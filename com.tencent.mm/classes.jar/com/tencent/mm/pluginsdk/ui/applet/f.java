package com.tencent.mm.pluginsdk.ui.applet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/ui/applet/BizImageDownloadReporter;", "", "()V", "TAG", "", "reportDownloadImageType", "", "requestImageType", "", "responseContentType", "reportDownloadResult", "imageType", "success", "", "reportDownloadTime", "contentType", "downloadTime", "", "reportImageDecodeResult", "reportImageDecodeTime", "decodeTime", "reportImageRequestResult", "reportImageRequestTime", "requestTime", "reportRequestDownload", "reportRequestDownloadByImageType", "reportRequestImageDecode", "reportRequestNormalAfterGetWxPicFailed", "reportRequestNormalResultAfterGetWxPicFailed", "reportWxPicDataValid", "valid", "reportWxPicDecodeFailed", "url", "type", "errCode", "fromScene", "WxPicDecodeErrCode", "plugin-biz_release"})
public final class f
{
  public static final f Rfh;
  
  static
  {
    AppMethodBeat.i(124852);
    Rfh = new f();
    AppMethodBeat.o(124852);
  }
  
  public static void DX(boolean paramBoolean)
  {
    AppMethodBeat.i(124842);
    Log.v("MicroMsg.BizImageDownloadReporter", "alvinluo reportWxPicDataValid valid: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    h localh = h.IzE;
    if (paramBoolean) {}
    for (long l = 9L;; l = 10L)
    {
      localh.p(1111L, l, 1L);
      AppMethodBeat.o(124842);
      return;
    }
  }
  
  public static void aN(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(124851);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(124851);
      return;
    }
    if ((paramInt2 != 1) && (paramInt2 != 2) && (paramInt2 != 3))
    {
      AppMethodBeat.o(124851);
      return;
    }
    Log.v("MicroMsg.BizImageDownloadReporter", "alvinluo reportWxPicDecodeFailed type: %d, errCode: %d, fromScene: %d", new Object[] { Integer.valueOf(2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    h.IzE.a(17492, new Object[] { paramString, Integer.valueOf(2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(124851);
  }
  
  public static void aqf(int paramInt)
  {
    AppMethodBeat.i(124840);
    Log.v("MicroMsg.BizImageDownloadReporter", "alvinluo reportRequestDownloadByImageType imageType: %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(124840);
      return;
      h.IzE.p(1111L, 1L, 1L);
      AppMethodBeat.o(124840);
      return;
      h.IzE.p(1111L, 2L, 1L);
      AppMethodBeat.o(124840);
      return;
      h.IzE.p(1111L, 31L, 1L);
    }
  }
  
  public static void aqg(int paramInt)
  {
    AppMethodBeat.i(124845);
    Log.v("MicroMsg.BizImageDownloadReporter", "alvinluo reportRequestNormalAfterGetWxPicFailed requestImageType: %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(124845);
      return;
      h.IzE.p(1111L, 14L, 1L);
      AppMethodBeat.o(124845);
      return;
      h.IzE.p(1111L, 40L, 1L);
    }
  }
  
  public static void b(int paramInt, boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(124847);
    Log.v("MicroMsg.BizImageDownloadReporter", "alvinluo requestImageRequestTime imageType: %d, success: %b, requestTime: %d", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), Long.valueOf(paramLong) });
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(124847);
      return;
    case 0: 
      localh = h.IzE;
      if (paramBoolean) {}
      for (l = 15L;; l = 24L)
      {
        localh.p(1111L, l, paramLong);
        AppMethodBeat.o(124847);
        return;
      }
    case 1: 
      localh = h.IzE;
      if (paramBoolean) {}
      for (l = 16L;; l = 25L)
      {
        localh.p(1111L, l, paramLong);
        AppMethodBeat.o(124847);
        return;
      }
    }
    h localh = h.IzE;
    if (paramBoolean) {}
    for (long l = 34L;; l = 35L)
    {
      localh.p(1111L, l, paramLong);
      break;
    }
  }
  
  public static void bI(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(124841);
    Log.v("MicroMsg.BizImageDownloadReporter", "alvinluo reportDownloadResult imageType: %d, success: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(124841);
      return;
    case 0: 
      localh = h.IzE;
      if (paramBoolean) {}
      for (l = 3L;; l = 4L)
      {
        localh.p(1111L, l, 1L);
        AppMethodBeat.o(124841);
        return;
      }
    case 1: 
      localh = h.IzE;
      if (paramBoolean) {}
      for (l = 5L;; l = 6L)
      {
        localh.p(1111L, l, 1L);
        AppMethodBeat.o(124841);
        return;
      }
    }
    h localh = h.IzE;
    if (paramBoolean) {}
    for (long l = 32L;; l = 33L)
    {
      localh.p(1111L, l, 1L);
      break;
    }
  }
  
  public static void bJ(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(124846);
    Log.v("MicroMsg.BizImageDownloadReporter", "alvinluo reportRequestNormalResultAfterGetWxPicFailed requestImageType: %d, success: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    switch (paramInt)
    {
    case 1: 
    default: 
      AppMethodBeat.o(124846);
      return;
    case 0: 
      localh = h.IzE;
      if (paramBoolean) {}
      for (l = 22L;; l = 23L)
      {
        localh.p(1111L, l, 1L);
        AppMethodBeat.o(124846);
        return;
      }
    }
    h localh = h.IzE;
    if (paramBoolean) {}
    for (long l = 41L;; l = 42L)
    {
      localh.p(1111L, l, 1L);
      break;
    }
  }
  
  public static void bK(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(124848);
    Log.v("MicroMsg.BizImageDownloadReporter", "alvinluo requestImageRequestResult imageType: %d, success: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(124848);
      return;
    case 0: 
      localh = h.IzE;
      if (paramBoolean) {}
      for (l = 26L;; l = 28L)
      {
        localh.p(1111L, l, 1L);
        AppMethodBeat.o(124848);
        return;
      }
    case 1: 
      localh = h.IzE;
      if (paramBoolean) {}
      for (l = 27L;; l = 29L)
      {
        localh.p(1111L, l, 1L);
        AppMethodBeat.o(124848);
        return;
      }
    }
    h localh = h.IzE;
    if (paramBoolean) {}
    for (long l = 38L;; l = 39L)
    {
      localh.p(1111L, l, 1L);
      break;
    }
  }
  
  public static void bY(String paramString, long paramLong)
  {
    AppMethodBeat.i(124849);
    Log.v("MicroMsg.BizImageDownloadReporter", "alvinluo reportDownloadTime contentType: %s, downloadTime: %d", new Object[] { paramString, Long.valueOf(paramLong) });
    if (paramLong < 0L)
    {
      AppMethodBeat.o(124849);
      return;
    }
    g localg = g.Rfj;
    switch (g.brh(paramString))
    {
    }
    for (;;)
    {
      AppMethodBeat.o(124849);
      return;
      h.IzE.p(1111L, 18L, paramLong);
      AppMethodBeat.o(124849);
      return;
      h.IzE.p(1111L, 20L, paramLong);
      AppMethodBeat.o(124849);
      return;
      h.IzE.p(1111L, 37L, paramLong);
    }
  }
  
  public static void bZ(String paramString, long paramLong)
  {
    AppMethodBeat.i(124850);
    if (paramLong < 0L)
    {
      AppMethodBeat.o(124850);
      return;
    }
    g localg = g.Rfj;
    int i = g.brh(paramString);
    Log.v("MicroMsg.BizImageDownloadReporter", "alvinluo reportImageDecodeTime contentType: %s, imageType: %d, decodeTime: %d", new Object[] { paramString, Integer.valueOf(i), Long.valueOf(paramLong) });
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(124850);
      return;
      h.IzE.p(1111L, 50L, paramLong);
      AppMethodBeat.o(124850);
      return;
      h.IzE.p(1111L, 21L, paramLong);
      AppMethodBeat.o(124850);
      return;
      h.IzE.p(1111L, 46L, paramLong);
    }
  }
  
  public static void brd(String paramString)
  {
    AppMethodBeat.i(124843);
    g localg = g.Rfj;
    int i = g.brh(paramString);
    Log.v("MicroMsg.BizImageDownloadReporter", "alvinluo reportRequestImageDecode contentType: %s, imageType: %d", new Object[] { paramString, Integer.valueOf(i) });
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(124843);
      return;
      h.IzE.p(1111L, 11L, 1L);
      AppMethodBeat.o(124843);
      return;
      h.IzE.p(1111L, 47L, 1L);
      AppMethodBeat.o(124843);
      return;
      h.IzE.p(1111L, 43L, 1L);
    }
  }
  
  public static void dn(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(124844);
    g localg = g.Rfj;
    int i = g.brh(paramString);
    Log.v("MicroMsg.BizImageDownloadReporter", "alvinluo reportImageDecodeResult contentType: %s, imageType: %d, success: %b", new Object[] { paramString, Integer.valueOf(i), Boolean.valueOf(paramBoolean) });
    switch (i)
    {
    default: 
      AppMethodBeat.o(124844);
      return;
    case 1: 
      paramString = h.IzE;
      if (paramBoolean) {}
      for (l = 12L;; l = 13L)
      {
        paramString.p(1111L, l, 1L);
        AppMethodBeat.o(124844);
        return;
      }
    case 0: 
      paramString = h.IzE;
      if (paramBoolean) {}
      for (l = 48L;; l = 49L)
      {
        paramString.p(1111L, l, 1L);
        AppMethodBeat.o(124844);
        return;
      }
    }
    paramString = h.IzE;
    if (paramBoolean) {}
    for (long l = 44L;; l = 45L)
    {
      paramString.p(1111L, l, 1L);
      break;
    }
  }
  
  public static void hkf()
  {
    AppMethodBeat.i(124839);
    Log.v("MicroMsg.BizImageDownloadReporter", "alvinluo reportRequestDownload");
    h.IzE.p(1111L, 0L, 1L);
    AppMethodBeat.o(124839);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.f
 * JD-Core Version:    0.7.0.1
 */