package com.tencent.mm.plugin.remittance.mobile.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.b.a.hi;
import com.tencent.mm.plugin.remittance.mobile.cgi.NetSceneMobileRemitGetRecvInfo;
import com.tencent.mm.protocal.protobuf.dph;
import org.xwalk.core.Log;

public final class b
{
  private static int mPayChannel = 0;
  
  public static void NX(int paramInt)
  {
    AppMethodBeat.i(67659);
    hi localhi = new hi();
    localhi.dVd = paramInt;
    localhi.aLk();
    AppMethodBeat.o(67659);
  }
  
  public static void NY(int paramInt)
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
  
  public static void a(Context paramContext, dph paramdph)
  {
    AppMethodBeat.i(67658);
    Log.i("MicroMsg.mobileRemit.MobileRemitHelper", "goMobileRemitUI()");
    Intent localIntent = new Intent();
    localIntent.putExtra("key_rcvr_openid", paramdph.HDi);
    localIntent.putExtra("key_rcvr_token", paramdph.HDj);
    localIntent.putExtra("key_wx_name", paramdph.xVb);
    localIntent.putExtra("key_real_name", paramdph.xVc);
    localIntent.putExtra("key_phone", paramdph.oyb);
    localIntent.putExtra("key_img_url", paramdph.FFn);
    localIntent.putExtra("key_amount_remind_bit", paramdph.xZf);
    localIntent.putExtra("key_delay_options", NetSceneMobileRemitGetRecvInfo.aO(paramdph.HDt));
    localIntent.putExtra("key_check_name_wording", paramdph.HDu);
    localIntent.putExtra("key_check_name_mask", paramdph.HDv);
    localIntent.putExtra("key_get_rcvr_ext", paramdph.HDk);
    localIntent.putExtra("key_timestamp_ms", paramdph.HDw);
    d.b(paramContext, "remittance", ".mobile.ui.MobileRemittanceUI", localIntent);
    AppMethodBeat.o(67658);
  }
  
  public static int dJc()
  {
    return mPayChannel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.a.b
 * JD-Core Version:    0.7.0.1
 */