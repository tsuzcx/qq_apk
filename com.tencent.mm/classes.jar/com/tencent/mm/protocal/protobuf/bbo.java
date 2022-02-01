package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bbo
  extends cvc
{
  public String FqV;
  public qu GyA;
  public String Gyy;
  public String Gyz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114787);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gyy == null)
      {
        paramVarArgs = new b("Not all required fields were included: FunctionMsgID");
        AppMethodBeat.o(114787);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Gyy != null) {
        paramVarArgs.d(2, this.Gyy);
      }
      if (this.Gyz != null) {
        paramVarArgs.d(3, this.Gyz);
      }
      if (this.FqV != null) {
        paramVarArgs.d(4, this.FqV);
      }
      if (this.GyA != null)
      {
        paramVarArgs.lC(5, this.GyA.computeSize());
        this.GyA.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(114787);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label694;
      }
    }
    label694:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Gyy != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Gyy);
      }
      i = paramInt;
      if (this.Gyz != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Gyz);
      }
      paramInt = i;
      if (this.FqV != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FqV);
      }
      i = paramInt;
      if (this.GyA != null) {
        i = paramInt + f.a.a.a.lB(5, this.GyA.computeSize());
      }
      AppMethodBeat.o(114787);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.Gyy == null)
        {
          paramVarArgs = new b("Not all required fields were included: FunctionMsgID");
          AppMethodBeat.o(114787);
          throw paramVarArgs;
        }
        AppMethodBeat.o(114787);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bbo localbbo = (bbo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114787);
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
            localbbo.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114787);
          return 0;
        case 2: 
          localbbo.Gyy = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(114787);
          return 0;
        case 3: 
          localbbo.Gyz = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(114787);
          return 0;
        case 4: 
          localbbo.FqV = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(114787);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new qu();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((qu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbbo.GyA = ((qu)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(114787);
        return 0;
      }
      AppMethodBeat.o(114787);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbo
 * JD-Core Version:    0.7.0.1
 */