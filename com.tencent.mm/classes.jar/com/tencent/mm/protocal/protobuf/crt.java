package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class crt
  extends com.tencent.mm.cd.a
{
  public String RFk;
  public String TyF;
  public String TyL;
  public String nickname;
  public String ueX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194857);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TyL != null) {
        paramVarArgs.f(1, this.TyL);
      }
      if (this.nickname != null) {
        paramVarArgs.f(2, this.nickname);
      }
      if (this.ueX != null) {
        paramVarArgs.f(3, this.ueX);
      }
      if (this.TyF != null) {
        paramVarArgs.f(4, this.TyF);
      }
      if (this.RFk != null) {
        paramVarArgs.f(5, this.RFk);
      }
      AppMethodBeat.o(194857);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TyL == null) {
        break label454;
      }
    }
    label454:
    for (int i = g.a.a.b.b.a.g(1, this.TyL) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.nickname);
      }
      i = paramInt;
      if (this.ueX != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.ueX);
      }
      paramInt = i;
      if (this.TyF != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.TyF);
      }
      i = paramInt;
      if (this.RFk != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.RFk);
      }
      AppMethodBeat.o(194857);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(194857);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        crt localcrt = (crt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(194857);
          return -1;
        case 1: 
          localcrt.TyL = locala.abFh.readString();
          AppMethodBeat.o(194857);
          return 0;
        case 2: 
          localcrt.nickname = locala.abFh.readString();
          AppMethodBeat.o(194857);
          return 0;
        case 3: 
          localcrt.ueX = locala.abFh.readString();
          AppMethodBeat.o(194857);
          return 0;
        case 4: 
          localcrt.TyF = locala.abFh.readString();
          AppMethodBeat.o(194857);
          return 0;
        }
        localcrt.RFk = locala.abFh.readString();
        AppMethodBeat.o(194857);
        return 0;
      }
      AppMethodBeat.o(194857);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crt
 * JD-Core Version:    0.7.0.1
 */