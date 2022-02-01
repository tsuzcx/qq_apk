package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dqt
  extends com.tencent.mm.bx.a
{
  public String Hsg;
  public int Hsk;
  public String Hsm;
  public String content;
  public int dlw;
  public int state;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153308);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hsm != null) {
        paramVarArgs.d(1, this.Hsm);
      }
      paramVarArgs.aS(2, this.dlw);
      if (this.content != null) {
        paramVarArgs.d(3, this.content);
      }
      if (this.Hsg != null) {
        paramVarArgs.d(4, this.Hsg);
      }
      paramVarArgs.aS(5, this.Hsk);
      paramVarArgs.aS(6, this.state);
      AppMethodBeat.o(153308);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Hsm == null) {
        break label470;
      }
    }
    label470:
    for (paramInt = f.a.a.b.b.a.e(1, this.Hsm) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.dlw);
      paramInt = i;
      if (this.content != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.content);
      }
      i = paramInt;
      if (this.Hsg != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Hsg);
      }
      paramInt = f.a.a.b.b.a.bz(5, this.Hsk);
      int j = f.a.a.b.b.a.bz(6, this.state);
      AppMethodBeat.o(153308);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(153308);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dqt localdqt = (dqt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153308);
          return -1;
        case 1: 
          localdqt.Hsm = locala.NPN.readString();
          AppMethodBeat.o(153308);
          return 0;
        case 2: 
          localdqt.dlw = locala.NPN.zc();
          AppMethodBeat.o(153308);
          return 0;
        case 3: 
          localdqt.content = locala.NPN.readString();
          AppMethodBeat.o(153308);
          return 0;
        case 4: 
          localdqt.Hsg = locala.NPN.readString();
          AppMethodBeat.o(153308);
          return 0;
        case 5: 
          localdqt.Hsk = locala.NPN.zc();
          AppMethodBeat.o(153308);
          return 0;
        }
        localdqt.state = locala.NPN.zc();
        AppMethodBeat.o(153308);
        return 0;
      }
      AppMethodBeat.o(153308);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqt
 * JD-Core Version:    0.7.0.1
 */