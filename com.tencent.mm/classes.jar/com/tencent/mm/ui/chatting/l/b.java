package com.tencent.mm.ui.chatting.l;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.a.a;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.plugin.messenger.f.b.b;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Map;

public final class b
  extends com.tencent.mm.plugin.messenger.f.b
{
  public b(b.b paramb)
  {
    super(paramb);
  }
  
  public final CharSequence b(final Map<String, String> paramMap, String paramString, final Bundle paramBundle, final WeakReference<Context> paramWeakReference, final WeakReference<NeatTextView> paramWeakReference1)
  {
    AppMethodBeat.i(254398);
    String str3 = (String)paramMap.get(paramString + ".title");
    final LinkedList localLinkedList = new LinkedList();
    int i = 0;
    for (;;)
    {
      String str2 = paramString + ".usernamelist.username";
      String str1 = str2;
      if (i != 0) {
        str1 = str2 + i;
      }
      str1 = (String)paramMap.get(str1);
      if (Util.isNullOrNil(str1)) {
        break;
      }
      localLinkedList.add(str1);
      i += 1;
    }
    paramString = new SpannableString(str3);
    paramString.setSpan(new a(paramBundle)
    {
      public final void onClickImp(View paramAnonymousView)
      {
        AppMethodBeat.i(254390);
        long l = paramBundle.getLong("msg_id");
        b.this.a(l, localLinkedList, 1);
        ((e)h.ax(e.class)).a("link_revoke", paramMap, paramBundle);
        AppMethodBeat.o(254390);
      }
    }, 0, str3.length(), 33);
    AppMethodBeat.o(254398);
    return paramString;
  }
  
  public final String gbt()
  {
    return "link_revoke";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.l.b
 * JD-Core Version:    0.7.0.1
 */