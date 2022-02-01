package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bss
  extends com.tencent.mm.bx.a
{
  public int CLL;
  public String DPP;
  public String DPQ;
  public String path;
  public int type;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123630);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      if (this.DPP != null) {
        paramVarArgs.d(2, this.DPP);
      }
      if (this.DPQ != null) {
        paramVarArgs.d(3, this.DPQ);
      }
      if (this.path != null) {
        paramVarArgs.d(4, this.path);
      }
      paramVarArgs.aR(5, this.CLL);
      paramVarArgs.aR(6, this.type);
      AppMethodBeat.o(123630);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label486;
      }
    }
    label486:
    for (int i = f.a.a.b.b.a.e(1, this.username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DPP != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DPP);
      }
      i = paramInt;
      if (this.DPQ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DPQ);
      }
      paramInt = i;
      if (this.path != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.path);
      }
      i = f.a.a.b.b.a.bA(5, this.CLL);
      int j = f.a.a.b.b.a.bA(6, this.type);
      AppMethodBeat.o(123630);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(123630);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bss localbss = (bss)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123630);
          return -1;
        case 1: 
          localbss.username = locala.KhF.readString();
          AppMethodBeat.o(123630);
          return 0;
        case 2: 
          localbss.DPP = locala.KhF.readString();
          AppMethodBeat.o(123630);
          return 0;
        case 3: 
          localbss.DPQ = locala.KhF.readString();
          AppMethodBeat.o(123630);
          return 0;
        case 4: 
          localbss.path = locala.KhF.readString();
          AppMethodBeat.o(123630);
          return 0;
        case 5: 
          localbss.CLL = locala.KhF.xS();
          AppMethodBeat.o(123630);
          return 0;
        }
        localbss.type = locala.KhF.xS();
        AppMethodBeat.o(123630);
        return 0;
      }
      AppMethodBeat.o(123630);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bss
 * JD-Core Version:    0.7.0.1
 */