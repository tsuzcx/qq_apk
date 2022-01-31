package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bpm
  extends bvk
{
  public String kmm;
  public int koj;
  public String kok;
  public String poq;
  public String por;
  public String xDA;
  public nx xDB;
  public String xDC;
  public String xDD;
  public clg xDE;
  public String xDz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48931);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(48931);
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
      if (this.xDz != null) {
        paramVarArgs.e(4, this.xDz);
      }
      if (this.kmm != null) {
        paramVarArgs.e(5, this.kmm);
      }
      if (this.xDA != null) {
        paramVarArgs.e(6, this.xDA);
      }
      if (this.xDB != null)
      {
        paramVarArgs.iQ(7, this.xDB.computeSize());
        this.xDB.writeFields(paramVarArgs);
      }
      if (this.xDC != null) {
        paramVarArgs.e(8, this.xDC);
      }
      if (this.por != null) {
        paramVarArgs.e(9, this.por);
      }
      if (this.poq != null) {
        paramVarArgs.e(10, this.poq);
      }
      if (this.xDD != null) {
        paramVarArgs.e(11, this.xDD);
      }
      if (this.xDE != null)
      {
        paramVarArgs.iQ(12, this.xDE.computeSize());
        this.xDE.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(48931);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1206;
      }
    }
    label1206:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.koj);
      paramInt = i;
      if (this.kok != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.kok);
      }
      i = paramInt;
      if (this.xDz != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.xDz);
      }
      paramInt = i;
      if (this.kmm != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.kmm);
      }
      i = paramInt;
      if (this.xDA != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.xDA);
      }
      paramInt = i;
      if (this.xDB != null) {
        paramInt = i + e.a.a.a.iP(7, this.xDB.computeSize());
      }
      i = paramInt;
      if (this.xDC != null) {
        i = paramInt + e.a.a.b.b.a.f(8, this.xDC);
      }
      paramInt = i;
      if (this.por != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.por);
      }
      i = paramInt;
      if (this.poq != null) {
        i = paramInt + e.a.a.b.b.a.f(10, this.poq);
      }
      paramInt = i;
      if (this.xDD != null) {
        paramInt = i + e.a.a.b.b.a.f(11, this.xDD);
      }
      i = paramInt;
      if (this.xDE != null) {
        i = paramInt + e.a.a.a.iP(12, this.xDE.computeSize());
      }
      AppMethodBeat.o(48931);
      return i;
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
          AppMethodBeat.o(48931);
          throw paramVarArgs;
        }
        AppMethodBeat.o(48931);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bpm localbpm = (bpm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(48931);
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
            localbpm.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48931);
          return 0;
        case 2: 
          localbpm.koj = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48931);
          return 0;
        case 3: 
          localbpm.kok = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48931);
          return 0;
        case 4: 
          localbpm.xDz = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48931);
          return 0;
        case 5: 
          localbpm.kmm = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48931);
          return 0;
        case 6: 
          localbpm.xDA = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48931);
          return 0;
        case 7: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new nx();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((nx)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbpm.xDB = ((nx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48931);
          return 0;
        case 8: 
          localbpm.xDC = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48931);
          return 0;
        case 9: 
          localbpm.por = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48931);
          return 0;
        case 10: 
          localbpm.poq = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48931);
          return 0;
        case 11: 
          localbpm.xDD = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48931);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new clg();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((clg)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbpm.xDE = ((clg)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(48931);
        return 0;
      }
      AppMethodBeat.o(48931);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpm
 * JD-Core Version:    0.7.0.1
 */