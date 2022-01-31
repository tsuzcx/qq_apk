package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cbz
  extends com.tencent.mm.bv.a
{
  public String Title;
  public String URL;
  public String ntH;
  public String wQr;
  public String woO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28653);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.URL != null) {
        paramVarArgs.e(1, this.URL);
      }
      if (this.Title != null) {
        paramVarArgs.e(2, this.Title);
      }
      if (this.woO != null) {
        paramVarArgs.e(3, this.woO);
      }
      if (this.ntH != null) {
        paramVarArgs.e(4, this.ntH);
      }
      if (this.wQr != null) {
        paramVarArgs.e(5, this.wQr);
      }
      AppMethodBeat.o(28653);
      return 0;
    }
    if (paramInt == 1) {
      if (this.URL == null) {
        break label465;
      }
    }
    label465:
    for (int i = e.a.a.b.b.a.f(1, this.URL) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.Title);
      }
      i = paramInt;
      if (this.woO != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.woO);
      }
      paramInt = i;
      if (this.ntH != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.ntH);
      }
      i = paramInt;
      if (this.wQr != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.wQr);
      }
      AppMethodBeat.o(28653);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(28653);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cbz localcbz = (cbz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(28653);
          return -1;
        case 1: 
          localcbz.URL = locala.CLY.readString();
          AppMethodBeat.o(28653);
          return 0;
        case 2: 
          localcbz.Title = locala.CLY.readString();
          AppMethodBeat.o(28653);
          return 0;
        case 3: 
          localcbz.woO = locala.CLY.readString();
          AppMethodBeat.o(28653);
          return 0;
        case 4: 
          localcbz.ntH = locala.CLY.readString();
          AppMethodBeat.o(28653);
          return 0;
        }
        localcbz.wQr = locala.CLY.readString();
        AppMethodBeat.o(28653);
        return 0;
      }
      AppMethodBeat.o(28653);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbz
 * JD-Core Version:    0.7.0.1
 */