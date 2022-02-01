package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class dup
  extends ckq
{
  public b CIu;
  public String DII;
  public String EJa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123696);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.DII != null) {
        paramVarArgs.d(2, this.DII);
      }
      if (this.CIu != null) {
        paramVarArgs.c(3, this.CIu);
      }
      if (this.EJa != null) {
        paramVarArgs.d(4, this.EJa);
      }
      AppMethodBeat.o(123696);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label490;
      }
    }
    label490:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DII != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DII);
      }
      i = paramInt;
      if (this.CIu != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.CIu);
      }
      paramInt = i;
      if (this.EJa != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EJa);
      }
      AppMethodBeat.o(123696);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(123696);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dup localdup = (dup)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123696);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdup.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123696);
          return 0;
        case 2: 
          localdup.DII = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123696);
          return 0;
        case 3: 
          localdup.CIu = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(123696);
          return 0;
        }
        localdup.EJa = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(123696);
        return 0;
      }
      AppMethodBeat.o(123696);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dup
 * JD-Core Version:    0.7.0.1
 */