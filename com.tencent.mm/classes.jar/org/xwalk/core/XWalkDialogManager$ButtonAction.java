package org.xwalk.core;

class XWalkDialogManager$ButtonAction
{
  Runnable mClickAction;
  boolean mMandatory;
  int mWhich;
  
  XWalkDialogManager$ButtonAction(int paramInt, Runnable paramRunnable, boolean paramBoolean)
  {
    this.mWhich = paramInt;
    this.mClickAction = paramRunnable;
    this.mMandatory = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     org.xwalk.core.XWalkDialogManager.ButtonAction
 * JD-Core Version:    0.7.0.1
 */