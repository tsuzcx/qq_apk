package com.tencent.mm.plugin.wallet.balance.model.lqt;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.c;
import com.tencent.mm.protocal.protobuf.bpy;
import com.tencent.mm.protocal.protobuf.bsb;
import com.tencent.mm.protocal.protobuf.cap;
import com.tencent.mm.protocal.protobuf.caq;
import com.tencent.mm.protocal.protobuf.car;
import com.tencent.mm.protocal.protobuf.ddo;
import com.tencent.mm.protocal.protobuf.ih;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class CgiLqtPlanIndex
  extends c<caq>
{
  public CgiLqtPlanIndex()
  {
    AppMethodBeat.i(68434);
    b.a locala = new b.a();
    locala.gUU = new cap();
    locala.gUV = new caq();
    locala.funcId = 2796;
    locala.uri = "/cgi-bin/mmpay-bin/planindex";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    ad.i("MicroMsg.CgiLqtPlanIndex", "isfirstclick: %s");
    AppMethodBeat.o(68434);
  }
  
  public static PlanIndexParcel a(caq paramcaq)
  {
    AppMethodBeat.i(68435);
    if (paramcaq == null)
    {
      AppMethodBeat.o(68435);
      return null;
    }
    PlanIndexParcel localPlanIndexParcel = new PlanIndexParcel();
    localPlanIndexParcel.ntx = paramcaq.ntx;
    localPlanIndexParcel.nty = paramcaq.nty;
    Iterator localIterator1 = paramcaq.DXb.iterator();
    while (localIterator1.hasNext())
    {
      car localcar = (car)localIterator1.next();
      PlanItemParcel localPlanItemParcel = new PlanItemParcel();
      localPlanItemParcel.foG = localcar.foG;
      localPlanItemParcel.dEb = localcar.dEb;
      localPlanItemParcel.dca = localcar.dca;
      localPlanItemParcel.uoo = localcar.uoo;
      localPlanItemParcel.zEv = localcar.zEv;
      localPlanItemParcel.zEw = localcar.zEw;
      localPlanItemParcel.vur = localcar.vur;
      localPlanItemParcel.zEB = localcar.zEB;
      if (localcar.DXe != null)
      {
        localPlanItemParcel.zEx = new TransTipsItemParcel();
        localPlanItemParcel.zEx.zEC = localcar.DXe.zEC;
        localPlanItemParcel.zEx.gHT = localcar.DXe.gHT;
      }
      if (localcar.DXf != null)
      {
        localPlanItemParcel.zEy = new MoreRecordsParcel();
        localPlanItemParcel.zEy.title = localcar.DXf.title;
        localPlanItemParcel.zEy.url = localcar.DXf.url;
      }
      if (localcar.DXg != null)
      {
        localPlanItemParcel.zEz = new MngPlanItemParcel();
        localPlanItemParcel.zEz.zEm = localcar.DXg.zEm;
        localPlanItemParcel.zEz.zEn = localcar.DXg.zEn;
        Iterator localIterator2 = localcar.DXg.DOh.iterator();
        while (localIterator2.hasNext())
        {
          Integer localInteger = (Integer)localIterator2.next();
          localPlanItemParcel.zEz.zEo.add(localInteger);
        }
      }
      localPlanItemParcel.zEA = localcar.zEA;
      localPlanItemParcel.state = localcar.state;
      localPlanItemParcel.szi = localcar.szi;
      localPlanIndexParcel.zEp.add(localPlanItemParcel);
    }
    localPlanIndexParcel.zEq = paramcaq.zEq;
    localPlanIndexParcel.zEr = paramcaq.zEr;
    if (paramcaq.DXc != null)
    {
      localPlanIndexParcel.zEs = new BannerParcel();
      localPlanIndexParcel.zEs.title = paramcaq.DXc.title;
      localPlanIndexParcel.zEs.url = paramcaq.DXc.url;
    }
    localPlanIndexParcel.zEt = paramcaq.zEt;
    localPlanIndexParcel.zEu = paramcaq.zEu;
    AppMethodBeat.o(68435);
    return localPlanIndexParcel;
  }
  
  public static class BannerParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<BannerParcel> CREATOR;
    public String title;
    public String url;
    
    static
    {
      AppMethodBeat.i(68411);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(68411);
    }
    
    public BannerParcel() {}
    
    protected BannerParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(68410);
      this.title = paramParcel.readString();
      this.url = paramParcel.readString();
      AppMethodBeat.o(68410);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(68409);
      paramParcel.writeString(this.title);
      paramParcel.writeString(this.url);
      AppMethodBeat.o(68409);
    }
  }
  
  public static class MngPlanItemParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<MngPlanItemParcel> CREATOR;
    public boolean zEm;
    public String zEn;
    public ArrayList<Integer> zEo;
    
    static
    {
      AppMethodBeat.i(68416);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(68416);
    }
    
    public MngPlanItemParcel()
    {
      AppMethodBeat.i(68414);
      this.zEo = new ArrayList();
      AppMethodBeat.o(68414);
    }
    
    protected MngPlanItemParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(68415);
      this.zEo = new ArrayList();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.zEm = bool;
        this.zEn = paramParcel.readString();
        this.zEo = new ArrayList();
        paramParcel.readList(this.zEo, Integer.class.getClassLoader());
        AppMethodBeat.o(68415);
        return;
      }
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(68413);
      if (this.zEm) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        paramParcel.writeString(this.zEn);
        paramParcel.writeList(this.zEo);
        AppMethodBeat.o(68413);
        return;
      }
    }
  }
  
  public static class MoreRecordsParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<MoreRecordsParcel> CREATOR;
    public String title;
    public String url;
    
    static
    {
      AppMethodBeat.i(68420);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(68420);
    }
    
    public MoreRecordsParcel() {}
    
    protected MoreRecordsParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(68419);
      this.title = paramParcel.readString();
      this.url = paramParcel.readString();
      AppMethodBeat.o(68419);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(68418);
      paramParcel.writeString(this.title);
      paramParcel.writeString(this.url);
      AppMethodBeat.o(68418);
    }
  }
  
  public static class PlanIndexParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<PlanIndexParcel> CREATOR;
    public int ntx;
    public String nty;
    public ArrayList<CgiLqtPlanIndex.PlanItemParcel> zEp;
    public long zEq;
    public String zEr;
    public CgiLqtPlanIndex.BannerParcel zEs;
    public String zEt;
    public String zEu;
    
    static
    {
      AppMethodBeat.i(68425);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(68425);
    }
    
    public PlanIndexParcel()
    {
      AppMethodBeat.i(68423);
      this.zEp = new ArrayList();
      AppMethodBeat.o(68423);
    }
    
    protected PlanIndexParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(68424);
      this.zEp = new ArrayList();
      this.ntx = paramParcel.readInt();
      this.nty = paramParcel.readString();
      this.zEp = new ArrayList();
      paramParcel.readList(this.zEp, CgiLqtPlanIndex.PlanItemParcel.class.getClassLoader());
      this.zEq = paramParcel.readLong();
      this.zEr = paramParcel.readString();
      this.zEs = ((CgiLqtPlanIndex.BannerParcel)paramParcel.readParcelable(CgiLqtPlanIndex.BannerParcel.class.getClassLoader()));
      this.zEt = paramParcel.readString();
      this.zEu = paramParcel.readString();
      AppMethodBeat.o(68424);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(68422);
      paramParcel.writeInt(this.ntx);
      paramParcel.writeString(this.nty);
      paramParcel.writeList(this.zEp);
      paramParcel.writeLong(this.zEq);
      paramParcel.writeString(this.zEr);
      paramParcel.writeParcelable(this.zEs, paramInt);
      paramParcel.writeString(this.zEt);
      paramParcel.writeString(this.zEu);
      AppMethodBeat.o(68422);
    }
  }
  
  public static class PlanItemParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<PlanItemParcel> CREATOR;
    public long dEb;
    public String dca;
    public int foG;
    public int state;
    public String szi;
    public String uoo;
    public String vur;
    public int zEA;
    public String zEB;
    public String zEv;
    public String zEw;
    public CgiLqtPlanIndex.TransTipsItemParcel zEx;
    public CgiLqtPlanIndex.MoreRecordsParcel zEy;
    public CgiLqtPlanIndex.MngPlanItemParcel zEz;
    
    static
    {
      AppMethodBeat.i(68429);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(68429);
    }
    
    public PlanItemParcel() {}
    
    protected PlanItemParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(68428);
      this.foG = paramParcel.readInt();
      this.dEb = paramParcel.readLong();
      this.dca = paramParcel.readString();
      this.uoo = paramParcel.readString();
      this.zEv = paramParcel.readString();
      this.zEw = paramParcel.readString();
      this.zEx = ((CgiLqtPlanIndex.TransTipsItemParcel)paramParcel.readParcelable(CgiLqtPlanIndex.TransTipsItemParcel.class.getClassLoader()));
      this.zEy = ((CgiLqtPlanIndex.MoreRecordsParcel)paramParcel.readParcelable(CgiLqtPlanIndex.MoreRecordsParcel.class.getClassLoader()));
      this.zEz = ((CgiLqtPlanIndex.MngPlanItemParcel)paramParcel.readParcelable(CgiLqtPlanIndex.MngPlanItemParcel.class.getClassLoader()));
      this.zEA = paramParcel.readInt();
      this.state = paramParcel.readInt();
      this.szi = paramParcel.readString();
      this.vur = paramParcel.readString();
      this.zEB = paramParcel.readString();
      AppMethodBeat.o(68428);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(68427);
      paramParcel.writeInt(this.foG);
      paramParcel.writeLong(this.dEb);
      paramParcel.writeString(this.dca);
      paramParcel.writeString(this.uoo);
      paramParcel.writeString(this.zEv);
      paramParcel.writeString(this.zEw);
      paramParcel.writeParcelable(this.zEx, paramInt);
      paramParcel.writeParcelable(this.zEy, paramInt);
      paramParcel.writeParcelable(this.zEz, paramInt);
      paramParcel.writeInt(this.zEA);
      paramParcel.writeInt(this.state);
      paramParcel.writeString(this.szi);
      paramParcel.writeString(this.vur);
      paramParcel.writeString(this.zEB);
      AppMethodBeat.o(68427);
    }
  }
  
  public static class TransTipsItemParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<TransTipsItemParcel> CREATOR;
    public String gHT;
    public String zEC;
    
    static
    {
      AppMethodBeat.i(68433);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(68433);
    }
    
    public TransTipsItemParcel() {}
    
    protected TransTipsItemParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(68432);
      this.zEC = paramParcel.readString();
      this.gHT = paramParcel.readString();
      AppMethodBeat.o(68432);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(68431);
      paramParcel.writeString(this.zEC);
      paramParcel.writeString(this.gHT);
      AppMethodBeat.o(68431);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.CgiLqtPlanIndex
 * JD-Core Version:    0.7.0.1
 */