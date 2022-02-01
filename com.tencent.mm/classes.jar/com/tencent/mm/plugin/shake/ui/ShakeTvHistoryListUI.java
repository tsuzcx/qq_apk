package com.tencent.mm.plugin.shake.ui;

import android.app.Activity;
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
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.plugin.shake.d.a.c;
import com.tencent.mm.plugin.shake.d.a.k;
import com.tencent.mm.plugin.shake.d.a.n;
import com.tencent.mm.plugin.shake.d.a.o;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.l;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

public class ShakeTvHistoryListUI
  extends MMActivity
{
  private n.d mRw;
  private String username;
  private a wqt;
  private ListView wqu;
  
  public ShakeTvHistoryListUI()
  {
    AppMethodBeat.i(28572);
    this.mRw = new n.d()
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
        com.tencent.mm.plugin.report.service.h.vKh.f(12662, new Object[] { Integer.valueOf(1), bt.nullAsNil(ShakeTvHistoryListUI.d(ShakeTvHistoryListUI.this)) });
        paramAnonymousMenuItem = m.dpd();
        String str = ShakeTvHistoryListUI.d(ShakeTvHistoryListUI.this);
        if (bt.isNullOrNil(str))
        {
          paramAnonymousInt = -1;
          label93:
          if (paramAnonymousInt >= 0) {
            break label185;
          }
          ad.i("MicroMsg.ShakeTvHistoryListUI", "delete tv history fail, ret[%d]", new Object[] { Integer.valueOf(paramAnonymousInt) });
        }
        for (;;)
        {
          ShakeTvHistoryListUI.a(ShakeTvHistoryListUI.this).a(null, null);
          break;
          str = "username = '" + str + "'";
          paramAnonymousInt = paramAnonymousMenuItem.db.delete(paramAnonymousMenuItem.getTableName(), str, null);
          ad.d("MicroMsg.ShakeTvHistoryStorage", "delMsgByUserName = ".concat(String.valueOf(paramAnonymousInt)));
          break label93;
          label185:
          paramAnonymousMenuItem = new c(1, ShakeTvHistoryListUI.d(ShakeTvHistoryListUI.this));
          az.aeS().a(paramAnonymousMenuItem, 0);
        }
      }
    };
    AppMethodBeat.o(28572);
  }
  
  public int getLayoutId()
  {
    return 2131495423;
  }
  
  public void initView()
  {
    AppMethodBeat.i(28575);
    setMMTitle(2131763635);
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
    addTextOptionMenu(0, getString(2131755694), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(28563);
        com.tencent.mm.ui.base.h.a(ShakeTvHistoryListUI.this.getContext(), true, ShakeTvHistoryListUI.this.getString(2131763634), "", ShakeTvHistoryListUI.this.getString(2131762786), ShakeTvHistoryListUI.this.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(28562);
            paramAnonymous2DialogInterface = com.tencent.mm.plugin.report.service.h.vKh;
            Object localObject2 = m.dpd();
            Object localObject1 = new ArrayList();
            localObject2 = ((o)localObject2).dpG();
            if (localObject2 != null)
            {
              while (((Cursor)localObject2).moveToNext())
              {
                n localn = new n();
                localn.convertFrom((Cursor)localObject2);
                ((List)localObject1).add(localn);
              }
              ((Cursor)localObject2).close();
            }
            localObject2 = new StringBuilder();
            localObject1 = ((List)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              ((StringBuilder)localObject2).append(((n)((Iterator)localObject1).next()).field_username);
              ((StringBuilder)localObject2).append("|");
            }
            paramAnonymous2DialogInterface.f(12662, new Object[] { Integer.valueOf(2), ((StringBuilder)localObject2).toString() });
            m.dpd().db.delete("shaketvhistory", null, null);
            paramAnonymous2DialogInterface = new c(2, null);
            az.aeS().a(paramAnonymous2DialogInterface, 0);
            ShakeTvHistoryListUI.a(ShakeTvHistoryListUI.this).Wd();
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
    this.wqu = ((ListView)findViewById(2131304733));
    this.wqt = new a(this);
    this.wqu.setAdapter(this.wqt);
    this.wqu.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(28564);
        paramAnonymousAdapterView = (n)ShakeTvHistoryListUI.a(ShakeTvHistoryListUI.this).getItem(paramAnonymousInt);
        paramAnonymousView = ShakeTvHistoryListUI.this.getContext();
        if (paramAnonymousAdapterView != null)
        {
          if ((bt.isNullOrNil(paramAnonymousAdapterView.field_username)) && (bt.isNullOrNil(paramAnonymousAdapterView.field_deeplink)))
          {
            com.tencent.mm.plugin.report.service.h.vKh.f(12108, new Object[] { bt.nullAsNil(paramAnonymousAdapterView.field_username), Integer.valueOf(2), Integer.valueOf(0) });
            AppMethodBeat.o(28564);
            return;
          }
          k.a(paramAnonymousAdapterView.field_username, paramAnonymousAdapterView.field_deeplink, 2, paramAnonymousView);
          ad.i("Micromsg.ShakeTVLogic", "doShakeTvHistoryItemClick start do nth");
        }
        AppMethodBeat.o(28564);
      }
    });
    final l locall = new l(this);
    this.wqu.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
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
    this.username = ((n)this.wqt.getItem(paramView.position)).field_username;
    paramContextMenu.add(paramView.position, 0, 0, 2131755707);
    AppMethodBeat.o(28576);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(28574);
    this.wqt.cHX();
    super.onDestroy();
    AppMethodBeat.o(28574);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends com.tencent.mm.ui.q<n>
  {
    private LayoutInflater mInflater;
    
    public a(Context paramContext)
    {
      super(new n());
      AppMethodBeat.i(28567);
      this.mInflater = LayoutInflater.from(paramContext);
      AppMethodBeat.o(28567);
    }
    
    public final void Wd()
    {
      AppMethodBeat.i(28569);
      setCursor(m.dpd().dpG());
      super.notifyDataSetChanged();
      AppMethodBeat.o(28569);
    }
    
    public final void We()
    {
      AppMethodBeat.i(28570);
      Wd();
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
        paramViewGroup = this.mInflater.inflate(2131495422, paramViewGroup, false);
        localObject1 = new a();
        ((a)localObject1).wqx = ((MMImageView)paramViewGroup.findViewById(2131304730));
        ((a)localObject1).kEu = ((TextView)paramViewGroup.findViewById(2131304732));
        ((a)localObject1).sYS = ((TextView)paramViewGroup.findViewById(2131304731));
        paramViewGroup.setTag(localObject1);
        localObject2 = (n)getItem(paramInt);
        e.a(((a)localObject1).wqx, ((n)localObject2).field_iconurl, 0, true);
        ((a)localObject1).kEu.setText(((n)localObject2).field_title);
        localObject1 = ((a)localObject1).sYS;
        paramView = ShakeTvHistoryListUI.this.getContext();
        l1 = ((n)localObject2).field_createtime * 1000L;
        localObject2 = new GregorianCalendar();
        if (l1 >= 3600000L) {
          break label193;
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
        label193:
        localObject2 = new GregorianCalendar(((GregorianCalendar)localObject2).get(1), ((GregorianCalendar)localObject2).get(2), ((GregorianCalendar)localObject2).get(5));
        long l2 = l1 - ((GregorianCalendar)localObject2).getTimeInMillis();
        if ((l2 > 0L) && (l2 <= 86400000L))
        {
          paramView = com.tencent.mm.pluginsdk.g.h.formatTime(paramView.getString(2131759529), l1 / 1000L);
        }
        else
        {
          l2 = l1 - ((GregorianCalendar)localObject2).getTimeInMillis() + 86400000L;
          if ((l2 > 0L) && (l2 <= 86400000L)) {
            paramView = paramView.getString(2131759551);
          } else {
            paramView = com.tencent.mm.pluginsdk.g.h.formatTime(paramView.getString(2131759517), l1 / 1000L);
          }
        }
      }
    }
    
    final class a
    {
      TextView kEu;
      TextView sYS;
      MMImageView wqx;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeTvHistoryListUI
 * JD-Core Version:    0.7.0.1
 */