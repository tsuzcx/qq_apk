package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bci
  extends cvw
{
  public String GSe;
  public String GSf;
  public String ikm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125730);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ikm != null) {
        paramVarArgs.d(2, this.ikm);
      }
      if (this.GSe != null) {
        paramVarArgs.d(3, this.GSe);
      }
      if (this.GSf != null) {
        paramVarArgs.d(4, this.GSf);
      }
      AppMethodBeat.o(125730);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label490;
      }
    }
    label490:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ikm != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ikm);
      }
      i = paramInt;
      if (this.GSe != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GSe);
      }
      paramInt = i;
      if (this.GSf != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GSf);
      }
      AppMethodBeat.o(125730);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(125730);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bci localbci = (bci)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125730);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbci.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125730);
          return 0;
        case 2: 
          localbci.ikm = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125730);
          return 0;
        case 3: 
          localbci.GSe = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125730);
          return 0;
        }
        localbci.GSf = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(125730);
        return 0;
      }
      AppMethodBeat.o(125730);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bci
 * JD-Core Version:    0.7.0.1
 */