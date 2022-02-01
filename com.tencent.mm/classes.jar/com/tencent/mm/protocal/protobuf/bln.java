package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class bln
  extends com.tencent.mm.cd.a
{
  public String SWz;
  public String Sba;
  public String appId;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(201544);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.appId != null) {
        paramVarArgs.f(1, this.appId);
      }
      if (this.SWz != null) {
        paramVarArgs.f(2, this.SWz);
      }
      if (this.Sba != null) {
        paramVarArgs.f(3, this.Sba);
      }
      AppMethodBeat.o(201544);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appId == null) {
        break label334;
      }
    }
    label334:
    for (int i = g.a.a.b.b.a.g(1, this.appId) + 0;; i = 0)
    {
      paramInt = i;
      if (this.SWz != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.SWz);
      }
      i = paramInt;
      if (this.Sba != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Sba);
      }
      AppMethodBeat.o(201544);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(201544);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bln localbln = (bln)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(201544);
          return -1;
        case 1: 
          localbln.appId = locala.abFh.readString();
          AppMethodBeat.o(201544);
          return 0;
        case 2: 
          localbln.SWz = locala.abFh.readString();
          AppMethodBeat.o(201544);
          return 0;
        }
        localbln.Sba = locala.abFh.readString();
        AppMethodBeat.o(201544);
        return 0;
      }
      AppMethodBeat.o(201544);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bln
 * JD-Core Version:    0.7.0.1
 */