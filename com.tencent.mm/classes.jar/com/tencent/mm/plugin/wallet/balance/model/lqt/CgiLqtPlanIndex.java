package com.tencent.mm.plugin.wallet.balance.model.lqt;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.protocal.protobuf.dov;
import com.tencent.mm.protocal.protobuf.drc;
import com.tencent.mm.protocal.protobuf.edr;
import com.tencent.mm.protocal.protobuf.eds;
import com.tencent.mm.protocal.protobuf.edt;
import com.tencent.mm.protocal.protobuf.foy;
import com.tencent.mm.protocal.protobuf.js;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class CgiLqtPlanIndex
  extends z<eds>
{
  public CgiLqtPlanIndex()
  {
    AppMethodBeat.i(68434);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new edr();
    ((c.a)localObject).otF = new eds();
    ((c.a)localObject).funcId = 2796;
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/planindex";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    localObject = ((c.a)localObject).bEF();
    c.b.b(((c)localObject).otB);
    c((c)localObject);
    Log.i("MicroMsg.CgiLqtPlanIndex", "isfirstclick: %s");
    AppMethodBeat.o(68434);
  }
  
  public static PlanIndexParcel a(eds parameds)
  {
    AppMethodBeat.i(68435);
    if (parameds == null)
    {
      AppMethodBeat.o(68435);
      return null;
    }
    PlanIndexParcel localPlanIndexParcel = new PlanIndexParcel();
    localPlanIndexParcel.wuz = parameds.wuz;
    localPlanIndexParcel.wuA = parameds.wuA;
    Iterator localIterator1 = parameds.abiO.iterator();
    while (localIterator1.hasNext())
    {
      edt localedt = (edt)localIterator1.next();
      PlanItemParcel localPlanItemParcel = new PlanItemParcel();
      localPlanItemParcel.day = localedt.day;
      localPlanItemParcel.ihV = localedt.ihV;
      localPlanItemParcel.hAk = localedt.hAk;
      localPlanItemParcel.MEp = localedt.MEp;
      localPlanItemParcel.UZA = localedt.UZA;
      localPlanItemParcel.UZB = localedt.UZB;
      localPlanItemParcel.Ocp = localedt.Ocp;
      localPlanItemParcel.UZG = localedt.UZG;
      if (localedt.abiR != null)
      {
        localPlanItemParcel.UZC = new TransTipsItemParcel();
        localPlanItemParcel.UZC.UZH = localedt.abiR.UZH;
        localPlanItemParcel.UZC.nRQ = localedt.abiR.nRQ;
      }
      if (localedt.abiS != null)
      {
        localPlanItemParcel.UZD = new MoreRecordsParcel();
        localPlanItemParcel.UZD.title = localedt.abiS.title;
        localPlanItemParcel.UZD.url = localedt.abiS.url;
      }
      if (localedt.abiT != null)
      {
        localPlanItemParcel.UZE = new MngPlanItemParcel();
        localPlanItemParcel.UZE.UZr = localedt.abiT.UZr;
        localPlanItemParcel.UZE.UZs = localedt.abiT.UZs;
        Iterator localIterator2 = localedt.abiT.aaVF.iterator();
        while (localIterator2.hasNext())
        {
          Integer localInteger = (Integer)localIterator2.next();
          localPlanItemParcel.UZE.UZt.add(localInteger);
        }
      }
      localPlanItemParcel.UZF = localedt.UZF;
      localPlanItemParcel.state = localedt.state;
      localPlanItemParcel.JFk = localedt.JFk;
      localPlanIndexParcel.UZu.add(localPlanItemParcel);
    }
    localPlanIndexParcel.UZv = parameds.UZv;
    localPlanIndexParcel.UZw = parameds.UZw;
    if (parameds.abiP != null)
    {
      localPlanIndexParcel.UZx = new BannerParcel();
      localPlanIndexParcel.UZx.title = parameds.abiP.title;
      localPlanIndexParcel.UZx.url = parameds.abiP.url;
    }
    localPlanIndexParcel.UZy = parameds.UZy;
    localPlanIndexParcel.UZz = parameds.UZz;
    AppMethodBeat.o(68435);
    return localPlanIndexParcel;
  }
  
  public static eds a(PlanIndexParcel paramPlanIndexParcel)
  {
    AppMethodBeat.i(316106);
    if (paramPlanIndexParcel == null)
    {
      AppMethodBeat.o(316106);
      return null;
    }
    eds localeds = new eds();
    localeds.wuz = paramPlanIndexParcel.wuz;
    localeds.wuA = paramPlanIndexParcel.wuA;
    Iterator localIterator1 = paramPlanIndexParcel.UZu.iterator();
    while (localIterator1.hasNext())
    {
      PlanItemParcel localPlanItemParcel = (PlanItemParcel)localIterator1.next();
      edt localedt = new edt();
      localedt.day = localPlanItemParcel.day;
      localedt.ihV = localPlanItemParcel.ihV;
      localedt.hAk = localPlanItemParcel.hAk;
      localedt.MEp = localPlanItemParcel.MEp;
      localedt.UZA = localPlanItemParcel.UZA;
      localedt.UZB = localPlanItemParcel.UZB;
      localedt.UZG = localPlanItemParcel.UZG;
      localedt.Ocp = localPlanItemParcel.Ocp;
      if (localPlanItemParcel.UZC != null)
      {
        localedt.abiR = new foy();
        localedt.abiR.UZH = localPlanItemParcel.UZC.UZH;
        localedt.abiR.nRQ = localPlanItemParcel.UZC.nRQ;
      }
      if (localPlanItemParcel.UZD != null)
      {
        localedt.abiS = new drc();
        localedt.abiS.title = localPlanItemParcel.UZD.title;
        localedt.abiS.url = localPlanItemParcel.UZD.url;
      }
      if (localPlanItemParcel.UZE != null)
      {
        localedt.abiT = new dov();
        localedt.abiT.UZr = localPlanItemParcel.UZE.UZr;
        localedt.abiT.UZs = localPlanItemParcel.UZE.UZs;
        Iterator localIterator2 = localPlanItemParcel.UZE.UZt.iterator();
        while (localIterator2.hasNext())
        {
          Integer localInteger = (Integer)localIterator2.next();
          localedt.abiT.aaVF.add(localInteger);
        }
      }
      localedt.UZF = localPlanItemParcel.UZF;
      localedt.state = localPlanItemParcel.state;
      localedt.JFk = localPlanItemParcel.JFk;
      localeds.abiO.add(localedt);
    }
    localeds.UZv = paramPlanIndexParcel.UZv;
    localeds.UZw = paramPlanIndexParcel.UZw;
    if (paramPlanIndexParcel.UZx != null)
    {
      localeds.abiP = new js();
      localeds.abiP.title = paramPlanIndexParcel.UZx.title;
      localeds.abiP.url = paramPlanIndexParcel.UZx.url;
    }
    localeds.UZy = paramPlanIndexParcel.UZy;
    localeds.UZz = paramPlanIndexParcel.UZz;
    AppMethodBeat.o(316106);
    return localeds;
  }
  
  static class BannerParcel
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
  
  static class MngPlanItemParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<MngPlanItemParcel> CREATOR;
    public boolean UZr;
    public String UZs;
    public ArrayList<Integer> UZt;
    
    static
    {
      AppMethodBeat.i(68416);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(68416);
    }
    
    public MngPlanItemParcel()
    {
      AppMethodBeat.i(68414);
      this.UZt = new ArrayList();
      AppMethodBeat.o(68414);
    }
    
    protected MngPlanItemParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(68415);
      this.UZt = new ArrayList();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.UZr = bool;
        this.UZs = paramParcel.readString();
        this.UZt = new ArrayList();
        paramParcel.readList(this.UZt, Integer.class.getClassLoader());
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
      if (this.UZr) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        paramParcel.writeString(this.UZs);
        paramParcel.writeList(this.UZt);
        AppMethodBeat.o(68413);
        return;
      }
    }
  }
  
  static class MoreRecordsParcel
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
    public ArrayList<CgiLqtPlanIndex.PlanItemParcel> UZu;
    public long UZv;
    public String UZw;
    public CgiLqtPlanIndex.BannerParcel UZx;
    public String UZy;
    public String UZz;
    public String wuA;
    public int wuz;
    
    static
    {
      AppMethodBeat.i(68425);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(68425);
    }
    
    public PlanIndexParcel()
    {
      AppMethodBeat.i(68423);
      this.UZu = new ArrayList();
      AppMethodBeat.o(68423);
    }
    
    protected PlanIndexParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(68424);
      this.UZu = new ArrayList();
      this.wuz = paramParcel.readInt();
      this.wuA = paramParcel.readString();
      this.UZu = new ArrayList();
      paramParcel.readList(this.UZu, CgiLqtPlanIndex.PlanItemParcel.class.getClassLoader());
      this.UZv = paramParcel.readLong();
      this.UZw = paramParcel.readString();
      this.UZx = ((CgiLqtPlanIndex.BannerParcel)paramParcel.readParcelable(CgiLqtPlanIndex.BannerParcel.class.getClassLoader()));
      this.UZy = paramParcel.readString();
      this.UZz = paramParcel.readString();
      AppMethodBeat.o(68424);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(68422);
      paramParcel.writeInt(this.wuz);
      paramParcel.writeString(this.wuA);
      paramParcel.writeList(this.UZu);
      paramParcel.writeLong(this.UZv);
      paramParcel.writeString(this.UZw);
      paramParcel.writeParcelable(this.UZx, paramInt);
      paramParcel.writeString(this.UZy);
      paramParcel.writeString(this.UZz);
      AppMethodBeat.o(68422);
    }
  }
  
  static class PlanItemParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<PlanItemParcel> CREATOR;
    public String JFk;
    public String MEp;
    public String Ocp;
    public String UZA;
    public String UZB;
    public CgiLqtPlanIndex.TransTipsItemParcel UZC;
    public CgiLqtPlanIndex.MoreRecordsParcel UZD;
    public CgiLqtPlanIndex.MngPlanItemParcel UZE;
    public int UZF;
    public String UZG;
    public int day;
    public String hAk;
    public long ihV;
    public int state;
    
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
      this.day = paramParcel.readInt();
      this.ihV = paramParcel.readLong();
      this.hAk = paramParcel.readString();
      this.MEp = paramParcel.readString();
      this.UZA = paramParcel.readString();
      this.UZB = paramParcel.readString();
      this.UZC = ((CgiLqtPlanIndex.TransTipsItemParcel)paramParcel.readParcelable(CgiLqtPlanIndex.TransTipsItemParcel.class.getClassLoader()));
      this.UZD = ((CgiLqtPlanIndex.MoreRecordsParcel)paramParcel.readParcelable(CgiLqtPlanIndex.MoreRecordsParcel.class.getClassLoader()));
      this.UZE = ((CgiLqtPlanIndex.MngPlanItemParcel)paramParcel.readParcelable(CgiLqtPlanIndex.MngPlanItemParcel.class.getClassLoader()));
      this.UZF = paramParcel.readInt();
      this.state = paramParcel.readInt();
      this.JFk = paramParcel.readString();
      this.Ocp = paramParcel.readString();
      this.UZG = paramParcel.readString();
      AppMethodBeat.o(68428);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(68427);
      paramParcel.writeInt(this.day);
      paramParcel.writeLong(this.ihV);
      paramParcel.writeString(this.hAk);
      paramParcel.writeString(this.MEp);
      paramParcel.writeString(this.UZA);
      paramParcel.writeString(this.UZB);
      paramParcel.writeParcelable(this.UZC, paramInt);
      paramParcel.writeParcelable(this.UZD, paramInt);
      paramParcel.writeParcelable(this.UZE, paramInt);
      paramParcel.writeInt(this.UZF);
      paramParcel.writeInt(this.state);
      paramParcel.writeString(this.JFk);
      paramParcel.writeString(this.Ocp);
      paramParcel.writeString(this.UZG);
      AppMethodBeat.o(68427);
    }
  }
  
  static class TransTipsItemParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<TransTipsItemParcel> CREATOR;
    public String UZH;
    public String nRQ;
    
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
      this.UZH = paramParcel.readString();
      this.nRQ = paramParcel.readString();
      AppMethodBeat.o(68432);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(68431);
      paramParcel.writeString(this.UZH);
      paramParcel.writeString(this.nRQ);
      AppMethodBeat.o(68431);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.CgiLqtPlanIndex
 * JD-Core Version:    0.7.0.1
 */