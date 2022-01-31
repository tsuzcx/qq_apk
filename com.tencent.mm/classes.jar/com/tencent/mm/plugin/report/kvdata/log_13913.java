package com.tencent.mm.plugin.report.kvdata;

public class log_13913
  extends com.tencent.mm.bv.a
{
  public int clientVersion_;
  public int device_;
  public int ds_;
  public String error_;
  public int import_ds_;
  public int scene_;
  public long time_stamp_;
  public long uin_;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.import_ds_);
      paramVarArgs.gB(2, this.ds_);
      paramVarArgs.Y(3, this.uin_);
      paramVarArgs.gB(4, this.device_);
      paramVarArgs.gB(5, this.clientVersion_);
      paramVarArgs.Y(6, this.time_stamp_);
      paramVarArgs.gB(7, this.scene_);
      if (this.error_ != null) {
        paramVarArgs.d(8, this.error_);
      }
      paramInt = 0;
    }
    int i;
    do
    {
      return paramInt;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.a.gy(1, this.import_ds_) + 0 + d.a.a.a.gy(2, this.ds_) + d.a.a.a.X(3, this.uin_) + d.a.a.a.gy(4, this.device_) + d.a.a.a.gy(5, this.clientVersion_) + d.a.a.a.X(6, this.time_stamp_) + d.a.a.a.gy(7, this.scene_);
      paramInt = i;
    } while (this.error_ == null);
    return i + d.a.a.b.b.a.e(8, this.error_);
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      return 0;
    }
    if (paramInt == 3)
    {
      d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
      log_13913 locallog_13913 = (log_13913)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        locallog_13913.import_ds_ = locala.xpH.oD();
        return 0;
      case 2: 
        locallog_13913.ds_ = locala.xpH.oD();
        return 0;
      case 3: 
        locallog_13913.uin_ = locala.xpH.oE();
        return 0;
      case 4: 
        locallog_13913.device_ = locala.xpH.oD();
        return 0;
      case 5: 
        locallog_13913.clientVersion_ = locala.xpH.oD();
        return 0;
      case 6: 
        locallog_13913.time_stamp_ = locala.xpH.oE();
        return 0;
      case 7: 
        locallog_13913.scene_ = locala.xpH.oD();
        return 0;
      }
      locallog_13913.error_ = locala.xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.report.kvdata.log_13913
 * JD-Core Version:    0.7.0.1
 */