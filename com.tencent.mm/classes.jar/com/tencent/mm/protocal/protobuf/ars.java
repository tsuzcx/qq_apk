package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class ars
  extends dpc
{
  public LinkedList<FinderCommentInfo> LDe;
  public int LDf;
  public int LDg;
  public LinkedList<FinderCommentInfo> LDh;
  public LinkedList<FinderObject> LDi;
  public int commentCount;
  public FinderObject feedObject;
  public b lastBuffer;
  public int secondaryShowFlag;
  public int upContinueFlag;
  
  public ars()
  {
    AppMethodBeat.i(168974);
    this.LDe = new LinkedList();
    this.LDh = new LinkedList();
    this.LDi = new LinkedList();
    AppMethodBeat.o(168974);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168975);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.LDe);
      if (this.feedObject != null)
      {
        paramVarArgs.ni(3, this.feedObject.computeSize());
        this.feedObject.writeFields(paramVarArgs);
      }
      if (this.lastBuffer != null) {
        paramVarArgs.c(4, this.lastBuffer);
      }
      paramVarArgs.aM(5, this.commentCount);
      paramVarArgs.aM(6, this.upContinueFlag);
      paramVarArgs.aM(7, this.LDf);
      paramVarArgs.aM(8, this.LDg);
      paramVarArgs.aM(9, this.secondaryShowFlag);
      paramVarArgs.e(10, 8, this.LDh);
      paramVarArgs.e(11, 8, this.LDi);
      AppMethodBeat.o(168975);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1186;
      }
    }
    label1186:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.LDe);
      paramInt = i;
      if (this.feedObject != null) {
        paramInt = i + g.a.a.a.nh(3, this.feedObject.computeSize());
      }
      i = paramInt;
      if (this.lastBuffer != null) {
        i = paramInt + g.a.a.b.b.a.b(4, this.lastBuffer);
      }
      paramInt = g.a.a.b.b.a.bu(5, this.commentCount);
      int j = g.a.a.b.b.a.bu(6, this.upContinueFlag);
      int k = g.a.a.b.b.a.bu(7, this.LDf);
      int m = g.a.a.b.b.a.bu(8, this.LDg);
      int n = g.a.a.b.b.a.bu(9, this.secondaryShowFlag);
      int i1 = g.a.a.a.c(10, 8, this.LDh);
      int i2 = g.a.a.a.c(11, 8, this.LDi);
      AppMethodBeat.o(168975);
      return i + paramInt + j + k + m + n + i1 + i2;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LDe.clear();
        this.LDh.clear();
        this.LDi.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(168975);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ars localars = (ars)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168975);
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
            localars.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168975);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderCommentInfo();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderCommentInfo)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localars.LDe.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168975);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderObject();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localars.feedObject = ((FinderObject)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168975);
          return 0;
        case 4: 
          localars.lastBuffer = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(168975);
          return 0;
        case 5: 
          localars.commentCount = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168975);
          return 0;
        case 6: 
          localars.upContinueFlag = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168975);
          return 0;
        case 7: 
          localars.LDf = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168975);
          return 0;
        case 8: 
          localars.LDg = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168975);
          return 0;
        case 9: 
          localars.secondaryShowFlag = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168975);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderCommentInfo();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderCommentInfo)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localars.LDh.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168975);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new FinderObject();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localars.LDi.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(168975);
        return 0;
      }
      AppMethodBeat.o(168975);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ars
 * JD-Core Version:    0.7.0.1
 */