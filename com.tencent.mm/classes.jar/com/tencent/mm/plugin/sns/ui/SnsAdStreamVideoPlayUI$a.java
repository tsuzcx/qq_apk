package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdStreamVideoView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;

final class SnsAdStreamVideoPlayUI$a
  implements b.b
{
  private String cBO;
  
  public SnsAdStreamVideoPlayUI$a(SnsAdStreamVideoPlayUI paramSnsAdStreamVideoPlayUI, String paramString)
  {
    this.cBO = paramString;
  }
  
  public final void ZU(String paramString) {}
  
  public final void bp(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(145509);
    if ((!bo.Q(new String[] { paramString, this.cBO })) && (paramString.equals(this.cBO)))
    {
      ab.i("MicroMsg.SnsAdStreamVideoPlayUI", "download image finish %s", new Object[] { paramString });
      paramString = d.decodeFile(SnsAdStreamVideoPlayUI.a(this.rNK), null);
      if (paramString != null) {
        SnsAdStreamVideoPlayUI.b(this.rNK).setCover(paramString);
      }
    }
    AppMethodBeat.o(145509);
  }
  
  public final void bq(String paramString, boolean paramBoolean) {}
  
  public final void cnV() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdStreamVideoPlayUI.a
 * JD-Core Version:    0.7.0.1
 */