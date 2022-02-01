package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fbt
  extends com.tencent.mm.bx.a
{
  public String abBq;
  public String abBr;
  public String abBs;
  public String abBt;
  public int abBu;
  public String abBv;
  public String content;
  public int state;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153299);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.content != null) {
        paramVarArgs.g(1, this.content);
      }
      if (this.abBq != null) {
        paramVarArgs.g(2, this.abBq);
      }
      if (this.abBr != null) {
        paramVarArgs.g(3, this.abBr);
      }
      if (this.abBs != null) {
        paramVarArgs.g(4, this.abBs);
      }
      if (this.abBt != null) {
        paramVarArgs.g(5, this.abBt);
      }
      paramVarArgs.bS(6, this.abBu);
      paramVarArgs.bS(7, this.state);
      if (this.abBv != null) {
        paramVarArgs.g(8, this.abBv);
      }
      AppMethodBeat.o(153299);
      return 0;
    }
    if (paramInt == 1) {
      if (this.content == null) {
        break label602;
      }
    }
    label602:
    for (int i = i.a.a.b.b.a.h(1, this.content) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abBq != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.abBq);
      }
      i = paramInt;
      if (this.abBr != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.abBr);
      }
      paramInt = i;
      if (this.abBs != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abBs);
      }
      i = paramInt;
      if (this.abBt != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.abBt);
      }
      i = i + i.a.a.b.b.a.cJ(6, this.abBu) + i.a.a.b.b.a.cJ(7, this.state);
      paramInt = i;
      if (this.abBv != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.abBv);
      }
      AppMethodBeat.o(153299);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(153299);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fbt localfbt = (fbt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153299);
          return -1;
        case 1: 
          localfbt.content = locala.ajGk.readString();
          AppMethodBeat.o(153299);
          return 0;
        case 2: 
          localfbt.abBq = locala.ajGk.readString();
          AppMethodBeat.o(153299);
          return 0;
        case 3: 
          localfbt.abBr = locala.ajGk.readString();
          AppMethodBeat.o(153299);
          return 0;
        case 4: 
          localfbt.abBs = locala.ajGk.readString();
          AppMethodBeat.o(153299);
          return 0;
        case 5: 
          localfbt.abBt = locala.ajGk.readString();
          AppMethodBeat.o(153299);
          return 0;
        case 6: 
          localfbt.abBu = locala.ajGk.aar();
          AppMethodBeat.o(153299);
          return 0;
        case 7: 
          localfbt.state = locala.ajGk.aar();
          AppMethodBeat.o(153299);
          return 0;
        }
        localfbt.abBv = locala.ajGk.readString();
        AppMethodBeat.o(153299);
        return 0;
      }
      AppMethodBeat.o(153299);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fbt
 * JD-Core Version:    0.7.0.1
 */