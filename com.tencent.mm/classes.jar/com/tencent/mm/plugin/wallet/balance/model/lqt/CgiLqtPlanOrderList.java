package com.tencent.mm.plugin.wallet.balance.model.lqt;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.protocal.protobuf.cxq;
import com.tencent.mm.protocal.protobuf.dli;
import com.tencent.mm.protocal.protobuf.dqr;
import com.tencent.mm.protocal.protobuf.dqs;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class CgiLqtPlanOrderList
  extends c<dqs>
{
  public CgiLqtPlanOrderList(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(68445);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new dqr();
    ((d.a)localObject).lBV = new dqs();
    ((d.a)localObject).funcId = 1916;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/qryautoplanorderlist";
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    localObject = ((d.a)localObject).bgN();
    dqr localdqr = (dqr)d.b.b(((d)localObject).lBR);
    localdqr.TXm = paramInt1;
    localdqr.offset = paramInt2;
    localdqr.TXn = paramInt3;
    c((d)localObject);
    Log.i("MicroMsg.CgiLqtPlanOrderList", "CgiLqtPlanOrderList Req：plan_id: %s, offset: %s, limit: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(68445);
  }
  
  public static PlanItemParcel a(dli paramdli)
  {
    AppMethodBeat.i(68446);
    if (paramdli == null)
    {
      AppMethodBeat.o(68446);
      return null;
    }
    PlanItemParcel localPlanItemParcel = new PlanItemParcel();
    localPlanItemParcel.Olc = paramdli.Olc;
    localPlanItemParcel.gbJ = paramdli.gbJ;
    localPlanItemParcel.day = paramdli.day;
    localPlanItemParcel.IfQ = paramdli.IfQ;
    localPlanItemParcel.DNV = paramdli.DNV;
    localPlanItemParcel.fvP = paramdli.fvP;
    localPlanItemParcel.GHy = paramdli.GHy;
    localPlanItemParcel.state = paramdli.state;
    localPlanItemParcel.Old = paramdli.Old;
    if (paramdli.TSu != null)
    {
      localPlanItemParcel.Olf = new MngPlanItemParcel();
      localPlanItemParcel.Olf.OkO = paramdli.TSu.OkO;
      localPlanItemParcel.Olf.OkP = paramdli.TSu.OkP;
      paramdli = paramdli.TSu.TFZ.iterator();
      while (paramdli.hasNext())
      {
        Integer localInteger = (Integer)paramdli.next();
        localPlanItemParcel.Olf.OkQ.add(localInteger);
      }
    }
    AppMethodBeat.o(68446);
    return localPlanItemParcel;
  }
  
  public static dli a(PlanItemParcel paramPlanItemParcel)
  {
    AppMethodBeat.i(201474);
    if (paramPlanItemParcel == null)
    {
      AppMethodBeat.o(201474);
      return null;
    }
    dli localdli = new dli();
    localdli.Olc = paramPlanItemParcel.Olc;
    localdli.gbJ = paramPlanItemParcel.gbJ;
    localdli.day = paramPlanItemParcel.day;
    localdli.IfQ = paramPlanItemParcel.IfQ;
    localdli.DNV = paramPlanItemParcel.DNV;
    localdli.fvP = paramPlanItemParcel.fvP;
    localdli.GHy = paramPlanItemParcel.GHy;
    localdli.state = paramPlanItemParcel.state;
    localdli.Old = paramPlanItemParcel.Old;
    if (paramPlanItemParcel.Olf != null)
    {
      localdli.TSu = new cxq();
      localdli.TSu.OkO = paramPlanItemParcel.Olf.OkO;
      localdli.TSu.OkP = paramPlanItemParcel.Olf.OkP;
      paramPlanItemParcel = paramPlanItemParcel.Olf.OkQ.iterator();
      while (paramPlanItemParcel.hasNext())
      {
        Integer localInteger = (Integer)paramPlanItemParcel.next();
        localdli.TSu.TFZ.add(localInteger);
      }
    }
    AppMethodBeat.o(201474);
    return localdli;
  }
  
  static class MngPlanItemParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<MngPlanItemParcel> CREATOR;
    public boolean OkO;
    public String OkP;
    public ArrayList<Integer> OkQ;
    
    static
    {
      AppMethodBeat.i(68440);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(68440);
    }
    
    public MngPlanItemParcel()
    {
      AppMethodBeat.i(68438);
      this.OkQ = new ArrayList();
      AppMethodBeat.o(68438);
    }
    
    protected MngPlanItemParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(68439);
      this.OkQ = new ArrayList();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.OkO = bool;
        this.OkP = paramParcel.readString();
        this.OkQ = new ArrayList();
        paramParcel.readList(this.OkQ, Integer.class.getClassLoader());
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
      if (this.OkO) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        paramParcel.writeString(this.OkP);
        paramParcel.writeList(this.OkQ);
        AppMethodBeat.o(68437);
        return;
      }
    }
  }
  
  public static class PlanItemParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<PlanItemParcel> CREATOR;
    public String DNV;
    public String GHy;
    public String IfQ;
    public int Olc;
    public String Old;
    public CgiLqtPlanOrderList.MngPlanItemParcel Olf;
    public int day;
    public String fvP;
    public long gbJ;
    public int state;
    
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
      this.day = paramParcel.readInt();
      this.gbJ = paramParcel.readLong();
      this.fvP = paramParcel.readString();
      this.GHy = paramParcel.readString();
      this.Olf = ((CgiLqtPlanOrderList.MngPlanItemParcel)paramParcel.readParcelable(CgiLqtPlanOrderList.MngPlanItemParcel.class.getClassLoader()));
      this.Olc = paramParcel.readInt();
      this.state = paramParcel.readInt();
      this.DNV = paramParcel.readString();
      this.IfQ = paramParcel.readString();
      this.Old = paramParcel.readString();
      AppMethodBeat.o(68443);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(68442);
      paramParcel.writeInt(this.day);
      paramParcel.writeLong(this.gbJ);
      paramParcel.writeString(this.fvP);
      paramParcel.writeString(this.GHy);
      paramParcel.writeParcelable(this.Olf, paramInt);
      paramParcel.writeInt(this.Olc);
      paramParcel.writeInt(this.state);
      paramParcel.writeString(this.DNV);
      paramParcel.writeString(this.IfQ);
      paramParcel.writeString(this.Old);
      AppMethodBeat.o(68442);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.CgiLqtPlanOrderList
 * JD-Core Version:    0.7.0.1
 */