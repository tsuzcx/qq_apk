package com.tencent.recovery.config;

public class ExpressItem
{
  private int count;
  private int processStage;
  private int processStartFlag;
  private int processStatus;
  
  public ExpressItem(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.processStartFlag = paramInt1;
    this.processStage = paramInt2;
    this.processStatus = paramInt3;
    this.count = paramInt4;
  }
  
  public int getCount()
  {
    return this.count;
  }
  
  public int getProcessStage()
  {
    return this.processStage;
  }
  
  public int getProcessStartFlag()
  {
    return this.processStartFlag;
  }
  
  public int getProcessStatus()
  {
    return this.processStatus;
  }
  
  public void setCount(int paramInt)
  {
    this.count = paramInt;
  }
  
  public void setProcessStage(int paramInt)
  {
    this.processStage = paramInt;
  }
  
  public void setProcessStartFlag(int paramInt)
  {
    this.processStartFlag = paramInt;
  }
  
  public void setProcessStatus(int paramInt)
  {
    this.processStatus = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.recovery.config.ExpressItem
 * JD-Core Version:    0.7.0.1
 */