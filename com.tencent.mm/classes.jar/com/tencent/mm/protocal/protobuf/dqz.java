package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dqz
  extends com.tencent.mm.bx.a
{
  public String aaBZ;
  public String aaCa;
  public String aazm;
  public String hOQ;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123628);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aazm != null) {
        paramVarArgs.g(1, this.aazm);
      }
      if (this.url != null) {
        paramVarArgs.g(2, this.url);
      }
      if (this.hOQ != null) {
        paramVarArgs.g(3, this.hOQ);
      }
      if (this.aaBZ != null) {
        paramVarArgs.g(4, this.aaBZ);
      }
      if (this.aaCa != null) {
        paramVarArgs.g(5, this.aaCa);
      }
      AppMethodBeat.o(123628);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aazm == null) {
        break label450;
      }
    }
    label450:
    for (int i = i.a.a.b.b.a.h(1, this.aazm) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.url);
      }
      i = paramInt;
      if (this.hOQ != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.hOQ);
      }
      paramInt = i;
      if (this.aaBZ != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aaBZ);
      }
      i = paramInt;
      if (this.aaCa != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.aaCa);
      }
      AppMethodBeat.o(123628);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(123628);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dqz localdqz = (dqz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123628);
          return -1;
        case 1: 
          localdqz.aazm = locala.ajGk.readString();
          AppMethodBeat.o(123628);
          return 0;
        case 2: 
          localdqz.url = locala.ajGk.readString();
          AppMethodBeat.o(123628);
          return 0;
        case 3: 
          localdqz.hOQ = locala.ajGk.readString();
          AppMethodBeat.o(123628);
          return 0;
        case 4: 
          localdqz.aaBZ = locala.ajGk.readString();
          AppMethodBeat.o(123628);
          return 0;
        }
        localdqz.aaCa = locala.ajGk.readString();
        AppMethodBeat.o(123628);
        return 0;
      }
      AppMethodBeat.o(123628);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqz
 * JD-Core Version:    0.7.0.1
 */