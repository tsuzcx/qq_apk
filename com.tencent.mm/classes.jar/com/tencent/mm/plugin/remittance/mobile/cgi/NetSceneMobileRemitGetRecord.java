package com.tencent.mm.plugin.remittance.mobile.cgi;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cbp;
import com.tencent.mm.protocal.protobuf.ejx;
import com.tencent.mm.protocal.protobuf.ejy;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class NetSceneMobileRemitGetRecord
  extends a
{
  private ejy ClT;
  private final String TAG;
  
  public NetSceneMobileRemitGetRecord(String paramString1, String paramString2)
  {
    AppMethodBeat.i(67639);
    this.TAG = "MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord";
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new ejx();
    ((d.a)localObject).iLO = new ejy();
    ((d.a)localObject).funcId = 2993;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/transferphonegethisrcvrs";
    this.rr = ((d.a)localObject).aXF();
    localObject = (ejx)this.rr.iLK.iLR;
    ((ejx)localObject).Nji = paramString1;
    ((ejx)localObject).Njj = paramString2;
    Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord", "do scene NetSceneMobileRemitGetRecord last_id:%s homepage_ext:%s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(67639);
  }
  
  public static ArrayList<HisRcvrParcel> bl(LinkedList<cbp> paramLinkedList)
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
      localArrayList.add(new HisRcvrParcel((cbp)paramLinkedList.next()));
    }
    AppMethodBeat.o(67641);
    return localArrayList;
  }
  
  public static ArrayList<cbp> gp(List<HisRcvrParcel> paramList)
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
      cbp localcbp = new cbp();
      localcbp.id = localHisRcvrParcel.id;
      localcbp.ClU = localHisRcvrParcel.ClU;
      localcbp.ClV = localHisRcvrParcel.ClV;
      localcbp.pSm = localHisRcvrParcel.pSm;
      localcbp.timestamp = localHisRcvrParcel.timestamp;
      localcbp.ClW = localHisRcvrParcel.ClW;
      localArrayList.add(localcbp);
    }
    AppMethodBeat.o(67642);
    return localArrayList;
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(67640);
    Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.ClT = ((ejy)((d)params).iLL.iLR);
    Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.ClT.pTZ), this.ClT.pUa });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67640);
  }
  
  public final void e(s params)
  {
    params = (ejy)((d)params).iLL.iLR;
    this.RtZ = params.pTZ;
    this.Rua = params.pUa;
  }
  
  public final ejy eNm()
  {
    if (this.ClT == null) {
      return null;
    }
    return this.ClT;
  }
  
  public final int getType()
  {
    return 2993;
  }
  
  public static class HisRcvrParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<HisRcvrParcel> CREATOR;
    public String ClU;
    public String ClV;
    public int ClW;
    public String id;
    public String pSm;
    public long timestamp;
    
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
      this.ClU = paramParcel.readString();
      this.ClV = paramParcel.readString();
      this.pSm = paramParcel.readString();
      this.timestamp = paramParcel.readLong();
      this.ClW = paramParcel.readInt();
      AppMethodBeat.o(67636);
    }
    
    protected HisRcvrParcel(cbp paramcbp)
    {
      this.id = paramcbp.id;
      this.ClU = paramcbp.ClU;
      this.ClV = paramcbp.ClV;
      this.pSm = paramcbp.pSm;
      this.timestamp = paramcbp.timestamp;
      this.ClW = paramcbp.ClW;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(67637);
      paramParcel.writeString(this.id);
      paramParcel.writeString(this.ClU);
      paramParcel.writeString(this.ClV);
      paramParcel.writeString(this.pSm);
      paramParcel.writeLong(this.timestamp);
      paramParcel.writeInt(this.ClW);
      AppMethodBeat.o(67637);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.cgi.NetSceneMobileRemitGetRecord
 * JD-Core Version:    0.7.0.1
 */