package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eoq
  extends com.tencent.mm.bw.a
{
  public LinkedList<eor> Mzx;
  public boolean lHF;
  public int lHG;
  public int lHH;
  public String lHI;
  public String lHJ;
  public String lHK;
  public String lHL;
  
  public eoq()
  {
    AppMethodBeat.i(123670);
    this.Mzx = new LinkedList();
    AppMethodBeat.o(123670);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123671);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.Mzx);
      paramVarArgs.cc(2, this.lHF);
      paramVarArgs.aM(3, this.lHG);
      paramVarArgs.aM(4, this.lHH);
      if (this.lHI != null) {
        paramVarArgs.e(5, this.lHI);
      }
      if (this.lHJ != null) {
        paramVarArgs.e(6, this.lHJ);
      }
      if (this.lHK != null) {
        paramVarArgs.e(7, this.lHK);
      }
      if (this.lHL != null) {
        paramVarArgs.e(8, this.lHL);
      }
      AppMethodBeat.o(123671);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.Mzx) + 0 + (g.a.a.b.b.a.fS(2) + 1) + g.a.a.b.b.a.bu(3, this.lHG) + g.a.a.b.b.a.bu(4, this.lHH);
      paramInt = i;
      if (this.lHI != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.lHI);
      }
      i = paramInt;
      if (this.lHJ != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.lHJ);
      }
      paramInt = i;
      if (this.lHK != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.lHK);
      }
      i = paramInt;
      if (this.lHL != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.lHL);
      }
      AppMethodBeat.o(123671);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Mzx.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(123671);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      eoq localeoq = (eoq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(123671);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new eor();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((eor)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localeoq.Mzx.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(123671);
        return 0;
      case 2: 
        localeoq.lHF = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(123671);
        return 0;
      case 3: 
        localeoq.lHG = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(123671);
        return 0;
      case 4: 
        localeoq.lHH = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(123671);
        return 0;
      case 5: 
        localeoq.lHI = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(123671);
        return 0;
      case 6: 
        localeoq.lHJ = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(123671);
        return 0;
      case 7: 
        localeoq.lHK = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(123671);
        return 0;
      }
      localeoq.lHL = ((g.a.a.a.a)localObject1).UbS.readString();
      AppMethodBeat.o(123671);
      return 0;
    }
    AppMethodBeat.o(123671);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eoq
 * JD-Core Version:    0.7.0.1
 */