package com.tencent.mm.ui.chatting.l;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.view.View;
import com.tencent.mm.model.s;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class b
  extends a
{
  public b(a.b paramb)
  {
    super(paramb);
  }
  
  final CharSequence b(Map<String, String> paramMap, String paramString, final Bundle paramBundle, final WeakReference<Context> paramWeakReference)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    String str = bk.aM((String)paramMap.get(paramString + ".separator"), "、");
    int i = 0;
    Object localObject2 = new StringBuilder().append(paramString).append(".memberlist.member");
    Object localObject1;
    if (i != 0)
    {
      localObject1 = Integer.valueOf(i);
      label77:
      localObject2 = localObject1;
      if (paramMap.get(localObject2) == null) {
        break label261;
      }
      if (i != 0) {
        localSpannableStringBuilder.append(str);
      }
      localObject1 = (String)paramMap.get((String)localObject2 + ".username");
      localObject2 = (String)paramMap.get((String)localObject2 + ".nickname");
      if ((!bk.bl((String)localObject1)) && (!bk.bl((String)localObject2))) {
        break label214;
      }
      y.w("MicroMsg.SysMsgHandlerProfile", "hy: can not resolve username or nickname");
    }
    for (;;)
    {
      i += 1;
      break;
      localObject1 = "";
      break label77;
      label214:
      SpannableString localSpannableString = j.b(ae.getContext(), (CharSequence)localObject2);
      localSpannableString.setSpan(new com.tencent.mm.plugin.messenger.a.a()
      {
        public final void onClickImp(View paramAnonymousView)
        {
          if ((paramWeakReference != null) && (paramWeakReference.get() != null))
          {
            paramAnonymousView = paramBundle.getString("conv_talker_username", null);
            if (s.fn(paramAnonymousView)) {
              b.A((Context)paramWeakReference.get(), this.egy, paramAnonymousView);
            }
          }
          else
          {
            return;
          }
          b.A((Context)paramWeakReference.get(), this.egy, null);
        }
      }, 0, ((String)localObject2).length(), 33);
      localSpannableStringBuilder.append(localSpannableString);
    }
    label261:
    return localSpannableStringBuilder;
  }
  
  final String cGZ()
  {
    return "link_profile";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.l.b
 * JD-Core Version:    0.7.0.1
 */