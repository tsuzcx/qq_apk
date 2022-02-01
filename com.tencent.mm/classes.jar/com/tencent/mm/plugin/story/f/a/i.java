package com.tencent.mm.plugin.story.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.model.cf;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.n.a;
import com.tencent.mm.plugin.story.i.g;
import com.tencent.mm.protocal.protobuf.djs;
import com.tencent.mm.protocal.protobuf.dke;
import com.tencent.mm.protocal.protobuf.dkf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;
import d.v;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryUserPage;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "userName", "", "maxId", "", "isSelf", "", "mRoomId", "source", "", "(Ljava/lang/String;JZLjava/lang/String;I)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "forSameMd5Count", "fp", "getFp", "()Z", "setFp", "(Z)V", "setSelf", "getMRoomId", "()Ljava/lang/String;", "getMaxId", "()J", "setMaxId", "(J)V", "minId", "getMinId", "setMinId", "originMaxId", "recentLimitID", "getRecentLimitID", "setRecentLimitID", "requestMd5", "requestTime", "getRequestTime", "()I", "setRequestTime", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getSource", "sourceType", "getUserName", "setUserName", "(Ljava/lang/String;)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getInfo", "getType", "insertList", "", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "resp", "Lcom/tencent/mm/protocal/protobuf/StoryUserPageResponse;", "isFavSelectSource", "isFavSource", "isProfileSource", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"})
public final class i
  extends com.tencent.mm.al.n
  implements com.tencent.mm.network.k
{
  public static final i.a ALx;
  private static final String TAG = "MicroMsg.StoryCgi.NetSceneStoryUserPage";
  private static final Vector<String> zit;
  private long ALi;
  public int ALw;
  private com.tencent.mm.al.f callback;
  public final int dnh;
  private boolean drv;
  private final String fPi;
  private b rr;
  private int sourceType;
  public String userName;
  private String zhM;
  public boolean zhh;
  private long zhi;
  private long zhj;
  private int zhl;
  public long ziB;
  
  static
  {
    AppMethodBeat.i(118843);
    ALx = new i.a((byte)0);
    TAG = "MicroMsg.StoryCgi.NetSceneStoryUserPage";
    zit = new Vector();
    AppMethodBeat.o(118843);
  }
  
  public i(String paramString1, long paramLong, boolean paramBoolean, String paramString2, int paramInt)
  {
    AppMethodBeat.i(118841);
    this.userName = paramString1;
    this.zhi = paramLong;
    this.drv = paramBoolean;
    this.fPi = paramString2;
    this.dnh = paramInt;
    this.zhM = "";
    if (this.zhi == 0L)
    {
      ad.i(TAG, "fp mUserName " + this.userName);
      if (!this.drv) {
        break label247;
      }
      paramString1 = com.tencent.mm.plugin.story.i.a.ATp;
    }
    for (paramInt = com.tencent.mm.plugin.story.i.a.ekx();; paramInt = com.tencent.mm.plugin.story.i.a.eky())
    {
      this.sourceType = paramInt;
      paramString1 = new b.a();
      paramString1.c((com.tencent.mm.bx.a)new dke());
      paramString1.d((com.tencent.mm.bx.a)new dkf());
      paramString1.Dl("/cgi-bin/micromsg-bin/mmstoryuserpage");
      paramString1.oP(273);
      paramString1.oR(400);
      paramString1.oS(1000000400);
      paramString1 = paramString1.aDC();
      p.g(paramString1, "builder.buildInstance()");
      this.rr = paramString1;
      paramString1 = this.rr.aEE();
      if (paramString1 != null) {
        break label259;
      }
      paramString1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryUserPageRequest");
      AppMethodBeat.o(118841);
      throw paramString1;
      ad.i(TAG, "np mUserName " + this.userName);
      break;
      label247:
      paramString1 = com.tencent.mm.plugin.story.i.a.ATp;
    }
    label259:
    dke localdke = (dke)paramString1;
    localdke.nDo = this.userName;
    localdke.HtV = this.zhi;
    localdke.tRT = this.dnh;
    if (this.zhi == 0L) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.zhh = paramBoolean;
      localdke.Hvg = 0L;
      if (d.n.n.a((CharSequence)this.fPi, "@", 0, false, 6) <= 0) {
        break label412;
      }
      paramString1 = this.fPi;
      paramInt = d.n.n.a((CharSequence)this.fPi, "@", 0, false, 6);
      if (paramString1 != null) {
        break;
      }
      paramString1 = new v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(118841);
      throw paramString1;
    }
    paramString1 = paramString1.substring(0, paramInt);
    p.g(paramString1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    localdke.HyS = bt.aRf(paramString1);
    label412:
    localdke.Hvh = 0;
    localdke.FuL = this.fPi;
    if (this.zhh)
    {
      paramInt = this.dnh;
      paramString1 = com.tencent.mm.plugin.story.i.a.ATp;
      if (paramInt != com.tencent.mm.plugin.story.i.a.ela()) {
        break label652;
      }
      paramString1 = com.tencent.mm.plugin.story.f.j.AKb;
      paramString1 = j.b.ehU();
      paramString2 = this.userName;
      p.h(paramString2, "userName");
      paramString2 = paramString1.aCf(paramString2).field_favoriteMd5;
      paramString1 = paramString2;
      if (paramString2 != null) {}
    }
    for (paramString1 = "";; paramString1 = j.b.ehU().aCg(this.userName))
    {
      this.zhM = paramString1;
      if (this.zhM == null) {
        this.zhM = "";
      }
      localdke.HtU = this.zhM;
      this.ALi = this.zhi;
      ad.i(TAG, this + " req.mUserName:" + localdke.nDo + " req.MaxId:" + localdke.HtV + " req.MinFilterId:" + localdke.Hvg + " req.LastRequestTime:" + localdke.Hvh + " ChatRoomName " + this.fPi + " req.FirstPageMd5:" + localdke.HtU + " souorce:" + this.dnh);
      AppMethodBeat.o(118841);
      return;
      label652:
      paramString1 = com.tencent.mm.plugin.story.f.j.AKb;
    }
  }
  
  public final int doScene(e parame, com.tencent.mm.al.f paramf)
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
    ad.i(TAG, this + " netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString + " source:" + this.dnh);
    paramq = this.rr.aEF();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryUserPageResponse");
      AppMethodBeat.o(118840);
      throw paramString;
    }
    dkf localdkf = (dkf)paramq;
    this.ziB = localdkf.HxY;
    this.ALw = localdkf.Hvp;
    if ((paramInt2 != 0) && (paramInt2 != 4))
    {
      ad.w(TAG, "onGYNetEnd errorType:" + paramInt2 + " errorCode:" + paramInt3 + ", return");
      paramq = this.callback;
      if (paramq == null) {
        p.bcb("callback");
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.al.n)this);
      AppMethodBeat.o(118840);
      return;
    }
    paramArrayOfByte = localdkf.HtU;
    paramq = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      paramq = "";
    }
    ad.i(TAG, "onGYNetEnd resp: ObjCount " + localdkf.HyT + ", size " + localdkf.HyU.size() + "; md5 req " + this.zhM + ", resp " + paramq + ", source: " + this.dnh + ", expiredTime:" + localdkf.FqM);
    label391:
    long l;
    if (paramInt2 == 0)
    {
      paramArrayOfByte = (CharSequence)this.zhM;
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
        if ((paramInt1 != 0) || (!bt.lQ(this.zhM, paramq))) {
          break label523;
        }
        paramq = com.tencent.mm.plugin.story.f.j.AKb;
        paramq = j.b.ehT();
        if (!this.zhh) {
          break label514;
        }
        l = 0L;
        label427:
        this.zhj = paramq.c(l, this.zhl, this.userName, this.drv);
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
          p.bcb("callback");
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
        l = this.ALi;
        break label427;
        label523:
        paramInt1 = this.dnh;
        paramArrayOfByte = com.tencent.mm.plugin.story.i.a.ATp;
        if (paramInt1 == com.tencent.mm.plugin.story.i.a.ela())
        {
          paramArrayOfByte = com.tencent.mm.plugin.story.f.j.AKb;
          j.b.ehU().kh(this.userName, paramq);
          paramInt1 = 0;
          continue;
        }
        paramArrayOfByte = com.tencent.mm.plugin.story.f.j.AKb;
        j.b.ehU().kg(this.userName, paramq);
        paramInt1 = 0;
        continue;
        if (paramInt2 != 4) {
          break label1467;
        }
        paramq = com.tencent.mm.plugin.story.i.a.ATp;
        if (paramInt3 != com.tencent.mm.plugin.story.i.a.ekF()) {
          break label1467;
        }
        paramInt1 = 1;
        continue;
      }
      paramq = localdkf.HyU;
      p.g(paramq, "resp.ObjList");
      paramq = (djs)d.a.j.jd((List)paramq);
      if (paramq != null)
      {
        l = paramq.Id;
        this.zhi = l;
        paramq = localdkf.HyU;
        p.g(paramq, "resp.ObjList");
        paramq = (djs)d.a.j.jf((List)paramq);
        if (paramq == null) {
          break label936;
        }
      }
      Object localObject1;
      Object localObject2;
      label936:
      for (l = paramq.Id;; l = 0L)
      {
        this.zhj = l;
        ad.i(TAG, "onGYNetEnd replace insert " + localdkf.HyU.size() + ", max " + this.zhi + ", min " + this.zhj);
        ad.i(TAG, "determin clear fav: " + this.dnh + ", " + paramInt3 + ", " + this.zhh);
        paramInt1 = this.dnh;
        paramq = com.tencent.mm.plugin.story.i.a.ATp;
        if (paramInt1 != com.tencent.mm.plugin.story.i.a.ela()) {
          break label1006;
        }
        if (!this.zhh) {
          break label942;
        }
        ad.i(TAG, "fetch first page, clear all fav");
        paramq = com.tencent.mm.plugin.story.f.j.AKb;
        paramq = j.b.ehT();
        paramArrayOfByte = this.userName;
        localObject1 = this.userName;
        localObject2 = com.tencent.mm.plugin.story.f.j.AKb;
        paramq = ((Iterable)paramq.cc(paramArrayOfByte, bt.lQ((String)localObject1, j.b.dTJ()))).iterator();
        while (paramq.hasNext())
        {
          paramArrayOfByte = (com.tencent.mm.plugin.story.i.j)paramq.next();
          localObject1 = com.tencent.mm.plugin.story.f.n.AKq;
          n.a.jdMethod_if((int)paramArrayOfByte.systemRowid, 0);
        }
        l = 0L;
        break;
      }
      label942:
      paramq = com.tencent.mm.plugin.story.f.n.AKq;
      n.a.b(this.userName, (List)localdkf.HyU, this.sourceType);
      for (;;)
      {
        paramq = this.callback;
        if (paramq == null) {
          p.bcb("callback");
        }
        paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.al.n)this);
        AppMethodBeat.o(118840);
        return;
        label1006:
        paramInt1 = this.dnh;
        paramq = com.tencent.mm.plugin.story.i.a.ATp;
        if (paramInt1 == com.tencent.mm.plugin.story.i.a.ekZ())
        {
          paramq = com.tencent.mm.plugin.story.f.n.AKq;
          n.a.b(this.userName, (List)localdkf.HyU, this.sourceType);
        }
        else
        {
          paramInt1 = this.dnh;
          paramq = com.tencent.mm.plugin.story.i.a.ATp;
          if (paramInt1 == com.tencent.mm.plugin.story.i.a.ekY())
          {
            if (this.drv)
            {
              paramq = com.tencent.mm.plugin.story.f.j.AKb;
              paramq = j.b.ehT();
              paramArrayOfByte = this.userName;
              paramInt1 = cf.aCN();
              localObject1 = com.tencent.mm.plugin.story.f.i.AJE;
              paramq = paramq.a(paramArrayOfByte, true, paramInt1 - com.tencent.mm.plugin.story.f.i.ehK(), true);
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
                paramArrayOfByte = localdkf.HyU;
                p.g(paramArrayOfByte, "resp.ObjList");
                paramArrayOfByte = (Iterable)paramArrayOfByte;
                if ((!(paramArrayOfByte instanceof Collection)) || (!((Collection)paramArrayOfByte).isEmpty()))
                {
                  paramArrayOfByte = paramArrayOfByte.iterator();
                  if (paramArrayOfByte.hasNext()) {
                    if (((djs)paramArrayOfByte.next()).Id == paramq.field_storyID)
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
                  if ((paramInt1 == 0) || (paramq.elB())) {
                    break label1343;
                  }
                  paramArrayOfByte = com.tencent.mm.plugin.story.f.j.AKb;
                  localObject2 = j.b.ehT();
                  l = paramq.field_storyID;
                  paramArrayOfByte = paramq.field_userName;
                  paramq = paramArrayOfByte;
                  if (paramArrayOfByte == null) {
                    paramq = "";
                  }
                  ((com.tencent.mm.plugin.story.i.k)localObject2).F(l, paramq);
                  break label1128;
                  paramq = com.tencent.mm.plugin.story.f.j.AKb;
                  paramq = j.b.ehT().ca(this.userName, false);
                  break;
                  paramInt1 = 0;
                  break label1246;
                  break label1212;
                }
              }
            }
            label1338:
            label1345:
            paramq = com.tencent.mm.plugin.story.f.n.AKq;
            paramq = (com.tencent.mm.plugin.story.i.j)d.a.j.E((List)n.a.b(this.userName, (List)localdkf.HyU, this.sourceType), 0);
            if (paramq == null)
            {
              ad.i(TAG, "onGYNetEnd clear ext sync");
              paramq = com.tencent.mm.plugin.story.f.k.AKk;
              com.tencent.mm.plugin.story.f.k.aBB(this.userName);
            }
            else
            {
              ad.i(TAG, "onGYNetEnd update ext sync, " + paramq.field_storyID + ' ' + paramq.field_createTime);
              paramArrayOfByte = com.tencent.mm.plugin.story.f.k.AKk;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.a.i
 * JD-Core Version:    0.7.0.1
 */