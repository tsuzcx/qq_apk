package com.tencent.mm.plugin.textstatus.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.zx;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.textstatus.a.h;
import com.tencent.mm.plugin.textstatus.a.a.a;
import com.tencent.mm.plugin.textstatus.a.a.b;
import com.tencent.mm.plugin.textstatus.a.a.c;
import com.tencent.mm.plugin.textstatus.proto.TextStatusTopicInfo;
import com.tencent.mm.plugin.textstatus.proto.ae;
import com.tencent.mm.plugin.textstatus.proto.ap;
import com.tencent.mm.plugin.textstatus.proto.ar;
import com.tencent.mm.plugin.textstatus.proto.as;
import com.tencent.mm.plugin.textstatus.proto.at;
import com.tencent.mm.plugin.textstatus.proto.w;
import com.tencent.mm.plugin.textstatus.proto.x;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.am;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/util/StatusIconHelperV2;", "Lcom/tencent/mm/plugin/textstatus/util/IStatusIconHelper;", "()V", "TAG", "", "coverAgenda", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusCoverAgenda;", "getCoverAgenda", "()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusCoverAgenda;", "setCoverAgenda", "(Lcom/tencent/mm/plugin/textstatus/proto/TextStatusCoverAgenda;)V", "coverAgendaIconId", "curConfig", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusIconConfig;", "getCurConfig", "()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusIconConfig;", "setCurConfig", "(Lcom/tencent/mm/plugin/textstatus/proto/TextStatusIconConfig;)V", "lastAgendaClickTime", "", "Ljava/lang/Long;", "addIconToGroup", "", "icon", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusIcon;", "groupId", "list", "", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusIconGroupWithIcons;", "createIconLoader", "Lcom/tencent/mm/plugin/textstatus/util/IconLoader;", "iv", "Landroid/widget/ImageView;", "iconId", "iconType", "Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconType;", "iconColor", "Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconColor;", "item", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "getClusterDesByInfo", "topicInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;", "sameTopicSize", "", "name", "type", "getConfigFromAsset", "getConfigFromFile", "getConfigFromLocal", "getCoverAgendaFromLocal", "getCoverAgendaIconId", "getCoverAgendaIconIdForReport", "getDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lkotlin/collections/ArrayList;", "getIconSpan", "Landroid/text/style/ImageSpan;", "attachView", "Landroid/view/View;", "id", "iconScene", "Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconScene;", "size", "getName", "getNameByInfo", "getResVersion", "getTextStatusCoverAgendaFromFile", "handleIconConfigResult", "rsp", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetIconConfigResp;", "initIconConfig", "isIconValidForSet", "", "loadIconBitmap", "url", "callback", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "onCreate", "onDestroy", "reqNewestIconConfig", "isClientVersionChange", "(Ljava/lang/Boolean;)V", "reset", "setBigIcon", "setCoverAgendaClickTime", "clickTime", "setCoverAgendaIconId", "setIcon", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends a
{
  public static final g TBm;
  private static Long TBn;
  private static ar TBo;
  private static w TBp;
  private static String Twm;
  
  static
  {
    AppMethodBeat.i(290458);
    TBm = new g();
    TBo = new ar();
    TBp = new w();
    AppMethodBeat.o(290458);
  }
  
  private static void a(ap paramap, String paramString, List<? extends at> paramList)
  {
    AppMethodBeat.i(290401);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      at localat = (at)paramList.next();
      if (kotlin.g.b.s.p(localat.TpX.TpV, paramString)) {
        localat.wwD.add(paramap);
      }
    }
    AppMethodBeat.o(290401);
  }
  
  private static final void a(kotlin.g.a.b paramb, com.tencent.mm.loader.g.a.a parama, com.tencent.mm.loader.d.b.g paramg, Bitmap paramBitmap)
  {
    AppMethodBeat.i(290451);
    kotlin.g.b.s.u(paramb, "$callback");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new g.c(paramb, paramBitmap));
    AppMethodBeat.o(290451);
  }
  
  private static c b(ImageView paramImageView, String paramString, a.c paramc, a.a parama, com.tencent.mm.plugin.textstatus.h.f.b paramb)
  {
    AppMethodBeat.i(290411);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (n.bp(localCharSequence))) {}
    for (int i = 1; (i != 0) || (paramImageView == null); i = 0)
    {
      AppMethodBeat.o(290411);
      return null;
    }
    paramImageView = new c(paramImageView, h.a(TBo, paramString), paramc, parama, paramb);
    AppMethodBeat.o(290411);
    return paramImageView;
  }
  
  public static ar hKu()
  {
    return TBo;
  }
  
  private static ar hKv()
  {
    Object localObject1 = null;
    AppMethodBeat.i(290424);
    for (;;)
    {
      try
      {
        localObject2 = e.TAU;
        arrayOfByte = y.bi(e.hKn(), 0, -1);
        if (arrayOfByte != null) {
          continue;
        }
      }
      finally
      {
        Object localObject2;
        byte[] arrayOfByte;
        continue;
      }
      AppMethodBeat.o(290424);
      return localObject1;
      localObject2 = new ar();
      ((ar)localObject2).parseFrom(arrayOfByte);
      localObject1 = localObject2;
    }
  }
  
  private static w hKw()
  {
    Object localObject1 = null;
    AppMethodBeat.i(290429);
    for (;;)
    {
      try
      {
        localObject2 = e.TAU;
        arrayOfByte = y.bi(e.hKo(), 0, -1);
        if (arrayOfByte != null) {
          continue;
        }
      }
      finally
      {
        Object localObject2;
        byte[] arrayOfByte;
        continue;
      }
      AppMethodBeat.o(290429);
      return localObject1;
      localObject2 = new w();
      ((w)localObject2).parseFrom(arrayOfByte);
      localObject1 = localObject2;
    }
  }
  
  private static ar hKx()
  {
    AppMethodBeat.i(290436);
    for (;;)
    {
      try
      {
        arrayOfByte = y.bi("assets:///text_status_config/icon.cfg", 0, -1);
        if (arrayOfByte != null) {
          continue;
        }
        Log.e("MicroMsg.TextStatus.StatusIconHelperV2", "getConfigFromAsset data null");
        localar1 = new ar();
      }
      finally
      {
        byte[] arrayOfByte;
        ar localar1;
        Log.printErrStackTrace("MicroMsg.TextStatus.StatusIconHelperV2", localThrowable, "getConfigFromAsset err", new Object[0]);
        ar localar2 = new ar();
        continue;
      }
      AppMethodBeat.o(290436);
      return localar1;
      localar1 = new ar();
      localar1.parseFrom(arrayOfByte);
    }
  }
  
  public static void u(String paramString, kotlin.g.a.b<? super Bitmap, ah> paramb)
  {
    AppMethodBeat.i(290445);
    kotlin.g.b.s.u(paramString, "url");
    kotlin.g.b.s.u(paramb, "callback");
    if (n.bp((CharSequence)paramString)) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramb.invoke(null);
      AppMethodBeat.o(290445);
      return;
    }
    com.tencent.mm.plugin.textstatus.c.d locald = com.tencent.mm.plugin.textstatus.c.d.TkB;
    com.tencent.mm.plugin.textstatus.c.d.eCl().dk(new com.tencent.mm.plugin.textstatus.c.b(paramString)).a(new g..ExternalSyntheticLambda0(paramb)).blg();
    AppMethodBeat.o(290445);
  }
  
  public final void G(Boolean paramBoolean)
  {
    AppMethodBeat.i(290582);
    if (kotlin.g.b.s.p(paramBoolean, Boolean.TRUE)) {}
    long l2;
    for (long l1 = 0L; kotlin.g.b.s.p(paramBoolean, Boolean.TRUE); l1 = TBo.key)
    {
      l2 = 0L;
      Log.i("MicroMsg.TextStatus.StatusIconHelperV2", "[reqNewestIconConfig] key:" + l1 + " coverAgendaKey:" + l2 + " isClientVersionChange:" + paramBoolean);
      paramBoolean = new com.tencent.mm.plugin.textstatus.h.g(l1, Long.valueOf(l2));
      com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)paramBoolean, 0);
      AppMethodBeat.o(290582);
      return;
    }
    Object localObject = TBp;
    if (localObject == null) {}
    for (localObject = null;; localObject = Long.valueOf(((w)localObject).key))
    {
      l2 = ((Long)localObject).longValue();
      break;
    }
  }
  
  public final ImageSpan a(View paramView, String paramString, a.c paramc, a.a parama, a.b paramb, int paramInt, com.tencent.mm.plugin.textstatus.h.f.b paramb1)
  {
    AppMethodBeat.i(290517);
    kotlin.g.b.s.u(paramc, "iconType");
    kotlin.g.b.s.u(parama, "iconColor");
    ColorDrawable localColorDrawable = new ColorDrawable(0);
    localColorDrawable.setBounds(0, 0, 0, 0);
    if (paramb == null)
    {
      i = -1;
      switch (i)
      {
      default: 
        j.a locala = j.TBr;
      }
    }
    for (int i = j.hKy();; i = 0)
    {
      paramView = (ImageSpan)new j(paramView, (Drawable)localColorDrawable, paramString, paramb1, paramb, paramc, parama, paramInt, i);
      AppMethodBeat.o(290517);
      return paramView;
      i = a.$EnumSwitchMapping$0[paramb.ordinal()];
      break;
    }
  }
  
  public final String a(TextStatusTopicInfo paramTextStatusTopicInfo, int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(290497);
    kotlin.g.b.s.u(paramString, "name");
    if (paramTextStatusTopicInfo == null)
    {
      AppMethodBeat.o(290497);
      return "";
    }
    paramTextStatusTopicInfo = h.a(TBo, paramTextStatusTopicInfo.iconId);
    if (paramTextStatusTopicInfo == null)
    {
      paramString = "";
      paramTextStatusTopicInfo = am.aixg;
      paramTextStatusTopicInfo = String.format(paramString, Arrays.copyOf(new Object[] { Integer.valueOf(paramInt1) }, 1));
      kotlin.g.b.s.s(paramTextStatusTopicInfo, "java.lang.String.format(format, *args)");
      AppMethodBeat.o(290497);
      return paramTextStatusTopicInfo;
    }
    switch (paramInt2)
    {
    default: 
      label108:
      paramTextStatusTopicInfo = "";
    }
    for (;;)
    {
      paramString = paramTextStatusTopicInfo;
      if (paramTextStatusTopicInfo != null) {
        break;
      }
      paramString = "";
      break;
      kotlin.g.b.s.u(paramTextStatusTopicInfo, "<this>");
      paramTextStatusTopicInfo = h.a(paramTextStatusTopicInfo);
      if (paramTextStatusTopicInfo == null) {
        break label108;
      }
      paramTextStatusTopicInfo = paramTextStatusTopicInfo.TpO;
      if (paramTextStatusTopicInfo == null) {
        break label108;
      }
      paramTextStatusTopicInfo = h.ca(paramTextStatusTopicInfo);
      if (paramTextStatusTopicInfo == null) {
        break label108;
      }
      continue;
      kotlin.g.b.s.u(paramTextStatusTopicInfo, "<this>");
      paramTextStatusTopicInfo = h.a(paramTextStatusTopicInfo);
      if (paramTextStatusTopicInfo == null) {
        break label108;
      }
      paramTextStatusTopicInfo = paramTextStatusTopicInfo.TpQ;
      if (paramTextStatusTopicInfo == null) {
        break label108;
      }
      paramTextStatusTopicInfo = h.ca(paramTextStatusTopicInfo);
      if (paramTextStatusTopicInfo == null) {
        break label108;
      }
    }
  }
  
  public final void a(ImageView paramImageView, String paramString, a.c paramc, a.a parama)
  {
    AppMethodBeat.i(290541);
    kotlin.g.b.s.u(paramc, "iconType");
    kotlin.g.b.s.u(parama, "iconColor");
    paramImageView = b(paramImageView, paramString, paramc, parama, null);
    if (paramImageView != null)
    {
      paramString = paramImageView.hKk();
      if (paramString != null) {
        paramImageView.du(paramString.TpR, h.a(paramString));
      }
    }
    AppMethodBeat.o(290541);
  }
  
  public final void a(ImageView paramImageView, String paramString, a.c paramc, a.a parama, com.tencent.mm.plugin.textstatus.h.f.b paramb)
  {
    AppMethodBeat.i(290532);
    kotlin.g.b.s.u(paramc, "iconType");
    kotlin.g.b.s.u(parama, "iconColor");
    paramImageView = b(paramImageView, paramString, paramc, parama, paramb);
    if (paramImageView != null)
    {
      paramString = paramImageView.hKk();
      if (paramString != null) {
        paramImageView.du(paramString.url, h.a(paramString));
      }
    }
    AppMethodBeat.o(290532);
  }
  
  public final void a(ae paramae)
  {
    AppMethodBeat.i(290594);
    kotlin.g.b.s.u(paramae, "rsp");
    if ((paramae.TpA == null) || (paramae.TpA.TpU.size() == 0) || (paramae.TpA.wwD.size() == 0))
    {
      Log.i("MicroMsg.TextStatus.StatusIconHelperV2", "handleIconConfigResult nochange");
      AppMethodBeat.o(290594);
      return;
    }
    long l1 = TBo.key;
    long l2 = paramae.TpA.key;
    Object localObject1 = paramae.TpA;
    kotlin.g.b.s.s(localObject1, "rsp.icon_config");
    TBo = (ar)localObject1;
    localObject1 = ((ar)localObject1).toByteArray();
    Object localObject2 = e.TAU;
    int i = y.f(e.hKn(), (byte[])localObject1, localObject1.length);
    localObject1 = new StringBuilder("res:").append(i).append(" handleIconConfigResult:");
    localObject2 = paramae.TpA;
    kotlin.g.b.s.s(localObject2, "rsp.icon_config");
    Log.i("MicroMsg.TextStatus.StatusIconHelperV2", h.a((ar)localObject2));
    if (i == 0)
    {
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adhd, Long.valueOf(cn.bDu()));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adhn, Integer.valueOf(com.tencent.mm.protocal.d.Yxh));
    }
    localObject1 = paramae.TpB;
    paramae = (ae)localObject1;
    if (localObject1 == null) {
      paramae = new w();
    }
    TBp = paramae;
    localObject1 = new StringBuilder("handleIconConfigResult:");
    paramae = TBp.Tpv;
    if (paramae == null) {}
    for (paramae = null;; paramae = Integer.valueOf(paramae.size()))
    {
      Log.i("MicroMsg.TextStatus.StatusIconHelperV2", paramae + ' ');
      paramae = e.TAU;
      paramae = e.hKo();
      localObject1 = TBp.toByteArray();
      y.f(paramae, (byte[])localObject1, localObject1.length);
      paramae = new zx();
      paramae.idv.idw = Long.valueOf(l1);
      paramae.idv.idy = Long.valueOf(l2);
      paramae.publish();
      AppMethodBeat.o(290594);
      return;
    }
  }
  
  public final boolean beh(String paramString)
  {
    AppMethodBeat.i(290486);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (n.bp(localCharSequence))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(290486);
      return false;
    }
    paramString = h.a(TBo, paramString);
    if (paramString == null) {}
    for (paramString = null; paramString != null; paramString = h.a(paramString, false))
    {
      AppMethodBeat.o(290486);
      return true;
    }
    AppMethodBeat.o(290486);
    return false;
  }
  
  public final String bei(String paramString)
  {
    AppMethodBeat.i(290491);
    paramString = h.a(TBo, paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(290491);
      return "";
    }
    paramString = h.b(paramString);
    AppMethodBeat.o(290491);
    return paramString;
  }
  
  public final void bej(String paramString)
  {
    AppMethodBeat.i(290567);
    kotlin.g.b.s.u(paramString, "iconId");
    Twm = paramString;
    AppMethodBeat.o(290567);
  }
  
  public final String f(TextStatusTopicInfo paramTextStatusTopicInfo)
  {
    AppMethodBeat.i(290493);
    if (paramTextStatusTopicInfo == null)
    {
      AppMethodBeat.o(290493);
      return "";
    }
    if (kotlin.g.b.s.p(paramTextStatusTopicInfo.iconId, "userdefine"))
    {
      paramTextStatusTopicInfo = paramTextStatusTopicInfo.title;
      if (paramTextStatusTopicInfo == null)
      {
        AppMethodBeat.o(290493);
        return "";
      }
      AppMethodBeat.o(290493);
      return paramTextStatusTopicInfo;
    }
    paramTextStatusTopicInfo = bei(paramTextStatusTopicInfo.iconId);
    AppMethodBeat.o(290493);
    return paramTextStatusTopicInfo;
  }
  
  public final ArrayList<com.tencent.mm.view.recyclerview.a> getDataList()
  {
    AppMethodBeat.i(290512);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new com.tencent.mm.plugin.textstatus.h.e.b(MMApplicationContext.getContext().getString(a.h.TgR)));
    Object localObject1 = TBo;
    if (localObject1 != null)
    {
      Object localObject2 = new LinkedList();
      Iterator localIterator = ((ar)localObject1).TpU.iterator();
      Object localObject3;
      Object localObject4;
      while (localIterator.hasNext())
      {
        localObject3 = (as)localIterator.next();
        localObject4 = new at();
        ((at)localObject4).TpX = ((as)localObject3);
        ((LinkedList)localObject2).add(localObject4);
      }
      localIterator = ((ar)localObject1).wwD.iterator();
      label162:
      label208:
      label211:
      while (localIterator.hasNext())
      {
        localObject3 = (ap)localIterator.next();
        kotlin.g.b.s.s(localObject3, "icon");
        localObject1 = h.a((ap)localObject3, true);
        if (localObject1 == null)
        {
          localObject1 = null;
          localObject4 = (CharSequence)localObject1;
          if ((localObject4 != null) && (!n.bp((CharSequence)localObject4))) {
            break label208;
          }
        }
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            break label211;
          }
          a((ap)localObject3, (String)localObject1, (List)localObject2);
          break;
          localObject1 = ((com.tencent.mm.plugin.textstatus.proto.aq)localObject1).groupId;
          break label162;
        }
      }
      localIterator = ((LinkedList)localObject2).iterator();
      while (localIterator.hasNext())
      {
        localObject3 = (at)localIterator.next();
        if (((at)localObject3).wwD.size() > 0)
        {
          localObject1 = ((at)localObject3).wwD;
          kotlin.g.b.s.s(localObject1, "group.icons");
          localObject1 = (List)localObject1;
          if (((List)localObject1).size() > 1) {
            kotlin.a.p.a((List)localObject1, (Comparator)new b());
          }
          localObject1 = ((at)localObject3).TpX;
          kotlin.g.b.s.s(localObject1, "group.iconGroup");
          kotlin.g.b.s.u(localObject1, "<this>");
          localObject1 = ((as)localObject1).TpW;
          kotlin.g.b.s.s(localObject1, "icon_group_descriptions");
          localObject2 = h.ca((LinkedList)localObject1);
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localArrayList.add(new com.tencent.mm.plugin.textstatus.h.e.a((String)localObject1));
          localObject1 = ((at)localObject3).wwD.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (ap)((Iterator)localObject1).next();
            kotlin.g.b.s.s(localObject2, "iconItem");
            localArrayList.add(new com.tencent.mm.plugin.textstatus.h.e.c(h.b((ap)localObject2), ((ap)localObject2).ToD));
          }
        }
      }
    }
    AppMethodBeat.o(290512);
    return localArrayList;
  }
  
  public final long getResVersion()
  {
    return TBo.key;
  }
  
  public final String hKe()
  {
    Object localObject3 = null;
    AppMethodBeat.i(290554);
    long l1 = cn.bDu() / 1000L;
    Object localObject1 = TBp;
    Object localObject5;
    if (localObject1 != null)
    {
      localObject1 = ((w)localObject1).Tpv;
      if (localObject1 != null)
      {
        localObject4 = ((Iterable)localObject1).iterator();
        localObject1 = null;
        for (;;)
        {
          localObject2 = localObject1;
          if (!((Iterator)localObject4).hasNext()) {
            break;
          }
          localObject5 = (x)((Iterator)localObject4).next();
          if ((((x)localObject5).ftu <= l1) && (((x)localObject5).end_time >= l1))
          {
            Log.i("MicroMsg.TextStatus.StatusIconHelperV2", "getCoverAgendaIconId: begin_time:" + ((x)localObject5).ftu + " end_time:" + ((x)localObject5).end_time + " nowTime:" + l1);
            localObject2 = TBn;
            if (localObject2 == null)
            {
              localObject2 = null;
              label166:
              if (localObject2 == null) {
                localObject1 = ((x)localObject5).ToD;
              }
            }
            else
            {
              long l2 = ((Number)localObject2).longValue();
              if ((l2 >= ((x)localObject5).ftu) && (l2 <= ((x)localObject5).end_time)) {
                break label243;
              }
              localObject1 = ((x)localObject5).ToD;
              Log.i("MicroMsg.TextStatus.StatusIconHelperV2", kotlin.g.b.s.X("getCoverAgendaIconId: lastAgendaClickTime:", Long.valueOf(l2)));
            }
            for (;;)
            {
              localObject2 = ah.aiuX;
              break label166;
              break;
              label243:
              Log.i("MicroMsg.TextStatus.StatusIconHelperV2", "getCoverAgendaIconId: Has been clicked");
            }
          }
          else
          {
            Log.w("MicroMsg.TextStatus.StatusIconHelperV2", "getCoverAgendaIconId Out of time range : begin_time:" + ((x)localObject5).ftu + " end_time:" + ((x)localObject5).end_time + " nowTime:" + l1);
          }
        }
      }
    }
    Object localObject2 = null;
    Object localObject4 = new StringBuilder("getCoverAgendaIconId: nowTime:").append(l1).append(" lastAgendaClickTime:").append(TBn).append(" coverAgenda.cover_icons.size:");
    localObject1 = TBp;
    if (localObject1 == null) {
      localObject1 = localObject3;
    }
    for (;;)
    {
      Log.i("MicroMsg.TextStatus.StatusIconHelperV2", localObject1 + " iconId:" + localObject2);
      AppMethodBeat.o(290554);
      return localObject2;
      localObject5 = ((w)localObject1).Tpv;
      localObject1 = localObject3;
      if (localObject5 != null) {
        localObject1 = Integer.valueOf(((LinkedList)localObject5).size());
      }
    }
  }
  
  public final String hKf()
  {
    String str2 = Twm;
    Twm = null;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final void onCreate()
  {
    boolean bool2 = true;
    AppMethodBeat.i(290476);
    Object localObject = hKv();
    boolean bool1;
    label46:
    label63:
    label93:
    long l1;
    int i;
    long l2;
    long l3;
    if (localObject != null)
    {
      bool1 = true;
      Log.i("MicroMsg.TextStatus.StatusIconHelperV2", kotlin.g.b.s.X("getConfigFromLocal isFromfile:", Boolean.valueOf(bool1)));
      if (localObject != null) {
        break label300;
      }
      localObject = hKx();
      TBo = (ar)localObject;
      localObject = hKw();
      if (localObject == null) {
        break label303;
      }
      bool1 = true;
      Log.i("MicroMsg.TextStatus.StatusIconHelperV2", kotlin.g.b.s.X("getCoverAgendaFromLocal isFromfile:", Boolean.valueOf(bool1)));
      if (localObject != null) {
        break label308;
      }
      localObject = new w();
      TBp = (w)localObject;
      TBn = Long.valueOf(com.tencent.mm.kernel.h.baE().ban().a(at.a.adhm, 0L));
      l1 = com.tencent.mm.kernel.h.baE().ban().a(at.a.adhd, 0L);
      i = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adhn, 0);
      l2 = cn.bDu();
      l3 = Math.abs(l2 - l1);
      if (l3 <= 86400000L) {
        break label311;
      }
      bool1 = true;
      label172:
      if (i == com.tencent.mm.protocal.d.Yxh) {
        break label316;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.TextStatus.StatusIconHelperV2", "initIconConfig lrt:" + l1 + " ct:" + l2 + " dt:" + l3 + " lastClientVersion:" + i + " version:" + com.tencent.mm.protocal.d.Yxh + " isReq:" + bool1 + " content:" + h.a(TBo));
      if ((bool1) || (bool2)) {
        G(Boolean.valueOf(bool2));
      }
      AppMethodBeat.o(290476);
      return;
      bool1 = false;
      break;
      label300:
      break label46;
      label303:
      bool1 = false;
      break label63;
      label308:
      break label93;
      label311:
      bool1 = false;
      break label172;
      label316:
      bool2 = false;
    }
  }
  
  public final void onDestroy() {}
  
  public final void wn(long paramLong)
  {
    AppMethodBeat.i(290561);
    TBn = Long.valueOf(paramLong);
    com.tencent.mm.kernel.h.baE().ban().set(at.a.adhm, Long.valueOf(paramLong));
    Log.i("MicroMsg.TextStatus.StatusIconHelperV2", kotlin.g.b.s.X("setCoverAgendaClickTime:  clickTime:", Long.valueOf(paramLong)));
    AppMethodBeat.o(290561);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k=3, mv={1, 5, 1})
  public static final class b<T>
    implements Comparator
  {
    public final int compare(T paramT1, T paramT2)
    {
      int j = 0;
      AppMethodBeat.i(290398);
      paramT1 = (ap)paramT1;
      kotlin.g.b.s.s(paramT1, "it");
      paramT1 = h.a(paramT1, true);
      if (paramT1 == null)
      {
        i = 0;
        paramT1 = (Comparable)Integer.valueOf(i);
        paramT2 = (ap)paramT2;
        kotlin.g.b.s.s(paramT2, "it");
        paramT2 = h.a(paramT2, true);
        if (paramT2 != null) {
          break label90;
        }
      }
      label90:
      for (int i = j;; i = paramT2.order)
      {
        i = kotlin.b.a.b(paramT1, (Comparable)Integer.valueOf(i));
        AppMethodBeat.o(290398);
        return i;
        i = paramT1.order;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.util.g
 * JD-Core Version:    0.7.0.1
 */