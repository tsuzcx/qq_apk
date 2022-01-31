package com.tencent.recovery;

import com.tencent.recovery.model.RecoveryStatusItem;
import java.util.ArrayList;

public final class RecoveryContext
{
  public ArrayList<RecoveryStatusItem> wKG = new ArrayList();
  
  public final String toString()
  {
    return this.wKG.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.recovery.RecoveryContext
 * JD-Core Version:    0.7.0.1
 */