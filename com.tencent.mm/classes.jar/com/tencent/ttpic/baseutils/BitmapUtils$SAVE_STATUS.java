package com.tencent.ttpic.baseutils;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum BitmapUtils$SAVE_STATUS
{
  static
  {
    AppMethodBeat.i(49597);
    SAVE_SUCCESS = new SAVE_STATUS("SAVE_SUCCESS", 0);
    SAVE_FAILED = new SAVE_STATUS("SAVE_FAILED", 1);
    SAVE_OOM = new SAVE_STATUS("SAVE_OOM", 2);
    SAVE_NULL = new SAVE_STATUS("SAVE_NULL", 3);
    SAVE_CHANGE_DIR = new SAVE_STATUS("SAVE_CHANGE_DIR", 4);
    $VALUES = new SAVE_STATUS[] { SAVE_SUCCESS, SAVE_FAILED, SAVE_OOM, SAVE_NULL, SAVE_CHANGE_DIR };
    AppMethodBeat.o(49597);
  }
  
  private BitmapUtils$SAVE_STATUS() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.BitmapUtils.SAVE_STATUS
 * JD-Core Version:    0.7.0.1
 */