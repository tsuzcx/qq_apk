package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cnw
  extends com.tencent.mm.bx.a
{
  public abl HgW;
  public bzd HgY;
  public String dxD;
  public String ozD;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209414);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dxD != null) {
        paramVarArgs.d(1, this.dxD);
      }
      paramVarArgs.aS(2, this.type);
      if (this.ozD != null) {
        paramVarArgs.d(3, this.ozD);
      }
      if (this.HgY != null)
      {
        paramVarArgs.lC(4, this.HgY.computeSize());
        this.HgY.writeFields(paramVarArgs);
      }
      if (this.HgW != null)
      {
        paramVarArgs.lC(5, this.HgW.computeSize());
        this.HgW.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(209414);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dxD == null) {
        break label630;
      }
    }
    label630:
    for (paramInt = f.a.a.b.b.a.e(1, this.dxD) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.type);
      paramInt = i;
      if (this.ozD != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ozD);
      }
      i = paramInt;
      if (this.HgY != null) {
        i = paramInt + f.a.a.a.lB(4, this.HgY.computeSize());
      }
      paramInt = i;
      if (this.HgW != null) {
        paramInt = i + f.a.a.a.lB(5, this.HgW.computeSize());
      }
      AppMethodBeat.o(209414);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(209414);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cnw localcnw = (cnw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209414);
          return -1;
        case 1: 
          localcnw.dxD = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(209414);
          return 0;
        case 2: 
          localcnw.type = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(209414);
          return 0;
        case 3: 
          localcnw.ozD = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(209414);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bzd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bzd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcnw.HgY = ((bzd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209414);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new abl();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((abl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcnw.HgW = ((abl)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209414);
        return 0;
      }
      AppMethodBeat.o(209414);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnw
 * JD-Core Version:    0.7.0.1
 */