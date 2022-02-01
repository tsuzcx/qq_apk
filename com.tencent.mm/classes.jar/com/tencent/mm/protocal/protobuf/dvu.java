package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dvu
  extends com.tencent.mm.bx.a
{
  public int CHC;
  public String Cxj;
  public String Cxw;
  public int EJJ;
  public String Username;
  public String sdZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117959);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Username != null) {
        paramVarArgs.d(1, this.Username);
      }
      if (this.sdZ != null) {
        paramVarArgs.d(2, this.sdZ);
      }
      paramVarArgs.aR(3, this.CHC);
      if (this.Cxj != null) {
        paramVarArgs.d(4, this.Cxj);
      }
      paramVarArgs.aR(5, this.EJJ);
      if (this.Cxw != null) {
        paramVarArgs.d(6, this.Cxw);
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
      if (this.sdZ != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.sdZ);
      }
      i += f.a.a.b.b.a.bA(3, this.CHC);
      paramInt = i;
      if (this.Cxj != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Cxj);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.EJJ);
      paramInt = i;
      if (this.Cxw != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Cxw);
      }
      AppMethodBeat.o(117959);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(117959);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dvu localdvu = (dvu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117959);
          return -1;
        case 1: 
          localdvu.Username = locala.KhF.readString();
          AppMethodBeat.o(117959);
          return 0;
        case 2: 
          localdvu.sdZ = locala.KhF.readString();
          AppMethodBeat.o(117959);
          return 0;
        case 3: 
          localdvu.CHC = locala.KhF.xS();
          AppMethodBeat.o(117959);
          return 0;
        case 4: 
          localdvu.Cxj = locala.KhF.readString();
          AppMethodBeat.o(117959);
          return 0;
        case 5: 
          localdvu.EJJ = locala.KhF.xS();
          AppMethodBeat.o(117959);
          return 0;
        }
        localdvu.Cxw = locala.KhF.readString();
        AppMethodBeat.o(117959);
        return 0;
      }
      AppMethodBeat.o(117959);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvu
 * JD-Core Version:    0.7.0.1
 */