package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.view.MenuItem;
import android.widget.TextView;
import com.tencent.mm.ai.e;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.z;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.n.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.n.b;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.s;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ao
{
  public static void a(bi parambi, Context paramContext, String paramString, boolean paramBoolean)
  {
    if (paramContext == null)
    {
      y.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptImgConnector: context is null");
      return;
    }
    if (parambi == null)
    {
      y.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptImgConnector: msg is null");
      return;
    }
    au.Hx();
    if (!c.isSDCardAvailable())
    {
      s.gM(paramContext);
      y.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptImgConnector: sd card is not available");
      return;
    }
    a(dU(z.My().in(4)), paramContext, new ao.5(parambi, paramContext, paramBoolean, paramString));
  }
  
  public static void a(bi parambi, String paramString, Context paramContext)
  {
    a(parambi, paramString, paramContext, 512);
  }
  
  private static void a(bi parambi, String paramString, Context paramContext, int paramInt)
  {
    if (paramContext == null)
    {
      y.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptMusicConnector: context is null");
      return;
    }
    if (parambi == null)
    {
      y.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptMusicConnector: msg is null");
      return;
    }
    List localList = null;
    switch (paramInt)
    {
    }
    for (;;)
    {
      a(localList, paramContext, new ao.10(parambi, paramString, paramInt, paramContext));
      return;
      localList = dU(z.My().in(256));
      continue;
      localList = dU(f.Mm());
      continue;
      localList = dU(z.My().in(512));
    }
  }
  
  private static void a(List<String> paramList, Context paramContext, n.d paramd)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      y.w("MicroMsg.LongClickBrandServiceHelper", "tryShowConnectorDialog: careList is null or empty");
      return;
    }
    com.tencent.mm.ui.tools.j localj = new com.tencent.mm.ui.tools.j(paramContext);
    localj.wdr = new ao.11();
    localj.wds = new n.b()
    {
      public final void a(TextView paramAnonymousTextView, MenuItem paramAnonymousMenuItem)
      {
        ad localad;
        if (paramAnonymousTextView != null)
        {
          au.Hx();
          localad = c.Fw().abl(paramAnonymousMenuItem.getTitle());
          if ((localad == null) || ((int)localad.dBe <= 0)) {
            paramAnonymousTextView.setText(paramAnonymousMenuItem.getTitle());
          }
        }
        else
        {
          return;
        }
        paramAnonymousTextView.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this.val$context, localad.Bp(), paramAnonymousTextView.getTextSize()));
      }
    };
    localj.phH = new ao.3(paramList);
    localj.phI = paramd;
    localj.bJQ();
  }
  
  public static void b(bi parambi, Context paramContext)
  {
    if (paramContext == null)
    {
      y.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVoiceConnector: context is null");
      return;
    }
    if (parambi == null)
    {
      y.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVoiceConnector: msg is null");
      return;
    }
    au.Hx();
    if (!c.isSDCardAvailable())
    {
      s.gM(paramContext);
      y.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVoiceConnector: sd card not available");
      return;
    }
    a(dU(z.My().in(2)), paramContext, new ao.4(parambi, paramContext));
  }
  
  public static void b(bi parambi, String paramString, Context paramContext)
  {
    a(parambi, paramString, paramContext, 256);
  }
  
  public static void c(bi parambi, Context paramContext)
  {
    if (paramContext == null)
    {
      y.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVideoConnector: context is null");
      return;
    }
    if (parambi == null)
    {
      y.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVideoConnector: msg is null");
      return;
    }
    au.Hx();
    if (!c.isSDCardAvailable())
    {
      s.gM(paramContext);
      y.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVideoConnector: sd card is not available");
      return;
    }
    a(dU(z.My().in(8)), paramContext, new ao.6(parambi, paramContext));
  }
  
  public static void c(bi parambi, String paramString, Context paramContext)
  {
    a(parambi, paramString, paramContext, 128);
  }
  
  public static void d(bi parambi, Context paramContext)
  {
    if (paramContext == null)
    {
      y.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptEmojiConnector: context is null");
      return;
    }
    if (parambi == null)
    {
      y.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptEmojiConnector: msg is null");
      return;
    }
    au.Hx();
    if (!c.isSDCardAvailable())
    {
      s.gM(paramContext);
      y.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptEmojiConnector: sd card is not available");
      return;
    }
    a(dU(z.My().in(64)), paramContext, new ao.9(parambi, paramContext));
  }
  
  private static List<String> dU(List<String> paramList)
  {
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if (!f.la(str)) {
        localLinkedList.add(str);
      }
    }
    y.d("MicroMsg.LongClickBrandServiceHelper", "get selected accept list, size %d", new Object[] { Integer.valueOf(localLinkedList.size()) });
    return localLinkedList;
  }
  
  public static void l(String paramString, Context paramContext)
  {
    if (paramContext == null)
    {
      y.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptTextConnector: context is null");
      return;
    }
    if (bk.bl(paramString))
    {
      y.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptTextConnector: content is null");
      return;
    }
    a(dU(z.My().in(1)), paramContext, new ao.1(paramString, paramContext));
  }
  
  public static void m(String paramString, Context paramContext)
  {
    if (paramContext == null)
    {
      y.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptLocationConnector: context is null");
      return;
    }
    if (bk.bl(paramString))
    {
      y.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptLocationConnector: locationXML is null");
      return;
    }
    a(dU(z.My().in(16)), paramContext, new ao.7(paramString, paramContext));
  }
  
  public static void n(String paramString, Context paramContext)
  {
    if (paramContext == null)
    {
      y.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptPersonalCardConnector: context is null");
      return;
    }
    if (bk.bl(paramString))
    {
      y.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptPersonalCardConnector: locationXML is null");
      return;
    }
    a(dU(z.My().in(32)), paramContext, new ao.8(paramString, paramContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ao
 * JD-Core Version:    0.7.0.1
 */