package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.sns.ad.j.a.b;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.lang.ref.WeakReference;

final class SnsMsgUI$a
  implements a.b
{
  private String Oha;
  private int Qev;
  private WeakReference<TextView> Rud;
  
  public SnsMsgUI$a(TextView paramTextView, String paramString)
  {
    AppMethodBeat.i(308227);
    this.Rud = new WeakReference(paramTextView);
    this.Qev = a.fromDPToPix(paramTextView.getContext(), 16);
    this.Oha = paramString;
    AppMethodBeat.o(308227);
  }
  
  public final void g(Bitmap paramBitmap, boolean paramBoolean)
  {
    AppMethodBeat.i(308230);
    try
    {
      Object localObject1 = this.Rud;
      if (localObject1 == null)
      {
        AppMethodBeat.o(308230);
        return;
      }
      localObject1 = (TextView)this.Rud.get();
      if (localObject1 == null)
      {
        AppMethodBeat.o(308230);
        return;
      }
      Object localObject2 = ((TextView)localObject1).getTag(b.f.sns_ad_social_img_url);
      if ((localObject2 instanceof String))
      {
        localObject2 = (String)localObject2;
        if ((!TextUtils.isEmpty(this.Oha)) && (this.Oha.equals(localObject2)) && (paramBoolean) && (paramBitmap != null))
        {
          paramBitmap = new BitmapDrawable(MMApplicationContext.getContext().getResources(), paramBitmap);
          paramBitmap.setBounds(0, 0, this.Qev, this.Qev);
          paramBitmap.setColorFilter(((TextView)localObject1).getResources().getColor(b.c.Link), PorterDuff.Mode.SRC_ATOP);
          ((TextView)localObject1).setCompoundDrawables(paramBitmap, null, null, null);
        }
      }
      AppMethodBeat.o(308230);
      return;
    }
    finally
    {
      Log.e("MicroMsg.SnsMsgUI", "onDownloadResult, exp=" + paramBitmap.toString());
      AppMethodBeat.o(308230);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsMsgUI.a
 * JD-Core Version:    0.7.0.1
 */