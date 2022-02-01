package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ehp
  extends com.tencent.mm.bx.a
{
  public int FFN;
  public String FuU;
  public String Fvh;
  public int HSi;
  public String Username;
  public String ujc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117959);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Username != null) {
        paramVarArgs.d(1, this.Username);
      }
      if (this.ujc != null) {
        paramVarArgs.d(2, this.ujc);
      }
      paramVarArgs.aS(3, this.FFN);
      if (this.FuU != null) {
        paramVarArgs.d(4, this.FuU);
      }
      paramVarArgs.aS(5, this.HSi);
      if (this.Fvh != null) {
        paramVarArgs.d(6, this.Fvh);
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
      if (this.ujc != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.ujc);
      }
      i += f.a.a.b.b.a.bz(3, this.FFN);
      paramInt = i;
      if (this.FuU != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FuU);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.HSi);
      paramInt = i;
      if (this.Fvh != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Fvh);
      }
      AppMethodBeat.o(117959);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(117959);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ehp localehp = (ehp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117959);
          return -1;
        case 1: 
          localehp.Username = locala.NPN.readString();
          AppMethodBeat.o(117959);
          return 0;
        case 2: 
          localehp.ujc = locala.NPN.readString();
          AppMethodBeat.o(117959);
          return 0;
        case 3: 
          localehp.FFN = locala.NPN.zc();
          AppMethodBeat.o(117959);
          return 0;
        case 4: 
          localehp.FuU = locala.NPN.readString();
          AppMethodBeat.o(117959);
          return 0;
        case 5: 
          localehp.HSi = locala.NPN.zc();
          AppMethodBeat.o(117959);
          return 0;
        }
        localehp.Fvh = locala.NPN.readString();
        AppMethodBeat.o(117959);
        return 0;
      }
      AppMethodBeat.o(117959);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ehp
 * JD-Core Version:    0.7.0.1
 */