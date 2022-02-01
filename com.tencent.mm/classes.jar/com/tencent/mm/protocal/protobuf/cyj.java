package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cyj
  extends com.tencent.mm.bw.a
{
  public int KIl;
  public int MDi;
  public String dNI;
  public String nHd;
  public String nHe;
  public String nHi;
  public int position;
  public String request_id;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50096);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.e(1, this.username);
      }
      if (this.nHd != null) {
        paramVarArgs.e(2, this.nHd);
      }
      if (this.request_id != null) {
        paramVarArgs.e(3, this.request_id);
      }
      if (this.nHe != null) {
        paramVarArgs.e(4, this.nHe);
      }
      if (this.dNI != null) {
        paramVarArgs.e(5, this.dNI);
      }
      if (this.nHi != null) {
        paramVarArgs.e(6, this.nHi);
      }
      paramVarArgs.aM(7, this.position);
      paramVarArgs.aM(8, this.MDi);
      paramVarArgs.aM(9, this.KIl);
      AppMethodBeat.o(50096);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label658;
      }
    }
    label658:
    for (int i = g.a.a.b.b.a.f(1, this.username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nHd != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.nHd);
      }
      i = paramInt;
      if (this.request_id != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.request_id);
      }
      paramInt = i;
      if (this.nHe != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.nHe);
      }
      i = paramInt;
      if (this.dNI != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.dNI);
      }
      paramInt = i;
      if (this.nHi != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.nHi);
      }
      i = g.a.a.b.b.a.bu(7, this.position);
      int j = g.a.a.b.b.a.bu(8, this.MDi);
      int k = g.a.a.b.b.a.bu(9, this.KIl);
      AppMethodBeat.o(50096);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(50096);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cyj localcyj = (cyj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(50096);
          return -1;
        case 1: 
          localcyj.username = locala.UbS.readString();
          AppMethodBeat.o(50096);
          return 0;
        case 2: 
          localcyj.nHd = locala.UbS.readString();
          AppMethodBeat.o(50096);
          return 0;
        case 3: 
          localcyj.request_id = locala.UbS.readString();
          AppMethodBeat.o(50096);
          return 0;
        case 4: 
          localcyj.nHe = locala.UbS.readString();
          AppMethodBeat.o(50096);
          return 0;
        case 5: 
          localcyj.dNI = locala.UbS.readString();
          AppMethodBeat.o(50096);
          return 0;
        case 6: 
          localcyj.nHi = locala.UbS.readString();
          AppMethodBeat.o(50096);
          return 0;
        case 7: 
          localcyj.position = locala.UbS.zi();
          AppMethodBeat.o(50096);
          return 0;
        case 8: 
          localcyj.MDi = locala.UbS.zi();
          AppMethodBeat.o(50096);
          return 0;
        }
        localcyj.KIl = locala.UbS.zi();
        AppMethodBeat.o(50096);
        return 0;
      }
      AppMethodBeat.o(50096);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyj
 * JD-Core Version:    0.7.0.1
 */