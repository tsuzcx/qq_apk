package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class qm
  extends com.tencent.mm.bw.a
{
  public String EhM;
  public LinkedList<String> EhN;
  
  public qm()
  {
    AppMethodBeat.i(72427);
    this.EhN = new LinkedList();
    AppMethodBeat.o(72427);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72428);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EhM != null) {
        paramVarArgs.d(1, this.EhM);
      }
      paramVarArgs.e(2, 1, this.EhN);
      AppMethodBeat.o(72428);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EhM == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.EhM) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 1, this.EhN);
      AppMethodBeat.o(72428);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EhN.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(72428);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        qm localqm = (qm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72428);
          return -1;
        case 1: 
          localqm.EhM = locala.LVo.readString();
          AppMethodBeat.o(72428);
          return 0;
        }
        localqm.EhN.add(locala.LVo.readString());
        AppMethodBeat.o(72428);
        return 0;
      }
      AppMethodBeat.o(72428);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qm
 * JD-Core Version:    0.7.0.1
 */