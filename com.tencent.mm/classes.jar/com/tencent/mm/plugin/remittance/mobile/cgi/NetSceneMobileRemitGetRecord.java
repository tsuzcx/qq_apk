package com.tencent.mm.plugin.remittance.mobile.cgi;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bjx;
import com.tencent.mm.protocal.protobuf.djp;
import com.tencent.mm.protocal.protobuf.djq;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class NetSceneMobileRemitGetRecord
  extends a
{
  private final String TAG;
  private djq wHt;
  
  public NetSceneMobileRemitGetRecord(String paramString1, String paramString2)
  {
    AppMethodBeat.i(67639);
    this.TAG = "MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord";
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new djp();
    ((b.a)localObject).hvu = new djq();
    ((b.a)localObject).funcId = 2993;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/transferphonegethisrcvrs";
    this.rr = ((b.a)localObject).aAz();
    localObject = (djp)this.rr.hvr.hvw;
    ((djp)localObject).FSG = paramString1;
    ((djp)localObject).FSH = paramString2;
    ac.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord", "do scene NetSceneMobileRemitGetRecord last_id:%s homepage_ext:%s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(67639);
  }
  
  public static ArrayList<HisRcvrParcel> aM(LinkedList<bjx> paramLinkedList)
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
      localArrayList.add(new HisRcvrParcel((bjx)paramLinkedList.next()));
    }
    AppMethodBeat.o(67641);
    return localArrayList;
  }
  
  public static ArrayList<bjx> eZ(List<HisRcvrParcel> paramList)
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
      bjx localbjx = new bjx();
      localbjx.id = localHisRcvrParcel.id;
      localbjx.wHu = localHisRcvrParcel.wHu;
      localbjx.wHv = localHisRcvrParcel.wHv;
      localbjx.nUG = localHisRcvrParcel.nUG;
      localbjx.timestamp = localHisRcvrParcel.timestamp;
      localbjx.wHw = localHisRcvrParcel.wHw;
      localArrayList.add(localbjx);
    }
    AppMethodBeat.o(67642);
    return localArrayList;
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67640);
    ac.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.wHt = ((djq)((b)paramq).hvs.hvw);
    ac.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.wHt.nWx), this.wHt.nWy });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67640);
  }
  
  public final djq dxD()
  {
    if (this.wHt == null) {
      return null;
    }
    return this.wHt;
  }
  
  public final void e(q paramq)
  {
    paramq = (djq)((b)paramq).hvs.hvw;
    this.JFq = paramq.nWx;
    this.JFr = paramq.nWy;
  }
  
  public final int getType()
  {
    return 2993;
  }
  
  public static class HisRcvrParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<HisRcvrParcel> CREATOR;
    public String id;
    public String nUG;
    public long timestamp;
    public String wHu;
    public String wHv;
    public int wHw;
    
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
      this.wHu = paramParcel.readString();
      this.wHv = paramParcel.readString();
      this.nUG = paramParcel.readString();
      this.timestamp = paramParcel.readLong();
      this.wHw = paramParcel.readInt();
      AppMethodBeat.o(67636);
    }
    
    protected HisRcvrParcel(bjx parambjx)
    {
      this.id = parambjx.id;
      this.wHu = parambjx.wHu;
      this.wHv = parambjx.wHv;
      this.nUG = parambjx.nUG;
      this.timestamp = parambjx.timestamp;
      this.wHw = parambjx.wHw;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(67637);
      paramParcel.writeString(this.id);
      paramParcel.writeString(this.wHu);
      paramParcel.writeString(this.wHv);
      paramParcel.writeString(this.nUG);
      paramParcel.writeLong(this.timestamp);
      paramParcel.writeInt(this.wHw);
      AppMethodBeat.o(67637);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.cgi.NetSceneMobileRemitGetRecord
 * JD-Core Version:    0.7.0.1
 */