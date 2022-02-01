package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class aib
  extends com.tencent.mm.bx.a
{
  public String Gfj;
  public String Gfu;
  public LinkedList<String> Gfv;
  public boolean Gfw;
  
  public aib()
  {
    AppMethodBeat.i(32203);
    this.Gfv = new LinkedList();
    AppMethodBeat.o(32203);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32204);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gfj == null)
      {
        paramVarArgs = new b("Not all required fields were included: LoginUrl");
        AppMethodBeat.o(32204);
        throw paramVarArgs;
      }
      if (this.Gfj != null) {
        paramVarArgs.d(1, this.Gfj);
      }
      if (this.Gfu != null) {
        paramVarArgs.d(2, this.Gfu);
      }
      paramVarArgs.e(3, 1, this.Gfv);
      paramVarArgs.bt(4, this.Gfw);
      AppMethodBeat.o(32204);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Gfj == null) {
        break label436;
      }
    }
    label436:
    for (paramInt = f.a.a.b.b.a.e(1, this.Gfj) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Gfu != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Gfu);
      }
      paramInt = f.a.a.a.c(3, 1, this.Gfv);
      int j = f.a.a.b.b.a.alV(4);
      AppMethodBeat.o(32204);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Gfv.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.Gfj == null)
        {
          paramVarArgs = new b("Not all required fields were included: LoginUrl");
          AppMethodBeat.o(32204);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32204);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        aib localaib = (aib)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32204);
          return -1;
        case 1: 
          localaib.Gfj = locala.NPN.readString();
          AppMethodBeat.o(32204);
          return 0;
        case 2: 
          localaib.Gfu = locala.NPN.readString();
          AppMethodBeat.o(32204);
          return 0;
        case 3: 
          localaib.Gfv.add(locala.NPN.readString());
          AppMethodBeat.o(32204);
          return 0;
        }
        localaib.Gfw = locala.NPN.grw();
        AppMethodBeat.o(32204);
        return 0;
      }
      AppMethodBeat.o(32204);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aib
 * JD-Core Version:    0.7.0.1
 */