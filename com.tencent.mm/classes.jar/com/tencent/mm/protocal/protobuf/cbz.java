package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cbz
  extends com.tencent.mm.bw.a
{
  public String GXn;
  public String GZq;
  public String GZr;
  public String dyl;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123628);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GXn != null) {
        paramVarArgs.d(1, this.GXn);
      }
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      if (this.dyl != null) {
        paramVarArgs.d(3, this.dyl);
      }
      if (this.GZq != null) {
        paramVarArgs.d(4, this.GZq);
      }
      if (this.GZr != null) {
        paramVarArgs.d(5, this.GZr);
      }
      AppMethodBeat.o(123628);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GXn == null) {
        break label454;
      }
    }
    label454:
    for (int i = f.a.a.b.b.a.e(1, this.GXn) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.dyl != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dyl);
      }
      paramInt = i;
      if (this.GZq != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GZq);
      }
      i = paramInt;
      if (this.GZr != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GZr);
      }
      AppMethodBeat.o(123628);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(123628);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cbz localcbz = (cbz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123628);
          return -1;
        case 1: 
          localcbz.GXn = locala.OmT.readString();
          AppMethodBeat.o(123628);
          return 0;
        case 2: 
          localcbz.url = locala.OmT.readString();
          AppMethodBeat.o(123628);
          return 0;
        case 3: 
          localcbz.dyl = locala.OmT.readString();
          AppMethodBeat.o(123628);
          return 0;
        case 4: 
          localcbz.GZq = locala.OmT.readString();
          AppMethodBeat.o(123628);
          return 0;
        }
        localcbz.GZr = locala.OmT.readString();
        AppMethodBeat.o(123628);
        return 0;
      }
      AppMethodBeat.o(123628);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbz
 * JD-Core Version:    0.7.0.1
 */