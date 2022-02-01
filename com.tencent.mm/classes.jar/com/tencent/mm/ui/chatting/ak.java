package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.an.f;
import com.tencent.mm.av.e;
import com.tencent.mm.g.a.rn;
import com.tencent.mm.g.a.rn.a;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.modelvideo.y.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import java.lang.ref.WeakReference;

public final class ak
  extends com.tencent.mm.sdk.b.c<rn>
{
  private a HQo;
  private WeakReference<Activity> jrI;
  
  public ak(a parama, Activity paramActivity)
  {
    super(0);
    AppMethodBeat.i(34879);
    this.HQo = null;
    this.HQo = parama;
    this.jrI = new WeakReference(paramActivity);
    this.__eventId = rn.class.getName().hashCode();
    AppMethodBeat.o(34879);
  }
  
  private boolean a(rn paramrn)
  {
    AppMethodBeat.i(34880);
    final Activity localActivity = (Activity)this.jrI.get();
    long l;
    String str;
    Object localObject;
    if ((this.HQo != null) && (paramrn != null) && ((paramrn instanceof rn)) && (localActivity != null))
    {
      l = paramrn.dux.msgId;
      str = paramrn.dux.duy;
      localObject = paramrn.dux.duz;
      if ((localObject != null) && (((dy)localObject).field_msgId > 0L)) {
        break label578;
      }
    }
    label406:
    label578:
    for (paramrn = paramrn.dux.duz;; paramrn = (rn)localObject)
    {
      if (paramrn == null)
      {
        ac.e("MicroMsg.RevokeMsgListener", "in callback msgInfo null");
        AppMethodBeat.o(34880);
        return false;
      }
      switch (paramrn.getType())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(34880);
        return false;
        switch (3.HQq[this.HQo.ordinal()])
        {
        default: 
          break;
        case 1: 
          if ((paramrn != null) && (paramrn.field_msgId > 0L)) {
            localObject = com.tencent.mm.an.c.a("downimg", paramrn.field_createTime, paramrn.field_talker, paramrn.field_msgId);
          }
          try
          {
            f.aDD().BR((String)localObject);
            ac.i("MicroMsg.RevokeMsgListener", "[oneliang][revokeMsgImage] cancel result:%s", new Object[] { Boolean.TRUE });
            az.agi().cancel(109);
            paramrn = com.tencent.mm.ui.chatting.gallery.d.k(paramrn);
            com.tencent.mm.av.o.aFy().x(paramrn.dcd, l);
            if ((localActivity == null) || (!(localActivity instanceof ImageGalleryUI))) {
              continue;
            }
            paramrn = (ImageGalleryUI)localActivity;
            ac.i("MicroMsg.RevokeMsgListener", "[oneliang][revokeMsgImage] image gallery ui,msg id is:%s,downloadingImageMsgId: %s", new Object[] { Long.valueOf(l), Long.valueOf(paramrn.msgId) });
            if (l != paramrn.msgId) {
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
          catch (Exception paramrn)
          {
            for (;;)
            {
              ac.printErrStackTrace("MicroMsg.RevokeMsgListener", paramrn, "[oneliang][revokeMsgImage] cancel failure:%s", new Object[] { paramrn.getMessage() });
            }
          }
          localObject = this.HQo;
          boolean bool;
          if (Looper.myLooper() == az.agU().GrZ.getLooper())
          {
            bool = true;
            ac.v("MicroMsg.RevokeMsgListener", "ashutest::revoke msg, type %s, isWorkerThread %B", new Object[] { localObject, Boolean.valueOf(bool) });
          }
          switch (3.HQq[this.HQo.ordinal()])
          {
          default: 
            break;
          case 2: 
            bw(paramrn);
            if ((localActivity instanceof ImageGalleryUI))
            {
              localObject = (ImageGalleryUI)localActivity;
              if ((((ImageGalleryUI)localObject).HZU != null) && (com.tencent.mm.ui.chatting.gallery.b.m(paramrn)) && (paramrn.field_msgId == ((ImageGalleryUI)localObject).HZU.fpg().field_msgId)) {}
              for (int i = 1; i != 0; i = 0)
              {
                ((ImageGalleryUI)localObject).abC(((ImageGalleryUI)localObject).getCurrentItem());
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
            bw(paramrn);
          }
          break;
        }
      }
    }
  }
  
  private static void bw(bo parambo)
  {
    AppMethodBeat.i(34881);
    Object localObject = u.Ej(parambo.field_imgPath);
    if (localObject != null)
    {
      localObject = com.tencent.mm.an.c.a("downvideo", ((s)localObject).createTime, ((s)localObject).getUser(), ((s)localObject).getFileName());
      try
      {
        f.aDD().BR((String)localObject);
        ac.i("MicroMsg.RevokeMsgListener", "ashutest::[oneliang][revokeMsgVideo] cancel result:%s", new Object[] { Boolean.TRUE });
        com.tencent.mm.modelvideo.o.aJD().aJW();
        bi.v(parambo);
        AppMethodBeat.o(34881);
        return;
      }
      catch (Exception parambo)
      {
        ac.printErrStackTrace("MicroMsg.RevokeMsgListener", parambo, "[oneliang][revokeMsgVideo] chatting item video,cancel failure:%s", new Object[] { parambo.getMessage() });
      }
    }
    AppMethodBeat.o(34881);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(34878);
      HQr = new a("CHATTING_ITEM_VIDEO", 0);
      HQs = new a("IMAGE_GALLERY_UI", 1);
      HQt = new a("VIDEO_GALLERY", 2);
      HQu = new a[] { HQr, HQs, HQt };
      AppMethodBeat.o(34878);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ak
 * JD-Core Version:    0.7.0.1
 */