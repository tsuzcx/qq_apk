package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class iz
  extends com.tencent.mm.bw.a
{
  public String FUs;
  public String FUt;
  public String FUu;
  public String imei;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116465);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.imei != null) {
        paramVarArgs.d(1, this.imei);
      }
      if (this.FUs != null) {
        paramVarArgs.d(2, this.FUs);
      }
      if (this.FUt != null) {
        paramVarArgs.d(3, this.FUt);
      }
      if (this.FUu != null) {
        paramVarArgs.d(4, this.FUu);
      }
      AppMethodBeat.o(116465);
      return 0;
    }
    if (paramInt == 1) {
      if (this.imei == null) {
        break label394;
      }
    }
    label394:
    for (int i = f.a.a.b.b.a.e(1, this.imei) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FUs != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FUs);
      }
      i = paramInt;
      if (this.FUt != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FUt);
      }
      paramInt = i;
      if (this.FUu != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FUu);
      }
      AppMethodBeat.o(116465);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(116465);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        iz localiz = (iz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(116465);
          return -1;
        case 1: 
          localiz.imei = locala.OmT.readString();
          AppMethodBeat.o(116465);
          return 0;
        case 2: 
          localiz.FUs = locala.OmT.readString();
          AppMethodBeat.o(116465);
          return 0;
        case 3: 
          localiz.FUt = locala.OmT.readString();
          AppMethodBeat.o(116465);
          return 0;
        }
        localiz.FUu = locala.OmT.readString();
        AppMethodBeat.o(116465);
        return 0;
      }
      AppMethodBeat.o(116465);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.iz
 * JD-Core Version:    0.7.0.1
 */