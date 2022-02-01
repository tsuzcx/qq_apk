package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class px
  extends com.tencent.mm.bw.a
{
  public String KWK;
  public int KWL;
  public String KWM;
  public int KWN;
  public LinkedList<ne> KWO;
  
  public px()
  {
    AppMethodBeat.i(152509);
    this.KWO = new LinkedList();
    AppMethodBeat.o(152509);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152510);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KWK != null) {
        paramVarArgs.e(1, this.KWK);
      }
      paramVarArgs.aM(2, this.KWL);
      if (this.KWM != null) {
        paramVarArgs.e(3, this.KWM);
      }
      paramVarArgs.aM(4, this.KWN);
      paramVarArgs.e(5, 8, this.KWO);
      AppMethodBeat.o(152510);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KWK == null) {
        break label506;
      }
    }
    label506:
    for (paramInt = g.a.a.b.b.a.f(1, this.KWK) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.KWL);
      paramInt = i;
      if (this.KWM != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.KWM);
      }
      i = g.a.a.b.b.a.bu(4, this.KWN);
      int j = g.a.a.a.c(5, 8, this.KWO);
      AppMethodBeat.o(152510);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.KWO.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(152510);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        px localpx = (px)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152510);
          return -1;
        case 1: 
          localpx.KWK = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152510);
          return 0;
        case 2: 
          localpx.KWL = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152510);
          return 0;
        case 3: 
          localpx.KWM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152510);
          return 0;
        case 4: 
          localpx.KWN = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152510);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ne();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ne)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localpx.KWO.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152510);
        return 0;
      }
      AppMethodBeat.o(152510);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.px
 * JD-Core Version:    0.7.0.1
 */