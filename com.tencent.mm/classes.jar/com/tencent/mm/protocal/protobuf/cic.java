package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cic
  extends com.tencent.mm.bx.a
{
  public String Desc;
  public String HbR;
  public String HbS;
  public String IconUrl;
  public String Title;
  public int tSt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117888);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HbR != null) {
        paramVarArgs.d(1, this.HbR);
      }
      if (this.Title != null) {
        paramVarArgs.d(2, this.Title);
      }
      if (this.Desc != null) {
        paramVarArgs.d(3, this.Desc);
      }
      if (this.IconUrl != null) {
        paramVarArgs.d(4, this.IconUrl);
      }
      if (this.HbS != null) {
        paramVarArgs.d(5, this.HbS);
      }
      paramVarArgs.aS(6, this.tSt);
      AppMethodBeat.o(117888);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HbR == null) {
        break label502;
      }
    }
    label502:
    for (int i = f.a.a.b.b.a.e(1, this.HbR) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Title);
      }
      i = paramInt;
      if (this.Desc != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Desc);
      }
      paramInt = i;
      if (this.IconUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.IconUrl);
      }
      i = paramInt;
      if (this.HbS != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.HbS);
      }
      paramInt = f.a.a.b.b.a.bz(6, this.tSt);
      AppMethodBeat.o(117888);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(117888);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cic localcic = (cic)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117888);
          return -1;
        case 1: 
          localcic.HbR = locala.NPN.readString();
          AppMethodBeat.o(117888);
          return 0;
        case 2: 
          localcic.Title = locala.NPN.readString();
          AppMethodBeat.o(117888);
          return 0;
        case 3: 
          localcic.Desc = locala.NPN.readString();
          AppMethodBeat.o(117888);
          return 0;
        case 4: 
          localcic.IconUrl = locala.NPN.readString();
          AppMethodBeat.o(117888);
          return 0;
        case 5: 
          localcic.HbS = locala.NPN.readString();
          AppMethodBeat.o(117888);
          return 0;
        }
        localcic.tSt = locala.NPN.zc();
        AppMethodBeat.o(117888);
        return 0;
      }
      AppMethodBeat.o(117888);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cic
 * JD-Core Version:    0.7.0.1
 */