package com.tencent.mm.plugin.wallet.balance.model.lqt;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a;
import com.tencent.mm.al.b.a;
import com.tencent.mm.protocal.protobuf.bze;
import com.tencent.mm.protocal.protobuf.cbi;
import com.tencent.mm.protocal.protobuf.ckn;
import com.tencent.mm.protocal.protobuf.cko;
import com.tencent.mm.protocal.protobuf.ckp;
import com.tencent.mm.protocal.protobuf.dos;
import com.tencent.mm.protocal.protobuf.iu;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class CgiLqtPlanIndex
  extends a<cko>
{
  public CgiLqtPlanIndex()
  {
    AppMethodBeat.i(68434);
    b.a locala = new b.a();
    locala.hNM = new ckn();
    locala.hNN = new cko();
    locala.funcId = 2796;
    locala.uri = "/cgi-bin/mmpay-bin/planindex";
    locala.hNO = 0;
    locala.respCmdId = 0;
    c(locala.aDC());
    ad.i("MicroMsg.CgiLqtPlanIndex", "isfirstclick: %s");
    AppMethodBeat.o(68434);
  }
  
  public static PlanIndexParcel a(cko paramcko)
  {
    AppMethodBeat.i(68435);
    if (paramcko == null)
    {
      AppMethodBeat.o(68435);
      return null;
    }
    PlanIndexParcel localPlanIndexParcel = new PlanIndexParcel();
    localPlanIndexParcel.ozR = paramcko.ozR;
    localPlanIndexParcel.ozS = paramcko.ozS;
    Iterator localIterator1 = paramcko.HdZ.iterator();
    while (localIterator1.hasNext())
    {
      ckp localckp = (ckp)localIterator1.next();
      PlanItemParcel localPlanItemParcel = new PlanItemParcel();
      localPlanItemParcel.fKG = localckp.fKG;
      localPlanItemParcel.dOa = localckp.dOa;
      localPlanItemParcel.dkR = localckp.dkR;
      localPlanItemParcel.wCE = localckp.wCE;
      localPlanItemParcel.CwR = localckp.CwR;
      localPlanItemParcel.CwS = localckp.CwS;
      localPlanItemParcel.xSd = localckp.xSd;
      localPlanItemParcel.CwX = localckp.CwX;
      if (localckp.Hec != null)
      {
        localPlanItemParcel.CwT = new TransTipsItemParcel();
        localPlanItemParcel.CwT.CwY = localckp.Hec.CwY;
        localPlanItemParcel.CwT.hAD = localckp.Hec.hAD;
      }
      if (localckp.Hed != null)
      {
        localPlanItemParcel.CwU = new MoreRecordsParcel();
        localPlanItemParcel.CwU.title = localckp.Hed.title;
        localPlanItemParcel.CwU.url = localckp.Hed.url;
      }
      if (localckp.Hee != null)
      {
        localPlanItemParcel.CwV = new MngPlanItemParcel();
        localPlanItemParcel.CwV.CwI = localckp.Hee.CwI;
        localPlanItemParcel.CwV.CwJ = localckp.Hee.CwJ;
        Iterator localIterator2 = localckp.Hee.GUg.iterator();
        while (localIterator2.hasNext())
        {
          Integer localInteger = (Integer)localIterator2.next();
          localPlanItemParcel.CwV.CwK.add(localInteger);
        }
      }
      localPlanItemParcel.CwW = localckp.CwW;
      localPlanItemParcel.state = localckp.state;
      localPlanItemParcel.uJF = localckp.uJF;
      localPlanIndexParcel.CwL.add(localPlanItemParcel);
    }
    localPlanIndexParcel.CwM = paramcko.CwM;
    localPlanIndexParcel.CwN = paramcko.CwN;
    if (paramcko.Hea != null)
    {
      localPlanIndexParcel.CwO = new BannerParcel();
      localPlanIndexParcel.CwO.title = paramcko.Hea.title;
      localPlanIndexParcel.CwO.url = paramcko.Hea.url;
    }
    localPlanIndexParcel.CwP = paramcko.CwP;
    localPlanIndexParcel.CwQ = paramcko.CwQ;
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
    public boolean CwI;
    public String CwJ;
    public ArrayList<Integer> CwK;
    
    static
    {
      AppMethodBeat.i(68416);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(68416);
    }
    
    public MngPlanItemParcel()
    {
      AppMethodBeat.i(68414);
      this.CwK = new ArrayList();
      AppMethodBeat.o(68414);
    }
    
    protected MngPlanItemParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(68415);
      this.CwK = new ArrayList();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.CwI = bool;
        this.CwJ = paramParcel.readString();
        this.CwK = new ArrayList();
        paramParcel.readList(this.CwK, Integer.class.getClassLoader());
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
      if (this.CwI) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        paramParcel.writeString(this.CwJ);
        paramParcel.writeList(this.CwK);
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
    public ArrayList<CgiLqtPlanIndex.PlanItemParcel> CwL;
    public long CwM;
    public String CwN;
    public CgiLqtPlanIndex.BannerParcel CwO;
    public String CwP;
    public String CwQ;
    public int ozR;
    public String ozS;
    
    static
    {
      AppMethodBeat.i(68425);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(68425);
    }
    
    public PlanIndexParcel()
    {
      AppMethodBeat.i(68423);
      this.CwL = new ArrayList();
      AppMethodBeat.o(68423);
    }
    
    protected PlanIndexParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(68424);
      this.CwL = new ArrayList();
      this.ozR = paramParcel.readInt();
      this.ozS = paramParcel.readString();
      this.CwL = new ArrayList();
      paramParcel.readList(this.CwL, CgiLqtPlanIndex.PlanItemParcel.class.getClassLoader());
      this.CwM = paramParcel.readLong();
      this.CwN = paramParcel.readString();
      this.CwO = ((CgiLqtPlanIndex.BannerParcel)paramParcel.readParcelable(CgiLqtPlanIndex.BannerParcel.class.getClassLoader()));
      this.CwP = paramParcel.readString();
      this.CwQ = paramParcel.readString();
      AppMethodBeat.o(68424);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(68422);
      paramParcel.writeInt(this.ozR);
      paramParcel.writeString(this.ozS);
      paramParcel.writeList(this.CwL);
      paramParcel.writeLong(this.CwM);
      paramParcel.writeString(this.CwN);
      paramParcel.writeParcelable(this.CwO, paramInt);
      paramParcel.writeString(this.CwP);
      paramParcel.writeString(this.CwQ);
      AppMethodBeat.o(68422);
    }
  }
  
  public static class PlanItemParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<PlanItemParcel> CREATOR;
    public String CwR;
    public String CwS;
    public CgiLqtPlanIndex.TransTipsItemParcel CwT;
    public CgiLqtPlanIndex.MoreRecordsParcel CwU;
    public CgiLqtPlanIndex.MngPlanItemParcel CwV;
    public int CwW;
    public String CwX;
    public long dOa;
    public String dkR;
    public int fKG;
    public int state;
    public String uJF;
    public String wCE;
    public String xSd;
    
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
      this.fKG = paramParcel.readInt();
      this.dOa = paramParcel.readLong();
      this.dkR = paramParcel.readString();
      this.wCE = paramParcel.readString();
      this.CwR = paramParcel.readString();
      this.CwS = paramParcel.readString();
      this.CwT = ((CgiLqtPlanIndex.TransTipsItemParcel)paramParcel.readParcelable(CgiLqtPlanIndex.TransTipsItemParcel.class.getClassLoader()));
      this.CwU = ((CgiLqtPlanIndex.MoreRecordsParcel)paramParcel.readParcelable(CgiLqtPlanIndex.MoreRecordsParcel.class.getClassLoader()));
      this.CwV = ((CgiLqtPlanIndex.MngPlanItemParcel)paramParcel.readParcelable(CgiLqtPlanIndex.MngPlanItemParcel.class.getClassLoader()));
      this.CwW = paramParcel.readInt();
      this.state = paramParcel.readInt();
      this.uJF = paramParcel.readString();
      this.xSd = paramParcel.readString();
      this.CwX = paramParcel.readString();
      AppMethodBeat.o(68428);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(68427);
      paramParcel.writeInt(this.fKG);
      paramParcel.writeLong(this.dOa);
      paramParcel.writeString(this.dkR);
      paramParcel.writeString(this.wCE);
      paramParcel.writeString(this.CwR);
      paramParcel.writeString(this.CwS);
      paramParcel.writeParcelable(this.CwT, paramInt);
      paramParcel.writeParcelable(this.CwU, paramInt);
      paramParcel.writeParcelable(this.CwV, paramInt);
      paramParcel.writeInt(this.CwW);
      paramParcel.writeInt(this.state);
      paramParcel.writeString(this.uJF);
      paramParcel.writeString(this.xSd);
      paramParcel.writeString(this.CwX);
      AppMethodBeat.o(68427);
    }
  }
  
  public static class TransTipsItemParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<TransTipsItemParcel> CREATOR;
    public String CwY;
    public String hAD;
    
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
      this.CwY = paramParcel.readString();
      this.hAD = paramParcel.readString();
      AppMethodBeat.o(68432);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(68431);
      paramParcel.writeString(this.CwY);
      paramParcel.writeString(this.hAD);
      AppMethodBeat.o(68431);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.CgiLqtPlanIndex
 * JD-Core Version:    0.7.0.1
 */