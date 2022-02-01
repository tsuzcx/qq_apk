package com.tencent.mm.plugin.wallet.balance.model.lqt;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.c;
import com.tencent.mm.protocal.protobuf.bup;
import com.tencent.mm.protocal.protobuf.bws;
import com.tencent.mm.protocal.protobuf.cfo;
import com.tencent.mm.protocal.protobuf.cfp;
import com.tencent.mm.protocal.protobuf.cfq;
import com.tencent.mm.protocal.protobuf.djd;
import com.tencent.mm.protocal.protobuf.in;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class CgiLqtPlanIndex
  extends c<cfp>
{
  public CgiLqtPlanIndex()
  {
    AppMethodBeat.i(68434);
    b.a locala = new b.a();
    locala.hvt = new cfo();
    locala.hvu = new cfp();
    locala.funcId = 2796;
    locala.uri = "/cgi-bin/mmpay-bin/planindex";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    ac.i("MicroMsg.CgiLqtPlanIndex", "isfirstclick: %s");
    AppMethodBeat.o(68434);
  }
  
  public static PlanIndexParcel a(cfp paramcfp)
  {
    AppMethodBeat.i(68435);
    if (paramcfp == null)
    {
      AppMethodBeat.o(68435);
      return null;
    }
    PlanIndexParcel localPlanIndexParcel = new PlanIndexParcel();
    localPlanIndexParcel.nWx = paramcfp.nWx;
    localPlanIndexParcel.nWy = paramcfp.nWy;
    Iterator localIterator1 = paramcfp.FtU.iterator();
    while (localIterator1.hasNext())
    {
      cfq localcfq = (cfq)localIterator1.next();
      PlanItemParcel localPlanItemParcel = new PlanItemParcel();
      localPlanItemParcel.fsg = localcfq.fsg;
      localPlanItemParcel.dBN = localcfq.dBN;
      localPlanItemParcel.cZz = localcfq.cZz;
      localPlanItemParcel.vxk = localcfq.vxk;
      localPlanItemParcel.AWI = localcfq.AWI;
      localPlanItemParcel.AWJ = localcfq.AWJ;
      localPlanItemParcel.wEw = localcfq.wEw;
      localPlanItemParcel.AWO = localcfq.AWO;
      if (localcfq.FtX != null)
      {
        localPlanItemParcel.AWK = new TransTipsItemParcel();
        localPlanItemParcel.AWK.AWP = localcfq.FtX.AWP;
        localPlanItemParcel.AWK.hiu = localcfq.FtX.hiu;
      }
      if (localcfq.FtY != null)
      {
        localPlanItemParcel.AWL = new MoreRecordsParcel();
        localPlanItemParcel.AWL.title = localcfq.FtY.title;
        localPlanItemParcel.AWL.url = localcfq.FtY.url;
      }
      if (localcfq.FtZ != null)
      {
        localPlanItemParcel.AWM = new MngPlanItemParcel();
        localPlanItemParcel.AWM.AWz = localcfq.FtZ.AWz;
        localPlanItemParcel.AWM.AWA = localcfq.FtZ.AWA;
        Iterator localIterator2 = localcfq.FtZ.Fky.iterator();
        while (localIterator2.hasNext())
        {
          Integer localInteger = (Integer)localIterator2.next();
          localPlanItemParcel.AWM.AWB.add(localInteger);
        }
      }
      localPlanItemParcel.AWN = localcfq.AWN;
      localPlanItemParcel.state = localcfq.state;
      localPlanItemParcel.tGS = localcfq.tGS;
      localPlanIndexParcel.AWC.add(localPlanItemParcel);
    }
    localPlanIndexParcel.AWD = paramcfp.AWD;
    localPlanIndexParcel.AWE = paramcfp.AWE;
    if (paramcfp.FtV != null)
    {
      localPlanIndexParcel.AWF = new BannerParcel();
      localPlanIndexParcel.AWF.title = paramcfp.FtV.title;
      localPlanIndexParcel.AWF.url = paramcfp.FtV.url;
    }
    localPlanIndexParcel.AWG = paramcfp.AWG;
    localPlanIndexParcel.AWH = paramcfp.AWH;
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
    public String AWA;
    public ArrayList<Integer> AWB;
    public boolean AWz;
    
    static
    {
      AppMethodBeat.i(68416);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(68416);
    }
    
    public MngPlanItemParcel()
    {
      AppMethodBeat.i(68414);
      this.AWB = new ArrayList();
      AppMethodBeat.o(68414);
    }
    
    protected MngPlanItemParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(68415);
      this.AWB = new ArrayList();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.AWz = bool;
        this.AWA = paramParcel.readString();
        this.AWB = new ArrayList();
        paramParcel.readList(this.AWB, Integer.class.getClassLoader());
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
      if (this.AWz) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        paramParcel.writeString(this.AWA);
        paramParcel.writeList(this.AWB);
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
    public ArrayList<CgiLqtPlanIndex.PlanItemParcel> AWC;
    public long AWD;
    public String AWE;
    public CgiLqtPlanIndex.BannerParcel AWF;
    public String AWG;
    public String AWH;
    public int nWx;
    public String nWy;
    
    static
    {
      AppMethodBeat.i(68425);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(68425);
    }
    
    public PlanIndexParcel()
    {
      AppMethodBeat.i(68423);
      this.AWC = new ArrayList();
      AppMethodBeat.o(68423);
    }
    
    protected PlanIndexParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(68424);
      this.AWC = new ArrayList();
      this.nWx = paramParcel.readInt();
      this.nWy = paramParcel.readString();
      this.AWC = new ArrayList();
      paramParcel.readList(this.AWC, CgiLqtPlanIndex.PlanItemParcel.class.getClassLoader());
      this.AWD = paramParcel.readLong();
      this.AWE = paramParcel.readString();
      this.AWF = ((CgiLqtPlanIndex.BannerParcel)paramParcel.readParcelable(CgiLqtPlanIndex.BannerParcel.class.getClassLoader()));
      this.AWG = paramParcel.readString();
      this.AWH = paramParcel.readString();
      AppMethodBeat.o(68424);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(68422);
      paramParcel.writeInt(this.nWx);
      paramParcel.writeString(this.nWy);
      paramParcel.writeList(this.AWC);
      paramParcel.writeLong(this.AWD);
      paramParcel.writeString(this.AWE);
      paramParcel.writeParcelable(this.AWF, paramInt);
      paramParcel.writeString(this.AWG);
      paramParcel.writeString(this.AWH);
      AppMethodBeat.o(68422);
    }
  }
  
  public static class PlanItemParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<PlanItemParcel> CREATOR;
    public String AWI;
    public String AWJ;
    public CgiLqtPlanIndex.TransTipsItemParcel AWK;
    public CgiLqtPlanIndex.MoreRecordsParcel AWL;
    public CgiLqtPlanIndex.MngPlanItemParcel AWM;
    public int AWN;
    public String AWO;
    public String cZz;
    public long dBN;
    public int fsg;
    public int state;
    public String tGS;
    public String vxk;
    public String wEw;
    
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
      this.fsg = paramParcel.readInt();
      this.dBN = paramParcel.readLong();
      this.cZz = paramParcel.readString();
      this.vxk = paramParcel.readString();
      this.AWI = paramParcel.readString();
      this.AWJ = paramParcel.readString();
      this.AWK = ((CgiLqtPlanIndex.TransTipsItemParcel)paramParcel.readParcelable(CgiLqtPlanIndex.TransTipsItemParcel.class.getClassLoader()));
      this.AWL = ((CgiLqtPlanIndex.MoreRecordsParcel)paramParcel.readParcelable(CgiLqtPlanIndex.MoreRecordsParcel.class.getClassLoader()));
      this.AWM = ((CgiLqtPlanIndex.MngPlanItemParcel)paramParcel.readParcelable(CgiLqtPlanIndex.MngPlanItemParcel.class.getClassLoader()));
      this.AWN = paramParcel.readInt();
      this.state = paramParcel.readInt();
      this.tGS = paramParcel.readString();
      this.wEw = paramParcel.readString();
      this.AWO = paramParcel.readString();
      AppMethodBeat.o(68428);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(68427);
      paramParcel.writeInt(this.fsg);
      paramParcel.writeLong(this.dBN);
      paramParcel.writeString(this.cZz);
      paramParcel.writeString(this.vxk);
      paramParcel.writeString(this.AWI);
      paramParcel.writeString(this.AWJ);
      paramParcel.writeParcelable(this.AWK, paramInt);
      paramParcel.writeParcelable(this.AWL, paramInt);
      paramParcel.writeParcelable(this.AWM, paramInt);
      paramParcel.writeInt(this.AWN);
      paramParcel.writeInt(this.state);
      paramParcel.writeString(this.tGS);
      paramParcel.writeString(this.wEw);
      paramParcel.writeString(this.AWO);
      AppMethodBeat.o(68427);
    }
  }
  
  public static class TransTipsItemParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<TransTipsItemParcel> CREATOR;
    public String AWP;
    public String hiu;
    
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
      this.AWP = paramParcel.readString();
      this.hiu = paramParcel.readString();
      AppMethodBeat.o(68432);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(68431);
      paramParcel.writeString(this.AWP);
      paramParcel.writeString(this.hiu);
      AppMethodBeat.o(68431);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.CgiLqtPlanIndex
 * JD-Core Version:    0.7.0.1
 */