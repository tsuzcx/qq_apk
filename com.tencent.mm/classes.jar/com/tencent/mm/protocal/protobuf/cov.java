package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cov
  extends com.tencent.mm.bw.a
{
  public String MuV;
  public String MuW;
  public String MuX;
  public String MuY;
  public String MuZ;
  public String pf;
  public String session_id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(214315);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MuV != null) {
        paramVarArgs.e(1, this.MuV);
      }
      if (this.MuW != null) {
        paramVarArgs.e(2, this.MuW);
      }
      if (this.MuX != null) {
        paramVarArgs.e(3, this.MuX);
      }
      if (this.session_id != null) {
        paramVarArgs.e(4, this.session_id);
      }
      if (this.MuY != null) {
        paramVarArgs.e(5, this.MuY);
      }
      if (this.pf != null) {
        paramVarArgs.e(6, this.pf);
      }
      if (this.MuZ != null) {
        paramVarArgs.e(7, this.MuZ);
      }
      AppMethodBeat.o(214315);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MuV == null) {
        break label578;
      }
    }
    label578:
    for (int i = g.a.a.b.b.a.f(1, this.MuV) + 0;; i = 0)
    {
      paramInt = i;
      if (this.MuW != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.MuW);
      }
      i = paramInt;
      if (this.MuX != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.MuX);
      }
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.session_id);
      }
      i = paramInt;
      if (this.MuY != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.MuY);
      }
      paramInt = i;
      if (this.pf != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.pf);
      }
      i = paramInt;
      if (this.MuZ != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.MuZ);
      }
      AppMethodBeat.o(214315);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(214315);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cov localcov = (cov)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(214315);
          return -1;
        case 1: 
          localcov.MuV = locala.UbS.readString();
          AppMethodBeat.o(214315);
          return 0;
        case 2: 
          localcov.MuW = locala.UbS.readString();
          AppMethodBeat.o(214315);
          return 0;
        case 3: 
          localcov.MuX = locala.UbS.readString();
          AppMethodBeat.o(214315);
          return 0;
        case 4: 
          localcov.session_id = locala.UbS.readString();
          AppMethodBeat.o(214315);
          return 0;
        case 5: 
          localcov.MuY = locala.UbS.readString();
          AppMethodBeat.o(214315);
          return 0;
        case 6: 
          localcov.pf = locala.UbS.readString();
          AppMethodBeat.o(214315);
          return 0;
        }
        localcov.MuZ = locala.UbS.readString();
        AppMethodBeat.o(214315);
        return 0;
      }
      AppMethodBeat.o(214315);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cov
 * JD-Core Version:    0.7.0.1
 */