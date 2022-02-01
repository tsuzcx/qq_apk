package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class avd
  extends com.tencent.mm.bx.a
{
  public String Gtr;
  public String Gts;
  public b Gtt;
  public int gsV;
  public String ujc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195473);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ujc != null) {
        paramVarArgs.d(1, this.ujc);
      }
      if (this.Gtr != null) {
        paramVarArgs.d(2, this.Gtr);
      }
      if (this.Gts != null) {
        paramVarArgs.d(3, this.Gts);
      }
      paramVarArgs.aS(4, this.gsV);
      if (this.Gtt != null) {
        paramVarArgs.c(5, this.Gtt);
      }
      AppMethodBeat.o(195473);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ujc == null) {
        break label438;
      }
    }
    label438:
    for (int i = f.a.a.b.b.a.e(1, this.ujc) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Gtr != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Gtr);
      }
      i = paramInt;
      if (this.Gts != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Gts);
      }
      i += f.a.a.b.b.a.bz(4, this.gsV);
      paramInt = i;
      if (this.Gtt != null) {
        paramInt = i + f.a.a.b.b.a.b(5, this.Gtt);
      }
      AppMethodBeat.o(195473);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(195473);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        avd localavd = (avd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(195473);
          return -1;
        case 1: 
          localavd.ujc = locala.NPN.readString();
          AppMethodBeat.o(195473);
          return 0;
        case 2: 
          localavd.Gtr = locala.NPN.readString();
          AppMethodBeat.o(195473);
          return 0;
        case 3: 
          localavd.Gts = locala.NPN.readString();
          AppMethodBeat.o(195473);
          return 0;
        case 4: 
          localavd.gsV = locala.NPN.zc();
          AppMethodBeat.o(195473);
          return 0;
        }
        localavd.Gtt = locala.NPN.gxI();
        AppMethodBeat.o(195473);
        return 0;
      }
      AppMethodBeat.o(195473);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avd
 * JD-Core Version:    0.7.0.1
 */