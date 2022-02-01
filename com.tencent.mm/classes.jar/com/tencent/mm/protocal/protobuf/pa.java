package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class pa
  extends com.tencent.mm.bw.a
{
  public String GcE;
  public int GcF;
  public String GcG;
  public int GcH;
  public LinkedList<mm> GcI;
  
  public pa()
  {
    AppMethodBeat.i(152509);
    this.GcI = new LinkedList();
    AppMethodBeat.o(152509);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152510);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GcE != null) {
        paramVarArgs.d(1, this.GcE);
      }
      paramVarArgs.aS(2, this.GcF);
      if (this.GcG != null) {
        paramVarArgs.d(3, this.GcG);
      }
      paramVarArgs.aS(4, this.GcH);
      paramVarArgs.e(5, 8, this.GcI);
      AppMethodBeat.o(152510);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GcE == null) {
        break label506;
      }
    }
    label506:
    for (paramInt = f.a.a.b.b.a.e(1, this.GcE) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.GcF);
      paramInt = i;
      if (this.GcG != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.GcG);
      }
      i = f.a.a.b.b.a.bz(4, this.GcH);
      int j = f.a.a.a.c(5, 8, this.GcI);
      AppMethodBeat.o(152510);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GcI.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(152510);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        pa localpa = (pa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152510);
          return -1;
        case 1: 
          localpa.GcE = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152510);
          return 0;
        case 2: 
          localpa.GcF = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152510);
          return 0;
        case 3: 
          localpa.GcG = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152510);
          return 0;
        case 4: 
          localpa.GcH = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152510);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new mm();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((mm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localpa.GcI.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152510);
        return 0;
      }
      AppMethodBeat.o(152510);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pa
 * JD-Core Version:    0.7.0.1
 */