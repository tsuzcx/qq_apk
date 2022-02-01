package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dm
  extends com.tencent.mm.bw.a
{
  public String dlQ;
  public int drx;
  public String oxl;
  public String unW;
  public String unX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72416);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.drx);
      if (this.dlQ != null) {
        paramVarArgs.d(2, this.dlQ);
      }
      if (this.unW != null) {
        paramVarArgs.d(3, this.unW);
      }
      if (this.unX != null) {
        paramVarArgs.d(4, this.unX);
      }
      if (this.oxl != null) {
        paramVarArgs.d(5, this.oxl);
      }
      AppMethodBeat.o(72416);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.drx) + 0;
      paramInt = i;
      if (this.dlQ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dlQ);
      }
      i = paramInt;
      if (this.unW != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.unW);
      }
      paramInt = i;
      if (this.unX != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.unX);
      }
      i = paramInt;
      if (this.oxl != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.oxl);
      }
      AppMethodBeat.o(72416);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(72416);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dm localdm = (dm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(72416);
        return -1;
      case 1: 
        localdm.drx = locala.LVo.xF();
        AppMethodBeat.o(72416);
        return 0;
      case 2: 
        localdm.dlQ = locala.LVo.readString();
        AppMethodBeat.o(72416);
        return 0;
      case 3: 
        localdm.unW = locala.LVo.readString();
        AppMethodBeat.o(72416);
        return 0;
      case 4: 
        localdm.unX = locala.LVo.readString();
        AppMethodBeat.o(72416);
        return 0;
      }
      localdm.oxl = locala.LVo.readString();
      AppMethodBeat.o(72416);
      return 0;
    }
    AppMethodBeat.o(72416);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dm
 * JD-Core Version:    0.7.0.1
 */