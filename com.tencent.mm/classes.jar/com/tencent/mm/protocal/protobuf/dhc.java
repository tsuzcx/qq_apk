package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dhc
  extends com.tencent.mm.bx.a
{
  public long HvA;
  public long HvB;
  public LinkedList<dfu> HvC;
  public String HvD;
  public long Hvz;
  public String dxa;
  public String dyV;
  public String hIG;
  
  public dhc()
  {
    AppMethodBeat.i(122548);
    this.Hvz = 0L;
    this.HvA = 0L;
    this.HvB = 0L;
    this.HvC = new LinkedList();
    AppMethodBeat.o(122548);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122549);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dyV != null) {
        paramVarArgs.d(1, this.dyV);
      }
      paramVarArgs.aY(2, this.Hvz);
      paramVarArgs.aY(3, this.HvA);
      paramVarArgs.aY(4, this.HvB);
      paramVarArgs.e(5, 8, this.HvC);
      if (this.dxa != null) {
        paramVarArgs.d(6, this.dxa);
      }
      if (this.hIG != null) {
        paramVarArgs.d(7, this.hIG);
      }
      if (this.HvD != null) {
        paramVarArgs.d(8, this.HvD);
      }
      AppMethodBeat.o(122549);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dyV == null) {
        break label670;
      }
    }
    label670:
    for (paramInt = f.a.a.b.b.a.e(1, this.dyV) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.Hvz) + f.a.a.b.b.a.p(3, this.HvA) + f.a.a.b.b.a.p(4, this.HvB) + f.a.a.a.c(5, 8, this.HvC);
      paramInt = i;
      if (this.dxa != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.dxa);
      }
      i = paramInt;
      if (this.hIG != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.hIG);
      }
      paramInt = i;
      if (this.HvD != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.HvD);
      }
      AppMethodBeat.o(122549);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HvC.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(122549);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dhc localdhc = (dhc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122549);
          return -1;
        case 1: 
          localdhc.dyV = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(122549);
          return 0;
        case 2: 
          localdhc.Hvz = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(122549);
          return 0;
        case 3: 
          localdhc.HvA = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(122549);
          return 0;
        case 4: 
          localdhc.HvB = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(122549);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dfu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dfu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdhc.HvC.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122549);
          return 0;
        case 6: 
          localdhc.dxa = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(122549);
          return 0;
        case 7: 
          localdhc.hIG = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(122549);
          return 0;
        }
        localdhc.HvD = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(122549);
        return 0;
      }
      AppMethodBeat.o(122549);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhc
 * JD-Core Version:    0.7.0.1
 */