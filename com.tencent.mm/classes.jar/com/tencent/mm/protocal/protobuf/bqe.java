package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bqe
  extends com.tencent.mm.bx.a
{
  public String CVv;
  public String CVw;
  public SKBuiltinBuffer_t CxB;
  public cmf DFJ;
  public int DIV;
  public String DIW;
  public String DIX;
  public String DIY;
  public int DIZ;
  public cwh DJb;
  public zh DJc;
  public cmf DNT;
  public cmf DNU;
  public cmf DNV;
  public int DOj;
  public int Dat;
  public cmf Dbb;
  public cmf Dbc;
  public cmf Dby;
  public String DyE;
  public int ijM;
  public String ijN;
  public String ijO;
  public String ijP;
  public int ijQ;
  public String ijR;
  public int ijS;
  public int ijT;
  public String ijU;
  public String ijV;
  public String ijW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101824);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Dby == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(101824);
        throw paramVarArgs;
      }
      if (this.DFJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(101824);
        throw paramVarArgs;
      }
      if (this.Dbb == null)
      {
        paramVarArgs = new b("Not all required fields were included: PYInitial");
        AppMethodBeat.o(101824);
        throw paramVarArgs;
      }
      if (this.Dbc == null)
      {
        paramVarArgs = new b("Not all required fields were included: QuanPin");
        AppMethodBeat.o(101824);
        throw paramVarArgs;
      }
      if (this.CxB == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(101824);
        throw paramVarArgs;
      }
      if (this.DNT == null)
      {
        paramVarArgs = new b("Not all required fields were included: Remark");
        AppMethodBeat.o(101824);
        throw paramVarArgs;
      }
      if (this.DNU == null)
      {
        paramVarArgs = new b("Not all required fields were included: RemarkPYInitial");
        AppMethodBeat.o(101824);
        throw paramVarArgs;
      }
      if (this.DNV == null)
      {
        paramVarArgs = new b("Not all required fields were included: RemarkQuanPin");
        AppMethodBeat.o(101824);
        throw paramVarArgs;
      }
      if (this.Dby != null)
      {
        paramVarArgs.kX(1, this.Dby.computeSize());
        this.Dby.writeFields(paramVarArgs);
      }
      if (this.DFJ != null)
      {
        paramVarArgs.kX(2, this.DFJ.computeSize());
        this.DFJ.writeFields(paramVarArgs);
      }
      if (this.Dbb != null)
      {
        paramVarArgs.kX(3, this.Dbb.computeSize());
        this.Dbb.writeFields(paramVarArgs);
      }
      if (this.Dbc != null)
      {
        paramVarArgs.kX(4, this.Dbc.computeSize());
        this.Dbc.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(5, this.ijM);
      if (this.CxB != null)
      {
        paramVarArgs.kX(6, this.CxB.computeSize());
        this.CxB.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(7, this.DOj);
      if (this.DNT != null)
      {
        paramVarArgs.kX(8, this.DNT.computeSize());
        this.DNT.writeFields(paramVarArgs);
      }
      if (this.DNU != null)
      {
        paramVarArgs.kX(9, this.DNU.computeSize());
        this.DNU.writeFields(paramVarArgs);
      }
      if (this.DNV != null)
      {
        paramVarArgs.kX(10, this.DNV.computeSize());
        this.DNV.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(11, this.Dat);
      if (this.ijN != null) {
        paramVarArgs.d(12, this.ijN);
      }
      if (this.ijO != null) {
        paramVarArgs.d(13, this.ijO);
      }
      if (this.ijP != null) {
        paramVarArgs.d(14, this.ijP);
      }
      paramVarArgs.aR(15, this.ijQ);
      paramVarArgs.aR(16, this.DIV);
      if (this.DIW != null) {
        paramVarArgs.d(17, this.DIW);
      }
      if (this.DIX != null) {
        paramVarArgs.d(18, this.DIX);
      }
      if (this.DyE != null) {
        paramVarArgs.d(19, this.DyE);
      }
      if (this.DIY != null) {
        paramVarArgs.d(20, this.DIY);
      }
      paramVarArgs.aR(21, this.DIZ);
      paramVarArgs.aR(22, this.ijT);
      paramVarArgs.aR(23, this.ijS);
      if (this.ijU != null) {
        paramVarArgs.d(24, this.ijU);
      }
      if (this.ijR != null) {
        paramVarArgs.d(25, this.ijR);
      }
      if (this.DJb != null)
      {
        paramVarArgs.kX(26, this.DJb.computeSize());
        this.DJb.writeFields(paramVarArgs);
      }
      if (this.ijV != null) {
        paramVarArgs.d(27, this.ijV);
      }
      if (this.CVv != null) {
        paramVarArgs.d(28, this.CVv);
      }
      if (this.CVw != null) {
        paramVarArgs.d(29, this.CVw);
      }
      if (this.ijW != null) {
        paramVarArgs.d(30, this.ijW);
      }
      if (this.DJc != null)
      {
        paramVarArgs.kX(31, this.DJc.computeSize());
        this.DJc.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(101824);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Dby == null) {
        break label3258;
      }
    }
    label3258:
    for (int i = f.a.a.a.kW(1, this.Dby.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DFJ != null) {
        paramInt = i + f.a.a.a.kW(2, this.DFJ.computeSize());
      }
      i = paramInt;
      if (this.Dbb != null) {
        i = paramInt + f.a.a.a.kW(3, this.Dbb.computeSize());
      }
      paramInt = i;
      if (this.Dbc != null) {
        paramInt = i + f.a.a.a.kW(4, this.Dbc.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.ijM);
      paramInt = i;
      if (this.CxB != null) {
        paramInt = i + f.a.a.a.kW(6, this.CxB.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(7, this.DOj);
      paramInt = i;
      if (this.DNT != null) {
        paramInt = i + f.a.a.a.kW(8, this.DNT.computeSize());
      }
      i = paramInt;
      if (this.DNU != null) {
        i = paramInt + f.a.a.a.kW(9, this.DNU.computeSize());
      }
      paramInt = i;
      if (this.DNV != null) {
        paramInt = i + f.a.a.a.kW(10, this.DNV.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(11, this.Dat);
      paramInt = i;
      if (this.ijN != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.ijN);
      }
      i = paramInt;
      if (this.ijO != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.ijO);
      }
      paramInt = i;
      if (this.ijP != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.ijP);
      }
      i = paramInt + f.a.a.b.b.a.bA(15, this.ijQ) + f.a.a.b.b.a.bA(16, this.DIV);
      paramInt = i;
      if (this.DIW != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.DIW);
      }
      i = paramInt;
      if (this.DIX != null) {
        i = paramInt + f.a.a.b.b.a.e(18, this.DIX);
      }
      paramInt = i;
      if (this.DyE != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.DyE);
      }
      i = paramInt;
      if (this.DIY != null) {
        i = paramInt + f.a.a.b.b.a.e(20, this.DIY);
      }
      i = i + f.a.a.b.b.a.bA(21, this.DIZ) + f.a.a.b.b.a.bA(22, this.ijT) + f.a.a.b.b.a.bA(23, this.ijS);
      paramInt = i;
      if (this.ijU != null) {
        paramInt = i + f.a.a.b.b.a.e(24, this.ijU);
      }
      i = paramInt;
      if (this.ijR != null) {
        i = paramInt + f.a.a.b.b.a.e(25, this.ijR);
      }
      paramInt = i;
      if (this.DJb != null) {
        paramInt = i + f.a.a.a.kW(26, this.DJb.computeSize());
      }
      i = paramInt;
      if (this.ijV != null) {
        i = paramInt + f.a.a.b.b.a.e(27, this.ijV);
      }
      paramInt = i;
      if (this.CVv != null) {
        paramInt = i + f.a.a.b.b.a.e(28, this.CVv);
      }
      i = paramInt;
      if (this.CVw != null) {
        i = paramInt + f.a.a.b.b.a.e(29, this.CVw);
      }
      paramInt = i;
      if (this.ijW != null) {
        paramInt = i + f.a.a.b.b.a.e(30, this.ijW);
      }
      i = paramInt;
      if (this.DJc != null) {
        i = paramInt + f.a.a.a.kW(31, this.DJc.computeSize());
      }
      AppMethodBeat.o(101824);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.Dby == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(101824);
          throw paramVarArgs;
        }
        if (this.DFJ == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(101824);
          throw paramVarArgs;
        }
        if (this.Dbb == null)
        {
          paramVarArgs = new b("Not all required fields were included: PYInitial");
          AppMethodBeat.o(101824);
          throw paramVarArgs;
        }
        if (this.Dbc == null)
        {
          paramVarArgs = new b("Not all required fields were included: QuanPin");
          AppMethodBeat.o(101824);
          throw paramVarArgs;
        }
        if (this.CxB == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgBuf");
          AppMethodBeat.o(101824);
          throw paramVarArgs;
        }
        if (this.DNT == null)
        {
          paramVarArgs = new b("Not all required fields were included: Remark");
          AppMethodBeat.o(101824);
          throw paramVarArgs;
        }
        if (this.DNU == null)
        {
          paramVarArgs = new b("Not all required fields were included: RemarkPYInitial");
          AppMethodBeat.o(101824);
          throw paramVarArgs;
        }
        if (this.DNV == null)
        {
          paramVarArgs = new b("Not all required fields were included: RemarkQuanPin");
          AppMethodBeat.o(101824);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101824);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bqe localbqe = (bqe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101824);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbqe.Dby = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101824);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbqe.DFJ = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101824);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbqe.Dbb = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101824);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbqe.Dbc = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101824);
          return 0;
        case 5: 
          localbqe.ijM = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(101824);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbqe.CxB = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101824);
          return 0;
        case 7: 
          localbqe.DOj = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(101824);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbqe.DNT = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101824);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbqe.DNU = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101824);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbqe.DNV = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101824);
          return 0;
        case 11: 
          localbqe.Dat = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(101824);
          return 0;
        case 12: 
          localbqe.ijN = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 13: 
          localbqe.ijO = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 14: 
          localbqe.ijP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 15: 
          localbqe.ijQ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(101824);
          return 0;
        case 16: 
          localbqe.DIV = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(101824);
          return 0;
        case 17: 
          localbqe.DIW = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 18: 
          localbqe.DIX = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 19: 
          localbqe.DyE = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 20: 
          localbqe.DIY = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 21: 
          localbqe.DIZ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(101824);
          return 0;
        case 22: 
          localbqe.ijT = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(101824);
          return 0;
        case 23: 
          localbqe.ijS = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(101824);
          return 0;
        case 24: 
          localbqe.ijU = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 25: 
          localbqe.ijR = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 26: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbqe.DJb = ((cwh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101824);
          return 0;
        case 27: 
          localbqe.ijV = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 28: 
          localbqe.CVv = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 29: 
          localbqe.CVw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 30: 
          localbqe.ijW = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(101824);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new zh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((zh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbqe.DJc = ((zh)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(101824);
        return 0;
      }
      AppMethodBeat.o(101824);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqe
 * JD-Core Version:    0.7.0.1
 */