package com.tencent.mm.ui.chatting;

import android.app.Activity;
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
import com.tencent.mm.ag.k.b;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.pluginsdk.i.f;
import com.tencent.mm.pluginsdk.model.r;
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
  private ArrayList<c> PdD;
  private HashSet<Long> PdE;
  private ListView PdF;
  private b PdG;
  private boolean PdH;
  private boolean PdI;
  private View PdJ;
  private AdapterView.OnItemClickListener ppw;
  private AbsListView.OnScrollListener qqo;
  private int startIndex;
  
  public AppAttachFileListUI()
  {
    AppMethodBeat.i(34189);
    this.PdH = true;
    this.PdI = false;
    this.ppw = new AppAttachFileListUI.2(this);
    this.qqo = new AbsListView.OnScrollListener()
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
  
  private c be(ca paramca)
  {
    AppMethodBeat.i(34194);
    k.b localb = k.b.HD(paramca.field_content);
    if (localb == null)
    {
      AppMethodBeat.o(34194);
      return null;
    }
    c localc = new c((byte)0);
    localc.dTX = paramca;
    localc.PdL = localb;
    AppMethodBeat.o(34194);
    return localc;
  }
  
  private void iw(List<ca> paramList)
  {
    AppMethodBeat.i(34193);
    if (paramList.size() < 20)
    {
      this.PdH = false;
      this.PdF.removeFooterView(this.PdJ);
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      ca localca = (ca)localIterator.next();
      c localc = be(localca);
      if ((localc != null) && (localc.PdL.type == 6) && (this.PdE.add(Long.valueOf(localca.field_msgId)))) {
        this.PdD.add(localc);
      }
    }
    Log.d("MicroMsg.AppAttachFileListUI", "append file item list size %d, current total size is %d", new Object[] { Integer.valueOf(paramList.size()), Integer.valueOf(this.PdD.size()) });
    AppMethodBeat.o(34193);
  }
  
  public final void a(i parami, i.c paramc)
  {
    AppMethodBeat.i(34195);
    if ("insert".equals(paramc.zqn))
    {
      Log.d("MicroMsg.AppAttachFileListUI", "reveive a msg");
      int i = paramc.hIs.size() - 1;
      while (i >= 0)
      {
        parami = (ca)paramc.hIs.get(i);
        if (parami.dOQ())
        {
          parami = be(parami);
          if ((parami != null) && (parami.PdL.type == 6)) {
            this.PdD.add(0, parami);
          }
        }
        i -= 1;
      }
      if (this.PdG != null) {
        this.PdG.notifyDataSetChanged();
      }
    }
    AppMethodBeat.o(34195);
  }
  
  public int getLayoutId()
  {
    return 2131492996;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(34190);
    super.onCreate(paramBundle);
    setMMTitle(2131759399);
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
    this.PdF = ((ListView)findViewById(2131300627));
    this.PdJ = getLayoutInflater().inflate(2131492994, null);
    this.PdF.addFooterView(this.PdJ);
    this.PdJ.setVisibility(8);
    this.PdD = new ArrayList();
    this.PdE = new HashSet();
    paramBundle = z.aTY();
    bg.aVF();
    paramBundle = c.aSQ().as(paramBundle, 0, 20);
    this.startIndex += 20;
    iw(paramBundle);
    this.PdG = new b((byte)0);
    this.PdF.setAdapter(this.PdG);
    this.PdF.setOnItemClickListener(this.ppw);
    this.PdF.setOnScrollListener(this.qqo);
    bg.aVF();
    c.aSQ().a(this, getMainLooper());
    AppMethodBeat.o(34190);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(34192);
    bg.aVF();
    c.aSQ().a(this);
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
        paramView = AppAttachFileListUI.this.getLayoutInflater().inflate(2131492995, paramViewGroup, false);
        Assert.assertNotNull(paramView);
        paramViewGroup = new AppAttachFileListUI.d(AppAttachFileListUI.this, (byte)0);
        paramViewGroup.PdM = ((MMImageView)paramView.findViewById(2131300624));
        paramViewGroup.PdN = ((TextView)paramView.findViewById(2131300626));
        paramViewGroup.PdO = ((TextView)paramView.findViewById(2131300623));
        paramViewGroup.PdP = ((TextView)paramView.findViewById(2131300625));
        paramView.setTag(paramViewGroup);
        Assert.assertNotNull(paramViewGroup);
        localc = (AppAttachFileListUI.c)AppAttachFileListUI.a(AppAttachFileListUI.this).get(paramInt);
        paramViewGroup.PdN.setText(localc.PdL.title);
        if (localc.dTX.field_isSend != 1) {
          break label244;
        }
      }
      label244:
      for (String str = "自己";; str = aa.getDisplayName(localc.PdL.dRL))
      {
        paramViewGroup.PdO.setText(String.format("大小：%s，来自：%s", new Object[] { Util.getSizeKB(localc.PdL.iwI), str }));
        paramViewGroup.PdP.setText(f.c(AppAttachFileListUI.this, localc.dTX.field_createTime, true));
        paramViewGroup.PdM.setImageResource(r.bdt(localc.PdL.iwJ));
        AppMethodBeat.o(34188);
        return paramView;
        paramViewGroup = (AppAttachFileListUI.d)paramView.getTag();
        break;
      }
    }
  }
  
  final class c
  {
    public k.b PdL;
    public ca dTX;
    
    private c() {}
  }
  
  final class d
  {
    public MMImageView PdM;
    public TextView PdN;
    public TextView PdO;
    public TextView PdP;
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppAttachFileListUI
 * JD-Core Version:    0.7.0.1
 */