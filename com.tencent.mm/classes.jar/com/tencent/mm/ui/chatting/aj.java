package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.a.li;
import com.tencent.mm.g.a.li.b;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.r;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bv.a;
import com.tencent.mm.vfs.k;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public final class aj
{
  List<bv> JVr;
  private String JYO;
  String JYP;
  ArrayList<Uri> JYQ;
  private Context context;
  private an dAu;
  private SimpleDateFormat nCa;
  
  public aj(Context paramContext, List<bv> paramList, an paraman)
  {
    AppMethodBeat.i(34842);
    this.JYO = null;
    this.dAu = null;
    this.nCa = new SimpleDateFormat("yyyy-MM-dd");
    this.JYP = null;
    this.JYQ = new ArrayList();
    this.context = paramContext;
    this.JVr = paramList;
    this.dAu = paraman;
    AppMethodBeat.o(34842);
  }
  
  private String Eo(long paramLong)
  {
    AppMethodBeat.i(34847);
    String str = this.nCa.format(new Date(paramLong));
    AppMethodBeat.o(34847);
    return str;
  }
  
  private String bo(bv parambv)
  {
    AppMethodBeat.i(34845);
    Object localObject1 = null;
    if (parambv.ftf()) {
      localObject1 = String.format("[%s]", new Object[] { this.context.getString(2131758203) });
    }
    for (;;)
    {
      ae.i("MicroMsg.OtherMailHistoryExporter", "formatOtherMsg, msgStr = %s", new Object[] { localObject1 });
      parambv = String.format("%s\n\n%s\n\n", new Object[] { bp(parambv), localObject1 });
      AppMethodBeat.o(34845);
      return parambv;
      if (parambv.fvA())
      {
        if (parambv.field_isSend == 1) {
          localObject1 = this.context.getString(2131758201);
        } else {
          localObject1 = this.context.getString(2131758200);
        }
      }
      else if (parambv.cVJ())
      {
        localObject1 = new li();
        ((li)localObject1).dzI.dzC = 1;
        ((li)localObject1).dzI.dlw = parambv;
        a.IvT.l((b)localObject1);
        localObject1 = String.format("[%s]", new Object[] { ((li)localObject1).dzJ.dvD });
      }
      else
      {
        Object localObject2;
        if (parambv.cVH())
        {
          localObject2 = k.b.zb(bu.aSA(parambv.field_content));
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
              localObject1 = ao.bJV().aMZ(((k.b)localObject2).dlu);
              if (localObject1 != null)
              {
                localObject1 = new k(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath);
                if (((k)localObject1).exists()) {
                  this.JYQ.add(com.tencent.mm.sdk.platformtools.o.a(this.context, (k)localObject1));
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
        else if (parambv.fvE())
        {
          bc.aCg();
          localObject1 = com.tencent.mm.model.c.azI().arp(parambv.field_content).nickname;
          localObject1 = String.format("[%s: %s]", new Object[] { this.context.getString(2131758195), localObject1 });
        }
        else if (parambv.cyG())
        {
          localObject1 = this.context.getString(2131758202);
          com.tencent.mm.modelvideo.o.aNh();
          localObject2 = String.format("[%s: %s(%s)]", new Object[] { localObject1, new k(t.HJ(parambv.field_imgPath)).getName(), this.context.getString(2131758194) });
          com.tencent.mm.modelvideo.o.aNh();
          k localk = new k(t.HJ(parambv.field_imgPath));
          localObject1 = localObject2;
          if (localk.exists())
          {
            this.JYQ.add(com.tencent.mm.sdk.platformtools.o.a(this.context, localk));
            localObject1 = localObject2;
          }
        }
        else if ((parambv.fvG()) || (parambv.fvH()))
        {
          localObject1 = String.format("[%s]", new Object[] { this.context.getString(2131758196) });
        }
      }
    }
  }
  
  private String bp(bv parambv)
  {
    AppMethodBeat.i(34846);
    String str = null;
    if (!x.wb(this.dAu.field_username)) {
      str = w.zP(parambv.field_talker);
    }
    for (;;)
    {
      if (parambv.field_isSend == 1)
      {
        ae.i("MicroMsg.OtherMailHistoryExporter", "isSend");
        str = v.aAE();
      }
      long l = parambv.field_createTime;
      parambv = new SimpleDateFormat("HH:mm").format(new Date(l));
      Object localObject = new StringBuilder("");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("  ");
      ((StringBuilder)localObject).append(parambv);
      parambv = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(34846);
      return parambv;
      localObject = parambv.field_content;
      int i = bl.BJ((String)localObject);
      if (i != -1) {
        str = w.zP(((String)localObject).substring(0, i).trim());
      }
    }
  }
  
  private String fGi()
  {
    AppMethodBeat.i(34844);
    Object localObject;
    if (!x.wb(this.dAu.field_username))
    {
      str1 = this.context.getString(2131763060);
      localObject = this.dAu.adF();
      bc.aCg();
      str1 = String.format(str1, new Object[] { localObject, com.tencent.mm.model.c.ajA().get(4, null) });
      AppMethodBeat.o(34844);
      return str1;
    }
    if (bu.isNullOrNil(this.dAu.field_nickname))
    {
      localObject = r.zA(this.dAu.field_username).iterator();
      String str2;
      for (str1 = ""; ((Iterator)localObject).hasNext(); str1 = str1 + str2 + ", ") {
        str2 = w.zP((String)((Iterator)localObject).next());
      }
    }
    for (String str1 = str1.substring(0, str1.length() - 2);; str1 = this.dAu.adF())
    {
      str1 = String.format(this.context.getString(2131763059), new Object[] { str1 });
      break;
    }
  }
  
  public final String fGh()
  {
    AppMethodBeat.i(34843);
    if (this.JYP == null) {}
    Object localObject1;
    for (boolean bool = true;; bool = false)
    {
      ae.d("MicroMsg.OtherMailHistoryExporter", "export: history is null? %B, selectItems.size = %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.JVr.size()) });
      if (this.JYP == null) {
        break;
      }
      localObject1 = this.JYP;
      AppMethodBeat.o(34843);
      return localObject1;
    }
    this.JYQ.clear();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(fGi());
    localStringBuilder.append("\n\n");
    Iterator localIterator = this.JVr.iterator();
    bv localbv;
    if (localIterator.hasNext())
    {
      localbv = (bv)localIterator.next();
      if (this.JYO == null)
      {
        this.JYO = Eo(localbv.field_createTime);
        localStringBuilder.append(String.format("—————  %s  —————\n\n", new Object[] { this.JYO }));
        localStringBuilder.append("\n");
        label196:
        if (!localbv.isText()) {
          break label428;
        }
        if (!localbv.isText()) {
          break label422;
        }
        if (localbv.field_isSend != 1) {
          break label324;
        }
        localObject1 = String.format("%s\n\n%s\n\n", new Object[] { bp(localbv), localbv.field_content });
      }
    }
    label422:
    label428:
    for (;;)
    {
      localStringBuilder.append((String)localObject1);
      break;
      localObject1 = Eo(localbv.field_createTime);
      if (((String)localObject1).equals(this.JYO)) {
        break label196;
      }
      this.JYO = ((String)localObject1);
      localStringBuilder.append(String.format("—————  %s  —————\n\n", new Object[] { this.JYO }));
      localStringBuilder.append("\n");
      break label196;
      label324:
      if (!x.wb(this.dAu.field_username))
      {
        localObject1 = String.format("%s\n\n%s\n\n", new Object[] { bp(localbv), localbv.field_content });
      }
      else
      {
        int i = bl.BJ(localbv.field_content);
        if (i != -1)
        {
          localObject1 = String.format("%s\n\n%s\n\n", new Object[] { bp(localbv), localbv.field_content.substring(i + 1).trim() });
          continue;
          localObject1 = null;
          continue;
          if (localbv.ftg())
          {
            if (localbv.ftg())
            {
              long l1 = localbv.field_msgId;
              long l2 = localbv.field_msgSvrId;
              Object localObject2 = ad.ck(localbv.field_talker, l1);
              localObject1 = localObject2;
              if (bu.isNullOrNil((String)localObject2)) {
                localObject1 = ad.cl(localbv.field_talker, l2);
              }
              ae.d("MicroMsg.OtherMailHistoryExporter", "imgPath[%s]", new Object[] { localObject1 });
              if (!bu.isNullOrNil((String)localObject1))
              {
                localObject1 = new k((String)localObject1);
                localObject2 = com.tencent.mm.sdk.platformtools.o.a(this.context, (k)localObject1);
                this.JYQ.add(localObject2);
                localObject1 = String.format("[%s: %s(%s)]", new Object[] { this.context.getString(2131758198), ((k)localObject1).getName(), this.context.getString(2131758194) });
              }
            }
            for (localObject1 = String.format("%s\n\n%s\n\n", new Object[] { bp(localbv), localObject1 });; localObject1 = null)
            {
              localStringBuilder.append((String)localObject1);
              break;
            }
          }
          if (localbv.cVH())
          {
            localObject1 = k.b.zb(localbv.field_content);
            if ((localObject1 != null) && ((((k.b)localObject1).type == 53) || (((k.b)localObject1).type == 57)))
            {
              if ((localObject1 != null) && ((((k.b)localObject1).type == 53) || (((k.b)localObject1).type == 57))) {}
              for (localObject1 = String.format("%s\n\n%s\n\n", new Object[] { bp(localbv), ((k.b)localObject1).title });; localObject1 = null)
              {
                localStringBuilder.append((String)localObject1);
                break;
              }
            }
            localStringBuilder.append(bo(localbv));
            break;
          }
          localStringBuilder.append(bo(localbv));
          break;
          localStringBuilder.append("\n\n");
          this.JYP = localStringBuilder.toString();
          localObject1 = this.JYP;
          AppMethodBeat.o(34843);
          return localObject1;
        }
        localObject1 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.aj
 * JD-Core Version:    0.7.0.1
 */