package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cyg
  extends com.tencent.mm.bx.a
{
  public int Eqm;
  public String Eqn;
  public String Eqo;
  public String Eqp;
  public String Eqq;
  public int height;
  public int width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168761);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Eqm);
      if (this.Eqn != null) {
        paramVarArgs.d(2, this.Eqn);
      }
      if (this.Eqo != null) {
        paramVarArgs.d(3, this.Eqo);
      }
      paramVarArgs.aR(4, this.height);
      paramVarArgs.aR(5, this.width);
      if (this.Eqp != null) {
        paramVarArgs.d(6, this.Eqp);
      }
      if (this.Eqq != null) {
        paramVarArgs.d(7, this.Eqq);
      }
      AppMethodBeat.o(168761);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.Eqm) + 0;
      paramInt = i;
      if (this.Eqn != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Eqn);
      }
      i = paramInt;
      if (this.Eqo != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Eqo);
      }
      i = i + f.a.a.b.b.a.bA(4, this.height) + f.a.a.b.b.a.bA(5, this.width);
      paramInt = i;
      if (this.Eqp != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Eqp);
      }
      i = paramInt;
      if (this.Eqq != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Eqq);
      }
      AppMethodBeat.o(168761);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(168761);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cyg localcyg = (cyg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(168761);
        return -1;
      case 1: 
        localcyg.Eqm = locala.KhF.xS();
        AppMethodBeat.o(168761);
        return 0;
      case 2: 
        localcyg.Eqn = locala.KhF.readString();
        AppMethodBeat.o(168761);
        return 0;
      case 3: 
        localcyg.Eqo = locala.KhF.readString();
        AppMethodBeat.o(168761);
        return 0;
      case 4: 
        localcyg.height = locala.KhF.xS();
        AppMethodBeat.o(168761);
        return 0;
      case 5: 
        localcyg.width = locala.KhF.xS();
        AppMethodBeat.o(168761);
        return 0;
      case 6: 
        localcyg.Eqp = locala.KhF.readString();
        AppMethodBeat.o(168761);
        return 0;
      }
      localcyg.Eqq = locala.KhF.readString();
      AppMethodBeat.o(168761);
      return 0;
    }
    AppMethodBeat.o(168761);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyg
 * JD-Core Version:    0.7.0.1
 */