package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.a.lh;
import com.tencent.mm.g.a.lh.b;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.q;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.n;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.bu.a;
import com.tencent.mm.vfs.e;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public final class ai
{
  List<bu> JAA;
  private String JDX;
  String JDY;
  ArrayList<Uri> JDZ;
  private Context context;
  private am dzp;
  private SimpleDateFormat nwF;
  
  public ai(Context paramContext, List<bu> paramList, am paramam)
  {
    AppMethodBeat.i(34842);
    this.JDX = null;
    this.dzp = null;
    this.nwF = new SimpleDateFormat("yyyy-MM-dd");
    this.JDY = null;
    this.JDZ = new ArrayList();
    this.context = paramContext;
    this.JAA = paramList;
    this.dzp = paramam;
    AppMethodBeat.o(34842);
  }
  
  private String DP(long paramLong)
  {
    AppMethodBeat.i(34847);
    String str = this.nwF.format(new Date(paramLong));
    AppMethodBeat.o(34847);
    return str;
  }
  
  private String bp(bu parambu)
  {
    AppMethodBeat.i(34845);
    Object localObject1 = null;
    if (parambu.fph()) {
      localObject1 = String.format("[%s]", new Object[] { this.context.getString(2131758203) });
    }
    for (;;)
    {
      ad.i("MicroMsg.OtherMailHistoryExporter", "formatOtherMsg, msgStr = %s", new Object[] { localObject1 });
      parambu = String.format("%s\n\n%s\n\n", new Object[] { bq(parambu), localObject1 });
      AppMethodBeat.o(34845);
      return parambu;
      if (parambu.frA())
      {
        if (parambu.field_isSend == 1) {
          localObject1 = this.context.getString(2131758201);
        } else {
          localObject1 = this.context.getString(2131758200);
        }
      }
      else if (parambu.cTe())
      {
        localObject1 = new lh();
        ((lh)localObject1).dyD.dyx = 1;
        ((lh)localObject1).dyD.dku = parambu;
        a.IbL.l((b)localObject1);
        localObject1 = String.format("[%s]", new Object[] { ((lh)localObject1).dyE.duy });
      }
      else
      {
        Object localObject2;
        if (parambu.cTc())
        {
          localObject2 = k.b.yr(bt.aRd(parambu.field_content));
          if (localObject2 != null)
          {
            switch (((k.b)localObject2).type)
            {
            }
            for (;;)
            {
              localObject1 = h.m(((k.b)localObject2).appId, true, false);
              if (localObject1 != null) {
                break label309;
              }
              localObject1 = "";
              break;
              localObject1 = ao.bIX().aLD(((k.b)localObject2).dks);
              if (localObject1 != null)
              {
                localObject1 = new e(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath);
                if (((e)localObject1).exists()) {
                  this.JDZ.add(n.a(this.context, (e)localObject1));
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
        else if (parambu.frE())
        {
          ba.aBQ();
          localObject1 = com.tencent.mm.model.c.azs().aqk(parambu.field_content).nickname;
          localObject1 = String.format("[%s: %s]", new Object[] { this.context.getString(2131758195), localObject1 });
        }
        else if (parambu.cxf())
        {
          localObject1 = this.context.getString(2131758202);
          o.aMJ();
          localObject2 = String.format("[%s: %s(%s)]", new Object[] { localObject1, new e(t.Hh(parambu.field_imgPath)).getName(), this.context.getString(2131758194) });
          o.aMJ();
          e locale = new e(t.Hh(parambu.field_imgPath));
          localObject1 = localObject2;
          if (locale.exists())
          {
            this.JDZ.add(n.a(this.context, locale));
            localObject1 = localObject2;
          }
        }
        else if ((parambu.frG()) || (parambu.frH()))
        {
          localObject1 = String.format("[%s]", new Object[] { this.context.getString(2131758196) });
        }
      }
    }
  }
  
  private String bq(bu parambu)
  {
    AppMethodBeat.i(34846);
    String str = null;
    if (!w.vF(this.dzp.field_username)) {
      str = v.zf(parambu.field_talker);
    }
    for (;;)
    {
      if (parambu.field_isSend == 1)
      {
        ad.i("MicroMsg.OtherMailHistoryExporter", "isSend");
        str = u.aAo();
      }
      long l = parambu.field_createTime;
      parambu = new SimpleDateFormat("HH:mm").format(new Date(l));
      Object localObject = new StringBuilder("");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("  ");
      ((StringBuilder)localObject).append(parambu);
      parambu = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(34846);
      return parambu;
      localObject = parambu.field_content;
      int i = bj.Bh((String)localObject);
      if (i != -1) {
        str = v.zf(((String)localObject).substring(0, i).trim());
      }
    }
  }
  
  private String fCg()
  {
    AppMethodBeat.i(34844);
    Object localObject;
    if (!w.vF(this.dzp.field_username))
    {
      str1 = this.context.getString(2131763060);
      localObject = this.dzp.adu();
      ba.aBQ();
      str1 = String.format(str1, new Object[] { localObject, com.tencent.mm.model.c.ajl().get(4, null) });
      AppMethodBeat.o(34844);
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
    AppMethodBeat.i(34843);
    if (this.JDY == null) {}
    Object localObject1;
    for (boolean bool = true;; bool = false)
    {
      ad.d("MicroMsg.OtherMailHistoryExporter", "export: history is null? %B, selectItems.size = %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.JAA.size()) });
      if (this.JDY == null) {
        break;
      }
      localObject1 = this.JDY;
      AppMethodBeat.o(34843);
      return localObject1;
    }
    this.JDZ.clear();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(fCg());
    localStringBuilder.append("\n\n");
    Iterator localIterator = this.JAA.iterator();
    bu localbu;
    if (localIterator.hasNext())
    {
      localbu = (bu)localIterator.next();
      if (this.JDX == null)
      {
        this.JDX = DP(localbu.field_createTime);
        localStringBuilder.append(String.format("—————  %s  —————\n\n", new Object[] { this.JDX }));
        localStringBuilder.append("\n");
        label196:
        if (!localbu.isText()) {
          break label428;
        }
        if (!localbu.isText()) {
          break label422;
        }
        if (localbu.field_isSend != 1) {
          break label324;
        }
        localObject1 = String.format("%s\n\n%s\n\n", new Object[] { bq(localbu), localbu.field_content });
      }
    }
    label422:
    label428:
    for (;;)
    {
      localStringBuilder.append((String)localObject1);
      break;
      localObject1 = DP(localbu.field_createTime);
      if (((String)localObject1).equals(this.JDX)) {
        break label196;
      }
      this.JDX = ((String)localObject1);
      localStringBuilder.append(String.format("—————  %s  —————\n\n", new Object[] { this.JDX }));
      localStringBuilder.append("\n");
      break label196;
      label324:
      if (!w.vF(this.dzp.field_username))
      {
        localObject1 = String.format("%s\n\n%s\n\n", new Object[] { bq(localbu), localbu.field_content });
      }
      else
      {
        int i = bj.Bh(localbu.field_content);
        if (i != -1)
        {
          localObject1 = String.format("%s\n\n%s\n\n", new Object[] { bq(localbu), localbu.field_content.substring(i + 1).trim() });
          continue;
          localObject1 = null;
          continue;
          if (localbu.fpi())
          {
            if (localbu.fpi())
            {
              long l1 = localbu.field_msgId;
              long l2 = localbu.field_msgSvrId;
              Object localObject2 = ac.cj(localbu.field_talker, l1);
              localObject1 = localObject2;
              if (bt.isNullOrNil((String)localObject2)) {
                localObject1 = ac.ck(localbu.field_talker, l2);
              }
              ad.d("MicroMsg.OtherMailHistoryExporter", "imgPath[%s]", new Object[] { localObject1 });
              if (!bt.isNullOrNil((String)localObject1))
              {
                localObject1 = new e((String)localObject1);
                localObject2 = n.a(this.context, (e)localObject1);
                this.JDZ.add(localObject2);
                localObject1 = String.format("[%s: %s(%s)]", new Object[] { this.context.getString(2131758198), ((e)localObject1).getName(), this.context.getString(2131758194) });
              }
            }
            for (localObject1 = String.format("%s\n\n%s\n\n", new Object[] { bq(localbu), localObject1 });; localObject1 = null)
            {
              localStringBuilder.append((String)localObject1);
              break;
            }
          }
          if (localbu.cTc())
          {
            localObject1 = k.b.yr(localbu.field_content);
            if ((localObject1 != null) && ((((k.b)localObject1).type == 53) || (((k.b)localObject1).type == 57)))
            {
              if ((localObject1 != null) && ((((k.b)localObject1).type == 53) || (((k.b)localObject1).type == 57))) {}
              for (localObject1 = String.format("%s\n\n%s\n\n", new Object[] { bq(localbu), ((k.b)localObject1).title });; localObject1 = null)
              {
                localStringBuilder.append((String)localObject1);
                break;
              }
            }
            localStringBuilder.append(bp(localbu));
            break;
          }
          localStringBuilder.append(bp(localbu));
          break;
          localStringBuilder.append("\n\n");
          this.JDY = localStringBuilder.toString();
          localObject1 = this.JDY;
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