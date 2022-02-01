package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class chl
  extends com.tencent.mm.bw.a
{
  public String HtA;
  public String HtB;
  public String HtC;
  public String HtD;
  public String HtE;
  public String HtF;
  public String Htz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(189428);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Htz != null) {
        paramVarArgs.d(1, this.Htz);
      }
      if (this.HtA != null) {
        paramVarArgs.d(2, this.HtA);
      }
      if (this.HtB != null) {
        paramVarArgs.d(3, this.HtB);
      }
      if (this.HtC != null) {
        paramVarArgs.d(4, this.HtC);
      }
      if (this.HtD != null) {
        paramVarArgs.d(5, this.HtD);
      }
      if (this.HtE != null) {
        paramVarArgs.d(6, this.HtE);
      }
      if (this.HtF != null) {
        paramVarArgs.d(7, this.HtF);
      }
      AppMethodBeat.o(189428);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Htz == null) {
        break label578;
      }
    }
    label578:
    for (int i = f.a.a.b.b.a.e(1, this.Htz) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HtA != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HtA);
      }
      i = paramInt;
      if (this.HtB != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HtB);
      }
      paramInt = i;
      if (this.HtC != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HtC);
      }
      i = paramInt;
      if (this.HtD != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.HtD);
      }
      paramInt = i;
      if (this.HtE != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.HtE);
      }
      i = paramInt;
      if (this.HtF != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.HtF);
      }
      AppMethodBeat.o(189428);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(189428);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        chl localchl = (chl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(189428);
          return -1;
        case 1: 
          localchl.Htz = locala.OmT.readString();
          AppMethodBeat.o(189428);
          return 0;
        case 2: 
          localchl.HtA = locala.OmT.readString();
          AppMethodBeat.o(189428);
          return 0;
        case 3: 
          localchl.HtB = locala.OmT.readString();
          AppMethodBeat.o(189428);
          return 0;
        case 4: 
          localchl.HtC = locala.OmT.readString();
          AppMethodBeat.o(189428);
          return 0;
        case 5: 
          localchl.HtD = locala.OmT.readString();
          AppMethodBeat.o(189428);
          return 0;
        case 6: 
          localchl.HtE = locala.OmT.readString();
          AppMethodBeat.o(189428);
          return 0;
        }
        localchl.HtF = locala.OmT.readString();
        AppMethodBeat.o(189428);
        return 0;
      }
      AppMethodBeat.o(189428);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chl
 * JD-Core Version:    0.7.0.1
 */