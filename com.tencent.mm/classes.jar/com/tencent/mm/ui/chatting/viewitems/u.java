package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.e.a;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class u
{
  static final class h
    extends u.b
  {
    ImageView iTH;
    ImageView jXH;
    MMNeat7extView jXI;
    ImageView jXx;
    View jYA;
    TextView timeTv;
    
    public final void fj(View paramView)
    {
      AppMethodBeat.i(33077);
      if (this.jXr != null)
      {
        AppMethodBeat.o(33077);
        return;
      }
      ViewStub localViewStub = (ViewStub)paramView.findViewById(2131821879);
      if (localViewStub == null)
      {
        AppMethodBeat.o(33077);
        return;
      }
      localViewStub.inflate();
      this.jXr = paramView.findViewById(2131821935);
      this.jXx = ((ImageView)this.jXr.findViewById(2131821438));
      this.jXG = ((ImageView)this.jXr.findViewById(2131821917));
      this.jXH = ((ImageView)this.jXr.findViewById(2131821909));
      this.iTH = ((ImageView)this.jXr.findViewById(2131821939));
      this.jXI = ((MMNeat7extView)this.jXr.findViewById(2131821212));
      this.timeTv = ((TextView)this.jXr.findViewById(2131821004));
      this.jYA = this.jXr.findViewById(2131821937);
      AppMethodBeat.o(33077);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.u
 * JD-Core Version:    0.7.0.1
 */