package com.tencent.mm.view.popview;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.a.ae;
import com.tencent.mm.emoji.a.a.h;
import com.tencent.mm.emoji.a.n;
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
        ((EmojiPopView)paramAbstractPopView).setEmojiInfo(((h)paramObject).fLP);
        AppMethodBeat.o(105304);
      }
    }
    else if ((paramAbstractPopView instanceof SmileyPopView))
    {
      if ((paramObject instanceof n))
      {
        ((SmileyPopView)paramAbstractPopView).setSmileyItem((n)paramObject);
        AppMethodBeat.o(105304);
        return;
      }
      if ((paramObject instanceof ae)) {
        ((SmileyPopView)paramAbstractPopView).setSmileyItem(((ae)paramObject).fOB);
      }
    }
    AppMethodBeat.o(105304);
  }
  
  public static AbstractPopView b(Context paramContext, Object paramObject)
  {
    AppMethodBeat.i(105303);
    if (((paramObject instanceof n)) || ((paramObject instanceof ae)))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.popview.c
 * JD-Core Version:    0.7.0.1
 */