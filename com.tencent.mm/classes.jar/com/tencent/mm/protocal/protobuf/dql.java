package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dql
  extends com.tencent.mm.bw.a
{
  public ccn FEc;
  public btl FXM;
  public int FXN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91725);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FEc != null)
      {
        paramVarArgs.ln(1, this.FEc.computeSize());
        this.FEc.writeFields(paramVarArgs);
      }
      if (this.FXM != null)
      {
        paramVarArgs.ln(2, this.FXM.computeSize());
        this.FXM.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.FXN);
      AppMethodBeat.o(91725);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FEc == null) {
        break label510;
      }
    }
    label510:
    for (paramInt = f.a.a.a.lm(1, this.FEc.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FXM != null) {
        i = paramInt + f.a.a.a.lm(2, this.FXM.computeSize());
      }
      paramInt = f.a.a.b.b.a.bx(3, this.FXN);
      AppMethodBeat.o(91725);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91725);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dql localdql = (dql)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91725);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ccn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ccn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdql.FEc = ((ccn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91725);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new btl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((btl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdql.FXM = ((btl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91725);
          return 0;
        }
        localdql.FXN = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91725);
        return 0;
      }
      AppMethodBeat.o(91725);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dql
 * JD-Core Version:    0.7.0.1
 */