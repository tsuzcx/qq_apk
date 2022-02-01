package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public class ghr
  extends com.tencent.mm.bx.a
{
  public int aceb;
  public int acec;
  public int dQ;
  public int mUU;
  public int startTime;
  public String title;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258816);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.url == null)
      {
        paramVarArgs = new b("Not all required fields were included: url");
        AppMethodBeat.o(258816);
        throw paramVarArgs;
      }
      if (this.url != null) {
        paramVarArgs.g(1, this.url);
      }
      paramVarArgs.bS(2, this.dQ);
      paramVarArgs.bS(3, this.mUU);
      paramVarArgs.bS(4, this.startTime);
      paramVarArgs.bS(5, this.aceb);
      paramVarArgs.bS(6, this.acec);
      if (this.title != null) {
        paramVarArgs.g(7, this.title);
      }
      AppMethodBeat.o(258816);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label534;
      }
    }
    label534:
    for (paramInt = i.a.a.b.b.a.h(1, this.url) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.dQ) + i.a.a.b.b.a.cJ(3, this.mUU) + i.a.a.b.b.a.cJ(4, this.startTime) + i.a.a.b.b.a.cJ(5, this.aceb) + i.a.a.b.b.a.cJ(6, this.acec);
      paramInt = i;
      if (this.title != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.title);
      }
      AppMethodBeat.o(258816);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.url == null)
        {
          paramVarArgs = new b("Not all required fields were included: url");
          AppMethodBeat.o(258816);
          throw paramVarArgs;
        }
        AppMethodBeat.o(258816);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ghr localghr = (ghr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258816);
          return -1;
        case 1: 
          localghr.url = locala.ajGk.readString();
          AppMethodBeat.o(258816);
          return 0;
        case 2: 
          localghr.dQ = locala.ajGk.aar();
          AppMethodBeat.o(258816);
          return 0;
        case 3: 
          localghr.mUU = locala.ajGk.aar();
          AppMethodBeat.o(258816);
          return 0;
        case 4: 
          localghr.startTime = locala.ajGk.aar();
          AppMethodBeat.o(258816);
          return 0;
        case 5: 
          localghr.aceb = locala.ajGk.aar();
          AppMethodBeat.o(258816);
          return 0;
        case 6: 
          localghr.acec = locala.ajGk.aar();
          AppMethodBeat.o(258816);
          return 0;
        }
        localghr.title = locala.ajGk.readString();
        AppMethodBeat.o(258816);
        return 0;
      }
      AppMethodBeat.o(258816);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ghr
 * JD-Core Version:    0.7.0.1
 */