package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ags
  extends cvp
{
  public int FAx;
  public LinkedList<dmd> FAy;
  public LinkedList<dme> FuN;
  public int GeI;
  public long GeJ;
  public int GeK;
  public int GeL;
  public int GeM;
  
  public ags()
  {
    AppMethodBeat.i(32191);
    this.FuN = new LinkedList();
    this.FAy = new LinkedList();
    AppMethodBeat.o(32191);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32192);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32192);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.GeI);
      paramVarArgs.aY(3, this.GeJ);
      paramVarArgs.aS(4, this.GeK);
      paramVarArgs.aS(5, this.GeL);
      paramVarArgs.e(6, 8, this.FuN);
      paramVarArgs.aS(7, this.GeM);
      paramVarArgs.aS(8, this.FAx);
      paramVarArgs.e(9, 8, this.FAy);
      AppMethodBeat.o(32192);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label941;
      }
    }
    label941:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.GeI);
      int j = f.a.a.b.b.a.p(3, this.GeJ);
      int k = f.a.a.b.b.a.bz(4, this.GeK);
      int m = f.a.a.b.b.a.bz(5, this.GeL);
      int n = f.a.a.a.c(6, 8, this.FuN);
      int i1 = f.a.a.b.b.a.bz(7, this.GeM);
      int i2 = f.a.a.b.b.a.bz(8, this.FAx);
      int i3 = f.a.a.a.c(9, 8, this.FAy);
      AppMethodBeat.o(32192);
      return paramInt + i + j + k + m + n + i1 + i2 + i3;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FuN.clear();
        this.FAy.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32192);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32192);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ags localags = (ags)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32192);
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
            localags.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32192);
          return 0;
        case 2: 
          localags.GeI = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32192);
          return 0;
        case 3: 
          localags.GeJ = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(32192);
          return 0;
        case 4: 
          localags.GeK = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32192);
          return 0;
        case 5: 
          localags.GeL = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32192);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dme();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dme)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localags.FuN.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32192);
          return 0;
        case 7: 
          localags.GeM = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32192);
          return 0;
        case 8: 
          localags.FAx = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32192);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dmd();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dmd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localags.FAy.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32192);
        return 0;
      }
      AppMethodBeat.o(32192);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ags
 * JD-Core Version:    0.7.0.1
 */