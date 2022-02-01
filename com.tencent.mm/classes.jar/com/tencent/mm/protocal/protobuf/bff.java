package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bff
  extends com.tencent.mm.bx.a
{
  public com.tencent.mm.bx.b DCm;
  public int DCn;
  public LinkedList<bfh> DCo;
  public LinkedList<Integer> DCp;
  
  public bff()
  {
    AppMethodBeat.i(115842);
    this.DCo = new LinkedList();
    this.DCp = new LinkedList();
    AppMethodBeat.o(115842);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115843);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DCm == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: RawBuf");
        AppMethodBeat.o(115843);
        throw paramVarArgs;
      }
      if (this.DCm != null) {
        paramVarArgs.c(1, this.DCm);
      }
      paramVarArgs.aR(2, this.DCn);
      paramVarArgs.e(3, 8, this.DCo);
      paramVarArgs.e(4, 2, this.DCp);
      AppMethodBeat.o(115843);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DCm == null) {
        break label513;
      }
    }
    label513:
    for (paramInt = f.a.a.b.b.a.b(1, this.DCm) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bA(2, this.DCn);
      int j = f.a.a.a.c(3, 8, this.DCo);
      int k = f.a.a.a.c(4, 2, this.DCp);
      AppMethodBeat.o(115843);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DCo.clear();
        this.DCp.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.DCm == null)
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
        bff localbff = (bff)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115843);
          return -1;
        case 1: 
          localbff.DCm = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(115843);
          return 0;
        case 2: 
          localbff.DCn = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115843);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bfh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((bfh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbff.DCo.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115843);
          return 0;
        }
        localbff.DCp.add(Integer.valueOf(((f.a.a.a.a)localObject1).KhF.xS()));
        AppMethodBeat.o(115843);
        return 0;
      }
      AppMethodBeat.o(115843);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bff
 * JD-Core Version:    0.7.0.1
 */