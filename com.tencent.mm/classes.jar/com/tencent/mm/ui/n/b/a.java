package com.tencent.mm.ui.n.b;

import android.graphics.Point;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingUIFragment;
import com.tencent.mm.ui.chatting.viewitems.c.a;
import com.tencent.mm.ui.n.a.d;
import com.tencent.mm.ui.n.a.e;
import java.util.ArrayList;
import java.util.List;

public final class a
{
  public static List<Pair<ca, c.a>> a(com.tencent.mm.ui.chatting.e.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(278497);
    if (parama == null)
    {
      Log.e("MicroMsg.MagicEmojiUtils", "hy: chatting context lost");
      AppMethodBeat.o(278497);
      return null;
    }
    parama = parama.WQv;
    if (!(parama instanceof ChattingUIFragment))
    {
      AppMethodBeat.o(278497);
      return null;
    }
    parama = (ChattingUIFragment)parama;
    com.tencent.mm.ui.chatting.a.a locala = parama.WCR;
    if (locala == null)
    {
      AppMethodBeat.o(278497);
      return null;
    }
    int j = parama.WCS.getFirstVisiblePosition();
    int k = parama.getListView().getLastVisiblePosition();
    if (k <= j)
    {
      AppMethodBeat.o(278497);
      return null;
    }
    ArrayList localArrayList = new ArrayList(5);
    int i = 0;
    while (i <= k - j)
    {
      View localView = parama.getChildAt(i);
      if ((localView instanceof ViewGroup))
      {
        Object localObject = localView.getTag();
        if ((localObject instanceof c.a))
        {
          ca localca = locala.avt(i + j);
          if (localca != null)
          {
            localObject = (c.a)localObject;
            if (((c.a)localObject).getMainContainerView() != null)
            {
              localArrayList.add(new Pair(localca, localObject));
              if (paramBoolean) {
                d((ViewGroup)localView, ((c.a)localObject).getMainContainerView());
              }
            }
          }
        }
      }
      i += 1;
    }
    AppMethodBeat.o(278497);
    return localArrayList;
  }
  
  public static String aG(ca paramca)
  {
    AppMethodBeat.i(278507);
    String str = "";
    if (paramca.field_isSend == 1) {
      paramca = z.bcZ();
    }
    for (;;)
    {
      AppMethodBeat.o(278507);
      return paramca;
      if (ab.Lj(paramca.field_talker))
      {
        if (!Util.isNullOrNil(paramca.field_content))
        {
          int i = paramca.field_content.indexOf(":");
          if (i > 0)
          {
            paramca = paramca.field_content.substring(0, i);
          }
          else
          {
            Log.w("MicroMsg.MagicEmojiUtils", "hy: can not retrieve username from group chat content");
            paramca = str;
          }
        }
        else
        {
          Log.w("MicroMsg.MagicEmojiUtils", "hy: msg content lost");
          paramca = str;
        }
      }
      else {
        paramca = paramca.field_talker;
      }
    }
  }
  
  public static String aH(ca paramca)
  {
    AppMethodBeat.i(278506);
    if (paramca.field_isSend == 1) {
      paramca = paramca.field_talker;
    }
    for (;;)
    {
      AppMethodBeat.o(278506);
      return paramca;
      if (ab.Lj(paramca.field_talker)) {
        paramca = paramca.field_talker;
      } else {
        paramca = z.bcZ();
      }
    }
  }
  
  public static void bAw(String paramString)
  {
    AppMethodBeat.i(278508);
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (WeChatEnvironment.hasDebugger()) || (com.tencent.mm.plugin.emoji.magicemoji.b.a.uBl))
    {
      h.ZvG.bc(new a.1(paramString));
      AppMethodBeat.o(278508);
      return;
    }
    Log.e("MicroMsg.MagicEmojiUtils", "hy: error in magic emoji: %s", new Object[] { paramString });
    AppMethodBeat.o(278508);
  }
  
  public static float cP(float paramFloat)
  {
    AppMethodBeat.i(278505);
    paramFloat = (float)Math.ceil(paramFloat / com.tencent.mm.plugin.appbrand.ac.g.clS());
    AppMethodBeat.o(278505);
    return paramFloat;
  }
  
  private static void d(ViewGroup paramViewGroup, View paramView)
  {
    AppMethodBeat.i(278500);
    ((ViewGroup)paramViewGroup.getParent()).setClipToPadding(false);
    ((ViewGroup)paramViewGroup.getParent()).setClipChildren(false);
    while (paramView != paramViewGroup)
    {
      View localView = (View)paramView.getParent();
      paramView = localView;
      if ((localView instanceof ViewGroup))
      {
        ((ViewGroup)localView).setClipChildren(false);
        ((ViewGroup)localView).setClipToPadding(false);
        paramView = localView;
      }
    }
    AppMethodBeat.o(278500);
  }
  
  public static int[] f(com.tencent.mm.ui.n.a.g paramg)
  {
    AppMethodBeat.i(278502);
    if (!g(paramg))
    {
      paramg = new int[2];
      AppMethodBeat.o(278502);
      return paramg;
    }
    paramg = paramg.XJB.XJJ.hXn();
    int i = paramg.x;
    int j = paramg.y;
    AppMethodBeat.o(278502);
    return new int[] { i, j };
  }
  
  private static boolean g(com.tencent.mm.ui.n.a.g paramg)
  {
    AppMethodBeat.i(278503);
    if (paramg == null)
    {
      Log.e("MicroMsg.MagicEmojiUtils", "hy: service is prepared");
      AppMethodBeat.o(278503);
      return false;
    }
    if (paramg.XJB == null)
    {
      Log.e("MicroMsg.MagicEmojiUtils", "hy: runtime not prepared");
      AppMethodBeat.o(278503);
      return false;
    }
    if (paramg.XJB.XJJ == null)
    {
      Log.e("MicroMsg.MagicEmojiUtils", "hy: magic emoji page not valid");
      AppMethodBeat.o(278503);
      return false;
    }
    AppMethodBeat.o(278503);
    return true;
  }
  
  public static int[] iA(View paramView)
  {
    AppMethodBeat.i(278504);
    int[] arrayOfInt = new int[2];
    if (paramView == null)
    {
      arrayOfInt[1] = 0;
      arrayOfInt[0] = 0;
    }
    for (;;)
    {
      AppMethodBeat.o(278504);
      return arrayOfInt;
      paramView.getLocationInWindow(arrayOfInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.n.b.a
 * JD-Core Version:    0.7.0.1
 */