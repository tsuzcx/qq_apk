package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aoa
  extends com.tencent.mm.cd.a
{
  public String AesKey;
  public String Md5;
  public String SAx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127471);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Md5 != null) {
        paramVarArgs.f(1, this.Md5);
      }
      if (this.AesKey != null) {
        paramVarArgs.f(2, this.AesKey);
      }
      if (this.SAx != null) {
        paramVarArgs.f(3, this.SAx);
      }
      AppMethodBeat.o(127471);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Md5 == null) {
        break label334;
      }
    }
    label334:
    for (int i = g.a.a.b.b.a.g(1, this.Md5) + 0;; i = 0)
    {
      paramInt = i;
      if (this.AesKey != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.AesKey);
      }
      i = paramInt;
      if (this.SAx != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.SAx);
      }
      AppMethodBeat.o(127471);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(127471);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        aoa localaoa = (aoa)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127471);
          return -1;
        case 1: 
          localaoa.Md5 = locala.abFh.readString();
          AppMethodBeat.o(127471);
          return 0;
        case 2: 
          localaoa.AesKey = locala.abFh.readString();
          AppMethodBeat.o(127471);
          return 0;
        }
        localaoa.SAx = locala.abFh.readString();
        AppMethodBeat.o(127471);
        return 0;
      }
      AppMethodBeat.o(127471);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aoa
 * JD-Core Version:    0.7.0.1
 */