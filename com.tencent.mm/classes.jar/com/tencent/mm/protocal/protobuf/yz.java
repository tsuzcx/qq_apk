package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class yz
  extends com.tencent.mm.bw.a
{
  public dfw Etd;
  public dhb Ete;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91425);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Etd != null)
      {
        paramVarArgs.ln(1, this.Etd.computeSize());
        this.Etd.writeFields(paramVarArgs);
      }
      if (this.Ete != null)
      {
        paramVarArgs.ln(2, this.Ete.computeSize());
        this.Ete.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91425);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Etd == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = f.a.a.a.lm(1, this.Etd.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Ete != null) {
        i = paramInt + f.a.a.a.lm(2, this.Ete.computeSize());
      }
      AppMethodBeat.o(91425);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91425);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        yz localyz = (yz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91425);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dfw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dfw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localyz.Etd = ((dfw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91425);
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
          localyz.Ete = ((dhb)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91425);
        return 0;
      }
      AppMethodBeat.o(91425);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yz
 * JD-Core Version:    0.7.0.1
 */