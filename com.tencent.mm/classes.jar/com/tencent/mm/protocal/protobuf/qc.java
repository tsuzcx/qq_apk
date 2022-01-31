package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class qc
  extends bvk
{
  public int cnK;
  public String desc;
  public String jVh;
  public String kNv;
  public String knU;
  public String qiN;
  public String ueu;
  public int wIA;
  public int wIB;
  public bry wIk;
  public boolean wIv;
  public String wIw;
  public int wIx;
  public LinkedList<Integer> wIy;
  public String wIz;
  
  public qc()
  {
    AppMethodBeat.i(48795);
    this.wIy = new LinkedList();
    AppMethodBeat.o(48795);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48796);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(48796);
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
      paramVarArgs.aS(4, this.wIv);
      if (this.qiN != null) {
        paramVarArgs.e(5, this.qiN);
      }
      if (this.wIw != null) {
        paramVarArgs.e(6, this.wIw);
      }
      if (this.jVh != null) {
        paramVarArgs.e(7, this.jVh);
      }
      paramVarArgs.aO(8, this.wIx);
      if (this.desc != null) {
        paramVarArgs.e(9, this.desc);
      }
      if (this.ueu != null) {
        paramVarArgs.e(10, this.ueu);
      }
      paramVarArgs.e(11, 2, this.wIy);
      if (this.wIz != null) {
        paramVarArgs.e(12, this.wIz);
      }
      if (this.knU != null) {
        paramVarArgs.e(13, this.knU);
      }
      paramVarArgs.aO(14, this.wIA);
      paramVarArgs.aO(15, this.wIB);
      if (this.wIk != null)
      {
        paramVarArgs.iQ(16, this.wIk.computeSize());
        this.wIk.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(48796);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1293;
      }
    }
    label1293:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.cnK);
      paramInt = i;
      if (this.kNv != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.kNv);
      }
      i = paramInt + (e.a.a.b.b.a.eW(4) + 1);
      paramInt = i;
      if (this.qiN != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.qiN);
      }
      i = paramInt;
      if (this.wIw != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.wIw);
      }
      paramInt = i;
      if (this.jVh != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.jVh);
      }
      i = paramInt + e.a.a.b.b.a.bl(8, this.wIx);
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.desc);
      }
      i = paramInt;
      if (this.ueu != null) {
        i = paramInt + e.a.a.b.b.a.f(10, this.ueu);
      }
      i += e.a.a.a.c(11, 2, this.wIy);
      paramInt = i;
      if (this.wIz != null) {
        paramInt = i + e.a.a.b.b.a.f(12, this.wIz);
      }
      i = paramInt;
      if (this.knU != null) {
        i = paramInt + e.a.a.b.b.a.f(13, this.knU);
      }
      i = i + e.a.a.b.b.a.bl(14, this.wIA) + e.a.a.b.b.a.bl(15, this.wIB);
      paramInt = i;
      if (this.wIk != null) {
        paramInt = i + e.a.a.a.iP(16, this.wIk.computeSize());
      }
      AppMethodBeat.o(48796);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wIy.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(48796);
          throw paramVarArgs;
        }
        AppMethodBeat.o(48796);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        qc localqc = (qc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(48796);
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
            localqc.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48796);
          return 0;
        case 2: 
          localqc.cnK = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48796);
          return 0;
        case 3: 
          localqc.kNv = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48796);
          return 0;
        case 4: 
          localqc.wIv = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(48796);
          return 0;
        case 5: 
          localqc.qiN = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48796);
          return 0;
        case 6: 
          localqc.wIw = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48796);
          return 0;
        case 7: 
          localqc.jVh = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48796);
          return 0;
        case 8: 
          localqc.wIx = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48796);
          return 0;
        case 9: 
          localqc.desc = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48796);
          return 0;
        case 10: 
          localqc.ueu = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48796);
          return 0;
        case 11: 
          localqc.wIy.add(Integer.valueOf(((e.a.a.a.a)localObject1).CLY.sl()));
          AppMethodBeat.o(48796);
          return 0;
        case 12: 
          localqc.wIz = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48796);
          return 0;
        case 13: 
          localqc.knU = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48796);
          return 0;
        case 14: 
          localqc.wIA = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48796);
          return 0;
        case 15: 
          localqc.wIB = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48796);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bry();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bry)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localqc.wIk = ((bry)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(48796);
        return 0;
      }
      AppMethodBeat.o(48796);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qc
 * JD-Core Version:    0.7.0.1
 */