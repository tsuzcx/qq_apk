package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class bri
  extends com.tencent.mm.bx.a
{
  public String CVv;
  public String CVw;
  public int DPf;
  public int DPg;
  public b DPh;
  public String DPi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32353);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.DPf);
      paramVarArgs.aR(2, this.DPg);
      if (this.DPh != null) {
        paramVarArgs.c(3, this.DPh);
      }
      if (this.DPi != null) {
        paramVarArgs.d(4, this.DPi);
      }
      if (this.CVv != null) {
        paramVarArgs.d(5, this.CVv);
      }
      if (this.CVw != null) {
        paramVarArgs.d(6, this.CVw);
      }
      AppMethodBeat.o(32353);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.DPf) + 0 + f.a.a.b.b.a.bA(2, this.DPg);
      paramInt = i;
      if (this.DPh != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.DPh);
      }
      i = paramInt;
      if (this.DPi != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.DPi);
      }
      paramInt = i;
      if (this.CVv != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.CVv);
      }
      i = paramInt;
      if (this.CVw != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.CVw);
      }
      AppMethodBeat.o(32353);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(32353);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bri localbri = (bri)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32353);
        return -1;
      case 1: 
        localbri.DPf = locala.KhF.xS();
        AppMethodBeat.o(32353);
        return 0;
      case 2: 
        localbri.DPg = locala.KhF.xS();
        AppMethodBeat.o(32353);
        return 0;
      case 3: 
        localbri.DPh = locala.KhF.fMu();
        AppMethodBeat.o(32353);
        return 0;
      case 4: 
        localbri.DPi = locala.KhF.readString();
        AppMethodBeat.o(32353);
        return 0;
      case 5: 
        localbri.CVv = locala.KhF.readString();
        AppMethodBeat.o(32353);
        return 0;
      }
      localbri.CVw = locala.KhF.readString();
      AppMethodBeat.o(32353);
      return 0;
    }
    AppMethodBeat.o(32353);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bri
 * JD-Core Version:    0.7.0.1
 */