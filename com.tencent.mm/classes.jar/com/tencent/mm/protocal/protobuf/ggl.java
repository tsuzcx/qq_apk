package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ggl
  extends com.tencent.mm.bx.a
{
  public boolean aavs;
  public LinkedList<gge> aazx;
  
  public ggl()
  {
    AppMethodBeat.i(32548);
    this.aazx = new LinkedList();
    AppMethodBeat.o(32548);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32549);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.di(1, this.aavs);
      paramVarArgs.e(2, 8, this.aazx);
      AppMethodBeat.o(32549);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.ko(1);
      i = i.a.a.a.c(2, 8, this.aazx);
      AppMethodBeat.o(32549);
      return paramInt + 1 + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.aazx.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(32549);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      ggl localggl = (ggl)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32549);
        return -1;
      case 1: 
        localggl.aavs = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(32549);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        gge localgge = new gge();
        if ((localObject != null) && (localObject.length > 0)) {
          localgge.parseFrom((byte[])localObject);
        }
        localggl.aazx.add(localgge);
        paramInt += 1;
      }
      AppMethodBeat.o(32549);
      return 0;
    }
    AppMethodBeat.o(32549);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ggl
 * JD-Core Version:    0.7.0.1
 */