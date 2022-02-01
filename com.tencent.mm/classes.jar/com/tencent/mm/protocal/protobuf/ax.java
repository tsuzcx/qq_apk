package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ax
  extends com.tencent.mm.bx.a
{
  public String IconUrl;
  public String Name;
  public String gKr;
  public int mBH;
  public String uwt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91340);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Name != null) {
        paramVarArgs.d(1, this.Name);
      }
      if (this.uwt != null) {
        paramVarArgs.d(2, this.uwt);
      }
      paramVarArgs.aR(3, this.mBH);
      if (this.gKr != null) {
        paramVarArgs.d(4, this.gKr);
      }
      if (this.IconUrl != null) {
        paramVarArgs.d(5, this.IconUrl);
      }
      AppMethodBeat.o(91340);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Name == null) {
        break label438;
      }
    }
    label438:
    for (paramInt = f.a.a.b.b.a.e(1, this.Name) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.uwt != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.uwt);
      }
      i += f.a.a.b.b.a.bA(3, this.mBH);
      paramInt = i;
      if (this.gKr != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.gKr);
      }
      i = paramInt;
      if (this.IconUrl != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.IconUrl);
      }
      AppMethodBeat.o(91340);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91340);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ax localax = (ax)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91340);
          return -1;
        case 1: 
          localax.Name = locala.KhF.readString();
          AppMethodBeat.o(91340);
          return 0;
        case 2: 
          localax.uwt = locala.KhF.readString();
          AppMethodBeat.o(91340);
          return 0;
        case 3: 
          localax.mBH = locala.KhF.xS();
          AppMethodBeat.o(91340);
          return 0;
        case 4: 
          localax.gKr = locala.KhF.readString();
          AppMethodBeat.o(91340);
          return 0;
        }
        localax.IconUrl = locala.KhF.readString();
        AppMethodBeat.o(91340);
        return 0;
      }
      AppMethodBeat.o(91340);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ax
 * JD-Core Version:    0.7.0.1
 */