package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.pluginsdk.model.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

public class AppAttachFileListUI
  extends MMActivity
  implements i.a
{
  private ArrayList<c> JxI;
  private HashSet<Long> JxJ;
  private ListView JxK;
  private b JxL;
  private boolean JxM;
  private boolean JxN;
  private View JxO;
  private AdapterView.OnItemClickListener nYP;
  private AbsListView.OnScrollListener oUM;
  private int startIndex;
  
  public AppAttachFileListUI()
  {
    AppMethodBeat.i(34189);
    this.JxM = true;
    this.JxN = false;
    this.nYP = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(34182);
        b localb = new b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mr(paramAnonymousInt);
        localb.qY(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/AppAttachFileListUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
        paramAnonymousView = new Intent();
        paramAnonymousView.setClassName(AppAttachFileListUI.this, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
        paramAnonymousView.putExtra("app_msg_id", ((AppAttachFileListUI.c)AppAttachFileListUI.a(AppAttachFileListUI.this).get(paramAnonymousInt)).dBd.field_msgId);
        paramAnonymousView.setFlags(67108864);
        paramAnonymousAdapterView = AppAttachFileListUI.this;
        paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, paramAnonymousView.ahp(), "com/tencent/mm/ui/chatting/AppAttachFileListUI$2", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousAdapterView.startActivity((Intent)paramAnonymousView.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, "com/tencent/mm/ui/chatting/AppAttachFileListUI$2", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/AppAttachFileListUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(34182);
      }
    };
    this.oUM = new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(34183);
        if ((paramAnonymousInt == 0) && (!AppAttachFileListUI.b(AppAttachFileListUI.this)) && (AppAttachFileListUI.c(AppAttachFileListUI.this)) && (paramAnonymousAbsListView.getLastVisiblePosition() == AppAttachFileListUI.d(AppAttachFileListUI.this).getCount()))
        {
          ad.d("MicroMsg.AppAttachFileListUI", "need to add item");
          paramAnonymousInt = AppAttachFileListUI.e(AppAttachFileListUI.this);
          new AppAttachFileListUI.a(AppAttachFileListUI.this, (byte)0).execute(new Integer[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(20) });
          AppAttachFileListUI.f(AppAttachFileListUI.this);
        }
        AppMethodBeat.o(34183);
      }
    };
    AppMethodBeat.o(34189);
  }
  
  private c aP(bu parambu)
  {
    AppMethodBeat.i(34194);
    k.b localb = k.b.yr(parambu.field_content);
    if (localb == null)
    {
      AppMethodBeat.o(34194);
      return null;
    }
    c localc = new c((byte)0);
    localc.dBd = parambu;
    localc.JxQ = localb;
    AppMethodBeat.o(34194);
    return localc;
  }
  
  private void hS(List<bu> paramList)
  {
    AppMethodBeat.i(34193);
    if (paramList.size() < 20)
    {
      this.JxM = false;
      this.JxK.removeFooterView(this.JxO);
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      bu localbu = (bu)localIterator.next();
      c localc = aP(localbu);
      if ((localc != null) && (localc.JxQ.type == 6) && (this.JxJ.add(Long.valueOf(localbu.field_msgId)))) {
        this.JxI.add(localc);
      }
    }
    ad.d("MicroMsg.AppAttachFileListUI", "append file item list size %d, current total size is %d", new Object[] { Integer.valueOf(paramList.size()), Integer.valueOf(this.JxI.size()) });
    AppMethodBeat.o(34193);
  }
  
  public final void a(com.tencent.mm.plugin.messenger.foundation.a.a.i parami, i.c paramc)
  {
    AppMethodBeat.i(34195);
    if ("insert".equals(paramc.vKe))
    {
      ad.d("MicroMsg.AppAttachFileListUI", "reveive a msg");
      int i = paramc.gNE.size() - 1;
      while (i >= 0)
      {
        parami = (bu)paramc.gNE.get(i);
        if (parami.cTc())
        {
          parami = aP(parami);
          if ((parami != null) && (parami.JxQ.type == 6)) {
            this.JxI.add(0, parami);
          }
        }
        i -= 1;
      }
      if (this.JxL != null) {
        this.JxL.notifyDataSetChanged();
      }
    }
    AppMethodBeat.o(34195);
  }
  
  public int getLayoutId()
  {
    return 2131492962;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(34190);
    super.onCreate(paramBundle);
    setMMTitle(2131759067);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(34181);
        AppAttachFileListUI.this.finish();
        AppMethodBeat.o(34181);
        return true;
      }
    });
    this.JxK = ((ListView)findViewById(2131299924));
    this.JxO = getLayoutInflater().inflate(2131492960, null);
    this.JxK.addFooterView(this.JxO);
    this.JxO.setVisibility(8);
    this.JxI = new ArrayList();
    this.JxJ = new HashSet();
    paramBundle = u.aAm();
    ba.aBQ();
    paramBundle = c.azs().ap(paramBundle, 0, 20);
    this.startIndex += 20;
    hS(paramBundle);
    this.JxL = new b((byte)0);
    this.JxK.setAdapter(this.JxL);
    this.JxK.setOnItemClickListener(this.nYP);
    this.JxK.setOnScrollListener(this.oUM);
    ba.aBQ();
    c.azs().a(this, getMainLooper());
    AppMethodBeat.o(34190);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(34192);
    ba.aBQ();
    c.azs().a(this);
    super.onDestroy();
    AppMethodBeat.o(34192);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(34191);
    super.onResume();
    AppMethodBeat.o(34191);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends AsyncTask<Integer, Integer, List<bu>>
  {
    private a() {}
  }
  
  final class b
    extends BaseAdapter
  {
    private b() {}
    
    public final int getCount()
    {
      AppMethodBeat.i(34186);
      int i = AppAttachFileListUI.a(AppAttachFileListUI.this).size();
      AppMethodBeat.o(34186);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(34187);
      Object localObject = AppAttachFileListUI.a(AppAttachFileListUI.this).get(paramInt);
      AppMethodBeat.o(34187);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(34188);
      AppAttachFileListUI.c localc;
      if (paramView == null)
      {
        paramView = AppAttachFileListUI.this.getLayoutInflater().inflate(2131492961, paramViewGroup, false);
        Assert.assertNotNull(paramView);
        paramViewGroup = new AppAttachFileListUI.d(AppAttachFileListUI.this, (byte)0);
        paramViewGroup.JxR = ((MMImageView)paramView.findViewById(2131299921));
        paramViewGroup.JxS = ((TextView)paramView.findViewById(2131299923));
        paramViewGroup.JxT = ((TextView)paramView.findViewById(2131299920));
        paramViewGroup.JxU = ((TextView)paramView.findViewById(2131299922));
        paramView.setTag(paramViewGroup);
        Assert.assertNotNull(paramViewGroup);
        localc = (AppAttachFileListUI.c)AppAttachFileListUI.a(AppAttachFileListUI.this).get(paramInt);
        paramViewGroup.JxS.setText(localc.JxQ.title);
        if (localc.dBd.field_isSend != 1) {
          break label244;
        }
      }
      label244:
      for (String str = "自己";; str = v.zf(localc.JxQ.dyU))
      {
        paramViewGroup.JxT.setText(String.format("大小：%s，来自：%s", new Object[] { bt.sy(localc.JxQ.hzO), str }));
        paramViewGroup.JxU.setText(com.tencent.mm.pluginsdk.i.i.c(AppAttachFileListUI.this, localc.dBd.field_createTime, true));
        paramViewGroup.JxR.setImageResource(q.aLB(localc.JxQ.hzP));
        AppMethodBeat.o(34188);
        return paramView;
        paramViewGroup = (AppAttachFileListUI.d)paramView.getTag();
        break;
      }
    }
  }
  
  final class c
  {
    public k.b JxQ;
    public bu dBd;
    
    private c() {}
  }
  
  final class d
  {
    public MMImageView JxR;
    public TextView JxS;
    public TextView JxT;
    public TextView JxU;
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppAttachFileListUI
 * JD-Core Version:    0.7.0.1
 */