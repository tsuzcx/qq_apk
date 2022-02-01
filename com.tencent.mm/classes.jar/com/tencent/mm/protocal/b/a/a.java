package com.tencent.mm.protocal.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class a
  extends com.tencent.mm.bw.a
{
  public String DKv;
  public String DKw;
  public int actionType;
  public int id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123716);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DKv == null)
      {
        paramVarArgs = new b("Not all required fields were included: btnStr");
        AppMethodBeat.o(123716);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.id);
      paramVarArgs.aR(2, this.actionType);
      if (this.DKv != null) {
        paramVarArgs.d(3, this.DKv);
      }
      if (this.DKw != null) {
        paramVarArgs.d(4, this.DKw);
      }
      AppMethodBeat.o(123716);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.id) + 0 + f.a.a.b.b.a.bx(2, this.actionType);
      paramInt = i;
      if (this.DKv != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.DKv);
      }
      i = paramInt;
      if (this.DKw != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.DKw);
      }
      AppMethodBeat.o(123716);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      if (this.DKv == null)
      {
        paramVarArgs = new b("Not all required fields were included: btnStr");
        AppMethodBeat.o(123716);
        throw paramVarArgs;
      }
      AppMethodBeat.o(123716);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      a locala1 = (a)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123716);
        return -1;
      case 1: 
        locala1.id = locala.LVo.xF();
        AppMethodBeat.o(123716);
        return 0;
      case 2: 
        locala1.actionType = locala.LVo.xF();
        AppMethodBeat.o(123716);
        return 0;
      case 3: 
        locala1.DKv = locala.LVo.readString();
        AppMethodBeat.o(123716);
        return 0;
      }
      locala1.DKw = locala.LVo.readString();
      AppMethodBeat.o(123716);
      return 0;
    }
    AppMethodBeat.o(123716);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.b.a.a
 * JD-Core Version:    0.7.0.1
 */