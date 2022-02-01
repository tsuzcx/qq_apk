package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bvn
  extends com.tencent.mm.bw.a
{
  public String FKB;
  public String Hii;
  public String Hio;
  public String nickname;
  public String pqq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(215585);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hio != null) {
        paramVarArgs.d(1, this.Hio);
      }
      if (this.nickname != null) {
        paramVarArgs.d(2, this.nickname);
      }
      if (this.pqq != null) {
        paramVarArgs.d(3, this.pqq);
      }
      if (this.Hii != null) {
        paramVarArgs.d(4, this.Hii);
      }
      if (this.FKB != null) {
        paramVarArgs.d(5, this.FKB);
      }
      AppMethodBeat.o(215585);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Hio == null) {
        break label454;
      }
    }
    label454:
    for (int i = f.a.a.b.b.a.e(1, this.Hio) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nickname);
      }
      i = paramInt;
      if (this.pqq != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.pqq);
      }
      paramInt = i;
      if (this.Hii != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Hii);
      }
      i = paramInt;
      if (this.FKB != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FKB);
      }
      AppMethodBeat.o(215585);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(215585);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bvn localbvn = (bvn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(215585);
          return -1;
        case 1: 
          localbvn.Hio = locala.OmT.readString();
          AppMethodBeat.o(215585);
          return 0;
        case 2: 
          localbvn.nickname = locala.OmT.readString();
          AppMethodBeat.o(215585);
          return 0;
        case 3: 
          localbvn.pqq = locala.OmT.readString();
          AppMethodBeat.o(215585);
          return 0;
        case 4: 
          localbvn.Hii = locala.OmT.readString();
          AppMethodBeat.o(215585);
          return 0;
        }
        localbvn.FKB = locala.OmT.readString();
        AppMethodBeat.o(215585);
        return 0;
      }
      AppMethodBeat.o(215585);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvn
 * JD-Core Version:    0.7.0.1
 */