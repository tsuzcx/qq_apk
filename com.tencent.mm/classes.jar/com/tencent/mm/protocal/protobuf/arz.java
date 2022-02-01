package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class arz
  extends com.tencent.mm.bx.a
{
  public String YRE;
  public LinkedList<art> ZBy;
  public art ZBz;
  public int muC;
  
  public arz()
  {
    AppMethodBeat.i(127478);
    this.ZBy = new LinkedList();
    AppMethodBeat.o(127478);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127479);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.muC);
      if (this.YRE != null) {
        paramVarArgs.g(2, this.YRE);
      }
      paramVarArgs.e(3, 8, this.ZBy);
      if (this.ZBz != null)
      {
        paramVarArgs.qD(4, this.ZBz.computeSize());
        this.ZBz.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(127479);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.muC) + 0;
      paramInt = i;
      if (this.YRE != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.YRE);
      }
      i = paramInt + i.a.a.a.c(3, 8, this.ZBy);
      paramInt = i;
      if (this.ZBz != null) {
        paramInt = i + i.a.a.a.qC(4, this.ZBz.computeSize());
      }
      AppMethodBeat.o(127479);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ZBy.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(127479);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      arz localarz = (arz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      art localart;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(127479);
        return -1;
      case 1: 
        localarz.muC = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(127479);
        return 0;
      case 2: 
        localarz.YRE = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(127479);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localart = new art();
          if ((localObject != null) && (localObject.length > 0)) {
            localart.parseFrom((byte[])localObject);
          }
          localarz.ZBy.add(localart);
          paramInt += 1;
        }
        AppMethodBeat.o(127479);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        localart = new art();
        if ((localObject != null) && (localObject.length > 0)) {
          localart.parseFrom((byte[])localObject);
        }
        localarz.ZBz = localart;
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.arz
 * JD-Core Version:    0.7.0.1
 */