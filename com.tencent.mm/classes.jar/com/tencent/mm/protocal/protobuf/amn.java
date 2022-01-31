package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class amn
  extends bvk
{
  public int kWh;
  public int koj;
  public String kok;
  public int xcZ;
  public bkl xdk;
  public bkm xdl;
  public bkm xdm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89100);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(89100);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.koj);
      if (this.kok != null) {
        paramVarArgs.e(3, this.kok);
      }
      paramVarArgs.aO(4, this.kWh);
      paramVarArgs.aO(5, this.xcZ);
      if (this.xdk != null)
      {
        paramVarArgs.iQ(6, this.xdk.computeSize());
        this.xdk.writeFields(paramVarArgs);
      }
      if (this.xdl != null)
      {
        paramVarArgs.iQ(7, this.xdl.computeSize());
        this.xdl.writeFields(paramVarArgs);
      }
      if (this.xdm != null)
      {
        paramVarArgs.iQ(8, this.xdm.computeSize());
        this.xdm.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(89100);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1018;
      }
    }
    label1018:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.koj);
      paramInt = i;
      if (this.kok != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.kok);
      }
      i = paramInt + e.a.a.b.b.a.bl(4, this.kWh) + e.a.a.b.b.a.bl(5, this.xcZ);
      paramInt = i;
      if (this.xdk != null) {
        paramInt = i + e.a.a.a.iP(6, this.xdk.computeSize());
      }
      i = paramInt;
      if (this.xdl != null) {
        i = paramInt + e.a.a.a.iP(7, this.xdl.computeSize());
      }
      paramInt = i;
      if (this.xdm != null) {
        paramInt = i + e.a.a.a.iP(8, this.xdm.computeSize());
      }
      AppMethodBeat.o(89100);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(89100);
          throw paramVarArgs;
        }
        AppMethodBeat.o(89100);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        amn localamn = (amn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(89100);
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
            localamn.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89100);
          return 0;
        case 2: 
          localamn.koj = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(89100);
          return 0;
        case 3: 
          localamn.kok = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89100);
          return 0;
        case 4: 
          localamn.kWh = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(89100);
          return 0;
        case 5: 
          localamn.xcZ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(89100);
          return 0;
        case 6: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bkl();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bkl)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localamn.xdk = ((bkl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89100);
          return 0;
        case 7: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bkm();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bkm)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localamn.xdl = ((bkm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89100);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bkm();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bkm)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localamn.xdm = ((bkm)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(89100);
        return 0;
      }
      AppMethodBeat.o(89100);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amn
 * JD-Core Version:    0.7.0.1
 */