package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public class log_13835
  extends com.tencent.mm.bx.a
{
  public int clientVersion_;
  public String currChatName_;
  public int device_;
  public int ds_;
  public int import_ds_;
  public LinkedList<IMBehavior> oplist_;
  public long time_stamp_;
  public long uin_;
  
  public log_13835()
  {
    AppMethodBeat.i(151545);
    this.oplist_ = new LinkedList();
    AppMethodBeat.o(151545);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(151546);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.currChatName_ == null)
      {
        paramVarArgs = new b("Not all required fields were included: currChatName_");
        AppMethodBeat.o(151546);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.import_ds_);
      paramVarArgs.aR(2, this.ds_);
      paramVarArgs.aG(3, this.uin_);
      paramVarArgs.aR(4, this.device_);
      paramVarArgs.aR(5, this.clientVersion_);
      paramVarArgs.aG(6, this.time_stamp_);
      if (this.currChatName_ != null) {
        paramVarArgs.d(7, this.currChatName_);
      }
      paramVarArgs.e(8, 8, this.oplist_);
      AppMethodBeat.o(151546);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.import_ds_) + 0 + f.a.a.b.b.a.bA(2, this.ds_) + f.a.a.b.b.a.q(3, this.uin_) + f.a.a.b.b.a.bA(4, this.device_) + f.a.a.b.b.a.bA(5, this.clientVersion_) + f.a.a.b.b.a.q(6, this.time_stamp_);
      paramInt = i;
      if (this.currChatName_ != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.currChatName_);
      }
      i = f.a.a.a.c(8, 8, this.oplist_);
      AppMethodBeat.o(151546);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.oplist_.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      if (this.currChatName_ == null)
      {
        paramVarArgs = new b("Not all required fields were included: currChatName_");
        AppMethodBeat.o(151546);
        throw paramVarArgs;
      }
      AppMethodBeat.o(151546);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      log_13835 locallog_13835 = (log_13835)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(151546);
        return -1;
      case 1: 
        locallog_13835.import_ds_ = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(151546);
        return 0;
      case 2: 
        locallog_13835.ds_ = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(151546);
        return 0;
      case 3: 
        locallog_13835.uin_ = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(151546);
        return 0;
      case 4: 
        locallog_13835.device_ = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(151546);
        return 0;
      case 5: 
        locallog_13835.clientVersion_ = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(151546);
        return 0;
      case 6: 
        locallog_13835.time_stamp_ = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(151546);
        return 0;
      case 7: 
        locallog_13835.currChatName_ = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(151546);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new IMBehavior();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((IMBehavior)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        locallog_13835.oplist_.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(151546);
      return 0;
    }
    AppMethodBeat.o(151546);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.report.kvdata.log_13835
 * JD-Core Version:    0.7.0.1
 */