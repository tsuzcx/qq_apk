package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class f
  extends com.tencent.mm.bx.a
{
  public int YyT;
  public int YyU;
  public o YyV;
  public o YyW;
  public int YyX;
  public int YyY;
  public int Yzh;
  public o Yzi;
  public int ret;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143946);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.ret);
      paramVarArgs.bS(2, this.YyT);
      paramVarArgs.bS(3, this.YyU);
      paramVarArgs.bS(4, this.Yzh);
      if (this.YyV != null)
      {
        paramVarArgs.qD(5, this.YyV.computeSize());
        this.YyV.writeFields(paramVarArgs);
      }
      if (this.YyW != null)
      {
        paramVarArgs.qD(6, this.YyW.computeSize());
        this.YyW.writeFields(paramVarArgs);
      }
      if (this.Yzi != null)
      {
        paramVarArgs.qD(7, this.Yzi.computeSize());
        this.Yzi.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(8, this.YyX);
      paramVarArgs.bS(9, this.YyY);
      AppMethodBeat.o(143946);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.ret) + 0 + i.a.a.b.b.a.cJ(2, this.YyT) + i.a.a.b.b.a.cJ(3, this.YyU) + i.a.a.b.b.a.cJ(4, this.Yzh);
      paramInt = i;
      if (this.YyV != null) {
        paramInt = i + i.a.a.a.qC(5, this.YyV.computeSize());
      }
      i = paramInt;
      if (this.YyW != null) {
        i = paramInt + i.a.a.a.qC(6, this.YyW.computeSize());
      }
      paramInt = i;
      if (this.Yzi != null) {
        paramInt = i + i.a.a.a.qC(7, this.Yzi.computeSize());
      }
      i = i.a.a.b.b.a.cJ(8, this.YyX);
      int j = i.a.a.b.b.a.cJ(9, this.YyY);
      AppMethodBeat.o(143946);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(143946);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      f localf = (f)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      o localo;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143946);
        return -1;
      case 1: 
        localf.ret = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(143946);
        return 0;
      case 2: 
        localf.YyT = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(143946);
        return 0;
      case 3: 
        localf.YyU = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(143946);
        return 0;
      case 4: 
        localf.Yzh = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(143946);
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
          localf.YyV = localo;
          paramInt += 1;
        }
        AppMethodBeat.o(143946);
        return 0;
      case 6: 
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
          localf.YyW = localo;
          paramInt += 1;
        }
        AppMethodBeat.o(143946);
        return 0;
      case 7: 
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
          localf.Yzi = localo;
          paramInt += 1;
        }
        AppMethodBeat.o(143946);
        return 0;
      case 8: 
        localf.YyX = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(143946);
        return 0;
      }
      localf.YyY = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(143946);
      return 0;
    }
    AppMethodBeat.o(143946);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.f
 * JD-Core Version:    0.7.0.1
 */