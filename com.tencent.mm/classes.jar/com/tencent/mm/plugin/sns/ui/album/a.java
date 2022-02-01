package com.tencent.mm.plugin.sns.ui.album;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
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
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.ap.a;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.plugin.sns.ui.LoadingMoreView;
import com.tencent.mm.plugin.sns.ui.bo;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.anj;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends RecyclerView.a
{
  private String BGl;
  private boolean KEq;
  private final int LgY;
  private final int LgZ;
  private final int Lha;
  List<b> Lhb;
  String Lhc;
  String Lhd;
  boolean Lhe;
  private long Lhf;
  private long Lhg;
  int Lhh;
  private int Lhi;
  private b Lhj;
  c.a Lhk;
  private a Lhl;
  private String iSn;
  private Context mContext;
  private String syO;
  private boolean tDb;
  
  public a(Context paramContext, String paramString, a parama)
  {
    AppMethodBeat.i(99856);
    this.LgY = 0;
    this.LgZ = 1;
    this.Lha = 2;
    this.Lhb = new ArrayList();
    this.mContext = null;
    this.BGl = null;
    this.Lhc = "";
    this.Lhd = "";
    this.iSn = "";
    this.KEq = false;
    this.Lhe = false;
    this.Lhf = 0L;
    this.Lhg = 0L;
    this.Lhh = 0;
    this.tDb = false;
    this.syO = "";
    this.Lhi = 0;
    this.Lhj = null;
    this.Lhk = null;
    this.Lhl = null;
    this.mContext = paramContext;
    this.Lhl = parama;
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
      this.BGl = paramContext;
      this.iSn = paramString;
      h.aHH();
      paramContext = (String)h.aHG().aHp().b(2, null);
      if (this.iSn.equals(paramContext)) {
        this.KEq = true;
      }
      this.Lhj = new b(new b.a()
      {
        public final void hP(List<a.b> paramAnonymousList)
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
            a.this.alc.notifyChanged();
            if (a.c(a.this) != null) {
              a.c(a.this).hQ(paramAnonymousList);
            }
            AppMethodBeat.o(99849);
            return;
          }
        }
      }, this.iSn, this.KEq);
      Rm(0L);
      Log.d("MicroMsg.SnsAlbumAdapter", "limitId=%s", new Object[] { this.Lhd });
      za(false);
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
  
  private void Rm(long paramLong)
  {
    AppMethodBeat.i(99863);
    int i = aj.fOy().baj(this.iSn);
    Object localObject = t.Qv(aj.fOI().ah(paramLong, i));
    if (this.Lhc.equals("")) {}
    for (;;)
    {
      this.Lhd = ((String)localObject);
      localObject = aj.fOM().bbr(this.iSn).fSG();
      if (((anj)localObject).SxC != 0L) {
        break;
      }
      AppMethodBeat.o(99863);
      return;
      if (((String)localObject).compareTo(this.Lhc) >= 0) {
        localObject = this.Lhc;
      }
    }
    localObject = t.Qv(((anj)localObject).SxC);
    if (this.Lhd.equals(""))
    {
      this.Lhd = ((String)localObject);
      AppMethodBeat.o(99863);
      return;
    }
    Log.d("MicroMsg.SnsAlbumAdapter", "updateLimieSeq getListId=%s mLimitSeq=%s", new Object[] { Long.valueOf(paramLong), this.Lhd });
    if (((String)localObject).compareTo(this.Lhd) > 0) {}
    for (;;)
    {
      this.Lhd = ((String)localObject);
      AppMethodBeat.o(99863);
      return;
      localObject = this.Lhd;
    }
  }
  
  public final void Rl(long paramLong)
  {
    if (0L != this.Lhf) {
      return;
    }
    this.Lhf = paramLong;
    this.Lhg = 0L;
  }
  
  public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(200256);
    Log.d("MicroMsg.SnsAlbumAdapter", "onCreateViewHolder %s", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 1) {
      paramViewGroup = new c(LayoutInflater.from(paramViewGroup.getContext()).inflate(i.g.sns_album_item_loading_layout, paramViewGroup, false));
    }
    for (;;)
    {
      AppMethodBeat.o(200256);
      return paramViewGroup;
      if (paramInt == 2) {
        paramViewGroup = new e(LayoutInflater.from(paramViewGroup.getContext()).inflate(i.g.sns_album_item_timeline_layout, paramViewGroup, false));
      } else {
        paramViewGroup = new f(LayoutInflater.from(paramViewGroup.getContext()).inflate(i.g.sns_album_item_layout, paramViewGroup, false));
      }
    }
  }
  
  public final void bcp(String paramString)
  {
    AppMethodBeat.i(99861);
    Log.d("MicroMsg.SnsAlbumAdapter", "snsactivty onIsDownAll ");
    this.tDb = true;
    this.syO = paramString;
    AppMethodBeat.o(99861);
  }
  
  public final ArrayList<com.tencent.mm.plugin.sns.j.b> cw(int paramInt, String paramString)
  {
    AppMethodBeat.i(99865);
    Log.d("MicroMsg.SnsAlbumAdapter", "snsLocalId=%s", new Object[] { Integer.valueOf(paramInt) });
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.Lhb.size())
    {
      Iterator localIterator1 = ((b)this.Lhb.get(i)).Lhn.iterator();
      while (localIterator1.hasNext())
      {
        SnsInfo localSnsInfo = (SnsInfo)localIterator1.next();
        int k = localSnsInfo.localid;
        if ((localSnsInfo.getTimeLine() != null) && (localSnsInfo.getTimeLine().ContentObj != null) && (localSnsInfo.getTimeLine().ContentObj.Sqr.size() != 0) && ((localSnsInfo.getTimeLine().ContentObj.Sqq == 1) || (localSnsInfo.getTimeLine().ContentObj.Sqq == 15)))
        {
          if (k == paramInt)
          {
            Log.d("MicroMsg.SnsAlbumAdapter", "mFixPosition=%s", new Object[] { Integer.valueOf(this.Lhh) });
            this.Lhh = localArrayList.size();
          }
          Iterator localIterator2 = localSnsInfo.getTimeLine().ContentObj.Sqr.iterator();
          int j = 0;
          while (localIterator2.hasNext())
          {
            cvt localcvt = (cvt)localIterator2.next();
            if (Util.isEqual(localcvt.Id, paramString)) {
              this.Lhh += j;
            }
            com.tencent.mm.plugin.sns.j.b localb = new com.tencent.mm.plugin.sns.j.b();
            localb.fVT = localcvt;
            localb.parentId = y.bt("sns_table_", k);
            localb.createTime = localSnsInfo.getCreateTime();
            localb.KeQ = j;
            localArrayList.add(localb);
            j += 1;
          }
        }
      }
      i += 1;
    }
    AppMethodBeat.o(99865);
    return localArrayList;
  }
  
  public final void d(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(200274);
    Log.d("MicroMsg.SnsAlbumAdapter", "onBindViewHolder %s", new Object[] { Integer.valueOf(paramInt) });
    if ((paramv instanceof c))
    {
      paramv = (c)paramv;
      Log.d("MicroMsg.SnsAlbumAdapter", "SnsAlbumLoadingHolder onBind");
      if (paramv.Lhm.tDb)
      {
        paramv.Lho.setVisibility(0);
        paramv.Lho.bbU(paramv.Lhm.syO);
        AppMethodBeat.o(200274);
        return;
      }
      paramv.Lho.setVisibility(0);
      AppMethodBeat.o(200274);
      return;
    }
    Object localObject2;
    Object localObject1;
    if ((paramv instanceof f))
    {
      localObject2 = (f)paramv;
      localObject1 = (b)((f)localObject2).Lhm.Lhb.get(paramInt);
      if (paramInt <= 1) {
        break label673;
      }
    }
    label647:
    label673:
    for (paramv = (b)((f)localObject2).Lhm.Lhb.get(paramInt - 1);; paramv = null)
    {
      int i = ((SnsInfo)((b)localObject1).Lhn.get(0)).getHead();
      if (paramv == null)
      {
        paramInt = 0;
        int j = i / 10000;
        int k = paramInt / 10000;
        Log.d("MicroMsg.SnsAlbumAdapter", "handleDateTv prehead=%s head=%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        if (((paramInt != 0) || (j == bo.getYear())) && ((paramInt == 0) || (j == k))) {
          break label586;
        }
        paramv = String.format(((f)localObject2).Lhm.mContext.getResources().getString(i.j.sns_user_date_year), new Object[] { Integer.valueOf(j) });
        ((f)localObject2).mMb.setText(paramv);
        ((f)localObject2).mMb.setVisibility(0);
        paramv = ((f)localObject2).amk.getLayoutParams();
        if ((paramv instanceof ViewGroup.MarginLayoutParams))
        {
          paramv = (ViewGroup.MarginLayoutParams)paramv;
          if (paramInt == 0) {
            break label565;
          }
          paramv.topMargin = com.tencent.mm.ci.a.fromDPToPix(((f)localObject2).mMb.getContext(), 70);
          label336:
          ((f)localObject2).amk.setLayoutParams(paramv);
        }
        label345:
        paramv = ((b)localObject1).label;
        if (paramv.indexOf(":") == -1) {
          break label647;
        }
        paramv = paramv.split(":");
        if (paramv.length > 1) {
          ((f)localObject2).timeTv.setText(paramv[1]);
        }
      }
      for (;;)
      {
        ((f)localObject2).Lhv.setLayoutManager(((f)localObject2).Lhw);
        ((f)localObject2).Lhv.setAdapter(((f)localObject2).Lhu);
        paramv = ((f)localObject2).Lhu;
        localObject1 = ((b)localObject1).Lhn;
        paramv.Lhy.clear();
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (SnsInfo)((Iterator)localObject1).next();
          Iterator localIterator = ((SnsInfo)localObject2).getTimeLine().ContentObj.Sqr.iterator();
          while (localIterator.hasNext())
          {
            cvt localcvt = (cvt)localIterator.next();
            d locald = new d();
            locald.fWh = ((SnsInfo)localObject2).localid;
            locald.Lhp = localcvt;
            paramv.Lhy.add(locald);
          }
        }
        paramInt = ((SnsInfo)paramv.Lhn.get(0)).getHead();
        break;
        label565:
        paramv.topMargin = com.tencent.mm.ci.a.aZ(((f)localObject2).mMb.getContext(), i.d.BasicPaddingSize);
        break label336;
        label586:
        ((f)localObject2).mMb.setVisibility(8);
        paramv = ((f)localObject2).amk.getLayoutParams();
        if (!(paramv instanceof ViewGroup.MarginLayoutParams)) {
          break label345;
        }
        paramv = (ViewGroup.MarginLayoutParams)paramv;
        paramv.topMargin = com.tencent.mm.ci.a.aZ(((f)localObject2).mMb.getContext(), i.d.BasicPaddingSize);
        ((f)localObject2).amk.setLayoutParams(paramv);
        break label345;
        ((f)localObject2).timeTv.setText(paramv);
      }
      paramv.alc.notifyChanged();
      AppMethodBeat.o(200274);
      return;
    }
  }
  
  public final void fWS()
  {
    AppMethodBeat.i(99862);
    Log.d("MicroMsg.SnsAlbumAdapter", "i addSize ");
    List localList;
    if (this.Lhb.size() > 1)
    {
      localList = ((b)this.Lhb.get(this.Lhb.size() - 2)).Lhn;
      if (localList.isEmpty()) {}
    }
    for (long l = ((SnsInfo)localList.get(localList.size() - 1)).field_snsId;; l = 0L)
    {
      Rm(l);
      AppMethodBeat.o(99862);
      return;
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(99860);
    int i = this.Lhb.size();
    AppMethodBeat.o(99860);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(99857);
    if ("loading".equals(((b)this.Lhb.get(paramInt)).label)) {
      paramInt = 1;
    }
    for (;;)
    {
      AppMethodBeat.o(99857);
      return paramInt;
      if ("my_timeline".equals(((b)this.Lhb.get(paramInt)).label)) {
        paramInt = 2;
      } else {
        paramInt = 0;
      }
    }
  }
  
  public final void za(boolean paramBoolean)
  {
    AppMethodBeat.i(99864);
    Log.d("MicroMsg.SnsAlbumAdapter", "limitSeq " + this.Lhd);
    if (this.Lhj != null) {
      this.Lhj.k(this.Lhd, this.Lhe, paramBoolean);
    }
    AppMethodBeat.o(99864);
  }
  
  public static abstract interface a
  {
    public abstract void hQ(List<a.b> paramList);
  }
  
  public static final class b
  {
    public List<SnsInfo> Lhn;
    public String label;
    
    public b()
    {
      AppMethodBeat.i(99850);
      this.Lhn = new ArrayList();
      this.label = "";
      AppMethodBeat.o(99850);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(99851);
      Object localObject = new StringBuilder();
      Iterator localIterator = this.Lhn.iterator();
      while (localIterator.hasNext())
      {
        SnsInfo localSnsInfo = (SnsInfo)localIterator.next();
        ((StringBuilder)localObject).append("\t[localId=").append(localSnsInfo.localid).append(", snsId=").append(localSnsInfo.field_snsId).append("\n");
      }
      localObject = this.label + "\n" + ((StringBuilder)localObject).toString();
      AppMethodBeat.o(99851);
      return localObject;
    }
  }
  
  final class c
    extends RecyclerView.v
  {
    LoadingMoreView Lho;
    
    public c(View paramView)
    {
      super();
      AppMethodBeat.i(99852);
      this.Lho = null;
      this.Lho = ((LoadingMoreView)paramView.findViewById(i.f.sns_album_item_loading_view));
      AppMethodBeat.o(99852);
    }
  }
  
  public static final class d
  {
    public cvt Lhp = null;
    public int fWh = 0;
  }
  
  final class e
    extends RecyclerView.v
  {
    private TextView Lhq;
    private WeImageView Lhr;
    
    public e(View paramView)
    {
      super();
      AppMethodBeat.i(99854);
      this.Lhq = null;
      this.Lhr = null;
      this.Lhq = ((TextView)paramView.findViewById(i.f.album_sns_my_timeline_tv));
      this.Lhr = ((WeImageView)paramView.findViewById(i.f.album_sns_my_timeline_iv));
      this.Lhq.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(99853);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/album/SnsAlbumAdapter$SnsAlbumTimelineHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          a.f(a.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/album/SnsAlbumAdapter$SnsAlbumTimelineHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99853);
        }
      });
      AppMethodBeat.o(99854);
    }
  }
  
  final class f
    extends RecyclerView.v
  {
    private LinearLayout KWp;
    c Lhu;
    RecyclerView Lhv;
    GridLayoutManager Lhw;
    TextView mMb;
    TextView timeTv;
    
    public f(View paramView)
    {
      super();
      AppMethodBeat.i(99855);
      this.Lhu = null;
      this.mMb = null;
      this.timeTv = null;
      this.Lhv = null;
      this.Lhw = null;
      this.KWp = null;
      this.mMb = ((TextView)paramView.findViewById(i.f.sns_album_item_date_tv));
      this.timeTv = ((TextView)paramView.findViewById(i.f.sns_album_item_time_tv));
      this.Lhv = ((RecyclerView)paramView.findViewById(i.f.sns_album_item_recycler));
      a.d(a.this);
      this.Lhw = new GridLayoutManager(3);
      this.Lhu = new c();
      this.Lhu.Lhz = a.e(a.this);
      AppMethodBeat.o(99855);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.album.a
 * JD-Core Version:    0.7.0.1
 */