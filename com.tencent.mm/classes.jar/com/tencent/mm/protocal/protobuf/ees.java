package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ees
  extends cvp
{
  public int FMu;
  public String GDb;
  public int HPG;
  public int Hmw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117956);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GDb == null)
      {
        paramVarArgs = new b("Not all required fields were included: Json");
        AppMethodBeat.o(117956);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.HPG);
      paramVarArgs.aS(3, this.FMu);
      if (this.GDb != null) {
        paramVarArgs.d(4, this.GDb);
      }
      paramVarArgs.aS(5, this.Hmw);
      AppMethodBeat.o(117956);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label550;
      }
    }
    label550:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.HPG) + f.a.a.b.b.a.bz(3, this.FMu);
      paramInt = i;
      if (this.GDb != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GDb);
      }
      i = f.a.a.b.b.a.bz(5, this.Hmw);
      AppMethodBeat.o(117956);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.GDb == null)
        {
          paramVarArgs = new b("Not all required fields were included: Json");
          AppMethodBeat.o(117956);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117956);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ees localees = (ees)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117956);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localees.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117956);
          return 0;
        case 2: 
          localees.HPG = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(117956);
          return 0;
        case 3: 
          localees.FMu = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(117956);
          return 0;
        case 4: 
          localees.GDb = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(117956);
          return 0;
        }
        localees.Hmw = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(117956);
        return 0;
      }
      AppMethodBeat.o(117956);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ees
 * JD-Core Version:    0.7.0.1
 */