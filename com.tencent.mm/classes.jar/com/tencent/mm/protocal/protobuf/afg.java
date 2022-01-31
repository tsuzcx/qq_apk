package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class afg
  extends bvk
{
  public String SSID;
  public String Title;
  public String jJA;
  public String nQe;
  public String ntu;
  public String wYA;
  public SKBuiltinBuffer_t wYl;
  public String wYn;
  public String wYo;
  public axj wYp;
  public afc wYq;
  public String wYr;
  public int wYs;
  public LinkedList<ls> wYt;
  public String wYu;
  public wi wYv;
  public SKBuiltinBuffer_t wYw;
  public int wYx;
  public LinkedList<avl> wYy;
  public String wYz;
  public String wkT;
  public int wld;
  
  public afg()
  {
    AppMethodBeat.i(80055);
    this.wYt = new LinkedList();
    this.wYy = new LinkedList();
    AppMethodBeat.o(80055);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80056);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(80056);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.wYn != null) {
        paramVarArgs.e(2, this.wYn);
      }
      if (this.wYo != null) {
        paramVarArgs.e(3, this.wYo);
      }
      paramVarArgs.aO(4, this.wld);
      if (this.Title != null) {
        paramVarArgs.e(5, this.Title);
      }
      if (this.ntu != null) {
        paramVarArgs.e(6, this.ntu);
      }
      if (this.wYp != null)
      {
        paramVarArgs.iQ(7, this.wYp.computeSize());
        this.wYp.writeFields(paramVarArgs);
      }
      if (this.wYq != null)
      {
        paramVarArgs.iQ(8, this.wYq.computeSize());
        this.wYq.writeFields(paramVarArgs);
      }
      if (this.jJA != null) {
        paramVarArgs.e(9, this.jJA);
      }
      if (this.wYr != null) {
        paramVarArgs.e(15, this.wYr);
      }
      paramVarArgs.aO(16, this.wYs);
      paramVarArgs.e(17, 8, this.wYt);
      if (this.wYu != null) {
        paramVarArgs.e(18, this.wYu);
      }
      if (this.SSID != null) {
        paramVarArgs.e(20, this.SSID);
      }
      if (this.wkT != null) {
        paramVarArgs.e(21, this.wkT);
      }
      if (this.wYv != null)
      {
        paramVarArgs.iQ(22, this.wYv.computeSize());
        this.wYv.writeFields(paramVarArgs);
      }
      if (this.wYw != null)
      {
        paramVarArgs.iQ(23, this.wYw.computeSize());
        this.wYw.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(24, this.wYx);
      paramVarArgs.e(25, 8, this.wYy);
      if (this.nQe != null) {
        paramVarArgs.e(26, this.nQe);
      }
      if (this.wYz != null) {
        paramVarArgs.e(27, this.wYz);
      }
      if (this.wYl != null)
      {
        paramVarArgs.iQ(28, this.wYl.computeSize());
        this.wYl.writeFields(paramVarArgs);
      }
      if (this.wYA != null) {
        paramVarArgs.e(29, this.wYA);
      }
      AppMethodBeat.o(80056);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2318;
      }
    }
    label2318:
    for (int i = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wYn != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wYn);
      }
      i = paramInt;
      if (this.wYo != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wYo);
      }
      i += e.a.a.b.b.a.bl(4, this.wld);
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.Title);
      }
      i = paramInt;
      if (this.ntu != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.ntu);
      }
      paramInt = i;
      if (this.wYp != null) {
        paramInt = i + e.a.a.a.iP(7, this.wYp.computeSize());
      }
      i = paramInt;
      if (this.wYq != null) {
        i = paramInt + e.a.a.a.iP(8, this.wYq.computeSize());
      }
      paramInt = i;
      if (this.jJA != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.jJA);
      }
      i = paramInt;
      if (this.wYr != null) {
        i = paramInt + e.a.a.b.b.a.f(15, this.wYr);
      }
      i = i + e.a.a.b.b.a.bl(16, this.wYs) + e.a.a.a.c(17, 8, this.wYt);
      paramInt = i;
      if (this.wYu != null) {
        paramInt = i + e.a.a.b.b.a.f(18, this.wYu);
      }
      i = paramInt;
      if (this.SSID != null) {
        i = paramInt + e.a.a.b.b.a.f(20, this.SSID);
      }
      paramInt = i;
      if (this.wkT != null) {
        paramInt = i + e.a.a.b.b.a.f(21, this.wkT);
      }
      i = paramInt;
      if (this.wYv != null) {
        i = paramInt + e.a.a.a.iP(22, this.wYv.computeSize());
      }
      paramInt = i;
      if (this.wYw != null) {
        paramInt = i + e.a.a.a.iP(23, this.wYw.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(24, this.wYx) + e.a.a.a.c(25, 8, this.wYy);
      paramInt = i;
      if (this.nQe != null) {
        paramInt = i + e.a.a.b.b.a.f(26, this.nQe);
      }
      i = paramInt;
      if (this.wYz != null) {
        i = paramInt + e.a.a.b.b.a.f(27, this.wYz);
      }
      paramInt = i;
      if (this.wYl != null) {
        paramInt = i + e.a.a.a.iP(28, this.wYl.computeSize());
      }
      i = paramInt;
      if (this.wYA != null) {
        i = paramInt + e.a.a.b.b.a.f(29, this.wYA);
      }
      AppMethodBeat.o(80056);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wYt.clear();
        this.wYy.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(80056);
          throw paramVarArgs;
        }
        AppMethodBeat.o(80056);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        afg localafg = (afg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        case 14: 
        case 19: 
        default: 
          AppMethodBeat.o(80056);
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
            localafg.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80056);
          return 0;
        case 2: 
          localafg.wYn = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80056);
          return 0;
        case 3: 
          localafg.wYo = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80056);
          return 0;
        case 4: 
          localafg.wld = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80056);
          return 0;
        case 5: 
          localafg.Title = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80056);
          return 0;
        case 6: 
          localafg.ntu = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80056);
          return 0;
        case 7: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new axj();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((axj)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localafg.wYp = ((axj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80056);
          return 0;
        case 8: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new afc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((afc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localafg.wYq = ((afc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80056);
          return 0;
        case 9: 
          localafg.jJA = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80056);
          return 0;
        case 15: 
          localafg.wYr = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80056);
          return 0;
        case 16: 
          localafg.wYs = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80056);
          return 0;
        case 17: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ls();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ls)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localafg.wYt.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80056);
          return 0;
        case 18: 
          localafg.wYu = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80056);
          return 0;
        case 20: 
          localafg.SSID = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80056);
          return 0;
        case 21: 
          localafg.wkT = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80056);
          return 0;
        case 22: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new wi();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((wi)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localafg.wYv = ((wi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80056);
          return 0;
        case 23: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localafg.wYw = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80056);
          return 0;
        case 24: 
          localafg.wYx = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80056);
          return 0;
        case 25: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new avl();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((avl)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localafg.wYy.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80056);
          return 0;
        case 26: 
          localafg.nQe = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80056);
          return 0;
        case 27: 
          localafg.wYz = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80056);
          return 0;
        case 28: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localafg.wYl = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80056);
          return 0;
        }
        localafg.wYA = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(80056);
        return 0;
      }
      AppMethodBeat.o(80056);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afg
 * JD-Core Version:    0.7.0.1
 */