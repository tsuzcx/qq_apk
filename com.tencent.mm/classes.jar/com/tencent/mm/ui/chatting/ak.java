package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.ao.f;
import com.tencent.mm.aw.e;
import com.tencent.mm.g.a.re;
import com.tencent.mm.g.a.re.a;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.modelvideo.y.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import java.lang.ref.WeakReference;

public final class ak
  extends com.tencent.mm.sdk.b.c<re>
{
  private a Gqw;
  private WeakReference<Activity> iRx;
  
  public ak(a parama, Activity paramActivity)
  {
    super(0);
    AppMethodBeat.i(34879);
    this.Gqw = null;
    this.Gqw = parama;
    this.iRx = new WeakReference(paramActivity);
    this.__eventId = re.class.getName().hashCode();
    AppMethodBeat.o(34879);
  }
  
  private boolean a(re paramre)
  {
    AppMethodBeat.i(34880);
    final Activity localActivity = (Activity)this.iRx.get();
    long l;
    String str;
    Object localObject;
    if ((this.Gqw != null) && (paramre != null) && ((paramre instanceof re)) && (localActivity != null))
    {
      l = paramre.dwK.msgId;
      str = paramre.dwK.dwL;
      localObject = paramre.dwK.dwM;
      if ((localObject != null) && (((du)localObject).field_msgId > 0L)) {
        break label578;
      }
    }
    label406:
    label578:
    for (paramre = paramre.dwK.dwM;; paramre = (re)localObject)
    {
      if (paramre == null)
      {
        ad.e("MicroMsg.RevokeMsgListener", "in callback msgInfo null");
        AppMethodBeat.o(34880);
        return false;
      }
      switch (paramre.getType())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(34880);
        return false;
        switch (3.Gqy[this.Gqw.ordinal()])
        {
        default: 
          break;
        case 1: 
          if ((paramre != null) && (paramre.field_msgId > 0L)) {
            localObject = com.tencent.mm.ao.c.a("downimg", paramre.field_createTime, paramre.field_talker, paramre.field_msgId);
          }
          try
          {
            f.awL().xL((String)localObject);
            ad.i("MicroMsg.RevokeMsgListener", "[oneliang][revokeMsgImage] cancel result:%s", new Object[] { Boolean.TRUE });
            az.aeS().cancel(109);
            paramre = com.tencent.mm.ui.chatting.gallery.d.k(paramre);
            com.tencent.mm.aw.o.ayG().A(paramre.deI, l);
            if ((localActivity == null) || (!(localActivity instanceof ImageGalleryUI))) {
              continue;
            }
            paramre = (ImageGalleryUI)localActivity;
            ad.i("MicroMsg.RevokeMsgListener", "[oneliang][revokeMsgImage] image gallery ui,msg id is:%s,downloadingImageMsgId: %s", new Object[] { Long.valueOf(l), Long.valueOf(paramre.msgId) });
            if (l != paramre.msgId) {
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
          catch (Exception paramre)
          {
            for (;;)
            {
              ad.printErrStackTrace("MicroMsg.RevokeMsgListener", paramre, "[oneliang][revokeMsgImage] cancel failure:%s", new Object[] { paramre.getMessage() });
            }
          }
          localObject = this.Gqw;
          boolean bool;
          if (Looper.myLooper() == az.afE().EUN.getLooper())
          {
            bool = true;
            ad.v("MicroMsg.RevokeMsgListener", "ashutest::revoke msg, type %s, isWorkerThread %B", new Object[] { localObject, Boolean.valueOf(bool) });
          }
          switch (3.Gqy[this.Gqw.ordinal()])
          {
          default: 
            break;
          case 2: 
            bu(paramre);
            if ((localActivity instanceof ImageGalleryUI))
            {
              localObject = (ImageGalleryUI)localActivity;
              if ((((ImageGalleryUI)localObject).GzZ != null) && (com.tencent.mm.ui.chatting.gallery.b.m(paramre)) && (paramre.field_msgId == ((ImageGalleryUI)localObject).GzZ.eZr().field_msgId)) {}
              for (int i = 1; i != 0; i = 0)
              {
                ((ImageGalleryUI)localObject).Zq(((ImageGalleryUI)localObject).getCurrentItem());
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
            bu(paramre);
          }
          break;
        }
      }
    }
  }
  
  private static void bu(bl parambl)
  {
    AppMethodBeat.i(34881);
    Object localObject = u.Ae(parambl.field_imgPath);
    if (localObject != null)
    {
      localObject = com.tencent.mm.ao.c.a("downvideo", ((s)localObject).createTime, ((s)localObject).getUser(), ((s)localObject).getFileName());
      try
      {
        f.awL().xL((String)localObject);
        ad.i("MicroMsg.RevokeMsgListener", "ashutest::[oneliang][revokeMsgVideo] cancel result:%s", new Object[] { Boolean.TRUE });
        com.tencent.mm.modelvideo.o.aCN().aDf();
        bi.v(parambl);
        AppMethodBeat.o(34881);
        return;
      }
      catch (Exception parambl)
      {
        ad.printErrStackTrace("MicroMsg.RevokeMsgListener", parambl, "[oneliang][revokeMsgVideo] chatting item video,cancel failure:%s", new Object[] { parambl.getMessage() });
      }
    }
    AppMethodBeat.o(34881);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(34878);
      Gqz = new a("CHATTING_ITEM_VIDEO", 0);
      GqA = new a("IMAGE_GALLERY_UI", 1);
      GqB = new a("VIDEO_GALLERY", 2);
      GqC = new a[] { Gqz, GqA, GqB };
      AppMethodBeat.o(34878);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ak
 * JD-Core Version:    0.7.0.1
 */