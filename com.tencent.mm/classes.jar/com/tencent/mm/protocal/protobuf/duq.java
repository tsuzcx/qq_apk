package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class duq
  extends com.tencent.mm.bw.a
{
  public String Fvl;
  public String GcA;
  public String Gcz;
  public String tia;
  public String tlK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32506);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Fvl != null) {
        paramVarArgs.d(1, this.Fvl);
      }
      if (this.Gcz != null) {
        paramVarArgs.d(2, this.Gcz);
      }
      if (this.tlK != null) {
        paramVarArgs.d(3, this.tlK);
      }
      if (this.tia != null) {
        paramVarArgs.d(4, this.tia);
      }
      if (this.GcA != null) {
        paramVarArgs.d(5, this.GcA);
      }
      AppMethodBeat.o(32506);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Fvl == null) {
        break label465;
      }
    }
    label465:
    for (int i = f.a.a.b.b.a.e(1, this.Fvl) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Gcz != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Gcz);
      }
      i = paramInt;
      if (this.tlK != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.tlK);
      }
      paramInt = i;
      if (this.tia != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.tia);
      }
      i = paramInt;
      if (this.GcA != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GcA);
      }
      AppMethodBeat.o(32506);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(32506);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        duq localduq = (duq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32506);
          return -1;
        case 1: 
          localduq.Fvl = locala.LVo.readString();
          AppMethodBeat.o(32506);
          return 0;
        case 2: 
          localduq.Gcz = locala.LVo.readString();
          AppMethodBeat.o(32506);
          return 0;
        case 3: 
          localduq.tlK = locala.LVo.readString();
          AppMethodBeat.o(32506);
          return 0;
        case 4: 
          localduq.tia = locala.LVo.readString();
          AppMethodBeat.o(32506);
          return 0;
        }
        localduq.GcA = locala.LVo.readString();
        AppMethodBeat.o(32506);
        return 0;
      }
      AppMethodBeat.o(32506);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.duq
 * JD-Core Version:    0.7.0.1
 */