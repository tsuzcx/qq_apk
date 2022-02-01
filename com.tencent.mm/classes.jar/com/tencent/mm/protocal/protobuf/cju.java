package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cju
  extends com.tencent.mm.cd.a
{
  public String aeskey;
  public String fileid;
  public String filemd5;
  public int iZc;
  public int iZd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258906);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fileid != null) {
        paramVarArgs.f(1, this.fileid);
      }
      if (this.aeskey != null) {
        paramVarArgs.f(2, this.aeskey);
      }
      if (this.filemd5 != null) {
        paramVarArgs.f(3, this.filemd5);
      }
      paramVarArgs.aY(4, this.iZc);
      paramVarArgs.aY(5, this.iZd);
      AppMethodBeat.o(258906);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fileid == null) {
        break label426;
      }
    }
    label426:
    for (int i = g.a.a.b.b.a.g(1, this.fileid) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aeskey != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.aeskey);
      }
      i = paramInt;
      if (this.filemd5 != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.filemd5);
      }
      paramInt = g.a.a.b.b.a.bM(4, this.iZc);
      int j = g.a.a.b.b.a.bM(5, this.iZd);
      AppMethodBeat.o(258906);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(258906);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cju localcju = (cju)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258906);
          return -1;
        case 1: 
          localcju.fileid = locala.abFh.readString();
          AppMethodBeat.o(258906);
          return 0;
        case 2: 
          localcju.aeskey = locala.abFh.readString();
          AppMethodBeat.o(258906);
          return 0;
        case 3: 
          localcju.filemd5 = locala.abFh.readString();
          AppMethodBeat.o(258906);
          return 0;
        case 4: 
          localcju.iZc = locala.abFh.AK();
          AppMethodBeat.o(258906);
          return 0;
        }
        localcju.iZd = locala.abFh.AK();
        AppMethodBeat.o(258906);
        return 0;
      }
      AppMethodBeat.o(258906);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cju
 * JD-Core Version:    0.7.0.1
 */