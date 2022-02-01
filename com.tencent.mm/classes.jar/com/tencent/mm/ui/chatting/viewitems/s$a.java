package com.tencent.mm.ui.chatting.viewitems;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
import com.tencent.mm.pluginsdk.ui.span.g;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pluginsdk.ui.span.n;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.widget.MMNeat7extView;

final class s$a
  extends c.a
{
  private MMNeat7extView IlT;
  
  public static void a(a parama, int paramInt, a parama1, bo parambo, c paramc)
  {
    AppMethodBeat.i(36984);
    k.b localb = null;
    Object localObject2 = parambo.field_content;
    Object localObject1 = localObject2;
    if (parama1.foQ())
    {
      int i = parambo.field_content.indexOf(':');
      localObject1 = localObject2;
      if (i != -1) {
        localObject1 = parambo.field_content.substring(i + 1);
      }
    }
    if (localObject1 != null) {
      localb = k.b.az((String)localObject1, parambo.field_reserved);
    }
    if ((localb != null) && (localb.type == 47))
    {
      localObject1 = localb.content;
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("rawUrl", localb.url);
      ((Bundle)localObject2).putString("sender_name", parambo.field_talker);
      localObject1 = k.a(ai.getContext(), (CharSequence)localObject1, (int)parama.IlT.getTextSize(), 4, localObject2, true);
      parama.IlT.a((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
      parama.IlT.setTag(new bj(parambo, parama1.foQ(), paramInt, parambo.field_talker, '\000'));
      az.ayM();
      if (com.tencent.mm.model.c.isSDCardAvailable()) {
        parama.IlT.setOnLongClickListener(paramc.c(parama1));
      }
    }
    AppMethodBeat.o(36984);
  }
  
  public final a gi(View paramView)
  {
    AppMethodBeat.i(36983);
    super.fX(paramView);
    this.IlT = ((MMNeat7extView)paramView.findViewById(2131298073));
    this.IlT.setOnTouchListener(new g(this.IlT, new n(this.IlT.getContext())));
    this.ijt = ((CheckBox)paramView.findViewById(2131298068));
    this.gGk = paramView.findViewById(2131298147);
    this.vYf = ((ProgressBar)paramView.findViewById(2131306220));
    AppMethodBeat.o(36983);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.s.a
 * JD-Core Version:    0.7.0.1
 */