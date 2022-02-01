package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ehg
  extends com.tencent.mm.bx.a
{
  public long ZRl;
  public int duration;
  public int end_time;
  public int ftu;
  public long mMJ;
  public long object_id;
  public int replay_status;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259086);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.mMJ);
      paramVarArgs.bv(2, this.object_id);
      paramVarArgs.bS(3, this.ftu);
      paramVarArgs.bS(4, this.end_time);
      paramVarArgs.bv(5, this.ZRl);
      paramVarArgs.bS(6, this.replay_status);
      paramVarArgs.bS(7, this.duration);
      AppMethodBeat.o(259086);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.q(1, this.mMJ);
      int i = i.a.a.b.b.a.q(2, this.object_id);
      int j = i.a.a.b.b.a.cJ(3, this.ftu);
      int k = i.a.a.b.b.a.cJ(4, this.end_time);
      int m = i.a.a.b.b.a.q(5, this.ZRl);
      int n = i.a.a.b.b.a.cJ(6, this.replay_status);
      int i1 = i.a.a.b.b.a.cJ(7, this.duration);
      AppMethodBeat.o(259086);
      return paramInt + 0 + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259086);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      ehg localehg = (ehg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259086);
        return -1;
      case 1: 
        localehg.mMJ = locala.ajGk.aaw();
        AppMethodBeat.o(259086);
        return 0;
      case 2: 
        localehg.object_id = locala.ajGk.aaw();
        AppMethodBeat.o(259086);
        return 0;
      case 3: 
        localehg.ftu = locala.ajGk.aar();
        AppMethodBeat.o(259086);
        return 0;
      case 4: 
        localehg.end_time = locala.ajGk.aar();
        AppMethodBeat.o(259086);
        return 0;
      case 5: 
        localehg.ZRl = locala.ajGk.aaw();
        AppMethodBeat.o(259086);
        return 0;
      case 6: 
        localehg.replay_status = locala.ajGk.aar();
        AppMethodBeat.o(259086);
        return 0;
      }
      localehg.duration = locala.ajGk.aar();
      AppMethodBeat.o(259086);
      return 0;
    }
    AppMethodBeat.o(259086);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ehg
 * JD-Core Version:    0.7.0.1
 */