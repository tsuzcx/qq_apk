package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bcb
  extends cld
{
  public LinkedList<amf> Cxt;
  public LinkedList<cxr> Cyc;
  public String DzA;
  public dxc DzB;
  public LinkedList<dxe> DzC;
  public LinkedList<dxd> DzD;
  public LinkedList<String> DzE;
  public String DzF;
  public String DzG;
  public LinkedList<pq> DzH;
  public boolean DzI;
  public String oXY;
  public String oXZ;
  public boolean oYi;
  public int peJ;
  public String source;
  
  public bcb()
  {
    AppMethodBeat.i(32279);
    this.DzC = new LinkedList();
    this.DzD = new LinkedList();
    this.DzE = new LinkedList();
    this.Cyc = new LinkedList();
    this.Cxt = new LinkedList();
    this.DzH = new LinkedList();
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
      if (this.DzA == null)
      {
        paramVarArgs = new b("Not all required fields were included: coverurl");
        AppMethodBeat.o(32280);
        throw paramVarArgs;
      }
      if (this.oXZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: motto");
        AppMethodBeat.o(32280);
        throw paramVarArgs;
      }
      if (this.DzB == null)
      {
        paramVarArgs = new b("Not all required fields were included: rankdesc");
        AppMethodBeat.o(32280);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.DzA != null) {
        paramVarArgs.d(2, this.DzA);
      }
      if (this.oXZ != null) {
        paramVarArgs.d(3, this.oXZ);
      }
      if (this.DzB != null)
      {
        paramVarArgs.kX(4, this.DzB.computeSize());
        this.DzB.writeFields(paramVarArgs);
      }
      paramVarArgs.e(5, 8, this.DzC);
      paramVarArgs.e(6, 8, this.DzD);
      if (this.source != null) {
        paramVarArgs.d(7, this.source);
      }
      paramVarArgs.e(8, 1, this.DzE);
      if (this.DzF != null) {
        paramVarArgs.d(9, this.DzF);
      }
      if (this.DzG != null) {
        paramVarArgs.d(10, this.DzG);
      }
      paramVarArgs.e(14, 8, this.Cyc);
      paramVarArgs.e(15, 8, this.Cxt);
      paramVarArgs.bg(16, this.oYi);
      paramVarArgs.e(17, 8, this.DzH);
      paramVarArgs.bg(18, this.DzI);
      paramVarArgs.aR(19, this.peJ);
      if (this.oXY != null) {
        paramVarArgs.d(20, this.oXY);
      }
      AppMethodBeat.o(32280);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1953;
      }
    }
    label1953:
    for (int i = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DzA != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DzA);
      }
      i = paramInt;
      if (this.oXZ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.oXZ);
      }
      paramInt = i;
      if (this.DzB != null) {
        paramInt = i + f.a.a.a.kW(4, this.DzB.computeSize());
      }
      i = paramInt + f.a.a.a.c(5, 8, this.DzC) + f.a.a.a.c(6, 8, this.DzD);
      paramInt = i;
      if (this.source != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.source);
      }
      i = paramInt + f.a.a.a.c(8, 1, this.DzE);
      paramInt = i;
      if (this.DzF != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.DzF);
      }
      i = paramInt;
      if (this.DzG != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.DzG);
      }
      i = i + f.a.a.a.c(14, 8, this.Cyc) + f.a.a.a.c(15, 8, this.Cxt) + (f.a.a.b.b.a.fY(16) + 1) + f.a.a.a.c(17, 8, this.DzH) + (f.a.a.b.b.a.fY(18) + 1) + f.a.a.b.b.a.bA(19, this.peJ);
      paramInt = i;
      if (this.oXY != null) {
        paramInt = i + f.a.a.b.b.a.e(20, this.oXY);
      }
      AppMethodBeat.o(32280);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DzC.clear();
        this.DzD.clear();
        this.DzE.clear();
        this.Cyc.clear();
        this.Cxt.clear();
        this.DzH.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32280);
          throw paramVarArgs;
        }
        if (this.DzA == null)
        {
          paramVarArgs = new b("Not all required fields were included: coverurl");
          AppMethodBeat.o(32280);
          throw paramVarArgs;
        }
        if (this.oXZ == null)
        {
          paramVarArgs = new b("Not all required fields were included: motto");
          AppMethodBeat.o(32280);
          throw paramVarArgs;
        }
        if (this.DzB == null)
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
        bcb localbcb = (bcb)paramVarArgs[1];
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
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbcb.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32280);
          return 0;
        case 2: 
          localbcb.DzA = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32280);
          return 0;
        case 3: 
          localbcb.oXZ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32280);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dxc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dxc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbcb.DzB = ((dxc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32280);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dxe();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dxe)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbcb.DzC.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32280);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dxd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dxd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbcb.DzD.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32280);
          return 0;
        case 7: 
          localbcb.source = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32280);
          return 0;
        case 8: 
          localbcb.DzE.add(((f.a.a.a.a)localObject1).KhF.readString());
          AppMethodBeat.o(32280);
          return 0;
        case 9: 
          localbcb.DzF = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32280);
          return 0;
        case 10: 
          localbcb.DzG = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32280);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxr();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbcb.Cyc.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32280);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new amf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((amf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbcb.Cxt.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32280);
          return 0;
        case 16: 
          localbcb.oYi = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(32280);
          return 0;
        case 17: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new pq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((pq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbcb.DzH.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32280);
          return 0;
        case 18: 
          localbcb.DzI = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(32280);
          return 0;
        case 19: 
          localbcb.peJ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32280);
          return 0;
        }
        localbcb.oXY = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(32280);
        return 0;
      }
      AppMethodBeat.o(32280);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcb
 * JD-Core Version:    0.7.0.1
 */