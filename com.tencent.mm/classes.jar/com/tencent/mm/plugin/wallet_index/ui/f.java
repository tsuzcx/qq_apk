package com.tencent.mm.plugin.wallet_index.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.wallet_core.model.u;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wallet_index/ui/WecoinIapData;", "", "()V", "mBuffer", "", "mCount", "", "getMCount", "()I", "setMCount", "(I)V", "mCurrencyType", "", "getMCurrencyType", "()Ljava/lang/String;", "setMCurrencyType", "(Ljava/lang/String;)V", "mGoodName", "getMGoodName", "setMGoodName", "mIsDeleteReceipt", "getMIsDeleteReceipt", "setMIsDeleteReceipt", "mPayType", "mPreparePurchaseBillNo", "mPrice", "getMPrice", "setMPrice", "mProductId", "mProductIds", "", "mResultProductIds", "Ljava/util/ArrayList;", "getMResultProductIds", "()Ljava/util/ArrayList;", "setMResultProductIds", "(Ljava/util/ArrayList;)V", "mResultSeriesIds", "getMResultSeriesIds", "setMResultSeriesIds", "mSeriesId", "getMSeriesId", "setMSeriesId", "getBillNo", "getBuffer", "getPrepareNetScene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "getProductId", "getVerifyNetScene", "getWecoinPriceNum", "isProductListEmpty", "", "savePrepareData", "Lcom/tencent/mm/plugin/wallet_index/model/IapResult;", "errCode", "errMsg", "scene", "saveVerifyData", "setPayType", "", "payType", "setProductId", "productId", "Companion", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final f.a Wcb;
  int MGo;
  String Wag;
  String Wah;
  ArrayList<String> Wbb;
  ArrayList<String> Wbc;
  String Wbd;
  int Wbe;
  final List<String> Wbf;
  String Wcc;
  byte[] eTS;
  int mCount;
  String xOk;
  String ydi;
  
  static
  {
    AppMethodBeat.i(263556);
    Wcb = new f.a((byte)0);
    AppMethodBeat.o(263556);
  }
  
  public f()
  {
    AppMethodBeat.i(263552);
    this.MGo = -1;
    this.Wcc = "";
    this.eTS = new byte[0];
    this.Wbd = "";
    this.Wbf = ((List)new ArrayList());
    this.xOk = "";
    this.Wbb = new ArrayList();
    this.Wbc = new ArrayList();
    this.mCount = 1;
    this.ydi = "";
    AppMethodBeat.o(263552);
  }
  
  public final p imt()
  {
    AppMethodBeat.i(263562);
    p localp = (p)new u(this.xOk, this.Wah, this.MGo);
    AppMethodBeat.o(263562);
    return localp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.f
 * JD-Core Version:    0.7.0.1
 */