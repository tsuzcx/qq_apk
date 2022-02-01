package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ahk
  extends com.tencent.mm.bx.a
{
  public boolean Dkb;
  public String doh;
  public String id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152991);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.id != null) {
        paramVarArgs.d(1, this.id);
      }
      if (this.doh != null) {
        paramVarArgs.d(2, this.doh);
      }
      paramVarArgs.bg(3, this.Dkb);
      AppMethodBeat.o(152991);
      return 0;
    }
    if (paramInt == 1) {
      if (this.id == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.id) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.doh != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.doh);
      }
      paramInt = f.a.a.b.b.a.fY(3);
      AppMethodBeat.o(152991);
      return i + (paramInt + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(152991);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ahk localahk = (ahk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152991);
          return -1;
        case 1: 
          localahk.id = locala.KhF.readString();
          AppMethodBeat.o(152991);
          return 0;
        case 2: 
          localahk.doh = locala.KhF.readString();
          AppMethodBeat.o(152991);
          return 0;
        }
        localahk.Dkb = locala.KhF.fHu();
        AppMethodBeat.o(152991);
        return 0;
      }
      AppMethodBeat.o(152991);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahk
 * JD-Core Version:    0.7.0.1
 */