package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cvz
  extends ckq
{
  public long Enw;
  public int OpCode;
  public String scP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125824);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.OpCode);
      paramVarArgs.aG(3, this.Enw);
      if (this.scP != null) {
        paramVarArgs.d(4, this.scP);
      }
      AppMethodBeat.o(125824);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label458;
      }
    }
    label458:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.OpCode) + f.a.a.b.b.a.q(3, this.Enw);
      paramInt = i;
      if (this.scP != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.scP);
      }
      AppMethodBeat.o(125824);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(125824);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cvz localcvz = (cvz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125824);
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
            localcvz.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125824);
          return 0;
        case 2: 
          localcvz.OpCode = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125824);
          return 0;
        case 3: 
          localcvz.Enw = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(125824);
          return 0;
        }
        localcvz.scP = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(125824);
        return 0;
      }
      AppMethodBeat.o(125824);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvz
 * JD-Core Version:    0.7.0.1
 */