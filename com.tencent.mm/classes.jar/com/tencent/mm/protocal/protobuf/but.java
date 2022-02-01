package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class but
  extends com.tencent.mm.bx.a
{
  public String Fsd;
  public String GOI;
  public String GOM;
  public String nickname;
  public String pjL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(211967);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GOM != null) {
        paramVarArgs.d(1, this.GOM);
      }
      if (this.nickname != null) {
        paramVarArgs.d(2, this.nickname);
      }
      if (this.pjL != null) {
        paramVarArgs.d(3, this.pjL);
      }
      if (this.GOI != null) {
        paramVarArgs.d(4, this.GOI);
      }
      if (this.Fsd != null) {
        paramVarArgs.d(5, this.Fsd);
      }
      AppMethodBeat.o(211967);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GOM == null) {
        break label454;
      }
    }
    label454:
    for (int i = f.a.a.b.b.a.e(1, this.GOM) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nickname);
      }
      i = paramInt;
      if (this.pjL != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.pjL);
      }
      paramInt = i;
      if (this.GOI != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GOI);
      }
      i = paramInt;
      if (this.Fsd != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Fsd);
      }
      AppMethodBeat.o(211967);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(211967);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        but localbut = (but)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(211967);
          return -1;
        case 1: 
          localbut.GOM = locala.NPN.readString();
          AppMethodBeat.o(211967);
          return 0;
        case 2: 
          localbut.nickname = locala.NPN.readString();
          AppMethodBeat.o(211967);
          return 0;
        case 3: 
          localbut.pjL = locala.NPN.readString();
          AppMethodBeat.o(211967);
          return 0;
        case 4: 
          localbut.GOI = locala.NPN.readString();
          AppMethodBeat.o(211967);
          return 0;
        }
        localbut.Fsd = locala.NPN.readString();
        AppMethodBeat.o(211967);
        return 0;
      }
      AppMethodBeat.o(211967);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.but
 * JD-Core Version:    0.7.0.1
 */