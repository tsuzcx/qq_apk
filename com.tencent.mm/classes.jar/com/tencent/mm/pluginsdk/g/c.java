package com.tencent.mm.pluginsdk.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.aq.f;
import com.tencent.mm.f.c.et;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;

public final class c
  implements g
{
  String QSF;
  String QSG;
  public String QSJ;
  public String QSK;
  private a QSS;
  d QST;
  private int QSU;
  String QSV;
  public boolean QSW = false;
  String lmq;
  private float progress;
  
  private void apy(int paramInt)
  {
    AppMethodBeat.i(215645);
    this.QST.endTime = Util.nowMilliSecond();
    com.tencent.mm.plugin.report.service.h.IzE.a(20470, true, true, false, new Object[] { Integer.valueOf(this.QST.scene), Long.valueOf(this.QST.totalFileSize), Long.valueOf(this.QST.endTime - this.QST.startTime), Integer.valueOf(paramInt), Long.valueOf(this.QST.QTc) });
    com.tencent.mm.plugin.report.service.h.IzE.el(1431, 2);
    switch (this.QST.scene)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(215645);
      return;
      com.tencent.mm.plugin.report.service.h.IzE.el(1431, 5);
      AppMethodBeat.o(215645);
      return;
      com.tencent.mm.plugin.report.service.h.IzE.el(1431, 8);
      AppMethodBeat.o(215645);
      return;
      com.tencent.mm.plugin.report.service.h.IzE.el(1431, 11);
      if (this.QST.totalFileSize > 26214400L) {
        com.tencent.mm.plugin.report.service.h.IzE.el(1431, 14);
      }
    }
  }
  
  private void dc(int paramInt, String paramString)
  {
    AppMethodBeat.i(215644);
    apy(paramInt);
    if (this.QST.QSZ != null) {
      this.QST.QSZ.O(paramInt, paramString);
    }
    AppMethodBeat.o(215644);
  }
  
  public final void a(a parama, float paramFloat, long paramLong)
  {
    AppMethodBeat.i(215647);
    if (parama.fileType == this.QST.fileType)
    {
      this.progress = paramFloat;
      if (this.QST.QSZ != null) {
        this.QST.QSZ.a(this.progress, paramLong);
      }
    }
    AppMethodBeat.o(215647);
  }
  
  public final void a(a parama, g.a parama1)
  {
    AppMethodBeat.i(215643);
    Log.i("MicroMsg.CGIParallelUploadMgr", "upload file success, type = %s, path = %s", new Object[] { Integer.valueOf(parama.fileType), parama.MFQ });
    d locald = this.QST;
    locald.QTc += parama1.mHi;
    if (this.QST.fileType == parama.fileType)
    {
      parama1.smU = parama.QSL;
      this.QST.endTime = Util.nowMilliSecond();
      com.tencent.mm.plugin.report.service.h.IzE.a(20470, true, true, true, new Object[] { Integer.valueOf(this.QST.scene), Long.valueOf(this.QST.totalFileSize), Long.valueOf(this.QST.endTime - this.QST.startTime), Integer.valueOf(0), Long.valueOf(this.QST.QTc) });
      com.tencent.mm.plugin.report.service.h.IzE.el(1431, 1);
      switch (this.QST.scene)
      {
      }
      for (;;)
      {
        if (this.QST.QSZ != null) {
          this.QST.QSZ.a(parama1);
        }
        AppMethodBeat.o(215643);
        return;
        com.tencent.mm.plugin.report.service.h.IzE.el(1431, 4);
        continue;
        com.tencent.mm.plugin.report.service.h.IzE.el(1431, 7);
        continue;
        com.tencent.mm.plugin.report.service.h.IzE.el(1431, 10);
        if (this.QST.totalFileSize > 26214400L) {
          com.tencent.mm.plugin.report.service.h.IzE.el(1431, 13);
        }
      }
    }
    switch (parama.fileType)
    {
    }
    for (;;)
    {
      apx(this.QST.fileType);
      AppMethodBeat.o(215643);
      return;
      this.QSF = parama1.fileId;
      this.lmq = parama1.aesKey;
      if (this.QST.fileType == 1)
      {
        apx(2);
        AppMethodBeat.o(215643);
        return;
      }
      apx(this.QST.fileType);
      AppMethodBeat.o(215643);
      return;
      this.QSG = parama1.fileId;
      this.QSV = parama1.aesKey;
    }
  }
  
  public final void a(a parama, String paramString, int paramInt)
  {
    AppMethodBeat.i(215646);
    if ((parama.fileType == 2) && (paramInt == -100003) && (this.QSW))
    {
      this.QSW = false;
      apx(2);
      AppMethodBeat.o(215646);
      return;
    }
    dc(paramInt, paramString);
    AppMethodBeat.o(215646);
  }
  
  public final boolean a(final d paramd)
  {
    AppMethodBeat.i(215639);
    com.tencent.e.h.ZvG.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(201061);
        com.tencent.mm.plugin.report.service.h.IzE.el(1431, 0);
        switch (paramd.scene)
        {
        }
        for (;;)
        {
          c.this.QST = paramd;
          c.this.QST.startTime = Util.nowMilliSecond();
          c.this.apx(3);
          AppMethodBeat.o(201061);
          return;
          com.tencent.mm.plugin.report.service.h.IzE.el(1431, 3);
          continue;
          com.tencent.mm.plugin.report.service.h.IzE.el(1431, 6);
          continue;
          com.tencent.mm.plugin.report.service.h.IzE.el(1431, 9);
        }
      }
      
      public final String toString()
      {
        AppMethodBeat.i(201064);
        String str = super.toString() + "|addUploadTask";
        AppMethodBeat.o(201064);
        return str;
      }
    }, "MicroMsg.ParallelUpload.ThreadName");
    AppMethodBeat.o(215639);
    return true;
  }
  
  final void apx(int paramInt)
  {
    AppMethodBeat.i(215642);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(215642);
      return;
      Log.i("MicroMsg.CGIParallelUploadMgr", "start upload middle image");
      if ((Util.isNullOrNil(this.QST.lNI)) || (!u.agG(this.QST.lNI)))
      {
        Log.e("MicroMsg.CGIParallelUploadMgr", "why has not middle image, filePath:%s", new Object[] { this.QST.fullPath });
        dc(-40002, "");
        AppMethodBeat.o(215642);
        return;
      }
      Object localObject2 = new a(this);
      long l = u.bBQ(this.QST.lNI);
      ((a)localObject2).bW(this.QST.lNI, l);
      ((a)localObject2).fileType = 2;
      ((a)localObject2).scene = this.QST.scene;
      ((a)localObject2).QSF = this.QSF;
      ((a)localObject2).lmq = this.lmq;
      this.QSU = 0;
      if (this.QSW)
      {
        localObject3 = this.QST.lNI;
        localObject1 = this.QST.QTb;
        if ((((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.emoji.b.c.class)).cTt()) && (u.bBQ((String)localObject3) > 0L))
        {
          if (u.bBQ((String)localObject1) > 0L)
          {
            com.tencent.mm.plugin.report.service.h.IzE.el(944, 9);
            u.deleteFile((String)localObject1);
          }
          if (!u.agG((String)localObject1)) {
            u.bBV((String)localObject1);
          }
          if (((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.emoji.b.c.class)).gb((String)localObject3, (String)localObject1) == 0)
          {
            paramInt = 1;
            if (paramInt == 0) {
              break label418;
            }
            label307:
            if (Util.isNullOrNil((String)localObject1)) {
              break label424;
            }
            l = u.bBQ(this.QST.lNI);
            ((a)localObject2).bW((String)localObject1, l);
            this.QSU = 1;
          }
        }
      }
      for (;;)
      {
        localObject1 = this.QST;
        ((d)localObject1).totalFileSize = (l + ((d)localObject1).totalFileSize);
        if (this.QST.fileType == 2) {
          ((a)localObject2).QSI = this.QSU;
        }
        this.QSS = ((a)localObject2);
        this.QSS.exE();
        AppMethodBeat.o(215642);
        return;
        Log.w("MicroMsg.CGIParallelUploadMgr", "file to hevc failed %s", new Object[] { localObject3 });
        paramInt = 0;
        break;
        label418:
        localObject1 = null;
        break label307;
        label424:
        this.QSW = false;
      }
      Log.i("MicroMsg.CGIParallelUploadMgr", "start upload big image");
      if ((Util.isNullOrNil(this.QST.fullPath)) || (!u.agG(this.QST.fullPath)))
      {
        Log.e("MicroMsg.CGIParallelUploadMgr", "why has not big image, filePath:%s", new Object[] { this.QST.fullPath });
        dc(-40003, "");
        AppMethodBeat.o(215642);
        return;
      }
      Object localObject1 = new a(this);
      paramInt = (int)u.bBQ(this.QST.fullPath);
      localObject2 = this.QST;
      ((d)localObject2).totalFileSize += paramInt;
      ((a)localObject1).bW(this.QST.fullPath, paramInt);
      ((a)localObject1).fileType = 1;
      ((a)localObject1).scene = this.QST.scene;
      ((a)localObject1).QSF = this.QSF;
      ((a)localObject1).lmq = this.lmq;
      ((a)localObject1).QSG = this.QSG;
      ((a)localObject1).QSH = this.QSV;
      ((a)localObject1).QSI = this.QSU;
      this.QSS = ((a)localObject1);
      this.QSS.exE();
      AppMethodBeat.o(215642);
      return;
      Log.i("MicroMsg.CGIParallelUploadMgr", "start upload video");
      if ((Util.isNullOrNil(this.QST.fullPath)) || (!u.agG(this.QST.fullPath)))
      {
        Log.e("MicroMsg.CGIParallelUploadMgr", "why has not big image, filePath:%s", new Object[] { this.QST.fullPath });
        dc(-40004, "");
        AppMethodBeat.o(215642);
        return;
      }
      localObject1 = new a(this);
      paramInt = (int)u.bBQ(this.QST.fullPath);
      localObject2 = this.QST;
      ((d)localObject2).totalFileSize += paramInt;
      ((a)localObject1).bW(this.QST.fullPath, paramInt);
      ((a)localObject1).fileType = 4;
      ((a)localObject1).scene = this.QST.scene;
      ((a)localObject1).QSF = this.QSF;
      ((a)localObject1).lmq = this.lmq;
      this.QSS = ((a)localObject1);
      ((a)localObject1).exE();
      AppMethodBeat.o(215642);
      return;
      Log.i("MicroMsg.CGIParallelUploadMgr", "start upload thumb image");
      if ((Util.isNullOrNil(this.QST.thumbPath)) || (!u.agG(this.QST.thumbPath)))
      {
        if (this.QST.fileType != 5)
        {
          Log.e("MicroMsg.CGIParallelUploadMgr", "why has not thumb, filePath:%s", new Object[] { this.QST.fullPath });
          dc(-40001, "");
          AppMethodBeat.o(215642);
          return;
        }
        paramInt = this.QST.fileType;
        break;
      }
      localObject1 = new a(this);
      ((a)localObject1).fileType = 3;
      ((a)localObject1).scene = this.QST.scene;
      l = u.bBQ(this.QST.thumbPath);
      ((a)localObject1).bW(this.QST.thumbPath, l);
      localObject2 = this.QST;
      ((d)localObject2).totalFileSize = (l + ((d)localObject2).totalFileSize);
      this.QSS = ((a)localObject1);
      ((a)localObject1).exE();
      AppMethodBeat.o(215642);
      return;
      Log.i("MicroMsg.CGIParallelUploadMgr", "start upload file");
      if ((Util.isNullOrNil(this.QST.fullPath)) || (!u.agG(this.QST.fullPath)))
      {
        Log.e("MicroMsg.CGIParallelUploadMgr", "why has not big image, filePath:%s", new Object[] { this.QST.fullPath });
        dc(-40005, "");
        AppMethodBeat.o(215642);
        return;
      }
      localObject1 = k.b.OQ(Util.processXml(((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(this.QST.lNP).field_content));
      f.bkh();
      this.QSK = com.tencent.mm.aq.a.bjV();
      if ((localObject1 != null) && (!Util.isNullOrNil(((k.b)localObject1).aesKey))) {
        this.QSK = ((k.b)localObject1).aesKey;
      }
      localObject1 = this.QST.fullPath;
      l = (int)u.bBQ((String)localObject1);
      localObject2 = this.QST;
      ((d)localObject2).totalFileSize += l;
      if (l > 26214400L) {
        com.tencent.mm.plugin.report.service.h.IzE.el(1431, 12);
      }
      localObject2 = this.QSK;
      Object localObject3 = new a(this);
      ((a)localObject3).bW((String)localObject1, l);
      ((a)localObject3).fileType = 5;
      ((a)localObject3).scene = this.QST.scene;
      ((a)localObject3).QSJ = this.QSJ;
      ((a)localObject3).QSK = ((String)localObject2);
      this.QSS = ((a)localObject3);
      this.QSS.exE();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.c
 * JD-Core Version:    0.7.0.1
 */