package com.tencent.mm.plugin.sns.ui.album;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.w;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.ao.a;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.plugin.sns.ui.LoadingMoreView;
import com.tencent.mm.plugin.sns.ui.bj;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.aju;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends RecyclerView.a
{
  private final int AJe;
  private final int AJf;
  private final int AJg;
  List<a.b> AJh;
  String AJi;
  String AJj;
  boolean AJk;
  private long AJl;
  private long AJm;
  int AJn;
  private int AJo;
  private b AJp;
  c.a AJq;
  private a AJr;
  private boolean Aiv;
  private String fIQ;
  private Context mContext;
  private boolean oTp;
  private String oeR;
  private String tDq;
  
  public a(Context paramContext, String paramString, a parama)
  {
    AppMethodBeat.i(99856);
    this.AJe = 0;
    this.AJf = 1;
    this.AJg = 2;
    this.AJh = new ArrayList();
    this.mContext = null;
    this.tDq = null;
    this.AJi = "";
    this.AJj = "";
    this.fIQ = "";
    this.Aiv = false;
    this.AJk = false;
    this.AJl = 0L;
    this.AJm = 0L;
    this.AJn = 0;
    this.oTp = false;
    this.oeR = "";
    this.AJo = 0;
    this.AJp = null;
    this.AJq = null;
    this.AJr = null;
    this.mContext = paramContext;
    this.AJr = parama;
    parama = ad.f(this.mContext.getSharedPreferences(ak.fow(), 0));
    ae.d("MicroMsg.SnsAlbumAdapter", "filterLan temp ".concat(String.valueOf(parama)));
    paramContext = parama;
    if (!parama.equals("zh_CN"))
    {
      paramContext = parama;
      if (!parama.equals("en"))
      {
        if (!parama.equals("zh_TW")) {
          break label297;
        }
        paramContext = parama;
      }
    }
    for (;;)
    {
      this.tDq = paramContext;
      this.fIQ = paramString;
      g.ajS();
      paramContext = (String)g.ajR().ajA().get(2, null);
      if (this.fIQ.equals(paramContext)) {
        this.Aiv = true;
      }
      this.AJp = new b(new b.a()
      {
        public final void gj(List<a.b> paramAnonymousList)
        {
          AppMethodBeat.i(99849);
          if (paramAnonymousList == null) {}
          for (int i = 0;; i = paramAnonymousList.size())
          {
            ae.d("MicroMsg.SnsAlbumAdapter", "onLoadingFinish list.size=%s", new Object[] { Integer.valueOf(i) });
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
            a.this.asY.notifyChanged();
            if (a.c(a.this) != null) {
              a.c(a.this).gk(paramAnonymousList);
            }
            AppMethodBeat.o(99849);
            return;
          }
        }
      }, this.fIQ, this.Aiv);
      AN(0L);
      ae.d("MicroMsg.SnsAlbumAdapter", "limitId=%s", new Object[] { this.AJj });
      sa(false);
      AppMethodBeat.o(99856);
      return;
      label297:
      if (parama.equals("zh_HK")) {
        paramContext = "zh_TW";
      } else {
        paramContext = "en";
      }
    }
  }
  
  private void AN(long paramLong)
  {
    AppMethodBeat.i(99863);
    int i = ah.dXu().aAr(this.fIQ);
    Object localObject = r.zW(ah.dXE().X(paramLong, i));
    if (this.AJi.equals("")) {}
    for (;;)
    {
      this.AJj = ((String)localObject);
      localObject = ah.dXI().aBw(this.fIQ).ecg();
      if (((aju)localObject).Gzo != 0L) {
        break;
      }
      AppMethodBeat.o(99863);
      return;
      if (((String)localObject).compareTo(this.AJi) >= 0) {
        localObject = this.AJi;
      }
    }
    localObject = r.zW(((aju)localObject).Gzo);
    if (this.AJj.equals(""))
    {
      this.AJj = ((String)localObject);
      AppMethodBeat.o(99863);
      return;
    }
    ae.d("MicroMsg.SnsAlbumAdapter", "updateLimieSeq getListId=%s mLimitSeq=%s", new Object[] { Long.valueOf(paramLong), this.AJj });
    if (((String)localObject).compareTo(this.AJj) > 0) {}
    for (;;)
    {
      this.AJj = ((String)localObject);
      AppMethodBeat.o(99863);
      return;
      localObject = this.AJj;
    }
  }
  
  public final void AM(long paramLong)
  {
    if (0L != this.AJl) {
      return;
    }
    this.AJl = paramLong;
    this.AJm = 0L;
  }
  
  public final RecyclerView.w a(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(99858);
    ae.d("MicroMsg.SnsAlbumAdapter", "onCreateViewHolder %s", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 1) {
      paramViewGroup = new c(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131495522, paramViewGroup, false));
    }
    for (;;)
    {
      AppMethodBeat.o(99858);
      return paramViewGroup;
      if (paramInt == 2) {
        paramViewGroup = new e(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131495524, paramViewGroup, false));
      } else {
        paramViewGroup = new f(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131495521, paramViewGroup, false));
      }
    }
  }
  
  public final void a(RecyclerView.w paramw, int paramInt)
  {
    AppMethodBeat.i(99859);
    ae.d("MicroMsg.SnsAlbumAdapter", "onBindViewHolder %s", new Object[] { Integer.valueOf(paramInt) });
    if ((paramw instanceof c))
    {
      paramw = (c)paramw;
      ae.d("MicroMsg.SnsAlbumAdapter", "SnsAlbumLoadingHolder onBind");
      if (paramw.AJs.oTp)
      {
        paramw.AJu.setVisibility(0);
        paramw.AJu.aBZ(paramw.AJs.oeR);
        AppMethodBeat.o(99859);
        return;
      }
      paramw.AJu.setVisibility(0);
      AppMethodBeat.o(99859);
      return;
    }
    Object localObject2;
    Object localObject1;
    if ((paramw instanceof f))
    {
      localObject2 = (f)paramw;
      localObject1 = (a.b)((f)localObject2).AJs.AJh.get(paramInt);
      if (paramInt <= 1) {
        break label673;
      }
    }
    label647:
    label673:
    for (paramw = (a.b)((f)localObject2).AJs.AJh.get(paramInt - 1);; paramw = null)
    {
      int i = ((p)((a.b)localObject1).AJt.get(0)).field_head;
      if (paramw == null)
      {
        paramInt = 0;
        int j = i / 10000;
        int k = paramInt / 10000;
        ae.d("MicroMsg.SnsAlbumAdapter", "handleDateTv prehead=%s head=%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        if (((paramInt != 0) || (j == bj.getYear())) && ((paramInt == 0) || (j == k))) {
          break label586;
        }
        paramw = String.format(((f)localObject2).AJs.mContext.getResources().getString(2131764061), new Object[] { Integer.valueOf(j) });
        ((f)localObject2).iXP.setText(paramw);
        ((f)localObject2).iXP.setVisibility(0);
        paramw = ((f)localObject2).auu.getLayoutParams();
        if ((paramw instanceof ViewGroup.MarginLayoutParams))
        {
          paramw = (ViewGroup.MarginLayoutParams)paramw;
          if (paramInt == 0) {
            break label565;
          }
          paramw.topMargin = com.tencent.mm.cb.a.fromDPToPix(((f)localObject2).iXP.getContext(), 70);
          label336:
          ((f)localObject2).auu.setLayoutParams(paramw);
        }
        label345:
        paramw = ((a.b)localObject1).label;
        if (paramw.indexOf(":") == -1) {
          break label647;
        }
        paramw = paramw.split(":");
        if (paramw.length > 1) {
          ((f)localObject2).timeTv.setText(paramw[1]);
        }
      }
      for (;;)
      {
        ((f)localObject2).AJB.setLayoutManager(((f)localObject2).ndV);
        ((f)localObject2).AJB.setAdapter(((f)localObject2).AJA);
        paramw = ((f)localObject2).AJA;
        localObject1 = ((a.b)localObject1).AJt;
        paramw.AJD.clear();
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (p)((Iterator)localObject1).next();
          Iterator localIterator = ((p)localObject2).ebP().HUG.Gtx.iterator();
          while (localIterator.hasNext())
          {
            bzh localbzh = (bzh)localIterator.next();
            d locald = new d();
            locald.dKr = ((p)localObject2).AdJ;
            locald.AJv = localbzh;
            paramw.AJD.add(locald);
          }
        }
        paramInt = ((p)paramw.AJt.get(0)).field_head;
        break;
        label565:
        paramw.topMargin = com.tencent.mm.cb.a.ay(((f)localObject2).iXP.getContext(), 2131165187);
        break label336;
        label586:
        ((f)localObject2).iXP.setVisibility(8);
        paramw = ((f)localObject2).auu.getLayoutParams();
        if (!(paramw instanceof ViewGroup.MarginLayoutParams)) {
          break label345;
        }
        paramw = (ViewGroup.MarginLayoutParams)paramw;
        paramw.topMargin = com.tencent.mm.cb.a.ay(((f)localObject2).iXP.getContext(), 2131165187);
        ((f)localObject2).auu.setLayoutParams(paramw);
        break label345;
        ((f)localObject2).timeTv.setText(paramw);
      }
      paramw.asY.notifyChanged();
      AppMethodBeat.o(99859);
      return;
    }
  }
  
  public final void aCr(String paramString)
  {
    AppMethodBeat.i(99861);
    ae.d("MicroMsg.SnsAlbumAdapter", "snsactivty onIsDownAll ");
    this.oTp = true;
    this.oeR = paramString;
    AppMethodBeat.o(99861);
  }
  
  public final ArrayList<com.tencent.mm.plugin.sns.i.b> ce(int paramInt, String paramString)
  {
    AppMethodBeat.i(99865);
    ae.d("MicroMsg.SnsAlbumAdapter", "snsLocalId=%s", new Object[] { Integer.valueOf(paramInt) });
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.AJh.size())
    {
      Iterator localIterator1 = ((a.b)this.AJh.get(i)).AJt.iterator();
      while (localIterator1.hasNext())
      {
        p localp = (p)localIterator1.next();
        int k = localp.AdJ;
        if ((localp.ebP() != null) && (localp.ebP().HUG != null) && (localp.ebP().HUG.Gtx.size() != 0) && ((localp.ebP().HUG.Gtw == 1) || (localp.ebP().HUG.Gtw == 15)))
        {
          if (k == paramInt)
          {
            ae.d("MicroMsg.SnsAlbumAdapter", "mFixPosition=%s", new Object[] { Integer.valueOf(this.AJn) });
            this.AJn = localArrayList.size();
          }
          Iterator localIterator2 = localp.ebP().HUG.Gtx.iterator();
          int j = 0;
          while (localIterator2.hasNext())
          {
            bzh localbzh = (bzh)localIterator2.next();
            if (bu.lX(localbzh.Id, paramString)) {
              this.AJn += j;
            }
            com.tencent.mm.plugin.sns.i.b localb = new com.tencent.mm.plugin.sns.i.b();
            localb.dKe = localbzh;
            localb.parentId = x.bo("sns_table_", k);
            localb.icw = localp.field_createTime;
            localb.zHI = j;
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
  
  public final void ege()
  {
    AppMethodBeat.i(99862);
    ae.d("MicroMsg.SnsAlbumAdapter", "i addSize ");
    List localList;
    if (this.AJh.size() > 1)
    {
      localList = ((a.b)this.AJh.get(this.AJh.size() - 2)).AJt;
      if (localList.isEmpty()) {}
    }
    for (long l = ((p)localList.get(localList.size() - 1)).field_snsId;; l = 0L)
    {
      AN(l);
      AppMethodBeat.o(99862);
      return;
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(99860);
    int i = this.AJh.size();
    AppMethodBeat.o(99860);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(99857);
    if ("loading".equals(((a.b)this.AJh.get(paramInt)).label)) {
      paramInt = 1;
    }
    for (;;)
    {
      AppMethodBeat.o(99857);
      return paramInt;
      if ("my_timeline".equals(((a.b)this.AJh.get(paramInt)).label)) {
        paramInt = 2;
      } else {
        paramInt = 0;
      }
    }
  }
  
  public final void sa(boolean paramBoolean)
  {
    AppMethodBeat.i(99864);
    ae.d("MicroMsg.SnsAlbumAdapter", "limitSeq " + this.AJj);
    if (this.AJp != null) {
      this.AJp.j(this.AJj, this.AJk, paramBoolean);
    }
    AppMethodBeat.o(99864);
  }
  
  public static abstract interface a
  {
    public abstract void gk(List<a.b> paramList);
  }
  
  final class c
    extends RecyclerView.w
  {
    LoadingMoreView AJu;
    
    public c(View paramView)
    {
      super();
      AppMethodBeat.i(99852);
      this.AJu = null;
      this.AJu = ((LoadingMoreView)paramView.findViewById(2131304930));
      AppMethodBeat.o(99852);
    }
  }
  
  public static final class d
  {
    public bzh AJv = null;
    public int dKr = 0;
  }
  
  final class e
    extends RecyclerView.w
  {
    private TextView AJw;
    private WeImageView AJx;
    
    public e(View paramView)
    {
      super();
      AppMethodBeat.i(99854);
      this.AJw = null;
      this.AJx = null;
      this.AJw = ((TextView)paramView.findViewById(2131296602));
      this.AJx = ((WeImageView)paramView.findViewById(2131296601));
      this.AJw.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(99853);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/album/SnsAlbumAdapter$SnsAlbumTimelineHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          a.f(a.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/album/SnsAlbumAdapter$SnsAlbumTimelineHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99853);
        }
      });
      AppMethodBeat.o(99854);
    }
  }
  
  final class f
    extends RecyclerView.w
  {
    c AJA;
    RecyclerView AJB;
    private LinearLayout AyV;
    TextView iXP;
    GridLayoutManager ndV;
    TextView timeTv;
    
    public f(View paramView)
    {
      super();
      AppMethodBeat.i(99855);
      this.AJA = null;
      this.iXP = null;
      this.timeTv = null;
      this.AJB = null;
      this.ndV = null;
      this.AyV = null;
      this.iXP = ((TextView)paramView.findViewById(2131304929));
      this.timeTv = ((TextView)paramView.findViewById(2131304935));
      this.AJB = ((RecyclerView)paramView.findViewById(2131304934));
      a.d(a.this);
      this.ndV = new GridLayoutManager(3);
      this.AJA = new c();
      this.AJA.AJE = a.e(a.this);
      AppMethodBeat.o(99855);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.album.a
 * JD-Core Version:    0.7.0.1
 */