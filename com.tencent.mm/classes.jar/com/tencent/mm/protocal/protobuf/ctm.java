package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ctm
  extends com.tencent.mm.cd.a
{
  public String RRZ;
  public int Sjq;
  public String TBx;
  public String TBy;
  public String type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116340);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TBx != null) {
        paramVarArgs.f(1, this.TBx);
      }
      if (this.RRZ != null) {
        paramVarArgs.f(2, this.RRZ);
      }
      if (this.type != null) {
        paramVarArgs.f(3, this.type);
      }
      paramVarArgs.aY(4, this.Sjq);
      if (this.TBy != null) {
        paramVarArgs.f(5, this.TBy);
      }
      AppMethodBeat.o(116340);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TBx == null) {
        break label438;
      }
    }
    label438:
    for (int i = g.a.a.b.b.a.g(1, this.TBx) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RRZ != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.RRZ);
      }
      i = paramInt;
      if (this.type != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.type);
      }
      i += g.a.a.b.b.a.bM(4, this.Sjq);
      paramInt = i;
      if (this.TBy != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.TBy);
      }
      AppMethodBeat.o(116340);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(116340);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ctm localctm = (ctm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(116340);
          return -1;
        case 1: 
          localctm.TBx = locala.abFh.readString();
          AppMethodBeat.o(116340);
          return 0;
        case 2: 
          localctm.RRZ = locala.abFh.readString();
          AppMethodBeat.o(116340);
          return 0;
        case 3: 
          localctm.type = locala.abFh.readString();
          AppMethodBeat.o(116340);
          return 0;
        case 4: 
          localctm.Sjq = locala.abFh.AK();
          AppMethodBeat.o(116340);
          return 0;
        }
        localctm.TBy = locala.abFh.readString();
        AppMethodBeat.o(116340);
        return 0;
      }
      AppMethodBeat.o(116340);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctm
 * JD-Core Version:    0.7.0.1
 */