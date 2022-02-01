package com.tencent.mm.plugin.story.f;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.particles.c;
import com.tencent.mm.particles.d;
import com.tencent.mm.plugin.story.api.AbsStoryGallery;
import com.tencent.mm.plugin.story.api.AbsStoryHeaderTipView;
import com.tencent.mm.plugin.story.api.AbsStoryMuteView;
import com.tencent.mm.plugin.story.api.i;
import com.tencent.mm.plugin.story.api.n.a;
import com.tencent.mm.plugin.story.ui.album.StoryAlbumUI;
import com.tencent.mm.plugin.story.ui.view.StoryHeaderTipView;
import com.tencent.mm.plugin.story.ui.view.StoryMuteView;
import com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.MMFragment;
import d.a.j;
import d.g.b.k;
import d.g.b.v.f;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/model/StoryUIFactory;", "Lcom/tencent/mm/plugin/story/api/IStoryUIFactory;", "()V", "CONFETTI_WIDTH_DP", "", "TAG", "", "VIVO_COMPATIBLE_LIST", "", "confettiManagers", "Ljava/util/HashMap;", "Landroid/view/View;", "Lcom/tencent/mm/particles/ConfettiManager;", "Lkotlin/collections/HashMap;", "mRunningConfetti", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "printLog", "", "unreadConfettiGenerator", "Lcom/tencent/mm/particles/ConfettiGenerator;", "bindUnreadBubbleConfetti", "", "parentView", "Landroid/view/ViewGroup;", "anchor", "offsetX", "offsetY", "genCompatibleBubble", "Landroid/graphics/Bitmap;", "getStoryGallery", "Lcom/tencent/mm/plugin/story/api/AbsStoryGallery;", "context", "Landroid/content/Context;", "type", "Lcom/tencent/mm/plugin/story/api/IStoryUIFactory$GalleryType;", "chatRoom", "getStoryHeaderTipView", "Lcom/tencent/mm/plugin/story/api/AbsStoryHeaderTipView;", "getStoryHintDrawable", "Landroid/graphics/drawable/Drawable;", "highLight", "getStoryHintProxy", "Lcom/tencent/mm/plugin/story/api/IStoryHintProxy;", "getStoryMuteView", "Lcom/tencent/mm/plugin/story/api/AbsStoryMuteView;", "instantiateAlbumFragment", "Lcom/tencent/mm/ui/MMFragment;", "bundle", "Landroid/os/Bundle;", "isInCompatibleList", "lazyInit", "startUnreadBubbleConfetti", "stopUnreadBubbleConfetti", "unbindUnreadBubbleConfetti", "plugin-story_release"})
public final class r
  implements com.tencent.mm.plugin.story.api.n
{
  private static final String TAG = "MicroMsg.StoryUIFactory";
  private static com.tencent.mm.particles.b zta;
  private static HashMap<View, c> ztb;
  private static ArrayList<c> ztc;
  private static int ztd;
  private static boolean zte;
  private static final List<String> ztf;
  public static final r ztg;
  
  static
  {
    AppMethodBeat.i(118788);
    ztg = new r();
    TAG = "MicroMsg.StoryUIFactory";
    ztb = new HashMap();
    ztc = new ArrayList();
    zte = true;
    ztf = j.listOf(new String[] { "y83a", "v1732a", " y83", "v1732t" });
    AppMethodBeat.o(118788);
  }
  
  public final AbsStoryGallery a(Context paramContext, n.a parama, String paramString)
  {
    AppMethodBeat.i(118779);
    k.h(paramContext, "context");
    k.h(parama, "type");
    paramContext = new StoryGalleryView(paramContext, parama, 0, false, null, 28);
    paramContext.setChatRoom(paramString);
    paramContext = (AbsStoryGallery)paramContext;
    AppMethodBeat.o(118779);
    return paramContext;
  }
  
  public final void d(ViewGroup paramViewGroup, View paramView, int paramInt)
  {
    AppMethodBeat.i(174578);
    k.h(paramView, "anchor");
    v.f localf;
    Object localObject1;
    int i;
    if (zta == null)
    {
      ztd = a.fromDPToPix(ai.getContext(), 8);
      localf = new v.f();
      if (zte)
      {
        ac.i(TAG, "isInCompatibleList " + Build.BRAND + "  config " + bw.fcC() + ' ');
        zte = false;
      }
      Object localObject2 = (Iterable)ztf;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      label221:
      label225:
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        String str1 = (String)localObject3;
        String str2 = Build.MODEL;
        k.g(str2, "Build.MODEL");
        if (!d.n.n.a((CharSequence)str2, (CharSequence)str1, true))
        {
          str2 = Build.DEVICE;
          k.g(str2, "Build.DEVICE");
          if (!d.n.n.a((CharSequence)str2, (CharSequence)str1, true)) {
            break label221;
          }
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label225;
          }
          ((Collection)localObject1).add(localObject3);
          break;
        }
      }
      localObject1 = (List)localObject1;
      if ((!k.g(Build.BRAND, "vivo")) || (((List)localObject1).isEmpty()) || (Build.VERSION.SDK_INT != 27)) {
        break label513;
      }
      i = 1;
      if (i == 0) {
        break label519;
      }
      localObject1 = ai.getContext();
      k.g(localObject1, "MMApplicationContext.getContext()");
      localObject1 = BitmapFactory.decodeResource(((Context)localObject1).getResources(), 2131234240);
      k.g(localObject1, "BitmapFactory.decodeReso…ble.story_comment_bubble)");
    }
    for (;;)
    {
      localf.KUQ = localObject1;
      zta = (com.tencent.mm.particles.b)new a(localf);
      if (!ztb.containsKey(paramView))
      {
        localObject1 = new int[2];
        Object tmp345_343 = localObject1;
        tmp345_343[0] = 0;
        Object tmp349_345 = tmp345_343;
        tmp349_345[1] = 0;
        tmp349_345;
        paramView.getLocationOnScreen((int[])localObject1);
        i = localObject1[0] + paramView.getWidth() / 2 - ztd / 2 + 0;
        paramInt = localObject1[1] + paramInt;
        ac.d(TAG, "bindUnreadBubbleConfetti containerMiddleX=" + i + " containerMiddleY=" + paramInt);
        localObject1 = new d(i, paramInt);
        paramViewGroup = new c(ai.getContext(), zta, (d)localObject1, paramViewGroup).aMq().al(8.0F).B(0.0F, 15.0F).C(-60.0F, 10.0F).qy(1500L);
        localObject1 = (Map)ztb;
        k.g(paramViewGroup, "manager");
        ((Map)localObject1).put(paramView, paramViewGroup);
      }
      AppMethodBeat.o(174578);
      return;
      label513:
      i = 0;
      break;
      label519:
      localObject1 = ai.getContext();
      k.g(localObject1, "MMApplicationContext.getContext()");
      localObject1 = BitmapFactory.decodeResource(((Context)localObject1).getResources(), 2131234240);
      i = ztd;
      localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject1, i, i, true);
    }
  }
  
  public final void fm(View paramView)
  {
    AppMethodBeat.i(118785);
    k.h(paramView, "anchor");
    if (ztb.containsKey(paramView)) {
      ztb.remove(paramView);
    }
    AppMethodBeat.o(118785);
  }
  
  public final void fn(View paramView)
  {
    AppMethodBeat.i(118786);
    k.h(paramView, "anchor");
    ac.d(TAG, "startUnreadBubbleConfetti mRunningConfetti=" + ztc);
    paramView = (c)ztb.get(paramView);
    if (paramView != null)
    {
      if (!ztc.contains(paramView))
      {
        ac.d(TAG, "startUnreadBubbleConfetti");
        paramView.aMu();
        ztc.add(paramView);
      }
      AppMethodBeat.o(118786);
      return;
    }
    AppMethodBeat.o(118786);
  }
  
  public final void fo(View paramView)
  {
    AppMethodBeat.i(118787);
    k.h(paramView, "anchor");
    ac.d(TAG, "stopUnreadBubbleConfetti mRunningConfetti=" + ztc);
    paramView = (c)ztb.get(paramView);
    if (paramView != null)
    {
      if (ztc.contains(paramView))
      {
        ac.l(TAG, "stopUnreadBubbleConfetti", new Object[0]);
        paramView.aMv();
        ztc.remove(paramView);
      }
      AppMethodBeat.o(118787);
      return;
    }
    AppMethodBeat.o(118787);
  }
  
  public final AbsStoryMuteView go(Context paramContext)
  {
    AppMethodBeat.i(118780);
    AbsStoryMuteView localAbsStoryMuteView = null;
    if (paramContext != null) {
      localAbsStoryMuteView = (AbsStoryMuteView)new StoryMuteView(paramContext);
    }
    AppMethodBeat.o(118780);
    return localAbsStoryMuteView;
  }
  
  public final AbsStoryHeaderTipView gp(Context paramContext)
  {
    AppMethodBeat.i(118781);
    AbsStoryHeaderTipView localAbsStoryHeaderTipView = null;
    if (paramContext != null) {
      localAbsStoryHeaderTipView = (AbsStoryHeaderTipView)new StoryHeaderTipView(paramContext);
    }
    AppMethodBeat.o(118781);
    return localAbsStoryHeaderTipView;
  }
  
  public final i gq(Context paramContext)
  {
    AppMethodBeat.i(118778);
    k.h(paramContext, "context");
    paramContext = (i)new com.tencent.mm.plugin.story.proxy.b(paramContext);
    AppMethodBeat.o(118778);
    return paramContext;
  }
  
  public final MMFragment instantiateAlbumFragment(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(118782);
    paramContext = Fragment.instantiate(paramContext, StoryAlbumUI.class.getName(), paramBundle);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMFragment");
      AppMethodBeat.o(118782);
      throw paramContext;
    }
    paramContext = (MMFragment)paramContext;
    AppMethodBeat.o(118782);
    return paramContext;
  }
  
  public final Drawable rB(boolean paramBoolean)
  {
    AppMethodBeat.i(118783);
    if (paramBoolean) {}
    for (int i = 2131689897;; i = 2131689898)
    {
      Object localObject = ai.getContext();
      k.g(localObject, "MMApplicationContext.getContext()");
      localObject = ((Context)localObject).getResources().getDrawable(i);
      i = a.fromDPToPix(ai.getContext(), 8);
      ((Drawable)localObject).setBounds(0, 0, i, i);
      k.g(localObject, "hintDrawable");
      AppMethodBeat.o(118783);
      return localObject;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/plugin/story/ui/view/CommentTipSmallConfetti;", "it", "Ljava/util/Random;", "kotlin.jvm.PlatformType", "generateConfetti"})
  static final class a
    implements com.tencent.mm.particles.b
  {
    a(v.f paramf) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.r
 * JD-Core Version:    0.7.0.1
 */