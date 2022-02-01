package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class amf
  extends com.tencent.mm.bx.a
{
  public String dbPath;
  public String sql;
  public int zAd;
  public String zAf;
  public String zAh;
  public String zAi;
  public String zzS;
  public int zzX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257731);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.zzS != null) {
        paramVarArgs.g(1, this.zzS);
      }
      paramVarArgs.bS(2, this.zzX);
      if (this.sql != null) {
        paramVarArgs.g(3, this.sql);
      }
      if (this.dbPath != null) {
        paramVarArgs.g(4, this.dbPath);
      }
      if (this.zAf != null) {
        paramVarArgs.g(5, this.zAf);
      }
      if (this.zAi != null) {
        paramVarArgs.g(6, this.zAi);
      }
      paramVarArgs.bS(7, this.zAd);
      if (this.zAh != null) {
        paramVarArgs.g(8, this.zAh);
      }
      AppMethodBeat.o(257731);
      return 0;
    }
    if (paramInt == 1) {
      if (this.zzS == null) {
        break label606;
      }
    }
    label606:
    for (paramInt = i.a.a.b.b.a.h(1, this.zzS) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.zzX);
      paramInt = i;
      if (this.sql != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.sql);
      }
      i = paramInt;
      if (this.dbPath != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.dbPath);
      }
      paramInt = i;
      if (this.zAf != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.zAf);
      }
      i = paramInt;
      if (this.zAi != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.zAi);
      }
      i += i.a.a.b.b.a.cJ(7, this.zAd);
      paramInt = i;
      if (this.zAh != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.zAh);
      }
      AppMethodBeat.o(257731);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257731);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        amf localamf = (amf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(257731);
          return -1;
        case 1: 
          localamf.zzS = locala.ajGk.readString();
          AppMethodBeat.o(257731);
          return 0;
        case 2: 
          localamf.zzX = locala.ajGk.aar();
          AppMethodBeat.o(257731);
          return 0;
        case 3: 
          localamf.sql = locala.ajGk.readString();
          AppMethodBeat.o(257731);
          return 0;
        case 4: 
          localamf.dbPath = locala.ajGk.readString();
          AppMethodBeat.o(257731);
          return 0;
        case 5: 
          localamf.zAf = locala.ajGk.readString();
          AppMethodBeat.o(257731);
          return 0;
        case 6: 
          localamf.zAi = locala.ajGk.readString();
          AppMethodBeat.o(257731);
          return 0;
        case 7: 
          localamf.zAd = locala.ajGk.aar();
          AppMethodBeat.o(257731);
          return 0;
        }
        localamf.zAh = locala.ajGk.readString();
        AppMethodBeat.o(257731);
        return 0;
      }
      AppMethodBeat.o(257731);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amf
 * JD-Core Version:    0.7.0.1
 */