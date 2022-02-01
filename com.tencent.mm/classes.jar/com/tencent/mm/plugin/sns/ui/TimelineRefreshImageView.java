package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.reflect.Field;

public class TimelineRefreshImageView
  extends ImageView
{
  public TimelineRefreshImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TimelineRefreshImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void buildDrawingCache(boolean paramBoolean)
  {
    AppMethodBeat.i(99765);
    Object localObject;
    if (paramBoolean) {
      localObject = "mDrawingCache";
    }
    for (;;)
    {
      try
      {
        localObject = View.class.getDeclaredField((String)localObject);
        ((Field)localObject).setAccessible(true);
        localObject = (Bitmap)((Field)localObject).get(this);
        if (localObject != null) {
          continue;
        }
        localObject = "cache is null";
        ad.d("MicroMsg.TimelineRefreshImageView", (String)localObject);
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.TimelineRefreshImageView", localException, "", new Object[0]);
        ad.e("MicroMsg.TimelineRefreshImageView", "checkIfCanReuseDrawingCache error: %s", new Object[] { localException.getMessage() });
        continue;
      }
      ad.d("MicroMsg.TimelineRefreshImageView", "buildDrawingCache, autoScale: %s, width: %s, height: %s, hash: %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(getWidth()), Integer.valueOf(getHeight()), Integer.valueOf(hashCode()) });
      super.buildDrawingCache(paramBoolean);
      AppMethodBeat.o(99765);
      return;
      localObject = "mUnscaledDrawingCache";
      continue;
      localObject = String.format("cache.width: %s, cache.height: %s, width: %s, height: %s", new Object[] { Integer.valueOf(((Bitmap)localObject).getWidth()), Integer.valueOf(((Bitmap)localObject).getHeight()), Integer.valueOf(getWidth()), Integer.valueOf(getHeight()) });
    }
  }
  
  public void destroyDrawingCache()
  {
    AppMethodBeat.i(99766);
    super.destroyDrawingCache();
    ad.d("MicroMsg.TimelineRefreshImageView", "destroyDrawingCache, width: %s, height: %s, hash: %s", new Object[] { Integer.valueOf(getWidth()), Integer.valueOf(getHeight()), Integer.valueOf(hashCode()) });
    AppMethodBeat.o(99766);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.TimelineRefreshImageView
 * JD-Core Version:    0.7.0.1
 */