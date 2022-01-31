package com.tencent.mm.pluginsdk.ui.chat;

import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.ui.widget.a.e.a;
import java.util.ArrayList;

final class n$8$1
  implements RadioGroup.OnCheckedChangeListener
{
  n$8$1(n.8 param8, e.a parama) {}
  
  public final void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    n.b(this.shF.shE, paramInt);
    n.f(this.shF.shE).setText((CharSequence)n.e(this.shF.shE).get(n.d(this.shF.shE)));
    n.h(this.shF.shE).setLangType(((Integer)n.g(this.shF.shE).get(n.d(this.shF.shE))).intValue());
    this.gPd.few.dismiss();
    this.shF.shE.Eq(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.n.8.1
 * JD-Core Version:    0.7.0.1
 */