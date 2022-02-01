package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class att
  extends dyy
{
  public int SGA;
  public LinkedList<FinderCommentInfo> SGB;
  public LinkedList<FinderObject> SGC;
  public LinkedList<FinderCommentInfo> SGy;
  public int SGz;
  public int commentCount;
  public FinderObject feedObject;
  public b lastBuffer;
  public int secondaryShowFlag;
  public int upContinueFlag;
  
  public att()
  {
    AppMethodBeat.i(168974);
    this.SGy = new LinkedList();
    this.SGB = new LinkedList();
    this.SGC = new LinkedList();
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
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.SGy);
      if (this.feedObject != null)
      {
        paramVarArgs.oE(3, this.feedObject.computeSize());
        this.feedObject.writeFields(paramVarArgs);
      }
      if (this.lastBuffer != null) {
        paramVarArgs.c(4, this.lastBuffer);
      }
      paramVarArgs.aY(5, this.commentCount);
      paramVarArgs.aY(6, this.upContinueFlag);
      paramVarArgs.aY(7, this.SGz);
      paramVarArgs.aY(8, this.SGA);
      paramVarArgs.aY(9, this.secondaryShowFlag);
      paramVarArgs.e(10, 8, this.SGB);
      paramVarArgs.e(11, 8, this.SGC);
      AppMethodBeat.o(168975);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1076;
      }
    }
    label1076:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.SGy);
      paramInt = i;
      if (this.feedObject != null) {
        paramInt = i + g.a.a.a.oD(3, this.feedObject.computeSize());
      }
      i = paramInt;
      if (this.lastBuffer != null) {
        i = paramInt + g.a.a.b.b.a.b(4, this.lastBuffer);
      }
      paramInt = g.a.a.b.b.a.bM(5, this.commentCount);
      int j = g.a.a.b.b.a.bM(6, this.upContinueFlag);
      int k = g.a.a.b.b.a.bM(7, this.SGz);
      int m = g.a.a.b.b.a.bM(8, this.SGA);
      int n = g.a.a.b.b.a.bM(9, this.secondaryShowFlag);
      int i1 = g.a.a.a.c(10, 8, this.SGB);
      int i2 = g.a.a.a.c(11, 8, this.SGC);
      AppMethodBeat.o(168975);
      return i + paramInt + j + k + m + n + i1 + i2;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SGy.clear();
        this.SGB.clear();
        this.SGC.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(168975);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        att localatt = (att)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168975);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localatt.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168975);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderCommentInfo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderCommentInfo)localObject2).parseFrom((byte[])localObject1);
            }
            localatt.SGy.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168975);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderObject();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderObject)localObject2).parseFrom((byte[])localObject1);
            }
            localatt.feedObject = ((FinderObject)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168975);
          return 0;
        case 4: 
          localatt.lastBuffer = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(168975);
          return 0;
        case 5: 
          localatt.commentCount = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168975);
          return 0;
        case 6: 
          localatt.upContinueFlag = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168975);
          return 0;
        case 7: 
          localatt.SGz = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168975);
          return 0;
        case 8: 
          localatt.SGA = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168975);
          return 0;
        case 9: 
          localatt.secondaryShowFlag = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168975);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderCommentInfo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderCommentInfo)localObject2).parseFrom((byte[])localObject1);
            }
            localatt.SGB.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168975);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new FinderObject();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((FinderObject)localObject2).parseFrom((byte[])localObject1);
          }
          localatt.SGC.add(localObject2);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.att
 * JD-Core Version:    0.7.0.1
 */