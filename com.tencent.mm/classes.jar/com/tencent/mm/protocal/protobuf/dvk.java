package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dvk
  extends com.tencent.mm.bw.a
{
  public String GcR;
  public ql GcS;
  public boolean GcT;
  public String GcU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91731);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GcR != null) {
        paramVarArgs.d(1, this.GcR);
      }
      if (this.GcS != null)
      {
        paramVarArgs.ln(2, this.GcS.computeSize());
        this.GcS.writeFields(paramVarArgs);
      }
      paramVarArgs.bl(3, this.GcT);
      if (this.GcU != null) {
        paramVarArgs.d(4, this.GcU);
      }
      AppMethodBeat.o(91731);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GcR == null) {
        break label474;
      }
    }
    label474:
    for (paramInt = f.a.a.b.b.a.e(1, this.GcR) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GcS != null) {
        i = paramInt + f.a.a.a.lm(2, this.GcS.computeSize());
      }
      i += f.a.a.b.b.a.fK(3) + 1;
      paramInt = i;
      if (this.GcU != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GcU);
      }
      AppMethodBeat.o(91731);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91731);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dvk localdvk = (dvk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91731);
          return -1;
        case 1: 
          localdvk.GcR = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91731);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ql();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ql)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdvk.GcS = ((ql)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91731);
          return 0;
        case 3: 
          localdvk.GcT = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(91731);
          return 0;
        }
        localdvk.GcU = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91731);
        return 0;
      }
      AppMethodBeat.o(91731);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvk
 * JD-Core Version:    0.7.0.1
 */