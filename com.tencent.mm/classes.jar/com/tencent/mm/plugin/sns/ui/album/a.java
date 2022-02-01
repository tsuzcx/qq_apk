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
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.an.a;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.plugin.sns.ui.LoadingMoreView;
import com.tencent.mm.plugin.sns.ui.bj;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.ajk;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends RecyclerView.a
{
  private final int ArQ;
  private final int ArR;
  private final int ArS;
  List<b> ArT;
  String ArU;
  String ArV;
  boolean ArW;
  private long ArX;
  private long ArY;
  int ArZ;
  private int Asa;
  private b Asb;
  c.a Asc;
  private a Asd;
  private String fGM;
  private Context mContext;
  private String nZi;
  private boolean oMN;
  private String tsz;
  private boolean zRo;
  
  public a(Context paramContext, String paramString, a parama)
  {
    AppMethodBeat.i(99856);
    this.ArQ = 0;
    this.ArR = 1;
    this.ArS = 2;
    this.ArT = new ArrayList();
    this.mContext = null;
    this.tsz = null;
    this.ArU = "";
    this.ArV = "";
    this.fGM = "";
    this.zRo = false;
    this.ArW = false;
    this.ArX = 0L;
    this.ArY = 0L;
    this.ArZ = 0;
    this.oMN = false;
    this.nZi = "";
    this.Asa = 0;
    this.Asb = null;
    this.Asc = null;
    this.Asd = null;
    this.mContext = paramContext;
    this.Asd = parama;
    parama = ac.f(this.mContext.getSharedPreferences(aj.fkC(), 0));
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
      this.tsz = paramContext;
      this.fGM = paramString;
      g.ajD();
      paramContext = (String)g.ajC().ajl().get(2, null);
      if (this.fGM.equals(paramContext)) {
        this.zRo = true;
      }
      this.Asb = new b(new b.a()
      {
        public final void ga(List<a.b> paramAnonymousList)
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
            a.this.asY.notifyChanged();
            if (a.c(a.this) != null) {
              a.c(a.this).gb(paramAnonymousList);
            }
            AppMethodBeat.o(99849);
            return;
          }
        }
      }, this.fGM, this.zRo);
      Ap(0L);
      ad.d("MicroMsg.SnsAlbumAdapter", "limitId=%s", new Object[] { this.ArV });
      rT(false);
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
  
  private void Ap(long paramLong)
  {
    AppMethodBeat.i(99863);
    int i = ag.dTU().aza(this.fGM);
    Object localObject = com.tencent.mm.plugin.sns.data.q.zx(ag.dUe().X(paramLong, i));
    if (this.ArU.equals("")) {}
    for (;;)
    {
      this.ArV = ((String)localObject);
      localObject = ag.dUi().aAf(this.fGM).dYC();
      if (((ajk)localObject).GgF != 0L) {
        break;
      }
      AppMethodBeat.o(99863);
      return;
      if (((String)localObject).compareTo(this.ArU) >= 0) {
        localObject = this.ArU;
      }
    }
    localObject = com.tencent.mm.plugin.sns.data.q.zx(((ajk)localObject).GgF);
    if (this.ArV.equals(""))
    {
      this.ArV = ((String)localObject);
      AppMethodBeat.o(99863);
      return;
    }
    ad.d("MicroMsg.SnsAlbumAdapter", "updateLimieSeq getListId=%s mLimitSeq=%s", new Object[] { Long.valueOf(paramLong), this.ArV });
    if (((String)localObject).compareTo(this.ArV) > 0) {}
    for (;;)
    {
      this.ArV = ((String)localObject);
      AppMethodBeat.o(99863);
      return;
      localObject = this.ArV;
    }
  }
  
  public final void Ao(long paramLong)
  {
    if (0L != this.ArX) {
      return;
    }
    this.ArX = paramLong;
    this.ArY = 0L;
  }
  
  public final RecyclerView.w a(ViewGroup paramViewGroup, int paramInt)
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
  
  public final void a(RecyclerView.w paramw, int paramInt)
  {
    AppMethodBeat.i(99859);
    ad.d("MicroMsg.SnsAlbumAdapter", "onBindViewHolder %s", new Object[] { Integer.valueOf(paramInt) });
    if ((paramw instanceof c))
    {
      paramw = (c)paramw;
      ad.d("MicroMsg.SnsAlbumAdapter", "SnsAlbumLoadingHolder onBind");
      if (paramw.Ase.oMN)
      {
        paramw.Asg.setVisibility(0);
        paramw.Asg.aAI(paramw.Ase.nZi);
        AppMethodBeat.o(99859);
        return;
      }
      paramw.Asg.setVisibility(0);
      AppMethodBeat.o(99859);
      return;
    }
    Object localObject2;
    Object localObject1;
    if ((paramw instanceof f))
    {
      localObject2 = (f)paramw;
      localObject1 = (b)((f)localObject2).Ase.ArT.get(paramInt);
      if (paramInt <= 1) {
        break label673;
      }
    }
    label647:
    label673:
    for (paramw = (b)((f)localObject2).Ase.ArT.get(paramInt - 1);; paramw = null)
    {
      int i = ((p)((b)localObject1).Asf.get(0)).field_head;
      if (paramw == null)
      {
        paramInt = 0;
        int j = i / 10000;
        int k = paramInt / 10000;
        ad.d("MicroMsg.SnsAlbumAdapter", "handleDateTv prehead=%s head=%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        if (((paramInt != 0) || (j == bj.getYear())) && ((paramInt == 0) || (j == k))) {
          break label586;
        }
        paramw = String.format(((f)localObject2).Ase.mContext.getResources().getString(2131764061), new Object[] { Integer.valueOf(j) });
        ((f)localObject2).iUW.setText(paramw);
        ((f)localObject2).iUW.setVisibility(0);
        paramw = ((f)localObject2).auu.getLayoutParams();
        if ((paramw instanceof ViewGroup.MarginLayoutParams))
        {
          paramw = (ViewGroup.MarginLayoutParams)paramw;
          if (paramInt == 0) {
            break label565;
          }
          paramw.topMargin = com.tencent.mm.cc.a.fromDPToPix(((f)localObject2).iUW.getContext(), 70);
          label336:
          ((f)localObject2).auu.setLayoutParams(paramw);
        }
        label345:
        paramw = ((b)localObject1).label;
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
        ((f)localObject2).Asn.setLayoutManager(((f)localObject2).mYO);
        ((f)localObject2).Asn.setAdapter(((f)localObject2).Asm);
        paramw = ((f)localObject2).Asm;
        localObject1 = ((b)localObject1).Asf;
        paramw.Asp.clear();
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (p)((Iterator)localObject1).next();
          Iterator localIterator = ((p)localObject2).dYl().HAT.GaQ.iterator();
          while (localIterator.hasNext())
          {
            byn localbyn = (byn)localIterator.next();
            d locald = new d();
            locald.dJd = ((p)localObject2).zMC;
            locald.Ash = localbyn;
            paramw.Asp.add(locald);
          }
        }
        paramInt = ((p)paramw.Asf.get(0)).field_head;
        break;
        label565:
        paramw.topMargin = com.tencent.mm.cc.a.ay(((f)localObject2).iUW.getContext(), 2131165187);
        break label336;
        label586:
        ((f)localObject2).iUW.setVisibility(8);
        paramw = ((f)localObject2).auu.getLayoutParams();
        if (!(paramw instanceof ViewGroup.MarginLayoutParams)) {
          break label345;
        }
        paramw = (ViewGroup.MarginLayoutParams)paramw;
        paramw.topMargin = com.tencent.mm.cc.a.ay(((f)localObject2).iUW.getContext(), 2131165187);
        ((f)localObject2).auu.setLayoutParams(paramw);
        break label345;
        ((f)localObject2).timeTv.setText(paramw);
      }
      paramw.asY.notifyChanged();
      AppMethodBeat.o(99859);
      return;
    }
  }
  
  public final void aBa(String paramString)
  {
    AppMethodBeat.i(99861);
    ad.d("MicroMsg.SnsAlbumAdapter", "snsactivty onIsDownAll ");
    this.oMN = true;
    this.nZi = paramString;
    AppMethodBeat.o(99861);
  }
  
  public final ArrayList<com.tencent.mm.plugin.sns.i.b> ce(int paramInt, String paramString)
  {
    AppMethodBeat.i(99865);
    ad.d("MicroMsg.SnsAlbumAdapter", "snsLocalId=%s", new Object[] { Integer.valueOf(paramInt) });
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.ArT.size())
    {
      Iterator localIterator1 = ((b)this.ArT.get(i)).Asf.iterator();
      while (localIterator1.hasNext())
      {
        p localp = (p)localIterator1.next();
        int k = localp.zMC;
        if ((localp.dYl() != null) && (localp.dYl().HAT != null) && (localp.dYl().HAT.GaQ.size() != 0) && ((localp.dYl().HAT.GaP == 1) || (localp.dYl().HAT.GaP == 15)))
        {
          if (k == paramInt)
          {
            ad.d("MicroMsg.SnsAlbumAdapter", "mFixPosition=%s", new Object[] { Integer.valueOf(this.ArZ) });
            this.ArZ = localArrayList.size();
          }
          Iterator localIterator2 = localp.dYl().HAT.GaQ.iterator();
          int j = 0;
          while (localIterator2.hasNext())
          {
            byn localbyn = (byn)localIterator2.next();
            if (bt.lQ(localbyn.Id, paramString)) {
              this.ArZ += j;
            }
            com.tencent.mm.plugin.sns.i.b localb = new com.tencent.mm.plugin.sns.i.b();
            localb.dIQ = localbyn;
            localb.parentId = x.bn("sns_table_", k);
            localb.hZE = localp.field_createTime;
            localb.zqt = j;
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
  
  public final void ecx()
  {
    AppMethodBeat.i(99862);
    ad.d("MicroMsg.SnsAlbumAdapter", "i addSize ");
    List localList;
    if (this.ArT.size() > 1)
    {
      localList = ((b)this.ArT.get(this.ArT.size() - 2)).Asf;
      if (localList.isEmpty()) {}
    }
    for (long l = ((p)localList.get(localList.size() - 1)).field_snsId;; l = 0L)
    {
      Ap(l);
      AppMethodBeat.o(99862);
      return;
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(99860);
    int i = this.ArT.size();
    AppMethodBeat.o(99860);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(99857);
    if ("loading".equals(((b)this.ArT.get(paramInt)).label)) {
      paramInt = 1;
    }
    for (;;)
    {
      AppMethodBeat.o(99857);
      return paramInt;
      if ("my_timeline".equals(((b)this.ArT.get(paramInt)).label)) {
        paramInt = 2;
      } else {
        paramInt = 0;
      }
    }
  }
  
  public final void rT(boolean paramBoolean)
  {
    AppMethodBeat.i(99864);
    ad.d("MicroMsg.SnsAlbumAdapter", "limitSeq " + this.ArV);
    if (this.Asb != null) {
      this.Asb.j(this.ArV, this.ArW, paramBoolean);
    }
    AppMethodBeat.o(99864);
  }
  
  public static abstract interface a
  {
    public abstract void gb(List<a.b> paramList);
  }
  
  public static final class b
  {
    public List<p> Asf;
    public String label;
    
    public b()
    {
      AppMethodBeat.i(99850);
      this.Asf = new ArrayList();
      this.label = "";
      AppMethodBeat.o(99850);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(99851);
      Object localObject = new StringBuilder();
      Iterator localIterator = this.Asf.iterator();
      while (localIterator.hasNext())
      {
        p localp = (p)localIterator.next();
        ((StringBuilder)localObject).append("\t[localId=").append(localp.zMC).append(", snsId=").append(localp.field_snsId).append("\n");
      }
      localObject = this.label + "\n" + ((StringBuilder)localObject).toString();
      AppMethodBeat.o(99851);
      return localObject;
    }
  }
  
  final class c
    extends RecyclerView.w
  {
    LoadingMoreView Asg;
    
    public c(View paramView)
    {
      super();
      AppMethodBeat.i(99852);
      this.Asg = null;
      this.Asg = ((LoadingMoreView)paramView.findViewById(2131304930));
      AppMethodBeat.o(99852);
    }
  }
  
  public static final class d
  {
    public byn Ash = null;
    public int dJd = 0;
  }
  
  final class e
    extends RecyclerView.w
  {
    private TextView Asi;
    private WeImageView Asj;
    
    public e(View paramView)
    {
      super();
      AppMethodBeat.i(99854);
      this.Asi = null;
      this.Asj = null;
      this.Asi = ((TextView)paramView.findViewById(2131296602));
      this.Asj = ((WeImageView)paramView.findViewById(2131296601));
      this.Asi.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(99853);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/album/SnsAlbumAdapter$SnsAlbumTimelineHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
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
    private LinearLayout AhJ;
    c Asm;
    RecyclerView Asn;
    TextView iUW;
    GridLayoutManager mYO;
    TextView timeTv;
    
    public f(View paramView)
    {
      super();
      AppMethodBeat.i(99855);
      this.Asm = null;
      this.iUW = null;
      this.timeTv = null;
      this.Asn = null;
      this.mYO = null;
      this.AhJ = null;
      this.iUW = ((TextView)paramView.findViewById(2131304929));
      this.timeTv = ((TextView)paramView.findViewById(2131304935));
      this.Asn = ((RecyclerView)paramView.findViewById(2131304934));
      a.d(a.this);
      this.mYO = new GridLayoutManager(3);
      this.Asm = new c();
      this.Asm.Asq = a.e(a.this);
      AppMethodBeat.o(99855);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.album.a
 * JD-Core Version:    0.7.0.1
 */