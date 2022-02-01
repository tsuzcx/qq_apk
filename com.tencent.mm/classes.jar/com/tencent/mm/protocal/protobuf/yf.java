package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class yf
  extends com.tencent.mm.bx.a
{
  public long channelType;
  public long connectSuccessfulTime;
  public long handshakeSuccessfulTime;
  public long readPacketFinishedTime;
  public long rtt;
  public long startConnectTime;
  public long startHandshakeTime;
  public long startReadPacketTime;
  public long startSendPacketTime;
  public long taskStartTime;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258304);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.startConnectTime);
      paramVarArgs.bv(2, this.connectSuccessfulTime);
      paramVarArgs.bv(3, this.startHandshakeTime);
      paramVarArgs.bv(4, this.handshakeSuccessfulTime);
      paramVarArgs.bv(5, this.startSendPacketTime);
      paramVarArgs.bv(6, this.startReadPacketTime);
      paramVarArgs.bv(7, this.readPacketFinishedTime);
      paramVarArgs.bv(8, this.taskStartTime);
      paramVarArgs.bv(9, this.rtt);
      paramVarArgs.bv(10, this.channelType);
      AppMethodBeat.o(258304);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.q(1, this.startConnectTime);
      int i = i.a.a.b.b.a.q(2, this.connectSuccessfulTime);
      int j = i.a.a.b.b.a.q(3, this.startHandshakeTime);
      int k = i.a.a.b.b.a.q(4, this.handshakeSuccessfulTime);
      int m = i.a.a.b.b.a.q(5, this.startSendPacketTime);
      int n = i.a.a.b.b.a.q(6, this.startReadPacketTime);
      int i1 = i.a.a.b.b.a.q(7, this.readPacketFinishedTime);
      int i2 = i.a.a.b.b.a.q(8, this.taskStartTime);
      int i3 = i.a.a.b.b.a.q(9, this.rtt);
      int i4 = i.a.a.b.b.a.q(10, this.channelType);
      AppMethodBeat.o(258304);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3 + i4;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258304);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      yf localyf = (yf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(258304);
        return -1;
      case 1: 
        localyf.startConnectTime = locala.ajGk.aaw();
        AppMethodBeat.o(258304);
        return 0;
      case 2: 
        localyf.connectSuccessfulTime = locala.ajGk.aaw();
        AppMethodBeat.o(258304);
        return 0;
      case 3: 
        localyf.startHandshakeTime = locala.ajGk.aaw();
        AppMethodBeat.o(258304);
        return 0;
      case 4: 
        localyf.handshakeSuccessfulTime = locala.ajGk.aaw();
        AppMethodBeat.o(258304);
        return 0;
      case 5: 
        localyf.startSendPacketTime = locala.ajGk.aaw();
        AppMethodBeat.o(258304);
        return 0;
      case 6: 
        localyf.startReadPacketTime = locala.ajGk.aaw();
        AppMethodBeat.o(258304);
        return 0;
      case 7: 
        localyf.readPacketFinishedTime = locala.ajGk.aaw();
        AppMethodBeat.o(258304);
        return 0;
      case 8: 
        localyf.taskStartTime = locala.ajGk.aaw();
        AppMethodBeat.o(258304);
        return 0;
      case 9: 
        localyf.rtt = locala.ajGk.aaw();
        AppMethodBeat.o(258304);
        return 0;
      }
      localyf.channelType = locala.ajGk.aaw();
      AppMethodBeat.o(258304);
      return 0;
    }
    AppMethodBeat.o(258304);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yf
 * JD-Core Version:    0.7.0.1
 */