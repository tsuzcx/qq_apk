package com.tencent.mm.ui.chatting.l;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.plugin.messenger.a.e.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import java.util.Map;

final class a$1
  implements e.b
{
  a$1(a parama) {}
  
  public final CharSequence a(Map<String, String> paramMap, String paramString, Bundle paramBundle, WeakReference<Context> paramWeakReference)
  {
    String str = paramBundle.getString("conv_talker_username", "");
    if (paramMap == null)
    {
      y.w("MicroMsg.SysMsgHandlerBase", "hy: non map!!");
      return null;
    }
    if (bk.bl(paramString))
    {
      y.w("MicroMsg.SysMsgHandlerBase", "hy: non header!!");
      return null;
    }
    if (bk.bl(str))
    {
      y.w("MicroMsg.SysMsgHandlerBase", "hy: not resolved talker!!");
      return null;
    }
    return this.vAm.b(paramMap, paramString, paramBundle, paramWeakReference);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.l.a.1
 * JD-Core Version:    0.7.0.1
 */