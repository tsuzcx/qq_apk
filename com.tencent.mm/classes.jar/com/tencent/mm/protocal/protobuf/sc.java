package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class sc
  extends com.tencent.mm.bx.a
{
  public int YWW;
  public int YWX;
  public int YWY;
  public LinkedList<sb> YWZ;
  public LinkedList<sb> YXa;
  
  public sc()
  {
    AppMethodBeat.i(133159);
    this.YWZ = new LinkedList();
    this.YXa = new LinkedList();
    AppMethodBeat.o(133159);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133160);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.YWW);
      paramVarArgs.bS(2, this.YWX);
      paramVarArgs.bS(5, this.YWY);
      paramVarArgs.e(3, 8, this.YWZ);
      paramVarArgs.e(4, 8, this.YXa);
      AppMethodBeat.o(133160);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.YWW);
      i = i.a.a.b.b.a.cJ(2, this.YWX);
      int j = i.a.a.b.b.a.cJ(5, this.YWY);
      int k = i.a.a.a.c(3, 8, this.YWZ);
      int m = i.a.a.a.c(4, 8, this.YXa);
      AppMethodBeat.o(133160);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.YWZ.clear();
      this.YXa.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(133160);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      sc localsc = (sc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      sb localsb;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(133160);
        return -1;
      case 1: 
        localsc.YWW = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(133160);
        return 0;
      case 2: 
        localsc.YWX = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(133160);
        return 0;
      case 5: 
        localsc.YWY = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(133160);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localsb = new sb();
          if ((localObject != null) && (localObject.length > 0)) {
            localsb.parseFrom((byte[])localObject);
          }
          localsc.YWZ.add(localsb);
          paramInt += 1;
        }
        AppMethodBeat.o(133160);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        localsb = new sb();
        if ((localObject != null) && (localObject.length > 0)) {
          localsb.parseFrom((byte[])localObject);
        }
        localsc.YXa.add(localsb);
        paramInt += 1;
      }
      AppMethodBeat.o(133160);
      return 0;
    }
    AppMethodBeat.o(133160);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sc
 * JD-Core Version:    0.7.0.1
 */