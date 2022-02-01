package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class aiw
  extends cld
{
  public LinkedList<FinderCommentInfo> Dlm;
  public int Dln;
  public int Dlo;
  public int commentCount;
  public b lastBuffer;
  public FinderObject qps;
  public int secondaryShowFlag;
  public int upContinueFlag;
  
  public aiw()
  {
    AppMethodBeat.i(168974);
    this.Dlm = new LinkedList();
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
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.Dlm);
      if (this.qps != null)
      {
        paramVarArgs.kX(3, this.qps.computeSize());
        this.qps.writeFields(paramVarArgs);
      }
      if (this.lastBuffer != null) {
        paramVarArgs.c(4, this.lastBuffer);
      }
      paramVarArgs.aR(5, this.commentCount);
      paramVarArgs.aR(6, this.upContinueFlag);
      paramVarArgs.aR(7, this.Dln);
      paramVarArgs.aR(8, this.Dlo);
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
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.Dlm);
      paramInt = i;
      if (this.qps != null) {
        paramInt = i + f.a.a.a.kW(3, this.qps.computeSize());
      }
      i = paramInt;
      if (this.lastBuffer != null) {
        i = paramInt + f.a.a.b.b.a.b(4, this.lastBuffer);
      }
      paramInt = f.a.a.b.b.a.bA(5, this.commentCount);
      int j = f.a.a.b.b.a.bA(6, this.upContinueFlag);
      int k = f.a.a.b.b.a.bA(7, this.Dln);
      int m = f.a.a.b.b.a.bA(8, this.Dlo);
      int n = f.a.a.b.b.a.bA(9, this.secondaryShowFlag);
      AppMethodBeat.o(168975);
      return i + paramInt + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Dlm.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(168975);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aiw localaiw = (aiw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168975);
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
            localaiw.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168975);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderCommentInfo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderCommentInfo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaiw.Dlm.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168975);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderObject();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaiw.qps = ((FinderObject)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168975);
          return 0;
        case 4: 
          localaiw.lastBuffer = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(168975);
          return 0;
        case 5: 
          localaiw.commentCount = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(168975);
          return 0;
        case 6: 
          localaiw.upContinueFlag = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(168975);
          return 0;
        case 7: 
          localaiw.Dln = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(168975);
          return 0;
        case 8: 
          localaiw.Dlo = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(168975);
          return 0;
        }
        localaiw.secondaryShowFlag = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(168975);
        return 0;
      }
      AppMethodBeat.o(168975);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aiw
 * JD-Core Version:    0.7.0.1
 */