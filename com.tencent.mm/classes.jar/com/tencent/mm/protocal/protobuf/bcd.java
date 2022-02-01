package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bcd
  extends cld
{
  public LinkedList<amf> Cxt;
  public LinkedList<String> DzE;
  public String DzF;
  public String DzG;
  public boolean DzI;
  public LinkedList<dxa> DzL;
  public LinkedList<dxb> DzM;
  public String DzN;
  public String DzO;
  public String DzP;
  public String DzQ;
  public boolean DzR;
  public int DzS;
  public String DzT;
  public String gHO;
  public boolean oYv;
  
  public bcd()
  {
    AppMethodBeat.i(32282);
    this.DzL = new LinkedList();
    this.DzM = new LinkedList();
    this.DzE = new LinkedList();
    this.Cxt = new LinkedList();
    AppMethodBeat.o(32282);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32283);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32283);
        throw paramVarArgs;
      }
      if (this.DzN == null)
      {
        paramVarArgs = new b("Not all required fields were included: championcoverurl");
        AppMethodBeat.o(32283);
        throw paramVarArgs;
      }
      if (this.DzO == null)
      {
        paramVarArgs = new b("Not all required fields were included: championmotto");
        AppMethodBeat.o(32283);
        throw paramVarArgs;
      }
      if (this.gHO == null)
      {
        paramVarArgs = new b("Not all required fields were included: rankid");
        AppMethodBeat.o(32283);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.DzL);
      paramVarArgs.e(3, 8, this.DzM);
      paramVarArgs.e(4, 1, this.DzE);
      if (this.DzN != null) {
        paramVarArgs.d(5, this.DzN);
      }
      if (this.DzO != null) {
        paramVarArgs.d(6, this.DzO);
      }
      if (this.gHO != null) {
        paramVarArgs.d(7, this.gHO);
      }
      if (this.DzP != null) {
        paramVarArgs.d(8, this.DzP);
      }
      if (this.DzF != null) {
        paramVarArgs.d(9, this.DzF);
      }
      paramVarArgs.bg(10, this.oYv);
      if (this.DzG != null) {
        paramVarArgs.d(11, this.DzG);
      }
      paramVarArgs.e(12, 8, this.Cxt);
      paramVarArgs.bg(13, this.DzI);
      if (this.DzQ != null) {
        paramVarArgs.d(14, this.DzQ);
      }
      paramVarArgs.bg(15, this.DzR);
      paramVarArgs.aR(16, this.DzS);
      if (this.DzT != null) {
        paramVarArgs.d(17, this.DzT);
      }
      AppMethodBeat.o(32283);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1677;
      }
    }
    label1677:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.DzL) + f.a.a.a.c(3, 8, this.DzM) + f.a.a.a.c(4, 1, this.DzE);
      paramInt = i;
      if (this.DzN != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.DzN);
      }
      i = paramInt;
      if (this.DzO != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.DzO);
      }
      paramInt = i;
      if (this.gHO != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.gHO);
      }
      i = paramInt;
      if (this.DzP != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.DzP);
      }
      paramInt = i;
      if (this.DzF != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.DzF);
      }
      i = paramInt + (f.a.a.b.b.a.fY(10) + 1);
      paramInt = i;
      if (this.DzG != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.DzG);
      }
      i = paramInt + f.a.a.a.c(12, 8, this.Cxt) + (f.a.a.b.b.a.fY(13) + 1);
      paramInt = i;
      if (this.DzQ != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.DzQ);
      }
      i = paramInt + (f.a.a.b.b.a.fY(15) + 1) + f.a.a.b.b.a.bA(16, this.DzS);
      paramInt = i;
      if (this.DzT != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.DzT);
      }
      AppMethodBeat.o(32283);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DzL.clear();
        this.DzM.clear();
        this.DzE.clear();
        this.Cxt.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32283);
          throw paramVarArgs;
        }
        if (this.DzN == null)
        {
          paramVarArgs = new b("Not all required fields were included: championcoverurl");
          AppMethodBeat.o(32283);
          throw paramVarArgs;
        }
        if (this.DzO == null)
        {
          paramVarArgs = new b("Not all required fields were included: championmotto");
          AppMethodBeat.o(32283);
          throw paramVarArgs;
        }
        if (this.gHO == null)
        {
          paramVarArgs = new b("Not all required fields were included: rankid");
          AppMethodBeat.o(32283);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32283);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bcd localbcd = (bcd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32283);
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
            localbcd.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32283);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dxa();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dxa)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbcd.DzL.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32283);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dxb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dxb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbcd.DzM.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32283);
          return 0;
        case 4: 
          localbcd.DzE.add(((f.a.a.a.a)localObject1).KhF.readString());
          AppMethodBeat.o(32283);
          return 0;
        case 5: 
          localbcd.DzN = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32283);
          return 0;
        case 6: 
          localbcd.DzO = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32283);
          return 0;
        case 7: 
          localbcd.gHO = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32283);
          return 0;
        case 8: 
          localbcd.DzP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32283);
          return 0;
        case 9: 
          localbcd.DzF = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32283);
          return 0;
        case 10: 
          localbcd.oYv = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(32283);
          return 0;
        case 11: 
          localbcd.DzG = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32283);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new amf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((amf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbcd.Cxt.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32283);
          return 0;
        case 13: 
          localbcd.DzI = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(32283);
          return 0;
        case 14: 
          localbcd.DzQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32283);
          return 0;
        case 15: 
          localbcd.DzR = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(32283);
          return 0;
        case 16: 
          localbcd.DzS = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32283);
          return 0;
        }
        localbcd.DzT = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(32283);
        return 0;
      }
      AppMethodBeat.o(32283);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcd
 * JD-Core Version:    0.7.0.1
 */