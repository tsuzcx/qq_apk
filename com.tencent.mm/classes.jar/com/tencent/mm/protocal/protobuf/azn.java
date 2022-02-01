package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class azn
  extends com.tencent.mm.bw.a
{
  public ux GPE;
  public String GPF;
  public boolean GPG;
  public int GPH;
  public String GPy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114024);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GPE != null)
      {
        paramVarArgs.lJ(1, this.GPE.computeSize());
        this.GPE.writeFields(paramVarArgs);
      }
      if (this.GPy != null) {
        paramVarArgs.d(2, this.GPy);
      }
      if (this.GPF != null) {
        paramVarArgs.d(3, this.GPF);
      }
      paramVarArgs.bC(4, this.GPG);
      paramVarArgs.aS(5, this.GPH);
      AppMethodBeat.o(114024);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GPE == null) {
        break label518;
      }
    }
    label518:
    for (int i = f.a.a.a.lI(1, this.GPE.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GPy != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GPy);
      }
      i = paramInt;
      if (this.GPF != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GPF);
      }
      paramInt = f.a.a.b.b.a.amF(4);
      int j = f.a.a.b.b.a.bz(5, this.GPH);
      AppMethodBeat.o(114024);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(114024);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        azn localazn = (azn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114024);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ux();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ux)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localazn.GPE = ((ux)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114024);
          return 0;
        case 2: 
          localazn.GPy = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(114024);
          return 0;
        case 3: 
          localazn.GPF = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(114024);
          return 0;
        case 4: 
          localazn.GPG = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(114024);
          return 0;
        }
        localazn.GPH = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(114024);
        return 0;
      }
      AppMethodBeat.o(114024);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azn
 * JD-Core Version:    0.7.0.1
 */