package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cqf
  extends com.tencent.mm.bx.a
{
  public String GgA;
  public String Guj;
  public String nDo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127291);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nDo != null) {
        paramVarArgs.d(1, this.nDo);
      }
      if (this.Guj != null) {
        paramVarArgs.d(2, this.Guj);
      }
      if (this.GgA != null) {
        paramVarArgs.d(3, this.GgA);
      }
      AppMethodBeat.o(127291);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nDo == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.nDo) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Guj != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Guj);
      }
      i = paramInt;
      if (this.GgA != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GgA);
      }
      AppMethodBeat.o(127291);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(127291);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cqf localcqf = (cqf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127291);
          return -1;
        case 1: 
          localcqf.nDo = locala.NPN.readString();
          AppMethodBeat.o(127291);
          return 0;
        case 2: 
          localcqf.Guj = locala.NPN.readString();
          AppMethodBeat.o(127291);
          return 0;
        }
        localcqf.GgA = locala.NPN.readString();
        AppMethodBeat.o(127291);
        return 0;
      }
      AppMethodBeat.o(127291);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqf
 * JD-Core Version:    0.7.0.1
 */