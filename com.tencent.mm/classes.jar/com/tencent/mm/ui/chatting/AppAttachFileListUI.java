package com.tencent.mm.ui.chatting;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.pluginsdk.model.x;
import com.tencent.mm.pluginsdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
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
  private ArrayList<c> aeeg;
  private HashSet<Long> aeeh;
  private ListView aeei;
  private b aeej;
  private boolean aeek;
  private boolean aeel;
  private View aeem;
  private int startIndex;
  private AdapterView.OnItemClickListener vEc;
  private AbsListView.OnScrollListener wSm;
  
  public AppAttachFileListUI()
  {
    AppMethodBeat.i(34189);
    this.aeek = true;
    this.aeel = false;
    this.vEc = new AppAttachFileListUI.2(this);
    this.wSm = new AbsListView.OnScrollListener()
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
  
  private c bK(cc paramcc)
  {
    AppMethodBeat.i(34194);
    k.b localb = k.b.Hf(paramcc.field_content);
    if (localb == null)
    {
      AppMethodBeat.o(34194);
      return null;
    }
    c localc = new c((byte)0);
    localc.hTm = paramcc;
    localc.aeeo = localb;
    AppMethodBeat.o(34194);
    return localc;
  }
  
  private void my(List<cc> paramList)
  {
    AppMethodBeat.i(34193);
    if (paramList.size() < 20)
    {
      this.aeek = false;
      this.aeei.removeFooterView(this.aeem);
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      cc localcc = (cc)localIterator.next();
      c localc = bK(localcc);
      if ((localc != null) && (localc.aeeo.type == 6) && (this.aeeh.add(Long.valueOf(localcc.field_msgId)))) {
        this.aeeg.add(localc);
      }
    }
    Log.d("MicroMsg.AppAttachFileListUI", "append file item list size %d, current total size is %d", new Object[] { Integer.valueOf(paramList.size()), Integer.valueOf(this.aeeg.size()) });
    AppMethodBeat.o(34193);
  }
  
  public int getLayoutId()
  {
    return R.i.gef;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(34190);
    super.onCreate(paramBundle);
    setMMTitle(R.l.gHJ);
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
    this.aeei = ((ListView)findViewById(R.h.fHY));
    this.aeem = getLayoutInflater().inflate(R.i.ged, null);
    this.aeei.addFooterView(this.aeem);
    this.aeem.setVisibility(8);
    this.aeeg = new ArrayList();
    this.aeeh = new HashSet();
    paramBundle = z.bAM();
    bh.bCz();
    paramBundle = c.bzD().aB(paramBundle, 0, 20);
    this.startIndex += 20;
    my(paramBundle);
    this.aeej = new b((byte)0);
    this.aeei.setAdapter(this.aeej);
    this.aeei.setOnItemClickListener(this.vEc);
    this.aeei.setOnScrollListener(this.wSm);
    bh.bCz();
    c.bzD().a(this, getMainLooper());
    AppMethodBeat.o(34190);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(34192);
    bh.bCz();
    c.bzD().a(this);
    super.onDestroy();
    AppMethodBeat.o(34192);
  }
  
  public void onNotifyChange(i parami, i.c paramc)
  {
    AppMethodBeat.i(34195);
    if ("insert".equals(paramc.KRm))
    {
      Log.d("MicroMsg.AppAttachFileListUI", "reveive a msg");
      int i = paramc.mZo.size() - 1;
      while (i >= 0)
      {
        parami = (cc)paramc.mZo.get(i);
        if (parami.fxR())
        {
          parami = bK(parami);
          if ((parami != null) && (parami.aeeo.type == 6)) {
            this.aeeg.add(0, parami);
          }
        }
        i -= 1;
      }
      if (this.aeej != null) {
        this.aeej.notifyDataSetChanged();
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
    extends AsyncTask<Integer, Integer, List<cc>>
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
        paramView = AppAttachFileListUI.this.getLayoutInflater().inflate(R.i.gee, paramViewGroup, false);
        Assert.assertNotNull(paramView);
        paramViewGroup = new AppAttachFileListUI.d(AppAttachFileListUI.this, (byte)0);
        paramViewGroup.aeep = ((MMImageView)paramView.findViewById(R.h.fHV));
        paramViewGroup.aeeq = ((TextView)paramView.findViewById(R.h.fHX));
        paramViewGroup.aeer = ((TextView)paramView.findViewById(R.h.fHU));
        paramViewGroup.aees = ((TextView)paramView.findViewById(R.h.fHW));
        paramView.setTag(paramViewGroup);
        Assert.assertNotNull(paramViewGroup);
        localc = (AppAttachFileListUI.c)AppAttachFileListUI.a(AppAttachFileListUI.this).get(paramInt);
        paramViewGroup.aeeq.setText(localc.aeeo.title);
        if (localc.hTm.field_isSend != 1) {
          break label249;
        }
      }
      label249:
      for (String str = "自己";; str = aa.getDisplayName(localc.aeeo.hQQ))
      {
        paramViewGroup.aeer.setText(String.format("大小：%s，来自：%s", new Object[] { Util.getSizeKB(localc.aeeo.nRd), str }));
        paramViewGroup.aees.setText(f.d(AppAttachFileListUI.this, localc.hTm.getCreateTime(), true));
        paramViewGroup.aeep.setImageResource(x.bpA(localc.aeeo.nRe));
        AppMethodBeat.o(34188);
        return paramView;
        paramViewGroup = (AppAttachFileListUI.d)paramView.getTag();
        break;
      }
    }
  }
  
  final class c
  {
    public k.b aeeo;
    public cc hTm;
    
    private c() {}
  }
  
  final class d
  {
    public MMImageView aeep;
    public TextView aeeq;
    public TextView aeer;
    public TextView aees;
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppAttachFileListUI
 * JD-Core Version:    0.7.0.1
 */