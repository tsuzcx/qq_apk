package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public class log_13835
  extends com.tencent.mm.bv.a
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
    AppMethodBeat.i(79159);
    this.oplist_ = new LinkedList();
    AppMethodBeat.o(79159);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(79160);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.currChatName_ == null)
      {
        paramVarArgs = new b("Not all required fields were included: currChatName_");
        AppMethodBeat.o(79160);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.import_ds_);
      paramVarArgs.aO(2, this.ds_);
      paramVarArgs.am(3, this.uin_);
      paramVarArgs.aO(4, this.device_);
      paramVarArgs.aO(5, this.clientVersion_);
      paramVarArgs.am(6, this.time_stamp_);
      if (this.currChatName_ != null) {
        paramVarArgs.e(7, this.currChatName_);
      }
      paramVarArgs.e(8, 8, this.oplist_);
      AppMethodBeat.o(79160);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.import_ds_) + 0 + e.a.a.b.b.a.bl(2, this.ds_) + e.a.a.b.b.a.p(3, this.uin_) + e.a.a.b.b.a.bl(4, this.device_) + e.a.a.b.b.a.bl(5, this.clientVersion_) + e.a.a.b.b.a.p(6, this.time_stamp_);
      paramInt = i;
      if (this.currChatName_ != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.currChatName_);
      }
      i = e.a.a.a.c(8, 8, this.oplist_);
      AppMethodBeat.o(79160);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.oplist_.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      if (this.currChatName_ == null)
      {
        paramVarArgs = new b("Not all required fields were included: currChatName_");
        AppMethodBeat.o(79160);
        throw paramVarArgs;
      }
      AppMethodBeat.o(79160);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      log_13835 locallog_13835 = (log_13835)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(79160);
        return -1;
      case 1: 
        locallog_13835.import_ds_ = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(79160);
        return 0;
      case 2: 
        locallog_13835.ds_ = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(79160);
        return 0;
      case 3: 
        locallog_13835.uin_ = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(79160);
        return 0;
      case 4: 
        locallog_13835.device_ = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(79160);
        return 0;
      case 5: 
        locallog_13835.clientVersion_ = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(79160);
        return 0;
      case 6: 
        locallog_13835.time_stamp_ = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(79160);
        return 0;
      case 7: 
        locallog_13835.currChatName_ = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(79160);
        return 0;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new IMBehavior();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((IMBehavior)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        locallog_13835.oplist_.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(79160);
      return 0;
    }
    AppMethodBeat.o(79160);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.report.kvdata.log_13835
 * JD-Core Version:    0.7.0.1
 */