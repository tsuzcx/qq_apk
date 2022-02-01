package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import java.lang.ref.WeakReference;

public final class i
  extends com.tencent.mm.pluginsdk.ui.b.b
  implements MStorage.IOnStorageChange
{
  private View FLZ;
  private TextView Qia;
  private TextView Qib;
  private View oQL;
  private View oQM;
  
  public i(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(38786);
    Log.i("MicroMsg.ForceNotifyBanner", "[initialize]");
    this.oQM = this.view.findViewById(2131297327);
    this.oQL = this.view.findViewById(2131297322);
    this.FLZ = this.view.findViewById(2131300159);
    this.Qia = ((TextView)this.view.findViewById(2131305567));
    this.Qib = ((TextView)this.view.findViewById(2131300160));
    paramContext = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(38785);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/ui/conversation/banner/ForceNotifyBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        boolean bool = i.this.gWj();
        Log.i("MicroMsg.ForceNotifyBanner", "[onClick] isShow=%s", new Object[] { Boolean.valueOf(bool) });
        if (bool)
        {
          paramAnonymousView = (com.tencent.mm.plugin.forcenotify.a.b)g.af(com.tencent.mm.plugin.forcenotify.a.b.class);
          if (paramAnonymousView != null) {
            paramAnonymousView.fQ((Context)i.a(i.this).get());
          }
        }
        for (;;)
        {
          a.a(this, "com/tencent/mm/ui/conversation/banner/ForceNotifyBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(38785);
          return;
          i.this.setVisibility(8);
        }
      }
    };
    this.view.setOnClickListener(paramContext);
    paramContext = (com.tencent.mm.plugin.forcenotify.a.b)g.af(com.tencent.mm.plugin.forcenotify.a.b.class);
    if (paramContext != null) {
      paramContext.dMm().add(this);
    }
    gWj();
    AppMethodBeat.o(38786);
  }
  
  public final boolean bYa()
  {
    AppMethodBeat.i(38789);
    h.RTc.aV(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(234284);
        final boolean bool = ((com.tencent.mm.plugin.forcenotify.a.b)g.af(com.tencent.mm.plugin.forcenotify.a.b.class)).hasError();
        h.RTc.aV(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(234283);
            if ((i.this.isFirst) && (i.this.ifo))
            {
              if (bool)
              {
                i.b(i.this).setBackgroundResource(2131235298);
                AppMethodBeat.o(234283);
                return;
              }
              i.c(i.this).setBackgroundResource(2131235299);
              AppMethodBeat.o(234283);
              return;
            }
            if (i.this.isFirst)
            {
              if (bool)
              {
                i.d(i.this).setBackgroundResource(2131234639);
                i.b(i.this).setBackgroundResource(2131233330);
                i.e(i.this).setBackgroundResource(2131233327);
                AppMethodBeat.o(234283);
                return;
              }
              i.d(i.this).setBackgroundResource(2131233332);
              i.c(i.this).setBackgroundResource(2131233330);
              i.f(i.this).setBackgroundResource(2131233327);
              AppMethodBeat.o(234283);
              return;
            }
            if (i.this.ifo)
            {
              if (bool)
              {
                i.d(i.this).setBackgroundResource(2131234639);
                i.b(i.this).setBackgroundResource(2131233327);
                i.e(i.this).setBackground(null);
                AppMethodBeat.o(234283);
                return;
              }
              i.d(i.this).setBackgroundResource(2131233332);
              i.c(i.this).setBackgroundResource(2131233327);
              i.f(i.this).setBackground(null);
            }
            AppMethodBeat.o(234283);
          }
        });
        AppMethodBeat.o(234284);
      }
    });
    com.tencent.mm.plugin.forcenotify.a.b localb = (com.tencent.mm.plugin.forcenotify.a.b)g.af(com.tencent.mm.plugin.forcenotify.a.b.class);
    if (localb != null) {}
    for (boolean bool = localb.dMl();; bool = false)
    {
      AppMethodBeat.o(38789);
      return bool;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(38787);
    if ((com.tencent.mm.plugin.forcenotify.a.b)g.af(com.tencent.mm.plugin.forcenotify.a.b.class) != null)
    {
      MAutoStorage localMAutoStorage = ((com.tencent.mm.plugin.forcenotify.a.b)g.af(com.tencent.mm.plugin.forcenotify.a.b.class)).dMm();
      if (localMAutoStorage != null) {
        localMAutoStorage.remove(this);
      }
    }
    AppMethodBeat.o(38787);
  }
  
  public final boolean gWj()
  {
    int j = 8;
    AppMethodBeat.i(38788);
    Object localObject = (com.tencent.mm.plugin.forcenotify.a.b)g.af(com.tencent.mm.plugin.forcenotify.a.b.class);
    if (localObject == null)
    {
      AppMethodBeat.o(38788);
      return false;
    }
    boolean bool2 = ((com.tencent.mm.plugin.forcenotify.a.b)localObject).dMl();
    boolean bool3 = ((com.tencent.mm.plugin.forcenotify.a.b)localObject).hasError();
    if ((this.FLZ == null) || (this.oQL == null))
    {
      AppMethodBeat.o(38788);
      return false;
    }
    int i;
    if (bool3)
    {
      localObject = this.FLZ;
      if (bool2)
      {
        i = 0;
        ((View)localObject).setVisibility(i);
        localObject = this.oQL;
        i = j;
        label101:
        ((View)localObject).setVisibility(i);
        if ((!bool2) || (bool3)) {
          break label194;
        }
      }
    }
    label194:
    for (boolean bool1 = true;; bool1 = false)
    {
      Log.i("MicroMsg.ForceNotifyBanner", "[checkShow] isShow:%s hasError:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3) });
      AppMethodBeat.o(38788);
      return bool2;
      i = 8;
      break;
      this.FLZ.setVisibility(8);
      View localView = this.oQL;
      localObject = localView;
      i = j;
      if (!bool2) {
        break label101;
      }
      i = 0;
      localObject = localView;
      break label101;
    }
  }
  
  public final int getLayoutId()
  {
    return 2131494716;
  }
  
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(38790);
    gWj();
    AppMethodBeat.o(38790);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.i
 * JD-Core Version:    0.7.0.1
 */