package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eim
  extends com.tencent.mm.bx.a
{
  public boolean aauo;
  public int abns;
  public boolean abnt;
  public String hOQ;
  public String md5;
  public String url;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123639);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.di(1, this.aauo);
      if (this.url != null) {
        paramVarArgs.g(2, this.url);
      }
      if (this.md5 != null) {
        paramVarArgs.g(3, this.md5);
      }
      paramVarArgs.bS(4, this.version);
      paramVarArgs.bS(5, this.abns);
      if (this.hOQ != null) {
        paramVarArgs.g(6, this.hOQ);
      }
      paramVarArgs.di(7, this.abnt);
      AppMethodBeat.o(123639);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.ko(1) + 1 + 0;
      paramInt = i;
      if (this.url != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.url);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.md5);
      }
      i = i + i.a.a.b.b.a.cJ(4, this.version) + i.a.a.b.b.a.cJ(5, this.abns);
      paramInt = i;
      if (this.hOQ != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.hOQ);
      }
      i = i.a.a.b.b.a.ko(7);
      AppMethodBeat.o(123639);
      return paramInt + (i + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(123639);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      eim localeim = (eim)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123639);
        return -1;
      case 1: 
        localeim.aauo = locala.ajGk.aai();
        AppMethodBeat.o(123639);
        return 0;
      case 2: 
        localeim.url = locala.ajGk.readString();
        AppMethodBeat.o(123639);
        return 0;
      case 3: 
        localeim.md5 = locala.ajGk.readString();
        AppMethodBeat.o(123639);
        return 0;
      case 4: 
        localeim.version = locala.ajGk.aar();
        AppMethodBeat.o(123639);
        return 0;
      case 5: 
        localeim.abns = locala.ajGk.aar();
        AppMethodBeat.o(123639);
        return 0;
      case 6: 
        localeim.hOQ = locala.ajGk.readString();
        AppMethodBeat.o(123639);
        return 0;
      }
      localeim.abnt = locala.ajGk.aai();
      AppMethodBeat.o(123639);
      return 0;
    }
    AppMethodBeat.o(123639);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eim
 * JD-Core Version:    0.7.0.1
 */