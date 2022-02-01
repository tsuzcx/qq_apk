package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class czy
  extends com.tencent.mm.bx.a
{
  public boolean aaFs;
  public String aaFt;
  public String filePath;
  public long lxm;
  public long msgId;
  public int state;
  public String talker;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258898);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.msgId);
      if (this.filePath != null) {
        paramVarArgs.g(2, this.filePath);
      }
      paramVarArgs.di(3, this.aaFs);
      paramVarArgs.bv(4, this.lxm);
      if (this.talker != null) {
        paramVarArgs.g(5, this.talker);
      }
      if (this.aaFt != null) {
        paramVarArgs.g(6, this.aaFt);
      }
      paramVarArgs.bS(7, this.state);
      AppMethodBeat.o(258898);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(1, this.msgId) + 0;
      paramInt = i;
      if (this.filePath != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.filePath);
      }
      i = paramInt + (i.a.a.b.b.a.ko(3) + 1) + i.a.a.b.b.a.q(4, this.lxm);
      paramInt = i;
      if (this.talker != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.talker);
      }
      i = paramInt;
      if (this.aaFt != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.aaFt);
      }
      paramInt = i.a.a.b.b.a.cJ(7, this.state);
      AppMethodBeat.o(258898);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258898);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      czy localczy = (czy)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(258898);
        return -1;
      case 1: 
        localczy.msgId = locala.ajGk.aaw();
        AppMethodBeat.o(258898);
        return 0;
      case 2: 
        localczy.filePath = locala.ajGk.readString();
        AppMethodBeat.o(258898);
        return 0;
      case 3: 
        localczy.aaFs = locala.ajGk.aai();
        AppMethodBeat.o(258898);
        return 0;
      case 4: 
        localczy.lxm = locala.ajGk.aaw();
        AppMethodBeat.o(258898);
        return 0;
      case 5: 
        localczy.talker = locala.ajGk.readString();
        AppMethodBeat.o(258898);
        return 0;
      case 6: 
        localczy.aaFt = locala.ajGk.readString();
        AppMethodBeat.o(258898);
        return 0;
      }
      localczy.state = locala.ajGk.aar();
      AppMethodBeat.o(258898);
      return 0;
    }
    AppMethodBeat.o(258898);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czy
 * JD-Core Version:    0.7.0.1
 */