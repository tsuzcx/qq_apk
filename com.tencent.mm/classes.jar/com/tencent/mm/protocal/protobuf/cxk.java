package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cxk
  extends com.tencent.mm.bx.a
{
  public bim ZOR;
  public int ZnA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259663);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZOR != null)
      {
        paramVarArgs.qD(1, this.ZOR.computeSize());
        this.ZOR.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.ZnA);
      AppMethodBeat.o(259663);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZOR == null) {
        break label328;
      }
    }
    label328:
    for (paramInt = i.a.a.a.qC(1, this.ZOR.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.ZnA);
      AppMethodBeat.o(259663);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259663);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cxk localcxk = (cxk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259663);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            bim localbim = new bim();
            if ((localObject != null) && (localObject.length > 0)) {
              localbim.parseFrom((byte[])localObject);
            }
            localcxk.ZOR = localbim;
            paramInt += 1;
          }
          AppMethodBeat.o(259663);
          return 0;
        }
        localcxk.ZnA = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259663);
        return 0;
      }
      AppMethodBeat.o(259663);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxk
 * JD-Core Version:    0.7.0.1
 */