package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gft
  extends com.tencent.mm.bx.a
{
  public int YYs;
  public LinkedList<gfm> aaqz;
  public boolean aavs;
  
  public gft()
  {
    AppMethodBeat.i(32525);
    this.aaqz = new LinkedList();
    AppMethodBeat.o(32525);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32526);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.aaqz);
      paramVarArgs.bS(2, this.YYs);
      paramVarArgs.di(3, this.aavs);
      AppMethodBeat.o(32526);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.a.c(1, 8, this.aaqz);
      i = i.a.a.b.b.a.cJ(2, this.YYs);
      int j = i.a.a.b.b.a.ko(3);
      AppMethodBeat.o(32526);
      return paramInt + 0 + i + (j + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.aaqz.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(32526);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      gft localgft = (gft)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32526);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          gfm localgfm = new gfm();
          if ((localObject != null) && (localObject.length > 0)) {
            localgfm.parseFrom((byte[])localObject);
          }
          localgft.aaqz.add(localgfm);
          paramInt += 1;
        }
        AppMethodBeat.o(32526);
        return 0;
      case 2: 
        localgft.YYs = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(32526);
        return 0;
      }
      localgft.aavs = ((i.a.a.a.a)localObject).ajGk.aai();
      AppMethodBeat.o(32526);
      return 0;
    }
    AppMethodBeat.o(32526);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gft
 * JD-Core Version:    0.7.0.1
 */