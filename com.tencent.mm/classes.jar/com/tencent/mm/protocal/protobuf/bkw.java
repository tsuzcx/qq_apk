package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bkw
  extends ckq
{
  public boolean DAR;
  public boolean DAS;
  public dty DIA;
  public dvv DIB;
  public dux DIC;
  public dws DID;
  public dvo DIE;
  public dvw DIF;
  public int DIG;
  public String DIH;
  public String DII;
  public dvx DIJ;
  public int Dym;
  public String hnC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123624);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.hnC != null) {
        paramVarArgs.d(2, this.hnC);
      }
      if (this.DIA != null)
      {
        paramVarArgs.kX(3, this.DIA.computeSize());
        this.DIA.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(4, this.Dym);
      if (this.DIB != null)
      {
        paramVarArgs.kX(5, this.DIB.computeSize());
        this.DIB.writeFields(paramVarArgs);
      }
      if (this.DIC != null)
      {
        paramVarArgs.kX(6, this.DIC.computeSize());
        this.DIC.writeFields(paramVarArgs);
      }
      if (this.DID != null)
      {
        paramVarArgs.kX(7, this.DID.computeSize());
        this.DID.writeFields(paramVarArgs);
      }
      if (this.DIE != null)
      {
        paramVarArgs.kX(8, this.DIE.computeSize());
        this.DIE.writeFields(paramVarArgs);
      }
      if (this.DIF != null)
      {
        paramVarArgs.kX(9, this.DIF.computeSize());
        this.DIF.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(10, this.DIG);
      if (this.DIH != null) {
        paramVarArgs.d(11, this.DIH);
      }
      if (this.DII != null) {
        paramVarArgs.d(12, this.DII);
      }
      paramVarArgs.bg(13, this.DAR);
      paramVarArgs.bg(14, this.DAS);
      if (this.DIJ != null)
      {
        paramVarArgs.kX(15, this.DIJ.computeSize());
        this.DIJ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(123624);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1758;
      }
    }
    label1758:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hnC != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.hnC);
      }
      i = paramInt;
      if (this.DIA != null) {
        i = paramInt + f.a.a.a.kW(3, this.DIA.computeSize());
      }
      i += f.a.a.b.b.a.bA(4, this.Dym);
      paramInt = i;
      if (this.DIB != null) {
        paramInt = i + f.a.a.a.kW(5, this.DIB.computeSize());
      }
      i = paramInt;
      if (this.DIC != null) {
        i = paramInt + f.a.a.a.kW(6, this.DIC.computeSize());
      }
      paramInt = i;
      if (this.DID != null) {
        paramInt = i + f.a.a.a.kW(7, this.DID.computeSize());
      }
      i = paramInt;
      if (this.DIE != null) {
        i = paramInt + f.a.a.a.kW(8, this.DIE.computeSize());
      }
      paramInt = i;
      if (this.DIF != null) {
        paramInt = i + f.a.a.a.kW(9, this.DIF.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(10, this.DIG);
      paramInt = i;
      if (this.DIH != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.DIH);
      }
      i = paramInt;
      if (this.DII != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.DII);
      }
      i = i + (f.a.a.b.b.a.fY(13) + 1) + (f.a.a.b.b.a.fY(14) + 1);
      paramInt = i;
      if (this.DIJ != null) {
        paramInt = i + f.a.a.a.kW(15, this.DIJ.computeSize());
      }
      AppMethodBeat.o(123624);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(123624);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bkw localbkw = (bkw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123624);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbkw.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123624);
          return 0;
        case 2: 
          localbkw.hnC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123624);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dty();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dty)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbkw.DIA = ((dty)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123624);
          return 0;
        case 4: 
          localbkw.Dym = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(123624);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dvv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dvv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbkw.DIB = ((dvv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123624);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dux();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dux)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbkw.DIC = ((dux)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123624);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dws();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dws)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbkw.DID = ((dws)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123624);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dvo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dvo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbkw.DIE = ((dvo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123624);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dvw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dvw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbkw.DIF = ((dvw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123624);
          return 0;
        case 10: 
          localbkw.DIG = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(123624);
          return 0;
        case 11: 
          localbkw.DIH = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123624);
          return 0;
        case 12: 
          localbkw.DII = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123624);
          return 0;
        case 13: 
          localbkw.DAR = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(123624);
          return 0;
        case 14: 
          localbkw.DAS = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(123624);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dvx();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dvx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbkw.DIJ = ((dvx)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(123624);
        return 0;
      }
      AppMethodBeat.o(123624);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkw
 * JD-Core Version:    0.7.0.1
 */