package com.tencent.mm.ui.chatting.l;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.a.a;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.plugin.messenger.f.b;
import com.tencent.mm.plugin.messenger.f.b.a;
import com.tencent.mm.plugin.messenger.f.b.b;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class d
  extends b
{
  public d(b.b paramb)
  {
    super(paramb);
  }
  
  public final CharSequence b(final Map<String, String> paramMap, String paramString, final Bundle paramBundle, final WeakReference<Context> paramWeakReference, final WeakReference<NeatTextView> paramWeakReference1)
  {
    AppMethodBeat.i(254397);
    String str = (String)paramMap.get(paramString + ".title");
    final b.a locala = new b.a(this);
    locala.username = ((String)paramMap.get(paramString + ".username"));
    locala.link = ((String)paramMap.get(paramString + ".qrcode"));
    paramString = new SpannableString(str);
    paramString.setSpan(new a(locala)
    {
      public final void onClickImp(View paramAnonymousView)
      {
        AppMethodBeat.i(254394);
        d locald = d.this;
        b.a locala = locala;
        if ((locald.KRZ != null) && (locald.KRZ.get() != null)) {
          ((b.b)locald.KRZ.get()).a(paramAnonymousView, locala);
        }
        ((e)h.ax(e.class)).a("link_revoke_qrcode", paramMap, paramBundle);
        AppMethodBeat.o(254394);
      }
    }, 0, str.length(), 33);
    AppMethodBeat.o(254397);
    return paramString;
  }
  
  public final String gbt()
  {
    return "link_revoke_qrcode";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.l.d
 * JD-Core Version:    0.7.0.1
 */