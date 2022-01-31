package com.tencent.mm.view.e;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.debug.EmojiDebugUI;

public final class a$3
  implements View.OnLongClickListener
{
  public a$3(a parama) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(63025);
    paramView = new Intent(a.g(this.AUz), EmojiDebugUI.class);
    a.g(this.AUz).startActivity(paramView);
    AppMethodBeat.o(63025);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.view.e.a.3
 * JD-Core Version:    0.7.0.1
 */