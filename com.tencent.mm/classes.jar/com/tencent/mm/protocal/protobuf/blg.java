package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class blg
  extends com.tencent.mm.bw.a
{
  public int LUj;
  public int LUk;
  public int LUl;
  public int LlA;
  public b LlC;
  public cbh LlD;
  public int Lly;
  public int Llz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143973);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.Lly);
      paramVarArgs.aM(2, this.Llz);
      paramVarArgs.aM(3, this.LlA);
      if (this.LlC != null) {
        paramVarArgs.c(4, this.LlC);
      }
      paramVarArgs.aM(5, this.LUj);
      paramVarArgs.aM(6, this.LUk);
      paramVarArgs.aM(7, this.LUl);
      if (this.LlD != null)
      {
        paramVarArgs.ni(8, this.LlD.computeSize());
        this.LlD.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(143973);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.Lly) + 0 + g.a.a.b.b.a.bu(2, this.Llz) + g.a.a.b.b.a.bu(3, this.LlA);
      paramInt = i;
      if (this.LlC != null) {
        paramInt = i + g.a.a.b.b.a.b(4, this.LlC);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.LUj) + g.a.a.b.b.a.bu(6, this.LUk) + g.a.a.b.b.a.bu(7, this.LUl);
      paramInt = i;
      if (this.LlD != null) {
        paramInt = i + g.a.a.a.nh(8, this.LlD.computeSize());
      }
      AppMethodBeat.o(143973);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(143973);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      blg localblg = (blg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143973);
        return -1;
      case 1: 
        localblg.Lly = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(143973);
        return 0;
      case 2: 
        localblg.Llz = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(143973);
        return 0;
      case 3: 
        localblg.LlA = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(143973);
        return 0;
      case 4: 
        localblg.LlC = ((g.a.a.a.a)localObject1).UbS.hPo();
        AppMethodBeat.o(143973);
        return 0;
      case 5: 
        localblg.LUj = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(143973);
        return 0;
      case 6: 
        localblg.LUk = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(143973);
        return 0;
      case 7: 
        localblg.LUl = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(143973);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new cbh();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((cbh)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localblg.LlD = ((cbh)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(143973);
      return 0;
    }
    AppMethodBeat.o(143973);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.blg
 * JD-Core Version:    0.7.0.1
 */