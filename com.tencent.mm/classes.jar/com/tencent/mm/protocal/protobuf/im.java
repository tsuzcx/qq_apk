package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class im
  extends com.tencent.mm.bx.a
{
  public String CEb;
  public String CEc;
  public String CEd;
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
      if (this.CEb != null) {
        paramVarArgs.d(2, this.CEb);
      }
      if (this.CEc != null) {
        paramVarArgs.d(3, this.CEc);
      }
      if (this.CEd != null) {
        paramVarArgs.d(4, this.CEd);
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
      if (this.CEb != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.CEb);
      }
      i = paramInt;
      if (this.CEc != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CEc);
      }
      paramInt = i;
      if (this.CEd != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.CEd);
      }
      AppMethodBeat.o(116465);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(116465);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        im localim = (im)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(116465);
          return -1;
        case 1: 
          localim.imei = locala.KhF.readString();
          AppMethodBeat.o(116465);
          return 0;
        case 2: 
          localim.CEb = locala.KhF.readString();
          AppMethodBeat.o(116465);
          return 0;
        case 3: 
          localim.CEc = locala.KhF.readString();
          AppMethodBeat.o(116465);
          return 0;
        }
        localim.CEd = locala.KhF.readString();
        AppMethodBeat.o(116465);
        return 0;
      }
      AppMethodBeat.o(116465);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.im
 * JD-Core Version:    0.7.0.1
 */