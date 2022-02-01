package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aub
  extends dyy
{
  public bhh SDf;
  public int SGK;
  public int continueFlag;
  public int jlf;
  public com.tencent.mm.cd.b lastBuffer;
  public LinkedList<FinderObject> object;
  public LinkedList<bkr> usualTopics;
  public int zwD;
  
  public aub()
  {
    AppMethodBeat.i(199708);
    this.object = new LinkedList();
    this.usualTopics = new LinkedList();
    AppMethodBeat.o(199708);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(199714);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(199714);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.object);
      if (this.lastBuffer != null) {
        paramVarArgs.c(3, this.lastBuffer);
      }
      paramVarArgs.aY(4, this.continueFlag);
      paramVarArgs.aY(5, this.jlf);
      paramVarArgs.aY(6, this.zwD);
      paramVarArgs.aY(7, this.SGK);
      if (this.SDf != null)
      {
        paramVarArgs.oE(8, this.SDf.computeSize());
        this.SDf.writeFields(paramVarArgs);
      }
      paramVarArgs.e(9, 8, this.usualTopics);
      AppMethodBeat.o(199714);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label942;
      }
    }
    label942:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.object);
      paramInt = i;
      if (this.lastBuffer != null) {
        paramInt = i + g.a.a.b.b.a.b(3, this.lastBuffer);
      }
      i = paramInt + g.a.a.b.b.a.bM(4, this.continueFlag) + g.a.a.b.b.a.bM(5, this.jlf) + g.a.a.b.b.a.bM(6, this.zwD) + g.a.a.b.b.a.bM(7, this.SGK);
      paramInt = i;
      if (this.SDf != null) {
        paramInt = i + g.a.a.a.oD(8, this.SDf.computeSize());
      }
      i = g.a.a.a.c(9, 8, this.usualTopics);
      AppMethodBeat.o(199714);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.object.clear();
        this.usualTopics.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(199714);
          throw paramVarArgs;
        }
        AppMethodBeat.o(199714);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aub localaub = (aub)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(199714);
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
            localaub.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(199714);
          return 0;
        case 2: 
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
            localaub.object.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(199714);
          return 0;
        case 3: 
          localaub.lastBuffer = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(199714);
          return 0;
        case 4: 
          localaub.continueFlag = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(199714);
          return 0;
        case 5: 
          localaub.jlf = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(199714);
          return 0;
        case 6: 
          localaub.zwD = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(199714);
          return 0;
        case 7: 
          localaub.SGK = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(199714);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bhh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bhh)localObject2).parseFrom((byte[])localObject1);
            }
            localaub.SDf = ((bhh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(199714);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bkr();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bkr)localObject2).parseFrom((byte[])localObject1);
          }
          localaub.usualTopics.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(199714);
        return 0;
      }
      AppMethodBeat.o(199714);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aub
 * JD-Core Version:    0.7.0.1
 */