package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class crx
  extends com.tencent.mm.bx.a
{
  public cwt Hkr;
  public int Hks;
  public LinkedList<cys> Hkt;
  
  public crx()
  {
    AppMethodBeat.i(6420);
    this.Hkt = new LinkedList();
    AppMethodBeat.o(6420);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6421);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hkr == null)
      {
        paramVarArgs = new b("Not all required fields were included: GroupName");
        AppMethodBeat.o(6421);
        throw paramVarArgs;
      }
      if (this.Hkr != null)
      {
        paramVarArgs.lC(1, this.Hkr.computeSize());
        this.Hkr.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.Hks);
      paramVarArgs.e(3, 8, this.Hkt);
      AppMethodBeat.o(6421);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Hkr == null) {
        break label555;
      }
    }
    label555:
    for (paramInt = f.a.a.a.lB(1, this.Hkr.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.Hks);
      int j = f.a.a.a.c(3, 8, this.Hkt);
      AppMethodBeat.o(6421);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Hkt.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.Hkr == null)
        {
          paramVarArgs = new b("Not all required fields were included: GroupName");
          AppMethodBeat.o(6421);
          throw paramVarArgs;
        }
        AppMethodBeat.o(6421);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        crx localcrx = (crx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(6421);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcrx.Hkr = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(6421);
          return 0;
        case 2: 
          localcrx.Hks = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(6421);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cys();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cys)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcrx.Hkt.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(6421);
        return 0;
      }
      AppMethodBeat.o(6421);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crx
 * JD-Core Version:    0.7.0.1
 */