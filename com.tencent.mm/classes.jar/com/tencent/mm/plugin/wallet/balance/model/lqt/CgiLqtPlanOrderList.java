package com.tencent.mm.plugin.wallet.balance.model.lqt;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.protocal.protobuf.bze;
import com.tencent.mm.protocal.protobuf.ckp;
import com.tencent.mm.protocal.protobuf.cod;
import com.tencent.mm.protocal.protobuf.coe;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class CgiLqtPlanOrderList
  extends a<coe>
{
  public CgiLqtPlanOrderList(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(68445);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new cod();
    ((b.a)localObject).hNN = new coe();
    ((b.a)localObject).funcId = 1916;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/qryautoplanorderlist";
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).aDC();
    cod localcod = (cod)((b)localObject).hNK.hNQ;
    localcod.Hhg = paramInt1;
    localcod.offset = paramInt2;
    localcod.Hhh = paramInt3;
    c((b)localObject);
    ad.i("MicroMsg.CgiLqtPlanOrderList", "CgiLqtPlanOrderList Req：plan_id: %s, offset: %s, limit: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(68445);
  }
  
  public static PlanItemParcel a(ckp paramckp)
  {
    AppMethodBeat.i(68446);
    if (paramckp == null)
    {
      AppMethodBeat.o(68446);
      return null;
    }
    PlanItemParcel localPlanItemParcel = new PlanItemParcel();
    localPlanItemParcel.CwW = paramckp.CwW;
    localPlanItemParcel.dOa = paramckp.dOa;
    localPlanItemParcel.fKG = paramckp.fKG;
    localPlanItemParcel.xSd = paramckp.xSd;
    localPlanItemParcel.uJF = paramckp.uJF;
    localPlanItemParcel.dkR = paramckp.dkR;
    localPlanItemParcel.wCE = paramckp.wCE;
    localPlanItemParcel.state = paramckp.state;
    localPlanItemParcel.CwX = paramckp.CwX;
    if (paramckp.Hee != null)
    {
      localPlanItemParcel.CwZ = new MngPlanItemParcel();
      localPlanItemParcel.CwZ.CwI = paramckp.Hee.CwI;
      localPlanItemParcel.CwZ.CwJ = paramckp.Hee.CwJ;
      paramckp = paramckp.Hee.GUg.iterator();
      while (paramckp.hasNext())
      {
        Integer localInteger = (Integer)paramckp.next();
        localPlanItemParcel.CwZ.CwK.add(localInteger);
      }
    }
    AppMethodBeat.o(68446);
    return localPlanItemParcel;
  }
  
  public static class MngPlanItemParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<MngPlanItemParcel> CREATOR;
    public boolean CwI;
    public String CwJ;
    public ArrayList<Integer> CwK;
    
    static
    {
      AppMethodBeat.i(68440);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(68440);
    }
    
    public MngPlanItemParcel()
    {
      AppMethodBeat.i(68438);
      this.CwK = new ArrayList();
      AppMethodBeat.o(68438);
    }
    
    protected MngPlanItemParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(68439);
      this.CwK = new ArrayList();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.CwI = bool;
        this.CwJ = paramParcel.readString();
        this.CwK = new ArrayList();
        paramParcel.readList(this.CwK, Integer.class.getClassLoader());
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
      if (this.CwI) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        paramParcel.writeString(this.CwJ);
        paramParcel.writeList(this.CwK);
        AppMethodBeat.o(68437);
        return;
      }
    }
  }
  
  public static class PlanItemParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<PlanItemParcel> CREATOR;
    public int CwW;
    public String CwX;
    public CgiLqtPlanOrderList.MngPlanItemParcel CwZ;
    public long dOa;
    public String dkR;
    public int fKG;
    public int state;
    public String uJF;
    public String wCE;
    public String xSd;
    
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
      this.fKG = paramParcel.readInt();
      this.dOa = paramParcel.readLong();
      this.dkR = paramParcel.readString();
      this.wCE = paramParcel.readString();
      this.CwZ = ((CgiLqtPlanOrderList.MngPlanItemParcel)paramParcel.readParcelable(CgiLqtPlanOrderList.MngPlanItemParcel.class.getClassLoader()));
      this.CwW = paramParcel.readInt();
      this.state = paramParcel.readInt();
      this.uJF = paramParcel.readString();
      this.xSd = paramParcel.readString();
      this.CwX = paramParcel.readString();
      AppMethodBeat.o(68443);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(68442);
      paramParcel.writeInt(this.fKG);
      paramParcel.writeLong(this.dOa);
      paramParcel.writeString(this.dkR);
      paramParcel.writeString(this.wCE);
      paramParcel.writeParcelable(this.CwZ, paramInt);
      paramParcel.writeInt(this.CwW);
      paramParcel.writeInt(this.state);
      paramParcel.writeString(this.uJF);
      paramParcel.writeString(this.xSd);
      paramParcel.writeString(this.CwX);
      AppMethodBeat.o(68442);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.CgiLqtPlanOrderList
 * JD-Core Version:    0.7.0.1
 */