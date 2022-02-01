package com.tencent.mm.pluginsdk.ui;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$b$1
  implements View.OnLongClickListener
{
  a$b$1(ImageView paramImageView, String paramString) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(152099);
    ((ClipboardManager)this.pBf.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("UserName:", this.crn));
    Toast.makeText(this.pBf.getContext(), 2131755702, 0).show();
    AppMethodBeat.o(152099);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.a.b.1
 * JD-Core Version:    0.7.0.1
 */