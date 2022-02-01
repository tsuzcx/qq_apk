package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class va
  extends cvw
{
  public String FOf;
  public String FOg;
  public String GmU;
  public String GmV;
  public int vxx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91412);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FOf == null)
      {
        paramVarArgs = new b("Not all required fields were included: f2f_id");
        AppMethodBeat.o(91412);
        throw paramVarArgs;
      }
      if (this.FOg == null)
      {
        paramVarArgs = new b("Not all required fields were included: trans_id");
        AppMethodBeat.o(91412);
        throw paramVarArgs;
      }
      if (this.GmV == null)
      {
        paramVarArgs = new b("Not all required fields were included: receiver_open_id");
        AppMethodBeat.o(91412);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FOf != null) {
        paramVarArgs.d(2, this.FOf);
      }
      if (this.FOg != null) {
        paramVarArgs.d(3, this.FOg);
      }
      if (this.GmU != null) {
        paramVarArgs.d(4, this.GmU);
      }
      if (this.GmV != null) {
        paramVarArgs.d(5, this.GmV);
      }
      paramVarArgs.aS(6, this.vxx);
      AppMethodBeat.o(91412);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label742;
      }
    }
    label742:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FOf != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FOf);
      }
      i = paramInt;
      if (this.FOg != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FOg);
      }
      paramInt = i;
      if (this.GmU != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GmU);
      }
      i = paramInt;
      if (this.GmV != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GmV);
      }
      paramInt = f.a.a.b.b.a.bz(6, this.vxx);
      AppMethodBeat.o(91412);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.FOf == null)
        {
          paramVarArgs = new b("Not all required fields were included: f2f_id");
          AppMethodBeat.o(91412);
          throw paramVarArgs;
        }
        if (this.FOg == null)
        {
          paramVarArgs = new b("Not all required fields were included: trans_id");
          AppMethodBeat.o(91412);
          throw paramVarArgs;
        }
        if (this.GmV == null)
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
        va localva = (va)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91412);
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
            localva.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91412);
          return 0;
        case 2: 
          localva.FOf = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91412);
          return 0;
        case 3: 
          localva.FOg = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91412);
          return 0;
        case 4: 
          localva.GmU = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91412);
          return 0;
        case 5: 
          localva.GmV = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91412);
          return 0;
        }
        localva.vxx = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91412);
        return 0;
      }
      AppMethodBeat.o(91412);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.va
 * JD-Core Version:    0.7.0.1
 */