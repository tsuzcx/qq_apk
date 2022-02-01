package com.tencent.mm.ui.chatting.n;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.a;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.plugin.messenger.d.b.b;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Map;

public final class b
  extends com.tencent.mm.plugin.messenger.d.b
{
  public b(b.b paramb)
  {
    super(paramb);
  }
  
  public final CharSequence b(final Map<String, String> paramMap, String paramString, final Bundle paramBundle, final WeakReference<Context> paramWeakReference, final WeakReference<NeatTextView> paramWeakReference1)
  {
    AppMethodBeat.i(191591);
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
      if (bt.isNullOrNil(str1)) {
        break;
      }
      localLinkedList.add(str1);
      i += 1;
    }
    paramString = new SpannableString(str3);
    paramString.setSpan(new a()
    {
      public final void onClickImp(View paramAnonymousView)
      {
        AppMethodBeat.i(191590);
        paramAnonymousView = b.this;
        LinkedList localLinkedList = localLinkedList;
        if ((paramAnonymousView.tzf != null) && (paramAnonymousView.tzf.get() != null)) {
          ((b.b)paramAnonymousView.tzf.get()).az(localLinkedList);
        }
        ((f)g.ab(f.class)).a("link_revoke", paramMap, paramBundle);
        AppMethodBeat.o(191590);
      }
    }, 0, str3.length(), 33);
    AppMethodBeat.o(191591);
    return paramString;
  }
  
  public final String cPc()
  {
    return "link_revoke";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.n.b
 * JD-Core Version:    0.7.0.1
 */