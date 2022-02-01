package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class jn
  extends com.tencent.mm.bx.a
{
  public String JFk;
  public String Ocp;
  public String YLA;
  public String YLC;
  public boolean YLM;
  public String YLN;
  public String hAk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(19405);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.JFk != null) {
        paramVarArgs.g(1, this.JFk);
      }
      if (this.Ocp != null) {
        paramVarArgs.g(2, this.Ocp);
      }
      if (this.hAk != null) {
        paramVarArgs.g(3, this.hAk);
      }
      paramVarArgs.di(4, this.YLM);
      if (this.YLC != null) {
        paramVarArgs.g(5, this.YLC);
      }
      if (this.YLA != null) {
        paramVarArgs.g(6, this.YLA);
      }
      if (this.YLN != null) {
        paramVarArgs.g(7, this.YLN);
      }
      AppMethodBeat.o(19405);
      return 0;
    }
    if (paramInt == 1) {
      if (this.JFk == null) {
        break label571;
      }
    }
    label571:
    for (int i = i.a.a.b.b.a.h(1, this.JFk) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Ocp != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.Ocp);
      }
      i = paramInt;
      if (this.hAk != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.hAk);
      }
      i += i.a.a.b.b.a.ko(4) + 1;
      paramInt = i;
      if (this.YLC != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.YLC);
      }
      i = paramInt;
      if (this.YLA != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.YLA);
      }
      paramInt = i;
      if (this.YLN != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.YLN);
      }
      AppMethodBeat.o(19405);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(19405);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        jn localjn = (jn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(19405);
          return -1;
        case 1: 
          localjn.JFk = locala.ajGk.readString();
          AppMethodBeat.o(19405);
          return 0;
        case 2: 
          localjn.Ocp = locala.ajGk.readString();
          AppMethodBeat.o(19405);
          return 0;
        case 3: 
          localjn.hAk = locala.ajGk.readString();
          AppMethodBeat.o(19405);
          return 0;
        case 4: 
          localjn.YLM = locala.ajGk.aai();
          AppMethodBeat.o(19405);
          return 0;
        case 5: 
          localjn.YLC = locala.ajGk.readString();
          AppMethodBeat.o(19405);
          return 0;
        case 6: 
          localjn.YLA = locala.ajGk.readString();
          AppMethodBeat.o(19405);
          return 0;
        }
        localjn.YLN = locala.ajGk.readString();
        AppMethodBeat.o(19405);
        return 0;
      }
      AppMethodBeat.o(19405);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.jn
 * JD-Core Version:    0.7.0.1
 */