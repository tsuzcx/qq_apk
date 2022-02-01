package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bna
  extends com.tencent.mm.bw.a
{
  public int Fck;
  public LinkedList<String> Fcl;
  public String scope;
  public String xoN;
  
  public bna()
  {
    AppMethodBeat.i(82449);
    this.Fcl = new LinkedList();
    AppMethodBeat.o(82449);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82450);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.scope != null) {
        paramVarArgs.d(1, this.scope);
      }
      paramVarArgs.aR(2, this.Fck);
      if (this.xoN != null) {
        paramVarArgs.d(3, this.xoN);
      }
      paramVarArgs.e(4, 1, this.Fcl);
      AppMethodBeat.o(82450);
      return 0;
    }
    if (paramInt == 1) {
      if (this.scope == null) {
        break label378;
      }
    }
    label378:
    for (paramInt = f.a.a.b.b.a.e(1, this.scope) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.Fck);
      paramInt = i;
      if (this.xoN != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.xoN);
      }
      i = f.a.a.a.c(4, 1, this.Fcl);
      AppMethodBeat.o(82450);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Fcl.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(82450);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bna localbna = (bna)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(82450);
          return -1;
        case 1: 
          localbna.scope = locala.LVo.readString();
          AppMethodBeat.o(82450);
          return 0;
        case 2: 
          localbna.Fck = locala.LVo.xF();
          AppMethodBeat.o(82450);
          return 0;
        case 3: 
          localbna.xoN = locala.LVo.readString();
          AppMethodBeat.o(82450);
          return 0;
        }
        localbna.Fcl.add(locala.LVo.readString());
        AppMethodBeat.o(82450);
        return 0;
      }
      AppMethodBeat.o(82450);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bna
 * JD-Core Version:    0.7.0.1
 */