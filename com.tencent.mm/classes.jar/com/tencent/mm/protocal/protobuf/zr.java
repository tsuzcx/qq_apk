package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class zr
  extends com.tencent.mm.bw.a
{
  public LinkedList<String> LkV;
  public String LkW;
  public long LkX;
  public int oUv;
  
  public zr()
  {
    AppMethodBeat.i(6401);
    this.LkV = new LinkedList();
    AppMethodBeat.o(6401);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6402);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.oUv);
      paramVarArgs.e(2, 1, this.LkV);
      if (this.LkW != null) {
        paramVarArgs.e(3, this.LkW);
      }
      paramVarArgs.bb(4, this.LkX);
      AppMethodBeat.o(6402);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.oUv) + 0 + g.a.a.a.c(2, 1, this.LkV);
      paramInt = i;
      if (this.LkW != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.LkW);
      }
      i = g.a.a.b.b.a.r(4, this.LkX);
      AppMethodBeat.o(6402);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.LkV.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(6402);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      zr localzr = (zr)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(6402);
        return -1;
      case 1: 
        localzr.oUv = locala.UbS.zi();
        AppMethodBeat.o(6402);
        return 0;
      case 2: 
        localzr.LkV.add(locala.UbS.readString());
        AppMethodBeat.o(6402);
        return 0;
      case 3: 
        localzr.LkW = locala.UbS.readString();
        AppMethodBeat.o(6402);
        return 0;
      }
      localzr.LkX = locala.UbS.zl();
      AppMethodBeat.o(6402);
      return 0;
    }
    AppMethodBeat.o(6402);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zr
 * JD-Core Version:    0.7.0.1
 */