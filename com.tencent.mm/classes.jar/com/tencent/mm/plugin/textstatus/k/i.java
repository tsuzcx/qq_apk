package com.tencent.mm.plugin.textstatus.k;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.ye;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.f.e;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.textstatus.a.a.a;
import com.tencent.mm.plugin.textstatus.a.a.b;
import com.tencent.mm.plugin.textstatus.a.a.c;
import com.tencent.mm.plugin.textstatus.b.e;
import com.tencent.mm.plugin.textstatus.b.h;
import com.tencent.mm.plugin.textstatus.g.d.c;
import com.tencent.mm.plugin.textstatus.proto.TextStatusTopicInfo;
import com.tencent.mm.plugin.textstatus.proto.ac;
import com.tencent.mm.plugin.textstatus.proto.ad;
import com.tencent.mm.plugin.textstatus.proto.ae;
import com.tencent.mm.plugin.textstatus.proto.af;
import com.tencent.mm.plugin.textstatus.proto.ag;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vfs.u;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.n.n;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/util/StatusIconHelperV2;", "Lcom/tencent/mm/plugin/textstatus/util/IStatusIconHelper;", "()V", "TAG", "", "curConfig", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusIconConfig;", "getCurConfig", "()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusIconConfig;", "setCurConfig", "(Lcom/tencent/mm/plugin/textstatus/proto/TextStatusIconConfig;)V", "addIconToGroup", "", "icon", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusIcon;", "groupId", "list", "", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusIconGroupWithIcons;", "getConfigFromAsset", "getConfigFromFile", "getConfigFromLocal", "getDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lkotlin/collections/ArrayList;", "getIconSpan", "Landroid/text/style/ImageSpan;", "attachView", "Landroid/view/View;", "id", "iconType", "Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconType;", "iconColor", "Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconColor;", "iconScene", "Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconScene;", "size", "", "item", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "getName", "getNameByInfo", "topicInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;", "getResVersion", "", "handleIconConfigResult", "rsp", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetIconConfigResp;", "initIconConfig", "isIconValidForSet", "", "loadIconBitmap", "url", "callback", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "onCreate", "onDestroy", "reqNewestIconConfig", "reset", "setIcon", "iv", "Landroid/widget/ImageView;", "iconId", "plugin-textstatus_release"})
public final class i
  extends a
{
  private static ae MON;
  public static final i MOO;
  
  static
  {
    AppMethodBeat.i(232206);
    MOO = new i();
    MON = new ae();
    AppMethodBeat.o(232206);
  }
  
  private static void a(ac paramac, String paramString, List<? extends ag> paramList)
  {
    AppMethodBeat.i(232190);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ag localag = (ag)paramList.next();
      if (kotlin.g.b.p.h(localag.MFJ.MFH, paramString)) {
        localag.tse.add(paramac);
      }
    }
    AppMethodBeat.o(232190);
  }
  
  public static ae gnJ()
  {
    return MON;
  }
  
  private static ae gnK()
  {
    Object localObject1 = null;
    AppMethodBeat.i(232201);
    for (;;)
    {
      try
      {
        localObject2 = f.MOw;
        arrayOfByte = u.aY(f.gnE(), 0, -1);
        if (arrayOfByte != null) {
          continue;
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject2;
        byte[] arrayOfByte;
        continue;
      }
      AppMethodBeat.o(232201);
      return localObject1;
      localObject2 = new ae();
      ((ae)localObject2).parseFrom(arrayOfByte);
      localObject1 = localObject2;
    }
  }
  
  private static ae gnL()
  {
    AppMethodBeat.i(232202);
    for (;;)
    {
      try
      {
        arrayOfByte = u.aY("assets:///text_status_config/icon.cfg", 0, -1);
        if (arrayOfByte != null) {
          continue;
        }
        Log.e("MicroMsg.TextStatus.StatusIconHelperV2", "getConfigFromAsset data null");
        localae1 = new ae();
      }
      catch (Throwable localThrowable)
      {
        byte[] arrayOfByte;
        ae localae1;
        Log.printErrStackTrace("MicroMsg.TextStatus.StatusIconHelperV2", localThrowable, "getConfigFromAsset err", new Object[0]);
        ae localae2 = new ae();
        continue;
      }
      AppMethodBeat.o(232202);
      return localae1;
      localae1 = new ae();
      localae1.parseFrom(arrayOfByte);
    }
  }
  
  public static void o(String paramString, kotlin.g.a.b<? super Bitmap, x> paramb)
  {
    AppMethodBeat.i(232205);
    kotlin.g.b.p.k(paramString, "url");
    kotlin.g.b.p.k(paramb, "callback");
    if (n.ba((CharSequence)paramString)) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramb.invoke(null);
      AppMethodBeat.o(232205);
      return;
    }
    com.tencent.mm.plugin.textstatus.c.d locald = com.tencent.mm.plugin.textstatus.c.d.MAU;
    com.tencent.mm.plugin.textstatus.c.d.dJe().bQ(new com.tencent.mm.plugin.textstatus.c.b(paramString)).a((e)new i.b(paramb)).aRr();
    AppMethodBeat.o(232205);
  }
  
  public final ImageSpan a(View paramView, String paramString, a.c paramc, a.a parama, a.b paramb, int paramInt, com.tencent.mm.plugin.textstatus.g.e.a parama1)
  {
    AppMethodBeat.i(232194);
    kotlin.g.b.p.k(paramc, "iconType");
    kotlin.g.b.p.k(parama, "iconColor");
    ColorDrawable localColorDrawable = new ColorDrawable(0);
    localColorDrawable.setBounds(0, 0, 0, 0);
    paramView = (ImageSpan)new l(paramView, (Drawable)localColorDrawable, paramString, parama1, paramb, paramc, parama, paramInt);
    AppMethodBeat.o(232194);
    return paramView;
  }
  
  public final void a(ImageView paramImageView, String paramString, a.c paramc, a.a parama, com.tencent.mm.plugin.textstatus.g.e.a parama1)
  {
    AppMethodBeat.i(232199);
    kotlin.g.b.p.k(paramc, "iconType");
    kotlin.g.b.p.k(parama, "iconColor");
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (n.ba(localCharSequence))) {}
    for (int i = 1; (i != 0) || (paramImageView == null); i = 0)
    {
      AppMethodBeat.o(232199);
      return;
    }
    paramString = j.a(MON, paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(232199);
      return;
    }
    paramString = new d(paramImageView, paramString, paramc, parama, parama1);
    paramImageView = (ImageView)paramString.Gfw.get();
    if (paramImageView == null)
    {
      AppMethodBeat.o(232199);
      return;
    }
    kotlin.g.b.p.j(paramImageView, "ivRef.get()?:return");
    paramc = paramString.MOq.MFB;
    paramImageView.setTag(b.e.MwF, paramc);
    paramImageView = j.a(paramString.MOq);
    if (paramImageView == null)
    {
      paramImageView = paramString.MDH;
      if (paramImageView != null)
      {
        paramImageView = paramImageView.glY().iconActions;
        if (paramImageView != null) {
          paramImageView = j.is((List)paramImageView);
        }
      }
    }
    for (;;)
    {
      if (paramImageView != null)
      {
        parama = paramImageView.url;
        kotlin.g.b.p.j(parama, "action.url");
        o(parama, (kotlin.g.a.b)new d.a(paramString, paramImageView, paramc));
      }
      AppMethodBeat.o(232199);
      return;
      paramImageView = null;
    }
  }
  
  public final void a(com.tencent.mm.plugin.textstatus.proto.p paramp)
  {
    AppMethodBeat.i(232204);
    kotlin.g.b.p.k(paramp, "rsp");
    if ((paramp.MFo == null) || (paramp.MFo.MFG.size() == 0) || (paramp.MFo.tse.size() == 0))
    {
      Log.i("MicroMsg.TextStatus.StatusIconHelperV2", "handleIconConfigResult nochange");
      AppMethodBeat.o(232204);
      return;
    }
    long l1 = MON.key;
    long l2 = paramp.MFo.key;
    Object localObject = paramp.MFo;
    kotlin.g.b.p.j(localObject, "rsp.icon_config");
    MON = (ae)localObject;
    localObject = ((ae)localObject).toByteArray();
    f localf = f.MOw;
    int i = u.H(f.gnE(), (byte[])localObject);
    localObject = new StringBuilder("res:").append(i).append(" handleIconConfigResult:");
    paramp = paramp.MFo;
    kotlin.g.b.p.j(paramp, "rsp.icon_config");
    Log.i("MicroMsg.TextStatus.StatusIconHelperV2", j.a(paramp));
    if (i == 0)
    {
      paramp = h.aHG();
      kotlin.g.b.p.j(paramp, "MMKernel.storage()");
      paramp.aHp().set(ar.a.VEc, Long.valueOf(cm.bfC()));
    }
    paramp = new ye();
    paramp.fXv.fXw = Long.valueOf(l1);
    paramp.fXv.fXx = Long.valueOf(l2);
    EventCenter.instance.publish((IEvent)paramp);
    AppMethodBeat.o(232204);
  }
  
  public final boolean beI(String paramString)
  {
    AppMethodBeat.i(232186);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (n.ba(localCharSequence))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(232186);
      return false;
    }
    paramString = j.a(MON, paramString);
    if (paramString != null) {}
    for (paramString = j.a(paramString, false); paramString != null; paramString = null)
    {
      AppMethodBeat.o(232186);
      return true;
    }
    AppMethodBeat.o(232186);
    return false;
  }
  
  public final String beJ(String paramString)
  {
    AppMethodBeat.i(232187);
    paramString = j.a(MON, paramString);
    if (paramString != null)
    {
      String str = j.b(paramString);
      paramString = str;
      if (str != null) {}
    }
    else
    {
      paramString = "";
    }
    AppMethodBeat.o(232187);
    return paramString;
  }
  
  public final String d(TextStatusTopicInfo paramTextStatusTopicInfo)
  {
    AppMethodBeat.i(232188);
    kotlin.g.b.p.k(paramTextStatusTopicInfo, "topicInfo");
    if (kotlin.g.b.p.h(paramTextStatusTopicInfo.iconId, "custom"))
    {
      paramTextStatusTopicInfo = paramTextStatusTopicInfo.title;
      AppMethodBeat.o(232188);
      return paramTextStatusTopicInfo;
    }
    paramTextStatusTopicInfo = beJ(paramTextStatusTopicInfo.iconId);
    AppMethodBeat.o(232188);
    return paramTextStatusTopicInfo;
  }
  
  public final ArrayList<com.tencent.mm.view.recyclerview.a> getDataList()
  {
    AppMethodBeat.i(232192);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new com.tencent.mm.plugin.textstatus.g.d.b(MMApplicationContext.getContext().getString(b.h.MyY)));
    Object localObject1 = MON;
    if (localObject1 != null)
    {
      Object localObject2 = new LinkedList();
      Iterator localIterator = ((ae)localObject1).MFG.iterator();
      Object localObject3;
      Object localObject4;
      while (localIterator.hasNext())
      {
        localObject3 = (af)localIterator.next();
        localObject4 = new ag();
        ((ag)localObject4).MFJ = ((af)localObject3);
        ((LinkedList)localObject2).add(localObject4);
      }
      localIterator = ((ae)localObject1).tse.iterator();
      label165:
      label208:
      label211:
      while (localIterator.hasNext())
      {
        localObject3 = (ac)localIterator.next();
        kotlin.g.b.p.j(localObject3, "icon");
        localObject1 = j.a((ac)localObject3, true);
        if (localObject1 != null)
        {
          localObject1 = ((ad)localObject1).groupId;
          localObject4 = (CharSequence)localObject1;
          if ((localObject4 != null) && (!n.ba((CharSequence)localObject4))) {
            break label208;
          }
        }
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            break label211;
          }
          a((ac)localObject3, (String)localObject1, (List)localObject2);
          break;
          localObject1 = null;
          break label165;
        }
      }
      localIterator = ((LinkedList)localObject2).iterator();
      while (localIterator.hasNext())
      {
        localObject3 = (ag)localIterator.next();
        if (((ag)localObject3).tse.size() > 0)
        {
          localObject1 = ((ag)localObject3).tse;
          kotlin.g.b.p.j(localObject1, "group.icons");
          localObject1 = (List)localObject1;
          if (((List)localObject1).size() > 1) {
            kotlin.a.j.a((List)localObject1, (Comparator)new i.a());
          }
          localObject1 = ((ag)localObject3).MFJ;
          kotlin.g.b.p.j(localObject1, "group.iconGroup");
          kotlin.g.b.p.k(localObject1, "$this$getDesc");
          localObject1 = ((af)localObject1).MFI;
          kotlin.g.b.p.j(localObject1, "icon_group_descriptions");
          localObject2 = j.bQ((LinkedList)localObject1);
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localArrayList.add(new com.tencent.mm.plugin.textstatus.g.d.a((String)localObject1));
          localObject1 = ((ag)localObject3).tse.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (ac)((Iterator)localObject1).next();
            kotlin.g.b.p.j(localObject2, "iconItem");
            localArrayList.add(new c(j.b((ac)localObject2), ((ac)localObject2).MFB));
          }
        }
      }
    }
    AppMethodBeat.o(232192);
    return localArrayList;
  }
  
  public final long getResVersion()
  {
    return MON.key;
  }
  
  public final void gnx()
  {
    AppMethodBeat.i(232203);
    long l = MON.key;
    Log.i("MicroMsg.TextStatus.StatusIconHelperV2", "[reqNewestIconConfig] key:".concat(String.valueOf(l)));
    com.tencent.mm.plugin.textstatus.g.f localf = new com.tencent.mm.plugin.textstatus.g.f(l);
    h.aGY().b((q)localf);
    AppMethodBeat.o(232203);
  }
  
  public final void onCreate()
  {
    boolean bool2 = true;
    AppMethodBeat.i(232184);
    Object localObject = gnK();
    StringBuilder localStringBuilder = new StringBuilder("getConfigFromLocal isFromfile:");
    boolean bool1;
    if (localObject != null)
    {
      bool1 = true;
      Log.i("MicroMsg.TextStatus.StatusIconHelperV2", bool1);
      if (localObject != null) {
        break label206;
      }
      localObject = gnL();
    }
    label206:
    for (;;)
    {
      MON = (ae)localObject;
      localObject = h.aHG();
      kotlin.g.b.p.j(localObject, "MMKernel.storage()");
      long l1 = ((com.tencent.mm.kernel.f)localObject).aHp().a(ar.a.VEc, 0L);
      long l2 = cm.bfC();
      long l3 = Math.abs(l2 - l1);
      if (l3 > 86400000L) {}
      for (bool1 = bool2;; bool1 = false)
      {
        Log.i("MicroMsg.TextStatus.StatusIconHelperV2", "initIconConfig lrt:" + l1 + " ct:" + l2 + " dt:" + l3 + " isReq:" + bool1 + " content:" + j.a(MON));
        if (bool1) {
          gnx();
        }
        AppMethodBeat.o(232184);
        return;
        bool1 = false;
        break;
      }
    }
  }
  
  public final void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.k.i
 * JD-Core Version:    0.7.0.1
 */