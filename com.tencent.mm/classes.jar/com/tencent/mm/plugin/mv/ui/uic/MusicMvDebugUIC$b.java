package com.tencent.mm.plugin.mv.ui.uic;

import android.app.Activity;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
public final class MusicMvDebugUIC$b
  implements o.f
{
  public MusicMvDebugUIC$b(MusicMvDebugUIC paramMusicMvDebugUIC) {}
  
  public final void onCreateMMMenu(m paramm)
  {
    AppMethodBeat.i(257114);
    paramm.a(1101, (CharSequence)this.Atu.getContext().getString(2131758267), 2131689842, this.Atu.getContext().getResources().getColor(2131099710), false);
    paramm.a(1102, (CharSequence)this.Atu.getContext().getString(2131758522), 2131689842, this.Atu.getContext().getResources().getColor(2131099710), false);
    paramm.a(1103, (CharSequence)this.Atu.getContext().getString(2131758709), 2131689842, this.Atu.getContext().getResources().getColor(2131099710), false);
    paramm.a(1104, (CharSequence)this.Atu.getContext().getString(2131758536), 2131689842, this.Atu.getContext().getResources().getColor(2131099710), false);
    paramm.a(1105, (CharSequence)this.Atu.getContext().getString(2131758521), 2131689842, this.Atu.getContext().getResources().getColor(2131099710), false);
    AppMethodBeat.o(257114);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.MusicMvDebugUIC.b
 * JD-Core Version:    0.7.0.1
 */