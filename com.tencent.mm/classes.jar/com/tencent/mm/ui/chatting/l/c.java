package com.tencent.mm.ui.chatting.l;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import com.tencent.mm.sdk.platformtools.bk;
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
      if (bk.bl(paramBundle)) {
        break;
      }
      localLinkedList.add(paramBundle);
      i += 1;
    }
    paramMap = new SpannableString(str);
    paramMap.setSpan(new c.1(this, localLinkedList), 0, str.length(), 33);
    return paramMap;
  }
  
  final String cGZ()
  {
    return "link_revoke";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.l.c
 * JD-Core Version:    0.7.0.1
 */