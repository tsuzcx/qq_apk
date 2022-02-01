package com.tencent.mm.plugin.wallet.balance.model.lqt;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.protocal.protobuf.cpa;
import com.tencent.mm.protocal.protobuf.cre;
import com.tencent.mm.protocal.protobuf.dbr;
import com.tencent.mm.protocal.protobuf.dbs;
import com.tencent.mm.protocal.protobuf.dbt;
import com.tencent.mm.protocal.protobuf.ejl;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class CgiLqtPlanIndex
  extends c<dbs>
{
  public CgiLqtPlanIndex()
  {
    AppMethodBeat.i(68434);
    d.a locala = new d.a();
    locala.iLN = new dbr();
    locala.iLO = new dbs();
    locala.funcId = 2796;
    locala.uri = "/cgi-bin/mmpay-bin/planindex";
    locala.iLP = 0;
    locala.respCmdId = 0;
    c(locala.aXF());
    Log.i("MicroMsg.CgiLqtPlanIndex", "isfirstclick: %s");
    AppMethodBeat.o(68434);
  }
  
  public static PlanIndexParcel a(dbs paramdbs)
  {
    AppMethodBeat.i(68435);
    if (paramdbs == null)
    {
      AppMethodBeat.o(68435);
      return null;
    }
    PlanIndexParcel localPlanIndexParcel = new PlanIndexParcel();
    localPlanIndexParcel.pTZ = paramdbs.pTZ;
    localPlanIndexParcel.pUa = paramdbs.pUa;
    Iterator localIterator1 = paramdbs.MGC.iterator();
    while (localIterator1.hasNext())
    {
      dbt localdbt = (dbt)localIterator1.next();
      PlanItemParcel localPlanItemParcel = new PlanItemParcel();
      localPlanItemParcel.grV = localdbt.grV;
      localPlanItemParcel.eht = localdbt.eht;
      localPlanItemParcel.dDj = localdbt.dDj;
      localPlanItemParcel.AOk = localdbt.AOk;
      localPlanItemParcel.Htm = localdbt.Htm;
      localPlanItemParcel.Htn = localdbt.Htn;
      localPlanItemParcel.CiX = localdbt.CiX;
      localPlanItemParcel.Hts = localdbt.Hts;
      if (localdbt.MGF != null)
      {
        localPlanItemParcel.Hto = new TransTipsItemParcel();
        localPlanItemParcel.Hto.Htt = localdbt.MGF.Htt;
        localPlanItemParcel.Hto.ixw = localdbt.MGF.ixw;
      }
      if (localdbt.MGG != null)
      {
        localPlanItemParcel.Htp = new MoreRecordsParcel();
        localPlanItemParcel.Htp.title = localdbt.MGG.title;
        localPlanItemParcel.Htp.url = localdbt.MGG.url;
      }
      if (localdbt.MGH != null)
      {
        localPlanItemParcel.Htq = new MngPlanItemParcel();
        localPlanItemParcel.Htq.Htd = localdbt.MGH.Htd;
        localPlanItemParcel.Htq.Hte = localdbt.MGH.Hte;
        Iterator localIterator2 = localdbt.MGH.Mvb.iterator();
        while (localIterator2.hasNext())
        {
          Integer localInteger = (Integer)localIterator2.next();
          localPlanItemParcel.Htq.Htf.add(localInteger);
        }
      }
      localPlanItemParcel.Htr = localdbt.Htr;
      localPlanItemParcel.state = localdbt.state;
      localPlanItemParcel.ynT = localdbt.ynT;
      localPlanIndexParcel.Htg.add(localPlanItemParcel);
    }
    localPlanIndexParcel.Hth = paramdbs.Hth;
    localPlanIndexParcel.Hti = paramdbs.Hti;
    if (paramdbs.MGD != null)
    {
      localPlanIndexParcel.Htj = new BannerParcel();
      localPlanIndexParcel.Htj.title = paramdbs.MGD.title;
      localPlanIndexParcel.Htj.url = paramdbs.MGD.url;
    }
    localPlanIndexParcel.Htk = paramdbs.Htk;
    localPlanIndexParcel.Htl = paramdbs.Htl;
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
    public boolean Htd;
    public String Hte;
    public ArrayList<Integer> Htf;
    
    static
    {
      AppMethodBeat.i(68416);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(68416);
    }
    
    public MngPlanItemParcel()
    {
      AppMethodBeat.i(68414);
      this.Htf = new ArrayList();
      AppMethodBeat.o(68414);
    }
    
    protected MngPlanItemParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(68415);
      this.Htf = new ArrayList();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.Htd = bool;
        this.Hte = paramParcel.readString();
        this.Htf = new ArrayList();
        paramParcel.readList(this.Htf, Integer.class.getClassLoader());
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
      if (this.Htd) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        paramParcel.writeString(this.Hte);
        paramParcel.writeList(this.Htf);
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
    public ArrayList<CgiLqtPlanIndex.PlanItemParcel> Htg;
    public long Hth;
    public String Hti;
    public CgiLqtPlanIndex.BannerParcel Htj;
    public String Htk;
    public String Htl;
    public int pTZ;
    public String pUa;
    
    static
    {
      AppMethodBeat.i(68425);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(68425);
    }
    
    public PlanIndexParcel()
    {
      AppMethodBeat.i(68423);
      this.Htg = new ArrayList();
      AppMethodBeat.o(68423);
    }
    
    protected PlanIndexParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(68424);
      this.Htg = new ArrayList();
      this.pTZ = paramParcel.readInt();
      this.pUa = paramParcel.readString();
      this.Htg = new ArrayList();
      paramParcel.readList(this.Htg, CgiLqtPlanIndex.PlanItemParcel.class.getClassLoader());
      this.Hth = paramParcel.readLong();
      this.Hti = paramParcel.readString();
      this.Htj = ((CgiLqtPlanIndex.BannerParcel)paramParcel.readParcelable(CgiLqtPlanIndex.BannerParcel.class.getClassLoader()));
      this.Htk = paramParcel.readString();
      this.Htl = paramParcel.readString();
      AppMethodBeat.o(68424);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(68422);
      paramParcel.writeInt(this.pTZ);
      paramParcel.writeString(this.pUa);
      paramParcel.writeList(this.Htg);
      paramParcel.writeLong(this.Hth);
      paramParcel.writeString(this.Hti);
      paramParcel.writeParcelable(this.Htj, paramInt);
      paramParcel.writeString(this.Htk);
      paramParcel.writeString(this.Htl);
      AppMethodBeat.o(68422);
    }
  }
  
  public static class PlanItemParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<PlanItemParcel> CREATOR;
    public String AOk;
    public String CiX;
    public String Htm;
    public String Htn;
    public CgiLqtPlanIndex.TransTipsItemParcel Hto;
    public CgiLqtPlanIndex.MoreRecordsParcel Htp;
    public CgiLqtPlanIndex.MngPlanItemParcel Htq;
    public int Htr;
    public String Hts;
    public String dDj;
    public long eht;
    public int grV;
    public int state;
    public String ynT;
    
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
      this.grV = paramParcel.readInt();
      this.eht = paramParcel.readLong();
      this.dDj = paramParcel.readString();
      this.AOk = paramParcel.readString();
      this.Htm = paramParcel.readString();
      this.Htn = paramParcel.readString();
      this.Hto = ((CgiLqtPlanIndex.TransTipsItemParcel)paramParcel.readParcelable(CgiLqtPlanIndex.TransTipsItemParcel.class.getClassLoader()));
      this.Htp = ((CgiLqtPlanIndex.MoreRecordsParcel)paramParcel.readParcelable(CgiLqtPlanIndex.MoreRecordsParcel.class.getClassLoader()));
      this.Htq = ((CgiLqtPlanIndex.MngPlanItemParcel)paramParcel.readParcelable(CgiLqtPlanIndex.MngPlanItemParcel.class.getClassLoader()));
      this.Htr = paramParcel.readInt();
      this.state = paramParcel.readInt();
      this.ynT = paramParcel.readString();
      this.CiX = paramParcel.readString();
      this.Hts = paramParcel.readString();
      AppMethodBeat.o(68428);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(68427);
      paramParcel.writeInt(this.grV);
      paramParcel.writeLong(this.eht);
      paramParcel.writeString(this.dDj);
      paramParcel.writeString(this.AOk);
      paramParcel.writeString(this.Htm);
      paramParcel.writeString(this.Htn);
      paramParcel.writeParcelable(this.Hto, paramInt);
      paramParcel.writeParcelable(this.Htp, paramInt);
      paramParcel.writeParcelable(this.Htq, paramInt);
      paramParcel.writeInt(this.Htr);
      paramParcel.writeInt(this.state);
      paramParcel.writeString(this.ynT);
      paramParcel.writeString(this.CiX);
      paramParcel.writeString(this.Hts);
      AppMethodBeat.o(68427);
    }
  }
  
  public static class TransTipsItemParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<TransTipsItemParcel> CREATOR;
    public String Htt;
    public String ixw;
    
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
      this.Htt = paramParcel.readString();
      this.ixw = paramParcel.readString();
      AppMethodBeat.o(68432);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(68431);
      paramParcel.writeString(this.Htt);
      paramParcel.writeString(this.ixw);
      AppMethodBeat.o(68431);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.CgiLqtPlanIndex
 * JD-Core Version:    0.7.0.1
 */