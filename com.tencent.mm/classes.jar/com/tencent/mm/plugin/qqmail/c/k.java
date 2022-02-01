package com.tencent.mm.plugin.qqmail.c;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.sdk.platformtools.Log;

public class k
  implements com.tencent.mm.am.h, d<Bundle, Bundle>
{
  private String Njg;
  private com.tencent.mm.ipcinvoker.f<Bundle> mzo;
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(266864);
    Log.i("MicroMsg.UpdateMailStatusTask", "read mail, errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (!((com.tencent.mm.plugin.qqmail.d.f)paramp).Njg.equals(this.Njg))
    {
      Log.w("MicroMsg.UpdateMailStatusTask", "not my scene, ignore");
      AppMethodBeat.o(266864);
      return;
    }
    com.tencent.mm.kernel.h.aZW().b(11480, this);
    if (this.mzo != null)
    {
      paramp = new Bundle();
      paramp.putInt("err_type", paramInt1);
      paramp.putInt("err_code", paramInt2);
      paramp.putString("err_msg", paramString);
      paramp.putString("mail_id", this.Njg);
      this.mzo.onCallback(paramp);
    }
    AppMethodBeat.o(266864);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.c.k
 * JD-Core Version:    0.7.0.1
 */