package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class nu
  extends com.tencent.mm.bw.a
{
  public String DZs;
  public int Ebf;
  public nv EdL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124454);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EdL != null)
      {
        paramVarArgs.ln(1, this.EdL.computeSize());
        this.EdL.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.Ebf);
      if (this.DZs != null) {
        paramVarArgs.d(3, this.DZs);
      }
      AppMethodBeat.o(124454);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EdL == null) {
        break label414;
      }
    }
    label414:
    for (paramInt = f.a.a.a.lm(1, this.EdL.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.Ebf);
      paramInt = i;
      if (this.DZs != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.DZs);
      }
      AppMethodBeat.o(124454);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(124454);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        nu localnu = (nu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124454);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new nv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((nv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localnu.EdL = ((nv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124454);
          return 0;
        case 2: 
          localnu.Ebf = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(124454);
          return 0;
        }
        localnu.DZs = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(124454);
        return 0;
      }
      AppMethodBeat.o(124454);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nu
 * JD-Core Version:    0.7.0.1
 */