package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ya
  extends com.tencent.mm.bx.a
{
  public LinkedList<String> FXE;
  public String FXF;
  public long FXG;
  public int nEf;
  
  public ya()
  {
    AppMethodBeat.i(6401);
    this.FXE = new LinkedList();
    AppMethodBeat.o(6401);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6402);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.nEf);
      paramVarArgs.e(2, 1, this.FXE);
      if (this.FXF != null) {
        paramVarArgs.d(3, this.FXF);
      }
      paramVarArgs.aY(4, this.FXG);
      AppMethodBeat.o(6402);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.nEf) + 0 + f.a.a.a.c(2, 1, this.FXE);
      paramInt = i;
      if (this.FXF != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.FXF);
      }
      i = f.a.a.b.b.a.p(4, this.FXG);
      AppMethodBeat.o(6402);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FXE.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(6402);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ya localya = (ya)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(6402);
        return -1;
      case 1: 
        localya.nEf = locala.NPN.zc();
        AppMethodBeat.o(6402);
        return 0;
      case 2: 
        localya.FXE.add(locala.NPN.readString());
        AppMethodBeat.o(6402);
        return 0;
      case 3: 
        localya.FXF = locala.NPN.readString();
        AppMethodBeat.o(6402);
        return 0;
      }
      localya.FXG = locala.NPN.zd();
      AppMethodBeat.o(6402);
      return 0;
    }
    AppMethodBeat.o(6402);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ya
 * JD-Core Version:    0.7.0.1
 */