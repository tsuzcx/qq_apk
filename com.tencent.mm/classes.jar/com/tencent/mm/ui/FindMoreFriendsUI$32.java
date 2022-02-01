package com.tencent.mm.ui;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.kq;
import com.tencent.mm.modelimage.loader.b.k;

final class FindMoreFriendsUI$32
  implements k
{
  FindMoreFriendsUI$32(FindMoreFriendsUI paramFindMoreFriendsUI, kq paramkq) {}
  
  public final void onImageLoadComplete(String paramString, View paramView, Bitmap paramBitmap, Object... paramVarArgs)
  {
    AppMethodBeat.i(249753);
    this.IYa.hMl.bUl = 2;
    this.IYa.hMl.url = paramString;
    this.IYa.publish();
    AppMethodBeat.o(249753);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.FindMoreFriendsUI.32
 * JD-Core Version:    0.7.0.1
 */