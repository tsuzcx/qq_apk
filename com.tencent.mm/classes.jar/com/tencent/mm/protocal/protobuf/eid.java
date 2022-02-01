package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eid
  extends com.tencent.mm.bx.a
{
  public LinkedList<Integer> HHF;
  public eic HSF;
  public LinkedList<Integer> HSG;
  public int HSH;
  public int HSI;
  
  public eid()
  {
    AppMethodBeat.i(153338);
    this.HSG = new LinkedList();
    this.HHF = new LinkedList();
    AppMethodBeat.o(153338);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153339);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HSF != null)
      {
        paramVarArgs.lC(1, this.HSF.computeSize());
        this.HSF.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 2, this.HSG);
      paramVarArgs.e(3, 2, this.HHF);
      paramVarArgs.aS(4, this.HSH);
      paramVarArgs.aS(5, this.HSI);
      AppMethodBeat.o(153339);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HSF == null) {
        break label528;
      }
    }
    label528:
    for (paramInt = f.a.a.a.lB(1, this.HSF.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 2, this.HSG);
      int j = f.a.a.a.c(3, 2, this.HHF);
      int k = f.a.a.b.b.a.bz(4, this.HSH);
      int m = f.a.a.b.b.a.bz(5, this.HSI);
      AppMethodBeat.o(153339);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HSG.clear();
        this.HHF.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(153339);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        eid localeid = (eid)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153339);
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
            localeid.HSF = ((eic)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153339);
          return 0;
        case 2: 
          localeid.HSG.add(Integer.valueOf(((f.a.a.a.a)localObject1).NPN.zc()));
          AppMethodBeat.o(153339);
          return 0;
        case 3: 
          localeid.HHF.add(Integer.valueOf(((f.a.a.a.a)localObject1).NPN.zc()));
          AppMethodBeat.o(153339);
          return 0;
        case 4: 
          localeid.HSH = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(153339);
          return 0;
        }
        localeid.HSI = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(153339);
        return 0;
      }
      AppMethodBeat.o(153339);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eid
 * JD-Core Version:    0.7.0.1
 */