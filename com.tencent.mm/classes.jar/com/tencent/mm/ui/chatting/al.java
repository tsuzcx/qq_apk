package com.tencent.mm.ui.chatting;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.f;
import com.tencent.mm.aj.z;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.tools.l;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class al
{
  public static void a(bi parambi, Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(31023);
    if (paramContext == null)
    {
      ab.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptImgConnector: context is null");
      AppMethodBeat.o(31023);
      return;
    }
    if (parambi == null)
    {
      ab.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptImgConnector: msg is null");
      AppMethodBeat.o(31023);
      return;
    }
    aw.aaz();
    if (!c.isSDCardAvailable())
    {
      t.ii(paramContext);
      ab.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptImgConnector: sd card is not available");
      AppMethodBeat.o(31023);
      return;
    }
    a(fe(z.afi().la(4)), paramContext, new al.5(parambi, paramContext, paramBoolean, paramString));
    AppMethodBeat.o(31023);
  }
  
  public static void a(bi parambi, String paramString, Context paramContext)
  {
    AppMethodBeat.i(31028);
    a(parambi, paramString, paramContext, 512);
    AppMethodBeat.o(31028);
  }
  
  private static void a(bi parambi, String paramString, Context paramContext, int paramInt)
  {
    AppMethodBeat.i(31031);
    if (paramContext == null)
    {
      ab.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptMusicConnector: context is null");
      AppMethodBeat.o(31031);
      return;
    }
    if (parambi == null)
    {
      ab.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptMusicConnector: msg is null");
      AppMethodBeat.o(31031);
      return;
    }
    List localList = null;
    switch (paramInt)
    {
    }
    for (;;)
    {
      a(localList, paramContext, new al.10(parambi, paramString, paramInt, paramContext));
      AppMethodBeat.o(31031);
      return;
      localList = fe(f.aeV());
      continue;
      localList = fe(f.aeT());
      continue;
      localList = fe(f.aeX());
    }
  }
  
  private static void a(List<String> paramList, Context paramContext, n.d paramd)
  {
    AppMethodBeat.i(31033);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      ab.w("MicroMsg.LongClickBrandServiceHelper", "tryShowConnectorDialog: careList is null or empty");
      AppMethodBeat.o(31033);
      return;
    }
    l locall = new l(paramContext);
    locall.AvY = new al.11();
    locall.AvZ = new al.2(paramContext);
    locall.sao = new al.3(paramList);
    locall.sap = paramd;
    locall.cwt();
    AppMethodBeat.o(31033);
  }
  
  public static void b(bi parambi, Context paramContext)
  {
    AppMethodBeat.i(31022);
    if (paramContext == null)
    {
      ab.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVoiceConnector: context is null");
      AppMethodBeat.o(31022);
      return;
    }
    if (parambi == null)
    {
      ab.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVoiceConnector: msg is null");
      AppMethodBeat.o(31022);
      return;
    }
    aw.aaz();
    if (!c.isSDCardAvailable())
    {
      t.ii(paramContext);
      ab.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVoiceConnector: sd card not available");
      AppMethodBeat.o(31022);
      return;
    }
    a(fe(z.afi().la(2)), paramContext, new al.4(parambi, paramContext));
    AppMethodBeat.o(31022);
  }
  
  public static void b(bi parambi, String paramString, Context paramContext)
  {
    AppMethodBeat.i(31029);
    a(parambi, paramString, paramContext, 256);
    AppMethodBeat.o(31029);
  }
  
  public static void c(bi parambi, Context paramContext)
  {
    AppMethodBeat.i(31024);
    if (paramContext == null)
    {
      ab.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVideoConnector: context is null");
      AppMethodBeat.o(31024);
      return;
    }
    if (parambi == null)
    {
      ab.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVideoConnector: msg is null");
      AppMethodBeat.o(31024);
      return;
    }
    aw.aaz();
    if (!c.isSDCardAvailable())
    {
      t.ii(paramContext);
      ab.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVideoConnector: sd card is not available");
      AppMethodBeat.o(31024);
      return;
    }
    a(fe(z.afi().la(8)), paramContext, new al.6(parambi, paramContext));
    AppMethodBeat.o(31024);
  }
  
  public static void c(bi parambi, String paramString, Context paramContext)
  {
    AppMethodBeat.i(31030);
    a(parambi, paramString, paramContext, 128);
    AppMethodBeat.o(31030);
  }
  
  public static void d(bi parambi, Context paramContext)
  {
    AppMethodBeat.i(31027);
    if (paramContext == null)
    {
      ab.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptEmojiConnector: context is null");
      AppMethodBeat.o(31027);
      return;
    }
    if (parambi == null)
    {
      ab.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptEmojiConnector: msg is null");
      AppMethodBeat.o(31027);
      return;
    }
    aw.aaz();
    if (!c.isSDCardAvailable())
    {
      t.ii(paramContext);
      ab.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptEmojiConnector: sd card is not available");
      AppMethodBeat.o(31027);
      return;
    }
    a(fe(z.afi().la(64)), paramContext, new al.9(parambi, paramContext));
    AppMethodBeat.o(31027);
  }
  
  private static List<String> fe(List<String> paramList)
  {
    AppMethodBeat.i(31032);
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if (!f.rV(str)) {
        localLinkedList.add(str);
      }
    }
    ab.d("MicroMsg.LongClickBrandServiceHelper", "get selected accept list, size %d", new Object[] { Integer.valueOf(localLinkedList.size()) });
    AppMethodBeat.o(31032);
    return localLinkedList;
  }
  
  public static void n(String paramString, Context paramContext)
  {
    AppMethodBeat.i(31021);
    if (paramContext == null)
    {
      ab.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptTextConnector: context is null");
      AppMethodBeat.o(31021);
      return;
    }
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptTextConnector: content is null");
      AppMethodBeat.o(31021);
      return;
    }
    a(fe(z.afi().la(1)), paramContext, new al.1(paramString, paramContext));
    AppMethodBeat.o(31021);
  }
  
  public static void o(String paramString, Context paramContext)
  {
    AppMethodBeat.i(31025);
    if (paramContext == null)
    {
      ab.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptLocationConnector: context is null");
      AppMethodBeat.o(31025);
      return;
    }
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptLocationConnector: locationXML is null");
      AppMethodBeat.o(31025);
      return;
    }
    a(fe(z.afi().la(16)), paramContext, new al.7(paramString, paramContext));
    AppMethodBeat.o(31025);
  }
  
  public static void p(String paramString, Context paramContext)
  {
    AppMethodBeat.i(31026);
    if (paramContext == null)
    {
      ab.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptPersonalCardConnector: context is null");
      AppMethodBeat.o(31026);
      return;
    }
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptPersonalCardConnector: locationXML is null");
      AppMethodBeat.o(31026);
      return;
    }
    a(fe(z.afi().la(32)), paramContext, new al.8(paramString, paramContext));
    AppMethodBeat.o(31026);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.al
 * JD-Core Version:    0.7.0.1
 */