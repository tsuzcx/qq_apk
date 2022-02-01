package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bck
  extends com.tencent.mm.bw.a
{
  public String JTr;
  public String LIb;
  public String LLA;
  public String LLy;
  public String LLz;
  public String iUO;
  public String kHV;
  public String tPa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(196094);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LLy != null) {
        paramVarArgs.e(1, this.LLy);
      }
      if (this.LLz != null) {
        paramVarArgs.e(2, this.LLz);
      }
      if (this.kHV != null) {
        paramVarArgs.e(3, this.kHV);
      }
      if (this.LLA != null) {
        paramVarArgs.e(4, this.LLA);
      }
      if (this.iUO != null) {
        paramVarArgs.e(5, this.iUO);
      }
      if (this.JTr != null) {
        paramVarArgs.e(6, this.JTr);
      }
      if (this.LIb != null) {
        paramVarArgs.e(7, this.LIb);
      }
      if (this.tPa != null) {
        paramVarArgs.e(8, this.tPa);
      }
      AppMethodBeat.o(196094);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LLy == null) {
        break label642;
      }
    }
    label642:
    for (int i = g.a.a.b.b.a.f(1, this.LLy) + 0;; i = 0)
    {
      paramInt = i;
      if (this.LLz != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.LLz);
      }
      i = paramInt;
      if (this.kHV != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.kHV);
      }
      paramInt = i;
      if (this.LLA != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.LLA);
      }
      i = paramInt;
      if (this.iUO != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.iUO);
      }
      paramInt = i;
      if (this.JTr != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.JTr);
      }
      i = paramInt;
      if (this.LIb != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.LIb);
      }
      paramInt = i;
      if (this.tPa != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.tPa);
      }
      AppMethodBeat.o(196094);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(196094);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bck localbck = (bck)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(196094);
          return -1;
        case 1: 
          localbck.LLy = locala.UbS.readString();
          AppMethodBeat.o(196094);
          return 0;
        case 2: 
          localbck.LLz = locala.UbS.readString();
          AppMethodBeat.o(196094);
          return 0;
        case 3: 
          localbck.kHV = locala.UbS.readString();
          AppMethodBeat.o(196094);
          return 0;
        case 4: 
          localbck.LLA = locala.UbS.readString();
          AppMethodBeat.o(196094);
          return 0;
        case 5: 
          localbck.iUO = locala.UbS.readString();
          AppMethodBeat.o(196094);
          return 0;
        case 6: 
          localbck.JTr = locala.UbS.readString();
          AppMethodBeat.o(196094);
          return 0;
        case 7: 
          localbck.LIb = locala.UbS.readString();
          AppMethodBeat.o(196094);
          return 0;
        }
        localbck.tPa = locala.UbS.readString();
        AppMethodBeat.o(196094);
        return 0;
      }
      AppMethodBeat.o(196094);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bck
 * JD-Core Version:    0.7.0.1
 */