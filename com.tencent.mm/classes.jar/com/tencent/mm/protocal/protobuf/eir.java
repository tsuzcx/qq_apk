package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eir
  extends com.tencent.mm.bw.a
{
  public int Kmn;
  public int NhR;
  public String NhS;
  public int NhT;
  public int NhU;
  public LinkedList<eiw> NhV;
  public boolean NhW;
  public boolean dEF;
  
  public eir()
  {
    AppMethodBeat.i(153003);
    this.NhV = new LinkedList();
    AppMethodBeat.o(153003);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153004);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.NhR);
      if (this.NhS != null) {
        paramVarArgs.e(2, this.NhS);
      }
      paramVarArgs.aM(3, this.Kmn);
      paramVarArgs.aM(4, this.NhT);
      paramVarArgs.aM(5, this.NhU);
      paramVarArgs.e(6, 8, this.NhV);
      paramVarArgs.cc(7, this.NhW);
      paramVarArgs.cc(8, this.dEF);
      AppMethodBeat.o(153004);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.NhR) + 0;
      paramInt = i;
      if (this.NhS != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.NhS);
      }
      i = g.a.a.b.b.a.bu(3, this.Kmn);
      int j = g.a.a.b.b.a.bu(4, this.NhT);
      int k = g.a.a.b.b.a.bu(5, this.NhU);
      int m = g.a.a.a.c(6, 8, this.NhV);
      int n = g.a.a.b.b.a.fS(7);
      int i1 = g.a.a.b.b.a.fS(8);
      AppMethodBeat.o(153004);
      return paramInt + i + j + k + m + (n + 1) + (i1 + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.NhV.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(153004);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      eir localeir = (eir)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(153004);
        return -1;
      case 1: 
        localeir.NhR = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(153004);
        return 0;
      case 2: 
        localeir.NhS = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(153004);
        return 0;
      case 3: 
        localeir.Kmn = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(153004);
        return 0;
      case 4: 
        localeir.NhT = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(153004);
        return 0;
      case 5: 
        localeir.NhU = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(153004);
        return 0;
      case 6: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new eiw();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((eiw)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localeir.NhV.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(153004);
        return 0;
      case 7: 
        localeir.NhW = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(153004);
        return 0;
      }
      localeir.dEF = ((g.a.a.a.a)localObject1).UbS.yZ();
      AppMethodBeat.o(153004);
      return 0;
    }
    AppMethodBeat.o(153004);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eir
 * JD-Core Version:    0.7.0.1
 */