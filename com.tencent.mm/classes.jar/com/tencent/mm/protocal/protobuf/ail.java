package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ail
  extends com.tencent.mm.bw.a
{
  public String GxR;
  public String Gyc;
  public LinkedList<String> Gyd;
  public boolean Gye;
  
  public ail()
  {
    AppMethodBeat.i(32203);
    this.Gyd = new LinkedList();
    AppMethodBeat.o(32203);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32204);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GxR == null)
      {
        paramVarArgs = new b("Not all required fields were included: LoginUrl");
        AppMethodBeat.o(32204);
        throw paramVarArgs;
      }
      if (this.GxR != null) {
        paramVarArgs.d(1, this.GxR);
      }
      if (this.Gyc != null) {
        paramVarArgs.d(2, this.Gyc);
      }
      paramVarArgs.e(3, 1, this.Gyd);
      paramVarArgs.bC(4, this.Gye);
      AppMethodBeat.o(32204);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GxR == null) {
        break label436;
      }
    }
    label436:
    for (paramInt = f.a.a.b.b.a.e(1, this.GxR) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Gyc != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Gyc);
      }
      paramInt = f.a.a.a.c(3, 1, this.Gyd);
      int j = f.a.a.b.b.a.amF(4);
      AppMethodBeat.o(32204);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Gyd.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.GxR == null)
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
        ail localail = (ail)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32204);
          return -1;
        case 1: 
          localail.GxR = locala.OmT.readString();
          AppMethodBeat.o(32204);
          return 0;
        case 2: 
          localail.Gyc = locala.OmT.readString();
          AppMethodBeat.o(32204);
          return 0;
        case 3: 
          localail.Gyd.add(locala.OmT.readString());
          AppMethodBeat.o(32204);
          return 0;
        }
        localail.Gye = locala.OmT.gvY();
        AppMethodBeat.o(32204);
        return 0;
      }
      AppMethodBeat.o(32204);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ail
 * JD-Core Version:    0.7.0.1
 */