package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cui
  extends com.tencent.mm.bw.a
{
  public LinkedList<Double> AZP;
  public ddh MzB;
  public double MzC;
  public String text;
  
  public cui()
  {
    AppMethodBeat.i(118410);
    this.AZP = new LinkedList();
    AppMethodBeat.o(118410);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118411);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.text != null) {
        paramVarArgs.e(1, this.text);
      }
      if (this.MzB != null)
      {
        paramVarArgs.ni(2, this.MzB.computeSize());
        this.MzB.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, this.MzC);
      paramVarArgs.e(4, 4, this.AZP);
      AppMethodBeat.o(118411);
      return 0;
    }
    if (paramInt == 1) {
      if (this.text == null) {
        break label483;
      }
    }
    label483:
    for (paramInt = g.a.a.b.b.a.f(1, this.text) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.MzB != null) {
        i = paramInt + g.a.a.a.nh(2, this.MzB.computeSize());
      }
      paramInt = g.a.a.b.b.a.fS(3);
      int j = g.a.a.a.c(4, 4, this.AZP);
      AppMethodBeat.o(118411);
      return i + (paramInt + 8) + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.AZP.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(118411);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cui localcui = (cui)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118411);
          return -1;
        case 1: 
          localcui.text = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(118411);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ddh();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ddh)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcui.MzB = ((ddh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118411);
          return 0;
        case 3: 
          localcui.MzC = Double.longBitsToDouble(((g.a.a.a.a)localObject1).UbS.zn());
          AppMethodBeat.o(118411);
          return 0;
        }
        localcui.AZP.add(Double.valueOf(Double.longBitsToDouble(((g.a.a.a.a)localObject1).UbS.zn())));
        AppMethodBeat.o(118411);
        return 0;
      }
      AppMethodBeat.o(118411);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cui
 * JD-Core Version:    0.7.0.1
 */