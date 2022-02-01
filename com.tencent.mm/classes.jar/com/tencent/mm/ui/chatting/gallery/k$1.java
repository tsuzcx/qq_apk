package com.tencent.mm.ui.chatting.gallery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.pluginsdk.ui.tools.j.a;
import com.tencent.mm.protocal.protobuf.eeq;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.o;
import java.util.HashMap;

final class k$1
  implements j.a
{
  k$1(k paramk) {}
  
  public final void eo(int paramInt1, int paramInt2) {}
  
  public final int fh(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(36320);
    this.PBh.PAG.start();
    this.PBh.PAK.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(36318);
        if ((k.1.this.PBh.PAK == null) || (k.1.this.PBh.PAK.getVisibility() == 0))
        {
          AppMethodBeat.o(36318);
          return;
        }
        if ((k.1.this.PBh.PAK.getTag() != null) && ((k.1.this.PBh.PAK.getTag() instanceof s)))
        {
          s locals = (s)k.1.this.PBh.PAK.getTag();
          if ((locals.jsw != null) && (!Util.isNullOrNil(locals.jsw.iyZ)))
          {
            k.1.this.PBh.PAK.setVisibility(8);
            AppMethodBeat.o(36318);
            return;
          }
          if ((locals.jsw != null) && (!Util.isNullOrNil(locals.jsw.izc)) && (!Util.isNullOrNil(locals.jsw.izd)))
          {
            k.1.this.PBh.PAK.setVisibility(8);
            AppMethodBeat.o(36318);
            return;
          }
        }
        k.1.this.PBh.PAK.setVisibility(0);
        k.1.this.PBh.PAK.startAnimation(AnimationUtils.loadAnimation(k.1.this.PBh.PAK.getContext(), 2130772059));
        AppMethodBeat.o(36318);
      }
    });
    AppMethodBeat.o(36320);
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(36319);
    this.PBh.PAG.stop();
    final String str = (String)((View)this.PBh.PAG).getTag();
    CrashReportFactory.reportRawMessage(Base64.encodeToString((e.eVv() + "[ImageGallery] on play sight error, what=" + paramInt1 + ", extra=" + paramInt2 + ", path=" + Util.nullAs(str, "")).getBytes(), 2), "FullScreenPlaySight");
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(36317);
        if (Util.isNullOrNil(str))
        {
          h.n(k.1.this.PBh.PwU.Pwv, 2131767073, 2131757488);
          AppMethodBeat.o(36317);
          return;
        }
        Object localObject = new Intent();
        ((Intent)localObject).setAction("android.intent.action.VIEW");
        FileProviderHelper.setIntentDataAndType(k.1.this.PBh.PwU.Pwv, (Intent)localObject, new o(str), "video/*", false);
        try
        {
          ImageGalleryUI localImageGalleryUI = k.1.this.PBh.PwU.Pwv;
          localObject = Intent.createChooser((Intent)localObject, k.1.this.PBh.PwU.Pwv.getContext().getString(2131759356));
          localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(localImageGalleryUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryViewHolder$1$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localImageGalleryUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(localImageGalleryUI, "com/tencent/mm/ui/chatting/gallery/ImageGalleryViewHolder$1$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(36317);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.ImageGalleryViewHolder", "startActivity fail, activity not found");
          h.n(k.1.this.PBh.PwU.Pwv, 2131759255, 2131759256);
          AppMethodBeat.o(36317);
        }
      }
    });
    this.PBh.PAE.put(str, Boolean.TRUE);
    AppMethodBeat.o(36319);
  }
  
  public final void tf() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.k.1
 * JD-Core Version:    0.7.0.1
 */