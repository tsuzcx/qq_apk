package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.aq.b;
import com.tencent.mm.aq.c;
import com.tencent.mm.ay.e;
import com.tencent.mm.ay.g;
import com.tencent.mm.ay.q;
import com.tencent.mm.f.a.gm;
import com.tencent.mm.f.a.tx;
import com.tencent.mm.f.a.tx.a;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.modelvideo.ac.a;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.w;
import com.tencent.mm.modelvideo.y;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import java.lang.ref.WeakReference;

public final class al
  extends IListener<tx>
{
  private a WDQ;
  private WeakReference<Activity> nLE;
  
  public al(a parama, Activity paramActivity)
  {
    super(0);
    AppMethodBeat.i(34879);
    this.WDQ = null;
    this.WDQ = parama;
    this.nLE = new WeakReference(paramActivity);
    this.__eventId = tx.class.getName().hashCode();
    AppMethodBeat.o(34879);
  }
  
  private boolean a(tx paramtx)
  {
    AppMethodBeat.i(34880);
    final Activity localActivity = (Activity)this.nLE.get();
    long l;
    String str;
    Object localObject;
    if ((this.WDQ != null) && (paramtx != null) && ((paramtx instanceof tx)) && (localActivity != null))
    {
      l = paramtx.fTi.msgId;
      str = paramtx.fTi.fTj;
      localObject = paramtx.fTi.fTk;
      if ((localObject != null) && (((et)localObject).field_msgId > 0L)) {
        break label609;
      }
    }
    label411:
    label609:
    for (paramtx = paramtx.fTi.fTk;; paramtx = (tx)localObject)
    {
      if (paramtx == null)
      {
        Log.e("MicroMsg.RevokeMsgListener", "in callback msgInfo null");
        AppMethodBeat.o(34880);
        return false;
      }
      switch (paramtx.getType())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(34880);
        return false;
        switch (3.WDS[this.WDQ.ordinal()])
        {
        default: 
          break;
        case 1: 
          if ((paramtx != null) && (paramtx.field_msgId > 0L)) {
            localObject = c.a("downimg", paramtx.field_createTime, paramtx.field_talker, paramtx.field_msgId);
          }
          try
          {
            com.tencent.mm.aq.f.bkg().Vz((String)localObject);
            Log.i("MicroMsg.RevokeMsgListener", "[oneliang][revokeMsgImage] cancel result:%s", new Object[] { Boolean.TRUE });
            bh.aGY().cancel(109);
            paramtx = com.tencent.mm.ui.chatting.gallery.h.k(paramtx);
            q.bmi().C(paramtx.localId, l);
            if ((localActivity == null) || (!(localActivity instanceof ImageGalleryUI))) {
              continue;
            }
            paramtx = (ImageGalleryUI)localActivity;
            Log.i("MicroMsg.RevokeMsgListener", "[oneliang][revokeMsgImage] image gallery ui,msg id is:%s,downloadingImageMsgId: %s", new Object[] { Long.valueOf(l), Long.valueOf(paramtx.msgId) });
            if (l != paramtx.msgId) {
              continue;
            }
            com.tencent.mm.ui.base.h.a(localActivity, str, "", false, new DialogInterface.OnClickListener()
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
          catch (Exception paramtx)
          {
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.RevokeMsgListener", paramtx, "[oneliang][revokeMsgImage] cancel failure:%s", new Object[] { paramtx.getMessage() });
            }
          }
          localObject = this.WDQ;
          boolean bool;
          if (Looper.myLooper() == bh.aHJ().getLooper())
          {
            bool = true;
            Log.v("MicroMsg.RevokeMsgListener", "ashutest::revoke msg, type %s, isWorkerThread %B", new Object[] { localObject, Boolean.valueOf(bool) });
          }
          switch (3.WDS[this.WDQ.ordinal()])
          {
          default: 
            break;
          case 2: 
            ci(paramtx);
            if ((localActivity instanceof ImageGalleryUI))
            {
              localObject = (ImageGalleryUI)localActivity;
              if ((((ImageGalleryUI)localObject).WQM != null) && (com.tencent.mm.ui.chatting.gallery.f.m(paramtx)) && (paramtx.field_msgId == ((ImageGalleryUI)localObject).WQM.hRF().field_msgId)) {}
              for (int i = 1; i != 0; i = 0)
              {
                ((ImageGalleryUI)localObject).awj(((ImageGalleryUI)localObject).getCurrentItem());
                com.tencent.mm.ui.base.h.a(localActivity, str, "", false, new DialogInterface.OnClickListener()
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
                break label411;
              }
            }
            break;
          case 3: 
            ci(paramtx);
            continue;
            paramtx = new gm();
            paramtx.fCK.fCN = 1;
            EventCenter.instance.publish(paramtx);
          }
          break;
        }
      }
    }
  }
  
  private static void ci(ca paramca)
  {
    AppMethodBeat.i(34881);
    Object localObject = y.Yk(paramca.field_imgPath);
    if (localObject != null)
    {
      localObject = c.a("downvideo", ((w)localObject).createTime, ((w)localObject).bqM(), ((w)localObject).getFileName());
      try
      {
        com.tencent.mm.aq.f.bkg().Vz((String)localObject);
        Log.i("MicroMsg.RevokeMsgListener", "ashutest::[oneliang][revokeMsgVideo] cancel result:%s", new Object[] { Boolean.TRUE });
        s.bqG().bre();
        bq.B(paramca);
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
      WDT = new a("CHATTING_ITEM_VIDEO", 0);
      WDU = new a("IMAGE_GALLERY_UI", 1);
      WDV = new a("VIDEO_GALLERY", 2);
      WDW = new a[] { WDT, WDU, WDV };
      AppMethodBeat.o(34878);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.al
 * JD-Core Version:    0.7.0.1
 */