package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aly
  extends com.tencent.mm.bw.a
{
  public LinkedList<String> EFA;
  public String EFy;
  public long EFz;
  
  public aly()
  {
    AppMethodBeat.i(195091);
    this.EFA = new LinkedList();
    AppMethodBeat.o(195091);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195092);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EFy != null) {
        paramVarArgs.d(1, this.EFy);
      }
      paramVarArgs.aO(2, this.EFz);
      paramVarArgs.e(3, 1, this.EFA);
      AppMethodBeat.o(195092);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EFy == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.EFy) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.p(2, this.EFz);
      int j = f.a.a.a.c(3, 1, this.EFA);
      AppMethodBeat.o(195092);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EFA.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(195092);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        aly localaly = (aly)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(195092);
          return -1;
        case 1: 
          localaly.EFy = locala.LVo.readString();
          AppMethodBeat.o(195092);
          return 0;
        case 2: 
          localaly.EFz = locala.LVo.xG();
          AppMethodBeat.o(195092);
          return 0;
        }
        localaly.EFA.add(locala.LVo.readString());
        AppMethodBeat.o(195092);
        return 0;
      }
      AppMethodBeat.o(195092);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aly
 * JD-Core Version:    0.7.0.1
 */