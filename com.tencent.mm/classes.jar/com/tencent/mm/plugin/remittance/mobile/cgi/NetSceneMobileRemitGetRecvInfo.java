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
import com.tencent.mm.protocal.protobuf.agg;
import com.tencent.mm.protocal.protobuf.ejz;
import com.tencent.mm.protocal.protobuf.eka;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class NetSceneMobileRemitGetRecvInfo
  extends a
{
  public String ClX;
  private eka ClY;
  private final String TAG;
  public String pSm;
  
  public NetSceneMobileRemitGetRecvInfo(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(67647);
    this.TAG = "MicroMsg.mobileRemit.NetSceneMobileRemitGetRecvInfo";
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new ejz();
    ((d.a)localObject).iLO = new eka();
    ((d.a)localObject).funcId = 1495;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/transferphonegetrcvr";
    this.rr = ((d.a)localObject).aXF();
    localObject = (ejz)this.rr.iLK.iLR;
    ((ejz)localObject).pSm = paramString1;
    ((ejz)localObject).Njh = paramString2;
    ((ejz)localObject).Njj = paramString3;
    ((ejz)localObject).MRS = paramInt;
    Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecvInfo", "do scene NetSceneMobileRemitGetRecvInfo phone:%s rcvr_id:%s input_type:%s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    this.ClX = paramString2;
    this.pSm = paramString1;
    AppMethodBeat.o(67647);
  }
  
  public static ArrayList<DelayOptionParcel> bm(LinkedList<agg> paramLinkedList)
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
      localArrayList.add(new DelayOptionParcel((agg)paramLinkedList.next()));
    }
    AppMethodBeat.o(67649);
    return localArrayList;
  }
  
  public static ArrayList<agg> gq(List<DelayOptionParcel> paramList)
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
      agg localagg = new agg();
      localagg.ClZ = localDelayOptionParcel.ClZ;
      localagg.code = localDelayOptionParcel.code;
      localArrayList.add(localagg);
    }
    AppMethodBeat.o(67650);
    return localArrayList;
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(67648);
    Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecvInfo", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.ClY = ((eka)((d)params).iLL.iLR);
    Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecvInfo", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.ClY.pTZ), this.ClY.pUa });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67648);
  }
  
  public final void e(s params)
  {
    params = (eka)((d)params).iLL.iLR;
    this.RtZ = params.pTZ;
    this.Rua = params.pUa;
  }
  
  public final eka eNn()
  {
    if (this.ClY == null) {
      return null;
    }
    return this.ClY;
  }
  
  public final int getType()
  {
    return 1495;
  }
  
  public static class DelayOptionParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<DelayOptionParcel> CREATOR;
    public String ClZ;
    public int code;
    
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
      this.ClZ = paramParcel.readString();
      this.code = paramParcel.readInt();
      AppMethodBeat.o(67645);
    }
    
    protected DelayOptionParcel(agg paramagg)
    {
      this.ClZ = paramagg.ClZ;
      this.code = paramagg.code;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(67644);
      paramParcel.writeString(this.ClZ);
      paramParcel.writeInt(this.code);
      AppMethodBeat.o(67644);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.cgi.NetSceneMobileRemitGetRecvInfo
 * JD-Core Version:    0.7.0.1
 */