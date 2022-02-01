package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aqm
  extends com.tencent.mm.bw.a
{
  public String GHp;
  public String content;
  public String link;
  public int subType;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169020);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.content != null) {
        paramVarArgs.d(2, this.content);
      }
      paramVarArgs.aS(3, this.subType);
      if (this.link != null) {
        paramVarArgs.d(4, this.link);
      }
      if (this.GHp != null) {
        paramVarArgs.d(5, this.GHp);
      }
      AppMethodBeat.o(169020);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label438;
      }
    }
    label438:
    for (paramInt = f.a.a.b.b.a.e(1, this.title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.content != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.content);
      }
      i += f.a.a.b.b.a.bz(3, this.subType);
      paramInt = i;
      if (this.link != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.link);
      }
      i = paramInt;
      if (this.GHp != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GHp);
      }
      AppMethodBeat.o(169020);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(169020);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        aqm localaqm = (aqm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(169020);
          return -1;
        case 1: 
          localaqm.title = locala.OmT.readString();
          AppMethodBeat.o(169020);
          return 0;
        case 2: 
          localaqm.content = locala.OmT.readString();
          AppMethodBeat.o(169020);
          return 0;
        case 3: 
          localaqm.subType = locala.OmT.zc();
          AppMethodBeat.o(169020);
          return 0;
        case 4: 
          localaqm.link = locala.OmT.readString();
          AppMethodBeat.o(169020);
          return 0;
        }
        localaqm.GHp = locala.OmT.readString();
        AppMethodBeat.o(169020);
        return 0;
      }
      AppMethodBeat.o(169020);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqm
 * JD-Core Version:    0.7.0.1
 */