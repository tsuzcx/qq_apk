package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class so
  extends com.tencent.mm.bw.a
{
  public int ETL;
  public int ETM;
  public int LaB;
  public String LaC;
  public String LaD;
  public String LaE;
  public int Lan;
  public String aeskey;
  public String gTB;
  public int length;
  public String md5;
  public int type;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(226008);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.aeskey == null)
      {
        paramVarArgs = new b("Not all required fields were included: aeskey");
        AppMethodBeat.o(226008);
        throw paramVarArgs;
      }
      if (this.url == null)
      {
        paramVarArgs = new b("Not all required fields were included: url");
        AppMethodBeat.o(226008);
        throw paramVarArgs;
      }
      if (this.aeskey != null) {
        paramVarArgs.e(1, this.aeskey);
      }
      if (this.url != null) {
        paramVarArgs.e(2, this.url);
      }
      paramVarArgs.aM(3, this.type);
      paramVarArgs.aM(4, this.length);
      paramVarArgs.aM(5, this.LaB);
      if (this.LaC != null) {
        paramVarArgs.e(6, this.LaC);
      }
      if (this.gTB != null) {
        paramVarArgs.e(7, this.gTB);
      }
      paramVarArgs.aM(8, this.Lan);
      paramVarArgs.aM(9, this.ETL);
      paramVarArgs.aM(10, this.ETM);
      if (this.md5 != null) {
        paramVarArgs.e(11, this.md5);
      }
      if (this.LaD != null) {
        paramVarArgs.e(12, this.LaD);
      }
      if (this.LaE != null) {
        paramVarArgs.e(13, this.LaE);
      }
      AppMethodBeat.o(226008);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aeskey == null) {
        break label942;
      }
    }
    label942:
    for (paramInt = g.a.a.b.b.a.f(1, this.aeskey) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.url != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.url);
      }
      i = i + g.a.a.b.b.a.bu(3, this.type) + g.a.a.b.b.a.bu(4, this.length) + g.a.a.b.b.a.bu(5, this.LaB);
      paramInt = i;
      if (this.LaC != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.LaC);
      }
      i = paramInt;
      if (this.gTB != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.gTB);
      }
      i = i + g.a.a.b.b.a.bu(8, this.Lan) + g.a.a.b.b.a.bu(9, this.ETL) + g.a.a.b.b.a.bu(10, this.ETM);
      paramInt = i;
      if (this.md5 != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.md5);
      }
      i = paramInt;
      if (this.LaD != null) {
        i = paramInt + g.a.a.b.b.a.f(12, this.LaD);
      }
      paramInt = i;
      if (this.LaE != null) {
        paramInt = i + g.a.a.b.b.a.f(13, this.LaE);
      }
      AppMethodBeat.o(226008);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.aeskey == null)
        {
          paramVarArgs = new b("Not all required fields were included: aeskey");
          AppMethodBeat.o(226008);
          throw paramVarArgs;
        }
        if (this.url == null)
        {
          paramVarArgs = new b("Not all required fields were included: url");
          AppMethodBeat.o(226008);
          throw paramVarArgs;
        }
        AppMethodBeat.o(226008);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        so localso = (so)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(226008);
          return -1;
        case 1: 
          localso.aeskey = locala.UbS.readString();
          AppMethodBeat.o(226008);
          return 0;
        case 2: 
          localso.url = locala.UbS.readString();
          AppMethodBeat.o(226008);
          return 0;
        case 3: 
          localso.type = locala.UbS.zi();
          AppMethodBeat.o(226008);
          return 0;
        case 4: 
          localso.length = locala.UbS.zi();
          AppMethodBeat.o(226008);
          return 0;
        case 5: 
          localso.LaB = locala.UbS.zi();
          AppMethodBeat.o(226008);
          return 0;
        case 6: 
          localso.LaC = locala.UbS.readString();
          AppMethodBeat.o(226008);
          return 0;
        case 7: 
          localso.gTB = locala.UbS.readString();
          AppMethodBeat.o(226008);
          return 0;
        case 8: 
          localso.Lan = locala.UbS.zi();
          AppMethodBeat.o(226008);
          return 0;
        case 9: 
          localso.ETL = locala.UbS.zi();
          AppMethodBeat.o(226008);
          return 0;
        case 10: 
          localso.ETM = locala.UbS.zi();
          AppMethodBeat.o(226008);
          return 0;
        case 11: 
          localso.md5 = locala.UbS.readString();
          AppMethodBeat.o(226008);
          return 0;
        case 12: 
          localso.LaD = locala.UbS.readString();
          AppMethodBeat.o(226008);
          return 0;
        }
        localso.LaE = locala.UbS.readString();
        AppMethodBeat.o(226008);
        return 0;
      }
      AppMethodBeat.o(226008);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.so
 * JD-Core Version:    0.7.0.1
 */