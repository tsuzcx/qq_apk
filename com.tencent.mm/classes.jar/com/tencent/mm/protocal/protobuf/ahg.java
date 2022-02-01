package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ahg
  extends com.tencent.mm.bw.a
{
  public int Gxw;
  public int Gxx;
  public String Gxy;
  public String dyI;
  public String pqW;
  public int uoi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(179487);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Gxw);
      paramVarArgs.aS(2, this.Gxx);
      paramVarArgs.aS(3, this.uoi);
      if (this.dyI != null) {
        paramVarArgs.d(4, this.dyI);
      }
      if (this.pqW != null) {
        paramVarArgs.d(5, this.pqW);
      }
      if (this.Gxy != null) {
        paramVarArgs.d(6, this.Gxy);
      }
      AppMethodBeat.o(179487);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.Gxw) + 0 + f.a.a.b.b.a.bz(2, this.Gxx) + f.a.a.b.b.a.bz(3, this.uoi);
      paramInt = i;
      if (this.dyI != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.dyI);
      }
      i = paramInt;
      if (this.pqW != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.pqW);
      }
      paramInt = i;
      if (this.Gxy != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Gxy);
      }
      AppMethodBeat.o(179487);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(179487);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ahg localahg = (ahg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(179487);
        return -1;
      case 1: 
        localahg.Gxw = locala.OmT.zc();
        AppMethodBeat.o(179487);
        return 0;
      case 2: 
        localahg.Gxx = locala.OmT.zc();
        AppMethodBeat.o(179487);
        return 0;
      case 3: 
        localahg.uoi = locala.OmT.zc();
        AppMethodBeat.o(179487);
        return 0;
      case 4: 
        localahg.dyI = locala.OmT.readString();
        AppMethodBeat.o(179487);
        return 0;
      case 5: 
        localahg.pqW = locala.OmT.readString();
        AppMethodBeat.o(179487);
        return 0;
      }
      localahg.Gxy = locala.OmT.readString();
      AppMethodBeat.o(179487);
      return 0;
    }
    AppMethodBeat.o(179487);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahg
 * JD-Core Version:    0.7.0.1
 */