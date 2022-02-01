package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.ref.WeakReference;

public final class i
  extends com.tencent.mm.pluginsdk.ui.b.b
  implements k.a
{
  View BjO;
  TextView Kyq;
  TextView Kyr;
  View nAt;
  View nAu;
  
  public i(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(38786);
    ad.i("MicroMsg.ForceNotifyBanner", "[initialize]");
    this.nAu = this.view.findViewById(2131297183);
    this.nAt = this.view.findViewById(2131297178);
    this.BjO = this.view.findViewById(2131299521);
    this.Kyq = ((TextView)this.view.findViewById(2131302978));
    this.Kyr = ((TextView)this.view.findViewById(2131299522));
    paramContext = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(38785);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/ui/conversation/banner/ForceNotifyBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        boolean bool = i.this.fJy();
        ad.i("MicroMsg.ForceNotifyBanner", "[onClick] isShow=%s", new Object[] { Boolean.valueOf(bool) });
        if (bool)
        {
          paramAnonymousView = (com.tencent.mm.plugin.forcenotify.a.b)g.ab(com.tencent.mm.plugin.forcenotify.a.b.class);
          if (paramAnonymousView != null) {
            paramAnonymousView.fg((Context)i.this.EXg.get());
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
    paramContext = (com.tencent.mm.plugin.forcenotify.a.b)g.ab(com.tencent.mm.plugin.forcenotify.a.b.class);
    if (paramContext != null) {
      paramContext.cQy().add(this);
    }
    fJy();
    AppMethodBeat.o(38786);
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(38790);
    fJy();
    AppMethodBeat.o(38790);
  }
  
  public final boolean bAa()
  {
    AppMethodBeat.i(38789);
    h.LTJ.aP(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(194760);
        final boolean bool = ((com.tencent.mm.plugin.forcenotify.a.b)g.ab(com.tencent.mm.plugin.forcenotify.a.b.class)).hasError();
        h.LTJ.aP(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(194759);
            if ((i.this.isFirst) && (i.this.hjE))
            {
              if (bool)
              {
                i.this.BjO.setBackgroundResource(2131234376);
                AppMethodBeat.o(194759);
                return;
              }
              i.this.nAt.setBackgroundResource(2131234377);
              AppMethodBeat.o(194759);
              return;
            }
            if (i.this.isFirst)
            {
              if (bool)
              {
                i.this.nAu.setBackgroundResource(2131233815);
                i.this.BjO.setBackgroundResource(2131232870);
                i.this.Kyr.setBackgroundResource(2131232867);
                AppMethodBeat.o(194759);
                return;
              }
              i.this.nAu.setBackgroundResource(2131232872);
              i.this.nAt.setBackgroundResource(2131232870);
              i.this.Kyq.setBackgroundResource(2131232867);
              AppMethodBeat.o(194759);
              return;
            }
            if (i.this.hjE)
            {
              if (bool)
              {
                i.this.nAu.setBackgroundResource(2131233815);
                i.this.BjO.setBackgroundResource(2131232867);
                i.this.Kyr.setBackground(null);
                AppMethodBeat.o(194759);
                return;
              }
              i.this.nAu.setBackgroundResource(2131232872);
              i.this.nAt.setBackgroundResource(2131232867);
              i.this.Kyq.setBackground(null);
            }
            AppMethodBeat.o(194759);
          }
        });
        AppMethodBeat.o(194760);
      }
    });
    com.tencent.mm.plugin.forcenotify.a.b localb = (com.tencent.mm.plugin.forcenotify.a.b)g.ab(com.tencent.mm.plugin.forcenotify.a.b.class);
    if (localb != null) {}
    for (boolean bool = localb.cQx();; bool = false)
    {
      AppMethodBeat.o(38789);
      return bool;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(38787);
    if ((com.tencent.mm.plugin.forcenotify.a.b)g.ab(com.tencent.mm.plugin.forcenotify.a.b.class) != null)
    {
      j localj = ((com.tencent.mm.plugin.forcenotify.a.b)g.ab(com.tencent.mm.plugin.forcenotify.a.b.class)).cQy();
      if (localj != null) {
        localj.remove(this);
      }
    }
    AppMethodBeat.o(38787);
  }
  
  public final boolean fJy()
  {
    int j = 8;
    AppMethodBeat.i(38788);
    Object localObject = (com.tencent.mm.plugin.forcenotify.a.b)g.ab(com.tencent.mm.plugin.forcenotify.a.b.class);
    if (localObject == null)
    {
      AppMethodBeat.o(38788);
      return false;
    }
    boolean bool2 = ((com.tencent.mm.plugin.forcenotify.a.b)localObject).cQx();
    boolean bool3 = ((com.tencent.mm.plugin.forcenotify.a.b)localObject).hasError();
    if ((this.BjO == null) || (this.nAt == null))
    {
      AppMethodBeat.o(38788);
      return false;
    }
    int i;
    if (bool3)
    {
      localObject = this.BjO;
      if (bool2)
      {
        i = 0;
        ((View)localObject).setVisibility(i);
        localObject = this.nAt;
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
      ad.i("MicroMsg.ForceNotifyBanner", "[checkShow] isShow:%s hasError:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3) });
      AppMethodBeat.o(38788);
      return bool2;
      i = 8;
      break;
      this.BjO.setVisibility(8);
      View localView = this.nAt;
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
    return 2131494161;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.i
 * JD-Core Version:    0.7.0.1
 */