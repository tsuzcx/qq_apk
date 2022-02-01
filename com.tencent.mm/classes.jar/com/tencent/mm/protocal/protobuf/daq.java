package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class daq
  extends cvc
{
  public int GUo;
  public int HqH;
  public LinkedList<eaj> HqI;
  public int HqJ;
  
  public daq()
  {
    AppMethodBeat.i(32431);
    this.HqI = new LinkedList();
    AppMethodBeat.o(32431);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32432);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.GUo);
      paramVarArgs.aS(3, this.HqH);
      paramVarArgs.e(4, 8, this.HqI);
      paramVarArgs.aS(5, this.HqJ);
      AppMethodBeat.o(32432);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label601;
      }
    }
    label601:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.GUo);
      int j = f.a.a.b.b.a.bz(3, this.HqH);
      int k = f.a.a.a.c(4, 8, this.HqI);
      int m = f.a.a.b.b.a.bz(5, this.HqJ);
      AppMethodBeat.o(32432);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HqI.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(32432);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        daq localdaq = (daq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32432);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdaq.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32432);
          return 0;
        case 2: 
          localdaq.GUo = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32432);
          return 0;
        case 3: 
          localdaq.HqH = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32432);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eaj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eaj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdaq.HqI.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32432);
          return 0;
        }
        localdaq.HqJ = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(32432);
        return 0;
      }
      AppMethodBeat.o(32432);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.daq
 * JD-Core Version:    0.7.0.1
 */