package com.tencent.mm.pluginsdk.i;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;

final class b
{
  @TargetApi(11)
  public static void b(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    AppMethodBeat.i(151889);
    ((ClipboardManager)aj.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(paramCharSequence1, paramCharSequence2));
    AppMethodBeat.o(151889);
  }
  
  @TargetApi(11)
  public static CharSequence faq()
  {
    AppMethodBeat.i(151890);
    Object localObject = ((ClipboardManager)aj.getContext().getSystemService("clipboard")).getPrimaryClip();
    if ((localObject == null) || (((ClipData)localObject).getItemCount() <= 0))
    {
      AppMethodBeat.o(151890);
      return null;
    }
    localObject = ((ClipData)localObject).getItemAt(0);
    if (localObject == null)
    {
      AppMethodBeat.o(151890);
      return null;
    }
    localObject = ((ClipData.Item)localObject).getText();
    AppMethodBeat.o(151890);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.i.b
 * JD-Core Version:    0.7.0.1
 */