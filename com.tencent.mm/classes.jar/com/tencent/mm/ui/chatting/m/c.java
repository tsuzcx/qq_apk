package com.tencent.mm.ui.chatting.m;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Map;

public final class c
  extends a
{
  public c(a.b paramb)
  {
    super(paramb);
  }
  
  final CharSequence b(Map<String, String> paramMap, String paramString, Bundle paramBundle, WeakReference<Context> paramWeakReference)
  {
    AppMethodBeat.i(32745);
    String str = (String)paramMap.get(paramString + ".title");
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    for (;;)
    {
      paramWeakReference = paramString + ".usernamelist.username";
      paramBundle = paramWeakReference;
      if (i != 0) {
        paramBundle = paramWeakReference + i;
      }
      paramBundle = (String)paramMap.get(paramBundle);
      if (bo.isNullOrNil(paramBundle)) {
        break;
      }
      localLinkedList.add(paramBundle);
      i += 1;
    }
    paramMap = new SpannableString(str);
    paramMap.setSpan(new c.1(this, localLinkedList), 0, str.length(), 33);
    AppMethodBeat.o(32745);
    return paramMap;
  }
  
  final String dLm()
  {
    return "link_revoke";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.m.c
 * JD-Core Version:    0.7.0.1
 */