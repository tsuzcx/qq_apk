package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class duh
  extends com.tencent.mm.bx.a
{
  public int abaj;
  public int abak;
  public dth abal;
  public bun abam;
  public int vhJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259108);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.vhJ);
      paramVarArgs.bS(2, this.abaj);
      paramVarArgs.bS(3, this.abak);
      if (this.abal != null)
      {
        paramVarArgs.qD(4, this.abal.computeSize());
        this.abal.writeFields(paramVarArgs);
      }
      if (this.abam != null)
      {
        paramVarArgs.qD(5, this.abam.computeSize());
        this.abam.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(259108);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.vhJ) + 0 + i.a.a.b.b.a.cJ(2, this.abaj) + i.a.a.b.b.a.cJ(3, this.abak);
      paramInt = i;
      if (this.abal != null) {
        paramInt = i + i.a.a.a.qC(4, this.abal.computeSize());
      }
      i = paramInt;
      if (this.abam != null) {
        i = paramInt + i.a.a.a.qC(5, this.abam.computeSize());
      }
      AppMethodBeat.o(259108);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259108);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      duh localduh = (duh)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(259108);
        return -1;
      case 1: 
        localduh.vhJ = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(259108);
        return 0;
      case 2: 
        localduh.abaj = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(259108);
        return 0;
      case 3: 
        localduh.abak = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(259108);
        return 0;
      case 4: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dth();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dth)localObject2).parseFrom((byte[])localObject1);
          }
          localduh.abal = ((dth)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(259108);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new bun();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((bun)localObject2).parseFrom((byte[])localObject1);
        }
        localduh.abam = ((bun)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(259108);
      return 0;
    }
    AppMethodBeat.o(259108);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.duh
 * JD-Core Version:    0.7.0.1
 */