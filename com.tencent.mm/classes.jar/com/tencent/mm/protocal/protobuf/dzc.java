package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dzc
  extends com.tencent.mm.bw.a
{
  public dqi MYD;
  public dqi MYF;
  public int MYG;
  public int xub;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125764);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MYD != null)
      {
        paramVarArgs.ni(1, this.MYD.computeSize());
        this.MYD.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.xub);
      if (this.MYF != null)
      {
        paramVarArgs.ni(3, this.MYF.computeSize());
        this.MYF.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(4, this.MYG);
      AppMethodBeat.o(125764);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MYD == null) {
        break label554;
      }
    }
    label554:
    for (paramInt = g.a.a.a.nh(1, this.MYD.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.xub);
      paramInt = i;
      if (this.MYF != null) {
        paramInt = i + g.a.a.a.nh(3, this.MYF.computeSize());
      }
      i = g.a.a.b.b.a.bu(4, this.MYG);
      AppMethodBeat.o(125764);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(125764);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dzc localdzc = (dzc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125764);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdzc.MYD = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125764);
          return 0;
        case 2: 
          localdzc.xub = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125764);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdzc.MYF = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125764);
          return 0;
        }
        localdzc.MYG = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(125764);
        return 0;
      }
      AppMethodBeat.o(125764);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzc
 * JD-Core Version:    0.7.0.1
 */