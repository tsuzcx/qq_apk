package com.tencent.mm.plugin.sns.ui.album;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.ar.a;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.ai;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.plugin.sns.ui.LoadingMoreView;
import com.tencent.mm.plugin.sns.ui.bp;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.arc;
import com.tencent.mm.protocal.protobuf.bzi;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends RecyclerView.a
{
  private String HqN;
  private a RHA;
  private final int RHn;
  private final int RHo;
  private final int RHp;
  List<a.b> RHq;
  String RHr;
  String RHs;
  boolean RHt;
  private long RHu;
  private long RHv;
  int RHw;
  private int RHx;
  private b RHy;
  c.a RHz;
  private boolean RdS;
  private String luk;
  private Context mContext;
  private String vEv;
  private boolean wHe;
  
  public a(Context paramContext, String paramString, a parama)
  {
    AppMethodBeat.i(99856);
    this.RHn = 0;
    this.RHo = 1;
    this.RHp = 2;
    this.RHq = new ArrayList();
    this.mContext = null;
    this.HqN = null;
    this.RHr = "";
    this.RHs = "";
    this.luk = "";
    this.RdS = false;
    this.RHt = false;
    this.RHu = 0L;
    this.RHv = 0L;
    this.RHw = 0;
    this.wHe = false;
    this.vEv = "";
    this.RHx = 0;
    this.RHy = null;
    this.RHz = null;
    this.RHA = null;
    this.mContext = paramContext;
    this.RHA = parama;
    parama = LocaleUtil.loadApplicationLanguage(this.mContext.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), this.mContext);
    Log.d("MicroMsg.SnsAlbumAdapter", "filterLan temp ".concat(String.valueOf(parama)));
    paramContext = parama;
    if (!parama.equals("zh_CN"))
    {
      paramContext = parama;
      if (!parama.equals("en"))
      {
        if (!parama.equals("zh_TW")) {
          break label301;
        }
        paramContext = parama;
      }
    }
    for (;;)
    {
      this.HqN = paramContext;
      this.luk = paramString;
      h.baF();
      paramContext = (String)h.baE().ban().d(2, null);
      if (this.luk.equals(paramContext)) {
        this.RdS = true;
      }
      this.RHy = new b(new b.a()
      {
        public final void kQ(List<a.b> paramAnonymousList)
        {
          AppMethodBeat.i(99849);
          if (paramAnonymousList == null) {}
          for (int i = 0;; i = paramAnonymousList.size())
          {
            Log.d("MicroMsg.SnsAlbumAdapter", "onLoadingFinish list.size=%s", new Object[] { Integer.valueOf(i) });
            a.a(a.this).clear();
            a.b localb = new a.b();
            localb.label = "my_timeline";
            a.a(a.this).add(localb);
            a.a(a.this).addAll(paramAnonymousList);
            a.a(a.this, a.b(a.this));
            if (!paramAnonymousList.isEmpty())
            {
              localb = new a.b();
              localb.label = "loading";
              a.a(a.this).add(localb);
            }
            a.this.bZE.notifyChanged();
            if (a.c(a.this) != null) {
              a.c(a.this).kR(paramAnonymousList);
            }
            AppMethodBeat.o(99849);
            return;
          }
        }
      }, this.luk, this.RdS);
      vs(0L);
      Log.d("MicroMsg.SnsAlbumAdapter", "limitId=%s", new Object[] { this.RHs });
      Ek(false);
      AppMethodBeat.o(99856);
      return;
      label301:
      if (parama.equals("zh_HK")) {
        paramContext = "zh_TW";
      } else {
        paramContext = "en";
      }
    }
  }
  
  private void vs(long paramLong)
  {
    AppMethodBeat.i(99863);
    int i = al.hgr().aYB(this.luk);
    Object localObject = t.uB(al.hgB().az(paramLong, i));
    if (this.RHr.equals("")) {}
    for (;;)
    {
      this.RHs = ((String)localObject);
      localObject = al.hgF().aZW(this.luk).hkS();
      if (((arc)localObject).Zyu != 0L) {
        break;
      }
      AppMethodBeat.o(99863);
      return;
      if (((String)localObject).compareTo(this.RHr) >= 0) {
        localObject = this.RHr;
      }
    }
    localObject = t.uB(((arc)localObject).Zyu);
    if (this.RHs.equals(""))
    {
      this.RHs = ((String)localObject);
      AppMethodBeat.o(99863);
      return;
    }
    Log.d("MicroMsg.SnsAlbumAdapter", "updateLimieSeq getListId=%s mLimitSeq=%s", new Object[] { Long.valueOf(paramLong), this.RHs });
    if (((String)localObject).compareTo(this.RHs) > 0) {}
    for (;;)
    {
      this.RHs = ((String)localObject);
      AppMethodBeat.o(99863);
      return;
      localObject = this.RHs;
    }
  }
  
  public final void Ek(boolean paramBoolean)
  {
    AppMethodBeat.i(99864);
    Log.d("MicroMsg.SnsAlbumAdapter", "limitSeq " + this.RHs);
    if (this.RHy != null) {
      this.RHy.m(this.RHs, this.RHt, paramBoolean);
    }
    AppMethodBeat.o(99864);
  }
  
  public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(309401);
    Log.d("MicroMsg.SnsAlbumAdapter", "onCreateViewHolder %s", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 1) {
      paramViewGroup = new c(LayoutInflater.from(paramViewGroup.getContext()).inflate(b.g.sns_album_item_loading_layout, paramViewGroup, false));
    }
    for (;;)
    {
      AppMethodBeat.o(309401);
      return paramViewGroup;
      if (paramInt == 2) {
        paramViewGroup = new e(LayoutInflater.from(paramViewGroup.getContext()).inflate(b.g.sns_album_item_timeline_layout, paramViewGroup, false));
      } else {
        paramViewGroup = new f(LayoutInflater.from(paramViewGroup.getContext()).inflate(b.g.sns_album_item_layout, paramViewGroup, false));
      }
    }
  }
  
  public final void baV(String paramString)
  {
    AppMethodBeat.i(99861);
    Log.d("MicroMsg.SnsAlbumAdapter", "snsactivty onIsDownAll ");
    this.wHe = true;
    this.vEv = paramString;
    AppMethodBeat.o(99861);
  }
  
  public final void d(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(309406);
    Log.d("MicroMsg.SnsAlbumAdapter", "onBindViewHolder %s", new Object[] { Integer.valueOf(paramInt) });
    if ((paramv instanceof c))
    {
      paramv = (c)paramv;
      Log.d("MicroMsg.SnsAlbumAdapter", "SnsAlbumLoadingHolder onBind");
      if (paramv.RHB.wHe)
      {
        paramv.RHD.setVisibility(0);
        paramv.RHD.baw(paramv.RHB.vEv);
        AppMethodBeat.o(309406);
        return;
      }
      paramv.RHD.setVisibility(0);
      AppMethodBeat.o(309406);
      return;
    }
    Object localObject2;
    Object localObject1;
    if ((paramv instanceof f))
    {
      localObject2 = (f)paramv;
      localObject1 = (a.b)((f)localObject2).RHB.RHq.get(paramInt);
      if (paramInt <= 1) {
        break label672;
      }
    }
    label646:
    label672:
    for (paramv = (a.b)((f)localObject2).RHB.RHq.get(paramInt - 1);; paramv = null)
    {
      int i = ((SnsInfo)((a.b)localObject1).RHC.get(0)).getHead();
      if (paramv == null)
      {
        paramInt = 0;
        int j = i / 10000;
        int k = paramInt / 10000;
        Log.d("MicroMsg.SnsAlbumAdapter", "handleDateTv prehead=%s head=%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        if (((paramInt != 0) || (j == bp.getYear())) && ((paramInt == 0) || (j == k))) {
          break label585;
        }
        paramv = String.format(((f)localObject2).RHB.mContext.getResources().getString(b.j.sns_user_date_year), new Object[] { Integer.valueOf(j) });
        ((f)localObject2).pIJ.setText(paramv);
        ((f)localObject2).pIJ.setVisibility(0);
        paramv = ((f)localObject2).caK.getLayoutParams();
        if ((paramv instanceof ViewGroup.MarginLayoutParams))
        {
          paramv = (ViewGroup.MarginLayoutParams)paramv;
          if (paramInt == 0) {
            break label564;
          }
          paramv.topMargin = com.tencent.mm.cd.a.fromDPToPix(((f)localObject2).pIJ.getContext(), 70);
          label336:
          ((f)localObject2).caK.setLayoutParams(paramv);
        }
        label345:
        paramv = ((a.b)localObject1).label;
        if (!paramv.contains("/")) {
          break label646;
        }
        paramv = paramv.split("/");
        if (paramv.length > 1) {
          ((f)localObject2).timeTv.setText(paramv[1]);
        }
      }
      for (;;)
      {
        ((f)localObject2).RHK.setLayoutManager(((f)localObject2).RHL);
        ((f)localObject2).RHK.setAdapter(((f)localObject2).RHJ);
        paramv = ((f)localObject2).RHJ;
        localObject1 = ((a.b)localObject1).RHC;
        paramv.RHN.clear();
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (SnsInfo)((Iterator)localObject1).next();
          Iterator localIterator = ((SnsInfo)localObject2).getTimeLine().ContentObj.Zpr.iterator();
          while (localIterator.hasNext())
          {
            dmz localdmz = (dmz)localIterator.next();
            d locald = new d();
            locald.icg = ((SnsInfo)localObject2).localid;
            locald.RHE = localdmz;
            paramv.RHN.add(locald);
          }
        }
        paramInt = ((SnsInfo)paramv.RHC.get(0)).getHead();
        break;
        label564:
        paramv.topMargin = com.tencent.mm.cd.a.bs(((f)localObject2).pIJ.getContext(), b.d.BasicPaddingSize);
        break label336;
        label585:
        ((f)localObject2).pIJ.setVisibility(8);
        paramv = ((f)localObject2).caK.getLayoutParams();
        if (!(paramv instanceof ViewGroup.MarginLayoutParams)) {
          break label345;
        }
        paramv = (ViewGroup.MarginLayoutParams)paramv;
        paramv.topMargin = com.tencent.mm.cd.a.bs(((f)localObject2).pIJ.getContext(), b.d.BasicPaddingSize);
        ((f)localObject2).caK.setLayoutParams(paramv);
        break label345;
        ((f)localObject2).timeTv.setText(paramv);
      }
      paramv.bZE.notifyChanged();
      AppMethodBeat.o(309406);
      return;
    }
  }
  
  public final ArrayList<bzi> dj(int paramInt, String paramString)
  {
    AppMethodBeat.i(99865);
    Log.d("MicroMsg.SnsAlbumAdapter", "snsLocalId=%s", new Object[] { Integer.valueOf(paramInt) });
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.RHq.size())
    {
      Iterator localIterator1 = ((a.b)this.RHq.get(i)).RHC.iterator();
      while (localIterator1.hasNext())
      {
        SnsInfo localSnsInfo = (SnsInfo)localIterator1.next();
        int k = localSnsInfo.localid;
        if ((localSnsInfo.getTimeLine() != null) && (localSnsInfo.getTimeLine().ContentObj != null) && (localSnsInfo.getTimeLine().ContentObj.Zpr.size() != 0) && ((localSnsInfo.getTimeLine().ContentObj.Zpq == 1) || (localSnsInfo.getTimeLine().ContentObj.Zpq == 15)))
        {
          if (k == paramInt)
          {
            Log.d("MicroMsg.SnsAlbumAdapter", "mFixPosition=%s", new Object[] { Integer.valueOf(this.RHw) });
            this.RHw = localArrayList.size();
          }
          Iterator localIterator2 = localSnsInfo.getTimeLine().ContentObj.Zpr.iterator();
          int j = 0;
          while (localIterator2.hasNext())
          {
            dmz localdmz = (dmz)localIterator2.next();
            if (Util.isEqual(localdmz.Id, paramString)) {
              this.RHw += j;
            }
            bzi localbzi = new bzi();
            localbzi.ibT = localdmz;
            localbzi.parentId = ai.bF("sns_table_", k);
            localbzi.createTime = localSnsInfo.getCreateTime();
            localbzi.aaiz = j;
            localArrayList.add(localbzi);
            j += 1;
          }
        }
      }
      i += 1;
    }
    AppMethodBeat.o(99865);
    return localArrayList;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(99860);
    int i = this.RHq.size();
    AppMethodBeat.o(99860);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(99857);
    if ("loading".equals(((a.b)this.RHq.get(paramInt)).label)) {
      paramInt = 1;
    }
    for (;;)
    {
      AppMethodBeat.o(99857);
      return paramInt;
      if ("my_timeline".equals(((a.b)this.RHq.get(paramInt)).label)) {
        paramInt = 2;
      } else {
        paramInt = 0;
      }
    }
  }
  
  public final void hpl()
  {
    AppMethodBeat.i(99862);
    Log.d("MicroMsg.SnsAlbumAdapter", "i addSize ");
    List localList;
    if (this.RHq.size() > 1)
    {
      localList = ((a.b)this.RHq.get(this.RHq.size() - 2)).RHC;
      if (localList.isEmpty()) {}
    }
    for (long l = ((SnsInfo)localList.get(localList.size() - 1)).field_snsId;; l = 0L)
    {
      vs(l);
      AppMethodBeat.o(99862);
      return;
    }
  }
  
  public final void vr(long paramLong)
  {
    if (0L != this.RHu) {
      return;
    }
    this.RHu = paramLong;
    this.RHv = 0L;
  }
  
  public static abstract interface a
  {
    public abstract void kR(List<a.b> paramList);
  }
  
  final class c
    extends RecyclerView.v
  {
    LoadingMoreView RHD;
    
    public c(View paramView)
    {
      super();
      AppMethodBeat.i(99852);
      this.RHD = null;
      this.RHD = ((LoadingMoreView)paramView.findViewById(b.f.sns_album_item_loading_view));
      AppMethodBeat.o(99852);
    }
  }
  
  public static final class d
  {
    public dmz RHE = null;
    public int icg = 0;
  }
  
  final class e
    extends RecyclerView.v
  {
    private TextView RHF;
    private WeImageView RHG;
    
    public e(View paramView)
    {
      super();
      AppMethodBeat.i(99854);
      this.RHF = null;
      this.RHG = null;
      this.RHF = ((TextView)paramView.findViewById(b.f.album_sns_my_timeline_tv));
      boolean bool = aj.hgc();
      paramView = (ImageView)paramView.findViewById(b.f.dot_iv);
      if (paramView != null) {
        if (!bool) {
          break label93;
        }
      }
      label93:
      for (int i = 0;; i = 8)
      {
        paramView.setVisibility(i);
        this.RHF.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(99853);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/album/SnsAlbumAdapter$SnsAlbumTimelineHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            a.f(a.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/album/SnsAlbumAdapter$SnsAlbumTimelineHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99853);
          }
        });
        AppMethodBeat.o(99854);
        return;
      }
    }
  }
  
  final class f
    extends RecyclerView.v
  {
    c RHJ;
    RecyclerView RHK;
    GridLayoutManager RHL;
    private LinearLayout Rwm;
    TextView pIJ;
    TextView timeTv;
    
    public f(View paramView)
    {
      super();
      AppMethodBeat.i(99855);
      this.RHJ = null;
      this.pIJ = null;
      this.timeTv = null;
      this.RHK = null;
      this.RHL = null;
      this.Rwm = null;
      this.pIJ = ((TextView)paramView.findViewById(b.f.sns_album_item_date_tv));
      this.pIJ.setTextSize(0, a.d(a.this).getResources().getDimension(b.d.BiggerTextSize));
      this.timeTv = ((TextView)paramView.findViewById(b.f.sns_album_item_time_tv));
      this.timeTv.setTextSize(0, a.d(a.this).getResources().getDimension(b.d.BiggerTextSize));
      this.RHK = ((RecyclerView)paramView.findViewById(b.f.sns_album_item_recycler));
      a.d(a.this);
      this.RHL = new GridLayoutManager(3);
      this.RHJ = new c();
      this.RHJ.RHO = a.e(a.this);
      AppMethodBeat.o(99855);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.album.a
 * JD-Core Version:    0.7.0.1
 */