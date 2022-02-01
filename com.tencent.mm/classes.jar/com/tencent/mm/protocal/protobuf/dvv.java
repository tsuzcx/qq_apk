package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dvv
  extends com.tencent.mm.bx.a
{
  public String EJi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123708);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EJi != null) {
        paramVarArgs.d(1, this.EJi);
      }
      AppMethodBeat.o(123708);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EJi == null) {
        break label213;
      }
    }
    label213:
    for (paramInt = f.a.a.b.b.a.e(1, this.EJi) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(123708);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(123708);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dvv localdvv = (dvv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123708);
          return -1;
        }
        localdvv.EJi = locala.KhF.readString();
        AppMethodBeat.o(123708);
        return 0;
      }
      AppMethodBeat.o(123708);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvv
 * JD-Core Version:    0.7.0.1
 */