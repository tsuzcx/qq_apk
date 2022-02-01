package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bnw
  extends com.tencent.mm.bx.a
{
  public String CKN;
  public String desc;
  public String hyC;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72498);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.d(2, this.desc);
      }
      if (this.hyC != null) {
        paramVarArgs.d(3, this.hyC);
      }
      if (this.CKN != null) {
        paramVarArgs.d(4, this.CKN);
      }
      AppMethodBeat.o(72498);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label394;
      }
    }
    label394:
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.desc);
      }
      i = paramInt;
      if (this.hyC != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.hyC);
      }
      paramInt = i;
      if (this.CKN != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.CKN);
      }
      AppMethodBeat.o(72498);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(72498);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bnw localbnw = (bnw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72498);
          return -1;
        case 1: 
          localbnw.title = locala.NPN.readString();
          AppMethodBeat.o(72498);
          return 0;
        case 2: 
          localbnw.desc = locala.NPN.readString();
          AppMethodBeat.o(72498);
          return 0;
        case 3: 
          localbnw.hyC = locala.NPN.readString();
          AppMethodBeat.o(72498);
          return 0;
        }
        localbnw.CKN = locala.NPN.readString();
        AppMethodBeat.o(72498);
        return 0;
      }
      AppMethodBeat.o(72498);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnw
 * JD-Core Version:    0.7.0.1
 */