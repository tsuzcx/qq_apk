package com.tencent.mm.plugin.sns.ui;

import android.widget.Gallery;
import com.tencent.mm.plugin.sns.g.b;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.ui.base.MultiTouchImageView.a;

final class SnsInfoFlip$6
  implements MultiTouchImageView.a
{
  SnsInfoFlip$6(SnsInfoFlip paramSnsInfoFlip) {}
  
  public final void bIU()
  {
    if ((SnsInfoFlip.g(this.oZi).getSelectedItem() == null) || (SnsInfoFlip.d(this.oZi) == null)) {}
    int i;
    Object localObject;
    do
    {
      return;
      i = SnsInfoFlip.g(this.oZi).getSelectedItemPosition();
      localObject = ((b)SnsInfoFlip.g(this.oZi).getSelectedItem()).owP;
      localObject = af.bDF().OB((String)localObject);
    } while (localObject == null);
    aw.d((n)localObject, i);
  }
  
  public final void bIV()
  {
    if ((SnsInfoFlip.g(this.oZi).getSelectedItem() == null) || (SnsInfoFlip.d(this.oZi) == null)) {}
    int i;
    Object localObject;
    do
    {
      return;
      i = SnsInfoFlip.g(this.oZi).getSelectedItemPosition();
      localObject = ((b)SnsInfoFlip.g(this.oZi).getSelectedItem()).owP;
      localObject = af.bDF().OB((String)localObject);
    } while (localObject == null);
    aw.e((n)localObject, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsInfoFlip.6
 * JD-Core Version:    0.7.0.1
 */