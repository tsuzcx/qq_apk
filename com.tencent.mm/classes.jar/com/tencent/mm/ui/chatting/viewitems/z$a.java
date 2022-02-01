package com.tencent.mm.ui.chatting.viewitems;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.pluginsdk.ui.span.s;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.widget.MMNeat7extView;

final class z$a
  extends c.a
{
  private MMNeat7extView DQt;
  
  public static void a(a parama, int paramInt, a parama1, cc paramcc, c paramc)
  {
    AppMethodBeat.i(36984);
    k.b localb = null;
    Object localObject2 = paramcc.field_content;
    Object localObject1 = localObject2;
    if (parama1.juG())
    {
      int i = paramcc.field_content.indexOf(':');
      localObject1 = localObject2;
      if (i != -1) {
        localObject1 = paramcc.field_content.substring(i + 1);
      }
    }
    if (localObject1 != null) {
      localb = k.b.aP((String)localObject1, paramcc.field_reserved);
    }
    if ((localb != null) && (localb.type == 47))
    {
      localObject1 = localb.content;
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("rawUrl", localb.url);
      ((Bundle)localObject2).putString("sender_name", paramcc.field_talker);
      localObject1 = p.a(MMApplicationContext.getContext(), (CharSequence)localObject1, (int)parama.DQt.getTextSize(), 4, localObject2, true);
      parama.DQt.a((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
      parama.DQt.setTag(new bz(paramcc, parama1.juG(), paramInt, paramcc.field_talker, '\000'));
      bh.bCz();
      if (com.tencent.mm.model.c.isSDCardAvailable()) {
        parama.DQt.setOnLongClickListener(paramc.c(parama1));
      }
    }
    AppMethodBeat.o(36984);
  }
  
  public final View getMainContainerView()
  {
    return this.DQt;
  }
  
  public final a lC(View paramView)
  {
    AppMethodBeat.i(36983);
    super.create(paramView);
    this.DQt = ((MMNeat7extView)paramView.findViewById(R.h.fxy));
    this.DQt.setOnTouchListener(new l(this.DQt, new s(this.DQt.getContext())));
    this.checkBox = ((CheckBox)paramView.findViewById(R.h.fxt));
    this.maskView = paramView.findViewById(R.h.fzn);
    this.uploadingPB = ((ProgressBar)paramView.findViewById(R.h.gbo));
    AppMethodBeat.o(36983);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.z.a
 * JD-Core Version:    0.7.0.1
 */