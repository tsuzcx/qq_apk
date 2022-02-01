package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class amt
  extends com.tencent.mm.bx.a
{
  public int DnN = 7;
  public long DnO = 0L;
  public int DnP = 0;
  public String DnQ = "";
  public String DnR = "";
  public boolean DnS = false;
  public int htk = 0;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122494);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.DnN);
      paramVarArgs.aG(2, this.DnO);
      paramVarArgs.aR(3, this.DnP);
      if (this.DnQ != null) {
        paramVarArgs.d(4, this.DnQ);
      }
      if (this.DnR != null) {
        paramVarArgs.d(5, this.DnR);
      }
      paramVarArgs.aR(6, this.htk);
      paramVarArgs.bg(7, this.DnS);
      AppMethodBeat.o(122494);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.DnN) + 0 + f.a.a.b.b.a.q(2, this.DnO) + f.a.a.b.b.a.bA(3, this.DnP);
      paramInt = i;
      if (this.DnQ != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DnQ);
      }
      i = paramInt;
      if (this.DnR != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.DnR);
      }
      paramInt = f.a.a.b.b.a.bA(6, this.htk);
      int j = f.a.a.b.b.a.fY(7);
      AppMethodBeat.o(122494);
      return i + paramInt + (j + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(122494);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      amt localamt = (amt)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(122494);
        return -1;
      case 1: 
        localamt.DnN = locala.KhF.xS();
        AppMethodBeat.o(122494);
        return 0;
      case 2: 
        localamt.DnO = locala.KhF.xT();
        AppMethodBeat.o(122494);
        return 0;
      case 3: 
        localamt.DnP = locala.KhF.xS();
        AppMethodBeat.o(122494);
        return 0;
      case 4: 
        localamt.DnQ = locala.KhF.readString();
        AppMethodBeat.o(122494);
        return 0;
      case 5: 
        localamt.DnR = locala.KhF.readString();
        AppMethodBeat.o(122494);
        return 0;
      case 6: 
        localamt.htk = locala.KhF.xS();
        AppMethodBeat.o(122494);
        return 0;
      }
      localamt.DnS = locala.KhF.fHu();
      AppMethodBeat.o(122494);
      return 0;
    }
    AppMethodBeat.o(122494);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amt
 * JD-Core Version:    0.7.0.1
 */