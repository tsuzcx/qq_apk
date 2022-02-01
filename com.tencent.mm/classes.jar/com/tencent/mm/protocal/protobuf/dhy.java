package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dhy
  extends com.tencent.mm.bx.a
{
  public int HwK;
  public int HwL;
  public int HwM;
  public int Hwe;
  public dws Hwf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115855);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hwf == null)
      {
        paramVarArgs = new b("Not all required fields were included: Addr");
        AppMethodBeat.o(115855);
        throw paramVarArgs;
      }
      if (this.Hwf != null)
      {
        paramVarArgs.lC(1, this.Hwf.computeSize());
        this.Hwf.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.Hwe);
      paramVarArgs.aS(3, this.HwK);
      paramVarArgs.aS(4, this.HwL);
      paramVarArgs.aS(5, this.HwM);
      AppMethodBeat.o(115855);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Hwf == null) {
        break label542;
      }
    }
    label542:
    for (paramInt = f.a.a.a.lB(1, this.Hwf.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.Hwe);
      int j = f.a.a.b.b.a.bz(3, this.HwK);
      int k = f.a.a.b.b.a.bz(4, this.HwL);
      int m = f.a.a.b.b.a.bz(5, this.HwM);
      AppMethodBeat.o(115855);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.Hwf == null)
        {
          paramVarArgs = new b("Not all required fields were included: Addr");
          AppMethodBeat.o(115855);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115855);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dhy localdhy = (dhy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115855);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dws();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dws)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdhy.Hwf = ((dws)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115855);
          return 0;
        case 2: 
          localdhy.Hwe = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115855);
          return 0;
        case 3: 
          localdhy.HwK = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115855);
          return 0;
        case 4: 
          localdhy.HwL = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115855);
          return 0;
        }
        localdhy.HwM = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(115855);
        return 0;
      }
      AppMethodBeat.o(115855);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhy
 * JD-Core Version:    0.7.0.1
 */