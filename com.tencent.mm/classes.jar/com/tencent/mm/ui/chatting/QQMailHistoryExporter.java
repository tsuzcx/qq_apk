package com.tencent.mm.ui.chatting;

import android.content.Context;
import com.tencent.mm.R.l;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.h.a.jd;
import com.tencent.mm.h.a.jd.b;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.model.q;
import com.tencent.mm.model.r;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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
  private static final char[] hlf = { 60, 62, 34, 39, 38, 10 };
  private static final String[] hlg = { "&lt;", "&gt;", "&quot;", "&apos;", "&amp;", "<br />" };
  private static final String vmF = "<img id=\"%d:%d\" src=\"%s\" height=\"100\" onclick=\"" + com.tencent.mm.pluginsdk.ui.tools.s.fY("weixin://img_onclick/", "this.id + '@@' + this.src") + "\"></img>";
  private ad bSg = null;
  private Context context;
  private float dOB = 1.0F;
  private List<bi> vju;
  private String vmD = null;
  
  public QQMailHistoryExporter(Context paramContext, List<bi> paramList, ad paramad)
  {
    this.context = paramContext;
    this.vju = paramList;
    this.bSg = paramad;
  }
  
  private static String ZP(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int n = paramString.length();
    int i = 0;
    if (i < n)
    {
      char c = paramString.charAt(i);
      int m = 1;
      int j = hlf.length - 1;
      for (;;)
      {
        int k = m;
        if (j >= 0)
        {
          if (hlf[j] == c)
          {
            localStringBuffer.append(hlg[j]);
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
    return localStringBuffer.toString();
  }
  
  private String aG(bi parambi)
  {
    String str = null;
    if (!com.tencent.mm.model.s.fn(this.bSg.field_username)) {
      str = r.gV(parambi.field_talker);
    }
    for (;;)
    {
      if (parambi.field_isSend == 1)
      {
        y.i("MicroMsg.QQMailHistoryExporter", "isSend");
        str = q.Gl();
      }
      long l = parambi.field_createTime;
      parambi = new SimpleDateFormat("HH:mm").format(new Date(l));
      Object localObject = new StringBuilder("");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("  ");
      ((StringBuilder)localObject).append(parambi);
      return ((StringBuilder)localObject).toString();
      localObject = parambi.field_content;
      int i = bd.iH((String)localObject);
      if (i != -1) {
        str = r.gV(((String)localObject).substring(0, i).trim());
      }
    }
  }
  
  private String cDi()
  {
    Object localObject;
    if (!com.tencent.mm.model.s.fn(this.bSg.field_username))
    {
      str1 = this.context.getString(R.l.send_mail_content_start_msg);
      localObject = this.bSg.Bp();
      au.Hx();
      return String.format(str1, new Object[] { localObject, c.Dz().get(4, null) });
    }
    if (bk.bl(this.bSg.field_nickname))
    {
      localObject = m.gK(this.bSg.field_username).iterator();
      String str2;
      for (str1 = ""; ((Iterator)localObject).hasNext(); str1 = str1 + str2 + ", ") {
        str2 = r.gV((String)((Iterator)localObject).next());
      }
    }
    for (String str1 = str1.substring(0, str1.length() - 2);; str1 = this.bSg.Bp()) {
      return String.format(this.context.getString(R.l.send_mail_content_room_start_msg), new Object[] { str1 });
    }
  }
  
  private static String hO(long paramLong)
  {
    return new SimpleDateFormat("yyyy-MM-dd").format(new Date(paramLong));
  }
  
  public final String cDh()
  {
    y.i("MicroMsg.QQMailHistoryExporter", "selectItems.size = %d", new Object[] { Integer.valueOf(this.vju.size()) });
    if (com.tencent.mm.cb.a.fh(this.context)) {
      this.dOB = com.tencent.mm.cb.a.cJ(this.context);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<div id=\"history\">\n");
    localStringBuilder.append(String.format("<p style=\"font-size:%fem;\">Dear:</p> <br> <p style=\"text-indent:2em; font-size:%fem;\">%s</p> <br>", new Object[] { Float.valueOf(this.dOB), Float.valueOf(this.dOB), cDi() }));
    Iterator localIterator = this.vju.iterator();
    bi localbi;
    label194:
    Object localObject1;
    if (localIterator.hasNext())
    {
      localbi = (bi)localIterator.next();
      if (this.vmD == null)
      {
        this.vmD = hO(localbi.field_createTime);
        localStringBuilder.append(String.format("<p style=\"text-align:center; font-size:%fem;\"><span style=\"color:#b8b8b8;\">—————  %s  —————</span></p>\n \n", new Object[] { Float.valueOf(this.dOB), this.vmD }));
        if (!localbi.isText()) {
          break label507;
        }
        if (!localbi.isText()) {
          break label501;
        }
        if (localbi.field_isSend != 1) {
          break label355;
        }
        localObject1 = String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", new Object[] { Float.valueOf(this.dOB), aG(localbi), Float.valueOf(this.dOB), ZP(localbi.field_content) });
      }
    }
    label1179:
    label1966:
    for (;;)
    {
      localStringBuilder.append((String)localObject1);
      break;
      localObject1 = hO(localbi.field_createTime);
      if (((String)localObject1).equals(this.vmD)) {
        break label194;
      }
      this.vmD = ((String)localObject1);
      localStringBuilder.append("<br>");
      localStringBuilder.append(String.format("<p style=\"text-align:center; font-size:%fem;\"><span style=\"color:#b8b8b8;\">—————  %s  —————</span></p>\n \n", new Object[] { Float.valueOf(this.dOB), this.vmD }));
      break label194;
      label355:
      if (!com.tencent.mm.model.s.fn(this.bSg.field_username))
      {
        localObject1 = String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", new Object[] { Float.valueOf(this.dOB), aG(localbi), Float.valueOf(this.dOB), ZP(localbi.field_content) });
      }
      else
      {
        int i = bd.iH(localbi.field_content);
        if (i != -1)
        {
          localObject1 = String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", new Object[] { Float.valueOf(this.dOB), aG(localbi), Float.valueOf(this.dOB), ZP(localbi.field_content.substring(i + 1).trim()) });
          continue;
          label501:
          localObject1 = null;
          continue;
          label507:
          Object localObject2;
          if (localbi.ctB())
          {
            if (localbi.ctB())
            {
              long l1 = localbi.field_msgId;
              long l2 = localbi.field_msgSvrId;
              localObject2 = af.hM(l1);
              localObject1 = localObject2;
              if (bk.bl((String)localObject2)) {
                localObject1 = af.hN(l2);
              }
              y.d("MicroMsg.QQMailHistoryExporter", "hdPath[%s]", new Object[] { localObject1 });
              if (!bk.bl((String)localObject1))
              {
                localObject2 = "file://" + (String)localObject1;
                localObject1 = String.format(vmF, new Object[] { Long.valueOf(localbi.field_msgId), Long.valueOf(localbi.field_msgSvrId), localObject2, localObject1 });
              }
            }
            for (localObject1 = String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", new Object[] { Float.valueOf(this.dOB), aG(localbi), Float.valueOf(this.dOB), localObject1 });; localObject1 = null)
            {
              localStringBuilder.append((String)localObject1);
              break;
            }
          }
          localObject1 = null;
          if (localbi.ctA()) {
            localObject1 = String.format("[%s]", new Object[] { this.context.getString(R.l.email_voice_prompt) });
          }
          for (;;)
          {
            y.d("MicroMsg.QQMailHistoryExporter", "formatOtherMsg, msgStr = %s", new Object[] { localObject1 });
            localStringBuilder.append(String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", new Object[] { Float.valueOf(this.dOB), aG(localbi), Float.valueOf(this.dOB), localObject1 }));
            break;
            if (localbi.cvj())
            {
              if (localbi.field_isSend == 1) {
                localObject1 = this.context.getString(R.l.email_send_voip_prompt);
              } else {
                localObject1 = this.context.getString(R.l.email_receive_voip_prompt);
              }
            }
            else if (localbi.aVM())
            {
              localObject1 = new jd();
              ((jd)localObject1).bRx.bRs = 1;
              ((jd)localObject1).bRx.bFH = localbi;
              com.tencent.mm.sdk.b.a.udP.m((b)localObject1);
              localObject1 = String.format("[%s]", new Object[] { ((jd)localObject1).bRy.bOn });
            }
            else
            {
              if (localbi.aVK())
              {
                localObject2 = localbi.field_content;
                localObject1 = localObject2;
                if (com.tencent.mm.model.s.fn(this.bSg.field_username))
                {
                  y.d("MicroMsg.QQMailHistoryExporter", "chatroom msg, parse it");
                  i = bd.iH(localbi.field_content);
                  localObject1 = localObject2;
                  if (i != -1) {
                    localObject1 = localbi.field_content.substring(i + 1).trim();
                  }
                }
                localObject2 = g.a.gp(bk.ZQ((String)localObject1));
                if (localObject2 == null)
                {
                  y.w("MicroMsg.QQMailHistoryExporter", "appmsg content is null");
                  localObject1 = String.format("[%s]", new Object[] { this.context.getString(R.l.email_appmsg_prompt) });
                  continue;
                }
                f localf = com.tencent.mm.pluginsdk.model.app.g.by(((g.a)localObject2).appId, true);
                if ((localf == null) || (bk.bl(localf.field_appName))) {}
                for (localObject1 = ((g.a)localObject2).appName;; localObject1 = localf.field_appName)
                {
                  localObject1 = com.tencent.mm.pluginsdk.model.app.g.b(this.context, localf, (String)localObject1);
                  if (!localbi.cvq()) {
                    break label1179;
                  }
                  if (!bk.bl((String)localObject1)) {
                    break label1148;
                  }
                  localObject1 = ZP(((g.a)localObject2).title);
                  break;
                }
                label1148:
                localObject1 = String.format("[%s: %s]", new Object[] { localObject1, ZP(((g.a)localObject2).title) });
                continue;
                if (localbi.cvr())
                {
                  localObject1 = af.a(localbi, (g.a)localObject2);
                  if (!bk.bl((String)localObject1))
                  {
                    localObject2 = "file://" + (String)localObject1;
                    localObject1 = String.format(vmF, new Object[] { Long.valueOf(localbi.field_msgId), Long.valueOf(localbi.field_msgSvrId), localObject2, localObject1 });
                  }
                }
                else
                {
                  switch (((g.a)localObject2).type)
                  {
                  case 7: 
                  default: 
                    localObject1 = String.format("[%s]", new Object[] { this.context.getString(R.l.email_appmsg_prompt) });
                    break;
                  case 3: 
                    if (bk.bl(((g.a)localObject2).description))
                    {
                      localObject1 = String.format("[%s: %s]", new Object[] { this.context.getString(R.l.email_music_prompt), ZP(((g.a)localObject2).title) });
                      continue;
                    }
                    localObject1 = String.format("[%s: %s-%s]", new Object[] { this.context.getString(R.l.email_music_prompt), ZP(((g.a)localObject2).title), ZP(((g.a)localObject2).description) });
                    break;
                  case 8: 
                    localObject1 = String.format("[%s]", new Object[] { this.context.getString(R.l.email_emoji_prompt) });
                    break;
                  case 6: 
                    if (bk.bl(((g.a)localObject2).description))
                    {
                      localObject1 = String.format("[%s: %s]", new Object[] { this.context.getString(R.l.email_file_prompt), ZP(((g.a)localObject2).title) });
                      continue;
                    }
                    localObject1 = String.format("[%s: %s-%s(%s)]", new Object[] { this.context.getString(R.l.email_file_prompt), ZP(((g.a)localObject2).title), ZP(((g.a)localObject2).description), this.context.getString(R.l.email_attach_tips) });
                    break;
                  case 2: 
                    localObject1 = af.a(localbi, (g.a)localObject2);
                    if (bk.bl((String)localObject1)) {
                      break label1966;
                    }
                    localObject2 = "file://" + (String)localObject1;
                    localObject1 = String.format(vmF, new Object[] { Long.valueOf(localbi.field_msgId), Long.valueOf(localbi.field_msgSvrId), localObject2, localObject1 });
                    break;
                  case 1: 
                    if (bk.bl((String)localObject1))
                    {
                      localObject1 = ZP(((g.a)localObject2).title);
                      continue;
                    }
                    localObject1 = String.format("[%s: %s]", new Object[] { localObject1, ZP(((g.a)localObject2).title) });
                    break;
                  case 4: 
                  case 5: 
                    localObject1 = String.format("[%s: %s]", new Object[] { ZP(((g.a)localObject2).title), ZP(((g.a)localObject2).url) });
                    break;
                  }
                }
              }
              else
              {
                if (localbi.cvn())
                {
                  au.Hx();
                  localObject1 = c.Fy().HN(localbi.field_content).nickname;
                  localObject1 = String.format("[%s: %s]", new Object[] { this.context.getString(R.l.email_card_prompt), localObject1 });
                  continue;
                }
                if (localbi.aRQ())
                {
                  localObject1 = this.context.getString(R.l.email_video_prompt);
                  o.Sr();
                  localObject1 = String.format("[%s: %s(%s)]", new Object[] { localObject1, new File(t.nS(localbi.field_imgPath)).getName(), this.context.getString(R.l.email_attach_tips) });
                  continue;
                }
                if ((!localbi.cvo()) && (!localbi.cvp())) {
                  continue;
                }
                localObject1 = String.format("[%s]", new Object[] { this.context.getString(R.l.email_emoji_prompt) });
                continue;
                localStringBuilder.append("\n</div>\n");
                return localStringBuilder.toString();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.QQMailHistoryExporter
 * JD-Core Version:    0.7.0.1
 */