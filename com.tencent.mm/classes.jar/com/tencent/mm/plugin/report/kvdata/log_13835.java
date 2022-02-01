package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
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
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.currChatName_ == null)
      {
        paramVarArgs = new b("Not all required fields were included: currChatName_");
        AppMethodBeat.o(151546);
        throw paramVarArgs;
      }
      paramVarArgs.bS(1, this.import_ds_);
      paramVarArgs.bS(2, this.ds_);
      paramVarArgs.bv(3, this.uin_);
      paramVarArgs.bS(4, this.device_);
      paramVarArgs.bS(5, this.clientVersion_);
      paramVarArgs.bv(6, this.time_stamp_);
      if (this.currChatName_ != null) {
        paramVarArgs.g(7, this.currChatName_);
      }
      paramVarArgs.e(8, 8, this.oplist_);
      AppMethodBeat.o(151546);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.import_ds_) + 0 + i.a.a.b.b.a.cJ(2, this.ds_) + i.a.a.b.b.a.q(3, this.uin_) + i.a.a.b.b.a.cJ(4, this.device_) + i.a.a.b.b.a.cJ(5, this.clientVersion_) + i.a.a.b.b.a.q(6, this.time_stamp_);
      paramInt = i;
      if (this.currChatName_ != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.currChatName_);
      }
      i = i.a.a.a.c(8, 8, this.oplist_);
      AppMethodBeat.o(151546);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.oplist_.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
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
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      log_13835 locallog_13835 = (log_13835)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(151546);
        return -1;
      case 1: 
        locallog_13835.import_ds_ = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(151546);
        return 0;
      case 2: 
        locallog_13835.ds_ = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(151546);
        return 0;
      case 3: 
        locallog_13835.uin_ = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(151546);
        return 0;
      case 4: 
        locallog_13835.device_ = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(151546);
        return 0;
      case 5: 
        locallog_13835.clientVersion_ = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(151546);
        return 0;
      case 6: 
        locallog_13835.time_stamp_ = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(151546);
        return 0;
      case 7: 
        locallog_13835.currChatName_ = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(151546);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        IMBehavior localIMBehavior = new IMBehavior();
        if ((localObject != null) && (localObject.length > 0)) {
          localIMBehavior.parseFrom((byte[])localObject);
        }
        locallog_13835.oplist_.add(localIMBehavior);
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