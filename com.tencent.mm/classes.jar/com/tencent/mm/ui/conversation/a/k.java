package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bi.b;
import com.tencent.mm.pluginsdk.ui.b.a;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.ad;

public final class k
  extends b
{
  LinearLayout Kyy;
  
  public k(final Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(38799);
    this.Kyy = null;
    this.Kyy = new LinearLayout(paramContext);
    this.Kyy.setVisibility(8);
    bi.aBW().hGw = new bi.b()
    {
      public final void onNotify()
      {
        AppMethodBeat.i(38798);
        k.this.Kyy.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(38797);
            if (k.this.Kyy != null)
            {
              k.this.Kyy.setVisibility(8);
              k.this.Kyy.removeAllViews();
            }
            a locala = e.a(k.1.this.val$context, e.a.Kyf, null);
            Object localObject = locala;
            if (locala == null) {
              localObject = e.a(k.1.this.val$context, e.a.KxW, null);
            }
            if ((localObject != null) && (((a)localObject).getView() != null))
            {
              ad.i("MicroMsg.MainFrameAndAbtestBanner", "summerinit MainFrameBannerStorage onNotify banner[%s], view[%s]", new Object[] { localObject, ((a)localObject).getView() });
              k.this.Kyy.setVisibility(0);
              localObject = ((a)localObject).getView();
              k.this.Kyy.addView((View)localObject, new LinearLayout.LayoutParams(-1, -2));
            }
            AppMethodBeat.o(38797);
          }
        });
        AppMethodBeat.o(38798);
      }
    };
    bi.aBW().hGw.onNotify();
    AppMethodBeat.o(38799);
  }
  
  public final boolean bAa()
  {
    AppMethodBeat.i(38800);
    if ((this.Kyy != null) && (this.Kyy.getVisibility() == 0))
    {
      AppMethodBeat.o(38800);
      return true;
    }
    AppMethodBeat.o(38800);
    return false;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(38801);
    bi.aBW().hGw = null;
    AppMethodBeat.o(38801);
  }
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final View getView()
  {
    return this.Kyy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.k
 * JD-Core Version:    0.7.0.1
 */