package com.tencent.mm.plugin.story.model.a;

import a.l;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.model.cb;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.story.h.g;
import com.tencent.mm.plugin.story.model.i;
import com.tencent.mm.plugin.story.model.j.b;
import com.tencent.mm.plugin.story.model.n;
import com.tencent.mm.plugin.story.model.n.a;
import com.tencent.mm.protocal.protobuf.chs;
import com.tencent.mm.protocal.protobuf.cie;
import com.tencent.mm.protocal.protobuf.cif;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryUserPage;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "userName", "", "maxId", "", "isSelf", "", "mRoomId", "source", "", "(Ljava/lang/String;JZLjava/lang/String;I)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "forSameMd5Count", "fp", "getFp", "()Z", "setFp", "(Z)V", "setSelf", "getMRoomId", "()Ljava/lang/String;", "getMaxId", "()J", "setMaxId", "(J)V", "minId", "getMinId", "setMinId", "originMaxId", "recentLimitID", "getRecentLimitID", "setRecentLimitID", "requestMd5", "requestTime", "getRequestTime", "()I", "setRequestTime", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getSource", "sourceType", "getUserName", "setUserName", "(Ljava/lang/String;)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getInfo", "getType", "insertList", "", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "resp", "Lcom/tencent/mm/protocal/protobuf/StoryUserPageResponse;", "isFavSelectSource", "isFavSource", "isProfileSource", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"})
public final class j
  extends com.tencent.mm.ai.m
  implements com.tencent.mm.network.k
{
  private static final String TAG = "MicroMsg.StoryCgi.NetSceneStoryUserPage";
  private static final Vector<String> rfF;
  public static final j.a sxt;
  private com.tencent.mm.ai.f callback;
  private int cpG;
  public final int cpt;
  private boolean ctJ;
  private final String egF;
  private int reA;
  public boolean rew;
  private long rex;
  private long rey;
  public long rfK;
  private String rfa;
  private b rr;
  private long sxe;
  public int sxs;
  public String userName;
  
  static
  {
    AppMethodBeat.i(109258);
    sxt = new j.a((byte)0);
    TAG = "MicroMsg.StoryCgi.NetSceneStoryUserPage";
    rfF = new Vector();
    AppMethodBeat.o(109258);
  }
  
  public j(String paramString1, long paramLong, boolean paramBoolean, String paramString2, int paramInt)
  {
    AppMethodBeat.i(109256);
    this.userName = paramString1;
    this.rex = paramLong;
    this.ctJ = paramBoolean;
    this.egF = paramString2;
    this.cpt = paramInt;
    this.rfa = "";
    if (this.rex == 0L)
    {
      ab.i(TAG, "fp mUserName " + this.userName);
      if (!this.ctJ) {
        break label247;
      }
      paramString1 = com.tencent.mm.plugin.story.h.a.sFV;
    }
    for (paramInt = com.tencent.mm.plugin.story.h.a.cDO();; paramInt = com.tencent.mm.plugin.story.h.a.cDP())
    {
      this.cpG = paramInt;
      paramString1 = new b.a();
      paramString1.a((com.tencent.mm.bv.a)new cie());
      paramString1.b((com.tencent.mm.bv.a)new cif());
      paramString1.rl("/cgi-bin/micromsg-bin/mmstoryuserpage");
      paramString1.kT(273);
      paramString1.kU(400);
      paramString1.kV(1000000400);
      paramString1 = paramString1.ado();
      a.f.b.j.p(paramString1, "builder.buildInstance()");
      this.rr = paramString1;
      paramString1 = this.rr.adm();
      if (paramString1 != null) {
        break label259;
      }
      paramString1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryUserPageRequest");
      AppMethodBeat.o(109256);
      throw paramString1;
      ab.i(TAG, "np mUserName " + this.userName);
      break;
      label247:
      paramString1 = com.tencent.mm.plugin.story.h.a.sFV;
    }
    label259:
    cie localcie = (cie)paramString1;
    localcie.jJA = this.userName;
    localcie.xOl = this.rex;
    localcie.niK = this.cpt;
    if (this.rex == 0L) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.rew = paramBoolean;
      localcie.xPt = 0L;
      if (a.l.m.a((CharSequence)this.egF, "@", 0, false, 6) <= 0) {
        break label412;
      }
      paramString1 = this.egF;
      paramInt = a.l.m.a((CharSequence)this.egF, "@", 0, false, 6);
      if (paramString1 != null) {
        break;
      }
      paramString1 = new v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(109256);
      throw paramString1;
    }
    paramString1 = paramString1.substring(0, paramInt);
    a.f.b.j.p(paramString1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    localcie.xSP = bo.apW(paramString1);
    label412:
    localcie.xPu = 0;
    localcie.wot = this.egF;
    if (this.rew)
    {
      paramInt = this.cpt;
      paramString1 = com.tencent.mm.plugin.story.h.a.sFV;
      if (paramInt != com.tencent.mm.plugin.story.h.a.cEv()) {
        break label652;
      }
      paramString1 = com.tencent.mm.plugin.story.model.j.svi;
      paramString1 = j.b.cAC();
      paramString2 = this.userName;
      a.f.b.j.q(paramString2, "userName");
      paramString2 = paramString1.adz(paramString2).field_favoriteMd5;
      paramString1 = paramString2;
      if (paramString2 != null) {}
    }
    for (paramString1 = "";; paramString1 = j.b.cAC().adA(this.userName))
    {
      this.rfa = paramString1;
      if (this.rfa == null) {
        this.rfa = "";
      }
      localcie.xOk = this.rfa;
      this.sxe = this.rex;
      ab.i(TAG, this + " req.mUserName:" + localcie.jJA + " req.MaxId:" + localcie.xOl + " req.MinFilterId:" + localcie.xPt + " req.LastRequestTime:" + localcie.xPu + " ChatRoomName " + this.egF + " req.FirstPageMd5:" + localcie.xOk + " souorce:" + this.cpt);
      AppMethodBeat.o(109256);
      return;
      label652:
      paramString1 = com.tencent.mm.plugin.story.model.j.svi;
    }
  }
  
  public final int doScene(e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(109254);
    a.f.b.j.q(parame, "dispatcher");
    a.f.b.j.q(paramf, "callback");
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rr, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(109254);
    return i;
  }
  
  public final String getInfo()
  {
    return this.userName;
  }
  
  public final int getType()
  {
    return 273;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(109255);
    ab.i(TAG, this + " netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString + " source:" + this.cpt);
    paramq = this.rr.adn();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryUserPageResponse");
      AppMethodBeat.o(109255);
      throw paramString;
    }
    cif localcif = (cif)paramq;
    this.rfK = localcif.xRS;
    this.sxs = localcif.xPz;
    if ((paramInt2 != 0) && (paramInt2 != 4))
    {
      ab.w(TAG, "onGYNetEnd errorType:" + paramInt2 + " errorCode:" + paramInt3 + ", return");
      paramq = this.callback;
      if (paramq == null) {
        a.f.b.j.ays("callback");
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.ai.m)this);
      AppMethodBeat.o(109255);
      return;
    }
    paramArrayOfByte = localcif.xOk;
    paramq = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      paramq = "";
    }
    ab.i(TAG, "onGYNetEnd resp: ObjCount " + localcif.xSQ + ", size " + localcif.xSR.size() + "; md5 req " + this.rfa + ", resp " + paramq + ", source: " + this.cpt + ", expiredTime:" + localcif.wlc);
    label391:
    long l;
    if (paramInt2 == 0)
    {
      paramArrayOfByte = (CharSequence)this.rfa;
      if ((paramArrayOfByte == null) || (paramArrayOfByte.length() == 0))
      {
        paramInt1 = 1;
        if (paramInt1 != 0) {
          break label523;
        }
        if (((CharSequence)paramq).length() != 0) {
          break label509;
        }
        paramInt1 = 1;
        if ((paramInt1 != 0) || (!bo.isEqual(this.rfa, paramq))) {
          break label523;
        }
        paramq = com.tencent.mm.plugin.story.model.j.svi;
        paramq = j.b.cAB();
        if (!this.rew) {
          break label514;
        }
        l = 0L;
        label427:
        this.rey = paramq.b(l, this.reA, this.userName, this.ctJ);
        ab.i(TAG, "md5 is nochange");
        paramInt1 = 1;
      }
    }
    for (;;)
    {
      if (paramInt1 != 0)
      {
        paramq = this.callback;
        if (paramq == null) {
          a.f.b.j.ays("callback");
        }
        paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.ai.m)this);
        AppMethodBeat.o(109255);
        return;
        paramInt1 = 0;
        break;
        label509:
        paramInt1 = 0;
        break label391;
        label514:
        l = this.sxe;
        break label427;
        label523:
        paramInt1 = this.cpt;
        paramArrayOfByte = com.tencent.mm.plugin.story.h.a.sFV;
        if (paramInt1 == com.tencent.mm.plugin.story.h.a.cEv())
        {
          paramArrayOfByte = com.tencent.mm.plugin.story.model.j.svi;
          j.b.cAC().gR(this.userName, paramq);
          paramInt1 = 0;
          continue;
        }
        paramArrayOfByte = com.tencent.mm.plugin.story.model.j.svi;
        j.b.cAC().gQ(this.userName, paramq);
        paramInt1 = 0;
        continue;
        if (paramInt2 != 4) {
          break label1467;
        }
        paramq = com.tencent.mm.plugin.story.h.a.sFV;
        if (paramInt3 != com.tencent.mm.plugin.story.h.a.cDW()) {
          break label1467;
        }
        paramInt1 = 1;
        continue;
      }
      paramq = localcif.xSR;
      a.f.b.j.p(paramq, "resp.ObjList");
      paramq = (chs)a.a.j.fR((List)paramq);
      if (paramq != null)
      {
        l = paramq.Id;
        this.rex = l;
        paramq = localcif.xSR;
        a.f.b.j.p(paramq, "resp.ObjList");
        paramq = (chs)a.a.j.fT((List)paramq);
        if (paramq == null) {
          break label936;
        }
      }
      Object localObject1;
      Object localObject2;
      label936:
      for (l = paramq.Id;; l = 0L)
      {
        this.rey = l;
        ab.i(TAG, "onGYNetEnd replace insert " + localcif.xSR.size() + ", max " + this.rex + ", min " + this.rey);
        ab.i(TAG, "determin clear fav: " + this.cpt + ", " + paramInt3 + ", " + this.rew);
        paramInt1 = this.cpt;
        paramq = com.tencent.mm.plugin.story.h.a.sFV;
        if (paramInt1 != com.tencent.mm.plugin.story.h.a.cEv()) {
          break label1006;
        }
        if (!this.rew) {
          break label942;
        }
        ab.i(TAG, "fetch first page, clear all fav");
        paramq = com.tencent.mm.plugin.story.model.j.svi;
        paramq = j.b.cAB();
        paramArrayOfByte = this.userName;
        localObject1 = this.userName;
        localObject2 = com.tencent.mm.plugin.story.model.j.svi;
        paramq = ((Iterable)paramq.bD(paramArrayOfByte, bo.isEqual((String)localObject1, j.b.coK()))).iterator();
        while (paramq.hasNext())
        {
          paramArrayOfByte = (com.tencent.mm.plugin.story.h.j)paramq.next();
          localObject1 = n.svx;
          n.a.fZ((int)paramArrayOfByte.systemRowid, 0);
        }
        l = 0L;
        break;
      }
      label942:
      paramq = n.svx;
      n.a.b(this.userName, (List)localcif.xSR, this.cpG);
      for (;;)
      {
        paramq = this.callback;
        if (paramq == null) {
          a.f.b.j.ays("callback");
        }
        paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.ai.m)this);
        AppMethodBeat.o(109255);
        return;
        label1006:
        paramInt1 = this.cpt;
        paramq = com.tencent.mm.plugin.story.h.a.sFV;
        if (paramInt1 == com.tencent.mm.plugin.story.h.a.cEu())
        {
          paramq = n.svx;
          n.a.b(this.userName, (List)localcif.xSR, this.cpG);
        }
        else
        {
          paramInt1 = this.cpt;
          paramq = com.tencent.mm.plugin.story.h.a.sFV;
          if (paramInt1 == com.tencent.mm.plugin.story.h.a.cEt())
          {
            if (this.ctJ)
            {
              paramq = com.tencent.mm.plugin.story.model.j.svi;
              paramq = j.b.cAB();
              paramArrayOfByte = this.userName;
              paramInt1 = cb.abr();
              localObject1 = i.suJ;
              paramq = paramq.a(paramArrayOfByte, true, paramInt1 - i.cAp(), true);
              localObject1 = ((Iterable)paramq).iterator();
            }
            label1212:
            label1343:
            for (;;)
            {
              label1128:
              if (!((Iterator)localObject1).hasNext()) {
                break label1345;
              }
              paramq = (com.tencent.mm.plugin.story.h.j)((Iterator)localObject1).next();
              if (paramq.field_storyID != 0L)
              {
                paramArrayOfByte = localcif.xSR;
                a.f.b.j.p(paramArrayOfByte, "resp.ObjList");
                paramArrayOfByte = (Iterable)paramArrayOfByte;
                if ((!(paramArrayOfByte instanceof Collection)) || (!((Collection)paramArrayOfByte).isEmpty()))
                {
                  paramArrayOfByte = paramArrayOfByte.iterator();
                  if (paramArrayOfByte.hasNext()) {
                    if (((chs)paramArrayOfByte.next()).Id == paramq.field_storyID)
                    {
                      paramInt1 = 1;
                      label1246:
                      if (paramInt1 == 0) {
                        break label1338;
                      }
                    }
                  }
                }
                for (paramInt1 = 0;; paramInt1 = 1)
                {
                  if ((paramInt1 == 0) || (paramq.cFd())) {
                    break label1343;
                  }
                  paramArrayOfByte = com.tencent.mm.plugin.story.model.j.svi;
                  localObject2 = j.b.cAB();
                  l = paramq.field_storyID;
                  paramArrayOfByte = paramq.field_userName;
                  paramq = paramArrayOfByte;
                  if (paramArrayOfByte == null) {
                    paramq = "";
                  }
                  ((com.tencent.mm.plugin.story.h.k)localObject2).x(l, paramq);
                  break label1128;
                  paramq = com.tencent.mm.plugin.story.model.j.svi;
                  paramq = j.b.cAB().bC(this.userName, false);
                  break;
                  paramInt1 = 0;
                  break label1246;
                  break label1212;
                }
              }
            }
            label1338:
            label1345:
            paramq = n.svx;
            paramq = (com.tencent.mm.plugin.story.h.j)a.a.j.w((List)n.a.b(this.userName, (List)localcif.xSR, this.cpG), 0);
            if (paramq == null)
            {
              ab.i(TAG, "onGYNetEnd clear ext sync");
              paramq = com.tencent.mm.plugin.story.model.k.svr;
              com.tencent.mm.plugin.story.model.k.acS(this.userName);
            }
            else
            {
              ab.i(TAG, "onGYNetEnd update ext sync, " + paramq.field_storyID + ' ' + paramq.field_createTime);
              paramArrayOfByte = com.tencent.mm.plugin.story.model.k.svr;
              com.tencent.mm.plugin.story.model.k.a(this.userName, paramq);
            }
          }
        }
      }
      label1467:
      paramInt1 = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.a.j
 * JD-Core Version:    0.7.0.1
 */