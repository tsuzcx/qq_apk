package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class amz
  extends com.tencent.mm.bw.a
{
  public String AesKey;
  public String LxW;
  public String Md5;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127471);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Md5 != null) {
        paramVarArgs.e(1, this.Md5);
      }
      if (this.AesKey != null) {
        paramVarArgs.e(2, this.AesKey);
      }
      if (this.LxW != null) {
        paramVarArgs.e(3, this.LxW);
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
    for (int i = g.a.a.b.b.a.f(1, this.Md5) + 0;; i = 0)
    {
      paramInt = i;
      if (this.AesKey != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.AesKey);
      }
      i = paramInt;
      if (this.LxW != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.LxW);
      }
      AppMethodBeat.o(127471);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(127471);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        amz localamz = (amz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127471);
          return -1;
        case 1: 
          localamz.Md5 = locala.UbS.readString();
          AppMethodBeat.o(127471);
          return 0;
        case 2: 
          localamz.AesKey = locala.UbS.readString();
          AppMethodBeat.o(127471);
          return 0;
        }
        localamz.LxW = locala.UbS.readString();
        AppMethodBeat.o(127471);
        return 0;
      }
      AppMethodBeat.o(127471);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amz
 * JD-Core Version:    0.7.0.1
 */