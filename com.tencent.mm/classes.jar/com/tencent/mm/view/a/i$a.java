package com.tencent.mm.view.a;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emojicapture.api.c;
import com.tencent.mm.view.f.a;

final class i$a
  extends i.c
{
  View ASl;
  ImageView ASm;
  TextView ASn;
  TextView ASo;
  
  public i$a(final i parami, View paramView, int paramInt)
  {
    super(parami, paramView, paramInt);
    AppMethodBeat.i(62998);
    this.ASl = paramView.findViewById(2131823608);
    this.ASm = ((ImageView)paramView.findViewById(2131823609));
    this.ASn = ((TextView)paramView.findViewById(2131823610));
    this.ASo = ((TextView)paramView.findViewById(2131823611));
    this.ASm.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(62997);
        if (((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().OR()) {
          c.h(i.a.this.ASp.mContext, null, a.RQ(i.a.this.ASp.AQS.mScene));
        }
        AppMethodBeat.o(62997);
      }
    });
    AppMethodBeat.o(62998);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.a.i.a
 * JD-Core Version:    0.7.0.1
 */