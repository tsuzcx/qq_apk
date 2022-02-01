package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ead
  extends cld
{
  public boolean DZy;
  public com.tencent.mm.bx.b LyM;
  public LinkedList<eat> LyO;
  public int LyP;
  public LinkedList<String> LyQ;
  public int LyR;
  public ear LyS;
  
  public ead()
  {
    AppMethodBeat.i(202495);
    this.LyO = new LinkedList();
    this.LyQ = new LinkedList();
    AppMethodBeat.o(202495);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(202496);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(202496);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.LyO);
      if (this.LyM != null) {
        paramVarArgs.c(3, this.LyM);
      }
      paramVarArgs.aR(4, this.LyP);
      paramVarArgs.e(5, 1, this.LyQ);
      paramVarArgs.aR(6, this.LyR);
      paramVarArgs.bg(7, this.DZy);
      if (this.LyS != null)
      {
        paramVarArgs.kX(8, this.LyS.computeSize());
        this.LyS.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(202496);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label902;
      }
    }
    label902:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.LyO);
      paramInt = i;
      if (this.LyM != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.LyM);
      }
      i = paramInt + f.a.a.b.b.a.bA(4, this.LyP) + f.a.a.a.c(5, 1, this.LyQ) + f.a.a.b.b.a.bA(6, this.LyR) + (f.a.a.b.b.a.fY(7) + 1);
      paramInt = i;
      if (this.LyS != null) {
        paramInt = i + f.a.a.a.kW(8, this.LyS.computeSize());
      }
      AppMethodBeat.o(202496);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LyO.clear();
        this.LyQ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(202496);
          throw paramVarArgs;
        }
        AppMethodBeat.o(202496);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ead localead = (ead)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(202496);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localead.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(202496);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eat();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eat)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localead.LyO.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(202496);
          return 0;
        case 3: 
          localead.LyM = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(202496);
          return 0;
        case 4: 
          localead.LyP = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(202496);
          return 0;
        case 5: 
          localead.LyQ.add(((f.a.a.a.a)localObject1).KhF.readString());
          AppMethodBeat.o(202496);
          return 0;
        case 6: 
          localead.LyR = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(202496);
          return 0;
        case 7: 
          localead.DZy = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(202496);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ear();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ear)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localead.LyS = ((ear)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(202496);
        return 0;
      }
      AppMethodBeat.o(202496);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ead
 * JD-Core Version:    0.7.0.1
 */