package com.tencent.mm.pluginsdk.ui.chat;

import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout;
import com.tencent.mm.ui.widget.b.c;
import com.tencent.mm.ui.widget.b.e.a;
import java.util.ArrayList;

final class n$8$1
  implements RadioGroup.OnCheckedChangeListener
{
  n$8$1(n.8 param8, e.a parama) {}
  
  public final void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    AppMethodBeat.i(27979);
    n.b(this.vZX.vZW, paramInt);
    n.e(this.vZX.vZW).setText((CharSequence)n.d(this.vZX.vZW).get(n.c(this.vZX.vZW)));
    if (n.f(this.vZX.vZW) != null) {
      n.f(this.vZX.vZW).setLangType(((Integer)n.g(this.vZX.vZW).get(n.c(this.vZX.vZW))).intValue());
    }
    if (this.jLl.gwf != null) {
      this.jLl.gwf.dismiss();
    }
    this.vZX.vZW.Mo(2);
    AppMethodBeat.o(27979);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.n.8.1
 * JD-Core Version:    0.7.0.1
 */