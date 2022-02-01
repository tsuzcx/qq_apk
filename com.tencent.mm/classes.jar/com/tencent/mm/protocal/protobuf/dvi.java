package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dvi
  extends com.tencent.mm.bw.a
{
  public String LPM;
  public long LPN;
  public boolean MWo;
  public LinkedList<cbm> MWp;
  public String dRM;
  public int index;
  public boolean vtY;
  
  public dvi()
  {
    AppMethodBeat.i(177411);
    this.index = -1;
    this.MWo = false;
    this.dRM = "";
    this.LPN = -1L;
    this.LPM = "";
    this.MWp = new LinkedList();
    this.vtY = false;
    AppMethodBeat.o(177411);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(177412);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.index);
      paramVarArgs.cc(2, this.MWo);
      if (this.dRM != null) {
        paramVarArgs.e(3, this.dRM);
      }
      paramVarArgs.bb(4, this.LPN);
      if (this.LPM != null) {
        paramVarArgs.e(5, this.LPM);
      }
      paramVarArgs.e(6, 8, this.MWp);
      paramVarArgs.cc(7, this.vtY);
      AppMethodBeat.o(177412);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.index) + 0 + (g.a.a.b.b.a.fS(2) + 1);
      paramInt = i;
      if (this.dRM != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.dRM);
      }
      i = paramInt + g.a.a.b.b.a.r(4, this.LPN);
      paramInt = i;
      if (this.LPM != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.LPM);
      }
      i = g.a.a.a.c(6, 8, this.MWp);
      int j = g.a.a.b.b.a.fS(7);
      AppMethodBeat.o(177412);
      return paramInt + i + (j + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.MWp.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(177412);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      dvi localdvi = (dvi)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(177412);
        return -1;
      case 1: 
        localdvi.index = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(177412);
        return 0;
      case 2: 
        localdvi.MWo = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(177412);
        return 0;
      case 3: 
        localdvi.dRM = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(177412);
        return 0;
      case 4: 
        localdvi.LPN = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(177412);
        return 0;
      case 5: 
        localdvi.LPM = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(177412);
        return 0;
      case 6: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cbm();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cbm)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdvi.MWp.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(177412);
        return 0;
      }
      localdvi.vtY = ((g.a.a.a.a)localObject1).UbS.yZ();
      AppMethodBeat.o(177412);
      return 0;
    }
    AppMethodBeat.o(177412);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvi
 * JD-Core Version:    0.7.0.1
 */