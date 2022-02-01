package com.tencent.mm.ui.chatting;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.cb.a;
import com.tencent.mm.g.a.ly;
import com.tencent.mm.g.a.ly.b;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.c;
import com.tencent.mm.model.v;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.ca.a;
import com.tencent.mm.vfs.s;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public final class QQMailHistoryExporter
{
  private static final char[] INVALID;
  private static final String Pke;
  private static final String[] VALID;
  private List<ca> PgD;
  private String Pkb = null;
  private Context context;
  private as dSh = null;
  private float textSize = 1.0F;
  
  static
  {
    AppMethodBeat.i(34858);
    Pke = "<img id=\"%s\" src=\"%s\" height=\"100\" onclick=\"" + com.tencent.mm.pluginsdk.ui.tools.z.mH("weixin://img_onclick/", "this.id + '@@' + this.src") + "\"></img>";
    INVALID = new char[] { 60, 62, 34, 39, 38, 10 };
    VALID = new String[] { "&lt;", "&gt;", "&quot;", "&apos;", "&amp;", "<br />" };
    AppMethodBeat.o(34858);
  }
  
  public QQMailHistoryExporter(Context paramContext, List<ca> paramList, as paramas)
  {
    this.context = paramContext;
    this.PgD = paramList;
    this.dSh = paramas;
  }
  
  private static String Ns(long paramLong)
  {
    AppMethodBeat.i(34857);
    String str = new SimpleDateFormat("yyyy-MM-dd").format(new Date(paramLong));
    AppMethodBeat.o(34857);
    return str;
  }
  
  private String bD(ca paramca)
  {
    AppMethodBeat.i(34854);
    Object localObject = null;
    if (paramca.gAy()) {
      localObject = String.format("[%s]", new Object[] { this.context.getString(2131758491) });
    }
    for (;;)
    {
      Log.d("MicroMsg.QQMailHistoryExporter", "formatOtherMsg, msgStr = %s", new Object[] { localObject });
      paramca = String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", new Object[] { Float.valueOf(this.textSize), bE(paramca), Float.valueOf(this.textSize), localObject });
      AppMethodBeat.o(34854);
      return paramca;
      if (paramca.gDh())
      {
        if (paramca.field_isSend == 1) {
          localObject = this.context.getString(2131758489);
        } else {
          localObject = this.context.getString(2131758488);
        }
      }
      else if (paramca.dOS())
      {
        localObject = new ly();
        ((ly)localObject).dRv.dRq = 1;
        ((ly)localObject).dRv.dCM = paramca;
        EventCenter.instance.publish((IEvent)localObject);
        localObject = String.format("[%s]", new Object[] { ((ly)localObject).dRw.dNk });
      }
      else if (paramca.dOQ())
      {
        localObject = bF(paramca);
      }
      else if (paramca.gDl())
      {
        bg.aVF();
        localObject = c.aSQ().aEK(paramca.field_content).nickname;
        localObject = String.format("[%s: %s]", new Object[] { this.context.getString(2131758483), localObject });
      }
      else if (paramca.cWJ())
      {
        localObject = this.context.getString(2131758490);
        com.tencent.mm.modelvideo.o.bhj();
        localObject = String.format("[%s: %s(%s)]", new Object[] { localObject, new com.tencent.mm.vfs.o(t.Qw(paramca.field_imgPath)).getName(), this.context.getString(2131758482) });
      }
      else if ((paramca.gDn()) || (paramca.gDo()))
      {
        localObject = String.format("[%s]", new Object[] { this.context.getString(2131758484) });
      }
    }
  }
  
  private String bE(ca paramca)
  {
    AppMethodBeat.i(34856);
    String str = null;
    if (!ab.Eq(this.dSh.field_username)) {
      str = aa.getDisplayName(paramca.field_talker);
    }
    for (;;)
    {
      if (paramca.field_isSend == 1)
      {
        Log.i("MicroMsg.QQMailHistoryExporter", "isSend");
        str = com.tencent.mm.model.z.aUa();
      }
      long l = paramca.field_createTime;
      paramca = new SimpleDateFormat("HH:mm").format(new Date(l));
      Object localObject = new StringBuilder("");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("  ");
      ((StringBuilder)localObject).append(paramca);
      paramca = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(34856);
      return paramca;
      localObject = paramca.field_content;
      int i = bp.Kp((String)localObject);
      if (i != -1) {
        str = aa.getDisplayName(((String)localObject).substring(0, i).trim());
      }
    }
  }
  
  private String bF(ca paramca)
  {
    AppMethodBeat.i(34855);
    Object localObject2 = paramca.field_content;
    Object localObject1 = localObject2;
    if (ab.Eq(this.dSh.field_username))
    {
      Log.d("MicroMsg.QQMailHistoryExporter", "chatroom msg, parse it");
      int i = bp.Kp(paramca.field_content);
      localObject1 = localObject2;
      if (i != -1) {
        localObject1 = paramca.field_content.substring(i + 1).trim();
      }
    }
    localObject2 = k.b.HD(Util.processXml((String)localObject1));
    if (localObject2 == null)
    {
      Log.w("MicroMsg.QQMailHistoryExporter", "appmsg content is null");
      paramca = String.format("[%s]", new Object[] { this.context.getString(2131758481) });
      AppMethodBeat.o(34855);
      return paramca;
    }
    g localg = h.o(((k.b)localObject2).appId, true, false);
    if ((localg == null) || (Util.isNullOrNil(localg.field_appName)))
    {
      localObject1 = ((k.b)localObject2).appName;
      localObject1 = h.a(this.context, localg, (String)localObject1);
      if (!paramca.gDq()) {
        break label232;
      }
      if (!Util.isNullOrNil((String)localObject1)) {
        break label204;
      }
      paramca = escapeStringForXml(((k.b)localObject2).title);
    }
    for (;;)
    {
      AppMethodBeat.o(34855);
      return paramca;
      localObject1 = localg.field_appName;
      break;
      label204:
      paramca = String.format("[%s: %s]", new Object[] { localObject1, escapeStringForXml(((k.b)localObject2).title) });
      continue;
      label232:
      if (paramca.gDr())
      {
        paramca = ad.b(paramca, (k.b)localObject2);
        if (!Util.isNullOrNil(paramca))
        {
          localObject1 = "file://".concat(String.valueOf(paramca));
          localObject2 = new com.tencent.mm.vfs.o(paramca);
          paramca = String.format(Pke, new Object[] { ((com.tencent.mm.vfs.o)localObject2).getName(), localObject1, paramca });
        }
      }
      else
      {
        switch (((k.b)localObject2).type)
        {
        case 7: 
        default: 
          paramca = String.format("[%s]", new Object[] { this.context.getString(2131758481) });
          break;
        case 3: 
          if (Util.isNullOrNil(((k.b)localObject2).description))
          {
            paramca = String.format("[%s: %s]", new Object[] { this.context.getString(2131758487), escapeStringForXml(((k.b)localObject2).title) });
            continue;
          }
          paramca = String.format("[%s: %s-%s]", new Object[] { this.context.getString(2131758487), escapeStringForXml(((k.b)localObject2).title), escapeStringForXml(((k.b)localObject2).description) });
          break;
        case 8: 
          paramca = String.format("[%s]", new Object[] { this.context.getString(2131758484) });
          break;
        case 6: 
          if (Util.isNullOrNil(((k.b)localObject2).description))
          {
            paramca = String.format("[%s: %s]", new Object[] { this.context.getString(2131758485), escapeStringForXml(((k.b)localObject2).title) });
            continue;
          }
          paramca = String.format("[%s: %s-%s(%s)]", new Object[] { this.context.getString(2131758485), escapeStringForXml(((k.b)localObject2).title), escapeStringForXml(((k.b)localObject2).description), this.context.getString(2131758482) });
          break;
        case 2: 
          paramca = ad.b(paramca, (k.b)localObject2);
          if (!Util.isNullOrNil(paramca))
          {
            localObject1 = "file://".concat(String.valueOf(paramca));
            localObject2 = new com.tencent.mm.vfs.o(paramca);
            paramca = String.format(Pke, new Object[] { ((com.tencent.mm.vfs.o)localObject2).getName(), localObject1, paramca });
          }
          break;
        case 1: 
          if (Util.isNullOrNil((String)localObject1))
          {
            paramca = escapeStringForXml(((k.b)localObject2).title);
            continue;
          }
          paramca = String.format("[%s: %s]", new Object[] { localObject1, escapeStringForXml(((k.b)localObject2).title) });
          break;
        case 4: 
        case 5: 
          paramca = String.format("[%s: %s]", new Object[] { escapeStringForXml(((k.b)localObject2).title), escapeStringForXml(((k.b)localObject2).url) });
          break;
        }
      }
      paramca = "";
    }
  }
  
  private static String escapeStringForXml(String paramString)
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
      int j = INVALID.length - 1;
      for (;;)
      {
        int k = m;
        if (j >= 0)
        {
          if (INVALID[j] == c)
          {
            localStringBuffer.append(VALID[j]);
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
  
  private String gOm()
  {
    AppMethodBeat.i(34853);
    Object localObject;
    if (!ab.Eq(this.dSh.field_username))
    {
      str1 = this.context.getString(2131765211);
      localObject = this.dSh.arI();
      bg.aVF();
      str1 = String.format(str1, new Object[] { localObject, c.azQ().get(4, null) });
      AppMethodBeat.o(34853);
      return str1;
    }
    if (Util.isNullOrNil(this.dSh.field_nickname))
    {
      localObject = v.Ic(this.dSh.field_username).iterator();
      String str2;
      for (str1 = ""; ((Iterator)localObject).hasNext(); str1 = str1 + str2 + ", ") {
        str2 = aa.getDisplayName((String)((Iterator)localObject).next());
      }
    }
    for (String str1 = str1.substring(0, str1.length() - 2);; str1 = this.dSh.arI())
    {
      str1 = String.format(this.context.getString(2131765210), new Object[] { str1 });
      break;
    }
  }
  
  public final String gOl()
  {
    AppMethodBeat.i(34852);
    Log.i("MicroMsg.QQMailHistoryExporter", "selectItems.size = %d", new Object[] { Integer.valueOf(this.PgD.size()) });
    if (a.jk(this.context)) {
      this.textSize = a.ez(this.context);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<div id=\"history\">\n");
    localStringBuilder.append(String.format("<p style=\"font-size:%fem;\">Dear:</p> <br> <p style=\"text-indent:2em; font-size:%fem;\">%s</p> <br>", new Object[] { Float.valueOf(this.textSize), Float.valueOf(this.textSize), gOm() }));
    Iterator localIterator = this.PgD.iterator();
    ca localca;
    label200:
    Object localObject;
    if (localIterator.hasNext())
    {
      localca = (ca)localIterator.next();
      if (this.Pkb == null)
      {
        this.Pkb = Ns(localca.field_createTime);
        localStringBuilder.append(String.format("<p style=\"text-align:center; font-size:%fem;\"><span style=\"color:#b8b8b8;\">—————  %s  —————</span></p>\n \n", new Object[] { Float.valueOf(this.textSize), this.Pkb }));
        if (!localca.isText()) {
          break label510;
        }
        if (!localca.isText()) {
          break label504;
        }
        if (localca.field_isSend != 1) {
          break label360;
        }
        localObject = String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", new Object[] { Float.valueOf(this.textSize), bE(localca), Float.valueOf(this.textSize), escapeStringForXml(localca.field_content) });
      }
    }
    for (;;)
    {
      localStringBuilder.append((String)localObject);
      break;
      localObject = Ns(localca.field_createTime);
      if (((String)localObject).equals(this.Pkb)) {
        break label200;
      }
      this.Pkb = ((String)localObject);
      localStringBuilder.append("<br>");
      localStringBuilder.append(String.format("<p style=\"text-align:center; font-size:%fem;\"><span style=\"color:#b8b8b8;\">—————  %s  —————</span></p>\n \n", new Object[] { Float.valueOf(this.textSize), this.Pkb }));
      break label200;
      label360:
      if (!ab.Eq(this.dSh.field_username))
      {
        localObject = String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", new Object[] { Float.valueOf(this.textSize), bE(localca), Float.valueOf(this.textSize), escapeStringForXml(localca.field_content) });
      }
      else
      {
        int i = bp.Kp(localca.field_content);
        if (i != -1)
        {
          localObject = String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", new Object[] { Float.valueOf(this.textSize), bE(localca), Float.valueOf(this.textSize), escapeStringForXml(localca.field_content.substring(i + 1).trim()) });
          continue;
          label504:
          localObject = null;
          continue;
          label510:
          if (localca.gAz())
          {
            if (localca.gAz())
            {
              long l1 = localca.field_msgId;
              long l2 = localca.field_msgSvrId;
              String str = ad.cf(localca.field_talker, l1);
              localObject = str;
              if (Util.isNullOrNil(str)) {
                localObject = ad.cg(localca.field_talker, l2);
              }
              localObject = s.k((String)localObject, false);
              Log.i("MicroMsg.QQMailHistoryExporter", "hdPath[%s]", new Object[] { localObject });
              if (!Util.isNullOrNil((String)localObject))
              {
                str = "file://".concat(String.valueOf(localObject));
                com.tencent.mm.vfs.o localo = new com.tencent.mm.vfs.o((String)localObject);
                localObject = String.format(Pke, new Object[] { localo.getName(), str, localObject });
              }
            }
            for (localObject = String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", new Object[] { Float.valueOf(this.textSize), bE(localca), Float.valueOf(this.textSize), localObject });; localObject = null)
            {
              localStringBuilder.append((String)localObject);
              break;
            }
          }
          if (localca.dOQ())
          {
            localObject = k.b.HD(localca.field_content);
            if ((localObject != null) && ((((k.b)localObject).type == 53) || (((k.b)localObject).type == 57)))
            {
              if ((localObject != null) && ((((k.b)localObject).type == 53) || (((k.b)localObject).type == 57))) {}
              for (localObject = String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", new Object[] { Float.valueOf(this.textSize), bE(localca), Float.valueOf(this.textSize), escapeStringForXml(((k.b)localObject).title) });; localObject = null)
              {
                localStringBuilder.append((String)localObject);
                break;
              }
            }
            localStringBuilder.append(bD(localca));
            break;
          }
          localStringBuilder.append(bD(localca));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.QQMailHistoryExporter
 * JD-Core Version:    0.7.0.1
 */