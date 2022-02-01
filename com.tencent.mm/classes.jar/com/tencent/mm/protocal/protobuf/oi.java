package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class oi
  extends cvp
{
  public int FGO;
  public lz FJC;
  public mv FJD;
  public nz FJE;
  public mx FJF;
  public nz FJG;
  public oz FJH;
  public LinkedList<atv> FJI;
  public int FJJ;
  public cmk FJK;
  public String FJL;
  
  public oi()
  {
    AppMethodBeat.i(124444);
    this.FJI = new LinkedList();
    AppMethodBeat.o(124444);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124445);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(124445);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.FJC != null)
      {
        paramVarArgs.lC(2, this.FJC.computeSize());
        this.FJC.writeFields(paramVarArgs);
      }
      if (this.FJD != null)
      {
        paramVarArgs.lC(3, this.FJD.computeSize());
        this.FJD.writeFields(paramVarArgs);
      }
      if (this.FJE != null)
      {
        paramVarArgs.lC(4, this.FJE.computeSize());
        this.FJE.writeFields(paramVarArgs);
      }
      if (this.FJF != null)
      {
        paramVarArgs.lC(5, this.FJF.computeSize());
        this.FJF.writeFields(paramVarArgs);
      }
      if (this.FJG != null)
      {
        paramVarArgs.lC(6, this.FJG.computeSize());
        this.FJG.writeFields(paramVarArgs);
      }
      if (this.FJH != null)
      {
        paramVarArgs.lC(7, this.FJH.computeSize());
        this.FJH.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(8, this.FGO);
      paramVarArgs.e(9, 8, this.FJI);
      paramVarArgs.aS(10, this.FJJ);
      if (this.FJK != null)
      {
        paramVarArgs.lC(11, this.FJK.computeSize());
        this.FJK.writeFields(paramVarArgs);
      }
      if (this.FJL != null) {
        paramVarArgs.d(12, this.FJL);
      }
      AppMethodBeat.o(124445);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1734;
      }
    }
    label1734:
    for (int i = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FJC != null) {
        paramInt = i + f.a.a.a.lB(2, this.FJC.computeSize());
      }
      i = paramInt;
      if (this.FJD != null) {
        i = paramInt + f.a.a.a.lB(3, this.FJD.computeSize());
      }
      paramInt = i;
      if (this.FJE != null) {
        paramInt = i + f.a.a.a.lB(4, this.FJE.computeSize());
      }
      i = paramInt;
      if (this.FJF != null) {
        i = paramInt + f.a.a.a.lB(5, this.FJF.computeSize());
      }
      paramInt = i;
      if (this.FJG != null) {
        paramInt = i + f.a.a.a.lB(6, this.FJG.computeSize());
      }
      i = paramInt;
      if (this.FJH != null) {
        i = paramInt + f.a.a.a.lB(7, this.FJH.computeSize());
      }
      i = i + f.a.a.b.b.a.bz(8, this.FGO) + f.a.a.a.c(9, 8, this.FJI) + f.a.a.b.b.a.bz(10, this.FJJ);
      paramInt = i;
      if (this.FJK != null) {
        paramInt = i + f.a.a.a.lB(11, this.FJK.computeSize());
      }
      i = paramInt;
      if (this.FJL != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.FJL);
      }
      AppMethodBeat.o(124445);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FJI.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(124445);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124445);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        oi localoi = (oi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124445);
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
            localoi.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124445);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new lz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((lz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localoi.FJC = ((lz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124445);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new mv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((mv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localoi.FJD = ((mv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124445);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new nz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((nz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localoi.FJE = ((nz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124445);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new mx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((mx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localoi.FJF = ((mx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124445);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new nz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((nz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localoi.FJG = ((nz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124445);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new oz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((oz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localoi.FJH = ((oz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124445);
          return 0;
        case 8: 
          localoi.FGO = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(124445);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new atv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((atv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localoi.FJI.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124445);
          return 0;
        case 10: 
          localoi.FJJ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(124445);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localoi.FJK = ((cmk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124445);
          return 0;
        }
        localoi.FJL = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(124445);
        return 0;
      }
      AppMethodBeat.o(124445);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.oi
 * JD-Core Version:    0.7.0.1
 */