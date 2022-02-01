package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class chb
  extends com.tencent.mm.bx.a
{
  public String CWf;
  public String HaD;
  public String app_id;
  public String oIu;
  public String oIw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72540);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.app_id != null) {
        paramVarArgs.d(1, this.app_id);
      }
      if (this.CWf != null) {
        paramVarArgs.d(2, this.CWf);
      }
      if (this.oIw != null) {
        paramVarArgs.d(3, this.oIw);
      }
      if (this.oIu != null) {
        paramVarArgs.d(4, this.oIu);
      }
      if (this.HaD != null) {
        paramVarArgs.d(5, this.HaD);
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
    for (int i = f.a.a.b.b.a.e(1, this.app_id) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CWf != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.CWf);
      }
      i = paramInt;
      if (this.oIw != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.oIw);
      }
      paramInt = i;
      if (this.oIu != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.oIu);
      }
      i = paramInt;
      if (this.HaD != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.HaD);
      }
      AppMethodBeat.o(72540);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(72540);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        chb localchb = (chb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72540);
          return -1;
        case 1: 
          localchb.app_id = locala.NPN.readString();
          AppMethodBeat.o(72540);
          return 0;
        case 2: 
          localchb.CWf = locala.NPN.readString();
          AppMethodBeat.o(72540);
          return 0;
        case 3: 
          localchb.oIw = locala.NPN.readString();
          AppMethodBeat.o(72540);
          return 0;
        case 4: 
          localchb.oIu = locala.NPN.readString();
          AppMethodBeat.o(72540);
          return 0;
        }
        localchb.HaD = locala.NPN.readString();
        AppMethodBeat.o(72540);
        return 0;
      }
      AppMethodBeat.o(72540);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chb
 * JD-Core Version:    0.7.0.1
 */