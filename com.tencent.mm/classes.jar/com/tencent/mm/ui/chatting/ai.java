package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.a.ky;
import com.tencent.mm.g.a.ky.b;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.q;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.m;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bo.a;
import com.tencent.mm.vfs.e;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public final class ai
{
  List<bo> HMK;
  private String HQi;
  String HQj;
  ArrayList<Uri> HQk;
  private Context context;
  private com.tencent.mm.storage.ai dnB;
  private SimpleDateFormat mWi;
  
  public ai(Context paramContext, List<bo> paramList, com.tencent.mm.storage.ai paramai)
  {
    AppMethodBeat.i(34842);
    this.HQi = null;
    this.dnB = null;
    this.mWi = new SimpleDateFormat("yyyy-MM-dd");
    this.HQj = null;
    this.HQk = new ArrayList();
    this.context = paramContext;
    this.HMK = paramList;
    this.dnB = paramai;
    AppMethodBeat.o(34842);
  }
  
  private String Bb(long paramLong)
  {
    AppMethodBeat.i(34847);
    String str = this.mWi.format(new Date(paramLong));
    AppMethodBeat.o(34847);
    return str;
  }
  
  private String bl(bo parambo)
  {
    AppMethodBeat.i(34845);
    Object localObject1 = null;
    if (parambo.eZl()) {
      localObject1 = String.format("[%s]", new Object[] { this.context.getString(2131758203) });
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.OtherMailHistoryExporter", "formatOtherMsg, msgStr = %s", new Object[] { localObject1 });
      parambo = String.format("%s\n\n%s\n\n", new Object[] { bm(parambo), localObject1 });
      AppMethodBeat.o(34845);
      return parambo;
      if (parambo.fbx())
      {
        if (parambo.field_isSend == 1) {
          localObject1 = this.context.getString(2131758201);
        } else {
          localObject1 = this.context.getString(2131758200);
        }
      }
      else if (parambo.cKP())
      {
        localObject1 = new ky();
        ((ky)localObject1).dmP.dmJ = 1;
        ((ky)localObject1).dmP.cZc = parambo;
        a.GpY.l((b)localObject1);
        localObject1 = String.format("[%s]", new Object[] { ((ky)localObject1).dmQ.diM });
      }
      else
      {
        Object localObject2;
        if (parambo.cKN())
        {
          localObject2 = k.b.vA(bs.aLx(parambo.field_content));
          if (localObject2 != null)
          {
            switch (((k.b)localObject2).type)
            {
            }
            for (;;)
            {
              localObject1 = com.tencent.mm.pluginsdk.model.app.h.k(((k.b)localObject2).appId, true, false);
              if (localObject1 != null) {
                break label309;
              }
              localObject1 = "";
              break;
              localObject1 = ap.bEO().aGd(((k.b)localObject2).cZa);
              if (localObject1 != null)
              {
                localObject1 = new e(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath);
                if (((e)localObject1).exists()) {
                  this.HQk.add(m.a(this.context, (e)localObject1));
                }
              }
            }
            label309:
            localObject1 = ((g)localObject1).field_appName;
            if (6 == ((k.b)localObject2).type) {
              localObject1 = String.format("[%s: %s(%s)]", new Object[] { this.context.getString(2131758193), localObject1, this.context.getString(2131758194) });
            } else {
              localObject1 = String.format("[%s: %s]", new Object[] { this.context.getString(2131758193), localObject1 });
            }
          }
        }
        else if (parambo.fbB())
        {
          az.ayM();
          localObject1 = com.tencent.mm.model.c.awD().alw(parambo.field_content).nickname;
          localObject1 = String.format("[%s: %s]", new Object[] { this.context.getString(2131758195), localObject1 });
        }
        else if (parambo.crt())
        {
          localObject1 = this.context.getString(2131758202);
          o.aJy();
          localObject2 = String.format("[%s: %s(%s)]", new Object[] { localObject1, new e(t.DV(parambo.field_imgPath)).getName(), this.context.getString(2131758194) });
          o.aJy();
          e locale = new e(t.DV(parambo.field_imgPath));
          localObject1 = localObject2;
          if (locale.exists())
          {
            this.HQk.add(m.a(this.context, locale));
            localObject1 = localObject2;
          }
        }
        else if ((parambo.fbC()) || (parambo.fbD()))
        {
          localObject1 = String.format("[%s]", new Object[] { this.context.getString(2131758196) });
        }
      }
    }
  }
  
  private String bm(bo parambo)
  {
    AppMethodBeat.i(34846);
    String str = null;
    if (!w.sQ(this.dnB.field_username)) {
      str = v.wk(parambo.field_talker);
    }
    for (;;)
    {
      if (parambo.field_isSend == 1)
      {
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.OtherMailHistoryExporter", "isSend");
        str = u.axy();
      }
      long l = parambo.field_createTime;
      parambo = new SimpleDateFormat("HH:mm").format(new Date(l));
      Object localObject = new StringBuilder("");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("  ");
      ((StringBuilder)localObject).append(parambo);
      parambo = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(34846);
      return parambo;
      localObject = parambo.field_content;
      int i = bi.yi((String)localObject);
      if (i != -1) {
        str = v.wk(((String)localObject).substring(0, i).trim());
      }
    }
  }
  
  private String flP()
  {
    AppMethodBeat.i(34844);
    Object localObject;
    if (!w.sQ(this.dnB.field_username))
    {
      str1 = this.context.getString(2131763060);
      localObject = this.dnB.aaR();
      az.ayM();
      str1 = String.format(str1, new Object[] { localObject, com.tencent.mm.model.c.agA().get(4, null) });
      AppMethodBeat.o(34844);
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
    AppMethodBeat.i(34843);
    if (this.HQj == null) {}
    Object localObject1;
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.OtherMailHistoryExporter", "export: history is null? %B, selectItems.size = %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.HMK.size()) });
      if (this.HQj == null) {
        break;
      }
      localObject1 = this.HQj;
      AppMethodBeat.o(34843);
      return localObject1;
    }
    this.HQk.clear();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(flP());
    localStringBuilder.append("\n\n");
    Iterator localIterator = this.HMK.iterator();
    bo localbo;
    if (localIterator.hasNext())
    {
      localbo = (bo)localIterator.next();
      if (this.HQi == null)
      {
        this.HQi = Bb(localbo.field_createTime);
        localStringBuilder.append(String.format("—————  %s  —————\n\n", new Object[] { this.HQi }));
        localStringBuilder.append("\n");
        label196:
        if (!localbo.isText()) {
          break label428;
        }
        if (!localbo.isText()) {
          break label422;
        }
        if (localbo.field_isSend != 1) {
          break label324;
        }
        localObject1 = String.format("%s\n\n%s\n\n", new Object[] { bm(localbo), localbo.field_content });
      }
    }
    label422:
    label428:
    for (;;)
    {
      localStringBuilder.append((String)localObject1);
      break;
      localObject1 = Bb(localbo.field_createTime);
      if (((String)localObject1).equals(this.HQi)) {
        break label196;
      }
      this.HQi = ((String)localObject1);
      localStringBuilder.append(String.format("—————  %s  —————\n\n", new Object[] { this.HQi }));
      localStringBuilder.append("\n");
      break label196;
      label324:
      if (!w.sQ(this.dnB.field_username))
      {
        localObject1 = String.format("%s\n\n%s\n\n", new Object[] { bm(localbo), localbo.field_content });
      }
      else
      {
        int i = bi.yi(localbo.field_content);
        if (i != -1)
        {
          localObject1 = String.format("%s\n\n%s\n\n", new Object[] { bm(localbo), localbo.field_content.substring(i + 1).trim() });
          continue;
          localObject1 = null;
          continue;
          if (localbo.eZm())
          {
            if (localbo.eZm())
            {
              long l1 = localbo.field_msgId;
              long l2 = localbo.field_msgSvrId;
              Object localObject2 = ac.AZ(l1);
              localObject1 = localObject2;
              if (bs.isNullOrNil((String)localObject2)) {
                localObject1 = ac.Ba(l2);
              }
              com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.OtherMailHistoryExporter", "imgPath[%s]", new Object[] { localObject1 });
              if (!bs.isNullOrNil((String)localObject1))
              {
                localObject1 = new e((String)localObject1);
                localObject2 = m.a(this.context, (e)localObject1);
                this.HQk.add(localObject2);
                localObject1 = String.format("[%s: %s(%s)]", new Object[] { this.context.getString(2131758198), ((e)localObject1).getName(), this.context.getString(2131758194) });
              }
            }
            for (localObject1 = String.format("%s\n\n%s\n\n", new Object[] { bm(localbo), localObject1 });; localObject1 = null)
            {
              localStringBuilder.append((String)localObject1);
              break;
            }
          }
          if (localbo.cKN())
          {
            localObject1 = k.b.vA(localbo.field_content);
            if ((localObject1 != null) && ((((k.b)localObject1).type == 53) || (((k.b)localObject1).type == 57)))
            {
              if ((localObject1 != null) && ((((k.b)localObject1).type == 53) || (((k.b)localObject1).type == 57))) {}
              for (localObject1 = String.format("%s\n\n%s\n\n", new Object[] { bm(localbo), ((k.b)localObject1).title });; localObject1 = null)
              {
                localStringBuilder.append((String)localObject1);
                break;
              }
            }
            localStringBuilder.append(bl(localbo));
            break;
          }
          localStringBuilder.append(bl(localbo));
          break;
          localStringBuilder.append("\n\n");
          this.HQj = localStringBuilder.toString();
          localObject1 = this.HQj;
          AppMethodBeat.o(34843);
          return localObject1;
        }
        localObject1 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ai
 * JD-Core Version:    0.7.0.1
 */