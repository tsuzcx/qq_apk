package com.tencent.mm.view.popview;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.b.ai;
import com.tencent.mm.emoji.b.b.h;
import com.tencent.mm.emoji.b.p;
import com.tencent.mm.storage.emotion.EmojiInfo;

public final class c
{
  public static void a(AbstractPopView paramAbstractPopView, Object paramObject)
  {
    AppMethodBeat.i(105304);
    if ((paramAbstractPopView instanceof EmojiPopView))
    {
      if ((paramObject instanceof EmojiInfo))
      {
        ((EmojiPopView)paramAbstractPopView).setEmojiInfo((EmojiInfo)paramObject);
        AppMethodBeat.o(105304);
        return;
      }
      if ((paramObject instanceof h))
      {
        ((EmojiPopView)paramAbstractPopView).setEmojiInfo(((h)paramObject).gWm);
        AppMethodBeat.o(105304);
      }
    }
    else if ((paramAbstractPopView instanceof SmileyPopView))
    {
      if ((paramObject instanceof p))
      {
        ((SmileyPopView)paramAbstractPopView).setSmileyItem((p)paramObject);
        AppMethodBeat.o(105304);
        return;
      }
      if ((paramObject instanceof ai)) {
        ((SmileyPopView)paramAbstractPopView).setSmileyItem(((ai)paramObject).gZf);
      }
    }
    AppMethodBeat.o(105304);
  }
  
  public static AbstractPopView b(Context paramContext, Object paramObject)
  {
    AppMethodBeat.i(105303);
    if (((paramObject instanceof p)) || ((paramObject instanceof ai)))
    {
      paramContext = new SmileyPopView(paramContext);
      AppMethodBeat.o(105303);
      return paramContext;
    }
    if (((paramObject instanceof h)) || ((paramObject instanceof EmojiInfo)))
    {
      paramContext = new EmojiPopView(paramContext);
      AppMethodBeat.o(105303);
      return paramContext;
    }
    paramContext = new EmojiPopView(paramContext);
    AppMethodBeat.o(105303);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.view.popview.c
 * JD-Core Version:    0.7.0.1
 */