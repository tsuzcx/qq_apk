package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.gx;
import com.tencent.mm.autogen.a.vm;
import com.tencent.mm.autogen.a.vm.a;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.modelvideo.ab;
import com.tencent.mm.modelvideo.ag.a;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.modelvideo.z;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.gallery.j;
import java.lang.ref.WeakReference;

public class RevokeMsgListener
  extends IListener<vm>
{
  private a aelq;
  private WeakReference<Activity> qLs;
  
  public RevokeMsgListener(a parama, Activity paramActivity)
  {
    super(com.tencent.mm.app.f.hfK);
    AppMethodBeat.i(34879);
    this.aelq = null;
    this.aelq = parama;
    this.qLs = new WeakReference(paramActivity);
    this.__eventId = vm.class.getName().hashCode();
    AppMethodBeat.o(34879);
  }
  
  private boolean a(vm paramvm)
  {
    AppMethodBeat.i(34880);
    final Activity localActivity = (Activity)this.qLs.get();
    long l;
    String str;
    Object localObject;
    if ((this.aelq != null) && (paramvm != null) && ((paramvm instanceof vm)) && (localActivity != null))
    {
      l = paramvm.hZg.msgId;
      str = paramvm.hZg.hZh;
      localObject = paramvm.hZg.hZi;
      if ((localObject != null) && (((fi)localObject).field_msgId > 0L)) {
        break label606;
      }
    }
    label410:
    label606:
    for (paramvm = paramvm.hZg.hZi;; paramvm = (vm)localObject)
    {
      if (paramvm == null)
      {
        Log.e("MicroMsg.RevokeMsgListener", "in callback msgInfo null");
        AppMethodBeat.o(34880);
        return false;
      }
      switch (paramvm.getType())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(34880);
        return false;
        switch (3.aels[this.aelq.ordinal()])
        {
        default: 
          break;
        case 1: 
          if ((paramvm != null) && (paramvm.field_msgId > 0L)) {
            localObject = com.tencent.mm.modelcdntran.h.a("downimg", paramvm.getCreateTime(), paramvm.field_talker, paramvm.field_msgId);
          }
          try
          {
            Log.i("MicroMsg.RevokeMsgListener", "[oneliang][revokeMsgImage] cancel result:%s", new Object[] { Boolean.valueOf(com.tencent.mm.modelcdntran.k.bHW().Nz((String)localObject)) });
            bh.aZW().cancel(109);
            paramvm = j.k(paramvm);
            r.bKb().Y(paramvm.localId, l);
            if ((localActivity == null) || (!(localActivity instanceof ImageGalleryUI))) {
              continue;
            }
            paramvm = (ImageGalleryUI)localActivity;
            Log.i("MicroMsg.RevokeMsgListener", "[oneliang][revokeMsgImage] image gallery ui,msg id is:%s,downloadingImageMsgId: %s", new Object[] { Long.valueOf(l), Long.valueOf(paramvm.msgId) });
            if (l != paramvm.msgId) {
              continue;
            }
            com.tencent.mm.ui.base.k.a(localActivity, str, "", false, new DialogInterface.OnClickListener()
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
          catch (Exception paramvm)
          {
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.RevokeMsgListener", paramvm, "[oneliang][revokeMsgImage] cancel failure:%s", new Object[] { paramvm.getMessage() });
            }
          }
          localObject = this.aelq;
          boolean bool;
          if (Looper.myLooper() == bh.baH().getLooper())
          {
            bool = true;
            Log.v("MicroMsg.RevokeMsgListener", "ashutest::revoke msg, type %s, isWorkerThread %B", new Object[] { localObject, Boolean.valueOf(bool) });
          }
          switch (3.aels[this.aelq.ordinal()])
          {
          default: 
            break;
          case 2: 
            cw(paramvm);
            if ((localActivity instanceof ImageGalleryUI))
            {
              localObject = (ImageGalleryUI)localActivity;
              if ((((ImageGalleryUI)localObject).aeAg != null) && (com.tencent.mm.ui.chatting.gallery.h.m(paramvm)) && (paramvm.field_msgId == ((ImageGalleryUI)localObject).aeAg.jvd().field_msgId)) {}
              for (int i = 1; i != 0; i = 0)
              {
                ((ImageGalleryUI)localObject).aCS(((ImageGalleryUI)localObject).getCurrentItem());
                com.tencent.mm.ui.base.k.a(localActivity, str, "", false, new DialogInterface.OnClickListener()
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
                break label410;
              }
            }
            break;
          case 3: 
            cw(paramvm);
            continue;
            paramvm = new gx();
            paramvm.hHz.hHC = 1;
            paramvm.publish();
          }
          break;
        }
      }
    }
  }
  
  private static void cw(cc paramcc)
  {
    AppMethodBeat.i(34881);
    Object localObject = ab.Qo(paramcc.field_imgPath);
    if (localObject != null)
    {
      localObject = com.tencent.mm.modelcdntran.h.a("downvideo", ((z)localObject).createTime, ((z)localObject).bOs(), ((z)localObject).getFileName());
      try
      {
        Log.i("MicroMsg.RevokeMsgListener", "ashutest::[oneliang][revokeMsgVideo] cancel result:%s", new Object[] { Boolean.valueOf(com.tencent.mm.modelcdntran.k.bHW().Nz((String)localObject)) });
        v.bOm().bOK();
        br.D(paramcc);
        AppMethodBeat.o(34881);
        return;
      }
      catch (Exception paramcc)
      {
        Log.printErrStackTrace("MicroMsg.RevokeMsgListener", paramcc, "[oneliang][revokeMsgVideo] chatting item video,cancel failure:%s", new Object[] { paramcc.getMessage() });
      }
    }
    AppMethodBeat.o(34881);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(34878);
      aelt = new a("CHATTING_ITEM_VIDEO", 0);
      aelu = new a("IMAGE_GALLERY_UI", 1);
      aelv = new a("VIDEO_GALLERY", 2);
      aelw = new a[] { aelt, aelu, aelv };
      AppMethodBeat.o(34878);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.RevokeMsgListener
 * JD-Core Version:    0.7.0.1
 */