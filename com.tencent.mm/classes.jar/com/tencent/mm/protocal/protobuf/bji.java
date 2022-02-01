package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bji
  extends com.tencent.mm.bx.a
{
  public String ZPd;
  public String ZSV;
  public String id;
  public int status;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259941);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.id != null) {
        paramVarArgs.g(1, this.id);
      }
      if (this.ZPd != null) {
        paramVarArgs.g(2, this.ZPd);
      }
      if (this.ZSV != null) {
        paramVarArgs.g(3, this.ZSV);
      }
      paramVarArgs.bS(4, this.status);
      AppMethodBeat.o(259941);
      return 0;
    }
    if (paramInt == 1) {
      if (this.id == null) {
        break label374;
      }
    }
    label374:
    for (int i = i.a.a.b.b.a.h(1, this.id) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ZPd != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ZPd);
      }
      i = paramInt;
      if (this.ZSV != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ZSV);
      }
      paramInt = i.a.a.b.b.a.cJ(4, this.status);
      AppMethodBeat.o(259941);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259941);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        bji localbji = (bji)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259941);
          return -1;
        case 1: 
          localbji.id = locala.ajGk.readString();
          AppMethodBeat.o(259941);
          return 0;
        case 2: 
          localbji.ZPd = locala.ajGk.readString();
          AppMethodBeat.o(259941);
          return 0;
        case 3: 
          localbji.ZSV = locala.ajGk.readString();
          AppMethodBeat.o(259941);
          return 0;
        }
        localbji.status = locala.ajGk.aar();
        AppMethodBeat.o(259941);
        return 0;
      }
      AppMethodBeat.o(259941);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bji
 * JD-Core Version:    0.7.0.1
 */