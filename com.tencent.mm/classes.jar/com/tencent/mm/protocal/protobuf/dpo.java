package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class dpo
  extends com.tencent.mm.bx.a
{
  public b EFx;
  public String description;
  public String oYa;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(191100);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.oYa != null) {
        paramVarArgs.d(1, this.oYa);
      }
      if (this.EFx != null) {
        paramVarArgs.c(2, this.EFx);
      }
      if (this.title != null) {
        paramVarArgs.d(3, this.title);
      }
      if (this.description != null) {
        paramVarArgs.d(4, this.description);
      }
      AppMethodBeat.o(191100);
      return 0;
    }
    if (paramInt == 1) {
      if (this.oYa == null) {
        break label394;
      }
    }
    label394:
    for (int i = f.a.a.b.b.a.e(1, this.oYa) + 0;; i = 0)
    {
      paramInt = i;
      if (this.EFx != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.EFx);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.title);
      }
      paramInt = i;
      if (this.description != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.description);
      }
      AppMethodBeat.o(191100);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(191100);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dpo localdpo = (dpo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(191100);
          return -1;
        case 1: 
          localdpo.oYa = locala.KhF.readString();
          AppMethodBeat.o(191100);
          return 0;
        case 2: 
          localdpo.EFx = locala.KhF.fMu();
          AppMethodBeat.o(191100);
          return 0;
        case 3: 
          localdpo.title = locala.KhF.readString();
          AppMethodBeat.o(191100);
          return 0;
        }
        localdpo.description = locala.KhF.readString();
        AppMethodBeat.o(191100);
        return 0;
      }
      AppMethodBeat.o(191100);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpo
 * JD-Core Version:    0.7.0.1
 */