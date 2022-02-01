package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bem
  extends com.tencent.mm.bw.a
{
  public int LBF;
  public int LBG;
  public bbi LNi;
  public int LOh;
  public int LOi;
  public int LOj;
  public int LOk;
  public int count;
  public String iAR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169077);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.count);
      paramVarArgs.aM(2, this.LBF);
      paramVarArgs.aM(3, this.LBG);
      paramVarArgs.aM(4, this.LOh);
      if (this.iAR != null) {
        paramVarArgs.e(5, this.iAR);
      }
      if (this.LNi != null)
      {
        paramVarArgs.ni(6, this.LNi.computeSize());
        this.LNi.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(7, this.LOi);
      paramVarArgs.aM(8, this.LOj);
      paramVarArgs.aM(9, this.LOk);
      AppMethodBeat.o(169077);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.count) + 0 + g.a.a.b.b.a.bu(2, this.LBF) + g.a.a.b.b.a.bu(3, this.LBG) + g.a.a.b.b.a.bu(4, this.LOh);
      paramInt = i;
      if (this.iAR != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.iAR);
      }
      i = paramInt;
      if (this.LNi != null) {
        i = paramInt + g.a.a.a.nh(6, this.LNi.computeSize());
      }
      paramInt = g.a.a.b.b.a.bu(7, this.LOi);
      int j = g.a.a.b.b.a.bu(8, this.LOj);
      int k = g.a.a.b.b.a.bu(9, this.LOk);
      AppMethodBeat.o(169077);
      return i + paramInt + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(169077);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      bem localbem = (bem)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(169077);
        return -1;
      case 1: 
        localbem.count = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(169077);
        return 0;
      case 2: 
        localbem.LBF = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(169077);
        return 0;
      case 3: 
        localbem.LBG = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(169077);
        return 0;
      case 4: 
        localbem.LOh = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(169077);
        return 0;
      case 5: 
        localbem.iAR = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(169077);
        return 0;
      case 6: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bbi();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bbi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbem.LNi = ((bbi)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169077);
        return 0;
      case 7: 
        localbem.LOi = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(169077);
        return 0;
      case 8: 
        localbem.LOj = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(169077);
        return 0;
      }
      localbem.LOk = ((g.a.a.a.a)localObject1).UbS.zi();
      AppMethodBeat.o(169077);
      return 0;
    }
    AppMethodBeat.o(169077);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bem
 * JD-Core Version:    0.7.0.1
 */