package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ard;
import com.tencent.mm.protocal.protobuf.are;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public final class g
  extends m
  implements k
{
  private f callback;
  private b rr;
  
  public g()
  {
    AppMethodBeat.i(126851);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new ard();
    ((b.a)localObject).fsY = new are();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/wxaapp/autofill/getinfo";
    ((b.a)localObject).funcId = 1191;
    this.rr = ((b.a)localObject).ado();
    localObject = (ard)this.rr.fsV.fta;
    ((ard)localObject).cpt = 2;
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
    ((ard)localObject).xgt = localLinkedList;
    ((ard)localObject).xgs = false;
    AppMethodBeat.o(126851);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(126853);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(126853);
    return i;
  }
  
  public final int getType()
  {
    return 1191;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(126852);
    ab.d("MicroMsg.NetSceneGetUserAutoFillInfo", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      ab.i("MicroMsg.NetSceneGetUserAutoFillInfo", "return is 0.now we parse the json and resetList..");
      paramq = (are)((b)paramq).fsW.fta;
      if (paramq.xgu == null) {}
    }
    try
    {
      boolean bool = new JSONObject(paramq.xgu).getBoolean("has_invoice_info");
      ab.i("MicroMsg.NetSceneGetUserAutoFillInfo", "has_invoice_info is ..".concat(String.valueOf(bool)));
      com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yFF, Boolean.valueOf(bool));
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126852);
      return;
    }
    catch (JSONException paramq)
    {
      for (;;)
      {
        ab.e("MicroMsg.NetSceneGetUserAutoFillInfo", "error parse this json");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.g
 * JD-Core Version:    0.7.0.1
 */