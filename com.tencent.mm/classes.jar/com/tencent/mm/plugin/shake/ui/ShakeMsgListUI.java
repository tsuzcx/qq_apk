package com.tencent.mm.plugin.shake.ui;

import android.app.Activity;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.shake.b.f;
import com.tencent.mm.plugin.shake.b.g;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.l;

public class ShakeMsgListUI
  extends MMActivity
{
  private int from;
  private int limit;
  private int mType;
  private long mWU;
  private n.d ntM;
  private TextView oAn;
  private int vkh;
  private int vki;
  private g xAd;
  private d xAe;
  private ListView xAf;
  
  public ShakeMsgListUI()
  {
    AppMethodBeat.i(28429);
    this.xAd = null;
    this.limit = 0;
    this.vkh = 0;
    this.vki = 0;
    this.ntM = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(28428);
        paramAnonymousMenuItem = ShakeMsgListUI.a(ShakeMsgListUI.this);
        long l = ShakeMsgListUI.i(ShakeMsgListUI.this);
        String str = "svrid = '" + String.valueOf(l) + "'";
        ac.i("MicroMsg.ShakeMessageStorage", "delBySvrId = ".concat(String.valueOf(paramAnonymousMenuItem.db.delete(paramAnonymousMenuItem.getTableName(), str, null))));
        ShakeMsgListUI.b(ShakeMsgListUI.this).a(null, null);
        AppMethodBeat.o(28428);
      }
    };
    AppMethodBeat.o(28429);
  }
  
  private void dDT()
  {
    AppMethodBeat.i(28435);
    this.oAn.setText(2131763591);
    this.oAn.setVisibility(0);
    enableOptionMenu(false);
    AppMethodBeat.o(28435);
  }
  
  public int getLayoutId()
  {
    return 2131495418;
  }
  
  public void initView()
  {
    AppMethodBeat.i(28433);
    setMMTitle(getIntent().getStringExtra("shake_msg_list_title"));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(28422);
        ShakeMsgListUI.this.hideVKB();
        ShakeMsgListUI.this.finish();
        AppMethodBeat.o(28422);
        return true;
      }
    });
    addTextOptionMenu(0, getString(2131755694), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(28424);
        com.tencent.mm.ui.base.h.a(ShakeMsgListUI.this.getContext(), true, ShakeMsgListUI.this.getString(2131763590), "", ShakeMsgListUI.this.getString(2131762786), ShakeMsgListUI.this.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(28423);
            paramAnonymous2DialogInterface = ShakeMsgListUI.a(ShakeMsgListUI.this);
            paramAnonymous2DialogInterface.db.delete(paramAnonymous2DialogInterface.getTableName(), null, null);
            ShakeMsgListUI.b(ShakeMsgListUI.this).Xb();
            ShakeMsgListUI.c(ShakeMsgListUI.this);
            AppMethodBeat.o(28423);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
        });
        AppMethodBeat.o(28424);
        return true;
      }
    });
    this.oAn = ((TextView)findViewById(2131299468));
    if (this.vkh == 0) {
      dDT();
    }
    this.xAf = ((ListView)findViewById(2131304697));
    Object localObject = getLayoutInflater().inflate(2131495281, null);
    ((View)localObject).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28425);
        ShakeMsgListUI.a(ShakeMsgListUI.this, ShakeMsgListUI.d(ShakeMsgListUI.this) + 8);
        ShakeMsgListUI.b(ShakeMsgListUI.this).NO(ShakeMsgListUI.d(ShakeMsgListUI.this));
        if (ShakeMsgListUI.e(ShakeMsgListUI.this) <= ShakeMsgListUI.d(ShakeMsgListUI.this)) {
          ShakeMsgListUI.f(ShakeMsgListUI.this).removeFooterView(this.vkl);
        }
        AppMethodBeat.o(28425);
      }
    });
    if ((this.vkh > 0) && (this.limit < this.vkh)) {
      this.xAf.addFooterView((View)localObject);
    }
    this.xAe = new d(this);
    this.xAe.xAa = this.limit;
    this.xAf.setAdapter(this.xAe);
    this.xAf.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(28426);
        paramAnonymousAdapterView = (f)ShakeMsgListUI.b(ShakeMsgListUI.this).getItem(paramAnonymousInt);
        if (!bs.isNullOrNil(paramAnonymousAdapterView.field_tag))
        {
          com.tencent.mm.plugin.report.service.h.wUl.kvStat(11316, ShakeMsgListUI.g(ShakeMsgListUI.this) + "," + paramAnonymousAdapterView.field_tag);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("rawUrl", paramAnonymousAdapterView.field_tag);
          com.tencent.mm.br.d.b(ShakeMsgListUI.this.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
        }
        AppMethodBeat.o(28426);
      }
    });
    localObject = new l(this);
    this.xAf.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(28427);
        if (paramAnonymousInt < ShakeMsgListUI.f(ShakeMsgListUI.this).getHeaderViewsCount())
        {
          ac.w("MicroMsg.ShakeMsgListUI", "on header view long click, ignore");
          AppMethodBeat.o(28427);
          return true;
        }
        this.ntP.a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, ShakeMsgListUI.this.getContext(), ShakeMsgListUI.h(ShakeMsgListUI.this));
        AppMethodBeat.o(28427);
        return true;
      }
    });
    AppMethodBeat.o(28433);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(28430);
    super.onCreate(paramBundle);
    this.mType = getIntent().getIntExtra("shake_msg_type", 0);
    this.xAd = m.dDm();
    this.vki = this.xAd.bQe();
    int i;
    if (this.vki == 0)
    {
      i = 8;
      this.limit = i;
      this.vkh = this.xAd.getCount();
      this.from = getIntent().getIntExtra("shake_msg_from", 1);
      if (this.from != 1) {
        break label191;
      }
      com.tencent.mm.plugin.report.service.h.wUl.f(11313, new Object[] { Integer.valueOf(this.vki), e.dEl() });
    }
    for (;;)
    {
      paramBundle = this.xAd;
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("status", Integer.valueOf(1));
      paramBundle.db.update(paramBundle.getTableName(), localContentValues, "status!=? ", new String[] { "1" });
      initView();
      AppMethodBeat.o(28430);
      return;
      i = this.vki;
      break;
      label191:
      com.tencent.mm.plugin.report.service.h.wUl.f(11315, new Object[] { Integer.valueOf(this.vki), e.dEl() });
    }
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(28434);
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    this.mWU = ((f)this.xAe.getItem(paramView.position)).field_svrid;
    paramContextMenu.add(paramView.position, 0, 0, 2131755707);
    AppMethodBeat.o(28434);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(28432);
    this.xAe.cVi();
    super.onDestroy();
    AppMethodBeat.o(28432);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(28431);
    super.onResume();
    if (this.vkh != this.xAd.getCount())
    {
      this.vkh = this.xAd.getCount();
      if (this.vkh == 0) {
        dDT();
      }
      this.xAe.Xb();
    }
    this.xAe.notifyDataSetChanged();
    AppMethodBeat.o(28431);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeMsgListUI
 * JD-Core Version:    0.7.0.1
 */