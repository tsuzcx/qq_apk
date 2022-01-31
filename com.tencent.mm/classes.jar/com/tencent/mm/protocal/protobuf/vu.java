package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class vu
  extends bvk
{
  public int eeF;
  public String wJq;
  public String wJr;
  public bwc wOt;
  public bwc wOv;
  public bwc wOw;
  public SKBuiltinBuffer_t woT;
  public LinkedList<bcx> wov;
  public bwc wow;
  
  public vu()
  {
    AppMethodBeat.i(5570);
    this.wov = new LinkedList();
    AppMethodBeat.o(5570);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(5571);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(5571);
        throw paramVarArgs;
      }
      if (this.wOt == null)
      {
        paramVarArgs = new b("Not all required fields were included: Topic");
        AppMethodBeat.o(5571);
        throw paramVarArgs;
      }
      if (this.wOv == null)
      {
        paramVarArgs = new b("Not all required fields were included: PYInitial");
        AppMethodBeat.o(5571);
        throw paramVarArgs;
      }
      if (this.wOw == null)
      {
        paramVarArgs = new b("Not all required fields were included: QuanPin");
        AppMethodBeat.o(5571);
        throw paramVarArgs;
      }
      if (this.wow == null)
      {
        paramVarArgs = new b("Not all required fields were included: ChatRoomName");
        AppMethodBeat.o(5571);
        throw paramVarArgs;
      }
      if (this.woT == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(5571);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.wOt != null)
      {
        paramVarArgs.iQ(2, this.wOt.computeSize());
        this.wOt.writeFields(paramVarArgs);
      }
      if (this.wOv != null)
      {
        paramVarArgs.iQ(3, this.wOv.computeSize());
        this.wOv.writeFields(paramVarArgs);
      }
      if (this.wOw != null)
      {
        paramVarArgs.iQ(4, this.wOw.computeSize());
        this.wOw.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(5, this.eeF);
      paramVarArgs.e(6, 8, this.wov);
      if (this.wow != null)
      {
        paramVarArgs.iQ(7, this.wow.computeSize());
        this.wow.writeFields(paramVarArgs);
      }
      if (this.woT != null)
      {
        paramVarArgs.iQ(8, this.woT.computeSize());
        this.woT.writeFields(paramVarArgs);
      }
      if (this.wJq != null) {
        paramVarArgs.e(9, this.wJq);
      }
      if (this.wJr != null) {
        paramVarArgs.e(10, this.wJr);
      }
      AppMethodBeat.o(5571);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1710;
      }
    }
    label1710:
    for (int i = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wOt != null) {
        paramInt = i + e.a.a.a.iP(2, this.wOt.computeSize());
      }
      i = paramInt;
      if (this.wOv != null) {
        i = paramInt + e.a.a.a.iP(3, this.wOv.computeSize());
      }
      paramInt = i;
      if (this.wOw != null) {
        paramInt = i + e.a.a.a.iP(4, this.wOw.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.eeF) + e.a.a.a.c(6, 8, this.wov);
      paramInt = i;
      if (this.wow != null) {
        paramInt = i + e.a.a.a.iP(7, this.wow.computeSize());
      }
      i = paramInt;
      if (this.woT != null) {
        i = paramInt + e.a.a.a.iP(8, this.woT.computeSize());
      }
      paramInt = i;
      if (this.wJq != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.wJq);
      }
      i = paramInt;
      if (this.wJr != null) {
        i = paramInt + e.a.a.b.b.a.f(10, this.wJr);
      }
      AppMethodBeat.o(5571);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wov.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(5571);
          throw paramVarArgs;
        }
        if (this.wOt == null)
        {
          paramVarArgs = new b("Not all required fields were included: Topic");
          AppMethodBeat.o(5571);
          throw paramVarArgs;
        }
        if (this.wOv == null)
        {
          paramVarArgs = new b("Not all required fields were included: PYInitial");
          AppMethodBeat.o(5571);
          throw paramVarArgs;
        }
        if (this.wOw == null)
        {
          paramVarArgs = new b("Not all required fields were included: QuanPin");
          AppMethodBeat.o(5571);
          throw paramVarArgs;
        }
        if (this.wow == null)
        {
          paramVarArgs = new b("Not all required fields were included: ChatRoomName");
          AppMethodBeat.o(5571);
          throw paramVarArgs;
        }
        if (this.woT == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgBuf");
          AppMethodBeat.o(5571);
          throw paramVarArgs;
        }
        AppMethodBeat.o(5571);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        vu localvu = (vu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(5571);
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
            localvu.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5571);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localvu.wOt = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5571);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localvu.wOv = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5571);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localvu.wOw = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5571);
          return 0;
        case 5: 
          localvu.eeF = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5571);
          return 0;
        case 6: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bcx();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bcx)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localvu.wov.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5571);
          return 0;
        case 7: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localvu.wow = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5571);
          return 0;
        case 8: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localvu.woT = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5571);
          return 0;
        case 9: 
          localvu.wJq = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(5571);
          return 0;
        }
        localvu.wJr = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(5571);
        return 0;
      }
      AppMethodBeat.o(5571);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vu
 * JD-Core Version:    0.7.0.1
 */