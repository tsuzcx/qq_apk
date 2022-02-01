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
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.am.a;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.plugin.sns.ui.LoadingMoreView;
import com.tencent.mm.plugin.sns.ui.bg;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agu;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends RecyclerView.a
{
  private String foE;
  private Context mContext;
  private String nxK;
  private boolean ojr;
  private String svY;
  private final int yZZ;
  private boolean yzX;
  private final int zaa;
  private final int zab;
  List<a.b> zac;
  String zad;
  String zae;
  boolean zaf;
  private long zag;
  private long zah;
  int zai;
  private int zaj;
  private b zak;
  c.a zal;
  private a zam;
  
  public a(Context paramContext, String paramString, a parama)
  {
    AppMethodBeat.i(99856);
    this.yZZ = 0;
    this.zaa = 1;
    this.zab = 2;
    this.zac = new ArrayList();
    this.mContext = null;
    this.svY = null;
    this.zad = "";
    this.zae = "";
    this.foE = "";
    this.yzX = false;
    this.zaf = false;
    this.zag = 0L;
    this.zah = 0L;
    this.zai = 0;
    this.ojr = false;
    this.nxK = "";
    this.zaj = 0;
    this.zak = null;
    this.zal = null;
    this.zam = null;
    this.mContext = paramContext;
    this.zam = parama;
    parama = ab.f(this.mContext.getSharedPreferences(ai.eUX(), 0));
    ac.d("MicroMsg.SnsAlbumAdapter", "filterLan temp ".concat(String.valueOf(parama)));
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
      this.svY = paramContext;
      this.foE = paramString;
      g.agS();
      paramContext = (String)g.agR().agA().get(2, null);
      if (this.foE.equals(paramContext)) {
        this.yzX = true;
      }
      this.zak = new b(new b.a()
      {
        public final void fP(List<a.b> paramAnonymousList)
        {
          AppMethodBeat.i(99849);
          if (paramAnonymousList == null) {}
          for (int i = 0;; i = paramAnonymousList.size())
          {
            ac.d("MicroMsg.SnsAlbumAdapter", "onLoadingFinish list.size=%s", new Object[] { Integer.valueOf(i) });
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
            a.this.arg.notifyChanged();
            if (a.c(a.this) != null) {
              a.c(a.this).fQ(paramAnonymousList);
            }
            AppMethodBeat.o(99849);
            return;
          }
        }
      }, this.foE, this.yzX);
      xR(0L);
      ac.d("MicroMsg.SnsAlbumAdapter", "limitId=%s", new Object[] { this.zae });
      rp(false);
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
  
  private void xR(long paramLong)
  {
    AppMethodBeat.i(99863);
    int i = af.dHH().atV(this.foE);
    Object localObject = com.tencent.mm.plugin.sns.data.q.wX(af.dHR().S(paramLong, i));
    if (this.zad.equals("")) {}
    for (;;)
    {
      this.zae = ((String)localObject);
      localObject = af.dHV().auY(this.foE).dMm();
      if (((agu)localObject).EyT != 0L) {
        break;
      }
      AppMethodBeat.o(99863);
      return;
      if (((String)localObject).compareTo(this.zad) >= 0) {
        localObject = this.zad;
      }
    }
    localObject = com.tencent.mm.plugin.sns.data.q.wX(((agu)localObject).EyT);
    if (this.zae.equals(""))
    {
      this.zae = ((String)localObject);
      AppMethodBeat.o(99863);
      return;
    }
    ac.d("MicroMsg.SnsAlbumAdapter", "updateLimieSeq getListId=%s mLimitSeq=%s", new Object[] { Long.valueOf(paramLong), this.zae });
    if (((String)localObject).compareTo(this.zae) > 0) {}
    for (;;)
    {
      this.zae = ((String)localObject);
      AppMethodBeat.o(99863);
      return;
      localObject = this.zae;
    }
  }
  
  public final RecyclerView.w a(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(99858);
    ac.d("MicroMsg.SnsAlbumAdapter", "onCreateViewHolder %s", new Object[] { Integer.valueOf(paramInt) });
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
    ac.d("MicroMsg.SnsAlbumAdapter", "onBindViewHolder %s", new Object[] { Integer.valueOf(paramInt) });
    if ((paramw instanceof c))
    {
      paramw = (c)paramw;
      ac.d("MicroMsg.SnsAlbumAdapter", "SnsAlbumLoadingHolder onBind");
      if (paramw.zan.ojr)
      {
        paramw.zap.setVisibility(0);
        paramw.zap.avB(paramw.zan.nxK);
        AppMethodBeat.o(99859);
        return;
      }
      paramw.zap.setVisibility(0);
      AppMethodBeat.o(99859);
      return;
    }
    Object localObject2;
    Object localObject1;
    if ((paramw instanceof f))
    {
      localObject2 = (f)paramw;
      localObject1 = (a.b)((f)localObject2).zan.zac.get(paramInt);
      if (paramInt <= 1) {
        break label673;
      }
    }
    label647:
    label673:
    for (paramw = (a.b)((f)localObject2).zan.zac.get(paramInt - 1);; paramw = null)
    {
      int i = ((p)((a.b)localObject1).zao.get(0)).field_head;
      if (paramw == null)
      {
        paramInt = 0;
        int j = i / 10000;
        int k = paramInt / 10000;
        ac.d("MicroMsg.SnsAlbumAdapter", "handleDateTv prehead=%s head=%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        if (((paramInt != 0) || (j == bg.getYear())) && ((paramInt == 0) || (j == k))) {
          break label586;
        }
        paramw = String.format(((f)localObject2).zan.mContext.getResources().getString(2131764061), new Object[] { Integer.valueOf(j) });
        ((f)localObject2).iBM.setText(paramw);
        ((f)localObject2).iBM.setVisibility(0);
        paramw = ((f)localObject2).asD.getLayoutParams();
        if ((paramw instanceof ViewGroup.MarginLayoutParams))
        {
          paramw = (ViewGroup.MarginLayoutParams)paramw;
          if (paramInt == 0) {
            break label565;
          }
          paramw.topMargin = com.tencent.mm.cc.a.fromDPToPix(((f)localObject2).iBM.getContext(), 70);
          label336:
          ((f)localObject2).asD.setLayoutParams(paramw);
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
        ((f)localObject2).zaw.setLayoutManager(((f)localObject2).myg);
        ((f)localObject2).zaw.setAdapter(((f)localObject2).zav);
        paramw = ((f)localObject2).zav;
        localObject1 = ((a.b)localObject1).zao;
        paramw.zay.clear();
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (p)((Iterator)localObject1).next();
          Iterator localIterator = ((p)localObject2).dLV().FQo.Etz.iterator();
          while (localIterator.hasNext())
          {
            btz localbtz = (btz)localIterator.next();
            d locald = new d();
            locald.dwR = ((p)localObject2).yvp;
            locald.zaq = localbtz;
            paramw.zay.add(locald);
          }
        }
        paramInt = ((p)paramw.zao.get(0)).field_head;
        break;
        label565:
        paramw.topMargin = com.tencent.mm.cc.a.av(((f)localObject2).iBM.getContext(), 2131165187);
        break label336;
        label586:
        ((f)localObject2).iBM.setVisibility(8);
        paramw = ((f)localObject2).asD.getLayoutParams();
        if (!(paramw instanceof ViewGroup.MarginLayoutParams)) {
          break label345;
        }
        paramw = (ViewGroup.MarginLayoutParams)paramw;
        paramw.topMargin = com.tencent.mm.cc.a.av(((f)localObject2).iBM.getContext(), 2131165187);
        ((f)localObject2).asD.setLayoutParams(paramw);
        break label345;
        ((f)localObject2).timeTv.setText(paramw);
      }
      paramw.arg.notifyChanged();
      AppMethodBeat.o(99859);
      return;
    }
  }
  
  public final void avT(String paramString)
  {
    AppMethodBeat.i(99861);
    ac.d("MicroMsg.SnsAlbumAdapter", "snsactivty onIsDownAll ");
    this.ojr = true;
    this.nxK = paramString;
    AppMethodBeat.o(99861);
  }
  
  public final ArrayList<com.tencent.mm.plugin.sns.i.b> bX(int paramInt, String paramString)
  {
    AppMethodBeat.i(99865);
    ac.d("MicroMsg.SnsAlbumAdapter", "snsLocalId=%s", new Object[] { Integer.valueOf(paramInt) });
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.zac.size())
    {
      Iterator localIterator1 = ((a.b)this.zac.get(i)).zao.iterator();
      while (localIterator1.hasNext())
      {
        p localp = (p)localIterator1.next();
        int k = localp.yvp;
        if ((localp.dLV() != null) && (localp.dLV().FQo != null) && (localp.dLV().FQo.Etz.size() != 0) && ((localp.dLV().FQo.Ety == 1) || (localp.dLV().FQo.Ety == 15)))
        {
          if (k == paramInt)
          {
            ac.d("MicroMsg.SnsAlbumAdapter", "mFixPosition=%s", new Object[] { Integer.valueOf(this.zai) });
            this.zai = localArrayList.size();
          }
          Iterator localIterator2 = localp.dLV().FQo.Etz.iterator();
          int j = 0;
          while (localIterator2.hasNext())
          {
            btz localbtz = (btz)localIterator2.next();
            if (bs.lr(localbtz.Id, paramString)) {
              this.zai += j;
            }
            com.tencent.mm.plugin.sns.i.b localb = new com.tencent.mm.plugin.sns.i.b();
            localb.dwE = localbtz;
            localb.yav = x.bk("sns_table_", k);
            localb.hGU = localp.field_createTime;
            localb.yax = j;
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
  
  public final void dQh()
  {
    AppMethodBeat.i(99862);
    ac.d("MicroMsg.SnsAlbumAdapter", "i addSize ");
    List localList;
    if (this.zac.size() > 1)
    {
      localList = ((a.b)this.zac.get(this.zac.size() - 2)).zao;
      if (localList.isEmpty()) {}
    }
    for (long l = ((p)localList.get(localList.size() - 1)).field_snsId;; l = 0L)
    {
      xR(l);
      AppMethodBeat.o(99862);
      return;
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(99860);
    int i = this.zac.size();
    AppMethodBeat.o(99860);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(99857);
    if ("loading".equals(((a.b)this.zac.get(paramInt)).label)) {
      paramInt = 1;
    }
    for (;;)
    {
      AppMethodBeat.o(99857);
      return paramInt;
      if ("my_timeline".equals(((a.b)this.zac.get(paramInt)).label)) {
        paramInt = 2;
      } else {
        paramInt = 0;
      }
    }
  }
  
  public final void rp(boolean paramBoolean)
  {
    AppMethodBeat.i(99864);
    ac.d("MicroMsg.SnsAlbumAdapter", "limitSeq " + this.zae);
    if (this.zak != null) {
      this.zak.h(this.zae, this.zaf, paramBoolean);
    }
    AppMethodBeat.o(99864);
  }
  
  public final void xQ(long paramLong)
  {
    if (0L != this.zag) {
      return;
    }
    this.zag = paramLong;
    this.zah = 0L;
  }
  
  public static abstract interface a
  {
    public abstract void fQ(List<a.b> paramList);
  }
  
  final class c
    extends RecyclerView.w
  {
    LoadingMoreView zap;
    
    public c(View paramView)
    {
      super();
      AppMethodBeat.i(99852);
      this.zap = null;
      this.zap = ((LoadingMoreView)paramView.findViewById(2131304930));
      AppMethodBeat.o(99852);
    }
  }
  
  public static final class d
  {
    public int dwR = 0;
    public btz zaq = null;
  }
  
  final class e
    extends RecyclerView.w
  {
    private TextView zar;
    private WeImageView zas;
    
    public e(View paramView)
    {
      super();
      AppMethodBeat.i(99854);
      this.zar = null;
      this.zas = null;
      this.zar = ((TextView)paramView.findViewById(2131296602));
      this.zas = ((WeImageView)paramView.findViewById(2131296601));
      this.zar.setOnClickListener(new View.OnClickListener()
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
    extends RecyclerView.w
  {
    TextView iBM;
    GridLayoutManager myg;
    TextView timeTv;
    private LinearLayout yQn;
    c zav;
    RecyclerView zaw;
    
    public f(View paramView)
    {
      super();
      AppMethodBeat.i(99855);
      this.zav = null;
      this.iBM = null;
      this.timeTv = null;
      this.zaw = null;
      this.myg = null;
      this.yQn = null;
      this.iBM = ((TextView)paramView.findViewById(2131304929));
      this.timeTv = ((TextView)paramView.findViewById(2131304935));
      this.zaw = ((RecyclerView)paramView.findViewById(2131304934));
      a.d(a.this);
      this.myg = new GridLayoutManager(3);
      this.zav = new c();
      this.zav.zaz = a.e(a.this);
      AppMethodBeat.o(99855);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.album.a
 * JD-Core Version:    0.7.0.1
 */