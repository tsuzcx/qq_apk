package com.tencent.mm.plugin.sns.ui.album;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.v;
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
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.am.a;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.plugin.sns.ui.LoadingMoreView;
import com.tencent.mm.plugin.sns.ui.bg;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.afv;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends RecyclerView.a
{
  private String flk;
  private Context mContext;
  private String mVk;
  private boolean nGq;
  private String rne;
  private final int xNj;
  private final int xNk;
  private final int xNl;
  List<a.b> xNm;
  String xNn;
  String xNo;
  boolean xNp;
  private long xNq;
  private long xNr;
  int xNs;
  private int xNt;
  private b xNu;
  c.a xNv;
  private a xNw;
  private boolean xng;
  
  public a(Context paramContext, String paramString, a parama)
  {
    AppMethodBeat.i(99856);
    this.xNj = 0;
    this.xNk = 1;
    this.xNl = 2;
    this.xNm = new ArrayList();
    this.mContext = null;
    this.rne = null;
    this.xNn = "";
    this.xNo = "";
    this.flk = "";
    this.xng = false;
    this.xNp = false;
    this.xNq = 0L;
    this.xNr = 0L;
    this.xNs = 0;
    this.nGq = false;
    this.mVk = "";
    this.xNt = 0;
    this.xNu = null;
    this.xNv = null;
    this.xNw = null;
    this.mContext = paramContext;
    this.xNw = parama;
    parama = ac.f(this.mContext.getSharedPreferences(aj.eFD(), 0));
    ad.d("MicroMsg.SnsAlbumAdapter", "filterLan temp ".concat(String.valueOf(parama)));
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
      this.rne = paramContext;
      this.flk = paramString;
      g.afC();
      paramContext = (String)g.afB().afk().get(2, null);
      if (this.flk.equals(paramContext)) {
        this.xng = true;
      }
      this.xNu = new b(new b.a()
      {
        public final void fH(List<a.b> paramAnonymousList)
        {
          AppMethodBeat.i(99849);
          if (paramAnonymousList == null) {}
          for (int i = 0;; i = paramAnonymousList.size())
          {
            ad.d("MicroMsg.SnsAlbumAdapter", "onLoadingFinish list.size=%s", new Object[] { Integer.valueOf(i) });
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
            a.this.aql.notifyChanged();
            if (a.c(a.this) != null) {
              a.c(a.this).fI(paramAnonymousList);
            }
            AppMethodBeat.o(99849);
            return;
          }
        }
      }, this.flk, this.xng);
      to(0L);
      ad.d("MicroMsg.SnsAlbumAdapter", "limitId=%s", new Object[] { this.xNo });
      qr(false);
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
  
  private void to(long paramLong)
  {
    AppMethodBeat.i(99863);
    int i = af.dtk().aoJ(this.flk);
    Object localObject = com.tencent.mm.plugin.sns.data.q.su(af.dtu().P(paramLong, i));
    if (this.xNn.equals("")) {}
    for (;;)
    {
      this.xNo = ((String)localObject);
      localObject = af.dty().apP(this.flk).dxP();
      if (((afv)localObject).DfN != 0L) {
        break;
      }
      AppMethodBeat.o(99863);
      return;
      if (((String)localObject).compareTo(this.xNn) >= 0) {
        localObject = this.xNn;
      }
    }
    localObject = com.tencent.mm.plugin.sns.data.q.su(((afv)localObject).DfN);
    if (this.xNo.equals(""))
    {
      this.xNo = ((String)localObject);
      AppMethodBeat.o(99863);
      return;
    }
    ad.d("MicroMsg.SnsAlbumAdapter", "updateLimieSeq getListId=%s mLimitSeq=%s", new Object[] { Long.valueOf(paramLong), this.xNo });
    if (((String)localObject).compareTo(this.xNo) > 0) {}
    for (;;)
    {
      this.xNo = ((String)localObject);
      AppMethodBeat.o(99863);
      return;
      localObject = this.xNo;
    }
  }
  
  public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(99858);
    ad.d("MicroMsg.SnsAlbumAdapter", "onCreateViewHolder %s", new Object[] { Integer.valueOf(paramInt) });
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
  
  public final void a(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(99859);
    ad.d("MicroMsg.SnsAlbumAdapter", "onBindViewHolder %s", new Object[] { Integer.valueOf(paramInt) });
    if ((paramv instanceof c))
    {
      paramv = (c)paramv;
      ad.d("MicroMsg.SnsAlbumAdapter", "SnsAlbumLoadingHolder onBind");
      if (paramv.xNx.nGq)
      {
        paramv.xNz.setVisibility(0);
        paramv.xNz.aqs(paramv.xNx.mVk);
        AppMethodBeat.o(99859);
        return;
      }
      paramv.xNz.setVisibility(0);
      AppMethodBeat.o(99859);
      return;
    }
    Object localObject2;
    Object localObject1;
    if ((paramv instanceof f))
    {
      localObject2 = (f)paramv;
      localObject1 = (a.b)((f)localObject2).xNx.xNm.get(paramInt);
      if (paramInt <= 1) {
        break label673;
      }
    }
    label647:
    label673:
    for (paramv = (a.b)((f)localObject2).xNx.xNm.get(paramInt - 1);; paramv = null)
    {
      int i = ((p)((a.b)localObject1).xNy.get(0)).field_head;
      if (paramv == null)
      {
        paramInt = 0;
        int j = i / 10000;
        int k = paramInt / 10000;
        ad.d("MicroMsg.SnsAlbumAdapter", "handleDateTv prehead=%s head=%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        if (((paramInt != 0) || (j == bg.getYear())) && ((paramInt == 0) || (j == k))) {
          break label586;
        }
        paramv = String.format(((f)localObject2).xNx.mContext.getResources().getString(2131764061), new Object[] { Integer.valueOf(j) });
        ((f)localObject2).ibF.setText(paramv);
        ((f)localObject2).ibF.setVisibility(0);
        paramv = ((f)localObject2).arI.getLayoutParams();
        if ((paramv instanceof ViewGroup.MarginLayoutParams))
        {
          paramv = (ViewGroup.MarginLayoutParams)paramv;
          if (paramInt == 0) {
            break label565;
          }
          paramv.topMargin = com.tencent.mm.cd.a.fromDPToPix(((f)localObject2).ibF.getContext(), 70);
          label336:
          ((f)localObject2).arI.setLayoutParams(paramv);
        }
        label345:
        paramv = ((a.b)localObject1).label;
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
        ((f)localObject2).xNG.setLayoutManager(((f)localObject2).lWe);
        ((f)localObject2).xNG.setAdapter(((f)localObject2).xNF);
        paramv = ((f)localObject2).xNF;
        localObject1 = ((a.b)localObject1).xNy;
        paramv.xNI.clear();
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (p)((Iterator)localObject1).next();
          Iterator localIterator = ((p)localObject2).dxy().Etm.DaC.iterator();
          while (localIterator.hasNext())
          {
            bpi localbpi = (bpi)localIterator.next();
            d locald = new d();
            locald.dzf = ((p)localObject2).xiB;
            locald.xNA = localbpi;
            paramv.xNI.add(locald);
          }
        }
        paramInt = ((p)paramv.xNy.get(0)).field_head;
        break;
        label565:
        paramv.topMargin = com.tencent.mm.cd.a.ap(((f)localObject2).ibF.getContext(), 2131165187);
        break label336;
        label586:
        ((f)localObject2).ibF.setVisibility(8);
        paramv = ((f)localObject2).arI.getLayoutParams();
        if (!(paramv instanceof ViewGroup.MarginLayoutParams)) {
          break label345;
        }
        paramv = (ViewGroup.MarginLayoutParams)paramv;
        paramv.topMargin = com.tencent.mm.cd.a.ap(((f)localObject2).ibF.getContext(), 2131165187);
        ((f)localObject2).arI.setLayoutParams(paramv);
        break label345;
        ((f)localObject2).timeTv.setText(paramv);
      }
      paramv.aql.notifyChanged();
      AppMethodBeat.o(99859);
      return;
    }
  }
  
  public final void aqK(String paramString)
  {
    AppMethodBeat.i(99861);
    ad.d("MicroMsg.SnsAlbumAdapter", "snsactivty onIsDownAll ");
    this.nGq = true;
    this.mVk = paramString;
    AppMethodBeat.o(99861);
  }
  
  public final ArrayList<com.tencent.mm.plugin.sns.j.b> bT(int paramInt, String paramString)
  {
    AppMethodBeat.i(99865);
    ad.d("MicroMsg.SnsAlbumAdapter", "snsLocalId=%s", new Object[] { Integer.valueOf(paramInt) });
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.xNm.size())
    {
      Iterator localIterator1 = ((a.b)this.xNm.get(i)).xNy.iterator();
      while (localIterator1.hasNext())
      {
        p localp = (p)localIterator1.next();
        int k = localp.xiB;
        if ((localp.dxy() != null) && (localp.dxy().Etm != null) && (localp.dxy().Etm.DaC.size() != 0) && ((localp.dxy().Etm.DaB == 1) || (localp.dxy().Etm.DaB == 15)))
        {
          if (k == paramInt)
          {
            ad.d("MicroMsg.SnsAlbumAdapter", "mFixPosition=%s", new Object[] { Integer.valueOf(this.xNs) });
            this.xNs = localArrayList.size();
          }
          Iterator localIterator2 = localp.dxy().Etm.DaC.iterator();
          int j = 0;
          while (localIterator2.hasNext())
          {
            bpi localbpi = (bpi)localIterator2.next();
            if (bt.kU(localbpi.Id, paramString)) {
              this.xNs += j;
            }
            com.tencent.mm.plugin.sns.j.b localb = new com.tencent.mm.plugin.sns.j.b();
            localb.dyS = localbpi;
            localb.wNP = x.bi("sns_table_", k);
            localb.hgr = localp.field_createTime;
            localb.wNQ = j;
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
  
  public final void dBK()
  {
    AppMethodBeat.i(99862);
    ad.d("MicroMsg.SnsAlbumAdapter", "i addSize ");
    List localList;
    if (this.xNm.size() > 1)
    {
      localList = ((a.b)this.xNm.get(this.xNm.size() - 2)).xNy;
      if (localList.isEmpty()) {}
    }
    for (long l = ((p)localList.get(localList.size() - 1)).field_snsId;; l = 0L)
    {
      to(l);
      AppMethodBeat.o(99862);
      return;
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(99860);
    int i = this.xNm.size();
    AppMethodBeat.o(99860);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(99857);
    if ("loading".equals(((a.b)this.xNm.get(paramInt)).label)) {
      paramInt = 1;
    }
    for (;;)
    {
      AppMethodBeat.o(99857);
      return paramInt;
      if ("my_timeline".equals(((a.b)this.xNm.get(paramInt)).label)) {
        paramInt = 2;
      } else {
        paramInt = 0;
      }
    }
  }
  
  public final void qr(boolean paramBoolean)
  {
    AppMethodBeat.i(99864);
    ad.d("MicroMsg.SnsAlbumAdapter", "limitSeq " + this.xNo);
    if (this.xNu != null) {
      this.xNu.g(this.xNo, this.xNp, paramBoolean);
    }
    AppMethodBeat.o(99864);
  }
  
  public final void tn(long paramLong)
  {
    if (0L != this.xNq) {
      return;
    }
    this.xNq = paramLong;
    this.xNr = 0L;
  }
  
  public static abstract interface a
  {
    public abstract void fI(List<a.b> paramList);
  }
  
  final class c
    extends RecyclerView.v
  {
    LoadingMoreView xNz;
    
    public c(View paramView)
    {
      super();
      AppMethodBeat.i(99852);
      this.xNz = null;
      this.xNz = ((LoadingMoreView)paramView.findViewById(2131304930));
      AppMethodBeat.o(99852);
    }
  }
  
  public static final class d
  {
    public int dzf = 0;
    public bpi xNA = null;
  }
  
  final class e
    extends RecyclerView.v
  {
    private TextView xNB;
    private WeImageView xNC;
    
    public e(View paramView)
    {
      super();
      AppMethodBeat.i(99854);
      this.xNB = null;
      this.xNC = null;
      this.xNB = ((TextView)paramView.findViewById(2131296602));
      this.xNC = ((WeImageView)paramView.findViewById(2131296601));
      this.xNB.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(99853);
          a.f(a.this);
          AppMethodBeat.o(99853);
        }
      });
      AppMethodBeat.o(99854);
    }
  }
  
  final class f
    extends RecyclerView.v
  {
    TextView ibF;
    GridLayoutManager lWe;
    TextView timeTv;
    private LinearLayout xDz;
    c xNF;
    RecyclerView xNG;
    
    public f(View paramView)
    {
      super();
      AppMethodBeat.i(99855);
      this.xNF = null;
      this.ibF = null;
      this.timeTv = null;
      this.xNG = null;
      this.lWe = null;
      this.xDz = null;
      this.ibF = ((TextView)paramView.findViewById(2131304929));
      this.timeTv = ((TextView)paramView.findViewById(2131304935));
      this.xNG = ((RecyclerView)paramView.findViewById(2131304934));
      a.d(a.this);
      this.lWe = new GridLayoutManager(3);
      this.xNF = new c();
      this.xNF.xNJ = a.e(a.this);
      AppMethodBeat.o(99855);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.album.a
 * JD-Core Version:    0.7.0.1
 */