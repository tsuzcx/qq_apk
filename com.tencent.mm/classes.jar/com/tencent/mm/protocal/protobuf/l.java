package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
  extends com.tencent.mm.bx.a
{
  public int iap;
  public int iaq;
  public int iar;
  public long ias;
  public long iat;
  public String iau;
  public String iav;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91323);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.iap);
      paramVarArgs.aR(2, this.iaq);
      paramVarArgs.aR(3, this.iar);
      paramVarArgs.aG(4, this.ias);
      paramVarArgs.aG(5, this.iat);
      if (this.iau != null) {
        paramVarArgs.d(6, this.iau);
      }
      if (this.iav != null) {
        paramVarArgs.d(7, this.iav);
      }
      AppMethodBeat.o(91323);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.iap) + 0 + f.a.a.b.b.a.bA(2, this.iaq) + f.a.a.b.b.a.bA(3, this.iar) + f.a.a.b.b.a.q(4, this.ias) + f.a.a.b.b.a.q(5, this.iat);
      paramInt = i;
      if (this.iau != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.iau);
      }
      i = paramInt;
      if (this.iav != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.iav);
      }
      AppMethodBeat.o(91323);
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
      AppMethodBeat.o(91323);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      l locall = (l)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91323);
        return -1;
      case 1: 
        locall.iap = locala.KhF.xS();
        AppMethodBeat.o(91323);
        return 0;
      case 2: 
        locall.iaq = locala.KhF.xS();
        AppMethodBeat.o(91323);
        return 0;
      case 3: 
        locall.iar = locala.KhF.xS();
        AppMethodBeat.o(91323);
        return 0;
      case 4: 
        locall.ias = locala.KhF.xT();
        AppMethodBeat.o(91323);
        return 0;
      case 5: 
        locall.iat = locala.KhF.xT();
        AppMethodBeat.o(91323);
        return 0;
      case 6: 
        locall.iau = locala.KhF.readString();
        AppMethodBeat.o(91323);
        return 0;
      }
      locall.iav = locala.KhF.readString();
      AppMethodBeat.o(91323);
      return 0;
    }
    AppMethodBeat.o(91323);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.l
 * JD-Core Version:    0.7.0.1
 */