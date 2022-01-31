package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bwe
  extends com.tencent.mm.bv.a
{
  public int CreateTime;
  public String Name;
  public String wPa;
  public String wsq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123516);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Name != null) {
        paramVarArgs.e(1, this.Name);
      }
      if (this.wPa != null) {
        paramVarArgs.e(2, this.wPa);
      }
      if (this.wsq != null) {
        paramVarArgs.e(3, this.wsq);
      }
      paramVarArgs.aO(4, this.CreateTime);
      AppMethodBeat.o(123516);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Name == null) {
        break label378;
      }
    }
    label378:
    for (int i = e.a.a.b.b.a.f(1, this.Name) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wPa != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wPa);
      }
      i = paramInt;
      if (this.wsq != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wsq);
      }
      paramInt = e.a.a.b.b.a.bl(4, this.CreateTime);
      AppMethodBeat.o(123516);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(123516);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bwe localbwe = (bwe)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123516);
          return -1;
        case 1: 
          localbwe.Name = locala.CLY.readString();
          AppMethodBeat.o(123516);
          return 0;
        case 2: 
          localbwe.wPa = locala.CLY.readString();
          AppMethodBeat.o(123516);
          return 0;
        case 3: 
          localbwe.wsq = locala.CLY.readString();
          AppMethodBeat.o(123516);
          return 0;
        }
        localbwe.CreateTime = locala.CLY.sl();
        AppMethodBeat.o(123516);
        return 0;
      }
      AppMethodBeat.o(123516);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwe
 * JD-Core Version:    0.7.0.1
 */