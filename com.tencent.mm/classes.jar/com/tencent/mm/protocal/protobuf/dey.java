package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dey
  extends com.tencent.mm.bw.a
{
  public boolean LYA;
  public LinkedList<cty> MJY;
  public String MJZ;
  public int Mzl;
  public String dQx;
  public String pTL;
  
  public dey()
  {
    AppMethodBeat.i(176148);
    this.MJY = new LinkedList();
    AppMethodBeat.o(176148);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(176149);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.MJY);
      if (this.dQx != null) {
        paramVarArgs.e(2, this.dQx);
      }
      if (this.MJZ != null) {
        paramVarArgs.e(3, this.MJZ);
      }
      if (this.pTL != null) {
        paramVarArgs.e(4, this.pTL);
      }
      paramVarArgs.cc(5, this.LYA);
      paramVarArgs.aM(6, this.Mzl);
      AppMethodBeat.o(176149);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.MJY) + 0;
      paramInt = i;
      if (this.dQx != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.dQx);
      }
      i = paramInt;
      if (this.MJZ != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.MJZ);
      }
      paramInt = i;
      if (this.pTL != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.pTL);
      }
      i = g.a.a.b.b.a.fS(5);
      int j = g.a.a.b.b.a.bu(6, this.Mzl);
      AppMethodBeat.o(176149);
      return paramInt + (i + 1) + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.MJY.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(176149);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      dey localdey = (dey)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(176149);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cty();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cty)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdey.MJY.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(176149);
        return 0;
      case 2: 
        localdey.dQx = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(176149);
        return 0;
      case 3: 
        localdey.MJZ = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(176149);
        return 0;
      case 4: 
        localdey.pTL = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(176149);
        return 0;
      case 5: 
        localdey.LYA = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(176149);
        return 0;
      }
      localdey.Mzl = ((g.a.a.a.a)localObject1).UbS.zi();
      AppMethodBeat.o(176149);
      return 0;
    }
    AppMethodBeat.o(176149);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dey
 * JD-Core Version:    0.7.0.1
 */