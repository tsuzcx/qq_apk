package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bcu
  extends cvc
{
  public String FME;
  public String FOY;
  public di Gzn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91486);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gzn == null)
      {
        paramVarArgs = new b("Not all required fields were included: Address");
        AppMethodBeat.o(91486);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FME != null) {
        paramVarArgs.d(2, this.FME);
      }
      if (this.FOY != null) {
        paramVarArgs.d(3, this.FOY);
      }
      if (this.Gzn != null)
      {
        paramVarArgs.lC(4, this.Gzn.computeSize());
        this.Gzn.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91486);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label634;
      }
    }
    label634:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FME != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FME);
      }
      i = paramInt;
      if (this.FOY != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FOY);
      }
      paramInt = i;
      if (this.Gzn != null) {
        paramInt = i + f.a.a.a.lB(4, this.Gzn.computeSize());
      }
      AppMethodBeat.o(91486);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.Gzn == null)
        {
          paramVarArgs = new b("Not all required fields were included: Address");
          AppMethodBeat.o(91486);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91486);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bcu localbcu = (bcu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91486);
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
            localbcu.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91486);
          return 0;
        case 2: 
          localbcu.FME = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91486);
          return 0;
        case 3: 
          localbcu.FOY = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91486);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new di();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((di)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbcu.Gzn = ((di)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91486);
        return 0;
      }
      AppMethodBeat.o(91486);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcu
 * JD-Core Version:    0.7.0.1
 */