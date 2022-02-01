package com.tencent.mm.plugin.shake.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
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
import com.tencent.mm.am.s;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.c.a.d;
import com.tencent.mm.plugin.shake.c.a.n;
import com.tencent.mm.plugin.shake.c.a.q;
import com.tencent.mm.plugin.shake.c.a.r;
import com.tencent.mm.plugin.shake.model.m;
import com.tencent.mm.pluginsdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.x;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

public class ShakeTvHistoryListUI
  extends MMActivity
{
  private a PEw;
  private ListView PEx;
  private String username;
  private u.i vzr;
  
  public ShakeTvHistoryListUI()
  {
    AppMethodBeat.i(28572);
    this.vzr = new u.i()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(28566);
        switch (paramAnonymousMenuItem.getItemId())
        {
        default: 
          AppMethodBeat.o(28566);
          return;
        }
        h.OAn.b(12662, new Object[] { Integer.valueOf(1), Util.nullAsNil(ShakeTvHistoryListUI.d(ShakeTvHistoryListUI.this)) });
        paramAnonymousMenuItem = m.gXf();
        String str = ShakeTvHistoryListUI.d(ShakeTvHistoryListUI.this);
        if (Util.isNullOrNil(str))
        {
          paramAnonymousInt = -1;
          label93:
          if (paramAnonymousInt >= 0) {
            break label185;
          }
          Log.i("MicroMsg.ShakeTvHistoryListUI", "delete tv history fail, ret[%d]", new Object[] { Integer.valueOf(paramAnonymousInt) });
        }
        for (;;)
        {
          ShakeTvHistoryListUI.a(ShakeTvHistoryListUI.this).onNotifyChange(null, null);
          break;
          str = "username = '" + str + "'";
          paramAnonymousInt = paramAnonymousMenuItem.db.delete(paramAnonymousMenuItem.getTableName(), str, null);
          Log.d("MicroMsg.ShakeTvHistoryStorage", "delMsgByUserName = ".concat(String.valueOf(paramAnonymousInt)));
          break label93;
          label185:
          paramAnonymousMenuItem = new d(1, ShakeTvHistoryListUI.d(ShakeTvHistoryListUI.this));
          bh.aZW().a(paramAnonymousMenuItem, 0);
        }
      }
    };
    AppMethodBeat.o(28572);
  }
  
  public int getLayoutId()
  {
    return R.i.goh;
  }
  
  public void initView()
  {
    AppMethodBeat.i(28575);
    setMMTitle(R.l.gVS);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(28561);
        ShakeTvHistoryListUI.this.hideVKB();
        ShakeTvHistoryListUI.this.finish();
        AppMethodBeat.o(28561);
        return true;
      }
    });
    addTextOptionMenu(0, getString(R.l.app_clear), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(28563);
        k.a(ShakeTvHistoryListUI.this.getContext(), true, ShakeTvHistoryListUI.this.getString(R.l.gVR), "", ShakeTvHistoryListUI.this.getString(R.l.say_hi_clean_all_btn), ShakeTvHistoryListUI.this.getString(R.l.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(28562);
            paramAnonymous2DialogInterface = h.OAn;
            Object localObject2 = m.gXf();
            Object localObject1 = new ArrayList();
            localObject2 = ((r)localObject2).gXH();
            if (localObject2 != null)
            {
              while (((Cursor)localObject2).moveToNext())
              {
                q localq = new q();
                localq.convertFrom((Cursor)localObject2);
                ((List)localObject1).add(localq);
              }
              ((Cursor)localObject2).close();
            }
            localObject2 = new StringBuilder();
            localObject1 = ((List)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              ((StringBuilder)localObject2).append(((q)((Iterator)localObject1).next()).field_username);
              ((StringBuilder)localObject2).append("|");
            }
            paramAnonymous2DialogInterface.b(12662, new Object[] { Integer.valueOf(2), ((StringBuilder)localObject2).toString() });
            m.gXf().db.delete("shaketvhistory", null, null);
            paramAnonymous2DialogInterface = new d(2, null);
            bh.aZW().a(paramAnonymous2DialogInterface, 0);
            ShakeTvHistoryListUI.a(ShakeTvHistoryListUI.this).aNy();
            ShakeTvHistoryListUI.this.enableOptionMenu(false);
            AppMethodBeat.o(28562);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
        });
        AppMethodBeat.o(28563);
        return true;
      }
    });
    this.PEx = ((ListView)findViewById(R.h.fXr));
    this.PEw = new a(this);
    this.PEx.setAdapter(this.PEw);
    this.PEx.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(28564);
        b localb = new b();
        localb.cH(paramAnonymousAdapterView);
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.hB(paramAnonymousLong);
        a.c("com/tencent/mm/plugin/shake/ui/ShakeTvHistoryListUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
        paramAnonymousAdapterView = (q)ShakeTvHistoryListUI.a(ShakeTvHistoryListUI.this).getItem(paramAnonymousInt);
        paramAnonymousView = ShakeTvHistoryListUI.this.getContext();
        if (paramAnonymousAdapterView != null)
        {
          if ((!Util.isNullOrNil(paramAnonymousAdapterView.field_username)) || (!Util.isNullOrNil(paramAnonymousAdapterView.field_deeplink))) {
            break label160;
          }
          h.OAn.b(12108, new Object[] { Util.nullAsNil(paramAnonymousAdapterView.field_username), Integer.valueOf(2), Integer.valueOf(0) });
        }
        for (;;)
        {
          a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeTvHistoryListUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(28564);
          return;
          label160:
          n.a(paramAnonymousAdapterView.field_username, paramAnonymousAdapterView.field_deeplink, 2, paramAnonymousView);
          Log.i("Micromsg.ShakeTVLogic", "doShakeTvHistoryItemClick start do nth");
        }
      }
    });
    final l locall = new l(this);
    this.PEx.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(28565);
        if (paramAnonymousInt < ShakeTvHistoryListUI.b(ShakeTvHistoryListUI.this).getHeaderViewsCount())
        {
          AppMethodBeat.o(28565);
          return true;
        }
        locall.a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, ShakeTvHistoryListUI.this.getContext(), ShakeTvHistoryListUI.c(ShakeTvHistoryListUI.this));
        AppMethodBeat.o(28565);
        return true;
      }
    });
    AppMethodBeat.o(28575);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(28573);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(28573);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(28576);
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    this.username = ((q)this.PEw.getItem(paramView.position)).field_username;
    paramContextMenu.add(paramView.position, 0, 0, R.l.app_delete);
    AppMethodBeat.o(28576);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(28574);
    this.PEw.fSd();
    super.onDestroy();
    AppMethodBeat.o(28574);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends x<q>
  {
    private LayoutInflater mInflater;
    
    public a(Context paramContext)
    {
      super(new q());
      AppMethodBeat.i(28567);
      this.mInflater = LayoutInflater.from(paramContext);
      AppMethodBeat.o(28567);
    }
    
    public final void aNy()
    {
      AppMethodBeat.i(28569);
      w(m.gXf().gXH());
      super.notifyDataSetChanged();
      AppMethodBeat.o(28569);
    }
    
    public final void aNz()
    {
      AppMethodBeat.i(28570);
      aNy();
      AppMethodBeat.o(28570);
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(28568);
      Object localObject1;
      Object localObject2;
      long l1;
      if (paramView == null)
      {
        paramViewGroup = this.mInflater.inflate(R.i.gog, paramViewGroup, false);
        localObject1 = new a();
        ((a)localObject1).PEA = ((MMImageView)paramViewGroup.findViewById(R.h.fXo));
        ((a)localObject1).sUt = ((TextView)paramViewGroup.findViewById(R.h.fXq));
        ((a)localObject1).KmP = ((TextView)paramViewGroup.findViewById(R.h.fXp));
        paramViewGroup.setTag(localObject1);
        localObject2 = (q)getItem(paramInt);
        e.a(((a)localObject1).PEA, ((q)localObject2).field_iconurl, 0, true);
        ((a)localObject1).sUt.setText(((q)localObject2).field_title);
        localObject1 = ((a)localObject1).KmP;
        paramView = ShakeTvHistoryListUI.this.getContext();
        l1 = ((q)localObject2).field_createtime * 1000L;
        localObject2 = new GregorianCalendar();
        if (l1 >= 3600000L) {
          break label197;
        }
        paramView = "";
      }
      for (;;)
      {
        ((TextView)localObject1).setText(paramView);
        AppMethodBeat.o(28568);
        return paramViewGroup;
        localObject1 = (a)paramView.getTag();
        paramViewGroup = paramView;
        break;
        label197:
        localObject2 = new GregorianCalendar(((GregorianCalendar)localObject2).get(1), ((GregorianCalendar)localObject2).get(2), ((GregorianCalendar)localObject2).get(5));
        long l2 = l1 - ((GregorianCalendar)localObject2).getTimeInMillis();
        if ((l2 > 0L) && (l2 <= 86400000L))
        {
          paramView = f.formatTime(paramView.getString(R.l.fmt_normal_time_24), l1 / 1000L);
        }
        else
        {
          l2 = l1 - ((GregorianCalendar)localObject2).getTimeInMillis() + 86400000L;
          if ((l2 > 0L) && (l2 <= 86400000L)) {
            paramView = paramView.getString(R.l.fmt_pre_yesterday);
          } else {
            paramView = f.formatTime(paramView.getString(R.l.fmt_longdate), l1 / 1000L);
          }
        }
      }
    }
    
    final class a
    {
      TextView KmP;
      MMImageView PEA;
      TextView sUt;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeTvHistoryListUI
 * JD-Core Version:    0.7.0.1
 */