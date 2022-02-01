package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dcm
  extends com.tencent.mm.bx.a
{
  public String DnR = "";
  public String activityName = "";
  public long timestamp = 0L;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122553);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.activityName != null) {
        paramVarArgs.d(1, this.activityName);
      }
      if (this.DnR != null) {
        paramVarArgs.d(2, this.DnR);
      }
      paramVarArgs.aG(3, this.timestamp);
      AppMethodBeat.o(122553);
      return 0;
    }
    if (paramInt == 1) {
      if (this.activityName == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.activityName) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DnR != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.DnR);
      }
      paramInt = f.a.a.b.b.a.q(3, this.timestamp);
      AppMethodBeat.o(122553);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(122553);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dcm localdcm = (dcm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(122553);
          return -1;
        case 1: 
          localdcm.activityName = locala.KhF.readString();
          AppMethodBeat.o(122553);
          return 0;
        case 2: 
          localdcm.DnR = locala.KhF.readString();
          AppMethodBeat.o(122553);
          return 0;
        }
        localdcm.timestamp = locala.KhF.xT();
        AppMethodBeat.o(122553);
        return 0;
      }
      AppMethodBeat.o(122553);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dcm
 * JD-Core Version:    0.7.0.1
 */