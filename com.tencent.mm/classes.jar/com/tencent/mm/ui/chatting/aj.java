package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.f.a.mp;
import com.tencent.mm.f.a.mp.b;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.x;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.ca.a;
import com.tencent.mm.vfs.q;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public final class aj
{
  private String WDJ;
  String WDK;
  ArrayList<Uri> WDL;
  List<ca> WzW;
  private Context context;
  private as fLE;
  private SimpleDateFormat rOV;
  
  public aj(Context paramContext, List<ca> paramList, as paramas)
  {
    AppMethodBeat.i(34842);
    this.WDJ = null;
    this.fLE = null;
    this.rOV = new SimpleDateFormat("yyyy-MM-dd");
    this.WDK = null;
    this.WDL = new ArrayList();
    this.context = paramContext;
    this.WzW = paramList;
    this.fLE = paramas;
    AppMethodBeat.o(34842);
  }
  
  private String VA(long paramLong)
  {
    AppMethodBeat.i(34847);
    String str = this.rOV.format(new Date(paramLong));
    AppMethodBeat.o(34847);
    return str;
  }
  
  private String bX(ca paramca)
  {
    AppMethodBeat.i(34845);
    Object localObject1 = null;
    if (paramca.hwF()) {
      localObject1 = String.format("[%s]", new Object[] { this.context.getString(R.l.eCe) });
    }
    for (;;)
    {
      Log.i("MicroMsg.OtherMailHistoryExporter", "formatOtherMsg, msgStr = %s", new Object[] { localObject1 });
      paramca = String.format("%s\n\n%s\n\n", new Object[] { bY(paramca), localObject1 });
      AppMethodBeat.o(34845);
      return paramca;
      if (paramca.hzu())
      {
        if (paramca.field_isSend == 1) {
          localObject1 = this.context.getString(R.l.eCc);
        } else {
          localObject1 = this.context.getString(R.l.eCb);
        }
      }
      else if (paramca.erm())
      {
        localObject1 = new mp();
        ((mp)localObject1).fKL.fKG = 1;
        ((mp)localObject1).fKL.fvt = paramca;
        EventCenter.instance.publish((IEvent)localObject1);
        localObject1 = String.format("[%s]", new Object[] { ((mp)localObject1).fKM.fGw });
      }
      else
      {
        Object localObject2;
        if (paramca.erk())
        {
          localObject2 = k.b.OQ(Util.processXml(paramca.field_content));
          if (localObject2 != null)
          {
            switch (((k.b)localObject2).type)
            {
            }
            for (;;)
            {
              localObject1 = h.o(((k.b)localObject2).appId, true, false);
              if (localObject1 != null) {
                break label313;
              }
              localObject1 = "";
              break;
              localObject1 = com.tencent.mm.pluginsdk.model.app.ao.ctZ().bpR(((k.b)localObject2).fvr);
              if (localObject1 != null)
              {
                localObject1 = new q(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath);
                if (((q)localObject1).ifE()) {
                  this.WDL.add(FileProviderHelper.getUriForFile(this.context, (q)localObject1));
                }
              }
            }
            label313:
            localObject1 = ((g)localObject1).field_appName;
            if (6 == ((k.b)localObject2).type) {
              localObject1 = String.format("[%s: %s(%s)]", new Object[] { this.context.getString(R.l.eBU), localObject1, this.context.getString(R.l.eBV) });
            } else {
              localObject1 = String.format("[%s: %s]", new Object[] { this.context.getString(R.l.eBU), localObject1 });
            }
          }
        }
        else if (paramca.hzy())
        {
          bh.beI();
          localObject1 = com.tencent.mm.model.c.bbO().aOU(paramca.field_content).nickname;
          localObject1 = String.format("[%s: %s]", new Object[] { this.context.getString(R.l.eBW), localObject1 });
        }
        else if (paramca.dlR())
        {
          localObject1 = this.context.getString(R.l.eCd);
          s.bqB();
          localObject2 = String.format("[%s: %s(%s)]", new Object[] { localObject1, new q(x.XT(paramca.field_imgPath)).getName(), this.context.getString(R.l.eBV) });
          s.bqB();
          q localq = new q(x.XT(paramca.field_imgPath));
          localObject1 = localObject2;
          if (localq.ifE())
          {
            this.WDL.add(FileProviderHelper.getUriForFile(this.context, localq));
            localObject1 = localObject2;
          }
        }
        else if ((paramca.hzB()) || (paramca.hzC()))
        {
          localObject1 = String.format("[%s]", new Object[] { this.context.getString(R.l.eBX) });
        }
      }
    }
  }
  
  private String bY(ca paramca)
  {
    AppMethodBeat.i(34846);
    String str = null;
    if (!ab.Lj(this.fLE.field_username)) {
      str = aa.PJ(paramca.field_talker);
    }
    for (;;)
    {
      if (paramca.field_isSend == 1)
      {
        Log.i("MicroMsg.OtherMailHistoryExporter", "isSend");
        str = z.bdb();
      }
      long l = paramca.field_createTime;
      paramca = new SimpleDateFormat("HH:mm").format(new Date(l));
      Object localObject = new StringBuilder("");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("  ");
      ((StringBuilder)localObject).append(paramca);
      paramca = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(34846);
      return paramca;
      localObject = paramca.field_content;
      int i = bq.RI((String)localObject);
      if (i != -1) {
        str = aa.PJ(((String)localObject).substring(0, i).trim());
      }
    }
  }
  
  private String hNw()
  {
    AppMethodBeat.i(34844);
    Object localObject;
    if (!ab.Lj(this.fLE.field_username))
    {
      str1 = this.context.getString(R.l.eSe);
      localObject = this.fLE.ayr();
      bh.beI();
      str1 = String.format(str1, new Object[] { localObject, com.tencent.mm.model.c.aHp().b(4, null) });
      AppMethodBeat.o(34844);
      return str1;
    }
    if (Util.isNullOrNil(this.fLE.field_nickname))
    {
      localObject = v.Ps(this.fLE.field_username).iterator();
      String str2;
      for (str1 = ""; ((Iterator)localObject).hasNext(); str1 = str1 + str2 + ", ") {
        str2 = aa.PJ((String)((Iterator)localObject).next());
      }
    }
    for (String str1 = str1.substring(0, str1.length() - 2);; str1 = this.fLE.ayr())
    {
      str1 = String.format(this.context.getString(R.l.eSd), new Object[] { str1 });
      break;
    }
  }
  
  public final String hNv()
  {
    AppMethodBeat.i(34843);
    if (this.WDK == null) {}
    Object localObject1;
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.OtherMailHistoryExporter", "export: history is null? %B, selectItems.size = %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.WzW.size()) });
      if (this.WDK == null) {
        break;
      }
      localObject1 = this.WDK;
      AppMethodBeat.o(34843);
      return localObject1;
    }
    this.WDL.clear();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(hNw());
    localStringBuilder.append("\n\n");
    Iterator localIterator = this.WzW.iterator();
    ca localca;
    if (localIterator.hasNext())
    {
      localca = (ca)localIterator.next();
      if (this.WDJ == null)
      {
        this.WDJ = VA(localca.field_createTime);
        localStringBuilder.append(String.format("—————  %s  —————\n\n", new Object[] { this.WDJ }));
        localStringBuilder.append("\n");
        label196:
        if (!localca.hwH()) {
          break label428;
        }
        if (!localca.hwH()) {
          break label422;
        }
        if (localca.field_isSend != 1) {
          break label324;
        }
        localObject1 = String.format("%s\n\n%s\n\n", new Object[] { bY(localca), localca.field_content });
      }
    }
    label422:
    label428:
    for (;;)
    {
      localStringBuilder.append((String)localObject1);
      break;
      localObject1 = VA(localca.field_createTime);
      if (((String)localObject1).equals(this.WDJ)) {
        break label196;
      }
      this.WDJ = ((String)localObject1);
      localStringBuilder.append(String.format("—————  %s  —————\n\n", new Object[] { this.WDJ }));
      localStringBuilder.append("\n");
      break label196;
      label324:
      if (!ab.Lj(this.fLE.field_username))
      {
        localObject1 = String.format("%s\n\n%s\n\n", new Object[] { bY(localca), localca.field_content });
      }
      else
      {
        int i = bq.RI(localca.field_content);
        if (i != -1)
        {
          localObject1 = String.format("%s\n\n%s\n\n", new Object[] { bY(localca), localca.field_content.substring(i + 1).trim() });
          continue;
          localObject1 = null;
          continue;
          if (localca.hwG())
          {
            if (localca.hwG())
            {
              long l1 = localca.field_msgId;
              long l2 = localca.field_msgSvrId;
              Object localObject2 = ad.cm(localca.field_talker, l1);
              localObject1 = localObject2;
              if (Util.isNullOrNil((String)localObject2)) {
                localObject1 = ad.cn(localca.field_talker, l2);
              }
              Log.d("MicroMsg.OtherMailHistoryExporter", "imgPath[%s]", new Object[] { localObject1 });
              if (!Util.isNullOrNil((String)localObject1))
              {
                localObject1 = new q((String)localObject1);
                localObject2 = FileProviderHelper.getUriForFile(this.context, (q)localObject1);
                this.WDL.add(localObject2);
                localObject1 = String.format("[%s: %s(%s)]", new Object[] { this.context.getString(R.l.eBZ), ((q)localObject1).getName(), this.context.getString(R.l.eBV) });
              }
            }
            for (localObject1 = String.format("%s\n\n%s\n\n", new Object[] { bY(localca), localObject1 });; localObject1 = null)
            {
              localStringBuilder.append((String)localObject1);
              break;
            }
          }
          if (localca.erk())
          {
            localObject1 = k.b.OQ(localca.field_content);
            if ((localObject1 != null) && ((((k.b)localObject1).type == 53) || (((k.b)localObject1).type == 57)))
            {
              if ((localObject1 != null) && ((((k.b)localObject1).type == 53) || (((k.b)localObject1).type == 57))) {}
              for (localObject1 = String.format("%s\n\n%s\n\n", new Object[] { bY(localca), ((k.b)localObject1).title });; localObject1 = null)
              {
                localStringBuilder.append((String)localObject1);
                break;
              }
            }
            localStringBuilder.append(bX(localca));
            break;
          }
          localStringBuilder.append(bX(localca));
          break;
          localStringBuilder.append("\n\n");
          this.WDK = localStringBuilder.toString();
          localObject1 = this.WDK;
          AppMethodBeat.o(34843);
          return localObject1;
        }
        localObject1 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.aj
 * JD-Core Version:    0.7.0.1
 */