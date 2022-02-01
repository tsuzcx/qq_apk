package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bzn
  extends com.tencent.mm.bw.a
{
  public cxn GtY;
  public cxn GtZ;
  public int Gto;
  public cxn GuK;
  public cxn Hed;
  public int Hhu;
  public String Hhv;
  public int Hns;
  public cxn Hnt;
  public cxn Hnu;
  public cxn Hnv;
  public int jfV;
  public String jfW;
  public String jfX;
  public String jfY;
  public int jfZ;
  public String jge;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101823);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GuK == null)
      {
        paramVarArgs = new b("Not all required fields were included: MemberName");
        AppMethodBeat.o(101823);
        throw paramVarArgs;
      }
      if (this.Hed == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(101823);
        throw paramVarArgs;
      }
      if (this.GtY == null)
      {
        paramVarArgs = new b("Not all required fields were included: PYInitial");
        AppMethodBeat.o(101823);
        throw paramVarArgs;
      }
      if (this.GtZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: QuanPin");
        AppMethodBeat.o(101823);
        throw paramVarArgs;
      }
      if (this.Hnt == null)
      {
        paramVarArgs = new b("Not all required fields were included: Remark");
        AppMethodBeat.o(101823);
        throw paramVarArgs;
      }
      if (this.Hnu == null)
      {
        paramVarArgs = new b("Not all required fields were included: RemarkPYInitial");
        AppMethodBeat.o(101823);
        throw paramVarArgs;
      }
      if (this.Hnv == null)
      {
        paramVarArgs = new b("Not all required fields were included: RemarkQuanPin");
        AppMethodBeat.o(101823);
        throw paramVarArgs;
      }
      if (this.GuK != null)
      {
        paramVarArgs.lJ(1, this.GuK.computeSize());
        this.GuK.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.Hns);
      if (this.Hed != null)
      {
        paramVarArgs.lJ(3, this.Hed.computeSize());
        this.Hed.writeFields(paramVarArgs);
      }
      if (this.GtY != null)
      {
        paramVarArgs.lJ(4, this.GtY.computeSize());
        this.GtY.writeFields(paramVarArgs);
      }
      if (this.GtZ != null)
      {
        paramVarArgs.lJ(5, this.GtZ.computeSize());
        this.GtZ.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(6, this.jfV);
      if (this.Hnt != null)
      {
        paramVarArgs.lJ(9, this.Hnt.computeSize());
        this.Hnt.writeFields(paramVarArgs);
      }
      if (this.Hnu != null)
      {
        paramVarArgs.lJ(10, this.Hnu.computeSize());
        this.Hnu.writeFields(paramVarArgs);
      }
      if (this.Hnv != null)
      {
        paramVarArgs.lJ(11, this.Hnv.computeSize());
        this.Hnv.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(12, this.Gto);
      if (this.jfW != null) {
        paramVarArgs.d(13, this.jfW);
      }
      if (this.jfX != null) {
        paramVarArgs.d(14, this.jfX);
      }
      if (this.jfY != null) {
        paramVarArgs.d(15, this.jfY);
      }
      paramVarArgs.aS(16, this.jfZ);
      paramVarArgs.aS(17, this.Hhu);
      if (this.Hhv != null) {
        paramVarArgs.d(18, this.Hhv);
      }
      if (this.jge != null) {
        paramVarArgs.d(19, this.jge);
      }
      AppMethodBeat.o(101823);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GuK == null) {
        break label2122;
      }
    }
    label2122:
    for (paramInt = f.a.a.a.lI(1, this.GuK.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.Hns);
      paramInt = i;
      if (this.Hed != null) {
        paramInt = i + f.a.a.a.lI(3, this.Hed.computeSize());
      }
      i = paramInt;
      if (this.GtY != null) {
        i = paramInt + f.a.a.a.lI(4, this.GtY.computeSize());
      }
      paramInt = i;
      if (this.GtZ != null) {
        paramInt = i + f.a.a.a.lI(5, this.GtZ.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.jfV);
      paramInt = i;
      if (this.Hnt != null) {
        paramInt = i + f.a.a.a.lI(9, this.Hnt.computeSize());
      }
      i = paramInt;
      if (this.Hnu != null) {
        i = paramInt + f.a.a.a.lI(10, this.Hnu.computeSize());
      }
      paramInt = i;
      if (this.Hnv != null) {
        paramInt = i + f.a.a.a.lI(11, this.Hnv.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(12, this.Gto);
      paramInt = i;
      if (this.jfW != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.jfW);
      }
      i = paramInt;
      if (this.jfX != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.jfX);
      }
      paramInt = i;
      if (this.jfY != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.jfY);
      }
      i = paramInt + f.a.a.b.b.a.bz(16, this.jfZ) + f.a.a.b.b.a.bz(17, this.Hhu);
      paramInt = i;
      if (this.Hhv != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.Hhv);
      }
      i = paramInt;
      if (this.jge != null) {
        i = paramInt + f.a.a.b.b.a.e(19, this.jge);
      }
      AppMethodBeat.o(101823);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.GuK == null)
        {
          paramVarArgs = new b("Not all required fields were included: MemberName");
          AppMethodBeat.o(101823);
          throw paramVarArgs;
        }
        if (this.Hed == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(101823);
          throw paramVarArgs;
        }
        if (this.GtY == null)
        {
          paramVarArgs = new b("Not all required fields were included: PYInitial");
          AppMethodBeat.o(101823);
          throw paramVarArgs;
        }
        if (this.GtZ == null)
        {
          paramVarArgs = new b("Not all required fields were included: QuanPin");
          AppMethodBeat.o(101823);
          throw paramVarArgs;
        }
        if (this.Hnt == null)
        {
          paramVarArgs = new b("Not all required fields were included: Remark");
          AppMethodBeat.o(101823);
          throw paramVarArgs;
        }
        if (this.Hnu == null)
        {
          paramVarArgs = new b("Not all required fields were included: RemarkPYInitial");
          AppMethodBeat.o(101823);
          throw paramVarArgs;
        }
        if (this.Hnv == null)
        {
          paramVarArgs = new b("Not all required fields were included: RemarkQuanPin");
          AppMethodBeat.o(101823);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101823);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bzn localbzn = (bzn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 7: 
        case 8: 
        default: 
          AppMethodBeat.o(101823);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbzn.GuK = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101823);
          return 0;
        case 2: 
          localbzn.Hns = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(101823);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbzn.Hed = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101823);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbzn.GtY = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101823);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbzn.GtZ = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101823);
          return 0;
        case 6: 
          localbzn.jfV = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(101823);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbzn.Hnt = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101823);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbzn.Hnu = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101823);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbzn.Hnv = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101823);
          return 0;
        case 12: 
          localbzn.Gto = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(101823);
          return 0;
        case 13: 
          localbzn.jfW = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(101823);
          return 0;
        case 14: 
          localbzn.jfX = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(101823);
          return 0;
        case 15: 
          localbzn.jfY = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(101823);
          return 0;
        case 16: 
          localbzn.jfZ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(101823);
          return 0;
        case 17: 
          localbzn.Hhu = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(101823);
          return 0;
        case 18: 
          localbzn.Hhv = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(101823);
          return 0;
        }
        localbzn.jge = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(101823);
        return 0;
      }
      AppMethodBeat.o(101823);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzn
 * JD-Core Version:    0.7.0.1
 */