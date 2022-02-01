package com.tencent.mm.plugin.wallet.balance.model.lqt;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.protocal.protobuf.bzy;
import com.tencent.mm.protocal.protobuf.clj;
import com.tencent.mm.protocal.protobuf.cox;
import com.tencent.mm.protocal.protobuf.coy;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class CgiLqtPlanOrderList
  extends a<coy>
{
  public CgiLqtPlanOrderList(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(68445);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new cox();
    ((b.a)localObject).hQG = new coy();
    ((b.a)localObject).funcId = 1916;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/qryautoplanorderlist";
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).aDS();
    cox localcox = (cox)((b)localObject).hQD.hQJ;
    localcox.HAG = paramInt1;
    localcox.offset = paramInt2;
    localcox.HAH = paramInt3;
    c((b)localObject);
    ae.i("MicroMsg.CgiLqtPlanOrderList", "CgiLqtPlanOrderList Req：plan_id: %s, offset: %s, limit: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(68445);
  }
  
  public static PlanItemParcel a(clj paramclj)
  {
    AppMethodBeat.i(68446);
    if (paramclj == null)
    {
      AppMethodBeat.o(68446);
      return null;
    }
    PlanItemParcel localPlanItemParcel = new PlanItemParcel();
    localPlanItemParcel.COB = paramclj.COB;
    localPlanItemParcel.dPq = paramclj.dPq;
    localPlanItemParcel.fMJ = paramclj.fMJ;
    localPlanItemParcel.yhW = paramclj.yhW;
    localPlanItemParcel.uVs = paramclj.uVs;
    localPlanItemParcel.dlT = paramclj.dlT;
    localPlanItemParcel.wSp = paramclj.wSp;
    localPlanItemParcel.state = paramclj.state;
    localPlanItemParcel.COC = paramclj.COC;
    if (paramclj.HxE != null)
    {
      localPlanItemParcel.COE = new MngPlanItemParcel();
      localPlanItemParcel.COE.COn = paramclj.HxE.COn;
      localPlanItemParcel.COE.COo = paramclj.HxE.COo;
      paramclj = paramclj.HxE.HnH.iterator();
      while (paramclj.hasNext())
      {
        Integer localInteger = (Integer)paramclj.next();
        localPlanItemParcel.COE.COp.add(localInteger);
      }
    }
    AppMethodBeat.o(68446);
    return localPlanItemParcel;
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
      AppMethodBeat.i(68440);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(68440);
    }
    
    public MngPlanItemParcel()
    {
      AppMethodBeat.i(68438);
      this.COp = new ArrayList();
      AppMethodBeat.o(68438);
    }
    
    protected MngPlanItemParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(68439);
      this.COp = new ArrayList();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.COn = bool;
        this.COo = paramParcel.readString();
        this.COp = new ArrayList();
        paramParcel.readList(this.COp, Integer.class.getClassLoader());
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
      if (this.COn) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        paramParcel.writeString(this.COo);
        paramParcel.writeList(this.COp);
        AppMethodBeat.o(68437);
        return;
      }
    }
  }
  
  public static class PlanItemParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<PlanItemParcel> CREATOR;
    public int COB;
    public String COC;
    public CgiLqtPlanOrderList.MngPlanItemParcel COE;
    public long dPq;
    public String dlT;
    public int fMJ;
    public int state;
    public String uVs;
    public String wSp;
    public String yhW;
    
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
      this.fMJ = paramParcel.readInt();
      this.dPq = paramParcel.readLong();
      this.dlT = paramParcel.readString();
      this.wSp = paramParcel.readString();
      this.COE = ((CgiLqtPlanOrderList.MngPlanItemParcel)paramParcel.readParcelable(CgiLqtPlanOrderList.MngPlanItemParcel.class.getClassLoader()));
      this.COB = paramParcel.readInt();
      this.state = paramParcel.readInt();
      this.uVs = paramParcel.readString();
      this.yhW = paramParcel.readString();
      this.COC = paramParcel.readString();
      AppMethodBeat.o(68443);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(68442);
      paramParcel.writeInt(this.fMJ);
      paramParcel.writeLong(this.dPq);
      paramParcel.writeString(this.dlT);
      paramParcel.writeString(this.wSp);
      paramParcel.writeParcelable(this.COE, paramInt);
      paramParcel.writeInt(this.COB);
      paramParcel.writeInt(this.state);
      paramParcel.writeString(this.uVs);
      paramParcel.writeString(this.yhW);
      paramParcel.writeString(this.COC);
      AppMethodBeat.o(68442);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.CgiLqtPlanOrderList
 * JD-Core Version:    0.7.0.1
 */