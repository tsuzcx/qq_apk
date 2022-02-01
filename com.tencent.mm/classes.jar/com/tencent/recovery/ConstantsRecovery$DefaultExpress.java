package com.tencent.recovery;

import com.tencent.recovery.config.Express;
import com.tencent.recovery.config.ExpressItem;
import java.util.ArrayList;
import java.util.List;

public final class ConstantsRecovery$DefaultExpress
{
  public static final Express Background = new Express();
  public static final Express Foreground;
  public static final Express ForegroundCrash;
  
  static
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new ExpressItem(17, 17, 1114112, 3));
    Background.addCondition(localArrayList);
    Foreground = new Express();
    localArrayList = new ArrayList();
    localArrayList.add(new ExpressItem(1, 17, 1118208, 3));
    Foreground.addCondition(localArrayList);
    ForegroundCrash = new Express();
    localArrayList = new ArrayList();
    localArrayList.add(new ExpressItem(1, 17, 1114112, 3));
    ForegroundCrash.addCondition(localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.recovery.ConstantsRecovery.DefaultExpress
 * JD-Core Version:    0.7.0.1
 */