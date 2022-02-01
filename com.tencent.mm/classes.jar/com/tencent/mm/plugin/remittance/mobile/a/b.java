package com.tencent.mm.plugin.remittance.mobile.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.f.b.a.nx;
import com.tencent.mm.plugin.remittance.mobile.cgi.NetSceneMobileRemitGetRecvInfo;
import com.tencent.mm.protocal.protobuf.eue;
import org.xwalk.core.Log;

public final class b
{
  private static int mPayChannel = 0;
  
  public static void a(Context paramContext, eue parameue)
  {
    AppMethodBeat.i(67658);
    Log.i("MicroMsg.mobileRemit.MobileRemitHelper", "goMobileRemitUI()");
    Intent localIntent = new Intent();
    localIntent.putExtra("key_rcvr_openid", parameue.UvJ);
    localIntent.putExtra("key_rcvr_token", parameue.UvK);
    localIntent.putExtra("key_wx_name", parameue.IiN);
    localIntent.putExtra("key_real_name", parameue.IiO);
    localIntent.putExtra("key_phone", parameue.tol);
    localIntent.putExtra("key_img_url", parameue.zaK);
    localIntent.putExtra("key_amount_remind_bit", parameue.Inc);
    localIntent.putExtra("key_delay_options", NetSceneMobileRemitGetRecvInfo.bG(parameue.UvU));
    localIntent.putExtra("key_check_name_wording", parameue.UvV);
    localIntent.putExtra("key_check_name_mask", parameue.UvW);
    localIntent.putExtra("key_get_rcvr_ext", parameue.UvL);
    localIntent.putExtra("key_timestamp_ms", parameue.UvX);
    c.b(paramContext, "remittance", ".mobile.ui.MobileRemittanceUI", localIntent);
    AppMethodBeat.o(67658);
  }
  
  public static void acM(int paramInt)
  {
    AppMethodBeat.i(67659);
    nx localnx = new nx();
    localnx.gnP = paramInt;
    localnx.bpa();
    AppMethodBeat.o(67659);
  }
  
  public static void acN(int paramInt)
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
  
  public static int fAi()
  {
    return mPayChannel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.a.b
 * JD-Core Version:    0.7.0.1
 */