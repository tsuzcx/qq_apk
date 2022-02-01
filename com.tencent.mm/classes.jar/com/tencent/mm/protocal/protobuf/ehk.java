package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ehk
  extends com.tencent.mm.bx.a
{
  public String GFO;
  public String GFP;
  public String HSe;
  public String dxg;
  public String url;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123707);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HSe != null) {
        paramVarArgs.d(1, this.HSe);
      }
      paramVarArgs.aS(2, this.version);
      if (this.url != null) {
        paramVarArgs.d(3, this.url);
      }
      if (this.dxg != null) {
        paramVarArgs.d(4, this.dxg);
      }
      if (this.GFO != null) {
        paramVarArgs.d(5, this.GFO);
      }
      if (this.GFP != null) {
        paramVarArgs.d(6, this.GFP);
      }
      AppMethodBeat.o(123707);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HSe == null) {
        break label502;
      }
    }
    label502:
    for (paramInt = f.a.a.b.b.a.e(1, this.HSe) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.version);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.url);
      }
      i = paramInt;
      if (this.dxg != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.dxg);
      }
      paramInt = i;
      if (this.GFO != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GFO);
      }
      i = paramInt;
      if (this.GFP != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.GFP);
      }
      AppMethodBeat.o(123707);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(123707);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ehk localehk = (ehk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123707);
          return -1;
        case 1: 
          localehk.HSe = locala.NPN.readString();
          AppMethodBeat.o(123707);
          return 0;
        case 2: 
          localehk.version = locala.NPN.zc();
          AppMethodBeat.o(123707);
          return 0;
        case 3: 
          localehk.url = locala.NPN.readString();
          AppMethodBeat.o(123707);
          return 0;
        case 4: 
          localehk.dxg = locala.NPN.readString();
          AppMethodBeat.o(123707);
          return 0;
        case 5: 
          localehk.GFO = locala.NPN.readString();
          AppMethodBeat.o(123707);
          return 0;
        }
        localehk.GFP = locala.NPN.readString();
        AppMethodBeat.o(123707);
        return 0;
      }
      AppMethodBeat.o(123707);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ehk
 * JD-Core Version:    0.7.0.1
 */