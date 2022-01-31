package com.tencent.mm.ui.chatting.l;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
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
    paramBundle = (String)paramMap.get(paramString + ".title");
    paramWeakReference = new a.a(this);
    paramWeakReference.username = ((String)paramMap.get(paramString + ".username"));
    paramWeakReference.eAl = ((String)paramMap.get(paramString + ".qrcode"));
    paramMap = new SpannableString(paramBundle);
    paramMap.setSpan(new d.1(this, paramWeakReference), 0, paramBundle.length(), 33);
    return paramMap;
  }
  
  final String cGZ()
  {
    return "link_revoke_qrcode";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.l.d
 * JD-Core Version:    0.7.0.1
 */