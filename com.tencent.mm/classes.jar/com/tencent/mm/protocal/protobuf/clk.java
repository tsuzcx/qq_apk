package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class clk
  extends com.tencent.mm.cd.a
{
  public clr TsT;
  public long TsU;
  public long TsV;
  public long TsW;
  public int TsX;
  public cls TsY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(210455);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TsT != null)
      {
        paramVarArgs.oE(1, this.TsT.computeSize());
        this.TsT.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(2, this.TsU);
      paramVarArgs.bm(3, this.TsV);
      paramVarArgs.bm(4, this.TsW);
      paramVarArgs.aY(5, this.TsX);
      if (this.TsY != null)
      {
        paramVarArgs.oE(6, this.TsY.computeSize());
        this.TsY.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(210455);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TsT == null) {
        break label594;
      }
    }
    label594:
    for (paramInt = g.a.a.a.oD(1, this.TsT.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.TsU) + g.a.a.b.b.a.p(3, this.TsV) + g.a.a.b.b.a.p(4, this.TsW) + g.a.a.b.b.a.bM(5, this.TsX);
      paramInt = i;
      if (this.TsY != null) {
        paramInt = i + g.a.a.a.oD(6, this.TsY.computeSize());
      }
      AppMethodBeat.o(210455);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(210455);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        clk localclk = (clk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(210455);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new clr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((clr)localObject2).parseFrom((byte[])localObject1);
            }
            localclk.TsT = ((clr)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(210455);
          return 0;
        case 2: 
          localclk.TsU = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(210455);
          return 0;
        case 3: 
          localclk.TsV = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(210455);
          return 0;
        case 4: 
          localclk.TsW = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(210455);
          return 0;
        case 5: 
          localclk.TsX = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(210455);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cls();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cls)localObject2).parseFrom((byte[])localObject1);
          }
          localclk.TsY = ((cls)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(210455);
        return 0;
      }
      AppMethodBeat.o(210455);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clk
 * JD-Core Version:    0.7.0.1
 */