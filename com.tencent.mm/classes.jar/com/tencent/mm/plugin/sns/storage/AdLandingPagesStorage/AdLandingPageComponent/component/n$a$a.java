package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.text.TextUtils;
import android.widget.Button;
import com.tencent.mm.plugin.sns.ui.widget.SnsTextProgressBar;

final class n$a$a
  extends com.tencent.mm.sdk.d.b
{
  n$a$a(n.a parama) {}
  
  public final void enter()
  {
    super.enter();
    this.oGp.oGd.oFY.setVisibility(8);
    this.oGp.oGd.oFX.setEnabled(false);
    Button localButton = this.oGp.oGd.oFX;
    if (!TextUtils.isEmpty(n.b(this.oGp.oGd).oCh)) {}
    for (String str = n.b(this.oGp.oGd).oCh;; str = "暂不支持安卓手机")
    {
      localButton.setText(str);
      this.oGp.oGd.oFX.setVisibility(0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n.a.a
 * JD-Core Version:    0.7.0.1
 */