package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class aki
  extends cqk
{
  public LinkedList<FinderCommentInfo> EEC;
  public int EED;
  public int EEE;
  public int commentCount;
  public b lastBuffer;
  public FinderObject qYy;
  public int secondaryShowFlag;
  public int upContinueFlag;
  
  public aki()
  {
    AppMethodBeat.i(168974);
    this.EEC = new LinkedList();
    AppMethodBeat.o(168974);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168975);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.EEC);
      if (this.qYy != null)
      {
        paramVarArgs.ln(3, this.qYy.computeSize());
        this.qYy.writeFields(paramVarArgs);
      }
      if (this.lastBuffer != null) {
        paramVarArgs.c(4, this.lastBuffer);
      }
      paramVarArgs.aR(5, this.commentCount);
      paramVarArgs.aR(6, this.upContinueFlag);
      paramVarArgs.aR(7, this.EED);
      paramVarArgs.aR(8, this.EEE);
      paramVarArgs.aR(9, this.secondaryShowFlag);
      AppMethodBeat.o(168975);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label902;
      }
    }
    label902:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.EEC);
      paramInt = i;
      if (this.qYy != null) {
        paramInt = i + f.a.a.a.lm(3, this.qYy.computeSize());
      }
      i = paramInt;
      if (this.lastBuffer != null) {
        i = paramInt + f.a.a.b.b.a.b(4, this.lastBuffer);
      }
      paramInt = f.a.a.b.b.a.bx(5, this.commentCount);
      int j = f.a.a.b.b.a.bx(6, this.upContinueFlag);
      int k = f.a.a.b.b.a.bx(7, this.EED);
      int m = f.a.a.b.b.a.bx(8, this.EEE);
      int n = f.a.a.b.b.a.bx(9, this.secondaryShowFlag);
      AppMethodBeat.o(168975);
      return i + paramInt + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EEC.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(168975);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aki localaki = (aki)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168975);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaki.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168975);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderCommentInfo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderCommentInfo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaki.EEC.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168975);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderObject();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaki.qYy = ((FinderObject)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168975);
          return 0;
        case 4: 
          localaki.lastBuffer = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(168975);
          return 0;
        case 5: 
          localaki.commentCount = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(168975);
          return 0;
        case 6: 
          localaki.upContinueFlag = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(168975);
          return 0;
        case 7: 
          localaki.EED = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(168975);
          return 0;
        case 8: 
          localaki.EEE = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(168975);
          return 0;
        }
        localaki.secondaryShowFlag = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(168975);
        return 0;
      }
      AppMethodBeat.o(168975);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aki
 * JD-Core Version:    0.7.0.1
 */