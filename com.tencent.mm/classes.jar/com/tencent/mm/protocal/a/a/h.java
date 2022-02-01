package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class h
  extends com.tencent.mm.bx.a
{
  public int YyT;
  public int YyU;
  public o YyV;
  public o YyW;
  public int YyX;
  public int YyY;
  public int Yzm;
  public int ret;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143949);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.ret);
      paramVarArgs.bS(2, this.YyT);
      paramVarArgs.bS(3, this.YyU);
      if (this.YyV != null)
      {
        paramVarArgs.qD(4, this.YyV.computeSize());
        this.YyV.writeFields(paramVarArgs);
      }
      if (this.YyW != null)
      {
        paramVarArgs.qD(5, this.YyW.computeSize());
        this.YyW.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(6, this.YyX);
      paramVarArgs.bS(7, this.Yzm);
      paramVarArgs.bS(8, this.YyY);
      AppMethodBeat.o(143949);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.ret) + 0 + i.a.a.b.b.a.cJ(2, this.YyT) + i.a.a.b.b.a.cJ(3, this.YyU);
      paramInt = i;
      if (this.YyV != null) {
        paramInt = i + i.a.a.a.qC(4, this.YyV.computeSize());
      }
      i = paramInt;
      if (this.YyW != null) {
        i = paramInt + i.a.a.a.qC(5, this.YyW.computeSize());
      }
      paramInt = i.a.a.b.b.a.cJ(6, this.YyX);
      int j = i.a.a.b.b.a.cJ(7, this.Yzm);
      int k = i.a.a.b.b.a.cJ(8, this.YyY);
      AppMethodBeat.o(143949);
      return i + paramInt + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(143949);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      h localh = (h)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      o localo;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143949);
        return -1;
      case 1: 
        localh.ret = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(143949);
        return 0;
      case 2: 
        localh.YyT = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(143949);
        return 0;
      case 3: 
        localh.YyU = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(143949);
        return 0;
      case 4: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localo = new o();
          if ((localObject != null) && (localObject.length > 0)) {
            localo.parseFrom((byte[])localObject);
          }
          localh.YyV = localo;
          paramInt += 1;
        }
        AppMethodBeat.o(143949);
        return 0;
      case 5: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localo = new o();
          if ((localObject != null) && (localObject.length > 0)) {
            localo.parseFrom((byte[])localObject);
          }
          localh.YyW = localo;
          paramInt += 1;
        }
        AppMethodBeat.o(143949);
        return 0;
      case 6: 
        localh.YyX = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(143949);
        return 0;
      case 7: 
        localh.Yzm = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(143949);
        return 0;
      }
      localh.YyY = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(143949);
      return 0;
    }
    AppMethodBeat.o(143949);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.h
 * JD-Core Version:    0.7.0.1
 */