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
import com.tencent.mm.cd.a;
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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.bt;
import com.tencent.mm.ui.MMFragment;
import d.a.j;
import d.g.b.k;
import d.g.b.v.e;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/model/StoryUIFactory;", "Lcom/tencent/mm/plugin/story/api/IStoryUIFactory;", "()V", "CONFETTI_WIDTH_DP", "", "TAG", "", "VIVO_COMPATIBLE_LIST", "", "confettiManagers", "Ljava/util/HashMap;", "Landroid/view/View;", "Lcom/tencent/mm/particles/ConfettiManager;", "Lkotlin/collections/HashMap;", "mRunningConfetti", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "printLog", "", "unreadConfettiGenerator", "Lcom/tencent/mm/particles/ConfettiGenerator;", "bindUnreadBubbleConfetti", "", "parentView", "Landroid/view/ViewGroup;", "anchor", "offsetX", "offsetY", "genCompatibleBubble", "Landroid/graphics/Bitmap;", "getStoryGallery", "Lcom/tencent/mm/plugin/story/api/AbsStoryGallery;", "context", "Landroid/content/Context;", "type", "Lcom/tencent/mm/plugin/story/api/IStoryUIFactory$GalleryType;", "chatRoom", "getStoryHeaderTipView", "Lcom/tencent/mm/plugin/story/api/AbsStoryHeaderTipView;", "getStoryHintDrawable", "Landroid/graphics/drawable/Drawable;", "highLight", "getStoryHintProxy", "Lcom/tencent/mm/plugin/story/api/IStoryHintProxy;", "getStoryMuteView", "Lcom/tencent/mm/plugin/story/api/AbsStoryMuteView;", "instantiateAlbumFragment", "Lcom/tencent/mm/ui/MMFragment;", "bundle", "Landroid/os/Bundle;", "isInCompatibleList", "lazyInit", "startUnreadBubbleConfetti", "stopUnreadBubbleConfetti", "unbindUnreadBubbleConfetti", "plugin-story_release"})
public final class r
  implements com.tencent.mm.plugin.story.api.n
{
  private static final String TAG = "MicroMsg.StoryUIFactory";
  private static com.tencent.mm.particles.b yga;
  private static HashMap<View, c> ygb;
  private static ArrayList<c> ygc;
  private static int ygd;
  private static boolean yge;
  private static final List<String> ygf;
  public static final r ygg;
  
  static
  {
    AppMethodBeat.i(118788);
    ygg = new r();
    TAG = "MicroMsg.StoryUIFactory";
    ygb = new HashMap();
    ygc = new ArrayList();
    yge = true;
    ygf = j.listOf(new String[] { "y83a", "v1732a", " y83", "v1732t" });
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
  
  public final void a(ViewGroup paramViewGroup, View paramView, int paramInt)
  {
    AppMethodBeat.i(174578);
    k.h(paramView, "anchor");
    v.e locale;
    Object localObject1;
    int i;
    if (yga == null)
    {
      ygd = a.fromDPToPix(aj.getContext(), 8);
      locale = new v.e();
      if (yge)
      {
        ad.i(TAG, "isInCompatibleList " + Build.BRAND + "  config " + bt.eMY() + ' ');
        yge = false;
      }
      Object localObject2 = (Iterable)ygf;
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
      localObject1 = aj.getContext();
      k.g(localObject1, "MMApplicationContext.getContext()");
      localObject1 = BitmapFactory.decodeResource(((Context)localObject1).getResources(), 2131234240);
      k.g(localObject1, "BitmapFactory.decodeReso…ble.story_comment_bubble)");
    }
    for (;;)
    {
      locale.Jhw = localObject1;
      yga = (com.tencent.mm.particles.b)new a(locale);
      if (!ygb.containsKey(paramView))
      {
        localObject1 = new int[2];
        Object tmp345_343 = localObject1;
        tmp345_343[0] = 0;
        Object tmp349_345 = tmp345_343;
        tmp349_345[1] = 0;
        tmp349_345;
        paramView.getLocationOnScreen((int[])localObject1);
        i = localObject1[0] + paramView.getWidth() / 2 - ygd / 2 + 0;
        paramInt = localObject1[1] + paramInt;
        ad.d(TAG, "bindUnreadBubbleConfetti containerMiddleX=" + i + " containerMiddleY=" + paramInt);
        localObject1 = new d(i, paramInt);
        paramViewGroup = new c(aj.getContext(), yga, (d)localObject1, paramViewGroup).aFy().ah(8.0F).y(0.0F, 15.0F).z(-60.0F, 10.0F).Bm(1500L);
        localObject1 = (Map)ygb;
        k.g(paramViewGroup, "manager");
        ((Map)localObject1).put(paramView, paramViewGroup);
      }
      AppMethodBeat.o(174578);
      return;
      label513:
      i = 0;
      break;
      label519:
      localObject1 = aj.getContext();
      k.g(localObject1, "MMApplicationContext.getContext()");
      localObject1 = BitmapFactory.decodeResource(((Context)localObject1).getResources(), 2131234240);
      i = ygd;
      localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject1, i, i, true);
    }
  }
  
  public final void eZ(View paramView)
  {
    AppMethodBeat.i(118785);
    k.h(paramView, "anchor");
    if (ygb.containsKey(paramView)) {
      ygb.remove(paramView);
    }
    AppMethodBeat.o(118785);
  }
  
  public final void fa(View paramView)
  {
    AppMethodBeat.i(118786);
    k.h(paramView, "anchor");
    ad.d(TAG, "startUnreadBubbleConfetti mRunningConfetti=" + ygc);
    paramView = (c)ygb.get(paramView);
    if (paramView != null)
    {
      if (!ygc.contains(paramView))
      {
        ad.d(TAG, "startUnreadBubbleConfetti");
        paramView.aFD();
        ygc.add(paramView);
      }
      AppMethodBeat.o(118786);
      return;
    }
    AppMethodBeat.o(118786);
  }
  
  public final void fb(View paramView)
  {
    AppMethodBeat.i(118787);
    k.h(paramView, "anchor");
    ad.d(TAG, "stopUnreadBubbleConfetti mRunningConfetti=" + ygc);
    paramView = (c)ygb.get(paramView);
    if (paramView != null)
    {
      if (ygc.contains(paramView))
      {
        ad.l(TAG, "stopUnreadBubbleConfetti", new Object[0]);
        paramView.aFE();
        ygc.remove(paramView);
      }
      AppMethodBeat.o(118787);
      return;
    }
    AppMethodBeat.o(118787);
  }
  
  public final AbsStoryMuteView gc(Context paramContext)
  {
    AppMethodBeat.i(118780);
    AbsStoryMuteView localAbsStoryMuteView = null;
    if (paramContext != null) {
      localAbsStoryMuteView = (AbsStoryMuteView)new StoryMuteView(paramContext);
    }
    AppMethodBeat.o(118780);
    return localAbsStoryMuteView;
  }
  
  public final AbsStoryHeaderTipView gd(Context paramContext)
  {
    AppMethodBeat.i(118781);
    AbsStoryHeaderTipView localAbsStoryHeaderTipView = null;
    if (paramContext != null) {
      localAbsStoryHeaderTipView = (AbsStoryHeaderTipView)new StoryHeaderTipView(paramContext);
    }
    AppMethodBeat.o(118781);
    return localAbsStoryHeaderTipView;
  }
  
  public final i ge(Context paramContext)
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
  
  public final Drawable qD(boolean paramBoolean)
  {
    AppMethodBeat.i(118783);
    if (paramBoolean) {}
    for (int i = 2131689897;; i = 2131689898)
    {
      Object localObject = aj.getContext();
      k.g(localObject, "MMApplicationContext.getContext()");
      localObject = ((Context)localObject).getResources().getDrawable(i);
      i = a.fromDPToPix(aj.getContext(), 8);
      ((Drawable)localObject).setBounds(0, 0, i, i);
      k.g(localObject, "hintDrawable");
      AppMethodBeat.o(118783);
      return localObject;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/plugin/story/ui/view/CommentTipSmallConfetti;", "it", "Ljava/util/Random;", "kotlin.jvm.PlatformType", "generateConfetti"})
  static final class a
    implements com.tencent.mm.particles.b
  {
    a(v.e parame) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.r
 * JD-Core Version:    0.7.0.1
 */