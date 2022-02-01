package com.tencent.mm.plugin.story.model;

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
import com.tencent.mm.cd.a;
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
import com.tencent.mm.plugin.story.ui.view.e;
import com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.co;
import com.tencent.mm.ui.MMFragment;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/model/StoryUIFactory;", "Lcom/tencent/mm/plugin/story/api/IStoryUIFactory;", "()V", "CONFETTI_WIDTH_DP", "", "TAG", "", "VIVO_COMPATIBLE_LIST", "", "confettiManagers", "Ljava/util/HashMap;", "Landroid/view/View;", "Lcom/tencent/mm/particles/ConfettiManager;", "Lkotlin/collections/HashMap;", "mRunningConfetti", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "printLog", "", "unreadConfettiGenerator", "Lcom/tencent/mm/particles/ConfettiGenerator;", "bindUnreadBubbleConfetti", "", "parentView", "Landroid/view/ViewGroup;", "anchor", "offsetX", "offsetY", "genCompatibleBubble", "Landroid/graphics/Bitmap;", "getStoryGallery", "Lcom/tencent/mm/plugin/story/api/AbsStoryGallery;", "context", "Landroid/content/Context;", "type", "Lcom/tencent/mm/plugin/story/api/IStoryUIFactory$GalleryType;", "chatRoom", "getStoryHeaderTipView", "Lcom/tencent/mm/plugin/story/api/AbsStoryHeaderTipView;", "getStoryHintDrawable", "Landroid/graphics/drawable/Drawable;", "highLight", "getStoryHintProxy", "Lcom/tencent/mm/plugin/story/api/IStoryHintProxy;", "getStoryMuteView", "Lcom/tencent/mm/plugin/story/api/AbsStoryMuteView;", "instantiateAlbumFragment", "Lcom/tencent/mm/ui/MMFragment;", "bundle", "Landroid/os/Bundle;", "isInCompatibleList", "lazyInit", "startUnreadBubbleConfetti", "stopUnreadBubbleConfetti", "unbindUnreadBubbleConfetti", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
  implements com.tencent.mm.plugin.story.api.n
{
  public static final q SkV;
  private static com.tencent.mm.particles.b SkW;
  private static HashMap<View, c> SkX;
  private static ArrayList<c> SkY;
  private static int SkZ;
  private static final List<String> Sla;
  private static final String TAG;
  private static boolean printLog;
  
  static
  {
    AppMethodBeat.i(118788);
    SkV = new q();
    TAG = "MicroMsg.StoryUIFactory";
    SkX = new HashMap();
    SkY = new ArrayList();
    printLog = true;
    Sla = p.listOf(new String[] { "y83a", "v1732a", " y83", "v1732t" });
    AppMethodBeat.o(118788);
  }
  
  private static final com.tencent.mm.particles.a.b a(ah.f paramf, Random paramRandom)
  {
    AppMethodBeat.i(367107);
    s.u(paramf, "$scaled");
    paramf = paramf.aqH;
    s.s(paramf, "scaled");
    paramf = (com.tencent.mm.particles.a.b)new e((Bitmap)paramf);
    AppMethodBeat.o(367107);
    return paramf;
  }
  
  public final Drawable EE(boolean paramBoolean)
  {
    AppMethodBeat.i(118783);
    if (paramBoolean) {}
    for (int i = a.f.chatting_avatar_story_hint;; i = a.f.chatting_avatar_story_hint_white)
    {
      Drawable localDrawable = MMApplicationContext.getContext().getResources().getDrawable(i);
      i = a.fromDPToPix(MMApplicationContext.getContext(), 8);
      localDrawable.setBounds(0, 0, i, i);
      s.s(localDrawable, "hintDrawable");
      AppMethodBeat.o(118783);
      return localDrawable;
    }
  }
  
  public final AbsStoryGallery a(Context paramContext, n.a parama, String paramString)
  {
    AppMethodBeat.i(118779);
    s.u(paramContext, "context");
    s.u(parama, "type");
    paramContext = new StoryGalleryView(paramContext, parama, 0, false, null, 28);
    paramContext.setChatRoom(paramString);
    paramContext = (AbsStoryGallery)paramContext;
    AppMethodBeat.o(118779);
    return paramContext;
  }
  
  public final void c(ViewGroup paramViewGroup, View paramView, int paramInt)
  {
    AppMethodBeat.i(174578);
    s.u(paramView, "anchor");
    ah.f localf;
    Object localObject1;
    int i;
    if (SkW == null)
    {
      SkZ = a.fromDPToPix(MMApplicationContext.getContext(), 8);
      localf = new ah.f();
      if (printLog)
      {
        Log.i(TAG, "isInCompatibleList " + Build.BRAND + "  config " + co.jcP() + ' ');
        printLog = false;
      }
      Object localObject2 = (Iterable)Sla;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      label223:
      label227:
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        String str1 = (String)localObject3;
        String str2 = com.tencent.mm.compatible.deviceinfo.q.aPo();
        s.s(str2, "getModel()");
        if (!kotlin.n.n.a((CharSequence)str2, (CharSequence)str1, true))
        {
          str2 = Build.DEVICE;
          s.s(str2, "DEVICE");
          if (!kotlin.n.n.a((CharSequence)str2, (CharSequence)str1, true)) {
            break label223;
          }
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label227;
          }
          ((Collection)localObject1).add(localObject3);
          break;
        }
      }
      localObject1 = (List)localObject1;
      if ((!s.p(Build.BRAND, "vivo")) || (((List)localObject1).isEmpty()) || (Build.VERSION.SDK_INT != 27)) {
        break label506;
      }
      i = 1;
      if (i == 0) {
        break label512;
      }
      localObject1 = BitmapFactory.decodeResource(MMApplicationContext.getContext().getResources(), a.c.story_comment_bubble);
      s.s(localObject1, "decodeResource(MMApplica…ble.story_comment_bubble)");
    }
    for (;;)
    {
      localf.aqH = localObject1;
      SkW = new q..ExternalSyntheticLambda0(localf);
      if (!SkX.containsKey(paramView))
      {
        localObject1 = new int[2];
        localObject1[0] = 0;
        localObject1[1] = 0;
        paramView.getLocationOnScreen((int[])localObject1);
        i = localObject1[0] + paramView.getWidth() / 2 - SkZ / 2 + 0;
        paramInt = localObject1[1] + paramInt;
        Log.d(TAG, "bindUnreadBubbleConfetti containerMiddleX=" + i + " containerMiddleY=" + paramInt);
        localObject1 = new d(i, paramInt);
        paramViewGroup = new c(MMApplicationContext.getContext(), SkW, (d)localObject1, paramViewGroup);
        paramViewGroup.pwk = 9223372036854775807L;
        paramViewGroup = paramViewGroup.bv(8.0F).an(0.0F, 15.0F).ao(-60.0F, 10.0F);
        paramViewGroup.pwJ = 1500L;
        localObject1 = (Map)SkX;
        s.s(paramViewGroup, "manager");
        ((Map)localObject1).put(paramView, paramViewGroup);
      }
      AppMethodBeat.o(174578);
      return;
      label506:
      i = 0;
      break;
      label512:
      localObject1 = BitmapFactory.decodeResource(MMApplicationContext.getContext().getResources(), a.c.story_comment_bubble);
      i = SkZ;
      localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject1, i, i, true);
    }
  }
  
  public final MMFragment instantiateAlbumFragment(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(118782);
    s.u(paramContext, "context");
    paramContext = (MMFragment)Fragment.instantiate(paramContext, StoryAlbumUI.class.getName(), paramBundle);
    AppMethodBeat.o(118782);
    return paramContext;
  }
  
  public final AbsStoryMuteView jY(Context paramContext)
  {
    AppMethodBeat.i(118780);
    AbsStoryMuteView localAbsStoryMuteView = null;
    if (paramContext != null) {
      localAbsStoryMuteView = (AbsStoryMuteView)new StoryMuteView(paramContext);
    }
    AppMethodBeat.o(118780);
    return localAbsStoryMuteView;
  }
  
  public final AbsStoryHeaderTipView jZ(Context paramContext)
  {
    AppMethodBeat.i(118781);
    AbsStoryHeaderTipView localAbsStoryHeaderTipView = null;
    if (paramContext != null) {
      localAbsStoryHeaderTipView = (AbsStoryHeaderTipView)new StoryHeaderTipView(paramContext);
    }
    AppMethodBeat.o(118781);
    return localAbsStoryHeaderTipView;
  }
  
  public final i ka(Context paramContext)
  {
    AppMethodBeat.i(118778);
    s.u(paramContext, "context");
    paramContext = (i)new com.tencent.mm.plugin.story.proxy.b(paramContext);
    AppMethodBeat.o(118778);
    return paramContext;
  }
  
  public final void kc(View paramView)
  {
    AppMethodBeat.i(118785);
    s.u(paramView, "anchor");
    if (SkX.containsKey(paramView)) {
      SkX.remove(paramView);
    }
    AppMethodBeat.o(118785);
  }
  
  public final void kd(View paramView)
  {
    AppMethodBeat.i(118786);
    s.u(paramView, "anchor");
    Log.d(TAG, s.X("startUnreadBubbleConfetti mRunningConfetti=", SkY));
    paramView = (c)SkX.get(paramView);
    if ((paramView != null) && (!SkY.contains(paramView)))
    {
      Log.d(TAG, "startUnreadBubbleConfetti");
      paramView.bSI();
      SkY.add(paramView);
    }
    AppMethodBeat.o(118786);
  }
  
  public final void ke(View paramView)
  {
    AppMethodBeat.i(118787);
    s.u(paramView, "anchor");
    Log.d(TAG, s.X("stopUnreadBubbleConfetti mRunningConfetti=", SkY));
    paramView = (c)SkX.get(paramView);
    if ((paramView != null) && (SkY.contains(paramView)))
    {
      Log.printDebugStack(TAG, "stopUnreadBubbleConfetti", new Object[0]);
      paramView.bSJ();
      SkY.remove(paramView);
    }
    AppMethodBeat.o(118787);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.q
 * JD-Core Version:    0.7.0.1
 */