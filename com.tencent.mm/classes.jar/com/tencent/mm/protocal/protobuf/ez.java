package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ez
  extends cld
{
  public int CzA;
  public String CzB;
  public int CzC;
  public int CzD;
  public int CzE;
  public el CzF;
  public dkm CzG;
  public String CzH;
  public bol CzI;
  public ew CzJ;
  public LinkedList<String> CzK;
  public do CzL;
  public LinkedList<bmy> CzM;
  public String CzN;
  public LinkedList<fn> Czz;
  public String gGC;
  public String url;
  
  public ez()
  {
    AppMethodBeat.i(103195);
    this.Czz = new LinkedList();
    this.CzK = new LinkedList();
    this.CzM = new LinkedList();
    AppMethodBeat.o(103195);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103196);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(103196);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.Czz);
      paramVarArgs.aR(3, this.CzA);
      if (this.CzB != null) {
        paramVarArgs.d(4, this.CzB);
      }
      paramVarArgs.aR(5, this.CzC);
      paramVarArgs.aR(6, this.CzD);
      paramVarArgs.aR(7, this.CzE);
      if (this.CzF != null)
      {
        paramVarArgs.kX(8, this.CzF.computeSize());
        this.CzF.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.d(9, this.url);
      }
      if (this.gGC != null) {
        paramVarArgs.d(10, this.gGC);
      }
      if (this.CzG != null)
      {
        paramVarArgs.kX(11, this.CzG.computeSize());
        this.CzG.writeFields(paramVarArgs);
      }
      if (this.CzH != null) {
        paramVarArgs.d(12, this.CzH);
      }
      if (this.CzI != null)
      {
        paramVarArgs.kX(13, this.CzI.computeSize());
        this.CzI.writeFields(paramVarArgs);
      }
      if (this.CzJ != null)
      {
        paramVarArgs.kX(14, this.CzJ.computeSize());
        this.CzJ.writeFields(paramVarArgs);
      }
      paramVarArgs.e(15, 1, this.CzK);
      if (this.CzL != null)
      {
        paramVarArgs.kX(16, this.CzL.computeSize());
        this.CzL.writeFields(paramVarArgs);
      }
      paramVarArgs.e(17, 8, this.CzM);
      if (this.CzN != null) {
        paramVarArgs.d(18, this.CzN);
      }
      AppMethodBeat.o(103196);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1962;
      }
    }
    label1962:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.Czz) + f.a.a.b.b.a.bA(3, this.CzA);
      paramInt = i;
      if (this.CzB != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.CzB);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.CzC) + f.a.a.b.b.a.bA(6, this.CzD) + f.a.a.b.b.a.bA(7, this.CzE);
      paramInt = i;
      if (this.CzF != null) {
        paramInt = i + f.a.a.a.kW(8, this.CzF.computeSize());
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.url);
      }
      paramInt = i;
      if (this.gGC != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.gGC);
      }
      i = paramInt;
      if (this.CzG != null) {
        i = paramInt + f.a.a.a.kW(11, this.CzG.computeSize());
      }
      paramInt = i;
      if (this.CzH != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.CzH);
      }
      i = paramInt;
      if (this.CzI != null) {
        i = paramInt + f.a.a.a.kW(13, this.CzI.computeSize());
      }
      paramInt = i;
      if (this.CzJ != null) {
        paramInt = i + f.a.a.a.kW(14, this.CzJ.computeSize());
      }
      i = paramInt + f.a.a.a.c(15, 1, this.CzK);
      paramInt = i;
      if (this.CzL != null) {
        paramInt = i + f.a.a.a.kW(16, this.CzL.computeSize());
      }
      i = paramInt + f.a.a.a.c(17, 8, this.CzM);
      paramInt = i;
      if (this.CzN != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.CzN);
      }
      AppMethodBeat.o(103196);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Czz.clear();
        this.CzK.clear();
        this.CzM.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(103196);
          throw paramVarArgs;
        }
        AppMethodBeat.o(103196);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ez localez = (ez)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(103196);
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
            localez.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103196);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((fn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localez.Czz.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103196);
          return 0;
        case 3: 
          localez.CzA = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(103196);
          return 0;
        case 4: 
          localez.CzB = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(103196);
          return 0;
        case 5: 
          localez.CzC = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(103196);
          return 0;
        case 6: 
          localez.CzD = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(103196);
          return 0;
        case 7: 
          localez.CzE = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(103196);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new el();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((el)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localez.CzF = ((el)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103196);
          return 0;
        case 9: 
          localez.url = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(103196);
          return 0;
        case 10: 
          localez.gGC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(103196);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dkm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dkm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localez.CzG = ((dkm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103196);
          return 0;
        case 12: 
          localez.CzH = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(103196);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bol();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bol)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localez.CzI = ((bol)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103196);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ew();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ew)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localez.CzJ = ((ew)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103196);
          return 0;
        case 15: 
          localez.CzK.add(((f.a.a.a.a)localObject1).KhF.readString());
          AppMethodBeat.o(103196);
          return 0;
        case 16: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new do();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((do)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localez.CzL = ((do)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103196);
          return 0;
        case 17: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localez.CzM.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103196);
          return 0;
        }
        localez.CzN = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(103196);
        return 0;
      }
      AppMethodBeat.o(103196);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ez
 * JD-Core Version:    0.7.0.1
 */