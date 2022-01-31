package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class ps
  extends bvk
{
  public int cnK;
  public String kNv;
  public String kNw;
  public String wHY;
  public LinkedList<aba> wHZ;
  public int wIa;
  
  public ps()
  {
    AppMethodBeat.i(56747);
    this.wHZ = new LinkedList();
    AppMethodBeat.o(56747);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56748);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(56748);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.cnK);
      if (this.kNv != null) {
        paramVarArgs.e(3, this.kNv);
      }
      if (this.wHY != null) {
        paramVarArgs.e(4, this.wHY);
      }
      if (this.kNw != null) {
        paramVarArgs.e(5, this.kNw);
      }
      paramVarArgs.e(6, 8, this.wHZ);
      paramVarArgs.aO(7, this.wIa);
      AppMethodBeat.o(56748);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label774;
      }
    }
    label774:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.cnK);
      paramInt = i;
      if (this.kNv != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.kNv);
      }
      i = paramInt;
      if (this.wHY != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.wHY);
      }
      paramInt = i;
      if (this.kNw != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.kNw);
      }
      i = e.a.a.a.c(6, 8, this.wHZ);
      int j = e.a.a.b.b.a.bl(7, this.wIa);
      AppMethodBeat.o(56748);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wHZ.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(56748);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56748);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        ps localps = (ps)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56748);
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
            localps.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56748);
          return 0;
        case 2: 
          localps.cnK = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56748);
          return 0;
        case 3: 
          localps.kNv = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56748);
          return 0;
        case 4: 
          localps.wHY = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56748);
          return 0;
        case 5: 
          localps.kNw = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56748);
          return 0;
        case 6: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aba();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aba)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localps.wHZ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56748);
          return 0;
        }
        localps.wIa = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56748);
        return 0;
      }
      AppMethodBeat.o(56748);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ps
 * JD-Core Version:    0.7.0.1
 */