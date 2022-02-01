package com.tencent.mm.plugin.remittance.mobile.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.b.a.ep;
import com.tencent.mm.plugin.remittance.mobile.cgi.NetSceneMobileRemitGetRecvInfo;
import com.tencent.mm.protocal.protobuf.ded;
import org.xwalk.core.Log;

public final class b
{
  private static int mPayChannel = 0;
  
  public static void Kw(int paramInt)
  {
    AppMethodBeat.i(67659);
    ep localep = new ep();
    localep.dKe = paramInt;
    localep.aBj();
    AppMethodBeat.o(67659);
  }
  
  public static void Kx(int paramInt)
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
  
  public static void a(Context paramContext, ded paramded)
  {
    AppMethodBeat.i(67658);
    Log.i("MicroMsg.mobileRemit.MobileRemitHelper", "goMobileRemitUI()");
    Intent localIntent = new Intent();
    localIntent.putExtra("key_rcvr_openid", paramded.Evw);
    localIntent.putExtra("key_rcvr_token", paramded.Evx);
    localIntent.putExtra("key_wx_name", paramded.vxp);
    localIntent.putExtra("key_real_name", paramded.vxq);
    localIntent.putExtra("key_phone", paramded.nrG);
    localIntent.putExtra("key_img_url", paramded.CHl);
    localIntent.putExtra("key_amount_remind_bit", paramded.vBt);
    localIntent.putExtra("key_delay_options", NetSceneMobileRemitGetRecvInfo.aG(paramded.EvH));
    localIntent.putExtra("key_check_name_wording", paramded.EvI);
    localIntent.putExtra("key_check_name_mask", paramded.EvJ);
    localIntent.putExtra("key_get_rcvr_ext", paramded.Evy);
    localIntent.putExtra("key_timestamp_ms", paramded.EvK);
    d.b(paramContext, "remittance", ".mobile.ui.MobileRemittanceUI", localIntent);
    AppMethodBeat.o(67658);
  }
  
  public static int djI()
  {
    return mPayChannel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.a.b
 * JD-Core Version:    0.7.0.1
 */