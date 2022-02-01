package com.tencent.mm.view.popview;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.c.b.ak;
import com.tencent.mm.emoji.c.b.h;
import com.tencent.mm.emoji.c.q;
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
        ((EmojiPopView)paramAbstractPopView).setEmojiInfo(((h)paramObject).mgK);
        AppMethodBeat.o(105304);
      }
    }
    else if ((paramAbstractPopView instanceof SmileyPopView))
    {
      if ((paramObject instanceof q))
      {
        ((SmileyPopView)paramAbstractPopView).setSmileyItem((q)paramObject);
        AppMethodBeat.o(105304);
        return;
      }
      if ((paramObject instanceof ak)) {
        ((SmileyPopView)paramAbstractPopView).setSmileyItem(((ak)paramObject).mjw);
      }
    }
    AppMethodBeat.o(105304);
  }
  
  public static AbstractPopView c(Context paramContext, Object paramObject)
  {
    AppMethodBeat.i(105303);
    if (((paramObject instanceof q)) || ((paramObject instanceof ak)))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.view.popview.c
 * JD-Core Version:    0.7.0.1
 */