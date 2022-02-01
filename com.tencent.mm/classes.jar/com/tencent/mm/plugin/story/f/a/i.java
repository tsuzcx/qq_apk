package com.tencent.mm.plugin.story.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.model.ch;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.n.a;
import com.tencent.mm.plugin.story.i.g;
import com.tencent.mm.protocal.protobuf.dkn;
import com.tencent.mm.protocal.protobuf.dkz;
import com.tencent.mm.protocal.protobuf.dla;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;
import d.v;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryUserPage;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "userName", "", "maxId", "", "isSelf", "", "mRoomId", "source", "", "(Ljava/lang/String;JZLjava/lang/String;I)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "forSameMd5Count", "fp", "getFp", "()Z", "setFp", "(Z)V", "setSelf", "getMRoomId", "()Ljava/lang/String;", "getMaxId", "()J", "setMaxId", "(J)V", "minId", "getMinId", "setMinId", "originMaxId", "recentLimitID", "getRecentLimitID", "setRecentLimitID", "requestMd5", "requestTime", "getRequestTime", "()I", "setRequestTime", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getSource", "sourceType", "getUserName", "setUserName", "(Ljava/lang/String;)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getInfo", "getType", "insertList", "", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "resp", "Lcom/tencent/mm/protocal/protobuf/StoryUserPageResponse;", "isFavSelectSource", "isFavSource", "isProfileSource", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"})
public final class i
  extends com.tencent.mm.ak.n
  implements com.tencent.mm.network.k
{
  public static final i.a Bda;
  private static final String TAG = "MicroMsg.StoryCgi.NetSceneStoryUserPage";
  private static final Vector<String> zzI;
  private long BcL;
  public int BcZ;
  private com.tencent.mm.ak.f callback;
  public final int doj;
  private boolean dsB;
  private final String fRo;
  private b rr;
  private int sourceType;
  public String userName;
  public boolean zxW;
  private long zxX;
  private long zxY;
  private String zyB;
  private int zya;
  public long zzQ;
  
  static
  {
    AppMethodBeat.i(118843);
    Bda = new i.a((byte)0);
    TAG = "MicroMsg.StoryCgi.NetSceneStoryUserPage";
    zzI = new Vector();
    AppMethodBeat.o(118843);
  }
  
  public i(String paramString1, long paramLong, boolean paramBoolean, String paramString2, int paramInt)
  {
    AppMethodBeat.i(118841);
    this.userName = paramString1;
    this.zxX = paramLong;
    this.dsB = paramBoolean;
    this.fRo = paramString2;
    this.doj = paramInt;
    this.zyB = "";
    if (this.zxX == 0L)
    {
      ae.i(TAG, "fp mUserName " + this.userName);
      if (!this.dsB) {
        break label247;
      }
      paramString1 = com.tencent.mm.plugin.story.i.a.BkN;
    }
    for (paramInt = com.tencent.mm.plugin.story.i.a.eog();; paramInt = com.tencent.mm.plugin.story.i.a.eoh())
    {
      this.sourceType = paramInt;
      paramString1 = new b.a();
      paramString1.c((com.tencent.mm.bw.a)new dkz());
      paramString1.d((com.tencent.mm.bw.a)new dla());
      paramString1.DN("/cgi-bin/micromsg-bin/mmstoryuserpage");
      paramString1.oS(273);
      paramString1.oU(400);
      paramString1.oV(1000000400);
      paramString1 = paramString1.aDS();
      p.g(paramString1, "builder.buildInstance()");
      this.rr = paramString1;
      paramString1 = this.rr.aEU();
      if (paramString1 != null) {
        break label259;
      }
      paramString1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryUserPageRequest");
      AppMethodBeat.o(118841);
      throw paramString1;
      ae.i(TAG, "np mUserName " + this.userName);
      break;
      label247:
      paramString1 = com.tencent.mm.plugin.story.i.a.BkN;
    }
    label259:
    dkz localdkz = (dkz)paramString1;
    localdkz.nIJ = this.userName;
    localdkz.HNy = this.zxX;
    localdkz.ucK = this.doj;
    if (this.zxX == 0L) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.zxW = paramBoolean;
      localdkz.HOJ = 0L;
      if (d.n.n.a((CharSequence)this.fRo, "@", 0, false, 6) <= 0) {
        break label412;
      }
      paramString1 = this.fRo;
      paramInt = d.n.n.a((CharSequence)this.fRo, "@", 0, false, 6);
      if (paramString1 != null) {
        break;
      }
      paramString1 = new v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(118841);
      throw paramString1;
    }
    paramString1 = paramString1.substring(0, paramInt);
    p.g(paramString1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    localdkz.HSD = bu.aSC(paramString1);
    label412:
    localdkz.HOK = 0;
    localdkz.FNj = this.fRo;
    if (this.zxW)
    {
      paramInt = this.doj;
      paramString1 = com.tencent.mm.plugin.story.i.a.BkN;
      if (paramInt != com.tencent.mm.plugin.story.i.a.eoJ()) {
        break label652;
      }
      paramString1 = com.tencent.mm.plugin.story.f.j.BbE;
      paramString1 = j.b.elC();
      paramString2 = this.userName;
      p.h(paramString2, "userName");
      paramString2 = paramString1.aDy(paramString2).field_favoriteMd5;
      paramString1 = paramString2;
      if (paramString2 != null) {}
    }
    for (paramString1 = "";; paramString1 = j.b.elC().aDz(this.userName))
    {
      this.zyB = paramString1;
      if (this.zyB == null) {
        this.zyB = "";
      }
      localdkz.HNx = this.zyB;
      this.BcL = this.zxX;
      ae.i(TAG, this + " req.mUserName:" + localdkz.nIJ + " req.MaxId:" + localdkz.HNy + " req.MinFilterId:" + localdkz.HOJ + " req.LastRequestTime:" + localdkz.HOK + " ChatRoomName " + this.fRo + " req.FirstPageMd5:" + localdkz.HNx + " souorce:" + this.doj);
      AppMethodBeat.o(118841);
      return;
      label652:
      paramString1 = com.tencent.mm.plugin.story.f.j.BbE;
    }
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(118839);
    p.h(parame, "dispatcher");
    p.h(paramf, "callback");
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rr, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(118839);
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
    AppMethodBeat.i(118840);
    ae.i(TAG, this + " netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString + " source:" + this.doj);
    paramq = this.rr.aEV();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryUserPageResponse");
      AppMethodBeat.o(118840);
      throw paramString;
    }
    dla localdla = (dla)paramq;
    this.zzQ = localdla.HRJ;
    this.BcZ = localdla.HOS;
    if ((paramInt2 != 0) && (paramInt2 != 4))
    {
      ae.w(TAG, "onGYNetEnd errorType:" + paramInt2 + " errorCode:" + paramInt3 + ", return");
      paramq = this.callback;
      if (paramq == null) {
        p.bdF("callback");
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.ak.n)this);
      AppMethodBeat.o(118840);
      return;
    }
    paramArrayOfByte = localdla.HNx;
    paramq = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      paramq = "";
    }
    ae.i(TAG, "onGYNetEnd resp: ObjCount " + localdla.HSE + ", size " + localdla.HSF.size() + "; md5 req " + this.zyB + ", resp " + paramq + ", source: " + this.doj + ", expiredTime:" + localdla.FJk);
    label391:
    long l;
    if (paramInt2 == 0)
    {
      paramArrayOfByte = (CharSequence)this.zyB;
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
        if ((paramInt1 != 0) || (!bu.lX(this.zyB, paramq))) {
          break label523;
        }
        paramq = com.tencent.mm.plugin.story.f.j.BbE;
        paramq = j.b.elB();
        if (!this.zxW) {
          break label514;
        }
        l = 0L;
        label427:
        this.zxY = paramq.c(l, this.zya, this.userName, this.dsB);
        ae.i(TAG, "md5 is nochange");
        paramInt1 = 1;
      }
    }
    for (;;)
    {
      if (paramInt1 != 0)
      {
        paramq = this.callback;
        if (paramq == null) {
          p.bdF("callback");
        }
        paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.ak.n)this);
        AppMethodBeat.o(118840);
        return;
        paramInt1 = 0;
        break;
        label509:
        paramInt1 = 0;
        break label391;
        label514:
        l = this.BcL;
        break label427;
        label523:
        paramInt1 = this.doj;
        paramArrayOfByte = com.tencent.mm.plugin.story.i.a.BkN;
        if (paramInt1 == com.tencent.mm.plugin.story.i.a.eoJ())
        {
          paramArrayOfByte = com.tencent.mm.plugin.story.f.j.BbE;
          j.b.elC().kn(this.userName, paramq);
          paramInt1 = 0;
          continue;
        }
        paramArrayOfByte = com.tencent.mm.plugin.story.f.j.BbE;
        j.b.elC().jV(this.userName, paramq);
        paramInt1 = 0;
        continue;
        if (paramInt2 != 4) {
          break label1467;
        }
        paramq = com.tencent.mm.plugin.story.i.a.BkN;
        if (paramInt3 != com.tencent.mm.plugin.story.i.a.eoo()) {
          break label1467;
        }
        paramInt1 = 1;
        continue;
      }
      paramq = localdla.HSF;
      p.g(paramq, "resp.ObjList");
      paramq = (dkn)d.a.j.jm((List)paramq);
      if (paramq != null)
      {
        l = paramq.Id;
        this.zxX = l;
        paramq = localdla.HSF;
        p.g(paramq, "resp.ObjList");
        paramq = (dkn)d.a.j.jo((List)paramq);
        if (paramq == null) {
          break label936;
        }
      }
      Object localObject1;
      Object localObject2;
      label936:
      for (l = paramq.Id;; l = 0L)
      {
        this.zxY = l;
        ae.i(TAG, "onGYNetEnd replace insert " + localdla.HSF.size() + ", max " + this.zxX + ", min " + this.zxY);
        ae.i(TAG, "determin clear fav: " + this.doj + ", " + paramInt3 + ", " + this.zxW);
        paramInt1 = this.doj;
        paramq = com.tencent.mm.plugin.story.i.a.BkN;
        if (paramInt1 != com.tencent.mm.plugin.story.i.a.eoJ()) {
          break label1006;
        }
        if (!this.zxW) {
          break label942;
        }
        ae.i(TAG, "fetch first page, clear all fav");
        paramq = com.tencent.mm.plugin.story.f.j.BbE;
        paramq = j.b.elB();
        paramArrayOfByte = this.userName;
        localObject1 = this.userName;
        localObject2 = com.tencent.mm.plugin.story.f.j.BbE;
        paramq = ((Iterable)paramq.cg(paramArrayOfByte, bu.lX((String)localObject1, j.b.dXj()))).iterator();
        while (paramq.hasNext())
        {
          paramArrayOfByte = (com.tencent.mm.plugin.story.i.j)paramq.next();
          localObject1 = com.tencent.mm.plugin.story.f.n.BbT;
          n.a.ii((int)paramArrayOfByte.systemRowid, 0);
        }
        l = 0L;
        break;
      }
      label942:
      paramq = com.tencent.mm.plugin.story.f.n.BbT;
      n.a.b(this.userName, (List)localdla.HSF, this.sourceType);
      for (;;)
      {
        paramq = this.callback;
        if (paramq == null) {
          p.bdF("callback");
        }
        paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.ak.n)this);
        AppMethodBeat.o(118840);
        return;
        label1006:
        paramInt1 = this.doj;
        paramq = com.tencent.mm.plugin.story.i.a.BkN;
        if (paramInt1 == com.tencent.mm.plugin.story.i.a.eoI())
        {
          paramq = com.tencent.mm.plugin.story.f.n.BbT;
          n.a.b(this.userName, (List)localdla.HSF, this.sourceType);
        }
        else
        {
          paramInt1 = this.doj;
          paramq = com.tencent.mm.plugin.story.i.a.BkN;
          if (paramInt1 == com.tencent.mm.plugin.story.i.a.eoH())
          {
            if (this.dsB)
            {
              paramq = com.tencent.mm.plugin.story.f.j.BbE;
              paramq = j.b.elB();
              paramArrayOfByte = this.userName;
              paramInt1 = ch.aDd();
              localObject1 = com.tencent.mm.plugin.story.f.i.Bbh;
              paramq = paramq.a(paramArrayOfByte, true, paramInt1 - com.tencent.mm.plugin.story.f.i.els(), true);
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
              paramq = (com.tencent.mm.plugin.story.i.j)((Iterator)localObject1).next();
              if (paramq.field_storyID != 0L)
              {
                paramArrayOfByte = localdla.HSF;
                p.g(paramArrayOfByte, "resp.ObjList");
                paramArrayOfByte = (Iterable)paramArrayOfByte;
                if ((!(paramArrayOfByte instanceof Collection)) || (!((Collection)paramArrayOfByte).isEmpty()))
                {
                  paramArrayOfByte = paramArrayOfByte.iterator();
                  if (paramArrayOfByte.hasNext()) {
                    if (((dkn)paramArrayOfByte.next()).Id == paramq.field_storyID)
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
                  if ((paramInt1 == 0) || (paramq.epk())) {
                    break label1343;
                  }
                  paramArrayOfByte = com.tencent.mm.plugin.story.f.j.BbE;
                  localObject2 = j.b.elB();
                  l = paramq.field_storyID;
                  paramArrayOfByte = paramq.field_userName;
                  paramq = paramArrayOfByte;
                  if (paramArrayOfByte == null) {
                    paramq = "";
                  }
                  ((com.tencent.mm.plugin.story.i.k)localObject2).G(l, paramq);
                  break label1128;
                  paramq = com.tencent.mm.plugin.story.f.j.BbE;
                  paramq = j.b.elB().ce(this.userName, false);
                  break;
                  paramInt1 = 0;
                  break label1246;
                  break label1212;
                }
              }
            }
            label1338:
            label1345:
            paramq = com.tencent.mm.plugin.story.f.n.BbT;
            paramq = (com.tencent.mm.plugin.story.i.j)d.a.j.F((List)n.a.b(this.userName, (List)localdla.HSF, this.sourceType), 0);
            if (paramq == null)
            {
              ae.i(TAG, "onGYNetEnd clear ext sync");
              paramq = com.tencent.mm.plugin.story.f.k.BbN;
              com.tencent.mm.plugin.story.f.k.aCU(this.userName);
            }
            else
            {
              ae.i(TAG, "onGYNetEnd update ext sync, " + paramq.field_storyID + ' ' + paramq.field_createTime);
              paramArrayOfByte = com.tencent.mm.plugin.story.f.k.BbN;
              com.tencent.mm.plugin.story.f.k.a(this.userName, paramq);
            }
          }
        }
      }
      label1467:
      paramInt1 = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.a.i
 * JD-Core Version:    0.7.0.1
 */