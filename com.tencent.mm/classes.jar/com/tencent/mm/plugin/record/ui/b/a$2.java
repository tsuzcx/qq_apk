package com.tencent.mm.plugin.record.ui.b;

import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.g.a.gi;
import com.tencent.mm.g.a.gi.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.record.ui.a.b;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.b.d;

final class a$2
  implements View.OnLongClickListener
{
  private Context context;
  private g muk;
  private String path;
  private b qah;
  private aca qai;
  
  a$2(a parama) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(24339);
    if (paramView != null)
    {
      this.context = paramView.getContext();
      this.qah = ((b)paramView.getTag());
      this.muk = this.qah.mCk;
      this.qai = this.qah.cuL;
    }
    paramView = new gi();
    paramView.cuX.type = 2;
    paramView.cuX.cuZ = this.qah.cuL;
    com.tencent.mm.sdk.b.a.ymk.l(paramView);
    this.path = paramView.cuY.path;
    if (!e.cN(this.path))
    {
      ab.w("MicroMsg.ImageViewWrapper", "file not exists");
      AppMethodBeat.o(24339);
      return true;
    }
    if (this.qag.mAF == null) {
      this.qag.mAF = new d(this.context, 1, false);
    }
    this.qag.mAF.sao = new a.2.1(this);
    this.qag.mAF.sap = new a.2.2(this);
    this.qag.mAF.AGQ = new a.2.3(this);
    this.qag.mAF.crd();
    AppMethodBeat.o(24339);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.b.a.2
 * JD-Core Version:    0.7.0.1
 */