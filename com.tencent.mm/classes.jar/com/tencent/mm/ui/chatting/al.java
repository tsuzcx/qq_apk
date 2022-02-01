package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.f;
import com.tencent.mm.av.e;
import com.tencent.mm.av.g;
import com.tencent.mm.g.a.sa;
import com.tencent.mm.g.a.sa.a;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.modelvideo.y.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.gallery.d;
import java.lang.ref.WeakReference;

public final class al
  extends com.tencent.mm.sdk.b.c<sa>
{
  private a JYU;
  private WeakReference<Activity> jOO;
  
  public al(a parama, Activity paramActivity)
  {
    super(0);
    AppMethodBeat.i(34879);
    this.JYU = null;
    this.JYU = parama;
    this.jOO = new WeakReference(paramActivity);
    this.__eventId = sa.class.getName().hashCode();
    AppMethodBeat.o(34879);
  }
  
  private boolean a(sa paramsa)
  {
    AppMethodBeat.i(34880);
    final Activity localActivity = (Activity)this.jOO.get();
    long l;
    String str;
    Object localObject;
    if ((this.JYU != null) && (paramsa != null) && ((paramsa instanceof sa)) && (localActivity != null))
    {
      l = paramsa.dHE.msgId;
      str = paramsa.dHE.dHF;
      localObject = paramsa.dHE.dHG;
      if ((localObject != null) && (((ei)localObject).field_msgId > 0L)) {
        break label578;
      }
    }
    label406:
    label578:
    for (paramsa = paramsa.dHE.dHG;; paramsa = (sa)localObject)
    {
      if (paramsa == null)
      {
        ae.e("MicroMsg.RevokeMsgListener", "in callback msgInfo null");
        AppMethodBeat.o(34880);
        return false;
      }
      switch (paramsa.getType())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(34880);
        return false;
        switch (3.JYW[this.JYU.ordinal()])
        {
        default: 
          break;
        case 1: 
          if ((paramsa != null) && (paramsa.field_msgId > 0L)) {
            localObject = com.tencent.mm.an.c.a("downimg", paramsa.field_createTime, paramsa.field_talker, paramsa.field_msgId);
          }
          try
          {
            f.aGZ().Fs((String)localObject);
            ae.i("MicroMsg.RevokeMsgListener", "[oneliang][revokeMsgImage] cancel result:%s", new Object[] { Boolean.TRUE });
            bc.ajj().cancel(109);
            paramsa = d.k(paramsa);
            com.tencent.mm.av.q.aIY().x(paramsa.doE, l);
            if ((localActivity == null) || (!(localActivity instanceof ImageGalleryUI))) {
              continue;
            }
            paramsa = (ImageGalleryUI)localActivity;
            ae.i("MicroMsg.RevokeMsgListener", "[oneliang][revokeMsgImage] image gallery ui,msg id is:%s,downloadingImageMsgId: %s", new Object[] { Long.valueOf(l), Long.valueOf(paramsa.msgId) });
            if (l != paramsa.msgId) {
              continue;
            }
            h.a(localActivity, str, "", false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(34873);
                paramAnonymousDialogInterface.dismiss();
                localActivity.finish();
                AppMethodBeat.o(34873);
              }
            });
          }
          catch (Exception paramsa)
          {
            for (;;)
            {
              ae.printErrStackTrace("MicroMsg.RevokeMsgListener", paramsa, "[oneliang][revokeMsgImage] cancel failure:%s", new Object[] { paramsa.getMessage() });
            }
          }
          localObject = this.JYU;
          boolean bool;
          if (Looper.myLooper() == bc.ajU().IxZ.getLooper())
          {
            bool = true;
            ae.v("MicroMsg.RevokeMsgListener", "ashutest::revoke msg, type %s, isWorkerThread %B", new Object[] { localObject, Boolean.valueOf(bool) });
          }
          switch (3.JYW[this.JYU.ordinal()])
          {
          default: 
            break;
          case 2: 
            bz(paramsa);
            if ((localActivity instanceof ImageGalleryUI))
            {
              localObject = (ImageGalleryUI)localActivity;
              if ((((ImageGalleryUI)localObject).Kkv != null) && (com.tencent.mm.ui.chatting.gallery.b.m(paramsa)) && (paramsa.field_msgId == ((ImageGalleryUI)localObject).Kkv.fJS().field_msgId)) {}
              for (int i = 1; i != 0; i = 0)
              {
                ((ImageGalleryUI)localObject).aew(((ImageGalleryUI)localObject).getCurrentItem());
                h.a(localActivity, str, "", false, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                  {
                    AppMethodBeat.i(34874);
                    paramAnonymousDialogInterface.dismiss();
                    localActivity.finish();
                    AppMethodBeat.o(34874);
                  }
                });
                break;
                bool = false;
                break label406;
              }
            }
            break;
          case 3: 
            bz(paramsa);
          }
          break;
        }
      }
    }
  }
  
  private static void bz(bv parambv)
  {
    AppMethodBeat.i(34881);
    Object localObject = u.Ia(parambv.field_imgPath);
    if (localObject != null)
    {
      localObject = com.tencent.mm.an.c.a("downvideo", ((s)localObject).createTime, ((s)localObject).getUser(), ((s)localObject).getFileName());
      try
      {
        f.aGZ().Fs((String)localObject);
        ae.i("MicroMsg.RevokeMsgListener", "ashutest::[oneliang][revokeMsgVideo] cancel result:%s", new Object[] { Boolean.TRUE });
        o.aNm().aNE();
        bl.x(parambv);
        AppMethodBeat.o(34881);
        return;
      }
      catch (Exception parambv)
      {
        ae.printErrStackTrace("MicroMsg.RevokeMsgListener", parambv, "[oneliang][revokeMsgVideo] chatting item video,cancel failure:%s", new Object[] { parambv.getMessage() });
      }
    }
    AppMethodBeat.o(34881);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(34878);
      JYX = new a("CHATTING_ITEM_VIDEO", 0);
      JYY = new a("IMAGE_GALLERY_UI", 1);
      JYZ = new a("VIDEO_GALLERY", 2);
      JZa = new a[] { JYX, JYY, JYZ };
      AppMethodBeat.o(34878);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.al
 * JD-Core Version:    0.7.0.1
 */