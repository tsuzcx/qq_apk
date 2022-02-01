package com.tencent.mm.ui.chatting.o;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.plugin.messenger.d.b;
import com.tencent.mm.plugin.messenger.d.b.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
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
    AppMethodBeat.i(187641);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    String str1 = bu.bI((String)paramMap.get(paramString + ".separator"), "、");
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
      if ((!bu.isNullOrNil((String)localObject1)) && (!bu.isNullOrNil((String)localObject2))) {
        break label250;
      }
      ae.w("MicroMsg.SysMsgHandlerProfile", "hy: can not resolve username or nickname");
    }
    for (;;)
    {
      i += 1;
      break;
      localObject1 = "";
      break label82;
      label250:
      SpannableString localSpannableString = k.c(ak.getContext(), (CharSequence)localObject2);
      localSpannableString.setSpan(new com.tencent.mm.plugin.messenger.a.a()
      {
        public final void onClickImp(View paramAnonymousView)
        {
          AppMethodBeat.i(187640);
          ((e)g.ab(e.class)).a("link_profile", paramMap, paramBundle);
          if ((paramWeakReference != null) && (paramWeakReference.get() != null))
          {
            long l = paramBundle.getLong("msg_id");
            paramAnonymousView = paramBundle.getString("conv_talker_username", null);
            if (x.wb(paramAnonymousView))
            {
              a.a((Context)paramWeakReference.get(), this.fOp, paramAnonymousView, str2, l);
              AppMethodBeat.o(187640);
              return;
            }
            a.a((Context)paramWeakReference.get(), this.fOp, null, str2, l);
          }
          AppMethodBeat.o(187640);
        }
      }, 0, ((String)localObject2).length(), 33);
      localSpannableStringBuilder.append(localSpannableString);
    }
    label302:
    AppMethodBeat.o(187641);
    return localSpannableStringBuilder;
  }
  
  public final String dpe()
  {
    return "link_profile";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.o.a
 * JD-Core Version:    0.7.0.1
 */