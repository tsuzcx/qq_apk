package com.tencent.mm.search.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/search/report/SimilarEmojiIdKey;", "", "()V", "KEY", "", "enableReport", "", "start", "markEmojiLoad", "", "markEmojiLoadTime", "time", "markSendDialogSimilarEmoji", "markSendSosSimilarEmoji", "markShowSimilarEmojiDialog", "markShowSimilarEmojiMenu", "markShowSosPage", "markSimilarRequest", "markSimilarRequestTime", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a acsi;
  
  static
  {
    AppMethodBeat.i(105851);
    acsi = new a();
    AppMethodBeat.o(105851);
  }
  
  public static void iTA()
  {
    AppMethodBeat.i(105845);
    h.OAn.p(1257L, 5L, 1L);
    AppMethodBeat.o(105845);
  }
  
  public static void iTB()
  {
    AppMethodBeat.i(105846);
    switch (NetStatusUtil.getIOSNetType(MMApplicationContext.getContext()))
    {
    }
    for (;;)
    {
      AppMethodBeat.o(105846);
      return;
      h.OAn.p(1257L, 100L, 1L);
      AppMethodBeat.o(105846);
      return;
      h.OAn.p(1257L, 103L, 1L);
      AppMethodBeat.o(105846);
      return;
      h.OAn.p(1257L, 106L, 1L);
      AppMethodBeat.o(105846);
      return;
      h.OAn.p(1257L, 109L, 1L);
    }
  }
  
  public static void iTC()
  {
    AppMethodBeat.i(105848);
    switch (NetStatusUtil.getIOSNetType(MMApplicationContext.getContext()))
    {
    }
    for (;;)
    {
      AppMethodBeat.o(105848);
      return;
      h.OAn.p(1257L, 115L, 1L);
      AppMethodBeat.o(105848);
      return;
      h.OAn.p(1257L, 118L, 1L);
      AppMethodBeat.o(105848);
      return;
      h.OAn.p(1257L, 121L, 1L);
      AppMethodBeat.o(105848);
      return;
      h.OAn.p(1257L, 124L, 1L);
    }
  }
  
  public static void iTw()
  {
    AppMethodBeat.i(105841);
    h.OAn.p(1257L, 1L, 1L);
    AppMethodBeat.o(105841);
  }
  
  public static void iTx()
  {
    AppMethodBeat.i(105842);
    h.OAn.p(1257L, 2L, 1L);
    AppMethodBeat.o(105842);
  }
  
  public static void iTy()
  {
    AppMethodBeat.i(105843);
    h.OAn.p(1257L, 3L, 1L);
    AppMethodBeat.o(105843);
  }
  
  public static void iTz()
  {
    AppMethodBeat.i(105844);
    h.OAn.p(1257L, 4L, 1L);
    AppMethodBeat.o(105844);
  }
  
  public static void yA(long paramLong)
  {
    AppMethodBeat.i(105849);
    switch (NetStatusUtil.getIOSNetType(MMApplicationContext.getContext()))
    {
    }
    for (;;)
    {
      AppMethodBeat.o(105849);
      return;
      h.OAn.p(1257L, 116L, paramLong);
      AppMethodBeat.o(105849);
      return;
      h.OAn.p(1257L, 119L, paramLong);
      AppMethodBeat.o(105849);
      return;
      h.OAn.p(1257L, 122L, paramLong);
      AppMethodBeat.o(105849);
      return;
      h.OAn.p(1257L, 125L, paramLong);
    }
  }
  
  public static boolean yB(long paramLong)
  {
    AppMethodBeat.i(105850);
    if (System.currentTimeMillis() - paramLong > 10000L)
    {
      AppMethodBeat.o(105850);
      return false;
    }
    AppMethodBeat.o(105850);
    return true;
  }
  
  public static void yz(long paramLong)
  {
    AppMethodBeat.i(105847);
    switch (NetStatusUtil.getIOSNetType(MMApplicationContext.getContext()))
    {
    }
    for (;;)
    {
      AppMethodBeat.o(105847);
      return;
      h.OAn.p(1257L, 101L, paramLong);
      AppMethodBeat.o(105847);
      return;
      h.OAn.p(1257L, 104L, paramLong);
      AppMethodBeat.o(105847);
      return;
      h.OAn.p(1257L, 107L, paramLong);
      AppMethodBeat.o(105847);
      return;
      h.OAn.p(1257L, 110L, paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.search.c.a
 * JD-Core Version:    0.7.0.1
 */