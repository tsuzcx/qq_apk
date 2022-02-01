package com.tencent.mm.plugin.story.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.protocal.protobuf.fiu;
import com.tencent.mm.protocal.protobuf.fiv;
import com.tencent.mm.protocal.protobuf.fiw;
import com.tencent.mm.protocal.protobuf.fix;
import com.tencent.mm.protocal.protobuf.fja;
import com.tencent.mm.protocal.protobuf.fjb;
import com.tencent.mm.protocal.protobuf.fjc;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryObjectOp;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "opList", "", "Lcom/tencent/mm/plugin/story/model/cgi/BaseStoryOpItem;", "localIdList", "", "(Ljava/util/List;Ljava/util/List;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getCallback", "()Lcom/tencent/mm/modelbase/IOnSceneEnd;", "setCallback", "(Lcom/tencent/mm/modelbase/IOnSceneEnd;)V", "getLocalIdList", "()Ljava/util/List;", "getOpList", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getOp", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends p
  implements com.tencent.mm.network.m
{
  public static final a Slk;
  private static final String TAG;
  private final List<a> Sll;
  public final List<Integer> Slm;
  public h callback;
  private final c rr;
  
  static
  {
    AppMethodBeat.i(118818);
    Slk = new a((byte)0);
    TAG = "MicroMsg.StoryCgi.NetSceneStoryObjectOp";
    AppMethodBeat.o(118818);
  }
  
  public f(List<? extends a> paramList, List<Integer> paramList1)
  {
    AppMethodBeat.i(118816);
    this.Sll = paramList;
    this.Slm = paramList1;
    paramList = new c.a();
    paramList.otE = ((com.tencent.mm.bx.a)new fjb());
    paramList.otF = ((com.tencent.mm.bx.a)new fjc());
    paramList.uri = "/cgi-bin/micromsg-bin/mmstoryobjectop";
    paramList.funcId = 764;
    paramList.otG = 0;
    paramList.respCmdId = 0;
    paramList = paramList.bEF();
    kotlin.g.b.s.s(paramList, "builder.buildInstance()");
    this.rr = paramList;
    paramList = c.b.b(this.rr.otB);
    if (paramList == null)
    {
      paramList = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryOpRequest");
      AppMethodBeat.o(118816);
      throw paramList;
    }
    paramList = (fjb)paramList;
    paramList.abDW = this.Sll.size();
    paramList1 = this.Sll.iterator();
    if (paramList1.hasNext())
    {
      a locala = (a)paramList1.next();
      fja localfja = new fja();
      localfja.abIO = locala.idH;
      localfja.muC = locala.type;
      Log.i(TAG, "op.id:" + locala.idH + " op.type:" + locala.type);
      Object localObject;
      if ((locala instanceof l))
      {
        localObject = new fiw();
        ((fiw)localObject).abIO = locala.idH;
        localfja.abJS = new gol().df(((fiw)localObject).toByteArray());
      }
      for (;;)
      {
        paramList.abDX.add(localfja);
        break;
        if ((locala instanceof j))
        {
          localObject = new fiu();
          ((fiu)localObject).abDh = ((j)locala).Slv;
          localfja.abJS = new gol().df(((fiu)localObject).toByteArray());
        }
        else if ((locala instanceof m))
        {
          localObject = new fix();
          ((fix)localObject).abJI = ((m)locala).Slw;
          ((fix)localObject).abIO = locala.idH;
          localfja.abJS = new gol().df(((fix)localObject).toByteArray());
        }
        else if ((locala instanceof k))
        {
          localObject = new fiv();
          ((fiv)localObject).abJH = ((k)locala).favorite;
          ((fiv)localObject).abIO = locala.idH;
          localfja.abJS = new gol().df(((fiv)localObject).toByteArray());
        }
      }
    }
    AppMethodBeat.o(118816);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(118813);
    kotlin.g.b.s.u(paramg, "dispatcher");
    kotlin.g.b.s.u(paramh, "callback");
    kotlin.g.b.s.u(paramh, "<set-?>");
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (com.tencent.mm.network.m)this);
    AppMethodBeat.o(118813);
    return i;
  }
  
  public final int getType()
  {
    return 764;
  }
  
  public final a hwE()
  {
    AppMethodBeat.i(118815);
    if (this.Sll != null)
    {
      if (!((Collection)this.Sll).isEmpty()) {}
      for (int i = 1; i != 0; i = 0)
      {
        a locala = (a)this.Sll.get(0);
        AppMethodBeat.o(118815);
        return locala;
      }
    }
    AppMethodBeat.o(118815);
    return null;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(118814);
    Log.i(TAG, "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    params = c.c.b(this.rr.otC);
    if (params == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryOpResponse");
      AppMethodBeat.o(118814);
      throw paramString;
    }
    paramInt1 = ((fjc)params).abJT;
    Log.i(TAG, kotlin.g.b.s.X("respCount=", Integer.valueOf(paramInt1)));
    params = this.callback;
    if (params != null) {}
    for (;;)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
      AppMethodBeat.o(118814);
      return;
      kotlin.g.b.s.bIx("callback");
      params = null;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryObjectOp$Companion;", "", "()V", "TAG", "", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.a.f
 * JD-Core Version:    0.7.0.1
 */