package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ev
  extends com.tencent.mm.bw.a
{
  public int KIl;
  public String dNI;
  public String nHe;
  public String nHi;
  public int position;
  public String request_id;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50080);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.e(1, this.username);
      }
      if (this.request_id != null) {
        paramVarArgs.e(2, this.request_id);
      }
      if (this.nHe != null) {
        paramVarArgs.e(3, this.nHe);
      }
      if (this.dNI != null) {
        paramVarArgs.e(4, this.dNI);
      }
      if (this.nHi != null) {
        paramVarArgs.e(5, this.nHi);
      }
      paramVarArgs.aM(6, this.position);
      paramVarArgs.aM(7, this.KIl);
      AppMethodBeat.o(50080);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label550;
      }
    }
    label550:
    for (int i = g.a.a.b.b.a.f(1, this.username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.request_id != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.request_id);
      }
      i = paramInt;
      if (this.nHe != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.nHe);
      }
      paramInt = i;
      if (this.dNI != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.dNI);
      }
      i = paramInt;
      if (this.nHi != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.nHi);
      }
      paramInt = g.a.a.b.b.a.bu(6, this.position);
      int j = g.a.a.b.b.a.bu(7, this.KIl);
      AppMethodBeat.o(50080);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(50080);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ev localev = (ev)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(50080);
          return -1;
        case 1: 
          localev.username = locala.UbS.readString();
          AppMethodBeat.o(50080);
          return 0;
        case 2: 
          localev.request_id = locala.UbS.readString();
          AppMethodBeat.o(50080);
          return 0;
        case 3: 
          localev.nHe = locala.UbS.readString();
          AppMethodBeat.o(50080);
          return 0;
        case 4: 
          localev.dNI = locala.UbS.readString();
          AppMethodBeat.o(50080);
          return 0;
        case 5: 
          localev.nHi = locala.UbS.readString();
          AppMethodBeat.o(50080);
          return 0;
        case 6: 
          localev.position = locala.UbS.zi();
          AppMethodBeat.o(50080);
          return 0;
        }
        localev.KIl = locala.UbS.zi();
        AppMethodBeat.o(50080);
        return 0;
      }
      AppMethodBeat.o(50080);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ev
 * JD-Core Version:    0.7.0.1
 */