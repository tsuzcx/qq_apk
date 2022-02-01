package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dqh
  extends com.tencent.mm.bw.a
{
  public String businessType;
  public String dNI;
  public String extInfo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209813);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.businessType != null) {
        paramVarArgs.e(1, this.businessType);
      }
      if (this.dNI != null) {
        paramVarArgs.e(2, this.dNI);
      }
      if (this.extInfo != null) {
        paramVarArgs.e(3, this.extInfo);
      }
      AppMethodBeat.o(209813);
      return 0;
    }
    if (paramInt == 1) {
      if (this.businessType == null) {
        break label334;
      }
    }
    label334:
    for (int i = g.a.a.b.b.a.f(1, this.businessType) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dNI != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.dNI);
      }
      i = paramInt;
      if (this.extInfo != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.extInfo);
      }
      AppMethodBeat.o(209813);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209813);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dqh localdqh = (dqh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(209813);
          return -1;
        case 1: 
          localdqh.businessType = locala.UbS.readString();
          AppMethodBeat.o(209813);
          return 0;
        case 2: 
          localdqh.dNI = locala.UbS.readString();
          AppMethodBeat.o(209813);
          return 0;
        }
        localdqh.extInfo = locala.UbS.readString();
        AppMethodBeat.o(209813);
        return 0;
      }
      AppMethodBeat.o(209813);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqh
 * JD-Core Version:    0.7.0.1
 */