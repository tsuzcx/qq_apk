package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ggg
  extends com.tencent.mm.bx.a
{
  public boolean aavs;
  public LinkedList<gge> aazx;
  public boolean accV;
  
  public ggg()
  {
    AppMethodBeat.i(32541);
    this.aazx = new LinkedList();
    AppMethodBeat.o(32541);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32542);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.di(1, this.aavs);
      paramVarArgs.e(2, 8, this.aazx);
      paramVarArgs.di(3, this.accV);
      AppMethodBeat.o(32542);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.ko(1);
      i = i.a.a.a.c(2, 8, this.aazx);
      int j = i.a.a.b.b.a.ko(3);
      AppMethodBeat.o(32542);
      return paramInt + 1 + 0 + i + (j + 1);
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
      AppMethodBeat.o(32542);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      ggg localggg = (ggg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32542);
        return -1;
      case 1: 
        localggg.aavs = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(32542);
        return 0;
      case 2: 
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
          localggg.aazx.add(localgge);
          paramInt += 1;
        }
        AppMethodBeat.o(32542);
        return 0;
      }
      localggg.accV = ((i.a.a.a.a)localObject).ajGk.aai();
      AppMethodBeat.o(32542);
      return 0;
    }
    AppMethodBeat.o(32542);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ggg
 * JD-Core Version:    0.7.0.1
 */