package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.zp;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.message.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.chatting.viewitems.bz;

final class u$1
  implements View.OnClickListener
{
  u$1(v paramv, String paramString) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(34578);
    Object localObject = new b();
    ((b)localObject).cH(paramView);
    a.c("com/tencent/mm/ui/chatting/ChattingItemHelper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
    paramView = (bz)paramView.getTag();
    Log.i("MicroMsg.ChattingItemHelper", "on app brand(%s) button1 click", new Object[] { this.vsS.nUR });
    localObject = new zp();
    ((zp)localObject).icM.userName = this.vsS.nUR;
    ((zp)localObject).icM.icO = this.vsS.nUS;
    ((zp)localObject).icM.icP = this.vsS.nUU;
    ((zp)localObject).icM.appVersion = this.vsS.nUT;
    ((zp)localObject).icM.icT = true;
    ((zp)localObject).icM.scene = 1076;
    ((zp)localObject).icM.hzx = (this.lzH + ":" + paramView.hTm.field_msgSvrId + ":" + paramView.WMC);
    ((zp)localObject).publish();
    a.a(this, "com/tencent/mm/ui/chatting/ChattingItemHelper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(34578);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.u.1
 * JD-Core Version:    0.7.0.1
 */