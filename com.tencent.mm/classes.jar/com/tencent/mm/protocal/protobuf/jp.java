package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class jp
  extends com.tencent.mm.bx.a
{
  public String JFk;
  public String VxX;
  public String YLP;
  public String YLQ;
  public String YLR;
  public boolean YLS;
  public String YLT;
  public String hAk;
  public String wDh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72419);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.JFk != null) {
        paramVarArgs.g(1, this.JFk);
      }
      if (this.hAk != null) {
        paramVarArgs.g(2, this.hAk);
      }
      if (this.wDh != null) {
        paramVarArgs.g(3, this.wDh);
      }
      if (this.VxX != null) {
        paramVarArgs.g(4, this.VxX);
      }
      if (this.YLP != null) {
        paramVarArgs.g(5, this.YLP);
      }
      if (this.YLQ != null) {
        paramVarArgs.g(6, this.YLQ);
      }
      if (this.YLR != null) {
        paramVarArgs.g(8, this.YLR);
      }
      paramVarArgs.di(9, this.YLS);
      if (this.YLT != null) {
        paramVarArgs.g(10, this.YLT);
      }
      AppMethodBeat.o(72419);
      return 0;
    }
    if (paramInt == 1) {
      if (this.JFk == null) {
        break label686;
      }
    }
    label686:
    for (int i = i.a.a.b.b.a.h(1, this.JFk) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hAk != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.hAk);
      }
      i = paramInt;
      if (this.wDh != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.wDh);
      }
      paramInt = i;
      if (this.VxX != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.VxX);
      }
      i = paramInt;
      if (this.YLP != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.YLP);
      }
      paramInt = i;
      if (this.YLQ != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.YLQ);
      }
      i = paramInt;
      if (this.YLR != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.YLR);
      }
      i += i.a.a.b.b.a.ko(9) + 1;
      paramInt = i;
      if (this.YLT != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.YLT);
      }
      AppMethodBeat.o(72419);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(72419);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        jp localjp = (jp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 7: 
        default: 
          AppMethodBeat.o(72419);
          return -1;
        case 1: 
          localjp.JFk = locala.ajGk.readString();
          AppMethodBeat.o(72419);
          return 0;
        case 2: 
          localjp.hAk = locala.ajGk.readString();
          AppMethodBeat.o(72419);
          return 0;
        case 3: 
          localjp.wDh = locala.ajGk.readString();
          AppMethodBeat.o(72419);
          return 0;
        case 4: 
          localjp.VxX = locala.ajGk.readString();
          AppMethodBeat.o(72419);
          return 0;
        case 5: 
          localjp.YLP = locala.ajGk.readString();
          AppMethodBeat.o(72419);
          return 0;
        case 6: 
          localjp.YLQ = locala.ajGk.readString();
          AppMethodBeat.o(72419);
          return 0;
        case 8: 
          localjp.YLR = locala.ajGk.readString();
          AppMethodBeat.o(72419);
          return 0;
        case 9: 
          localjp.YLS = locala.ajGk.aai();
          AppMethodBeat.o(72419);
          return 0;
        }
        localjp.YLT = locala.ajGk.readString();
        AppMethodBeat.o(72419);
        return 0;
      }
      AppMethodBeat.o(72419);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.jp
 * JD-Core Version:    0.7.0.1
 */