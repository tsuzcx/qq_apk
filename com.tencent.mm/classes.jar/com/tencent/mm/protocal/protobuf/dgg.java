package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dgg
  extends cvp
{
  public int Hur;
  public LinkedList<Integer> Hut;
  public int Huu;
  public int Huv;
  public LinkedList<dhk> Huw;
  
  public dgg()
  {
    AppMethodBeat.i(125800);
    this.Hut = new LinkedList();
    this.Huw = new LinkedList();
    AppMethodBeat.o(125800);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125801);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(125801);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.Hur);
      paramVarArgs.f(3, 2, this.Hut);
      paramVarArgs.aS(4, this.Huu);
      paramVarArgs.aS(5, this.Huv);
      paramVarArgs.e(6, 8, this.Huw);
      AppMethodBeat.o(125801);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label713;
      }
    }
    label713:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.Hur);
      int j = f.a.a.a.d(3, 2, this.Hut);
      int k = f.a.a.b.b.a.bz(4, this.Huu);
      int m = f.a.a.b.b.a.bz(5, this.Huv);
      int n = f.a.a.a.c(6, 8, this.Huw);
      AppMethodBeat.o(125801);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Hut.clear();
        this.Huw.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(125801);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125801);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dgg localdgg = (dgg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125801);
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
            localdgg.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125801);
          return 0;
        case 2: 
          localdgg.Hur = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125801);
          return 0;
        case 3: 
          localdgg.Hut = new f.a.a.a.a(((f.a.a.a.a)localObject1).NPN.gxI().zr, unknownTagHandler).NPN.gxG();
          AppMethodBeat.o(125801);
          return 0;
        case 4: 
          localdgg.Huu = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125801);
          return 0;
        case 5: 
          localdgg.Huv = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125801);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dhk();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dhk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdgg.Huw.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125801);
        return 0;
      }
      AppMethodBeat.o(125801);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgg
 * JD-Core Version:    0.7.0.1
 */