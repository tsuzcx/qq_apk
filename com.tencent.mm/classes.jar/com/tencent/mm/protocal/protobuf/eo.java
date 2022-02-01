package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eo
  extends com.tencent.mm.bx.a
{
  public String Fwn;
  public String Fwo;
  public String Fwp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125710);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Fwn != null) {
        paramVarArgs.d(1, this.Fwn);
      }
      if (this.Fwo != null) {
        paramVarArgs.d(2, this.Fwo);
      }
      if (this.Fwp != null) {
        paramVarArgs.d(3, this.Fwp);
      }
      AppMethodBeat.o(125710);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Fwn == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.Fwn) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Fwo != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Fwo);
      }
      i = paramInt;
      if (this.Fwp != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Fwp);
      }
      AppMethodBeat.o(125710);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(125710);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        eo localeo = (eo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(125710);
          return -1;
        case 1: 
          localeo.Fwn = locala.NPN.readString();
          AppMethodBeat.o(125710);
          return 0;
        case 2: 
          localeo.Fwo = locala.NPN.readString();
          AppMethodBeat.o(125710);
          return 0;
        }
        localeo.Fwp = locala.NPN.readString();
        AppMethodBeat.o(125710);
        return 0;
      }
      AppMethodBeat.o(125710);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eo
 * JD-Core Version:    0.7.0.1
 */