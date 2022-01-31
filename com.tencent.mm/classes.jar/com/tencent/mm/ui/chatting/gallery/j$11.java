package com.tencent.mm.ui.chatting.gallery;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.e;
import java.util.HashMap;

final class j$11
  implements Runnable
{
  j$11(j paramj, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(32326);
    if ((this.zNd.zJI == null) || (this.zNd.zJI.dJY() == null) || (j.l(this.zNd) == null))
    {
      ab.w("MicroMsg.Imagegallery.handler.video", "show error alert but adapter is null.");
      AppMethodBeat.o(32326);
      return;
    }
    this.zNd.zJI.dJY().a(false, 0.0F);
    if (!bo.isNullOrNil(this.mED)) {
      ab.e("MicroMsg.Imagegallery.handler.video", "mediaplay play video error, use third player.[%s]", new Object[] { this.mED });
    }
    try
    {
      Object localObject = new Intent();
      ((Intent)localObject).setAction("android.intent.action.VIEW");
      com.tencent.mm.sdk.platformtools.k.a(this.zNd.zJI.zJK, (Intent)localObject, e.avH(this.mED), "video/*");
      this.zNd.zJI.zJK.startActivity((Intent)localObject);
      localObject = (j.a)j.l(this.zNd).get(j.a(this.zNd));
      if ((localObject == null) || (((j.a)localObject).cmQ == null))
      {
        AppMethodBeat.o(32326);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.Imagegallery.handler.video", "startActivity fail, activity not found");
        h.h(this.zNd.zJI.zJK, 2131299759, 2131299760);
      }
      this.zNd.Ql(localException.pos);
      AppMethodBeat.o(32326);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.j.11
 * JD-Core Version:    0.7.0.1
 */