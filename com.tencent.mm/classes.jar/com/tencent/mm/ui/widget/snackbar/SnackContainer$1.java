package com.tencent.mm.ui.widget.snackbar;

final class SnackContainer$1
  implements Runnable
{
  SnackContainer$1(SnackContainer paramSnackContainer) {}
  
  public final void run()
  {
    if (this.wqa.getVisibility() == 0) {
      this.wqa.startAnimation(SnackContainer.a(this.wqa));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.snackbar.SnackContainer.1
 * JD-Core Version:    0.7.0.1
 */