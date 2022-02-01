package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cna
  extends com.tencent.mm.bw.a
{
  public long Gbf;
  public long Hzb;
  public int oIh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104829);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.oIh);
      paramVarArgs.aZ(2, this.Gbf);
      paramVarArgs.aZ(3, this.Hzb);
      AppMethodBeat.o(104829);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.oIh);
      int i = f.a.a.b.b.a.p(2, this.Gbf);
      int j = f.a.a.b.b.a.p(3, this.Hzb);
      AppMethodBeat.o(104829);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(104829);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cna localcna = (cna)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(104829);
        return -1;
      case 1: 
        localcna.oIh = locala.OmT.zc();
        AppMethodBeat.o(104829);
        return 0;
      case 2: 
        localcna.Gbf = locala.OmT.zd();
        AppMethodBeat.o(104829);
        return 0;
      }
      localcna.Hzb = locala.OmT.zd();
      AppMethodBeat.o(104829);
      return 0;
    }
    AppMethodBeat.o(104829);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cna
 * JD-Core Version:    0.7.0.1
 */