package com.tencent.mm.plugin.taskbar.ui.section.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.taskbar.ui.section.b.a;
import com.tencent.mm.plugin.taskbar.ui.section.d.b;
import com.tencent.mm.plugin.taskbar.ui.section.g;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.aop;
import com.tencent.mm.protocal.protobuf.aoq;
import com.tencent.mm.protocal.protobuf.bei;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.protocal.protobuf.cnl;
import com.tencent.mm.protocal.protobuf.cnu;
import com.tencent.mm.protocal.protobuf.cod;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/taskbar/ui/section/video/TaskBarSectionVideoView;", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionFinderView;", "context", "Landroid/content/Context;", "callback", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$Callback;", "sectionType", "", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "(Landroid/content/Context;Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$Callback;ILandroid/util/AttributeSet;I)V", "makeTimeString", "", "d", "onBindViewHolder", "", "viewHolder", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionFinderView$BaseViewHolder;", "pos", "onCreateViewHolder", "view", "Landroid/view/ViewGroup;", "titleName", "Companion", "ViewHolder", "plugin-taskbar_release"})
@SuppressLint({"ViewConstructor"})
public final class a
  extends com.tencent.mm.plugin.taskbar.ui.section.d
{
  public static final a FVP;
  private HashMap _$_findViewCache;
  
  static
  {
    AppMethodBeat.i(238552);
    FVP = new a((byte)0);
    AppMethodBeat.o(238552);
  }
  
  private a(Context paramContext, b.a parama, int paramInt)
  {
    super(paramContext, parama, paramInt, null, 0);
    AppMethodBeat.i(238551);
    AppMethodBeat.o(238551);
  }
  
  public a(Context paramContext, b.a parama, int paramInt, char paramChar)
  {
    this(paramContext, parama, paramInt, (byte)0);
  }
  
  private static String xt(int paramInt)
  {
    AppMethodBeat.i(238550);
    if (paramInt < 10)
    {
      str = "0".concat(String.valueOf(paramInt));
      AppMethodBeat.o(238550);
      return str;
    }
    String str = String.valueOf(paramInt);
    AppMethodBeat.o(238550);
    return str;
  }
  
  public final d.b J(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(238548);
    kotlin.g.b.p.h(paramViewGroup, "view");
    paramViewGroup = LayoutInflater.from(getContext()).inflate(2131496663, paramViewGroup, false);
    kotlin.g.b.p.g(paramViewGroup, "itemView");
    paramViewGroup = (d.b)new b(paramViewGroup);
    AppMethodBeat.o(238548);
    return paramViewGroup;
  }
  
  @SuppressLint({"SetTextI18n"})
  public final void a(d.b paramb, int paramInt)
  {
    AppMethodBeat.i(238549);
    kotlin.g.b.p.h(paramb, "viewHolder");
    if (!(paramb instanceof b))
    {
      AppMethodBeat.o(238549);
      return;
    }
    Object localObject1 = new cnu();
    FinderObject localFinderObject;
    Object localObject3;
    Object localObject4;
    Object localObject2;
    Object localObject5;
    try
    {
      ((cnu)localObject1).parseFrom(((MultiTaskInfo)getViewModel().FVI.get(paramInt)).field_data);
      if (((cnu)localObject1).Muf.isEmpty())
      {
        AppMethodBeat.o(238549);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Log.e("AppBrandDesktopSectionVideoView", "MegaVideoFloatBallInfo parse fail", new Object[] { localThrowable });
      }
      localFinderObject = (FinderObject)((cnu)localObject1).Muf.get(0);
      localObject3 = localFinderObject.contact;
      localObject1 = m.uJa;
      localObject4 = m.dka();
      if (localObject3 != null)
      {
        localObject2 = ((FinderContact)localObject3).headUrl;
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      localObject1 = new com.tencent.mm.plugin.finder.loader.a((String)localObject1);
      localObject2 = ((b)paramb).keC;
      kotlin.g.b.p.g(localObject2, "viewHolder.avatar");
      localObject5 = m.uJa;
      ((com.tencent.mm.loader.d)localObject4).a(localObject1, (ImageView)localObject2, m.a(m.a.uJe));
      localObject2 = ((b)paramb).uuB;
      kotlin.g.b.p.g(localObject2, "viewHolder.nickname");
      localObject1 = com.tencent.mm.plugin.taskbar.ui.c.c.FWh;
      localObject4 = ((b)paramb).uuB;
      kotlin.g.b.p.g(localObject4, "viewHolder.nickname");
      localObject5 = getContext();
      if (localObject3 == null) {
        break label771;
      }
    }
    localObject1 = ((FinderContact)localObject3).nickname;
    localObject1 = com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject5, (CharSequence)localObject1);
    if (localObject1 != null)
    {
      localObject1 = (CharSequence)localObject1;
      label278:
      ((TextView)localObject2).setText(com.tencent.mm.plugin.taskbar.ui.c.c.a((TextView)localObject4, (CharSequence)localObject1, com.tencent.mm.cb.a.fromDPToPix(getContext(), 62)));
      if (localObject3 != null)
      {
        localObject1 = y.vXH;
        localObject1 = ((b)paramb).vMF;
        kotlin.g.b.p.g(localObject1, "viewHolder.authIcon");
        y.a((ImageView)localObject1, ((FinderContact)localObject3).authInfo);
      }
      if (localFinderObject == null) {
        break label787;
      }
      localObject1 = localFinderObject.objectDesc;
      if (localObject1 == null) {
        break label787;
      }
      localObject1 = ((FinderObjectDesc)localObject1).media;
      if (localObject1 == null) {
        break label787;
      }
      localObject2 = (FinderMedia)((LinkedList)localObject1).getFirst();
      label376:
      if (localObject2 != null)
      {
        localObject3 = ((FinderMedia)localObject2).coverUrl;
        localObject1 = localObject3;
        if (localObject3 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      kotlin.g.b.p.g(localObject1, "finderMedia?.coverUrl ?: \"\"");
      if (localObject2 == null) {
        break label793;
      }
      localObject3 = ((FinderMedia)localObject2).thumbUrl;
      label421:
      if (localObject2 == null) {
        break label799;
      }
      localObject2 = ((FinderMedia)localObject2).thumb_url_token;
      label433:
      localObject2 = kotlin.g.b.p.I((String)localObject3, Util.nullAsNil((String)localObject2));
      if (!Util.isNullOrNil((String)localObject1)) {
        localObject2 = localObject1;
      }
      localObject1 = ((b)paramb).xDr;
      ((ImageView)localObject1).setImageBitmap(null);
      localObject3 = m.uJa;
      localObject2 = m.djY().bQ(new com.tencent.mm.plugin.finder.loader.p((String)localObject2, x.vEn)).a((com.tencent.mm.loader.f.d)new com.tencent.mm.loader.e.d(null, null, 3));
      localObject3 = m.uJa;
      localObject2 = ((com.tencent.mm.loader.b)localObject2).a(m.a(m.a.uJb));
      kotlin.g.b.p.g(localObject1, "it");
      ((com.tencent.mm.loader.b)localObject2).c((ImageView)localObject1);
      if (localFinderObject == null) {
        break label805;
      }
      localObject1 = localFinderObject.attachmentList;
      if (localObject1 == null) {
        break label805;
      }
      localObject1 = ((aoq)localObject1).LAM;
      if (localObject1 == null) {
        break label805;
      }
      localObject1 = (aop)kotlin.a.j.kt((List)localObject1);
      if (localObject1 == null) {
        break label805;
      }
      localObject1 = ((aop)localObject1).LAL;
      if (localObject1 == null) {
        break label805;
      }
      localObject1 = ((bei)localObject1).LIA;
      if (localObject1 == null) {
        break label805;
      }
      localObject1 = ((cng)localObject1).MtG;
      if (localObject1 == null) {
        break label805;
      }
      localObject1 = ((cnl)localObject1).media;
      if (localObject1 == null) {
        break label805;
      }
      localObject1 = (cod)kotlin.a.j.kt((List)localObject1);
      if (localObject1 == null) {
        break label805;
      }
    }
    label771:
    label787:
    label793:
    label799:
    label805:
    for (paramInt = com.tencent.mm.plugin.finder.storage.data.j.a((cod)localObject1).videoDuration;; paramInt = 0)
    {
      if (paramInt > 0)
      {
        long l = paramInt;
        localObject1 = com.tencent.mm.plugin.finder.storage.c.vCb;
        int i = paramInt;
        if (l >= com.tencent.mm.plugin.finder.storage.c.drG() * 1000L) {
          i = paramInt / 1000;
        }
        paramb = ((b)paramb).pwO;
        kotlin.g.b.p.g(paramb, "viewHolder.time");
        paramb.setText((CharSequence)(xt(i / 60) + ":" + xt(i % 60)));
      }
      AppMethodBeat.o(238549);
      return;
      localObject1 = null;
      break;
      localObject1 = (CharSequence)"";
      break label278;
      localObject2 = null;
      break label376;
      localObject3 = null;
      break label421;
      localObject2 = null;
      break label433;
    }
  }
  
  public final View ewN()
  {
    AppMethodBeat.i(238553);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(2131299174));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(2131299174);
      this._$_findViewCache.put(Integer.valueOf(2131299174), localView1);
    }
    AppMethodBeat.o(238553);
    return localView1;
  }
  
  public final String fvi()
  {
    AppMethodBeat.i(238547);
    String str = getContext().getString(2131755733);
    kotlin.g.b.p.g(str, "context.getString(R.stri…nd_taskbar_section_video)");
    AppMethodBeat.o(238547);
    return str;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/taskbar/ui/section/video/TaskBarSectionVideoView$Companion;", "", "()V", "TAG", "", "plugin-taskbar_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/taskbar/ui/section/video/TaskBarSectionVideoView$ViewHolder;", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionFinderView$BaseViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "authIcon", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getAuthIcon", "()Landroid/widget/ImageView;", "avatar", "getAvatar", "nickname", "Landroid/widget/TextView;", "getNickname", "()Landroid/widget/TextView;", "thumbImg", "getThumbImg", "time", "getTime", "plugin-taskbar_release"})
  public static final class b
    extends d.b
  {
    final ImageView keC;
    final TextView pwO;
    final TextView uuB;
    final ImageView vMF;
    final ImageView xDr;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(238546);
      this.xDr = ((ImageView)paramView.findViewById(2131309072));
      this.keC = ((ImageView)paramView.findViewById(2131303423));
      this.uuB = ((TextView)paramView.findViewById(2131303426));
      this.vMF = ((ImageView)paramView.findViewById(2131297096));
      this.pwO = ((TextView)paramView.findViewById(2131309086));
      AppMethodBeat.o(238546);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.section.d.a
 * JD-Core Version:    0.7.0.1
 */