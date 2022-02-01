package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ne
  extends cld
{
  public int CID;
  public lj CKR;
  public lz CKS;
  public mw CKT;
  public mb CKU;
  public mw CKV;
  public nn CKW;
  public LinkedList<amx> CKX;
  public int CKY;
  public ccj CKZ;
  
  public ne()
  {
    AppMethodBeat.i(124444);
    this.CKX = new LinkedList();
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
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.CKR != null)
      {
        paramVarArgs.kX(2, this.CKR.computeSize());
        this.CKR.writeFields(paramVarArgs);
      }
      if (this.CKS != null)
      {
        paramVarArgs.kX(3, this.CKS.computeSize());
        this.CKS.writeFields(paramVarArgs);
      }
      if (this.CKT != null)
      {
        paramVarArgs.kX(4, this.CKT.computeSize());
        this.CKT.writeFields(paramVarArgs);
      }
      if (this.CKU != null)
      {
        paramVarArgs.kX(5, this.CKU.computeSize());
        this.CKU.writeFields(paramVarArgs);
      }
      if (this.CKV != null)
      {
        paramVarArgs.kX(6, this.CKV.computeSize());
        this.CKV.writeFields(paramVarArgs);
      }
      if (this.CKW != null)
      {
        paramVarArgs.kX(7, this.CKW.computeSize());
        this.CKW.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(8, this.CID);
      paramVarArgs.e(9, 8, this.CKX);
      paramVarArgs.aR(10, this.CKY);
      if (this.CKZ != null)
      {
        paramVarArgs.kX(11, this.CKZ.computeSize());
        this.CKZ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124445);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1674;
      }
    }
    label1674:
    for (int i = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CKR != null) {
        paramInt = i + f.a.a.a.kW(2, this.CKR.computeSize());
      }
      i = paramInt;
      if (this.CKS != null) {
        i = paramInt + f.a.a.a.kW(3, this.CKS.computeSize());
      }
      paramInt = i;
      if (this.CKT != null) {
        paramInt = i + f.a.a.a.kW(4, this.CKT.computeSize());
      }
      i = paramInt;
      if (this.CKU != null) {
        i = paramInt + f.a.a.a.kW(5, this.CKU.computeSize());
      }
      paramInt = i;
      if (this.CKV != null) {
        paramInt = i + f.a.a.a.kW(6, this.CKV.computeSize());
      }
      i = paramInt;
      if (this.CKW != null) {
        i = paramInt + f.a.a.a.kW(7, this.CKW.computeSize());
      }
      i = i + f.a.a.b.b.a.bA(8, this.CID) + f.a.a.a.c(9, 8, this.CKX) + f.a.a.b.b.a.bA(10, this.CKY);
      paramInt = i;
      if (this.CKZ != null) {
        paramInt = i + f.a.a.a.kW(11, this.CKZ.computeSize());
      }
      AppMethodBeat.o(124445);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CKX.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
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
        ne localne = (ne)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124445);
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
            localne.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124445);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new lj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((lj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localne.CKR = ((lj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124445);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new lz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((lz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localne.CKS = ((lz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124445);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new mw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((mw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localne.CKT = ((mw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124445);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new mb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((mb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localne.CKU = ((mb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124445);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new mw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((mw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localne.CKV = ((mw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124445);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new nn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((nn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localne.CKW = ((nn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124445);
          return 0;
        case 8: 
          localne.CID = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(124445);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new amx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((amx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localne.CKX.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124445);
          return 0;
        case 10: 
          localne.CKY = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(124445);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ccj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ccj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localne.CKZ = ((ccj)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124445);
        return 0;
      }
      AppMethodBeat.o(124445);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ne
 * JD-Core Version:    0.7.0.1
 */