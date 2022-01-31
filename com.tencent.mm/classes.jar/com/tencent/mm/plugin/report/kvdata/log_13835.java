package com.tencent.mm.plugin.report.kvdata;

import d.a.a.b;
import java.util.LinkedList;

public class log_13835
  extends com.tencent.mm.bv.a
{
  public int clientVersion_;
  public String currChatName_;
  public int device_;
  public int ds_;
  public int import_ds_;
  public LinkedList<IMBehavior> oplist_ = new LinkedList();
  public long time_stamp_;
  public long uin_;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.currChatName_ == null) {
        throw new b("Not all required fields were included: currChatName_");
      }
      paramVarArgs.gB(1, this.import_ds_);
      paramVarArgs.gB(2, this.ds_);
      paramVarArgs.Y(3, this.uin_);
      paramVarArgs.gB(4, this.device_);
      paramVarArgs.gB(5, this.clientVersion_);
      paramVarArgs.Y(6, this.time_stamp_);
      if (this.currChatName_ != null) {
        paramVarArgs.d(7, this.currChatName_);
      }
      paramVarArgs.d(8, 8, this.oplist_);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = d.a.a.a.gy(1, this.import_ds_) + 0 + d.a.a.a.gy(2, this.ds_) + d.a.a.a.X(3, this.uin_) + d.a.a.a.gy(4, this.device_) + d.a.a.a.gy(5, this.clientVersion_) + d.a.a.a.X(6, this.time_stamp_);
      paramInt = i;
      if (this.currChatName_ != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.currChatName_);
      }
      return paramInt + d.a.a.a.c(8, 8, this.oplist_);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.oplist_.clear();
      paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      if (this.currChatName_ == null) {
        throw new b("Not all required fields were included: currChatName_");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
      log_13835 locallog_13835 = (log_13835)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        locallog_13835.import_ds_ = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        locallog_13835.ds_ = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 3: 
        locallog_13835.uin_ = ((d.a.a.a.a)localObject1).xpH.oE();
        return 0;
      case 4: 
        locallog_13835.device_ = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 5: 
        locallog_13835.clientVersion_ = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 6: 
        locallog_13835.time_stamp_ = ((d.a.a.a.a)localObject1).xpH.oE();
        return 0;
      case 7: 
        locallog_13835.currChatName_ = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new IMBehavior();
        localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((IMBehavior)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
        locallog_13835.oplist_.add(localObject1);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.report.kvdata.log_13835
 * JD-Core Version:    0.7.0.1
 */