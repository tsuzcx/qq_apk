package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends com.tencent.mm.bw.a
{
  public String dlQ;
  public int drx;
  public String oxl;
  public String unW;
  public String unX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91310);
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
      AppMethodBeat.o(91310);
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
      AppMethodBeat.o(91310);
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
      AppMethodBeat.o(91310);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      a locala1 = (a)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91310);
        return -1;
      case 1: 
        locala1.drx = locala.LVo.xF();
        AppMethodBeat.o(91310);
        return 0;
      case 2: 
        locala1.dlQ = locala.LVo.readString();
        AppMethodBeat.o(91310);
        return 0;
      case 3: 
        locala1.unW = locala.LVo.readString();
        AppMethodBeat.o(91310);
        return 0;
      case 4: 
        locala1.unX = locala.LVo.readString();
        AppMethodBeat.o(91310);
        return 0;
      }
      locala1.oxl = locala.LVo.readString();
      AppMethodBeat.o(91310);
      return 0;
    }
    AppMethodBeat.o(91310);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.a
 * JD-Core Version:    0.7.0.1
 */