package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class csd
  extends com.tencent.mm.bw.a
{
  public int Category;
  public int HDj;
  public int HDk;
  public LinkedList<String> HDl;
  public int HDm;
  
  public csd()
  {
    AppMethodBeat.i(117893);
    this.HDl = new LinkedList();
    AppMethodBeat.o(117893);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117894);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HDj);
      paramVarArgs.aS(2, this.HDk);
      paramVarArgs.aS(3, this.Category);
      paramVarArgs.e(4, 1, this.HDl);
      paramVarArgs.aS(5, this.HDm);
      AppMethodBeat.o(117894);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.HDj);
      int i = f.a.a.b.b.a.bz(2, this.HDk);
      int j = f.a.a.b.b.a.bz(3, this.Category);
      int k = f.a.a.a.c(4, 1, this.HDl);
      int m = f.a.a.b.b.a.bz(5, this.HDm);
      AppMethodBeat.o(117894);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.HDl.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(117894);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      csd localcsd = (csd)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117894);
        return -1;
      case 1: 
        localcsd.HDj = locala.OmT.zc();
        AppMethodBeat.o(117894);
        return 0;
      case 2: 
        localcsd.HDk = locala.OmT.zc();
        AppMethodBeat.o(117894);
        return 0;
      case 3: 
        localcsd.Category = locala.OmT.zc();
        AppMethodBeat.o(117894);
        return 0;
      case 4: 
        localcsd.HDl.add(locala.OmT.readString());
        AppMethodBeat.o(117894);
        return 0;
      }
      localcsd.HDm = locala.OmT.zc();
      AppMethodBeat.o(117894);
      return 0;
    }
    AppMethodBeat.o(117894);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csd
 * JD-Core Version:    0.7.0.1
 */