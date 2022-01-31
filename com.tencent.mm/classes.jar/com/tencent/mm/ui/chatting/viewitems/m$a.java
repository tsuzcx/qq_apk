package com.tencent.mm.ui.chatting.viewitems;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.pluginsdk.ui.d.f;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pluginsdk.ui.d.m;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.widget.MMNeat7extView;

final class m$a
  extends c.a
{
  private ProgressBar pNd;
  private MMNeat7extView zUf;
  
  public static void a(a parama, int paramInt, a parama1, bi parambi, c paramc)
  {
    AppMethodBeat.i(32968);
    j.b localb = null;
    Object localObject2 = parambi.field_content;
    Object localObject1 = localObject2;
    if (parama1.dJG())
    {
      int i = parambi.field_content.indexOf(':');
      localObject1 = localObject2;
      if (i != -1) {
        localObject1 = parambi.field_content.substring(i + 1);
      }
    }
    if (localObject1 != null) {
      localb = j.b.ab((String)localObject1, parambi.field_reserved);
    }
    if ((localb != null) && (localb.type == 47))
    {
      localObject1 = localb.content;
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("rawUrl", localb.url);
      ((Bundle)localObject2).putString("sender_name", parambi.field_talker);
      localObject1 = j.a(ah.getContext(), (CharSequence)localObject1, (int)parama.zUf.getTextSize(), localObject2, true);
      parama.zUf.a((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
      parama.zUf.setTag(new az(parambi, parama1.dJG(), paramInt, parambi.field_talker, '\000'));
      aw.aaz();
      if (com.tencent.mm.model.c.isSDCardAvailable()) {
        parama.zUf.setOnLongClickListener(paramc.c(parama1));
      }
    }
    AppMethodBeat.o(32968);
  }
  
  public final a fd(View paramView)
  {
    AppMethodBeat.i(32967);
    super.eV(paramView);
    this.zUf = ((MMNeat7extView)paramView.findViewById(2131821123));
    this.zUf.setOnTouchListener(new f(this.zUf, new m(this.zUf.getContext())));
    this.mCC = ((CheckBox)paramView.findViewById(2131820579));
    this.jbK = paramView.findViewById(2131820586);
    this.pNd = ((ProgressBar)paramView.findViewById(2131822728));
    AppMethodBeat.o(32967);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.m.a
 * JD-Core Version:    0.7.0.1
 */