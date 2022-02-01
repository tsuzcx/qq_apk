package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ath
  extends com.tencent.mm.bx.a
{
  public String ZDM;
  public String ZDN;
  public String ZDO;
  public String wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258314);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.wording != null) {
        paramVarArgs.g(1, this.wording);
      }
      if (this.ZDM != null) {
        paramVarArgs.g(2, this.ZDM);
      }
      if (this.ZDN != null) {
        paramVarArgs.g(3, this.ZDN);
      }
      if (this.ZDO != null) {
        paramVarArgs.g(4, this.ZDO);
      }
      AppMethodBeat.o(258314);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wording == null) {
        break label390;
      }
    }
    label390:
    for (int i = i.a.a.b.b.a.h(1, this.wording) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ZDM != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ZDM);
      }
      i = paramInt;
      if (this.ZDN != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ZDN);
      }
      paramInt = i;
      if (this.ZDO != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ZDO);
      }
      AppMethodBeat.o(258314);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258314);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ath localath = (ath)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258314);
          return -1;
        case 1: 
          localath.wording = locala.ajGk.readString();
          AppMethodBeat.o(258314);
          return 0;
        case 2: 
          localath.ZDM = locala.ajGk.readString();
          AppMethodBeat.o(258314);
          return 0;
        case 3: 
          localath.ZDN = locala.ajGk.readString();
          AppMethodBeat.o(258314);
          return 0;
        }
        localath.ZDO = locala.ajGk.readString();
        AppMethodBeat.o(258314);
        return 0;
      }
      AppMethodBeat.o(258314);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ath
 * JD-Core Version:    0.7.0.1
 */