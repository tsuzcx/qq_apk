package com.tencent.wcdb;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class CrossProcessCursorWrapper
  extends CursorWrapper
  implements CrossProcessCursor
{
  public CrossProcessCursorWrapper(Cursor paramCursor)
  {
    super(paramCursor);
  }
  
  public void fillWindow(int paramInt, CursorWindow paramCursorWindow)
  {
    AppMethodBeat.i(2667);
    if ((this.mCursor instanceof CrossProcessCursor))
    {
      ((CrossProcessCursor)this.mCursor).fillWindow(paramInt, paramCursorWindow);
      AppMethodBeat.o(2667);
      return;
    }
    DatabaseUtils.cursorFillWindow(this.mCursor, paramInt, paramCursorWindow);
    AppMethodBeat.o(2667);
  }
  
  public CursorWindow getWindow()
  {
    AppMethodBeat.i(2668);
    if ((this.mCursor instanceof CrossProcessCursor))
    {
      CursorWindow localCursorWindow = ((CrossProcessCursor)this.mCursor).getWindow();
      AppMethodBeat.o(2668);
      return localCursorWindow;
    }
    AppMethodBeat.o(2668);
    return null;
  }
  
  public boolean onMove(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2669);
    if ((this.mCursor instanceof CrossProcessCursor))
    {
      boolean bool = ((CrossProcessCursor)this.mCursor).onMove(paramInt1, paramInt2);
      AppMethodBeat.o(2669);
      return bool;
    }
    AppMethodBeat.o(2669);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wcdb.CrossProcessCursorWrapper
 * JD-Core Version:    0.7.0.1
 */