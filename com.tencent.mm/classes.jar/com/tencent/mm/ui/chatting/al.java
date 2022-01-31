package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.net.Uri;
import com.tencent.mm.R.l;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.h.a.jd;
import com.tencent.mm.h.a.jd.b;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.m;
import com.tencent.mm.model.q;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bi.a;
import com.tencent.mm.storage.z;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public final class al
{
  private ad bSg = null;
  private Context context;
  private SimpleDateFormat hJl = new SimpleDateFormat("yyyy-MM-dd");
  String kzt = null;
  List<bi> vju;
  private String vmD = null;
  ArrayList<Uri> vmE = new ArrayList();
  
  public al(Context paramContext, List<bi> paramList, ad paramad)
  {
    this.context = paramContext;
    this.vju = paramList;
    this.bSg = paramad;
  }
  
  private String aG(bi parambi)
  {
    String str = null;
    if (!s.fn(this.bSg.field_username)) {
      str = r.gV(parambi.field_talker);
    }
    for (;;)
    {
      if (parambi.field_isSend == 1)
      {
        y.i("MicroMsg.OtherMailHistoryExporter", "isSend");
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
    if (!s.fn(this.bSg.field_username))
    {
      str1 = this.context.getString(R.l.send_mail_content_start_msg);
      localObject = this.bSg.Bp();
      au.Hx();
      return String.format(str1, new Object[] { localObject, com.tencent.mm.model.c.Dz().get(4, null) });
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
  
  private String hO(long paramLong)
  {
    return this.hJl.format(new Date(paramLong));
  }
  
  public final String cDh()
  {
    if (this.kzt == null) {}
    for (boolean bool = true;; bool = false)
    {
      y.d("MicroMsg.OtherMailHistoryExporter", "export: history is null? %B, selectItems.size = %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.vju.size()) });
      if (this.kzt == null) {
        break;
      }
      return this.kzt;
    }
    this.vmE.clear();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(cDi());
    localStringBuilder.append("\n\n");
    Iterator localIterator = this.vju.iterator();
    bi localbi;
    label178:
    Object localObject1;
    if (localIterator.hasNext())
    {
      localbi = (bi)localIterator.next();
      if (this.vmD == null)
      {
        this.vmD = hO(localbi.field_createTime);
        localStringBuilder.append(String.format("—————  %s  —————\n\n", new Object[] { this.vmD }));
        localStringBuilder.append("\n");
        if (!localbi.isText()) {
          break label413;
        }
        if (!localbi.isText()) {
          break label407;
        }
        if (localbi.field_isSend != 1) {
          break label307;
        }
        localObject1 = String.format("%s\n\n%s\n\n", new Object[] { aG(localbi), localbi.field_content });
      }
    }
    label407:
    label413:
    for (;;)
    {
      localStringBuilder.append((String)localObject1);
      break;
      localObject1 = hO(localbi.field_createTime);
      if (((String)localObject1).equals(this.vmD)) {
        break label178;
      }
      this.vmD = ((String)localObject1);
      localStringBuilder.append(String.format("—————  %s  —————\n\n", new Object[] { this.vmD }));
      localStringBuilder.append("\n");
      break label178;
      label307:
      if (!s.fn(this.bSg.field_username))
      {
        localObject1 = String.format("%s\n\n%s\n\n", new Object[] { aG(localbi), localbi.field_content });
      }
      else
      {
        int i = bd.iH(localbi.field_content);
        if (i != -1)
        {
          localObject1 = String.format("%s\n\n%s\n\n", new Object[] { aG(localbi), localbi.field_content.substring(i + 1).trim() });
          continue;
          localObject1 = null;
          continue;
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
              y.d("MicroMsg.OtherMailHistoryExporter", "hdPath[%s]", new Object[] { localObject1 });
              if (!bk.bl((String)localObject1))
              {
                localObject2 = "file://" + (String)localObject1;
                this.vmE.add(Uri.parse((String)localObject2));
                localObject1 = String.format("[%s: %s(%s)]", new Object[] { this.context.getString(R.l.email_image_prompt), new File((String)localObject1).getName(), this.context.getString(R.l.email_attach_tips) });
              }
            }
            for (localObject1 = String.format("%s\n\n%s\n\n", new Object[] { aG(localbi), localObject1 });; localObject1 = null)
            {
              localStringBuilder.append((String)localObject1);
              break;
            }
          }
          if (localbi.ctA()) {
            localObject1 = String.format("[%s]", new Object[] { this.context.getString(R.l.email_voice_prompt) });
          }
          for (;;)
          {
            y.i("MicroMsg.OtherMailHistoryExporter", "formatOtherMsg, msgStr = %s", new Object[] { localObject1 });
            localStringBuilder.append(String.format("%s\n\n%s\n\n", new Object[] { aG(localbi), localObject1 }));
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
              a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
              localObject1 = String.format("[%s]", new Object[] { ((jd)localObject1).bRy.bOn });
            }
            else
            {
              if (localbi.aVK())
              {
                localObject1 = g.a.gp(bk.ZQ(localbi.field_content));
                if (localObject1 != null)
                {
                  switch (((g.a)localObject1).type)
                  {
                  }
                  for (;;)
                  {
                    localObject2 = com.tencent.mm.pluginsdk.model.app.g.by(((g.a)localObject1).appId, true);
                    if (localObject2 != null) {
                      break label959;
                    }
                    localObject1 = "";
                    break;
                    localObject2 = ap.avh().VQ(((g.a)localObject1).bFE);
                    if (localObject2 != null)
                    {
                      localObject2 = new File(((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_fileFullPath);
                      if (((File)localObject2).exists()) {
                        this.vmE.add(Uri.fromFile((File)localObject2));
                      }
                    }
                  }
                  label959:
                  localObject2 = ((f)localObject2).field_appName;
                  if (6 == ((g.a)localObject1).type)
                  {
                    localObject1 = String.format("[%s: %s(%s)]", new Object[] { this.context.getString(R.l.email_appmsg_prompt), localObject2, this.context.getString(R.l.email_attach_tips) });
                    continue;
                  }
                  localObject1 = String.format("[%s: %s]", new Object[] { this.context.getString(R.l.email_appmsg_prompt), localObject2 });
                }
              }
              else
              {
                if (localbi.cvn())
                {
                  au.Hx();
                  localObject1 = com.tencent.mm.model.c.Fy().HN(localbi.field_content).nickname;
                  localObject1 = String.format("[%s: %s]", new Object[] { this.context.getString(R.l.email_card_prompt), localObject1 });
                  continue;
                }
                if (localbi.aRQ())
                {
                  localObject1 = this.context.getString(R.l.email_video_prompt);
                  o.Sr();
                  localObject2 = String.format("[%s: %s(%s)]", new Object[] { localObject1, new File(t.nS(localbi.field_imgPath)).getName(), this.context.getString(R.l.email_attach_tips) });
                  o.Sr();
                  File localFile = new File(t.nS(localbi.field_imgPath));
                  localObject1 = localObject2;
                  if (!localFile.exists()) {
                    continue;
                  }
                  this.vmE.add(Uri.fromFile(localFile));
                  localObject1 = localObject2;
                  continue;
                }
                if ((localbi.cvo()) || (localbi.cvp()))
                {
                  localObject1 = String.format("[%s]", new Object[] { this.context.getString(R.l.email_emoji_prompt) });
                  continue;
                  localStringBuilder.append("\n\n");
                  this.kzt = localStringBuilder.toString();
                  return this.kzt;
                }
              }
              localObject1 = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.al
 * JD-Core Version:    0.7.0.1
 */