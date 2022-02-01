package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cbv
  extends dyy
{
  public long Tkj;
  public LinkedList<duv> Tkm;
  public LinkedList<dud> Tkn;
  public int Tko;
  public int nRk;
  
  public cbv()
  {
    AppMethodBeat.i(50090);
    this.Tkm = new LinkedList();
    this.Tkn = new LinkedList();
    AppMethodBeat.o(50090);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50091);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(50091);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.nRk);
      paramVarArgs.e(3, 8, this.Tkm);
      paramVarArgs.bm(4, this.Tkj);
      paramVarArgs.e(5, 8, this.Tkn);
      paramVarArgs.aY(6, this.Tko);
      AppMethodBeat.o(50091);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label716;
      }
    }
    label716:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.nRk);
      int j = g.a.a.a.c(3, 8, this.Tkm);
      int k = g.a.a.b.b.a.p(4, this.Tkj);
      int m = g.a.a.a.c(5, 8, this.Tkn);
      int n = g.a.a.b.b.a.bM(6, this.Tko);
      AppMethodBeat.o(50091);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Tkm.clear();
        this.Tkn.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(50091);
          throw paramVarArgs;
        }
        AppMethodBeat.o(50091);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cbv localcbv = (cbv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(50091);
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
            localcbv.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(50091);
          return 0;
        case 2: 
          localcbv.nRk = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(50091);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new duv();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((duv)localObject2).parseFrom((byte[])localObject1);
            }
            localcbv.Tkm.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(50091);
          return 0;
        case 4: 
          localcbv.Tkj = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(50091);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dud();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dud)localObject2).parseFrom((byte[])localObject1);
            }
            localcbv.Tkn.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(50091);
          return 0;
        }
        localcbv.Tko = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(50091);
        return 0;
      }
      AppMethodBeat.o(50091);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbv
 * JD-Core Version:    0.7.0.1
 */