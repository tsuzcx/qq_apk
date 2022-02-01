package com.tencent.mm.ui;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.c.k;
import com.tencent.mm.f.a.jp;
import com.tencent.mm.sdk.event.EventCenter;

final class FindMoreFriendsUI$26
  implements k
{
  FindMoreFriendsUI$26(FindMoreFriendsUI paramFindMoreFriendsUI, jp paramjp) {}
  
  public final void a(String paramString, View paramView, Bitmap paramBitmap, Object... paramVarArgs)
  {
    AppMethodBeat.i(280465);
    this.DdJ.fGP.Vh = 2;
    this.DdJ.fGP.url = paramString;
    EventCenter.instance.publish(this.DdJ);
    AppMethodBeat.o(280465);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.FindMoreFriendsUI.26
 * JD-Core Version:    0.7.0.1
 */