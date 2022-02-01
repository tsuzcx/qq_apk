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
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.f.c.et;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.pluginsdk.j.f;
import com.tencent.mm.pluginsdk.model.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
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
  private ArrayList<c> WwP;
  private HashSet<Long> WwQ;
  private ListView WwR;
  private b WwS;
  private boolean WwT;
  private boolean WwU;
  private View WwV;
  private int startIndex;
  private AdapterView.OnItemClickListener syv;
  private AbsListView.OnScrollListener tOW;
  
  public AppAttachFileListUI()
  {
    AppMethodBeat.i(34189);
    this.WwT = true;
    this.WwU = false;
    this.syv = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(34182);
        b localb = new b();
        localb.bn(paramAnonymousAdapterView);
        localb.bn(paramAnonymousView);
        localb.sg(paramAnonymousInt);
        localb.Fs(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/AppAttachFileListUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
        paramAnonymousView = new Intent();
        paramAnonymousView.setClassName(AppAttachFileListUI.this, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
        paramAnonymousView.putExtra("app_msg_id", ((AppAttachFileListUI.c)AppAttachFileListUI.a(AppAttachFileListUI.this).get(paramAnonymousInt)).fNz.field_msgId);
        paramAnonymousView.setFlags(67108864);
        paramAnonymousAdapterView = AppAttachFileListUI.this;
        paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousAdapterView, paramAnonymousView.aFh(), "com/tencent/mm/ui/chatting/AppAttachFileListUI$2", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousAdapterView.startActivity((Intent)paramAnonymousView.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousAdapterView, "com/tencent/mm/ui/chatting/AppAttachFileListUI$2", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/AppAttachFileListUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(34182);
      }
    };
    this.tOW = new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(34183);
        if ((paramAnonymousInt == 0) && (!AppAttachFileListUI.b(AppAttachFileListUI.this)) && (AppAttachFileListUI.c(AppAttachFileListUI.this)) && (paramAnonymousAbsListView.getLastVisiblePosition() == AppAttachFileListUI.d(AppAttachFileListUI.this).getCount()))
        {
          Log.d("MicroMsg.AppAttachFileListUI", "need to add item");
          paramAnonymousInt = AppAttachFileListUI.e(AppAttachFileListUI.this);
          new AppAttachFileListUI.a(AppAttachFileListUI.this, (byte)0).execute(new Integer[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(20) });
          AppAttachFileListUI.f(AppAttachFileListUI.this);
        }
        AppMethodBeat.o(34183);
      }
    };
    AppMethodBeat.o(34189);
  }
  
  private c bx(ca paramca)
  {
    AppMethodBeat.i(34194);
    k.b localb = k.b.OQ(paramca.field_content);
    if (localb == null)
    {
      AppMethodBeat.o(34194);
      return null;
    }
    c localc = new c((byte)0);
    localc.fNz = paramca;
    localc.WwX = localb;
    AppMethodBeat.o(34194);
    return localc;
  }
  
  private void jn(List<ca> paramList)
  {
    AppMethodBeat.i(34193);
    if (paramList.size() < 20)
    {
      this.WwT = false;
      this.WwR.removeFooterView(this.WwV);
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      ca localca = (ca)localIterator.next();
      c localc = bx(localca);
      if ((localc != null) && (localc.WwX.type == 6) && (this.WwQ.add(Long.valueOf(localca.field_msgId)))) {
        this.WwP.add(localc);
      }
    }
    Log.d("MicroMsg.AppAttachFileListUI", "append file item list size %d, current total size is %d", new Object[] { Integer.valueOf(paramList.size()), Integer.valueOf(this.WwP.size()) });
    AppMethodBeat.o(34193);
  }
  
  public int getLayoutId()
  {
    return R.i.ebx;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(34190);
    super.onCreate(paramBundle);
    setMMTitle(R.l.eEQ);
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
    this.WwR = ((ListView)findViewById(R.h.dGR));
    this.WwV = getLayoutInflater().inflate(R.i.ebv, null);
    this.WwR.addFooterView(this.WwV);
    this.WwV.setVisibility(8);
    this.WwP = new ArrayList();
    this.WwQ = new HashSet();
    paramBundle = z.bcZ();
    bh.beI();
    paramBundle = c.bbO().au(paramBundle, 0, 20);
    this.startIndex += 20;
    jn(paramBundle);
    this.WwS = new b((byte)0);
    this.WwR.setAdapter(this.WwS);
    this.WwR.setOnItemClickListener(this.syv);
    this.WwR.setOnScrollListener(this.tOW);
    bh.beI();
    c.bbO().a(this, getMainLooper());
    AppMethodBeat.o(34190);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(34192);
    bh.beI();
    c.bbO().a(this);
    super.onDestroy();
    AppMethodBeat.o(34192);
  }
  
  public void onNotifyChange(i parami, i.c paramc)
  {
    AppMethodBeat.i(34195);
    if ("insert".equals(paramc.EVM))
    {
      Log.d("MicroMsg.AppAttachFileListUI", "reveive a msg");
      int i = paramc.kvM.size() - 1;
      while (i >= 0)
      {
        parami = (ca)paramc.kvM.get(i);
        if (parami.erk())
        {
          parami = bx(parami);
          if ((parami != null) && (parami.WwX.type == 6)) {
            this.WwP.add(0, parami);
          }
        }
        i -= 1;
      }
      if (this.WwS != null) {
        this.WwS.notifyDataSetChanged();
      }
    }
    AppMethodBeat.o(34195);
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
    extends AsyncTask<Integer, Integer, List<ca>>
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
        paramView = AppAttachFileListUI.this.getLayoutInflater().inflate(R.i.ebw, paramViewGroup, false);
        Assert.assertNotNull(paramView);
        paramViewGroup = new AppAttachFileListUI.d(AppAttachFileListUI.this, (byte)0);
        paramViewGroup.WwY = ((MMImageView)paramView.findViewById(R.h.dGO));
        paramViewGroup.WwZ = ((TextView)paramView.findViewById(R.h.dGQ));
        paramViewGroup.Wxa = ((TextView)paramView.findViewById(R.h.dGN));
        paramViewGroup.Wxb = ((TextView)paramView.findViewById(R.h.dGP));
        paramView.setTag(paramViewGroup);
        Assert.assertNotNull(paramViewGroup);
        localc = (AppAttachFileListUI.c)AppAttachFileListUI.a(AppAttachFileListUI.this).get(paramInt);
        paramViewGroup.WwZ.setText(localc.WwX.title);
        if (localc.fNz.field_isSend != 1) {
          break label249;
        }
      }
      label249:
      for (String str = "自己";; str = aa.PJ(localc.WwX.fLi))
      {
        paramViewGroup.Wxa.setText(String.format("大小：%s，来自：%s", new Object[] { Util.getSizeKB(localc.WwX.llX), str }));
        paramViewGroup.Wxb.setText(f.d(AppAttachFileListUI.this, localc.fNz.field_createTime, true));
        paramViewGroup.WwY.setImageResource(v.bpJ(localc.WwX.llY));
        AppMethodBeat.o(34188);
        return paramView;
        paramViewGroup = (AppAttachFileListUI.d)paramView.getTag();
        break;
      }
    }
  }
  
  final class c
  {
    public k.b WwX;
    public ca fNz;
    
    private c() {}
  }
  
  final class d
  {
    public MMImageView WwY;
    public TextView WwZ;
    public TextView Wxa;
    public TextView Wxb;
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppAttachFileListUI
 * JD-Core Version:    0.7.0.1
 */