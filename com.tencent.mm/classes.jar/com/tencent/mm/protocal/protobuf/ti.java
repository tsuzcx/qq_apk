package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ti
  extends com.tencent.mm.bx.a
{
  public int FQR;
  public String FQS;
  public String FQT;
  public String FQU;
  public int FQV;
  public String FQW;
  public tg FQX;
  public String FQY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113967);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FQR);
      if (this.FQS != null) {
        paramVarArgs.d(2, this.FQS);
      }
      if (this.FQT != null) {
        paramVarArgs.d(3, this.FQT);
      }
      if (this.FQU != null) {
        paramVarArgs.d(4, this.FQU);
      }
      paramVarArgs.aS(5, this.FQV);
      if (this.FQW != null) {
        paramVarArgs.d(6, this.FQW);
      }
      if (this.FQX != null)
      {
        paramVarArgs.lC(7, this.FQX.computeSize());
        this.FQX.writeFields(paramVarArgs);
      }
      if (this.FQY != null) {
        paramVarArgs.d(8, this.FQY);
      }
      AppMethodBeat.o(113967);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.FQR) + 0;
      paramInt = i;
      if (this.FQS != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FQS);
      }
      i = paramInt;
      if (this.FQT != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FQT);
      }
      paramInt = i;
      if (this.FQU != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FQU);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.FQV);
      paramInt = i;
      if (this.FQW != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FQW);
      }
      i = paramInt;
      if (this.FQX != null) {
        i = paramInt + f.a.a.a.lB(7, this.FQX.computeSize());
      }
      paramInt = i;
      if (this.FQY != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FQY);
      }
      AppMethodBeat.o(113967);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(113967);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ti localti = (ti)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(113967);
        return -1;
      case 1: 
        localti.FQR = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(113967);
        return 0;
      case 2: 
        localti.FQS = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(113967);
        return 0;
      case 3: 
        localti.FQT = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(113967);
        return 0;
      case 4: 
        localti.FQU = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(113967);
        return 0;
      case 5: 
        localti.FQV = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(113967);
        return 0;
      case 6: 
        localti.FQW = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(113967);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new tg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((tg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localti.FQX = ((tg)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113967);
        return 0;
      }
      localti.FQY = ((f.a.a.a.a)localObject1).NPN.readString();
      AppMethodBeat.o(113967);
      return 0;
    }
    AppMethodBeat.o(113967);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ti
 * JD-Core Version:    0.7.0.1
 */