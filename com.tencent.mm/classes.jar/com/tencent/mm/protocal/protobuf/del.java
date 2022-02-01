package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class del
  extends cld
{
  public String CsB;
  public String CxX;
  public String EvO;
  public String EvQ;
  public int EvR;
  public int EvS;
  public civ EvT;
  public we EvU;
  public ciw EvV;
  public String EvW;
  public civ Evv;
  public String Evz;
  public String dlJ;
  public int ntx;
  public String nty;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72608);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.ntx);
      if (this.nty != null) {
        paramVarArgs.d(3, this.nty);
      }
      paramVarArgs.aR(4, this.EvR);
      if (this.Evv != null)
      {
        paramVarArgs.kX(5, this.Evv.computeSize());
        this.Evv.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(6, this.EvS);
      if (this.EvT != null)
      {
        paramVarArgs.kX(7, this.EvT.computeSize());
        this.EvT.writeFields(paramVarArgs);
      }
      if (this.EvU != null)
      {
        paramVarArgs.kX(8, this.EvU.computeSize());
        this.EvU.writeFields(paramVarArgs);
      }
      if (this.EvV != null)
      {
        paramVarArgs.kX(9, this.EvV.computeSize());
        this.EvV.writeFields(paramVarArgs);
      }
      if (this.dlJ != null) {
        paramVarArgs.d(10, this.dlJ);
      }
      if (this.CsB != null) {
        paramVarArgs.d(11, this.CsB);
      }
      if (this.CxX != null) {
        paramVarArgs.d(12, this.CxX);
      }
      if (this.EvO != null) {
        paramVarArgs.d(13, this.EvO);
      }
      if (this.EvW != null) {
        paramVarArgs.d(14, this.EvW);
      }
      if (this.EvQ != null) {
        paramVarArgs.d(15, this.EvQ);
      }
      if (this.Evz != null) {
        paramVarArgs.d(16, this.Evz);
      }
      AppMethodBeat.o(72608);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1562;
      }
    }
    label1562:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.ntx);
      paramInt = i;
      if (this.nty != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nty);
      }
      i = paramInt + f.a.a.b.b.a.bA(4, this.EvR);
      paramInt = i;
      if (this.Evv != null) {
        paramInt = i + f.a.a.a.kW(5, this.Evv.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(6, this.EvS);
      paramInt = i;
      if (this.EvT != null) {
        paramInt = i + f.a.a.a.kW(7, this.EvT.computeSize());
      }
      i = paramInt;
      if (this.EvU != null) {
        i = paramInt + f.a.a.a.kW(8, this.EvU.computeSize());
      }
      paramInt = i;
      if (this.EvV != null) {
        paramInt = i + f.a.a.a.kW(9, this.EvV.computeSize());
      }
      i = paramInt;
      if (this.dlJ != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.dlJ);
      }
      paramInt = i;
      if (this.CsB != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.CsB);
      }
      i = paramInt;
      if (this.CxX != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.CxX);
      }
      paramInt = i;
      if (this.EvO != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.EvO);
      }
      i = paramInt;
      if (this.EvW != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.EvW);
      }
      paramInt = i;
      if (this.EvQ != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.EvQ);
      }
      i = paramInt;
      if (this.Evz != null) {
        i = paramInt + f.a.a.b.b.a.e(16, this.Evz);
      }
      AppMethodBeat.o(72608);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(72608);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        del localdel = (del)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72608);
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
            localdel.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72608);
          return 0;
        case 2: 
          localdel.ntx = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72608);
          return 0;
        case 3: 
          localdel.nty = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72608);
          return 0;
        case 4: 
          localdel.EvR = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72608);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new civ();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((civ)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdel.Evv = ((civ)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72608);
          return 0;
        case 6: 
          localdel.EvS = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72608);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new civ();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((civ)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdel.EvT = ((civ)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72608);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new we();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((we)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdel.EvU = ((we)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72608);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ciw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ciw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdel.EvV = ((ciw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72608);
          return 0;
        case 10: 
          localdel.dlJ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72608);
          return 0;
        case 11: 
          localdel.CsB = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72608);
          return 0;
        case 12: 
          localdel.CxX = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72608);
          return 0;
        case 13: 
          localdel.EvO = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72608);
          return 0;
        case 14: 
          localdel.EvW = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72608);
          return 0;
        case 15: 
          localdel.EvQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72608);
          return 0;
        }
        localdel.Evz = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(72608);
        return 0;
      }
      AppMethodBeat.o(72608);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.del
 * JD-Core Version:    0.7.0.1
 */