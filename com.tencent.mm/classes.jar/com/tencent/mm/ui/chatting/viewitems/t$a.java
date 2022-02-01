package com.tencent.mm.ui.chatting.viewitems;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.pluginsdk.ui.span.g;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pluginsdk.ui.span.n;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.widget.MMNeat7extView;

final class t$a
  extends c.a
{
  private MMNeat7extView KyL;
  
  public static void a(a parama, int paramInt, a parama1, bv parambv, c paramc)
  {
    AppMethodBeat.i(36984);
    k.b localb = null;
    Object localObject2 = parambv.field_content;
    Object localObject1 = localObject2;
    if (parama1.fJC())
    {
      int i = parambv.field_content.indexOf(':');
      localObject1 = localObject2;
      if (i != -1) {
        localObject1 = parambv.field_content.substring(i + 1);
      }
    }
    if (localObject1 != null) {
      localb = k.b.aB((String)localObject1, parambv.field_reserved);
    }
    if ((localb != null) && (localb.type == 47))
    {
      localObject1 = localb.content;
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("rawUrl", localb.url);
      ((Bundle)localObject2).putString("sender_name", parambv.field_talker);
      localObject1 = k.a(ak.getContext(), (CharSequence)localObject1, (int)parama.KyL.getTextSize(), 4, localObject2, true);
      parama.KyL.a((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
      parama.KyL.setTag(new bk(parambv, parama1.fJC(), paramInt, parambv.field_talker, '\000'));
      bc.aCg();
      if (com.tencent.mm.model.c.isSDCardAvailable()) {
        parama.KyL.setOnLongClickListener(paramc.c(parama1));
      }
    }
    AppMethodBeat.o(36984);
  }
  
  public final a gE(View paramView)
  {
    AppMethodBeat.i(36983);
    super.gs(paramView);
    this.KyL = ((MMNeat7extView)paramView.findViewById(2131298073));
    this.KyL.setOnTouchListener(new g(this.KyL, new n(this.KyL.getContext())));
    this.iFD = ((CheckBox)paramView.findViewById(2131298068));
    this.hcH = paramView.findViewById(2131298147);
    this.xvJ = ((ProgressBar)paramView.findViewById(2131306220));
    AppMethodBeat.o(36983);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.t.a
 * JD-Core Version:    0.7.0.1
 */