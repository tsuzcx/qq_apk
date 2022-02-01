package com.tencent.mm.plugin.story.f;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.particles.c;
import com.tencent.mm.particles.d;
import com.tencent.mm.plugin.story.a.c;
import com.tencent.mm.plugin.story.a.f;
import com.tencent.mm.plugin.story.api.AbsStoryGallery;
import com.tencent.mm.plugin.story.api.AbsStoryHeaderTipView;
import com.tencent.mm.plugin.story.api.AbsStoryMuteView;
import com.tencent.mm.plugin.story.api.i;
import com.tencent.mm.plugin.story.api.n.a;
import com.tencent.mm.plugin.story.ui.album.StoryAlbumUI;
import com.tencent.mm.plugin.story.ui.view.StoryHeaderTipView;
import com.tencent.mm.plugin.story.ui.view.StoryMuteView;
import com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.cl;
import com.tencent.mm.ui.MMFragment;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.a.j;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/model/StoryUIFactory;", "Lcom/tencent/mm/plugin/story/api/IStoryUIFactory;", "()V", "CONFETTI_WIDTH_DP", "", "TAG", "", "VIVO_COMPATIBLE_LIST", "", "confettiManagers", "Ljava/util/HashMap;", "Landroid/view/View;", "Lcom/tencent/mm/particles/ConfettiManager;", "Lkotlin/collections/HashMap;", "mRunningConfetti", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "printLog", "", "unreadConfettiGenerator", "Lcom/tencent/mm/particles/ConfettiGenerator;", "bindUnreadBubbleConfetti", "", "parentView", "Landroid/view/ViewGroup;", "anchor", "offsetX", "offsetY", "genCompatibleBubble", "Landroid/graphics/Bitmap;", "getStoryGallery", "Lcom/tencent/mm/plugin/story/api/AbsStoryGallery;", "context", "Landroid/content/Context;", "type", "Lcom/tencent/mm/plugin/story/api/IStoryUIFactory$GalleryType;", "chatRoom", "getStoryHeaderTipView", "Lcom/tencent/mm/plugin/story/api/AbsStoryHeaderTipView;", "getStoryHintDrawable", "Landroid/graphics/drawable/Drawable;", "highLight", "getStoryHintProxy", "Lcom/tencent/mm/plugin/story/api/IStoryHintProxy;", "getStoryMuteView", "Lcom/tencent/mm/plugin/story/api/AbsStoryMuteView;", "instantiateAlbumFragment", "Lcom/tencent/mm/ui/MMFragment;", "bundle", "Landroid/os/Bundle;", "isInCompatibleList", "lazyInit", "startUnreadBubbleConfetti", "stopUnreadBubbleConfetti", "unbindUnreadBubbleConfetti", "plugin-story_release"})
public final class r
  implements com.tencent.mm.plugin.story.api.n
{
  private static com.tencent.mm.particles.b LHs;
  private static HashMap<View, c> LHt;
  private static ArrayList<c> LHu;
  private static int LHv = 0;
  private static final List<String> LHw;
  public static final r LHx;
  private static final String TAG = "MicroMsg.StoryUIFactory";
  private static boolean printLog;
  
  static
  {
    AppMethodBeat.i(118788);
    LHx = new r();
    TAG = "MicroMsg.StoryUIFactory";
    LHt = new HashMap();
    LHu = new ArrayList();
    printLog = true;
    LHw = j.listOf(new String[] { "y83a", "v1732a", " y83", "v1732t" });
    AppMethodBeat.o(118788);
  }
  
  public final AbsStoryGallery a(Context paramContext, n.a parama, String paramString)
  {
    AppMethodBeat.i(118779);
    p.k(paramContext, "context");
    p.k(parama, "type");
    paramContext = new StoryGalleryView(paramContext, parama, 0, false, null, 28);
    paramContext.setChatRoom(paramString);
    paramContext = (AbsStoryGallery)paramContext;
    AppMethodBeat.o(118779);
    return paramContext;
  }
  
  public final void c(ViewGroup paramViewGroup, View paramView, int paramInt)
  {
    AppMethodBeat.i(174578);
    p.k(paramView, "anchor");
    aa.f localf;
    Object localObject1;
    int i;
    if (LHs == null)
    {
      LHv = a.fromDPToPix(MMApplicationContext.getContext(), 8);
      localf = new aa.f();
      if (printLog)
      {
        Log.i(TAG, "isInCompatibleList " + Build.BRAND + "  config " + cl.hAM() + ' ');
        printLog = false;
      }
      Object localObject2 = (Iterable)LHw;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      label221:
      label225:
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        String str1 = (String)localObject3;
        String str2 = Build.MODEL;
        p.j(str2, "Build.MODEL");
        if (!kotlin.n.n.a((CharSequence)str2, (CharSequence)str1, true))
        {
          str2 = Build.DEVICE;
          p.j(str2, "Build.DEVICE");
          if (!kotlin.n.n.a((CharSequence)str2, (CharSequence)str1, true)) {
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
      if ((!p.h(Build.BRAND, "vivo")) || (((List)localObject1).isEmpty()) || (Build.VERSION.SDK_INT != 27)) {
        break label513;
      }
      i = 1;
      if (i == 0) {
        break label519;
      }
      localObject1 = MMApplicationContext.getContext();
      p.j(localObject1, "MMApplicationContext.getContext()");
      localObject1 = BitmapFactory.decodeResource(((Context)localObject1).getResources(), a.c.story_comment_bubble);
      p.j(localObject1, "BitmapFactory.decodeReso…ble.story_comment_bubble)");
    }
    for (;;)
    {
      localf.aaBC = localObject1;
      LHs = (com.tencent.mm.particles.b)new a(localf);
      if (!LHt.containsKey(paramView))
      {
        localObject1 = new int[2];
        Object tmp345_343 = localObject1;
        tmp345_343[0] = 0;
        Object tmp349_345 = tmp345_343;
        tmp349_345[1] = 0;
        tmp349_345;
        paramView.getLocationOnScreen((int[])localObject1);
        i = localObject1[0] + paramView.getWidth() / 2 - LHv / 2 + 0;
        paramInt = localObject1[1] + paramInt;
        Log.d(TAG, "bindUnreadBubbleConfetti containerMiddleX=" + i + " containerMiddleY=" + paramInt);
        localObject1 = new d(i, paramInt);
        paramViewGroup = new c(MMApplicationContext.getContext(), LHs, (d)localObject1, paramViewGroup).bus().ax(8.0F).H(0.0F, 15.0F).I(-60.0F, 10.0F).GZ(1500L);
        localObject1 = (Map)LHt;
        p.j(paramViewGroup, "manager");
        ((Map)localObject1).put(paramView, paramViewGroup);
      }
      AppMethodBeat.o(174578);
      return;
      label513:
      i = 0;
      break;
      label519:
      localObject1 = MMApplicationContext.getContext();
      p.j(localObject1, "MMApplicationContext.getContext()");
      localObject1 = BitmapFactory.decodeResource(((Context)localObject1).getResources(), a.c.story_comment_bubble);
      i = LHv;
      localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject1, i, i, true);
    }
  }
  
  public final void gW(View paramView)
  {
    AppMethodBeat.i(118785);
    p.k(paramView, "anchor");
    if (LHt.containsKey(paramView)) {
      LHt.remove(paramView);
    }
    AppMethodBeat.o(118785);
  }
  
  public final void gX(View paramView)
  {
    AppMethodBeat.i(118786);
    p.k(paramView, "anchor");
    Log.d(TAG, "startUnreadBubbleConfetti mRunningConfetti=" + LHu);
    paramView = (c)LHt.get(paramView);
    if (paramView != null)
    {
      if (!LHu.contains(paramView))
      {
        Log.d(TAG, "startUnreadBubbleConfetti");
        paramView.bux();
        LHu.add(paramView);
      }
      AppMethodBeat.o(118786);
      return;
    }
    AppMethodBeat.o(118786);
  }
  
  public final void gY(View paramView)
  {
    AppMethodBeat.i(118787);
    p.k(paramView, "anchor");
    Log.d(TAG, "stopUnreadBubbleConfetti mRunningConfetti=" + LHu);
    paramView = (c)LHt.get(paramView);
    if (paramView != null)
    {
      if (LHu.contains(paramView))
      {
        Log.printDebugStack(TAG, "stopUnreadBubbleConfetti", new Object[0]);
        paramView.buy();
        LHu.remove(paramView);
      }
      AppMethodBeat.o(118787);
      return;
    }
    AppMethodBeat.o(118787);
  }
  
  public final AbsStoryMuteView ii(Context paramContext)
  {
    AppMethodBeat.i(118780);
    AbsStoryMuteView localAbsStoryMuteView = null;
    if (paramContext != null) {
      localAbsStoryMuteView = (AbsStoryMuteView)new StoryMuteView(paramContext);
    }
    AppMethodBeat.o(118780);
    return localAbsStoryMuteView;
  }
  
  public final AbsStoryHeaderTipView ij(Context paramContext)
  {
    AppMethodBeat.i(118781);
    AbsStoryHeaderTipView localAbsStoryHeaderTipView = null;
    if (paramContext != null) {
      localAbsStoryHeaderTipView = (AbsStoryHeaderTipView)new StoryHeaderTipView(paramContext);
    }
    AppMethodBeat.o(118781);
    return localAbsStoryHeaderTipView;
  }
  
  public final i ik(Context paramContext)
  {
    AppMethodBeat.i(118778);
    p.k(paramContext, "context");
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
      paramContext = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragment");
      AppMethodBeat.o(118782);
      throw paramContext;
    }
    paramContext = (MMFragment)paramContext;
    AppMethodBeat.o(118782);
    return paramContext;
  }
  
  public final Drawable zn(boolean paramBoolean)
  {
    AppMethodBeat.i(118783);
    if (paramBoolean) {}
    for (int i = a.f.chatting_avatar_story_hint;; i = a.f.chatting_avatar_story_hint_white)
    {
      Object localObject = MMApplicationContext.getContext();
      p.j(localObject, "MMApplicationContext.getContext()");
      localObject = ((Context)localObject).getResources().getDrawable(i);
      i = a.fromDPToPix(MMApplicationContext.getContext(), 8);
      ((Drawable)localObject).setBounds(0, 0, i, i);
      p.j(localObject, "hintDrawable");
      AppMethodBeat.o(118783);
      return localObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/story/ui/view/CommentTipSmallConfetti;", "it", "Ljava/util/Random;", "kotlin.jvm.PlatformType", "generateConfetti"})
  static final class a
    implements com.tencent.mm.particles.b
  {
    a(aa.f paramf) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.r
 * JD-Core Version:    0.7.0.1
 */