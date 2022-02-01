package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
  private TextView HgR;
  private TextView HgS;
  private View mxV;
  private View mxW;
  private View yEV;
  
  public i(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(38786);
    ad.i("MicroMsg.ForceNotifyBanner", "[initialize]");
    this.mxW = this.view.findViewById(2131297183);
    this.mxV = this.view.findViewById(2131297178);
    this.yEV = this.view.findViewById(2131299521);
    this.HgR = ((TextView)this.view.findViewById(2131302978));
    this.HgS = ((TextView)this.view.findViewById(2131299522));
    paramContext = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(38785);
        boolean bool = i.this.fcP();
        ad.i("MicroMsg.ForceNotifyBanner", "[onClick] isShow=%s", new Object[] { Boolean.valueOf(bool) });
        if (bool)
        {
          paramAnonymousView = (com.tencent.mm.plugin.forcenotify.a.b)g.ab(com.tencent.mm.plugin.forcenotify.a.b.class);
          if (paramAnonymousView != null) {
            paramAnonymousView.eQ((Context)i.this.BZM.get());
          }
          AppMethodBeat.o(38785);
          return;
        }
        i.this.setVisibility(8);
        AppMethodBeat.o(38785);
      }
    };
    this.view.setOnClickListener(paramContext);
    paramContext = (com.tencent.mm.plugin.forcenotify.a.b)g.ab(com.tencent.mm.plugin.forcenotify.a.b.class);
    if (paramContext != null) {
      paramContext.cuX().add(this);
    }
    fcP();
    AppMethodBeat.o(38786);
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(38790);
    fcP();
    AppMethodBeat.o(38790);
  }
  
  public final boolean boZ()
  {
    AppMethodBeat.i(38789);
    boolean bool = ((com.tencent.mm.plugin.forcenotify.a.b)g.ab(com.tencent.mm.plugin.forcenotify.a.b.class)).hasError();
    if ((this.isFirst) && (this.gqE)) {
      if (bool) {
        this.yEV.setBackgroundResource(2131234376);
      }
    }
    for (;;)
    {
      bool = super.boZ();
      AppMethodBeat.o(38789);
      return bool;
      this.mxV.setBackgroundResource(2131234377);
      continue;
      if (this.isFirst)
      {
        if (bool)
        {
          this.mxW.setBackgroundResource(2131233815);
          this.yEV.setBackgroundResource(2131232870);
          this.HgS.setBackgroundResource(2131232867);
        }
        else
        {
          this.mxW.setBackgroundResource(2131232872);
          this.mxV.setBackgroundResource(2131232870);
          this.HgR.setBackgroundResource(2131232867);
        }
      }
      else if (this.gqE) {
        if (bool)
        {
          this.mxW.setBackgroundResource(2131233815);
          this.yEV.setBackgroundResource(2131232867);
          this.HgS.setBackground(null);
        }
        else
        {
          this.mxW.setBackgroundResource(2131232872);
          this.mxV.setBackgroundResource(2131232867);
          this.HgR.setBackground(null);
        }
      }
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(38787);
    if ((com.tencent.mm.plugin.forcenotify.a.b)g.ab(com.tencent.mm.plugin.forcenotify.a.b.class) != null)
    {
      j localj = ((com.tencent.mm.plugin.forcenotify.a.b)g.ab(com.tencent.mm.plugin.forcenotify.a.b.class)).cuX();
      if (localj != null) {
        localj.remove(this);
      }
    }
    AppMethodBeat.o(38787);
  }
  
  public final boolean fcP()
  {
    int j = 8;
    AppMethodBeat.i(38788);
    Object localObject = (com.tencent.mm.plugin.forcenotify.a.b)g.ab(com.tencent.mm.plugin.forcenotify.a.b.class);
    if (localObject == null)
    {
      AppMethodBeat.o(38788);
      return false;
    }
    boolean bool2 = ((com.tencent.mm.plugin.forcenotify.a.b)localObject).cuW();
    boolean bool3 = ((com.tencent.mm.plugin.forcenotify.a.b)localObject).hasError();
    if ((this.yEV == null) || (this.mxV == null))
    {
      AppMethodBeat.o(38788);
      return false;
    }
    int i;
    if (bool3)
    {
      localObject = this.yEV;
      if (bool2)
      {
        i = 0;
        ((View)localObject).setVisibility(i);
        localObject = this.mxV;
        i = j;
        label101:
        ((View)localObject).setVisibility(i);
        if ((!bool2) || (bool3)) {
          break label203;
        }
      }
    }
    label203:
    for (boolean bool1 = true;; bool1 = false)
    {
      ad.i("MicroMsg.ForceNotifyBanner", "[checkShow] isShow:%s hasError:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3) });
      if ((!bool2) || (bool3)) {
        break label208;
      }
      AppMethodBeat.o(38788);
      return true;
      i = 8;
      break;
      this.yEV.setVisibility(8);
      View localView = this.mxV;
      localObject = localView;
      i = j;
      if (!bool2) {
        break label101;
      }
      i = 0;
      localObject = localView;
      break label101;
    }
    label208:
    AppMethodBeat.o(38788);
    return false;
  }
  
  public final int getLayoutId()
  {
    return 2131494161;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.i
 * JD-Core Version:    0.7.0.1
 */