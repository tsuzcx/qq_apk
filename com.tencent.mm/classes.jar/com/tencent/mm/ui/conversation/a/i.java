package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;

public final class i
  extends com.tencent.mm.pluginsdk.ui.b.b
  implements k.a
{
  private View AmF;
  private TextView AmG;
  private TextView AmH;
  private View jGC;
  private View jGD;
  
  public i(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(34659);
    ab.i("MicroMsg.ForceNotifyBanner", "[initialize]");
    this.jGD = this.view.findViewById(2131821667);
    this.jGC = this.view.findViewById(2131824232);
    this.AmF = this.view.findViewById(2131824235);
    this.AmG = ((TextView)this.view.findViewById(2131824234));
    this.AmH = ((TextView)this.view.findViewById(2131824236));
    paramContext = new i.1(this);
    this.view.setOnClickListener(paramContext);
    paramContext = (com.tencent.mm.plugin.forcenotify.a.b)g.E(com.tencent.mm.plugin.forcenotify.a.b.class);
    if (paramContext != null) {
      paramContext.bzI().add(this);
    }
    dNb();
    AppMethodBeat.o(34659);
  }
  
  private boolean dNb()
  {
    int j = 8;
    AppMethodBeat.i(34661);
    Object localObject = (com.tencent.mm.plugin.forcenotify.a.b)g.E(com.tencent.mm.plugin.forcenotify.a.b.class);
    if (localObject != null) {}
    for (boolean bool1 = ((com.tencent.mm.plugin.forcenotify.a.b)localObject).bzH();; bool1 = false)
    {
      boolean bool3 = ((com.tencent.mm.plugin.forcenotify.a.b)g.E(com.tencent.mm.plugin.forcenotify.a.b.class)).hasError();
      int i;
      if (bool3)
      {
        localObject = this.AmF;
        if (bool1)
        {
          i = 0;
          ((View)localObject).setVisibility(i);
          localObject = this.jGC;
          i = j;
          label77:
          ((View)localObject).setVisibility(i);
          if ((!bool1) || (bool3)) {
            break label178;
          }
        }
      }
      label178:
      for (boolean bool2 = true;; bool2 = false)
      {
        ab.i("MicroMsg.ForceNotifyBanner", "[checkShow] isShow:%s hasError:%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
        if ((!bool1) || (bool3)) {
          break label184;
        }
        AppMethodBeat.o(34661);
        return true;
        i = 8;
        break;
        this.AmF.setVisibility(8);
        View localView = this.jGC;
        localObject = localView;
        i = j;
        if (!bool1) {
          break label77;
        }
        i = 0;
        localObject = localView;
        break label77;
      }
      label184:
      AppMethodBeat.o(34661);
      return false;
    }
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(34663);
    dNb();
    AppMethodBeat.o(34663);
  }
  
  public final boolean aMK()
  {
    AppMethodBeat.i(34662);
    boolean bool = ((com.tencent.mm.plugin.forcenotify.a.b)g.E(com.tencent.mm.plugin.forcenotify.a.b.class)).hasError();
    if ((this.nwf) && (this.eUx)) {
      if (bool) {
        this.AmF.setBackgroundResource(2130840582);
      }
    }
    for (;;)
    {
      bool = super.aMK();
      AppMethodBeat.o(34662);
      return bool;
      this.jGC.setBackgroundResource(2130840583);
      continue;
      if (this.nwf)
      {
        if (bool)
        {
          this.jGD.setBackgroundResource(2130840132);
          this.AmF.setBackgroundResource(2130839278);
          this.AmH.setBackgroundResource(2130839276);
        }
        else
        {
          this.jGD.setBackgroundResource(2130839279);
          this.jGC.setBackgroundResource(2130839278);
          this.AmG.setBackgroundResource(2130839276);
        }
      }
      else if (this.eUx) {
        if (bool)
        {
          this.jGD.setBackgroundResource(2130840132);
          this.AmF.setBackgroundResource(2130839276);
          this.AmH.setBackground(null);
        }
        else
        {
          this.jGD.setBackgroundResource(2130839279);
          this.jGC.setBackgroundResource(2130839276);
          this.AmG.setBackground(null);
        }
      }
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(34660);
    if ((com.tencent.mm.plugin.forcenotify.a.b)g.E(com.tencent.mm.plugin.forcenotify.a.b.class) != null)
    {
      j localj = ((com.tencent.mm.plugin.forcenotify.a.b)g.E(com.tencent.mm.plugin.forcenotify.a.b.class)).bzI();
      if (localj != null) {
        localj.remove(this);
      }
    }
    AppMethodBeat.o(34660);
  }
  
  public final int getLayoutId()
  {
    return 2130969620;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.i
 * JD-Core Version:    0.7.0.1
 */