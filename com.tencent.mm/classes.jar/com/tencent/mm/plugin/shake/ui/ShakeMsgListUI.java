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
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.shake.b.f;
import com.tencent.mm.plugin.shake.b.g;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.tools.l;

public class ShakeMsgListUI
  extends MMActivity
{
  private int AAs;
  private int AAt;
  private g DjP;
  private d DjQ;
  private ListView DjR;
  private int from;
  private int limit;
  private int mType;
  private long oNJ;
  private o.g plk;
  private TextView qzz;
  
  public ShakeMsgListUI()
  {
    AppMethodBeat.i(28429);
    this.DjP = null;
    this.limit = 0;
    this.AAs = 0;
    this.AAt = 0;
    this.plk = new o.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(28428);
        paramAnonymousMenuItem = ShakeMsgListUI.a(ShakeMsgListUI.this);
        long l = ShakeMsgListUI.i(ShakeMsgListUI.this);
        String str = "svrid = '" + String.valueOf(l) + "'";
        Log.i("MicroMsg.ShakeMessageStorage", "delBySvrId = ".concat(String.valueOf(paramAnonymousMenuItem.db.delete(paramAnonymousMenuItem.getTableName(), str, null))));
        ShakeMsgListUI.b(ShakeMsgListUI.this).onNotifyChange(null, null);
        AppMethodBeat.o(28428);
      }
    };
    AppMethodBeat.o(28429);
  }
  
  private void eUU()
  {
    AppMethodBeat.i(28435);
    this.qzz.setText(2131765779);
    this.qzz.setVisibility(0);
    enableOptionMenu(false);
    AppMethodBeat.o(28435);
  }
  
  public int getLayoutId()
  {
    return 2131496286;
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
    addTextOptionMenu(0, getString(2131755764), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(28424);
        com.tencent.mm.ui.base.h.a(ShakeMsgListUI.this.getContext(), true, ShakeMsgListUI.this.getString(2131765778), "", ShakeMsgListUI.this.getString(2131764873), ShakeMsgListUI.this.getString(2131755761), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(28423);
            paramAnonymous2DialogInterface = ShakeMsgListUI.a(ShakeMsgListUI.this);
            paramAnonymous2DialogInterface.db.delete(paramAnonymous2DialogInterface.getTableName(), null, null);
            ShakeMsgListUI.b(ShakeMsgListUI.this).anp();
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
    this.qzz = ((TextView)findViewById(2131300096));
    if (this.AAs == 0) {
      eUU();
    }
    this.DjR = ((ListView)findViewById(2131307754));
    Object localObject = getLayoutInflater().inflate(2131496131, null);
    ((View)localObject).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28425);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/shake/ui/ShakeMsgListUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        ShakeMsgListUI.a(ShakeMsgListUI.this, ShakeMsgListUI.d(ShakeMsgListUI.this) + 8);
        ShakeMsgListUI.b(ShakeMsgListUI.this).XB(ShakeMsgListUI.d(ShakeMsgListUI.this));
        if (ShakeMsgListUI.e(ShakeMsgListUI.this) <= ShakeMsgListUI.d(ShakeMsgListUI.this)) {
          ShakeMsgListUI.f(ShakeMsgListUI.this).removeFooterView(this.AAw);
        }
        a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeMsgListUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(28425);
      }
    });
    if ((this.AAs > 0) && (this.limit < this.AAs)) {
      this.DjR.addFooterView((View)localObject);
    }
    this.DjQ = new d(this);
    this.DjQ.DjM = this.limit;
    this.DjR.setAdapter(this.DjQ);
    this.DjR.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(28426);
        b localb = new b();
        localb.bm(paramAnonymousAdapterView);
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.zo(paramAnonymousLong);
        a.b("com/tencent/mm/plugin/shake/ui/ShakeMsgListUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
        paramAnonymousAdapterView = (f)ShakeMsgListUI.b(ShakeMsgListUI.this).getItem(paramAnonymousInt);
        if (!Util.isNullOrNil(paramAnonymousAdapterView.field_tag))
        {
          com.tencent.mm.plugin.report.service.h.CyF.kvStat(11316, ShakeMsgListUI.g(ShakeMsgListUI.this) + "," + paramAnonymousAdapterView.field_tag);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("rawUrl", paramAnonymousAdapterView.field_tag);
          c.b(ShakeMsgListUI.this.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
        }
        a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeMsgListUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(28426);
      }
    });
    localObject = new l(this);
    this.DjR.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(28427);
        if (paramAnonymousInt < ShakeMsgListUI.f(ShakeMsgListUI.this).getHeaderViewsCount())
        {
          Log.w("MicroMsg.ShakeMsgListUI", "on header view long click, ignore");
          AppMethodBeat.o(28427);
          return true;
        }
        this.pln.a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, ShakeMsgListUI.this.getContext(), ShakeMsgListUI.h(ShakeMsgListUI.this));
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
    this.DjP = m.eUn();
    this.AAt = this.DjP.ctM();
    int i;
    if (this.AAt == 0)
    {
      i = 8;
      this.limit = i;
      this.AAs = this.DjP.getCount();
      this.from = getIntent().getIntExtra("shake_msg_from", 1);
      if (this.from != 1) {
        break label191;
      }
      com.tencent.mm.plugin.report.service.h.CyF.a(11313, new Object[] { Integer.valueOf(this.AAt), e.eVk() });
    }
    for (;;)
    {
      paramBundle = this.DjP;
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("status", Integer.valueOf(1));
      paramBundle.db.update(paramBundle.getTableName(), localContentValues, "status!=? ", new String[] { "1" });
      initView();
      AppMethodBeat.o(28430);
      return;
      i = this.AAt;
      break;
      label191:
      com.tencent.mm.plugin.report.service.h.CyF.a(11315, new Object[] { Integer.valueOf(this.AAt), e.eVk() });
    }
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(28434);
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    this.oNJ = ((f)this.DjQ.getItem(paramView.position)).field_svrid;
    paramContextMenu.add(paramView.position, 0, 0, 2131755778);
    AppMethodBeat.o(28434);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(28432);
    this.DjQ.ebf();
    super.onDestroy();
    AppMethodBeat.o(28432);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(28431);
    super.onResume();
    if (this.AAs != this.DjP.getCount())
    {
      this.AAs = this.DjP.getCount();
      if (this.AAs == 0) {
        eUU();
      }
      this.DjQ.anp();
    }
    this.DjQ.notifyDataSetChanged();
    AppMethodBeat.o(28431);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeMsgListUI
 * JD-Core Version:    0.7.0.1
 */