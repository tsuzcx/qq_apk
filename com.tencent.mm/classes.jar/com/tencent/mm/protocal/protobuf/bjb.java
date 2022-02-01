package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class bjb
  extends com.tencent.mm.bx.a
{
  public String ZFM;
  public b ZLo;
  public boolean ZPU;
  public String nVs;
  public String nickname;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260105);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.g(1, this.username);
      }
      if (this.nickname != null) {
        paramVarArgs.g(2, this.nickname);
      }
      if (this.nVs != null) {
        paramVarArgs.g(3, this.nVs);
      }
      if (this.ZFM != null) {
        paramVarArgs.g(4, this.ZFM);
      }
      if (this.ZLo != null) {
        paramVarArgs.d(5, this.ZLo);
      }
      paramVarArgs.di(6, this.ZPU);
      AppMethodBeat.o(260105);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label494;
      }
    }
    label494:
    for (int i = i.a.a.b.b.a.h(1, this.username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.nickname);
      }
      i = paramInt;
      if (this.nVs != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.nVs);
      }
      paramInt = i;
      if (this.ZFM != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ZFM);
      }
      i = paramInt;
      if (this.ZLo != null) {
        i = paramInt + i.a.a.b.b.a.c(5, this.ZLo);
      }
      paramInt = i.a.a.b.b.a.ko(6);
      AppMethodBeat.o(260105);
      return i + (paramInt + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(260105);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        bjb localbjb = (bjb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(260105);
          return -1;
        case 1: 
          localbjb.username = locala.ajGk.readString();
          AppMethodBeat.o(260105);
          return 0;
        case 2: 
          localbjb.nickname = locala.ajGk.readString();
          AppMethodBeat.o(260105);
          return 0;
        case 3: 
          localbjb.nVs = locala.ajGk.readString();
          AppMethodBeat.o(260105);
          return 0;
        case 4: 
          localbjb.ZFM = locala.ajGk.readString();
          AppMethodBeat.o(260105);
          return 0;
        case 5: 
          localbjb.ZLo = locala.ajGk.kFX();
          AppMethodBeat.o(260105);
          return 0;
        }
        localbjb.ZPU = locala.ajGk.aai();
        AppMethodBeat.o(260105);
        return 0;
      }
      AppMethodBeat.o(260105);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjb
 * JD-Core Version:    0.7.0.1
 */