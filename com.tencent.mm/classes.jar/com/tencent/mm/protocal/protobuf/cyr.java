package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cyr
  extends cqk
{
  public gx FGd;
  public int FHN;
  public gw FHO;
  public String FHP;
  public LinkedList<gy> FHQ;
  public String FHR;
  public String FHS;
  public gz FHT;
  public LinkedList<gz> FHU;
  public dps FHV;
  public boolean FHW;
  public String FHX;
  public gv FHY;
  public String FnD;
  public String ddJ;
  public String hiX;
  public String title;
  
  public cyr()
  {
    AppMethodBeat.i(123652);
    this.FHQ = new LinkedList();
    this.FHU = new LinkedList();
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
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.FGd != null)
      {
        paramVarArgs.ln(2, this.FGd.computeSize());
        this.FGd.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.FHN);
      if (this.FHO != null)
      {
        paramVarArgs.ln(4, this.FHO.computeSize());
        this.FHO.writeFields(paramVarArgs);
      }
      if (this.title != null) {
        paramVarArgs.d(5, this.title);
      }
      if (this.FnD != null) {
        paramVarArgs.d(6, this.FnD);
      }
      if (this.hiX != null) {
        paramVarArgs.d(7, this.hiX);
      }
      if (this.FHP != null) {
        paramVarArgs.d(8, this.FHP);
      }
      paramVarArgs.e(9, 8, this.FHQ);
      if (this.FHR != null) {
        paramVarArgs.d(10, this.FHR);
      }
      if (this.FHS != null) {
        paramVarArgs.d(11, this.FHS);
      }
      if (this.FHT != null)
      {
        paramVarArgs.ln(12, this.FHT.computeSize());
        this.FHT.writeFields(paramVarArgs);
      }
      paramVarArgs.e(13, 8, this.FHU);
      if (this.ddJ != null) {
        paramVarArgs.d(14, this.ddJ);
      }
      if (this.FHV != null)
      {
        paramVarArgs.ln(15, this.FHV.computeSize());
        this.FHV.writeFields(paramVarArgs);
      }
      paramVarArgs.bl(16, this.FHW);
      if (this.FHX != null) {
        paramVarArgs.d(17, this.FHX);
      }
      if (this.FHY != null)
      {
        paramVarArgs.ln(19, this.FHY.computeSize());
        this.FHY.writeFields(paramVarArgs);
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
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FGd != null) {
        i = paramInt + f.a.a.a.lm(2, this.FGd.computeSize());
      }
      i += f.a.a.b.b.a.bx(3, this.FHN);
      paramInt = i;
      if (this.FHO != null) {
        paramInt = i + f.a.a.a.lm(4, this.FHO.computeSize());
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.title);
      }
      paramInt = i;
      if (this.FnD != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FnD);
      }
      i = paramInt;
      if (this.hiX != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.hiX);
      }
      paramInt = i;
      if (this.FHP != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FHP);
      }
      i = paramInt + f.a.a.a.c(9, 8, this.FHQ);
      paramInt = i;
      if (this.FHR != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.FHR);
      }
      i = paramInt;
      if (this.FHS != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.FHS);
      }
      paramInt = i;
      if (this.FHT != null) {
        paramInt = i + f.a.a.a.lm(12, this.FHT.computeSize());
      }
      i = paramInt + f.a.a.a.c(13, 8, this.FHU);
      paramInt = i;
      if (this.ddJ != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.ddJ);
      }
      i = paramInt;
      if (this.FHV != null) {
        i = paramInt + f.a.a.a.lm(15, this.FHV.computeSize());
      }
      i += f.a.a.b.b.a.fK(16) + 1;
      paramInt = i;
      if (this.FHX != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.FHX);
      }
      i = paramInt;
      if (this.FHY != null) {
        i = paramInt + f.a.a.a.lm(19, this.FHY.computeSize());
      }
      AppMethodBeat.o(123653);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FHQ.clear();
        this.FHU.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
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
        cyr localcyr = (cyr)paramVarArgs[1];
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
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcyr.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123653);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcyr.FGd = ((gx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123653);
          return 0;
        case 3: 
          localcyr.FHN = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(123653);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcyr.FHO = ((gw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123653);
          return 0;
        case 5: 
          localcyr.title = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123653);
          return 0;
        case 6: 
          localcyr.FnD = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123653);
          return 0;
        case 7: 
          localcyr.hiX = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123653);
          return 0;
        case 8: 
          localcyr.FHP = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123653);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcyr.FHQ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123653);
          return 0;
        case 10: 
          localcyr.FHR = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123653);
          return 0;
        case 11: 
          localcyr.FHS = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123653);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcyr.FHT = ((gz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123653);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcyr.FHU.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123653);
          return 0;
        case 14: 
          localcyr.ddJ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123653);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dps();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dps)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcyr.FHV = ((dps)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123653);
          return 0;
        case 16: 
          localcyr.FHW = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(123653);
          return 0;
        case 17: 
          localcyr.FHX = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123653);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new gv();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((gv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcyr.FHY = ((gv)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyr
 * JD-Core Version:    0.7.0.1
 */