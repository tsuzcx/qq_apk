package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.f;
import com.tencent.mm.aw.e;
import com.tencent.mm.aw.g;
import com.tencent.mm.g.a.rz;
import com.tencent.mm.g.a.rz.a;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bj;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.modelvideo.y.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.gallery.d;
import java.lang.ref.WeakReference;

public final class ak
  extends com.tencent.mm.sdk.b.c<rz>
{
  private a JEd;
  private WeakReference<Activity> jLC;
  
  public ak(a parama, Activity paramActivity)
  {
    super(0);
    AppMethodBeat.i(34879);
    this.JEd = null;
    this.JEd = parama;
    this.jLC = new WeakReference(paramActivity);
    this.__eventId = rz.class.getName().hashCode();
    AppMethodBeat.o(34879);
  }
  
  private boolean a(rz paramrz)
  {
    AppMethodBeat.i(34880);
    final Activity localActivity = (Activity)this.jLC.get();
    long l;
    String str;
    Object localObject;
    if ((this.JEd != null) && (paramrz != null) && ((paramrz instanceof rz)) && (localActivity != null))
    {
      l = paramrz.dGy.msgId;
      str = paramrz.dGy.dGz;
      localObject = paramrz.dGy.dGA;
      if ((localObject != null) && (((ei)localObject).field_msgId > 0L)) {
        break label578;
      }
    }
    label406:
    label578:
    for (paramrz = paramrz.dGy.dGA;; paramrz = (rz)localObject)
    {
      if (paramrz == null)
      {
        ad.e("MicroMsg.RevokeMsgListener", "in callback msgInfo null");
        AppMethodBeat.o(34880);
        return false;
      }
      switch (paramrz.getType())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(34880);
        return false;
        switch (3.JEf[this.JEd.ordinal()])
        {
        default: 
          break;
        case 1: 
          if ((paramrz != null) && (paramrz.field_msgId > 0L)) {
            localObject = com.tencent.mm.ao.c.a("downimg", paramrz.field_createTime, paramrz.field_talker, paramrz.field_msgId);
          }
          try
          {
            f.aGI().EQ((String)localObject);
            ad.i("MicroMsg.RevokeMsgListener", "[oneliang][revokeMsgImage] cancel result:%s", new Object[] { Boolean.TRUE });
            ba.aiU().cancel(109);
            paramrz = d.k(paramrz);
            com.tencent.mm.aw.q.aIG().x(paramrz.dnz, l);
            if ((localActivity == null) || (!(localActivity instanceof ImageGalleryUI))) {
              continue;
            }
            paramrz = (ImageGalleryUI)localActivity;
            ad.i("MicroMsg.RevokeMsgListener", "[oneliang][revokeMsgImage] image gallery ui,msg id is:%s,downloadingImageMsgId: %s", new Object[] { Long.valueOf(l), Long.valueOf(paramrz.msgId) });
            if (l != paramrz.msgId) {
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
          catch (Exception paramrz)
          {
            for (;;)
            {
              ad.printErrStackTrace("MicroMsg.RevokeMsgListener", paramrz, "[oneliang][revokeMsgImage] cancel failure:%s", new Object[] { paramrz.getMessage() });
            }
          }
          localObject = this.JEd;
          boolean bool;
          if (Looper.myLooper() == ba.ajF().IdO.getLooper())
          {
            bool = true;
            ad.v("MicroMsg.RevokeMsgListener", "ashutest::revoke msg, type %s, isWorkerThread %B", new Object[] { localObject, Boolean.valueOf(bool) });
          }
          switch (3.JEf[this.JEd.ordinal()])
          {
          default: 
            break;
          case 2: 
            bA(paramrz);
            if ((localActivity instanceof ImageGalleryUI))
            {
              localObject = (ImageGalleryUI)localActivity;
              if ((((ImageGalleryUI)localObject).JPj != null) && (com.tencent.mm.ui.chatting.gallery.b.m(paramrz)) && (paramrz.field_msgId == ((ImageGalleryUI)localObject).JPj.fFL().field_msgId)) {}
              for (int i = 1; i != 0; i = 0)
              {
                ((ImageGalleryUI)localObject).adO(((ImageGalleryUI)localObject).getCurrentItem());
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
            bA(paramrz);
          }
          break;
        }
      }
    }
  }
  
  private static void bA(bu parambu)
  {
    AppMethodBeat.i(34881);
    Object localObject = u.Hy(parambu.field_imgPath);
    if (localObject != null)
    {
      localObject = com.tencent.mm.ao.c.a("downvideo", ((s)localObject).createTime, ((s)localObject).getUser(), ((s)localObject).getFileName());
      try
      {
        f.aGI().EQ((String)localObject);
        ad.i("MicroMsg.RevokeMsgListener", "ashutest::[oneliang][revokeMsgVideo] cancel result:%s", new Object[] { Boolean.TRUE });
        o.aMO().aNg();
        bj.x(parambu);
        AppMethodBeat.o(34881);
        return;
      }
      catch (Exception parambu)
      {
        ad.printErrStackTrace("MicroMsg.RevokeMsgListener", parambu, "[oneliang][revokeMsgVideo] chatting item video,cancel failure:%s", new Object[] { parambu.getMessage() });
      }
    }
    AppMethodBeat.o(34881);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(34878);
      JEg = new a("CHATTING_ITEM_VIDEO", 0);
      JEh = new a("IMAGE_GALLERY_UI", 1);
      JEi = new a("VIDEO_GALLERY", 2);
      JEj = new a[] { JEg, JEh, JEi };
      AppMethodBeat.o(34878);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ak
 * JD-Core Version:    0.7.0.1
 */