package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ku
  extends com.tencent.mm.cd.a
{
  public int CqV;
  public String RPQ;
  public String RPV;
  public cyb RPW;
  public ciu RPX;
  public String rVG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82393);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.CqV);
      if (this.RPV != null) {
        paramVarArgs.f(2, this.RPV);
      }
      if (this.RPW != null)
      {
        paramVarArgs.oE(3, this.RPW.computeSize());
        this.RPW.writeFields(paramVarArgs);
      }
      if (this.RPQ != null) {
        paramVarArgs.f(4, this.RPQ);
      }
      if (this.rVG != null) {
        paramVarArgs.f(5, this.rVG);
      }
      if (this.RPX != null)
      {
        paramVarArgs.oE(6, this.RPX.computeSize());
        this.RPX.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(82393);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.CqV) + 0;
      paramInt = i;
      if (this.RPV != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.RPV);
      }
      i = paramInt;
      if (this.RPW != null) {
        i = paramInt + g.a.a.a.oD(3, this.RPW.computeSize());
      }
      paramInt = i;
      if (this.RPQ != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.RPQ);
      }
      i = paramInt;
      if (this.rVG != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.rVG);
      }
      paramInt = i;
      if (this.RPX != null) {
        paramInt = i + g.a.a.a.oD(6, this.RPX.computeSize());
      }
      AppMethodBeat.o(82393);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(82393);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      ku localku = (ku)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(82393);
        return -1;
      case 1: 
        localku.CqV = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(82393);
        return 0;
      case 2: 
        localku.RPV = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(82393);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cyb();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cyb)localObject2).parseFrom((byte[])localObject1);
          }
          localku.RPW = ((cyb)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(82393);
        return 0;
      case 4: 
        localku.RPQ = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(82393);
        return 0;
      case 5: 
        localku.rVG = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(82393);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new ciu();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((ciu)localObject2).parseFrom((byte[])localObject1);
        }
        localku.RPX = ((ciu)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(82393);
      return 0;
    }
    AppMethodBeat.o(82393);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ku
 * JD-Core Version:    0.7.0.1
 */