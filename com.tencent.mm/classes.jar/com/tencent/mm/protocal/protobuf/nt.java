package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class nt
  extends com.tencent.mm.bw.a
{
  public String KTl;
  public String KTm;
  public int KTn;
  public int KTp;
  public String KTq;
  public String KTr;
  public int KTs;
  public String name;
  public int type;
  public int ver;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124416);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KTl != null) {
        paramVarArgs.e(1, this.KTl);
      }
      paramVarArgs.aM(2, this.type);
      if (this.KTm != null) {
        paramVarArgs.e(3, this.KTm);
      }
      if (this.name != null) {
        paramVarArgs.e(4, this.name);
      }
      paramVarArgs.aM(5, this.ver);
      paramVarArgs.aM(6, this.KTn);
      paramVarArgs.aM(7, this.KTp);
      if (this.KTq != null) {
        paramVarArgs.e(8, this.KTq);
      }
      if (this.KTr != null) {
        paramVarArgs.e(9, this.KTr);
      }
      paramVarArgs.aM(10, this.KTs);
      AppMethodBeat.o(124416);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KTl == null) {
        break label682;
      }
    }
    label682:
    for (paramInt = g.a.a.b.b.a.f(1, this.KTl) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.type);
      paramInt = i;
      if (this.KTm != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.KTm);
      }
      i = paramInt;
      if (this.name != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.name);
      }
      i = i + g.a.a.b.b.a.bu(5, this.ver) + g.a.a.b.b.a.bu(6, this.KTn) + g.a.a.b.b.a.bu(7, this.KTp);
      paramInt = i;
      if (this.KTq != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.KTq);
      }
      i = paramInt;
      if (this.KTr != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.KTr);
      }
      paramInt = g.a.a.b.b.a.bu(10, this.KTs);
      AppMethodBeat.o(124416);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(124416);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        nt localnt = (nt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124416);
          return -1;
        case 1: 
          localnt.KTl = locala.UbS.readString();
          AppMethodBeat.o(124416);
          return 0;
        case 2: 
          localnt.type = locala.UbS.zi();
          AppMethodBeat.o(124416);
          return 0;
        case 3: 
          localnt.KTm = locala.UbS.readString();
          AppMethodBeat.o(124416);
          return 0;
        case 4: 
          localnt.name = locala.UbS.readString();
          AppMethodBeat.o(124416);
          return 0;
        case 5: 
          localnt.ver = locala.UbS.zi();
          AppMethodBeat.o(124416);
          return 0;
        case 6: 
          localnt.KTn = locala.UbS.zi();
          AppMethodBeat.o(124416);
          return 0;
        case 7: 
          localnt.KTp = locala.UbS.zi();
          AppMethodBeat.o(124416);
          return 0;
        case 8: 
          localnt.KTq = locala.UbS.readString();
          AppMethodBeat.o(124416);
          return 0;
        case 9: 
          localnt.KTr = locala.UbS.readString();
          AppMethodBeat.o(124416);
          return 0;
        }
        localnt.KTs = locala.UbS.zi();
        AppMethodBeat.o(124416);
        return 0;
      }
      AppMethodBeat.o(124416);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nt
 * JD-Core Version:    0.7.0.1
 */