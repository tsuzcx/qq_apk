package com.tencent.mm.plugin.record.b;

import android.os.Looper;
import com.tencent.mm.R.g;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.as.d;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.pluginsdk.model.app.ac;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

final class k$b
  implements com.tencent.mm.ah.f, t.a, Runnable
{
  private boolean bur = false;
  private int i = 0;
  private com.tencent.mm.plugin.record.a.g nsL;
  HashMap<Long, Boolean> ntg = new HashMap();
  HashMap<Long, String> ntk = new HashMap();
  
  public k$b(k paramk, com.tencent.mm.plugin.record.a.g paramg)
  {
    this.nsL = paramg;
    com.tencent.mm.modelvideo.o.Sr().a(this, Looper.getMainLooper());
    au.Dk().a(221, this);
  }
  
  private void Y(bi parambi)
  {
    Object localObject = g.a.gp(parambi.field_content);
    if (localObject == null) {
      y.e("MicroMsg.RecordMsgSendService", "parse msgContent error, %s", new Object[] { parambi.field_content });
    }
    do
    {
      return;
      if ((bk.bl(((g.a)localObject).bFE)) && (!bk.bl(((g.a)localObject).dQK)))
      {
        y.e("MicroMsg.RecordMsgSendService", "msgContent format error, %s", new Object[] { parambi.field_content });
        ((g.a)localObject).bFE = ((g.a)localObject).dQK.hashCode();
      }
      localObject = ((g.a)localObject).bFE;
    } while (l.a(parambi, l.ap((String)localObject, parambi.field_msgId)));
    this.ntg.put(Long.valueOf(parambi.field_msgId), Boolean.valueOf(false));
    this.ntk.put(Long.valueOf(parambi.field_msgId), localObject);
    l.a(parambi, null);
  }
  
  private void a(HashMap<Long, Boolean> paramHashMap, boolean paramBoolean, com.tencent.mm.plugin.record.a.g paramg)
  {
    if (paramHashMap != null)
    {
      paramHashMap = paramHashMap.entrySet().iterator();
      do
      {
        if (!paramHashMap.hasNext()) {
          break;
        }
      } while (Boolean.valueOf(((Boolean)((Map.Entry)paramHashMap.next()).getValue()).booleanValue()).booleanValue());
    }
    for (int j = 0;; j = 1)
    {
      if ((j != 0) && (paramBoolean))
      {
        com.tencent.mm.modelvideo.o.Sr().a(this);
        paramg.field_type = 2;
        n.bvz().c(paramg, new String[] { "localId" });
        n.bvA().a(paramg);
      }
      return;
    }
  }
  
  public final void a(t.a.a parama)
  {
    parama = u.oe(parama.fileName);
    if (parama != null)
    {
      au.Hx();
      bi localbi = c.Fy().fd(parama.eHI);
      if (parama.SG())
      {
        this.ntg.put(Long.valueOf(localbi.field_msgId), Boolean.valueOf(true));
        a(this.ntg, this.bur, this.nsL);
      }
      return;
    }
    a(null, this.bur, this.nsL);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm instanceof ac))
    {
      au.Dk().b(221, this);
      if (this.ntk != null) {
        paramm = this.ntk.entrySet().iterator();
      }
    }
    label264:
    label267:
    for (;;)
    {
      long l;
      b localb;
      if (paramm.hasNext())
      {
        paramString = (Map.Entry)paramm.next();
        l = ((Long)paramString.getKey()).longValue();
        paramString = (String)paramString.getValue();
        if ((l <= 0L) || (((Boolean)this.ntg.get(Long.valueOf(l))).booleanValue())) {
          continue;
        }
        au.Hx();
        c.Fy().fd(l);
        localb = l.ap(paramString, l);
        if (localb == null) {
          break label264;
        }
      }
      for (paramString = localb.field_fileFullPath;; paramString = null)
      {
        if ((paramString == null) || (paramString.length() <= 0)) {
          break label267;
        }
        this.ntg.put(Long.valueOf(l), Boolean.valueOf(true));
        paramString = this.nsL.field_dataProto.sXc.iterator();
        while (paramString.hasNext())
        {
          xv localxv = (xv)paramString.next();
          if (localxv.sVM == l) {
            localxv.XI(localb.field_fileFullPath);
          }
        }
        break;
        a(this.ntg, this.bur, this.nsL);
        return;
        a(null, this.bur, this.nsL);
        return;
      }
    }
  }
  
  public final void run()
  {
    this.i = 0;
    this.bur = false;
    Iterator localIterator = this.nsL.field_dataProto.sXc.iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (xv)localIterator.next();
      long l = ((xv)localObject1).sVM;
      if (l > 0L)
      {
        au.Hx();
        bi localbi = c.Fy().fd(l);
        Object localObject2 = ((xv)localObject1).sVe;
        if ((System.currentTimeMillis() - localbi.field_createTime > 259200000L) && ((bk.bl((String)localObject2)) || (!com.tencent.mm.vfs.e.bK((String)localObject2)))) {}
        for (int j = 1;; j = 0)
        {
          if (j == 0) {
            break label150;
          }
          y.i("MicroMsg.RecordMsgSendService", "dataItem is expired!! msgType:%s", new Object[] { Integer.valueOf(localbi.getType()) });
          break;
        }
        label150:
        if (((xv)localObject1).aYU == 2)
        {
          if (localbi.ctB())
          {
            localObject2 = com.tencent.mm.as.o.OJ().bX(localbi.field_msgSvrId);
            if (localbi.field_isSend == 1) {
              if (((com.tencent.mm.as.e)localObject2).Or()) {
                j = 1;
              }
            }
            for (;;)
            {
              if ((((com.tencent.mm.as.e)localObject2).offset >= ((com.tencent.mm.as.e)localObject2).ebK) && (((com.tencent.mm.as.e)localObject2).ebK != 0)) {
                break label350;
              }
              this.ntg.put(Long.valueOf(l), Boolean.valueOf(false));
              this.i = this.nsL.field_dataProto.sXc.indexOf(localObject1);
              com.tencent.mm.as.o.OK().a(((com.tencent.mm.as.e)localObject2).enp, localbi.field_msgId, j, localObject1, R.g.chat_img_template, new k.b.1(this, (com.tencent.mm.as.e)localObject2, localbi, l));
              break;
              j = 0;
              continue;
              if (!((com.tencent.mm.as.e)localObject2).Or())
              {
                j = 0;
              }
              else
              {
                com.tencent.mm.as.e locale = com.tencent.mm.as.f.a((com.tencent.mm.as.e)localObject2);
                if (!com.tencent.mm.vfs.e.bK(com.tencent.mm.as.o.OJ().o(locale.enq, "", ""))) {
                  j = 0;
                } else {
                  j = 1;
                }
              }
            }
          }
          else
          {
            label350:
            if (localbi.cvr()) {
              Y(localbi);
            }
          }
        }
        else if ((((xv)localObject1).aYU == 4) || (((xv)localObject1).aYU == 15))
        {
          localObject1 = u.oe(localbi.field_imgPath);
          if ((localObject1 != null) && (((s)localObject1).status != 199))
          {
            this.ntg.put(Long.valueOf(l), Boolean.valueOf(false));
            if (((s)localObject1).SF())
            {
              y.i("MicroMsg.RecordMsgSendService", "start complete online video");
              u.oj(localbi.field_imgPath);
            }
            else
            {
              y.i("MicroMsg.RecordMsgSendService", "start complete offline video");
              u.oa(localbi.field_imgPath);
            }
          }
        }
        else if ((((xv)localObject1).aYU == 8) && (!bk.bl(((xv)localObject1).sVY)))
        {
          Y(localbi);
        }
      }
    }
    this.bur = true;
    this.ntj.nsO = false;
    a(this.ntg, this.bur, this.nsL);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.k.b
 * JD-Core Version:    0.7.0.1
 */