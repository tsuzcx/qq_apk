package com.tencent.mm.plugin.sns.model.d;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsns.o;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.data.u;
import com.tencent.mm.plugin.sns.data.u.a;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.bmr;
import com.tencent.mm.protocal.protobuf.bvj;
import com.tencent.mm.protocal.protobuf.bvl;
import com.tencent.mm.protocal.protobuf.djv;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.protocal.protobuf.dnb;
import com.tencent.mm.protocal.protobuf.dtj;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sns_compose.a.f;
import com.tencent.mm.sns_compose.a.f.a;
import com.tencent.mm.sns_compose.a.f.b;
import com.tencent.mm.sns_compose.a.f.c;
import com.tencent.mm.sns_compose.a.f.d;
import com.tencent.mm.sns_compose.a.f.e;
import com.tencent.mm.sns_compose.a.f.f;
import com.tencent.mm.sns_compose.a.f.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.am;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"MAX_USER", "", "getMAX_USER", "()I", "TAG", "", "getFinderLiveMedia", "Lcom/tencent/mm/protocal/protobuf/MediaObj;", "snsId", "tlObj", "Lcom/tencent/mm/protocal/protobuf/TimeLineObject;", "getFinderShareMedia", "getMusicMvShareMedia", "withFriends", "", "username", "getMediaList", "", "toSnsInfo", "Lcom/tencent/mm/plugin/sns/storage/SnsInfo;", "Lcom/tencent/mm/protocal/protobuf/SnsObject;", "sourceType", "toSnsWithTa", "Lcom/tencent/mm/sns_compose/api/SnsWithTaBase;", "toWithTaString", "Lcom/tencent/mm/protocal/protobuf/Location;", "", "plugin-sns_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class b
{
  private static final int QAP = 3;
  
  public static final f N(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(309625);
    s.u(paramSnsInfo, "<this>");
    Object localObject3 = paramSnsInfo.getTimeLine();
    Object localObject4;
    label54:
    long l;
    if (localObject3 == null)
    {
      localObject3 = o.bMJ();
      s.checkNotNull(localObject3);
      if (!Util.isNullOrNil(paramSnsInfo.field_withTa)) {
        break label292;
      }
      localObject4 = (List)new ArrayList();
      String str1 = paramSnsInfo.getUserName();
      s.s(str1, "this.userName");
      localObject1 = ((TimeLineObject)localObject3).ContentDesc;
      Object localObject5 = localObject1;
      if (localObject1 == null) {
        localObject5 = "";
      }
      int i = paramSnsInfo.getCreateTime();
      String str2 = paramSnsInfo.getSnsId();
      s.s(str2, "this.snsId");
      int j = paramSnsInfo.localid;
      String str3 = paramSnsInfo.getStringSeq();
      s.s(str3, "this.stringSeq");
      int k = paramSnsInfo.getTypeFlag();
      localObject1 = ((TimeLineObject)localObject3).Location;
      l = paramSnsInfo.field_snsId;
      if (localObject1 != null) {
        break label327;
      }
      localObject2 = "";
      localObject1 = new f.a(str1, (String)localObject5, i, str2, j, str3, k, (List)localObject4, (String)localObject2, paramSnsInfo.withTaUsername.toString(), paramSnsInfo.ExtFlag);
    }
    switch (((TimeLineObject)localObject3).ContentObj.Zpq)
    {
    default: 
    case 2: 
    case 1: 
    case 15: 
      do
      {
        paramSnsInfo = (f)localObject1;
        AppMethodBeat.o(309625);
        return paramSnsInfo;
        break;
        localObject1 = paramSnsInfo.field_withTa;
        s.s(localObject1, "this.field_withTa");
        localObject4 = n.b((CharSequence)localObject1, new String[] { ";" });
        break label54;
        if (!TextUtils.isEmpty((CharSequence)((djv)localObject1).poiName)) {
          if ((l == 0L) && (!TextUtils.isEmpty((CharSequence)((djv)localObject1).pSh))) {
            localObject1 = ((djv)localObject1).pSh + '·' + ((djv)localObject1).poiName;
          }
        }
        for (;;)
        {
          localObject2 = localObject1;
          if (localObject1 != null) {
            break;
          }
          localObject2 = "";
          break;
          localObject1 = ((djv)localObject1).poiName;
          continue;
          localObject1 = ((djv)localObject1).pSh;
        }
        paramSnsInfo = (f)new f.e((f)localObject1);
        AppMethodBeat.o(309625);
        return paramSnsInfo;
        localObject1 = (f)localObject1;
        s.u(localObject3, "<this>");
        paramSnsInfo = ((TimeLineObject)localObject3).ContentObj;
        if (paramSnsInfo == null) {}
        for (paramSnsInfo = null;; paramSnsInfo = paramSnsInfo.Zpr)
        {
          s.checkNotNull(paramSnsInfo);
          paramSnsInfo = (f)new f.c((f)localObject1, (List)paramSnsInfo);
          AppMethodBeat.o(309625);
          return paramSnsInfo;
        }
        paramSnsInfo = ((TimeLineObject)localObject3).ContentObj;
        s.checkNotNull(paramSnsInfo);
        if (paramSnsInfo.Zpr != null) {
          break label554;
        }
        paramSnsInfo = ((TimeLineObject)localObject3).ContentObj;
        s.checkNotNull(paramSnsInfo);
      } while (paramSnsInfo.Zpr.size() == 0);
      paramSnsInfo = (f)localObject1;
      localObject1 = ((TimeLineObject)localObject3).ContentObj;
      s.checkNotNull(localObject1);
      localObject1 = ((agh)localObject1).Zpr;
      s.checkNotNull(localObject1);
      localObject1 = ((LinkedList)localObject1).get(0);
      s.s(localObject1, "timeLineObj.ContentObj!!.MediaObjList!![0]");
      paramSnsInfo = (f)new f.g(paramSnsInfo, (dmz)localObject1);
      AppMethodBeat.o(309625);
      return paramSnsInfo;
    case 4: 
    case 30: 
      localObject1 = (f)localObject1;
      paramSnsInfo = ((TimeLineObject)localObject3).ContentObj;
      if (paramSnsInfo == null) {
        paramSnsInfo = null;
      }
      for (;;)
      {
        paramSnsInfo = (f)new f.f((f)localObject1, paramSnsInfo, ((TimeLineObject)localObject3).ContentObj.hAP, (byte)0);
        AppMethodBeat.o(309625);
        return paramSnsInfo;
        paramSnsInfo = paramSnsInfo.Zpr;
        if (paramSnsInfo == null) {
          paramSnsInfo = null;
        } else {
          paramSnsInfo = (dmz)paramSnsInfo.get(0);
        }
      }
    case 34: 
      paramSnsInfo = (f)localObject1;
      localObject1 = ((f)localObject1).hQX;
      s.u(localObject1, "snsId");
      s.u(localObject3, "tlObj");
      localObject2 = new dmz();
      ((dmz)localObject2).Url = ((TimeLineObject)localObject3).ContentObj.DHa.coverUrl;
      ((dmz)localObject2).aaTl = ((TimeLineObject)localObject3).ContentObj.DHa.coverUrl;
      ((dmz)localObject2).vhJ = 2;
      ((dmz)localObject2).aaTm = 1;
      ((dmz)localObject2).aaTn = new dnb();
      ((dmz)localObject2).aazR = 1;
      ((dmz)localObject2).aaTn.aaUb = ((TimeLineObject)localObject3).ContentObj.DHa.width;
      ((dmz)localObject2).aaTn.aaUc = ((TimeLineObject)localObject3).ContentObj.DHa.height;
      ((dmz)localObject2).Id = ((String)localObject1);
      paramSnsInfo = (f)new f.f(paramSnsInfo, (dmz)localObject2, MMApplicationContext.getContext().getString(b.j.sns_share_finder_live_title, new Object[] { ((TimeLineObject)localObject3).ContentObj.DHa.nickName }), (byte)0);
      AppMethodBeat.o(309625);
      return paramSnsInfo;
    case 3: 
      localObject2 = (f)localObject1;
      paramSnsInfo = ((TimeLineObject)localObject3).ContentObj;
      if (paramSnsInfo == null)
      {
        paramSnsInfo = null;
        localObject1 = ((TimeLineObject)localObject3).ContentObj;
        if (localObject1 != null) {
          break label974;
        }
      }
      for (localObject1 = null;; localObject1 = ((agh)localObject1).hAP)
      {
        paramSnsInfo = (f)new f.f((f)localObject2, paramSnsInfo, (String)localObject1, (byte)0);
        AppMethodBeat.o(309625);
        return paramSnsInfo;
        paramSnsInfo = paramSnsInfo.Zpr;
        if (paramSnsInfo == null)
        {
          paramSnsInfo = null;
          break;
        }
        paramSnsInfo = (dmz)paramSnsInfo.get(0);
        break;
      }
    case 42: 
      label292:
      label327:
      label974:
      localObject2 = (f)localObject1;
      label554:
      s.u(((f)localObject1).hQX, "snsId");
      s.u(localObject3, "tlObj");
      localObject4 = (dmz)((TimeLineObject)localObject3).ContentObj.Zpr.get(0);
      paramSnsInfo = ((TimeLineObject)localObject3).ContentObj.oPb.YqP;
      if (!Util.isNullOrNil(paramSnsInfo)) {
        ((dmz)localObject4).aaTl = paramSnsInfo;
      }
      s.s(localObject4, "media");
      paramSnsInfo = ((TimeLineObject)localObject3).ContentObj;
      if (paramSnsInfo == null)
      {
        paramSnsInfo = null;
        localObject1 = ((TimeLineObject)localObject3).ContentObj;
        if (localObject1 != null) {
          break label1150;
        }
        localObject1 = null;
      }
      for (;;)
      {
        paramSnsInfo = (f)new f.d((f)localObject2, (dmz)localObject4, paramSnsInfo, (String)localObject1);
        AppMethodBeat.o(309625);
        return paramSnsInfo;
        paramSnsInfo = paramSnsInfo.Zpr;
        if (paramSnsInfo == null)
        {
          paramSnsInfo = null;
          break;
        }
        paramSnsInfo = (dmz)paramSnsInfo.get(0);
        if (paramSnsInfo == null)
        {
          paramSnsInfo = null;
          break;
        }
        paramSnsInfo = paramSnsInfo.hAP;
        break;
        label1150:
        localObject1 = ((agh)localObject1).oPb;
        if (localObject1 == null) {
          localObject1 = null;
        } else {
          localObject1 = ((dtj)localObject1).singerName;
        }
      }
    }
    Object localObject2 = ((TimeLineObject)localObject3).ContentObj.hKU;
    if (localObject2 != null)
    {
      paramSnsInfo = ((bvl)localObject2).mediaList;
      if (paramSnsInfo != null) {
        break label1231;
      }
    }
    label1231:
    for (paramSnsInfo = null; paramSnsInfo == null; paramSnsInfo = (bvj)paramSnsInfo.get(0))
    {
      Log.e("Sns-WithTa-Utils", "finder obj is null");
      paramSnsInfo = (f)localObject1;
      AppMethodBeat.o(309625);
      return paramSnsInfo;
    }
    localObject3 = (f)localObject1;
    Object localObject1 = ((bvj)((bvl)localObject2).mediaList.get(0)).thumbUrl;
    paramSnsInfo = (SnsInfo)localObject1;
    if (localObject1 == null) {
      paramSnsInfo = "";
    }
    if (((bvl)localObject2).GfT == 4) {}
    for (boolean bool = true;; bool = false)
    {
      paramSnsInfo = (f)new f.b((f)localObject3, paramSnsInfo, bool);
      AppMethodBeat.o(309625);
      return paramSnsInfo;
    }
  }
  
  public static final void aZb(String paramString)
  {
    AppMethodBeat.i(309607);
    s.u(paramString, "username");
    paramString = ((com.tencent.mm.plugin.messenger.a.b)h.ax(com.tencent.mm.plugin.messenger.a.b.class)).IE(paramString);
    Object localObject = d.QAS;
    if (!d.hhW().contains(paramString))
    {
      localObject = d.QAS;
      d.hhW().add(paramString);
    }
    paramString = d.QAS;
    paramString = (List)d.hhW();
    localObject = d.QAS;
    if (d.hhW().size() > QAP)
    {
      paramString = d.QAS;
      paramString = d.hhW().subList(0, 3);
      s.s(paramString, "WithTaComposeOp.withFriendsNameList.subList(0, 3)");
    }
    localObject = d.QAS;
    localObject = am.aixg;
    localObject = MMApplicationContext.getString(b.j.sns_withta_with_friends_total);
    s.s(localObject, "getString(R.string.sns_withta_with_friends_total)");
    paramString = String.format((String)localObject, Arrays.copyOf(new Object[] { p.a((Iterable)paramString, (CharSequence)"、", null, null, 0, null, null, 62) }, 1));
    s.s(paramString, "java.lang.String.format(format, *args)");
    d.aZc(paramString);
    AppMethodBeat.o(309607);
  }
  
  public static final SnsInfo i(SnsObject paramSnsObject)
  {
    AppMethodBeat.i(309635);
    s.u(paramSnsObject, "<this>");
    SnsInfo localSnsInfo = new SnsInfo();
    Object localObject = paramSnsObject.ObjectDesc.aaxD.toByteArray();
    s.s(localObject, "this.ObjectDesc.buffer.toByteArray()");
    localObject = new String((byte[])localObject, kotlin.n.d.UTF_8);
    if (BuildInfo.DEBUG) {
      Log.v("MicroMsg.NetSceneSnsClassifyTimeLine", "snsxml up: %s", new Object[] { localObject });
    }
    Log.d("MicroMsg.NetSceneSnsClassifyTimeLine", "from server %d ", new Object[] { Long.valueOf(paramSnsObject.Id) });
    if (!localSnsInfo.setContent((String)localObject))
    {
      AppMethodBeat.o(309635);
      return null;
    }
    localSnsInfo.field_userName = paramSnsObject.Username;
    localSnsInfo.field_createTime = paramSnsObject.CreateTime;
    localSnsInfo.field_likeFlag = paramSnsObject.LikeFlag;
    localSnsInfo.setSnsId(paramSnsObject.Id);
    localSnsInfo.setStringSeq(paramSnsObject.Id);
    localSnsInfo.ExtFlag = paramSnsObject.ExtFlag;
    localSnsInfo.addSourceFlag(256);
    localObject = paramSnsObject.WithTaList;
    s.s(localObject, "this.WithTaList");
    localSnsInfo.field_withTa = p.a((Iterable)localObject, (CharSequence)";", null, null, 0, null, null, 62);
    try
    {
      localSnsInfo.setAttrBuf(paramSnsObject.toByteArray());
      if (!Util.isNullOrNil((List)paramSnsObject.NewWithTaList))
      {
        localObject = u.Qoz;
        localObject = localSnsInfo.getSnsId();
        s.s(localObject, "snsinfo.snsId");
        boolean bool = al.hgg().equals(paramSnsObject.Username);
        LinkedList localLinkedList = paramSnsObject.NewWithTaList;
        s.s(localLinkedList, "this.NewWithTaList");
        localSnsInfo.withTaUsername = u.a.a(null, (String)localObject, bool, localLinkedList);
      }
      localObject = localSnsInfo.getTimeLine();
      ((TimeLineObject)localObject).UserName = paramSnsObject.Username;
      localSnsInfo.setPravited(((TimeLineObject)localObject).Privated);
      Log.d("MicroMsg.NetSceneSnsClassifyTimeLine", s.X("ext flag ", Integer.valueOf(paramSnsObject.ExtFlag)));
      localSnsInfo.setExtFlag();
      localSnsInfo.setTimeLine((TimeLineObject)localObject);
      localSnsInfo.setTypeFlag(((TimeLineObject)localObject).ContentObj.Zpq);
      localSnsInfo.setSubTypeFlag(((TimeLineObject)localObject).ContentObj.Zps);
      AppMethodBeat.o(309635);
      return localSnsInfo;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.NetSceneSnsClassifyTimeLine", (Throwable)localException, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.d.b
 * JD-Core Version:    0.7.0.1
 */