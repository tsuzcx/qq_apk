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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.l;

public class ShakeMsgListUI
  extends MMActivity
{
  private int from;
  private int limit;
  private n.d mRw;
  private int mType;
  private long muT;
  private TextView nWS;
  private int ubj;
  private int ubk;
  private g woM;
  private d woN;
  private ListView woO;
  
  public ShakeMsgListUI()
  {
    AppMethodBeat.i(28429);
    this.woM = null;
    this.limit = 0;
    this.ubj = 0;
    this.ubk = 0;
    this.mRw = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(28428);
        paramAnonymousMenuItem = ShakeMsgListUI.a(ShakeMsgListUI.this);
        long l = ShakeMsgListUI.i(ShakeMsgListUI.this);
        String str = "svrid = '" + String.valueOf(l) + "'";
        ad.i("MicroMsg.ShakeMessageStorage", "delBySvrId = ".concat(String.valueOf(paramAnonymousMenuItem.db.delete(paramAnonymousMenuItem.getTableName(), str, null))));
        ShakeMsgListUI.b(ShakeMsgListUI.this).a(null, null);
        AppMethodBeat.o(28428);
      }
    };
    AppMethodBeat.o(28429);
  }
  
  private void dpJ()
  {
    AppMethodBeat.i(28435);
    this.nWS.setText(2131763591);
    this.nWS.setVisibility(0);
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
            ShakeMsgListUI.b(ShakeMsgListUI.this).Wd();
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
    this.nWS = ((TextView)findViewById(2131299468));
    if (this.ubj == 0) {
      dpJ();
    }
    this.woO = ((ListView)findViewById(2131304697));
    Object localObject = getLayoutInflater().inflate(2131495281, null);
    ((View)localObject).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28425);
        ShakeMsgListUI.a(ShakeMsgListUI.this, ShakeMsgListUI.d(ShakeMsgListUI.this) + 8);
        ShakeMsgListUI.b(ShakeMsgListUI.this).LO(ShakeMsgListUI.d(ShakeMsgListUI.this));
        if (ShakeMsgListUI.e(ShakeMsgListUI.this) <= ShakeMsgListUI.d(ShakeMsgListUI.this)) {
          ShakeMsgListUI.f(ShakeMsgListUI.this).removeFooterView(this.ubn);
        }
        AppMethodBeat.o(28425);
      }
    });
    if ((this.ubj > 0) && (this.limit < this.ubj)) {
      this.woO.addFooterView((View)localObject);
    }
    this.woN = new d(this);
    this.woN.woJ = this.limit;
    this.woO.setAdapter(this.woN);
    this.woO.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(28426);
        paramAnonymousAdapterView = (f)ShakeMsgListUI.b(ShakeMsgListUI.this).getItem(paramAnonymousInt);
        if (!bt.isNullOrNil(paramAnonymousAdapterView.field_tag))
        {
          com.tencent.mm.plugin.report.service.h.vKh.kvStat(11316, ShakeMsgListUI.g(ShakeMsgListUI.this) + "," + paramAnonymousAdapterView.field_tag);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("rawUrl", paramAnonymousAdapterView.field_tag);
          com.tencent.mm.bs.d.b(ShakeMsgListUI.this.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
        }
        AppMethodBeat.o(28426);
      }
    });
    localObject = new l(this);
    this.woO.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(28427);
        if (paramAnonymousInt < ShakeMsgListUI.f(ShakeMsgListUI.this).getHeaderViewsCount())
        {
          ad.w("MicroMsg.ShakeMsgListUI", "on header view long click, ignore");
          AppMethodBeat.o(28427);
          return true;
        }
        this.mRz.a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, ShakeMsgListUI.this.getContext(), ShakeMsgListUI.h(ShakeMsgListUI.this));
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
    this.woM = m.dpc();
    this.ubk = this.woM.bIR();
    int i;
    if (this.ubk == 0)
    {
      i = 8;
      this.limit = i;
      this.ubj = this.woM.getCount();
      this.from = getIntent().getIntExtra("shake_msg_from", 1);
      if (this.from != 1) {
        break label191;
      }
      com.tencent.mm.plugin.report.service.h.vKh.f(11313, new Object[] { Integer.valueOf(this.ubk), e.dqb() });
    }
    for (;;)
    {
      paramBundle = this.woM;
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("status", Integer.valueOf(1));
      paramBundle.db.update(paramBundle.getTableName(), localContentValues, "status!=? ", new String[] { "1" });
      initView();
      AppMethodBeat.o(28430);
      return;
      i = this.ubk;
      break;
      label191:
      com.tencent.mm.plugin.report.service.h.vKh.f(11315, new Object[] { Integer.valueOf(this.ubk), e.dqb() });
    }
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(28434);
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    this.muT = ((f)this.woN.getItem(paramView.position)).field_svrid;
    paramContextMenu.add(paramView.position, 0, 0, 2131755707);
    AppMethodBeat.o(28434);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(28432);
    this.woN.cHX();
    super.onDestroy();
    AppMethodBeat.o(28432);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(28431);
    super.onResume();
    if (this.ubj != this.woM.getCount())
    {
      this.ubj = this.woM.getCount();
      if (this.ubj == 0) {
        dpJ();
      }
      this.woN.Wd();
    }
    this.woN.notifyDataSetChanged();
    AppMethodBeat.o(28431);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeMsgListUI
 * JD-Core Version:    0.7.0.1
 */