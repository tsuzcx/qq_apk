package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class w
  extends com.tencent.mm.bx.a
{
  public int dLt;
  public String hQG;
  public int id;
  public int status;
  public String xrv;
  public b xrw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(27828);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.id);
      paramVarArgs.aS(2, this.status);
      if (this.xrv != null) {
        paramVarArgs.d(3, this.xrv);
      }
      if (this.hQG != null) {
        paramVarArgs.d(4, this.hQG);
      }
      if (this.xrw != null) {
        paramVarArgs.c(5, this.xrw);
      }
      paramVarArgs.aS(6, this.dLt);
      AppMethodBeat.o(27828);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.id) + 0 + f.a.a.b.b.a.bz(2, this.status);
      paramInt = i;
      if (this.xrv != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.xrv);
      }
      i = paramInt;
      if (this.hQG != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.hQG);
      }
      paramInt = i;
      if (this.xrw != null) {
        paramInt = i + f.a.a.b.b.a.b(5, this.xrw);
      }
      i = f.a.a.b.b.a.bz(6, this.dLt);
      AppMethodBeat.o(27828);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(27828);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      w localw = (w)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(27828);
        return -1;
      case 1: 
        localw.id = locala.NPN.zc();
        AppMethodBeat.o(27828);
        return 0;
      case 2: 
        localw.status = locala.NPN.zc();
        AppMethodBeat.o(27828);
        return 0;
      case 3: 
        localw.xrv = locala.NPN.readString();
        AppMethodBeat.o(27828);
        return 0;
      case 4: 
        localw.hQG = locala.NPN.readString();
        AppMethodBeat.o(27828);
        return 0;
      case 5: 
        localw.xrw = locala.NPN.gxI();
        AppMethodBeat.o(27828);
        return 0;
      }
      localw.dLt = locala.NPN.zc();
      AppMethodBeat.o(27828);
      return 0;
    }
    AppMethodBeat.o(27828);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.w
 * JD-Core Version:    0.7.0.1
 */