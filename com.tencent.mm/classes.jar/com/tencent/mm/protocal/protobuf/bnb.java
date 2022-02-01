package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bnb
  extends ckq
{
  public String DKu;
  public String lang;
  public int limit;
  public int offset;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152624);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.offset);
      paramVarArgs.aR(3, this.limit);
      if (this.lang != null) {
        paramVarArgs.d(4, this.lang);
      }
      if (this.DKu != null) {
        paramVarArgs.d(5, this.DKu);
      }
      AppMethodBeat.o(152624);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label518;
      }
    }
    label518:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.offset) + f.a.a.b.b.a.bA(3, this.limit);
      paramInt = i;
      if (this.lang != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.lang);
      }
      i = paramInt;
      if (this.DKu != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.DKu);
      }
      AppMethodBeat.o(152624);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(152624);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bnb localbnb = (bnb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152624);
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
            localbnb.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152624);
          return 0;
        case 2: 
          localbnb.offset = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152624);
          return 0;
        case 3: 
          localbnb.limit = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152624);
          return 0;
        case 4: 
          localbnb.lang = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152624);
          return 0;
        }
        localbnb.DKu = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(152624);
        return 0;
      }
      AppMethodBeat.o(152624);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnb
 * JD-Core Version:    0.7.0.1
 */