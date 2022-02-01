package com.tencent.mm.plugin.remittance.mobile.cgi;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bgf;
import com.tencent.mm.protocal.protobuf.dea;
import com.tencent.mm.protocal.protobuf.deb;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class NetSceneMobileRemitGetRecord
  extends a
{
  private final String TAG;
  private deb vxo;
  
  public NetSceneMobileRemitGetRecord(String paramString1, String paramString2)
  {
    AppMethodBeat.i(67639);
    this.TAG = "MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord";
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new dea();
    ((b.a)localObject).gUV = new deb();
    ((b.a)localObject).funcId = 2993;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/transferphonegethisrcvrs";
    this.rr = ((b.a)localObject).atI();
    localObject = (dea)this.rr.gUS.gUX;
    ((dea)localObject).EvD = paramString1;
    ((dea)localObject).EvE = paramString2;
    ad.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord", "do scene NetSceneMobileRemitGetRecord last_id:%s homepage_ext:%s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(67639);
  }
  
  public static ArrayList<HisRcvrParcel> aF(LinkedList<bgf> paramLinkedList)
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
      localArrayList.add(new HisRcvrParcel((bgf)paramLinkedList.next()));
    }
    AppMethodBeat.o(67641);
    return localArrayList;
  }
  
  public static ArrayList<bgf> eT(List<HisRcvrParcel> paramList)
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
      bgf localbgf = new bgf();
      localbgf.id = localHisRcvrParcel.id;
      localbgf.vxp = localHisRcvrParcel.vxp;
      localbgf.vxq = localHisRcvrParcel.vxq;
      localbgf.nrG = localHisRcvrParcel.nrG;
      localbgf.timestamp = localHisRcvrParcel.timestamp;
      localbgf.vxr = localHisRcvrParcel.vxr;
      localArrayList.add(localbgf);
    }
    AppMethodBeat.o(67642);
    return localArrayList;
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67640);
    ad.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.vxo = ((deb)((b)paramq).gUT.gUX);
    ad.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.vxo.ntx), this.vxo.nty });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67640);
  }
  
  public final deb djB()
  {
    if (this.vxo == null) {
      return null;
    }
    return this.vxo;
  }
  
  public final void e(q paramq)
  {
    paramq = (deb)((b)paramq).gUT.gUX;
    this.IdO = paramq.ntx;
    this.IdP = paramq.nty;
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
    public String nrG;
    public long timestamp;
    public String vxp;
    public String vxq;
    public int vxr;
    
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
      this.vxp = paramParcel.readString();
      this.vxq = paramParcel.readString();
      this.nrG = paramParcel.readString();
      this.timestamp = paramParcel.readLong();
      this.vxr = paramParcel.readInt();
      AppMethodBeat.o(67636);
    }
    
    protected HisRcvrParcel(bgf parambgf)
    {
      this.id = parambgf.id;
      this.vxp = parambgf.vxp;
      this.vxq = parambgf.vxq;
      this.nrG = parambgf.nrG;
      this.timestamp = parambgf.timestamp;
      this.vxr = parambgf.vxr;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(67637);
      paramParcel.writeString(this.id);
      paramParcel.writeString(this.vxp);
      paramParcel.writeString(this.vxq);
      paramParcel.writeString(this.nrG);
      paramParcel.writeLong(this.timestamp);
      paramParcel.writeInt(this.vxr);
      AppMethodBeat.o(67637);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.cgi.NetSceneMobileRemitGetRecord
 * JD-Core Version:    0.7.0.1
 */