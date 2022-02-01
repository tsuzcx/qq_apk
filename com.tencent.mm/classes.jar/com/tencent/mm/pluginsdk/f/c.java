package com.tencent.mm.pluginsdk.f;

import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.ao.f;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class c
  implements g
{
  String EKA;
  public boolean EKB = false;
  String EKk;
  String EKl;
  public String EKo;
  public String EKp;
  private a EKx;
  d EKy;
  private int EKz;
  String hAi;
  private float progress;
  
  private void Yj(int paramInt)
  {
    AppMethodBeat.i(195353);
    this.EKy.endTime = bt.flT();
    com.tencent.mm.plugin.report.service.g.yhR.a(20470, true, true, false, new Object[] { Integer.valueOf(this.EKy.scene), Long.valueOf(this.EKy.EKH), Long.valueOf(this.EKy.endTime - this.EKy.startTime), Integer.valueOf(paramInt), Long.valueOf(this.EKy.EKI) });
    com.tencent.mm.plugin.report.service.g.yhR.dD(1431, 2);
    switch (this.EKy.scene)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(195353);
      return;
      com.tencent.mm.plugin.report.service.g.yhR.dD(1431, 5);
      AppMethodBeat.o(195353);
      return;
      com.tencent.mm.plugin.report.service.g.yhR.dD(1431, 8);
      AppMethodBeat.o(195353);
      return;
      com.tencent.mm.plugin.report.service.g.yhR.dD(1431, 11);
      if (this.EKy.EKH > 26214400L) {
        com.tencent.mm.plugin.report.service.g.yhR.dD(1431, 14);
      }
    }
  }
  
  private void cI(int paramInt, String paramString)
  {
    AppMethodBeat.i(195352);
    Yj(paramInt);
    if (this.EKy.EKE != null) {
      this.EKy.EKE.J(paramInt, paramString);
    }
    AppMethodBeat.o(195352);
  }
  
  final void Yi(int paramInt)
  {
    AppMethodBeat.i(195350);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(195350);
      return;
      ad.i("MicroMsg.CGIParallelUploadMgr", "start upload middle image");
      if ((bt.isNullOrNil(this.EKy.hZx)) || (!com.tencent.mm.vfs.i.fv(this.EKy.hZx)))
      {
        ad.e("MicroMsg.CGIParallelUploadMgr", "why has not middle image, filePath:%s", new Object[] { this.EKy.hdP });
        cI(-40002, "");
        AppMethodBeat.o(195350);
        return;
      }
      Object localObject2 = new a(this);
      long l = com.tencent.mm.vfs.i.aYo(this.EKy.hZx);
      ((a)localObject2).bN(this.EKy.hZx, l);
      ((a)localObject2).fileType = 2;
      ((a)localObject2).scene = this.EKy.scene;
      ((a)localObject2).EKk = this.EKk;
      ((a)localObject2).hAi = this.hAi;
      this.EKz = 0;
      if (this.EKB)
      {
        localObject3 = this.EKy.hZx;
        localObject1 = this.EKy.EKG;
        if ((((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).cfM()) && (com.tencent.mm.vfs.i.aYo((String)localObject3) > 0L))
        {
          if (com.tencent.mm.vfs.i.aYo((String)localObject1) > 0L)
          {
            com.tencent.mm.plugin.report.service.g.yhR.dD(944, 9);
            com.tencent.mm.vfs.i.deleteFile((String)localObject1);
          }
          if (!com.tencent.mm.vfs.i.fv((String)localObject1)) {
            com.tencent.mm.vfs.i.aYs((String)localObject1);
          }
          if (((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).fs((String)localObject3, (String)localObject1) == 0)
          {
            paramInt = 1;
            if (paramInt == 0) {
              break label417;
            }
            label307:
            if (bt.isNullOrNil((String)localObject1)) {
              break label423;
            }
            l = com.tencent.mm.vfs.i.aYo(this.EKy.hZx);
            ((a)localObject2).bN((String)localObject1, l);
            this.EKz = 1;
          }
        }
      }
      for (;;)
      {
        localObject1 = this.EKy;
        ((d)localObject1).EKH = (l + ((d)localObject1).EKH);
        if (this.EKy.fileType == 2) {
          ((a)localObject2).EKn = this.EKz;
        }
        this.EKx = ((a)localObject2);
        this.EKx.cYf();
        AppMethodBeat.o(195350);
        return;
        ad.w("MicroMsg.CGIParallelUploadMgr", "file to hevc failed %s", new Object[] { localObject3 });
        paramInt = 0;
        break;
        label417:
        localObject1 = null;
        break label307;
        label423:
        this.EKB = false;
      }
      ad.i("MicroMsg.CGIParallelUploadMgr", "start upload big image");
      if ((bt.isNullOrNil(this.EKy.hdP)) || (!com.tencent.mm.vfs.i.fv(this.EKy.hdP)))
      {
        ad.e("MicroMsg.CGIParallelUploadMgr", "why has not big image, filePath:%s", new Object[] { this.EKy.hdP });
        cI(-40003, "");
        AppMethodBeat.o(195350);
        return;
      }
      Object localObject1 = new a(this);
      paramInt = (int)com.tencent.mm.vfs.i.aYo(this.EKy.hdP);
      localObject2 = this.EKy;
      ((d)localObject2).EKH += paramInt;
      ((a)localObject1).bN(this.EKy.hdP, paramInt);
      ((a)localObject1).fileType = 1;
      ((a)localObject1).scene = this.EKy.scene;
      ((a)localObject1).EKk = this.EKk;
      ((a)localObject1).hAi = this.hAi;
      ((a)localObject1).EKl = this.EKl;
      ((a)localObject1).EKm = this.EKA;
      ((a)localObject1).EKn = this.EKz;
      this.EKx = ((a)localObject1);
      this.EKx.cYf();
      AppMethodBeat.o(195350);
      return;
      ad.i("MicroMsg.CGIParallelUploadMgr", "start upload video");
      if ((bt.isNullOrNil(this.EKy.hdP)) || (!com.tencent.mm.vfs.i.fv(this.EKy.hdP)))
      {
        ad.e("MicroMsg.CGIParallelUploadMgr", "why has not big image, filePath:%s", new Object[] { this.EKy.hdP });
        cI(-40004, "");
        AppMethodBeat.o(195350);
        return;
      }
      localObject1 = new a(this);
      paramInt = (int)com.tencent.mm.vfs.i.aYo(this.EKy.hdP);
      localObject2 = this.EKy;
      ((d)localObject2).EKH += paramInt;
      ((a)localObject1).bN(this.EKy.hdP, paramInt);
      ((a)localObject1).fileType = 4;
      ((a)localObject1).scene = this.EKy.scene;
      ((a)localObject1).EKk = this.EKk;
      ((a)localObject1).hAi = this.hAi;
      this.EKx = ((a)localObject1);
      ((a)localObject1).cYf();
      AppMethodBeat.o(195350);
      return;
      ad.i("MicroMsg.CGIParallelUploadMgr", "start upload thumb image");
      if ((bt.isNullOrNil(this.EKy.thumbPath)) || (!com.tencent.mm.vfs.i.fv(this.EKy.thumbPath)))
      {
        if (this.EKy.fileType != 5)
        {
          ad.e("MicroMsg.CGIParallelUploadMgr", "why has not thumb, filePath:%s", new Object[] { this.EKy.hdP });
          cI(-40001, "");
          AppMethodBeat.o(195350);
          return;
        }
        paramInt = this.EKy.fileType;
        break;
      }
      localObject1 = new a(this);
      ((a)localObject1).fileType = 3;
      ((a)localObject1).scene = this.EKy.scene;
      l = com.tencent.mm.vfs.i.aYo(this.EKy.thumbPath);
      ((a)localObject1).bN(this.EKy.thumbPath, l);
      localObject2 = this.EKy;
      ((d)localObject2).EKH = (l + ((d)localObject2).EKH);
      this.EKx = ((a)localObject1);
      ((a)localObject1).cYf();
      AppMethodBeat.o(195350);
      return;
      ad.i("MicroMsg.CGIParallelUploadMgr", "start upload file");
      if ((bt.isNullOrNil(this.EKy.hdP)) || (!com.tencent.mm.vfs.i.fv(this.EKy.hdP)))
      {
        ad.e("MicroMsg.CGIParallelUploadMgr", "why has not big image, filePath:%s", new Object[] { this.EKy.hdP });
        cI(-40005, "");
        AppMethodBeat.o(195350);
        return;
      }
      localObject1 = k.b.yr(bt.aRd(((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().xY(this.EKy.hZF).field_content));
      f.aGJ();
      this.EKp = com.tencent.mm.ao.a.aGz();
      if ((localObject1 != null) && (!bt.isNullOrNil(((k.b)localObject1).gjI))) {
        this.EKp = ((k.b)localObject1).gjI;
      }
      localObject1 = this.EKy.hdP;
      l = (int)com.tencent.mm.vfs.i.aYo((String)localObject1);
      localObject2 = this.EKy;
      ((d)localObject2).EKH += l;
      if (l > 26214400L) {
        com.tencent.mm.plugin.report.service.g.yhR.dD(1431, 12);
      }
      localObject2 = this.EKp;
      Object localObject3 = new a(this);
      ((a)localObject3).bN((String)localObject1, l);
      ((a)localObject3).fileType = 5;
      ((a)localObject3).scene = this.EKy.scene;
      ((a)localObject3).EKo = this.EKo;
      ((a)localObject3).EKp = ((String)localObject2);
      this.EKx = ((a)localObject3);
      this.EKx.cYf();
    }
  }
  
  public final void a(a parama, float paramFloat, long paramLong)
  {
    AppMethodBeat.i(195355);
    if (parama.fileType == this.EKy.fileType)
    {
      this.progress = paramFloat;
      if (this.EKy.EKE != null) {
        this.EKy.EKE.a(this.progress, paramLong);
      }
    }
    AppMethodBeat.o(195355);
  }
  
  public final void a(a parama, g.a parama1)
  {
    AppMethodBeat.i(195351);
    ad.i("MicroMsg.CGIParallelUploadMgr", "upload file success, type = %s, path = %s", new Object[] { Integer.valueOf(parama.fileType), parama.EKf });
    d locald = this.EKy;
    locald.EKI += parama1.iQl;
    if (this.EKy.fileType == parama.fileType)
    {
      parama1.nUg = parama.EKq;
      this.EKy.endTime = bt.flT();
      com.tencent.mm.plugin.report.service.g.yhR.a(20470, true, true, true, new Object[] { Integer.valueOf(this.EKy.scene), Long.valueOf(this.EKy.EKH), Long.valueOf(this.EKy.endTime - this.EKy.startTime), Integer.valueOf(0), Long.valueOf(this.EKy.EKI) });
      com.tencent.mm.plugin.report.service.g.yhR.dD(1431, 1);
      switch (this.EKy.scene)
      {
      }
      for (;;)
      {
        if (this.EKy.EKE != null) {
          this.EKy.EKE.a(parama1);
        }
        AppMethodBeat.o(195351);
        return;
        com.tencent.mm.plugin.report.service.g.yhR.dD(1431, 4);
        continue;
        com.tencent.mm.plugin.report.service.g.yhR.dD(1431, 7);
        continue;
        com.tencent.mm.plugin.report.service.g.yhR.dD(1431, 10);
        if (this.EKy.EKH > 26214400L) {
          com.tencent.mm.plugin.report.service.g.yhR.dD(1431, 13);
        }
      }
    }
    switch (parama.fileType)
    {
    }
    for (;;)
    {
      Yi(this.EKy.fileType);
      AppMethodBeat.o(195351);
      return;
      this.EKk = parama1.fileId;
      this.hAi = parama1.gjI;
      if (this.EKy.fileType == 1)
      {
        Yi(2);
        AppMethodBeat.o(195351);
        return;
      }
      Yi(this.EKy.fileType);
      AppMethodBeat.o(195351);
      return;
      this.EKl = parama1.fileId;
      this.EKA = parama1.gjI;
    }
  }
  
  public final void a(a parama, String paramString, int paramInt)
  {
    AppMethodBeat.i(195354);
    if ((parama.fileType == 2) && (paramInt == -100003) && (this.EKB))
    {
      this.EKB = false;
      Yi(2);
      AppMethodBeat.o(195354);
      return;
    }
    cI(paramInt, paramString);
    AppMethodBeat.o(195354);
  }
  
  public final boolean a(final d paramd)
  {
    AppMethodBeat.i(195349);
    h.LTJ.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(195347);
        com.tencent.mm.plugin.report.service.g.yhR.dD(1431, 0);
        switch (paramd.scene)
        {
        }
        for (;;)
        {
          c.this.EKy = paramd;
          c.this.EKy.startTime = bt.flT();
          c.this.Yi(3);
          AppMethodBeat.o(195347);
          return;
          com.tencent.mm.plugin.report.service.g.yhR.dD(1431, 3);
          continue;
          com.tencent.mm.plugin.report.service.g.yhR.dD(1431, 6);
          continue;
          com.tencent.mm.plugin.report.service.g.yhR.dD(1431, 9);
        }
      }
      
      public final String toString()
      {
        AppMethodBeat.i(195348);
        String str = super.toString() + "|addUploadTask";
        AppMethodBeat.o(195348);
        return str;
      }
    }, "MicroMsg.ParallelUpload.ThreadName");
    AppMethodBeat.o(195349);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.f.c
 * JD-Core Version:    0.7.0.1
 */