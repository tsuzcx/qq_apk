package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bse
  extends com.tencent.mm.bw.a
{
  public int Hfl;
  public LinkedList<String> Hfm;
  public String scope;
  public String yTx;
  
  public bse()
  {
    AppMethodBeat.i(82449);
    this.Hfm = new LinkedList();
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
      paramVarArgs.aS(2, this.Hfl);
      if (this.yTx != null) {
        paramVarArgs.d(3, this.yTx);
      }
      paramVarArgs.e(4, 1, this.Hfm);
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
      int i = paramInt + f.a.a.b.b.a.bz(2, this.Hfl);
      paramInt = i;
      if (this.yTx != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.yTx);
      }
      i = f.a.a.a.c(4, 1, this.Hfm);
      AppMethodBeat.o(82450);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Hfm.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(82450);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bse localbse = (bse)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(82450);
          return -1;
        case 1: 
          localbse.scope = locala.OmT.readString();
          AppMethodBeat.o(82450);
          return 0;
        case 2: 
          localbse.Hfl = locala.OmT.zc();
          AppMethodBeat.o(82450);
          return 0;
        case 3: 
          localbse.yTx = locala.OmT.readString();
          AppMethodBeat.o(82450);
          return 0;
        }
        localbse.Hfm.add(locala.OmT.readString());
        AppMethodBeat.o(82450);
        return 0;
      }
      AppMethodBeat.o(82450);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bse
 * JD-Core Version:    0.7.0.1
 */