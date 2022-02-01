package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eai
  extends com.tencent.mm.bx.a
{
  public LinkedList<Long> abfA;
  public int cHb;
  public String extraInfo;
  public String hJW;
  public int hYb;
  public String sessionId;
  public long zIA;
  public String zIB;
  public String zIC;
  public String zIE;
  public long zIy;
  public long zIz;
  
  public eai()
  {
    AppMethodBeat.i(258481);
    this.cHb = 0;
    this.zIy = 0L;
    this.zIz = 0L;
    this.zIA = 0L;
    this.hYb = 0;
    this.abfA = new LinkedList();
    AppMethodBeat.o(258481);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258485);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.sessionId != null) {
        paramVarArgs.g(1, this.sessionId);
      }
      if (this.hJW != null) {
        paramVarArgs.g(2, this.hJW);
      }
      paramVarArgs.bS(3, this.cHb);
      paramVarArgs.bv(4, this.zIy);
      paramVarArgs.bv(5, this.zIz);
      paramVarArgs.bv(6, this.zIA);
      if (this.zIB != null) {
        paramVarArgs.g(7, this.zIB);
      }
      if (this.zIC != null) {
        paramVarArgs.g(8, this.zIC);
      }
      paramVarArgs.bS(9, this.hYb);
      paramVarArgs.e(10, 3, this.abfA);
      if (this.extraInfo != null) {
        paramVarArgs.g(11, this.extraInfo);
      }
      if (this.zIE != null) {
        paramVarArgs.g(12, this.zIE);
      }
      AppMethodBeat.o(258485);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sessionId == null) {
        break label801;
      }
    }
    label801:
    for (paramInt = i.a.a.b.b.a.h(1, this.sessionId) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.hJW != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.hJW);
      }
      i = i + i.a.a.b.b.a.cJ(3, this.cHb) + i.a.a.b.b.a.q(4, this.zIy) + i.a.a.b.b.a.q(5, this.zIz) + i.a.a.b.b.a.q(6, this.zIA);
      paramInt = i;
      if (this.zIB != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.zIB);
      }
      i = paramInt;
      if (this.zIC != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.zIC);
      }
      i = i + i.a.a.b.b.a.cJ(9, this.hYb) + i.a.a.a.c(10, 3, this.abfA);
      paramInt = i;
      if (this.extraInfo != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.extraInfo);
      }
      i = paramInt;
      if (this.zIE != null) {
        i = paramInt + i.a.a.b.b.a.h(12, this.zIE);
      }
      AppMethodBeat.o(258485);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abfA.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258485);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        eai localeai = (eai)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258485);
          return -1;
        case 1: 
          localeai.sessionId = locala.ajGk.readString();
          AppMethodBeat.o(258485);
          return 0;
        case 2: 
          localeai.hJW = locala.ajGk.readString();
          AppMethodBeat.o(258485);
          return 0;
        case 3: 
          localeai.cHb = locala.ajGk.aar();
          AppMethodBeat.o(258485);
          return 0;
        case 4: 
          localeai.zIy = locala.ajGk.aaw();
          AppMethodBeat.o(258485);
          return 0;
        case 5: 
          localeai.zIz = locala.ajGk.aaw();
          AppMethodBeat.o(258485);
          return 0;
        case 6: 
          localeai.zIA = locala.ajGk.aaw();
          AppMethodBeat.o(258485);
          return 0;
        case 7: 
          localeai.zIB = locala.ajGk.readString();
          AppMethodBeat.o(258485);
          return 0;
        case 8: 
          localeai.zIC = locala.ajGk.readString();
          AppMethodBeat.o(258485);
          return 0;
        case 9: 
          localeai.hYb = locala.ajGk.aar();
          AppMethodBeat.o(258485);
          return 0;
        case 10: 
          localeai.abfA.add(Long.valueOf(locala.ajGk.aaw()));
          AppMethodBeat.o(258485);
          return 0;
        case 11: 
          localeai.extraInfo = locala.ajGk.readString();
          AppMethodBeat.o(258485);
          return 0;
        }
        localeai.zIE = locala.ajGk.readString();
        AppMethodBeat.o(258485);
        return 0;
      }
      AppMethodBeat.o(258485);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eai
 * JD-Core Version:    0.7.0.1
 */