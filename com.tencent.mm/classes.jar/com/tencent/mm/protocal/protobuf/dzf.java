package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dzf
  extends com.tencent.mm.bx.a
{
  public String LxN;
  public long LxO;
  public LinkedList<String> LxP;
  
  public dzf()
  {
    AppMethodBeat.i(203863);
    this.LxP = new LinkedList();
    AppMethodBeat.o(203863);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(203864);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.LxN != null) {
        paramVarArgs.d(1, this.LxN);
      }
      paramVarArgs.aG(2, this.LxO);
      paramVarArgs.e(3, 1, this.LxP);
      AppMethodBeat.o(203864);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LxN == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.LxN) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.q(2, this.LxO);
      int j = f.a.a.a.c(3, 1, this.LxP);
      AppMethodBeat.o(203864);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LxP.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(203864);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dzf localdzf = (dzf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(203864);
          return -1;
        case 1: 
          localdzf.LxN = locala.KhF.readString();
          AppMethodBeat.o(203864);
          return 0;
        case 2: 
          localdzf.LxO = locala.KhF.xT();
          AppMethodBeat.o(203864);
          return 0;
        }
        localdzf.LxP.add(locala.KhF.readString());
        AppMethodBeat.o(203864);
        return 0;
      }
      AppMethodBeat.o(203864);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzf
 * JD-Core Version:    0.7.0.1
 */