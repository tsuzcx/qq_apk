package com.tencent.mm.ui.chatting.m;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class d
  extends a
{
  public d(a.b paramb)
  {
    super(paramb);
  }
  
  final CharSequence b(Map<String, String> paramMap, String paramString, Bundle paramBundle, WeakReference<Context> paramWeakReference)
  {
    AppMethodBeat.i(32747);
    paramBundle = (String)paramMap.get(paramString + ".title");
    paramWeakReference = new a.a(this);
    paramWeakReference.username = ((String)paramMap.get(paramString + ".username"));
    paramWeakReference.link = ((String)paramMap.get(paramString + ".qrcode"));
    paramMap = new SpannableString(paramBundle);
    paramMap.setSpan(new d.1(this, paramWeakReference), 0, paramBundle.length(), 33);
    AppMethodBeat.o(32747);
    return paramMap;
  }
  
  final String dLm()
  {
    return "link_revoke_qrcode";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.m.d
 * JD-Core Version:    0.7.0.1
 */