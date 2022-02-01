package com.tencent.mm.plugin.remittance.mobile.cgi;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.czx;
import com.tencent.mm.protocal.protobuf.fpo;
import com.tencent.mm.protocal.protobuf.fpp;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class NetSceneMobileRemitGetRecord
  extends a
{
  private fpp Ofx;
  private final String TAG;
  
  public NetSceneMobileRemitGetRecord(String paramString1, String paramString2)
  {
    AppMethodBeat.i(67639);
    this.TAG = "MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord";
    Object localObject = new c.a();
    ((c.a)localObject).otE = new fpo();
    ((c.a)localObject).otF = new fpp();
    ((c.a)localObject).funcId = 2993;
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/transferphonegethisrcvrs";
    this.rr = ((c.a)localObject).bEF();
    localObject = (fpo)c.b.b(this.rr.otB);
    ((fpo)localObject).abPv = paramString1;
    ((fpo)localObject).abPw = paramString2;
    Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord", "do scene NetSceneMobileRemitGetRecord last_id:%s homepage_ext:%s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(67639);
  }
  
  public static ArrayList<HisRcvrParcel> bO(LinkedList<czx> paramLinkedList)
  {
    AppMethodBeat.i(67641);
    if (paramLinkedList == null)
    {
      AppMethodBeat.o(67641);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext()) {
      localArrayList.add(new HisRcvrParcel((czx)paramLinkedList.next()));
    }
    AppMethodBeat.o(67641);
    return localArrayList;
  }
  
  public static ArrayList<czx> jV(List<HisRcvrParcel> paramList)
  {
    AppMethodBeat.i(67642);
    if (paramList == null)
    {
      AppMethodBeat.o(67642);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      HisRcvrParcel localHisRcvrParcel = (HisRcvrParcel)paramList.next();
      czx localczx = new czx();
      localczx.id = localHisRcvrParcel.id;
      localczx.Ofy = localHisRcvrParcel.Ofy;
      localczx.Ofz = localHisRcvrParcel.Ofz;
      localczx.wsM = localHisRcvrParcel.wsM;
      localczx.timestamp = localHisRcvrParcel.timestamp;
      localczx.OfA = localHisRcvrParcel.OfA;
      localArrayList.add(localczx);
    }
    AppMethodBeat.o(67642);
    return localArrayList;
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(67640);
    Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.Ofx = ((fpp)c.c.b(((c)params).otC));
    Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.Ofx.wuz), this.Ofx.wuA });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67640);
  }
  
  public final void f(s params)
  {
    AppMethodBeat.i(288879);
    params = (fpp)c.c.b(((c)params).otC);
    this.agTs = params.wuz;
    this.agTt = params.wuA;
    AppMethodBeat.o(288879);
  }
  
  public final fpp gLN()
  {
    if (this.Ofx == null) {
      return null;
    }
    return this.Ofx;
  }
  
  public final int getType()
  {
    return 2993;
  }
  
  public static class HisRcvrParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<HisRcvrParcel> CREATOR;
    public int OfA;
    public String Ofy;
    public String Ofz;
    public String id;
    public long timestamp;
    public String wsM;
    
    static
    {
      AppMethodBeat.i(67638);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(67638);
    }
    
    public HisRcvrParcel() {}
    
    protected HisRcvrParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(67636);
      this.id = paramParcel.readString();
      this.Ofy = paramParcel.readString();
      this.Ofz = paramParcel.readString();
      this.wsM = paramParcel.readString();
      this.timestamp = paramParcel.readLong();
      this.OfA = paramParcel.readInt();
      AppMethodBeat.o(67636);
    }
    
    protected HisRcvrParcel(czx paramczx)
    {
      this.id = paramczx.id;
      this.Ofy = paramczx.Ofy;
      this.Ofz = paramczx.Ofz;
      this.wsM = paramczx.wsM;
      this.timestamp = paramczx.timestamp;
      this.OfA = paramczx.OfA;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(67637);
      paramParcel.writeString(this.id);
      paramParcel.writeString(this.Ofy);
      paramParcel.writeString(this.Ofz);
      paramParcel.writeString(this.wsM);
      paramParcel.writeLong(this.timestamp);
      paramParcel.writeInt(this.OfA);
      AppMethodBeat.o(67637);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.cgi.NetSceneMobileRemitGetRecord
 * JD-Core Version:    0.7.0.1
 */