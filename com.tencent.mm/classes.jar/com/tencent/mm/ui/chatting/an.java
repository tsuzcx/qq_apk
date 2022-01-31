package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mm.ah.p;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.as.d;
import com.tencent.mm.h.a.ok;
import com.tencent.mm.h.a.ok.a;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.modelvideo.y.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;

public final class an
  extends com.tencent.mm.sdk.b.c<ok>
{
  Activity activity = null;
  private an.a vmI = null;
  
  public an(an.a parama, Activity paramActivity)
  {
    super(0);
    this.vmI = parama;
    this.activity = paramActivity;
    this.udX = ok.class.getName().hashCode();
  }
  
  private boolean a(ok paramok)
  {
    int i = 1;
    long l;
    String str;
    Object localObject;
    if ((this.vmI != null) && (paramok != null) && ((paramok instanceof ok)))
    {
      l = paramok.bXY.bIt;
      str = paramok.bXY.bXZ;
      localObject = paramok.bXY.bYa;
      if ((localObject != null) && (((cs)localObject).field_msgId > 0L)) {
        break label553;
      }
    }
    label553:
    for (paramok = paramok.bXY.bYa;; paramok = (ok)localObject)
    {
      if (paramok == null) {
        y.e("MicroMsg.RevokeMsgListener", "in callback msgInfo null");
      }
      boolean bool;
      label383:
      do
      {
        for (;;)
        {
          return false;
          switch (paramok.getType())
          {
          default: 
            return false;
          case 3: 
            switch (an.3.vmK[this.vmI.ordinal()])
            {
            default: 
              return false;
            }
            if ((paramok != null) && (paramok.field_msgId > 0L)) {
              localObject = com.tencent.mm.ak.c.a("downimg", paramok.field_createTime, paramok.field_talker, paramok.field_msgId);
            }
            try
            {
              f.Nd().lM((String)localObject);
              y.i("MicroMsg.RevokeMsgListener", "[oneliang][revokeMsgImage] cancel result:%s", new Object[] { Boolean.valueOf(true) });
              au.Dk().cancel(109);
              paramok = com.tencent.mm.ui.chatting.gallery.e.bt(paramok);
              com.tencent.mm.as.o.OK().q(paramok.enp, l);
              if ((this.activity != null) && ((this.activity instanceof ImageGalleryUI)))
              {
                paramok = (ImageGalleryUI)this.activity;
                y.i("MicroMsg.RevokeMsgListener", "[oneliang][revokeMsgImage] image gallery ui,msg id is:%s,downloadingImageMsgId: %s", new Object[] { Long.valueOf(l), Long.valueOf(paramok.bIt) });
                if (l == paramok.bIt)
                {
                  h.a(this.activity, str, "", false, new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                    {
                      paramAnonymousDialogInterface.dismiss();
                      an.this.activity.finish();
                    }
                  });
                  return false;
                }
              }
            }
            catch (Exception paramok)
            {
              for (;;)
              {
                y.printErrStackTrace("MicroMsg.RevokeMsgListener", paramok, "[oneliang][revokeMsgImage] cancel failure:%s", new Object[] { paramok.getMessage() });
              }
            }
          }
        }
        localObject = this.vmI;
        if (Looper.myLooper() != au.DS().mnU.getLooper()) {
          break;
        }
        bool = true;
        y.v("MicroMsg.RevokeMsgListener", "ashutest::revoke msg, type %s, isWorkerThread %B", new Object[] { localObject, Boolean.valueOf(bool) });
        switch (an.3.vmK[this.vmI.ordinal()])
        {
        default: 
          return false;
        case 2: 
          aP(paramok);
        }
      } while (!(this.activity instanceof ImageGalleryUI));
      localObject = (ImageGalleryUI)this.activity;
      if ((((ImageGalleryUI)localObject).vtH != null) && (com.tencent.mm.ui.chatting.gallery.c.bf(paramok)) && (paramok.field_msgId == ((ImageGalleryUI)localObject).vtH.cFU().field_msgId)) {}
      while (i != 0)
      {
        ((ImageGalleryUI)localObject).HB(((ImageGalleryUI)localObject).getCurrentItem());
        h.a(this.activity, str, "", false, new an.2(this));
        return false;
        bool = false;
        break label383;
        i = 0;
      }
      aP(paramok);
      return false;
    }
  }
  
  private static void aP(bi parambi)
  {
    Object localObject = u.oe(parambi.field_imgPath);
    if (localObject != null) {
      localObject = com.tencent.mm.ak.c.a("downvideo", ((s)localObject).createTime, ((s)localObject).SA(), ((s)localObject).getFileName());
    }
    try
    {
      f.Nd().lM((String)localObject);
      y.i("MicroMsg.RevokeMsgListener", "ashutest::[oneliang][revokeMsgVideo] cancel result:%s", new Object[] { Boolean.valueOf(true) });
      localObject = com.tencent.mm.modelvideo.o.Sw();
      g.Dk().c(((y.a)localObject).eIr);
      ((y.a)localObject).uB();
      bd.i(parambi);
      return;
    }
    catch (Exception parambi)
    {
      y.printErrStackTrace("MicroMsg.RevokeMsgListener", parambi, "[oneliang][revokeMsgVideo] chatting item video,cancel failure:%s", new Object[] { parambi.getMessage() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.an
 * JD-Core Version:    0.7.0.1
 */