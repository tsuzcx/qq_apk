package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aog
  extends com.tencent.mm.cd.a
{
  public String RUd;
  public LinkedList<aoa> SAG;
  public aoa SAH;
  public int jUk;
  
  public aog()
  {
    AppMethodBeat.i(127478);
    this.SAG = new LinkedList();
    AppMethodBeat.o(127478);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127479);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.jUk);
      if (this.RUd != null) {
        paramVarArgs.f(2, this.RUd);
      }
      paramVarArgs.e(3, 8, this.SAG);
      if (this.SAH != null)
      {
        paramVarArgs.oE(4, this.SAH.computeSize());
        this.SAH.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(127479);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.jUk) + 0;
      paramInt = i;
      if (this.RUd != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.RUd);
      }
      i = paramInt + g.a.a.a.c(3, 8, this.SAG);
      paramInt = i;
      if (this.SAH != null) {
        paramInt = i + g.a.a.a.oD(4, this.SAH.computeSize());
      }
      AppMethodBeat.o(127479);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.SAG.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(127479);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      aog localaog = (aog)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      aoa localaoa;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(127479);
        return -1;
      case 1: 
        localaog.jUk = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(127479);
        return 0;
      case 2: 
        localaog.RUd = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(127479);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localaoa = new aoa();
          if ((localObject != null) && (localObject.length > 0)) {
            localaoa.parseFrom((byte[])localObject);
          }
          localaog.SAG.add(localaoa);
          paramInt += 1;
        }
        AppMethodBeat.o(127479);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        localaoa = new aoa();
        if ((localObject != null) && (localObject.length > 0)) {
          localaoa.parseFrom((byte[])localObject);
        }
        localaog.SAH = localaoa;
        paramInt += 1;
      }
      AppMethodBeat.o(127479);
      return 0;
    }
    AppMethodBeat.o(127479);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aog
 * JD-Core Version:    0.7.0.1
 */