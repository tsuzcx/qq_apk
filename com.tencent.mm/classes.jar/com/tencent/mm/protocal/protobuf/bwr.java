package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bwr
  extends com.tencent.mm.bx.a
{
  public LinkedList<bwq> aafH;
  public String aafI;
  
  public bwr()
  {
    AppMethodBeat.i(258536);
    this.aafH = new LinkedList();
    AppMethodBeat.o(258536);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258539);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.aafH);
      if (this.aafI != null) {
        paramVarArgs.g(2, this.aafI);
      }
      AppMethodBeat.o(258539);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 8, this.aafH) + 0;
      paramInt = i;
      if (this.aafI != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aafI);
      }
      AppMethodBeat.o(258539);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.aafH.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258539);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      bwr localbwr = (bwr)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(258539);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          bwq localbwq = new bwq();
          if ((localObject != null) && (localObject.length > 0)) {
            localbwq.parseFrom((byte[])localObject);
          }
          localbwr.aafH.add(localbwq);
          paramInt += 1;
        }
        AppMethodBeat.o(258539);
        return 0;
      }
      localbwr.aafI = ((i.a.a.a.a)localObject).ajGk.readString();
      AppMethodBeat.o(258539);
      return 0;
    }
    AppMethodBeat.o(258539);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwr
 * JD-Core Version:    0.7.0.1
 */