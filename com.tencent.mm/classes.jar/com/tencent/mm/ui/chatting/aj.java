package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.g.a.ly;
import com.tencent.mm.g.a.ly.b;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.modelvideo.t;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public final class aj
{
  List<ca> PgD;
  private String Pkb;
  String Pkc;
  ArrayList<Uri> Pkd;
  private Context context;
  private as dSh;
  private SimpleDateFormat oMZ;
  
  public aj(Context paramContext, List<ca> paramList, as paramas)
  {
    AppMethodBeat.i(34842);
    this.Pkb = null;
    this.dSh = null;
    this.oMZ = new SimpleDateFormat("yyyy-MM-dd");
    this.Pkc = null;
    this.Pkd = new ArrayList();
    this.context = paramContext;
    this.PgD = paramList;
    this.dSh = paramas;
    AppMethodBeat.o(34842);
  }
  
  private String Ns(long paramLong)
  {
    AppMethodBeat.i(34847);
    String str = this.oMZ.format(new Date(paramLong));
    AppMethodBeat.o(34847);
    return str;
  }
  
  private String bD(ca paramca)
  {
    AppMethodBeat.i(34845);
    Object localObject1 = null;
    if (paramca.gAy()) {
      localObject1 = String.format("[%s]", new Object[] { this.context.getString(2131758491) });
    }
    for (;;)
    {
      Log.i("MicroMsg.OtherMailHistoryExporter", "formatOtherMsg, msgStr = %s", new Object[] { localObject1 });
      paramca = String.format("%s\n\n%s\n\n", new Object[] { bE(paramca), localObject1 });
      AppMethodBeat.o(34845);
      return paramca;
      if (paramca.gDh())
      {
        if (paramca.field_isSend == 1) {
          localObject1 = this.context.getString(2131758489);
        } else {
          localObject1 = this.context.getString(2131758488);
        }
      }
      else if (paramca.dOS())
      {
        localObject1 = new ly();
        ((ly)localObject1).dRv.dRq = 1;
        ((ly)localObject1).dRv.dCM = paramca;
        EventCenter.instance.publish((IEvent)localObject1);
        localObject1 = String.format("[%s]", new Object[] { ((ly)localObject1).dRw.dNk });
      }
      else
      {
        Object localObject2;
        if (paramca.dOQ())
        {
          localObject2 = k.b.HD(Util.processXml(paramca.field_content));
          if (localObject2 != null)
          {
            switch (((k.b)localObject2).type)
            {
            }
            for (;;)
            {
              localObject1 = h.o(((k.b)localObject2).appId, true, false);
              if (localObject1 != null) {
                break label309;
              }
              localObject1 = "";
              break;
              localObject1 = com.tencent.mm.pluginsdk.model.app.ao.cgO().bdx(((k.b)localObject2).dCK);
              if (localObject1 != null)
              {
                localObject1 = new com.tencent.mm.vfs.o(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath);
                if (((com.tencent.mm.vfs.o)localObject1).exists()) {
                  this.Pkd.add(FileProviderHelper.getUriForFile(this.context, (com.tencent.mm.vfs.o)localObject1));
                }
              }
            }
            label309:
            localObject1 = ((g)localObject1).field_appName;
            if (6 == ((k.b)localObject2).type) {
              localObject1 = String.format("[%s: %s(%s)]", new Object[] { this.context.getString(2131758481), localObject1, this.context.getString(2131758482) });
            } else {
              localObject1 = String.format("[%s: %s]", new Object[] { this.context.getString(2131758481), localObject1 });
            }
          }
        }
        else if (paramca.gDl())
        {
          bg.aVF();
          localObject1 = com.tencent.mm.model.c.aSQ().aEK(paramca.field_content).nickname;
          localObject1 = String.format("[%s: %s]", new Object[] { this.context.getString(2131758483), localObject1 });
        }
        else if (paramca.cWJ())
        {
          localObject1 = this.context.getString(2131758490);
          com.tencent.mm.modelvideo.o.bhj();
          localObject2 = String.format("[%s: %s(%s)]", new Object[] { localObject1, new com.tencent.mm.vfs.o(t.Qw(paramca.field_imgPath)).getName(), this.context.getString(2131758482) });
          com.tencent.mm.modelvideo.o.bhj();
          com.tencent.mm.vfs.o localo = new com.tencent.mm.vfs.o(t.Qw(paramca.field_imgPath));
          localObject1 = localObject2;
          if (localo.exists())
          {
            this.Pkd.add(FileProviderHelper.getUriForFile(this.context, localo));
            localObject1 = localObject2;
          }
        }
        else if ((paramca.gDn()) || (paramca.gDo()))
        {
          localObject1 = String.format("[%s]", new Object[] { this.context.getString(2131758484) });
        }
      }
    }
  }
  
  private String bE(ca paramca)
  {
    AppMethodBeat.i(34846);
    String str = null;
    if (!ab.Eq(this.dSh.field_username)) {
      str = aa.getDisplayName(paramca.field_talker);
    }
    for (;;)
    {
      if (paramca.field_isSend == 1)
      {
        Log.i("MicroMsg.OtherMailHistoryExporter", "isSend");
        str = z.aUa();
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
      int i = bp.Kp((String)localObject);
      if (i != -1) {
        str = aa.getDisplayName(((String)localObject).substring(0, i).trim());
      }
    }
  }
  
  private String gOm()
  {
    AppMethodBeat.i(34844);
    Object localObject;
    if (!ab.Eq(this.dSh.field_username))
    {
      str1 = this.context.getString(2131765211);
      localObject = this.dSh.arI();
      bg.aVF();
      str1 = String.format(str1, new Object[] { localObject, com.tencent.mm.model.c.azQ().get(4, null) });
      AppMethodBeat.o(34844);
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
    AppMethodBeat.i(34843);
    if (this.Pkc == null) {}
    Object localObject1;
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.OtherMailHistoryExporter", "export: history is null? %B, selectItems.size = %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.PgD.size()) });
      if (this.Pkc == null) {
        break;
      }
      localObject1 = this.Pkc;
      AppMethodBeat.o(34843);
      return localObject1;
    }
    this.Pkd.clear();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(gOm());
    localStringBuilder.append("\n\n");
    Iterator localIterator = this.PgD.iterator();
    ca localca;
    if (localIterator.hasNext())
    {
      localca = (ca)localIterator.next();
      if (this.Pkb == null)
      {
        this.Pkb = Ns(localca.field_createTime);
        localStringBuilder.append(String.format("—————  %s  —————\n\n", new Object[] { this.Pkb }));
        localStringBuilder.append("\n");
        label196:
        if (!localca.isText()) {
          break label428;
        }
        if (!localca.isText()) {
          break label422;
        }
        if (localca.field_isSend != 1) {
          break label324;
        }
        localObject1 = String.format("%s\n\n%s\n\n", new Object[] { bE(localca), localca.field_content });
      }
    }
    label422:
    label428:
    for (;;)
    {
      localStringBuilder.append((String)localObject1);
      break;
      localObject1 = Ns(localca.field_createTime);
      if (((String)localObject1).equals(this.Pkb)) {
        break label196;
      }
      this.Pkb = ((String)localObject1);
      localStringBuilder.append(String.format("—————  %s  —————\n\n", new Object[] { this.Pkb }));
      localStringBuilder.append("\n");
      break label196;
      label324:
      if (!ab.Eq(this.dSh.field_username))
      {
        localObject1 = String.format("%s\n\n%s\n\n", new Object[] { bE(localca), localca.field_content });
      }
      else
      {
        int i = bp.Kp(localca.field_content);
        if (i != -1)
        {
          localObject1 = String.format("%s\n\n%s\n\n", new Object[] { bE(localca), localca.field_content.substring(i + 1).trim() });
          continue;
          localObject1 = null;
          continue;
          if (localca.gAz())
          {
            if (localca.gAz())
            {
              long l1 = localca.field_msgId;
              long l2 = localca.field_msgSvrId;
              Object localObject2 = ad.cf(localca.field_talker, l1);
              localObject1 = localObject2;
              if (Util.isNullOrNil((String)localObject2)) {
                localObject1 = ad.cg(localca.field_talker, l2);
              }
              Log.d("MicroMsg.OtherMailHistoryExporter", "imgPath[%s]", new Object[] { localObject1 });
              if (!Util.isNullOrNil((String)localObject1))
              {
                localObject1 = new com.tencent.mm.vfs.o((String)localObject1);
                localObject2 = FileProviderHelper.getUriForFile(this.context, (com.tencent.mm.vfs.o)localObject1);
                this.Pkd.add(localObject2);
                localObject1 = String.format("[%s: %s(%s)]", new Object[] { this.context.getString(2131758486), ((com.tencent.mm.vfs.o)localObject1).getName(), this.context.getString(2131758482) });
              }
            }
            for (localObject1 = String.format("%s\n\n%s\n\n", new Object[] { bE(localca), localObject1 });; localObject1 = null)
            {
              localStringBuilder.append((String)localObject1);
              break;
            }
          }
          if (localca.dOQ())
          {
            localObject1 = k.b.HD(localca.field_content);
            if ((localObject1 != null) && ((((k.b)localObject1).type == 53) || (((k.b)localObject1).type == 57)))
            {
              if ((localObject1 != null) && ((((k.b)localObject1).type == 53) || (((k.b)localObject1).type == 57))) {}
              for (localObject1 = String.format("%s\n\n%s\n\n", new Object[] { bE(localca), ((k.b)localObject1).title });; localObject1 = null)
              {
                localStringBuilder.append((String)localObject1);
                break;
              }
            }
            localStringBuilder.append(bD(localca));
            break;
          }
          localStringBuilder.append(bD(localca));
          break;
          localStringBuilder.append("\n\n");
          this.Pkc = localStringBuilder.toString();
          localObject1 = this.Pkc;
          AppMethodBeat.o(34843);
          return localObject1;
        }
        localObject1 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.aj
 * JD-Core Version:    0.7.0.1
 */