package com.tencent.mm.plugin.taskbar.ui.section.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.taskbar.ui.c.c;
import com.tencent.mm.plugin.taskbar.ui.section.b.a;
import com.tencent.mm.plugin.taskbar.ui.section.d.b;
import com.tencent.mm.plugin.taskbar.ui.section.g;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.aws;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.view.recyclerview.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/taskbar/ui/section/live/TaskBarSectionLiveView;", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionFinderView;", "context", "Landroid/content/Context;", "callback", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$Callback;", "sectionType", "", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "(Landroid/content/Context;Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$Callback;ILandroid/util/AttributeSet;I)V", "canAddToMinimize", "", "getClickedTaskBarItem", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "pos", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionFinderView$BaseViewHolder;", "onCreateViewHolder", "view", "Landroid/view/ViewGroup;", "refreshMask", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "obj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "removeItem", "titleName", "", "Companion", "ViewHolder", "plugin-taskbar_release"})
@SuppressLint({"ViewConstructor"})
public final class a
  extends com.tencent.mm.plugin.taskbar.ui.section.d
{
  public static final a FVN;
  private HashMap _$_findViewCache;
  
  static
  {
    AppMethodBeat.i(238538);
    FVN = new a((byte)0);
    AppMethodBeat.o(238538);
  }
  
  private a(Context paramContext, b.a parama, int paramInt)
  {
    super(paramContext, parama, paramInt, null, 0);
    AppMethodBeat.i(238537);
    AppMethodBeat.o(238537);
  }
  
  public a(Context paramContext, b.a parama, int paramInt, char paramChar)
  {
    this(paramContext, parama, paramInt, (byte)0);
  }
  
  public final d.b J(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(238533);
    kotlin.g.b.p.h(paramViewGroup, "view");
    paramViewGroup = LayoutInflater.from(getContext()).inflate(2131496657, paramViewGroup, false);
    kotlin.g.b.p.g(paramViewGroup, "itemView");
    paramViewGroup = (d.b)new b(paramViewGroup);
    AppMethodBeat.o(238533);
    return paramViewGroup;
  }
  
  public final void a(d.b paramb, int paramInt)
  {
    AppMethodBeat.i(238534);
    kotlin.g.b.p.h(paramb, "holder");
    Object localObject1 = new aws();
    try
    {
      ((aws)localObject1).parseFrom(((MultiTaskInfo)getViewModel().FVI.get(paramInt)).field_data);
      if (((aws)localObject1).tuO == null)
      {
        AppMethodBeat.o(238534);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Log.e("MicroMsg.TaskBarSectionLiveView", "FinderLiveMultiTaskData parse fail", new Object[] { localThrowable });
      }
      FinderObject localFinderObject = ((aws)localObject1).tuO;
      if (localFinderObject == null) {
        kotlin.g.b.p.hyc();
      }
      kotlin.g.b.p.g(localFinderObject, "data.finderObject!!");
      localObject1 = com.tencent.mm.plugin.finder.loader.m.uJa;
      Object localObject3 = com.tencent.mm.plugin.finder.loader.m.dka();
      localObject1 = localFinderObject.contact;
      if (localObject1 != null)
      {
        localObject2 = ((FinderContact)localObject1).headUrl;
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      localObject1 = new com.tencent.mm.plugin.finder.loader.a((String)localObject1);
      Object localObject2 = paramb.Mn(2131303423);
      kotlin.g.b.p.g(localObject2, "holder.getView(R.id.live_list_item_avatar)");
      localObject2 = (ImageView)localObject2;
      com.tencent.mm.plugin.finder.loader.m localm = com.tencent.mm.plugin.finder.loader.m.uJa;
      ((com.tencent.mm.loader.d)localObject3).a(localObject1, (ImageView)localObject2, com.tencent.mm.plugin.finder.loader.m.a(m.a.uJe));
      localObject2 = (TextView)paramb.Mn(2131303426);
      kotlin.g.b.p.g(localObject2, "it");
      localObject1 = c.FWh;
      localObject3 = getContext();
      localObject1 = localFinderObject.contact;
      if (localObject1 != null)
      {
        localObject1 = ((FinderContact)localObject1).nickname;
        if (localObject1 != null)
        {
          localObject1 = (CharSequence)localObject1;
          localObject1 = com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject3, (CharSequence)localObject1);
          kotlin.g.b.p.g(localObject1, "MMSpanManager.spanForSmi….contact?.nickname ?: \"\")");
          ((TextView)localObject2).setText(c.a((TextView)localObject2, (CharSequence)localObject1, com.tencent.mm.cb.a.fromDPToPix(getContext(), 62)));
          localObject1 = y.vXH;
          localObject1 = paramb.Mn(2131297096);
          kotlin.g.b.p.g(localObject1, "holder.getView(R.id.auth_icon)");
          localObject2 = (ImageView)localObject1;
          localObject1 = localFinderObject.contact;
          if (localObject1 == null) {
            break label595;
          }
          localObject1 = ((FinderContact)localObject1).authInfo;
          label313:
          y.a((ImageView)localObject2, (FinderAuthInfo)localObject1);
          localObject3 = (h)paramb;
          paramb = localFinderObject.liveInfo;
          if (paramb == null) {
            break label600;
          }
          paramInt = paramb.liveStatus;
          label340:
          paramb = localFinderObject.objectDesc;
          if (paramb == null) {
            break label605;
          }
          paramb = paramb.media;
          if (paramb == null) {
            break label605;
          }
          localObject1 = (FinderMedia)j.kt((List)paramb);
          label370:
          if (localObject1 != null)
          {
            localObject2 = ((FinderMedia)localObject1).coverUrl;
            paramb = (d.b)localObject2;
            if (localObject2 != null) {}
          }
          else
          {
            paramb = "";
          }
          kotlin.g.b.p.g(paramb, "firstMedia?.coverUrl ?: \"\"");
          if (localObject1 == null) {
            break label610;
          }
          localObject2 = ((FinderMedia)localObject1).thumbUrl;
          label408:
          if (localObject1 == null) {
            break label616;
          }
        }
      }
      label595:
      label600:
      label605:
      label610:
      label616:
      for (localObject1 = ((FinderMedia)localObject1).thumb_url_token;; localObject1 = null)
      {
        localObject1 = kotlin.g.b.p.I((String)localObject2, Util.nullAsNil((String)localObject1));
        if (!Util.isNullOrNil(paramb)) {
          localObject1 = paramb;
        }
        ((ImageView)((h)localObject3).Mn(2131309072)).setImageBitmap(null);
        if (paramInt != 1) {
          break label621;
        }
        paramb = com.tencent.mm.plugin.finder.loader.m.uJa;
        paramb = com.tencent.mm.plugin.finder.loader.m.djY().bQ(new com.tencent.mm.plugin.finder.loader.p((String)localObject1, x.vEn)).a((com.tencent.mm.loader.f.d)new com.tencent.mm.loader.e.d(null, null, 3));
        localObject1 = com.tencent.mm.plugin.finder.loader.m.uJa;
        paramb = paramb.a(com.tencent.mm.plugin.finder.loader.m.a(m.a.uJb));
        localObject1 = ((h)localObject3).Mn(2131309072);
        kotlin.g.b.p.g(localObject1, "holder.getView<ImageView…          R.id.thumb_img)");
        paramb.c((ImageView)localObject1);
        paramb = ((h)localObject3).Mn(2131301215);
        kotlin.g.b.p.g(paramb, "holder.getView<View>(R.i…inder_live_onlive_widget)");
        paramb.setVisibility(0);
        paramb = ((h)localObject3).Mn(2131300984);
        kotlin.g.b.p.g(paramb, "holder.getView<View>(R.id.finder_live_finish_logo)");
        paramb.setVisibility(8);
        AppMethodBeat.o(238534);
        return;
        localObject1 = (CharSequence)"";
        break;
        localObject1 = null;
        break label313;
        paramInt = 2;
        break label340;
        localObject1 = null;
        break label370;
        localObject2 = null;
        break label408;
      }
      label621:
      paramb = com.tencent.mm.plugin.finder.utils.m.vVH;
      paramb = ((h)localObject3).Mn(2131309072);
      kotlin.g.b.p.g(paramb, "holder.getView<ImageView>(R.id.thumb_img)");
      com.tencent.mm.plugin.finder.utils.m.h((ImageView)paramb, (String)localObject1);
      paramb = ((h)localObject3).Mn(2131301215);
      kotlin.g.b.p.g(paramb, "holder.getView<View>(R.i…inder_live_onlive_widget)");
      paramb.setVisibility(8);
      paramb = ((h)localObject3).Mn(2131300984);
      kotlin.g.b.p.g(paramb, "holder.getView<View>(R.id.finder_live_finish_logo)");
      paramb.setVisibility(0);
      AppMethodBeat.o(238534);
    }
  }
  
  public final MultiTaskInfo abH(int paramInt)
  {
    AppMethodBeat.i(238536);
    MultiTaskInfo localMultiTaskInfo1 = (MultiTaskInfo)getViewModel().FVI.get(paramInt);
    aws localaws1 = new aws();
    Collection localCollection;
    try
    {
      localaws1.parseFrom(localMultiTaskInfo1.field_data);
      localaws1.LHt = paramInt;
      Object localObject = (Iterable)getViewModel().FVI;
      localCollection = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MultiTaskInfo localMultiTaskInfo2 = (MultiTaskInfo)((Iterator)localObject).next();
        aws localaws2 = new aws();
        localaws2.parseFrom(localMultiTaskInfo2.field_data);
        localCollection.add(localaws2.tuO);
        continue;
        AppMethodBeat.o(238536);
      }
    }
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.TaskBarSectionLiveView", "FinderLiveMultiTaskData parse fail", new Object[] { localThrowable });
    }
    for (;;)
    {
      return localMultiTaskInfo1;
      localThrowable.LHu = new LinkedList((Collection)j.p((Iterable)localCollection));
      localMultiTaskInfo1.field_data = localThrowable.toByteArray();
    }
  }
  
  public final View ewN()
  {
    AppMethodBeat.i(238539);
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
    AppMethodBeat.o(238539);
    return localView1;
  }
  
  public final String fvi()
  {
    AppMethodBeat.i(238532);
    String str = getContext().getString(2131755731);
    kotlin.g.b.p.g(str, "context.getString(R.stri…and_taskbar_section_live)");
    AppMethodBeat.o(238532);
    return str;
  }
  
  public final boolean fvj()
  {
    return false;
  }
  
  public final void removeItem(int paramInt)
  {
    AppMethodBeat.i(238535);
    super.removeItem(paramInt);
    if (getViewModel().FVI.isEmpty()) {
      getCallback().abA(getSectionType());
    }
    AppMethodBeat.o(238535);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/taskbar/ui/section/live/TaskBarSectionLiveView$Companion;", "", "()V", "TAG", "", "plugin-taskbar_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/taskbar/ui/section/live/TaskBarSectionLiveView$ViewHolder;", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionFinderView$BaseViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "plugin-taskbar_release"})
  public static final class b
    extends d.b
  {
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(238531);
      AppMethodBeat.o(238531);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.section.b.a
 * JD-Core Version:    0.7.0.1
 */