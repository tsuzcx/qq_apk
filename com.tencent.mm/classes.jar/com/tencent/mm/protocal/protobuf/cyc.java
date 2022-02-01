package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cyc
  extends com.tencent.mm.bw.a
{
  public String HXc;
  public String MDb;
  public String app_id;
  public String qcK;
  public String qcM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72540);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.app_id != null) {
        paramVarArgs.e(1, this.app_id);
      }
      if (this.HXc != null) {
        paramVarArgs.e(2, this.HXc);
      }
      if (this.qcM != null) {
        paramVarArgs.e(3, this.qcM);
      }
      if (this.qcK != null) {
        paramVarArgs.e(4, this.qcK);
      }
      if (this.MDb != null) {
        paramVarArgs.e(5, this.MDb);
      }
      AppMethodBeat.o(72540);
      return 0;
    }
    if (paramInt == 1) {
      if (this.app_id == null) {
        break label454;
      }
    }
    label454:
    for (int i = g.a.a.b.b.a.f(1, this.app_id) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HXc != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.HXc);
      }
      i = paramInt;
      if (this.qcM != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.qcM);
      }
      paramInt = i;
      if (this.qcK != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.qcK);
      }
      i = paramInt;
      if (this.MDb != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.MDb);
      }
      AppMethodBeat.o(72540);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(72540);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cyc localcyc = (cyc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72540);
          return -1;
        case 1: 
          localcyc.app_id = locala.UbS.readString();
          AppMethodBeat.o(72540);
          return 0;
        case 2: 
          localcyc.HXc = locala.UbS.readString();
          AppMethodBeat.o(72540);
          return 0;
        case 3: 
          localcyc.qcM = locala.UbS.readString();
          AppMethodBeat.o(72540);
          return 0;
        case 4: 
          localcyc.qcK = locala.UbS.readString();
          AppMethodBeat.o(72540);
          return 0;
        }
        localcyc.MDb = locala.UbS.readString();
        AppMethodBeat.o(72540);
        return 0;
      }
      AppMethodBeat.o(72540);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyc
 * JD-Core Version:    0.7.0.1
 */