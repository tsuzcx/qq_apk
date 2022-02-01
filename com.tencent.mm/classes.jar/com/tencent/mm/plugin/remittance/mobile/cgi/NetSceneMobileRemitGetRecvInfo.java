package com.tencent.mm.plugin.remittance.mobile.cgi;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.adu;
import com.tencent.mm.protocal.protobuf.dpg;
import com.tencent.mm.protocal.protobuf.dph;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class NetSceneMobileRemitGetRecvInfo
  extends a
{
  private final String TAG;
  public String oyb;
  public String xVe;
  private dph xVf;
  
  public NetSceneMobileRemitGetRecvInfo(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(67647);
    this.TAG = "MicroMsg.mobileRemit.NetSceneMobileRemitGetRecvInfo";
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new dpg();
    ((b.a)localObject).hNN = new dph();
    ((b.a)localObject).funcId = 1495;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/transferphonegetrcvr";
    this.rr = ((b.a)localObject).aDC();
    localObject = (dpg)this.rr.hNK.hNQ;
    ((dpg)localObject).oyb = paramString1;
    ((dpg)localObject).HDo = paramString2;
    ((dpg)localObject).HDq = paramString3;
    ((dpg)localObject).Hni = paramInt;
    ad.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecvInfo", "do scene NetSceneMobileRemitGetRecvInfo phone:%s rcvr_id:%s input_type:%s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    this.xVe = paramString2;
    this.oyb = paramString1;
    AppMethodBeat.o(67647);
  }
  
  public static ArrayList<DelayOptionParcel> aO(LinkedList<adu> paramLinkedList)
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
      localArrayList.add(new DelayOptionParcel((adu)paramLinkedList.next()));
    }
    AppMethodBeat.o(67649);
    return localArrayList;
  }
  
  public static ArrayList<adu> fn(List<DelayOptionParcel> paramList)
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
      adu localadu = new adu();
      localadu.xVg = localDelayOptionParcel.xVg;
      localadu.code = localDelayOptionParcel.code;
      localArrayList.add(localadu);
    }
    AppMethodBeat.o(67650);
    return localArrayList;
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67648);
    ad.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecvInfo", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.xVf = ((dph)((b)paramq).hNL.hNQ);
    ad.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecvInfo", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.xVf.ozR), this.xVf.ozS });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67648);
  }
  
  public final dph dIW()
  {
    if (this.xVf == null) {
      return null;
    }
    return this.xVf;
  }
  
  public final void e(q paramq)
  {
    paramq = (dph)((b)paramq).hNL.hNQ;
    this.Lyu = paramq.ozR;
    this.Lyv = paramq.ozS;
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
    public String xVg;
    
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
      this.xVg = paramParcel.readString();
      this.code = paramParcel.readInt();
      AppMethodBeat.o(67645);
    }
    
    protected DelayOptionParcel(adu paramadu)
    {
      this.xVg = paramadu.xVg;
      this.code = paramadu.code;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(67644);
      paramParcel.writeString(this.xVg);
      paramParcel.writeInt(this.code);
      AppMethodBeat.o(67644);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.cgi.NetSceneMobileRemitGetRecvInfo
 * JD-Core Version:    0.7.0.1
 */