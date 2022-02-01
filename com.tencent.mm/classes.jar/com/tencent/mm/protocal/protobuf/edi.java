package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class edi
  extends com.tencent.mm.bx.a
{
  public String ZkD;
  public boolean abiC;
  public boolean abiD;
  public String data;
  public String dbg;
  public String hRk;
  public String tGK;
  public String tGL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123634);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.hRk != null) {
        paramVarArgs.g(1, this.hRk);
      }
      if (this.ZkD != null) {
        paramVarArgs.g(2, this.ZkD);
      }
      paramVarArgs.di(3, this.abiC);
      paramVarArgs.di(4, this.abiD);
      if (this.tGK != null) {
        paramVarArgs.g(5, this.tGK);
      }
      if (this.dbg != null) {
        paramVarArgs.g(6, this.dbg);
      }
      if (this.tGL != null) {
        paramVarArgs.g(7, this.tGL);
      }
      if (this.data != null) {
        paramVarArgs.g(8, this.data);
      }
      AppMethodBeat.o(123634);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hRk == null) {
        break label598;
      }
    }
    label598:
    for (paramInt = i.a.a.b.b.a.h(1, this.hRk) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ZkD != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.ZkD);
      }
      i = i + (i.a.a.b.b.a.ko(3) + 1) + (i.a.a.b.b.a.ko(4) + 1);
      paramInt = i;
      if (this.tGK != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.tGK);
      }
      i = paramInt;
      if (this.dbg != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.dbg);
      }
      paramInt = i;
      if (this.tGL != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.tGL);
      }
      i = paramInt;
      if (this.data != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.data);
      }
      AppMethodBeat.o(123634);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(123634);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        edi localedi = (edi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123634);
          return -1;
        case 1: 
          localedi.hRk = locala.ajGk.readString();
          AppMethodBeat.o(123634);
          return 0;
        case 2: 
          localedi.ZkD = locala.ajGk.readString();
          AppMethodBeat.o(123634);
          return 0;
        case 3: 
          localedi.abiC = locala.ajGk.aai();
          AppMethodBeat.o(123634);
          return 0;
        case 4: 
          localedi.abiD = locala.ajGk.aai();
          AppMethodBeat.o(123634);
          return 0;
        case 5: 
          localedi.tGK = locala.ajGk.readString();
          AppMethodBeat.o(123634);
          return 0;
        case 6: 
          localedi.dbg = locala.ajGk.readString();
          AppMethodBeat.o(123634);
          return 0;
        case 7: 
          localedi.tGL = locala.ajGk.readString();
          AppMethodBeat.o(123634);
          return 0;
        }
        localedi.data = locala.ajGk.readString();
        AppMethodBeat.o(123634);
        return 0;
      }
      AppMethodBeat.o(123634);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.edi
 * JD-Core Version:    0.7.0.1
 */