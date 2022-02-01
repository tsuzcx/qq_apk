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
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.pluginsdk.model.q;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
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
  private ListView JSA;
  private b JSB;
  private boolean JSC;
  private boolean JSD;
  private View JSE;
  private ArrayList<c> JSy;
  private HashSet<Long> JSz;
  private AdapterView.OnItemClickListener oey;
  private AbsListView.OnScrollListener pbp;
  private int startIndex;
  
  public AppAttachFileListUI()
  {
    AppMethodBeat.i(34189);
    this.JSC = true;
    this.JSD = false;
    this.oey = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(34182);
        b localb = new b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mu(paramAnonymousInt);
        localb.rl(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/AppAttachFileListUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
        paramAnonymousView = new Intent();
        paramAnonymousView.setClassName(AppAttachFileListUI.this, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
        paramAnonymousView.putExtra("app_msg_id", ((AppAttachFileListUI.c)AppAttachFileListUI.a(AppAttachFileListUI.this).get(paramAnonymousInt)).dCi.field_msgId);
        paramAnonymousView.setFlags(67108864);
        paramAnonymousAdapterView = AppAttachFileListUI.this;
        paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, paramAnonymousView.ahE(), "com/tencent/mm/ui/chatting/AppAttachFileListUI$2", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousAdapterView.startActivity((Intent)paramAnonymousView.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, "com/tencent/mm/ui/chatting/AppAttachFileListUI$2", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/AppAttachFileListUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(34182);
      }
    };
    this.pbp = new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(34183);
        if ((paramAnonymousInt == 0) && (!AppAttachFileListUI.b(AppAttachFileListUI.this)) && (AppAttachFileListUI.c(AppAttachFileListUI.this)) && (paramAnonymousAbsListView.getLastVisiblePosition() == AppAttachFileListUI.d(AppAttachFileListUI.this).getCount()))
        {
          ae.d("MicroMsg.AppAttachFileListUI", "need to add item");
          paramAnonymousInt = AppAttachFileListUI.e(AppAttachFileListUI.this);
          new AppAttachFileListUI.a(AppAttachFileListUI.this, (byte)0).execute(new Integer[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(20) });
          AppAttachFileListUI.f(AppAttachFileListUI.this);
        }
        AppMethodBeat.o(34183);
      }
    };
    AppMethodBeat.o(34189);
  }
  
  private c aO(bv parambv)
  {
    AppMethodBeat.i(34194);
    k.b localb = k.b.zb(parambv.field_content);
    if (localb == null)
    {
      AppMethodBeat.o(34194);
      return null;
    }
    c localc = new c((byte)0);
    localc.dCi = parambv;
    localc.JSG = localb;
    AppMethodBeat.o(34194);
    return localc;
  }
  
  private void ic(List<bv> paramList)
  {
    AppMethodBeat.i(34193);
    if (paramList.size() < 20)
    {
      this.JSC = false;
      this.JSA.removeFooterView(this.JSE);
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      bv localbv = (bv)localIterator.next();
      c localc = aO(localbv);
      if ((localc != null) && (localc.JSG.type == 6) && (this.JSz.add(Long.valueOf(localbv.field_msgId)))) {
        this.JSy.add(localc);
      }
    }
    ae.d("MicroMsg.AppAttachFileListUI", "append file item list size %d, current total size is %d", new Object[] { Integer.valueOf(paramList.size()), Integer.valueOf(this.JSy.size()) });
    AppMethodBeat.o(34193);
  }
  
  public final void a(com.tencent.mm.plugin.messenger.foundation.a.a.i parami, i.c paramc)
  {
    AppMethodBeat.i(34195);
    if ("insert".equals(paramc.vWi))
    {
      ae.d("MicroMsg.AppAttachFileListUI", "reveive a msg");
      int i = paramc.gQn.size() - 1;
      while (i >= 0)
      {
        parami = (bv)paramc.gQn.get(i);
        if (parami.cVH())
        {
          parami = aO(parami);
          if ((parami != null) && (parami.JSG.type == 6)) {
            this.JSy.add(0, parami);
          }
        }
        i -= 1;
      }
      if (this.JSB != null) {
        this.JSB.notifyDataSetChanged();
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
    this.JSA = ((ListView)findViewById(2131299924));
    this.JSE = getLayoutInflater().inflate(2131492960, null);
    this.JSA.addFooterView(this.JSE);
    this.JSE.setVisibility(8);
    this.JSy = new ArrayList();
    this.JSz = new HashSet();
    paramBundle = v.aAC();
    bc.aCg();
    paramBundle = c.azI().ap(paramBundle, 0, 20);
    this.startIndex += 20;
    ic(paramBundle);
    this.JSB = new b((byte)0);
    this.JSA.setAdapter(this.JSB);
    this.JSA.setOnItemClickListener(this.oey);
    this.JSA.setOnScrollListener(this.pbp);
    bc.aCg();
    c.azI().a(this, getMainLooper());
    AppMethodBeat.o(34190);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(34192);
    bc.aCg();
    c.azI().a(this);
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
    extends AsyncTask<Integer, Integer, List<bv>>
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
        paramViewGroup.JSH = ((MMImageView)paramView.findViewById(2131299921));
        paramViewGroup.JSI = ((TextView)paramView.findViewById(2131299923));
        paramViewGroup.JSJ = ((TextView)paramView.findViewById(2131299920));
        paramViewGroup.JSK = ((TextView)paramView.findViewById(2131299922));
        paramView.setTag(paramViewGroup);
        Assert.assertNotNull(paramViewGroup);
        localc = (AppAttachFileListUI.c)AppAttachFileListUI.a(AppAttachFileListUI.this).get(paramInt);
        paramViewGroup.JSI.setText(localc.JSG.title);
        if (localc.dCi.field_isSend != 1) {
          break label244;
        }
      }
      label244:
      for (String str = "自己";; str = w.zP(localc.JSG.dzZ))
      {
        paramViewGroup.JSJ.setText(String.format("大小：%s，来自：%s", new Object[] { bu.sL(localc.JSG.hCC), str }));
        paramViewGroup.JSK.setText(com.tencent.mm.pluginsdk.i.i.c(AppAttachFileListUI.this, localc.dCi.field_createTime, true));
        paramViewGroup.JSH.setImageResource(q.aMX(localc.JSG.hCD));
        AppMethodBeat.o(34188);
        return paramView;
        paramViewGroup = (AppAttachFileListUI.d)paramView.getTag();
        break;
      }
    }
  }
  
  final class c
  {
    public k.b JSG;
    public bv dCi;
    
    private c() {}
  }
  
  final class d
  {
    public MMImageView JSH;
    public TextView JSI;
    public TextView JSJ;
    public TextView JSK;
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppAttachFileListUI
 * JD-Core Version:    0.7.0.1
 */