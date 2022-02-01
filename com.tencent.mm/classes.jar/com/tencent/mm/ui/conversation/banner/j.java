package com.tencent.mm.ui.conversation.banner;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bq.b;
import com.tencent.mm.pluginsdk.ui.a.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;

public final class j
  extends b
{
  LinearLayout aftm;
  
  public j(final Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(38799);
    this.aftm = null;
    this.aftm = new LinearLayout(paramContext);
    this.aftm.setVisibility(8);
    bq.bCF().oly = new bq.b()
    {
      public final void onNotify()
      {
        AppMethodBeat.i(38798);
        j.this.aftm.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(38797);
            if (j.this.aftm != null)
            {
              j.this.aftm.setVisibility(8);
              j.this.aftm.removeAllViews();
            }
            a locala = e.a(j.1.this.val$context, e.a.afsX, null);
            Object localObject = locala;
            if (locala == null) {
              localObject = e.a(j.1.this.val$context, e.a.afsO, null);
            }
            if ((localObject != null) && (((a)localObject).getView() != null))
            {
              Log.i("MicroMsg.MainFrameAndAbtestBanner", "summerinit MainFrameBannerStorage onNotify banner[%s], view[%s]", new Object[] { localObject, ((a)localObject).getView() });
              j.this.aftm.setVisibility(0);
              localObject = ((a)localObject).getView();
              j.this.aftm.addView((View)localObject, new LinearLayout.LayoutParams(-1, -2));
            }
            AppMethodBeat.o(38797);
          }
        });
        AppMethodBeat.o(38798);
      }
    };
    bq.bCF().oly.onNotify();
    AppMethodBeat.o(38799);
  }
  
  public final boolean cMa()
  {
    AppMethodBeat.i(38800);
    if ((this.aftm != null) && (this.aftm.getVisibility() == 0))
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
    bq.bCF().oly = null;
    AppMethodBeat.o(38801);
  }
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final View getView()
  {
    return this.aftm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.banner.j
 * JD-Core Version:    0.7.0.1
 */