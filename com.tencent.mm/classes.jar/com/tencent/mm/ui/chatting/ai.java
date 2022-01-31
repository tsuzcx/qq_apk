package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.g.a.jm;
import com.tencent.mm.g.a.jm.b;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.n;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
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

public final class ai
{
  private Context context;
  private ad czH;
  private SimpleDateFormat jCL;
  String mVj;
  private String zBZ;
  ArrayList<Uri> zCa;
  List<bi> zyt;
  
  public ai(Context paramContext, List<bi> paramList, ad paramad)
  {
    AppMethodBeat.i(30962);
    this.zBZ = null;
    this.czH = null;
    this.jCL = new SimpleDateFormat("yyyy-MM-dd");
    this.mVj = null;
    this.zCa = new ArrayList();
    this.context = paramContext;
    this.zyt = paramList;
    this.czH = paramad;
    AppMethodBeat.o(30962);
  }
  
  private String aQ(bi parambi)
  {
    AppMethodBeat.i(30965);
    String str = null;
    if (!com.tencent.mm.model.t.lA(this.czH.field_username)) {
      str = s.nE(parambi.field_talker);
    }
    for (;;)
    {
      if (parambi.field_isSend == 1)
      {
        ab.i("MicroMsg.OtherMailHistoryExporter", "isSend");
        str = r.Zp();
      }
      long l = parambi.field_createTime;
      parambi = new SimpleDateFormat("HH:mm").format(new Date(l));
      Object localObject = new StringBuilder("");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("  ");
      ((StringBuilder)localObject).append(parambi);
      parambi = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(30965);
      return parambi;
      localObject = parambi.field_content;
      int i = bf.pt((String)localObject);
      if (i != -1) {
        str = s.nE(((String)localObject).substring(0, i).trim());
      }
    }
  }
  
