package com.tencent.recovery;

import com.tencent.recovery.config.Express;
import com.tencent.recovery.config.ExpressItem;
import com.tencent.recovery.option.CommonOptions;
import com.tencent.recovery.option.CommonOptions.Builder;
import com.tencent.recovery.option.ProcessOptions;
import com.tencent.recovery.option.ProcessOptions.Builder;
import java.util.ArrayList;
import java.util.List;

public class ConstantsRecovery
{
  public static final class DefaultCommonOptions
  {
    public static final CommonOptions BhT;
    
    static
    {
      CommonOptions.Builder localBuilder = new CommonOptions.Builder();
      localBuilder.eAx = "";
      localBuilder.clientVersion = "";
      localBuilder.Biu = "";
      localBuilder.Bix = "";
      localBuilder.Biy = "";
      BhT = localBuilder.dUs();
    }
  }
  
  public static final class DefaultExpress
  {
    public static final Express BhU = new Express();
    public static final Express BhV;
    public static final Express BhW;
    
    static
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new ExpressItem(17, 1114112));
      BhU.fI(localArrayList);
      BhV = new Express();
      localArrayList = new ArrayList();
      localArrayList.add(new ExpressItem(1, 1118208));
      BhV.fI(localArrayList);
      BhW = new Express();
      localArrayList = new ArrayList();
      localArrayList.add(new ExpressItem(1, 1114112));
      BhW.fI(localArrayList);
    }
  }
  
  public static final class DefaultProcessOptions
  {
    public static final ProcessOptions BhX;
    public static final ProcessOptions BhY;
    public static final ProcessOptions BhZ;
    
    static
    {
      ProcessOptions.Builder localBuilder = new ProcessOptions.Builder();
      localBuilder.BiD = ConstantsRecovery.DefaultExpress.BhU;
      localBuilder.dUt();
      BhX = localBuilder.dUu();
      localBuilder = new ProcessOptions.Builder();
      localBuilder.BiD = ConstantsRecovery.DefaultExpress.BhV;
      localBuilder.dUt();
      BhY = localBuilder.dUu();
      localBuilder = new ProcessOptions.Builder();
      localBuilder.BiD = ConstantsRecovery.DefaultExpress.BhW;
      localBuilder.dUt();
      BhZ = localBuilder.dUu();
    }
  }
  
  public static final class IntentAction {}
  
  public static final class IntentKeys {}
  
  public static final class Message {}
  
  public static final class ProcessStage {}
  
  public static final class ProcessStartFlag {}
  
  public static final class ProcessStatus {}
  
  public static final class ReportType {}
  
  public static final class SpKeys {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.recovery.ConstantsRecovery
 * JD-Core Version:    0.7.0.1
 */