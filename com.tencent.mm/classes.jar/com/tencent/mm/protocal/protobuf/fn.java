package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class fn
  extends com.tencent.mm.bw.a
{
  public int Brl;
  public int KIQ;
  public String KIR;
  public int KIS;
  public boolean KIT;
  public int KIU;
  public int KIV;
  public int KIW;
  public int KIX;
  public boolean KIY;
  public LinkedList<eib> KIZ;
  public String Url;
  public int iAb;
  public String iAc;
  
  public fn()
  {
    AppMethodBeat.i(6388);
    this.KIQ = 600;
    this.iAb = -1;
    this.KIY = false;
    this.KIZ = new LinkedList();
    AppMethodBeat.o(6388);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6389);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Url != null) {
        paramVarArgs.e(1, this.Url);
      }
      if (this.iAc != null) {
        paramVarArgs.e(2, this.iAc);
      }
      paramVarArgs.aM(3, this.KIQ);
      if (this.KIR != null) {
        paramVarArgs.e(4, this.KIR);
      }
      paramVarArgs.aM(5, this.KIS);
      paramVarArgs.cc(6, this.KIT);
      paramVarArgs.aM(7, this.KIU);
      paramVarArgs.aM(8, this.KIV);
      paramVarArgs.aM(9, this.Brl);
      paramVarArgs.aM(10, this.KIW);
      paramVarArgs.aM(11, this.KIX);
      paramVarArgs.aM(12, this.iAb);
      paramVarArgs.cc(13, this.KIY);
      paramVarArgs.e(14, 8, this.KIZ);
      AppMethodBeat.o(6389);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Url == null) {
        break label970;
      }
    }
    label970:
    for (paramInt = g.a.a.b.b.a.f(1, this.Url) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.iAc != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.iAc);
      }
      i += g.a.a.b.b.a.bu(3, this.KIQ);
      paramInt = i;
      if (this.KIR != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.KIR);
      }
      i = g.a.a.b.b.a.bu(5, this.KIS);
      int j = g.a.a.b.b.a.fS(6);
      int k = g.a.a.b.b.a.bu(7, this.KIU);
      int m = g.a.a.b.b.a.bu(8, this.KIV);
      int n = g.a.a.b.b.a.bu(9, this.Brl);
      int i1 = g.a.a.b.b.a.bu(10, this.KIW);
      int i2 = g.a.a.b.b.a.bu(11, this.KIX);
      int i3 = g.a.a.b.b.a.bu(12, this.iAb);
      int i4 = g.a.a.b.b.a.fS(13);
      int i5 = g.a.a.a.c(14, 8, this.KIZ);
      AppMethodBeat.o(6389);
      return paramInt + i + (j + 1) + k + m + n + i1 + i2 + i3 + (i4 + 1) + i5;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.KIZ.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(6389);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        fn localfn = (fn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(6389);
          return -1;
        case 1: 
          localfn.Url = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(6389);
          return 0;
        case 2: 
          localfn.iAc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(6389);
          return 0;
        case 3: 
          localfn.KIQ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(6389);
          return 0;
        case 4: 
          localfn.KIR = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(6389);
          return 0;
        case 5: 
          localfn.KIS = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(6389);
          return 0;
        case 6: 
          localfn.KIT = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(6389);
          return 0;
        case 7: 
          localfn.KIU = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(6389);
          return 0;
        case 8: 
          localfn.KIV = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(6389);
          return 0;
        case 9: 
          localfn.Brl = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(6389);
          return 0;
        case 10: 
          localfn.KIW = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(6389);
          return 0;
        case 11: 
          localfn.KIX = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(6389);
          return 0;
        case 12: 
          localfn.iAb = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(6389);
          return 0;
        case 13: 
          localfn.KIY = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(6389);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new eib();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((eib)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localfn.KIZ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(6389);
        return 0;
      }
      AppMethodBeat.o(6389);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fn
 * JD-Core Version:    0.7.0.1
 */