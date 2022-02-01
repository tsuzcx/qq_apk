package com.tencent.mm.plugin.wallet.balance.model.lqt;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.c;
import com.tencent.mm.protocal.protobuf.bpy;
import com.tencent.mm.protocal.protobuf.car;
import com.tencent.mm.protocal.protobuf.cea;
import com.tencent.mm.protocal.protobuf.ceb;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class CgiLqtPlanOrderList
  extends c<ceb>
{
  public CgiLqtPlanOrderList(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(68445);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new cea();
    ((b.a)localObject).gUV = new ceb();
    ((b.a)localObject).funcId = 1916;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/qryautoplanorderlist";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).atI();
    cea localcea = (cea)((b)localObject).gUS.gUX;
    localcea.Eag = paramInt1;
    localcea.offset = paramInt2;
    localcea.Eah = paramInt3;
    this.rr = ((b)localObject);
    ad.i("MicroMsg.CgiLqtPlanOrderList", "CgiLqtPlanOrderList Req：plan_id: %s, offset: %s, limit: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(68445);
  }
  
  public static PlanItemParcel a(car paramcar)
  {
    AppMethodBeat.i(68446);
    if (paramcar == null)
    {
      AppMethodBeat.o(68446);
      return null;
    }
    PlanItemParcel localPlanItemParcel = new PlanItemParcel();
    localPlanItemParcel.zEA = paramcar.zEA;
    localPlanItemParcel.dEb = paramcar.dEb;
    localPlanItemParcel.foG = paramcar.foG;
    localPlanItemParcel.vur = paramcar.vur;
    localPlanItemParcel.szi = paramcar.szi;
    localPlanItemParcel.dca = paramcar.dca;
    localPlanItemParcel.uoo = paramcar.uoo;
    localPlanItemParcel.state = paramcar.state;
    localPlanItemParcel.zEB = paramcar.zEB;
    if (paramcar.DXg != null)
    {
      localPlanItemParcel.zED = new MngPlanItemParcel();
      localPlanItemParcel.zED.zEm = paramcar.DXg.zEm;
      localPlanItemParcel.zED.zEn = paramcar.DXg.zEn;
      paramcar = paramcar.DXg.DOh.iterator();
      while (paramcar.hasNext())
      {
        Integer localInteger = (Integer)paramcar.next();
        localPlanItemParcel.zED.zEo.add(localInteger);
      }
    }
    AppMethodBeat.o(68446);
    return localPlanItemParcel;
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
      AppMethodBeat.i(68440);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(68440);
    }
    
    public MngPlanItemParcel()
    {
      AppMethodBeat.i(68438);
      this.zEo = new ArrayList();
      AppMethodBeat.o(68438);
    }
    
    protected MngPlanItemParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(68439);
      this.zEo = new ArrayList();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.zEm = bool;
        this.zEn = paramParcel.readString();
        this.zEo = new ArrayList();
        paramParcel.readList(this.zEo, Integer.class.getClassLoader());
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
      if (this.zEm) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        paramParcel.writeString(this.zEn);
        paramParcel.writeList(this.zEo);
        AppMethodBeat.o(68437);
        return;
      }
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
    public CgiLqtPlanOrderList.MngPlanItemParcel zED;
    
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
      this.foG = paramParcel.readInt();
      this.dEb = paramParcel.readLong();
      this.dca = paramParcel.readString();
      this.uoo = paramParcel.readString();
      this.zED = ((CgiLqtPlanOrderList.MngPlanItemParcel)paramParcel.readParcelable(CgiLqtPlanOrderList.MngPlanItemParcel.class.getClassLoader()));
      this.zEA = paramParcel.readInt();
      this.state = paramParcel.readInt();
      this.szi = paramParcel.readString();
      this.vur = paramParcel.readString();
      this.zEB = paramParcel.readString();
      AppMethodBeat.o(68443);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(68442);
      paramParcel.writeInt(this.foG);
      paramParcel.writeLong(this.dEb);
      paramParcel.writeString(this.dca);
      paramParcel.writeString(this.uoo);
      paramParcel.writeParcelable(this.zED, paramInt);
      paramParcel.writeInt(this.zEA);
      paramParcel.writeInt(this.state);
      paramParcel.writeString(this.szi);
      paramParcel.writeString(this.vur);
      paramParcel.writeString(this.zEB);
      AppMethodBeat.o(68442);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.CgiLqtPlanOrderList
 * JD-Core Version:    0.7.0.1
 */