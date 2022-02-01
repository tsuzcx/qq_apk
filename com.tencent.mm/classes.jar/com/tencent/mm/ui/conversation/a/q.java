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
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.h;
import java.lang.ref.WeakReference;

public final class q
  extends com.tencent.mm.pluginsdk.ui.b.b
  implements View.OnClickListener
{
  private View jxm;
  
  public q(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(163383);
    this.jxm = getView().findViewById(2131297323);
    paramContext = (ImageView)getView().findViewById(2131305571);
    TextView localTextView = (TextView)getView().findViewById(2131305569);
    View localView = getView().findViewById(2131298778);
    paramContext.setImageDrawable(ar.m((Context)this.Kgr.get(), 2131690547, ((Context)this.Kgr.get()).getResources().getColor(2131099818)));
    localTextView.setText(2131756558);
    this.view.setOnClickListener(this);
    localView.setOnClickListener(this);
    AppMethodBeat.o(163383);
  }
  
  public final boolean bYa()
  {
    AppMethodBeat.i(163385);
    boolean bool = g.aAh().azQ().getBoolean(ar.a.OnE, false);
    int i;
    if ((android.support.v4.content.b.checkSelfPermission((Activity)this.Kgr.get(), "android.permission.WRITE_EXTERNAL_STORAGE") != 0) && (android.support.v4.app.a.a((Activity)this.Kgr.get(), "android.permission.WRITE_EXTERNAL_STORAGE")) && (!com.tencent.mm.sdcard_migrate.b.bhQ(com.tencent.mm.loader.j.b.aKI())))
    {
      i = 1;
      if ((bool) || (i == 0)) {
        break label107;
      }
      this.jxm.setVisibility(0);
      getView().setVisibility(0);
    }
    for (;;)
    {
      bool = super.bYa();
      AppMethodBeat.o(163385);
      return bool;
      i = 0;
      break;
      label107:
      this.jxm.setVisibility(8);
      getView().setVisibility(8);
    }
  }
  
  public final void destroy() {}
  
  public final int getLayoutId()
  {
    return 2131496550;
  }
  
  public final int getOrder()
  {
    return 4;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(163384);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/banner/StoragePermissionBanner", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
    Log.i("MicroMsg.StoragePermissionBanner", "onClick, %d", new Object[] { Integer.valueOf(paramView.getId()) });
    localObject = (Activity)this.Kgr.get();
    if (paramView.getId() == 2131298778)
    {
      h.a((Context)localObject, ((Activity)localObject).getString(2131756559), ((Activity)localObject).getString(2131755998), ((Activity)localObject).getString(2131763873), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(163382);
          g.aAh().azQ().set(ar.a.OnE, Boolean.TRUE);
          q.this.bYa();
          AppMethodBeat.o(163382);
        }
      });
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(462L, 25L, 1L, true);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/banner/StoragePermissionBanner", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(163384);
      return;
      com.tencent.mm.pluginsdk.permission.b.a((Activity)this.Kgr.get(), "android.permission.WRITE_EXTERNAL_STORAGE", 33, "", "");
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(462L, 24L, 1L, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.q
 * JD-Core Version:    0.7.0.1
 */