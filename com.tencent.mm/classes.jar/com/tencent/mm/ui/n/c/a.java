package com.tencent.mm.ui.n.c;

import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.af.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.m;
import com.tencent.mm.ui.chatting.viewitems.c.a;
import java.util.ArrayList;
import java.util.List;

public final class a
{
  public static c.a a(com.tencent.mm.ui.chatting.d.a parama, long paramLong)
  {
    AppMethodBeat.i(249819);
    parama = ((m)parama.cm(m.class)).ht(paramLong);
    if (parama != null)
    {
      parama = (c.a)parama.getTag();
      AppMethodBeat.o(249819);
      return parama;
    }
    AppMethodBeat.o(249819);
    return null;
  }
  
  public static List<Pair<cc, c.a>> a(com.tencent.mm.ui.chatting.d.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(249815);
    if (parama == null)
    {
      Log.e("MicroMsg.MagicEmojiUtils", "hy: chatting context lost");
      AppMethodBeat.o(249815);
      return null;
    }
    parama = parama.aezO;
    if (!(parama instanceof ChattingUIFragment))
    {
      AppMethodBeat.o(249815);
      return null;
    }
    parama = (ChattingUIFragment)parama;
    com.tencent.mm.ui.chatting.a.a locala = parama.aekk;
    if (locala == null)
    {
      AppMethodBeat.o(249815);
      return null;
    }
    int k = parama.aekl.getFirstVisiblePosition();
    int m = parama.getListView().getLastVisiblePosition();
    if (m <= k)
    {
      AppMethodBeat.o(249815);
      return null;
    }
    ArrayList localArrayList = new ArrayList(5);
    int j = 0;
    int i = 0;
    if (j <= m - k)
    {
      View localView = parama.getChildAt(j);
      if (!(localView instanceof ViewGroup)) {
        i += 1;
      }
      for (;;)
      {
        j += 1;
        break;
        Object localObject = localView.getTag();
        if (!(localObject instanceof c.a))
        {
          i += 1;
        }
        else
        {
          cc localcc = locala.aBV(j + k - i);
          if (localcc != null)
          {
            localObject = (c.a)localObject;
            if (((c.a)localObject).getMainContainerView() != null)
            {
              localArrayList.add(new Pair(localcc, localObject));
              if (paramBoolean) {
                e((ViewGroup)localView, ((c.a)localObject).getMainContainerView());
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(249815);
    return localArrayList;
  }
  
  public static String aU(cc paramcc)
  {
    AppMethodBeat.i(249846);
    String str = "";
    if (paramcc.field_isSend == 1) {
      paramcc = z.bAM();
    }
    for (;;)
    {
      AppMethodBeat.o(249846);
      return paramcc;
      if (au.bwE(paramcc.field_talker))
      {
        if (!Util.isNullOrNil(paramcc.field_content))
        {
          int i = paramcc.field_content.indexOf(":");
          if (i > 0)
          {
            paramcc = paramcc.field_content.substring(0, i);
          }
          else
          {
            Log.w("MicroMsg.MagicEmojiUtils", "hy: can not retrieve username from group chat content");
            paramcc = str;
          }
        }
        else
        {
          Log.w("MicroMsg.MagicEmojiUtils", "hy: msg content lost");
          paramcc = str;
        }
      }
      else {
        paramcc = paramcc.field_talker;
      }
    }
  }
  
  public static String aV(cc paramcc)
  {
    AppMethodBeat.i(249838);
    if (paramcc.field_isSend == 1) {
      paramcc = paramcc.field_talker;
    }
    for (;;)
    {
      AppMethodBeat.o(249838);
      return paramcc;
      if (au.bwE(paramcc.field_talker)) {
        paramcc = paramcc.field_talker;
      } else {
        paramcc = z.bAM();
      }
    }
  }
  
  private static void e(ViewGroup paramViewGroup, View paramView)
  {
    AppMethodBeat.i(249822);
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
    AppMethodBeat.o(249822);
  }
  
  public static float ec(float paramFloat)
  {
    AppMethodBeat.i(249830);
    paramFloat = (float)Math.ceil(paramFloat / i.mn());
    AppMethodBeat.o(249830);
    return paramFloat;
  }
  
  public static int[] lX(View paramView)
  {
    AppMethodBeat.i(249826);
    int[] arrayOfInt = new int[2];
    if (paramView == null)
    {
      arrayOfInt[1] = 0;
      arrayOfInt[0] = 0;
    }
    for (;;)
    {
      AppMethodBeat.o(249826);
      return arrayOfInt;
      paramView.getLocationInWindow(arrayOfInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.n.c.a
 * JD-Core Version:    0.7.0.1
 */