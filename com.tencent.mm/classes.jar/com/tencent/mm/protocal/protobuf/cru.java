package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cru
  extends com.tencent.mm.bw.a
{
  public int Eso;
  public String MwQ;
  public String MwR;
  public int MwS;
  public boolean MwT;
  public String gCr;
  public String nickname;
  public String tag;
  public String title;
  public int xlQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(208708);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.nickname != null) {
        paramVarArgs.e(1, this.nickname);
      }
      if (this.title != null) {
        paramVarArgs.e(2, this.title);
      }
      if (this.MwQ != null) {
        paramVarArgs.e(3, this.MwQ);
      }
      paramVarArgs.aM(4, this.Eso);
      if (this.gCr != null) {
        paramVarArgs.e(5, this.gCr);
      }
      if (this.MwR != null) {
        paramVarArgs.e(6, this.MwR);
      }
      paramVarArgs.aM(7, this.MwS);
      paramVarArgs.cc(8, this.MwT);
      if (this.tag != null) {
        paramVarArgs.e(9, this.tag);
      }
      paramVarArgs.aM(10, this.xlQ);
      AppMethodBeat.o(208708);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nickname == null) {
        break label698;
      }
    }
    label698:
    for (int i = g.a.a.b.b.a.f(1, this.nickname) + 0;; i = 0)
    {
      paramInt = i;
      if (this.title != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.title);
      }
      i = paramInt;
      if (this.MwQ != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.MwQ);
      }
      i += g.a.a.b.b.a.bu(4, this.Eso);
      paramInt = i;
      if (this.gCr != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.gCr);
      }
      i = paramInt;
      if (this.MwR != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.MwR);
      }
      i = i + g.a.a.b.b.a.bu(7, this.MwS) + (g.a.a.b.b.a.fS(8) + 1);
      paramInt = i;
      if (this.tag != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.tag);
      }
      i = g.a.a.b.b.a.bu(10, this.xlQ);
      AppMethodBeat.o(208708);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(208708);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cru localcru = (cru)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(208708);
          return -1;
        case 1: 
          localcru.nickname = locala.UbS.readString();
          AppMethodBeat.o(208708);
          return 0;
        case 2: 
          localcru.title = locala.UbS.readString();
          AppMethodBeat.o(208708);
          return 0;
        case 3: 
          localcru.MwQ = locala.UbS.readString();
          AppMethodBeat.o(208708);
          return 0;
        case 4: 
          localcru.Eso = locala.UbS.zi();
          AppMethodBeat.o(208708);
          return 0;
        case 5: 
          localcru.gCr = locala.UbS.readString();
          AppMethodBeat.o(208708);
          return 0;
        case 6: 
          localcru.MwR = locala.UbS.readString();
          AppMethodBeat.o(208708);
          return 0;
        case 7: 
          localcru.MwS = locala.UbS.zi();
          AppMethodBeat.o(208708);
          return 0;
        case 8: 
          localcru.MwT = locala.UbS.yZ();
          AppMethodBeat.o(208708);
          return 0;
        case 9: 
          localcru.tag = locala.UbS.readString();
          AppMethodBeat.o(208708);
          return 0;
        }
        localcru.xlQ = locala.UbS.zi();
        AppMethodBeat.o(208708);
        return 0;
      }
      AppMethodBeat.o(208708);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cru
 * JD-Core Version:    0.7.0.1
 */