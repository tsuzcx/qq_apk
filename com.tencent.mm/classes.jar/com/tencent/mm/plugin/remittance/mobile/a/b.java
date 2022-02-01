package com.tencent.mm.plugin.remittance.mobile.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.g.b.a.gf;
import com.tencent.mm.plugin.remittance.mobile.cgi.NetSceneMobileRemitGetRecvInfo;
import com.tencent.mm.protocal.protobuf.djs;
import org.xwalk.core.Log;

public final class b
{
  private static int mPayChannel = 0;
  
  public static void Mv(int paramInt)
  {
    AppMethodBeat.i(67659);
    gf localgf = new gf();
    localgf.dHY = paramInt;
    localgf.aHZ();
    AppMethodBeat.o(67659);
  }
  
  public static void Mw(int paramInt)
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
  
  public static void a(Context paramContext, djs paramdjs)
  {
    AppMethodBeat.i(67658);
    Log.i("MicroMsg.mobileRemit.MobileRemitHelper", "goMobileRemitUI()");
    Intent localIntent = new Intent();
    localIntent.putExtra("key_rcvr_openid", paramdjs.FSz);
    localIntent.putExtra("key_rcvr_token", paramdjs.FSA);
    localIntent.putExtra("key_wx_name", paramdjs.wHu);
    localIntent.putExtra("key_real_name", paramdjs.wHv);
    localIntent.putExtra("key_phone", paramdjs.nUG);
    localIntent.putExtra("key_img_url", paramdjs.DZN);
    localIntent.putExtra("key_amount_remind_bit", paramdjs.wLy);
    localIntent.putExtra("key_delay_options", NetSceneMobileRemitGetRecvInfo.aN(paramdjs.FSK));
    localIntent.putExtra("key_check_name_wording", paramdjs.FSL);
    localIntent.putExtra("key_check_name_mask", paramdjs.FSM);
    localIntent.putExtra("key_get_rcvr_ext", paramdjs.FSB);
    localIntent.putExtra("key_timestamp_ms", paramdjs.FSN);
    d.b(paramContext, "remittance", ".mobile.ui.MobileRemittanceUI", localIntent);
    AppMethodBeat.o(67658);
  }
  
  public static int dxK()
  {
    return mPayChannel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.a.b
 * JD-Core Version:    0.7.0.1
 */