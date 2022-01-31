package com.tencent.mm.view.popview;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.i;
import com.tencent.mm.storage.emotion.EmojiInfo;

public final class a
{
  public static void a(AbstractPopView paramAbstractPopView, Object paramObject)
  {
    AppMethodBeat.i(63069);
    if ((paramAbstractPopView instanceof EmojiPopView))
    {
      ((EmojiPopView)paramAbstractPopView).setEmojiInfo((EmojiInfo)paramObject);
      AppMethodBeat.o(63069);
      return;
    }
    if ((paramAbstractPopView instanceof SmileyPopView)) {
      ((SmileyPopView)paramAbstractPopView).setSmileyItem((i)paramObject);
    }
    AppMethodBeat.o(63069);
  }
  
  public static AbstractPopView b(Context paramContext, Object paramObject)
  {
    AppMethodBeat.i(63068);
    if ((paramObject instanceof i))
    {
      paramContext = new SmileyPopView(paramContext);
      AppMethodBeat.o(63068);
      return paramContext;
    }
    paramContext = new EmojiPopView(paramContext);
    AppMethodBeat.o(63068);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.popview.a
 * JD-Core Version:    0.7.0.1
 */