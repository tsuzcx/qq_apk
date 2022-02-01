package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dpp
  extends com.tencent.mm.bx.a
{
  public String EFy;
  public String EFz;
  public String EwI;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91726);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.EFy != null) {
        paramVarArgs.d(2, this.EFy);
      }
      if (this.EwI != null) {
        paramVarArgs.d(3, this.EwI);
      }
      if (this.EFz != null) {
        paramVarArgs.d(4, this.EFz);
      }
      AppMethodBeat.o(91726);
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
      if (this.EFy != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EFy);
      }
      i = paramInt;
      if (this.EwI != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EwI);
      }
      paramInt = i;
      if (this.EFz != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EFz);
      }
      AppMethodBeat.o(91726);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91726);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dpp localdpp = (dpp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91726);
          return -1;
        case 1: 
          localdpp.title = locala.KhF.readString();
          AppMethodBeat.o(91726);
          return 0;
        case 2: 
          localdpp.EFy = locala.KhF.readString();
          AppMethodBeat.o(91726);
          return 0;
        case 3: 
          localdpp.EwI = locala.KhF.readString();
          AppMethodBeat.o(91726);
          return 0;
        }
        localdpp.EFz = locala.KhF.readString();
        AppMethodBeat.o(91726);
        return 0;
      }
      AppMethodBeat.o(91726);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpp
 * JD-Core Version:    0.7.0.1
 */