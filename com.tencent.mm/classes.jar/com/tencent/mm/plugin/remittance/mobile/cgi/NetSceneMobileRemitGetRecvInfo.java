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
import com.tencent.mm.protocal.protobuf.aed;
import com.tencent.mm.protocal.protobuf.dqd;
import com.tencent.mm.protocal.protobuf.dqe;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class NetSceneMobileRemitGetRecvInfo
  extends a
{
  private final String TAG;
  public String oED;
  public String ykX;
  private dqe ykY;
  
  public NetSceneMobileRemitGetRecvInfo(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(67647);
    this.TAG = "MicroMsg.mobileRemit.NetSceneMobileRemitGetRecvInfo";
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new dqd();
    ((b.a)localObject).hQG = new dqe();
    ((b.a)localObject).funcId = 1495;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/transferphonegetrcvr";
    this.rr = ((b.a)localObject).aDS();
    localObject = (dqd)this.rr.hQD.hQJ;
    ((dqd)localObject).oED = paramString1;
    ((dqd)localObject).HXb = paramString2;
    ((dqd)localObject).HXd = paramString3;
    ((dqd)localObject).HGI = paramInt;
    ae.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecvInfo", "do scene NetSceneMobileRemitGetRecvInfo phone:%s rcvr_id:%s input_type:%s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    this.ykX = paramString2;
    this.oED = paramString1;
    AppMethodBeat.o(67647);
  }
  
  public static ArrayList<DelayOptionParcel> aP(LinkedList<aed> paramLinkedList)
  {
    AppMethodBeat.i(67649);
    if (paramLinkedList == null)
    {
      AppMethodBeat.o(67649);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext()) {
      localArrayList.add(new DelayOptionParcel((aed)paramLinkedList.next()));
    }
    AppMethodBeat.o(67649);
    return localArrayList;
  }
  
  public static ArrayList<aed> fv(List<DelayOptionParcel> paramList)
  {
    AppMethodBeat.i(67650);
    if (paramList == null)
    {
      AppMethodBeat.o(67650);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      DelayOptionParcel localDelayOptionParcel = (DelayOptionParcel)paramList.next();
      aed localaed = new aed();
      localaed.ykZ = localDelayOptionParcel.ykZ;
      localaed.code = localDelayOptionParcel.code;
      localArrayList.add(localaed);
    }
    AppMethodBeat.o(67650);
    return localArrayList;
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67648);
    ae.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecvInfo", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.ykY = ((dqe)((b)paramq).hQE.hQJ);
    ae.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecvInfo", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.ykY.oGt), this.ykY.oGu });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67648);
  }
  
  public final dqe dMn()
  {
    if (this.ykY == null) {
      return null;
    }
    return this.ykY;
  }
  
  public final void e(q paramq)
  {
    paramq = (dqe)((b)paramq).hQE.hQJ;
    this.LVj = paramq.oGt;
    this.LVk = paramq.oGu;
  }
  
  public final int getType()
  {
    return 1495;
  }
  
  public static class DelayOptionParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<DelayOptionParcel> CREATOR;
    public int code;
    public String ykZ;
    
    static
    {
      AppMethodBeat.i(67646);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(67646);
    }
    
    public DelayOptionParcel() {}
    
    protected DelayOptionParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(67645);
      this.ykZ = paramParcel.readString();
      this.code = paramParcel.readInt();
      AppMethodBeat.o(67645);
    }
    
    protected DelayOptionParcel(aed paramaed)
    {
      this.ykZ = paramaed.ykZ;
      this.code = paramaed.code;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(67644);
      paramParcel.writeString(this.ykZ);
      paramParcel.writeInt(this.code);
      AppMethodBeat.o(67644);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.cgi.NetSceneMobileRemitGetRecvInfo
 * JD-Core Version:    0.7.0.1
 */