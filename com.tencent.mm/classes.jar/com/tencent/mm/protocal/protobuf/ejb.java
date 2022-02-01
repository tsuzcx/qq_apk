package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ejb
  extends com.tencent.mm.bw.a
{
  public String GZq;
  public String GZr;
  public String Iml;
  public String dyl;
  public String url;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123707);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Iml != null) {
        paramVarArgs.d(1, this.Iml);
      }
      paramVarArgs.aS(2, this.version);
      if (this.url != null) {
        paramVarArgs.d(3, this.url);
      }
      if (this.dyl != null) {
        paramVarArgs.d(4, this.dyl);
      }
      if (this.GZq != null) {
        paramVarArgs.d(5, this.GZq);
      }
      if (this.GZr != null) {
        paramVarArgs.d(6, this.GZr);
      }
      AppMethodBeat.o(123707);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Iml == null) {
        break label502;
      }
    }
    label502:
    for (paramInt = f.a.a.b.b.a.e(1, this.Iml) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.version);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.url);
      }
      i = paramInt;
      if (this.dyl != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.dyl);
      }
      paramInt = i;
      if (this.GZq != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GZq);
      }
      i = paramInt;
      if (this.GZr != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.GZr);
      }
      AppMethodBeat.o(123707);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(123707);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ejb localejb = (ejb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123707);
          return -1;
        case 1: 
          localejb.Iml = locala.OmT.readString();
          AppMethodBeat.o(123707);
          return 0;
        case 2: 
          localejb.version = locala.OmT.zc();
          AppMethodBeat.o(123707);
          return 0;
        case 3: 
          localejb.url = locala.OmT.readString();
          AppMethodBeat.o(123707);
          return 0;
        case 4: 
          localejb.dyl = locala.OmT.readString();
          AppMethodBeat.o(123707);
          return 0;
        case 5: 
          localejb.GZq = locala.OmT.readString();
          AppMethodBeat.o(123707);
          return 0;
        }
        localejb.GZr = locala.OmT.readString();
        AppMethodBeat.o(123707);
        return 0;
      }
      AppMethodBeat.o(123707);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ejb
 * JD-Core Version:    0.7.0.1
 */