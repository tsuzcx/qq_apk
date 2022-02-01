package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class eay
  extends com.tencent.mm.bw.a
{
  public int EN;
  public b Gwe;
  public String uuid;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147789);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.EN);
      if (this.uuid != null) {
        paramVarArgs.d(2, this.uuid);
      }
      if (this.Gwe != null) {
        paramVarArgs.c(3, this.Gwe);
      }
      AppMethodBeat.o(147789);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.EN) + 0;
      paramInt = i;
      if (this.uuid != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.uuid);
      }
      i = paramInt;
      if (this.Gwe != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.Gwe);
      }
      AppMethodBeat.o(147789);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(147789);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      eay localeay = (eay)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(147789);
        return -1;
      case 1: 
        localeay.EN = locala.OmT.zc();
        AppMethodBeat.o(147789);
        return 0;
      case 2: 
        localeay.uuid = locala.OmT.readString();
        AppMethodBeat.o(147789);
        return 0;
      }
      localeay.Gwe = locala.OmT.gCk();
      AppMethodBeat.o(147789);
      return 0;
    }
    AppMethodBeat.o(147789);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eay
 * JD-Core Version:    0.7.0.1
 */