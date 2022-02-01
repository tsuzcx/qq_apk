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
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.aq.a;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.plugin.sns.ui.LoadingMoreView;
import com.tencent.mm.plugin.sns.ui.bm;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.ami;
import com.tencent.mm.protocal.protobuf.cnb;
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
  private final int ESX;
  private final int ESY;
  private final int ESZ;
  List<a.b> ETa;
  String ETb;
  String ETc;
  boolean ETd;
  private long ETe;
  private long ETf;
  int ETg;
  private int ETh;
  private b ETi;
  c.a ETj;
  private a ETk;
  private boolean EqY;
  private String goe;
  private Context mContext;
  private String ppP;
  private boolean qhf;
  private String wUp;
  
  public a(Context paramContext, String paramString, a parama)
  {
    AppMethodBeat.i(99856);
    this.ESX = 0;
    this.ESY = 1;
    this.ESZ = 2;
    this.ETa = new ArrayList();
    this.mContext = null;
    this.wUp = null;
    this.ETb = "";
    this.ETc = "";
    this.goe = "";
    this.EqY = false;
    this.ETd = false;
    this.ETe = 0L;
    this.ETf = 0L;
    this.ETg = 0;
    this.qhf = false;
    this.ppP = "";
    this.ETh = 0;
    this.ETi = null;
    this.ETj = null;
    this.ETk = null;
    this.mContext = paramContext;
    this.ETk = parama;
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
      this.wUp = paramContext;
      this.goe = paramString;
      g.aAi();
      paramContext = (String)g.aAh().azQ().get(2, null);
      if (this.goe.equals(paramContext)) {
        this.EqY = true;
      }
      this.ETi = new b(new b.a()
      {
        public final void hg(List<a.b> paramAnonymousList)
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
            a.this.atj.notifyChanged();
            if (a.c(a.this) != null) {
              a.c(a.this).hh(paramAnonymousList);
            }
            AppMethodBeat.o(99849);
            return;
          }
        }
      }, this.goe, this.EqY);
      JS(0L);
      Log.d("MicroMsg.SnsAlbumAdapter", "limitId=%s", new Object[] { this.ETc });
      vw(false);
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
  
  private void JS(long paramLong)
  {
    AppMethodBeat.i(99863);
    int i = aj.faE().aPn(this.goe);
    Object localObject = r.Jc(aj.faO().Y(paramLong, i));
    if (this.ETb.equals("")) {}
    for (;;)
    {
      this.ETc = ((String)localObject);
      localObject = aj.faS().aQr(this.goe).feM();
      if (((ami)localObject).Lvc != 0L) {
        break;
      }
      AppMethodBeat.o(99863);
      return;
      if (((String)localObject).compareTo(this.ETb) >= 0) {
        localObject = this.ETb;
      }
    }
    localObject = r.Jc(((ami)localObject).Lvc);
    if (this.ETc.equals(""))
    {
      this.ETc = ((String)localObject);
      AppMethodBeat.o(99863);
      return;
    }
    Log.d("MicroMsg.SnsAlbumAdapter", "updateLimieSeq getListId=%s mLimitSeq=%s", new Object[] { Long.valueOf(paramLong), this.ETc });
    if (((String)localObject).compareTo(this.ETc) > 0) {}
    for (;;)
    {
      this.ETc = ((String)localObject);
      AppMethodBeat.o(99863);
      return;
      localObject = this.ETc;
    }
  }
  
  public final void JR(long paramLong)
  {
    if (0L != this.ETe) {
      return;
    }
    this.ETe = paramLong;
    this.ETf = 0L;
  }
  
  public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(99858);
    Log.d("MicroMsg.SnsAlbumAdapter", "onCreateViewHolder %s", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 1) {
      paramViewGroup = new c(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131496410, paramViewGroup, false));
    }
    for (;;)
    {
      AppMethodBeat.o(99858);
      return paramViewGroup;
      if (paramInt == 2) {
        paramViewGroup = new e(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131496412, paramViewGroup, false));
      } else {
        paramViewGroup = new f(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131496409, paramViewGroup, false));
      }
    }
  }
  
  public final void a(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(99859);
    Log.d("MicroMsg.SnsAlbumAdapter", "onBindViewHolder %s", new Object[] { Integer.valueOf(paramInt) });
    if ((paramv instanceof c))
    {
      paramv = (c)paramv;
      Log.d("MicroMsg.SnsAlbumAdapter", "SnsAlbumLoadingHolder onBind");
      if (paramv.ETl.qhf)
      {
        paramv.ETn.setVisibility(0);
        paramv.ETn.aQU(paramv.ETl.ppP);
        AppMethodBeat.o(99859);
        return;
      }
      paramv.ETn.setVisibility(0);
      AppMethodBeat.o(99859);
      return;
    }
    Object localObject2;
    Object localObject1;
    if ((paramv instanceof f))
    {
      localObject2 = (f)paramv;
      localObject1 = (a.b)((f)localObject2).ETl.ETa.get(paramInt);
      if (paramInt <= 1) {
        break label673;
      }
    }
    label647:
    label673:
    for (paramv = (a.b)((f)localObject2).ETl.ETa.get(paramInt - 1);; paramv = null)
    {
      int i = ((SnsInfo)((a.b)localObject1).ETm.get(0)).getHead();
      if (paramv == null)
      {
        paramInt = 0;
        int j = i / 10000;
        int k = paramInt / 10000;
        Log.d("MicroMsg.SnsAlbumAdapter", "handleDateTv prehead=%s head=%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        if (((paramInt != 0) || (j == bm.getYear())) && ((paramInt == 0) || (j == k))) {
          break label586;
        }
        paramv = String.format(((f)localObject2).ETl.mContext.getResources().getString(2131766301), new Object[] { Integer.valueOf(j) });
        ((f)localObject2).jUO.setText(paramv);
        ((f)localObject2).jUO.setVisibility(0);
        paramv = ((f)localObject2).aus.getLayoutParams();
        if ((paramv instanceof ViewGroup.MarginLayoutParams))
        {
          paramv = (ViewGroup.MarginLayoutParams)paramv;
          if (paramInt == 0) {
            break label565;
          }
          paramv.topMargin = com.tencent.mm.cb.a.fromDPToPix(((f)localObject2).jUO.getContext(), 70);
          label336:
          ((f)localObject2).aus.setLayoutParams(paramv);
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
        ((f)localObject2).ETu.setLayoutManager(((f)localObject2).opj);
        ((f)localObject2).ETu.setAdapter(((f)localObject2).ETt);
        paramv = ((f)localObject2).ETt;
        localObject1 = ((a.b)localObject1).ETm;
        paramv.ETw.clear();
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (SnsInfo)((Iterator)localObject1).next();
          Iterator localIterator = ((SnsInfo)localObject2).getTimeLine().ContentObj.LoV.iterator();
          while (localIterator.hasNext())
          {
            cnb localcnb = (cnb)localIterator.next();
            d locald = new d();
            locald.ecf = ((SnsInfo)localObject2).localid;
            locald.ETo = localcnb;
            paramv.ETw.add(locald);
          }
        }
        paramInt = ((SnsInfo)paramv.ETm.get(0)).getHead();
        break;
        label565:
        paramv.topMargin = com.tencent.mm.cb.a.aH(((f)localObject2).jUO.getContext(), 2131165190);
        break label336;
        label586:
        ((f)localObject2).jUO.setVisibility(8);
        paramv = ((f)localObject2).aus.getLayoutParams();
        if (!(paramv instanceof ViewGroup.MarginLayoutParams)) {
          break label345;
        }
        paramv = (ViewGroup.MarginLayoutParams)paramv;
        paramv.topMargin = com.tencent.mm.cb.a.aH(((f)localObject2).jUO.getContext(), 2131165190);
        ((f)localObject2).aus.setLayoutParams(paramv);
        break label345;
        ((f)localObject2).timeTv.setText(paramv);
      }
      paramv.atj.notifyChanged();
      AppMethodBeat.o(99859);
      return;
    }
  }
  
  public final void aRn(String paramString)
  {
    AppMethodBeat.i(99861);
    Log.d("MicroMsg.SnsAlbumAdapter", "snsactivty onIsDownAll ");
    this.qhf = true;
    this.ppP = paramString;
    AppMethodBeat.o(99861);
  }
  
  public final ArrayList<com.tencent.mm.plugin.sns.j.b> cv(int paramInt, String paramString)
  {
    AppMethodBeat.i(99865);
    Log.d("MicroMsg.SnsAlbumAdapter", "snsLocalId=%s", new Object[] { Integer.valueOf(paramInt) });
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.ETa.size())
    {
      Iterator localIterator1 = ((a.b)this.ETa.get(i)).ETm.iterator();
      while (localIterator1.hasNext())
      {
        SnsInfo localSnsInfo = (SnsInfo)localIterator1.next();
        int k = localSnsInfo.localid;
        if ((localSnsInfo.getTimeLine() != null) && (localSnsInfo.getTimeLine().ContentObj != null) && (localSnsInfo.getTimeLine().ContentObj.LoV.size() != 0) && ((localSnsInfo.getTimeLine().ContentObj.LoU == 1) || (localSnsInfo.getTimeLine().ContentObj.LoU == 15)))
        {
          if (k == paramInt)
          {
            Log.d("MicroMsg.SnsAlbumAdapter", "mFixPosition=%s", new Object[] { Integer.valueOf(this.ETg) });
            this.ETg = localArrayList.size();
          }
          Iterator localIterator2 = localSnsInfo.getTimeLine().ContentObj.LoV.iterator();
          int j = 0;
          while (localIterator2.hasNext())
          {
            cnb localcnb = (cnb)localIterator2.next();
            if (Util.isEqual(localcnb.Id, paramString)) {
              this.ETg += j;
            }
            com.tencent.mm.plugin.sns.j.b localb = new com.tencent.mm.plugin.sns.j.b();
            localb.ebR = localcnb;
            localb.parentId = y.bq("sns_table_", k);
            localb.iXu = localSnsInfo.getCreateTime();
            localb.DRJ = j;
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
  
  public final void fiE()
  {
    AppMethodBeat.i(99862);
    Log.d("MicroMsg.SnsAlbumAdapter", "i addSize ");
    List localList;
    if (this.ETa.size() > 1)
    {
      localList = ((a.b)this.ETa.get(this.ETa.size() - 2)).ETm;
      if (localList.isEmpty()) {}
    }
    for (long l = ((SnsInfo)localList.get(localList.size() - 1)).field_snsId;; l = 0L)
    {
      JS(l);
      AppMethodBeat.o(99862);
      return;
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(99860);
    int i = this.ETa.size();
    AppMethodBeat.o(99860);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(99857);
    if ("loading".equals(((a.b)this.ETa.get(paramInt)).label)) {
      paramInt = 1;
    }
    for (;;)
    {
      AppMethodBeat.o(99857);
      return paramInt;
      if ("my_timeline".equals(((a.b)this.ETa.get(paramInt)).label)) {
        paramInt = 2;
      } else {
        paramInt = 0;
      }
    }
  }
  
  public final void vw(boolean paramBoolean)
  {
    AppMethodBeat.i(99864);
    Log.d("MicroMsg.SnsAlbumAdapter", "limitSeq " + this.ETc);
    if (this.ETi != null) {
      this.ETi.k(this.ETc, this.ETd, paramBoolean);
    }
    AppMethodBeat.o(99864);
  }
  
  public static abstract interface a
  {
    public abstract void hh(List<a.b> paramList);
  }
  
  final class c
    extends RecyclerView.v
  {
    LoadingMoreView ETn;
    
    public c(View paramView)
    {
      super();
      AppMethodBeat.i(99852);
      this.ETn = null;
      this.ETn = ((LoadingMoreView)paramView.findViewById(2131308069));
      AppMethodBeat.o(99852);
    }
  }
  
  public static final class d
  {
    public cnb ETo = null;
    public int ecf = 0;
  }
  
  final class e
    extends RecyclerView.v
  {
    private TextView ETp;
    private WeImageView ETq;
    
    public e(View paramView)
    {
      super();
      AppMethodBeat.i(99854);
      this.ETp = null;
      this.ETq = null;
      this.ETp = ((TextView)paramView.findViewById(2131296679));
      this.ETq = ((WeImageView)paramView.findViewById(2131296678));
      this.ETp.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(99853);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/album/SnsAlbumAdapter$SnsAlbumTimelineHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
    private LinearLayout EIn;
    c ETt;
    RecyclerView ETu;
    TextView jUO;
    GridLayoutManager opj;
    TextView timeTv;
    
    public f(View paramView)
    {
      super();
      AppMethodBeat.i(99855);
      this.ETt = null;
      this.jUO = null;
      this.timeTv = null;
      this.ETu = null;
      this.opj = null;
      this.EIn = null;
      this.jUO = ((TextView)paramView.findViewById(2131308068));
      this.timeTv = ((TextView)paramView.findViewById(2131308074));
      this.ETu = ((RecyclerView)paramView.findViewById(2131308073));
      a.d(a.this);
      this.opj = new GridLayoutManager(3);
      this.ETt = new c();
      this.ETt.ETx = a.e(a.this);
      AppMethodBeat.o(99855);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.album.a
 * JD-Core Version:    0.7.0.1
 */