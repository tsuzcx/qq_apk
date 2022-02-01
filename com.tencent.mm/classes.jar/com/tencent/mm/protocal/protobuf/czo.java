package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class czo
  extends com.tencent.mm.bw.a
{
  public crm FIJ;
  public crm FIL;
  public int FIM;
  public int sVo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125764);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FIJ != null)
      {
        paramVarArgs.ln(1, this.FIJ.computeSize());
        this.FIJ.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.sVo);
      if (this.FIL != null)
      {
        paramVarArgs.ln(3, this.FIL.computeSize());
        this.FIL.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(4, this.FIM);
      AppMethodBeat.o(125764);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FIJ == null) {
        break label554;
      }
    }
    label554:
    for (paramInt = f.a.a.a.lm(1, this.FIJ.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.sVo);
      paramInt = i;
      if (this.FIL != null) {
        paramInt = i + f.a.a.a.lm(3, this.FIL.computeSize());
      }
      i = f.a.a.b.b.a.bx(4, this.FIM);
      AppMethodBeat.o(125764);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(125764);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        czo localczo = (czo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125764);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localczo.FIJ = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125764);
          return 0;
        case 2: 
          localczo.sVo = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125764);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localczo.FIL = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125764);
          return 0;
        }
        localczo.FIM = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(125764);
        return 0;
      }
      AppMethodBeat.o(125764);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czo
 * JD-Core Version:    0.7.0.1
 */