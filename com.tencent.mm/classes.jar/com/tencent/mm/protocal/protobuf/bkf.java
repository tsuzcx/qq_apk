package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bkf
  extends com.tencent.mm.bx.a
{
  public String ZTr;
  public String ZTs;
  public String content;
  public String title;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259623);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.type);
      if (this.ZTr != null) {
        paramVarArgs.g(2, this.ZTr);
      }
      if (this.title != null) {
        paramVarArgs.g(3, this.title);
      }
      if (this.content != null) {
        paramVarArgs.g(4, this.content);
      }
      if (this.ZTs != null) {
        paramVarArgs.g(5, this.ZTs);
      }
      AppMethodBeat.o(259623);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.type) + 0;
      paramInt = i;
      if (this.ZTr != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ZTr);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.title);
      }
      paramInt = i;
      if (this.content != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.content);
      }
      i = paramInt;
      if (this.ZTs != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.ZTs);
      }
      AppMethodBeat.o(259623);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259623);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      bkf localbkf = (bkf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259623);
        return -1;
      case 1: 
        localbkf.type = locala.ajGk.aar();
        AppMethodBeat.o(259623);
        return 0;
      case 2: 
        localbkf.ZTr = locala.ajGk.readString();
        AppMethodBeat.o(259623);
        return 0;
      case 3: 
        localbkf.title = locala.ajGk.readString();
        AppMethodBeat.o(259623);
        return 0;
      case 4: 
        localbkf.content = locala.ajGk.readString();
        AppMethodBeat.o(259623);
        return 0;
      }
      localbkf.ZTs = locala.ajGk.readString();
      AppMethodBeat.o(259623);
      return 0;
    }
    AppMethodBeat.o(259623);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkf
 * JD-Core Version:    0.7.0.1
 */