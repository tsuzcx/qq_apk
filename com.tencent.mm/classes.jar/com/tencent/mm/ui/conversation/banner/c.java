package com.tencent.mm.ui.conversation.banner;

import android.content.Context;
import android.content.res.AssetManager;
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
import com.tencent.mm.pluginsdk.k.a.a.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import junit.framework.Assert;

public final class c
{
  com.tencent.mm.pluginsdk.k.a.a afsK;
  
  c(com.tencent.mm.pluginsdk.k.a.a parama)
  {
    this.afsK = parama;
  }
  
  private static Drawable a(Map<String, String> paramMap, Context paramContext)
  {
    AppMethodBeat.i(38771);
    if ((paramMap == null) || (paramMap.size() <= 0))
    {
      AppMethodBeat.o(38771);
      return null;
    }
    Object localObject2 = (String)paramMap.get(BackwardSupportUtil.BitmapFactory.getDisplaySizeType(paramContext));
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = (String)paramMap.get(BackwardSupportUtil.BitmapFactory.getDisplayDensityType(paramContext));
    }
    if (Util.nullAsNil((String)localObject1).length() <= 0)
    {
      AppMethodBeat.o(38771);
      return null;
    }
    localObject2 = com.tencent.mm.pluginsdk.k.a.a.bqw((String)localObject1);
    if (localObject2 == a.a.XXm)
    {
      AppMethodBeat.o(38771);
      return null;
    }
    localObject1 = com.tencent.mm.pluginsdk.k.a.a.bqv((String)localObject1);
    if (Util.nullAsNil((String)localObject1).length() <= 0)
    {
      AppMethodBeat.o(38771);
      return null;
    }
    for (;;)
    {
      try
      {
        if (localObject2 == a.a.XXk)
        {
          paramMap = BackwardSupportUtil.BitmapFactory.decodeStream(paramContext.getAssets().open((String)localObject1), com.tencent.mm.cd.a.getDensity(paramContext));
          if (paramMap == null)
          {
            Log.e("MicroMsg.ADListView.Message", "get Bitmap failed type:" + localObject2 + " path:" + (String)localObject1);
            AppMethodBeat.o(38771);
            return null;
          }
        }
        else
        {
          paramMap = BackwardSupportUtil.BitmapFactory.decodeFile((String)localObject1, com.tencent.mm.cd.a.getDensity(paramContext));
          continue;
        }
        localObject1 = paramMap.getNinePatchChunk();
        if ((localObject1 != null) && (NinePatch.isNinePatchChunk((byte[])localObject1)))
        {
          paramMap = new NinePatchDrawable(paramMap, (byte[])localObject1, new Rect(), null);
          AppMethodBeat.o(38771);
          return paramMap;
        }
        localObject2 = paramContext.getResources().getDisplayMetrics();
        localObject1 = Bitmap.createScaledBitmap(paramMap, ((DisplayMetrics)localObject2).widthPixels, ((DisplayMetrics)localObject2).widthPixels * paramMap.getHeight() / paramMap.getWidth(), true);
        paramContext = paramMap;
        if (localObject1 != null)
        {
          if (paramMap != localObject1)
          {
            Log.i("MicroMsg.ADListView.Message", "recycle bitmap:%s", new Object[] { paramMap });
            paramMap.recycle();
          }
        }
        else
        {
          paramMap = new BitmapDrawable(paramContext);
          paramMap.setTargetDensity((DisplayMetrics)localObject2);
          AppMethodBeat.o(38771);
          return paramMap;
        }
      }
      catch (Exception paramMap)
      {
        Log.printErrStackTrace("MicroMsg.ADListView.Message", paramMap, "", new Object[0]);
        AppMethodBeat.o(38771);
        return null;
      }
      paramContext = (Context)localObject1;
    }
  }
  
  public final int a(d paramd)
  {
    boolean bool2 = true;
    AppMethodBeat.i(38770);
    if (paramd != null)
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      if (paramd.afsM == null) {
        break label68;
      }
    }
    Drawable localDrawable;
    label68:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      localDrawable = a(this.afsK.XXi, paramd.afsL.getContext());
      if (localDrawable != null) {
        break label73;
      }
      AppMethodBeat.o(38770);
      return -1;
      bool1 = false;
      break;
    }
    label73:
    paramd.afsL.setBackgroundDrawable(localDrawable);
    paramd = paramd.afsM;
    if (this.afsK.XXd) {}
    for (int i = 0;; i = 8)
    {
      paramd.setVisibility(i);
      AppMethodBeat.o(38770);
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.banner.c
 * JD-Core Version:    0.7.0.1
 */