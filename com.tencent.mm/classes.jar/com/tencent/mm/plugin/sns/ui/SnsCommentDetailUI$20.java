package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.ui.widget.SnsAvatarImageView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;

final class SnsCommentDetailUI$20
  implements f.a
{
  SnsCommentDetailUI$20(SnsCommentDetailUI paramSnsCommentDetailUI, SnsAvatarImageView paramSnsAvatarImageView) {}
  
  public final void abi(String paramString)
  {
    AppMethodBeat.i(38800);
    ab.i("MicroMsg.SnsCommentDetailUI", "download img %s", new Object[] { paramString });
    if ((!bo.Q(new String[] { (String)this.rPw.getTag(2131820667), paramString })) && (paramString.equals(h.gy("adId", (String)this.rPw.getTag(2131820667)))))
    {
      paramString = d.decodeFile(paramString, null);
      if (paramString != null) {
        this.rPw.setImageBitmap(paramString);
      }
    }
    AppMethodBeat.o(38800);
  }
  
  public final void coe() {}
  
  public final void cqU() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.20
 * JD-Core Version:    0.7.0.1
 */