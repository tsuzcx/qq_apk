package com.tencent.mm.ui.chatting.c;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.chatting.view.AvatarImageView;
import com.tencent.mm.ui.chatting.viewitems.az;
import java.lang.ref.WeakReference;

final class al$3
  implements Runnable
{
  al$3(al paramal, String paramString, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(31722);
    int i = 0;
    while (i < al.i(this.zIt).size())
    {
      AvatarImageView localAvatarImageView = (AvatarImageView)((WeakReference)al.i(this.zIt).valueAt(i)).get();
      if (localAvatarImageView != null)
      {
        Object localObject = localAvatarImageView.getTag();
        if (((localObject instanceof az)) && (this.efI.equals(((az)localObject).userName)))
        {
          localAvatarImageView.dw(((az)localObject).userName, 5);
          localAvatarImageView.setShowStoryHint(this.zIu);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(31722);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.al.3
 * JD-Core Version:    0.7.0.1
 */