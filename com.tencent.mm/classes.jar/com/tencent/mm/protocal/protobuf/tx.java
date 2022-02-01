package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class tx
  extends com.tencent.mm.bx.a
{
  public int RIb;
  public int RIc;
  public String YZF;
  public String YZG;
  public String YZH;
  public int YZr;
  public String aeskey;
  public int length;
  public String md5;
  public String mdZ;
  public int playtime;
  public int type;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259642);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aeskey == null)
      {
        paramVarArgs = new b("Not all required fields were included: aeskey");
        AppMethodBeat.o(259642);
        throw paramVarArgs;
      }
      if (this.url == null)
      {
        paramVarArgs = new b("Not all required fields were included: url");
        AppMethodBeat.o(259642);
        throw paramVarArgs;
      }
      if (this.aeskey != null) {
        paramVarArgs.g(1, this.aeskey);
      }
      if (this.url != null) {
        paramVarArgs.g(2, this.url);
      }
      paramVarArgs.bS(3, this.type);
      paramVarArgs.bS(4, this.length);
      paramVarArgs.bS(5, this.playtime);
      if (this.YZF != null) {
        paramVarArgs.g(6, this.YZF);
      }
      if (this.mdZ != null) {
        paramVarArgs.g(7, this.mdZ);
      }
      paramVarArgs.bS(8, this.YZr);
      paramVarArgs.bS(9, this.RIb);
      paramVarArgs.bS(10, this.RIc);
      if (this.md5 != null) {
        paramVarArgs.g(11, this.md5);
      }
      if (this.YZG != null) {
        paramVarArgs.g(12, this.YZG);
      }
      if (this.YZH != null) {
        paramVarArgs.g(13, this.YZH);
      }
      AppMethodBeat.o(259642);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aeskey == null) {
        break label938;
      }
    }
    label938:
    for (paramInt = i.a.a.b.b.a.h(1, this.aeskey) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.url != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.url);
      }
      i = i + i.a.a.b.b.a.cJ(3, this.type) + i.a.a.b.b.a.cJ(4, this.length) + i.a.a.b.b.a.cJ(5, this.playtime);
      paramInt = i;
      if (this.YZF != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.YZF);
      }
      i = paramInt;
      if (this.mdZ != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.mdZ);
      }
      i = i + i.a.a.b.b.a.cJ(8, this.YZr) + i.a.a.b.b.a.cJ(9, this.RIb) + i.a.a.b.b.a.cJ(10, this.RIc);
      paramInt = i;
      if (this.md5 != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.md5);
      }
      i = paramInt;
      if (this.YZG != null) {
        i = paramInt + i.a.a.b.b.a.h(12, this.YZG);
      }
      paramInt = i;
      if (this.YZH != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.YZH);
      }
      AppMethodBeat.o(259642);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.aeskey == null)
        {
          paramVarArgs = new b("Not all required fields were included: aeskey");
          AppMethodBeat.o(259642);
          throw paramVarArgs;
        }
        if (this.url == null)
        {
          paramVarArgs = new b("Not all required fields were included: url");
          AppMethodBeat.o(259642);
          throw paramVarArgs;
        }
        AppMethodBeat.o(259642);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        tx localtx = (tx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259642);
          return -1;
        case 1: 
          localtx.aeskey = locala.ajGk.readString();
          AppMethodBeat.o(259642);
          return 0;
        case 2: 
          localtx.url = locala.ajGk.readString();
          AppMethodBeat.o(259642);
          return 0;
        case 3: 
          localtx.type = locala.ajGk.aar();
          AppMethodBeat.o(259642);
          return 0;
        case 4: 
          localtx.length = locala.ajGk.aar();
          AppMethodBeat.o(259642);
          return 0;
        case 5: 
          localtx.playtime = locala.ajGk.aar();
          AppMethodBeat.o(259642);
          return 0;
        case 6: 
          localtx.YZF = locala.ajGk.readString();
          AppMethodBeat.o(259642);
          return 0;
        case 7: 
          localtx.mdZ = locala.ajGk.readString();
          AppMethodBeat.o(259642);
          return 0;
        case 8: 
          localtx.YZr = locala.ajGk.aar();
          AppMethodBeat.o(259642);
          return 0;
        case 9: 
          localtx.RIb = locala.ajGk.aar();
          AppMethodBeat.o(259642);
          return 0;
        case 10: 
          localtx.RIc = locala.ajGk.aar();
          AppMethodBeat.o(259642);
          return 0;
        case 11: 
          localtx.md5 = locala.ajGk.readString();
          AppMethodBeat.o(259642);
          return 0;
        case 12: 
          localtx.YZG = locala.ajGk.readString();
          AppMethodBeat.o(259642);
          return 0;
        }
        localtx.YZH = locala.ajGk.readString();
        AppMethodBeat.o(259642);
        return 0;
      }
      AppMethodBeat.o(259642);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tx
 * JD-Core Version:    0.7.0.1
 */