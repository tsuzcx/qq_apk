package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ead
  extends com.tencent.mm.cd.a
{
  public String appid;
  public String businessType;
  public String extInfo;
  public boolean xSm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(203910);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.businessType != null) {
        paramVarArgs.f(1, this.businessType);
      }
      if (this.appid != null) {
        paramVarArgs.f(2, this.appid);
      }
      if (this.extInfo != null) {
        paramVarArgs.f(3, this.extInfo);
      }
      paramVarArgs.co(4, this.xSm);
      AppMethodBeat.o(203910);
      return 0;
    }
    if (paramInt == 1) {
      if (this.businessType == null) {
        break label378;
      }
    }
    label378:
    for (int i = g.a.a.b.b.a.g(1, this.businessType) + 0;; i = 0)
    {
      paramInt = i;
      if (this.appid != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.appid);
      }
      i = paramInt;
      if (this.extInfo != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.extInfo);
      }
      paramInt = g.a.a.b.b.a.gL(4);
      AppMethodBeat.o(203910);
      return i + (paramInt + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(203910);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ead localead = (ead)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(203910);
          return -1;
        case 1: 
          localead.businessType = locala.abFh.readString();
          AppMethodBeat.o(203910);
          return 0;
        case 2: 
          localead.appid = locala.abFh.readString();
          AppMethodBeat.o(203910);
          return 0;
        case 3: 
          localead.extInfo = locala.abFh.readString();
          AppMethodBeat.o(203910);
          return 0;
        }
        localead.xSm = locala.abFh.AB();
        AppMethodBeat.o(203910);
        return 0;
      }
      AppMethodBeat.o(203910);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ead
 * JD-Core Version:    0.7.0.1
 */