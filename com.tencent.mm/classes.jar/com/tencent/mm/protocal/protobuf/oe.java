package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class oe
  extends dyy
{
  public com.tencent.mm.cd.b RVs;
  public LinkedList<oc> RVu;
  public int RVv;
  public int xFI;
  
  public oe()
  {
    AppMethodBeat.i(206306);
    this.RVu = new LinkedList();
    AppMethodBeat.o(206306);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(206307);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(206307);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.RVu);
      if (this.RVs != null) {
        paramVarArgs.c(3, this.RVs);
      }
      paramVarArgs.aY(4, this.xFI);
      paramVarArgs.aY(5, this.RVv);
      AppMethodBeat.o(206307);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label606;
      }
    }
    label606:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.RVu);
      paramInt = i;
      if (this.RVs != null) {
        paramInt = i + g.a.a.b.b.a.b(3, this.RVs);
      }
      i = g.a.a.b.b.a.bM(4, this.xFI);
      int j = g.a.a.b.b.a.bM(5, this.RVv);
      AppMethodBeat.o(206307);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.RVu.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(206307);
          throw paramVarArgs;
        }
        AppMethodBeat.o(206307);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        oe localoe = (oe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(206307);
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
            localoe.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(206307);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new oc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((oc)localObject2).parseFrom((byte[])localObject1);
            }
            localoe.RVu.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(206307);
          return 0;
        case 3: 
          localoe.RVs = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(206307);
          return 0;
        case 4: 
          localoe.xFI = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(206307);
          return 0;
        }
        localoe.RVv = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(206307);
        return 0;
      }
      AppMethodBeat.o(206307);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.oe
 * JD-Core Version:    0.7.0.1
 */