package com.tencent.mm.ui.chatting.n;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.plugin.messenger.d.b;
import com.tencent.mm.plugin.messenger.d.b.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class a
  extends b
{
  public a(b.b paramb)
  {
    super(paramb);
  }
  
  public final CharSequence b(final Map<String, String> paramMap, String paramString, final Bundle paramBundle, final WeakReference<Context> paramWeakReference, final WeakReference<NeatTextView> paramWeakReference1)
  {
    AppMethodBeat.i(196653);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    String str1 = bs.bG((String)paramMap.get(paramString + ".separator"), "、");
    int i = 0;
    Object localObject2 = new StringBuilder().append(paramString).append(".memberlist.member");
    Object localObject1;
    label82:
    final String str2;
    if (i != 0)
    {
      localObject1 = Integer.valueOf(i);
      str2 = localObject1;
      if (paramMap.get(str2) == null) {
        break label302;
      }
      if (i != 0) {
        localSpannableStringBuilder.append(str1);
      }
      localObject1 = (String)paramMap.get(str2 + ".username");
      localObject2 = (String)paramMap.get(str2 + ".nickname");
      str2 = (String)paramMap.get(str2 + ".antispam_ticket");
      if ((!bs.isNullOrNil((String)localObject1)) && (!bs.isNullOrNil((String)localObject2))) {
        break label250;
      }
      ac.w("MicroMsg.SysMsgHandlerProfile", "hy: can not resolve username or nickname");
    }
    for (;;)
    {
      i += 1;
      break;
      localObject1 = "";
      break label82;
      label250:
      SpannableString localSpannableString = k.c(ai.getContext(), (CharSequence)localObject2);
      localSpannableString.setSpan(new com.tencent.mm.plugin.messenger.a.a()
      {
        public final void onClickImp(View paramAnonymousView)
        {
          AppMethodBeat.i(196652);
          ((f)g.ab(f.class)).a("link_profile", paramMap, paramBundle);
          if ((paramWeakReference != null) && (paramWeakReference.get() != null))
          {
            long l = paramBundle.getLong("msg_id");
            paramAnonymousView = paramBundle.getString("conv_talker_username", null);
            if (w.sQ(paramAnonymousView))
            {
              a.a((Context)paramWeakReference.get(), this.hyc, paramAnonymousView, str2, l);
              AppMethodBeat.o(196652);
              return;
            }
            a.a((Context)paramWeakReference.get(), this.hyc, null, str2, l);
          }
          AppMethodBeat.o(196652);
        }
      }, 0, ((String)localObject2).length(), 33);
      localSpannableStringBuilder.append(localSpannableString);
    }
    label302:
    AppMethodBeat.o(196653);
    return localSpannableStringBuilder;
  }
  
  public final String dcL()
  {
    return "link_profile";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.n.a
 * JD-Core Version:    0.7.0.1
 */