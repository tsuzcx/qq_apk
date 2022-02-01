package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class drn
  extends com.tencent.mm.bx.a
{
  public boolean EGC;
  public boolean EGD;
  public boolean EGE;
  public com.tencent.mm.bx.b EGl;
  public String Egc;
  public int EjI;
  public String Title;
  public String gKr;
  public int sdO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32545);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Egc == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Talker");
        AppMethodBeat.o(32545);
        throw paramVarArgs;
      }
      if (this.Title == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Title");
        AppMethodBeat.o(32545);
        throw paramVarArgs;
      }
      if (this.gKr == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Content");
        AppMethodBeat.o(32545);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.sdO);
      if (this.Egc != null) {
        paramVarArgs.d(2, this.Egc);
      }
      if (this.Title != null) {
        paramVarArgs.d(3, this.Title);
      }
      if (this.gKr != null) {
        paramVarArgs.d(4, this.gKr);
      }
      paramVarArgs.aR(5, this.EjI);
      if (this.EGl != null) {
        paramVarArgs.c(6, this.EGl);
      }
      paramVarArgs.bg(7, this.EGC);
      paramVarArgs.bg(8, this.EGD);
      paramVarArgs.bg(9, this.EGE);
      AppMethodBeat.o(32545);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.sdO) + 0;
      paramInt = i;
      if (this.Egc != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Egc);
      }
      i = paramInt;
      if (this.Title != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Title);
      }
      paramInt = i;
      if (this.gKr != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.gKr);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.EjI);
      paramInt = i;
      if (this.EGl != null) {
        paramInt = i + f.a.a.b.b.a.b(6, this.EGl);
      }
      i = f.a.a.b.b.a.fY(7);
      int j = f.a.a.b.b.a.fY(8);
      int k = f.a.a.b.b.a.fY(9);
      AppMethodBeat.o(32545);
      return paramInt + (i + 1) + (j + 1) + (k + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      if (this.Egc == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Talker");
        AppMethodBeat.o(32545);
        throw paramVarArgs;
      }
      if (this.Title == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Title");
        AppMethodBeat.o(32545);
        throw paramVarArgs;
      }
      if (this.gKr == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Content");
        AppMethodBeat.o(32545);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32545);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      drn localdrn = (drn)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32545);
        return -1;
      case 1: 
        localdrn.sdO = locala.KhF.xS();
        AppMethodBeat.o(32545);
        return 0;
      case 2: 
        localdrn.Egc = locala.KhF.readString();
        AppMethodBeat.o(32545);
        return 0;
      case 3: 
        localdrn.Title = locala.KhF.readString();
        AppMethodBeat.o(32545);
        return 0;
      case 4: 
        localdrn.gKr = locala.KhF.readString();
        AppMethodBeat.o(32545);
        return 0;
      case 5: 
        localdrn.EjI = locala.KhF.xS();
        AppMethodBeat.o(32545);
        return 0;
      case 6: 
        localdrn.EGl = locala.KhF.fMu();
        AppMethodBeat.o(32545);
        return 0;
      case 7: 
        localdrn.EGC = locala.KhF.fHu();
        AppMethodBeat.o(32545);
        return 0;
      case 8: 
        localdrn.EGD = locala.KhF.fHu();
        AppMethodBeat.o(32545);
        return 0;
      }
      localdrn.EGE = locala.KhF.fHu();
      AppMethodBeat.o(32545);
      return 0;
    }
    AppMethodBeat.o(32545);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.drn
 * JD-Core Version:    0.7.0.1
 */