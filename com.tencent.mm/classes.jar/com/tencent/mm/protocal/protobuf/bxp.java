package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bxp
  extends com.tencent.mm.bx.a
{
  public String Adv;
  public String DUg;
  public String app_id;
  public String nCa;
  public String nCc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72540);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.app_id != null) {
        paramVarArgs.d(1, this.app_id);
      }
      if (this.Adv != null) {
        paramVarArgs.d(2, this.Adv);
      }
      if (this.nCc != null) {
        paramVarArgs.d(3, this.nCc);
      }
      if (this.nCa != null) {
        paramVarArgs.d(4, this.nCa);
      }
      if (this.DUg != null) {
        paramVarArgs.d(5, this.DUg);
      }
      AppMethodBeat.o(72540);
      return 0;
    }
    if (paramInt == 1) {
      if (this.app_id == null) {
        break label454;
      }
    }
    label454:
    for (int i = f.a.a.b.b.a.e(1, this.app_id) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Adv != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Adv);
      }
      i = paramInt;
      if (this.nCc != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.nCc);
      }
      paramInt = i;
      if (this.nCa != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.nCa);
      }
      i = paramInt;
      if (this.DUg != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.DUg);
      }
      AppMethodBeat.o(72540);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(72540);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bxp localbxp = (bxp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72540);
          return -1;
        case 1: 
          localbxp.app_id = locala.KhF.readString();
          AppMethodBeat.o(72540);
          return 0;
        case 2: 
          localbxp.Adv = locala.KhF.readString();
          AppMethodBeat.o(72540);
          return 0;
        case 3: 
          localbxp.nCc = locala.KhF.readString();
          AppMethodBeat.o(72540);
          return 0;
        case 4: 
          localbxp.nCa = locala.KhF.readString();
          AppMethodBeat.o(72540);
          return 0;
        }
        localbxp.DUg = locala.KhF.readString();
        AppMethodBeat.o(72540);
        return 0;
      }
      AppMethodBeat.o(72540);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxp
 * JD-Core Version:    0.7.0.1
 */