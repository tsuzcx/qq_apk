package com.tencent.mm.plugin.wallet.balance.model.lqt;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.protocal.protobuf.cpa;
import com.tencent.mm.protocal.protobuf.dbt;
import com.tencent.mm.protocal.protobuf.dgw;
import com.tencent.mm.protocal.protobuf.dgx;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class CgiLqtPlanOrderList
  extends c<dgx>
{
  public CgiLqtPlanOrderList(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(68445);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new dgw();
    ((d.a)localObject).iLO = new dgx();
    ((d.a)localObject).funcId = 1916;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/qryautoplanorderlist";
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    localObject = ((d.a)localObject).aXF();
    dgw localdgw = (dgw)((d)localObject).iLK.iLR;
    localdgw.MLr = paramInt1;
    localdgw.offset = paramInt2;
    localdgw.MLs = paramInt3;
    c((d)localObject);
    Log.i("MicroMsg.CgiLqtPlanOrderList", "CgiLqtPlanOrderList Req：plan_id: %s, offset: %s, limit: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(68445);
  }
  
  public static PlanItemParcel a(dbt paramdbt)
  {
    AppMethodBeat.i(68446);
    if (paramdbt == null)
    {
      AppMethodBeat.o(68446);
      return null;
    }
    PlanItemParcel localPlanItemParcel = new PlanItemParcel();
    localPlanItemParcel.Htr = paramdbt.Htr;
    localPlanItemParcel.eht = paramdbt.eht;
    localPlanItemParcel.grV = paramdbt.grV;
    localPlanItemParcel.CiX = paramdbt.CiX;
    localPlanItemParcel.ynT = paramdbt.ynT;
    localPlanItemParcel.dDj = paramdbt.dDj;
    localPlanItemParcel.AOk = paramdbt.AOk;
    localPlanItemParcel.state = paramdbt.state;
    localPlanItemParcel.Hts = paramdbt.Hts;
    if (paramdbt.MGH != null)
    {
      localPlanItemParcel.Htu = new MngPlanItemParcel();
      localPlanItemParcel.Htu.Htd = paramdbt.MGH.Htd;
      localPlanItemParcel.Htu.Hte = paramdbt.MGH.Hte;
      paramdbt = paramdbt.MGH.Mvb.iterator();
      while (paramdbt.hasNext())
      {
        Integer localInteger = (Integer)paramdbt.next();
        localPlanItemParcel.Htu.Htf.add(localInteger);
      }
    }
    AppMethodBeat.o(68446);
    return localPlanItemParcel;
  }
  
  public static class MngPlanItemParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<MngPlanItemParcel> CREATOR;
    public boolean Htd;
    public String Hte;
    public ArrayList<Integer> Htf;
    
    static
    {
      AppMethodBeat.i(68440);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(68440);
    }
    
    public MngPlanItemParcel()
    {
      AppMethodBeat.i(68438);
      this.Htf = new ArrayList();
      AppMethodBeat.o(68438);
    }
    
    protected MngPlanItemParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(68439);
      this.Htf = new ArrayList();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.Htd = bool;
        this.Hte = paramParcel.readString();
        this.Htf = new ArrayList();
        paramParcel.readList(this.Htf, Integer.class.getClassLoader());
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
      if (this.Htd) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        paramParcel.writeString(this.Hte);
        paramParcel.writeList(this.Htf);
        AppMethodBeat.o(68437);
        return;
      }
    }
  }
  
  public static class PlanItemParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<PlanItemParcel> CREATOR;
    public String AOk;
    public String CiX;
    public int Htr;
    public String Hts;
    public CgiLqtPlanOrderList.MngPlanItemParcel Htu;
    public String dDj;
    public long eht;
    public int grV;
    public int state;
    public String ynT;
    
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
      this.grV = paramParcel.readInt();
      this.eht = paramParcel.readLong();
      this.dDj = paramParcel.readString();
      this.AOk = paramParcel.readString();
      this.Htu = ((CgiLqtPlanOrderList.MngPlanItemParcel)paramParcel.readParcelable(CgiLqtPlanOrderList.MngPlanItemParcel.class.getClassLoader()));
      this.Htr = paramParcel.readInt();
      this.state = paramParcel.readInt();
      this.ynT = paramParcel.readString();
      this.CiX = paramParcel.readString();
      this.Hts = paramParcel.readString();
      AppMethodBeat.o(68443);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(68442);
      paramParcel.writeInt(this.grV);
      paramParcel.writeLong(this.eht);
      paramParcel.writeString(this.dDj);
      paramParcel.writeString(this.AOk);
      paramParcel.writeParcelable(this.Htu, paramInt);
      paramParcel.writeInt(this.Htr);
      paramParcel.writeInt(this.state);
      paramParcel.writeString(this.ynT);
      paramParcel.writeString(this.CiX);
      paramParcel.writeString(this.Hts);
      AppMethodBeat.o(68442);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.CgiLqtPlanOrderList
 * JD-Core Version:    0.7.0.1
 */