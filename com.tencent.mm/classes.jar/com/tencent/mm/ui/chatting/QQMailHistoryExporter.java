package com.tencent.mm.ui.chatting;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.a.lh;
import com.tencent.mm.g.a.lh.b;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.bu.a;
import com.tencent.mm.vfs.e;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public final class QQMailHistoryExporter
{
  private static final String JEa;
  private static final char[] mOA;
  private static final String[] mOB;
  private List<bu> JAA;
  private String JDX = null;
  private Context context;
  private am dzp = null;
  private float textSize = 1.0F;
  
  static
  {
    AppMethodBeat.i(34858);
    JEa = "<img id=\"%s\" src=\"%s\" height=\"100\" onclick=\"" + x.lC("weixin://img_onclick/", "this.id + '@@' + this.src") + "\"></img>";
    mOA = new char[] { 60, 62, 34, 39, 38, 10 };
    mOB = new String[] { "&lt;", "&gt;", "&quot;", "&apos;", "&amp;", "<br />" };
    AppMethodBeat.o(34858);
  }
  
  public QQMailHistoryExporter(Context paramContext, List<bu> paramList, am paramam)
  {
    this.context = paramContext;
    this.JAA = paramList;
    this.dzp = paramam;
  }
  
  private static String DP(long paramLong)
  {
    AppMethodBeat.i(34857);
    String str = new SimpleDateFormat("yyyy-MM-dd").format(new Date(paramLong));
    AppMethodBeat.o(34857);
    return str;
  }
  
  private static String aRc(String paramString)
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
      int j = mOA.length - 1;
      for (;;)
      {
        int k = m;
        if (j >= 0)
        {
          if (mOA[j] == c)
          {
            localStringBuffer.append(mOB[j]);
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
  
  private String bp(bu parambu)
  {
    AppMethodBeat.i(34854);
    Object localObject = null;
    if (parambu.fph()) {
      localObject = String.format("[%s]", new Object[] { this.context.getString(2131758203) });
    }
    for (;;)
    {
      ad.d("MicroMsg.QQMailHistoryExporter", "formatOtherMsg, msgStr = %s", new Object[] { localObject });
      parambu = String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", new Object[] { Float.valueOf(this.textSize), bq(parambu), Float.valueOf(this.textSize), localObject });
      AppMethodBeat.o(34854);
      return parambu;
      if (parambu.frA())
      {
        if (parambu.field_isSend == 1) {
          localObject = this.context.getString(2131758201);
        } else {
          localObject = this.context.getString(2131758200);
        }
      }
      else if (parambu.cTe())
      {
        localObject = new lh();
        ((lh)localObject).dyD.dyx = 1;
        ((lh)localObject).dyD.dku = parambu;
        com.tencent.mm.sdk.b.a.IbL.l((b)localObject);
        localObject = String.format("[%s]", new Object[] { ((lh)localObject).dyE.duy });
      }
      else if (parambu.cTc())
      {
        localObject = br(parambu);
      }
      else if (parambu.frE())
      {
        ba.aBQ();
        localObject = c.azs().aqk(parambu.field_content).nickname;
        localObject = String.format("[%s: %s]", new Object[] { this.context.getString(2131758195), localObject });
      }
      else if (parambu.cxf())
      {
        localObject = this.context.getString(2131758202);
        o.aMJ();
        localObject = String.format("[%s: %s(%s)]", new Object[] { localObject, new e(t.Hh(parambu.field_imgPath)).getName(), this.context.getString(2131758194) });
      }
      else if ((parambu.frG()) || (parambu.frH()))
      {
        localObject = String.format("[%s]", new Object[] { this.context.getString(2131758196) });
      }
    }
  }
  
  private String bq(bu parambu)
  {
    AppMethodBeat.i(34856);
    String str = null;
    if (!w.vF(this.dzp.field_username)) {
      str = v.zf(parambu.field_talker);
    }
    for (;;)
    {
      if (parambu.field_isSend == 1)
      {
        ad.i("MicroMsg.QQMailHistoryExporter", "isSend");
        str = u.aAo();
      }
      long l = parambu.field_createTime;
      parambu = new SimpleDateFormat("HH:mm").format(new Date(l));
      Object localObject = new StringBuilder("");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("  ");
      ((StringBuilder)localObject).append(parambu);
      parambu = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(34856);
      return parambu;
      localObject = parambu.field_content;
      int i = bj.Bh((String)localObject);
      if (i != -1) {
        str = v.zf(((String)localObject).substring(0, i).trim());
      }
    }
  }
  
  private String br(bu parambu)
  {
    AppMethodBeat.i(34855);
    Object localObject2 = parambu.field_content;
    Object localObject1 = localObject2;
    if (w.vF(this.dzp.field_username))
    {
      ad.d("MicroMsg.QQMailHistoryExporter", "chatroom msg, parse it");
      int i = bj.Bh(parambu.field_content);
      localObject1 = localObject2;
      if (i != -1) {
        localObject1 = parambu.field_content.substring(i + 1).trim();
      }
    }
    localObject2 = k.b.yr(bt.aRd((String)localObject1));
    if (localObject2 == null)
    {
      ad.w("MicroMsg.QQMailHistoryExporter", "appmsg content is null");
      parambu = String.format("[%s]", new Object[] { this.context.getString(2131758193) });
      AppMethodBeat.o(34855);
      return parambu;
    }
    g localg = h.m(((k.b)localObject2).appId, true, false);
    if ((localg == null) || (bt.isNullOrNil(localg.field_appName)))
    {
      localObject1 = ((k.b)localObject2).appName;
      localObject1 = h.a(this.context, localg, (String)localObject1);
      if (!parambu.frJ()) {
        break label233;
      }
      if (!bt.isNullOrNil((String)localObject1)) {
        break label204;
      }
      parambu = aRc(((k.b)localObject2).title);
    }
    for (;;)
    {
      AppMethodBeat.o(34855);
      return parambu;
      localObject1 = localg.field_appName;
      break;
      label204:
      parambu = String.format("[%s: %s]", new Object[] { localObject1, aRc(((k.b)localObject2).title) });
      continue;
      label233:
      if (parambu.frK())
      {
        parambu = ac.d(parambu, (k.b)localObject2);
        if (!bt.isNullOrNil(parambu))
        {
          localObject1 = "file://".concat(String.valueOf(parambu));
          localObject2 = new e(parambu);
          parambu = String.format(JEa, new Object[] { ((e)localObject2).getName(), localObject1, parambu });
        }
      }
      else
      {
        switch (((k.b)localObject2).type)
        {
        case 7: 
        default: 
          parambu = String.format("[%s]", new Object[] { this.context.getString(2131758193) });
          break;
        case 3: 
          if (bt.isNullOrNil(((k.b)localObject2).description))
          {
            parambu = String.format("[%s: %s]", new Object[] { this.context.getString(2131758199), aRc(((k.b)localObject2).title) });
            continue;
          }
          parambu = String.format("[%s: %s-%s]", new Object[] { this.context.getString(2131758199), aRc(((k.b)localObject2).title), aRc(((k.b)localObject2).description) });
          break;
        case 8: 
          parambu = String.format("[%s]", new Object[] { this.context.getString(2131758196) });
          break;
        case 6: 
          if (bt.isNullOrNil(((k.b)localObject2).description))
          {
            parambu = String.format("[%s: %s]", new Object[] { this.context.getString(2131758197), aRc(((k.b)localObject2).title) });
            continue;
          }
          parambu = String.format("[%s: %s-%s(%s)]", new Object[] { this.context.getString(2131758197), aRc(((k.b)localObject2).title), aRc(((k.b)localObject2).description), this.context.getString(2131758194) });
          break;
        case 2: 
          parambu = ac.d(parambu, (k.b)localObject2);
          if (!bt.isNullOrNil(parambu))
          {
            localObject1 = "file://".concat(String.valueOf(parambu));
            localObject2 = new e(parambu);
            parambu = String.format(JEa, new Object[] { ((e)localObject2).getName(), localObject1, parambu });
          }
          break;
        case 1: 
          if (bt.isNullOrNil((String)localObject1))
          {
            parambu = aRc(((k.b)localObject2).title);
            continue;
          }
          parambu = String.format("[%s: %s]", new Object[] { localObject1, aRc(((k.b)localObject2).title) });
          break;
        case 4: 
        case 5: 
          parambu = String.format("[%s: %s]", new Object[] { aRc(((k.b)localObject2).title), aRc(((k.b)localObject2).url) });
          break;
        }
      }
      parambu = "";
    }
  }
  
  private String fCg()
  {
    AppMethodBeat.i(34853);
    Object localObject;
    if (!w.vF(this.dzp.field_username))
    {
      str1 = this.context.getString(2131763060);
      localObject = this.dzp.adu();
      ba.aBQ();
      str1 = String.format(str1, new Object[] { localObject, c.ajl().get(4, null) });
      AppMethodBeat.o(34853);
      return str1;
    }
    if (bt.isNullOrNil(this.dzp.field_nickname))
    {
      localObject = q.yQ(this.dzp.field_username).iterator();
      String str2;
      for (str1 = ""; ((Iterator)localObject).hasNext(); str1 = str1 + str2 + ", ") {
        str2 = v.zf((String)((Iterator)localObject).next());
      }
    }
    for (String str1 = str1.substring(0, str1.length() - 2);; str1 = this.dzp.adu())
    {
      str1 = String.format(this.context.getString(2131763059), new Object[] { str1 });
      break;
    }
  }
  
  public final String fCf()
  {
    AppMethodBeat.i(34852);
    ad.i("MicroMsg.QQMailHistoryExporter", "selectItems.size = %d", new Object[] { Integer.valueOf(this.JAA.size()) });
    if (com.tencent.mm.cc.a.im(this.context)) {
      this.textSize = com.tencent.mm.cc.a.eb(this.context);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<div id=\"history\">\n");
    localStringBuilder.append(String.format("<p style=\"font-size:%fem;\">Dear:</p> <br> <p style=\"text-indent:2em; font-size:%fem;\">%s</p> <br>", new Object[] { Float.valueOf(this.textSize), Float.valueOf(this.textSize), fCg() }));
    Iterator localIterator = this.JAA.iterator();
    bu localbu;
    label200:
    Object localObject;
    if (localIterator.hasNext())
    {
      localbu = (bu)localIterator.next();
      if (this.JDX == null)
      {
        this.JDX = DP(localbu.field_createTime);
        localStringBuilder.append(String.format("<p style=\"text-align:center; font-size:%fem;\"><span style=\"color:#b8b8b8;\">—————  %s  —————</span></p>\n \n", new Object[] { Float.valueOf(this.textSize), this.JDX }));
        if (!localbu.isText()) {
          break label510;
        }
        if (!localbu.isText()) {
          break label504;
        }
        if (localbu.field_isSend != 1) {
          break label360;
        }
        localObject = String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", new Object[] { Float.valueOf(this.textSize), bq(localbu), Float.valueOf(this.textSize), aRc(localbu.field_content) });
      }
    }
    for (;;)
    {
      localStringBuilder.append((String)localObject);
      break;
      localObject = DP(localbu.field_createTime);
      if (((String)localObject).equals(this.JDX)) {
        break label200;
      }
      this.JDX = ((String)localObject);
      localStringBuilder.append("<br>");
      localStringBuilder.append(String.format("<p style=\"text-align:center; font-size:%fem;\"><span style=\"color:#b8b8b8;\">—————  %s  —————</span></p>\n \n", new Object[] { Float.valueOf(this.textSize), this.JDX }));
      break label200;
      label360:
      if (!w.vF(this.dzp.field_username))
      {
        localObject = String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", new Object[] { Float.valueOf(this.textSize), bq(localbu), Float.valueOf(this.textSize), aRc(localbu.field_content) });
      }
      else
      {
        int i = bj.Bh(localbu.field_content);
        if (i != -1)
        {
          localObject = String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", new Object[] { Float.valueOf(this.textSize), bq(localbu), Float.valueOf(this.textSize), aRc(localbu.field_content.substring(i + 1).trim()) });
          continue;
          label504:
          localObject = null;
          continue;
          label510:
          if (localbu.fpi())
          {
            if (localbu.fpi())
            {
              long l1 = localbu.field_msgId;
              long l2 = localbu.field_msgSvrId;
              String str = ac.cj(localbu.field_talker, l1);
              localObject = str;
              if (bt.isNullOrNil(str)) {
                localObject = ac.ck(localbu.field_talker, l2);
              }
              localObject = com.tencent.mm.vfs.i.k((String)localObject, false);
              ad.i("MicroMsg.QQMailHistoryExporter", "hdPath[%s]", new Object[] { localObject });
              if (!bt.isNullOrNil((String)localObject))
              {
                str = "file://".concat(String.valueOf(localObject));
                e locale = new e((String)localObject);
                localObject = String.format(JEa, new Object[] { locale.getName(), str, localObject });
              }
            }
            for (localObject = String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", new Object[] { Float.valueOf(this.textSize), bq(localbu), Float.valueOf(this.textSize), localObject });; localObject = null)
            {
              localStringBuilder.append((String)localObject);
              break;
            }
          }
          if (localbu.cTc())
          {
            localObject = k.b.yr(localbu.field_content);
            if ((localObject != null) && ((((k.b)localObject).type == 53) || (((k.b)localObject).type == 57)))
            {
              if ((localObject != null) && ((((k.b)localObject).type == 53) || (((k.b)localObject).type == 57))) {}
              for (localObject = String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", new Object[] { Float.valueOf(this.textSize), bq(localbu), Float.valueOf(this.textSize), aRc(((k.b)localObject).title) });; localObject = null)
              {
                localStringBuilder.append((String)localObject);
                break;
              }
            }
            localStringBuilder.append(bp(localbu));
            break;
          }
          localStringBuilder.append(bp(localbu));
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