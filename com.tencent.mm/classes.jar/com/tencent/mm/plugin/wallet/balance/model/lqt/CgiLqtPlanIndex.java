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
import com.tencent.mm.protocal.protobuf.czv;
import com.tencent.mm.protocal.protobuf.dlg;
import com.tencent.mm.protocal.protobuf.dlh;
import com.tencent.mm.protocal.protobuf.dli;
import com.tencent.mm.protocal.protobuf.etn;
import com.tencent.mm.protocal.protobuf.iw;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class CgiLqtPlanIndex
  extends c<dlh>
{
  public CgiLqtPlanIndex()
  {
    AppMethodBeat.i(68434);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new dlg();
    ((d.a)localObject).lBV = new dlh();
    ((d.a)localObject).funcId = 2796;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/planindex";
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    localObject = ((d.a)localObject).bgN();
    d.b.b(((d)localObject).lBR);
    c((d)localObject);
    Log.i("MicroMsg.CgiLqtPlanIndex", "isfirstclick: %s");
    AppMethodBeat.o(68434);
  }
  
  public static PlanIndexParcel a(dlh paramdlh)
  {
    AppMethodBeat.i(68435);
    if (paramdlh == null)
    {
      AppMethodBeat.o(68435);
      return null;
    }
    PlanIndexParcel localPlanIndexParcel = new PlanIndexParcel();
    localPlanIndexParcel.tqa = paramdlh.tqa;
    localPlanIndexParcel.tqb = paramdlh.tqb;
    Iterator localIterator1 = paramdlh.TSp.iterator();
    while (localIterator1.hasNext())
    {
      dli localdli = (dli)localIterator1.next();
      PlanItemParcel localPlanItemParcel = new PlanItemParcel();
      localPlanItemParcel.day = localdli.day;
      localPlanItemParcel.gbJ = localdli.gbJ;
      localPlanItemParcel.fvP = localdli.fvP;
      localPlanItemParcel.GHy = localdli.GHy;
      localPlanItemParcel.OkX = localdli.OkX;
      localPlanItemParcel.OkY = localdli.OkY;
      localPlanItemParcel.IfQ = localdli.IfQ;
      localPlanItemParcel.Old = localdli.Old;
      if (localdli.TSs != null)
      {
        localPlanItemParcel.OkZ = new TransTipsItemParcel();
        localPlanItemParcel.OkZ.Ole = localdli.TSs.Ole;
        localPlanItemParcel.OkZ.lmL = localdli.TSs.lmL;
      }
      if (localdli.TSt != null)
      {
        localPlanItemParcel.Ola = new MoreRecordsParcel();
        localPlanItemParcel.Ola.title = localdli.TSt.title;
        localPlanItemParcel.Ola.url = localdli.TSt.url;
      }
      if (localdli.TSu != null)
      {
        localPlanItemParcel.Olb = new MngPlanItemParcel();
        localPlanItemParcel.Olb.OkO = localdli.TSu.OkO;
        localPlanItemParcel.Olb.OkP = localdli.TSu.OkP;
        Iterator localIterator2 = localdli.TSu.TFZ.iterator();
        while (localIterator2.hasNext())
        {
          Integer localInteger = (Integer)localIterator2.next();
          localPlanItemParcel.Olb.OkQ.add(localInteger);
        }
      }
      localPlanItemParcel.Olc = localdli.Olc;
      localPlanItemParcel.state = localdli.state;
      localPlanItemParcel.DNV = localdli.DNV;
      localPlanIndexParcel.OkR.add(localPlanItemParcel);
    }
    localPlanIndexParcel.OkS = paramdlh.OkS;
    localPlanIndexParcel.OkT = paramdlh.OkT;
    if (paramdlh.TSq != null)
    {
      localPlanIndexParcel.OkU = new BannerParcel();
      localPlanIndexParcel.OkU.title = paramdlh.TSq.title;
      localPlanIndexParcel.OkU.url = paramdlh.TSq.url;
    }
    localPlanIndexParcel.OkV = paramdlh.OkV;
    localPlanIndexParcel.OkW = paramdlh.OkW;
    AppMethodBeat.o(68435);
    return localPlanIndexParcel;
  }
  
  public static dlh a(PlanIndexParcel paramPlanIndexParcel)
  {
    AppMethodBeat.i(276118);
    if (paramPlanIndexParcel == null)
    {
      AppMethodBeat.o(276118);
      return null;
    }
    dlh localdlh = new dlh();
    localdlh.tqa = paramPlanIndexParcel.tqa;
    localdlh.tqb = paramPlanIndexParcel.tqb;
    Iterator localIterator1 = paramPlanIndexParcel.OkR.iterator();
    while (localIterator1.hasNext())
    {
      PlanItemParcel localPlanItemParcel = (PlanItemParcel)localIterator1.next();
      dli localdli = new dli();
      localdli.day = localPlanItemParcel.day;
      localdli.gbJ = localPlanItemParcel.gbJ;
      localdli.fvP = localPlanItemParcel.fvP;
      localdli.GHy = localPlanItemParcel.GHy;
      localdli.OkX = localPlanItemParcel.OkX;
      localdli.OkY = localPlanItemParcel.OkY;
      localdli.Old = localPlanItemParcel.Old;
      localdli.IfQ = localPlanItemParcel.IfQ;
      if (localPlanItemParcel.OkZ != null)
      {
        localdli.TSs = new etn();
        localdli.TSs.Ole = localPlanItemParcel.OkZ.Ole;
        localdli.TSs.lmL = localPlanItemParcel.OkZ.lmL;
      }
      if (localPlanItemParcel.Ola != null)
      {
        localdli.TSt = new czv();
        localdli.TSt.title = localPlanItemParcel.Ola.title;
        localdli.TSt.url = localPlanItemParcel.Ola.url;
      }
      if (localPlanItemParcel.Olb != null)
      {
        localdli.TSu = new cxq();
        localdli.TSu.OkO = localPlanItemParcel.Olb.OkO;
        localdli.TSu.OkP = localPlanItemParcel.Olb.OkP;
        Iterator localIterator2 = localPlanItemParcel.Olb.OkQ.iterator();
        while (localIterator2.hasNext())
        {
          Integer localInteger = (Integer)localIterator2.next();
          localdli.TSu.TFZ.add(localInteger);
        }
      }
      localdli.Olc = localPlanItemParcel.Olc;
      localdli.state = localPlanItemParcel.state;
      localdli.DNV = localPlanItemParcel.DNV;
      localdlh.TSp.add(localdli);
    }
    localdlh.OkS = paramPlanIndexParcel.OkS;
    localdlh.OkT = paramPlanIndexParcel.OkT;
    if (paramPlanIndexParcel.OkU != null)
    {
      localdlh.TSq = new iw();
      localdlh.TSq.title = paramPlanIndexParcel.OkU.title;
      localdlh.TSq.url = paramPlanIndexParcel.OkU.url;
    }
    localdlh.OkV = paramPlanIndexParcel.OkV;
    localdlh.OkW = paramPlanIndexParcel.OkW;
    AppMethodBeat.o(276118);
    return localdlh;
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
    public boolean OkO;
    public String OkP;
    public ArrayList<Integer> OkQ;
    
    static
    {
      AppMethodBeat.i(68416);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(68416);
    }
    
    public MngPlanItemParcel()
    {
      AppMethodBeat.i(68414);
      this.OkQ = new ArrayList();
      AppMethodBeat.o(68414);
    }
    
    protected MngPlanItemParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(68415);
      this.OkQ = new ArrayList();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.OkO = bool;
        this.OkP = paramParcel.readString();
        this.OkQ = new ArrayList();
        paramParcel.readList(this.OkQ, Integer.class.getClassLoader());
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
      if (this.OkO) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        paramParcel.writeString(this.OkP);
        paramParcel.writeList(this.OkQ);
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
    public ArrayList<CgiLqtPlanIndex.PlanItemParcel> OkR;
    public long OkS;
    public String OkT;
    public CgiLqtPlanIndex.BannerParcel OkU;
    public String OkV;
    public String OkW;
    public int tqa;
    public String tqb;
    
    static
    {
      AppMethodBeat.i(68425);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(68425);
    }
    
    public PlanIndexParcel()
    {
      AppMethodBeat.i(68423);
      this.OkR = new ArrayList();
      AppMethodBeat.o(68423);
    }
    
    protected PlanIndexParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(68424);
      this.OkR = new ArrayList();
      this.tqa = paramParcel.readInt();
      this.tqb = paramParcel.readString();
      this.OkR = new ArrayList();
      paramParcel.readList(this.OkR, CgiLqtPlanIndex.PlanItemParcel.class.getClassLoader());
      this.OkS = paramParcel.readLong();
      this.OkT = paramParcel.readString();
      this.OkU = ((CgiLqtPlanIndex.BannerParcel)paramParcel.readParcelable(CgiLqtPlanIndex.BannerParcel.class.getClassLoader()));
      this.OkV = paramParcel.readString();
      this.OkW = paramParcel.readString();
      AppMethodBeat.o(68424);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(68422);
      paramParcel.writeInt(this.tqa);
      paramParcel.writeString(this.tqb);
      paramParcel.writeList(this.OkR);
      paramParcel.writeLong(this.OkS);
      paramParcel.writeString(this.OkT);
      paramParcel.writeParcelable(this.OkU, paramInt);
      paramParcel.writeString(this.OkV);
      paramParcel.writeString(this.OkW);
      AppMethodBeat.o(68422);
    }
  }
  
  static class PlanItemParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<PlanItemParcel> CREATOR;
    public String DNV;
    public String GHy;
    public String IfQ;
    public String OkX;
    public String OkY;
    public CgiLqtPlanIndex.TransTipsItemParcel OkZ;
    public CgiLqtPlanIndex.MoreRecordsParcel Ola;
    public CgiLqtPlanIndex.MngPlanItemParcel Olb;
    public int Olc;
    public String Old;
    public int day;
    public String fvP;
    public long gbJ;
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
      this.gbJ = paramParcel.readLong();
      this.fvP = paramParcel.readString();
      this.GHy = paramParcel.readString();
      this.OkX = paramParcel.readString();
      this.OkY = paramParcel.readString();
      this.OkZ = ((CgiLqtPlanIndex.TransTipsItemParcel)paramParcel.readParcelable(CgiLqtPlanIndex.TransTipsItemParcel.class.getClassLoader()));
      this.Ola = ((CgiLqtPlanIndex.MoreRecordsParcel)paramParcel.readParcelable(CgiLqtPlanIndex.MoreRecordsParcel.class.getClassLoader()));
      this.Olb = ((CgiLqtPlanIndex.MngPlanItemParcel)paramParcel.readParcelable(CgiLqtPlanIndex.MngPlanItemParcel.class.getClassLoader()));
      this.Olc = paramParcel.readInt();
      this.state = paramParcel.readInt();
      this.DNV = paramParcel.readString();
      this.IfQ = paramParcel.readString();
      this.Old = paramParcel.readString();
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
      paramParcel.writeLong(this.gbJ);
      paramParcel.writeString(this.fvP);
      paramParcel.writeString(this.GHy);
      paramParcel.writeString(this.OkX);
      paramParcel.writeString(this.OkY);
      paramParcel.writeParcelable(this.OkZ, paramInt);
      paramParcel.writeParcelable(this.Ola, paramInt);
      paramParcel.writeParcelable(this.Olb, paramInt);
      paramParcel.writeInt(this.Olc);
      paramParcel.writeInt(this.state);
      paramParcel.writeString(this.DNV);
      paramParcel.writeString(this.IfQ);
      paramParcel.writeString(this.Old);
      AppMethodBeat.o(68427);
    }
  }
  
  static class TransTipsItemParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<TransTipsItemParcel> CREATOR;
    public String Ole;
    public String lmL;
    
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
      this.Ole = paramParcel.readString();
      this.lmL = paramParcel.readString();
      AppMethodBeat.o(68432);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(68431);
      paramParcel.writeString(this.Ole);
      paramParcel.writeString(this.lmL);
      AppMethodBeat.o(68431);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.CgiLqtPlanIndex
 * JD-Core Version:    0.7.0.1
 */