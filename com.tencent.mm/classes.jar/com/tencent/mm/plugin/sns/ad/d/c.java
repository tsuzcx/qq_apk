package com.tencent.mm.plugin.sns.ad.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.j.j;
import com.tencent.mm.plugin.sns.data.b;
import com.tencent.mm.plugin.sns.data.c.a;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
{
  public static void a(b paramb)
  {
    AppMethodBeat.i(310021);
    try
    {
      c.a locala = new c.a();
      locala.eventId = 4001001;
      locala.uxInfo = paramb.uxInfo;
      locala.rzx = paramb.rzx;
      locala.enterScene = paramb.enterScene;
      locala.adExtInfo = paramb.adExtInfo;
      locala.PVG = paramb.PVG;
      locala.qTb = paramb.qTb;
      locala.pId = paramb.pId;
      locala.lxk = 4;
      locala.Qms = paramb.Qms;
      j.a(locala.heI());
      AppMethodBeat.o(310021);
      return;
    }
    finally
    {
      Log.e("AdConversionOnlineReportHelper", paramb.toString());
      AppMethodBeat.o(310021);
    }
  }
  
  public static void a(b paramb, int paramInt)
  {
    AppMethodBeat.i(310066);
    for (;;)
    {
      try
      {
        locala = new c.a();
        locala.eventId = 4001014;
        locala.lxk = paramInt;
        locala.uxInfo = paramb.uxInfo;
        locala.adExtInfo = paramb.adExtInfo;
        locala.PVG = paramb.PVG;
        locala.qTb = paramb.qTb;
        locala.pId = paramb.pId;
        switch (paramInt)
        {
        case 1: 
        case 2: 
          j.a(locala.heI());
          AppMethodBeat.o(310066);
          return;
        }
      }
      finally
      {
        c.a locala;
        Log.e("AdConversionOnlineReportHelper", paramb.toString());
        AppMethodBeat.o(310066);
        return;
      }
      locala.rzx = paramb.rzx;
      locala.enterScene = paramb.enterScene;
    }
  }
  
  public static void a(boolean paramBoolean, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(310011);
    if (paramSnsInfo == null)
    {
      Log.e("AdConversionOnlineReportHelper", "reportInstallStatusBeforeDownload, snsInfo is null");
      AppMethodBeat.o(310011);
      return;
    }
    ADXml localADXml = paramSnsInfo.getAdXml();
    if (localADXml == null)
    {
      Log.e("AdConversionOnlineReportHelper", "reportInstallStatusBeforeDownload, adXml is null");
      AppMethodBeat.o(310011);
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
        locala.PVG = paramSnsInfo.getAid();
        locala.qTb = paramSnsInfo.getTraceid();
        locala.pId = paramSnsInfo.getPid();
        j.a(locala.heI());
        AppMethodBeat.o(310011);
        return;
      }
      finally
      {
        c.a locala;
        Log.e("AdConversionOnlineReportHelper", paramSnsInfo.toString());
        AppMethodBeat.o(310011);
      }
      locala = new c.a();
      locala.eventId = 4001020;
    }
  }
  
  public static void b(b paramb)
  {
    AppMethodBeat.i(310030);
    try
    {
      c.a locala = new c.a();
      locala.eventId = 4001004;
      locala.uxInfo = paramb.uxInfo;
      locala.rzx = paramb.rzx;
      locala.enterScene = paramb.enterScene;
      locala.adExtInfo = paramb.adExtInfo;
      locala.PVG = paramb.PVG;
      locala.qTb = paramb.qTb;
      locala.pId = paramb.pId;
      locala.lxk = 4;
      locala.Qms = paramb.Qms;
      locala.Qmq = paramb.Qmq;
      locala.Qmx = paramb.Qmr;
      j.a(locala.heI());
      AppMethodBeat.o(310030);
      return;
    }
    finally
    {
      Log.e("AdConversionOnlineReportHelper", paramb.toString());
      AppMethodBeat.o(310030);
    }
  }
  
  public static void b(b paramb, int paramInt)
  {
    AppMethodBeat.i(310072);
    for (;;)
    {
      try
      {
        locala = new c.a();
        locala.eventId = 4001016;
        locala.lxk = paramInt;
        locala.uxInfo = paramb.uxInfo;
        locala.adExtInfo = paramb.adExtInfo;
        locala.PVG = paramb.PVG;
        locala.qTb = paramb.qTb;
        locala.pId = paramb.pId;
        switch (paramInt)
        {
        case 1: 
        case 2: 
          j.a(locala.heI());
          AppMethodBeat.o(310072);
          return;
        }
      }
      finally
      {
        c.a locala;
        Log.e("AdConversionOnlineReportHelper", paramb.toString());
        AppMethodBeat.o(310072);
        return;
      }
      locala.rzx = paramb.rzx;
      locala.enterScene = paramb.enterScene;
    }
  }
  
  public static void c(b paramb)
  {
    AppMethodBeat.i(310035);
    try
    {
      c.a locala = new c.a();
      locala.eventId = 4001005;
      locala.uxInfo = paramb.uxInfo;
      locala.rzx = paramb.rzx;
      locala.enterScene = paramb.enterScene;
      locala.adExtInfo = paramb.adExtInfo;
      locala.PVG = paramb.PVG;
      locala.qTb = paramb.qTb;
      locala.pId = paramb.pId;
      locala.lxk = 4;
      locala.Qms = paramb.Qms;
      locala.Qmq = paramb.Qmq;
      locala.Qmx = paramb.Qmr;
      j.a(locala.heI());
      AppMethodBeat.o(310035);
      return;
    }
    finally
    {
      Log.e("AdConversionOnlineReportHelper", paramb.toString());
      AppMethodBeat.o(310035);
    }
  }
  
  public static void c(b paramb, int paramInt)
  {
    AppMethodBeat.i(310080);
    for (;;)
    {
      try
      {
        locala = new c.a();
        locala.eventId = 4001017;
        locala.lxk = paramInt;
        locala.uxInfo = paramb.uxInfo;
        locala.adExtInfo = paramb.adExtInfo;
        locala.PVG = paramb.PVG;
        locala.qTb = paramb.qTb;
        locala.pId = paramb.pId;
        locala.Qmp = paramb.Qmp;
        switch (paramInt)
        {
        case 1: 
        case 2: 
          j.a(locala.heI());
          AppMethodBeat.o(310080);
          return;
        }
      }
      finally
      {
        c.a locala;
        Log.e("AdConversionOnlineReportHelper", paramb.toString());
        AppMethodBeat.o(310080);
        return;
      }
      locala.rzx = paramb.rzx;
      locala.enterScene = paramb.enterScene;
    }
  }
  
  public static void d(b paramb)
  {
    AppMethodBeat.i(310042);
    try
    {
      c.a locala = new c.a();
      locala.eventId = 4001009;
      locala.uxInfo = paramb.uxInfo;
      locala.rzx = paramb.rzx;
      locala.enterScene = paramb.enterScene;
      locala.adExtInfo = paramb.adExtInfo;
      locala.PVG = paramb.PVG;
      locala.qTb = paramb.qTb;
      locala.pId = paramb.pId;
      locala.lxk = 4;
      locala.Qms = paramb.Qms;
      j.a(locala.heI());
      AppMethodBeat.o(310042);
      return;
    }
    finally
    {
      Log.e("AdConversionOnlineReportHelper", paramb.toString());
      AppMethodBeat.o(310042);
    }
  }
  
  public static void e(b paramb)
  {
    AppMethodBeat.i(310051);
    try
    {
      c.a locala = new c.a();
      locala.eventId = 4001010;
      locala.uxInfo = paramb.uxInfo;
      locala.rzx = paramb.rzx;
      locala.enterScene = paramb.enterScene;
      locala.adExtInfo = paramb.adExtInfo;
      locala.PVG = paramb.PVG;
      locala.qTb = paramb.qTb;
      locala.pId = paramb.pId;
      locala.lxk = 4;
      locala.Qms = paramb.Qms;
      locala.Qmq = paramb.Qmq;
      j.a(locala.heI());
      AppMethodBeat.o(310051);
      return;
    }
    finally
    {
      Log.e("AdConversionOnlineReportHelper", paramb.toString());
      AppMethodBeat.o(310051);
    }
  }
  
  public static void f(b paramb)
  {
    AppMethodBeat.i(310054);
    try
    {
      c.a locala = new c.a();
      locala.eventId = 4001006;
      locala.uxInfo = paramb.uxInfo;
      locala.rzx = paramb.rzx;
      locala.enterScene = paramb.enterScene;
      locala.adExtInfo = paramb.adExtInfo;
      locala.PVG = paramb.PVG;
      locala.qTb = paramb.qTb;
      locala.pId = paramb.pId;
      locala.lxk = 4;
      locala.Qms = paramb.Qms;
      j.a(locala.heI());
      AppMethodBeat.o(310054);
      return;
    }
    finally
    {
      Log.e("AdConversionOnlineReportHelper", paramb.toString());
      AppMethodBeat.o(310054);
    }
  }
  
  public static void g(b paramb)
  {
    AppMethodBeat.i(310087);
    try
    {
      c.a locala = new c.a();
      locala.eventId = 4001018;
      locala.uxInfo = paramb.uxInfo;
      locala.rzx = paramb.rzx;
      locala.enterScene = paramb.enterScene;
      locala.adExtInfo = paramb.adExtInfo;
      locala.PVG = paramb.PVG;
      locala.qTb = paramb.qTb;
      locala.pId = paramb.pId;
      locala.lxk = 4;
      locala.Qms = paramb.Qms;
      locala.Qmt = paramb.Qmt;
      j.a(locala.heI());
      AppMethodBeat.o(310087);
      return;
    }
    finally
    {
      Log.e("AdConversionOnlineReportHelper", paramb.toString());
      AppMethodBeat.o(310087);
    }
  }
  
  public static void h(b paramb)
  {
    AppMethodBeat.i(310094);
    try
    {
      c.a locala = new c.a();
      locala.eventId = 4001002;
      locala.uxInfo = paramb.uxInfo;
      locala.rzx = paramb.rzx;
      locala.enterScene = paramb.enterScene;
      locala.adExtInfo = paramb.adExtInfo;
      locala.PVG = paramb.PVG;
      locala.qTb = paramb.qTb;
      locala.pId = paramb.pId;
      locala.lxk = 4;
      locala.Qms = paramb.Qms;
      locala.Qmt = paramb.Qmt;
      j.a(locala.heI());
      AppMethodBeat.o(310094);
      return;
    }
    finally
    {
      Log.e("AdConversionOnlineReportHelper", paramb.toString());
      AppMethodBeat.o(310094);
    }
  }
  
  public static void i(b paramb)
  {
    AppMethodBeat.i(310100);
    try
    {
      c.a locala = new c.a();
      locala.eventId = 4001018;
      locala.uxInfo = paramb.uxInfo;
      locala.adExtInfo = paramb.adExtInfo;
      locala.PVG = paramb.PVG;
      locala.qTb = paramb.qTb;
      locala.pId = paramb.pId;
      locala.lxk = 1;
      j.a(locala.heI());
      AppMethodBeat.o(310100);
      return;
    }
    finally
    {
      Log.e("AdConversionOnlineReportHelper", paramb.toString());
      AppMethodBeat.o(310100);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.c
 * JD-Core Version:    0.7.0.1
 */