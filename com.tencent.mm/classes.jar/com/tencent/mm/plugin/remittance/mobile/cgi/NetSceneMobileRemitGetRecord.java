package com.tencent.mm.plugin.remittance.mobile.cgi;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.box;
import com.tencent.mm.protocal.protobuf.dqb;
import com.tencent.mm.protocal.protobuf.dqc;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class NetSceneMobileRemitGetRecord
  extends a
{
  private final String TAG;
  private dqc ykT;
  
  public NetSceneMobileRemitGetRecord(String paramString1, String paramString2)
  {
    AppMethodBeat.i(67639);
    this.TAG = "MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord";
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new dqb();
    ((b.a)localObject).hQG = new dqc();
    ((b.a)localObject).funcId = 2993;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/transferphonegethisrcvrs";
    this.rr = ((b.a)localObject).aDS();
    localObject = (dqb)this.rr.hQD.hQJ;
    ((dqb)localObject).HXc = paramString1;
    ((dqb)localObject).HXd = paramString2;
    ae.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord", "do scene NetSceneMobileRemitGetRecord last_id:%s homepage_ext:%s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(67639);
  }
  
  public static ArrayList<HisRcvrParcel> aO(LinkedList<box> paramLinkedList)
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
      localArrayList.add(new HisRcvrParcel((box)paramLinkedList.next()));
    }
    AppMethodBeat.o(67641);
    return localArrayList;
  }
  
  public static ArrayList<box> fu(List<HisRcvrParcel> paramList)
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
      box localbox = new box();
      localbox.id = localHisRcvrParcel.id;
      localbox.ykU = localHisRcvrParcel.ykU;
      localbox.ykV = localHisRcvrParcel.ykV;
      localbox.oED = localHisRcvrParcel.oED;
      localbox.timestamp = localHisRcvrParcel.timestamp;
      localbox.ykW = localHisRcvrParcel.ykW;
      localArrayList.add(localbox);
    }
    AppMethodBeat.o(67642);
    return localArrayList;
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67640);
    ae.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.ykT = ((dqc)((b)paramq).hQE.hQJ);
    ae.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.ykT.oGt), this.ykT.oGu });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67640);
  }
  
  public final dqc dMm()
  {
    if (this.ykT == null) {
      return null;
    }
    return this.ykT;
  }
  
  public final void e(q paramq)
  {
    paramq = (dqc)((b)paramq).hQE.hQJ;
    this.LVj = paramq.oGt;
    this.LVk = paramq.oGu;
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
    public String oED;
    public long timestamp;
    public String ykU;
    public String ykV;
    public int ykW;
    
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
      this.ykU = paramParcel.readString();
      this.ykV = paramParcel.readString();
      this.oED = paramParcel.readString();
      this.timestamp = paramParcel.readLong();
      this.ykW = paramParcel.readInt();
      AppMethodBeat.o(67636);
    }
    
    protected HisRcvrParcel(box parambox)
    {
      this.id = parambox.id;
      this.ykU = parambox.ykU;
      this.ykV = parambox.ykV;
      this.oED = parambox.oED;
      this.timestamp = parambox.timestamp;
      this.ykW = parambox.ykW;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(67637);
      paramParcel.writeString(this.id);
      paramParcel.writeString(this.ykU);
      paramParcel.writeString(this.ykV);
      paramParcel.writeString(this.oED);
      paramParcel.writeLong(this.timestamp);
      paramParcel.writeInt(this.ykW);
      AppMethodBeat.o(67637);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.cgi.NetSceneMobileRemitGetRecord
 * JD-Core Version:    0.7.0.1
 */