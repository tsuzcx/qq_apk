package com.tencent.mm.plugin.sns.ui.album;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.plugin.sns.ui.LoadingMoreView;
import com.tencent.mm.plugin.sns.ui.ax;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abx;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends RecyclerView.a
{
  String eaX;
  Context mContext;
  private String mQn;
  private boolean rHl;
  private final int sea;
  private final int seb;
  private final int sec;
  List<a.b> sed;
  String see;
  String sef;
  boolean seg;
  private long seh;
  private long sei;
  int sej;
  boolean sek;
  int sel;
  private b sem;
  c.a sen;
  a.a seo;
  
  public a(Context paramContext, String paramString, a.a parama)
  {
    AppMethodBeat.i(39966);
    this.sea = 0;
    this.seb = 1;
    this.sec = 2;
    this.sed = new ArrayList();
    this.mContext = null;
    this.mQn = null;
    this.see = "";
    this.sef = "";
    this.eaX = "";
    this.rHl = false;
    this.seg = false;
    this.seh = 0L;
    this.sei = 0L;
    this.sej = 0;
    this.sek = false;
    this.sel = 0;
    this.sem = null;
    this.sen = null;
    this.seo = null;
    this.mContext = paramContext;
    this.seo = parama;
    parama = aa.f(this.mContext.getSharedPreferences(ah.dsP(), 0));
    ab.d("MicroMsg.SnsAlbumAdapter", "filterLan temp ".concat(String.valueOf(parama)));
    paramContext = parama;
    if (!parama.equals("zh_CN"))
    {
      paramContext = parama;
      if (!parama.equals("en"))
      {
        if (!parama.equals("zh_TW")) {
          break label291;
        }
        paramContext = parama;
      }
    }
    for (;;)
    {
      this.mQn = paramContext;
      this.eaX = paramString;
      g.RM();
      paramContext = (String)g.RL().Ru().get(2, null);
      if (this.eaX.equals(paramContext)) {
        this.rHl = true;
      }
      this.sem = new b(new a.1(this), this.eaX, this.rHl);
      mf(0L);
      ab.d("MicroMsg.SnsAlbumAdapter", "limitId=%s", new Object[] { this.sef });
      lE(false);
      AppMethodBeat.o(39966);
      return;
      label291:
      if (parama.equals("zh_HK")) {
        paramContext = "zh_TW";
      } else {
        paramContext = "en";
      }
    }
  }
  
  private void mf(long paramLong)
  {
    AppMethodBeat.i(39973);
    ag.coV();
    Object localObject = i.lr(ag.cpf().d(paramLong, this.eaX, this.rHl));
    if (this.see.equals("")) {}
    for (;;)
    {
      this.sef = ((String)localObject);
      localObject = ag.cpj().abz(this.eaX).csy();
      if (((abx)localObject).wSq != 0L) {
        break;
      }
      AppMethodBeat.o(39973);
      return;
      if (((String)localObject).compareTo(this.see) >= 0) {
        localObject = this.see;
      }
    }
    localObject = i.lr(((abx)localObject).wSq);
    if (this.sef.equals(""))
    {
      this.sef = ((String)localObject);
      AppMethodBeat.o(39973);
      return;
    }
    ab.d("MicroMsg.SnsAlbumAdapter", "updateLimieSeq getListId=%s mLimitSeq=%s", new Object[] { Long.valueOf(paramLong), this.sef });
    if (((String)localObject).compareTo(this.sef) > 0) {}
    for (;;)
    {
      this.sef = ((String)localObject);
      AppMethodBeat.o(39973);
      return;
      localObject = this.sef;
    }
  }
  
  public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(39968);
    ab.d("MicroMsg.SnsAlbumAdapter", "onCreateViewHolder %s", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 1) {
      paramViewGroup = new a.c(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2130970802, paramViewGroup, false));
    }
    for (;;)
    {
      AppMethodBeat.o(39968);
      return paramViewGroup;
      if (paramInt == 2) {
        paramViewGroup = new a.e(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2130970804, paramViewGroup, false));
      } else {
        paramViewGroup = new a.f(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2130970801, paramViewGroup, false));
      }
    }
  }
  
  public final void a(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(39969);
    ab.d("MicroMsg.SnsAlbumAdapter", "onBindViewHolder %s", new Object[] { Integer.valueOf(paramInt) });
    if ((paramv instanceof a.c))
    {
      paramv = (a.c)paramv;
      ab.d("MicroMsg.SnsAlbumAdapter", "SnsAlbumLoadingHolder onBind");
      if (paramv.sep.sek)
      {
        paramv.ser.setVisibility(0);
        paramv.ser.lu(false);
        AppMethodBeat.o(39969);
        return;
      }
      paramInt = paramv.sep.sel;
      ag.coV();
      if (paramInt >= 30)
      {
        paramv.ser.setVisibility(0);
        AppMethodBeat.o(39969);
        return;
      }
      paramv.ser.setVisibility(8);
      AppMethodBeat.o(39969);
      return;
    }
    Object localObject2;
    Object localObject1;
    if ((paramv instanceof a.f))
    {
      localObject2 = (a.f)paramv;
      localObject1 = (a.b)((a.f)localObject2).sep.sed.get(paramInt);
      if (paramInt <= 1) {
        break label701;
      }
    }
    label675:
    label701:
    for (paramv = (a.b)((a.f)localObject2).sep.sed.get(paramInt - 1);; paramv = null)
    {
      int i = ((n)((a.b)localObject1).seq.get(0)).field_head;
      if (paramv == null)
      {
        paramInt = 0;
        int j = i / 10000;
        int k = paramInt / 10000;
        ab.d("MicroMsg.SnsAlbumAdapter", "handleDateTv prehead=%s head=%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        if (((paramInt != 0) || (j == ax.getYear())) && ((paramInt == 0) || (j == k))) {
          break label614;
        }
        paramv = String.format(((a.f)localObject2).sep.mContext.getResources().getString(2131304040), new Object[] { Integer.valueOf(j) });
        ((a.f)localObject2).gpp.setText(paramv);
        ((a.f)localObject2).gpp.setVisibility(0);
        paramv = ((a.f)localObject2).aku.getLayoutParams();
        if ((paramv instanceof ViewGroup.MarginLayoutParams))
        {
          paramv = (ViewGroup.MarginLayoutParams)paramv;
          if (paramInt == 0) {
            break label593;
          }
          paramv.topMargin = com.tencent.mm.cb.a.fromDPToPix(((a.f)localObject2).gpp.getContext(), 70);
          label364:
          ((a.f)localObject2).aku.setLayoutParams(paramv);
        }
        label373:
        paramv = ((a.b)localObject1).label;
        if (paramv.indexOf(":") == -1) {
          break label675;
        }
        paramv = paramv.split(":");
        if (paramv.length > 1) {
          ((a.f)localObject2).timeTv.setText(paramv[1]);
        }
      }
      for (;;)
      {
        ((a.f)localObject2).sey.setLayoutManager(((a.f)localObject2).jfY);
        ((a.f)localObject2).sey.setAdapter(((a.f)localObject2).sex);
        paramv = ((a.f)localObject2).sex;
        localObject1 = ((a.b)localObject1).seq;
        paramv.seA.clear();
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (n)((Iterator)localObject1).next();
          Iterator localIterator = ((n)localObject2).csh().xTS.wOa.iterator();
          while (localIterator.hasNext())
          {
            bcs localbcs = (bcs)localIterator.next();
            a.d locald = new a.d();
            locald.cIp = ((n)localObject2).rCV;
            locald.ses = localbcs;
            paramv.seA.add(locald);
          }
        }
        paramInt = ((n)paramv.seq.get(0)).field_head;
        break;
        label593:
        paramv.topMargin = com.tencent.mm.cb.a.ap(((a.f)localObject2).gpp.getContext(), 2131427496);
        break label364;
        label614:
        ((a.f)localObject2).gpp.setVisibility(8);
        paramv = ((a.f)localObject2).aku.getLayoutParams();
        if (!(paramv instanceof ViewGroup.MarginLayoutParams)) {
          break label373;
        }
        paramv = (ViewGroup.MarginLayoutParams)paramv;
        paramv.topMargin = com.tencent.mm.cb.a.ap(((a.f)localObject2).gpp.getContext(), 2131427496);
        ((a.f)localObject2).aku.setLayoutParams(paramv);
        break label373;
        ((a.f)localObject2).timeTv.setText(paramv);
      }
      paramv.ajb.notifyChanged();
      AppMethodBeat.o(39969);
      return;
    }
  }
  
  public final ArrayList<com.tencent.mm.plugin.sns.h.b> bh(int paramInt, String paramString)
  {
    AppMethodBeat.i(39975);
    ab.d("MicroMsg.SnsAlbumAdapter", "snsLocalId=%s", new Object[] { Integer.valueOf(paramInt) });
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.sed.size())
    {
      Iterator localIterator1 = ((a.b)this.sed.get(i)).seq.iterator();
      while (localIterator1.hasNext())
      {
        n localn = (n)localIterator1.next();
        int k = localn.rCV;
        if ((localn.csh() != null) && (localn.csh().xTS != null) && (localn.csh().xTS.wOa.size() != 0) && ((localn.csh().xTS.wNZ == 1) || (localn.csh().xTS.wNZ == 15)))
        {
          if (k == paramInt)
          {
            ab.d("MicroMsg.SnsAlbumAdapter", "mFixPosition=%s", new Object[] { Integer.valueOf(this.sej) });
            this.sej = localArrayList.size();
          }
          Iterator localIterator2 = localn.csh().xTS.wOa.iterator();
          int j = 0;
          while (localIterator2.hasNext())
          {
            bcs localbcs = (bcs)localIterator2.next();
            if (bo.isEqual(localbcs.Id, paramString)) {
              this.sej += j;
            }
            com.tencent.mm.plugin.sns.h.b localb = new com.tencent.mm.plugin.sns.h.b();
            localb.cIc = localbcs;
            localb.rlJ = v.aF("sns_table_", k);
            localb.fDT = localn.field_createTime;
            localb.rlK = j;
            localArrayList.add(localb);
            j += 1;
          }
        }
      }
      i += 1;
    }
    AppMethodBeat.o(39975);
    return localArrayList;
  }
  
  public final void cvL()
  {
    AppMethodBeat.i(39972);
    ab.d("MicroMsg.SnsAlbumAdapter", "i addSize ");
    List localList;
    if (this.sed.size() > 1)
    {
      localList = ((a.b)this.sed.get(this.sed.size() - 2)).seq;
      if (localList.isEmpty()) {}
    }
    for (long l = ((n)localList.get(localList.size() - 1)).field_snsId;; l = 0L)
    {
      mf(l);
      AppMethodBeat.o(39972);
      return;
    }
  }
  
  public final void cwR()
  {
    AppMethodBeat.i(39971);
    ab.d("MicroMsg.SnsAlbumAdapter", "snsactivty onIsAll ");
    this.sek = true;
    AppMethodBeat.o(39971);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(39970);
    int i = this.sed.size();
    AppMethodBeat.o(39970);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(39967);
    if ("loading".equals(((a.b)this.sed.get(paramInt)).label)) {
      paramInt = 1;
    }
    for (;;)
    {
      AppMethodBeat.o(39967);
      return paramInt;
      if ("my_timeline".equals(((a.b)this.sed.get(paramInt)).label)) {
        paramInt = 2;
      } else {
        paramInt = 0;
      }
    }
  }
  
  public final void lE(boolean paramBoolean)
  {
    AppMethodBeat.i(39974);
    ab.d("MicroMsg.SnsAlbumAdapter", "limitSeq " + this.sef);
    if (this.sem != null) {
      this.sem.h(this.sef, this.seg, paramBoolean);
    }
    AppMethodBeat.o(39974);
  }
  
  public final void me(long paramLong)
  {
    if (0L != this.seh) {
      return;
    }
    this.seh = paramLong;
    this.sei = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.album.a
 * JD-Core Version:    0.7.0.1
 */