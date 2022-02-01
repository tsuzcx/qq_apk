package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bnx
  extends com.tencent.mm.bw.a
{
  public com.tencent.mm.bw.b HaG;
  public int HaH;
  public LinkedList<bnz> HaI;
  public LinkedList<Integer> HaJ;
  
  public bnx()
  {
    AppMethodBeat.i(115842);
    this.HaI = new LinkedList();
    this.HaJ = new LinkedList();
    AppMethodBeat.o(115842);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115843);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HaG == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: RawBuf");
        AppMethodBeat.o(115843);
        throw paramVarArgs;
      }
      if (this.HaG != null) {
        paramVarArgs.c(1, this.HaG);
      }
      paramVarArgs.aS(2, this.HaH);
      paramVarArgs.e(3, 8, this.HaI);
      paramVarArgs.e(4, 2, this.HaJ);
      AppMethodBeat.o(115843);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HaG == null) {
        break label513;
      }
    }
    label513:
    for (paramInt = f.a.a.b.b.a.b(1, this.HaG) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.HaH);
      int j = f.a.a.a.c(3, 8, this.HaI);
      int k = f.a.a.a.c(4, 2, this.HaJ);
      AppMethodBeat.o(115843);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HaI.clear();
        this.HaJ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.HaG == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: RawBuf");
          AppMethodBeat.o(115843);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115843);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bnx localbnx = (bnx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115843);
          return -1;
        case 1: 
          localbnx.HaG = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(115843);
          return 0;
        case 2: 
          localbnx.HaH = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115843);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bnz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((bnz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbnx.HaI.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115843);
          return 0;
        }
        localbnx.HaJ.add(Integer.valueOf(((f.a.a.a.a)localObject1).OmT.zc()));
        AppMethodBeat.o(115843);
        return 0;
      }
      AppMethodBeat.o(115843);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnx
 * JD-Core Version:    0.7.0.1
 */