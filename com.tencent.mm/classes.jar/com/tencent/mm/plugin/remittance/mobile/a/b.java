package com.tencent.mm.plugin.remittance.mobile.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.g.b.a.lb;
import com.tencent.mm.plugin.remittance.mobile.cgi.NetSceneMobileRemitGetRecvInfo;
import com.tencent.mm.protocal.protobuf.eka;
import org.xwalk.core.Log;

public final class b
{
  private static int mPayChannel = 0;
  
  public static void VY(int paramInt)
  {
    AppMethodBeat.i(67659);
    lb locallb = new lb();
    locallb.erW = paramInt;
    locallb.bfK();
    AppMethodBeat.o(67659);
  }
  
  public static void VZ(int paramInt)
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
  
  public static void a(Context paramContext, eka parameka)
  {
    AppMethodBeat.i(67658);
    Log.i("MicroMsg.mobileRemit.MobileRemitHelper", "goMobileRemitUI()");
    Intent localIntent = new Intent();
    localIntent.putExtra("key_rcvr_openid", parameka.Njb);
    localIntent.putExtra("key_rcvr_token", parameka.Njc);
    localIntent.putExtra("key_wx_name", parameka.ClU);
    localIntent.putExtra("key_real_name", parameka.ClV);
    localIntent.putExtra("key_phone", parameka.pSm);
    localIntent.putExtra("key_img_url", parameka.KRv);
    localIntent.putExtra("key_amount_remind_bit", parameka.CpN);
    localIntent.putExtra("key_delay_options", NetSceneMobileRemitGetRecvInfo.bm(parameka.Njm));
    localIntent.putExtra("key_check_name_wording", parameka.Njn);
    localIntent.putExtra("key_check_name_mask", parameka.Njo);
    localIntent.putExtra("key_get_rcvr_ext", parameka.Njd);
    localIntent.putExtra("key_timestamp_ms", parameka.Njp);
    c.b(paramContext, "remittance", ".mobile.ui.MobileRemittanceUI", localIntent);
    AppMethodBeat.o(67658);
  }
  
  public static int eNt()
  {
    return mPayChannel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.a.b
 * JD-Core Version:    0.7.0.1
 */