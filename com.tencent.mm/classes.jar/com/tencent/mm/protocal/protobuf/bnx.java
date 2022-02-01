package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bnx
  extends com.tencent.mm.bw.a
{
  public String nnB;
  public String path;
  public String qGB;
  public String title;
  public int type;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123579);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.qGB != null) {
        paramVarArgs.e(1, this.qGB);
      }
      if (this.title != null) {
        paramVarArgs.e(2, this.title);
      }
      paramVarArgs.aM(3, this.type);
      if (this.nnB != null) {
        paramVarArgs.e(4, this.nnB);
      }
      if (this.username != null) {
        paramVarArgs.e(5, this.username);
      }
      if (this.path != null) {
        paramVarArgs.e(6, this.path);
      }
      AppMethodBeat.o(123579);
      return 0;
    }
    if (paramInt == 1) {
      if (this.qGB == null) {
        break label502;
      }
    }
    label502:
    for (paramInt = g.a.a.b.b.a.f(1, this.qGB) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.title != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.title);
      }
      i += g.a.a.b.b.a.bu(3, this.type);
      paramInt = i;
      if (this.nnB != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.nnB);
      }
      i = paramInt;
      if (this.username != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.username);
      }
      paramInt = i;
      if (this.path != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.path);
      }
      AppMethodBeat.o(123579);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(123579);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bnx localbnx = (bnx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123579);
          return -1;
        case 1: 
          localbnx.qGB = locala.UbS.readString();
          AppMethodBeat.o(123579);
          return 0;
        case 2: 
          localbnx.title = locala.UbS.readString();
          AppMethodBeat.o(123579);
          return 0;
        case 3: 
          localbnx.type = locala.UbS.zi();
          AppMethodBeat.o(123579);
          return 0;
        case 4: 
          localbnx.nnB = locala.UbS.readString();
          AppMethodBeat.o(123579);
          return 0;
        case 5: 
          localbnx.username = locala.UbS.readString();
          AppMethodBeat.o(123579);
          return 0;
        }
        localbnx.path = locala.UbS.readString();
        AppMethodBeat.o(123579);
        return 0;
      }
      AppMethodBeat.o(123579);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnx
 * JD-Core Version:    0.7.0.1
 */