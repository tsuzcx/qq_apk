package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class x
  extends cvw
{
  public String FIP;
  public int FIQ;
  public int FIR;
  public String FIS;
  public int limit;
  public int offset;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91336);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.limit);
      paramVarArgs.aS(3, this.offset);
      paramVarArgs.aS(4, this.type);
      if (this.FIP != null) {
        paramVarArgs.d(5, this.FIP);
      }
      paramVarArgs.aS(6, this.FIQ);
      paramVarArgs.aS(7, this.FIR);
      if (this.FIS != null) {
        paramVarArgs.d(8, this.FIS);
      }
      AppMethodBeat.o(91336);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label650;
      }
    }
    label650:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.limit) + f.a.a.b.b.a.bz(3, this.offset) + f.a.a.b.b.a.bz(4, this.type);
      paramInt = i;
      if (this.FIP != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FIP);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.FIQ) + f.a.a.b.b.a.bz(7, this.FIR);
      paramInt = i;
      if (this.FIS != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FIS);
      }
      AppMethodBeat.o(91336);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91336);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        x localx = (x)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91336);
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
            localx.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91336);
          return 0;
        case 2: 
          localx.limit = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91336);
          return 0;
        case 3: 
          localx.offset = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91336);
          return 0;
        case 4: 
          localx.type = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91336);
          return 0;
        case 5: 
          localx.FIP = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91336);
          return 0;
        case 6: 
          localx.FIQ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91336);
          return 0;
        case 7: 
          localx.FIR = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91336);
          return 0;
        }
        localx.FIS = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91336);
        return 0;
      }
      AppMethodBeat.o(91336);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.x
 * JD-Core Version:    0.7.0.1
 */