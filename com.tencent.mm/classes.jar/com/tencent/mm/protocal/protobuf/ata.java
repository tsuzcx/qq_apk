package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class ata
  extends com.tencent.mm.bx.a
{
  public String Ddp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104787);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Ddp == null)
      {
        paramVarArgs = new b("Not all required fields were included: DesignerID");
        AppMethodBeat.o(104787);
        throw paramVarArgs;
      }
      if (this.Ddp != null) {
        paramVarArgs.d(1, this.Ddp);
      }
      AppMethodBeat.o(104787);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ddp == null) {
        break label261;
      }
    }
    label261:
    for (paramInt = f.a.a.b.b.a.e(1, this.Ddp) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(104787);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.Ddp == null)
        {
          paramVarArgs = new b("Not all required fields were included: DesignerID");
          AppMethodBeat.o(104787);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104787);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ata localata = (ata)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104787);
          return -1;
        }
        localata.Ddp = locala.KhF.readString();
        AppMethodBeat.o(104787);
        return 0;
      }
      AppMethodBeat.o(104787);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ata
 * JD-Core Version:    0.7.0.1
 */