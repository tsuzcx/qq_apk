package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dig
  extends com.tencent.mm.bx.a
{
  public int HTK;
  public String Zqd;
  public String aaNe;
  public String aaNf;
  public long mMJ;
  public int rotation;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257350);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.mMJ);
      if (this.aaNe != null) {
        paramVarArgs.g(2, this.aaNe);
      }
      paramVarArgs.bS(3, this.rotation);
      if (this.Zqd != null) {
        paramVarArgs.g(4, this.Zqd);
      }
      paramVarArgs.bS(5, this.HTK);
      if (this.aaNf != null) {
        paramVarArgs.g(6, this.aaNf);
      }
      AppMethodBeat.o(257350);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(1, this.mMJ) + 0;
      paramInt = i;
      if (this.aaNe != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aaNe);
      }
      i = paramInt + i.a.a.b.b.a.cJ(3, this.rotation);
      paramInt = i;
      if (this.Zqd != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.Zqd);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.HTK);
      paramInt = i;
      if (this.aaNf != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.aaNf);
      }
      AppMethodBeat.o(257350);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(257350);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      dig localdig = (dig)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(257350);
        return -1;
      case 1: 
        localdig.mMJ = locala.ajGk.aaw();
        AppMethodBeat.o(257350);
        return 0;
      case 2: 
        localdig.aaNe = locala.ajGk.readString();
        AppMethodBeat.o(257350);
        return 0;
      case 3: 
        localdig.rotation = locala.ajGk.aar();
        AppMethodBeat.o(257350);
        return 0;
      case 4: 
        localdig.Zqd = locala.ajGk.readString();
        AppMethodBeat.o(257350);
        return 0;
      case 5: 
        localdig.HTK = locala.ajGk.aar();
        AppMethodBeat.o(257350);
        return 0;
      }
      localdig.aaNf = locala.ajGk.readString();
      AppMethodBeat.o(257350);
      return 0;
    }
    AppMethodBeat.o(257350);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dig
 * JD-Core Version:    0.7.0.1
 */