package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class cbk
  extends com.tencent.mm.bx.a
{
  public int HTK;
  public String IGG;
  public String IKJ;
  public String ThumbUrl;
  public int aakI;
  public int aakJ;
  public String aako;
  public String hAP;
  public String oOI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(42646);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.hAP == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(42646);
        throw paramVarArgs;
      }
      if (this.IGG == null)
      {
        paramVarArgs = new b("Not all required fields were included: Desc");
        AppMethodBeat.o(42646);
        throw paramVarArgs;
      }
      if (this.ThumbUrl == null)
      {
        paramVarArgs = new b("Not all required fields were included: ThumbUrl");
        AppMethodBeat.o(42646);
        throw paramVarArgs;
      }
      if (this.hAP != null) {
        paramVarArgs.g(1, this.hAP);
      }
      if (this.IGG != null) {
        paramVarArgs.g(2, this.IGG);
      }
      if (this.ThumbUrl != null) {
        paramVarArgs.g(3, this.ThumbUrl);
      }
      if (this.aako != null) {
        paramVarArgs.g(4, this.aako);
      }
      paramVarArgs.bS(5, this.aakI);
      paramVarArgs.bS(6, this.aakJ);
      if (this.oOI != null) {
        paramVarArgs.g(7, this.oOI);
      }
      paramVarArgs.bS(8, this.HTK);
      if (this.IKJ != null) {
        paramVarArgs.g(9, this.IKJ);
      }
      AppMethodBeat.o(42646);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hAP == null) {
        break label794;
      }
    }
    label794:
    for (int i = i.a.a.b.b.a.h(1, this.hAP) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IGG != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.IGG);
      }
      i = paramInt;
      if (this.ThumbUrl != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ThumbUrl);
      }
      paramInt = i;
      if (this.aako != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aako);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.aakI) + i.a.a.b.b.a.cJ(6, this.aakJ);
      paramInt = i;
      if (this.oOI != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.oOI);
      }
      i = paramInt + i.a.a.b.b.a.cJ(8, this.HTK);
      paramInt = i;
      if (this.IKJ != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.IKJ);
      }
      AppMethodBeat.o(42646);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.hAP == null)
        {
          paramVarArgs = new b("Not all required fields were included: Title");
          AppMethodBeat.o(42646);
          throw paramVarArgs;
        }
        if (this.IGG == null)
        {
          paramVarArgs = new b("Not all required fields were included: Desc");
          AppMethodBeat.o(42646);
          throw paramVarArgs;
        }
        if (this.ThumbUrl == null)
        {
          paramVarArgs = new b("Not all required fields were included: ThumbUrl");
          AppMethodBeat.o(42646);
          throw paramVarArgs;
        }
        AppMethodBeat.o(42646);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        cbk localcbk = (cbk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(42646);
          return -1;
        case 1: 
          localcbk.hAP = locala.ajGk.readString();
          AppMethodBeat.o(42646);
          return 0;
        case 2: 
          localcbk.IGG = locala.ajGk.readString();
          AppMethodBeat.o(42646);
          return 0;
        case 3: 
          localcbk.ThumbUrl = locala.ajGk.readString();
          AppMethodBeat.o(42646);
          return 0;
        case 4: 
          localcbk.aako = locala.ajGk.readString();
          AppMethodBeat.o(42646);
          return 0;
        case 5: 
          localcbk.aakI = locala.ajGk.aar();
          AppMethodBeat.o(42646);
          return 0;
        case 6: 
          localcbk.aakJ = locala.ajGk.aar();
          AppMethodBeat.o(42646);
          return 0;
        case 7: 
          localcbk.oOI = locala.ajGk.readString();
          AppMethodBeat.o(42646);
          return 0;
        case 8: 
          localcbk.HTK = locala.ajGk.aar();
          AppMethodBeat.o(42646);
          return 0;
        }
        localcbk.IKJ = locala.ajGk.readString();
        AppMethodBeat.o(42646);
        return 0;
      }
      AppMethodBeat.o(42646);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbk
 * JD-Core Version:    0.7.0.1
 */