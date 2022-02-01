package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cao
  extends com.tencent.mm.bw.a
{
  public com.tencent.mm.bw.b MfG;
  public int MfH;
  public LinkedList<caq> MfI;
  public LinkedList<Integer> MfJ;
  
  public cao()
  {
    AppMethodBeat.i(115842);
    this.MfI = new LinkedList();
    this.MfJ = new LinkedList();
    AppMethodBeat.o(115842);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115843);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MfG == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: RawBuf");
        AppMethodBeat.o(115843);
        throw paramVarArgs;
      }
      if (this.MfG != null) {
        paramVarArgs.c(1, this.MfG);
      }
      paramVarArgs.aM(2, this.MfH);
      paramVarArgs.e(3, 8, this.MfI);
      paramVarArgs.e(4, 2, this.MfJ);
      AppMethodBeat.o(115843);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MfG == null) {
        break label513;
      }
    }
    label513:
    for (paramInt = g.a.a.b.b.a.b(1, this.MfG) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.MfH);
      int j = g.a.a.a.c(3, 8, this.MfI);
      int k = g.a.a.a.c(4, 2, this.MfJ);
      AppMethodBeat.o(115843);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MfI.clear();
        this.MfJ.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.MfG == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: RawBuf");
          AppMethodBeat.o(115843);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115843);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cao localcao = (cao)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115843);
          return -1;
        case 1: 
          localcao.MfG = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(115843);
          return 0;
        case 2: 
          localcao.MfH = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115843);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new caq();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((caq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcao.MfI.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115843);
          return 0;
        }
        localcao.MfJ.add(Integer.valueOf(((g.a.a.a.a)localObject1).UbS.zi()));
        AppMethodBeat.o(115843);
        return 0;
      }
      AppMethodBeat.o(115843);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cao
 * JD-Core Version:    0.7.0.1
 */