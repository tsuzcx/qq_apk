package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class avb
  extends com.tencent.mm.bx.a
{
  public String Gtl;
  public int Gtm;
  public int Gtn;
  public long Gto;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152542);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gtl != null) {
        paramVarArgs.d(1, this.Gtl);
      }
      paramVarArgs.aS(2, this.Gtm);
      paramVarArgs.aS(3, this.Gtn);
      paramVarArgs.aY(99, this.Gto);
      AppMethodBeat.o(152542);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Gtl == null) {
        break label366;
      }
    }
    label366:
    for (paramInt = f.a.a.b.b.a.e(1, this.Gtl) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.Gtm);
      int j = f.a.a.b.b.a.bz(3, this.Gtn);
      int k = f.a.a.b.b.a.p(99, this.Gto);
      AppMethodBeat.o(152542);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(152542);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        avb localavb = (avb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152542);
          return -1;
        case 1: 
          localavb.Gtl = locala.NPN.readString();
          AppMethodBeat.o(152542);
          return 0;
        case 2: 
          localavb.Gtm = locala.NPN.zc();
          AppMethodBeat.o(152542);
          return 0;
        case 3: 
          localavb.Gtn = locala.NPN.zc();
          AppMethodBeat.o(152542);
          return 0;
        }
        localavb.Gto = locala.NPN.zd();
        AppMethodBeat.o(152542);
        return 0;
      }
      AppMethodBeat.o(152542);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avb
 * JD-Core Version:    0.7.0.1
 */