package com.tencent.mm.plugin.wallet.balance.model.lqt;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.c;
import com.tencent.mm.protocal.protobuf.bup;
import com.tencent.mm.protocal.protobuf.cfq;
import com.tencent.mm.protocal.protobuf.cjd;
import com.tencent.mm.protocal.protobuf.cje;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class CgiLqtPlanOrderList
  extends c<cje>
{
  public CgiLqtPlanOrderList(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(68445);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new cjd();
    ((b.a)localObject).hvu = new cje();
    ((b.a)localObject).funcId = 1916;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/qryautoplanorderlist";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).aAz();
    cjd localcjd = (cjd)((b)localObject).hvr.hvw;
    localcjd.Fxb = paramInt1;
    localcjd.offset = paramInt2;
    localcjd.Fxc = paramInt3;
    this.rr = ((b)localObject);
    ac.i("MicroMsg.CgiLqtPlanOrderList", "CgiLqtPlanOrderList Req：plan_id: %s, offset: %s, limit: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(68445);
  }
  
  public static PlanItemParcel a(cfq paramcfq)
  {
    AppMethodBeat.i(68446);
    if (paramcfq == null)
    {
      AppMethodBeat.o(68446);
      return null;
    }
    PlanItemParcel localPlanItemParcel = new PlanItemParcel();
    localPlanItemParcel.AWN = paramcfq.AWN;
    localPlanItemParcel.dBN = paramcfq.dBN;
    localPlanItemParcel.fsg = paramcfq.fsg;
    localPlanItemParcel.wEw = paramcfq.wEw;
    localPlanItemParcel.tGS = paramcfq.tGS;
    localPlanItemParcel.cZz = paramcfq.cZz;
    localPlanItemParcel.vxk = paramcfq.vxk;
    localPlanItemParcel.state = paramcfq.state;
    localPlanItemParcel.AWO = paramcfq.AWO;
    if (paramcfq.FtZ != null)
    {
      localPlanItemParcel.AWQ = new MngPlanItemParcel();
      localPlanItemParcel.AWQ.AWz = paramcfq.FtZ.AWz;
      localPlanItemParcel.AWQ.AWA = paramcfq.FtZ.AWA;
      paramcfq = paramcfq.FtZ.Fky.iterator();
      while (paramcfq.hasNext())
      {
        Integer localInteger = (Integer)paramcfq.next();
        localPlanItemParcel.AWQ.AWB.add(localInteger);
      }
    }
    AppMethodBeat.o(68446);
    return localPlanItemParcel;
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
      AppMethodBeat.i(68440);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(68440);
    }
    
    public MngPlanItemParcel()
    {
      AppMethodBeat.i(68438);
      this.AWB = new ArrayList();
      AppMethodBeat.o(68438);
    }
    
    protected MngPlanItemParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(68439);
      this.AWB = new ArrayList();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.AWz = bool;
        this.AWA = paramParcel.readString();
        this.AWB = new ArrayList();
        paramParcel.readList(this.AWB, Integer.class.getClassLoader());
        AppMethodBeat.o(68439);
        return;
      }
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(68437);
      if (this.AWz) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        paramParcel.writeString(this.AWA);
        paramParcel.writeList(this.AWB);
        AppMethodBeat.o(68437);
        return;
      }
    }
  }
  
  public static class PlanItemParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<PlanItemParcel> CREATOR;
    public int AWN;
    public String AWO;
    public CgiLqtPlanOrderList.MngPlanItemParcel AWQ;
    public String cZz;
    public long dBN;
    public int fsg;
    public int state;
    public String tGS;
    public String vxk;
    public String wEw;
    
    static
    {
      AppMethodBeat.i(68444);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(68444);
    }
    
    public PlanItemParcel() {}
    
    protected PlanItemParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(68443);
      this.fsg = paramParcel.readInt();
      this.dBN = paramParcel.readLong();
      this.cZz = paramParcel.readString();
      this.vxk = paramParcel.readString();
      this.AWQ = ((CgiLqtPlanOrderList.MngPlanItemParcel)paramParcel.readParcelable(CgiLqtPlanOrderList.MngPlanItemParcel.class.getClassLoader()));
      this.AWN = paramParcel.readInt();
      this.state = paramParcel.readInt();
      this.tGS = paramParcel.readString();
      this.wEw = paramParcel.readString();
      this.AWO = paramParcel.readString();
      AppMethodBeat.o(68443);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(68442);
      paramParcel.writeInt(this.fsg);
      paramParcel.writeLong(this.dBN);
      paramParcel.writeString(this.cZz);
      paramParcel.writeString(this.vxk);
      paramParcel.writeParcelable(this.AWQ, paramInt);
      paramParcel.writeInt(this.AWN);
      paramParcel.writeInt(this.state);
      paramParcel.writeString(this.tGS);
      paramParcel.writeString(this.wEw);
      paramParcel.writeString(this.AWO);
      AppMethodBeat.o(68442);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.CgiLqtPlanOrderList
 * JD-Core Version:    0.7.0.1
 */