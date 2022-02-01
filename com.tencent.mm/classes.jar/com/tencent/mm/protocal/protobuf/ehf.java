package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ehf
  extends com.tencent.mm.bw.a
{
  public String IkU;
  public int IkV;
  public String Nickname;
  public String urn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124574);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.IkU != null) {
        paramVarArgs.d(1, this.IkU);
      }
      if (this.urn != null) {
        paramVarArgs.d(2, this.urn);
      }
      if (this.Nickname != null) {
        paramVarArgs.d(3, this.Nickname);
      }
      paramVarArgs.aS(4, this.IkV);
      AppMethodBeat.o(124574);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IkU == null) {
        break label378;
      }
    }
    label378:
    for (int i = f.a.a.b.b.a.e(1, this.IkU) + 0;; i = 0)
    {
      paramInt = i;
      if (this.urn != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.urn);
      }
      i = paramInt;
      if (this.Nickname != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Nickname);
      }
      paramInt = f.a.a.b.b.a.bz(4, this.IkV);
      AppMethodBeat.o(124574);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(124574);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ehf localehf = (ehf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124574);
          return -1;
        case 1: 
          localehf.IkU = locala.OmT.readString();
          AppMethodBeat.o(124574);
          return 0;
        case 2: 
          localehf.urn = locala.OmT.readString();
          AppMethodBeat.o(124574);
          return 0;
        case 3: 
          localehf.Nickname = locala.OmT.readString();
          AppMethodBeat.o(124574);
          return 0;
        }
        localehf.IkV = locala.OmT.zc();
        AppMethodBeat.o(124574);
        return 0;
      }
      AppMethodBeat.o(124574);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ehf
 * JD-Core Version:    0.7.0.1
 */