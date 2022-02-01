package com.tencent.mm.pluginsdk.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.an.f;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;

public final class c
  implements g
{
  String JTA;
  public String JTD;
  public String JTE;
  private a JTM;
  d JTN;
  private int JTO;
  String JTP;
  public boolean JTQ = false;
  String JTz;
  String ixb;
  private float progress;
  
  private void ahB(int paramInt)
  {
    AppMethodBeat.i(223737);
    this.JTN.endTime = Util.nowMilliSecond();
    com.tencent.mm.plugin.report.service.h.CyF.a(20470, true, true, false, new Object[] { Integer.valueOf(this.JTN.scene), Long.valueOf(this.JTN.totalFileSize), Long.valueOf(this.JTN.endTime - this.JTN.startTime), Integer.valueOf(paramInt), Long.valueOf(this.JTN.JTW) });
    com.tencent.mm.plugin.report.service.h.CyF.dN(1431, 2);
    switch (this.JTN.scene)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(223737);
      return;
      com.tencent.mm.plugin.report.service.h.CyF.dN(1431, 5);
      AppMethodBeat.o(223737);
      return;
      com.tencent.mm.plugin.report.service.h.CyF.dN(1431, 8);
      AppMethodBeat.o(223737);
      return;
      com.tencent.mm.plugin.report.service.h.CyF.dN(1431, 11);
      if (this.JTN.totalFileSize > 26214400L) {
        com.tencent.mm.plugin.report.service.h.CyF.dN(1431, 14);
      }
    }
  }
  
  private void dc(int paramInt, String paramString)
  {
    AppMethodBeat.i(223736);
    ahB(paramInt);
    if (this.JTN.JTT != null) {
      this.JTN.JTT.M(paramInt, paramString);
    }
    AppMethodBeat.o(223736);
  }
  
  public final void a(a parama, float paramFloat, long paramLong)
  {
    AppMethodBeat.i(223739);
    if (parama.fileType == this.JTN.fileType)
    {
      this.progress = paramFloat;
      if (this.JTN.JTT != null) {
        this.JTN.JTT.a(this.progress, paramLong);
      }
    }
    AppMethodBeat.o(223739);
  }
  
  public final void a(a parama, g.a parama1)
  {
    AppMethodBeat.i(223735);
    Log.i("MicroMsg.CGIParallelUploadMgr", "upload file success, type = %s, path = %s", new Object[] { Integer.valueOf(parama.fileType), parama.GaX });
    d locald = this.JTN;
    locald.JTW += parama1.jPY;
    if (this.JTN.fileType == parama.fileType)
    {
      parama1.pkL = parama.JTF;
      this.JTN.endTime = Util.nowMilliSecond();
      com.tencent.mm.plugin.report.service.h.CyF.a(20470, true, true, true, new Object[] { Integer.valueOf(this.JTN.scene), Long.valueOf(this.JTN.totalFileSize), Long.valueOf(this.JTN.endTime - this.JTN.startTime), Integer.valueOf(0), Long.valueOf(this.JTN.JTW) });
      com.tencent.mm.plugin.report.service.h.CyF.dN(1431, 1);
      switch (this.JTN.scene)
      {
      }
      for (;;)
      {
        if (this.JTN.JTT != null) {
          this.JTN.JTT.a(parama1);
        }
        AppMethodBeat.o(223735);
        return;
        com.tencent.mm.plugin.report.service.h.CyF.dN(1431, 4);
        continue;
        com.tencent.mm.plugin.report.service.h.CyF.dN(1431, 7);
        continue;
        com.tencent.mm.plugin.report.service.h.CyF.dN(1431, 10);
        if (this.JTN.totalFileSize > 26214400L) {
          com.tencent.mm.plugin.report.service.h.CyF.dN(1431, 13);
        }
      }
    }
    switch (parama.fileType)
    {
    }
    for (;;)
    {
      ahA(this.JTN.fileType);
      AppMethodBeat.o(223735);
      return;
      this.JTz = parama1.fileId;
      this.ixb = parama1.aesKey;
      if (this.JTN.fileType == 1)
      {
        ahA(2);
        AppMethodBeat.o(223735);
        return;
      }
      ahA(this.JTN.fileType);
      AppMethodBeat.o(223735);
      return;
      this.JTA = parama1.fileId;
      this.JTP = parama1.aesKey;
    }
  }
  
  public final void a(a parama, String paramString, int paramInt)
  {
    AppMethodBeat.i(223738);
    if ((parama.fileType == 2) && (paramInt == -100003) && (this.JTQ))
    {
      this.JTQ = false;
      ahA(2);
      AppMethodBeat.o(223738);
      return;
    }
    dc(paramInt, paramString);
    AppMethodBeat.o(223738);
  }
  
  public final boolean a(final d paramd)
  {
    AppMethodBeat.i(223733);
    com.tencent.f.h.RTc.b(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(223731);
        com.tencent.mm.plugin.report.service.h.CyF.dN(1431, 0);
        switch (paramd.scene)
        {
        }
        for (;;)
        {
          c.this.JTN = paramd;
          c.this.JTN.startTime = Util.nowMilliSecond();
          c.this.ahA(3);
          AppMethodBeat.o(223731);
          return;
          com.tencent.mm.plugin.report.service.h.CyF.dN(1431, 3);
          continue;
          com.tencent.mm.plugin.report.service.h.CyF.dN(1431, 6);
          continue;
          com.tencent.mm.plugin.report.service.h.CyF.dN(1431, 9);
        }
      }
      
      public final String toString()
      {
        AppMethodBeat.i(223732);
        String str = super.toString() + "|addUploadTask";
        AppMethodBeat.o(223732);
        return str;
      }
    }, "MicroMsg.ParallelUpload.ThreadName");
    AppMethodBeat.o(223733);
    return true;
  }
  
  final void ahA(int paramInt)
  {
    AppMethodBeat.i(223734);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(223734);
      return;
      Log.i("MicroMsg.CGIParallelUploadMgr", "start upload middle image");
      if ((Util.isNullOrNil(this.JTN.iXn)) || (!s.YS(this.JTN.iXn)))
      {
        Log.e("MicroMsg.CGIParallelUploadMgr", "why has not middle image, filePath:%s", new Object[] { this.JTN.fullPath });
        dc(-40002, "");
        AppMethodBeat.o(223734);
        return;
      }
      Object localObject2 = new a(this);
      long l = s.boW(this.JTN.iXn);
      ((a)localObject2).bP(this.JTN.iXn, l);
      ((a)localObject2).fileType = 2;
      ((a)localObject2).scene = this.JTN.scene;
      ((a)localObject2).JTz = this.JTz;
      ((a)localObject2).ixb = this.ixb;
      this.JTO = 0;
      if (this.JTQ)
      {
        localObject3 = this.JTN.iXn;
        localObject1 = this.JTN.JTV;
        if ((((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.emoji.b.c.class)).cEO()) && (s.boW((String)localObject3) > 0L))
        {
          if (s.boW((String)localObject1) > 0L)
          {
            com.tencent.mm.plugin.report.service.h.CyF.dN(944, 9);
            s.deleteFile((String)localObject1);
          }
          if (!s.YS((String)localObject1)) {
            s.bpa((String)localObject1);
          }
          if (((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.emoji.b.c.class)).fO((String)localObject3, (String)localObject1) == 0)
          {
            paramInt = 1;
            if (paramInt == 0) {
              break label418;
            }
            label307:
            if (Util.isNullOrNil((String)localObject1)) {
              break label424;
            }
            l = s.boW(this.JTN.iXn);
            ((a)localObject2).bP((String)localObject1, l);
            this.JTO = 1;
          }
        }
      }
      for (;;)
      {
        localObject1 = this.JTN;
        ((d)localObject1).totalFileSize = (l + ((d)localObject1).totalFileSize);
        if (this.JTN.fileType == 2) {
          ((a)localObject2).JTC = this.JTO;
        }
        this.JTM = ((a)localObject2);
        this.JTM.dUx();
        AppMethodBeat.o(223734);
        return;
        Log.w("MicroMsg.CGIParallelUploadMgr", "file to hevc failed %s", new Object[] { localObject3 });
        paramInt = 0;
        break;
        label418:
        localObject1 = null;
        break label307;
        label424:
        this.JTQ = false;
      }
      Log.i("MicroMsg.CGIParallelUploadMgr", "start upload big image");
      if ((Util.isNullOrNil(this.JTN.fullPath)) || (!s.YS(this.JTN.fullPath)))
      {
        Log.e("MicroMsg.CGIParallelUploadMgr", "why has not big image, filePath:%s", new Object[] { this.JTN.fullPath });
        dc(-40003, "");
        AppMethodBeat.o(223734);
        return;
      }
      Object localObject1 = new a(this);
      paramInt = (int)s.boW(this.JTN.fullPath);
      localObject2 = this.JTN;
      ((d)localObject2).totalFileSize += paramInt;
      ((a)localObject1).bP(this.JTN.fullPath, paramInt);
      ((a)localObject1).fileType = 1;
      ((a)localObject1).scene = this.JTN.scene;
      ((a)localObject1).JTz = this.JTz;
      ((a)localObject1).ixb = this.ixb;
      ((a)localObject1).JTA = this.JTA;
      ((a)localObject1).JTB = this.JTP;
      ((a)localObject1).JTC = this.JTO;
      this.JTM = ((a)localObject1);
      this.JTM.dUx();
      AppMethodBeat.o(223734);
      return;
      Log.i("MicroMsg.CGIParallelUploadMgr", "start upload video");
      if ((Util.isNullOrNil(this.JTN.fullPath)) || (!s.YS(this.JTN.fullPath)))
      {
        Log.e("MicroMsg.CGIParallelUploadMgr", "why has not big image, filePath:%s", new Object[] { this.JTN.fullPath });
        dc(-40004, "");
        AppMethodBeat.o(223734);
        return;
      }
      localObject1 = new a(this);
      paramInt = (int)s.boW(this.JTN.fullPath);
      localObject2 = this.JTN;
      ((d)localObject2).totalFileSize += paramInt;
      ((a)localObject1).bP(this.JTN.fullPath, paramInt);
      ((a)localObject1).fileType = 4;
      ((a)localObject1).scene = this.JTN.scene;
      ((a)localObject1).JTz = this.JTz;
      ((a)localObject1).ixb = this.ixb;
      this.JTM = ((a)localObject1);
      ((a)localObject1).dUx();
      AppMethodBeat.o(223734);
      return;
      Log.i("MicroMsg.CGIParallelUploadMgr", "start upload thumb image");
      if ((Util.isNullOrNil(this.JTN.thumbPath)) || (!s.YS(this.JTN.thumbPath)))
      {
        if (this.JTN.fileType != 5)
        {
          Log.e("MicroMsg.CGIParallelUploadMgr", "why has not thumb, filePath:%s", new Object[] { this.JTN.fullPath });
          dc(-40001, "");
          AppMethodBeat.o(223734);
          return;
        }
        paramInt = this.JTN.fileType;
        break;
      }
      localObject1 = new a(this);
      ((a)localObject1).fileType = 3;
      ((a)localObject1).scene = this.JTN.scene;
      l = s.boW(this.JTN.thumbPath);
      ((a)localObject1).bP(this.JTN.thumbPath, l);
      localObject2 = this.JTN;
      ((d)localObject2).totalFileSize = (l + ((d)localObject2).totalFileSize);
      this.JTM = ((a)localObject1);
      ((a)localObject1).dUx();
      AppMethodBeat.o(223734);
      return;
      Log.i("MicroMsg.CGIParallelUploadMgr", "start upload file");
      if ((Util.isNullOrNil(this.JTN.fullPath)) || (!s.YS(this.JTN.fullPath)))
      {
        Log.e("MicroMsg.CGIParallelUploadMgr", "why has not big image, filePath:%s", new Object[] { this.JTN.fullPath });
        dc(-40005, "");
        AppMethodBeat.o(223734);
        return;
      }
      localObject1 = k.b.HD(Util.processXml(((l)com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(this.JTN.iXv).field_content));
      f.baR();
      this.JTE = com.tencent.mm.an.a.baG();
      if ((localObject1 != null) && (!Util.isNullOrNil(((k.b)localObject1).aesKey))) {
        this.JTE = ((k.b)localObject1).aesKey;
      }
      localObject1 = this.JTN.fullPath;
      l = (int)s.boW((String)localObject1);
      localObject2 = this.JTN;
      ((d)localObject2).totalFileSize += l;
      if (l > 26214400L) {
        com.tencent.mm.plugin.report.service.h.CyF.dN(1431, 12);
      }
      localObject2 = this.JTE;
      Object localObject3 = new a(this);
      ((a)localObject3).bP((String)localObject1, l);
      ((a)localObject3).fileType = 5;
      ((a)localObject3).scene = this.JTN.scene;
      ((a)localObject3).JTD = this.JTD;
      ((a)localObject3).JTE = ((String)localObject2);
      this.JTM = ((a)localObject3);
      this.JTM.dUx();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.f.c
 * JD-Core Version:    0.7.0.1
 */