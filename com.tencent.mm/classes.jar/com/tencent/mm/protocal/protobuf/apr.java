package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class apr
  extends com.tencent.mm.bw.a
{
  public dhz EIE;
  public String EIF = "";
  public String EIG = "";
  public boolean EIH = false;
  public boolean EII = false;
  public long timestamp = 0L;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122493);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EIE != null)
      {
        paramVarArgs.ln(1, this.EIE.computeSize());
        this.EIE.writeFields(paramVarArgs);
      }
      if (this.EIG != null) {
        paramVarArgs.d(2, this.EIG);
      }
      paramVarArgs.bl(3, this.EIH);
      if (this.EIF != null) {
        paramVarArgs.d(4, this.EIF);
      }
      paramVarArgs.bl(5, this.EII);
      paramVarArgs.aO(6, this.timestamp);
      AppMethodBeat.o(122493);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EIE == null) {
        break label562;
      }
    }
    label562:
    for (paramInt = f.a.a.a.lm(1, this.EIE.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.EIG != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.EIG);
      }
      i += f.a.a.b.b.a.fK(3) + 1;
      paramInt = i;
      if (this.EIF != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EIF);
      }
      i = f.a.a.b.b.a.fK(5);
      int j = f.a.a.b.b.a.p(6, this.timestamp);
      AppMethodBeat.o(122493);
      return paramInt + (i + 1) + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(122493);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        apr localapr = (apr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122493);
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
            localapr.EIE = ((dhz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122493);
          return 0;
        case 2: 
          localapr.EIG = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(122493);
          return 0;
        case 3: 
          localapr.EIH = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(122493);
          return 0;
        case 4: 
          localapr.EIF = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(122493);
          return 0;
        case 5: 
          localapr.EII = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(122493);
          return 0;
        }
        localapr.timestamp = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(122493);
        return 0;
      }
      AppMethodBeat.o(122493);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apr
 * JD-Core Version:    0.7.0.1
 */