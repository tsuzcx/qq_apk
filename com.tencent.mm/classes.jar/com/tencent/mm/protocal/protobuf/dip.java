package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dip
  extends com.tencent.mm.cd.a
{
  public String CMB;
  public String CNj;
  public int Crq;
  public String TPZ;
  public String TQa;
  public String fwr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117888);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TPZ != null) {
        paramVarArgs.f(1, this.TPZ);
      }
      if (this.fwr != null) {
        paramVarArgs.f(2, this.fwr);
      }
      if (this.CMB != null) {
        paramVarArgs.f(3, this.CMB);
      }
      if (this.CNj != null) {
        paramVarArgs.f(4, this.CNj);
      }
      if (this.TQa != null) {
        paramVarArgs.f(5, this.TQa);
      }
      paramVarArgs.aY(6, this.Crq);
      AppMethodBeat.o(117888);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TPZ == null) {
        break label502;
      }
    }
    label502:
    for (int i = g.a.a.b.b.a.g(1, this.TPZ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.fwr != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.fwr);
      }
      i = paramInt;
      if (this.CMB != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.CMB);
      }
      paramInt = i;
      if (this.CNj != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.CNj);
      }
      i = paramInt;
      if (this.TQa != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.TQa);
      }
      paramInt = g.a.a.b.b.a.bM(6, this.Crq);
      AppMethodBeat.o(117888);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(117888);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dip localdip = (dip)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117888);
          return -1;
        case 1: 
          localdip.TPZ = locala.abFh.readString();
          AppMethodBeat.o(117888);
          return 0;
        case 2: 
          localdip.fwr = locala.abFh.readString();
          AppMethodBeat.o(117888);
          return 0;
        case 3: 
          localdip.CMB = locala.abFh.readString();
          AppMethodBeat.o(117888);
          return 0;
        case 4: 
          localdip.CNj = locala.abFh.readString();
          AppMethodBeat.o(117888);
          return 0;
        case 5: 
          localdip.TQa = locala.abFh.readString();
          AppMethodBeat.o(117888);
          return 0;
        }
        localdip.Crq = locala.abFh.AK();
        AppMethodBeat.o(117888);
        return 0;
      }
      AppMethodBeat.o(117888);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dip
 * JD-Core Version:    0.7.0.1
 */