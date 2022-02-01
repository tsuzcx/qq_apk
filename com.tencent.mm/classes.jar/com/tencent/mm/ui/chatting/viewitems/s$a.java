package com.tencent.mm.ui.chatting.viewitems;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.pluginsdk.ui.span.g;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pluginsdk.ui.span.n;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.widget.MMNeat7extView;

final class s$a
  extends c.a
{
  private MMNeat7extView GLW;
  private ProgressBar uPp;
  
  public static void a(a parama, int paramInt, a parama1, bl parambl, c paramc)
  {
    AppMethodBeat.i(36984);
    k.b localb = null;
    Object localObject2 = parambl.field_content;
    Object localObject1 = localObject2;
    if (parama1.eZb())
    {
      int i = parambl.field_content.indexOf(':');
      localObject1 = localObject2;
      if (i != -1) {
        localObject1 = parambl.field_content.substring(i + 1);
      }
    }
    if (localObject1 != null) {
      localb = k.b.ar((String)localObject1, parambl.field_reserved);
    }
    if ((localb != null) && (localb.type == 47))
    {
      localObject1 = localb.content;
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("rawUrl", localb.url);
      ((Bundle)localObject2).putString("sender_name", parambl.field_talker);
      localObject1 = k.a(aj.getContext(), (CharSequence)localObject1, (int)parama.GLW.getTextSize(), 4, localObject2, true);
      parama.GLW.a((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
      parama.GLW.setTag(new bi(parambl, parama1.eZb(), paramInt, parambl.field_talker, '\000'));
      az.arV();
      if (com.tencent.mm.model.c.isSDCardAvailable()) {
        parama.GLW.setOnLongClickListener(paramc.c(parama1));
      }
    }
    AppMethodBeat.o(36984);
  }
  
  public final a fV(View paramView)
  {
    AppMethodBeat.i(36983);
    super.fK(paramView);
    this.GLW = ((MMNeat7extView)paramView.findViewById(2131298073));
    this.GLW.setOnTouchListener(new g(this.GLW, new n(this.GLW.getContext())));
    this.hIS = ((CheckBox)paramView.findViewById(2131298068));
    this.lRB = paramView.findViewById(2131298147);
    this.uPp = ((ProgressBar)paramView.findViewById(2131306220));
    AppMethodBeat.o(36983);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.s.a
 * JD-Core Version:    0.7.0.1
 */