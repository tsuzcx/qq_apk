package com.tencent.mm.ui.chatting;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.a.ky;
import com.tencent.mm.g.a.ky.b;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.dy;
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
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bo.a;
import com.tencent.mm.vfs.e;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public final class QQMailHistoryExporter
{
  private static final String HQl;
  private static final char[] mnY;
  private static final String[] mnZ;
  private List<bo> HMK;
  private String HQi = null;
  private Context context;
  private ai dnB = null;
  private float textSize = 1.0F;
  
  static
  {
    AppMethodBeat.i(34858);
    HQl = "<img id=\"%d:%d\" src=\"%s\" height=\"100\" onclick=\"" + x.ld("weixin://img_onclick/", "this.id + '@@' + this.src") + "\"></img>";
    mnY = new char[] { 60, 62, 34, 39, 38, 10 };
    mnZ = new String[] { "&lt;", "&gt;", "&quot;", "&apos;", "&amp;", "<br />" };
    AppMethodBeat.o(34858);
  }
  
  public QQMailHistoryExporter(Context paramContext, List<bo> paramList, ai paramai)
  {
    this.context = paramContext;
    this.HMK = paramList;
    this.dnB = paramai;
  }
  
  private static String Bb(long paramLong)
  {
    AppMethodBeat.i(34857);
    String str = new SimpleDateFormat("yyyy-MM-dd").format(new Date(paramLong));
    AppMethodBeat.o(34857);
    return str;
  }
  
  private static String aLw(String paramString)
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
      int j = mnY.length - 1;
      for (;;)
      {
        int k = m;
        if (j >= 0)
        {
          if (mnY[j] == c)
          {
            localStringBuffer.append(mnZ[j]);
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
  
  private String bl(bo parambo)
  {
    AppMethodBeat.i(34854);
    Object localObject = null;
    if (parambo.eZl()) {
      localObject = String.format("[%s]", new Object[] { this.context.getString(2131758203) });
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.QQMailHistoryExporter", "formatOtherMsg, msgStr = %s", new Object[] { localObject });
      parambo = String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", new Object[] { Float.valueOf(this.textSize), bm(parambo), Float.valueOf(this.textSize), localObject });
      AppMethodBeat.o(34854);
      return parambo;
      if (parambo.fbx())
      {
        if (parambo.field_isSend == 1) {
          localObject = this.context.getString(2131758201);
        } else {
          localObject = this.context.getString(2131758200);
        }
      }
      else if (parambo.cKP())
      {
        localObject = new ky();
        ((ky)localObject).dmP.dmJ = 1;
        ((ky)localObject).dmP.cZc = parambo;
        com.tencent.mm.sdk.b.a.GpY.l((b)localObject);
        localObject = String.format("[%s]", new Object[] { ((ky)localObject).dmQ.diM });
      }
      else if (parambo.cKN())
      {
        localObject = bn(parambo);
      }
      else if (parambo.fbB())
      {
        az.ayM();
        localObject = c.awD().alw(parambo.field_content).nickname;
        localObject = String.format("[%s: %s]", new Object[] { this.context.getString(2131758195), localObject });
      }
      else if (parambo.crt())
      {
        localObject = this.context.getString(2131758202);
        o.aJy();
        localObject = String.format("[%s: %s(%s)]", new Object[] { localObject, new e(t.DV(parambo.field_imgPath)).getName(), this.context.getString(2131758194) });
      }
      else if ((parambo.fbC()) || (parambo.fbD()))
      {
        localObject = String.format("[%s]", new Object[] { this.context.getString(2131758196) });
      }
    }
  }
  
  private String bm(bo parambo)
  {
    AppMethodBeat.i(34856);
    String str = null;
    if (!w.sQ(this.dnB.field_username)) {
      str = v.wk(parambo.field_talker);
    }
    for (;;)
    {
      if (parambo.field_isSend == 1)
      {
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.QQMailHistoryExporter", "isSend");
        str = u.axy();
      }
      long l = parambo.field_createTime;
      parambo = new SimpleDateFormat("HH:mm").format(new Date(l));
      Object localObject = new StringBuilder("");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("  ");
      ((StringBuilder)localObject).append(parambo);
      parambo = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(34856);
      return parambo;
      localObject = parambo.field_content;
      int i = bi.yi((String)localObject);
      if (i != -1) {
        str = v.wk(((String)localObject).substring(0, i).trim());
      }
    }
  }
  
  private String bn(bo parambo)
  {
    AppMethodBeat.i(34855);
    Object localObject2 = parambo.field_content;
    Object localObject1 = localObject2;
    if (w.sQ(this.dnB.field_username))
    {
      com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.QQMailHistoryExporter", "chatroom msg, parse it");
      int i = bi.yi(parambo.field_content);
      localObject1 = localObject2;
      if (i != -1) {
        localObject1 = parambo.field_content.substring(i + 1).trim();
      }
    }
    localObject2 = k.b.vA(bs.aLx((String)localObject1));
    if (localObject2 == null)
    {
      com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.QQMailHistoryExporter", "appmsg content is null");
      parambo = String.format("[%s]", new Object[] { this.context.getString(2131758193) });
      AppMethodBeat.o(34855);
      return parambo;
    }
    g localg = com.tencent.mm.pluginsdk.model.app.h.k(((k.b)localObject2).appId, true, false);
    if ((localg == null) || (bs.isNullOrNil(localg.field_appName)))
    {
      localObject1 = ((k.b)localObject2).appName;
      localObject1 = com.tencent.mm.pluginsdk.model.app.h.a(this.context, localg, (String)localObject1);
      if (!parambo.fbF()) {
        break label233;
      }
      if (!bs.isNullOrNil((String)localObject1)) {
        break label204;
      }
      parambo = aLw(((k.b)localObject2).title);
    }
    for (;;)
    {
      AppMethodBeat.o(34855);
      return parambo;
      localObject1 = localg.field_appName;
      break;
      label204:
      parambo = String.format("[%s: %s]", new Object[] { localObject1, aLw(((k.b)localObject2).title) });
      continue;
      label233:
      if (parambo.fbG())
      {
        localObject1 = ac.b(parambo, (k.b)localObject2);
        if (!bs.isNullOrNil((String)localObject1))
        {
          localObject2 = "file://".concat(String.valueOf(localObject1));
          parambo = String.format(HQl, new Object[] { Long.valueOf(parambo.field_msgId), Long.valueOf(parambo.field_msgSvrId), localObject2, localObject1 });
        }
      }
      else
      {
        switch (((k.b)localObject2).type)
        {
        case 7: 
        default: 
          parambo = String.format("[%s]", new Object[] { this.context.getString(2131758193) });
          break;
        case 3: 
          if (bs.isNullOrNil(((k.b)localObject2).description))
          {
            parambo = String.format("[%s: %s]", new Object[] { this.context.getString(2131758199), aLw(((k.b)localObject2).title) });
            continue;
          }
          parambo = String.format("[%s: %s-%s]", new Object[] { this.context.getString(2131758199), aLw(((k.b)localObject2).title), aLw(((k.b)localObject2).description) });
          break;
        case 8: 
          parambo = String.format("[%s]", new Object[] { this.context.getString(2131758196) });
          break;
        case 6: 
          if (bs.isNullOrNil(((k.b)localObject2).description))
          {
            parambo = String.format("[%s: %s]", new Object[] { this.context.getString(2131758197), aLw(((k.b)localObject2).title) });
            continue;
          }
          parambo = String.format("[%s: %s-%s(%s)]", new Object[] { this.context.getString(2131758197), aLw(((k.b)localObject2).title), aLw(((k.b)localObject2).description), this.context.getString(2131758194) });
          break;
        case 2: 
          localObject1 = ac.b(parambo, (k.b)localObject2);
          if (!bs.isNullOrNil((String)localObject1))
          {
            localObject2 = "file://".concat(String.valueOf(localObject1));
            parambo = String.format(HQl, new Object[] { Long.valueOf(parambo.field_msgId), Long.valueOf(parambo.field_msgSvrId), localObject2, localObject1 });
          }
          break;
        case 1: 
          if (bs.isNullOrNil((String)localObject1))
          {
            parambo = aLw(((k.b)localObject2).title);
            continue;
          }
          parambo = String.format("[%s: %s]", new Object[] { localObject1, aLw(((k.b)localObject2).title) });
          break;
        case 4: 
        case 5: 
          parambo = String.format("[%s: %s]", new Object[] { aLw(((k.b)localObject2).title), aLw(((k.b)localObject2).url) });
          break;
        }
      }
      parambo = "";
    }
  }
  
  private String flP()
  {
    AppMethodBeat.i(34853);
    Object localObject;
    if (!w.sQ(this.dnB.field_username))
    {
      str1 = this.context.getString(2131763060);
      localObject = this.dnB.aaR();
      az.ayM();
      str1 = String.format(str1, new Object[] { localObject, c.agA().get(4, null) });
      AppMethodBeat.o(34853);
      return str1;
    }
    if (bs.isNullOrNil(this.dnB.field_nickname))
    {
      localObject = q.vZ(this.dnB.field_username).iterator();
      String str2;
      for (str1 = ""; ((Iterator)localObject).hasNext(); str1 = str1 + str2 + ", ") {
        str2 = v.wk((String)((Iterator)localObject).next());
      }
    }
    for (String str1 = str1.substring(0, str1.length() - 2);; str1 = this.dnB.aaR())
    {
      str1 = String.format(this.context.getString(2131763059), new Object[] { str1 });
      break;
    }
  }
  
  public final String flO()
  {
    AppMethodBeat.i(34852);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.QQMailHistoryExporter", "selectItems.size = %d", new Object[] { Integer.valueOf(this.HMK.size()) });
    if (com.tencent.mm.cc.a.id(this.context)) {
      this.textSize = com.tencent.mm.cc.a.eb(this.context);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<div id=\"history\">\n");
    localStringBuilder.append(String.format("<p style=\"font-size:%fem;\">Dear:</p> <br> <p style=\"text-indent:2em; font-size:%fem;\">%s</p> <br>", new Object[] { Float.valueOf(this.textSize), Float.valueOf(this.textSize), flP() }));
    Iterator localIterator = this.HMK.iterator();
    bo localbo;
    label200:
    Object localObject;
    if (localIterator.hasNext())
    {
      localbo = (bo)localIterator.next();
      if (this.HQi == null)
      {
        this.HQi = Bb(localbo.field_createTime);
        localStringBuilder.append(String.format("<p style=\"text-align:center; font-size:%fem;\"><span style=\"color:#b8b8b8;\">—————  %s  —————</span></p>\n \n", new Object[] { Float.valueOf(this.textSize), this.HQi }));
        if (!localbo.isText()) {
          break label510;
        }
        if (!localbo.isText()) {
          break label504;
        }
        if (localbo.field_isSend != 1) {
          break label360;
        }
        localObject = String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", new Object[] { Float.valueOf(this.textSize), bm(localbo), Float.valueOf(this.textSize), aLw(localbo.field_content) });
      }
    }
    for (;;)
    {
      localStringBuilder.append((String)localObject);
      break;
      localObject = Bb(localbo.field_createTime);
      if (((String)localObject).equals(this.HQi)) {
        break label200;
      }
      this.HQi = ((String)localObject);
      localStringBuilder.append("<br>");
      localStringBuilder.append(String.format("<p style=\"text-align:center; font-size:%fem;\"><span style=\"color:#b8b8b8;\">—————  %s  —————</span></p>\n \n", new Object[] { Float.valueOf(this.textSize), this.HQi }));
      break label200;
      label360:
      if (!w.sQ(this.dnB.field_username))
      {
        localObject = String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", new Object[] { Float.valueOf(this.textSize), bm(localbo), Float.valueOf(this.textSize), aLw(localbo.field_content) });
      }
      else
      {
        int i = bi.yi(localbo.field_content);
        if (i != -1)
        {
          localObject = String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", new Object[] { Float.valueOf(this.textSize), bm(localbo), Float.valueOf(this.textSize), aLw(localbo.field_content.substring(i + 1).trim()) });
          continue;
          label504:
          localObject = null;
          continue;
          label510:
          if (localbo.eZm())
          {
            if (localbo.eZm())
            {
              long l1 = localbo.field_msgId;
              long l2 = localbo.field_msgSvrId;
              String str = ac.AZ(l1);
              localObject = str;
              if (bs.isNullOrNil(str)) {
                localObject = ac.Ba(l2);
              }
              com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.QQMailHistoryExporter", "hdPath[%s]", new Object[] { localObject });
              if (!bs.isNullOrNil((String)localObject))
              {
                str = "file://".concat(String.valueOf(localObject));
                localObject = String.format(HQl, new Object[] { Long.valueOf(localbo.field_msgId), Long.valueOf(localbo.field_msgSvrId), str, localObject });
              }
            }
            for (localObject = String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", new Object[] { Float.valueOf(this.textSize), bm(localbo), Float.valueOf(this.textSize), localObject });; localObject = null)
            {
              localStringBuilder.append((String)localObject);
              break;
            }
          }
          if (localbo.cKN())
          {
            localObject = k.b.vA(localbo.field_content);
            if ((localObject != null) && ((((k.b)localObject).type == 53) || (((k.b)localObject).type == 57)))
            {
              if ((localObject != null) && ((((k.b)localObject).type == 53) || (((k.b)localObject).type == 57))) {}
              for (localObject = String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", new Object[] { Float.valueOf(this.textSize), bm(localbo), Float.valueOf(this.textSize), aLw(((k.b)localObject).title) });; localObject = null)
              {
                localStringBuilder.append((String)localObject);
                break;
              }
            }
            localStringBuilder.append(bl(localbo));
            break;
          }
          localStringBuilder.append(bl(localbo));
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