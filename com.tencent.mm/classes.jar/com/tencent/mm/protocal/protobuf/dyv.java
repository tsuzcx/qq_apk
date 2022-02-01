package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class dyv
  extends com.tencent.mm.bw.a
{
  public long Gxr;
  public long HSD;
  public int Iee;
  public int Ief;
  public int Ieg;
  public int Ieh;
  public b Iei;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125501);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.HSD);
      paramVarArgs.aZ(2, this.Gxr);
      paramVarArgs.aS(3, this.Iee);
      paramVarArgs.aS(4, this.Ief);
      paramVarArgs.aS(5, this.Ieg);
      paramVarArgs.aS(6, this.Ieh);
      if (this.Iei != null) {
        paramVarArgs.c(7, this.Iei);
      }
      AppMethodBeat.o(125501);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.HSD) + 0 + f.a.a.b.b.a.p(2, this.Gxr) + f.a.a.b.b.a.bz(3, this.Iee) + f.a.a.b.b.a.bz(4, this.Ief) + f.a.a.b.b.a.bz(5, this.Ieg) + f.a.a.b.b.a.bz(6, this.Ieh);
      paramInt = i;
      if (this.Iei != null) {
        paramInt = i + f.a.a.b.b.a.b(7, this.Iei);
      }
      AppMethodBeat.o(125501);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(125501);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dyv localdyv = (dyv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125501);
        return -1;
      case 1: 
        localdyv.HSD = locala.OmT.zd();
        AppMethodBeat.o(125501);
        return 0;
      case 2: 
        localdyv.Gxr = locala.OmT.zd();
        AppMethodBeat.o(125501);
        return 0;
      case 3: 
        localdyv.Iee = locala.OmT.zc();
        AppMethodBeat.o(125501);
        return 0;
      case 4: 
        localdyv.Ief = locala.OmT.zc();
        AppMethodBeat.o(125501);
        return 0;
      case 5: 
        localdyv.Ieg = locala.OmT.zc();
        AppMethodBeat.o(125501);
        return 0;
      case 6: 
        localdyv.Ieh = locala.OmT.zc();
        AppMethodBeat.o(125501);
        return 0;
      }
      localdyv.Iei = locala.OmT.gCk();
      AppMethodBeat.o(125501);
      return 0;
    }
    AppMethodBeat.o(125501);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyv
 * JD-Core Version:    0.7.0.1
 */