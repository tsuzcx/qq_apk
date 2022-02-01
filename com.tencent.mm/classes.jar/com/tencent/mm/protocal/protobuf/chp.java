package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class chp
  extends cwj
{
  public String HtK;
  public chs HtO;
  public LinkedList<chp> HtP;
  public int HtQ;
  public String type;
  public String wTE;
  
  public chp()
  {
    AppMethodBeat.i(117539);
    this.HtP = new LinkedList();
    AppMethodBeat.o(117539);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117540);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.HtO != null)
      {
        paramVarArgs.lJ(2, this.HtO.computeSize());
        this.HtO.writeFields(paramVarArgs);
      }
      if (this.HtK != null) {
        paramVarArgs.d(3, this.HtK);
      }
      if (this.wTE != null) {
        paramVarArgs.d(4, this.wTE);
      }
      if (this.type != null) {
        paramVarArgs.d(5, this.type);
      }
      paramVarArgs.e(6, 8, this.HtP);
      paramVarArgs.aS(7, this.HtQ);
      AppMethodBeat.o(117540);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label834;
      }
    }
    label834:
    for (int i = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HtO != null) {
        paramInt = i + f.a.a.a.lI(2, this.HtO.computeSize());
      }
      i = paramInt;
      if (this.HtK != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HtK);
      }
      paramInt = i;
      if (this.wTE != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.wTE);
      }
      i = paramInt;
      if (this.type != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.type);
      }
      paramInt = f.a.a.a.c(6, 8, this.HtP);
      int j = f.a.a.b.b.a.bz(7, this.HtQ);
      AppMethodBeat.o(117540);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HtP.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(117540);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        chp localchp = (chp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117540);
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
            localchp.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117540);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new chs();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((chs)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localchp.HtO = ((chs)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117540);
          return 0;
        case 3: 
          localchp.HtK = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(117540);
          return 0;
        case 4: 
          localchp.wTE = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(117540);
          return 0;
        case 5: 
          localchp.type = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(117540);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new chp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((chp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localchp.HtP.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117540);
          return 0;
        }
        localchp.HtQ = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(117540);
        return 0;
      }
      AppMethodBeat.o(117540);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chp
 * JD-Core Version:    0.7.0.1
 */