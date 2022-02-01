package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class apq
  extends com.tencent.mm.bw.a
{
  public dhz EIE;
  public String EIF = "";
  public long timestamp = 0L;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122492);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EIE != null)
      {
        paramVarArgs.ln(1, this.EIE.computeSize());
        this.EIE.writeFields(paramVarArgs);
      }
      if (this.EIF != null) {
        paramVarArgs.d(2, this.EIF);
      }
      paramVarArgs.aO(3, this.timestamp);
      AppMethodBeat.o(122492);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EIE == null) {
        break label414;
      }
    }
    label414:
    for (paramInt = f.a.a.a.lm(1, this.EIE.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.EIF != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.EIF);
      }
      paramInt = f.a.a.b.b.a.p(3, this.timestamp);
      AppMethodBeat.o(122492);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(122492);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        apq localapq = (apq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122492);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dhz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dhz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localapq.EIE = ((dhz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122492);
          return 0;
        case 2: 
          localapq.EIF = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(122492);
          return 0;
        }
        localapq.timestamp = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(122492);
        return 0;
      }
      AppMethodBeat.o(122492);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apq
 * JD-Core Version:    0.7.0.1
 */