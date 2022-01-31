package com.tencent.mm.plugin.sns.ui;

import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.ay;
import com.tencent.mm.sdk.g.b.a;
import com.tencent.mm.ui.MMActivity;
import java.util.List;

final class ag$a
  extends com.tencent.mm.plugin.sns.model.h<String, Integer, Boolean>
{
  private ProgressDialog eeN;
  private ay rIM;
  private List<com.tencent.mm.plugin.sns.data.h> rKe;
  
  public ag$a(ay paramay, List<com.tencent.mm.plugin.sns.data.h> paramList)
  {
    AppMethodBeat.i(38484);
    this.eeN = null;
    this.rIM = paramList;
    Object localObject;
    this.rKe = localObject;
    paramList = paramay.cmc;
    paramay.cmc.getString(2131297087);
    this.eeN = com.tencent.mm.ui.base.h.b(paramList, paramay.cmc.getString(2131296988), false, new ag.a.1(this, paramay));
    AppMethodBeat.o(38484);
  }
  
  public final a cjN()
  {
    AppMethodBeat.i(38485);
    a locala = com.tencent.mm.plugin.sns.model.ag.coS();
    AppMethodBeat.o(38485);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ag.a
 * JD-Core Version:    0.7.0.1
 */