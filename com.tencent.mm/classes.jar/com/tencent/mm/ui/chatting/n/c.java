package com.tencent.mm.ui.chatting.n;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.a;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.plugin.messenger.d.b;
import com.tencent.mm.plugin.messenger.d.b.a;
import com.tencent.mm.plugin.messenger.d.b.b;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class c
  extends b
{
  public c(b.b paramb)
  {
    super(paramb);
  }
  
  public final CharSequence b(final Map<String, String> paramMap, String paramString, final Bundle paramBundle, final WeakReference<Context> paramWeakReference, final WeakReference<NeatTextView> paramWeakReference1)
  {
    AppMethodBeat.i(196658);
    String str = (String)paramMap.get(paramString + ".title");
    final b.a locala = new b.a(this);
    locala.username = ((String)paramMap.get(paramString + ".username"));
    locala.link = ((String)paramMap.get(paramString + ".qrcode"));
    paramString = new SpannableString(str);
    paramString.setSpan(new a()
    {
      public final void onClickImp(View paramAnonymousView)
      {
        AppMethodBeat.i(196657);
        c localc = c.this;
        b.a locala = locala;
        if ((localc.uHC != null) && (localc.uHC.get() != null)) {
          ((b.b)localc.uHC.get()).a(paramAnonymousView, locala);
        }
        ((f)g.ab(f.class)).a("link_revoke_qrcode", paramMap, paramBundle);
        AppMethodBeat.o(196657);
      }
    }, 0, str.length(), 33);
    AppMethodBeat.o(196658);
    return paramString;
  }
  
  public final String dcL()
  {
    return "link_revoke_qrcode";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.n.c
 * JD-Core Version:    0.7.0.1
 */