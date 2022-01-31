package com.tencent.mm.plugin.subapp.b;

import com.tencent.mm.ah.e;
import com.tencent.mm.ah.e.a;
import com.tencent.mm.ah.e.b;
import com.tencent.mm.ah.e.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.util.LinkedList;
import java.util.Queue;

public final class b
  implements e, f
{
  private Queue<b.a> pvt = null;
  private boolean pvu = false;
  
  private void bLV()
  {
    if (this.pvu) {}
    do
    {
      do
      {
        return;
      } while (this.pvt.size() == 0);
      localObject = (b.a)this.pvt.peek();
      if (((b.a)localObject).pvv.size() == 0)
      {
        this.pvt.poll();
        au.Hx();
        c.Dz().o(8193, ((b.a)localObject).eZK);
        au.Hx();
        c.Dz().o(8449, Long.valueOf(bk.UX()));
        return;
      }
      localObject = (String)((b.a)localObject).pvv.peek();
    } while ((localObject == null) || (((String)localObject).length() <= 0));
    this.pvu = true;
    Object localObject = new a((String)localObject);
    au.Dk().a(141, this);
    au.Dk().a((m)localObject, 0);
  }
  
  public final void a(e.c paramc) {}
  
  public final e.b b(e.a parama)
  {
    parama = aa.a(parama.dBs.svH);
    if (this.pvt == null) {
      this.pvt = new LinkedList();
    }
    parama = new b.a(parama);
    if (parama.eZK != null)
    {
      this.pvt.offer(parama);
      bLV();
    }
    return null;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (paramm.getType() != 141)
    {
      this.pvu = false;
      return;
    }
    au.Dk().b(141, this);
    paramString = ((a)paramm).url;
    paramm = (b.a)this.pvt.peek();
    if ((paramm == null) || (paramm.pvv.size() == 0))
    {
      y.e("MicroMsg.PushMessageExtension", "getDoSceneQueue failed ! reset queue!");
      this.pvt = new LinkedList();
      this.pvu = false;
      return;
    }
    if (paramm.pvv.size() == 0)
    {
      y.e("MicroMsg.PushMessageExtension", "get imgQueue failed ! ignore this message");
      this.pvt.poll();
      this.pvu = false;
      return;
    }
    if (!((String)paramm.pvv.peek()).equals(paramString))
    {
      y.e("MicroMsg.PushMessageExtension", "check img url failed ! ignore this message");
      this.pvt.poll();
      this.pvu = false;
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      y.e("MicroMsg.PushMessageExtension", "down failed [" + paramInt1 + "," + paramInt2 + "] ignore this message : img:[" + paramString + "] ");
      this.pvt.poll();
      this.pvu = false;
      return;
    }
    paramm.pvv.poll();
    this.pvu = false;
    bLV();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.b.b
 * JD-Core Version:    0.7.0.1
 */