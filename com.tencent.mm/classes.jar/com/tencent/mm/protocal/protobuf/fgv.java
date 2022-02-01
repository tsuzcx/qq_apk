package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fgv
  extends com.tencent.mm.bx.a
{
  public int ZlG;
  public com.tencent.mm.bx.b aaPP;
  public LinkedList<fgt> abHa;
  public int abHb;
  public int interval;
  
  public fgv()
  {
    AppMethodBeat.i(257702);
    this.abHa = new LinkedList();
    AppMethodBeat.o(257702);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257708);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaPP == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: ctx");
        AppMethodBeat.o(257708);
        throw paramVarArgs;
      }
      paramVarArgs.e(1, 8, this.abHa);
      paramVarArgs.bS(2, this.interval);
      paramVarArgs.bS(3, this.abHb);
      if (this.aaPP != null) {
        paramVarArgs.d(4, this.aaPP);
      }
      paramVarArgs.bS(5, this.ZlG);
      AppMethodBeat.o(257708);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 8, this.abHa) + 0 + i.a.a.b.b.a.cJ(2, this.interval) + i.a.a.b.b.a.cJ(3, this.abHb);
      paramInt = i;
      if (this.aaPP != null) {
        paramInt = i + i.a.a.b.b.a.c(4, this.aaPP);
      }
      i = i.a.a.b.b.a.cJ(5, this.ZlG);
      AppMethodBeat.o(257708);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.abHa.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      if (this.aaPP == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: ctx");
        AppMethodBeat.o(257708);
        throw paramVarArgs;
      }
      AppMethodBeat.o(257708);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      fgv localfgv = (fgv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(257708);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          fgt localfgt = new fgt();
          if ((localObject != null) && (localObject.length > 0)) {
            localfgt.parseFrom((byte[])localObject);
          }
          localfgv.abHa.add(localfgt);
          paramInt += 1;
        }
        AppMethodBeat.o(257708);
        return 0;
      case 2: 
        localfgv.interval = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(257708);
        return 0;
      case 3: 
        localfgv.abHb = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(257708);
        return 0;
      case 4: 
        localfgv.aaPP = ((i.a.a.a.a)localObject).ajGk.kFX();
        AppMethodBeat.o(257708);
        return 0;
      }
      localfgv.ZlG = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(257708);
      return 0;
    }
    AppMethodBeat.o(257708);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fgv
 * JD-Core Version:    0.7.0.1
 */