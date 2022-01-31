package com.tencent.mm.plugin.subapp.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.ai.e.b;
import com.tencent.mm.ai.e.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import java.util.LinkedList;
import java.util.Queue;

public final class b
  implements e, f
{
  private Queue<b.a> sWY = null;
  private boolean sWZ = false;
  
  private void cGR()
  {
    AppMethodBeat.i(25242);
    if (this.sWZ)
    {
      AppMethodBeat.o(25242);
      return;
    }
    if (this.sWY.size() == 0)
    {
      AppMethodBeat.o(25242);
      return;
    }
    Object localObject = (b.a)this.sWY.peek();
    if (((b.a)localObject).sXa.size() == 0)
    {
      this.sWY.poll();
      aw.aaz();
      c.Ru().set(8193, ((b.a)localObject).grD);
      aw.aaz();
      c.Ru().set(8449, Long.valueOf(bo.aox()));
      AppMethodBeat.o(25242);
      return;
    }
    localObject = (String)((b.a)localObject).sXa.peek();
    if ((localObject == null) || (((String)localObject).length() <= 0))
    {
      AppMethodBeat.o(25242);
      return;
    }
    this.sWZ = true;
    localObject = new a((String)localObject);
    aw.Rc().a(141, this);
    aw.Rc().a((m)localObject, 0);
    AppMethodBeat.o(25242);
  }
  
  public final void a(e.c paramc) {}
  
  public final e.b b(e.a parama)
  {
    AppMethodBeat.i(25241);
    parama = aa.a(parama.eyJ.woR);
    if (this.sWY == null) {
      this.sWY = new LinkedList();
    }
    parama = new b.a(parama);
    if (parama.grD != null)
    {
      this.sWY.offer(parama);
      cGR();
    }
    AppMethodBeat.o(25241);
    return null;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(25243);
    if (paramm.getType() != 141)
    {
      this.sWZ = false;
      AppMethodBeat.o(25243);
      return;
    }
    aw.Rc().b(141, this);
    paramString = ((a)paramm).url;
    paramm = (b.a)this.sWY.peek();
    if ((paramm == null) || (paramm.sXa.size() == 0))
    {
      ab.e("MicroMsg.PushMessageExtension", "getDoSceneQueue failed ! reset queue!");
      this.sWY = new LinkedList();
      this.sWZ = false;
      AppMethodBeat.o(25243);
      return;
    }
    if (paramm.sXa.size() == 0)
    {
      ab.e("MicroMsg.PushMessageExtension", "get imgQueue failed ! ignore this message");
      this.sWY.poll();
      this.sWZ = false;
      AppMethodBeat.o(25243);
      return;
    }
    if (!((String)paramm.sXa.peek()).equals(paramString))
    {
      ab.e("MicroMsg.PushMessageExtension", "check img url failed ! ignore this message");
      this.sWY.poll();
      this.sWZ = false;
      AppMethodBeat.o(25243);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ab.e("MicroMsg.PushMessageExtension", "down failed [" + paramInt1 + "," + paramInt2 + "] ignore this message : img:[" + paramString + "] ");
      this.sWY.poll();
      this.sWZ = false;
      AppMethodBeat.o(25243);
      return;
    }
    paramm.sXa.poll();
    this.sWZ = false;
    cGR();
    AppMethodBeat.o(25243);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.b.b
 * JD-Core Version:    0.7.0.1
 */