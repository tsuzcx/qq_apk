package com.tencent.mm.ui.chatting.viewitems;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.bg;
import com.tencent.mm.pluginsdk.ui.span.h;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.widget.MMNeat7extView;

final class x$a
  extends c.a
{
  private MMNeat7extView PKY;
  
  public static void a(a parama, int paramInt, a parama1, ca paramca, c paramc)
  {
    AppMethodBeat.i(36984);
    k.b localb = null;
    Object localObject2 = paramca.field_content;
    Object localObject1 = localObject2;
    if (parama1.gRM())
    {
      int i = paramca.field_content.indexOf(':');
      localObject1 = localObject2;
      if (i != -1) {
        localObject1 = paramca.field_content.substring(i + 1);
      }
    }
    if (localObject1 != null) {
      localb = k.b.aD((String)localObject1, paramca.field_reserved);
    }
    if ((localb != null) && (localb.type == 47))
    {
      localObject1 = localb.content;
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("rawUrl", localb.url);
      ((Bundle)localObject2).putString("sender_name", paramca.field_talker);
      localObject1 = l.a(MMApplicationContext.getContext(), (CharSequence)localObject1, (int)parama.PKY.getTextSize(), 4, localObject2, true);
      parama.PKY.a((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
      parama.PKY.setTag(new bq(paramca, parama1.gRM(), paramInt, paramca.field_talker, '\000'));
      bg.aVF();
      if (com.tencent.mm.model.c.isSDCardAvailable()) {
        parama.PKY.setOnLongClickListener(paramc.c(parama1));
      }
    }
    AppMethodBeat.o(36984);
  }
  
  public final a gU(View paramView)
  {
    AppMethodBeat.i(36983);
    super.create(paramView);
    this.PKY = ((MMNeat7extView)paramView.findViewById(2131298416));
    this.PKY.setOnTouchListener(new h(this.PKY, new o(this.PKY.getContext())));
    this.checkBox = ((CheckBox)paramView.findViewById(2131298410));
    this.maskView = paramView.findViewById(2131298508);
    this.uploadingPB = ((ProgressBar)paramView.findViewById(2131309619));
    AppMethodBeat.o(36983);
    return this;
  }
  
  public final View getMainContainerView()
  {
    return this.PKY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.x.a
 * JD-Core Version:    0.7.0.1
 */