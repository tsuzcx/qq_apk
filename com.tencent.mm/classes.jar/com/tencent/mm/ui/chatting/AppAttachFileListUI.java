package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class AppAttachFileListUI
  extends MMActivity
  implements h.a
{
  private AdapterView.OnItemClickListener jUz;
  private int jih;
  private AbsListView.OnScrollListener kHL;
  private ArrayList<AppAttachFileListUI.c> zvP;
  private HashSet<Long> zvQ;
  private ListView zvR;
  private AppAttachFileListUI.b zvS;
  private boolean zvT;
  private boolean zvU;
  private View zvV;
  
  public AppAttachFileListUI()
  {
    AppMethodBeat.i(30338);
    this.zvT = true;
    this.zvU = false;
    this.jUz = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(30331);
        paramAnonymousAdapterView = new Intent();
        paramAnonymousAdapterView.setClassName(AppAttachFileListUI.this, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
        paramAnonymousAdapterView.putExtra("app_msg_id", ((AppAttachFileListUI.c)AppAttachFileListUI.a(AppAttachFileListUI.this).get(paramAnonymousInt)).cEE.field_msgId);
        paramAnonymousAdapterView.setFlags(67108864);
        AppAttachFileListUI.this.startActivity(paramAnonymousAdapterView);
        AppMethodBeat.o(30331);
      }
    };
    this.kHL = new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(30332);
        if ((paramAnonymousInt == 0) && (!AppAttachFileListUI.b(AppAttachFileListUI.this)) && (AppAttachFileListUI.c(AppAttachFileListUI.this)) && (paramAnonymousAbsListView.getLastVisiblePosition() == AppAttachFileListUI.d(AppAttachFileListUI.this).getCount()))
        {
          ab.d("MicroMsg.AppAttachFileListUI", "need to add item");
          paramAnonymousInt = AppAttachFileListUI.e(AppAttachFileListUI.this);
          new AppAttachFileListUI.a(AppAttachFileListUI.this, (byte)0).execute(new Integer[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(20) });
          AppAttachFileListUI.f(AppAttachFileListUI.this);
        }
        AppMethodBeat.o(30332);
      }
    };
    AppMethodBeat.o(30338);
  }
  
  private AppAttachFileListUI.c au(bi parambi)
  {
    AppMethodBeat.i(30343);
    j.b localb = j.b.mY(parambi.field_content);
    if (localb == null)
    {
      AppMethodBeat.o(30343);
      return null;
    }
    AppAttachFileListUI.c localc = new AppAttachFileListUI.c(this, (byte)0);
    localc.cEE = parambi;
    localc.zvX = localb;
    AppMethodBeat.o(30343);
    return localc;
  }
  
  private void eW(List<bi> paramList)
  {
    AppMethodBeat.i(30342);
    if (paramList.size() < 20)
    {
      this.zvT = false;
      this.zvR.removeFooterView(this.zvV);
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      bi localbi = (bi)localIterator.next();
      AppAttachFileListUI.c localc = au(localbi);
      if ((localc != null) && (localc.zvX.type == 6) && (this.zvQ.add(Long.valueOf(localbi.field_msgId)))) {
        this.zvP.add(localc);
      }
    }
    ab.d("MicroMsg.AppAttachFileListUI", "append file item list size %d, current total size is %d", new Object[] { Integer.valueOf(paramList.size()), Integer.valueOf(this.zvP.size()) });
    AppMethodBeat.o(30342);
  }
  
  public final void a(h paramh, h.c paramc)
  {
    AppMethodBeat.i(30344);
    if ("insert".equals(paramc.oDP))
    {
      ab.d("MicroMsg.AppAttachFileListUI", "reveive a msg");
      int i = paramc.oDQ.size() - 1;
      while (i >= 0)
      {
        paramh = (bi)paramc.oDQ.get(i);
        if (paramh.bCn())
        {
          paramh = au(paramh);
          if ((paramh != null) && (paramh.zvX.type == 6)) {
            this.zvP.add(0, paramh);
          }
        }
        i -= 1;
      }
      if (this.zvS != null) {
        this.zvS.notifyDataSetChanged();
      }
    }
    AppMethodBeat.o(30344);
  }
  
  public int getLayoutId()
  {
    return 2130968653;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(30339);
    super.onCreate(paramBundle);
    setMMTitle(2131299884);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(30330);
        AppAttachFileListUI.this.finish();
        AppMethodBeat.o(30330);
        return true;
      }
    });
    this.zvR = ((ListView)findViewById(2131821128));
    this.zvV = getLayoutInflater().inflate(2130968651, null);
    this.zvR.addFooterView(this.zvV);
    this.zvV.setVisibility(8);
    this.zvP = new ArrayList();
    this.zvQ = new HashSet();
    paramBundle = r.Zn();
    aw.aaz();
    paramBundle = c.YC().am(paramBundle, 0, 20);
    this.jih += 20;
    eW(paramBundle);
    this.zvS = new AppAttachFileListUI.b(this, (byte)0);
    this.zvR.setAdapter(this.zvS);
    this.zvR.setOnItemClickListener(this.jUz);
    this.zvR.setOnScrollListener(this.kHL);
    aw.aaz();
    c.YC().a(this, getMainLooper());
    AppMethodBeat.o(30339);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(30341);
    aw.aaz();
    c.YC().a(this);
    super.onDestroy();
    AppMethodBeat.o(30341);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(30340);
    super.onResume();
    AppMethodBeat.o(30340);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppAttachFileListUI
 * JD-Core Version:    0.7.0.1
 */