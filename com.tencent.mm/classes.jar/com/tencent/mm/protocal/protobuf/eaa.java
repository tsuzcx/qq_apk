package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eaa
  extends com.tencent.mm.bx.a
{
  public int aaBU;
  public boolean aarj;
  public boolean aark;
  public String aazm;
  public int aazp;
  public String appid;
  public String md5;
  public String url;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123633);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.appid != null) {
        paramVarArgs.g(1, this.appid);
      }
      if (this.aazm != null) {
        paramVarArgs.g(2, this.aazm);
      }
      paramVarArgs.bS(3, this.aazp);
      paramVarArgs.bS(4, this.version);
      if (this.url != null) {
        paramVarArgs.g(5, this.url);
      }
      if (this.md5 != null) {
        paramVarArgs.g(6, this.md5);
      }
      paramVarArgs.di(20, this.aarj);
      paramVarArgs.di(21, this.aark);
      paramVarArgs.bS(22, this.aaBU);
      AppMethodBeat.o(123633);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appid == null) {
        break label650;
      }
    }
    label650:
    for (paramInt = i.a.a.b.b.a.h(1, this.appid) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.aazm != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.aazm);
      }
      i = i + i.a.a.b.b.a.cJ(3, this.aazp) + i.a.a.b.b.a.cJ(4, this.version);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.url);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.md5);
      }
      paramInt = i.a.a.b.b.a.ko(20);
      int j = i.a.a.b.b.a.ko(21);
      int k = i.a.a.b.b.a.cJ(22, this.aaBU);
      AppMethodBeat.o(123633);
      return i + (paramInt + 1) + (j + 1) + k;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(123633);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        eaa localeaa = (eaa)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123633);
          return -1;
        case 1: 
          localeaa.appid = locala.ajGk.readString();
          AppMethodBeat.o(123633);
          return 0;
        case 2: 
          localeaa.aazm = locala.ajGk.readString();
          AppMethodBeat.o(123633);
          return 0;
        case 3: 
          localeaa.aazp = locala.ajGk.aar();
          AppMethodBeat.o(123633);
          return 0;
        case 4: 
          localeaa.version = locala.ajGk.aar();
          AppMethodBeat.o(123633);
          return 0;
        case 5: 
          localeaa.url = locala.ajGk.readString();
          AppMethodBeat.o(123633);
          return 0;
        case 6: 
          localeaa.md5 = locala.ajGk.readString();
          AppMethodBeat.o(123633);
          return 0;
        case 20: 
          localeaa.aarj = locala.ajGk.aai();
          AppMethodBeat.o(123633);
          return 0;
        case 21: 
          localeaa.aark = locala.ajGk.aai();
          AppMethodBeat.o(123633);
          return 0;
        }
        localeaa.aaBU = locala.ajGk.aar();
        AppMethodBeat.o(123633);
        return 0;
      }
      AppMethodBeat.o(123633);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eaa
 * JD-Core Version:    0.7.0.1
 */