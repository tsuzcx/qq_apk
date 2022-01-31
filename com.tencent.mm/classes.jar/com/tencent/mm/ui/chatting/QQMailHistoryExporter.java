package com.tencent.mm.ui.chatting;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.g.a.jm;
import com.tencent.mm.g.a.jm.b;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.c;
import com.tencent.mm.model.n;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bi.a;
import com.tencent.mm.storage.z;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public final class QQMailHistoryExporter
{
  private static final char[] iXA;
  private static final String[] iXB;
  private static final String zCb;
  private Context context;
  private ad czH = null;
  private float textSize = 1.0F;
  private String zBZ = null;
  private List<bi> zyt;
  
  static
  {
    AppMethodBeat.i(30975);
    zCb = "<img id=\"%d:%d\" src=\"%s\" height=\"100\" onclick=\"" + u.hZ("weixin://img_onclick/", "this.id + '@@' + this.src") + "\"></img>";
    iXA = new char[] { 60, 62, 34, 39, 38, 10 };
    iXB = new String[] { "&lt;", "&gt;", "&quot;", "&apos;", "&amp;", "<br />" };
    AppMethodBeat.o(30975);
  }
  
  public QQMailHistoryExporter(Context paramContext, List<bi> paramList, ad paramad)
  {
    this.context = paramContext;
    this.zyt = paramList;
    this.czH = paramad;
  }
  
  private String aQ(bi parambi)
  {
    AppMethodBeat.i(30973);
    String str = null;
    if (!com.tencent.mm.model.t.lA(this.czH.field_username)) {
      str = s.nE(parambi.field_talker);
    }
    for (;;)
    {
      if (parambi.field_isSend == 1)
      {
        ab.i("MicroMsg.QQMailHistoryExporter", "isSend");
        str = r.Zp();
      }
      long l = parambi.field_createTime;
      parambi = new SimpleDateFormat("HH:mm").format(new Date(l));
      Object localObject = new StringBuilder("");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("  ");
      ((StringBuilder)localObject).append(parambi);
      parambi = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(30973);
      return parambi;
      localObject = parambi.field_content;
      int i = bf.pt((String)localObject);
      if (i != -1) {
        str = s.nE(((String)localObject).substring(0, i).trim());
      }
    }
  }
  
  private static String apT(String paramString)
  {
    AppMethodBeat.i(30970);
    if (paramString == null)
    {
      AppMethodBeat.o(30970);
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int n = paramString.length();
    int i = 0;
    if (i < n)
    {
      char c = paramString.charAt(i);
      int m = 1;
      int j = iXA.length - 1;
      for (;;)
      {
        int k = m;
        if (j >= 0)
        {
          if (iXA[j] == c)
          {
            localStringBuffer.append(iXB[j]);
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
    AppMethodBeat.o(30970);
    return paramString;
  }
  
  private String dGW()
  {
    AppMethodBeat.i(30972);
    Object localObject;
    if (!com.tencent.mm.model.t.lA(this.czH.field_username))
    {
      str1 = this.context.getString(2131303111);
      localObject = this.czH.Oe();
      aw.aaz();
      str1 = String.format(str1, new Object[] { localObject, c.Ru().get(4, null) });
      AppMethodBeat.o(30972);
      return str1;
    }
    if (bo.isNullOrNil(this.czH.field_nickname))
    {
      localObject = n.nt(this.czH.field_username).iterator();
      String str2;
      for (str1 = ""; ((Iterator)localObject).hasNext(); str1 = str1 + str2 + ", ") {
        str2 = s.nE((String)((Iterator)localObject).next());
      }
    }
    for (String str1 = str1.substring(0, str1.length() - 2);; str1 = this.czH.Oe())
    {
      str1 = String.format(this.context.getString(2131303110), new Object[] { str1 });
      break;
    }
  }
  
  private static String oA(long paramLong)
  {
    AppMethodBeat.i(30974);
    String str = new SimpleDateFormat("yyyy-MM-dd").format(new Date(paramLong));
    AppMethodBeat.o(30974);
    return str;
  }
  
  public final String dGV()
  {
    AppMethodBeat.i(30971);
    ab.i("MicroMsg.QQMailHistoryExporter", "selectItems.size = %d", new Object[] { Integer.valueOf(this.zyt.size()) });
    if (com.tencent.mm.cb.a.gt(this.context)) {
      this.textSize = com.tencent.mm.cb.a.dr(this.context);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<div id=\"history\">\n");
    localStringBuilder.append(String.format("<p style=\"font-size:%fem;\">Dear:</p> <br> <p style=\"text-indent:2em; font-size:%fem;\">%s</p> <br>", new Object[] { Float.valueOf(this.textSize), Float.valueOf(this.textSize), dGW() }));
    Iterator localIterator = this.zyt.iterator();
    bi localbi;
    label200:
    Object localObject1;
    if (localIterator.hasNext())
    {
      localbi = (bi)localIterator.next();
      if (this.zBZ == null)
      {
        this.zBZ = oA(localbi.field_createTime);
        localStringBuilder.append(String.format("<p style=\"text-align:center; font-size:%fem;\"><span style=\"color:#b8b8b8;\">—————  %s  —————</span></p>\n \n", new Object[] { Float.valueOf(this.textSize), this.zBZ }));
        if (!localbi.isText()) {
          break label513;
        }
        if (!localbi.isText()) {
          break label507;
        }
        if (localbi.field_isSend != 1) {
          break label361;
        }
        localObject1 = String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", new Object[] { Float.valueOf(this.textSize), aQ(localbi), Float.valueOf(this.textSize), apT(localbi.field_content) });
      }
    }
    label513:
    label1178:
    label1961:
    for (;;)
    {
      localStringBuilder.append((String)localObject1);
      break;
      localObject1 = oA(localbi.field_createTime);
      if (((String)localObject1).equals(this.zBZ)) {
        break label200;
      }
      this.zBZ = ((String)localObject1);
      localStringBuilder.append("<br>");
      localStringBuilder.append(String.format("<p style=\"text-align:center; font-size:%fem;\"><span style=\"color:#b8b8b8;\">—————  %s  —————</span></p>\n \n", new Object[] { Float.valueOf(this.textSize), this.zBZ }));
      break label200;
      label361:
      if (!com.tencent.mm.model.t.lA(this.czH.field_username))
      {
        localObject1 = String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", new Object[] { Float.valueOf(this.textSize), aQ(localbi), Float.valueOf(this.textSize), apT(localbi.field_content) });
      }
      else
      {
        int i = bf.pt(localbi.field_content);
        if (i != -1)
        {
          localObject1 = String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", new Object[] { Float.valueOf(this.textSize), aQ(localbi), Float.valueOf(this.textSize), apT(localbi.field_content.substring(i + 1).trim()) });
          continue;
          label507:
          localObject1 = null;
          continue;
          Object localObject2;
          if (localbi.dvX())
          {
            if (localbi.dvX())
            {
              long l1 = localbi.field_msgId;
              long l2 = localbi.field_msgSvrId;
              localObject2 = ac.oy(l1);
              localObject1 = localObject2;
              if (bo.isNullOrNil((String)localObject2)) {
                localObject1 = ac.oz(l2);
              }
              ab.d("MicroMsg.QQMailHistoryExporter", "hdPath[%s]", new Object[] { localObject1 });
              if (!bo.isNullOrNil((String)localObject1))
              {
                localObject2 = "file://".concat(String.valueOf(localObject1));
                localObject1 = String.format(zCb, new Object[] { Long.valueOf(localbi.field_msgId), Long.valueOf(localbi.field_msgSvrId), localObject2, localObject1 });
              }
            }
            for (localObject1 = String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", new Object[] { Float.valueOf(this.textSize), aQ(localbi), Float.valueOf(this.textSize), localObject1 });; localObject1 = null)
            {
              localStringBuilder.append((String)localObject1);
              break;
            }
          }
          localObject1 = null;
          if (localbi.dvW()) {
            localObject1 = String.format("[%s]", new Object[] { this.context.getString(2131299092) });
          }
          for (;;)
          {
            ab.d("MicroMsg.QQMailHistoryExporter", "formatOtherMsg, msgStr = %s", new Object[] { localObject1 });
            localStringBuilder.append(String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", new Object[] { Float.valueOf(this.textSize), aQ(localbi), Float.valueOf(this.textSize), localObject1 }));
            break;
            if (localbi.dxN())
            {
              if (localbi.field_isSend == 1) {
                localObject1 = this.context.getString(2131299090);
              } else {
                localObject1 = this.context.getString(2131299089);
              }
            }
            else if (localbi.bCp())
            {
              localObject1 = new jm();
              ((jm)localObject1).cyZ.cyU = 1;
              ((jm)localObject1).cyZ.cmQ = localbi;
              com.tencent.mm.sdk.b.a.ymk.l((b)localObject1);
              localObject1 = String.format("[%s]", new Object[] { ((jm)localObject1).cza.cvF });
            }
            else
            {
              if (localbi.bCn())
              {
                localObject2 = localbi.field_content;
                localObject1 = localObject2;
                if (com.tencent.mm.model.t.lA(this.czH.field_username))
                {
                  ab.d("MicroMsg.QQMailHistoryExporter", "chatroom msg, parse it");
                  i = bf.pt(localbi.field_content);
                  localObject1 = localObject2;
                  if (i != -1) {
                    localObject1 = localbi.field_content.substring(i + 1).trim();
                  }
                }
                localObject2 = j.b.mY(bo.apU((String)localObject1));
                if (localObject2 == null)
                {
                  ab.w("MicroMsg.QQMailHistoryExporter", "appmsg content is null");
                  localObject1 = String.format("[%s]", new Object[] { this.context.getString(2131299082) });
                  continue;
                }
                f localf = g.ca(((j.b)localObject2).appId, true);
                if ((localf == null) || (bo.isNullOrNil(localf.field_appName))) {}
                for (localObject1 = ((j.b)localObject2).appName;; localObject1 = localf.field_appName)
                {
                  localObject1 = g.b(this.context, localf, (String)localObject1);
                  if (!localbi.dxU()) {
                    break label1178;
                  }
                  if (!bo.isNullOrNil((String)localObject1)) {
                    break label1147;
                  }
                  localObject1 = apT(((j.b)localObject2).title);
                  break;
                }
                label1147:
                localObject1 = String.format("[%s: %s]", new Object[] { localObject1, apT(((j.b)localObject2).title) });
                continue;
                if (localbi.dxV())
                {
                  localObject1 = ac.a(localbi, (j.b)localObject2);
                  if (!bo.isNullOrNil((String)localObject1))
                  {
                    localObject2 = "file://".concat(String.valueOf(localObject1));
                    localObject1 = String.format(zCb, new Object[] { Long.valueOf(localbi.field_msgId), Long.valueOf(localbi.field_msgSvrId), localObject2, localObject1 });
                  }
                }
                else
                {
                  switch (((j.b)localObject2).type)
                  {
                  case 7: 
                  default: 
                    localObject1 = String.format("[%s]", new Object[] { this.context.getString(2131299082) });
                    break;
                  case 3: 
                    if (bo.isNullOrNil(((j.b)localObject2).description))
                    {
                      localObject1 = String.format("[%s: %s]", new Object[] { this.context.getString(2131299088), apT(((j.b)localObject2).title) });
                      continue;
                    }
                    localObject1 = String.format("[%s: %s-%s]", new Object[] { this.context.getString(2131299088), apT(((j.b)localObject2).title), apT(((j.b)localObject2).description) });
                    break;
                  case 8: 
                    localObject1 = String.format("[%s]", new Object[] { this.context.getString(2131299085) });
                    break;
                  case 6: 
                    if (bo.isNullOrNil(((j.b)localObject2).description))
                    {
                      localObject1 = String.format("[%s: %s]", new Object[] { this.context.getString(2131299086), apT(((j.b)localObject2).title) });
                      continue;
                    }
                    localObject1 = String.format("[%s: %s-%s(%s)]", new Object[] { this.context.getString(2131299086), apT(((j.b)localObject2).title), apT(((j.b)localObject2).description), this.context.getString(2131299083) });
                    break;
                  case 2: 
                    localObject1 = ac.a(localbi, (j.b)localObject2);
                    if (bo.isNullOrNil((String)localObject1)) {
                      break label1961;
                    }
                    localObject2 = "file://".concat(String.valueOf(localObject1));
                    localObject1 = String.format(zCb, new Object[] { Long.valueOf(localbi.field_msgId), Long.valueOf(localbi.field_msgSvrId), localObject2, localObject1 });
                    break;
                  case 1: 
                    if (bo.isNullOrNil((String)localObject1))
                    {
                      localObject1 = apT(((j.b)localObject2).title);
                      continue;
                    }
                    localObject1 = String.format("[%s: %s]", new Object[] { localObject1, apT(((j.b)localObject2).title) });
                    break;
                  case 4: 
                  case 5: 
                    localObject1 = String.format("[%s: %s]", new Object[] { apT(((j.b)localObject2).title), apT(((j.b)localObject2).url) });
                    break;
                  }
                }
              }
              else
              {
                if (localbi.dxR())
                {
                  aw.aaz();
                  localObject1 = c.YC().Ty(localbi.field_content).nickname;
                  localObject1 = String.format("[%s: %s]", new Object[] { this.context.getString(2131299084), localObject1 });
                  continue;
                }
                if (localbi.byj())
                {
                  localObject1 = this.context.getString(2131299091);
                  o.alE();
                  localObject1 = String.format("[%s: %s(%s)]", new Object[] { localObject1, new File(com.tencent.mm.modelvideo.t.vf(localbi.field_imgPath)).getName(), this.context.getString(2131299083) });
                  continue;
                }
                if ((!localbi.dxS()) && (!localbi.dxT())) {
                  continue;
                }
                localObject1 = String.format("[%s]", new Object[] { this.context.getString(2131299085) });
                continue;
                localStringBuilder.append("\n</div>\n");
                localObject1 = localStringBuilder.toString();
                AppMethodBeat.o(30971);
                return localObject1;
              }
              localObject1 = "";
            }
          }
        }
        else
        {
          localObject1 = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.QQMailHistoryExporter
 * JD-Core Version:    0.7.0.1
 */