package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class jv
  extends bvk
{
  public int jJS;
  public int wmw;
  public int wmz;
  public SKBuiltinBuffer_t woT;
  public SKBuiltinBuffer_t wrN;
  public SKBuiltinBuffer_t wrT;
  public bwf wwc;
  public String wwk;
  public bwc wwn;
  public SKBuiltinBuffer_t wwo;
  public int wwq;
  public String wwr;
  public String wws;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(73696);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(73696);
        throw paramVarArgs;
      }
      if (this.woT == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(73696);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.wwk != null) {
        paramVarArgs.e(2, this.wwk);
      }
      if (this.woT != null)
      {
        paramVarArgs.iQ(3, this.woT.computeSize());
        this.woT.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(4, this.wmz);
      paramVarArgs.aO(5, this.wwq);
      if (this.wwr != null) {
        paramVarArgs.e(6, this.wwr);
      }
      paramVarArgs.aO(7, this.jJS);
      if (this.wws != null) {
        paramVarArgs.e(8, this.wws);
      }
      if (this.wwn != null)
      {
        paramVarArgs.iQ(9, this.wwn.computeSize());
        this.wwn.writeFields(paramVarArgs);
      }
      if (this.wrT != null)
      {
        paramVarArgs.iQ(10, this.wrT.computeSize());
        this.wrT.writeFields(paramVarArgs);
      }
      if (this.wwo != null)
      {
        paramVarArgs.iQ(11, this.wwo.computeSize());
        this.wwo.writeFields(paramVarArgs);
      }
      if (this.wwc != null)
      {
        paramVarArgs.iQ(12, this.wwc.computeSize());
        this.wwc.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(13, this.wmw);
      if (this.wrN != null)
      {
        paramVarArgs.iQ(14, this.wrN.computeSize());
        this.wrN.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(73696);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1702;
      }
    }
    label1702:
    for (int i = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wwk != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wwk);
      }
      i = paramInt;
      if (this.woT != null) {
        i = paramInt + e.a.a.a.iP(3, this.woT.computeSize());
      }
      i = i + e.a.a.b.b.a.bl(4, this.wmz) + e.a.a.b.b.a.bl(5, this.wwq);
      paramInt = i;
      if (this.wwr != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wwr);
      }
      i = paramInt + e.a.a.b.b.a.bl(7, this.jJS);
      paramInt = i;
      if (this.wws != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.wws);
      }
      i = paramInt;
      if (this.wwn != null) {
        i = paramInt + e.a.a.a.iP(9, this.wwn.computeSize());
      }
      paramInt = i;
      if (this.wrT != null) {
        paramInt = i + e.a.a.a.iP(10, this.wrT.computeSize());
      }
      i = paramInt;
      if (this.wwo != null) {
        i = paramInt + e.a.a.a.iP(11, this.wwo.computeSize());
      }
      paramInt = i;
      if (this.wwc != null) {
        paramInt = i + e.a.a.a.iP(12, this.wwc.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(13, this.wmw);
      paramInt = i;
      if (this.wrN != null) {
        paramInt = i + e.a.a.a.iP(14, this.wrN.computeSize());
      }
      AppMethodBeat.o(73696);
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
          AppMethodBeat.o(73696);
          throw paramVarArgs;
        }
        if (this.woT == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgBuf");
          AppMethodBeat.o(73696);
          throw paramVarArgs;
        }
        AppMethodBeat.o(73696);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        jv localjv = (jv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(73696);
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
            localjv.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(73696);
          return 0;
        case 2: 
          localjv.wwk = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(73696);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localjv.woT = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(73696);
          return 0;
        case 4: 
          localjv.wmz = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(73696);
          return 0;
        case 5: 
          localjv.wwq = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(73696);
          return 0;
        case 6: 
          localjv.wwr = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(73696);
          return 0;
        case 7: 
          localjv.jJS = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(73696);
          return 0;
        case 8: 
          localjv.wws = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(73696);
          return 0;
        case 9: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localjv.wwn = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(73696);
          return 0;
        case 10: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localjv.wrT = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(73696);
          return 0;
        case 11: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localjv.wwo = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(73696);
          return 0;
        case 12: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwf();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwf)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localjv.wwc = ((bwf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(73696);
          return 0;
        case 13: 
          localjv.wmw = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(73696);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localjv.wrN = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(73696);
        return 0;
      }
      AppMethodBeat.o(73696);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.jv
 * JD-Core Version:    0.7.0.1
 */