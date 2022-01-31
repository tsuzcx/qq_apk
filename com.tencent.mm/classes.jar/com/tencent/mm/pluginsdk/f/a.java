package com.tencent.mm.pluginsdk.f;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;

public final class a
{
  public static void b(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    AppMethodBeat.i(79446);
    if (Build.VERSION.SDK_INT >= 11)
    {
      new b();
      b.b(paramCharSequence1, paramCharSequence2);
      AppMethodBeat.o(79446);
      return;
    }
    new c();
    c.L(paramCharSequence2);
    AppMethodBeat.o(79446);
  }
  
  public static CharSequence dlQ()
  {
    AppMethodBeat.i(79447);
    if (Build.VERSION.SDK_INT >= 11)
    {
      new b();
      localObject = ((android.content.ClipboardManager)ah.getContext().getSystemService("clipboard")).getPrimaryClip();
      if ((localObject == null) || (((ClipData)localObject).getItemCount() <= 0))
      {
        AppMethodBeat.o(79447);
        return null;
      }
      localObject = ((ClipData)localObject).getItemAt(0);
      if (localObject == null)
      {
        AppMethodBeat.o(79447);
        return null;
      }
      localObject = ((ClipData.Item)localObject).getText();
      AppMethodBeat.o(79447);
      return localObject;
    }
    new c();
    Object localObject = ((android.text.ClipboardManager)ah.getContext().getSystemService("clipboard")).getText();
    AppMethodBeat.o(79447);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.f.a
 * JD-Core Version:    0.7.0.1
 */