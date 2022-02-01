package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class is
  extends com.tencent.mm.bw.a
{
  public String DWB;
  public String DWC;
  public String DWD;
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
      if (this.DWB != null) {
        paramVarArgs.d(2, this.DWB);
      }
      if (this.DWC != null) {
        paramVarArgs.d(3, this.DWC);
      }
      if (this.DWD != null) {
        paramVarArgs.d(4, this.DWD);
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
      if (this.DWB != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DWB);
      }
      i = paramInt;
      if (this.DWC != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DWC);
      }
      paramInt = i;
      if (this.DWD != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DWD);
      }
      AppMethodBeat.o(116465);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(116465);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        is localis = (is)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(116465);
          return -1;
        case 1: 
          localis.imei = locala.LVo.readString();
          AppMethodBeat.o(116465);
          return 0;
        case 2: 
          localis.DWB = locala.LVo.readString();
          AppMethodBeat.o(116465);
          return 0;
        case 3: 
          localis.DWC = locala.LVo.readString();
          AppMethodBeat.o(116465);
          return 0;
        }
        localis.DWD = locala.LVo.readString();
        AppMethodBeat.o(116465);
        return 0;
      }
      AppMethodBeat.o(116465);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.is
 * JD-Core Version:    0.7.0.1
 */