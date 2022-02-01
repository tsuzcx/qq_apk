package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ckm
  extends com.tencent.mm.cd.a
{
  public String CMP;
  public String Md5;
  public String SuY;
  public String Url;
  public int rWo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32329);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SuY != null) {
        paramVarArgs.f(1, this.SuY);
      }
      paramVarArgs.aY(2, this.rWo);
      if (this.Md5 != null) {
        paramVarArgs.f(3, this.Md5);
      }
      if (this.Url != null) {
        paramVarArgs.f(4, this.Url);
      }
      if (this.CMP != null) {
        paramVarArgs.f(5, this.CMP);
      }
      AppMethodBeat.o(32329);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SuY == null) {
        break label449;
      }
    }
    label449:
    for (paramInt = g.a.a.b.b.a.g(1, this.SuY) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.rWo);
      paramInt = i;
      if (this.Md5 != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.Md5);
      }
      i = paramInt;
      if (this.Url != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.Url);
      }
      paramInt = i;
      if (this.CMP != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.CMP);
      }
      AppMethodBeat.o(32329);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(32329);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ckm localckm = (ckm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32329);
          return -1;
        case 1: 
          localckm.SuY = locala.abFh.readString();
          AppMethodBeat.o(32329);
          return 0;
        case 2: 
          localckm.rWo = locala.abFh.AK();
          AppMethodBeat.o(32329);
          return 0;
        case 3: 
          localckm.Md5 = locala.abFh.readString();
          AppMethodBeat.o(32329);
          return 0;
        case 4: 
          localckm.Url = locala.abFh.readString();
          AppMethodBeat.o(32329);
          return 0;
        }
        localckm.CMP = locala.abFh.readString();
        AppMethodBeat.o(32329);
        return 0;
      }
      AppMethodBeat.o(32329);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckm
 * JD-Core Version:    0.7.0.1
 */