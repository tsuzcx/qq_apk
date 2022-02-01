package com.tencent.mm.plugin.remittance.mobile.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.rp;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.remittance.mobile.cgi.NetSceneMobileRemitGetRecvInfo;
import com.tencent.mm.protocal.protobuf.fpr;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
{
  private static int mPayChannel = 0;
  
  public static void a(Context paramContext, fpr paramfpr)
  {
    AppMethodBeat.i(67658);
    Log.i("MicroMsg.mobileRemit.MobileRemitHelper", "goMobileRemitUI()");
    Intent localIntent = new Intent();
    localIntent.putExtra("key_rcvr_openid", paramfpr.abPo);
    localIntent.putExtra("key_rcvr_token", paramfpr.abPp);
    localIntent.putExtra("key_wx_name", paramfpr.Ofy);
    localIntent.putExtra("key_real_name", paramfpr.Ofz);
    localIntent.putExtra("key_phone", paramfpr.wsM);
    localIntent.putExtra("key_img_url", paramfpr.DUR);
    localIntent.putExtra("key_amount_remind_bit", paramfpr.Okq);
    localIntent.putExtra("key_delay_options", NetSceneMobileRemitGetRecvInfo.bP(paramfpr.abPz));
    localIntent.putExtra("key_check_name_wording", paramfpr.abPA);
    localIntent.putExtra("key_check_name_mask", paramfpr.abPB);
    localIntent.putExtra("key_get_rcvr_ext", paramfpr.abPq);
    localIntent.putExtra("key_timestamp_ms", paramfpr.abPC);
    c.b(paramContext, "remittance", ".mobile.ui.MobileRemittanceUI", localIntent);
    AppMethodBeat.o(67658);
  }
  
  public static void ahf(int paramInt)
  {
    AppMethodBeat.i(67659);
    rp localrp = new rp();
    localrp.iqr = paramInt;
    localrp.bMH();
    AppMethodBeat.o(67659);
  }
  
  public static void ahg(int paramInt)
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
  
  public static int gLU()
  {
    return mPayChannel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.a.b
 * JD-Core Version:    0.7.0.1
 */