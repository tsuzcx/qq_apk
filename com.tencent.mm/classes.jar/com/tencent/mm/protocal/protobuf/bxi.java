package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bxi
  extends com.tencent.mm.bw.a
{
  public bld EgF;
  public dhb Ete;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91552);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EgF != null)
      {
        paramVarArgs.ln(1, this.EgF.computeSize());
        this.EgF.writeFields(paramVarArgs);
      }
      if (this.Ete != null)
      {
        paramVarArgs.ln(2, this.Ete.computeSize());
        this.Ete.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91552);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EgF == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = f.a.a.a.lm(1, this.EgF.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Ete != null) {
        i = paramInt + f.a.a.a.lm(2, this.Ete.computeSize());
      }
      AppMethodBeat.o(91552);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91552);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bxi localbxi = (bxi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91552);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bld();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bld)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbxi.EgF = ((bld)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91552);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dhb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dhb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbxi.Ete = ((dhb)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91552);
        return 0;
      }
      AppMethodBeat.o(91552);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxi
 * JD-Core Version:    0.7.0.1
 */