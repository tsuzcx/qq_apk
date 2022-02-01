package com.tencent.mm.ui.chatting.viewitems;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.pluginsdk.ui.span.g;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pluginsdk.ui.span.n;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.widget.MMNeat7extView;

final class t$a
  extends c.a
{
  private MMNeat7extView Kct;
  
  public static void a(a parama, int paramInt, a parama1, bu parambu, c paramc)
  {
    AppMethodBeat.i(36984);
    k.b localb = null;
    Object localObject2 = parambu.field_content;
    Object localObject1 = localObject2;
    if (parama1.fFv())
    {
      int i = parambu.field_content.indexOf(':');
      localObject1 = localObject2;
      if (i != -1) {
        localObject1 = parambu.field_content.substring(i + 1);
      }
    }
    if (localObject1 != null) {
      localb = k.b.aA((String)localObject1, parambu.field_reserved);
    }
    if ((localb != null) && (localb.type == 47))
    {
      localObject1 = localb.content;
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("rawUrl", localb.url);
      ((Bundle)localObject2).putString("sender_name", parambu.field_talker);
      localObject1 = k.a(aj.getContext(), (CharSequence)localObject1, (int)parama.Kct.getTextSize(), 4, localObject2, true);
      parama.Kct.a((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
      parama.Kct.setTag(new bk(parambu, parama1.fFv(), paramInt, parambu.field_talker, '\000'));
      ba.aBQ();
      if (com.tencent.mm.model.c.isSDCardAvailable()) {
        parama.Kct.setOnLongClickListener(paramc.c(parama1));
      }
    }
    AppMethodBeat.o(36984);
  }
  
  public final a gz(View paramView)
  {
    AppMethodBeat.i(36983);
    super.gn(paramView);
    this.Kct = ((MMNeat7extView)paramView.findViewById(2131298073));
    this.Kct.setOnTouchListener(new g(this.Kct, new n(this.Kct.getContext())));
    this.iCK = ((CheckBox)paramView.findViewById(2131298068));
    this.gZU = paramView.findViewById(2131298147);
    this.xfR = ((ProgressBar)paramView.findViewById(2131306220));
    AppMethodBeat.o(36983);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.t.a
 * JD-Core Version:    0.7.0.1
 */