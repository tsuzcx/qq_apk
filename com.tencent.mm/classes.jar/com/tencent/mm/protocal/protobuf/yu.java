package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class yu
  extends com.tencent.mm.bx.a
{
  public String Aar;
  public String Aav;
  public String Ahv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91429);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Aar != null) {
        paramVarArgs.d(1, this.Aar);
      }
      if (this.Ahv != null) {
        paramVarArgs.d(2, this.Ahv);
      }
      if (this.Aav != null) {
        paramVarArgs.d(3, this.Aav);
      }
      AppMethodBeat.o(91429);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Aar == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.Aar) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Ahv != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Ahv);
      }
      i = paramInt;
      if (this.Aav != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Aav);
      }
      AppMethodBeat.o(91429);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91429);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        yu localyu = (yu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91429);
          return -1;
        case 1: 
          localyu.Aar = locala.KhF.readString();
          AppMethodBeat.o(91429);
          return 0;
        case 2: 
          localyu.Ahv = locala.KhF.readString();
          AppMethodBeat.o(91429);
          return 0;
        }
        localyu.Aav = locala.KhF.readString();
        AppMethodBeat.o(91429);
        return 0;
      }
      AppMethodBeat.o(91429);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yu
 * JD-Core Version:    0.7.0.1
 */