package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aml
  extends com.tencent.mm.bx.a
{
  public String Acr;
  public String Acs;
  public String Act;
  public int DnA;
  public double DnB;
  public long Dnz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91470);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aG(1, this.Dnz);
      paramVarArgs.aR(2, this.DnA);
      paramVarArgs.e(3, this.DnB);
      if (this.Acr != null) {
        paramVarArgs.d(4, this.Acr);
      }
      if (this.Acs != null) {
        paramVarArgs.d(5, this.Acs);
      }
      if (this.Act != null) {
        paramVarArgs.d(6, this.Act);
      }
      AppMethodBeat.o(91470);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.q(1, this.Dnz) + 0 + f.a.a.b.b.a.bA(2, this.DnA) + (f.a.a.b.b.a.fY(3) + 8);
      paramInt = i;
      if (this.Acr != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Acr);
      }
      i = paramInt;
      if (this.Acs != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Acs);
      }
      paramInt = i;
      if (this.Act != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Act);
      }
      AppMethodBeat.o(91470);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(91470);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aml localaml = (aml)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91470);
        return -1;
      case 1: 
        localaml.Dnz = locala.KhF.xT();
        AppMethodBeat.o(91470);
        return 0;
      case 2: 
        localaml.DnA = locala.KhF.xS();
        AppMethodBeat.o(91470);
        return 0;
      case 3: 
        localaml.DnB = Double.longBitsToDouble(locala.KhF.fHy());
        AppMethodBeat.o(91470);
        return 0;
      case 4: 
        localaml.Acr = locala.KhF.readString();
        AppMethodBeat.o(91470);
        return 0;
      case 5: 
        localaml.Acs = locala.KhF.readString();
        AppMethodBeat.o(91470);
        return 0;
      }
      localaml.Act = locala.KhF.readString();
      AppMethodBeat.o(91470);
      return 0;
    }
    AppMethodBeat.o(91470);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aml
 * JD-Core Version:    0.7.0.1
 */