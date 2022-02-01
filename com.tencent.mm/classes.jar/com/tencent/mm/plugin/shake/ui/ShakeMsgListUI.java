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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.shake.b.f;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.tools.l;

public class ShakeMsgListUI
  extends MMActivity
{
  private int from;
  private int limit;
  private int mType;
  private n.e nUI;
  private long nxr;
  private TextView pdI;
  private int wpA;
  private int wpz;
  private com.tencent.mm.plugin.shake.b.g yON;
  private d yOO;
  private ListView yOP;
  
  public ShakeMsgListUI()
  {
    AppMethodBeat.i(28429);
    this.yON = null;
    this.limit = 0;
    this.wpz = 0;
    this.wpA = 0;
    this.nUI = new n.e()
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
  
  private void dPw()
  {
    AppMethodBeat.i(28435);
    this.pdI.setText(2131763591);
    this.pdI.setVisibility(0);
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
        h.a(ShakeMsgListUI.this.getContext(), true, ShakeMsgListUI.this.getString(2131763590), "", ShakeMsgListUI.this.getString(2131762786), ShakeMsgListUI.this.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(28423);
            paramAnonymous2DialogInterface = ShakeMsgListUI.a(ShakeMsgListUI.this);
            paramAnonymous2DialogInterface.db.delete(paramAnonymous2DialogInterface.getTableName(), null, null);
            ShakeMsgListUI.b(ShakeMsgListUI.this).Zu();
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
    this.pdI = ((TextView)findViewById(2131299468));
    if (this.wpz == 0) {
      dPw();
    }
    this.yOP = ((ListView)findViewById(2131304697));
    Object localObject = getLayoutInflater().inflate(2131495281, null);
    ((View)localObject).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28425);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/shake/ui/ShakeMsgListUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ShakeMsgListUI.a(ShakeMsgListUI.this, ShakeMsgListUI.d(ShakeMsgListUI.this) + 8);
        ShakeMsgListUI.b(ShakeMsgListUI.this).Pr(ShakeMsgListUI.d(ShakeMsgListUI.this));
        if (ShakeMsgListUI.e(ShakeMsgListUI.this) <= ShakeMsgListUI.d(ShakeMsgListUI.this)) {
          ShakeMsgListUI.f(ShakeMsgListUI.this).removeFooterView(this.wpD);
        }
        a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeMsgListUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(28425);
      }
    });
    if ((this.wpz > 0) && (this.limit < this.wpz)) {
      this.yOP.addFooterView((View)localObject);
    }
    this.yOO = new d(this);
    this.yOO.yOK = this.limit;
    this.yOP.setAdapter(this.yOO);
    this.yOP.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(28426);
        b localb = new b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mr(paramAnonymousInt);
        localb.qY(paramAnonymousLong);
        a.b("com/tencent/mm/plugin/shake/ui/ShakeMsgListUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
        paramAnonymousAdapterView = (f)ShakeMsgListUI.b(ShakeMsgListUI.this).getItem(paramAnonymousInt);
        if (!bt.isNullOrNil(paramAnonymousAdapterView.field_tag))
        {
          com.tencent.mm.plugin.report.service.g.yhR.kvStat(11316, ShakeMsgListUI.g(ShakeMsgListUI.this) + "," + paramAnonymousAdapterView.field_tag);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("rawUrl", paramAnonymousAdapterView.field_tag);
          com.tencent.mm.bs.d.b(ShakeMsgListUI.this.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
        }
        a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeMsgListUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(28426);
      }
    });
    localObject = new l(this);
    this.yOP.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
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
        this.nUL.a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, ShakeMsgListUI.this.getContext(), ShakeMsgListUI.h(ShakeMsgListUI.this));
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
    this.yON = m.dOP();
    this.wpA = this.yON.bUJ();
    int i;
    if (this.wpA == 0)
    {
      i = 8;
      this.limit = i;
      this.wpz = this.yON.getCount();
      this.from = getIntent().getIntExtra("shake_msg_from", 1);
      if (this.from != 1) {
        break label191;
      }
      com.tencent.mm.plugin.report.service.g.yhR.f(11313, new Object[] { Integer.valueOf(this.wpA), e.dPO() });
    }
    for (;;)
    {
      paramBundle = this.yON;
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("status", Integer.valueOf(1));
      paramBundle.db.update(paramBundle.getTableName(), localContentValues, "status!=? ", new String[] { "1" });
      initView();
      AppMethodBeat.o(28430);
      return;
      i = this.wpA;
      break;
      label191:
      com.tencent.mm.plugin.report.service.g.yhR.f(11315, new Object[] { Integer.valueOf(this.wpA), e.dPO() });
    }
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(28434);
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    this.nxr = ((f)this.yOO.getItem(paramView.position)).field_svrid;
    paramContextMenu.add(paramView.position, 0, 0, 2131755707);
    AppMethodBeat.o(28434);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(28432);
    this.yOO.det();
    super.onDestroy();
    AppMethodBeat.o(28432);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(28431);
    super.onResume();
    if (this.wpz != this.yON.getCount())
    {
      this.wpz = this.yON.getCount();
      if (this.wpz == 0) {
        dPw();
      }
      this.yOO.Zu();
    }
    this.yOO.notifyDataSetChanged();
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