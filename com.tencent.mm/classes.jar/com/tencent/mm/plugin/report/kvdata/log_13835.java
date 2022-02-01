package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public class log_13835
  extends com.tencent.mm.cd.a
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
      paramVarArgs.aY(1, this.import_ds_);
      paramVarArgs.aY(2, this.ds_);
      paramVarArgs.bm(3, this.uin_);
      paramVarArgs.aY(4, this.device_);
      paramVarArgs.aY(5, this.clientVersion_);
      paramVarArgs.bm(6, this.time_stamp_);
      if (this.currChatName_ != null) {
        paramVarArgs.f(7, this.currChatName_);
      }
      paramVarArgs.e(8, 8, this.oplist_);
      AppMethodBeat.o(151546);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.import_ds_) + 0 + g.a.a.b.b.a.bM(2, this.ds_) + g.a.a.b.b.a.p(3, this.uin_) + g.a.a.b.b.a.bM(4, this.device_) + g.a.a.b.b.a.bM(5, this.clientVersion_) + g.a.a.b.b.a.p(6, this.time_stamp_);
      paramInt = i;
      if (this.currChatName_ != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.currChatName_);
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
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
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
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      log_13835 locallog_13835 = (log_13835)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(151546);
        return -1;
      case 1: 
        locallog_13835.import_ds_ = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(151546);
        return 0;
      case 2: 
        locallog_13835.ds_ = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(151546);
        return 0;
      case 3: 
        locallog_13835.uin_ = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(151546);
        return 0;
      case 4: 
        locallog_13835.device_ = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(151546);
        return 0;
      case 5: 
        locallog_13835.clientVersion_ = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(151546);
        return 0;
      case 6: 
        locallog_13835.time_stamp_ = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(151546);
        return 0;
      case 7: 
        locallog_13835.currChatName_ = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(151546);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
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