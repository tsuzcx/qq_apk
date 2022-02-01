package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class crs
  extends com.tencent.mm.cd.a
{
  public String TyL;
  public int TyM;
  public String content;
  public String jjF;
  public int msg_type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195247);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TyL != null) {
        paramVarArgs.f(1, this.TyL);
      }
      if (this.jjF != null) {
        paramVarArgs.f(2, this.jjF);
      }
      paramVarArgs.aY(3, this.msg_type);
      if (this.content != null) {
        paramVarArgs.f(4, this.content);
      }
      paramVarArgs.aY(5, this.TyM);
      AppMethodBeat.o(195247);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TyL == null) {
        break label422;
      }
    }
    label422:
    for (paramInt = g.a.a.b.b.a.g(1, this.TyL) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.jjF != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.jjF);
      }
      i += g.a.a.b.b.a.bM(3, this.msg_type);
      paramInt = i;
      if (this.content != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.content);
      }
      i = g.a.a.b.b.a.bM(5, this.TyM);
      AppMethodBeat.o(195247);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(195247);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        crs localcrs = (crs)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(195247);
          return -1;
        case 1: 
          localcrs.TyL = locala.abFh.readString();
          AppMethodBeat.o(195247);
          return 0;
        case 2: 
          localcrs.jjF = locala.abFh.readString();
          AppMethodBeat.o(195247);
          return 0;
        case 3: 
          localcrs.msg_type = locala.abFh.AK();
          AppMethodBeat.o(195247);
          return 0;
        case 4: 
          localcrs.content = locala.abFh.readString();
          AppMethodBeat.o(195247);
          return 0;
        }
        localcrs.TyM = locala.abFh.AK();
        AppMethodBeat.o(195247);
        return 0;
      }
      AppMethodBeat.o(195247);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crs
 * JD-Core Version:    0.7.0.1
 */