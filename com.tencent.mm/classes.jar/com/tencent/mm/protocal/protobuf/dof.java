package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dof
  extends com.tencent.mm.bx.a
{
  public String EEB;
  public String dbm;
  public String dbn;
  public long timestamp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147800);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dbm != null) {
        paramVarArgs.d(1, this.dbm);
      }
      if (this.dbn != null) {
        paramVarArgs.d(2, this.dbn);
      }
      if (this.EEB != null) {
        paramVarArgs.d(3, this.EEB);
      }
      paramVarArgs.aG(4, this.timestamp);
      AppMethodBeat.o(147800);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dbm == null) {
        break label378;
      }
    }
    label378:
    for (int i = f.a.a.b.b.a.e(1, this.dbm) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dbn != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dbn);
      }
      i = paramInt;
      if (this.EEB != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EEB);
      }
      paramInt = f.a.a.b.b.a.q(4, this.timestamp);
      AppMethodBeat.o(147800);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(147800);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dof localdof = (dof)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(147800);
          return -1;
        case 1: 
          localdof.dbm = locala.KhF.readString();
          AppMethodBeat.o(147800);
          return 0;
        case 2: 
          localdof.dbn = locala.KhF.readString();
          AppMethodBeat.o(147800);
          return 0;
        case 3: 
          localdof.EEB = locala.KhF.readString();
          AppMethodBeat.o(147800);
          return 0;
        }
        localdof.timestamp = locala.KhF.xT();
        AppMethodBeat.o(147800);
        return 0;
      }
      AppMethodBeat.o(147800);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dof
 * JD-Core Version:    0.7.0.1
 */