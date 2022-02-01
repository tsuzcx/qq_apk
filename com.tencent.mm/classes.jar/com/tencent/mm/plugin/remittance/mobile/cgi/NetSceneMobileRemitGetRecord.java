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
import com.tencent.mm.protocal.protobuf.bof;
import com.tencent.mm.protocal.protobuf.dpe;
import com.tencent.mm.protocal.protobuf.dpf;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class NetSceneMobileRemitGetRecord
  extends a
{
  private final String TAG;
  private dpf xVa;
  
  public NetSceneMobileRemitGetRecord(String paramString1, String paramString2)
  {
    AppMethodBeat.i(67639);
    this.TAG = "MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord";
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new dpe();
    ((b.a)localObject).hNN = new dpf();
    ((b.a)localObject).funcId = 2993;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/transferphonegethisrcvrs";
    this.rr = ((b.a)localObject).aDC();
    localObject = (dpe)this.rr.hNK.hNQ;
    ((dpe)localObject).HDp = paramString1;
    ((dpe)localObject).HDq = paramString2;
    ad.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord", "do scene NetSceneMobileRemitGetRecord last_id:%s homepage_ext:%s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(67639);
  }
  
  public static ArrayList<HisRcvrParcel> aN(LinkedList<bof> paramLinkedList)
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
      localArrayList.add(new HisRcvrParcel((bof)paramLinkedList.next()));
    }
    AppMethodBeat.o(67641);
    return localArrayList;
  }
  
  public static ArrayList<bof> fm(List<HisRcvrParcel> paramList)
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
      bof localbof = new bof();
      localbof.id = localHisRcvrParcel.id;
      localbof.xVb = localHisRcvrParcel.xVb;
      localbof.xVc = localHisRcvrParcel.xVc;
      localbof.oyb = localHisRcvrParcel.oyb;
      localbof.timestamp = localHisRcvrParcel.timestamp;
      localbof.xVd = localHisRcvrParcel.xVd;
      localArrayList.add(localbof);
    }
    AppMethodBeat.o(67642);
    return localArrayList;
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67640);
    ad.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.xVa = ((dpf)((b)paramq).hNL.hNQ);
    ad.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.xVa.ozR), this.xVa.ozS });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67640);
  }
  
  public final dpf dIV()
  {
    if (this.xVa == null) {
      return null;
    }
    return this.xVa;
  }
  
  public final void e(q paramq)
  {
    paramq = (dpf)((b)paramq).hNL.hNQ;
    this.Lyu = paramq.ozR;
    this.Lyv = paramq.ozS;
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
    public String oyb;
    public long timestamp;
    public String xVb;
    public String xVc;
    public int xVd;
    
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
      this.xVb = paramParcel.readString();
      this.xVc = paramParcel.readString();
      this.oyb = paramParcel.readString();
      this.timestamp = paramParcel.readLong();
      this.xVd = paramParcel.readInt();
      AppMethodBeat.o(67636);
    }
    
    protected HisRcvrParcel(bof parambof)
    {
      this.id = parambof.id;
      this.xVb = parambof.xVb;
      this.xVc = parambof.xVc;
      this.oyb = parambof.oyb;
      this.timestamp = parambof.timestamp;
      this.xVd = parambof.xVd;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(67637);
      paramParcel.writeString(this.id);
      paramParcel.writeString(this.xVb);
      paramParcel.writeString(this.xVc);
      paramParcel.writeString(this.oyb);
      paramParcel.writeLong(this.timestamp);
      paramParcel.writeInt(this.xVd);
      AppMethodBeat.o(67637);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.cgi.NetSceneMobileRemitGetRecord
 * JD-Core Version:    0.7.0.1
 */