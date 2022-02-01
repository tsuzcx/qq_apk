package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class enq
  extends com.tencent.mm.bx.a
{
  public int IJG;
  public String SessionId;
  public String YWK;
  public b aaui;
  public b aauj;
  public String absf;
  public b absg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104831);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YWK != null) {
        paramVarArgs.g(1, this.YWK);
      }
      if (this.absf != null) {
        paramVarArgs.g(2, this.absf);
      }
      if (this.SessionId != null) {
        paramVarArgs.g(3, this.SessionId);
      }
      if (this.aauj != null) {
        paramVarArgs.d(4, this.aauj);
      }
      if (this.aaui != null) {
        paramVarArgs.d(5, this.aaui);
      }
      paramVarArgs.bS(6, this.IJG);
      if (this.absg != null) {
        paramVarArgs.d(7, this.absg);
      }
      AppMethodBeat.o(104831);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YWK == null) {
        break label558;
      }
    }
    label558:
    for (int i = i.a.a.b.b.a.h(1, this.YWK) + 0;; i = 0)
    {
      paramInt = i;
      if (this.absf != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.absf);
      }
      i = paramInt;
      if (this.SessionId != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.SessionId);
      }
      paramInt = i;
      if (this.aauj != null) {
        paramInt = i + i.a.a.b.b.a.c(4, this.aauj);
      }
      i = paramInt;
      if (this.aaui != null) {
        i = paramInt + i.a.a.b.b.a.c(5, this.aaui);
      }
      i += i.a.a.b.b.a.cJ(6, this.IJG);
      paramInt = i;
      if (this.absg != null) {
        paramInt = i + i.a.a.b.b.a.c(7, this.absg);
      }
      AppMethodBeat.o(104831);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(104831);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        enq localenq = (enq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104831);
          return -1;
        case 1: 
          localenq.YWK = locala.ajGk.readString();
          AppMethodBeat.o(104831);
          return 0;
        case 2: 
          localenq.absf = locala.ajGk.readString();
          AppMethodBeat.o(104831);
          return 0;
        case 3: 
          localenq.SessionId = locala.ajGk.readString();
          AppMethodBeat.o(104831);
          return 0;
        case 4: 
          localenq.aauj = locala.ajGk.kFX();
          AppMethodBeat.o(104831);
          return 0;
        case 5: 
          localenq.aaui = locala.ajGk.kFX();
          AppMethodBeat.o(104831);
          return 0;
        case 6: 
          localenq.IJG = locala.ajGk.aar();
          AppMethodBeat.o(104831);
          return 0;
        }
        localenq.absg = locala.ajGk.kFX();
        AppMethodBeat.o(104831);
        return 0;
      }
      AppMethodBeat.o(104831);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.enq
 * JD-Core Version:    0.7.0.1
 */