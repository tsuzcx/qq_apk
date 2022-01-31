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
    public static final CommonOptions wKs;
    
    static
    {
      CommonOptions.Builder localBuilder = new CommonOptions.Builder();
      localBuilder.dCX = "";
      localBuilder.clientVersion = "";
      localBuilder.wKU = "";
      localBuilder.wKY = "";
      localBuilder.wKZ = "";
      wKs = localBuilder.cOD();
    }
  }
  
  public static final class DefaultExpress
  {
    public static final Express wKt = new Express();
    public static final Express wKu;
    public static final Express wKv;
    
    static
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new ExpressItem(17, 1114112));
      wKt.ew(localArrayList);
      wKu = new Express();
      localArrayList = new ArrayList();
      localArrayList.add(new ExpressItem(1, 1118208));
      wKu.ew(localArrayList);
      wKv = new Express();
      localArrayList = new ArrayList();
      localArrayList.add(new ExpressItem(1, 1114112));
      wKv.ew(localArrayList);
    }
  }
  
  public static final class DefaultProcessOptions
  {
    public static final ProcessOptions wKw;
    public static final ProcessOptions wKx;
    public static final ProcessOptions wKy;
    
    static
    {
      ProcessOptions.Builder localBuilder = new ProcessOptions.Builder();
      localBuilder.wLe = ConstantsRecovery.DefaultExpress.wKt;
      localBuilder.cOE();
      wKw = localBuilder.cOF();
      localBuilder = new ProcessOptions.Builder();
      localBuilder.wLe = ConstantsRecovery.DefaultExpress.wKu;
      localBuilder.cOE();
      wKx = localBuilder.cOF();
      localBuilder = new ProcessOptions.Builder();
      localBuilder.wLe = ConstantsRecovery.DefaultExpress.wKv;
      localBuilder.cOE();
      wKy = localBuilder.cOF();
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