package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aul
  extends dyy
{
  public com.tencent.mm.cd.b SDI;
  public LinkedList<FinderObject> object;
  public bhh preloadInfo;
  public int xFI;
  
  public aul()
  {
    AppMethodBeat.i(168983);
    this.object = new LinkedList();
    AppMethodBeat.o(168983);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168984);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(168984);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.object);
      if (this.SDI != null) {
        paramVarArgs.c(3, this.SDI);
      }
      paramVarArgs.aY(4, this.xFI);
      if (this.preloadInfo != null)
      {
        paramVarArgs.oE(5, this.preloadInfo.computeSize());
        this.preloadInfo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(168984);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label692;
      }
    }
    label692:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.object);
      paramInt = i;
      if (this.SDI != null) {
        paramInt = i + g.a.a.b.b.a.b(3, this.SDI);
      }
      i = paramInt + g.a.a.b.b.a.bM(4, this.xFI);
      paramInt = i;
      if (this.preloadInfo != null) {
        paramInt = i + g.a.a.a.oD(5, this.preloadInfo.computeSize());
      }
      AppMethodBeat.o(168984);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.object.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(168984);
          throw paramVarArgs;
        }
        AppMethodBeat.o(168984);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aul localaul = (aul)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168984);
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
            localaul.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168984);
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
            localaul.object.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168984);
          return 0;
        case 3: 
          localaul.SDI = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(168984);
          return 0;
        case 4: 
          localaul.xFI = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168984);
          return 0;
        }
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
          localaul.preloadInfo = ((bhh)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(168984);
        return 0;
      }
      AppMethodBeat.o(168984);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aul
 * JD-Core Version:    0.7.0.1
 */