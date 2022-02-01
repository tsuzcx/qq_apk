package com.tencent.mm.pluginsdk.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.k.b;
import com.tencent.mm.modelcdntran.k;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;

public final class c
  implements g
{
  public String XOD;
  String XOE;
  public String XOH;
  public String XOI;
  public boolean XOK = false;
  private MMHandler XOR;
  private a XOS;
  d XOT;
  private int XOU;
  String XOV;
  public boolean XOW = false;
  public boolean XOX = false;
  public String nRv;
  private float progress;
  
  private void avC(int paramInt)
  {
    AppMethodBeat.i(244958);
    this.XOT.endTime = Util.nowMilliSecond();
    com.tencent.mm.plugin.report.service.h.OAn.a(20470, true, true, false, new Object[] { Integer.valueOf(this.XOT.scene), Long.valueOf(this.XOT.totalFileSize), Long.valueOf(this.XOT.endTime - this.XOT.startTime), Integer.valueOf(paramInt), Long.valueOf(this.XOT.XPd) });
    com.tencent.mm.plugin.report.service.h.OAn.kJ(1431, 2);
    switch (this.XOT.scene)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(244958);
      return;
      com.tencent.mm.plugin.report.service.h.OAn.kJ(1431, 5);
      AppMethodBeat.o(244958);
      return;
      com.tencent.mm.plugin.report.service.h.OAn.kJ(1431, 8);
      AppMethodBeat.o(244958);
      return;
      com.tencent.mm.plugin.report.service.h.OAn.kJ(1431, 11);
      if (this.XOT.totalFileSize > 26214400L) {
        com.tencent.mm.plugin.report.service.h.OAn.kJ(1431, 14);
      }
    }
  }
  
  private void dU(int paramInt, String paramString)
  {
    AppMethodBeat.i(244953);
    avC(paramInt);
    if (this.XOT.XPa != null) {
      this.XOT.XPa.T(paramInt, paramString);
    }
    AppMethodBeat.o(244953);
  }
  
  public final void a(a parama, float paramFloat, long paramLong)
  {
    AppMethodBeat.i(244988);
    if (parama.fileType == this.XOT.fileType)
    {
      this.progress = paramFloat;
      if (this.XOT.XPa != null) {
        this.XOT.XPa.b(this.progress, paramLong);
      }
    }
    AppMethodBeat.o(244988);
  }
  
  public final void a(a parama, g.a parama1)
  {
    AppMethodBeat.i(244983);
    Log.i("MicroMsg.CGIParallelUploadMgr", "upload file success, type = %s, path = %s", new Object[] { Integer.valueOf(parama.fileType), parama.Tql });
    d locald = this.XOT;
    locald.XPd += parama1.fileLength;
    if (this.XOT.fileType == parama.fileType)
    {
      parama1.vyS = parama.XOJ;
      this.XOT.endTime = Util.nowMilliSecond();
      com.tencent.mm.plugin.report.service.h.OAn.a(20470, true, true, true, new Object[] { Integer.valueOf(this.XOT.scene), Long.valueOf(this.XOT.totalFileSize), Long.valueOf(this.XOT.endTime - this.XOT.startTime), Integer.valueOf(0), Long.valueOf(this.XOT.XPd) });
      com.tencent.mm.plugin.report.service.h.OAn.kJ(1431, 1);
      switch (this.XOT.scene)
      {
      }
      for (;;)
      {
        if (this.XOT.XPa != null) {
          this.XOT.XPa.a(parama1);
        }
        AppMethodBeat.o(244983);
        return;
        com.tencent.mm.plugin.report.service.h.OAn.kJ(1431, 4);
        continue;
        com.tencent.mm.plugin.report.service.h.OAn.kJ(1431, 7);
        continue;
        com.tencent.mm.plugin.report.service.h.OAn.kJ(1431, 10);
        if (this.XOT.totalFileSize > 26214400L) {
          com.tencent.mm.plugin.report.service.h.OAn.kJ(1431, 13);
        }
      }
    }
    switch (parama.fileType)
    {
    }
    for (;;)
    {
      avB(this.XOT.fileType);
      AppMethodBeat.o(244983);
      return;
      this.XOD = parama1.fileId;
      this.nRv = parama1.aesKey;
      if (this.XOT.fileType == 1)
      {
        avB(2);
        AppMethodBeat.o(244983);
        return;
      }
      avB(this.XOT.fileType);
      AppMethodBeat.o(244983);
      return;
      this.XOE = parama1.fileId;
      this.XOV = parama1.aesKey;
    }
  }
  
  public final void a(a parama, String paramString, int paramInt)
  {
    AppMethodBeat.i(244986);
    if ((parama.fileType == 2) && (paramInt == -100003) && (this.XOW))
    {
      this.XOW = false;
      avB(2);
      AppMethodBeat.o(244986);
      return;
    }
    dU(paramInt, paramString);
    AppMethodBeat.o(244986);
  }
  
  public final boolean a(final d paramd)
  {
    AppMethodBeat.i(244963);
    com.tencent.threadpool.h.ahAA.g(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(244962);
        com.tencent.mm.plugin.report.service.h.OAn.kJ(1431, 0);
        switch (paramd.scene)
        {
        }
        for (;;)
        {
          c.this.XOT = paramd;
          c.this.XOT.startTime = Util.nowMilliSecond();
          c.this.avB(3);
          AppMethodBeat.o(244962);
          return;
          com.tencent.mm.plugin.report.service.h.OAn.kJ(1431, 3);
          continue;
          com.tencent.mm.plugin.report.service.h.OAn.kJ(1431, 6);
          continue;
          com.tencent.mm.plugin.report.service.h.OAn.kJ(1431, 9);
        }
      }
      
      public final String toString()
      {
        AppMethodBeat.i(244966);
        String str = super.toString() + "|addUploadTask";
        AppMethodBeat.o(244966);
        return str;
      }
    }, "MicroMsg.ParallelUpload.ThreadName");
    AppMethodBeat.o(244963);
    return true;
  }
  
  final void avB(int paramInt)
  {
    AppMethodBeat.i(244979);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(244979);
      return;
      Log.i("MicroMsg.CGIParallelUploadMgr", "start upload middle image");
      if ((Util.isNullOrNil(this.XOT.oGs)) || (!y.ZC(this.XOT.oGs)))
      {
        Log.e("MicroMsg.CGIParallelUploadMgr", "why has not middle image, filePath:%s", new Object[] { this.XOT.fullPath });
        dU(-40002, "");
        AppMethodBeat.o(244979);
        return;
      }
      Object localObject2 = new a(this);
      long l = y.bEl(this.XOT.oGs);
      ((a)localObject2).ch(this.XOT.oGs, l);
      ((a)localObject2).fileType = 2;
      ((a)localObject2).scene = this.XOT.scene;
      ((a)localObject2).XOD = this.XOD;
      ((a)localObject2).nRv = this.nRv;
      this.XOU = 0;
      if (this.XOW)
      {
        localObject3 = this.XOT.oGs;
        localObject1 = this.XOT.XPc;
        if ((((com.tencent.mm.plugin.emoji.c.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.emoji.c.c.class)).dxO()) && (y.bEl((String)localObject3) > 0L))
        {
          if (y.bEl((String)localObject1) > 0L)
          {
            com.tencent.mm.plugin.report.service.h.OAn.kJ(944, 9);
            y.deleteFile((String)localObject1);
          }
          if (!y.ZC((String)localObject1)) {
            y.bEp((String)localObject1);
          }
          if (((com.tencent.mm.plugin.emoji.c.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.emoji.c.c.class)).gG((String)localObject3, (String)localObject1) == 0)
          {
            paramInt = 1;
            if (paramInt == 0) {
              break label418;
            }
            label307:
            if (Util.isNullOrNil((String)localObject1)) {
              break label424;
            }
            l = y.bEl(this.XOT.oGs);
            ((a)localObject2).ch((String)localObject1, l);
            this.XOU = 1;
          }
        }
      }
      for (;;)
      {
        localObject1 = this.XOT;
        ((d)localObject1).totalFileSize = (l + ((d)localObject1).totalFileSize);
        if (this.XOT.fileType == 2) {
          ((a)localObject2).XOG = this.XOU;
        }
        this.XOS = ((a)localObject2);
        this.XOS.fFA();
        AppMethodBeat.o(244979);
        return;
        Log.w("MicroMsg.CGIParallelUploadMgr", "file to hevc failed %s", new Object[] { localObject3 });
        paramInt = 0;
        break;
        label418:
        localObject1 = null;
        break label307;
        label424:
        this.XOW = false;
      }
      Log.i("MicroMsg.CGIParallelUploadMgr", "start upload big image");
      if ((Util.isNullOrNil(this.XOT.fullPath)) || (!y.ZC(this.XOT.fullPath)))
      {
        Log.e("MicroMsg.CGIParallelUploadMgr", "why has not big image, filePath:%s", new Object[] { this.XOT.fullPath });
        dU(-40003, "");
        AppMethodBeat.o(244979);
        return;
      }
      Object localObject1 = new a(this);
      paramInt = (int)y.bEl(this.XOT.fullPath);
      localObject2 = this.XOT;
      ((d)localObject2).totalFileSize += paramInt;
      ((a)localObject1).ch(this.XOT.fullPath, paramInt);
      ((a)localObject1).fileType = 1;
      ((a)localObject1).scene = this.XOT.scene;
      ((a)localObject1).XOD = this.XOD;
      ((a)localObject1).nRv = this.nRv;
      ((a)localObject1).XOE = this.XOE;
      ((a)localObject1).XOF = this.XOV;
      ((a)localObject1).XOG = this.XOU;
      this.XOS = ((a)localObject1);
      this.XOS.fFA();
      AppMethodBeat.o(244979);
      return;
      Log.i("MicroMsg.CGIParallelUploadMgr", "start upload video");
      if ((Util.isNullOrNil(this.XOT.fullPath)) || (!y.ZC(this.XOT.fullPath)))
      {
        Log.e("MicroMsg.CGIParallelUploadMgr", "why has not big image, filePath:%s", new Object[] { this.XOT.fullPath });
        dU(-40004, "");
        AppMethodBeat.o(244979);
        return;
      }
      localObject1 = new a(this);
      paramInt = (int)y.bEl(this.XOT.fullPath);
      localObject2 = this.XOT;
      ((d)localObject2).totalFileSize += paramInt;
      ((a)localObject1).ch(this.XOT.fullPath, paramInt);
      ((a)localObject1).fileType = 4;
      ((a)localObject1).scene = this.XOT.scene;
      ((a)localObject1).XOD = this.XOD;
      ((a)localObject1).nRv = this.nRv;
      ((a)localObject1).XOK = this.XOK;
      this.XOS = ((a)localObject1);
      ((a)localObject1).fFA();
      AppMethodBeat.o(244979);
      return;
      Log.i("MicroMsg.CGIParallelUploadMgr", "start upload thumb image");
      if ((Util.isNullOrNil(this.XOT.thumbPath)) || (!y.ZC(this.XOT.thumbPath)))
      {
        if ((this.XOT.fileType != 5) && (!this.XOK) && (!this.XOX))
        {
          Log.e("MicroMsg.CGIParallelUploadMgr", "why has not thumb, filePath:%s", new Object[] { this.XOT.fullPath });
          dU(-40001, "");
          AppMethodBeat.o(244979);
          return;
        }
        paramInt = this.XOT.fileType;
        break;
      }
      localObject1 = new a(this);
      ((a)localObject1).fileType = 3;
      ((a)localObject1).scene = this.XOT.scene;
      l = y.bEl(this.XOT.thumbPath);
      ((a)localObject1).ch(this.XOT.thumbPath, l);
      localObject2 = this.XOT;
      ((d)localObject2).totalFileSize = (l + ((d)localObject2).totalFileSize);
      this.XOS = ((a)localObject1);
      ((a)localObject1).fFA();
      AppMethodBeat.o(244979);
      return;
      Log.i("MicroMsg.CGIParallelUploadMgr", "start upload file");
      if ((Util.isNullOrNil(this.XOT.fullPath)) || (!y.ZC(this.XOT.fullPath)))
      {
        Log.e("MicroMsg.CGIParallelUploadMgr", "why has not big image, filePath:%s", new Object[] { this.XOT.fullPath });
        dU(-40005, "");
        AppMethodBeat.o(244979);
        return;
      }
      localObject1 = k.b.Hf(Util.processXml(((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(this.XOT.oGz).field_content));
      k.bHX();
      this.XOI = com.tencent.mm.modelcdntran.d.bHI();
      if ((localObject1 != null) && (!Util.isNullOrNil(((k.b)localObject1).aesKey))) {
        this.XOI = ((k.b)localObject1).aesKey;
      }
      localObject1 = this.XOT.fullPath;
      l = (int)y.bEl((String)localObject1);
      localObject2 = this.XOT;
      ((d)localObject2).totalFileSize += l;
      if (l > 26214400L) {
        com.tencent.mm.plugin.report.service.h.OAn.kJ(1431, 12);
      }
      localObject2 = this.XOI;
      Object localObject3 = new a(this);
      ((a)localObject3).ch((String)localObject1, l);
      ((a)localObject3).fileType = 5;
      ((a)localObject3).scene = this.XOT.scene;
      ((a)localObject3).XOH = this.XOH;
      ((a)localObject3).XOI = ((String)localObject2);
      this.XOS = ((a)localObject3);
      this.XOS.fFA();
    }
  }
  
  public final void iGP()
  {
    AppMethodBeat.i(244967);
    Log.i("MicroMsg.CGIParallelUploadMgr", "quitVideoSendThread");
    if (this.XOR != null) {}
    try
    {
      this.XOR.quit();
      this.XOR = null;
      if (this.XOS != null) {
        this.XOS.iGP();
      }
      AppMethodBeat.o(244967);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.CGIParallelUploadMgr", "quitVideoSendThread error: %s", new Object[] { localException.getMessage() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.c
 * JD-Core Version:    0.7.0.1
 */