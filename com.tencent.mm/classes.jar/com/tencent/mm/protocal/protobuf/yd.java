package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class yd
  extends com.tencent.mm.cd.a
{
  public String Skl;
  public String Skm;
  public String Skn;
  public int Sko;
  public int Skp;
  public String Skq;
  public int Skr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127444);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Skl != null) {
        paramVarArgs.f(1, this.Skl);
      }
      if (this.Skm != null) {
        paramVarArgs.f(2, this.Skm);
      }
      if (this.Skn != null) {
        paramVarArgs.f(3, this.Skn);
      }
      paramVarArgs.aY(4, this.Sko);
      paramVarArgs.aY(5, this.Skp);
      if (this.Skq != null) {
        paramVarArgs.f(6, this.Skq);
      }
      paramVarArgs.aY(7, this.Skr);
      AppMethodBeat.o(127444);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Skl == null) {
        break label530;
      }
    }
    label530:
    for (int i = g.a.a.b.b.a.g(1, this.Skl) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Skm != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Skm);
      }
      i = paramInt;
      if (this.Skn != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Skn);
      }
      i = i + g.a.a.b.b.a.bM(4, this.Sko) + g.a.a.b.b.a.bM(5, this.Skp);
      paramInt = i;
      if (this.Skq != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.Skq);
      }
      i = g.a.a.b.b.a.bM(7, this.Skr);
      AppMethodBeat.o(127444);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(127444);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        yd localyd = (yd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127444);
          return -1;
        case 1: 
          localyd.Skl = locala.abFh.readString();
          AppMethodBeat.o(127444);
          return 0;
        case 2: 
          localyd.Skm = locala.abFh.readString();
          AppMethodBeat.o(127444);
          return 0;
        case 3: 
          localyd.Skn = locala.abFh.readString();
          AppMethodBeat.o(127444);
          return 0;
        case 4: 
          localyd.Sko = locala.abFh.AK();
          AppMethodBeat.o(127444);
          return 0;
        case 5: 
          localyd.Skp = locala.abFh.AK();
          AppMethodBeat.o(127444);
          return 0;
        case 6: 
          localyd.Skq = locala.abFh.readString();
          AppMethodBeat.o(127444);
          return 0;
        }
        localyd.Skr = locala.abFh.AK();
        AppMethodBeat.o(127444);
        return 0;
      }
      AppMethodBeat.o(127444);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yd
 * JD-Core Version:    0.7.0.1
 */