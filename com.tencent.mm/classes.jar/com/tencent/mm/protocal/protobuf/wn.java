package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class wn
  extends com.tencent.mm.cd.a
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
    AppMethodBeat.i(214832);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.startConnectTime);
      paramVarArgs.bm(2, this.connectSuccessfulTime);
      paramVarArgs.bm(3, this.startHandshakeTime);
      paramVarArgs.bm(4, this.handshakeSuccessfulTime);
      paramVarArgs.bm(5, this.startSendPacketTime);
      paramVarArgs.bm(6, this.startReadPacketTime);
      paramVarArgs.bm(7, this.readPacketFinishedTime);
      paramVarArgs.bm(8, this.taskStartTime);
      AppMethodBeat.o(214832);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.p(1, this.startConnectTime);
      int i = g.a.a.b.b.a.p(2, this.connectSuccessfulTime);
      int j = g.a.a.b.b.a.p(3, this.startHandshakeTime);
      int k = g.a.a.b.b.a.p(4, this.handshakeSuccessfulTime);
      int m = g.a.a.b.b.a.p(5, this.startSendPacketTime);
      int n = g.a.a.b.b.a.p(6, this.startReadPacketTime);
      int i1 = g.a.a.b.b.a.p(7, this.readPacketFinishedTime);
      int i2 = g.a.a.b.b.a.p(8, this.taskStartTime);
      AppMethodBeat.o(214832);
      return paramInt + 0 + i + j + k + m + n + i1 + i2;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(214832);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      wn localwn = (wn)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(214832);
        return -1;
      case 1: 
        localwn.startConnectTime = locala.abFh.AN();
        AppMethodBeat.o(214832);
        return 0;
      case 2: 
        localwn.connectSuccessfulTime = locala.abFh.AN();
        AppMethodBeat.o(214832);
        return 0;
      case 3: 
        localwn.startHandshakeTime = locala.abFh.AN();
        AppMethodBeat.o(214832);
        return 0;
      case 4: 
        localwn.handshakeSuccessfulTime = locala.abFh.AN();
        AppMethodBeat.o(214832);
        return 0;
      case 5: 
        localwn.startSendPacketTime = locala.abFh.AN();
        AppMethodBeat.o(214832);
        return 0;
      case 6: 
        localwn.startReadPacketTime = locala.abFh.AN();
        AppMethodBeat.o(214832);
        return 0;
      case 7: 
        localwn.readPacketFinishedTime = locala.abFh.AN();
        AppMethodBeat.o(214832);
        return 0;
      }
      localwn.taskStartTime = locala.abFh.AN();
      AppMethodBeat.o(214832);
      return 0;
    }
    AppMethodBeat.o(214832);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wn
 * JD-Core Version:    0.7.0.1
 */