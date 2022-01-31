package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.al.b;
import com.tencent.mm.al.f;
import com.tencent.mm.at.d;
import com.tencent.mm.g.a.pm;
import com.tencent.mm.g.a.pm.a;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.modelvideo.y.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import java.lang.ref.WeakReference;

public final class ak
  extends com.tencent.mm.sdk.b.c<pm>
{
  private WeakReference<Activity> gYJ;
  private ak.a zCe;
  
  public ak(ak.a parama, Activity paramActivity)
  {
    super(0);
    AppMethodBeat.i(30994);
    this.zCe = null;
    this.zCe = parama;
    this.gYJ = new WeakReference(paramActivity);
    this.__eventId = pm.class.getName().hashCode();
    AppMethodBeat.o(30994);
  }
  
  private boolean a(pm parampm)
  {
    AppMethodBeat.i(30995);
    Activity localActivity = (Activity)this.gYJ.get();
    long l;
    String str;
    Object localObject;
    if ((this.zCe != null) && (parampm != null) && ((parampm instanceof pm)) && (localActivity != null))
    {
      l = parampm.cFZ.cpO;
      str = parampm.cFZ.cGa;
      localObject = parampm.cFZ.cGb;
      if ((localObject != null) && (((dd)localObject).field_msgId > 0L)) {
        break label582;
      }
    }
    label410:
    label582:
    for (parampm = parampm.cFZ.cGb;; parampm = (pm)localObject)
    {
      if (parampm == null)
      {
        ab.e("MicroMsg.RevokeMsgListener", "in callback msgInfo null");
        AppMethodBeat.o(30995);
        return false;
      }
      switch (parampm.getType())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(30995);
        return false;
        switch (ak.3.zCg[this.zCe.ordinal()])
        {
        default: 
          break;
        case 1: 
          if ((parampm != null) && (parampm.field_msgId > 0L)) {
            localObject = com.tencent.mm.al.c.a("downimg", parampm.field_createTime, parampm.field_talker, parampm.field_msgId);
          }
          try
          {
            f.afO().sJ((String)localObject);
            ab.i("MicroMsg.RevokeMsgListener", "[oneliang][revokeMsgImage] cancel result:%s", new Object[] { Boolean.TRUE });
            aw.Rc().cancel(109);
            parampm = com.tencent.mm.ui.chatting.gallery.e.d(parampm);
            com.tencent.mm.at.o.ahD().z(parampm.fDL, l);
            if ((localActivity == null) || (!(localActivity instanceof ImageGalleryUI))) {
              continue;
            }
            parampm = (ImageGalleryUI)localActivity;
            ab.i("MicroMsg.RevokeMsgListener", "[oneliang][revokeMsgImage] image gallery ui,msg id is:%s,downloadingImageMsgId: %s", new Object[] { Long.valueOf(l), Long.valueOf(parampm.cpO) });
            if (l != parampm.cpO) {
              continue;
            }
            h.a(localActivity, str, "", false, new ak.1(this, localActivity));
          }
          catch (Exception parampm)
          {
            for (;;)
            {
              ab.printErrStackTrace("MicroMsg.RevokeMsgListener", parampm, "[oneliang][revokeMsgImage] cancel failure:%s", new Object[] { parampm.getMessage() });
            }
          }
          localObject = this.zCe;
          boolean bool;
          if (Looper.myLooper() == aw.RO().oNc.getLooper())
          {
            bool = true;
            ab.v("MicroMsg.RevokeMsgListener", "ashutest::revoke msg, type %s, isWorkerThread %B", new Object[] { localObject, Boolean.valueOf(bool) });
          }
          switch (ak.3.zCg[this.zCe.ordinal()])
          {
          default: 
            break;
          case 2: 
            aZ(parampm);
            if ((localActivity instanceof ImageGalleryUI))
            {
              localObject = (ImageGalleryUI)localActivity;
              if ((((ImageGalleryUI)localObject).zJI != null) && (com.tencent.mm.ui.chatting.gallery.c.f(parampm)) && (parampm.field_msgId == ((ImageGalleryUI)localObject).zJI.dJX().field_msgId)) {}
              for (int i = 1; i != 0; i = 0)
              {
                ((ImageGalleryUI)localObject).Qi(((ImageGalleryUI)localObject).getCurrentItem());
                h.a(localActivity, str, "", false, new ak.2(this, localActivity));
                break;
                bool = false;
                break label410;
              }
            }
            break;
          case 3: 
            aZ(parampm);
          }
          break;
        }
      }
    }
  }
  
  private static void aZ(bi parambi)
  {
    AppMethodBeat.i(30996);
    Object localObject = u.vr(parambi.field_imgPath);
    if (localObject != null)
    {
      localObject = com.tencent.mm.al.c.a("downvideo", ((s)localObject).createTime, ((s)localObject).getUser(), ((s)localObject).getFileName());
      try
      {
        f.afO().sJ((String)localObject);
        ab.i("MicroMsg.RevokeMsgListener", "ashutest::[oneliang][revokeMsgVideo] cancel result:%s", new Object[] { Boolean.TRUE });
        com.tencent.mm.modelvideo.o.alJ().ama();
        bf.m(parambi);
        AppMethodBeat.o(30996);
        return;
      }
      catch (Exception parambi)
      {
        ab.printErrStackTrace("MicroMsg.RevokeMsgListener", parambi, "[oneliang][revokeMsgVideo] chatting item video,cancel failure:%s", new Object[] { parambi.getMessage() });
      }
    }
    AppMethodBeat.o(30996);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ak
 * JD-Core Version:    0.7.0.1
 */