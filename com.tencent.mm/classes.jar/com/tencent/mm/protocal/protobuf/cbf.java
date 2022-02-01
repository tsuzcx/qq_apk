package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cbf
  extends com.tencent.mm.bx.a
{
  public String GDK;
  public String GFO;
  public String GFP;
  public String dxg;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123628);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GDK != null) {
        paramVarArgs.d(1, this.GDK);
      }
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      if (this.dxg != null) {
        paramVarArgs.d(3, this.dxg);
      }
      if (this.GFO != null) {
        paramVarArgs.d(4, this.GFO);
      }
      if (this.GFP != null) {
        paramVarArgs.d(5, this.GFP);
      }
      AppMethodBeat.o(123628);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GDK == null) {
        break label454;
      }
    }
    label454:
    for (int i = f.a.a.b.b.a.e(1, this.GDK) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.dxg != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dxg);
      }
      paramInt = i;
      if (this.GFO != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GFO);
      }
      i = paramInt;
      if (this.GFP != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GFP);
      }
      AppMethodBeat.o(123628);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(123628);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cbf localcbf = (cbf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123628);
          return -1;
        case 1: 
          localcbf.GDK = locala.NPN.readString();
          AppMethodBeat.o(123628);
          return 0;
        case 2: 
          localcbf.url = locala.NPN.readString();
          AppMethodBeat.o(123628);
          return 0;
        case 3: 
          localcbf.dxg = locala.NPN.readString();
          AppMethodBeat.o(123628);
          return 0;
        case 4: 
          localcbf.GFO = locala.NPN.readString();
          AppMethodBeat.o(123628);
          return 0;
        }
        localcbf.GFP = locala.NPN.readString();
        AppMethodBeat.o(123628);
        return 0;
      }
      AppMethodBeat.o(123628);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbf
 * JD-Core Version:    0.7.0.1
 */