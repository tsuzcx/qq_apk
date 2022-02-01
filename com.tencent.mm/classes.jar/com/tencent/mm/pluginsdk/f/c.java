package com.tencent.mm.pluginsdk.f;

import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.an.f;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;

public final class c
  implements g
{
  String FcI;
  String FcJ;
  public String FcM;
  public String FcN;
  private a FcV;
  d FcW;
  private int FcX;
  String FcY;
  public boolean FcZ = false;
  String hCW;
  private float progress;
  
  private void YP(int paramInt)
  {
    AppMethodBeat.i(218806);
    this.FcW.endTime = bu.fpO();
    com.tencent.mm.plugin.report.service.g.yxI.a(20470, true, true, false, new Object[] { Integer.valueOf(this.FcW.scene), Long.valueOf(this.FcW.Fdf), Long.valueOf(this.FcW.endTime - this.FcW.startTime), Integer.valueOf(paramInt), Long.valueOf(this.FcW.Fdg) });
    com.tencent.mm.plugin.report.service.g.yxI.dD(1431, 2);
    switch (this.FcW.scene)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(218806);
      return;
      com.tencent.mm.plugin.report.service.g.yxI.dD(1431, 5);
      AppMethodBeat.o(218806);
      return;
      com.tencent.mm.plugin.report.service.g.yxI.dD(1431, 8);
      AppMethodBeat.o(218806);
      return;
      com.tencent.mm.plugin.report.service.g.yxI.dD(1431, 11);
      if (this.FcW.Fdf > 26214400L) {
        com.tencent.mm.plugin.report.service.g.yxI.dD(1431, 14);
      }
    }
  }
  
  private void cI(int paramInt, String paramString)
  {
    AppMethodBeat.i(218805);
    YP(paramInt);
    if (this.FcW.Fdc != null) {
      this.FcW.Fdc.J(paramInt, paramString);
    }
    AppMethodBeat.o(218805);
  }
  
  final void YO(int paramInt)
  {
    AppMethodBeat.i(218803);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(218803);
      return;
      ae.i("MicroMsg.CGIParallelUploadMgr", "start upload middle image");
      if ((bu.isNullOrNil(this.FcW.icp)) || (!o.fB(this.FcW.icp)))
      {
        ae.e("MicroMsg.CGIParallelUploadMgr", "why has not middle image, filePath:%s", new Object[] { this.FcW.hgD });
        cI(-40002, "");
        AppMethodBeat.o(218803);
        return;
      }
      Object localObject2 = new a(this);
      long l = o.aZR(this.FcW.icp);
      ((a)localObject2).bO(this.FcW.icp, l);
      ((a)localObject2).fileType = 2;
      ((a)localObject2).scene = this.FcW.scene;
      ((a)localObject2).FcI = this.FcI;
      ((a)localObject2).hCW = this.hCW;
      this.FcX = 0;
      if (this.FcZ)
      {
        localObject3 = this.FcW.icp;
        localObject1 = this.FcW.Fde;
        if ((((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).chc()) && (o.aZR((String)localObject3) > 0L))
        {
          if (o.aZR((String)localObject1) > 0L)
          {
            com.tencent.mm.plugin.report.service.g.yxI.dD(944, 9);
            o.deleteFile((String)localObject1);
          }
          if (!o.fB((String)localObject1)) {
            o.aZV((String)localObject1);
          }
          if (((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).fw((String)localObject3, (String)localObject1) == 0)
          {
            paramInt = 1;
            if (paramInt == 0) {
              break label417;
            }
            label307:
            if (bu.isNullOrNil((String)localObject1)) {
              break label423;
            }
            l = o.aZR(this.FcW.icp);
            ((a)localObject2).bO((String)localObject1, l);
            this.FcX = 1;
          }
        }
      }
      for (;;)
      {
        localObject1 = this.FcW;
        ((d)localObject1).Fdf = (l + ((d)localObject1).Fdf);
        if (this.FcW.fileType == 2) {
          ((a)localObject2).FcL = this.FcX;
        }
        this.FcV = ((a)localObject2);
        this.FcV.daP();
        AppMethodBeat.o(218803);
        return;
        ae.w("MicroMsg.CGIParallelUploadMgr", "file to hevc failed %s", new Object[] { localObject3 });
        paramInt = 0;
        break;
        label417:
        localObject1 = null;
        break label307;
        label423:
        this.FcZ = false;
      }
      ae.i("MicroMsg.CGIParallelUploadMgr", "start upload big image");
      if ((bu.isNullOrNil(this.FcW.hgD)) || (!o.fB(this.FcW.hgD)))
      {
        ae.e("MicroMsg.CGIParallelUploadMgr", "why has not big image, filePath:%s", new Object[] { this.FcW.hgD });
        cI(-40003, "");
        AppMethodBeat.o(218803);
        return;
      }
      Object localObject1 = new a(this);
      paramInt = (int)o.aZR(this.FcW.hgD);
      localObject2 = this.FcW;
      ((d)localObject2).Fdf += paramInt;
      ((a)localObject1).bO(this.FcW.hgD, paramInt);
      ((a)localObject1).fileType = 1;
      ((a)localObject1).scene = this.FcW.scene;
      ((a)localObject1).FcI = this.FcI;
      ((a)localObject1).hCW = this.hCW;
      ((a)localObject1).FcJ = this.FcJ;
      ((a)localObject1).FcK = this.FcY;
      ((a)localObject1).FcL = this.FcX;
      this.FcV = ((a)localObject1);
      this.FcV.daP();
      AppMethodBeat.o(218803);
      return;
      ae.i("MicroMsg.CGIParallelUploadMgr", "start upload video");
      if ((bu.isNullOrNil(this.FcW.hgD)) || (!o.fB(this.FcW.hgD)))
      {
        ae.e("MicroMsg.CGIParallelUploadMgr", "why has not big image, filePath:%s", new Object[] { this.FcW.hgD });
        cI(-40004, "");
        AppMethodBeat.o(218803);
        return;
      }
      localObject1 = new a(this);
      paramInt = (int)o.aZR(this.FcW.hgD);
      localObject2 = this.FcW;
      ((d)localObject2).Fdf += paramInt;
      ((a)localObject1).bO(this.FcW.hgD, paramInt);
      ((a)localObject1).fileType = 4;
      ((a)localObject1).scene = this.FcW.scene;
      ((a)localObject1).FcI = this.FcI;
      ((a)localObject1).hCW = this.hCW;
      this.FcV = ((a)localObject1);
      ((a)localObject1).daP();
      AppMethodBeat.o(218803);
      return;
      ae.i("MicroMsg.CGIParallelUploadMgr", "start upload thumb image");
      if ((bu.isNullOrNil(this.FcW.thumbPath)) || (!o.fB(this.FcW.thumbPath)))
      {
        if (this.FcW.fileType != 5)
        {
          ae.e("MicroMsg.CGIParallelUploadMgr", "why has not thumb, filePath:%s", new Object[] { this.FcW.hgD });
          cI(-40001, "");
          AppMethodBeat.o(218803);
          return;
        }
        paramInt = this.FcW.fileType;
        break;
      }
      localObject1 = new a(this);
      ((a)localObject1).fileType = 3;
      ((a)localObject1).scene = this.FcW.scene;
      l = o.aZR(this.FcW.thumbPath);
      ((a)localObject1).bO(this.FcW.thumbPath, l);
      localObject2 = this.FcW;
      ((d)localObject2).Fdf = (l + ((d)localObject2).Fdf);
      this.FcV = ((a)localObject1);
      ((a)localObject1).daP();
      AppMethodBeat.o(218803);
      return;
      ae.i("MicroMsg.CGIParallelUploadMgr", "start upload file");
      if ((bu.isNullOrNil(this.FcW.hgD)) || (!o.fB(this.FcW.hgD)))
      {
        ae.e("MicroMsg.CGIParallelUploadMgr", "why has not big image, filePath:%s", new Object[] { this.FcW.hgD });
        cI(-40005, "");
        AppMethodBeat.o(218803);
        return;
      }
      localObject1 = k.b.zb(bu.aSA(((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().ys(this.FcW.icx).field_content));
      f.aHa();
      this.FcN = com.tencent.mm.an.a.aGP();
      if ((localObject1 != null) && (!bu.isNullOrNil(((k.b)localObject1).gmb))) {
        this.FcN = ((k.b)localObject1).gmb;
      }
      localObject1 = this.FcW.hgD;
      l = (int)o.aZR((String)localObject1);
      localObject2 = this.FcW;
      ((d)localObject2).Fdf += l;
      if (l > 26214400L) {
        com.tencent.mm.plugin.report.service.g.yxI.dD(1431, 12);
      }
      localObject2 = this.FcN;
      Object localObject3 = new a(this);
      ((a)localObject3).bO((String)localObject1, l);
      ((a)localObject3).fileType = 5;
      ((a)localObject3).scene = this.FcW.scene;
      ((a)localObject3).FcM = this.FcM;
      ((a)localObject3).FcN = ((String)localObject2);
      this.FcV = ((a)localObject3);
      this.FcV.daP();
    }
  }
  
  public final void a(a parama, float paramFloat, long paramLong)
  {
    AppMethodBeat.i(218808);
    if (parama.fileType == this.FcW.fileType)
    {
      this.progress = paramFloat;
      if (this.FcW.Fdc != null) {
        this.FcW.Fdc.a(this.progress, paramLong);
      }
    }
    AppMethodBeat.o(218808);
  }
  
  public final void a(a parama, g.a parama1)
  {
    AppMethodBeat.i(218804);
    ae.i("MicroMsg.CGIParallelUploadMgr", "upload file success, type = %s, path = %s", new Object[] { Integer.valueOf(parama.fileType), parama.FcD });
    d locald = this.FcW;
    locald.Fdg += parama1.iTe;
    if (this.FcW.fileType == parama.fileType)
    {
      parama1.nZM = parama.FcO;
      this.FcW.endTime = bu.fpO();
      com.tencent.mm.plugin.report.service.g.yxI.a(20470, true, true, true, new Object[] { Integer.valueOf(this.FcW.scene), Long.valueOf(this.FcW.Fdf), Long.valueOf(this.FcW.endTime - this.FcW.startTime), Integer.valueOf(0), Long.valueOf(this.FcW.Fdg) });
      com.tencent.mm.plugin.report.service.g.yxI.dD(1431, 1);
      switch (this.FcW.scene)
      {
      }
      for (;;)
      {
        if (this.FcW.Fdc != null) {
          this.FcW.Fdc.a(parama1);
        }
        AppMethodBeat.o(218804);
        return;
        com.tencent.mm.plugin.report.service.g.yxI.dD(1431, 4);
        continue;
        com.tencent.mm.plugin.report.service.g.yxI.dD(1431, 7);
        continue;
        com.tencent.mm.plugin.report.service.g.yxI.dD(1431, 10);
        if (this.FcW.Fdf > 26214400L) {
          com.tencent.mm.plugin.report.service.g.yxI.dD(1431, 13);
        }
      }
    }
    switch (parama.fileType)
    {
    }
    for (;;)
    {
      YO(this.FcW.fileType);
      AppMethodBeat.o(218804);
      return;
      this.FcI = parama1.fileId;
      this.hCW = parama1.gmb;
      if (this.FcW.fileType == 1)
      {
        YO(2);
        AppMethodBeat.o(218804);
        return;
      }
      YO(this.FcW.fileType);
      AppMethodBeat.o(218804);
      return;
      this.FcJ = parama1.fileId;
      this.FcY = parama1.gmb;
    }
  }
  
  public final void a(a parama, String paramString, int paramInt)
  {
    AppMethodBeat.i(218807);
    if ((parama.fileType == 2) && (paramInt == -100003) && (this.FcZ))
    {
      this.FcZ = false;
      YO(2);
      AppMethodBeat.o(218807);
      return;
    }
    cI(paramInt, paramString);
    AppMethodBeat.o(218807);
  }
  
  public final boolean a(final d paramd)
  {
    AppMethodBeat.i(218802);
    h.MqF.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(218800);
        com.tencent.mm.plugin.report.service.g.yxI.dD(1431, 0);
        switch (paramd.scene)
        {
        }
        for (;;)
        {
          c.this.FcW = paramd;
          c.this.FcW.startTime = bu.fpO();
          c.this.YO(3);
          AppMethodBeat.o(218800);
          return;
          com.tencent.mm.plugin.report.service.g.yxI.dD(1431, 3);
          continue;
          com.tencent.mm.plugin.report.service.g.yxI.dD(1431, 6);
          continue;
          com.tencent.mm.plugin.report.service.g.yxI.dD(1431, 9);
        }
      }
      
      public final String toString()
      {
        AppMethodBeat.i(218801);
        String str = super.toString() + "|addUploadTask";
        AppMethodBeat.o(218801);
        return str;
      }
    }, "MicroMsg.ParallelUpload.ThreadName");
    AppMethodBeat.o(218802);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.f.c
 * JD-Core Version:    0.7.0.1
 */