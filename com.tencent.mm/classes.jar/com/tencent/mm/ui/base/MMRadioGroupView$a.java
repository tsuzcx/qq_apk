package com.tencent.mm.ui.base;

final class MMRadioGroupView$a
  implements MMRadioImageButton.a
{
  MMRadioGroupView$a(MMRadioGroupView paramMMRadioGroupView) {}
  
  public final void a(MMRadioImageButton paramMMRadioImageButton)
  {
    if (MMRadioGroupView.a(this.uXE) != -1) {
      MMRadioGroupView.a(this.uXE, MMRadioGroupView.a(this.uXE));
    }
    int i = paramMMRadioImageButton.getId();
    MMRadioGroupView.a(this.uXE, paramMMRadioImageButton);
    MMRadioGroupView.b(this.uXE, i);
  }
  
  public final void b(MMRadioImageButton paramMMRadioImageButton)
  {
    MMRadioGroupView.c(this.uXE, paramMMRadioImageButton.getId());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMRadioGroupView.a
 * JD-Core Version:    0.7.0.1
 */