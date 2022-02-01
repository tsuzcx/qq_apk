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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
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
  private long nCM;
  private n.e oao;
  private TextView pko;
  private int wFi;
  private int wFj;
  private com.tencent.mm.plugin.shake.b.g zeX;
  private d zeY;
  private ListView zeZ;
  
  public ShakeMsgListUI()
  {
    AppMethodBeat.i(28429);
    this.zeX = null;
    this.limit = 0;
    this.wFi = 0;
    this.wFj = 0;
    this.oao = new n.e()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(28428);
        paramAnonymousMenuItem = ShakeMsgListUI.a(ShakeMsgListUI.this);
        long l = ShakeMsgListUI.i(ShakeMsgListUI.this);
        String str = "svrid = '" + String.valueOf(l) + "'";
        ae.i("MicroMsg.ShakeMessageStorage", "delBySvrId = ".concat(String.valueOf(paramAnonymousMenuItem.db.delete(paramAnonymousMenuItem.getTableName(), str, null))));
        ShakeMsgListUI.b(ShakeMsgListUI.this).a(null, null);
        AppMethodBeat.o(28428);
      }
    };
    AppMethodBeat.o(28429);
  }
  
  private void dST()
  {
    AppMethodBeat.i(28435);
    this.pko.setText(2131763591);
    this.pko.setVisibility(0);
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
            ShakeMsgListUI.b(ShakeMsgListUI.this).ZD();
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
    this.pko = ((TextView)findViewById(2131299468));
    if (this.wFi == 0) {
      dST();
    }
    this.zeZ = ((ListView)findViewById(2131304697));
    Object localObject = getLayoutInflater().inflate(2131495281, null);
    ((View)localObject).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28425);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/shake/ui/ShakeMsgListUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ShakeMsgListUI.a(ShakeMsgListUI.this, ShakeMsgListUI.d(ShakeMsgListUI.this) + 8);
        ShakeMsgListUI.b(ShakeMsgListUI.this).PY(ShakeMsgListUI.d(ShakeMsgListUI.this));
        if (ShakeMsgListUI.e(ShakeMsgListUI.this) <= ShakeMsgListUI.d(ShakeMsgListUI.this)) {
          ShakeMsgListUI.f(ShakeMsgListUI.this).removeFooterView(this.wFm);
        }
        a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeMsgListUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(28425);
      }
    });
    if ((this.wFi > 0) && (this.limit < this.wFi)) {
      this.zeZ.addFooterView((View)localObject);
    }
    this.zeY = new d(this);
    this.zeY.zeU = this.limit;
    this.zeZ.setAdapter(this.zeY);
    this.zeZ.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(28426);
        b localb = new b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mu(paramAnonymousInt);
        localb.rl(paramAnonymousLong);
        a.b("com/tencent/mm/plugin/shake/ui/ShakeMsgListUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
        paramAnonymousAdapterView = (f)ShakeMsgListUI.b(ShakeMsgListUI.this).getItem(paramAnonymousInt);
        if (!bu.isNullOrNil(paramAnonymousAdapterView.field_tag))
        {
          com.tencent.mm.plugin.report.service.g.yxI.kvStat(11316, ShakeMsgListUI.g(ShakeMsgListUI.this) + "," + paramAnonymousAdapterView.field_tag);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("rawUrl", paramAnonymousAdapterView.field_tag);
          com.tencent.mm.br.d.b(ShakeMsgListUI.this.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
        }
        a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeMsgListUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(28426);
      }
    });
    localObject = new l(this);
    this.zeZ.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(28427);
        if (paramAnonymousInt < ShakeMsgListUI.f(ShakeMsgListUI.this).getHeaderViewsCount())
        {
          ae.w("MicroMsg.ShakeMsgListUI", "on header view long click, ignore");
          AppMethodBeat.o(28427);
          return true;
        }
        this.oar.a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, ShakeMsgListUI.this.getContext(), ShakeMsgListUI.h(ShakeMsgListUI.this));
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
    this.zeX = m.dSm();
    this.wFj = this.zeX.bVY();
    int i;
    if (this.wFj == 0)
    {
      i = 8;
      this.limit = i;
      this.wFi = this.zeX.getCount();
      this.from = getIntent().getIntExtra("shake_msg_from", 1);
      if (this.from != 1) {
        break label191;
      }
      com.tencent.mm.plugin.report.service.g.yxI.f(11313, new Object[] { Integer.valueOf(this.wFj), e.dTl() });
    }
    for (;;)
    {
      paramBundle = this.zeX;
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("status", Integer.valueOf(1));
      paramBundle.db.update(paramBundle.getTableName(), localContentValues, "status!=? ", new String[] { "1" });
      initView();
      AppMethodBeat.o(28430);
      return;
      i = this.wFj;
      break;
      label191:
      com.tencent.mm.plugin.report.service.g.yxI.f(11315, new Object[] { Integer.valueOf(this.wFj), e.dTl() });
    }
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(28434);
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    this.nCM = ((f)this.zeY.getItem(paramView.position)).field_svrid;
    paramContextMenu.add(paramView.position, 0, 0, 2131755707);
    AppMethodBeat.o(28434);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(28432);
    this.zeY.dhl();
    super.onDestroy();
    AppMethodBeat.o(28432);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(28431);
    super.onResume();
    if (this.wFi != this.zeX.getCount())
    {
      this.wFi = this.zeX.getCount();
      if (this.wFi == 0) {
        dST();
      }
      this.zeY.ZD();
    }
    this.zeY.notifyDataSetChanged();
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