package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class ary
  extends dpc
{
  public long Gcy;
  public LinkedList<FinderContact> LCI;
  public LinkedList<aqr> LDp;
  public int continueFlag;
  public b tVM;
  
  public ary()
  {
    AppMethodBeat.i(168977);
    this.LCI = new LinkedList();
    this.LDp = new LinkedList();
    AppMethodBeat.o(168977);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168978);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.LCI);
      paramVarArgs.aM(3, this.continueFlag);
      paramVarArgs.bb(4, this.Gcy);
      if (this.tVM != null) {
        paramVarArgs.c(5, this.tVM);
      }
      paramVarArgs.e(6, 8, this.LDp);
      AppMethodBeat.o(168978);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label738;
      }
    }
    label738:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.LCI) + g.a.a.b.b.a.bu(3, this.continueFlag) + g.a.a.b.b.a.r(4, this.Gcy);
      paramInt = i;
      if (this.tVM != null) {
        paramInt = i + g.a.a.b.b.a.b(5, this.tVM);
      }
      i = g.a.a.a.c(6, 8, this.LDp);
      AppMethodBeat.o(168978);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LCI.clear();
        this.LDp.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(168978);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ary localary = (ary)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168978);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localary.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168978);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderContact();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localary.LCI.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168978);
          return 0;
        case 3: 
          localary.continueFlag = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168978);
          return 0;
        case 4: 
          localary.Gcy = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(168978);
          return 0;
        case 5: 
          localary.tVM = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(168978);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aqr();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aqr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localary.LDp.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(168978);
        return 0;
      }
      AppMethodBeat.o(168978);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ary
 * JD-Core Version:    0.7.0.1
 */