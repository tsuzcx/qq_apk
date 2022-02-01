package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ali
  extends com.tencent.mm.bw.a
{
  public LinkedList<String> Gcm;
  public int Gcn;
  
  public ali()
  {
    AppMethodBeat.i(124487);
    this.Gcm = new LinkedList();
    this.Gcn = 1;
    AppMethodBeat.o(124487);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124488);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.Gcm);
      paramVarArgs.aS(2, this.Gcn);
      AppMethodBeat.o(124488);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.a.c(1, 1, this.Gcm);
      int i = f.a.a.b.b.a.bz(2, this.Gcn);
      AppMethodBeat.o(124488);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Gcm.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(124488);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ali localali = (ali)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124488);
        return -1;
      case 1: 
        localali.Gcm.add(locala.OmT.readString());
        AppMethodBeat.o(124488);
        return 0;
      }
      localali.Gcn = locala.OmT.zc();
      AppMethodBeat.o(124488);
      return 0;
    }
    AppMethodBeat.o(124488);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ali
 * JD-Core Version:    0.7.0.1
 */