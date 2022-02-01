package com.tencent.mm.plugin.sns.ad.timeline.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.sns.ui.PhotosContent;
import com.tencent.mm.sdk.platformtools.ae;

public final class b
{
  public static ImageView a(Context paramContext, PhotosContent paramPhotosContent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(219122);
    if ((paramContext == null) || (paramPhotosContent == null))
    {
      AppMethodBeat.o(219122);
      return null;
    }
    try
    {
      paramPhotosContent = paramPhotosContent.getChildAt(paramInt1);
      if (paramPhotosContent != null) {}
      for (paramPhotosContent = (ViewGroup.MarginLayoutParams)paramPhotosContent.getLayoutParams(); paramPhotosContent != null; paramPhotosContent = null)
      {
        ImageView localImageView = new ImageView(paramContext);
        paramPhotosContent = new ViewGroup.MarginLayoutParams(paramPhotosContent);
        paramPhotosContent.width = paramInt2;
        paramPhotosContent.height = paramInt2;
        localImageView.setImageDrawable(a.l(paramContext, 2131235087));
        localImageView.setLayoutParams(paramPhotosContent);
        AppMethodBeat.o(219122);
        return localImageView;
      }
      ae.e("AddWeAppIconHelper", "getEachImageViewLayoutParams is null");
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        ae.e("AddWeAppIconHelper", paramContext.toString());
      }
    }
    AppMethodBeat.o(219122);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.a.b
 * JD-Core Version:    0.7.0.1
 */