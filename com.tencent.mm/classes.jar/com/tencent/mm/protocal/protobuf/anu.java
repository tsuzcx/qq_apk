package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class anu
  extends cwj
{
  public LinkedList<FinderCommentInfo> GFB;
  public int GFC;
  public int GFD;
  public LinkedList<FinderCommentInfo> GFE;
  public int commentCount;
  public b lastBuffer;
  public FinderObject rSc;
  public int secondaryShowFlag;
  public int upContinueFlag;
  
  public anu()
  {
    AppMethodBeat.i(168974);
    this.GFB = new LinkedList();
    this.GFE = new LinkedList();
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
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.GFB);
      if (this.rSc != null)
      {
        paramVarArgs.lJ(3, this.rSc.computeSize());
        this.rSc.writeFields(paramVarArgs);
      }
      if (this.lastBuffer != null) {
        paramVarArgs.c(4, this.lastBuffer);
      }
      paramVarArgs.aS(5, this.commentCount);
      paramVarArgs.aS(6, this.upContinueFlag);
      paramVarArgs.aS(7, this.GFC);
      paramVarArgs.aS(8, this.GFD);
      paramVarArgs.aS(9, this.secondaryShowFlag);
      paramVarArgs.e(10, 8, this.GFE);
      AppMethodBeat.o(168975);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1046;
      }
    }
    label1046:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.GFB);
      paramInt = i;
      if (this.rSc != null) {
        paramInt = i + f.a.a.a.lI(3, this.rSc.computeSize());
      }
      i = paramInt;
      if (this.lastBuffer != null) {
        i = paramInt + f.a.a.b.b.a.b(4, this.lastBuffer);
      }
      paramInt = f.a.a.b.b.a.bz(5, this.commentCount);
      int j = f.a.a.b.b.a.bz(6, this.upContinueFlag);
      int k = f.a.a.b.b.a.bz(7, this.GFC);
      int m = f.a.a.b.b.a.bz(8, this.GFD);
      int n = f.a.a.b.b.a.bz(9, this.secondaryShowFlag);
      int i1 = f.a.a.a.c(10, 8, this.GFE);
      AppMethodBeat.o(168975);
      return i + paramInt + j + k + m + n + i1;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GFB.clear();
        this.GFE.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(168975);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        anu localanu = (anu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168975);
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
            localanu.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168975);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderCommentInfo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderCommentInfo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localanu.GFB.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168975);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderObject();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localanu.rSc = ((FinderObject)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168975);
          return 0;
        case 4: 
          localanu.lastBuffer = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(168975);
          return 0;
        case 5: 
          localanu.commentCount = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(168975);
          return 0;
        case 6: 
          localanu.upContinueFlag = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(168975);
          return 0;
        case 7: 
          localanu.GFC = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(168975);
          return 0;
        case 8: 
          localanu.GFD = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(168975);
          return 0;
        case 9: 
          localanu.secondaryShowFlag = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(168975);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new FinderCommentInfo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((FinderCommentInfo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localanu.GFE.add(localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.anu
 * JD-Core Version:    0.7.0.1
 */