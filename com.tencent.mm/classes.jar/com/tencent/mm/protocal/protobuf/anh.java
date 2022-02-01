package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class anh
  extends cvp
{
  public LinkedList<FinderCommentInfo> Gmt;
  public int Gmu;
  public int Gmv;
  public LinkedList<FinderCommentInfo> Gmw;
  public int commentCount;
  public b lastBuffer;
  public FinderObject rJO;
  public int secondaryShowFlag;
  public int upContinueFlag;
  
  public anh()
  {
    AppMethodBeat.i(168974);
    this.Gmt = new LinkedList();
    this.Gmw = new LinkedList();
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
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.Gmt);
      if (this.rJO != null)
      {
        paramVarArgs.lC(3, this.rJO.computeSize());
        this.rJO.writeFields(paramVarArgs);
      }
      if (this.lastBuffer != null) {
        paramVarArgs.c(4, this.lastBuffer);
      }
      paramVarArgs.aS(5, this.commentCount);
      paramVarArgs.aS(6, this.upContinueFlag);
      paramVarArgs.aS(7, this.Gmu);
      paramVarArgs.aS(8, this.Gmv);
      paramVarArgs.aS(9, this.secondaryShowFlag);
      paramVarArgs.e(10, 8, this.Gmw);
      AppMethodBeat.o(168975);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1046;
      }
    }
    label1046:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.Gmt);
      paramInt = i;
      if (this.rJO != null) {
        paramInt = i + f.a.a.a.lB(3, this.rJO.computeSize());
      }
      i = paramInt;
      if (this.lastBuffer != null) {
        i = paramInt + f.a.a.b.b.a.b(4, this.lastBuffer);
      }
      paramInt = f.a.a.b.b.a.bz(5, this.commentCount);
      int j = f.a.a.b.b.a.bz(6, this.upContinueFlag);
      int k = f.a.a.b.b.a.bz(7, this.Gmu);
      int m = f.a.a.b.b.a.bz(8, this.Gmv);
      int n = f.a.a.b.b.a.bz(9, this.secondaryShowFlag);
      int i1 = f.a.a.a.c(10, 8, this.Gmw);
      AppMethodBeat.o(168975);
      return i + paramInt + j + k + m + n + i1;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Gmt.clear();
        this.Gmw.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(168975);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        anh localanh = (anh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168975);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localanh.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168975);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderCommentInfo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderCommentInfo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localanh.Gmt.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168975);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderObject();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localanh.rJO = ((FinderObject)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168975);
          return 0;
        case 4: 
          localanh.lastBuffer = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(168975);
          return 0;
        case 5: 
          localanh.commentCount = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(168975);
          return 0;
        case 6: 
          localanh.upContinueFlag = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(168975);
          return 0;
        case 7: 
          localanh.Gmu = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(168975);
          return 0;
        case 8: 
          localanh.Gmv = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(168975);
          return 0;
        case 9: 
          localanh.secondaryShowFlag = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(168975);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new FinderCommentInfo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((FinderCommentInfo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localanh.Gmw.add(localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.anh
 * JD-Core Version:    0.7.0.1
 */