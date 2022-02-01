package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class csr
  extends com.tencent.mm.bx.a
{
  public String Cxw;
  public String MD5;
  public String Title;
  public String URL;
  public String sdi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32451);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.URL != null) {
        paramVarArgs.d(1, this.URL);
      }
      if (this.Title != null) {
        paramVarArgs.d(2, this.Title);
      }
      if (this.Cxw != null) {
        paramVarArgs.d(3, this.Cxw);
      }
      if (this.sdi != null) {
        paramVarArgs.d(4, this.sdi);
      }
      if (this.MD5 != null) {
        paramVarArgs.d(5, this.MD5);
      }
      AppMethodBeat.o(32451);
      return 0;
    }
    if (paramInt == 1) {
      if (this.URL == null) {
        break label465;
      }
    }
    label465:
    for (int i = f.a.a.b.b.a.e(1, this.URL) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Title);
      }
      i = paramInt;
      if (this.Cxw != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Cxw);
      }
      paramInt = i;
      if (this.sdi != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.sdi);
      }
      i = paramInt;
      if (this.MD5 != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.MD5);
      }
      AppMethodBeat.o(32451);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(32451);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        csr localcsr = (csr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32451);
          return -1;
        case 1: 
          localcsr.URL = locala.KhF.readString();
          AppMethodBeat.o(32451);
          return 0;
        case 2: 
          localcsr.Title = locala.KhF.readString();
          AppMethodBeat.o(32451);
          return 0;
        case 3: 
          localcsr.Cxw = locala.KhF.readString();
          AppMethodBeat.o(32451);
          return 0;
        case 4: 
          localcsr.sdi = locala.KhF.readString();
          AppMethodBeat.o(32451);
          return 0;
        }
        localcsr.MD5 = locala.KhF.readString();
        AppMethodBeat.o(32451);
        return 0;
      }
      AppMethodBeat.o(32451);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csr
 * JD-Core Version:    0.7.0.1
 */