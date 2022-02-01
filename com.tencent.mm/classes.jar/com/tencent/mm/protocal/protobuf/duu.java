package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class duu
  extends com.tencent.mm.bx.a
{
  public String ZYN;
  public long abaF;
  public int abaG;
  public int abaH;
  public String abaI;
  public int liveStatus;
  public long mMJ;
  public long object_id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259072);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.mMJ);
      paramVarArgs.bv(2, this.object_id);
      if (this.ZYN != null) {
        paramVarArgs.g(3, this.ZYN);
      }
      paramVarArgs.bv(4, this.abaF);
      paramVarArgs.bS(5, this.abaG);
      paramVarArgs.bS(6, this.abaH);
      paramVarArgs.bS(7, this.liveStatus);
      if (this.abaI != null) {
        paramVarArgs.g(8, this.abaI);
      }
      AppMethodBeat.o(259072);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(1, this.mMJ) + 0 + i.a.a.b.b.a.q(2, this.object_id);
      paramInt = i;
      if (this.ZYN != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.ZYN);
      }
      i = paramInt + i.a.a.b.b.a.q(4, this.abaF) + i.a.a.b.b.a.cJ(5, this.abaG) + i.a.a.b.b.a.cJ(6, this.abaH) + i.a.a.b.b.a.cJ(7, this.liveStatus);
      paramInt = i;
      if (this.abaI != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.abaI);
      }
      AppMethodBeat.o(259072);
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
      AppMethodBeat.o(259072);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      duu localduu = (duu)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259072);
        return -1;
      case 1: 
        localduu.mMJ = locala.ajGk.aaw();
        AppMethodBeat.o(259072);
        return 0;
      case 2: 
        localduu.object_id = locala.ajGk.aaw();
        AppMethodBeat.o(259072);
        return 0;
      case 3: 
        localduu.ZYN = locala.ajGk.readString();
        AppMethodBeat.o(259072);
        return 0;
      case 4: 
        localduu.abaF = locala.ajGk.aaw();
        AppMethodBeat.o(259072);
        return 0;
      case 5: 
        localduu.abaG = locala.ajGk.aar();
        AppMethodBeat.o(259072);
        return 0;
      case 6: 
        localduu.abaH = locala.ajGk.aar();
        AppMethodBeat.o(259072);
        return 0;
      case 7: 
        localduu.liveStatus = locala.ajGk.aar();
        AppMethodBeat.o(259072);
        return 0;
      }
      localduu.abaI = locala.ajGk.readString();
      AppMethodBeat.o(259072);
      return 0;
    }
    AppMethodBeat.o(259072);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.duu
 * JD-Core Version:    0.7.0.1
 */