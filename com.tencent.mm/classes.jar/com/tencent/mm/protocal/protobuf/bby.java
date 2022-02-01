package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class bby
  extends com.tencent.mm.bw.a
{
  public String LLa;
  public b LLb;
  public String LLc;
  public int actionType;
  public String appId;
  public String link;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209669);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LLa != null) {
        paramVarArgs.e(1, this.LLa);
      }
      paramVarArgs.aM(2, this.actionType);
      if (this.link != null) {
        paramVarArgs.e(3, this.link);
      }
      if (this.appId != null) {
        paramVarArgs.e(4, this.appId);
      }
      if (this.LLb != null) {
        paramVarArgs.c(5, this.LLb);
      }
      if (this.LLc != null) {
        paramVarArgs.e(6, this.LLc);
      }
      AppMethodBeat.o(209669);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LLa == null) {
        break label502;
      }
    }
    label502:
    for (paramInt = g.a.a.b.b.a.f(1, this.LLa) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.actionType);
      paramInt = i;
      if (this.link != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.link);
      }
      i = paramInt;
      if (this.appId != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.appId);
      }
      paramInt = i;
      if (this.LLb != null) {
        paramInt = i + g.a.a.b.b.a.b(5, this.LLb);
      }
      i = paramInt;
      if (this.LLc != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.LLc);
      }
      AppMethodBeat.o(209669);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209669);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bby localbby = (bby)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(209669);
          return -1;
        case 1: 
          localbby.LLa = locala.UbS.readString();
          AppMethodBeat.o(209669);
          return 0;
        case 2: 
          localbby.actionType = locala.UbS.zi();
          AppMethodBeat.o(209669);
          return 0;
        case 3: 
          localbby.link = locala.UbS.readString();
          AppMethodBeat.o(209669);
          return 0;
        case 4: 
          localbby.appId = locala.UbS.readString();
          AppMethodBeat.o(209669);
          return 0;
        case 5: 
          localbby.LLb = locala.UbS.hPo();
          AppMethodBeat.o(209669);
          return 0;
        }
        localbby.LLc = locala.UbS.readString();
        AppMethodBeat.o(209669);
        return 0;
      }
      AppMethodBeat.o(209669);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bby
 * JD-Core Version:    0.7.0.1
 */