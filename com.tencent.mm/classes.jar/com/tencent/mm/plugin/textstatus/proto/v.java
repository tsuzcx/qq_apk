package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.protocal.protobuf.jh;
import java.util.LinkedList;

public final class v
  extends dyy
{
  public com.tencent.mm.cd.b MFp;
  public boolean MFr;
  public LinkedList<ak> MFu;
  public LinkedList<an> MFv;
  
  public v()
  {
    AppMethodBeat.i(243792);
    this.MFu = new LinkedList();
    this.MFv = new LinkedList();
    AppMethodBeat.o(243792);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(243795);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(243795);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.MFu);
      if (this.MFp != null) {
        paramVarArgs.c(3, this.MFp);
      }
      paramVarArgs.co(4, this.MFr);
      paramVarArgs.e(5, 8, this.MFv);
      AppMethodBeat.o(243795);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label676;
      }
    }
    label676:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.MFu);
      paramInt = i;
      if (this.MFp != null) {
        paramInt = i + g.a.a.b.b.a.b(3, this.MFp);
      }
      i = g.a.a.b.b.a.gL(4);
      int j = g.a.a.a.c(5, 8, this.MFv);
      AppMethodBeat.o(243795);
      return paramInt + (i + 1) + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MFu.clear();
        this.MFv.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(243795);
          throw paramVarArgs;
        }
        AppMethodBeat.o(243795);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        v localv = (v)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(243795);
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
            localv.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(243795);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ak();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ak)localObject2).parseFrom((byte[])localObject1);
            }
            localv.MFu.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(243795);
          return 0;
        case 3: 
          localv.MFp = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(243795);
          return 0;
        case 4: 
          localv.MFr = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(243795);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new an();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((an)localObject2).parseFrom((byte[])localObject1);
          }
          localv.MFv.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(243795);
        return 0;
      }
      AppMethodBeat.o(243795);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.v
 * JD-Core Version:    0.7.0.1
 */