package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ui
  extends com.tencent.mm.bw.a
{
  public String LdJ;
  public String LdK;
  public String LdL;
  public int LdM;
  public String LdN;
  public un LdO;
  public String LdP;
  public int LdQ;
  public int LdR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113959);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LdJ != null) {
        paramVarArgs.e(1, this.LdJ);
      }
      if (this.LdK != null) {
        paramVarArgs.e(2, this.LdK);
      }
      if (this.LdL != null) {
        paramVarArgs.e(3, this.LdL);
      }
      paramVarArgs.aM(4, this.LdM);
      if (this.LdN != null) {
        paramVarArgs.e(5, this.LdN);
      }
      if (this.LdO != null)
      {
        paramVarArgs.ni(6, this.LdO.computeSize());
        this.LdO.writeFields(paramVarArgs);
      }
      if (this.LdP != null) {
        paramVarArgs.e(7, this.LdP);
      }
      paramVarArgs.aM(8, this.LdQ);
      paramVarArgs.aM(9, this.LdR);
      AppMethodBeat.o(113959);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LdJ == null) {
        break label754;
      }
    }
    label754:
    for (int i = g.a.a.b.b.a.f(1, this.LdJ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.LdK != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.LdK);
      }
      i = paramInt;
      if (this.LdL != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.LdL);
      }
      i += g.a.a.b.b.a.bu(4, this.LdM);
      paramInt = i;
      if (this.LdN != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.LdN);
      }
      i = paramInt;
      if (this.LdO != null) {
        i = paramInt + g.a.a.a.nh(6, this.LdO.computeSize());
      }
      paramInt = i;
      if (this.LdP != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.LdP);
      }
      i = g.a.a.b.b.a.bu(8, this.LdQ);
      int j = g.a.a.b.b.a.bu(9, this.LdR);
      AppMethodBeat.o(113959);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(113959);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ui localui = (ui)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113959);
          return -1;
        case 1: 
          localui.LdJ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(113959);
          return 0;
        case 2: 
          localui.LdK = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(113959);
          return 0;
        case 3: 
          localui.LdL = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(113959);
          return 0;
        case 4: 
          localui.LdM = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(113959);
          return 0;
        case 5: 
          localui.LdN = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(113959);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new un();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((un)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localui.LdO = ((un)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113959);
          return 0;
        case 7: 
          localui.LdP = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(113959);
          return 0;
        case 8: 
          localui.LdQ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(113959);
          return 0;
        }
        localui.LdR = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(113959);
        return 0;
      }
      AppMethodBeat.o(113959);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ui
 * JD-Core Version:    0.7.0.1
 */