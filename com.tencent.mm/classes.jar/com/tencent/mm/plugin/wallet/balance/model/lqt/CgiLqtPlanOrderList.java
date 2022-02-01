package com.tencent.mm.plugin.wallet.balance.model.lqt;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.protocal.protobuf.dov;
import com.tencent.mm.protocal.protobuf.edt;
import com.tencent.mm.protocal.protobuf.ejm;
import com.tencent.mm.protocal.protobuf.ejn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class CgiLqtPlanOrderList
  extends z<ejn>
{
  public CgiLqtPlanOrderList(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(68445);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new ejm();
    ((c.a)localObject).otF = new ejn();
    ((c.a)localObject).funcId = 1916;
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/qryautoplanorderlist";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    localObject = ((c.a)localObject).bEF();
    ejm localejm = (ejm)c.b.b(((c)localObject).otB);
    localejm.aboe = paramInt1;
    localejm.offset = paramInt2;
    localejm.dJg = paramInt3;
    c((c)localObject);
    Log.i("MicroMsg.CgiLqtPlanOrderList", "CgiLqtPlanOrderList Req：plan_id: %s, offset: %s, limit: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(68445);
  }
  
  public static PlanItemParcel a(edt paramedt)
  {
    AppMethodBeat.i(68446);
    if (paramedt == null)
    {
      AppMethodBeat.o(68446);
      return null;
    }
    PlanItemParcel localPlanItemParcel = new PlanItemParcel();
    localPlanItemParcel.UZF = paramedt.UZF;
    localPlanItemParcel.ihV = paramedt.ihV;
    localPlanItemParcel.day = paramedt.day;
    localPlanItemParcel.Ocp = paramedt.Ocp;
    localPlanItemParcel.JFk = paramedt.JFk;
    localPlanItemParcel.hAk = paramedt.hAk;
    localPlanItemParcel.MEp = paramedt.MEp;
    localPlanItemParcel.state = paramedt.state;
    localPlanItemParcel.UZG = paramedt.UZG;
    if (paramedt.abiT != null)
    {
      localPlanItemParcel.UZI = new MngPlanItemParcel();
      localPlanItemParcel.UZI.UZr = paramedt.abiT.UZr;
      localPlanItemParcel.UZI.UZs = paramedt.abiT.UZs;
      paramedt = paramedt.abiT.aaVF.iterator();
      while (paramedt.hasNext())
      {
        Integer localInteger = (Integer)paramedt.next();
        localPlanItemParcel.UZI.UZt.add(localInteger);
      }
    }
    AppMethodBeat.o(68446);
    return localPlanItemParcel;
  }
  
  public static edt a(PlanItemParcel paramPlanItemParcel)
  {
    AppMethodBeat.i(316206);
    if (paramPlanItemParcel == null)
    {
      AppMethodBeat.o(316206);
      return null;
    }
    edt localedt = new edt();
    localedt.UZF = paramPlanItemParcel.UZF;
    localedt.ihV = paramPlanItemParcel.ihV;
    localedt.day = paramPlanItemParcel.day;
    localedt.Ocp = paramPlanItemParcel.Ocp;
    localedt.JFk = paramPlanItemParcel.JFk;
    localedt.hAk = paramPlanItemParcel.hAk;
    localedt.MEp = paramPlanItemParcel.MEp;
    localedt.state = paramPlanItemParcel.state;
    localedt.UZG = paramPlanItemParcel.UZG;
    if (paramPlanItemParcel.UZI != null)
    {
      localedt.abiT = new dov();
      localedt.abiT.UZr = paramPlanItemParcel.UZI.UZr;
      localedt.abiT.UZs = paramPlanItemParcel.UZI.UZs;
      paramPlanItemParcel = paramPlanItemParcel.UZI.UZt.iterator();
      while (paramPlanItemParcel.hasNext())
      {
        Integer localInteger = (Integer)paramPlanItemParcel.next();
        localedt.abiT.aaVF.add(localInteger);
      }
    }
    AppMethodBeat.o(316206);
    return localedt;
  }
  
  static class MngPlanItemParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<MngPlanItemParcel> CREATOR;
    public boolean UZr;
    public String UZs;
    public ArrayList<Integer> UZt;
    
    static
    {
      AppMethodBeat.i(68440);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(68440);
    }
    
    public MngPlanItemParcel()
    {
      AppMethodBeat.i(68438);
      this.UZt = new ArrayList();
      AppMethodBeat.o(68438);
    }
    
    protected MngPlanItemParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(68439);
      this.UZt = new ArrayList();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.UZr = bool;
        this.UZs = paramParcel.readString();
        this.UZt = new ArrayList();
        paramParcel.readList(this.UZt, Integer.class.getClassLoader());
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
      if (this.UZr) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        paramParcel.writeString(this.UZs);
        paramParcel.writeList(this.UZt);
        AppMethodBeat.o(68437);
        return;
      }
    }
  }
  
  public static class PlanItemParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<PlanItemParcel> CREATOR;
    public String JFk;
    public String MEp;
    public String Ocp;
    public int UZF;
    public String UZG;
    public CgiLqtPlanOrderList.MngPlanItemParcel UZI;
    public int day;
    public String hAk;
    public long ihV;
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
      this.ihV = paramParcel.readLong();
      this.hAk = paramParcel.readString();
      this.MEp = paramParcel.readString();
      this.UZI = ((CgiLqtPlanOrderList.MngPlanItemParcel)paramParcel.readParcelable(CgiLqtPlanOrderList.MngPlanItemParcel.class.getClassLoader()));
      this.UZF = paramParcel.readInt();
      this.state = paramParcel.readInt();
      this.JFk = paramParcel.readString();
      this.Ocp = paramParcel.readString();
      this.UZG = paramParcel.readString();
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
      paramParcel.writeLong(this.ihV);
      paramParcel.writeString(this.hAk);
      paramParcel.writeString(this.MEp);
      paramParcel.writeParcelable(this.UZI, paramInt);
      paramParcel.writeInt(this.UZF);
      paramParcel.writeInt(this.state);
      paramParcel.writeString(this.JFk);
      paramParcel.writeString(this.Ocp);
      paramParcel.writeString(this.UZG);
      AppMethodBeat.o(68442);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.CgiLqtPlanOrderList
 * JD-Core Version:    0.7.0.1
 */