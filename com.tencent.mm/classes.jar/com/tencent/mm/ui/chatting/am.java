package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.nw;
import com.tencent.mm.autogen.a.nw.b;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.model.app.as;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.cc.a;
import com.tencent.mm.vfs.u;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public final class am
{
  List<cc> aehr;
  private String aelj;
  String aelk;
  ArrayList<Uri> aell;
  private Context context;
  private au hRm;
  private SimpleDateFormat vaj;
  
  public am(Context paramContext, List<cc> paramList, au paramau)
  {
    AppMethodBeat.i(34842);
    this.aelj = null;
    this.hRm = null;
    this.vaj = new SimpleDateFormat("yyyy-MM-dd");
    this.aelk = null;
    this.aell = new ArrayList();
    this.context = paramContext;
    this.aehr = paramList;
    this.hRm = paramau;
    AppMethodBeat.o(34842);
  }
  
  private String cl(cc paramcc)
  {
    AppMethodBeat.i(34845);
    Object localObject1 = null;
    if (paramcc.iYj()) {
      localObject1 = String.format("[%s]", new Object[] { this.context.getString(R.l.gFm) });
    }
    for (;;)
    {
      Log.i("MicroMsg.OtherMailHistoryExporter", "formatOtherMsg, msgStr = %s", new Object[] { localObject1 });
      paramcc = String.format("%s\n\n%s\n\n", new Object[] { cm(paramcc), localObject1 });
      AppMethodBeat.o(34845);
      return paramcc;
      if (paramcc.jbx())
      {
        if (paramcc.field_isSend == 1) {
          localObject1 = this.context.getString(R.l.gFk);
        } else {
          localObject1 = this.context.getString(R.l.gFj);
        }
      }
      else if (paramcc.fxT())
      {
        localObject1 = new nw();
        ((nw)localObject1).hQs.hQm = 1;
        ((nw)localObject1).hQs.hzO = paramcc;
        ((nw)localObject1).publish();
        localObject1 = String.format("[%s]", new Object[] { ((nw)localObject1).hQt.hLS });
      }
      else
      {
        Object localObject2;
        if (paramcc.fxR())
        {
          localObject2 = k.b.Hf(Util.processXml(paramcc.field_content));
          if (localObject2 != null)
          {
            switch (((k.b)localObject2).type)
            {
            }
            for (;;)
            {
              localObject1 = h.s(((k.b)localObject2).appId, true, false);
              if (localObject1 != null) {
                break label309;
              }
              localObject1 = "";
              break;
              localObject1 = as.cWJ().bpI(((k.b)localObject2).hzM);
              if (localObject1 != null)
              {
                localObject1 = new u(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath);
                if (((u)localObject1).jKS()) {
                  this.aell.add(FileProviderHelper.getUriForFile(this.context, (u)localObject1));
                }
              }
            }
            label309:
            localObject1 = ((g)localObject1).field_appName;
            if (6 == ((k.b)localObject2).type) {
              localObject1 = String.format("[%s: %s(%s)]", new Object[] { this.context.getString(R.l.gFc), localObject1, this.context.getString(R.l.gFd) });
            } else {
              localObject1 = String.format("[%s: %s]", new Object[] { this.context.getString(R.l.gFc), localObject1 });
            }
          }
        }
        else if (paramcc.jbB())
        {
          bh.bCz();
          localObject1 = com.tencent.mm.model.c.bzD().aLU(paramcc.field_content).nickname;
          localObject1 = String.format("[%s: %s]", new Object[] { this.context.getString(R.l.gFe), localObject1 });
        }
        else if (paramcc.dSH())
        {
          localObject1 = this.context.getString(R.l.gFl);
          com.tencent.mm.modelvideo.v.bOh();
          localObject2 = String.format("[%s: %s(%s)]", new Object[] { localObject1, new u(com.tencent.mm.modelvideo.aa.PX(paramcc.field_imgPath)).getName(), this.context.getString(R.l.gFd) });
          com.tencent.mm.modelvideo.v.bOh();
          u localu = new u(com.tencent.mm.modelvideo.aa.PX(paramcc.field_imgPath));
          localObject1 = localObject2;
          if (localu.jKS())
          {
            this.aell.add(FileProviderHelper.getUriForFile(this.context, localu));
            localObject1 = localObject2;
          }
        }
        else if ((paramcc.jbG()) || (paramcc.jbH()))
        {
          localObject1 = String.format("[%s]", new Object[] { this.context.getString(R.l.gFf) });
        }
      }
    }
  }
  
  private String cm(cc paramcc)
  {
    AppMethodBeat.i(34846);
    String str = null;
    if (!au.bwE(this.hRm.field_username)) {
      str = com.tencent.mm.model.aa.getDisplayName(paramcc.field_talker);
    }
    for (;;)
    {
      if (paramcc.field_isSend == 1)
      {
        Log.i("MicroMsg.OtherMailHistoryExporter", "isSend");
        str = z.bAO();
      }
      long l = paramcc.getCreateTime();
      paramcc = new SimpleDateFormat("HH:mm").format(new Date(l));
      Object localObject = new StringBuilder("");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("  ");
      ((StringBuilder)localObject).append(paramcc);
      paramcc = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(34846);
      return paramcc;
      localObject = paramcc.field_content;
      int i = br.JG((String)localObject);
      if (i != -1) {
        str = com.tencent.mm.model.aa.getDisplayName(((String)localObject).substring(0, i).trim());
      }
    }
  }
  
  private String jqc()
  {
    AppMethodBeat.i(34844);
    Object localObject;
    if (!au.bwE(this.hRm.field_username))
    {
      str1 = this.context.getString(R.l.gUO);
      localObject = this.hRm.aSU();
      bh.bCz();
      str1 = String.format(str1, new Object[] { localObject, com.tencent.mm.model.c.ban().d(4, null) });
      AppMethodBeat.o(34844);
      return str1;
    }
    if (Util.isNullOrNil(this.hRm.field_nickname))
    {
      localObject = com.tencent.mm.model.v.Il(this.hRm.field_username).iterator();
      String str2;
      for (str1 = ""; ((Iterator)localObject).hasNext(); str1 = str1 + str2 + ", ") {
        str2 = com.tencent.mm.model.aa.getDisplayName((String)((Iterator)localObject).next());
      }
    }
    for (String str1 = str1.substring(0, str1.length() - 2);; str1 = this.hRm.aSU())
    {
      str1 = String.format(this.context.getString(R.l.gUN), new Object[] { str1 });
      break;
    }
  }
  
  private String zI(long paramLong)
  {
    AppMethodBeat.i(34847);
    String str = this.vaj.format(new Date(paramLong));
    AppMethodBeat.o(34847);
    return str;
  }
  
  public final String jqb()
  {
    AppMethodBeat.i(34843);
    if (this.aelk == null) {}
    Object localObject1;
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.OtherMailHistoryExporter", "export: history is null? %B, selectItems.size = %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.aehr.size()) });
      if (this.aelk == null) {
        break;
      }
      localObject1 = this.aelk;
      AppMethodBeat.o(34843);
      return localObject1;
    }
    this.aell.clear();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jqc());
    localStringBuilder.append("\n\n");
    Iterator localIterator = this.aehr.iterator();
    cc localcc;
    if (localIterator.hasNext())
    {
      localcc = (cc)localIterator.next();
      if (this.aelj == null)
      {
        this.aelj = zI(localcc.getCreateTime());
        localStringBuilder.append(String.format("—————  %s  —————\n\n", new Object[] { this.aelj }));
        localStringBuilder.append("\n");
        label196:
        if (!localcc.iYl()) {
          break label428;
        }
        if (!localcc.iYl()) {
          break label422;
        }
        if (localcc.field_isSend != 1) {
          break label324;
        }
        localObject1 = String.format("%s\n\n%s\n\n", new Object[] { cm(localcc), localcc.field_content });
      }
    }
    label422:
    label428:
    for (;;)
    {
      localStringBuilder.append((String)localObject1);
      break;
      localObject1 = zI(localcc.getCreateTime());
      if (((String)localObject1).equals(this.aelj)) {
        break label196;
      }
      this.aelj = ((String)localObject1);
      localStringBuilder.append(String.format("—————  %s  —————\n\n", new Object[] { this.aelj }));
      localStringBuilder.append("\n");
      break label196;
      label324:
      if (!au.bwE(this.hRm.field_username))
      {
        localObject1 = String.format("%s\n\n%s\n\n", new Object[] { cm(localcc), localcc.field_content });
      }
      else
      {
        int i = br.JG(localcc.field_content);
        if (i != -1)
        {
          localObject1 = String.format("%s\n\n%s\n\n", new Object[] { cm(localcc), localcc.field_content.substring(i + 1).trim() });
          continue;
          localObject1 = null;
          continue;
          if (localcc.iYk())
          {
            if (localcc.iYk())
            {
              long l1 = localcc.field_msgId;
              long l2 = localcc.field_msgSvrId;
              Object localObject2 = af.cy(localcc.field_talker, l1);
              localObject1 = localObject2;
              if (Util.isNullOrNil((String)localObject2)) {
                localObject1 = af.cz(localcc.field_talker, l2);
              }
              Log.d("MicroMsg.OtherMailHistoryExporter", "imgPath[%s]", new Object[] { localObject1 });
              if (!Util.isNullOrNil((String)localObject1))
              {
                localObject1 = new u((String)localObject1);
                localObject2 = FileProviderHelper.getUriForFile(this.context, (u)localObject1);
                this.aell.add(localObject2);
                localObject1 = String.format("[%s: %s(%s)]", new Object[] { this.context.getString(R.l.gFh), ((u)localObject1).getName(), this.context.getString(R.l.gFd) });
              }
            }
            for (localObject1 = String.format("%s\n\n%s\n\n", new Object[] { cm(localcc), localObject1 });; localObject1 = null)
            {
              localStringBuilder.append((String)localObject1);
              break;
            }
          }
          if (localcc.fxR())
          {
            localObject1 = k.b.Hf(localcc.field_content);
            if ((localObject1 != null) && ((((k.b)localObject1).type == 53) || (((k.b)localObject1).type == 57)))
            {
              if ((localObject1 != null) && ((((k.b)localObject1).type == 53) || (((k.b)localObject1).type == 57))) {}
              for (localObject1 = String.format("%s\n\n%s\n\n", new Object[] { cm(localcc), ((k.b)localObject1).title });; localObject1 = null)
              {
                localStringBuilder.append((String)localObject1);
                break;
              }
            }
            localStringBuilder.append(cl(localcc));
            break;
          }
          localStringBuilder.append(cl(localcc));
          break;
          localStringBuilder.append("\n\n");
          this.aelk = localStringBuilder.toString();
          localObject1 = this.aelk;
          AppMethodBeat.o(34843);
          return localObject1;
        }
        localObject1 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.am
 * JD-Core Version:    0.7.0.1
 */