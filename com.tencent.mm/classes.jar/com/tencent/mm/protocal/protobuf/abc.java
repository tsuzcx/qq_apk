package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class abc
  extends com.tencent.mm.bw.a
{
  public int GsO;
  public String GsV;
  public LinkedList<String> GsW;
  public long Gsg;
  
  public abc()
  {
    AppMethodBeat.i(211623);
    this.GsW = new LinkedList();
    AppMethodBeat.o(211623);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(211624);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.Gsg);
      if (this.GsV != null) {
        paramVarArgs.d(2, this.GsV);
      }
      paramVarArgs.e(3, 1, this.GsW);
      paramVarArgs.aS(4, this.GsO);
      AppMethodBeat.o(211624);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.Gsg) + 0;
      paramInt = i;
      if (this.GsV != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GsV);
      }
      i = f.a.a.a.c(3, 1, this.GsW);
      int j = f.a.a.b.b.a.bz(4, this.GsO);
      AppMethodBeat.o(211624);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.GsW.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(211624);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      abc localabc = (abc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(211624);
        return -1;
      case 1: 
        localabc.Gsg = locala.OmT.zd();
        AppMethodBeat.o(211624);
        return 0;
      case 2: 
        localabc.GsV = locala.OmT.readString();
        AppMethodBeat.o(211624);
        return 0;
      case 3: 
        localabc.GsW.add(locala.OmT.readString());
        AppMethodBeat.o(211624);
        return 0;
      }
      localabc.GsO = locala.OmT.zc();
      AppMethodBeat.o(211624);
      return 0;
    }
    AppMethodBeat.o(211624);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abc
 * JD-Core Version:    0.7.0.1
 */