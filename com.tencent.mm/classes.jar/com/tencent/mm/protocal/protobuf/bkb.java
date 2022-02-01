package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bkb
  extends cvp
{
  public LinkedList<diq> FvN;
  public LinkedList<atc> Fve;
  public LinkedList<rc> GEA;
  public boolean GEB;
  public String GEt;
  public eiz GEu;
  public LinkedList<ejb> GEv;
  public LinkedList<eja> GEw;
  public LinkedList<String> GEx;
  public String GEy;
  public String GEz;
  public String qeO;
  public String qeP;
  public boolean qeY;
  public int qlz;
  public String source;
  
  public bkb()
  {
    AppMethodBeat.i(32279);
    this.GEv = new LinkedList();
    this.GEw = new LinkedList();
    this.GEx = new LinkedList();
    this.FvN = new LinkedList();
    this.Fve = new LinkedList();
    this.GEA = new LinkedList();
    AppMethodBeat.o(32279);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32280);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32280);
        throw paramVarArgs;
      }
      if (this.GEt == null)
      {
        paramVarArgs = new b("Not all required fields were included: coverurl");
        AppMethodBeat.o(32280);
        throw paramVarArgs;
      }
      if (this.qeP == null)
      {
        paramVarArgs = new b("Not all required fields were included: motto");
        AppMethodBeat.o(32280);
        throw paramVarArgs;
      }
      if (this.GEu == null)
      {
        paramVarArgs = new b("Not all required fields were included: rankdesc");
        AppMethodBeat.o(32280);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.GEt != null) {
        paramVarArgs.d(2, this.GEt);
      }
      if (this.qeP != null) {
        paramVarArgs.d(3, this.qeP);
      }
      if (this.GEu != null)
      {
        paramVarArgs.lC(4, this.GEu.computeSize());
        this.GEu.writeFields(paramVarArgs);
      }
      paramVarArgs.e(5, 8, this.GEv);
      paramVarArgs.e(6, 8, this.GEw);
      if (this.source != null) {
        paramVarArgs.d(7, this.source);
      }
      paramVarArgs.e(8, 1, this.GEx);
      if (this.GEy != null) {
        paramVarArgs.d(9, this.GEy);
      }
      if (this.GEz != null) {
        paramVarArgs.d(10, this.GEz);
      }
      paramVarArgs.e(14, 8, this.FvN);
      paramVarArgs.e(15, 8, this.Fve);
      paramVarArgs.bt(16, this.qeY);
      paramVarArgs.e(17, 8, this.GEA);
      paramVarArgs.bt(18, this.GEB);
      paramVarArgs.aS(19, this.qlz);
      if (this.qeO != null) {
        paramVarArgs.d(20, this.qeO);
      }
      AppMethodBeat.o(32280);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1949;
      }
    }
    label1949:
    for (int i = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GEt != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GEt);
      }
      i = paramInt;
      if (this.qeP != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.qeP);
      }
      paramInt = i;
      if (this.GEu != null) {
        paramInt = i + f.a.a.a.lB(4, this.GEu.computeSize());
      }
      i = paramInt + f.a.a.a.c(5, 8, this.GEv) + f.a.a.a.c(6, 8, this.GEw);
      paramInt = i;
      if (this.source != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.source);
      }
      i = paramInt + f.a.a.a.c(8, 1, this.GEx);
      paramInt = i;
      if (this.GEy != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.GEy);
      }
      i = paramInt;
      if (this.GEz != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.GEz);
      }
      i = i + f.a.a.a.c(14, 8, this.FvN) + f.a.a.a.c(15, 8, this.Fve) + f.a.a.b.b.a.alV(16) + f.a.a.a.c(17, 8, this.GEA) + f.a.a.b.b.a.alV(18) + f.a.a.b.b.a.bz(19, this.qlz);
      paramInt = i;
      if (this.qeO != null) {
        paramInt = i + f.a.a.b.b.a.e(20, this.qeO);
      }
      AppMethodBeat.o(32280);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GEv.clear();
        this.GEw.clear();
        this.GEx.clear();
        this.FvN.clear();
        this.Fve.clear();
        this.GEA.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32280);
          throw paramVarArgs;
        }
        if (this.GEt == null)
        {
          paramVarArgs = new b("Not all required fields were included: coverurl");
          AppMethodBeat.o(32280);
          throw paramVarArgs;
        }
        if (this.qeP == null)
        {
          paramVarArgs = new b("Not all required fields were included: motto");
          AppMethodBeat.o(32280);
          throw paramVarArgs;
        }
        if (this.GEu == null)
        {
          paramVarArgs = new b("Not all required fields were included: rankdesc");
          AppMethodBeat.o(32280);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32280);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bkb localbkb = (bkb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 11: 
        case 12: 
        case 13: 
        default: 
          AppMethodBeat.o(32280);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbkb.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32280);
          return 0;
        case 2: 
          localbkb.GEt = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32280);
          return 0;
        case 3: 
          localbkb.qeP = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32280);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eiz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eiz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbkb.GEu = ((eiz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32280);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ejb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ejb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbkb.GEv.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32280);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eja();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eja)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbkb.GEw.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32280);
          return 0;
        case 7: 
          localbkb.source = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32280);
          return 0;
        case 8: 
          localbkb.GEx.add(((f.a.a.a.a)localObject1).NPN.readString());
          AppMethodBeat.o(32280);
          return 0;
        case 9: 
          localbkb.GEy = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32280);
          return 0;
        case 10: 
          localbkb.GEz = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32280);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new diq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((diq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbkb.FvN.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32280);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new atc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((atc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbkb.Fve.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32280);
          return 0;
        case 16: 
          localbkb.qeY = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(32280);
          return 0;
        case 17: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((rc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbkb.GEA.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32280);
          return 0;
        case 18: 
          localbkb.GEB = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(32280);
          return 0;
        case 19: 
          localbkb.qlz = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32280);
          return 0;
        }
        localbkb.qeO = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(32280);
        return 0;
      }
      AppMethodBeat.o(32280);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkb
 * JD-Core Version:    0.7.0.1
 */