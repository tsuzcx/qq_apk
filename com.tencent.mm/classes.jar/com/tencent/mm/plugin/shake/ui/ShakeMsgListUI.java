package com.tencent.mm.plugin.shake.ui;

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
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.mmdata.rpt.mz;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.model.f;
import com.tencent.mm.plugin.shake.model.g;
import com.tencent.mm.plugin.shake.model.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.tools.l;

public class ShakeMsgListUI
  extends MMActivity
{
  private int Mpv;
  private int Mpw;
  private g PCo;
  private d PCp;
  private ListView PCq;
  private int from;
  private int limit;
  private int mType;
  private long vaU;
  private u.i vzr;
  private TextView xbR;
  
  public ShakeMsgListUI()
  {
    AppMethodBeat.i(28429);
    this.PCo = null;
    this.limit = 0;
    this.Mpv = 0;
    this.Mpw = 0;
    this.vzr = new u.i()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(28428);
        paramAnonymousMenuItem = ShakeMsgListUI.a(ShakeMsgListUI.this);
        long l = ShakeMsgListUI.j(ShakeMsgListUI.this);
        String str = "svrid = '" + String.valueOf(l) + "'";
        Log.i("MicroMsg.ShakeMessageStorage", "delBySvrId = ".concat(String.valueOf(paramAnonymousMenuItem.db.delete(paramAnonymousMenuItem.getTableName(), str, null))));
        ShakeMsgListUI.b(ShakeMsgListUI.this).onNotifyChange(null, null);
        AppMethodBeat.o(28428);
      }
    };
    AppMethodBeat.o(28429);
  }
  
  private void gXK()
  {
    AppMethodBeat.i(28435);
    this.xbR.setText(R.l.gVE);
    this.xbR.setVisibility(0);
    enableOptionMenu(false);
    AppMethodBeat.o(28435);
  }
  
  public int getLayoutId()
  {
    return R.i.goe;
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
    addTextOptionMenu(0, getString(R.l.app_clear), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(28424);
        k.a(ShakeMsgListUI.this.getContext(), true, ShakeMsgListUI.this.getString(R.l.gVD), "", ShakeMsgListUI.this.getString(R.l.say_hi_clean_all_btn), ShakeMsgListUI.this.getString(R.l.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(28423);
            paramAnonymous2DialogInterface = ShakeMsgListUI.a(ShakeMsgListUI.this);
            paramAnonymous2DialogInterface.db.delete(paramAnonymous2DialogInterface.getTableName(), null, null);
            ShakeMsgListUI.b(ShakeMsgListUI.this).aNy();
            ShakeMsgListUI.c(ShakeMsgListUI.this);
            paramAnonymous2DialogInterface = new mz();
            com.tencent.mm.plugin.shake.a locala = com.tencent.mm.plugin.shake.a.PyM;
            com.tencent.mm.plugin.shake.a.a(202, paramAnonymous2DialogInterface);
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
    this.xbR = ((TextView)findViewById(R.h.empty_msg_tip_tv));
    if (this.Mpv == 0) {
      gXK();
    }
    this.PCq = ((ListView)findViewById(R.h.fWt));
    Object localObject = getLayoutInflater().inflate(R.i.say_hi_list_footer, null);
    ((View)localObject).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28425);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/shake/ui/ShakeMsgListUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        ShakeMsgListUI.d(ShakeMsgListUI.this);
        ShakeMsgListUI.b(ShakeMsgListUI.this).ajh(ShakeMsgListUI.e(ShakeMsgListUI.this));
        if (ShakeMsgListUI.f(ShakeMsgListUI.this) <= ShakeMsgListUI.e(ShakeMsgListUI.this)) {
          ShakeMsgListUI.g(ShakeMsgListUI.this).removeFooterView(this.Mpz);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeMsgListUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(28425);
      }
    });
    if ((this.Mpv > 0) && (this.limit < this.Mpv)) {
      this.PCq.addFooterView((View)localObject);
    }
    this.PCp = new d(this);
    this.PCp.PCl = this.limit;
    this.PCq.setAdapter(this.PCp);
    this.PCq.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(28426);
        b localb = new b();
        localb.cH(paramAnonymousAdapterView);
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.hB(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/shake/ui/ShakeMsgListUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
        paramAnonymousAdapterView = (f)ShakeMsgListUI.b(ShakeMsgListUI.this).getItem(paramAnonymousInt);
        if (!Util.isNullOrNil(paramAnonymousAdapterView.field_tag))
        {
          h.OAn.kvStat(11316, ShakeMsgListUI.h(ShakeMsgListUI.this) + "," + paramAnonymousAdapterView.field_tag);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("rawUrl", paramAnonymousAdapterView.field_tag);
          c.b(ShakeMsgListUI.this.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
          paramAnonymousAdapterView = new mz();
          paramAnonymousView = com.tencent.mm.plugin.shake.a.PyM;
          com.tencent.mm.plugin.shake.a.a(201, paramAnonymousAdapterView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeMsgListUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(28426);
      }
    });
    localObject = new l(this);
    this.PCq.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(28427);
        if (paramAnonymousInt < ShakeMsgListUI.g(ShakeMsgListUI.this).getHeaderViewsCount())
        {
          Log.w("MicroMsg.ShakeMsgListUI", "on header view long click, ignore");
          AppMethodBeat.o(28427);
          return true;
        }
        this.vzu.a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, ShakeMsgListUI.this.getContext(), ShakeMsgListUI.i(ShakeMsgListUI.this));
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
    this.PCo = m.gXe();
    this.Mpw = this.PCo.dkF();
    int i;
    if (this.Mpw == 0)
    {
      i = 8;
      this.limit = i;
      this.Mpv = this.PCo.getCount();
      this.from = getIntent().getIntExtra("shake_msg_from", 1);
      if (this.from != 1) {
        break label191;
      }
      h.OAn.b(11313, new Object[] { Integer.valueOf(this.Mpw), e.gYf() });
    }
    for (;;)
    {
      paramBundle = this.PCo;
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("status", Integer.valueOf(1));
      paramBundle.db.update(paramBundle.getTableName(), localContentValues, "status!=? ", new String[] { "1" });
      initView();
      AppMethodBeat.o(28430);
      return;
      i = this.Mpw;
      break;
      label191:
      h.OAn.b(11315, new Object[] { Integer.valueOf(this.Mpw), e.gYf() });
    }
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(28434);
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    this.vaU = ((f)this.PCp.getItem(paramView.position)).field_svrid;
    paramContextMenu.add(paramView.position, 0, 0, R.l.app_delete);
    AppMethodBeat.o(28434);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(28432);
    this.PCp.fSd();
    super.onDestroy();
    AppMethodBeat.o(28432);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(28431);
    super.onResume();
    if (this.Mpv != this.PCo.getCount())
    {
      this.Mpv = this.PCo.getCount();
      if (this.Mpv == 0) {
        gXK();
      }
      this.PCp.aNy();
    }
    this.PCp.notifyDataSetChanged();
    AppMethodBeat.o(28431);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeMsgListUI
 * JD-Core Version:    0.7.0.1
 */