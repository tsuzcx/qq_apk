package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bcx
  extends com.tencent.mm.bv.a
{
  public int gwP;
  public String gwQ;
  public String gwR;
  public String gwS;
  public int gwT;
  public String gwY;
  public int wNQ;
  public bwc wOY;
  public bwc wOv;
  public bwc wOw;
  public bwc xmi;
  public int xpe;
  public String xpf;
  public int xsS;
  public bwc xsT;
  public bwc xsU;
  public bwc xsV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(5594);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wOY == null)
      {
        paramVarArgs = new b("Not all required fields were included: MemberName");
        AppMethodBeat.o(5594);
        throw paramVarArgs;
      }
      if (this.xmi == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(5594);
        throw paramVarArgs;
      }
      if (this.wOv == null)
      {
        paramVarArgs = new b("Not all required fields were included: PYInitial");
        AppMethodBeat.o(5594);
        throw paramVarArgs;
      }
      if (this.wOw == null)
      {
        paramVarArgs = new b("Not all required fields were included: QuanPin");
        AppMethodBeat.o(5594);
        throw paramVarArgs;
      }
      if (this.xsT == null)
      {
        paramVarArgs = new b("Not all required fields were included: Remark");
        AppMethodBeat.o(5594);
        throw paramVarArgs;
      }
      if (this.xsU == null)
      {
        paramVarArgs = new b("Not all required fields were included: RemarkPYInitial");
        AppMethodBeat.o(5594);
        throw paramVarArgs;
      }
      if (this.xsV == null)
      {
        paramVarArgs = new b("Not all required fields were included: RemarkQuanPin");
        AppMethodBeat.o(5594);
        throw paramVarArgs;
      }
      if (this.wOY != null)
      {
        paramVarArgs.iQ(1, this.wOY.computeSize());
        this.wOY.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.xsS);
      if (this.xmi != null)
      {
        paramVarArgs.iQ(3, this.xmi.computeSize());
        this.xmi.writeFields(paramVarArgs);
      }
      if (this.wOv != null)
      {
        paramVarArgs.iQ(4, this.wOv.computeSize());
        this.wOv.writeFields(paramVarArgs);
      }
      if (this.wOw != null)
      {
        paramVarArgs.iQ(5, this.wOw.computeSize());
        this.wOw.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(6, this.gwP);
      if (this.xsT != null)
      {
        paramVarArgs.iQ(9, this.xsT.computeSize());
        this.xsT.writeFields(paramVarArgs);
      }
      if (this.xsU != null)
      {
        paramVarArgs.iQ(10, this.xsU.computeSize());
        this.xsU.writeFields(paramVarArgs);
      }
      if (this.xsV != null)
      {
        paramVarArgs.iQ(11, this.xsV.computeSize());
        this.xsV.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(12, this.wNQ);
      if (this.gwQ != null) {
        paramVarArgs.e(13, this.gwQ);
      }
      if (this.gwR != null) {
        paramVarArgs.e(14, this.gwR);
      }
      if (this.gwS != null) {
        paramVarArgs.e(15, this.gwS);
      }
      paramVarArgs.aO(16, this.gwT);
      paramVarArgs.aO(17, this.xpe);
      if (this.xpf != null) {
        paramVarArgs.e(18, this.xpf);
      }
      if (this.gwY != null) {
        paramVarArgs.e(19, this.gwY);
      }
      AppMethodBeat.o(5594);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wOY == null) {
        break label2157;
      }
    }
    label2157:
    for (paramInt = e.a.a.a.iP(1, this.wOY.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.xsS);
      paramInt = i;
      if (this.xmi != null) {
        paramInt = i + e.a.a.a.iP(3, this.xmi.computeSize());
      }
      i = paramInt;
      if (this.wOv != null) {
        i = paramInt + e.a.a.a.iP(4, this.wOv.computeSize());
      }
      paramInt = i;
      if (this.wOw != null) {
        paramInt = i + e.a.a.a.iP(5, this.wOw.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(6, this.gwP);
      paramInt = i;
      if (this.xsT != null) {
        paramInt = i + e.a.a.a.iP(9, this.xsT.computeSize());
      }
      i = paramInt;
      if (this.xsU != null) {
        i = paramInt + e.a.a.a.iP(10, this.xsU.computeSize());
      }
      paramInt = i;
      if (this.xsV != null) {
        paramInt = i + e.a.a.a.iP(11, this.xsV.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(12, this.wNQ);
      paramInt = i;
      if (this.gwQ != null) {
        paramInt = i + e.a.a.b.b.a.f(13, this.gwQ);
      }
      i = paramInt;
      if (this.gwR != null) {
        i = paramInt + e.a.a.b.b.a.f(14, this.gwR);
      }
      paramInt = i;
      if (this.gwS != null) {
        paramInt = i + e.a.a.b.b.a.f(15, this.gwS);
      }
      i = paramInt + e.a.a.b.b.a.bl(16, this.gwT) + e.a.a.b.b.a.bl(17, this.xpe);
      paramInt = i;
      if (this.xpf != null) {
        paramInt = i + e.a.a.b.b.a.f(18, this.xpf);
      }
      i = paramInt;
      if (this.gwY != null) {
        i = paramInt + e.a.a.b.b.a.f(19, this.gwY);
      }
      AppMethodBeat.o(5594);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wOY == null)
        {
          paramVarArgs = new b("Not all required fields were included: MemberName");
          AppMethodBeat.o(5594);
          throw paramVarArgs;
        }
        if (this.xmi == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(5594);
          throw paramVarArgs;
        }
        if (this.wOv == null)
        {
          paramVarArgs = new b("Not all required fields were included: PYInitial");
          AppMethodBeat.o(5594);
          throw paramVarArgs;
        }
        if (this.wOw == null)
        {
          paramVarArgs = new b("Not all required fields were included: QuanPin");
          AppMethodBeat.o(5594);
          throw paramVarArgs;
        }
        if (this.xsT == null)
        {
          paramVarArgs = new b("Not all required fields were included: Remark");
          AppMethodBeat.o(5594);
          throw paramVarArgs;
        }
        if (this.xsU == null)
        {
          paramVarArgs = new b("Not all required fields were included: RemarkPYInitial");
          AppMethodBeat.o(5594);
          throw paramVarArgs;
        }
        if (this.xsV == null)
        {
          paramVarArgs = new b("Not all required fields were included: RemarkQuanPin");
          AppMethodBeat.o(5594);
          throw paramVarArgs;
        }
        AppMethodBeat.o(5594);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bcx localbcx = (bcx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 7: 
        case 8: 
        default: 
          AppMethodBeat.o(5594);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbcx.wOY = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5594);
          return 0;
        case 2: 
          localbcx.xsS = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5594);
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
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbcx.xmi = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5594);
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
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbcx.wOv = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5594);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbcx.wOw = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5594);
          return 0;
        case 6: 
          localbcx.gwP = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5594);
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
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbcx.xsT = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5594);
          return 0;
        case 10: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbcx.xsU = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5594);
          return 0;
        case 11: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbcx.xsV = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5594);
          return 0;
        case 12: 
          localbcx.wNQ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5594);
          return 0;
        case 13: 
          localbcx.gwQ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(5594);
          return 0;
        case 14: 
          localbcx.gwR = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(5594);
          return 0;
        case 15: 
          localbcx.gwS = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(5594);
          return 0;
        case 16: 
          localbcx.gwT = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5594);
          return 0;
        case 17: 
          localbcx.xpe = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5594);
          return 0;
        case 18: 
          localbcx.xpf = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(5594);
          return 0;
        }
        localbcx.gwY = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(5594);
        return 0;
      }
      AppMethodBeat.o(5594);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcx
 * JD-Core Version:    0.7.0.1
 */