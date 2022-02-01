package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class tw
  extends com.tencent.mm.cd.a
{
  public String appId;
  public int cBI;
  public String md5;
  public String path;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(205481);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.appId != null) {
        paramVarArgs.f(1, this.appId);
      }
      if (this.path != null) {
        paramVarArgs.f(2, this.path);
      }
      paramVarArgs.aY(3, this.version);
      paramVarArgs.aY(4, this.cBI);
      if (this.md5 != null) {
        paramVarArgs.f(5, this.md5);
      }
      AppMethodBeat.o(205481);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appId == null) {
        break label422;
      }
    }
    label422:
    for (paramInt = g.a.a.b.b.a.g(1, this.appId) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.path != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.path);
      }
      i = i + g.a.a.b.b.a.bM(3, this.version) + g.a.a.b.b.a.bM(4, this.cBI);
      paramInt = i;
      if (this.md5 != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.md5);
      }
      AppMethodBeat.o(205481);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(205481);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        tw localtw = (tw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(205481);
          return -1;
        case 1: 
          localtw.appId = locala.abFh.readString();
          AppMethodBeat.o(205481);
          return 0;
        case 2: 
          localtw.path = locala.abFh.readString();
          AppMethodBeat.o(205481);
          return 0;
        case 3: 
          localtw.version = locala.abFh.AK();
          AppMethodBeat.o(205481);
          return 0;
        case 4: 
          localtw.cBI = locala.abFh.AK();
          AppMethodBeat.o(205481);
          return 0;
        }
        localtw.md5 = locala.abFh.readString();
        AppMethodBeat.o(205481);
        return 0;
      }
      AppMethodBeat.o(205481);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tw
 * JD-Core Version:    0.7.0.1
 */