package com.tencent.mm.plugin.story.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.model.ce;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.n.a;
import com.tencent.mm.plugin.story.i.f;
import com.tencent.mm.protocal.protobuf.def;
import com.tencent.mm.protocal.protobuf.der;
import com.tencent.mm.protocal.protobuf.des;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import d.l;
import d.v;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryUserPage;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "userName", "", "maxId", "", "isSelf", "", "mRoomId", "source", "", "(Ljava/lang/String;JZLjava/lang/String;I)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "forSameMd5Count", "fp", "getFp", "()Z", "setFp", "(Z)V", "setSelf", "getMRoomId", "()Ljava/lang/String;", "getMaxId", "()J", "setMaxId", "(J)V", "minId", "getMinId", "setMinId", "originMaxId", "recentLimitID", "getRecentLimitID", "setRecentLimitID", "requestMd5", "requestTime", "getRequestTime", "()I", "setRequestTime", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getSource", "sourceType", "getUserName", "setUserName", "(Ljava/lang/String;)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getInfo", "getType", "insertList", "", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "resp", "Lcom/tencent/mm/protocal/protobuf/StoryUserPageResponse;", "isFavSelectSource", "isFavSource", "isProfileSource", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"})
public final class i
  extends com.tencent.mm.ak.n
  implements com.tencent.mm.network.k
{
  private static final String TAG = "MicroMsg.StoryCgi.NetSceneStoryUserPage";
  private static final Vector<String> xSz;
  public static final i.a ztD;
  private com.tencent.mm.ak.g callback;
  public final int dbL;
  private boolean dfZ;
  private final String fvZ;
  private b rr;
  private int sourceType;
  public String userName;
  private String xRS;
  public boolean xRn;
  private long xRo;
  private long xRp;
  private int xRr;
  public long xSH;
  public int ztC;
  private long zto;
  
  static
  {
    AppMethodBeat.i(118843);
    ztD = new i.a((byte)0);
    TAG = "MicroMsg.StoryCgi.NetSceneStoryUserPage";
    xSz = new Vector();
    AppMethodBeat.o(118843);
  }
  
  public i(String paramString1, long paramLong, boolean paramBoolean, String paramString2, int paramInt)
  {
    AppMethodBeat.i(118841);
    this.userName = paramString1;
    this.xRo = paramLong;
    this.dfZ = paramBoolean;
    this.fvZ = paramString2;
    this.dbL = paramInt;
    this.xRS = "";
    if (this.xRo == 0L)
    {
      ac.i(TAG, "fp mUserName " + this.userName);
      if (!this.dfZ) {
        break label247;
      }
      paramString1 = com.tencent.mm.plugin.story.i.a.zBQ;
    }
    for (paramInt = com.tencent.mm.plugin.story.i.a.dYi();; paramInt = com.tencent.mm.plugin.story.i.a.dYj())
    {
      this.sourceType = paramInt;
      paramString1 = new b.a();
      paramString1.c((com.tencent.mm.bw.a)new der());
      paramString1.d((com.tencent.mm.bw.a)new des());
      paramString1.Am("/cgi-bin/micromsg-bin/mmstoryuserpage");
      paramString1.op(273);
      paramString1.or(400);
      paramString1.os(1000000400);
      paramString1 = paramString1.aAz();
      d.g.b.k.g(paramString1, "builder.buildInstance()");
      this.rr = paramString1;
      paramString1 = this.rr.aBC();
      if (paramString1 != null) {
        break label259;
      }
      paramString1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryUserPageRequest");
      AppMethodBeat.o(118841);
      throw paramString1;
      ac.i(TAG, "np mUserName " + this.userName);
      break;
      label247:
      paramString1 = com.tencent.mm.plugin.story.i.a.zBQ;
    }
    label259:
    der localder = (der)paramString1;
    localder.ncR = this.userName;
    localder.FJn = this.xRo;
    localder.sVo = this.dbL;
    if (this.xRo == 0L) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.xRn = paramBoolean;
      localder.FKy = 0L;
      if (d.n.n.a((CharSequence)this.fvZ, "@", 0, false, 6) <= 0) {
        break label412;
      }
      paramString1 = this.fvZ;
      paramInt = d.n.n.a((CharSequence)this.fvZ, "@", 0, false, 6);
      if (paramString1 != null) {
        break;
      }
      paramString1 = new v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(118841);
      throw paramString1;
    }
    paramString1 = paramString1.substring(0, paramInt);
    d.g.b.k.g(paramString1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    localder.FOh = bs.aLz(paramString1);
    label412:
    localder.FKz = 0;
    localder.DPx = this.fvZ;
    if (this.xRn)
    {
      paramInt = this.dbL;
      paramString1 = com.tencent.mm.plugin.story.i.a.zBQ;
      if (paramInt != com.tencent.mm.plugin.story.i.a.dYL()) {
        break label652;
      }
      paramString1 = com.tencent.mm.plugin.story.f.j.zsh;
      paramString1 = j.b.dVF();
      paramString2 = this.userName;
      d.g.b.k.h(paramString2, "userName");
      paramString2 = paramString1.axb(paramString2).field_favoriteMd5;
      paramString1 = paramString2;
      if (paramString2 != null) {}
    }
    for (paramString1 = "";; paramString1 = j.b.dVF().axc(this.userName))
    {
      this.xRS = paramString1;
      if (this.xRS == null) {
        this.xRS = "";
      }
      localder.FJm = this.xRS;
      this.zto = this.xRo;
      ac.i(TAG, this + " req.mUserName:" + localder.ncR + " req.MaxId:" + localder.FJn + " req.MinFilterId:" + localder.FKy + " req.LastRequestTime:" + localder.FKz + " ChatRoomName " + this.fvZ + " req.FirstPageMd5:" + localder.FJm + " souorce:" + this.dbL);
      AppMethodBeat.o(118841);
      return;
      label652:
      paramString1 = com.tencent.mm.plugin.story.f.j.zsh;
    }
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
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
    ac.i(TAG, this + " netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString + " source:" + this.dbL);
    paramq = this.rr.aBD();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryUserPageResponse");
      AppMethodBeat.o(118840);
      throw paramString;
    }
    des localdes = (des)paramq;
    this.xSH = localdes.FNn;
    this.ztC = localdes.FKH;
    if ((paramInt2 != 0) && (paramInt2 != 4))
    {
      ac.w(TAG, "onGYNetEnd errorType:" + paramInt2 + " errorCode:" + paramInt3 + ", return");
      paramq = this.callback;
      if (paramq == null) {
        d.g.b.k.aVY("callback");
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.ak.n)this);
      AppMethodBeat.o(118840);
      return;
    }
    paramArrayOfByte = localdes.FJm;
    paramq = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      paramq = "";
    }
    ac.i(TAG, "onGYNetEnd resp: ObjCount " + localdes.FOi + ", size " + localdes.FOj.size() + "; md5 req " + this.xRS + ", resp " + paramq + ", source: " + this.dbL + ", expiredTime:" + localdes.DLH);
    label391:
    long l;
    if (paramInt2 == 0)
    {
      paramArrayOfByte = (CharSequence)this.xRS;
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
        if ((paramInt1 != 0) || (!bs.lr(this.xRS, paramq))) {
          break label523;
        }
        paramq = com.tencent.mm.plugin.story.f.j.zsh;
        paramq = j.b.dVE();
        if (!this.xRn) {
          break label514;
        }
        l = 0L;
        label427:
        this.xRp = paramq.c(l, this.xRr, this.userName, this.dfZ);
        ac.i(TAG, "md5 is nochange");
        paramInt1 = 1;
      }
    }
    for (;;)
    {
      if (paramInt1 != 0)
      {
        paramq = this.callback;
        if (paramq == null) {
          d.g.b.k.aVY("callback");
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
        l = this.zto;
        break label427;
        label523:
        paramInt1 = this.dbL;
        paramArrayOfByte = com.tencent.mm.plugin.story.i.a.zBQ;
        if (paramInt1 == com.tencent.mm.plugin.story.i.a.dYL())
        {
          paramArrayOfByte = com.tencent.mm.plugin.story.f.j.zsh;
          j.b.dVF().jS(this.userName, paramq);
          paramInt1 = 0;
          continue;
        }
        paramArrayOfByte = com.tencent.mm.plugin.story.f.j.zsh;
        j.b.dVF().jR(this.userName, paramq);
        paramInt1 = 0;
        continue;
        if (paramInt2 != 4) {
          break label1467;
        }
        paramq = com.tencent.mm.plugin.story.i.a.zBQ;
        if (paramInt3 != com.tencent.mm.plugin.story.i.a.dYq()) {
          break label1467;
        }
        paramInt1 = 1;
        continue;
      }
      paramq = localdes.FOj;
      d.g.b.k.g(paramq, "resp.ObjList");
      paramq = (def)d.a.j.iP((List)paramq);
      if (paramq != null)
      {
        l = paramq.Id;
        this.xRo = l;
        paramq = localdes.FOj;
        d.g.b.k.g(paramq, "resp.ObjList");
        paramq = (def)d.a.j.iR((List)paramq);
        if (paramq == null) {
          break label936;
        }
      }
      Object localObject1;
      Object localObject2;
      label936:
      for (l = paramq.Id;; l = 0L)
      {
        this.xRp = l;
        ac.i(TAG, "onGYNetEnd replace insert " + localdes.FOj.size() + ", max " + this.xRo + ", min " + this.xRp);
        ac.i(TAG, "determin clear fav: " + this.dbL + ", " + paramInt3 + ", " + this.xRn);
        paramInt1 = this.dbL;
        paramq = com.tencent.mm.plugin.story.i.a.zBQ;
        if (paramInt1 != com.tencent.mm.plugin.story.i.a.dYL()) {
          break label1006;
        }
        if (!this.xRn) {
          break label942;
        }
        ac.i(TAG, "fetch first page, clear all fav");
        paramq = com.tencent.mm.plugin.story.f.j.zsh;
        paramq = j.b.dVE();
        paramArrayOfByte = this.userName;
        localObject1 = this.userName;
        localObject2 = com.tencent.mm.plugin.story.f.j.zsh;
        paramq = ((Iterable)paramq.bV(paramArrayOfByte, bs.lr((String)localObject1, j.b.dHx()))).iterator();
        while (paramq.hasNext())
        {
          paramArrayOfByte = (com.tencent.mm.plugin.story.i.j)paramq.next();
          localObject1 = com.tencent.mm.plugin.story.f.n.zsw;
          n.a.hO((int)paramArrayOfByte.systemRowid, 0);
        }
        l = 0L;
        break;
      }
      label942:
      paramq = com.tencent.mm.plugin.story.f.n.zsw;
      n.a.b(this.userName, (List)localdes.FOj, this.sourceType);
      for (;;)
      {
        paramq = this.callback;
        if (paramq == null) {
          d.g.b.k.aVY("callback");
        }
        paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.ak.n)this);
        AppMethodBeat.o(118840);
        return;
        label1006:
        paramInt1 = this.dbL;
        paramq = com.tencent.mm.plugin.story.i.a.zBQ;
        if (paramInt1 == com.tencent.mm.plugin.story.i.a.dYK())
        {
          paramq = com.tencent.mm.plugin.story.f.n.zsw;
          n.a.b(this.userName, (List)localdes.FOj, this.sourceType);
        }
        else
        {
          paramInt1 = this.dbL;
          paramq = com.tencent.mm.plugin.story.i.a.zBQ;
          if (paramInt1 == com.tencent.mm.plugin.story.i.a.dYJ())
          {
            if (this.dfZ)
            {
              paramq = com.tencent.mm.plugin.story.f.j.zsh;
              paramq = j.b.dVE();
              paramArrayOfByte = this.userName;
              paramInt1 = ce.azK();
              localObject1 = com.tencent.mm.plugin.story.f.i.zrK;
              paramq = paramq.a(paramArrayOfByte, true, paramInt1 - com.tencent.mm.plugin.story.f.i.dVv(), true);
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
                paramArrayOfByte = localdes.FOj;
                d.g.b.k.g(paramArrayOfByte, "resp.ObjList");
                paramArrayOfByte = (Iterable)paramArrayOfByte;
                if ((!(paramArrayOfByte instanceof Collection)) || (!((Collection)paramArrayOfByte).isEmpty()))
                {
                  paramArrayOfByte = paramArrayOfByte.iterator();
                  if (paramArrayOfByte.hasNext()) {
                    if (((def)paramArrayOfByte.next()).Id == paramq.field_storyID)
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
                  if ((paramInt1 == 0) || (paramq.dZm())) {
                    break label1343;
                  }
                  paramArrayOfByte = com.tencent.mm.plugin.story.f.j.zsh;
                  localObject2 = j.b.dVE();
                  l = paramq.field_storyID;
                  paramArrayOfByte = paramq.field_userName;
                  paramq = paramArrayOfByte;
                  if (paramArrayOfByte == null) {
                    paramq = "";
                  }
                  ((com.tencent.mm.plugin.story.i.k)localObject2).B(l, paramq);
                  break label1128;
                  paramq = com.tencent.mm.plugin.story.f.j.zsh;
                  paramq = j.b.dVE().bT(this.userName, false);
                  break;
                  paramInt1 = 0;
                  break label1246;
                  break label1212;
                }
              }
            }
            label1338:
            label1345:
            paramq = com.tencent.mm.plugin.story.f.n.zsw;
            paramq = (com.tencent.mm.plugin.story.i.j)d.a.j.C((List)n.a.b(this.userName, (List)localdes.FOj, this.sourceType), 0);
            if (paramq == null)
            {
              ac.i(TAG, "onGYNetEnd clear ext sync");
              paramq = com.tencent.mm.plugin.story.f.k.zsq;
              com.tencent.mm.plugin.story.f.k.aww(this.userName);
            }
            else
            {
              ac.i(TAG, "onGYNetEnd update ext sync, " + paramq.field_storyID + ' ' + paramq.field_createTime);
              paramArrayOfByte = com.tencent.mm.plugin.story.f.k.zsq;
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