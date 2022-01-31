package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.mm.api.d;
import com.tencent.mm.api.p;
import com.tencent.mm.sdk.platformtools.y;

final class TestVideoEditUI$1
  implements p
{
  TestVideoEditUI$1(TestVideoEditUI paramTestVideoEditUI) {}
  
  public final void a(d paramd)
  {
    y.i("MicroMsg.TestVideoEditUI", "[onSelectedFeature] features:%s", new Object[] { paramd.name() });
  }
  
  public final void a(d paramd, int paramInt)
  {
    y.i("MicroMsg.TestVideoEditUI", "[onSelectedDetailFeature] features:%s index:%s", new Object[] { paramd.name(), Integer.valueOf(paramInt) });
  }
  
  public final void aL(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mqV.showVKB();
      return;
    }
    this.mqV.hideVKB(TestVideoEditUI.a(this.mqV));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.TestVideoEditUI.1
 * JD-Core Version:    0.7.0.1
 */