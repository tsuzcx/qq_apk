package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ehe
  extends com.tencent.mm.bw.a
{
  public String HDz;
  public String IkT;
  public String dyI;
  public String pinyin;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152729);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HDz != null) {
        paramVarArgs.d(1, this.HDz);
      }
      if (this.dyI != null) {
        paramVarArgs.d(2, this.dyI);
      }
      if (this.pinyin != null) {
        paramVarArgs.d(3, this.pinyin);
      }
      if (this.IkT != null) {
        paramVarArgs.d(4, this.IkT);
      }
      AppMethodBeat.o(152729);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HDz == null) {
        break label394;
      }
    }
    label394:
    for (int i = f.a.a.b.b.a.e(1, this.HDz) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dyI != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dyI);
      }
      i = paramInt;
      if (this.pinyin != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.pinyin);
      }
      paramInt = i;
      if (this.IkT != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.IkT);
      }
      AppMethodBeat.o(152729);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(152729);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ehe localehe = (ehe)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152729);
          return -1;
        case 1: 
          localehe.HDz = locala.OmT.readString();
          AppMethodBeat.o(152729);
          return 0;
        case 2: 
          localehe.dyI = locala.OmT.readString();
          AppMethodBeat.o(152729);
          return 0;
        case 3: 
          localehe.pinyin = locala.OmT.readString();
          AppMethodBeat.o(152729);
          return 0;
        }
        localehe.IkT = locala.OmT.readString();
        AppMethodBeat.o(152729);
        return 0;
      }
      AppMethodBeat.o(152729);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ehe
 * JD-Core Version:    0.7.0.1
 */