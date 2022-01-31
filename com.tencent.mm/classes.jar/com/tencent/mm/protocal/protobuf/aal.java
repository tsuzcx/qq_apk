package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.a.i;
import java.util.LinkedList;

public final class aal
  extends bvk
{
  public int koj;
  public String kok;
  public LinkedList<i> wQZ;
  public int wRa;
  public d.a.a.a wRb;
  
  public aal()
  {
    AppMethodBeat.i(56776);
    this.wQZ = new LinkedList();
    AppMethodBeat.o(56776);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56777);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.koj);
      if (this.kok != null) {
        paramVarArgs.e(3, this.kok);
      }
      paramVarArgs.e(4, 8, this.wQZ);
      paramVarArgs.aO(5, this.wRa);
      if (this.wRb != null)
      {
        paramVarArgs.iQ(6, this.wRb.computeSize());
        this.wRb.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(56777);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label754;
      }
    }
    label754:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.koj);
      paramInt = i;
      if (this.kok != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.kok);
      }
      i = paramInt + e.a.a.a.c(4, 8, this.wQZ) + e.a.a.b.b.a.bl(5, this.wRa);
      paramInt = i;
      if (this.wRb != null) {
        paramInt = i + e.a.a.a.iP(6, this.wRb.computeSize());
      }
      AppMethodBeat.o(56777);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wQZ.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56777);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        aal localaal = (aal)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56777);
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
            localaal.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56777);
          return 0;
        case 2: 
          localaal.koj = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56777);
          return 0;
        case 3: 
          localaal.kok = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56777);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new i();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((i)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaal.wQZ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56777);
          return 0;
        case 5: 
          localaal.wRa = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56777);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new d.a.a.a();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((d.a.a.a)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localaal.wRb = ((d.a.a.a)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(56777);
        return 0;
      }
      AppMethodBeat.o(56777);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aal
 * JD-Core Version:    0.7.0.1
 */