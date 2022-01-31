package com.tencent.mm.ui.chatting.m;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class b
  extends a
{
  public b(a.b paramb)
  {
    super(paramb);
  }
  
  final CharSequence b(Map<String, String> paramMap, String paramString, Bundle paramBundle, WeakReference<Context> paramWeakReference)
  {
    AppMethodBeat.i(32742);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    String str = bo.bf((String)paramMap.get(paramString + ".separator"), "、");
    int i = 0;
    Object localObject2 = new StringBuilder().append(paramString).append(".memberlist.member");
    Object localObject1;
    if (i != 0)
    {
      localObject1 = Integer.valueOf(i);
      label83:
      localObject2 = localObject1;
      if (paramMap.get(localObject2) == null) {
        break label267;
      }
      if (i != 0) {
        localSpannableStringBuilder.append(str);
      }
      localObject1 = (String)paramMap.get((String)localObject2 + ".username");
      localObject2 = (String)paramMap.get((String)localObject2 + ".nickname");
      if ((!bo.isNullOrNil((String)localObject1)) && (!bo.isNullOrNil((String)localObject2))) {
        break label220;
      }
      ab.w("MicroMsg.SysMsgHandlerProfile", "hy: can not resolve username or nickname");
    }
    for (;;)
    {
      i += 1;
      break;
      localObject1 = "";
      break label83;
      label220:
      SpannableString localSpannableString = j.b(ah.getContext(), (CharSequence)localObject2);
      localSpannableString.setSpan(new b.1(this, paramWeakReference, paramBundle, (String)localObject1), 0, ((String)localObject2).length(), 33);
      localSpannableStringBuilder.append(localSpannableString);
    }
    label267:
    AppMethodBeat.o(32742);
    return localSpannableStringBuilder;
  }
  
  final String dLm()
  {
    return "link_profile";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.m.b
 * JD-Core Version:    0.7.0.1
 */