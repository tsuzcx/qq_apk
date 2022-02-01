package com.tencent.mm.ui.chatting;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.nw;
import com.tencent.mm.autogen.a.nw.b;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.cd.a;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.cc.a;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public final class QQMailHistoryExporter
{
  private static final char[] INVALID;
  private static final String[] VALID;
  private static final String aelm;
  private List<cc> aehr;
  private String aelj = null;
  private Context context;
  private au hRm = null;
  private float textSize = 1.0F;
  
  static
  {
    AppMethodBeat.i(34858);
    aelm = "<img id=\"%s\" src=\"%s\" height=\"100\" onclick=\"" + com.tencent.mm.pluginsdk.ui.tools.aa.pt("weixin://img_onclick/", "this.id + '@@' + this.src") + "\"></img>";
    INVALID = new char[] { 60, 62, 34, 39, 38, 10 };
    VALID = new String[] { "&lt;", "&gt;", "&quot;", "&apos;", "&amp;", "<br />" };
    AppMethodBeat.o(34858);
  }
  
  public QQMailHistoryExporter(Context paramContext, List<cc> paramList, au paramau)
  {
    this.context = paramContext;
    this.aehr = paramList;
    this.hRm = paramau;
  }
  
  private String cl(cc paramcc)
  {
    AppMethodBeat.i(34854);
    Object localObject = null;
    if (paramcc.iYj()) {
      localObject = String.format("[%s]", new Object[] { this.context.getString(R.l.gFm) });
    }
    for (;;)
    {
      Log.d("MicroMsg.QQMailHistoryExporter", "formatOtherMsg, msgStr = %s", new Object[] { localObject });
      paramcc = String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", new Object[] { Float.valueOf(this.textSize), cm(paramcc), Float.valueOf(this.textSize), localObject });
      AppMethodBeat.o(34854);
      return paramcc;
      if (paramcc.jbx())
      {
        if (paramcc.field_isSend == 1) {
          localObject = this.context.getString(R.l.gFk);
        } else {
          localObject = this.context.getString(R.l.gFj);
        }
      }
      else if (paramcc.fxT())
      {
        localObject = new nw();
        ((nw)localObject).hQs.hQm = 1;
        ((nw)localObject).hQs.hzO = paramcc;
        ((nw)localObject).publish();
        localObject = String.format("[%s]", new Object[] { ((nw)localObject).hQt.hLS });
      }
      else if (paramcc.fxR())
      {
        localObject = cn(paramcc);
      }
      else if (paramcc.jbB())
      {
        bh.bCz();
        localObject = c.bzD().aLU(paramcc.field_content).nickname;
        localObject = String.format("[%s: %s]", new Object[] { this.context.getString(R.l.gFe), localObject });
      }
      else if (paramcc.dSH())
      {
        localObject = this.context.getString(R.l.gFl);
        com.tencent.mm.modelvideo.v.bOh();
        localObject = String.format("[%s: %s(%s)]", new Object[] { localObject, new u(com.tencent.mm.modelvideo.aa.PX(paramcc.field_imgPath)).getName(), this.context.getString(R.l.gFd) });
      }
      else if ((paramcc.jbG()) || (paramcc.jbH()))
      {
        localObject = String.format("[%s]", new Object[] { this.context.getString(R.l.gFf) });
      }
    }
  }
  
  private String cm(cc paramcc)
  {
    AppMethodBeat.i(34856);
    String str = null;
    if (!au.bwE(this.hRm.field_username)) {
      str = com.tencent.mm.model.aa.getDisplayName(paramcc.field_talker);
    }
    for (;;)
    {
      if (paramcc.field_isSend == 1)
      {
        Log.i("MicroMsg.QQMailHistoryExporter", "isSend");
        str = z.bAO();
      }
      long l = paramcc.getCreateTime();
      paramcc = new SimpleDateFormat("HH:mm").format(new Date(l));
      Object localObject = new StringBuilder("");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("  ");
      ((StringBuilder)localObject).append(paramcc);
      paramcc = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(34856);
      return paramcc;
      localObject = paramcc.field_content;
      int i = br.JG((String)localObject);
      if (i != -1) {
        str = com.tencent.mm.model.aa.getDisplayName(((String)localObject).substring(0, i).trim());
      }
    }
  }
  
  private String cn(cc paramcc)
  {
    AppMethodBeat.i(34855);
    Object localObject2 = paramcc.field_content;
    Object localObject1 = localObject2;
    if (au.bwE(this.hRm.field_username))
    {
      Log.d("MicroMsg.QQMailHistoryExporter", "chatroom msg, parse it");
      int i = br.JG(paramcc.field_content);
      localObject1 = localObject2;
      if (i != -1) {
        localObject1 = paramcc.field_content.substring(i + 1).trim();
      }
    }
    localObject2 = k.b.Hf(Util.processXml((String)localObject1));
    if (localObject2 == null)
    {
      Log.w("MicroMsg.QQMailHistoryExporter", "appmsg content is null");
      paramcc = String.format("[%s]", new Object[] { this.context.getString(R.l.gFc) });
      AppMethodBeat.o(34855);
      return paramcc;
    }
    g localg = h.s(((k.b)localObject2).appId, true, false);
    if ((localg == null) || (Util.isNullOrNil(localg.field_appName)))
    {
      localObject1 = ((k.b)localObject2).appName;
      localObject1 = h.a(this.context, localg, (String)localObject1);
      if (!paramcc.jbJ()) {
        break label232;
      }
      if (!Util.isNullOrNil((String)localObject1)) {
        break label204;
      }
      paramcc = escapeStringForXml(((k.b)localObject2).title);
    }
    for (;;)
    {
      AppMethodBeat.o(34855);
      return paramcc;
      localObject1 = localg.field_appName;
      break;
      label204:
      paramcc = String.format("[%s: %s]", new Object[] { localObject1, escapeStringForXml(((k.b)localObject2).title) });
      continue;
      label232:
      if (paramcc.jbK())
      {
        paramcc = af.c(paramcc, (k.b)localObject2);
        if (!Util.isNullOrNil(paramcc))
        {
          localObject1 = "file://".concat(String.valueOf(paramcc));
          localObject2 = new u(paramcc);
          paramcc = String.format(aelm, new Object[] { ((u)localObject2).getName(), localObject1, paramcc });
        }
      }
      else
      {
        switch (((k.b)localObject2).type)
        {
        case 7: 
        default: 
          paramcc = String.format("[%s]", new Object[] { this.context.getString(R.l.gFc) });
          break;
        case 3: 
          if (Util.isNullOrNil(((k.b)localObject2).description))
          {
            paramcc = String.format("[%s: %s]", new Object[] { this.context.getString(R.l.gFi), escapeStringForXml(((k.b)localObject2).title) });
            continue;
          }
          paramcc = String.format("[%s: %s-%s]", new Object[] { this.context.getString(R.l.gFi), escapeStringForXml(((k.b)localObject2).title), escapeStringForXml(((k.b)localObject2).description) });
          break;
        case 8: 
          paramcc = String.format("[%s]", new Object[] { this.context.getString(R.l.gFf) });
          break;
        case 6: 
          if (Util.isNullOrNil(((k.b)localObject2).description))
          {
            paramcc = String.format("[%s: %s]", new Object[] { this.context.getString(R.l.gFg), escapeStringForXml(((k.b)localObject2).title) });
            continue;
          }
          paramcc = String.format("[%s: %s-%s(%s)]", new Object[] { this.context.getString(R.l.gFg), escapeStringForXml(((k.b)localObject2).title), escapeStringForXml(((k.b)localObject2).description), this.context.getString(R.l.gFd) });
          break;
        case 2: 
          paramcc = af.c(paramcc, (k.b)localObject2);
          if (!Util.isNullOrNil(paramcc))
          {
            localObject1 = "file://".concat(String.valueOf(paramcc));
            localObject2 = new u(paramcc);
            paramcc = String.format(aelm, new Object[] { ((u)localObject2).getName(), localObject1, paramcc });
          }
          break;
        case 1: 
          if (Util.isNullOrNil((String)localObject1))
          {
            paramcc = escapeStringForXml(((k.b)localObject2).title);
            continue;
          }
          paramcc = String.format("[%s: %s]", new Object[] { localObject1, escapeStringForXml(((k.b)localObject2).title) });
          break;
        case 4: 
        case 5: 
          paramcc = String.format("[%s: %s]", new Object[] { escapeStringForXml(((k.b)localObject2).title), escapeStringForXml(((k.b)localObject2).url) });
          break;
        }
      }
      paramcc = "";
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
  
  private String jqc()
  {
    AppMethodBeat.i(34853);
    Object localObject;
    if (!au.bwE(this.hRm.field_username))
    {
      str1 = this.context.getString(R.l.gUO);
      localObject = this.hRm.aSU();
      bh.bCz();
      str1 = String.format(str1, new Object[] { localObject, c.ban().d(4, null) });
      AppMethodBeat.o(34853);
      return str1;
    }
    if (Util.isNullOrNil(this.hRm.field_nickname))
    {
      localObject = com.tencent.mm.model.v.Il(this.hRm.field_username).iterator();
      String str2;
      for (str1 = ""; ((Iterator)localObject).hasNext(); str1 = str1 + str2 + ", ") {
        str2 = com.tencent.mm.model.aa.getDisplayName((String)((Iterator)localObject).next());
      }
    }
    for (String str1 = str1.substring(0, str1.length() - 2);; str1 = this.hRm.aSU())
    {
      str1 = String.format(this.context.getString(R.l.gUN), new Object[] { str1 });
      break;
    }
  }
  
  private static String zI(long paramLong)
  {
    AppMethodBeat.i(34857);
    String str = new SimpleDateFormat("yyyy-MM-dd").format(new Date(paramLong));
    AppMethodBeat.o(34857);
    return str;
  }
  
  public final String jqb()
  {
    AppMethodBeat.i(34852);
    Log.i("MicroMsg.QQMailHistoryExporter", "selectItems.size = %d", new Object[] { Integer.valueOf(this.aehr.size()) });
    if (a.mp(this.context)) {
      this.textSize = a.getScaleSize(this.context);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<div id=\"history\">\n");
    localStringBuilder.append(String.format("<p style=\"font-size:%fem;\">Dear:</p> <br> <p style=\"text-indent:2em; font-size:%fem;\">%s</p> <br>", new Object[] { Float.valueOf(this.textSize), Float.valueOf(this.textSize), jqc() }));
    Iterator localIterator = this.aehr.iterator();
    cc localcc;
    label200:
    Object localObject;
    if (localIterator.hasNext())
    {
      localcc = (cc)localIterator.next();
      if (this.aelj == null)
      {
        this.aelj = zI(localcc.getCreateTime());
        localStringBuilder.append(String.format("<p style=\"text-align:center; font-size:%fem;\"><span style=\"color:#b8b8b8;\">—————  %s  —————</span></p>\n \n", new Object[] { Float.valueOf(this.textSize), this.aelj }));
        if (!localcc.iYl()) {
          break label510;
        }
        if (!localcc.iYl()) {
          break label504;
        }
        if (localcc.field_isSend != 1) {
          break label360;
        }
        localObject = String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", new Object[] { Float.valueOf(this.textSize), cm(localcc), Float.valueOf(this.textSize), escapeStringForXml(localcc.field_content) });
      }
    }
    for (;;)
    {
      localStringBuilder.append((String)localObject);
      break;
      localObject = zI(localcc.getCreateTime());
      if (((String)localObject).equals(this.aelj)) {
        break label200;
      }
      this.aelj = ((String)localObject);
      localStringBuilder.append("<br>");
      localStringBuilder.append(String.format("<p style=\"text-align:center; font-size:%fem;\"><span style=\"color:#b8b8b8;\">—————  %s  —————</span></p>\n \n", new Object[] { Float.valueOf(this.textSize), this.aelj }));
      break label200;
      label360:
      if (!au.bwE(this.hRm.field_username))
      {
        localObject = String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", new Object[] { Float.valueOf(this.textSize), cm(localcc), Float.valueOf(this.textSize), escapeStringForXml(localcc.field_content) });
      }
      else
      {
        int i = br.JG(localcc.field_content);
        if (i != -1)
        {
          localObject = String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", new Object[] { Float.valueOf(this.textSize), cm(localcc), Float.valueOf(this.textSize), escapeStringForXml(localcc.field_content.substring(i + 1).trim()) });
          continue;
          label504:
          localObject = null;
          continue;
          label510:
          if (localcc.iYk())
          {
            if (localcc.iYk())
            {
              long l1 = localcc.field_msgId;
              long l2 = localcc.field_msgSvrId;
              String str = af.cy(localcc.field_talker, l1);
              localObject = str;
              if (Util.isNullOrNil(str)) {
                localObject = af.cz(localcc.field_talker, l2);
              }
              localObject = y.n((String)localObject, false);
              Log.i("MicroMsg.QQMailHistoryExporter", "hdPath[%s]", new Object[] { localObject });
              if (!Util.isNullOrNil((String)localObject))
              {
                str = "file://".concat(String.valueOf(localObject));
                u localu = new u((String)localObject);
                localObject = String.format(aelm, new Object[] { localu.getName(), str, localObject });
              }
            }
            for (localObject = String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", new Object[] { Float.valueOf(this.textSize), cm(localcc), Float.valueOf(this.textSize), localObject });; localObject = null)
            {
              localStringBuilder.append((String)localObject);
              break;
            }
          }
          if (localcc.fxR())
          {
            localObject = k.b.Hf(localcc.field_content);
            if ((localObject != null) && ((((k.b)localObject).type == 53) || (((k.b)localObject).type == 57)))
            {
              if ((localObject != null) && ((((k.b)localObject).type == 53) || (((k.b)localObject).type == 57))) {}
              for (localObject = String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", new Object[] { Float.valueOf(this.textSize), cm(localcc), Float.valueOf(this.textSize), escapeStringForXml(((k.b)localObject).title) });; localObject = null)
              {
                localStringBuilder.append((String)localObject);
                break;
              }
            }
            localStringBuilder.append(cl(localcc));
            break;
          }
          localStringBuilder.append(cl(localcc));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.QQMailHistoryExporter
 * JD-Core Version:    0.7.0.1
 */