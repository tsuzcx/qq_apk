package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bji
  extends com.tencent.mm.bx.a
{
  public int DGQ;
  public LinkedList<String> DGR;
  public String scope;
  public String wdz;
  
  public bji()
  {
    AppMethodBeat.i(82449);
    this.DGR = new LinkedList();
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
      paramVarArgs.aR(2, this.DGQ);
      if (this.wdz != null) {
        paramVarArgs.d(3, this.wdz);
      }
      paramVarArgs.e(4, 1, this.DGR);
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
      int i = paramInt + f.a.a.b.b.a.bA(2, this.DGQ);
      paramInt = i;
      if (this.wdz != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.wdz);
      }
      i = f.a.a.a.c(4, 1, this.DGR);
      AppMethodBeat.o(82450);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DGR.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(82450);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bji localbji = (bji)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(82450);
          return -1;
        case 1: 
          localbji.scope = locala.KhF.readString();
          AppMethodBeat.o(82450);
          return 0;
        case 2: 
          localbji.DGQ = locala.KhF.xS();
          AppMethodBeat.o(82450);
          return 0;
        case 3: 
          localbji.wdz = locala.KhF.readString();
          AppMethodBeat.o(82450);
          return 0;
        }
        localbji.DGR.add(locala.KhF.readString());
        AppMethodBeat.o(82450);
        return 0;
      }
      AppMethodBeat.o(82450);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bji
 * JD-Core Version:    0.7.0.1
 */