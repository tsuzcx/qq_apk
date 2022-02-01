package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m
  extends com.tencent.mm.bx.a
{
  public String Okz;
  public String ToR;
  public String ToS;
  public String ToT;
  public String ToU;
  public String ToV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(290025);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Okz != null) {
        paramVarArgs.g(1, this.Okz);
      }
      if (this.ToR != null) {
        paramVarArgs.g(2, this.ToR);
      }
      if (this.ToS != null) {
        paramVarArgs.g(3, this.ToS);
      }
      if (this.ToT != null) {
        paramVarArgs.g(4, this.ToT);
      }
      if (this.ToU != null) {
        paramVarArgs.g(5, this.ToU);
      }
      if (this.ToV != null) {
        paramVarArgs.g(6, this.ToV);
      }
      AppMethodBeat.o(290025);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Okz == null) {
        break label514;
      }
    }
    label514:
    for (int i = i.a.a.b.b.a.h(1, this.Okz) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ToR != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ToR);
      }
      i = paramInt;
      if (this.ToS != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ToS);
      }
      paramInt = i;
      if (this.ToT != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ToT);
      }
      i = paramInt;
      if (this.ToU != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.ToU);
      }
      paramInt = i;
      if (this.ToV != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.ToV);
      }
      AppMethodBeat.o(290025);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(290025);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        m localm = (m)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(290025);
          return -1;
        case 1: 
          localm.Okz = locala.ajGk.readString();
          AppMethodBeat.o(290025);
          return 0;
        case 2: 
          localm.ToR = locala.ajGk.readString();
          AppMethodBeat.o(290025);
          return 0;
        case 3: 
          localm.ToS = locala.ajGk.readString();
          AppMethodBeat.o(290025);
          return 0;
        case 4: 
          localm.ToT = locala.ajGk.readString();
          AppMethodBeat.o(290025);
          return 0;
        case 5: 
          localm.ToU = locala.ajGk.readString();
          AppMethodBeat.o(290025);
          return 0;
        }
        localm.ToV = locala.ajGk.readString();
        AppMethodBeat.o(290025);
        return 0;
      }
      AppMethodBeat.o(290025);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.m
 * JD-Core Version:    0.7.0.1
 */