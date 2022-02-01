package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dim
  extends com.tencent.mm.bw.a
{
  public String FRJ;
  public String FRK;
  public LinkedList<aij> FRL;
  
  public dim()
  {
    AppMethodBeat.i(153008);
    this.FRL = new LinkedList();
    AppMethodBeat.o(153008);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153009);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FRJ != null) {
        paramVarArgs.d(1, this.FRJ);
      }
      if (this.FRK != null) {
        paramVarArgs.d(2, this.FRK);
      }
      paramVarArgs.e(3, 8, this.FRL);
      AppMethodBeat.o(153009);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FRJ == null) {
        break label418;
      }
    }
    label418:
    for (paramInt = f.a.a.b.b.a.e(1, this.FRJ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FRK != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.FRK);
      }
      paramInt = f.a.a.a.c(3, 8, this.FRL);
      AppMethodBeat.o(153009);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FRL.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(153009);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dim localdim = (dim)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153009);
          return -1;
        case 1: 
          localdim.FRJ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153009);
          return 0;
        case 2: 
          localdim.FRK = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153009);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aij();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((aij)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdim.FRL.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(153009);
        return 0;
      }
      AppMethodBeat.o(153009);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dim
 * JD-Core Version:    0.7.0.1
 */