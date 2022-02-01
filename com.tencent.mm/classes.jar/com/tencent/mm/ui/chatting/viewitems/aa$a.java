package com.tencent.mm.ui.chatting.viewitems;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.bh;
import com.tencent.mm.pluginsdk.ui.span.h;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.widget.MMNeat7extView;

final class aa$a
  extends c.a
{
  private MMNeat7extView yXc;
  
  public static void a(a parama, int paramInt, a parama1, ca paramca, c paramc)
  {
    AppMethodBeat.i(36984);
    k.b localb = null;
    Object localObject2 = paramca.field_content;
    Object localObject1 = localObject2;
    if (parama1.hRi())
    {
      int i = paramca.field_content.indexOf(':');
      localObject1 = localObject2;
      if (i != -1) {
        localObject1 = paramca.field_content.substring(i + 1);
      }
    }
    if (localObject1 != null) {
      localb = k.b.aG((String)localObject1, paramca.field_reserved);
    }
    if ((localb != null) && (localb.type == 47))
    {
      localObject1 = localb.content;
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("rawUrl", localb.url);
      ((Bundle)localObject2).putString("sender_name", paramca.field_talker);
      localObject1 = l.a(MMApplicationContext.getContext(), (CharSequence)localObject1, (int)parama.yXc.getTextSize(), 4, localObject2, true);
      parama.yXc.a((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
      parama.yXc.setTag(new by(paramca, parama1.hRi(), paramInt, paramca.field_talker, '\000'));
      bh.beI();
      if (com.tencent.mm.model.c.isSDCardAvailable()) {
        parama.yXc.setOnLongClickListener(paramc.c(parama1));
      }
    }
    AppMethodBeat.o(36984);
  }
  
  public final View getMainContainerView()
  {
    return this.yXc;
  }
  
  public final a ig(View paramView)
  {
    AppMethodBeat.i(36983);
    super.create(paramView);
    this.yXc = ((MMNeat7extView)paramView.findViewById(R.h.chatting_content_itv));
    this.yXc.setOnTouchListener(new h(this.yXc, new o(this.yXc.getContext())));
    this.checkBox = ((CheckBox)paramView.findViewById(R.h.dwZ));
    this.maskView = paramView.findViewById(R.h.dyD);
    this.uploadingPB = ((ProgressBar)paramView.findViewById(R.h.dYz));
    AppMethodBeat.o(36983);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aa.a
 * JD-Core Version:    0.7.0.1
 */