  private String dGW()
  {
    AppMethodBeat.i(30964);
    Object localObject;
    if (!com.tencent.mm.model.t.lA(this.czH.field_username))
    {
      str1 = this.context.getString(2131303111);
      localObject = this.czH.Oe();
      aw.aaz();
      str1 = String.format(str1, new Object[] { localObject, com.tencent.mm.model.c.Ru().get(4, null) });
      AppMethodBeat.o(30964);
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
  
  private String oA(long paramLong)
  {
    AppMethodBeat.i(30966);
    String str = this.jCL.format(new Date(paramLong));
    AppMethodBeat.o(30966);
    return str;
  }
  
  public final String dGV()
  {
    AppMethodBeat.i(30963);
    if (this.mVj == null) {}
    Object localObject1;
    for (boolean bool = true;; bool = false)
    {
      ab.d("MicroMsg.OtherMailHistoryExporter", "export: history is null? %B, selectItems.size = %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.zyt.size()) });
      if (this.mVj == null) {
        break;
      }
      localObject1 = this.mVj;
      AppMethodBeat.o(30963);
      return localObject1;
    }
    this.zCa.clear();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(dGW());
    localStringBuilder.append("\n\n");
    Iterator localIterator = this.zyt.iterator();
    bi localbi;
    if (localIterator.hasNext())
    {
      localbi = (bi)localIterator.next();
      if (this.zBZ == null)
      {
        this.zBZ = oA(localbi.field_createTime);
        localStringBuilder.append(String.format("—————  %s  —————\n\n", new Object[] { this.zBZ }));
        localStringBuilder.append("\n");
        label194:
        if (!localbi.isText()) {
          break label429;
        }
        if (!localbi.isText()) {
          break label423;
        }
        if (localbi.field_isSend != 1) {
          break label323;
        }
        localObject1 = String.format("%s\n\n%s\n\n", new Object[] { aQ(localbi), localbi.field_content });
      }
    }
    label423:
    label429:
    for (;;)
    {
      localStringBuilder.append((String)localObject1);
      break;
      localObject1 = oA(localbi.field_createTime);
      if (((String)localObject1).equals(this.zBZ)) {
        break label194;
      }
      this.zBZ = ((String)localObject1);
      localStringBuilder.append(String.format("—————  %s  —————\n\n", new Object[] { this.zBZ }));
      localStringBuilder.append("\n");
      break label194;
      label323:
      if (!com.tencent.mm.model.t.lA(this.czH.field_username))
      {
        localObject1 = String.format("%s\n\n%s\n\n", new Object[] { aQ(localbi), localbi.field_content });
      }
      else
      {
        int i = bf.pt(localbi.field_content);
        if (i != -1)
        {
          localObject1 = String.format("%s\n\n%s\n\n", new Object[] { aQ(localbi), localbi.field_content.substring(i + 1).trim() });
          continue;
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
              ab.d("MicroMsg.OtherMailHistoryExporter", "hdPath[%s]", new Object[] { localObject1 });
              if (!bo.isNullOrNil((String)localObject1))
              {
                localObject2 = "content://".concat(String.valueOf(localObject1));
                this.zCa.add(Uri.parse((String)localObject2));
                localObject1 = String.format("[%s: %s(%s)]", new Object[] { this.context.getString(2131299087), new File((String)localObject1).getName(), this.context.getString(2131299083) });
              }
            }
            for (localObject1 = String.format("%s\n\n%s\n\n", new Object[] { aQ(localbi), localObject1 });; localObject1 = null)
            {
              localStringBuilder.append((String)localObject1);
              break;
            }
          }
          if (localbi.dvW()) {
            localObject1 = String.format("[%s]", new Object[] { this.context.getString(2131299092) });
          }
          for (;;)
          {
            ab.i("MicroMsg.OtherMailHistoryExporter", "formatOtherMsg, msgStr = %s", new Object[] { localObject1 });
            localStringBuilder.append(String.format("%s\n\n%s\n\n", new Object[] { aQ(localbi), localObject1 }));
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
              a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
              localObject1 = String.format("[%s]", new Object[] { ((jm)localObject1).cza.cvF });
            }
            else
            {
              if (localbi.bCn())
              {
                localObject1 = j.b.mY(bo.apU(localbi.field_content));
                if (localObject1 != null)
                {
                  switch (((j.b)localObject1).type)
                  {
                  }
                  for (;;)
                  {
                    localObject2 = g.ca(((j.b)localObject1).appId, true);
                    if (localObject2 != null) {
                      break label967;
                    }
                    localObject1 = "";
                    break;
                    localObject2 = al.aUJ().alo(((j.b)localObject1).cmN);
                    if (localObject2 != null)
                    {
                      localObject2 = new File(((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_fileFullPath);
                      if (((File)localObject2).exists()) {
                        this.zCa.add(Uri.fromFile((File)localObject2));
                      }
                    }
                  }
                  label967:
                  localObject2 = ((f)localObject2).field_appName;
                  if (6 == ((j.b)localObject1).type)
                  {
                    localObject1 = String.format("[%s: %s(%s)]", new Object[] { this.context.getString(2131299082), localObject2, this.context.getString(2131299083) });
                    continue;
                  }
                  localObject1 = String.format("[%s: %s]", new Object[] { this.context.getString(2131299082), localObject2 });
                }
              }
              else
              {
                if (localbi.dxR())
                {
                  aw.aaz();
                  localObject1 = com.tencent.mm.model.c.YC().Ty(localbi.field_content).nickname;
                  localObject1 = String.format("[%s: %s]", new Object[] { this.context.getString(2131299084), localObject1 });
                  continue;
                }
                if (localbi.byj())
                {
                  localObject1 = this.context.getString(2131299091);
                  o.alE();
                  localObject2 = String.format("[%s: %s(%s)]", new Object[] { localObject1, new File(com.tencent.mm.modelvideo.t.vf(localbi.field_imgPath)).getName(), this.context.getString(2131299083) });
                  o.alE();
                  File localFile = new File(com.tencent.mm.modelvideo.t.vf(localbi.field_imgPath));
                  localObject1 = localObject2;
                  if (!localFile.exists()) {
                    continue;
                  }
                  this.zCa.add(Uri.fromFile(localFile));
                  localObject1 = localObject2;
                  continue;
                }
                if ((localbi.dxS()) || (localbi.dxT()))
                {
                  localObject1 = String.format("[%s]", new Object[] { this.context.getString(2131299085) });
                  continue;
                  localStringBuilder.append("\n\n");
                  this.mVj = localStringBuilder.toString();
                  localObject1 = this.mVj;
                  AppMethodBeat.o(30963);
                  return localObject1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ai
 * JD-Core Version:    0.7.0.1
 */