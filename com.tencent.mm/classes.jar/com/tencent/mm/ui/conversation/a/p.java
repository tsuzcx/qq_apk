package com.tencent.mm.ui.conversation.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.au;
import java.lang.ref.WeakReference;

public final class p
  extends com.tencent.mm.pluginsdk.ui.b.b
  implements View.OnClickListener
{
  private View fyN;
  
  public p(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(163383);
    this.fyN = getView().findViewById(R.h.dtb);
    paramContext = (ImageView)getView().findViewById(R.h.nw_icon);
    TextView localTextView = (TextView)getView().findViewById(R.h.dQx);
    View localView = getView().findViewById(R.h.close_icon);
    paramContext.setImageDrawable(au.o((Context)this.Rhc.get(), R.k.icons_filled_error, ((Context)this.Rhc.get()).getResources().getColor(R.e.Red)));
    localTextView.setText(R.l.esF);
    this.view.setOnClickListener(this);
    localView.setOnClickListener(this);
    AppMethodBeat.o(163383);
  }
  
  public final boolean ckL()
  {
    AppMethodBeat.i(163385);
    boolean bool = com.tencent.mm.kernel.h.aHG().aHp().getBoolean(ar.a.VCR, false);
    int i;
    if ((androidx.core.content.a.checkSelfPermission((Activity)this.Rhc.get(), "android.permission.WRITE_EXTERNAL_STORAGE") != 0) && (androidx.core.app.a.a((Activity)this.Rhc.get(), "android.permission.WRITE_EXTERNAL_STORAGE")) && (!com.tencent.mm.sdcard_migrate.b.buj(com.tencent.mm.loader.j.b.aSK())))
    {
      i = 1;
      if ((bool) || (i == 0)) {
        break label107;
      }
      this.fyN.setVisibility(0);
      getView().setVisibility(0);
    }
    for (;;)
    {
      bool = super.ckL();
      AppMethodBeat.o(163385);
      return bool;
      i = 0;
      break;
      label107:
      this.fyN.setVisibility(8);
      getView().setVisibility(8);
    }
  }
  
  public final void destroy() {}
  
  public final int getLayoutId()
  {
    return R.i.elt;
  }
  
  public final int getOrder()
  {
    return 4;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(163384);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/conversation/banner/StoragePermissionBanner", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
    Log.i("MicroMsg.StoragePermissionBanner", "onClick, %d", new Object[] { Integer.valueOf(paramView.getId()) });
    localObject = (Activity)this.Rhc.get();
    if (paramView.getId() == R.h.close_icon)
    {
      com.tencent.mm.ui.base.h.a((Context)localObject, ((Activity)localObject).getString(R.l.esG), ((Activity)localObject).getString(R.l.app_tip), ((Activity)localObject).getString(R.l.permission_launcher_guide_i_know), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(163382);
          com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VCR, Boolean.TRUE);
          p.this.ckL();
          AppMethodBeat.o(163382);
        }
      });
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(462L, 25L, 1L, true);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/banner/StoragePermissionBanner", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(163384);
      return;
      com.tencent.mm.pluginsdk.permission.b.a((Activity)this.Rhc.get(), "android.permission.WRITE_EXTERNAL_STORAGE", 33, "", "");
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(462L, 24L, 1L, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.p
 * JD-Core Version:    0.7.0.1
 */