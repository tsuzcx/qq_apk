package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bfo;
import com.tencent.mm.protocal.protobuf.bfp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public final class h
  extends n
  implements k
{
  private com.tencent.mm.ak.g callback;
  private b rr;
  
  public h()
  {
    AppMethodBeat.i(73773);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new bfo();
    ((b.a)localObject).hvu = new bfp();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/wxaapp/autofill/getinfo";
    ((b.a)localObject).funcId = 1191;
    this.rr = ((b.a)localObject).aAz();
    localObject = (bfo)this.rr.hvr.hvw;
    ((bfo)localObject).dbL = 2;
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add("invoice_info.title");
    localLinkedList.add("invoice_info.tax_number");
    localLinkedList.add("invoice_info.bank_number");
    localLinkedList.add("invoice_info.bank_name");
    localLinkedList.add("invoice_info.type");
    localLinkedList.add("invoice_info.email");
    localLinkedList.add("invoice_info.company_address");
    localLinkedList.add("invoice_info.company_address_detail");
    localLinkedList.add("invoice_info.company_address_postcode");
    localLinkedList.add("invoice_info.phone");
    ((bfo)localObject).EUR = localLinkedList;
    ((bfo)localObject).EUQ = false;
    AppMethodBeat.o(73773);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(73775);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(73775);
    return i;
  }
  
  public final int getType()
  {
    return 1191;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(73774);
    ac.d("MicroMsg.NetSceneGetUserAutoFillInfo", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      ac.i("MicroMsg.NetSceneGetUserAutoFillInfo", "return is 0.now we parse the json and resetList..");
      paramq = (bfp)((b)paramq).hvs.hvw;
      if (paramq.EUS == null) {}
    }
    try
    {
      boolean bool = new JSONObject(paramq.EUS).getBoolean("has_invoice_info");
      ac.i("MicroMsg.NetSceneGetUserAutoFillInfo", "has_invoice_info is ..".concat(String.valueOf(bool)));
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GMd, Boolean.valueOf(bool));
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(73774);
      return;
    }
    catch (JSONException paramq)
    {
      for (;;)
      {
        ac.e("MicroMsg.NetSceneGetUserAutoFillInfo", "error parse this json");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.h
 * JD-Core Version:    0.7.0.1
 */