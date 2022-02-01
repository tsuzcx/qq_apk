package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public class log_13835
  extends com.tencent.mm.bw.a
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
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.currChatName_ == null)
      {
        paramVarArgs = new b("Not all required fields were included: currChatName_");
        AppMethodBeat.o(151546);
        throw paramVarArgs;
      }
      paramVarArgs.aM(1, this.import_ds_);
      paramVarArgs.aM(2, this.ds_);
      paramVarArgs.bb(3, this.uin_);
      paramVarArgs.aM(4, this.device_);
      paramVarArgs.aM(5, this.clientVersion_);
      paramVarArgs.bb(6, this.time_stamp_);
      if (this.currChatName_ != null) {
        paramVarArgs.e(7, this.currChatName_);
      }
      paramVarArgs.e(8, 8, this.oplist_);
      AppMethodBeat.o(151546);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.import_ds_) + 0 + g.a.a.b.b.a.bu(2, this.ds_) + g.a.a.b.b.a.r(3, this.uin_) + g.a.a.b.b.a.bu(4, this.device_) + g.a.a.b.b.a.bu(5, this.clientVersion_) + g.a.a.b.b.a.r(6, this.time_stamp_);
      paramInt = i;
      if (this.currChatName_ != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.currChatName_);
      }
      i = g.a.a.a.c(8, 8, this.oplist_);
      AppMethodBeat.o(151546);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.oplist_.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
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
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      log_13835 locallog_13835 = (log_13835)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(151546);
        return -1;
      case 1: 
        locallog_13835.import_ds_ = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(151546);
        return 0;
      case 2: 
        locallog_13835.ds_ = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(151546);
        return 0;
      case 3: 
        locallog_13835.uin_ = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(151546);
        return 0;
      case 4: 
        locallog_13835.device_ = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(151546);
        return 0;
      case 5: 
        locallog_13835.clientVersion_ = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(151546);
        return 0;
      case 6: 
        locallog_13835.time_stamp_ = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(151546);
        return 0;
      case 7: 
        locallog_13835.currChatName_ = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(151546);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new IMBehavior();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((IMBehavior)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
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