package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class btk
  extends com.tencent.mm.bw.a
{
  public long GbU;
  public LinkedList<String> HgK;
  
  public btk()
  {
    AppMethodBeat.i(196272);
    this.GbU = 0L;
    this.HgK = new LinkedList();
    AppMethodBeat.o(196272);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(196273);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.GbU);
      paramVarArgs.e(2, 1, this.HgK);
      AppMethodBeat.o(196273);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.GbU);
      int i = f.a.a.a.c(2, 1, this.HgK);
      AppMethodBeat.o(196273);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.HgK.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(196273);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      btk localbtk = (btk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(196273);
        return -1;
      case 1: 
        localbtk.GbU = locala.OmT.zd();
        AppMethodBeat.o(196273);
        return 0;
      }
      localbtk.HgK.add(locala.OmT.readString());
      AppMethodBeat.o(196273);
      return 0;
    }
    AppMethodBeat.o(196273);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.btk
 * JD-Core Version:    0.7.0.1
 */