package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bo;
import com.tencent.mm.model.bo.b;
import com.tencent.mm.pluginsdk.ui.b.a;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.Log;

public final class k
  extends b
{
  LinearLayout Qii;
  
  public k(final Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(38799);
    this.Qii = null;
    this.Qii = new LinearLayout(paramContext);
    this.Qii.setVisibility(8);
    bo.aVL().iDY = new bo.b()
    {
      public final void onNotify()
      {
        AppMethodBeat.i(38798);
        k.this.Qii.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(38797);
            if (k.this.Qii != null)
            {
              k.this.Qii.setVisibility(8);
              k.this.Qii.removeAllViews();
            }
            a locala = e.a(k.1.this.val$context, e.a.QhP, null);
            Object localObject = locala;
            if (locala == null) {
              localObject = e.a(k.1.this.val$context, e.a.QhG, null);
            }
            if ((localObject != null) && (((a)localObject).getView() != null))
            {
              Log.i("MicroMsg.MainFrameAndAbtestBanner", "summerinit MainFrameBannerStorage onNotify banner[%s], view[%s]", new Object[] { localObject, ((a)localObject).getView() });
              k.this.Qii.setVisibility(0);
              localObject = ((a)localObject).getView();
              k.this.Qii.addView((View)localObject, new LinearLayout.LayoutParams(-1, -2));
            }
            AppMethodBeat.o(38797);
          }
        });
        AppMethodBeat.o(38798);
      }
    };
    bo.aVL().iDY.onNotify();
    AppMethodBeat.o(38799);
  }
  
  public final boolean bYa()
  {
    AppMethodBeat.i(38800);
    if ((this.Qii != null) && (this.Qii.getVisibility() == 0))
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
    bo.aVL().iDY = null;
    AppMethodBeat.o(38801);
  }
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final View getView()
  {
    return this.Qii;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.k
 * JD-Core Version:    0.7.0.1
 */