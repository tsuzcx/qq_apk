package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class pu
  extends com.tencent.mm.bw.a
{
  public String FZx;
  public LinkedList<String> Gdt;
  
  public pu()
  {
    AppMethodBeat.i(124465);
    this.Gdt = new LinkedList();
    AppMethodBeat.o(124465);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124466);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FZx == null)
      {
        paramVarArgs = new b("Not all required fields were included: brand_user_name");
        AppMethodBeat.o(124466);
        throw paramVarArgs;
      }
      if (this.FZx != null) {
        paramVarArgs.d(2, this.FZx);
      }
      paramVarArgs.e(3, 1, this.Gdt);
      AppMethodBeat.o(124466);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FZx == null) {
        break label322;
      }
    }
    label322:
    for (paramInt = f.a.a.b.b.a.e(2, this.FZx) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(3, 1, this.Gdt);
      AppMethodBeat.o(124466);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Gdt.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.FZx == null)
        {
          paramVarArgs = new b("Not all required fields were included: brand_user_name");
          AppMethodBeat.o(124466);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124466);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        pu localpu = (pu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124466);
          return -1;
        case 2: 
          localpu.FZx = locala.OmT.readString();
          AppMethodBeat.o(124466);
          return 0;
        }
        localpu.Gdt.add(locala.OmT.readString());
        AppMethodBeat.o(124466);
        return 0;
      }
      AppMethodBeat.o(124466);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pu
 * JD-Core Version:    0.7.0.1
 */