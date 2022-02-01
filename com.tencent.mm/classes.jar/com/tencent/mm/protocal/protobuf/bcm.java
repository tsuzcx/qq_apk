package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bcm
  extends cvc
{
  public String FqI;
  public aep FqZ;
  public String tmO;
  public String tmP;
  public String tmQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32243);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.tmO != null) {
        paramVarArgs.d(2, this.tmO);
      }
      if (this.tmP != null) {
        paramVarArgs.d(3, this.tmP);
      }
      if (this.tmQ != null) {
        paramVarArgs.d(4, this.tmQ);
      }
      if (this.FqI != null) {
        paramVarArgs.d(5, this.FqI);
      }
      if (this.FqZ != null)
      {
        paramVarArgs.lC(6, this.FqZ.computeSize());
        this.FqZ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32243);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label718;
      }
    }
    label718:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tmO != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.tmO);
      }
      i = paramInt;
      if (this.tmP != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.tmP);
      }
      paramInt = i;
      if (this.tmQ != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.tmQ);
      }
      i = paramInt;
      if (this.FqI != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FqI);
      }
      paramInt = i;
      if (this.FqZ != null) {
        paramInt = i + f.a.a.a.lB(6, this.FqZ.computeSize());
      }
      AppMethodBeat.o(32243);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(32243);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bcm localbcm = (bcm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32243);
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
            localbcm.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32243);
          return 0;
        case 2: 
          localbcm.tmO = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32243);
          return 0;
        case 3: 
          localbcm.tmP = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32243);
          return 0;
        case 4: 
          localbcm.tmQ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32243);
          return 0;
        case 5: 
          localbcm.FqI = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32243);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aep();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aep)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbcm.FqZ = ((aep)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32243);
        return 0;
      }
      AppMethodBeat.o(32243);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcm
 * JD-Core Version:    0.7.0.1
 */