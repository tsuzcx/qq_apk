package com.tencent.mm.ui.chatting;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.a.li;
import com.tencent.mm.g.a.li.b;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bv.a;
import com.tencent.mm.vfs.k;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public final class QQMailHistoryExporter
{
  private static final String JYR;
  private static final char[] mTF;
  private static final String[] mTG;
  private List<bv> JVr;
  private String JYO = null;
  private Context context;
  private an dAu = null;
  private float textSize = 1.0F;
  
  static
  {
    AppMethodBeat.i(34858);
    JYR = "<img id=\"%s\" src=\"%s\" height=\"100\" onclick=\"" + com.tencent.mm.pluginsdk.ui.tools.x.lJ("weixin://img_onclick/", "this.id + '@@' + this.src") + "\"></img>";
    mTF = new char[] { 60, 62, 34, 39, 38, 10 };
    mTG = new String[] { "&lt;", "&gt;", "&quot;", "&apos;", "&amp;", "<br />" };
    AppMethodBeat.o(34858);
  }
  
  public QQMailHistoryExporter(Context paramContext, List<bv> paramList, an paraman)
  {
    this.context = paramContext;
    this.JVr = paramList;
    this.dAu = paraman;
  }
  
  private static String Eo(long paramLong)
  {
    AppMethodBeat.i(34857);
    String str = new SimpleDateFormat("yyyy-MM-dd").format(new Date(paramLong));
    AppMethodBeat.o(34857);
    return str;
  }
  
  private static String aSz(String paramString)
  {
    AppMethodBeat.i(34851);
    if (paramString == null)
    {
      AppMethodBeat.o(34851);
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int n = paramString.length();
    int i = 0;
    if (i < n)
    {
      char c = paramString.charAt(i);
      int m = 1;
      int j = mTF.length - 1;
      for (;;)
      {
        int k = m;
        if (j >= 0)
        {
          if (mTF[j] == c)
          {
            localStringBuffer.append(mTG[j]);
            k = 0;
          }
        }
        else
        {
          if (k != 0) {
            localStringBuffer.append(c);
          }
          i += 1;
          break;
        }
        j -= 1;
      }
    }
    paramString = localStringBuffer.toString();
    AppMethodBeat.o(34851);
    return paramString;
  }
  
  private String bo(bv parambv)
  {
    AppMethodBeat.i(34854);
    Object localObject = null;
    if (parambv.ftf()) {
      localObject = String.format("[%s]", new Object[] { this.context.getString(2131758203) });
    }
    for (;;)
    {
      ae.d("MicroMsg.QQMailHistoryExporter", "formatOtherMsg, msgStr = %s", new Object[] { localObject });
      parambv = String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", new Object[] { Float.valueOf(this.textSize), bp(parambv), Float.valueOf(this.textSize), localObject });
      AppMethodBeat.o(34854);
      return parambv;
      if (parambv.fvA())
      {
        if (parambv.field_isSend == 1) {
          localObject = this.context.getString(2131758201);
        } else {
          localObject = this.context.getString(2131758200);
        }
      }
      else if (parambv.cVJ())
      {
        localObject = new li();
        ((li)localObject).dzI.dzC = 1;
        ((li)localObject).dzI.dlw = parambv;
        com.tencent.mm.sdk.b.a.IvT.l((b)localObject);
        localObject = String.format("[%s]", new Object[] { ((li)localObject).dzJ.dvD });
      }
      else if (parambv.cVH())
      {
        localObject = bq(parambv);
      }
      else if (parambv.fvE())
      {
        bc.aCg();
        localObject = c.azI().arp(parambv.field_content).nickname;
        localObject = String.format("[%s: %s]", new Object[] { this.context.getString(2131758195), localObject });
      }
      else if (parambv.cyG())
      {
        localObject = this.context.getString(2131758202);
        com.tencent.mm.modelvideo.o.aNh();
        localObject = String.format("[%s: %s(%s)]", new Object[] { localObject, new k(t.HJ(parambv.field_imgPath)).getName(), this.context.getString(2131758194) });
      }
      else if ((parambv.fvG()) || (parambv.fvH()))
      {
        localObject = String.format("[%s]", new Object[] { this.context.getString(2131758196) });
      }
    }
  }
  
  private String bp(bv parambv)
  {
    AppMethodBeat.i(34856);
    String str = null;
    if (!com.tencent.mm.model.x.wb(this.dAu.field_username)) {
      str = w.zP(parambv.field_talker);
    }
    for (;;)
    {
      if (parambv.field_isSend == 1)
      {
        ae.i("MicroMsg.QQMailHistoryExporter", "isSend");
        str = v.aAE();
      }
      long l = parambv.field_createTime;
      parambv = new SimpleDateFormat("HH:mm").format(new Date(l));
      Object localObject = new StringBuilder("");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("  ");
      ((StringBuilder)localObject).append(parambv);
      parambv = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(34856);
      return parambv;
      localObject = parambv.field_content;
      int i = bl.BJ((String)localObject);
      if (i != -1) {
        str = w.zP(((String)localObject).substring(0, i).trim());
      }
    }
  }
  
  private String bq(bv parambv)
  {
    AppMethodBeat.i(34855);
    Object localObject2 = parambv.field_content;
    Object localObject1 = localObject2;
    if (com.tencent.mm.model.x.wb(this.dAu.field_username))
    {
      ae.d("MicroMsg.QQMailHistoryExporter", "chatroom msg, parse it");
      int i = bl.BJ(parambv.field_content);
      localObject1 = localObject2;
      if (i != -1) {
        localObject1 = parambv.field_content.substring(i + 1).trim();
      }
    }
    localObject2 = k.b.zb(bu.aSA((String)localObject1));
    if (localObject2 == null)
    {
      ae.w("MicroMsg.QQMailHistoryExporter", "appmsg content is null");
      parambv = String.format("[%s]", new Object[] { this.context.getString(2131758193) });
      AppMethodBeat.o(34855);
      return parambv;
    }
    g localg = h.m(((k.b)localObject2).appId, true, false);
    if ((localg == null) || (bu.isNullOrNil(localg.field_appName)))
    {
      localObject1 = ((k.b)localObject2).appName;
      localObject1 = h.a(this.context, localg, (String)localObject1);
      if (!parambv.fvJ()) {
        break label233;
      }
      if (!bu.isNullOrNil((String)localObject1)) {
        break label204;
      }
      parambv = aSz(((k.b)localObject2).title);
    }
    for (;;)
    {
      AppMethodBeat.o(34855);
      return parambv;
      localObject1 = localg.field_appName;
      break;
      label204:
      parambv = String.format("[%s: %s]", new Object[] { localObject1, aSz(((k.b)localObject2).title) });
      continue;
      label233:
      if (parambv.fvK())
      {
        parambv = ad.d(parambv, (k.b)localObject2);
        if (!bu.isNullOrNil(parambv))
        {
          localObject1 = "file://".concat(String.valueOf(parambv));
          localObject2 = new k(parambv);
          parambv = String.format(JYR, new Object[] { ((k)localObject2).getName(), localObject1, parambv });
        }
      }
      else
      {
        switch (((k.b)localObject2).type)
        {
        case 7: 
        default: 
          parambv = String.format("[%s]", new Object[] { this.context.getString(2131758193) });
          break;
        case 3: 
          if (bu.isNullOrNil(((k.b)localObject2).description))
          {
            parambv = String.format("[%s: %s]", new Object[] { this.context.getString(2131758199), aSz(((k.b)localObject2).title) });
            continue;
          }
          parambv = String.format("[%s: %s-%s]", new Object[] { this.context.getString(2131758199), aSz(((k.b)localObject2).title), aSz(((k.b)localObject2).description) });
          break;
        case 8: 
          parambv = String.format("[%s]", new Object[] { this.context.getString(2131758196) });
          break;
        case 6: 
          if (bu.isNullOrNil(((k.b)localObject2).description))
          {
            parambv = String.format("[%s: %s]", new Object[] { this.context.getString(2131758197), aSz(((k.b)localObject2).title) });
            continue;
          }
          parambv = String.format("[%s: %s-%s(%s)]", new Object[] { this.context.getString(2131758197), aSz(((k.b)localObject2).title), aSz(((k.b)localObject2).description), this.context.getString(2131758194) });
          break;
        case 2: 
          parambv = ad.d(parambv, (k.b)localObject2);
          if (!bu.isNullOrNil(parambv))
          {
            localObject1 = "file://".concat(String.valueOf(parambv));
            localObject2 = new k(parambv);
            parambv = String.format(JYR, new Object[] { ((k)localObject2).getName(), localObject1, parambv });
          }
          break;
        case 1: 
          if (bu.isNullOrNil((String)localObject1))
          {
            parambv = aSz(((k.b)localObject2).title);
            continue;
          }
          parambv = String.format("[%s: %s]", new Object[] { localObject1, aSz(((k.b)localObject2).title) });
          break;
        case 4: 
        case 5: 
          parambv = String.format("[%s: %s]", new Object[] { aSz(((k.b)localObject2).title), aSz(((k.b)localObject2).url) });
          break;
        }
      }
      parambv = "";
    }
  }
  
  private String fGi()
  {
    AppMethodBeat.i(34853);
    Object localObject;
    if (!com.tencent.mm.model.x.wb(this.dAu.field_username))
    {
      str1 = this.context.getString(2131763060);
      localObject = this.dAu.adF();
      bc.aCg();
      str1 = String.format(str1, new Object[] { localObject, c.ajA().get(4, null) });
      AppMethodBeat.o(34853);
      return str1;
    }
    if (bu.isNullOrNil(this.dAu.field_nickname))
    {
      localObject = r.zA(this.dAu.field_username).iterator();
      String str2;
      for (str1 = ""; ((Iterator)localObject).hasNext(); str1 = str1 + str2 + ", ") {
        str2 = w.zP((String)((Iterator)localObject).next());
      }
    }
    for (String str1 = str1.substring(0, str1.length() - 2);; str1 = this.dAu.adF())
    {
      str1 = String.format(this.context.getString(2131763059), new Object[] { str1 });
      break;
    }
  }
  
  public final String fGh()
  {
    AppMethodBeat.i(34852);
    ae.i("MicroMsg.QQMailHistoryExporter", "selectItems.size = %d", new Object[] { Integer.valueOf(this.JVr.size()) });
    if (com.tencent.mm.cb.a.ir(this.context)) {
      this.textSize = com.tencent.mm.cb.a.ef(this.context);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<div id=\"history\">\n");
    localStringBuilder.append(String.format("<p style=\"font-size:%fem;\">Dear:</p> <br> <p style=\"text-indent:2em; font-size:%fem;\">%s</p> <br>", new Object[] { Float.valueOf(this.textSize), Float.valueOf(this.textSize), fGi() }));
    Iterator localIterator = this.JVr.iterator();
    bv localbv;
    label200:
    Object localObject;
    if (localIterator.hasNext())
    {
      localbv = (bv)localIterator.next();
      if (this.JYO == null)
      {
        this.JYO = Eo(localbv.field_createTime);
        localStringBuilder.append(String.format("<p style=\"text-align:center; font-size:%fem;\"><span style=\"color:#b8b8b8;\">—————  %s  —————</span></p>\n \n", new Object[] { Float.valueOf(this.textSize), this.JYO }));
        if (!localbv.isText()) {
          break label510;
        }
        if (!localbv.isText()) {
          break label504;
        }
        if (localbv.field_isSend != 1) {
          break label360;
        }
        localObject = String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", new Object[] { Float.valueOf(this.textSize), bp(localbv), Float.valueOf(this.textSize), aSz(localbv.field_content) });
      }
    }
    for (;;)
    {
      localStringBuilder.append((String)localObject);
      break;
      localObject = Eo(localbv.field_createTime);
      if (((String)localObject).equals(this.JYO)) {
        break label200;
      }
      this.JYO = ((String)localObject);
      localStringBuilder.append("<br>");
      localStringBuilder.append(String.format("<p style=\"text-align:center; font-size:%fem;\"><span style=\"color:#b8b8b8;\">—————  %s  —————</span></p>\n \n", new Object[] { Float.valueOf(this.textSize), this.JYO }));
      break label200;
      label360:
      if (!com.tencent.mm.model.x.wb(this.dAu.field_username))
      {
        localObject = String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", new Object[] { Float.valueOf(this.textSize), bp(localbv), Float.valueOf(this.textSize), aSz(localbv.field_content) });
      }
      else
      {
        int i = bl.BJ(localbv.field_content);
        if (i != -1)
        {
          localObject = String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", new Object[] { Float.valueOf(this.textSize), bp(localbv), Float.valueOf(this.textSize), aSz(localbv.field_content.substring(i + 1).trim()) });
          continue;
          label504:
          localObject = null;
          continue;
          label510:
          if (localbv.ftg())
          {
            if (localbv.ftg())
            {
              long l1 = localbv.field_msgId;
              long l2 = localbv.field_msgSvrId;
              String str = ad.ck(localbv.field_talker, l1);
              localObject = str;
              if (bu.isNullOrNil(str)) {
                localObject = ad.cl(localbv.field_talker, l2);
              }
              localObject = com.tencent.mm.vfs.o.k((String)localObject, false);
              ae.i("MicroMsg.QQMailHistoryExporter", "hdPath[%s]", new Object[] { localObject });
              if (!bu.isNullOrNil((String)localObject))
              {
                str = "file://".concat(String.valueOf(localObject));
                k localk = new k((String)localObject);
                localObject = String.format(JYR, new Object[] { localk.getName(), str, localObject });
              }
            }
            for (localObject = String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", new Object[] { Float.valueOf(this.textSize), bp(localbv), Float.valueOf(this.textSize), localObject });; localObject = null)
            {
              localStringBuilder.append((String)localObject);
              break;
            }
          }
          if (localbv.cVH())
          {
            localObject = k.b.zb(localbv.field_content);
            if ((localObject != null) && ((((k.b)localObject).type == 53) || (((k.b)localObject).type == 57)))
            {
              if ((localObject != null) && ((((k.b)localObject).type == 53) || (((k.b)localObject).type == 57))) {}
              for (localObject = String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", new Object[] { Float.valueOf(this.textSize), bp(localbv), Float.valueOf(this.textSize), aSz(((k.b)localObject).title) });; localObject = null)
              {
                localStringBuilder.append((String)localObject);
                break;
              }
            }
            localStringBuilder.append(bo(localbv));
            break;
          }
          localStringBuilder.append(bo(localbv));
          break;
          localStringBuilder.append("\n</div>\n");
          localObject = localStringBuilder.toString();
          AppMethodBeat.o(34852);
          return localObject;
        }
        localObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.QQMailHistoryExporter
 * JD-Core Version:    0.7.0.1
 */