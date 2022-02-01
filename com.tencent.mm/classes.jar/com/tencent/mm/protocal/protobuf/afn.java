package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class afn
  extends com.tencent.mm.bw.a
{
  public String ExD;
  public String ExO;
  public LinkedList<String> ExP;
  public boolean ExQ;
  
  public afn()
  {
    AppMethodBeat.i(32203);
    this.ExP = new LinkedList();
    AppMethodBeat.o(32203);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32204);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ExD == null)
      {
        paramVarArgs = new b("Not all required fields were included: LoginUrl");
        AppMethodBeat.o(32204);
        throw paramVarArgs;
      }
      if (this.ExD != null) {
        paramVarArgs.d(1, this.ExD);
      }
      if (this.ExO != null) {
        paramVarArgs.d(2, this.ExO);
      }
      paramVarArgs.e(3, 1, this.ExP);
      paramVarArgs.bl(4, this.ExQ);
      AppMethodBeat.o(32204);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ExD == null) {
        break label436;
      }
    }
    label436:
    for (paramInt = f.a.a.b.b.a.e(1, this.ExD) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ExO != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.ExO);
      }
      paramInt = f.a.a.a.c(3, 1, this.ExP);
      int j = f.a.a.b.b.a.fK(4);
      AppMethodBeat.o(32204);
      return i + paramInt + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ExP.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.ExD == null)
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
        afn localafn = (afn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32204);
          return -1;
        case 1: 
          localafn.ExD = locala.LVo.readString();
          AppMethodBeat.o(32204);
          return 0;
        case 2: 
          localafn.ExO = locala.LVo.readString();
          AppMethodBeat.o(32204);
          return 0;
        case 3: 
          localafn.ExP.add(locala.LVo.readString());
          AppMethodBeat.o(32204);
          return 0;
        }
        localafn.ExQ = locala.LVo.fZX();
        AppMethodBeat.o(32204);
        return 0;
      }
      AppMethodBeat.o(32204);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afn
 * JD-Core Version:    0.7.0.1
 */