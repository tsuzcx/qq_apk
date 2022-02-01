package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class agm
  extends com.tencent.mm.bx.a
{
  public String AesKey;
  public String Diz;
  public String Md5;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127471);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Md5 != null) {
        paramVarArgs.d(1, this.Md5);
      }
      if (this.AesKey != null) {
        paramVarArgs.d(2, this.AesKey);
      }
      if (this.Diz != null) {
        paramVarArgs.d(3, this.Diz);
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
    for (int i = f.a.a.b.b.a.e(1, this.Md5) + 0;; i = 0)
    {
      paramInt = i;
      if (this.AesKey != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.AesKey);
      }
      i = paramInt;
      if (this.Diz != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Diz);
      }
      AppMethodBeat.o(127471);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(127471);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        agm localagm = (agm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127471);
          return -1;
        case 1: 
          localagm.Md5 = locala.KhF.readString();
          AppMethodBeat.o(127471);
          return 0;
        case 2: 
          localagm.AesKey = locala.KhF.readString();
          AppMethodBeat.o(127471);
          return 0;
        }
        localagm.Diz = locala.KhF.readString();
        AppMethodBeat.o(127471);
        return 0;
      }
      AppMethodBeat.o(127471);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agm
 * JD-Core Version:    0.7.0.1
 */