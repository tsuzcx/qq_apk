package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bjv
  extends bvk
{
  public String pqD;
  public String type;
  public String xyg;
  public bjy xyk;
  public LinkedList<bjv> xyl;
  public int xym;
  
  public bjv()
  {
    AppMethodBeat.i(90699);
    this.xyl = new LinkedList();
    AppMethodBeat.o(90699);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(90700);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.xyk != null)
      {
        paramVarArgs.iQ(2, this.xyk.computeSize());
        this.xyk.writeFields(paramVarArgs);
      }
      if (this.xyg != null) {
        paramVarArgs.e(3, this.xyg);
      }
      if (this.pqD != null) {
        paramVarArgs.e(4, this.pqD);
      }
      if (this.type != null) {
        paramVarArgs.e(5, this.type);
      }
      paramVarArgs.e(6, 8, this.xyl);
      paramVarArgs.aO(7, this.xym);
      AppMethodBeat.o(90700);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label834;
      }
    }
    label834:
    for (int i = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xyk != null) {
        paramInt = i + e.a.a.a.iP(2, this.xyk.computeSize());
      }
      i = paramInt;
      if (this.xyg != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.xyg);
      }
      paramInt = i;
      if (this.pqD != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.pqD);
      }
      i = paramInt;
      if (this.type != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.type);
      }
      paramInt = e.a.a.a.c(6, 8, this.xyl);
      int j = e.a.a.b.b.a.bl(7, this.xym);
      AppMethodBeat.o(90700);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xyl.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(90700);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bjv localbjv = (bjv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(90700);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbjv.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(90700);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bjy();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bjy)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbjv.xyk = ((bjy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(90700);
          return 0;
        case 3: 
          localbjv.xyg = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(90700);
          return 0;
        case 4: 
          localbjv.pqD = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(90700);
          return 0;
        case 5: 
          localbjv.type = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(90700);
          return 0;
        case 6: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bjv();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bjv)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbjv.xyl.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(90700);
          return 0;
        }
        localbjv.xym = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(90700);
        return 0;
      }
      AppMethodBeat.o(90700);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjv
 * JD-Core Version:    0.7.0.1
 */