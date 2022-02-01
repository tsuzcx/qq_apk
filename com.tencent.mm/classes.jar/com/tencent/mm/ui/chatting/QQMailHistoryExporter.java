package com.tencent.mm.ui.chatting;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.a.kp;
import com.tencent.mm.g.a.kp.b;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bl.a;
import com.tencent.mm.vfs.e;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public final class QQMailHistoryExporter
{
  private static final String Gqt;
  private static final char[] lMb;
  private static final String[] lMc;
  private List<bl> GmU;
  private String Gqq = null;
  private Context context;
  private af dpQ = null;
  private float textSize = 1.0F;
  
  static
  {
    AppMethodBeat.i(34858);
    Gqt = "<img id=\"%d:%d\" src=\"%s\" height=\"100\" onclick=\"" + x.kG("weixin://img_onclick/", "this.id + '@@' + this.src") + "\"></img>";
    lMb = new char[] { 60, 62, 34, 39, 38, 10 };
    lMc = new String[] { "&lt;", "&gt;", "&quot;", "&apos;", "&amp;", "<br />" };
    AppMethodBeat.o(34858);
  }
  
  public QQMailHistoryExporter(Context paramContext, List<bl> paramList, af paramaf)
  {
    this.context = paramContext;
    this.GmU = paramList;
    this.dpQ = paramaf;
  }
  
  private static String aGf(String paramString)
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
      int j = lMb.length - 1;
      for (;;)
      {
        int k = m;
        if (j >= 0)
        {
          if (lMb[j] == c)
          {
            localStringBuffer.append(lMc[j]);
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
  
  private String bj(bl parambl)
  {
    AppMethodBeat.i(34854);
    Object localObject = null;
    if (parambl.eJN()) {
      localObject = String.format("[%s]", new Object[] { this.context.getString(2131758203) });
    }
    for (;;)
    {
      ad.d("MicroMsg.QQMailHistoryExporter", "formatOtherMsg, msgStr = %s", new Object[] { localObject });
      parambl = String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", new Object[] { Float.valueOf(this.textSize), bk(parambl), Float.valueOf(this.textSize), localObject });
      AppMethodBeat.o(34854);
      return parambl;
      if (parambl.eLT())
      {
        if (parambl.field_isSend == 1) {
          localObject = this.context.getString(2131758201);
        } else {
          localObject = this.context.getString(2131758200);
        }
      }
      else if (parambl.cxD())
      {
        localObject = new kp();
        ((kp)localObject).dpf.doZ = 1;
        ((kp)localObject).dpf.dbD = parambl;
        com.tencent.mm.sdk.b.a.ESL.l((b)localObject);
        localObject = String.format("[%s]", new Object[] { ((kp)localObject).dpg.dld });
      }
      else if (parambl.cxB())
      {
        localObject = bl(parambl);
      }
      else if (parambl.eLX())
      {
        az.arV();
        localObject = c.apO().agC(parambl.field_content).nickname;
        localObject = String.format("[%s: %s]", new Object[] { this.context.getString(2131758195), localObject });
      }
      else if (parambl.cjM())
      {
        localObject = this.context.getString(2131758202);
        o.aCI();
        localObject = String.format("[%s: %s(%s)]", new Object[] { localObject, new e(t.zQ(parambl.field_imgPath)).getName(), this.context.getString(2131758194) });
      }
      else if ((parambl.eLY()) || (parambl.eLZ()))
      {
        localObject = String.format("[%s]", new Object[] { this.context.getString(2131758196) });
      }
    }
  }
  
  private String bk(bl parambl)
  {
    AppMethodBeat.i(34856);
    String str = null;
    if (!w.pF(this.dpQ.field_username)) {
      str = v.sh(parambl.field_talker);
    }
    for (;;)
    {
      if (parambl.field_isSend == 1)
      {
        ad.i("MicroMsg.QQMailHistoryExporter", "isSend");
        str = u.aqI();
      }
      long l = parambl.field_createTime;
      parambl = new SimpleDateFormat("HH:mm").format(new Date(l));
      Object localObject = new StringBuilder("");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("  ");
      ((StringBuilder)localObject).append(parambl);
      parambl = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(34856);
      return parambl;
      localObject = parambl.field_content;
      int i = bi.uc((String)localObject);
      if (i != -1) {
        str = v.sh(((String)localObject).substring(0, i).trim());
      }
    }
  }
  
  private String bl(bl parambl)
  {
    AppMethodBeat.i(34855);
    Object localObject2 = parambl.field_content;
    Object localObject1 = localObject2;
    if (w.pF(this.dpQ.field_username))
    {
      ad.d("MicroMsg.QQMailHistoryExporter", "chatroom msg, parse it");
      int i = bi.uc(parambl.field_content);
      localObject1 = localObject2;
      if (i != -1) {
        localObject1 = parambl.field_content.substring(i + 1).trim();
      }
    }
    localObject2 = k.b.rx(bt.aGg((String)localObject1));
    if (localObject2 == null)
    {
      ad.w("MicroMsg.QQMailHistoryExporter", "appmsg content is null");
      parambl = String.format("[%s]", new Object[] { this.context.getString(2131758193) });
      AppMethodBeat.o(34855);
      return parambl;
    }
    g localg = com.tencent.mm.pluginsdk.model.app.h.j(((k.b)localObject2).appId, true, false);
    if ((localg == null) || (bt.isNullOrNil(localg.field_appName)))
    {
      localObject1 = ((k.b)localObject2).appName;
      localObject1 = com.tencent.mm.pluginsdk.model.app.h.a(this.context, localg, (String)localObject1);
      if (!parambl.eMa()) {
        break label233;
      }
      if (!bt.isNullOrNil((String)localObject1)) {
        break label204;
      }
      parambl = aGf(((k.b)localObject2).title);
    }
    for (;;)
    {
      AppMethodBeat.o(34855);
      return parambl;
      localObject1 = localg.field_appName;
      break;
      label204:
      parambl = String.format("[%s: %s]", new Object[] { localObject1, aGf(((k.b)localObject2).title) });
      continue;
      label233:
      if (parambl.eMb())
      {
        localObject1 = ac.b(parambl, (k.b)localObject2);
        if (!bt.isNullOrNil((String)localObject1))
        {
          localObject2 = "file://".concat(String.valueOf(localObject1));
          parambl = String.format(Gqt, new Object[] { Long.valueOf(parambl.field_msgId), Long.valueOf(parambl.field_msgSvrId), localObject2, localObject1 });
        }
      }
      else
      {
        switch (((k.b)localObject2).type)
        {
        case 7: 
        default: 
          parambl = String.format("[%s]", new Object[] { this.context.getString(2131758193) });
          break;
        case 3: 
          if (bt.isNullOrNil(((k.b)localObject2).description))
          {
            parambl = String.format("[%s: %s]", new Object[] { this.context.getString(2131758199), aGf(((k.b)localObject2).title) });
            continue;
          }
          parambl = String.format("[%s: %s-%s]", new Object[] { this.context.getString(2131758199), aGf(((k.b)localObject2).title), aGf(((k.b)localObject2).description) });
          break;
        case 8: 
          parambl = String.format("[%s]", new Object[] { this.context.getString(2131758196) });
          break;
        case 6: 
          if (bt.isNullOrNil(((k.b)localObject2).description))
          {
            parambl = String.format("[%s: %s]", new Object[] { this.context.getString(2131758197), aGf(((k.b)localObject2).title) });
            continue;
          }
          parambl = String.format("[%s: %s-%s(%s)]", new Object[] { this.context.getString(2131758197), aGf(((k.b)localObject2).title), aGf(((k.b)localObject2).description), this.context.getString(2131758194) });
          break;
        case 2: 
          localObject1 = ac.b(parambl, (k.b)localObject2);
          if (!bt.isNullOrNil((String)localObject1))
          {
            localObject2 = "file://".concat(String.valueOf(localObject1));
            parambl = String.format(Gqt, new Object[] { Long.valueOf(parambl.field_msgId), Long.valueOf(parambl.field_msgSvrId), localObject2, localObject1 });
          }
          break;
        case 1: 
          if (bt.isNullOrNil((String)localObject1))
          {
            parambl = aGf(((k.b)localObject2).title);
            continue;
          }
          parambl = String.format("[%s: %s]", new Object[] { localObject1, aGf(((k.b)localObject2).title) });
          break;
        case 4: 
        case 5: 
          parambl = String.format("[%s: %s]", new Object[] { aGf(((k.b)localObject2).title), aGf(((k.b)localObject2).url) });
          break;
        }
      }
      parambl = "";
    }
  }
  
  private String eWd()
  {
    AppMethodBeat.i(34853);
    Object localObject;
    if (!w.pF(this.dpQ.field_username))
    {
      str1 = this.context.getString(2131763060);
      localObject = this.dpQ.ZW();
      az.arV();
      str1 = String.format(str1, new Object[] { localObject, c.afk().get(4, null) });
      AppMethodBeat.o(34853);
      return str1;
    }
    if (bt.isNullOrNil(this.dpQ.field_nickname))
    {
      localObject = q.rW(this.dpQ.field_username).iterator();
      String str2;
      for (str1 = ""; ((Iterator)localObject).hasNext(); str1 = str1 + str2 + ", ") {
        str2 = v.sh((String)((Iterator)localObject).next());
      }
    }
    for (String str1 = str1.substring(0, str1.length() - 2);; str1 = this.dpQ.ZW())
    {
      str1 = String.format(this.context.getString(2131763059), new Object[] { str1 });
      break;
    }
  }
  
  private static String wy(long paramLong)
  {
    AppMethodBeat.i(34857);
    String str = new SimpleDateFormat("yyyy-MM-dd").format(new Date(paramLong));
    AppMethodBeat.o(34857);
    return str;
  }
  
  public final String eWc()
  {
    AppMethodBeat.i(34852);
    ad.i("MicroMsg.QQMailHistoryExporter", "selectItems.size = %d", new Object[] { Integer.valueOf(this.GmU.size()) });
    if (com.tencent.mm.cd.a.hS(this.context)) {
      this.textSize = com.tencent.mm.cd.a.dT(this.context);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<div id=\"history\">\n");
    localStringBuilder.append(String.format("<p style=\"font-size:%fem;\">Dear:</p> <br> <p style=\"text-indent:2em; font-size:%fem;\">%s</p> <br>", new Object[] { Float.valueOf(this.textSize), Float.valueOf(this.textSize), eWd() }));
    Iterator localIterator = this.GmU.iterator();
    bl localbl;
    label200:
    Object localObject;
    if (localIterator.hasNext())
    {
      localbl = (bl)localIterator.next();
      if (this.Gqq == null)
      {
        this.Gqq = wy(localbl.field_createTime);
        localStringBuilder.append(String.format("<p style=\"text-align:center; font-size:%fem;\"><span style=\"color:#b8b8b8;\">—————  %s  —————</span></p>\n \n", new Object[] { Float.valueOf(this.textSize), this.Gqq }));
        if (!localbl.isText()) {
          break label510;
        }
        if (!localbl.isText()) {
          break label504;
        }
        if (localbl.field_isSend != 1) {
          break label360;
        }
        localObject = String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", new Object[] { Float.valueOf(this.textSize), bk(localbl), Float.valueOf(this.textSize), aGf(localbl.field_content) });
      }
    }
    for (;;)
    {
      localStringBuilder.append((String)localObject);
      break;
      localObject = wy(localbl.field_createTime);
      if (((String)localObject).equals(this.Gqq)) {
        break label200;
      }
      this.Gqq = ((String)localObject);
      localStringBuilder.append("<br>");
      localStringBuilder.append(String.format("<p style=\"text-align:center; font-size:%fem;\"><span style=\"color:#b8b8b8;\">—————  %s  —————</span></p>\n \n", new Object[] { Float.valueOf(this.textSize), this.Gqq }));
      break label200;
      label360:
      if (!w.pF(this.dpQ.field_username))
      {
        localObject = String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", new Object[] { Float.valueOf(this.textSize), bk(localbl), Float.valueOf(this.textSize), aGf(localbl.field_content) });
      }
      else
      {
        int i = bi.uc(localbl.field_content);
        if (i != -1)
        {
          localObject = String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", new Object[] { Float.valueOf(this.textSize), bk(localbl), Float.valueOf(this.textSize), aGf(localbl.field_content.substring(i + 1).trim()) });
          continue;
          label504:
          localObject = null;
          continue;
          label510:
          if (localbl.eJO())
          {
            if (localbl.eJO())
            {
              long l1 = localbl.field_msgId;
              long l2 = localbl.field_msgSvrId;
              String str = ac.ww(l1);
              localObject = str;
              if (bt.isNullOrNil(str)) {
                localObject = ac.wx(l2);
              }
              ad.d("MicroMsg.QQMailHistoryExporter", "hdPath[%s]", new Object[] { localObject });
              if (!bt.isNullOrNil((String)localObject))
              {
                str = "file://".concat(String.valueOf(localObject));
                localObject = String.format(Gqt, new Object[] { Long.valueOf(localbl.field_msgId), Long.valueOf(localbl.field_msgSvrId), str, localObject });
              }
            }
            for (localObject = String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", new Object[] { Float.valueOf(this.textSize), bk(localbl), Float.valueOf(this.textSize), localObject });; localObject = null)
            {
              localStringBuilder.append((String)localObject);
              break;
            }
          }
          if (localbl.cxB())
          {
            localObject = k.b.rx(localbl.field_content);
            if ((localObject != null) && ((((k.b)localObject).type == 53) || (((k.b)localObject).type == 57)))
            {
              if ((localObject != null) && ((((k.b)localObject).type == 53) || (((k.b)localObject).type == 57))) {}
              for (localObject = String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", new Object[] { Float.valueOf(this.textSize), bk(localbl), Float.valueOf(this.textSize), aGf(((k.b)localObject).title) });; localObject = null)
              {
                localStringBuilder.append((String)localObject);
                break;
              }
            }
            localStringBuilder.append(bj(localbl));
            break;
          }
          localStringBuilder.append(bj(localbl));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.QQMailHistoryExporter
 * JD-Core Version:    0.7.0.1
 */