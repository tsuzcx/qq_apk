package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.b.c;

public final class j
  extends b
{
  View AmJ;
  int dqG;
  private c yWz;
  
  public j(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(34668);
    this.AmJ = View.inflate(paramContext, 2130969910, null);
    if (this.AmJ == null)
    {
      AppMethodBeat.o(34668);
      return;
    }
    this.dqG = ah.getInt(g.Nq().getValue("InviteFriendsControlFlags"), 0);
    this.AmJ.setVisibility(8);
    this.AmJ.setPadding(0, -com.tencent.mm.cb.a.fromDPToPix(paramContext, 2131427807), 0, 0);
    if ((this.dqG & 0x1) > 0)
    {
      this.AmJ.setVisibility(0);
      this.AmJ.setPadding(0, 0, 0, 0);
    }
    this.AmJ.setOnClickListener(new j.1(this, paramContext));
    this.yWz = new j.2(this);
    AppMethodBeat.o(34668);
  }
  
  public final boolean aMK()
  {
    AppMethodBeat.i(34669);
    com.tencent.mm.sdk.b.a.ymk.c(this.yWz);
    if ((this.AmJ != null) && (this.AmJ.getVisibility() == 0))
    {
      AppMethodBeat.o(34669);
      return true;
    }
    AppMethodBeat.o(34669);
    return false;
  }
  
  public final void destroy() {}
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final View getView()
  {
    return this.AmJ;
  }
  
  public final void release()
  {
    AppMethodBeat.i(34670);
    com.tencent.mm.sdk.b.a.ymk.d(this.yWz);
    AppMethodBeat.o(34670);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.j
 * JD-Core Version:    0.7.0.1
 */