package com.tencent.mm.smiley;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class d
  extends com.tencent.mm.bx.a
{
  public q acwN;
  public int acxf = -1;
  public int acxg;
  public String acxh;
  public int acxi;
  public int dIY;
  public int size;
  public int uKE;
  public int uKF;
  public int uKG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104918);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.uKE);
      paramVarArgs.bS(2, this.uKF);
      paramVarArgs.bS(3, this.uKG);
      paramVarArgs.bS(41, this.acxf);
      paramVarArgs.bS(5, this.acxg);
      paramVarArgs.bS(6, this.dIY);
      paramVarArgs.bS(7, this.size);
      if (this.acxh != null) {
        paramVarArgs.g(8, this.acxh);
      }
      paramVarArgs.bS(9, this.acxi);
      if (this.acwN != null)
      {
        paramVarArgs.qD(10, this.acwN.computeSize());
        this.acwN.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(104918);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.uKE) + 0 + i.a.a.b.b.a.cJ(2, this.uKF) + i.a.a.b.b.a.cJ(3, this.uKG) + i.a.a.b.b.a.cJ(41, this.acxf) + i.a.a.b.b.a.cJ(5, this.acxg) + i.a.a.b.b.a.cJ(6, this.dIY) + i.a.a.b.b.a.cJ(7, this.size);
      paramInt = i;
      if (this.acxh != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.acxh);
      }
      i = paramInt + i.a.a.b.b.a.cJ(9, this.acxi);
      paramInt = i;
      if (this.acwN != null) {
        paramInt = i + i.a.a.a.qC(10, this.acwN.computeSize());
      }
      AppMethodBeat.o(104918);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(104918);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      d locald = (d)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(104918);
        return -1;
      case 1: 
        locald.uKE = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(104918);
        return 0;
      case 2: 
        locald.uKF = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(104918);
        return 0;
      case 3: 
        locald.uKG = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(104918);
        return 0;
      case 41: 
        locald.acxf = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(104918);
        return 0;
      case 5: 
        locald.acxg = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(104918);
        return 0;
      case 6: 
        locald.dIY = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(104918);
        return 0;
      case 7: 
        locald.size = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(104918);
        return 0;
      case 8: 
        locald.acxh = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(104918);
        return 0;
      case 9: 
        locald.acxi = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(104918);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        q localq = new q();
        if ((localObject != null) && (localObject.length > 0)) {
          localq.parseFrom((byte[])localObject);
        }
        locald.acwN = localq;
        paramInt += 1;
      }
      AppMethodBeat.o(104918);
      return 0;
    }
    AppMethodBeat.o(104918);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.smiley.d
 * JD-Core Version:    0.7.0.1
 */