package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ebe
  extends com.tencent.mm.bw.a
{
  public ebd GgO;
  public vg GgP;
  public int dfm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194864);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GgO != null)
      {
        paramVarArgs.ln(1, this.GgO.computeSize());
        this.GgO.writeFields(paramVarArgs);
      }
      if (this.GgP != null)
      {
        paramVarArgs.ln(2, this.GgP.computeSize());
        this.GgP.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.dfm);
      AppMethodBeat.o(194864);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GgO == null) {
        break label510;
      }
    }
    label510:
    for (paramInt = f.a.a.a.lm(1, this.GgO.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GgP != null) {
        i = paramInt + f.a.a.a.lm(2, this.GgP.computeSize());
      }
      paramInt = f.a.a.b.b.a.bx(3, this.dfm);
      AppMethodBeat.o(194864);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(194864);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ebe localebe = (ebe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(194864);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ebd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ebd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localebe.GgO = ((ebd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(194864);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new vg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((vg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localebe.GgP = ((vg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(194864);
          return 0;
        }
        localebe.dfm = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(194864);
        return 0;
      }
      AppMethodBeat.o(194864);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebe
 * JD-Core Version:    0.7.0.1
 */