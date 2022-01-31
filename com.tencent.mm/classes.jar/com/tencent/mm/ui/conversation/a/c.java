package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.pluginsdk.h.a.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Map;
import java.util.Map<Ljava.lang.String;Ljava.lang.String;>;
import junit.framework.Assert;

public final class c
{
  com.tencent.mm.pluginsdk.h.a.a Ami;
  
  c(com.tencent.mm.pluginsdk.h.a.a parama)
  {
    this.Ami = parama;
  }
  
  private static Drawable a(Map<String, String> paramMap, Context paramContext)
  {
    AppMethodBeat.i(34644);
    if ((paramMap == null) || (paramMap.size() <= 0))
    {
      AppMethodBeat.o(34644);
      return null;
    }
    Object localObject1 = paramContext.getResources().getDisplayMetrics();
    Object localObject2 = (String)paramMap.get(((DisplayMetrics)localObject1).heightPixels + "x" + ((DisplayMetrics)localObject1).widthPixels);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      new f();
      localObject1 = paramContext.getResources().getDisplayMetrics();
      localObject2 = paramContext.getResources().getConfiguration();
      if (((DisplayMetrics)localObject1).density >= 1.0F) {
        break label197;
      }
      localObject1 = "" + "LDPI";
      localObject3 = new StringBuilder().append((String)localObject1);
      if (((Configuration)localObject2).orientation != 2) {
        break label255;
      }
    }
    label197:
    label255:
    for (localObject1 = "_L";; localObject1 = "_P")
    {
      localObject1 = (String)paramMap.get((String)localObject1);
      if (ah.nullAsNil((String)localObject1).length() > 0) {
        break label261;
      }
      AppMethodBeat.o(34644);
      return null;
      if (((DisplayMetrics)localObject1).density >= 1.5F)
      {
        localObject1 = "" + "HDPI";
        break;
      }
      localObject1 = "" + "MDPI";
      break;
    }
    label261:
    localObject2 = com.tencent.mm.pluginsdk.h.a.a.alV((String)localObject1);
    if (localObject2 == a.a.vOY)
    {
      AppMethodBeat.o(34644);
      return null;
    }
    Object localObject3 = com.tencent.mm.pluginsdk.h.a.a.alU((String)localObject1);
    if (ah.nullAsNil((String)localObject3).length() <= 0)
    {
      AppMethodBeat.o(34644);
      return null;
    }
    try
    {
      float f;
      if (localObject2 == a.a.vOW)
      {
        paramMap = paramContext.getAssets().open((String)localObject3);
        f = com.tencent.mm.cb.a.getDensity(paramContext);
        new f();
        paramMap = com.tencent.mm.sdk.platformtools.d.a(paramMap, f);
      }
      while (paramMap == null)
      {
        ab.e("MicroMsg.ADListView.Message", "get Bitmap failed type:" + localObject2 + " path:" + (String)localObject3);
        AppMethodBeat.o(34644);
        return null;
        f = com.tencent.mm.cb.a.getDensity(paramContext);
        new f();
        localObject1 = com.tencent.mm.sdk.platformtools.d.l((String)localObject3, f);
        paramMap = (Map<String, String>)localObject1;
        if (localObject1 != null)
        {
          ((Bitmap)localObject1).setDensity((int)(160.0F * f));
          paramMap = (Map<String, String>)localObject1;
        }
      }
      localObject1 = paramMap.getNinePatchChunk();
    }
    catch (Exception paramMap)
    {
      ab.printErrStackTrace("MicroMsg.ADListView.Message", paramMap, "", new Object[0]);
      AppMethodBeat.o(34644);
      return null;
    }
    if ((localObject1 != null) && (NinePatch.isNinePatchChunk((byte[])localObject1)))
    {
      paramMap = new NinePatchDrawable(paramMap, (byte[])localObject1, new Rect(), null);
      AppMethodBeat.o(34644);
      return paramMap;
    }
    localObject2 = paramContext.getResources().getDisplayMetrics();
    localObject1 = Bitmap.createScaledBitmap(paramMap, ((DisplayMetrics)localObject2).widthPixels, ((DisplayMetrics)localObject2).widthPixels * paramMap.getHeight() / paramMap.getWidth(), true);
    paramContext = paramMap;
    if (localObject1 != null)
    {
      if (paramMap == localObject1) {
        break label577;
      }
      ab.i("MicroMsg.ADListView.Message", "recycle bitmap:%s", new Object[] { paramMap });
      paramMap.recycle();
    }
    for (;;)
    {
      paramMap = new BitmapDrawable(paramContext);
      paramMap.setTargetDensity((DisplayMetrics)localObject2);
      AppMethodBeat.o(34644);
      return paramMap;
      label577:
      paramContext = (Context)localObject1;
    }
  }
  
  public final int a(d paramd)
  {
    boolean bool2 = true;
    AppMethodBeat.i(34643);
    if (paramd != null)
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      if (paramd.Amk == null) {
        break label68;
      }
    }
    Drawable localDrawable;
    label68:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      localDrawable = a(this.Ami.vOU, paramd.Amj.getContext());
      if (localDrawable != null) {
        break label73;
      }
      AppMethodBeat.o(34643);
      return -1;
      bool1 = false;
      break;
    }
    label73:
    paramd.Amj.setBackgroundDrawable(localDrawable);
    paramd = paramd.Amk;
    if (this.Ami.vOP) {}
    for (int i = 0;; i = 8)
    {
      paramd.setVisibility(i);
      AppMethodBeat.o(34643);
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.c
 * JD-Core Version:    0.7.0.1
 */