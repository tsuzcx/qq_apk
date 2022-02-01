package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fqc
  extends com.tencent.mm.bx.a
{
  public String JFk;
  public String OcL;
  public String OcM;
  public String OcN;
  public String OcO;
  public String Ocp;
  public String hAk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72612);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.OcL != null) {
        paramVarArgs.g(1, this.OcL);
      }
      if (this.OcM != null) {
        paramVarArgs.g(2, this.OcM);
      }
      if (this.Ocp != null) {
        paramVarArgs.g(3, this.Ocp);
      }
      if (this.JFk != null) {
        paramVarArgs.g(4, this.JFk);
      }
      if (this.hAk != null) {
        paramVarArgs.g(5, this.hAk);
      }
      if (this.OcN != null) {
        paramVarArgs.g(6, this.OcN);
      }
      if (this.OcO != null) {
        paramVarArgs.g(7, this.OcO);
      }
      AppMethodBeat.o(72612);
      return 0;
    }
    if (paramInt == 1) {
      if (this.OcL == null) {
        break label574;
      }
    }
    label574:
    for (int i = i.a.a.b.b.a.h(1, this.OcL) + 0;; i = 0)
    {
      paramInt = i;
      if (this.OcM != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.OcM);
      }
      i = paramInt;
      if (this.Ocp != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.Ocp);
      }
      paramInt = i;
      if (this.JFk != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.JFk);
      }
      i = paramInt;
      if (this.hAk != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.hAk);
      }
      paramInt = i;
      if (this.OcN != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.OcN);
      }
      i = paramInt;
      if (this.OcO != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.OcO);
      }
      AppMethodBeat.o(72612);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(72612);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fqc localfqc = (fqc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72612);
          return -1;
        case 1: 
          localfqc.OcL = locala.ajGk.readString();
          AppMethodBeat.o(72612);
          return 0;
        case 2: 
          localfqc.OcM = locala.ajGk.readString();
          AppMethodBeat.o(72612);
          return 0;
        case 3: 
          localfqc.Ocp = locala.ajGk.readString();
          AppMethodBeat.o(72612);
          return 0;
        case 4: 
          localfqc.JFk = locala.ajGk.readString();
          AppMethodBeat.o(72612);
          return 0;
        case 5: 
          localfqc.hAk = locala.ajGk.readString();
          AppMethodBeat.o(72612);
          return 0;
        case 6: 
          localfqc.OcN = locala.ajGk.readString();
          AppMethodBeat.o(72612);
          return 0;
        }
        localfqc.OcO = locala.ajGk.readString();
        AppMethodBeat.o(72612);
        return 0;
      }
      AppMethodBeat.o(72612);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fqc
 * JD-Core Version:    0.7.0.1
 */