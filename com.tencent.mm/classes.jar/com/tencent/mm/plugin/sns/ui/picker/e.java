package com.tencent.mm.plugin.sns.ui.picker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.plugin.sight.base.f;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.model.as;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.bp;
import com.tencent.mm.plugin.sns.ui.d;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.h.a;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerListAdapterHelper;", "Lcom/tencent/mm/plugin/sns/ui/AdapterLoader;", "Lcom/tencent/mm/plugin/sns/ui/picker/SnsPickerMediaInfo;", "mCallback", "Lcom/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerListAdapterHelper$OnSnsAlbumInfoDataCallback;", "mUserName", "", "mIsMySelf", "", "(Lcom/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerListAdapterHelper$OnSnsAlbumInfoDataCallback;Ljava/lang/String;Z)V", "getMCallback", "()Lcom/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerListAdapterHelper$OnSnsAlbumInfoDataCallback;", "mCurLimitSeqMin", "getMIsMySelf", "()Z", "mTargetLimitSeq", "mTimeHeaderList", "Ljava/util/LinkedList;", "getMTimeHeaderList", "()Ljava/util/LinkedList;", "getMUserName", "()Ljava/lang/String;", "checkSnsInfoMediaType", "info", "Lcom/tencent/mm/plugin/sns/storage/SnsInfo;", "checkSnsInfoPrivate", "snsInfo", "isSelf", "createSnsPickerLoadingInfo", "createSnsPickerTimeHeader", "timeLabelString", "isLoadingInfo", "isTimeInfo", "loadData", "", "publicNotify", "", "list", "resetCursor", "limitSeq", "isPrivate", "isWork", "secondFloatTime2String", "durationSecond", "", "Companion", "OnSnsAlbumInfoDataCallback", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends d<g>
{
  public static final e.a RRU;
  private final e.b RRV;
  private final boolean RRW;
  private final LinkedList<String> RRX;
  private String RRY;
  private String RRZ;
  private final String luk;
  
  static
  {
    AppMethodBeat.i(308784);
    RRU = new e.a((byte)0);
    AppMethodBeat.o(308784);
  }
  
  public e(e.b paramb, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(308745);
    this.RRV = paramb;
    this.luk = paramString;
    this.RRW = paramBoolean;
    this.RRX = new LinkedList();
    this.RRY = "";
    this.RRZ = "";
    AppMethodBeat.o(308745);
  }
  
  public static boolean b(g paramg)
  {
    AppMethodBeat.i(308765);
    s.u(paramg, "info");
    if ((s.p(paramg.Qsr.Id, "-1")) && (paramg.RSO.getCreateTime() == -1) && (paramg.RSO.getTypeFlag() == -1))
    {
      AppMethodBeat.o(308765);
      return true;
    }
    AppMethodBeat.o(308765);
    return false;
  }
  
  public static boolean c(g paramg)
  {
    AppMethodBeat.i(308771);
    s.u(paramg, "info");
    if ((s.p(paramg.Qsr.Id, "-4")) && (paramg.RSO.getCreateTime() == -4) && (paramg.RSO.getTypeFlag() == -4))
    {
      AppMethodBeat.o(308771);
      return true;
    }
    AppMethodBeat.o(308771);
    return false;
  }
  
  public static String ds(float paramFloat)
  {
    AppMethodBeat.i(308780);
    if (paramFloat <= 0.0F)
    {
      AppMethodBeat.o(308780);
      return "--:--";
    }
    int i = a.eH(paramFloat);
    String str2 = String.valueOf(i % 60);
    String str1 = str2;
    if (str2.length() < 2) {
      str1 = s.X("0", str2);
    }
    str1 = i / 60 + ':' + str1;
    AppMethodBeat.o(308780);
    return str1;
  }
  
  public static boolean h(SnsInfo paramSnsInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(308749);
    s.u(paramSnsInfo, "snsInfo");
    paramBoolean = ap.bG(paramSnsInfo.getLocalPrivate(), paramBoolean);
    AppMethodBeat.o(308749);
    return paramBoolean;
  }
  
  public static g hrA()
  {
    AppMethodBeat.i(308755);
    Object localObject = new SnsInfo();
    ((SnsInfo)localObject).setCreateTime(-4);
    ((SnsInfo)localObject).setTypeFlag(-4);
    dmz localdmz = new dmz();
    localdmz.Id = "-4";
    localObject = new g((SnsInfo)localObject, localdmz);
    AppMethodBeat.o(308755);
    return localObject;
  }
  
  public final List<g> aNv()
  {
    AppMethodBeat.i(308794);
    Object localObject1 = new LinkedList();
    Object localObject2 = ap.a(this.luk, this.RRW, this.RRY, this.RRZ);
    Object localObject3 = new StringBuilder("to loadData limitSeq: [").append(this.RRY).append(',').append(this.RRZ).append("], pull all type snsInfo count:").append(((List)localObject2).size()).append(" , minSnsId = ");
    s.s(localObject2, "snsInfoList");
    Object localObject4 = (SnsInfo)p.oN((List)localObject2);
    long l;
    int i;
    label139:
    label160:
    label212:
    Object localObject5;
    label318:
    label325:
    label331:
    Object localObject6;
    if (localObject4 == null)
    {
      l = 0L;
      Log.i("MicroMsg.SnsAlbumPickerListAdapterHelper", l);
      if (((Collection)localObject2).isEmpty()) {
        break label606;
      }
      i = 1;
      if (i != 0)
      {
        localObject3 = (SnsInfo)p.oN((List)localObject2);
        if (localObject3 != null) {
          break label611;
        }
        l = 0L;
        localObject3 = t.uB(l);
        s.s(localObject3, "longToFullString(snsInfo…Null()?.field_snsId ?:0L)");
        this.RRY = ((String)localObject3);
        localObject4 = this.RRV;
        if (localObject4 != null) {
          ((e.b)localObject4).bbg((String)localObject3);
        }
      }
      localObject2 = ((Iterable)localObject2).iterator();
      do
      {
        do
        {
          do
          {
            if (!((Iterator)localObject2).hasNext()) {
              break label645;
            }
            localObject3 = (SnsInfo)((Iterator)localObject2).next();
            s.s(localObject3, "info");
            s.u(localObject3, "info");
            if ((((SnsInfo)localObject3).field_type != 1) && (((SnsInfo)localObject3).field_type != 15)) {
              break label630;
            }
            localObject4 = ((SnsInfo)localObject3).getTimeLine();
            if (localObject4 == null) {
              break label625;
            }
            localObject4 = ((TimeLineObject)localObject4).ContentObj;
            if (localObject4 == null) {
              break label625;
            }
            localObject4 = ((agh)localObject4).Zpr;
            if (localObject4 == null) {
              break label625;
            }
            if (((Collection)localObject4).isEmpty()) {
              break;
            }
            i = 1;
            if (1 != i) {
              break label625;
            }
            i = 1;
            if (i == 0) {
              break label630;
            }
            i = 1;
            if (i == 0) {
              break label633;
            }
            localObject4 = bp.vv(((SnsInfo)localObject3).getCreateTime() * 1000L).toString();
            if (!this.RRX.contains(localObject4))
            {
              this.RRX.add(localObject4);
              s.u(localObject4, "timeLabelString");
              localObject5 = new SnsInfo();
              ((SnsInfo)localObject5).setCreateTime(-1);
              ((SnsInfo)localObject5).setTypeFlag(-1);
              localObject6 = new dmz();
              ((dmz)localObject6).Id = "-1";
              ((dmz)localObject6).hAP = ((String)localObject4);
              ((LinkedList)localObject1).add(new g((SnsInfo)localObject5, (dmz)localObject6));
            }
            localObject4 = ((SnsInfo)localObject3).getTimeLine();
          } while (localObject4 == null);
          localObject4 = ((TimeLineObject)localObject4).ContentObj;
        } while (localObject4 == null);
        localObject4 = ((agh)localObject4).Zpr;
      } while (localObject4 == null);
      localObject4 = ((Iterable)localObject4).iterator();
      label492:
      if (((Iterator)localObject4).hasNext())
      {
        localObject5 = (dmz)((Iterator)localObject4).next();
        if ((((dmz)localObject5).vhJ == 6) && (((dmz)localObject5).aaTF <= 0.0F))
        {
          localObject6 = f.aVX(as.mi(((dmz)localObject5).Id, t.i((dmz)localObject5)));
          if (localObject6 != null) {
            break label635;
          }
        }
      }
    }
    label606:
    label611:
    label625:
    label630:
    label633:
    label635:
    for (float f = 0.0F;; f = ((b)localObject6).videoDuration)
    {
      ((dmz)localObject5).aaTF = (f / 1000.0F);
      s.s(localObject5, "media");
      ((LinkedList)localObject1).add(new g((SnsInfo)localObject3, (dmz)localObject5));
      break label492;
      break label212;
      l = ((SnsInfo)localObject4).field_snsId;
      break;
      i = 0;
      break label139;
      l = ((SnsInfo)localObject3).field_snsId;
      break label160;
      i = 0;
      break label318;
      i = 0;
      break label325;
      i = 0;
      break label331;
      break label212;
    }
    label645:
    localObject1 = (List)localObject1;
    AppMethodBeat.o(308794);
    return localObject1;
  }
  
  public final void dk(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(308802);
    s.u(paramString, "limitSeq");
    Log.d("MicroMsg.SnsAlbumPickerListAdapterHelper", "resetCursor limitSeq = " + paramString + " , isPrivate = " + paramBoolean + " ,isWork = true ");
    this.RRZ = paramString;
    wq(true);
    AppMethodBeat.o(308802);
  }
  
  public final void kI(List<g> paramList)
  {
    AppMethodBeat.i(308808);
    s.u(paramList, "list");
    e.b localb = this.RRV;
    if (localb != null) {
      localb.kV(paramList);
    }
    AppMethodBeat.o(308808);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.picker.e
 * JD-Core Version:    0.7.0.1
 */