package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bgu
  extends cqk
{
  public String Desc;
  public int EVA;
  public LinkedList<dur> EVB;
  public String EVP;
  public String EVQ;
  public String EVR;
  public String EVS;
  public String EVT;
  public String EVU;
  public dux EVV;
  public String EVW;
  public String EVX;
  public String EVY;
  public String EVZ;
  public String EWa;
  public String Title;
  public String tLG;
  
  public bgu()
  {
    AppMethodBeat.i(32308);
    this.EVB = new LinkedList();
    AppMethodBeat.o(32308);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32309);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32309);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.EVP != null) {
        paramVarArgs.d(2, this.EVP);
      }
      if (this.tLG != null) {
        paramVarArgs.d(3, this.tLG);
      }
      if (this.Title != null) {
        paramVarArgs.d(4, this.Title);
      }
      if (this.Desc != null) {
        paramVarArgs.d(5, this.Desc);
      }
      if (this.EVQ != null) {
        paramVarArgs.d(6, this.EVQ);
      }
      if (this.EVR != null) {
        paramVarArgs.d(7, this.EVR);
      }
      if (this.EVS != null) {
        paramVarArgs.d(8, this.EVS);
      }
      if (this.EVT != null) {
        paramVarArgs.d(9, this.EVT);
      }
      if (this.EVU != null) {
        paramVarArgs.d(10, this.EVU);
      }
      if (this.EVV != null)
      {
        paramVarArgs.ln(11, this.EVV.computeSize());
        this.EVV.writeFields(paramVarArgs);
      }
      if (this.EVW != null) {
        paramVarArgs.d(12, this.EVW);
      }
      if (this.EVX != null) {
        paramVarArgs.d(13, this.EVX);
      }
      if (this.EVY != null) {
        paramVarArgs.d(14, this.EVY);
      }
      if (this.EVZ != null) {
        paramVarArgs.d(15, this.EVZ);
      }
      if (this.EWa != null) {
        paramVarArgs.d(16, this.EWa);
      }
      paramVarArgs.aR(17, this.EVA);
      paramVarArgs.e(18, 8, this.EVB);
      AppMethodBeat.o(32309);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1590;
      }
    }
    label1590:
    for (int i = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.EVP != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EVP);
      }
      i = paramInt;
      if (this.tLG != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.tLG);
      }
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Title);
      }
      i = paramInt;
      if (this.Desc != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Desc);
      }
      paramInt = i;
      if (this.EVQ != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.EVQ);
      }
      i = paramInt;
      if (this.EVR != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.EVR);
      }
      paramInt = i;
      if (this.EVS != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.EVS);
      }
      i = paramInt;
      if (this.EVT != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.EVT);
      }
      paramInt = i;
      if (this.EVU != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.EVU);
      }
      i = paramInt;
      if (this.EVV != null) {
        i = paramInt + f.a.a.a.lm(11, this.EVV.computeSize());
      }
      paramInt = i;
      if (this.EVW != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.EVW);
      }
      i = paramInt;
      if (this.EVX != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.EVX);
      }
      paramInt = i;
      if (this.EVY != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.EVY);
      }
      i = paramInt;
      if (this.EVZ != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.EVZ);
      }
      paramInt = i;
      if (this.EWa != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.EWa);
      }
      i = f.a.a.b.b.a.bx(17, this.EVA);
      int j = f.a.a.a.c(18, 8, this.EVB);
      AppMethodBeat.o(32309);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EVB.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32309);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32309);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bgu localbgu = (bgu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32309);
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
            localbgu.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32309);
          return 0;
        case 2: 
          localbgu.EVP = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 3: 
          localbgu.tLG = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 4: 
          localbgu.Title = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 5: 
          localbgu.Desc = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 6: 
          localbgu.EVQ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 7: 
          localbgu.EVR = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 8: 
          localbgu.EVS = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 9: 
          localbgu.EVT = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 10: 
          localbgu.EVU = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dux();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dux)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbgu.EVV = ((dux)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32309);
          return 0;
        case 12: 
          localbgu.EVW = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 13: 
          localbgu.EVX = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 14: 
          localbgu.EVY = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 15: 
          localbgu.EVZ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 16: 
          localbgu.EWa = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 17: 
          localbgu.EVA = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32309);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dur();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dur)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbgu.EVB.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32309);
        return 0;
      }
      AppMethodBeat.o(32309);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgu
 * JD-Core Version:    0.7.0.1
 */