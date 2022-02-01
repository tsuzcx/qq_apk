package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class bij
  extends dyy
{
  public LinkedList<asn> SGG;
  public int continueFlag;
  public b xHE;
  
  public bij()
  {
    AppMethodBeat.i(208627);
    this.SGG = new LinkedList();
    AppMethodBeat.o(208627);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(208630);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.continueFlag);
      if (this.xHE != null) {
        paramVarArgs.c(3, this.xHE);
      }
      paramVarArgs.e(4, 8, this.SGG);
      AppMethodBeat.o(208630);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label510;
      }
    }
    label510:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.continueFlag);
      paramInt = i;
      if (this.xHE != null) {
        paramInt = i + g.a.a.b.b.a.b(3, this.xHE);
      }
      i = g.a.a.a.c(4, 8, this.SGG);
      AppMethodBeat.o(208630);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SGG.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(208630);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bij localbij = (bij)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(208630);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localbij.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(208630);
          return 0;
        case 2: 
          localbij.continueFlag = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(208630);
          return 0;
        case 3: 
          localbij.xHE = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(208630);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new asn();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((asn)localObject2).parseFrom((byte[])localObject1);
          }
          localbij.SGG.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(208630);
        return 0;
      }
      AppMethodBeat.o(208630);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bij
 * JD-Core Version:    0.7.0.1
 */