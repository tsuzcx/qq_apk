package com.tencent.mm.plugin.story.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.model.ce;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.n.a;
import com.tencent.mm.plugin.story.i.f;
import com.tencent.mm.protocal.protobuf.cyt;
import com.tencent.mm.protocal.protobuf.czf;
import com.tencent.mm.protocal.protobuf.czg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.l;
import d.v;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryUserPage;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "userName", "", "maxId", "", "isSelf", "", "mRoomId", "source", "", "(Ljava/lang/String;JZLjava/lang/String;I)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "forSameMd5Count", "fp", "getFp", "()Z", "setFp", "(Z)V", "setSelf", "getMRoomId", "()Ljava/lang/String;", "getMaxId", "()J", "setMaxId", "(J)V", "minId", "getMinId", "setMinId", "originMaxId", "recentLimitID", "getRecentLimitID", "setRecentLimitID", "requestMd5", "requestTime", "getRequestTime", "()I", "setRequestTime", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getSource", "sourceType", "getUserName", "setUserName", "(Ljava/lang/String;)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getInfo", "getType", "insertList", "", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "resp", "Lcom/tencent/mm/protocal/protobuf/StoryUserPageResponse;", "isFavSelectSource", "isFavSource", "isProfileSource", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"})
public final class i
  extends com.tencent.mm.al.n
  implements com.tencent.mm.network.k
{
  private static final String TAG = "MicroMsg.StoryCgi.NetSceneStoryUserPage";
  private static final Vector<String> wGf;
  public static final a ygD;
  private com.tencent.mm.al.g callback;
  public final int dep;
  private boolean diE;
  private final String fss;
  private b rr;
  private int sourceType;
  public String userName;
  public boolean wES;
  private long wET;
  private long wEU;
  private int wEW;
  private String wFy;
  public long wGn;
  public int ygC;
  private long ygo;
  
  static
  {
    AppMethodBeat.i(118843);
    ygD = new a((byte)0);
    TAG = "MicroMsg.StoryCgi.NetSceneStoryUserPage";
    wGf = new Vector();
    AppMethodBeat.o(118843);
  }
  
  public i(String paramString1, long paramLong, boolean paramBoolean, String paramString2, int paramInt)
  {
    AppMethodBeat.i(118841);
    this.userName = paramString1;
    this.wET = paramLong;
    this.diE = paramBoolean;
    this.fss = paramString2;
    this.dep = paramInt;
    this.wFy = "";
    if (this.wET == 0L)
    {
      ad.i(TAG, "fp mUserName " + this.userName);
      if (!this.diE) {
        break label247;
      }
      paramString1 = com.tencent.mm.plugin.story.i.a.yor;
    }
    for (paramInt = com.tencent.mm.plugin.story.i.a.dJH();; paramInt = com.tencent.mm.plugin.story.i.a.dJI())
    {
      this.sourceType = paramInt;
      paramString1 = new b.a();
      paramString1.c((com.tencent.mm.bx.a)new czf());
      paramString1.d((com.tencent.mm.bx.a)new czg());
      paramString1.wg("/cgi-bin/micromsg-bin/mmstoryuserpage");
      paramString1.nB(273);
      paramString1.nD(400);
      paramString1.nE(1000000400);
      paramString1 = paramString1.atI();
      d.g.b.k.g(paramString1, "builder.buildInstance()");
      this.rr = paramString1;
      paramString1 = this.rr.auL();
      if (paramString1 != null) {
        break label259;
      }
      paramString1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryUserPageRequest");
      AppMethodBeat.o(118841);
      throw paramString1;
      ad.i(TAG, "np mUserName " + this.userName);
      break;
      label247:
      paramString1 = com.tencent.mm.plugin.story.i.a.yor;
    }
    label259:
    czf localczf = (czf)paramString1;
    localczf.mAQ = this.userName;
    localczf.Emo = this.wET;
    localczf.rNz = this.dep;
    if (this.wET == 0L) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.wES = paramBoolean;
      localczf.Enz = 0L;
      if (d.n.n.a((CharSequence)this.fss, "@", 0, false, 6) <= 0) {
        break label412;
      }
      paramString1 = this.fss;
      paramInt = d.n.n.a((CharSequence)this.fss, "@", 0, false, 6);
      if (paramString1 != null) {
        break;
      }
      paramString1 = new v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(118841);
      throw paramString1;
    }
    paramString1 = paramString1.substring(0, paramInt);
    d.g.b.k.g(paramString1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    localczf.Erf = bt.aGi(paramString1);
    label412:
    localczf.EnA = 0;
    localczf.Cxb = this.fss;
    if (this.wES)
    {
      paramInt = this.dep;
      paramString1 = com.tencent.mm.plugin.story.i.a.yor;
      if (paramInt != com.tencent.mm.plugin.story.i.a.dKk()) {
        break label652;
      }
      paramString1 = com.tencent.mm.plugin.story.f.j.yfh;
      paramString1 = j.b.dHe();
      paramString2 = this.userName;
      d.g.b.k.h(paramString2, "userName");
      paramString2 = paramString1.arS(paramString2).field_favoriteMd5;
      paramString1 = paramString2;
      if (paramString2 != null) {}
    }
    for (paramString1 = "";; paramString1 = j.b.dHe().arT(this.userName))
    {
      this.wFy = paramString1;
      if (this.wFy == null) {
        this.wFy = "";
      }
      localczf.Emn = this.wFy;
      this.ygo = this.wET;
      ad.i(TAG, this + " req.mUserName:" + localczf.mAQ + " req.MaxId:" + localczf.Emo + " req.MinFilterId:" + localczf.Enz + " req.LastRequestTime:" + localczf.EnA + " ChatRoomName " + this.fss + " req.FirstPageMd5:" + localczf.Emn + " souorce:" + this.dep);
      AppMethodBeat.o(118841);
      return;
      label652:
      paramString1 = com.tencent.mm.plugin.story.f.j.yfh;
    }
  }
  
  public final int doScene(e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(118839);
    d.g.b.k.h(parame, "dispatcher");
    d.g.b.k.h(paramg, "callback");
    this.callback = paramg;
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
    ad.i(TAG, this + " netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString + " source:" + this.dep);
    paramq = this.rr.auM();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryUserPageResponse");
      AppMethodBeat.o(118840);
      throw paramString;
    }
    czg localczg = (czg)paramq;
    this.wGn = localczg.Eql;
    this.ygC = localczg.EnI;
    if ((paramInt2 != 0) && (paramInt2 != 4))
    {
      ad.w(TAG, "onGYNetEnd errorType:" + paramInt2 + " errorCode:" + paramInt3 + ", return");
      paramq = this.callback;
      if (paramq == null) {
        d.g.b.k.aPZ("callback");
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.al.n)this);
      AppMethodBeat.o(118840);
      return;
    }
    paramArrayOfByte = localczg.Emn;
    paramq = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      paramq = "";
    }
    ad.i(TAG, "onGYNetEnd resp: ObjCount " + localczg.Erg + ", size " + localczg.Erh.size() + "; md5 req " + this.wFy + ", resp " + paramq + ", source: " + this.dep + ", expiredTime:" + localczg.Ctq);
    label391:
    long l;
    if (paramInt2 == 0)
    {
      paramArrayOfByte = (CharSequence)this.wFy;
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
        if ((paramInt1 != 0) || (!bt.kU(this.wFy, paramq))) {
          break label523;
        }
        paramq = com.tencent.mm.plugin.story.f.j.yfh;
        paramq = j.b.dHd();
        if (!this.wES) {
          break label514;
        }
        l = 0L;
        label427:
        this.wEU = paramq.b(l, this.wEW, this.userName, this.diE);
        ad.i(TAG, "md5 is nochange");
        paramInt1 = 1;
      }
    }
    for (;;)
    {
      if (paramInt1 != 0)
      {
        paramq = this.callback;
        if (paramq == null) {
          d.g.b.k.aPZ("callback");
        }
        paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.al.n)this);
        AppMethodBeat.o(118840);
        return;
        paramInt1 = 0;
        break;
        label509:
        paramInt1 = 0;
        break label391;
        label514:
        l = this.ygo;
        break label427;
        label523:
        paramInt1 = this.dep;
        paramArrayOfByte = com.tencent.mm.plugin.story.i.a.yor;
        if (paramInt1 == com.tencent.mm.plugin.story.i.a.dKk())
        {
          paramArrayOfByte = com.tencent.mm.plugin.story.f.j.yfh;
          j.b.dHe().ju(this.userName, paramq);
          paramInt1 = 0;
          continue;
        }
        paramArrayOfByte = com.tencent.mm.plugin.story.f.j.yfh;
        j.b.dHe().jt(this.userName, paramq);
        paramInt1 = 0;
        continue;
        if (paramInt2 != 4) {
          break label1467;
        }
        paramq = com.tencent.mm.plugin.story.i.a.yor;
        if (paramInt3 != com.tencent.mm.plugin.story.i.a.dJP()) {
          break label1467;
        }
        paramInt1 = 1;
        continue;
      }
      paramq = localczg.Erh;
      d.g.b.k.g(paramq, "resp.ObjList");
      paramq = (cyt)d.a.j.iz((List)paramq);
      if (paramq != null)
      {
        l = paramq.Id;
        this.wET = l;
        paramq = localczg.Erh;
        d.g.b.k.g(paramq, "resp.ObjList");
        paramq = (cyt)d.a.j.iB((List)paramq);
        if (paramq == null) {
          break label936;
        }
      }
      Object localObject1;
      Object localObject2;
      label936:
      for (l = paramq.Id;; l = 0L)
      {
        this.wEU = l;
        ad.i(TAG, "onGYNetEnd replace insert " + localczg.Erh.size() + ", max " + this.wET + ", min " + this.wEU);
        ad.i(TAG, "determin clear fav: " + this.dep + ", " + paramInt3 + ", " + this.wES);
        paramInt1 = this.dep;
        paramq = com.tencent.mm.plugin.story.i.a.yor;
        if (paramInt1 != com.tencent.mm.plugin.story.i.a.dKk()) {
          break label1006;
        }
        if (!this.wES) {
          break label942;
        }
        ad.i(TAG, "fetch first page, clear all fav");
        paramq = com.tencent.mm.plugin.story.f.j.yfh;
        paramq = j.b.dHd();
        paramArrayOfByte = this.userName;
        localObject1 = this.userName;
        localObject2 = com.tencent.mm.plugin.story.f.j.yfh;
        paramq = ((Iterable)paramq.bO(paramArrayOfByte, bt.kU((String)localObject1, j.b.dta()))).iterator();
        while (paramq.hasNext())
        {
          paramArrayOfByte = (com.tencent.mm.plugin.story.i.j)paramq.next();
          localObject1 = com.tencent.mm.plugin.story.f.n.yfw;
          n.a.hF((int)paramArrayOfByte.systemRowid, 0);
        }
        l = 0L;
        break;
      }
      label942:
      paramq = com.tencent.mm.plugin.story.f.n.yfw;
      n.a.b(this.userName, (List)localczg.Erh, this.sourceType);
      for (;;)
      {
        paramq = this.callback;
        if (paramq == null) {
          d.g.b.k.aPZ("callback");
        }
        paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.al.n)this);
        AppMethodBeat.o(118840);
        return;
        label1006:
        paramInt1 = this.dep;
        paramq = com.tencent.mm.plugin.story.i.a.yor;
        if (paramInt1 == com.tencent.mm.plugin.story.i.a.dKj())
        {
          paramq = com.tencent.mm.plugin.story.f.n.yfw;
          n.a.b(this.userName, (List)localczg.Erh, this.sourceType);
        }
        else
        {
          paramInt1 = this.dep;
          paramq = com.tencent.mm.plugin.story.i.a.yor;
          if (paramInt1 == com.tencent.mm.plugin.story.i.a.dKi())
          {
            if (this.diE)
            {
              paramq = com.tencent.mm.plugin.story.f.j.yfh;
              paramq = j.b.dHd();
              paramArrayOfByte = this.userName;
              paramInt1 = ce.asT();
              localObject1 = com.tencent.mm.plugin.story.f.i.yeK;
              paramq = paramq.a(paramArrayOfByte, true, paramInt1 - com.tencent.mm.plugin.story.f.i.dGU(), true);
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
                paramArrayOfByte = localczg.Erh;
                d.g.b.k.g(paramArrayOfByte, "resp.ObjList");
                paramArrayOfByte = (Iterable)paramArrayOfByte;
                if ((!(paramArrayOfByte instanceof Collection)) || (!((Collection)paramArrayOfByte).isEmpty()))
                {
                  paramArrayOfByte = paramArrayOfByte.iterator();
                  if (paramArrayOfByte.hasNext()) {
                    if (((cyt)paramArrayOfByte.next()).Id == paramq.field_storyID)
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
                  if ((paramInt1 == 0) || (paramq.dKL())) {
                    break label1343;
                  }
                  paramArrayOfByte = com.tencent.mm.plugin.story.f.j.yfh;
                  localObject2 = j.b.dHd();
                  l = paramq.field_storyID;
                  paramArrayOfByte = paramq.field_userName;
                  paramq = paramArrayOfByte;
                  if (paramArrayOfByte == null) {
                    paramq = "";
                  }
                  ((com.tencent.mm.plugin.story.i.k)localObject2).D(l, paramq);
                  break label1128;
                  paramq = com.tencent.mm.plugin.story.f.j.yfh;
                  paramq = j.b.dHd().bM(this.userName, false);
                  break;
                  paramInt1 = 0;
                  break label1246;
                  break label1212;
                }
              }
            }
            label1338:
            label1345:
            paramq = com.tencent.mm.plugin.story.f.n.yfw;
            paramq = (com.tencent.mm.plugin.story.i.j)d.a.j.C((List)n.a.b(this.userName, (List)localczg.Erh, this.sourceType), 0);
            if (paramq == null)
            {
              ad.i(TAG, "onGYNetEnd clear ext sync");
              paramq = com.tencent.mm.plugin.story.f.k.yfq;
              com.tencent.mm.plugin.story.f.k.arn(this.userName);
            }
            else
            {
              ad.i(TAG, "onGYNetEnd update ext sync, " + paramq.field_storyID + ' ' + paramq.field_createTime);
              paramArrayOfByte = com.tencent.mm.plugin.story.f.k.yfq;
              com.tencent.mm.plugin.story.f.k.a(this.userName, paramq);
            }
          }
        }
      }
      label1467:
      paramInt1 = 0;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryUserPage$Companion;", "", "()V", "TAG", "", "userPageLock", "Ljava/util/Vector;", "addStoryUserReq", "", "muserName", "removeUserReq", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.a.i
 * JD-Core Version:    0.7.0.1
 */