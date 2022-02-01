package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class wl
  extends com.tencent.mm.bw.a
{
  public long connectSuccessfulTime;
  public long handshakeSuccessfulTime;
  public long readPacketFinishedTime;
  public long startConnectTime;
  public long startHandshakeTime;
  public long startReadPacketTime;
  public long startSendPacketTime;
  public long taskStartTime;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(197131);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.startConnectTime);
      paramVarArgs.bb(2, this.connectSuccessfulTime);
      paramVarArgs.bb(3, this.startHandshakeTime);
      paramVarArgs.bb(4, this.handshakeSuccessfulTime);
      paramVarArgs.bb(5, this.startSendPacketTime);
      paramVarArgs.bb(6, this.startReadPacketTime);
      paramVarArgs.bb(7, this.readPacketFinishedTime);
      paramVarArgs.bb(8, this.taskStartTime);
      AppMethodBeat.o(197131);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.r(1, this.startConnectTime);
      int i = g.a.a.b.b.a.r(2, this.connectSuccessfulTime);
      int j = g.a.a.b.b.a.r(3, this.startHandshakeTime);
      int k = g.a.a.b.b.a.r(4, this.handshakeSuccessfulTime);
      int m = g.a.a.b.b.a.r(5, this.startSendPacketTime);
      int n = g.a.a.b.b.a.r(6, this.startReadPacketTime);
      int i1 = g.a.a.b.b.a.r(7, this.readPacketFinishedTime);
      int i2 = g.a.a.b.b.a.r(8, this.taskStartTime);
      AppMethodBeat.o(197131);
      return paramInt + 0 + i + j + k + m + n + i1 + i2;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(197131);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      wl localwl = (wl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(197131);
        return -1;
      case 1: 
        localwl.startConnectTime = locala.UbS.zl();
        AppMethodBeat.o(197131);
        return 0;
      case 2: 
        localwl.connectSuccessfulTime = locala.UbS.zl();
        AppMethodBeat.o(197131);
        return 0;
      case 3: 
        localwl.startHandshakeTime = locala.UbS.zl();
        AppMethodBeat.o(197131);
        return 0;
      case 4: 
        localwl.handshakeSuccessfulTime = locala.UbS.zl();
        AppMethodBeat.o(197131);
        return 0;
      case 5: 
        localwl.startSendPacketTime = locala.UbS.zl();
        AppMethodBeat.o(197131);
        return 0;
      case 6: 
        localwl.startReadPacketTime = locala.UbS.zl();
        AppMethodBeat.o(197131);
        return 0;
      case 7: 
        localwl.readPacketFinishedTime = locala.UbS.zl();
        AppMethodBeat.o(197131);
        return 0;
      }
      localwl.taskStartTime = locala.UbS.zl();
      AppMethodBeat.o(197131);
      return 0;
    }
    AppMethodBeat.o(197131);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wl
 * JD-Core Version:    0.7.0.1
 */