package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dvq
  extends com.tencent.mm.bx.a
{
  public int CJd;
  public boolean EJG;
  public String nickname;
  public String sYq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153328);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.CJd);
      if (this.sYq != null) {
        paramVarArgs.d(2, this.sYq);
      }
      if (this.nickname != null) {
        paramVarArgs.d(3, this.nickname);
      }
      paramVarArgs.bg(4, this.EJG);
      AppMethodBeat.o(153328);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.CJd) + 0;
      paramInt = i;
      if (this.sYq != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.sYq);
      }
      i = paramInt;
      if (this.nickname != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.nickname);
      }
      paramInt = f.a.a.b.b.a.fY(4);
      AppMethodBeat.o(153328);
      return i + (paramInt + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(153328);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dvq localdvq = (dvq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(153328);
        return -1;
      case 1: 
        localdvq.CJd = locala.KhF.xS();
        AppMethodBeat.o(153328);
        return 0;
      case 2: 
        localdvq.sYq = locala.KhF.readString();
        AppMethodBeat.o(153328);
        return 0;
      case 3: 
        localdvq.nickname = locala.KhF.readString();
        AppMethodBeat.o(153328);
        return 0;
      }
      localdvq.EJG = locala.KhF.fHu();
      AppMethodBeat.o(153328);
      return 0;
    }
    AppMethodBeat.o(153328);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvq
 * JD-Core Version:    0.7.0.1
 */