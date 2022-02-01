package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class efl
  extends com.tencent.mm.bx.a
{
  public LinkedList<String> HQI;
  public int version;
  
  public efl()
  {
    AppMethodBeat.i(219112);
    this.HQI = new LinkedList();
    AppMethodBeat.o(219112);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(219113);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.version);
      paramVarArgs.e(2, 1, this.HQI);
      AppMethodBeat.o(219113);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.version);
      int i = f.a.a.a.c(2, 1, this.HQI);
      AppMethodBeat.o(219113);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.HQI.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(219113);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      efl localefl = (efl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(219113);
        return -1;
      case 1: 
        localefl.version = locala.NPN.zc();
        AppMethodBeat.o(219113);
        return 0;
      }
      localefl.HQI.add(locala.NPN.readString());
      AppMethodBeat.o(219113);
      return 0;
    }
    AppMethodBeat.o(219113);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.efl
 * JD-Core Version:    0.7.0.1
 */