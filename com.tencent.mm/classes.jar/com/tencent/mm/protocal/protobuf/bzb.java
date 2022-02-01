package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bzb
  extends com.tencent.mm.bx.a
{
  public String desc;
  public String hzB;
  public String path;
  public String title;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91539);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.hzB != null) {
        paramVarArgs.d(1, this.hzB);
      }
      if (this.title != null) {
        paramVarArgs.d(2, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.d(3, this.desc);
      }
      if (this.username != null) {
        paramVarArgs.d(4, this.username);
      }
      if (this.path != null) {
        paramVarArgs.d(5, this.path);
      }
      AppMethodBeat.o(91539);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hzB == null) {
        break label454;
      }
    }
    label454:
    for (int i = f.a.a.b.b.a.e(1, this.hzB) + 0;; i = 0)
    {
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.title);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.desc);
      }
      paramInt = i;
      if (this.username != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.username);
      }
      i = paramInt;
      if (this.path != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.path);
      }
      AppMethodBeat.o(91539);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91539);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bzb localbzb = (bzb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91539);
          return -1;
        case 1: 
          localbzb.hzB = locala.NPN.readString();
          AppMethodBeat.o(91539);
          return 0;
        case 2: 
          localbzb.title = locala.NPN.readString();
          AppMethodBeat.o(91539);
          return 0;
        case 3: 
          localbzb.desc = locala.NPN.readString();
          AppMethodBeat.o(91539);
          return 0;
        case 4: 
          localbzb.username = locala.NPN.readString();
          AppMethodBeat.o(91539);
          return 0;
        }
        localbzb.path = locala.NPN.readString();
        AppMethodBeat.o(91539);
        return 0;
      }
      AppMethodBeat.o(91539);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzb
 * JD-Core Version:    0.7.0.1
 */