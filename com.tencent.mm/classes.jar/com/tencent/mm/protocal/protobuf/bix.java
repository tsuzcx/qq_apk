package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bix
  extends com.tencent.mm.bw.a
{
  public com.tencent.mm.bw.b EXI;
  public int EXJ;
  public LinkedList<biz> EXK;
  public LinkedList<Integer> EXL;
  
  public bix()
  {
    AppMethodBeat.i(115842);
    this.EXK = new LinkedList();
    this.EXL = new LinkedList();
    AppMethodBeat.o(115842);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115843);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EXI == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: RawBuf");
        AppMethodBeat.o(115843);
        throw paramVarArgs;
      }
      if (this.EXI != null) {
        paramVarArgs.c(1, this.EXI);
      }
      paramVarArgs.aR(2, this.EXJ);
      paramVarArgs.e(3, 8, this.EXK);
      paramVarArgs.e(4, 2, this.EXL);
      AppMethodBeat.o(115843);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EXI == null) {
        break label513;
      }
    }
    label513:
    for (paramInt = f.a.a.b.b.a.b(1, this.EXI) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bx(2, this.EXJ);
      int j = f.a.a.a.c(3, 8, this.EXK);
      int k = f.a.a.a.c(4, 2, this.EXL);
      AppMethodBeat.o(115843);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EXK.clear();
        this.EXL.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.EXI == null)
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
        bix localbix = (bix)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115843);
          return -1;
        case 1: 
          localbix.EXI = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(115843);
          return 0;
        case 2: 
          localbix.EXJ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115843);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new biz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((biz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbix.EXK.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115843);
          return 0;
        }
        localbix.EXL.add(Integer.valueOf(((f.a.a.a.a)localObject1).LVo.xF()));
        AppMethodBeat.o(115843);
        return 0;
      }
      AppMethodBeat.o(115843);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bix
 * JD-Core Version:    0.7.0.1
 */