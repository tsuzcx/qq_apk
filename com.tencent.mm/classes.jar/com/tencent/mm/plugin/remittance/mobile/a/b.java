package com.tencent.mm.plugin.remittance.mobile.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.g.b.a.hk;
import com.tencent.mm.plugin.remittance.mobile.cgi.NetSceneMobileRemitGetRecvInfo;
import com.tencent.mm.protocal.protobuf.dqe;
import org.xwalk.core.Log;

public final class b
{
  private static int mPayChannel = 0;
  
  public static void OD(int paramInt)
  {
    AppMethodBeat.i(67659);
    hk localhk = new hk();
    localhk.dWt = paramInt;
    localhk.aLH();
    AppMethodBeat.o(67659);
  }
  
  public static void OE(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      mPayChannel = 0;
      return;
    case 1: 
      mPayChannel = 1;
      return;
    }
    mPayChannel = 21;
  }
  
  public static void a(Context paramContext, dqe paramdqe)
  {
    AppMethodBeat.i(67658);
    Log.i("MicroMsg.mobileRemit.MobileRemitHelper", "goMobileRemitUI()");
    Intent localIntent = new Intent();
    localIntent.putExtra("key_rcvr_openid", paramdqe.HWV);
    localIntent.putExtra("key_rcvr_token", paramdqe.HWW);
    localIntent.putExtra("key_wx_name", paramdqe.ykU);
    localIntent.putExtra("key_real_name", paramdqe.ykV);
    localIntent.putExtra("key_phone", paramdqe.oED);
    localIntent.putExtra("key_img_url", paramdqe.FXI);
    localIntent.putExtra("key_amount_remind_bit", paramdqe.yoX);
    localIntent.putExtra("key_delay_options", NetSceneMobileRemitGetRecvInfo.aP(paramdqe.HXg));
    localIntent.putExtra("key_check_name_wording", paramdqe.HXh);
    localIntent.putExtra("key_check_name_mask", paramdqe.HXi);
    localIntent.putExtra("key_get_rcvr_ext", paramdqe.HWX);
    localIntent.putExtra("key_timestamp_ms", paramdqe.HXj);
    d.b(paramContext, "remittance", ".mobile.ui.MobileRemittanceUI", localIntent);
    AppMethodBeat.o(67658);
  }
  
  public static int dMt()
  {
    return mPayChannel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.a.b
 * JD-Core Version:    0.7.0.1
 */