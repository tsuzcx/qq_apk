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
import com.tencent.mm.protocal.protobuf.abu;
import com.tencent.mm.protocal.protobuf.djr;
import com.tencent.mm.protocal.protobuf.djs;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class NetSceneMobileRemitGetRecvInfo
  extends a
{
  private final String TAG;
  public String nUG;
  public String wHx;
  private djs wHy;
  
  public NetSceneMobileRemitGetRecvInfo(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(67647);
    this.TAG = "MicroMsg.mobileRemit.NetSceneMobileRemitGetRecvInfo";
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new djr();
    ((b.a)localObject).hvu = new djs();
    ((b.a)localObject).funcId = 1495;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/transferphonegetrcvr";
    this.rr = ((b.a)localObject).aAz();
    localObject = (djr)this.rr.hvr.hvw;
    ((djr)localObject).nUG = paramString1;
    ((djr)localObject).FSF = paramString2;
    ((djr)localObject).FSH = paramString3;
    ((djr)localObject).FCV = paramInt;
    ac.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecvInfo", "do scene NetSceneMobileRemitGetRecvInfo phone:%s rcvr_id:%s input_type:%s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    this.wHx = paramString2;
    this.nUG = paramString1;
    AppMethodBeat.o(67647);
  }
  
  public static ArrayList<DelayOptionParcel> aN(LinkedList<abu> paramLinkedList)
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
      localArrayList.add(new DelayOptionParcel((abu)paramLinkedList.next()));
    }
    AppMethodBeat.o(67649);
    return localArrayList;
  }
  
  public static ArrayList<abu> fa(List<DelayOptionParcel> paramList)
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
      abu localabu = new abu();
      localabu.wHz = localDelayOptionParcel.wHz;
      localabu.code = localDelayOptionParcel.code;
      localArrayList.add(localabu);
    }
    AppMethodBeat.o(67650);
    return localArrayList;
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67648);
    ac.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecvInfo", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.wHy = ((djs)((b)paramq).hvs.hvw);
    ac.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecvInfo", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.wHy.nWx), this.wHy.nWy });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67648);
  }
  
  public final djs dxE()
  {
    if (this.wHy == null) {
      return null;
    }
    return this.wHy;
  }
  
  public final void e(q paramq)
  {
    paramq = (djs)((b)paramq).hvs.hvw;
    this.JFq = paramq.nWx;
    this.JFr = paramq.nWy;
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
    public String wHz;
    
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
      this.wHz = paramParcel.readString();
      this.code = paramParcel.readInt();
      AppMethodBeat.o(67645);
    }
    
    protected DelayOptionParcel(abu paramabu)
    {
      this.wHz = paramabu.wHz;
      this.code = paramabu.code;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(67644);
      paramParcel.writeString(this.wHz);
      paramParcel.writeInt(this.code);
      AppMethodBeat.o(67644);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.cgi.NetSceneMobileRemitGetRecvInfo
 * JD-Core Version:    0.7.0.1
 */