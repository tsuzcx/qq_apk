package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class alv
  extends cld
{
  public FinderContact DmQ;
  public int DmR;
  public String DmS;
  public String DmT;
  public String DmU;
  public int KXV;
  public int KXW;
  public int LyH;
  public int LyI;
  public dyb LyJ;
  public int actionType;
  public akb verifyInfo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169074);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.actionType);
      if (this.verifyInfo != null)
      {
        paramVarArgs.kX(3, this.verifyInfo.computeSize());
        this.verifyInfo.writeFields(paramVarArgs);
      }
      if (this.DmQ != null)
      {
        paramVarArgs.kX(4, this.DmQ.computeSize());
        this.DmQ.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(5, this.DmR);
      if (this.DmS != null) {
        paramVarArgs.d(6, this.DmS);
      }
      if (this.DmT != null) {
        paramVarArgs.d(7, this.DmT);
      }
      if (this.DmU != null) {
        paramVarArgs.d(8, this.DmU);
      }
      paramVarArgs.aR(9, this.LyH);
      paramVarArgs.aR(10, this.KXW);
      paramVarArgs.aR(11, this.LyI);
      paramVarArgs.aR(12, this.KXV);
      if (this.LyJ != null)
      {
        paramVarArgs.kX(13, this.LyJ.computeSize());
        this.LyJ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(169074);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1226;
      }
    }
    label1226:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.actionType);
      paramInt = i;
      if (this.verifyInfo != null) {
        paramInt = i + f.a.a.a.kW(3, this.verifyInfo.computeSize());
      }
      i = paramInt;
      if (this.DmQ != null) {
        i = paramInt + f.a.a.a.kW(4, this.DmQ.computeSize());
      }
      i += f.a.a.b.b.a.bA(5, this.DmR);
      paramInt = i;
      if (this.DmS != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DmS);
      }
      i = paramInt;
      if (this.DmT != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.DmT);
      }
      paramInt = i;
      if (this.DmU != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.DmU);
      }
      i = paramInt + f.a.a.b.b.a.bA(9, this.LyH) + f.a.a.b.b.a.bA(10, this.KXW) + f.a.a.b.b.a.bA(11, this.LyI) + f.a.a.b.b.a.bA(12, this.KXV);
      paramInt = i;
      if (this.LyJ != null) {
        paramInt = i + f.a.a.a.kW(13, this.LyJ.computeSize());
      }
      AppMethodBeat.o(169074);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(169074);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        alv localalv = (alv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169074);
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
            localalv.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169074);
          return 0;
        case 2: 
          localalv.actionType = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(169074);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new akb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((akb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localalv.verifyInfo = ((akb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169074);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderContact();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localalv.DmQ = ((FinderContact)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169074);
          return 0;
        case 5: 
          localalv.DmR = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(169074);
          return 0;
        case 6: 
          localalv.DmS = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(169074);
          return 0;
        case 7: 
          localalv.DmT = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(169074);
          return 0;
        case 8: 
          localalv.DmU = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(169074);
          return 0;
        case 9: 
          localalv.LyH = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(169074);
          return 0;
        case 10: 
          localalv.KXW = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(169074);
          return 0;
        case 11: 
          localalv.LyI = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(169074);
          return 0;
        case 12: 
          localalv.KXV = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(169074);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dyb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dyb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localalv.LyJ = ((dyb)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169074);
        return 0;
      }
      AppMethodBeat.o(169074);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.alv
 * JD-Core Version:    0.7.0.1
 */