package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eij
  extends com.tencent.mm.bx.a
{
  public LinkedList<Integer> HHF;
  public eic HSF;
  public String HSX;
  public int HSY;
  public int HSZ;
  
  public eij()
  {
    AppMethodBeat.i(153345);
    this.HHF = new LinkedList();
    AppMethodBeat.o(153345);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153346);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HSF != null)
      {
        paramVarArgs.lC(1, this.HSF.computeSize());
        this.HSF.writeFields(paramVarArgs);
      }
      if (this.HSX != null) {
        paramVarArgs.d(2, this.HSX);
      }
      paramVarArgs.e(3, 2, this.HHF);
      paramVarArgs.aS(4, this.HSY);
      paramVarArgs.aS(5, this.HSZ);
      AppMethodBeat.o(153346);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HSF == null) {
        break label525;
      }
    }
    label525:
    for (paramInt = f.a.a.a.lB(1, this.HSF.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HSX != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.HSX);
      }
      paramInt = f.a.a.a.c(3, 2, this.HHF);
      int j = f.a.a.b.b.a.bz(4, this.HSY);
      int k = f.a.a.b.b.a.bz(5, this.HSZ);
      AppMethodBeat.o(153346);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HHF.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(153346);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        eij localeij = (eij)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153346);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eic();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((eic)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localeij.HSF = ((eic)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153346);
          return 0;
        case 2: 
          localeij.HSX = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153346);
          return 0;
        case 3: 
          localeij.HHF.add(Integer.valueOf(((f.a.a.a.a)localObject1).NPN.zc()));
          AppMethodBeat.o(153346);
          return 0;
        case 4: 
          localeij.HSY = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(153346);
          return 0;
        }
        localeij.HSZ = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(153346);
        return 0;
      }
      AppMethodBeat.o(153346);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eij
 * JD-Core Version:    0.7.0.1
 */