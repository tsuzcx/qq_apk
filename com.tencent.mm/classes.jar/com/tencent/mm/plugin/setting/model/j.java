package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bwx;
import com.tencent.mm.protocal.protobuf.bwy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public final class j
  extends q
  implements m
{
  private i callback;
  private d rr;
  
  public j()
  {
    AppMethodBeat.i(73773);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new bwx();
    ((d.a)localObject).iLO = new bwy();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/wxaapp/autofill/getinfo";
    ((d.a)localObject).funcId = 1191;
    this.rr = ((d.a)localObject).aXF();
    localObject = (bwx)this.rr.iLK.iLR;
    ((bwx)localObject).source = 2;
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
    ((bwx)localObject).McG = localLinkedList;
    ((bwx)localObject).McF = false;
    AppMethodBeat.o(73773);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(73775);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(73775);
    return i;
  }
  
  public final int getType()
  {
    return 1191;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(73774);
    Log.d("MicroMsg.NetSceneGetUserAutoFillInfo", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      Log.i("MicroMsg.NetSceneGetUserAutoFillInfo", "return is 0.now we parse the json and resetList..");
      params = (bwy)((d)params).iLL.iLR;
      if (params.McH == null) {}
    }
    try
    {
      boolean bool = new JSONObject(params.McH).getBoolean("has_invoice_info");
      Log.i("MicroMsg.NetSceneGetUserAutoFillInfo", "has_invoice_info is ..".concat(String.valueOf(bool)));
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Obg, Boolean.valueOf(bool));
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(73774);
      return;
    }
    catch (JSONException params)
    {
      for (;;)
      {
        Log.e("MicroMsg.NetSceneGetUserAutoFillInfo", "error parse this json");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.j
 * JD-Core Version:    0.7.0.1
 */