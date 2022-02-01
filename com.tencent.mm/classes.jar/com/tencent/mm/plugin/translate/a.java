package com.tencent.mm.plugin.translate;

import android.os.Looper;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.h;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.abe;
import com.tencent.mm.model.be;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.translate.b.e;
import com.tencent.mm.plugin.translate.b.e.a;
import com.tencent.mm.plugin.translate.b.e.b;
import com.tencent.mm.plugin.translate.b.e.c;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

public final class a
  implements be
{
  private IListener TSA;
  private IListener TSB;
  private e TSx;
  private QueueWorkerThread TSy;
  private e.a TSz;
  private MMHandler handler;
  
  public a()
  {
    AppMethodBeat.i(29736);
    this.TSx = e.b.TSY;
    this.TSy = new QueueWorkerThread(5, "ProcessTranslatedMessage", 1, Looper.getMainLooper());
    this.TSz = new e.a()
    {
      public final void a(final int paramAnonymousInt, SparseArray<e.c> paramAnonymousSparseArray)
      {
        AppMethodBeat.i(29732);
        int i = 0;
        while (i < paramAnonymousSparseArray.size())
        {
          final e.c localc = (e.c)paramAnonymousSparseArray.valueAt(i);
          if (localc != null) {
            a.a(a.this).add(new QueueWorkerThread.ThreadObject()
            {
              public final boolean doInBackground()
              {
                AppMethodBeat.i(29731);
                Log.d("MicroMsg.SubCoreTranslate", "finish translated, id: %s", new Object[] { localc.id });
                if (paramAnonymousInt != 0)
                {
                  Log.e("MicroMsg.SubCoreTranslate", "translate error");
                  AppMethodBeat.o(29731);
                  return true;
                }
                if (localc.ret != 0)
                {
                  Log.e("MicroMsg.SubCoreTranslate", "translate ret not ok : %s", new Object[] { Integer.valueOf(localc.ret) });
                  AppMethodBeat.o(29731);
                  return true;
                }
                if (Util.isNullOrNil(localc.ieQ))
                {
                  Log.e("MicroMsg.SubCoreTranslate", "translate return null");
                  AppMethodBeat.o(29731);
                  return true;
                }
                if ((localc.type == 0) || (localc.type == 1))
                {
                  Log.d("MicroMsg.SubCoreTranslate", "we recieved one translated message");
                  a.a(localc);
                }
                AppMethodBeat.o(29731);
                return true;
              }
              
              public final boolean onPostExecute()
              {
                AppMethodBeat.i(29730);
                if (paramAnonymousInt != 0) {}
                for (int i = paramAnonymousInt;; i = localc.ret)
                {
                  abe localabe = new abe();
                  localabe.ieP.ret = i;
                  localabe.ieP.ieH = localc.ieH;
                  localabe.ieP.id = localc.id;
                  localabe.ieP.ieQ = localc.ieQ;
                  localabe.ieP.type = localc.type;
                  localabe.ieP.source = localc.source;
                  localabe.ieP.icx = localc.icx;
                  localabe.ieP.ieJ = localc.kLr;
                  localabe.ieP.ieR = localc.ieR;
                  localabe.publish();
                  AppMethodBeat.o(29730);
                  return false;
                }
              }
            });
          }
          i += 1;
        }
        AppMethodBeat.o(29732);
      }
    };
    this.handler = new MMHandler(Looper.getMainLooper());
    this.TSA = new SubCoreTranslate.2(this, com.tencent.mm.app.f.hfK);
    this.TSB = new SubCoreTranslate.3(this, com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(29736);
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(29737);
    e locale = this.TSx;
    e.a locala = this.TSz;
    if ((locala == null) || (locale.listeners.contains(locala))) {}
    for (;;)
    {
      this.TSA.alive();
      this.TSB.alive();
      AppMethodBeat.o(29737);
      return;
      locale.listeners.add(locala);
    }
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(29738);
    this.TSA.dead();
    this.TSB.dead();
    e locale = this.TSx;
    Object localObject = this.TSz;
    if ((localObject == null) || (!locale.listeners.contains(localObject))) {}
    for (;;)
    {
      locale = this.TSx;
      if (locale.TSV == null) {
        break;
      }
      localObject = locale.TSV;
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        h localh = localObject[i];
        if (localh != null)
        {
          bh.aZW().b(631, localh);
          if (localh.TTe != null)
          {
            localh.TTg.stopTimer();
            bh.aZW().a(localh.TTe);
          }
          localh.hPy();
          localh.TTc = null;
        }
        i += 1;
      }
      locale.listeners.remove(localObject);
    }
    locale.TSX.clear();
    locale.TSW.clear();
    locale.listeners.clear();
    locale.wrD = 0;
    AppMethodBeat.o(29738);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.translate.a
 * JD-Core Version:    0.7.0.1
 */