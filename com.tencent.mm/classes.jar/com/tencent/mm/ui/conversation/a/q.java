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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.h;
import java.lang.ref.WeakReference;

public final class q
  extends com.tencent.mm.pluginsdk.ui.b.b
  implements View.OnClickListener
{
  private View ize;
  
  public q(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(163383);
    this.ize = getView().findViewById(2131297179);
    paramContext = (ImageView)getView().findViewById(2131302982);
    TextView localTextView = (TextView)getView().findViewById(2131302980);
    View localView = getView().findViewById(2131298370);
    paramContext.setImageDrawable(ao.k((Context)this.EXg.get(), 2131690397, ((Context)this.EXg.get()).getResources().getColor(2131099803)));
    localTextView.setText(2131756423);
    this.view.setOnClickListener(this);
    localView.setOnClickListener(this);
    AppMethodBeat.o(163383);
  }
  
  public final boolean bAa()
  {
    AppMethodBeat.i(163385);
    boolean bool = g.ajC().ajl().getBoolean(al.a.IJs, false);
    int i;
    if ((android.support.v4.content.b.checkSelfPermission((Activity)this.EXg.get(), "android.permission.WRITE_EXTERNAL_STORAGE") != 0) && (android.support.v4.app.a.a((Activity)this.EXg.get(), "android.permission.WRITE_EXTERNAL_STORAGE")) && (!com.tencent.mm.sdcard_migrate.b.aPQ(com.tencent.mm.loader.j.b.arT())))
    {
      i = 1;
      if ((bool) || (i == 0)) {
        break label107;
      }
      this.ize.setVisibility(0);
      getView().setVisibility(0);
    }
    for (;;)
    {
      bool = super.bAa();
      AppMethodBeat.o(163385);
      return bool;
      i = 0;
      break;
      label107:
      this.ize.setVisibility(8);
      getView().setVisibility(8);
    }
  }
  
  public final void destroy() {}
  
  public final int getLayoutId()
  {
    return 2131495645;
  }
  
  public final int getOrder()
  {
    return 4;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(163384);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/banner/StoragePermissionBanner", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
    ad.i("MicroMsg.StoragePermissionBanner", "onClick, %d", new Object[] { Integer.valueOf(paramView.getId()) });
    localObject = (Activity)this.EXg.get();
    if (paramView.getId() == 2131298370)
    {
      h.a((Context)localObject, ((Activity)localObject).getString(2131756424), ((Activity)localObject).getString(2131755906), ((Activity)localObject).getString(2131761868), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(163382);
          g.ajC().ajl().set(al.a.IJs, Boolean.TRUE);
          q.this.bAa();
          AppMethodBeat.o(163382);
        }
      });
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(462L, 25L, 1L, true);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/banner/StoragePermissionBanner", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(163384);
      return;
      com.tencent.mm.pluginsdk.permission.b.a((Activity)this.EXg.get(), "android.permission.WRITE_EXTERNAL_STORAGE", 33, "", "");
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(462L, 24L, 1L, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.q
 * JD-Core Version:    0.7.0.1
 */