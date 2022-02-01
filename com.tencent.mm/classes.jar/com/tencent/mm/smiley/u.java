package com.tencent.mm.smiley;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.span.f;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.Util;

public final class u
  implements f
{
  private static u acyQ;
  public int acyP = 300;
  
  private Spannable a(Context paramContext, Spannable paramSpannable, int paramInt)
  {
    AppMethodBeat.i(242873);
    if ((paramSpannable == null) || (Util.isNullOrNil(paramSpannable.toString())))
    {
      paramContext = new SpannableString("");
      AppMethodBeat.o(242873);
      return paramContext;
    }
    PInt localPInt = new PInt();
    localPInt.value = this.acyP;
    EmojiHelper.iUM();
    paramContext = EmojiHelper.a(paramContext, paramSpannable, paramInt, localPInt);
    paramContext = QQSmileyManager.iVq().a(paramContext, paramInt);
    AppMethodBeat.o(242873);
    return paramContext;
  }
  
  public static u iVt()
  {
    AppMethodBeat.i(104946);
    if (acyQ == null) {
      acyQ = new u();
    }
    u localu = acyQ;
    AppMethodBeat.o(104946);
    return localu;
  }
  
  public final SpannableString a(Context paramContext, CharSequence paramCharSequence, float paramFloat)
  {
    AppMethodBeat.i(242879);
    if ((paramCharSequence == null) || (Util.isNullOrNil(paramCharSequence.toString())))
    {
      paramContext = new SpannableString("");
      AppMethodBeat.o(242879);
      return paramContext;
    }
    if ((paramCharSequence instanceof SpannableString)) {}
    for (paramCharSequence = (SpannableString)paramCharSequence;; paramCharSequence = new SpannableString(paramCharSequence))
    {
      paramContext = (SpannableString)a(paramContext, paramCharSequence, (int)paramFloat);
      AppMethodBeat.o(242879);
      return paramContext;
    }
  }
  
  public final CharSequence a(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(242877);
    if ((paramCharSequence == null) || (Util.isNullOrNil(paramCharSequence.toString())))
    {
      paramContext = new SpannableString("");
      AppMethodBeat.o(242877);
      return paramContext;
    }
    if ((paramCharSequence instanceof Spannable)) {}
    for (paramCharSequence = (Spannable)paramCharSequence;; paramCharSequence = new SpannableString(paramCharSequence))
    {
      paramContext = a(paramContext, paramCharSequence, paramInt);
      AppMethodBeat.o(242877);
      return paramContext;
    }
  }
  
  public final boolean aa(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(104951);
    EmojiHelper.iUM();
    boolean bool = EmojiHelper.buu(paramCharSequence.toString());
    AppMethodBeat.o(104951);
    return bool;
  }
  
  public final boolean ab(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(104950);
    boolean bool = QQSmileyManager.iVq().buu(paramCharSequence.toString());
    AppMethodBeat.o(104950);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.smiley.u
 * JD-Core Version:    0.7.0.1
 */