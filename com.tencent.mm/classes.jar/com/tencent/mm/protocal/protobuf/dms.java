package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dms
  extends com.tencent.mm.cd.a
{
  public String InB;
  public int action;
  public String url;
  public String username;
  public String wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(266965);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.wording != null) {
        paramVarArgs.f(1, this.wording);
      }
      paramVarArgs.aY(2, this.action);
      if (this.url != null) {
        paramVarArgs.f(3, this.url);
      }
      if (this.username != null) {
        paramVarArgs.f(4, this.username);
      }
      if (this.InB != null) {
        paramVarArgs.f(5, this.InB);
      }
      AppMethodBeat.o(266965);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wording == null) {
        break label438;
      }
    }
    label438:
    for (paramInt = g.a.a.b.b.a.g(1, this.wording) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.action);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.url);
      }
      i = paramInt;
      if (this.username != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.username);
      }
      paramInt = i;
      if (this.InB != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.InB);
      }
      AppMethodBeat.o(266965);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(266965);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dms localdms = (dms)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(266965);
          return -1;
        case 1: 
          localdms.wording = locala.abFh.readString();
          AppMethodBeat.o(266965);
          return 0;
        case 2: 
          localdms.action = locala.abFh.AK();
          AppMethodBeat.o(266965);
          return 0;
        case 3: 
          localdms.url = locala.abFh.readString();
          AppMethodBeat.o(266965);
          return 0;
        case 4: 
          localdms.username = locala.abFh.readString();
          AppMethodBeat.o(266965);
          return 0;
        }
        localdms.InB = locala.abFh.readString();
        AppMethodBeat.o(266965);
        return 0;
      }
      AppMethodBeat.o(266965);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dms
 * JD-Core Version:    0.7.0.1
 */