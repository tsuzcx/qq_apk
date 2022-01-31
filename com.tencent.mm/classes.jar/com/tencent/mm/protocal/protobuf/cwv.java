package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cwv
  extends com.tencent.mm.bv.a
{
  public String jJA;
  public String jKG;
  public String ntu;
  public int nuk;
  public com.tencent.mm.bv.b yeB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28728);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.jJA == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: UserName");
        AppMethodBeat.o(28728);
        throw paramVarArgs;
      }
      if (this.jKG == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: NickName");
        AppMethodBeat.o(28728);
        throw paramVarArgs;
      }
      if (this.ntu == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: Content");
        AppMethodBeat.o(28728);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.nuk);
      if (this.jJA != null) {
        paramVarArgs.e(2, this.jJA);
      }
      if (this.jKG != null) {
        paramVarArgs.e(3, this.jKG);
      }
      if (this.ntu != null) {
        paramVarArgs.e(4, this.ntu);
      }
      if (this.yeB != null) {
        paramVarArgs.c(5, this.yeB);
      }
      AppMethodBeat.o(28728);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.nuk) + 0;
      paramInt = i;
      if (this.jJA != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.jJA);
      }
      i = paramInt;
      if (this.jKG != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.jKG);
      }
      paramInt = i;
      if (this.ntu != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.ntu);
      }
      i = paramInt;
      if (this.yeB != null) {
        i = paramInt + e.a.a.b.b.a.b(5, this.yeB);
      }
      AppMethodBeat.o(28728);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      if (this.jJA == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: UserName");
        AppMethodBeat.o(28728);
        throw paramVarArgs;
      }
      if (this.jKG == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: NickName");
        AppMethodBeat.o(28728);
        throw paramVarArgs;
      }
      if (this.ntu == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: Content");
        AppMethodBeat.o(28728);
        throw paramVarArgs;
      }
      AppMethodBeat.o(28728);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      cwv localcwv = (cwv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(28728);
        return -1;
      case 1: 
        localcwv.nuk = locala.CLY.sl();
        AppMethodBeat.o(28728);
        return 0;
      case 2: 
        localcwv.jJA = locala.CLY.readString();
        AppMethodBeat.o(28728);
        return 0;
      case 3: 
        localcwv.jKG = locala.CLY.readString();
        AppMethodBeat.o(28728);
        return 0;
      case 4: 
        localcwv.ntu = locala.CLY.readString();
        AppMethodBeat.o(28728);
        return 0;
      }
      localcwv.yeB = locala.CLY.eqS();
      AppMethodBeat.o(28728);
      return 0;
    }
    AppMethodBeat.o(28728);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwv
 * JD-Core Version:    0.7.0.1
 */