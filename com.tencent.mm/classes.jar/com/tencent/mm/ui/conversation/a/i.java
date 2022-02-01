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
import com.tencent.mm.sdk.platformtools.ac;
import java.lang.ref.WeakReference;

public final class i
  extends com.tencent.mm.pluginsdk.ui.b.b
  implements k.a
{
  private TextView IHk;
  private TextView IHl;
  private View mZW;
  private View mZX;
  private View zSj;
  
  public i(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(38786);
    ac.i("MicroMsg.ForceNotifyBanner", "[initialize]");
    this.mZX = this.view.findViewById(2131297183);
    this.mZW = this.view.findViewById(2131297178);
    this.zSj = this.view.findViewById(2131299521);
    this.IHk = ((TextView)this.view.findViewById(2131302978));
    this.IHl = ((TextView)this.view.findViewById(2131299522));
    paramContext = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(38785);
        boolean bool = i.this.fsK();
        ac.i("MicroMsg.ForceNotifyBanner", "[onClick] isShow=%s", new Object[] { Boolean.valueOf(bool) });
        if (bool)
        {
          paramAnonymousView = (com.tencent.mm.plugin.forcenotify.a.b)g.ab(com.tencent.mm.plugin.forcenotify.a.b.class);
          if (paramAnonymousView != null) {
            paramAnonymousView.fd((Context)i.this.Dsc.get());
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
      paramContext.cIj().add(this);
    }
    fsK();
    AppMethodBeat.o(38786);
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(38790);
    fsK();
    AppMethodBeat.o(38790);
  }
  
  public final boolean bvU()
  {
    AppMethodBeat.i(38789);
    boolean bool = ((com.tencent.mm.plugin.forcenotify.a.b)g.ab(com.tencent.mm.plugin.forcenotify.a.b.class)).hasError();
    com.tencent.mm.plugin.forcenotify.a.b localb;
    if ((this.isFirst) && (this.gRm)) {
      if (bool)
      {
        this.zSj.setBackgroundResource(2131234376);
        localb = (com.tencent.mm.plugin.forcenotify.a.b)g.ab(com.tencent.mm.plugin.forcenotify.a.b.class);
        if (localb == null) {
          break label225;
        }
      }
    }
    label225:
    for (bool = localb.cIi();; bool = false)
    {
      AppMethodBeat.o(38789);
      return bool;
      this.mZW.setBackgroundResource(2131234377);
      break;
      if (this.isFirst)
      {
        if (bool)
        {
          this.mZX.setBackgroundResource(2131233815);
          this.zSj.setBackgroundResource(2131232870);
          this.IHl.setBackgroundResource(2131232867);
          break;
        }
        this.mZX.setBackgroundResource(2131232872);
        this.mZW.setBackgroundResource(2131232870);
        this.IHk.setBackgroundResource(2131232867);
        break;
      }
      if (!this.gRm) {
        break;
      }
      if (bool)
      {
        this.mZX.setBackgroundResource(2131233815);
        this.zSj.setBackgroundResource(2131232867);
        this.IHl.setBackground(null);
        break;
      }
      this.mZX.setBackgroundResource(2131232872);
      this.mZW.setBackgroundResource(2131232867);
      this.IHk.setBackground(null);
      break;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(38787);
    if ((com.tencent.mm.plugin.forcenotify.a.b)g.ab(com.tencent.mm.plugin.forcenotify.a.b.class) != null)
    {
      j localj = ((com.tencent.mm.plugin.forcenotify.a.b)g.ab(com.tencent.mm.plugin.forcenotify.a.b.class)).cIj();
      if (localj != null) {
        localj.remove(this);
      }
    }
    AppMethodBeat.o(38787);
  }
  
  public final boolean fsK()
  {
    int j = 8;
    AppMethodBeat.i(38788);
    Object localObject = (com.tencent.mm.plugin.forcenotify.a.b)g.ab(com.tencent.mm.plugin.forcenotify.a.b.class);
    if (localObject == null)
    {
      AppMethodBeat.o(38788);
      return false;
    }
    boolean bool2 = ((com.tencent.mm.plugin.forcenotify.a.b)localObject).cIi();
    boolean bool3 = ((com.tencent.mm.plugin.forcenotify.a.b)localObject).hasError();
    if ((this.zSj == null) || (this.mZW == null))
    {
      AppMethodBeat.o(38788);
      return false;
    }
    int i;
    if (bool3)
    {
      localObject = this.zSj;
      if (bool2)
      {
        i = 0;
        ((View)localObject).setVisibility(i);
        localObject = this.mZW;
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
      ac.i("MicroMsg.ForceNotifyBanner", "[checkShow] isShow:%s hasError:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3) });
      AppMethodBeat.o(38788);
      return bool2;
      i = 8;
      break;
      this.zSj.setVisibility(8);
      View localView = this.mZW;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.i
 * JD-Core Version:    0.7.0.1
 */