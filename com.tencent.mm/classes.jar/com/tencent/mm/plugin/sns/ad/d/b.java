package com.tencent.mm.plugin.sns.ad.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.i.j;
import com.tencent.mm.plugin.sns.data.c.a;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
{
  public static void a(com.tencent.mm.plugin.sns.data.b paramb)
  {
    AppMethodBeat.i(235996);
    try
    {
      c.a locala = new c.a();
      locala.eventId = 4001001;
      locala.uxInfo = paramb.uxInfo;
      locala.owd = paramb.owd;
      locala.enterScene = paramb.enterScene;
      locala.adExtInfo = paramb.adExtInfo;
      locala.JEE = paramb.JEE;
      locala.nTp = paramb.nTp;
      locala.pId = paramb.pId;
      locala.iVf = 4;
      locala.JPL = paramb.JPL;
      j.a(locala.fNh());
      AppMethodBeat.o(235996);
      return;
    }
    catch (Throwable paramb)
    {
      Log.e("AdConversionOnlineReportHelper", paramb.toString());
      AppMethodBeat.o(235996);
    }
  }
  
  public static void a(com.tencent.mm.plugin.sns.data.b paramb, int paramInt)
  {
    AppMethodBeat.i(236020);
    for (;;)
    {
      try
      {
        locala = new c.a();
        locala.eventId = 4001014;
        locala.iVf = paramInt;
        locala.uxInfo = paramb.uxInfo;
        locala.adExtInfo = paramb.adExtInfo;
        locala.JEE = paramb.JEE;
        locala.nTp = paramb.nTp;
        locala.pId = paramb.pId;
        switch (paramInt)
        {
        case 1: 
        case 2: 
          j.a(locala.fNh());
          AppMethodBeat.o(236020);
          return;
        }
      }
      catch (Throwable paramb)
      {
        c.a locala;
        Log.e("AdConversionOnlineReportHelper", paramb.toString());
        AppMethodBeat.o(236020);
        return;
      }
      locala.owd = paramb.owd;
      locala.enterScene = paramb.enterScene;
    }
  }
  
  public static void a(boolean paramBoolean, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(235994);
    if (paramSnsInfo == null)
    {
      Log.e("AdConversionOnlineReportHelper", "reportInstallStatusBeforeDownload, snsInfo is null");
      AppMethodBeat.o(235994);
      return;
    }
    ADXml localADXml = paramSnsInfo.getAdXml();
    if (localADXml == null)
    {
      Log.e("AdConversionOnlineReportHelper", "reportInstallStatusBeforeDownload, adXml is null");
      AppMethodBeat.o(235994);
      return;
    }
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        locala = new c.a();
        locala.eventId = 4001019;
        locala.uxInfo = paramSnsInfo.getUxinfo();
        locala.adExtInfo = localADXml.adExtInfo;
        locala.JEE = paramSnsInfo.getAid();
        locala.nTp = paramSnsInfo.getTraceid();
        locala.pId = paramSnsInfo.getPid();
        j.a(locala.fNh());
        AppMethodBeat.o(235994);
        return;
      }
      catch (Throwable paramSnsInfo)
      {
        c.a locala;
        Log.e("AdConversionOnlineReportHelper", paramSnsInfo.toString());
        AppMethodBeat.o(235994);
      }
      locala = new c.a();
      locala.eventId = 4001020;
    }
  }
  
  public static void b(com.tencent.mm.plugin.sns.data.b paramb)
  {
    AppMethodBeat.i(235998);
    try
    {
      c.a locala = new c.a();
      locala.eventId = 4001004;
      locala.uxInfo = paramb.uxInfo;
      locala.owd = paramb.owd;
      locala.enterScene = paramb.enterScene;
      locala.adExtInfo = paramb.adExtInfo;
      locala.JEE = paramb.JEE;
      locala.nTp = paramb.nTp;
      locala.pId = paramb.pId;
      locala.iVf = 4;
      locala.JPL = paramb.JPL;
      locala.JPJ = paramb.JPJ;
      locala.JPQ = paramb.JPK;
      j.a(locala.fNh());
      AppMethodBeat.o(235998);
      return;
    }
    catch (Throwable paramb)
    {
      Log.e("AdConversionOnlineReportHelper", paramb.toString());
      AppMethodBeat.o(235998);
    }
  }
  
  public static void b(com.tencent.mm.plugin.sns.data.b paramb, int paramInt)
  {
    AppMethodBeat.i(236027);
    for (;;)
    {
      try
      {
        locala = new c.a();
        locala.eventId = 4001016;
        locala.iVf = paramInt;
        locala.uxInfo = paramb.uxInfo;
        locala.adExtInfo = paramb.adExtInfo;
        locala.JEE = paramb.JEE;
        locala.nTp = paramb.nTp;
        locala.pId = paramb.pId;
        switch (paramInt)
        {
        case 1: 
        case 2: 
          j.a(locala.fNh());
          AppMethodBeat.o(236027);
          return;
        }
      }
      catch (Throwable paramb)
      {
        c.a locala;
        Log.e("AdConversionOnlineReportHelper", paramb.toString());
        AppMethodBeat.o(236027);
        return;
      }
      locala.owd = paramb.owd;
      locala.enterScene = paramb.enterScene;
    }
  }
  
  public static void c(com.tencent.mm.plugin.sns.data.b paramb)
  {
    AppMethodBeat.i(236001);
    try
    {
      c.a locala = new c.a();
      locala.eventId = 4001005;
      locala.uxInfo = paramb.uxInfo;
      locala.owd = paramb.owd;
      locala.enterScene = paramb.enterScene;
      locala.adExtInfo = paramb.adExtInfo;
      locala.JEE = paramb.JEE;
      locala.nTp = paramb.nTp;
      locala.pId = paramb.pId;
      locala.iVf = 4;
      locala.JPL = paramb.JPL;
      locala.JPJ = paramb.JPJ;
      locala.JPQ = paramb.JPK;
      j.a(locala.fNh());
      AppMethodBeat.o(236001);
      return;
    }
    catch (Throwable paramb)
    {
      Log.e("AdConversionOnlineReportHelper", paramb.toString());
      AppMethodBeat.o(236001);
    }
  }
  
  public static void c(com.tencent.mm.plugin.sns.data.b paramb, int paramInt)
  {
    AppMethodBeat.i(236031);
    for (;;)
    {
      try
      {
        locala = new c.a();
        locala.eventId = 4001017;
        locala.iVf = paramInt;
        locala.uxInfo = paramb.uxInfo;
        locala.adExtInfo = paramb.adExtInfo;
        locala.JEE = paramb.JEE;
        locala.nTp = paramb.nTp;
        locala.pId = paramb.pId;
        locala.JPI = paramb.JPI;
        switch (paramInt)
        {
        case 1: 
        case 2: 
          j.a(locala.fNh());
          AppMethodBeat.o(236031);
          return;
        }
      }
      catch (Throwable paramb)
      {
        c.a locala;
        Log.e("AdConversionOnlineReportHelper", paramb.toString());
        AppMethodBeat.o(236031);
        return;
      }
      locala.owd = paramb.owd;
      locala.enterScene = paramb.enterScene;
    }
  }
  
  public static void d(com.tencent.mm.plugin.sns.data.b paramb)
  {
    AppMethodBeat.i(236008);
    try
    {
      c.a locala = new c.a();
      locala.eventId = 4001009;
      locala.uxInfo = paramb.uxInfo;
      locala.owd = paramb.owd;
      locala.enterScene = paramb.enterScene;
      locala.adExtInfo = paramb.adExtInfo;
      locala.JEE = paramb.JEE;
      locala.nTp = paramb.nTp;
      locala.pId = paramb.pId;
      locala.iVf = 4;
      locala.JPL = paramb.JPL;
      j.a(locala.fNh());
      AppMethodBeat.o(236008);
      return;
    }
    catch (Throwable paramb)
    {
      Log.e("AdConversionOnlineReportHelper", paramb.toString());
      AppMethodBeat.o(236008);
    }
  }
  
  public static void e(com.tencent.mm.plugin.sns.data.b paramb)
  {
    AppMethodBeat.i(236011);
    try
    {
      c.a locala = new c.a();
      locala.eventId = 4001010;
      locala.uxInfo = paramb.uxInfo;
      locala.owd = paramb.owd;
      locala.enterScene = paramb.enterScene;
      locala.adExtInfo = paramb.adExtInfo;
      locala.JEE = paramb.JEE;
      locala.nTp = paramb.nTp;
      locala.pId = paramb.pId;
      locala.iVf = 4;
      locala.JPL = paramb.JPL;
      locala.JPJ = paramb.JPJ;
      j.a(locala.fNh());
      AppMethodBeat.o(236011);
      return;
    }
    catch (Throwable paramb)
    {
      Log.e("AdConversionOnlineReportHelper", paramb.toString());
      AppMethodBeat.o(236011);
    }
  }
  
  public static void f(com.tencent.mm.plugin.sns.data.b paramb)
  {
    AppMethodBeat.i(236016);
    try
    {
      c.a locala = new c.a();
      locala.eventId = 4001006;
      locala.uxInfo = paramb.uxInfo;
      locala.owd = paramb.owd;
      locala.enterScene = paramb.enterScene;
      locala.adExtInfo = paramb.adExtInfo;
      locala.JEE = paramb.JEE;
      locala.nTp = paramb.nTp;
      locala.pId = paramb.pId;
      locala.iVf = 4;
      locala.JPL = paramb.JPL;
      j.a(locala.fNh());
      AppMethodBeat.o(236016);
      return;
    }
    catch (Throwable paramb)
    {
      Log.e("AdConversionOnlineReportHelper", paramb.toString());
      AppMethodBeat.o(236016);
    }
  }
  
  public static void g(com.tencent.mm.plugin.sns.data.b paramb)
  {
    AppMethodBeat.i(236032);
    try
    {
      c.a locala = new c.a();
      locala.eventId = 4001018;
      locala.uxInfo = paramb.uxInfo;
      locala.owd = paramb.owd;
      locala.enterScene = paramb.enterScene;
      locala.adExtInfo = paramb.adExtInfo;
      locala.JEE = paramb.JEE;
      locala.nTp = paramb.nTp;
      locala.pId = paramb.pId;
      locala.iVf = 4;
      locala.JPL = paramb.JPL;
      locala.JPM = paramb.JPM;
      j.a(locala.fNh());
      AppMethodBeat.o(236032);
      return;
    }
    catch (Throwable paramb)
    {
      Log.e("AdConversionOnlineReportHelper", paramb.toString());
      AppMethodBeat.o(236032);
    }
  }
  
  public static void h(com.tencent.mm.plugin.sns.data.b paramb)
  {
    AppMethodBeat.i(236034);
    try
    {
      c.a locala = new c.a();
      locala.eventId = 4001002;
      locala.uxInfo = paramb.uxInfo;
      locala.owd = paramb.owd;
      locala.enterScene = paramb.enterScene;
      locala.adExtInfo = paramb.adExtInfo;
      locala.JEE = paramb.JEE;
      locala.nTp = paramb.nTp;
      locala.pId = paramb.pId;
      locala.iVf = 4;
      locala.JPL = paramb.JPL;
      locala.JPM = paramb.JPM;
      j.a(locala.fNh());
      AppMethodBeat.o(236034);
      return;
    }
    catch (Throwable paramb)
    {
      Log.e("AdConversionOnlineReportHelper", paramb.toString());
      AppMethodBeat.o(236034);
    }
  }
  
  public static void i(com.tencent.mm.plugin.sns.data.b paramb)
  {
    AppMethodBeat.i(236036);
    try
    {
      c.a locala = new c.a();
      locala.eventId = 4001018;
      locala.uxInfo = paramb.uxInfo;
      locala.adExtInfo = paramb.adExtInfo;
      locala.JEE = paramb.JEE;
      locala.nTp = paramb.nTp;
      locala.pId = paramb.pId;
      locala.iVf = 1;
      j.a(locala.fNh());
      AppMethodBeat.o(236036);
      return;
    }
    catch (Throwable paramb)
    {
      Log.e("AdConversionOnlineReportHelper", paramb.toString());
      AppMethodBeat.o(236036);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.b
 * JD-Core Version:    0.7.0.1
 */