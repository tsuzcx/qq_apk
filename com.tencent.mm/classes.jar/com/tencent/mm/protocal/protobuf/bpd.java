package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bpd
  extends com.tencent.mm.bx.a
{
  public String ZXM;
  public long ZXN;
  public LinkedList<String> ZXO;
  
  public bpd()
  {
    AppMethodBeat.i(258088);
    this.ZXO = new LinkedList();
    AppMethodBeat.o(258088);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258093);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZXM != null) {
        paramVarArgs.g(1, this.ZXM);
      }
      paramVarArgs.bv(2, this.ZXN);
      paramVarArgs.e(3, 1, this.ZXO);
      AppMethodBeat.o(258093);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZXM == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = i.a.a.b.b.a.h(1, this.ZXM) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.q(2, this.ZXN);
      int j = i.a.a.a.c(3, 1, this.ZXO);
      AppMethodBeat.o(258093);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZXO.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258093);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        bpd localbpd = (bpd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258093);
          return -1;
        case 1: 
          localbpd.ZXM = locala.ajGk.readString();
          AppMethodBeat.o(258093);
          return 0;
        case 2: 
          localbpd.ZXN = locala.ajGk.aaw();
          AppMethodBeat.o(258093);
          return 0;
        }
        localbpd.ZXO.add(locala.ajGk.readString());
        AppMethodBeat.o(258093);
        return 0;
      }
      AppMethodBeat.o(258093);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpd
 * JD-Core Version:    0.7.0.1
 */