package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ctg
  extends cld
{
  public String DRl;
  public gt Ejf;
  public int EkP;
  public gs EkQ;
  public String EkR;
  public LinkedList<gu> EkS;
  public String EkT;
  public String EkU;
  public gv EkV;
  public LinkedList<gv> EkW;
  public dkd EkX;
  public boolean EkY;
  public String EkZ;
  public gr Ela;
  public String dgo;
  public String gIw;
  public String title;
  
  public ctg()
  {
    AppMethodBeat.i(123652);
    this.EkS = new LinkedList();
    this.EkW = new LinkedList();
    AppMethodBeat.o(123652);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123653);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123653);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Ejf != null)
      {
        paramVarArgs.kX(2, this.Ejf.computeSize());
        this.Ejf.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.EkP);
      if (this.EkQ != null)
      {
        paramVarArgs.kX(4, this.EkQ.computeSize());
        this.EkQ.writeFields(paramVarArgs);
      }
      if (this.title != null) {
        paramVarArgs.d(5, this.title);
      }
      if (this.DRl != null) {
        paramVarArgs.d(6, this.DRl);
      }
      if (this.gIw != null) {
        paramVarArgs.d(7, this.gIw);
      }
      if (this.EkR != null) {
        paramVarArgs.d(8, this.EkR);
      }
      paramVarArgs.e(9, 8, this.EkS);
      if (this.EkT != null) {
        paramVarArgs.d(10, this.EkT);
      }
      if (this.EkU != null) {
        paramVarArgs.d(11, this.EkU);
      }
      if (this.EkV != null)
      {
        paramVarArgs.kX(12, this.EkV.computeSize());
        this.EkV.writeFields(paramVarArgs);
      }
      paramVarArgs.e(13, 8, this.EkW);
      if (this.dgo != null) {
        paramVarArgs.d(14, this.dgo);
      }
      if (this.EkX != null)
      {
        paramVarArgs.kX(15, this.EkX.computeSize());
        this.EkX.writeFields(paramVarArgs);
      }
      paramVarArgs.bg(16, this.EkY);
      if (this.EkZ != null) {
        paramVarArgs.d(17, this.EkZ);
      }
      if (this.Ela != null)
      {
        paramVarArgs.kX(19, this.Ela.computeSize());
        this.Ela.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(123653);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2006;
      }
    }
    label2006:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Ejf != null) {
        i = paramInt + f.a.a.a.kW(2, this.Ejf.computeSize());
      }
      i += f.a.a.b.b.a.bA(3, this.EkP);
      paramInt = i;
      if (this.EkQ != null) {
        paramInt = i + f.a.a.a.kW(4, this.EkQ.computeSize());
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.title);
      }
      paramInt = i;
      if (this.DRl != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DRl);
      }
      i = paramInt;
      if (this.gIw != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.gIw);
      }
      paramInt = i;
      if (this.EkR != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.EkR);
      }
      i = paramInt + f.a.a.a.c(9, 8, this.EkS);
      paramInt = i;
      if (this.EkT != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.EkT);
      }
      i = paramInt;
      if (this.EkU != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.EkU);
      }
      paramInt = i;
      if (this.EkV != null) {
        paramInt = i + f.a.a.a.kW(12, this.EkV.computeSize());
      }
      i = paramInt + f.a.a.a.c(13, 8, this.EkW);
      paramInt = i;
      if (this.dgo != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.dgo);
      }
      i = paramInt;
      if (this.EkX != null) {
        i = paramInt + f.a.a.a.kW(15, this.EkX.computeSize());
      }
      i += f.a.a.b.b.a.fY(16) + 1;
      paramInt = i;
      if (this.EkZ != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.EkZ);
      }
      i = paramInt;
      if (this.Ela != null) {
        i = paramInt + f.a.a.a.kW(19, this.Ela.computeSize());
      }
      AppMethodBeat.o(123653);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EkS.clear();
        this.EkW.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(123653);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123653);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ctg localctg = (ctg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 18: 
        default: 
          AppMethodBeat.o(123653);
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
            localctg.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123653);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localctg.Ejf = ((gt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123653);
          return 0;
        case 3: 
          localctg.EkP = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(123653);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gs();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gs)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localctg.EkQ = ((gs)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123653);
          return 0;
        case 5: 
          localctg.title = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123653);
          return 0;
        case 6: 
          localctg.DRl = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123653);
          return 0;
        case 7: 
          localctg.gIw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123653);
          return 0;
        case 8: 
          localctg.EkR = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123653);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localctg.EkS.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123653);
          return 0;
        case 10: 
          localctg.EkT = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123653);
          return 0;
        case 11: 
          localctg.EkU = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123653);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localctg.EkV = ((gv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123653);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localctg.EkW.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123653);
          return 0;
        case 14: 
          localctg.dgo = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123653);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dkd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dkd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localctg.EkX = ((dkd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123653);
          return 0;
        case 16: 
          localctg.EkY = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(123653);
          return 0;
        case 17: 
          localctg.EkZ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123653);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new gr();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((gr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localctg.Ela = ((gr)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(123653);
        return 0;
      }
      AppMethodBeat.o(123653);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctg
 * JD-Core Version:    0.7.0.1
 */