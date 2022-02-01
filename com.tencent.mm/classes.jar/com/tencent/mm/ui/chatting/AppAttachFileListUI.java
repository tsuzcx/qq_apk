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
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;
import com.tencent.mm.pluginsdk.model.q;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

public class AppAttachFileListUI
  extends MMActivity
  implements h.a
{
  private ArrayList<c> HJR;
  private HashSet<Long> HJS;
  private ListView HJT;
  private b HJU;
  private boolean HJV;
  private boolean HJW;
  private View HJX;
  private AdapterView.OnItemClickListener nxr;
  private AbsListView.OnScrollListener orq;
  private int startIndex;
  
  public AppAttachFileListUI()
  {
    AppMethodBeat.i(34189);
    this.HJV = true;
    this.HJW = false;
    this.nxr = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(34182);
        paramAnonymousView = new Intent();
        paramAnonymousView.setClassName(AppAttachFileListUI.this, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
        paramAnonymousView.putExtra("app_msg_id", ((AppAttachFileListUI.c)AppAttachFileListUI.a(AppAttachFileListUI.this).get(paramAnonymousInt)).dpq.field_msgId);
        paramAnonymousView.setFlags(67108864);
        paramAnonymousAdapterView = AppAttachFileListUI.this;
        paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, paramAnonymousView.aeD(), "com/tencent/mm/ui/chatting/AppAttachFileListUI$2", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousAdapterView.startActivity((Intent)paramAnonymousView.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, "com/tencent/mm/ui/chatting/AppAttachFileListUI$2", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(34182);
      }
    };
    this.orq = new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(34183);
        if ((paramAnonymousInt == 0) && (!AppAttachFileListUI.b(AppAttachFileListUI.this)) && (AppAttachFileListUI.c(AppAttachFileListUI.this)) && (paramAnonymousAbsListView.getLastVisiblePosition() == AppAttachFileListUI.d(AppAttachFileListUI.this).getCount()))
        {
          ac.d("MicroMsg.AppAttachFileListUI", "need to add item");
          paramAnonymousInt = AppAttachFileListUI.e(AppAttachFileListUI.this);
          new AppAttachFileListUI.a(AppAttachFileListUI.this, (byte)0).execute(new Integer[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(20) });
          AppAttachFileListUI.f(AppAttachFileListUI.this);
        }
        AppMethodBeat.o(34183);
      }
    };
    AppMethodBeat.o(34189);
  }
  
  private c aM(bo parambo)
  {
    AppMethodBeat.i(34194);
    k.b localb = k.b.vA(parambo.field_content);
    if (localb == null)
    {
      AppMethodBeat.o(34194);
      return null;
    }
    c localc = new c((byte)0);
    localc.dpq = parambo;
    localc.HJZ = localb;
    AppMethodBeat.o(34194);
    return localc;
  }
  
  private void hG(List<bo> paramList)
  {
    AppMethodBeat.i(34193);
    if (paramList.size() < 20)
    {
      this.HJV = false;
      this.HJT.removeFooterView(this.HJX);
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      bo localbo = (bo)localIterator.next();
      c localc = aM(localbo);
      if ((localc != null) && (localc.HJZ.type == 6) && (this.HJS.add(Long.valueOf(localbo.field_msgId)))) {
        this.HJR.add(localc);
      }
    }
    ac.d("MicroMsg.AppAttachFileListUI", "append file item list size %d, current total size is %d", new Object[] { Integer.valueOf(paramList.size()), Integer.valueOf(this.HJR.size()) });
    AppMethodBeat.o(34193);
  }
  
  public final void a(com.tencent.mm.plugin.messenger.foundation.a.a.h paramh, h.c paramc)
  {
    AppMethodBeat.i(34195);
    if ("insert".equals(paramc.uHb))
    {
      ac.d("MicroMsg.AppAttachFileListUI", "reveive a msg");
      int i = paramc.gtT.size() - 1;
      while (i >= 0)
      {
        paramh = (bo)paramc.gtT.get(i);
        if (paramh.cKN())
        {
          paramh = aM(paramh);
          if ((paramh != null) && (paramh.HJZ.type == 6)) {
            this.HJR.add(0, paramh);
          }
        }
        i -= 1;
      }
      if (this.HJU != null) {
        this.HJU.notifyDataSetChanged();
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
    this.HJT = ((ListView)findViewById(2131299924));
    this.HJX = getLayoutInflater().inflate(2131492960, null);
    this.HJT.addFooterView(this.HJX);
    this.HJX.setVisibility(8);
    this.HJR = new ArrayList();
    this.HJS = new HashSet();
    paramBundle = u.axw();
    az.ayM();
    paramBundle = c.awD().al(paramBundle, 0, 20);
    this.startIndex += 20;
    hG(paramBundle);
    this.HJU = new b((byte)0);
    this.HJT.setAdapter(this.HJU);
    this.HJT.setOnItemClickListener(this.nxr);
    this.HJT.setOnScrollListener(this.orq);
    az.ayM();
    c.awD().a(this, getMainLooper());
    AppMethodBeat.o(34190);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(34192);
    az.ayM();
    c.awD().a(this);
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
    extends AsyncTask<Integer, Integer, List<bo>>
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
        paramViewGroup.HKa = ((MMImageView)paramView.findViewById(2131299921));
        paramViewGroup.HKb = ((TextView)paramView.findViewById(2131299923));
        paramViewGroup.HKc = ((TextView)paramView.findViewById(2131299920));
        paramViewGroup.HKd = ((TextView)paramView.findViewById(2131299922));
        paramView.setTag(paramViewGroup);
        Assert.assertNotNull(paramViewGroup);
        localc = (AppAttachFileListUI.c)AppAttachFileListUI.a(AppAttachFileListUI.this).get(paramInt);
        paramViewGroup.HKb.setText(localc.HJZ.title);
        if (localc.dpq.field_isSend != 1) {
          break label244;
        }
      }
      label244:
      for (String str = "自己";; str = v.wk(localc.HJZ.dng))
      {
        paramViewGroup.HKc.setText(String.format("大小：%s，来自：%s", new Object[] { bs.qz(localc.HJZ.hhF), str }));
        paramViewGroup.HKd.setText(com.tencent.mm.pluginsdk.g.h.c(AppAttachFileListUI.this, localc.dpq.field_createTime, true));
        paramViewGroup.HKa.setImageResource(q.aGb(localc.HJZ.hhG));
        AppMethodBeat.o(34188);
        return paramView;
        paramViewGroup = (AppAttachFileListUI.d)paramView.getTag();
        break;
      }
    }
  }
  
  final class c
  {
    public k.b HJZ;
    public bo dpq;
    
    private c() {}
  }
  
  final class d
  {
    public MMImageView HKa;
    public TextView HKb;
    public TextView HKc;
    public TextView HKd;
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppAttachFileListUI
 * JD-Core Version:    0.7.0.1
 */