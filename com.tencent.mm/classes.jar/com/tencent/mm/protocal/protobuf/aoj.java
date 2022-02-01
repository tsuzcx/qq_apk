package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aoj
  extends com.tencent.mm.bx.a
{
  public int DVm;
  public int MRD;
  public boolean ZvO;
  public aka ZvP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259881);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.di(1, this.ZvO);
      if (this.ZvP != null)
      {
        paramVarArgs.qD(2, this.ZvP.computeSize());
        this.ZvP.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(3, this.MRD);
      paramVarArgs.bS(4, this.DVm);
      AppMethodBeat.o(259881);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.ko(1) + 1 + 0;
      paramInt = i;
      if (this.ZvP != null) {
        paramInt = i + i.a.a.a.qC(2, this.ZvP.computeSize());
      }
      i = i.a.a.b.b.a.cJ(3, this.MRD);
      int j = i.a.a.b.b.a.cJ(4, this.DVm);
      AppMethodBeat.o(259881);
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
      AppMethodBeat.o(259881);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      aoj localaoj = (aoj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(259881);
        return -1;
      case 1: 
        localaoj.ZvO = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(259881);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          aka localaka = new aka();
          if ((localObject != null) && (localObject.length > 0)) {
            localaka.parseFrom((byte[])localObject);
          }
          localaoj.ZvP = localaka;
          paramInt += 1;
        }
        AppMethodBeat.o(259881);
        return 0;
      case 3: 
        localaoj.MRD = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259881);
        return 0;
      }
      localaoj.DVm = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(259881);
      return 0;
    }
    AppMethodBeat.o(259881);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aoj
 * JD-Core Version:    0.7.0.1
 */