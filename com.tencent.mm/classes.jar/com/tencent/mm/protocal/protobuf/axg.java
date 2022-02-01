package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class axg
  extends cwj
{
  public int FJh;
  public int FJl;
  public String FJm;
  public dfd FJn;
  public int FJv;
  public hu tAK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32220);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32220);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.FJl);
      paramVarArgs.aS(3, this.FJv);
      if (this.FJm != null) {
        paramVarArgs.d(4, this.FJm);
      }
      if (this.FJn != null)
      {
        paramVarArgs.lJ(5, this.FJn.computeSize());
        this.FJn.writeFields(paramVarArgs);
      }
      if (this.tAK != null)
      {
        paramVarArgs.lJ(6, this.tAK.computeSize());
        this.tAK.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(7, this.FJh);
      AppMethodBeat.o(32220);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label875;
      }
    }
    label875:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.FJl) + f.a.a.b.b.a.bz(3, this.FJv);
      paramInt = i;
      if (this.FJm != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FJm);
      }
      i = paramInt;
      if (this.FJn != null) {
        i = paramInt + f.a.a.a.lI(5, this.FJn.computeSize());
      }
      paramInt = i;
      if (this.tAK != null) {
        paramInt = i + f.a.a.a.lI(6, this.tAK.computeSize());
      }
      i = f.a.a.b.b.a.bz(7, this.FJh);
      AppMethodBeat.o(32220);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32220);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32220);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        axg localaxg = (axg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32220);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaxg.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32220);
          return 0;
        case 2: 
          localaxg.FJl = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32220);
          return 0;
        case 3: 
          localaxg.FJv = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32220);
          return 0;
        case 4: 
          localaxg.FJm = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32220);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dfd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dfd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaxg.FJn = ((dfd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32220);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaxg.tAK = ((hu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32220);
          return 0;
        }
        localaxg.FJh = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(32220);
        return 0;
      }
      AppMethodBeat.o(32220);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axg
 * JD-Core Version:    0.7.0.1
 */