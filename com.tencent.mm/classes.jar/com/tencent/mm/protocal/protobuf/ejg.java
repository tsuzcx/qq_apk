package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ejg
  extends com.tencent.mm.bw.a
{
  public String FNF;
  public String FNs;
  public int FYj;
  public int Imp;
  public String Username;
  public String uuA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117959);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Username != null) {
        paramVarArgs.d(1, this.Username);
      }
      if (this.uuA != null) {
        paramVarArgs.d(2, this.uuA);
      }
      paramVarArgs.aS(3, this.FYj);
      if (this.FNs != null) {
        paramVarArgs.d(4, this.FNs);
      }
      paramVarArgs.aS(5, this.Imp);
      if (this.FNF != null) {
        paramVarArgs.d(6, this.FNF);
      }
      AppMethodBeat.o(117959);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Username == null) {
        break label486;
      }
    }
    label486:
    for (paramInt = f.a.a.b.b.a.e(1, this.Username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.uuA != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.uuA);
      }
      i += f.a.a.b.b.a.bz(3, this.FYj);
      paramInt = i;
      if (this.FNs != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FNs);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.Imp);
      paramInt = i;
      if (this.FNF != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FNF);
      }
      AppMethodBeat.o(117959);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(117959);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ejg localejg = (ejg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117959);
          return -1;
        case 1: 
          localejg.Username = locala.OmT.readString();
          AppMethodBeat.o(117959);
          return 0;
        case 2: 
          localejg.uuA = locala.OmT.readString();
          AppMethodBeat.o(117959);
          return 0;
        case 3: 
          localejg.FYj = locala.OmT.zc();
          AppMethodBeat.o(117959);
          return 0;
        case 4: 
          localejg.FNs = locala.OmT.readString();
          AppMethodBeat.o(117959);
          return 0;
        case 5: 
          localejg.Imp = locala.OmT.zc();
          AppMethodBeat.o(117959);
          return 0;
        }
        localejg.FNF = locala.OmT.readString();
        AppMethodBeat.o(117959);
        return 0;
      }
      AppMethodBeat.o(117959);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ejg
 * JD-Core Version:    0.7.0.1
 */