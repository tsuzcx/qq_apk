package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class pw
  extends bvk
{
  public int cnK;
  public String kNG;
  public String kNH;
  public int qkj;
  public String qkk;
  public String qkl;
  public String ueu;
  public String url;
  public int wIa;
  public LinkedList<bda> wId;
  public bda wIe;
  public String wIf;
  public boolean wIg;
  public String wIh;
  public int wIi;
  public bdh wIj;
  public bry wIk;
  
  public pw()
  {
    AppMethodBeat.i(56752);
    this.wId = new LinkedList();
    AppMethodBeat.o(56752);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56753);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(56753);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.e(2, this.url);
      }
      paramVarArgs.e(3, 8, this.wId);
      if (this.wIe != null)
      {
        paramVarArgs.iQ(4, this.wIe.computeSize());
        this.wIe.writeFields(paramVarArgs);
      }
      if (this.ueu != null) {
        paramVarArgs.e(5, this.ueu);
      }
      if (this.wIf != null) {
        paramVarArgs.e(6, this.wIf);
      }
      paramVarArgs.aS(7, this.wIg);
      paramVarArgs.aO(8, this.qkj);
      if (this.wIh != null) {
        paramVarArgs.e(9, this.wIh);
      }
      if (this.qkk != null) {
        paramVarArgs.e(10, this.qkk);
      }
      if (this.qkl != null) {
        paramVarArgs.e(11, this.qkl);
      }
      paramVarArgs.aO(12, this.wIi);
      if (this.wIj != null)
      {
        paramVarArgs.iQ(13, this.wIj.computeSize());
        this.wIj.writeFields(paramVarArgs);
      }
      if (this.wIk != null)
      {
        paramVarArgs.iQ(14, this.wIk.computeSize());
        this.wIk.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(15, this.cnK);
      paramVarArgs.aO(16, this.wIa);
      if (this.kNG != null) {
        paramVarArgs.e(17, this.kNG);
      }
      if (this.kNH != null) {
        paramVarArgs.e(18, this.kNH);
      }
      AppMethodBeat.o(56753);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1682;
      }
    }
    label1682:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.url != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.url);
      }
      i += e.a.a.a.c(3, 8, this.wId);
      paramInt = i;
      if (this.wIe != null) {
        paramInt = i + e.a.a.a.iP(4, this.wIe.computeSize());
      }
      i = paramInt;
      if (this.ueu != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.ueu);
      }
      paramInt = i;
      if (this.wIf != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wIf);
      }
      i = paramInt + (e.a.a.b.b.a.eW(7) + 1) + e.a.a.b.b.a.bl(8, this.qkj);
      paramInt = i;
      if (this.wIh != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.wIh);
      }
      i = paramInt;
      if (this.qkk != null) {
        i = paramInt + e.a.a.b.b.a.f(10, this.qkk);
      }
      paramInt = i;
      if (this.qkl != null) {
        paramInt = i + e.a.a.b.b.a.f(11, this.qkl);
      }
      i = paramInt + e.a.a.b.b.a.bl(12, this.wIi);
      paramInt = i;
      if (this.wIj != null) {
        paramInt = i + e.a.a.a.iP(13, this.wIj.computeSize());
      }
      i = paramInt;
      if (this.wIk != null) {
        i = paramInt + e.a.a.a.iP(14, this.wIk.computeSize());
      }
      i = i + e.a.a.b.b.a.bl(15, this.cnK) + e.a.a.b.b.a.bl(16, this.wIa);
      paramInt = i;
      if (this.kNG != null) {
        paramInt = i + e.a.a.b.b.a.f(17, this.kNG);
      }
      i = paramInt;
      if (this.kNH != null) {
        i = paramInt + e.a.a.b.b.a.f(18, this.kNH);
      }
      AppMethodBeat.o(56753);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wId.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(56753);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56753);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        pw localpw = (pw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56753);
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
            localpw.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56753);
          return 0;
        case 2: 
          localpw.url = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56753);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bda();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bda)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localpw.wId.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56753);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bda();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bda)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localpw.wIe = ((bda)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56753);
          return 0;
        case 5: 
          localpw.ueu = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56753);
          return 0;
        case 6: 
          localpw.wIf = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56753);
          return 0;
        case 7: 
          localpw.wIg = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(56753);
          return 0;
        case 8: 
          localpw.qkj = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56753);
          return 0;
        case 9: 
          localpw.wIh = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56753);
          return 0;
        case 10: 
          localpw.qkk = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56753);
          return 0;
        case 11: 
          localpw.qkl = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56753);
          return 0;
        case 12: 
          localpw.wIi = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56753);
          return 0;
        case 13: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bdh();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bdh)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localpw.wIj = ((bdh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56753);
          return 0;
        case 14: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bry();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bry)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localpw.wIk = ((bry)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56753);
          return 0;
        case 15: 
          localpw.cnK = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56753);
          return 0;
        case 16: 
          localpw.wIa = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56753);
          return 0;
        case 17: 
          localpw.kNG = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56753);
          return 0;
        }
        localpw.kNH = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56753);
        return 0;
      }
      AppMethodBeat.o(56753);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pw
 * JD-Core Version:    0.7.0.1
 */