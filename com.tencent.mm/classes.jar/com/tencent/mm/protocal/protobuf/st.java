package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class st
  extends ckq
{
  public String CUC;
  public String CUD;
  public String CxW;
  public String CxX;
  public int tav;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91412);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CxW == null)
      {
        paramVarArgs = new b("Not all required fields were included: f2f_id");
        AppMethodBeat.o(91412);
        throw paramVarArgs;
      }
      if (this.CxX == null)
      {
        paramVarArgs = new b("Not all required fields were included: trans_id");
        AppMethodBeat.o(91412);
        throw paramVarArgs;
      }
      if (this.CUD == null)
      {
        paramVarArgs = new b("Not all required fields were included: receiver_open_id");
        AppMethodBeat.o(91412);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.CxW != null) {
        paramVarArgs.d(2, this.CxW);
      }
      if (this.CxX != null) {
        paramVarArgs.d(3, this.CxX);
      }
      if (this.CUC != null) {
        paramVarArgs.d(4, this.CUC);
      }
      if (this.CUD != null) {
        paramVarArgs.d(5, this.CUD);
      }
      paramVarArgs.aR(6, this.tav);
      AppMethodBeat.o(91412);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label742;
      }
    }
    label742:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CxW != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.CxW);
      }
      i = paramInt;
      if (this.CxX != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CxX);
      }
      paramInt = i;
      if (this.CUC != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.CUC);
      }
      i = paramInt;
      if (this.CUD != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.CUD);
      }
      paramInt = f.a.a.b.b.a.bA(6, this.tav);
      AppMethodBeat.o(91412);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.CxW == null)
        {
          paramVarArgs = new b("Not all required fields were included: f2f_id");
          AppMethodBeat.o(91412);
          throw paramVarArgs;
        }
        if (this.CxX == null)
        {
          paramVarArgs = new b("Not all required fields were included: trans_id");
          AppMethodBeat.o(91412);
          throw paramVarArgs;
        }
        if (this.CUD == null)
        {
          paramVarArgs = new b("Not all required fields were included: receiver_open_id");
          AppMethodBeat.o(91412);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91412);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        st localst = (st)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91412);
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
            localst.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91412);
          return 0;
        case 2: 
          localst.CxW = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91412);
          return 0;
        case 3: 
          localst.CxX = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91412);
          return 0;
        case 4: 
          localst.CUC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91412);
          return 0;
        case 5: 
          localst.CUD = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91412);
          return 0;
        }
        localst.tav = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(91412);
        return 0;
      }
      AppMethodBeat.o(91412);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.st
 * JD-Core Version:    0.7.0.1
 */