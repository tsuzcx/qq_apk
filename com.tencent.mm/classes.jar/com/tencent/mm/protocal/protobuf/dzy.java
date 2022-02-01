package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dzy
  extends com.tencent.mm.bx.a
{
  public String VEW;
  public String abfh;
  public String app_id;
  public String wDe;
  public String wDg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72540);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.app_id != null) {
        paramVarArgs.g(1, this.app_id);
      }
      if (this.VEW != null) {
        paramVarArgs.g(2, this.VEW);
      }
      if (this.wDg != null) {
        paramVarArgs.g(3, this.wDg);
      }
      if (this.wDe != null) {
        paramVarArgs.g(4, this.wDe);
      }
      if (this.abfh != null) {
        paramVarArgs.g(5, this.abfh);
      }
      AppMethodBeat.o(72540);
      return 0;
    }
    if (paramInt == 1) {
      if (this.app_id == null) {
        break label450;
      }
    }
    label450:
    for (int i = i.a.a.b.b.a.h(1, this.app_id) + 0;; i = 0)
    {
      paramInt = i;
      if (this.VEW != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.VEW);
      }
      i = paramInt;
      if (this.wDg != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.wDg);
      }
      paramInt = i;
      if (this.wDe != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.wDe);
      }
      i = paramInt;
      if (this.abfh != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.abfh);
      }
      AppMethodBeat.o(72540);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(72540);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dzy localdzy = (dzy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72540);
          return -1;
        case 1: 
          localdzy.app_id = locala.ajGk.readString();
          AppMethodBeat.o(72540);
          return 0;
        case 2: 
          localdzy.VEW = locala.ajGk.readString();
          AppMethodBeat.o(72540);
          return 0;
        case 3: 
          localdzy.wDg = locala.ajGk.readString();
          AppMethodBeat.o(72540);
          return 0;
        case 4: 
          localdzy.wDe = locala.ajGk.readString();
          AppMethodBeat.o(72540);
          return 0;
        }
        localdzy.abfh = locala.ajGk.readString();
        AppMethodBeat.o(72540);
        return 0;
      }
      AppMethodBeat.o(72540);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzy
 * JD-Core Version:    0.7.0.1
 */