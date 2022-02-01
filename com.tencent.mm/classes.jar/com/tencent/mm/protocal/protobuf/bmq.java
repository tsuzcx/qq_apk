package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class bmq
  extends com.tencent.mm.bx.a
{
  public String ZVg;
  public boolean enable;
  public String mdK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258987);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZVg != null) {
        paramVarArgs.g(1, this.ZVg);
      }
      if (this.mdK != null) {
        paramVarArgs.g(2, this.mdK);
      }
      paramVarArgs.di(3, this.enable);
      AppMethodBeat.o(258987);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZVg == null) {
        break label314;
      }
    }
    label314:
    for (paramInt = i.a.a.b.b.a.h(1, this.ZVg) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.mdK != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.mdK);
      }
      paramInt = i.a.a.b.b.a.ko(3);
      AppMethodBeat.o(258987);
      return i + (paramInt + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258987);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        bmq localbmq = (bmq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258987);
          return -1;
        case 1: 
          localbmq.ZVg = locala.ajGk.readString();
          AppMethodBeat.o(258987);
          return 0;
        case 2: 
          localbmq.mdK = locala.ajGk.readString();
          AppMethodBeat.o(258987);
          return 0;
        }
        localbmq.enable = locala.ajGk.aai();
        AppMethodBeat.o(258987);
        return 0;
      }
      AppMethodBeat.o(258987);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmq
 * JD-Core Version:    0.7.0.1
 */