package com.tencent.mm.plugin.wear.model;

import android.os.Looper;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.aj.e;
import com.tencent.mm.g.a.vx;
import com.tencent.mm.g.a.vx.a;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.b;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.wear.model.e.i;
import com.tencent.mm.protocal.protobuf.cwy;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.LinkedList;
import java.util.List;

public final class b
  implements com.tencent.mm.ai.f
{
  n.b mTY;
  boolean uGM;
  com.tencent.mm.sdk.b.c uGN;
  ap uGO;
  
  public b()
  {
    AppMethodBeat.i(26280);
    this.uGN = new b.1(this);
    this.mTY = new b.3(this);
    this.uGO = new ap(Looper.getMainLooper(), new b.4(this), true);
    com.tencent.mm.sdk.b.a.ymk.c(this.uGN);
    aw.aaz();
    com.tencent.mm.model.c.YA().a(this.mTY);
    AppMethodBeat.o(26280);
  }
  
  public static void a(cwy paramcwy)
  {
    AppMethodBeat.i(26285);
    if (paramcwy != null)
    {
      vx localvx = new vx();
      localvx.cNm.coO = 6;
      localvx.cNm.bYu = paramcwy.yeC;
      com.tencent.mm.sdk.b.a.ymk.l(localvx);
      AppMethodBeat.o(26285);
      return;
    }
    ab.i("MicroMsg.Wear.WearBizLogic", "request is null");
    AppMethodBeat.o(26285);
  }
  
  static boolean aga(String paramString)
  {
    AppMethodBeat.i(26283);
    vx localvx = new vx();
    localvx.cNm.coO = 3;
    localvx.cNm.bYu = paramString;
    localvx.cNm.cqJ = "gh_43f2581f6fd6";
    com.tencent.mm.sdk.b.a.ymk.l(localvx);
    ab.i("MicroMsg.Wear.WearBizLogic", "isRegister: %b", new Object[] { Boolean.valueOf(localvx.cNm.csk) });
    boolean bool = localvx.cNm.csk;
    AppMethodBeat.o(26283);
    return bool;
  }
  
  static boolean cYz()
  {
    AppMethodBeat.i(26284);
    aw.aaz();
    boolean bool = com.tencent.mm.n.a.je(com.tencent.mm.model.c.YA().arw("gh_43f2581f6fd6").field_type);
    AppMethodBeat.o(26284);
    return bool;
  }
  
  public final void connect()
  {
    AppMethodBeat.i(26281);
    Object localObject = a.cYy().uGC.uGT.uHH;
    if (localObject == null)
    {
      ab.e("MicroMsg.Wear.WearBizLogic", "get connect wear data error");
      AppMethodBeat.o(26281);
      return;
    }
    if (!cYz())
    {
      aw.aaz();
      boolean bool = ((Boolean)com.tencent.mm.model.c.Ru().get(327825, Boolean.FALSE)).booleanValue();
      ab.i("MicroMsg.Wear.WearBizLogic", "auto focus biz contact %b", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        if (bo.hl(ah.getContext()))
        {
          ab.i("MicroMsg.Wear.WearBizLogic", "oversea user, forbid biz auto focus logic");
          AppMethodBeat.o(26281);
          return;
        }
        a.cYy().uGI.a(new a((byte)0));
        a.cYy().uGI.a(new b.b(this, (cwy)localObject));
      }
      AppMethodBeat.o(26281);
      return;
    }
    if (!aga(((cwy)localObject).yeC))
    {
      ab.i("MicroMsg.Wear.WearBizLogic", "start to register device %s", new Object[] { ((cwy)localObject).yeC });
      a.cYy().uGI.a(new b.b(this, (cwy)localObject));
      AppMethodBeat.o(26281);
      return;
    }
    if (!this.uGM)
    {
      ab.i("MicroMsg.Wear.WearBizLogic", "start to auth device %s", new Object[] { ((cwy)localObject).yeC });
      localObject = ((cwy)localObject).yeC;
      if ((!this.uGM) && (aga((String)localObject)))
      {
        ab.i("MicroMsg.Wear.WearBizLogic", "auth device, deviceId=%s | deviceType=%s", new Object[] { localObject, "gh_43f2581f6fd6" });
        vx localvx = new vx();
        localvx.cNm.coO = 7;
        localvx.cNm.bYu = ((String)localObject);
        localvx.cNm.cqJ = "gh_43f2581f6fd6";
        com.tencent.mm.sdk.b.a.ymk.l(localvx);
      }
      AppMethodBeat.o(26281);
      return;
    }
    if (this.uGO.dtj())
    {
      ab.i("MicroMsg.Wear.WearBizLogic", "start step count timer");
      this.uGO.ag(3600000L, 3600000L);
    }
    for (;;)
    {
      a((cwy)localObject);
      AppMethodBeat.o(26281);
      return;
      ab.i("MicroMsg.Wear.WearBizLogic", "stop timer and restart step count timer");
      this.uGO.stopTimer();
      this.uGO.ag(3600000L, 3600000L);
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(26282);
    Object localObject;
    if ((paramm instanceof com.tencent.mm.plugin.wear.model.d.a))
    {
      aw.Rc().b(1091, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ab.e("MicroMsg.Wear.WearBizLogic", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        AppMethodBeat.o(26282);
        return;
      }
      paramm = (com.tencent.mm.plugin.wear.model.d.a)paramm;
      paramString = paramm.bYu;
      paramm = paramm.cqJ;
      localObject = new vx();
      ((vx)localObject).cNm.coO = 1;
      ((vx)localObject).cNm.bYu = paramString;
      ((vx)localObject).cNm.cqJ = paramm;
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
      AppMethodBeat.o(26282);
      return;
    }
    if ((paramm instanceof com.tencent.mm.pluginsdk.model.m))
    {
      aw.Rc().b(30, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ab.e("MicroMsg.Wear.WearBizLogic", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        if ((paramInt1 == 4) && (paramInt2 == -24) && (!bo.isNullOrNil(paramString)))
        {
          Toast.makeText(ah.getContext(), paramString, 1).show();
          AppMethodBeat.o(26282);
        }
      }
      else
      {
        localObject = ((com.tencent.mm.pluginsdk.model.m)paramm).dlk();
        ab.i("MicroMsg.Wear.WearBizLogic", "bind fitness contact %s success", new Object[] { localObject });
        aw.aaz();
        paramm = com.tencent.mm.model.c.YA().arw("gh_43f2581f6fd6");
        if ((paramm != null) && (!bo.isNullOrNil((String)localObject))) {
          break label369;
        }
        ab.e("MicroMsg.Wear.WearBizLogic", "respUsername == " + (String)localObject + ", contact = " + paramm);
      }
    }
    for (;;)
    {
      paramString = com.tencent.mm.aj.z.afi().rK(paramm.field_username);
      com.tencent.mm.aj.z.afi().e(paramString);
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(327825, Boolean.TRUE);
      connect();
      AppMethodBeat.o(26282);
      return;
      label369:
      paramString = null;
      if (t.nS(paramm.field_username))
      {
        String str = bo.nullAsNil(paramm.field_username);
        paramString = com.tencent.mm.aj.f.rS(str);
        if (paramString != null) {
          paramString.field_username = ((String)localObject);
        }
        com.tencent.mm.aj.z.afi().delete(str);
        paramm.jv(str);
      }
      paramm.setUsername((String)localObject);
      if ((int)paramm.euF == 0)
      {
        aw.aaz();
        com.tencent.mm.model.c.YA().Z(paramm);
      }
      if ((int)paramm.euF <= 0)
      {
        ab.e("MicroMsg.Wear.WearBizLogic", "addContact : insert contact failed");
      }
      else
      {
        t.q(paramm);
        aw.aaz();
        localObject = com.tencent.mm.model.c.YA().arw(paramm.field_username);
        if (paramString != null)
        {
          com.tencent.mm.aj.z.afi().d(paramString);
        }
        else
        {
          paramString = com.tencent.mm.aj.f.rS(((aq)localObject).field_username);
          if ((paramString == null) || (paramString.aea()))
          {
            ab.d("MicroMsg.Wear.WearBizLogic", "shouldUpdate");
            ao.a.flI.am(((aq)localObject).field_username, "");
            com.tencent.mm.ah.b.qT(((aq)localObject).field_username);
          }
          else if (((ad)localObject).dwC())
          {
            ab.d("MicroMsg.Wear.WearBizLogic", "update contact, last check time=%d", new Object[] { Integer.valueOf(((aq)localObject).dqR) });
            ao.a.flI.am(((aq)localObject).field_username, "");
            com.tencent.mm.ah.b.qT(((aq)localObject).field_username);
          }
        }
      }
    }
  }
  
  final class a
    extends com.tencent.mm.plugin.wear.model.f.d
  {
    private a() {}
    
    public final void execute()
    {
      AppMethodBeat.i(26278);
      aw.Rc().a(30, b.this);
      Object localObject = new LinkedList();
      ((LinkedList)localObject).add("gh_43f2581f6fd6");
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(Integer.valueOf(1));
      localObject = new com.tencent.mm.pluginsdk.model.m((List)localObject, localLinkedList, "", "");
      aw.Rc().a((com.tencent.mm.ai.m)localObject, 0);
      AppMethodBeat.o(26278);
    }
    
    public final String getName()
    {
      return "AddContactTask";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.b
 * JD-Core Version:    0.7.0.1
 */