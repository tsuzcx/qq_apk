package com.tencent.mm.plugin.story.model;

import a.f.b.u.d;
import a.l;
import a.v;
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
import com.tencent.mm.cb.a;
import com.tencent.mm.particles.c;
import com.tencent.mm.particles.d;
import com.tencent.mm.plugin.story.api.AbsStoryGallery;
import com.tencent.mm.plugin.story.api.AbsStoryMuteView;
import com.tencent.mm.plugin.story.api.i;
import com.tencent.mm.plugin.story.api.m.a;
import com.tencent.mm.plugin.story.ui.album.StoryAlbumUI;
import com.tencent.mm.plugin.story.ui.view.StoryMuteView;
import com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.bs;
import com.tencent.mm.ui.MMFragment;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/StoryUIFactory;", "Lcom/tencent/mm/plugin/story/api/IStoryUIFactory;", "()V", "CONFETTI_WIDTH_DP", "", "TAG", "", "VIVO_COMPATIBLE_LIST", "", "confettiManagers", "Ljava/util/HashMap;", "Landroid/view/View;", "Lcom/tencent/mm/particles/ConfettiManager;", "Lkotlin/collections/HashMap;", "mRunningConfetti", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "printLog", "", "unreadConfettiGenerator", "Lcom/tencent/mm/particles/ConfettiGenerator;", "bindUnreadBubbleConfetti", "", "parentView", "Landroid/view/ViewGroup;", "anchor", "genCompatibleBubble", "Landroid/graphics/Bitmap;", "getStoryGallery", "Lcom/tencent/mm/plugin/story/api/AbsStoryGallery;", "context", "Landroid/content/Context;", "type", "Lcom/tencent/mm/plugin/story/api/IStoryUIFactory$GalleryType;", "chatRoom", "getStoryHintDrawable", "Landroid/graphics/drawable/Drawable;", "highLight", "getStoryHintProxy", "Lcom/tencent/mm/plugin/story/api/IStoryHintProxy;", "getStoryMuteView", "Lcom/tencent/mm/plugin/story/api/AbsStoryMuteView;", "instantiateAlbumFragment", "Lcom/tencent/mm/ui/MMFragment;", "bundle", "Landroid/os/Bundle;", "isInCompatibleList", "lazyInit", "startUnreadBubbleConfetti", "stopUnreadBubbleConfetti", "unbindUnreadBubbleConfetti", "plugin-story_release"})
public final class r
  implements com.tencent.mm.plugin.story.api.m
{
  private static final String TAG = "MicroMsg.StoryUIFactory";
  private static com.tencent.mm.particles.b swb;
  private static HashMap<View, c> swc;
  private static ArrayList<c> swd;
  private static int swe;
  private static boolean swf;
  private static final List<String> swg;
  public static final r swh;
  
  static
  {
    AppMethodBeat.i(109164);
    swh = new r();
    TAG = "MicroMsg.StoryUIFactory";
    swc = new HashMap();
    swd = new ArrayList();
    swf = true;
    swg = a.a.j.listOf(new String[] { "y83a", "v1732a", " y83", "v1732t" });
    AppMethodBeat.o(109164);
  }
  
  public final AbsStoryGallery a(Context paramContext, m.a parama, String paramString)
  {
    AppMethodBeat.i(109156);
    a.f.b.j.q(paramContext, "context");
    a.f.b.j.q(parama, "type");
    paramContext = new StoryGalleryView(paramContext, parama, 0, false, null, 28);
    paramContext.setChatRoom(paramString);
    paramContext = (AbsStoryGallery)paramContext;
    AppMethodBeat.o(109156);
    return paramContext;
  }
  
  public final void d(ViewGroup paramViewGroup, View paramView)
  {
    AppMethodBeat.i(109160);
    a.f.b.j.q(paramView, "anchor");
    u.d locald;
    Object localObject1;
    int i;
    if (swb == null)
    {
      swe = a.fromDPToPix(ah.getContext(), 8);
      locald = new u.d();
      if (swf)
      {
        ab.i(TAG, "isInCompatibleList " + Build.BRAND + "  config " + bs.dyO() + ' ');
        swf = false;
      }
      Object localObject2 = (Iterable)swg;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      label219:
      label222:
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        String str1 = (String)localObject3;
        String str2 = Build.MODEL;
        a.f.b.j.p(str2, "Build.MODEL");
        if (!a.l.m.a((CharSequence)str2, (CharSequence)str1, true))
        {
          str2 = Build.DEVICE;
          a.f.b.j.p(str2, "Build.DEVICE");
          if (!a.l.m.a((CharSequence)str2, (CharSequence)str1, true)) {
            break label219;
          }
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label222;
          }
          ((Collection)localObject1).add(localObject3);
          break;
        }
      }
      localObject1 = (List)localObject1;
      if ((!a.f.b.j.e(Build.BRAND, "vivo")) || (((List)localObject1).isEmpty()) || (Build.VERSION.SDK_INT != 27)) {
        break label478;
      }
      i = 1;
      if (i == 0) {
        break label483;
      }
      localObject1 = ah.getContext();
      a.f.b.j.p(localObject1, "MMApplicationContext.getContext()");
      localObject1 = BitmapFactory.decodeResource(((Context)localObject1).getResources(), 2130840467);
      a.f.b.j.p(localObject1, "BitmapFactory.decodeReso…ble.story_comment_bubble)");
    }
    for (;;)
    {
      locald.BNq = localObject1;
      swb = (com.tencent.mm.particles.b)new r.a(locald);
      if (!swc.containsKey(paramView))
      {
        i = paramView.getLeft() + paramView.getWidth() / 2 - swe / 2;
        int j = paramView.getTop();
        ab.d(TAG, "bindUnreadBubbleConfetti containerMiddleX=" + i + " containerMiddleY=" + j);
        localObject1 = new d(i, j);
        paramViewGroup = new c(ah.getContext(), swb, (d)localObject1, paramViewGroup).anQ().ah(8.0F).H(0.0F, 15.0F).I(-60.0F, 10.0F).anU();
        localObject1 = (Map)swc;
        a.f.b.j.p(paramViewGroup, "manager");
        ((Map)localObject1).put(paramView, paramViewGroup);
      }
      AppMethodBeat.o(109160);
      return;
      label478:
      i = 0;
      break;
      label483:
      localObject1 = ah.getContext();
      a.f.b.j.p(localObject1, "MMApplicationContext.getContext()");
      localObject1 = BitmapFactory.decodeResource(((Context)localObject1).getResources(), 2130840467);
      i = swe;
      localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject1, i, i, true);
    }
  }
  
  public final void eh(View paramView)
  {
    AppMethodBeat.i(109161);
    a.f.b.j.q(paramView, "anchor");
    if (swc.containsKey(paramView)) {
      swc.remove(paramView);
    }
    AppMethodBeat.o(109161);
  }
  
  public final void ei(View paramView)
  {
    AppMethodBeat.i(109162);
    a.f.b.j.q(paramView, "anchor");
    ab.d(TAG, "startUnreadBubbleConfetti mRunningConfetti=" + swd);
    paramView = (c)swc.get(paramView);
    if (paramView != null)
    {
      if (!swd.contains(paramView))
      {
        ab.d(TAG, "startUnreadBubbleConfetti");
        paramView.anV();
        swd.add(paramView);
      }
      AppMethodBeat.o(109162);
      return;
    }
    AppMethodBeat.o(109162);
  }
  
  public final void ej(View paramView)
  {
    AppMethodBeat.i(109163);
    a.f.b.j.q(paramView, "anchor");
    ab.d(TAG, "stopUnreadBubbleConfetti mRunningConfetti=" + swd);
    paramView = (c)swc.get(paramView);
    if (paramView != null)
    {
      if (swd.contains(paramView))
      {
        ab.a(TAG, "stopUnreadBubbleConfetti", new Object[0]);
        paramView.anW();
        swd.remove(paramView);
      }
      AppMethodBeat.o(109163);
      return;
    }
    AppMethodBeat.o(109163);
  }
  
  public final AbsStoryMuteView fb(Context paramContext)
  {
    AppMethodBeat.i(109157);
    AbsStoryMuteView localAbsStoryMuteView = null;
    if (paramContext != null) {
      localAbsStoryMuteView = (AbsStoryMuteView)new StoryMuteView(paramContext);
    }
    AppMethodBeat.o(109157);
    return localAbsStoryMuteView;
  }
  
  public final i fc(Context paramContext)
  {
    AppMethodBeat.i(109155);
    a.f.b.j.q(paramContext, "context");
    paramContext = (i)new com.tencent.mm.plugin.story.proxy.b(paramContext);
    AppMethodBeat.o(109155);
    return paramContext;
  }
  
  public final MMFragment instantiateAlbumFragment(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(109158);
    paramContext = Fragment.instantiate(paramContext, StoryAlbumUI.class.getName(), paramBundle);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMFragment");
      AppMethodBeat.o(109158);
      throw paramContext;
    }
    paramContext = (MMFragment)paramContext;
    AppMethodBeat.o(109158);
    return paramContext;
  }
  
  public final Drawable lO(boolean paramBoolean)
  {
    AppMethodBeat.i(109159);
    if (paramBoolean) {}
    for (int i = 2131231103;; i = 2131231104)
    {
      Object localObject = ah.getContext();
      a.f.b.j.p(localObject, "MMApplicationContext.getContext()");
      localObject = ((Context)localObject).getResources().getDrawable(i);
      i = a.fromDPToPix(ah.getContext(), 8);
      ((Drawable)localObject).setBounds(0, 0, i, i);
      a.f.b.j.p(localObject, "hintDrawable");
      AppMethodBeat.o(109159);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.r
 * JD-Core Version:    0.7.0.1
 */