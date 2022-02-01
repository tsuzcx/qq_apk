package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.an.c;
import com.tencent.mm.an.f;
import com.tencent.mm.av.e;
import com.tencent.mm.av.g;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.sw;
import com.tencent.mm.g.a.sw.a;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.modelvideo.y.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.gallery.d;
import java.lang.ref.WeakReference;

public final class al
  extends IListener<sw>
{
  private a Pkh;
  private WeakReference<Activity> kRw;
  
  public al(a parama, Activity paramActivity)
  {
    super(0);
    AppMethodBeat.i(34879);
    this.Pkh = null;
    this.Pkh = parama;
    this.kRw = new WeakReference(paramActivity);
    this.__eventId = sw.class.getName().hashCode();
    AppMethodBeat.o(34879);
  }
  
  private boolean a(sw paramsw)
  {
    AppMethodBeat.i(34880);
    final Activity localActivity = (Activity)this.kRw.get();
    long l;
    String str;
    Object localObject;
    if ((this.Pkh != null) && (paramsw != null) && ((paramsw instanceof sw)) && (localActivity != null))
    {
      l = paramsw.dZp.msgId;
      str = paramsw.dZp.dZq;
      localObject = paramsw.dZp.dZr;
      if ((localObject != null) && (((eo)localObject).field_msgId > 0L)) {
        break label574;
      }
    }
    label403:
    label574:
    for (paramsw = paramsw.dZp.dZr;; paramsw = (sw)localObject)
    {
      if (paramsw == null)
      {
        Log.e("MicroMsg.RevokeMsgListener", "in callback msgInfo null");
        AppMethodBeat.o(34880);
        return false;
      }
      switch (paramsw.getType())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(34880);
        return false;
        switch (3.Pkj[this.Pkh.ordinal()])
        {
        default: 
          break;
        case 1: 
          if ((paramsw != null) && (paramsw.field_msgId > 0L)) {
            localObject = c.a("downimg", paramsw.field_createTime, paramsw.field_talker, paramsw.field_msgId);
          }
          try
          {
            f.baQ().Oc((String)localObject);
            Log.i("MicroMsg.RevokeMsgListener", "[oneliang][revokeMsgImage] cancel result:%s", new Object[] { Boolean.TRUE });
            bg.azz().cancel(109);
            paramsw = d.k(paramsw);
            q.bcS().C(paramsw.localId, l);
            if ((localActivity == null) || (!(localActivity instanceof ImageGalleryUI))) {
              continue;
            }
            paramsw = (ImageGalleryUI)localActivity;
            Log.i("MicroMsg.RevokeMsgListener", "[oneliang][revokeMsgImage] image gallery ui,msg id is:%s,downloadingImageMsgId: %s", new Object[] { Long.valueOf(l), Long.valueOf(paramsw.msgId) });
            if (l != paramsw.msgId) {
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
          catch (Exception paramsw)
          {
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.RevokeMsgListener", paramsw, "[oneliang][revokeMsgImage] cancel failure:%s", new Object[] { paramsw.getMessage() });
            }
          }
          localObject = this.Pkh;
          boolean bool;
          if (Looper.myLooper() == bg.aAk().getLooper())
          {
            bool = true;
            Log.v("MicroMsg.RevokeMsgListener", "ashutest::revoke msg, type %s, isWorkerThread %B", new Object[] { localObject, Boolean.valueOf(bool) });
          }
          switch (3.Pkj[this.Pkh.ordinal()])
          {
          default: 
            break;
          case 2: 
            bO(paramsw);
            if ((localActivity instanceof ImageGalleryUI))
            {
              localObject = (ImageGalleryUI)localActivity;
              if ((((ImageGalleryUI)localObject).Pwu != null) && (com.tencent.mm.ui.chatting.gallery.b.m(paramsw)) && (paramsw.field_msgId == ((ImageGalleryUI)localObject).Pwu.gSg().field_msgId)) {}
              for (int i = 1; i != 0; i = 0)
              {
                ((ImageGalleryUI)localObject).ang(((ImageGalleryUI)localObject).getCurrentItem());
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
                break label403;
              }
            }
            break;
          case 3: 
            bO(paramsw);
          }
          break;
        }
      }
    }
  }
  
  private static void bO(ca paramca)
  {
    AppMethodBeat.i(34881);
    Object localObject = u.QN(paramca.field_imgPath);
    if (localObject != null)
    {
      localObject = c.a("downvideo", ((s)localObject).createTime, ((s)localObject).getUser(), ((s)localObject).getFileName());
      try
      {
        f.baQ().Oc((String)localObject);
        Log.i("MicroMsg.RevokeMsgListener", "ashutest::[oneliang][revokeMsgVideo] cancel result:%s", new Object[] { Boolean.TRUE });
        o.bho().bhH();
        bp.z(paramca);
        AppMethodBeat.o(34881);
        return;
      }
      catch (Exception paramca)
      {
        Log.printErrStackTrace("MicroMsg.RevokeMsgListener", paramca, "[oneliang][revokeMsgVideo] chatting item video,cancel failure:%s", new Object[] { paramca.getMessage() });
      }
    }
    AppMethodBeat.o(34881);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(34878);
      Pkk = new a("CHATTING_ITEM_VIDEO", 0);
      Pkl = new a("IMAGE_GALLERY_UI", 1);
      Pkm = new a("VIDEO_GALLERY", 2);
      Pkn = new a[] { Pkk, Pkl, Pkm };
      AppMethodBeat.o(34878);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.al
 * JD-Core Version:    0.7.0.1
 */