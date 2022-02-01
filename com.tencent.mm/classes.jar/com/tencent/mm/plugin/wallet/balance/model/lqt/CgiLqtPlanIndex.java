package com.tencent.mm.plugin.wallet.balance.model.lqt;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.protocal.protobuf.bzy;
import com.tencent.mm.protocal.protobuf.ccc;
import com.tencent.mm.protocal.protobuf.clh;
import com.tencent.mm.protocal.protobuf.cli;
import com.tencent.mm.protocal.protobuf.clj;
import com.tencent.mm.protocal.protobuf.dpp;
import com.tencent.mm.protocal.protobuf.iu;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class CgiLqtPlanIndex
  extends a<cli>
{
  public CgiLqtPlanIndex()
  {
    AppMethodBeat.i(68434);
    b.a locala = new b.a();
    locala.hQF = new clh();
    locala.hQG = new cli();
    locala.funcId = 2796;
    locala.uri = "/cgi-bin/mmpay-bin/planindex";
    locala.hQH = 0;
    locala.respCmdId = 0;
    c(locala.aDS());
    ae.i("MicroMsg.CgiLqtPlanIndex", "isfirstclick: %s");
    AppMethodBeat.o(68434);
  }
  
  public static PlanIndexParcel a(cli paramcli)
  {
    AppMethodBeat.i(68435);
    if (paramcli == null)
    {
      AppMethodBeat.o(68435);
      return null;
    }
    PlanIndexParcel localPlanIndexParcel = new PlanIndexParcel();
    localPlanIndexParcel.oGt = paramcli.oGt;
    localPlanIndexParcel.oGu = paramcli.oGu;
    Iterator localIterator1 = paramcli.Hxz.iterator();
    while (localIterator1.hasNext())
    {
      clj localclj = (clj)localIterator1.next();
      PlanItemParcel localPlanItemParcel = new PlanItemParcel();
      localPlanItemParcel.fMJ = localclj.fMJ;
      localPlanItemParcel.dPq = localclj.dPq;
      localPlanItemParcel.dlT = localclj.dlT;
      localPlanItemParcel.wSp = localclj.wSp;
      localPlanItemParcel.COw = localclj.COw;
      localPlanItemParcel.COx = localclj.COx;
      localPlanItemParcel.yhW = localclj.yhW;
      localPlanItemParcel.COC = localclj.COC;
      if (localclj.HxC != null)
      {
        localPlanItemParcel.COy = new TransTipsItemParcel();
        localPlanItemParcel.COy.COD = localclj.HxC.COD;
        localPlanItemParcel.COy.hDr = localclj.HxC.hDr;
      }
      if (localclj.HxD != null)
      {
        localPlanItemParcel.COz = new MoreRecordsParcel();
        localPlanItemParcel.COz.title = localclj.HxD.title;
        localPlanItemParcel.COz.url = localclj.HxD.url;
      }
      if (localclj.HxE != null)
      {
        localPlanItemParcel.COA = new MngPlanItemParcel();
        localPlanItemParcel.COA.COn = localclj.HxE.COn;
        localPlanItemParcel.COA.COo = localclj.HxE.COo;
        Iterator localIterator2 = localclj.HxE.HnH.iterator();
        while (localIterator2.hasNext())
        {
          Integer localInteger = (Integer)localIterator2.next();
          localPlanItemParcel.COA.COp.add(localInteger);
        }
      }
      localPlanItemParcel.COB = localclj.COB;
      localPlanItemParcel.state = localclj.state;
      localPlanItemParcel.uVs = localclj.uVs;
      localPlanIndexParcel.COq.add(localPlanItemParcel);
    }
    localPlanIndexParcel.COr = paramcli.COr;
    localPlanIndexParcel.COs = paramcli.COs;
    if (paramcli.HxA != null)
    {
      localPlanIndexParcel.COt = new BannerParcel();
      localPlanIndexParcel.COt.title = paramcli.HxA.title;
      localPlanIndexParcel.COt.url = paramcli.HxA.url;
    }
    localPlanIndexParcel.COu = paramcli.COu;
    localPlanIndexParcel.COv = paramcli.COv;
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
    public boolean COn;
    public String COo;
    public ArrayList<Integer> COp;
    
    static
    {
      AppMethodBeat.i(68416);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(68416);
    }
    
    public MngPlanItemParcel()
    {
      AppMethodBeat.i(68414);
      this.COp = new ArrayList();
      AppMethodBeat.o(68414);
    }
    
    protected MngPlanItemParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(68415);
      this.COp = new ArrayList();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.COn = bool;
        this.COo = paramParcel.readString();
        this.COp = new ArrayList();
        paramParcel.readList(this.COp, Integer.class.getClassLoader());
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
      if (this.COn) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        paramParcel.writeString(this.COo);
        paramParcel.writeList(this.COp);
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
    public ArrayList<CgiLqtPlanIndex.PlanItemParcel> COq;
    public long COr;
    public String COs;
    public CgiLqtPlanIndex.BannerParcel COt;
    public String COu;
    public String COv;
    public int oGt;
    public String oGu;
    
    static
    {
      AppMethodBeat.i(68425);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(68425);
    }
    
    public PlanIndexParcel()
    {
      AppMethodBeat.i(68423);
      this.COq = new ArrayList();
      AppMethodBeat.o(68423);
    }
    
    protected PlanIndexParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(68424);
      this.COq = new ArrayList();
      this.oGt = paramParcel.readInt();
      this.oGu = paramParcel.readString();
      this.COq = new ArrayList();
      paramParcel.readList(this.COq, CgiLqtPlanIndex.PlanItemParcel.class.getClassLoader());
      this.COr = paramParcel.readLong();
      this.COs = paramParcel.readString();
      this.COt = ((CgiLqtPlanIndex.BannerParcel)paramParcel.readParcelable(CgiLqtPlanIndex.BannerParcel.class.getClassLoader()));
      this.COu = paramParcel.readString();
      this.COv = paramParcel.readString();
      AppMethodBeat.o(68424);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(68422);
      paramParcel.writeInt(this.oGt);
      paramParcel.writeString(this.oGu);
      paramParcel.writeList(this.COq);
      paramParcel.writeLong(this.COr);
      paramParcel.writeString(this.COs);
      paramParcel.writeParcelable(this.COt, paramInt);
      paramParcel.writeString(this.COu);
      paramParcel.writeString(this.COv);
      AppMethodBeat.o(68422);
    }
  }
  
  public static class PlanItemParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<PlanItemParcel> CREATOR;
    public CgiLqtPlanIndex.MngPlanItemParcel COA;
    public int COB;
    public String COC;
    public String COw;
    public String COx;
    public CgiLqtPlanIndex.TransTipsItemParcel COy;
    public CgiLqtPlanIndex.MoreRecordsParcel COz;
    public long dPq;
    public String dlT;
    public int fMJ;
    public int state;
    public String uVs;
    public String wSp;
    public String yhW;
    
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
      this.fMJ = paramParcel.readInt();
      this.dPq = paramParcel.readLong();
      this.dlT = paramParcel.readString();
      this.wSp = paramParcel.readString();
      this.COw = paramParcel.readString();
      this.COx = paramParcel.readString();
      this.COy = ((CgiLqtPlanIndex.TransTipsItemParcel)paramParcel.readParcelable(CgiLqtPlanIndex.TransTipsItemParcel.class.getClassLoader()));
      this.COz = ((CgiLqtPlanIndex.MoreRecordsParcel)paramParcel.readParcelable(CgiLqtPlanIndex.MoreRecordsParcel.class.getClassLoader()));
      this.COA = ((CgiLqtPlanIndex.MngPlanItemParcel)paramParcel.readParcelable(CgiLqtPlanIndex.MngPlanItemParcel.class.getClassLoader()));
      this.COB = paramParcel.readInt();
      this.state = paramParcel.readInt();
      this.uVs = paramParcel.readString();
      this.yhW = paramParcel.readString();
      this.COC = paramParcel.readString();
      AppMethodBeat.o(68428);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(68427);
      paramParcel.writeInt(this.fMJ);
      paramParcel.writeLong(this.dPq);
      paramParcel.writeString(this.dlT);
      paramParcel.writeString(this.wSp);
      paramParcel.writeString(this.COw);
      paramParcel.writeString(this.COx);
      paramParcel.writeParcelable(this.COy, paramInt);
      paramParcel.writeParcelable(this.COz, paramInt);
      paramParcel.writeParcelable(this.COA, paramInt);
      paramParcel.writeInt(this.COB);
      paramParcel.writeInt(this.state);
      paramParcel.writeString(this.uVs);
      paramParcel.writeString(this.yhW);
      paramParcel.writeString(this.COC);
      AppMethodBeat.o(68427);
    }
  }
  
  public static class TransTipsItemParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<TransTipsItemParcel> CREATOR;
    public String COD;
    public String hDr;
    
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
      this.COD = paramParcel.readString();
      this.hDr = paramParcel.readString();
      AppMethodBeat.o(68432);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(68431);
      paramParcel.writeString(this.COD);
      paramParcel.writeString(this.hDr);
      AppMethodBeat.o(68431);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.CgiLqtPlanIndex
 * JD-Core Version:    0.7.0.1
 */