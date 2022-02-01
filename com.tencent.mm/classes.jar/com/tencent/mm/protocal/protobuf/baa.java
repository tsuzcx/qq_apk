package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class baa
  extends dyy
{
  public aze SJb;
  public LinkedList<bnw> SLB;
  public int SLC;
  
  public baa()
  {
    AppMethodBeat.i(230037);
    this.SLB = new LinkedList();
    AppMethodBeat.o(230037);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(230038);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.SLB);
      if (this.SJb != null)
      {
        paramVarArgs.oE(3, this.SJb.computeSize());
        this.SJb.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(4, this.SLC);
      AppMethodBeat.o(230038);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label584;
      }
    }
    label584:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.SLB);
      paramInt = i;
      if (this.SJb != null) {
        paramInt = i + g.a.a.a.oD(3, this.SJb.computeSize());
      }
      i = g.a.a.b.b.a.bM(4, this.SLC);
      AppMethodBeat.o(230038);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SLB.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(230038);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        baa localbaa = (baa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(230038);
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
            localbaa.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230038);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bnw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bnw)localObject2).parseFrom((byte[])localObject1);
            }
            localbaa.SLB.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230038);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aze();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aze)localObject2).parseFrom((byte[])localObject1);
            }
            localbaa.SJb = ((aze)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230038);
          return 0;
        }
        localbaa.SLC = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(230038);
        return 0;
      }
      AppMethodBeat.o(230038);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.baa
 * JD-Core Version:    0.7.0.1
 */