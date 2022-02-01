package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dml
  extends com.tencent.mm.bw.a
{
  public int LqX;
  public String LqY;
  public String LqZ;
  public int Lra;
  public int Lrb;
  public int Lrc;
  public int Lrg;
  public int Lrh;
  public esr MPX;
  public esr MPY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115848);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.LqX);
      if (this.LqY != null) {
        paramVarArgs.e(2, this.LqY);
      }
      if (this.LqZ != null) {
        paramVarArgs.e(3, this.LqZ);
      }
      paramVarArgs.aM(4, this.Lra);
      paramVarArgs.aM(5, this.Lrb);
      paramVarArgs.aM(6, this.Lrc);
      if (this.MPX != null)
      {
        paramVarArgs.ni(7, this.MPX.computeSize());
        this.MPX.writeFields(paramVarArgs);
      }
      if (this.MPY != null)
      {
        paramVarArgs.ni(8, this.MPY.computeSize());
        this.MPY.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(9, this.Lrg);
      paramVarArgs.aM(10, this.Lrh);
      AppMethodBeat.o(115848);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.LqX) + 0;
      paramInt = i;
      if (this.LqY != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.LqY);
      }
      i = paramInt;
      if (this.LqZ != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.LqZ);
      }
      i = i + g.a.a.b.b.a.bu(4, this.Lra) + g.a.a.b.b.a.bu(5, this.Lrb) + g.a.a.b.b.a.bu(6, this.Lrc);
      paramInt = i;
      if (this.MPX != null) {
        paramInt = i + g.a.a.a.nh(7, this.MPX.computeSize());
      }
      i = paramInt;
      if (this.MPY != null) {
        i = paramInt + g.a.a.a.nh(8, this.MPY.computeSize());
      }
      paramInt = g.a.a.b.b.a.bu(9, this.Lrg);
      int j = g.a.a.b.b.a.bu(10, this.Lrh);
      AppMethodBeat.o(115848);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(115848);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      dml localdml = (dml)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(115848);
        return -1;
      case 1: 
        localdml.LqX = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(115848);
        return 0;
      case 2: 
        localdml.LqY = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(115848);
        return 0;
      case 3: 
        localdml.LqZ = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(115848);
        return 0;
      case 4: 
        localdml.Lra = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(115848);
        return 0;
      case 5: 
        localdml.Lrb = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(115848);
        return 0;
      case 6: 
        localdml.Lrc = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(115848);
        return 0;
      case 7: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new esr();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((esr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdml.MPX = ((esr)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115848);
        return 0;
      case 8: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new esr();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((esr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdml.MPY = ((esr)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115848);
        return 0;
      case 9: 
        localdml.Lrg = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(115848);
        return 0;
      }
      localdml.Lrh = ((g.a.a.a.a)localObject1).UbS.zi();
      AppMethodBeat.o(115848);
      return 0;
    }
    AppMethodBeat.o(115848);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dml
 * JD-Core Version:    0.7.0.1
 */