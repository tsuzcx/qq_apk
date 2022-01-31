package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.g.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class AppAttachFileListUI
  extends MMActivity
  implements com.tencent.mm.plugin.messenger.foundation.a.a.g.a
{
  private int hrK;
  private AbsListView.OnScrollListener iCE = new AbsListView.OnScrollListener()
  {
    public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    
    public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
    {
      if ((paramAnonymousInt == 0) && (!AppAttachFileListUI.b(AppAttachFileListUI.this)) && (AppAttachFileListUI.c(AppAttachFileListUI.this)) && (paramAnonymousAbsListView.getLastVisiblePosition() == AppAttachFileListUI.d(AppAttachFileListUI.this).getCount()))
      {
        y.d("MicroMsg.AppAttachFileListUI", "need to add item");
        paramAnonymousInt = AppAttachFileListUI.e(AppAttachFileListUI.this);
        new AppAttachFileListUI.a(AppAttachFileListUI.this, (byte)0).execute(new Integer[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(20) });
        AppAttachFileListUI.f(AppAttachFileListUI.this);
      }
    }
  };
  private AdapterView.OnItemClickListener idL = new AdapterView.OnItemClickListener()
  {
    public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
    {
      paramAnonymousAdapterView = new Intent();
      paramAnonymousAdapterView.setClassName(AppAttachFileListUI.this, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
      paramAnonymousAdapterView.putExtra("app_msg_id", ((AppAttachFileListUI.c)AppAttachFileListUI.a(AppAttachFileListUI.this).get(paramAnonymousInt)).bWO.field_msgId);
      paramAnonymousAdapterView.setFlags(67108864);
      AppAttachFileListUI.this.startActivity(paramAnonymousAdapterView);
    }
  };
  private ArrayList<AppAttachFileListUI.c> vgN;
  private HashSet<Long> vgO;
  private ListView vgP;
  private AppAttachFileListUI.b vgQ;
  private boolean vgR = true;
  private boolean vgS = false;
  private View vgT;
  
  private AppAttachFileListUI.c am(bi parambi)
  {
    com.tencent.mm.ae.g.a locala = com.tencent.mm.ae.g.a.gp(parambi.field_content);
    if (locala == null) {
      return null;
    }
    AppAttachFileListUI.c localc = new AppAttachFileListUI.c(this, (byte)0);
    localc.bWO = parambi;
    localc.vgV = locala;
    return localc;
  }
  
  private void dN(List<bi> paramList)
  {
    if (paramList.size() < 20)
    {
      this.vgR = false;
      this.vgP.removeFooterView(this.vgT);
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      bi localbi = (bi)localIterator.next();
      AppAttachFileListUI.c localc = am(localbi);
      if ((localc != null) && (localc.vgV.type == 6) && (this.vgO.add(Long.valueOf(localbi.field_msgId)))) {
        this.vgN.add(localc);
      }
    }
    y.d("MicroMsg.AppAttachFileListUI", "append file item list size %d, current total size is %d", new Object[] { Integer.valueOf(paramList.size()), Integer.valueOf(this.vgN.size()) });
  }
  
  public final void a(g paramg, g.c paramc)
  {
    if ("insert".equals(paramc.mdt))
    {
      y.d("MicroMsg.AppAttachFileListUI", "reveive a msg");
      int i = paramc.mdu.size() - 1;
      while (i >= 0)
      {
        paramg = (bi)paramc.mdu.get(i);
        if (paramg.aVK())
        {
          paramg = am(paramg);
          if ((paramg != null) && (paramg.vgV.type == 6)) {
            this.vgN.add(0, paramg);
          }
        }
        i -= 1;
      }
      if (this.vgQ != null) {
        this.vgQ.notifyDataSetChanged();
      }
    }
  }
  
  protected final int getLayoutId()
  {
    return R.i.app_attach_file_list_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(R.l.file_list_title);
    setBackBtn(new AppAttachFileListUI.1(this));
    this.vgP = ((ListView)findViewById(R.h.file_list_lv));
    this.vgT = getLayoutInflater().inflate(R.i.app_attach_file_list_footer, null);
    this.vgP.addFooterView(this.vgT);
    this.vgT.setVisibility(8);
    this.vgN = new ArrayList();
    this.vgO = new HashSet();
    paramBundle = q.Gj();
    au.Hx();
    paramBundle = c.Fy().W(paramBundle, 0, 20);
    this.hrK += 20;
    dN(paramBundle);
    this.vgQ = new AppAttachFileListUI.b(this, (byte)0);
    this.vgP.setAdapter(this.vgQ);
    this.vgP.setOnItemClickListener(this.idL);
    this.vgP.setOnScrollListener(this.iCE);
    au.Hx();
    c.Fy().a(this, getMainLooper());
  }
  
  protected void onDestroy()
  {
    au.Hx();
    c.Fy().a(this);
    super.onDestroy();
  }
  
  protected void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppAttachFileListUI
 * JD-Core Version:    0.7.0.1
 */