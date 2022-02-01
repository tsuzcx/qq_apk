package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.c.d;
import com.tencent.mm.ay.q;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;

final class ae$c$1
  implements d
{
  ae$c$1(com.tencent.mm.ui.chatting.e.a parama, boolean paramBoolean) {}
  
  public final void a(boolean paramBoolean, final Object... paramVarArgs)
  {
    AppMethodBeat.i(267439);
    final ImageView localImageView = (ImageView)paramVarArgs[0];
    final String str1 = (String)paramVarArgs[1];
    final RelativeLayout localRelativeLayout = (RelativeLayout)paramVarArgs[2];
    final String str2 = (String)paramVarArgs[3];
    paramVarArgs = BitmapUtil.getBitmapNative((String)paramVarArgs[4], localImageView.getWidth(), localImageView.getHeight());
    final Bitmap localBitmap = ae.b(this.QWD.WQv.getContext(), paramVarArgs, localRelativeLayout.getHeight(), localRelativeLayout.getWidth(), this.EzU);
    q.bml().h(str1, paramVarArgs);
    q.bml().h(str2, localBitmap);
    h.ZvG.bc(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(206036);
        if ((localImageView.getTag() != null) && (localImageView.getTag().equals(str1)))
        {
          Log.i("MicroMsg.MusicItemHolder", "setImageBitmap %s %s %s ", new Object[] { Integer.valueOf(localImageView.hashCode()), localImageView.getTag(), str1 });
          localImageView.setImageBitmap(paramVarArgs);
        }
        if ((localRelativeLayout.getTag() != null) && (localRelativeLayout.getTag().equals(str2)))
        {
          BitmapDrawable localBitmapDrawable = new BitmapDrawable(ae.c.1.this.QWD.WQv.getContext().getResources(), localBitmap);
          localRelativeLayout.setBackground(localBitmapDrawable);
        }
        AppMethodBeat.o(206036);
      }
    });
    AppMethodBeat.o(267439);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ae.c.1
 * JD-Core Version:    0.7.0.1
 */