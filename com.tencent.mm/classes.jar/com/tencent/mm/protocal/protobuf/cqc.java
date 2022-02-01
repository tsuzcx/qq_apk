package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cqc
  extends ckq
{
  public long Ejn;
  public long Ejo;
  public String riG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82476);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.riG != null) {
        paramVarArgs.d(2, this.riG);
      }
      paramVarArgs.aG(3, this.Ejn);
      paramVarArgs.aG(4, this.Ejo);
      AppMethodBeat.o(82476);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label462;
      }
    }
    label462:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.riG != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.riG);
      }
      paramInt = f.a.a.b.b.a.q(3, this.Ejn);
      int j = f.a.a.b.b.a.q(4, this.Ejo);
      AppMethodBeat.o(82476);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(82476);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cqc localcqc = (cqc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82476);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcqc.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82476);
          return 0;
        case 2: 
          localcqc.riG = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(82476);
          return 0;
        case 3: 
          localcqc.Ejn = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(82476);
          return 0;
        }
        localcqc.Ejo = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(82476);
        return 0;
      }
      AppMethodBeat.o(82476);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqc
 * JD-Core Version:    0.7.0.1
 */