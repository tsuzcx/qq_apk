package com.tencent.mm.plugin.product.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends com.tencent.mm.bx.a
{
  public String IconUrl;
  public String Name;
  public String gKr;
  public int mBH;
  public String uwt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91264);
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
      AppMethodBeat.o(91264);
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
      AppMethodBeat.o(91264);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91264);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        a locala1 = (a)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91264);
          return -1;
        case 1: 
          locala1.Name = locala.KhF.readString();
          AppMethodBeat.o(91264);
          return 0;
        case 2: 
          locala1.uwt = locala.KhF.readString();
          AppMethodBeat.o(91264);
          return 0;
        case 3: 
          locala1.mBH = locala.KhF.xS();
          AppMethodBeat.o(91264);
          return 0;
        case 4: 
          locala1.gKr = locala.KhF.readString();
          AppMethodBeat.o(91264);
          return 0;
        }
        locala1.IconUrl = locala.KhF.readString();
        AppMethodBeat.o(91264);
        return 0;
      }
      AppMethodBeat.o(91264);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.product.c.a
 * JD-Core Version:    0.7.0.1
 */