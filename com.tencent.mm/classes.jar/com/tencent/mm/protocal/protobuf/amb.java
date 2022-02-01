package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class amb
  extends com.tencent.mm.bw.a
{
  public b GEv;
  public int cmdId;
  public String kuP;
  public int retCode;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168939);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.cmdId);
      paramVarArgs.aS(2, this.retCode);
      if (this.kuP != null) {
        paramVarArgs.d(3, this.kuP);
      }
      if (this.GEv != null) {
        paramVarArgs.c(4, this.GEv);
      }
      AppMethodBeat.o(168939);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.cmdId) + 0 + f.a.a.b.b.a.bz(2, this.retCode);
      paramInt = i;
      if (this.kuP != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.kuP);
      }
      i = paramInt;
      if (this.GEv != null) {
        i = paramInt + f.a.a.b.b.a.b(4, this.GEv);
      }
      AppMethodBeat.o(168939);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(168939);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      amb localamb = (amb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(168939);
        return -1;
      case 1: 
        localamb.cmdId = locala.OmT.zc();
        AppMethodBeat.o(168939);
        return 0;
      case 2: 
        localamb.retCode = locala.OmT.zc();
        AppMethodBeat.o(168939);
        return 0;
      case 3: 
        localamb.kuP = locala.OmT.readString();
        AppMethodBeat.o(168939);
        return 0;
      }
      localamb.GEv = locala.OmT.gCk();
      AppMethodBeat.o(168939);
      return 0;
    }
    AppMethodBeat.o(168939);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amb
 * JD-Core Version:    0.7.0.1
 */