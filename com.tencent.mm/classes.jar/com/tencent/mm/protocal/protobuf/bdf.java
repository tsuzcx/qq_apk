package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bdf
  extends com.tencent.mm.bv.a
{
  public String desc;
  public String kmm;
  public String path;
  public String title;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56854);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.kmm != null) {
        paramVarArgs.e(1, this.kmm);
      }
      if (this.title != null) {
        paramVarArgs.e(2, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.e(3, this.desc);
      }
      if (this.username != null) {
        paramVarArgs.e(4, this.username);
      }
      if (this.path != null) {
        paramVarArgs.e(5, this.path);
      }
      AppMethodBeat.o(56854);
      return 0;
    }
    if (paramInt == 1) {
      if (this.kmm == null) {
        break label454;
      }
    }
    label454:
    for (int i = e.a.a.b.b.a.f(1, this.kmm) + 0;; i = 0)
    {
      paramInt = i;
      if (this.title != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.title);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.desc);
      }
      paramInt = i;
      if (this.username != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.username);
      }
      i = paramInt;
      if (this.path != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.path);
      }
      AppMethodBeat.o(56854);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56854);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bdf localbdf = (bdf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(56854);
          return -1;
        case 1: 
          localbdf.kmm = locala.CLY.readString();
          AppMethodBeat.o(56854);
          return 0;
        case 2: 
          localbdf.title = locala.CLY.readString();
          AppMethodBeat.o(56854);
          return 0;
        case 3: 
          localbdf.desc = locala.CLY.readString();
          AppMethodBeat.o(56854);
          return 0;
        case 4: 
          localbdf.username = locala.CLY.readString();
          AppMethodBeat.o(56854);
          return 0;
        }
        localbdf.path = locala.CLY.readString();
        AppMethodBeat.o(56854);
        return 0;
      }
      AppMethodBeat.o(56854);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdf
 * JD-Core Version:    0.7.0.1
 */