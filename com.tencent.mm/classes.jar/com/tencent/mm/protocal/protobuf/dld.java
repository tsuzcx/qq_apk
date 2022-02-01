package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dld
  extends com.tencent.mm.bx.a
{
  public long DFW;
  public long aaQY;
  public long aaQZ;
  public long aaRa;
  public long liveId;
  public int startTime;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259168);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.DFW);
      paramVarArgs.bv(2, this.aaQY);
      paramVarArgs.bS(3, this.startTime);
      paramVarArgs.bv(4, this.liveId);
      paramVarArgs.bv(5, this.aaQZ);
      paramVarArgs.bv(6, this.aaRa);
      AppMethodBeat.o(259168);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.q(1, this.DFW);
      int i = i.a.a.b.b.a.q(2, this.aaQY);
      int j = i.a.a.b.b.a.cJ(3, this.startTime);
      int k = i.a.a.b.b.a.q(4, this.liveId);
      int m = i.a.a.b.b.a.q(5, this.aaQZ);
      int n = i.a.a.b.b.a.q(6, this.aaRa);
      AppMethodBeat.o(259168);
      return paramInt + 0 + i + j + k + m + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259168);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      dld localdld = (dld)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259168);
        return -1;
      case 1: 
        localdld.DFW = locala.ajGk.aaw();
        AppMethodBeat.o(259168);
        return 0;
      case 2: 
        localdld.aaQY = locala.ajGk.aaw();
        AppMethodBeat.o(259168);
        return 0;
      case 3: 
        localdld.startTime = locala.ajGk.aar();
        AppMethodBeat.o(259168);
        return 0;
      case 4: 
        localdld.liveId = locala.ajGk.aaw();
        AppMethodBeat.o(259168);
        return 0;
      case 5: 
        localdld.aaQZ = locala.ajGk.aaw();
        AppMethodBeat.o(259168);
        return 0;
      }
      localdld.aaRa = locala.ajGk.aaw();
      AppMethodBeat.o(259168);
      return 0;
    }
    AppMethodBeat.o(259168);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dld
 * JD-Core Version:    0.7.0.1
 */