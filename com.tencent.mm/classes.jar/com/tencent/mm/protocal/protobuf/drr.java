package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class drr
  extends com.tencent.mm.bx.a
{
  public com.tencent.mm.bx.b EGF;
  public com.tencent.mm.bx.b EGG;
  public String EGH;
  public String EGI;
  public String Eit;
  public int Epz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32550);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Eit == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Msg");
        AppMethodBeat.o(32550);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.Epz);
      if (this.Eit != null) {
        paramVarArgs.d(2, this.Eit);
      }
      if (this.EGF != null) {
        paramVarArgs.c(3, this.EGF);
      }
      if (this.EGG != null) {
        paramVarArgs.c(4, this.EGG);
      }
      if (this.EGH != null) {
        paramVarArgs.d(5, this.EGH);
      }
      if (this.EGI != null) {
        paramVarArgs.d(6, this.EGI);
      }
      AppMethodBeat.o(32550);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.Epz) + 0;
      paramInt = i;
      if (this.Eit != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Eit);
      }
      i = paramInt;
      if (this.EGF != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.EGF);
      }
      paramInt = i;
      if (this.EGG != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.EGG);
      }
      i = paramInt;
      if (this.EGH != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.EGH);
      }
      paramInt = i;
      if (this.EGI != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.EGI);
      }
      AppMethodBeat.o(32550);
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
      if (this.Eit == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Msg");
        AppMethodBeat.o(32550);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32550);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      drr localdrr = (drr)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32550);
        return -1;
      case 1: 
        localdrr.Epz = locala.KhF.xS();
        AppMethodBeat.o(32550);
        return 0;
      case 2: 
        localdrr.Eit = locala.KhF.readString();
        AppMethodBeat.o(32550);
        return 0;
      case 3: 
        localdrr.EGF = locala.KhF.fMu();
        AppMethodBeat.o(32550);
        return 0;
      case 4: 
        localdrr.EGG = locala.KhF.fMu();
        AppMethodBeat.o(32550);
        return 0;
      case 5: 
        localdrr.EGH = locala.KhF.readString();
        AppMethodBeat.o(32550);
        return 0;
      }
      localdrr.EGI = locala.KhF.readString();
      AppMethodBeat.o(32550);
      return 0;
    }
    AppMethodBeat.o(32550);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.drr
 * JD-Core Version:    0.7.0.1
 */