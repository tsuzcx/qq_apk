package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cnj
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
  public cmf Dbb;
  public cmf Dbc;
  public cmf Dby;
  public String Dqd;
  public int EhQ;
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
    AppMethodBeat.i(152681);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Dby == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(152681);
        throw paramVarArgs;
      }
      if (this.DFJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(152681);
        throw paramVarArgs;
      }
      if (this.Dbb == null)
      {
        paramVarArgs = new b("Not all required fields were included: PYInitial");
        AppMethodBeat.o(152681);
        throw paramVarArgs;
      }
      if (this.Dbc == null)
      {
        paramVarArgs = new b("Not all required fields were included: QuanPin");
        AppMethodBeat.o(152681);
        throw paramVarArgs;
      }
      if (this.CxB == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(152681);
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
      if (this.ijN != null) {
        paramVarArgs.d(7, this.ijN);
      }
      if (this.ijO != null) {
        paramVarArgs.d(8, this.ijO);
      }
      if (this.ijP != null) {
        paramVarArgs.d(9, this.ijP);
      }
      paramVarArgs.aR(10, this.ijQ);
      paramVarArgs.aR(11, this.DIV);
      if (this.DIW != null) {
        paramVarArgs.d(12, this.DIW);
      }
      if (this.DIX != null) {
        paramVarArgs.d(13, this.DIX);
      }
      if (this.ijR != null) {
        paramVarArgs.d(14, this.ijR);
      }
      if (this.DIY != null) {
        paramVarArgs.d(15, this.DIY);
      }
      paramVarArgs.aR(16, this.DIZ);
      paramVarArgs.aR(17, this.ijT);
      paramVarArgs.aR(18, this.ijS);
      if (this.ijU != null) {
        paramVarArgs.d(19, this.ijU);
      }
      if (this.DJb != null)
      {
        paramVarArgs.kX(20, this.DJb.computeSize());
        this.DJb.writeFields(paramVarArgs);
      }
      if (this.ijV != null) {
        paramVarArgs.d(21, this.ijV);
      }
      if (this.ijW != null) {
        paramVarArgs.d(22, this.ijW);
      }
      if (this.DJc != null)
      {
        paramVarArgs.kX(23, this.DJc.computeSize());
        this.DJc.writeFields(paramVarArgs);
      }
      if (this.CVv != null) {
        paramVarArgs.d(24, this.CVv);
      }
      if (this.CVw != null) {
        paramVarArgs.d(25, this.CVw);
      }
      if (this.Dqd != null) {
        paramVarArgs.d(26, this.Dqd);
      }
      paramVarArgs.aR(27, this.EhQ);
      AppMethodBeat.o(152681);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Dby == null) {
        break label2602;
      }
    }
    label2602:
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
      i = paramInt;
      if (this.ijN != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.ijN);
      }
      paramInt = i;
      if (this.ijO != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.ijO);
      }
      i = paramInt;
      if (this.ijP != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.ijP);
      }
      i = i + f.a.a.b.b.a.bA(10, this.ijQ) + f.a.a.b.b.a.bA(11, this.DIV);
      paramInt = i;
      if (this.DIW != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.DIW);
      }
      i = paramInt;
      if (this.DIX != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.DIX);
      }
      paramInt = i;
      if (this.ijR != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.ijR);
      }
      i = paramInt;
      if (this.DIY != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.DIY);
      }
      i = i + f.a.a.b.b.a.bA(16, this.DIZ) + f.a.a.b.b.a.bA(17, this.ijT) + f.a.a.b.b.a.bA(18, this.ijS);
      paramInt = i;
      if (this.ijU != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.ijU);
      }
      i = paramInt;
      if (this.DJb != null) {
        i = paramInt + f.a.a.a.kW(20, this.DJb.computeSize());
      }
      paramInt = i;
      if (this.ijV != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.ijV);
      }
      i = paramInt;
      if (this.ijW != null) {
        i = paramInt + f.a.a.b.b.a.e(22, this.ijW);
      }
      paramInt = i;
      if (this.DJc != null) {
        paramInt = i + f.a.a.a.kW(23, this.DJc.computeSize());
      }
      i = paramInt;
      if (this.CVv != null) {
        i = paramInt + f.a.a.b.b.a.e(24, this.CVv);
      }
      paramInt = i;
      if (this.CVw != null) {
        paramInt = i + f.a.a.b.b.a.e(25, this.CVw);
      }
      i = paramInt;
      if (this.Dqd != null) {
        i = paramInt + f.a.a.b.b.a.e(26, this.Dqd);
      }
      paramInt = f.a.a.b.b.a.bA(27, this.EhQ);
      AppMethodBeat.o(152681);
      return i + paramInt;
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
          AppMethodBeat.o(152681);
          throw paramVarArgs;
        }
        if (this.DFJ == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(152681);
          throw paramVarArgs;
        }
        if (this.Dbb == null)
        {
          paramVarArgs = new b("Not all required fields were included: PYInitial");
          AppMethodBeat.o(152681);
          throw paramVarArgs;
        }
        if (this.Dbc == null)
        {
          paramVarArgs = new b("Not all required fields were included: QuanPin");
          AppMethodBeat.o(152681);
          throw paramVarArgs;
        }
        if (this.CxB == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgBuf");
          AppMethodBeat.o(152681);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152681);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cnj localcnj = (cnj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152681);
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
            localcnj.Dby = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152681);
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
            localcnj.DFJ = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152681);
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
            localcnj.Dbb = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152681);
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
            localcnj.Dbc = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152681);
          return 0;
        case 5: 
          localcnj.ijM = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152681);
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
            localcnj.CxB = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152681);
          return 0;
        case 7: 
          localcnj.ijN = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 8: 
          localcnj.ijO = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 9: 
          localcnj.ijP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 10: 
          localcnj.ijQ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152681);
          return 0;
        case 11: 
          localcnj.DIV = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152681);
          return 0;
        case 12: 
          localcnj.DIW = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 13: 
          localcnj.DIX = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 14: 
          localcnj.ijR = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 15: 
          localcnj.DIY = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 16: 
          localcnj.DIZ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152681);
          return 0;
        case 17: 
          localcnj.ijT = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152681);
          return 0;
        case 18: 
          localcnj.ijS = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152681);
          return 0;
        case 19: 
          localcnj.ijU = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 20: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcnj.DJb = ((cwh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152681);
          return 0;
        case 21: 
          localcnj.ijV = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 22: 
          localcnj.ijW = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 23: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new zh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((zh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcnj.DJc = ((zh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152681);
          return 0;
        case 24: 
          localcnj.CVv = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 25: 
          localcnj.CVw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 26: 
          localcnj.Dqd = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152681);
          return 0;
        }
        localcnj.EhQ = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(152681);
        return 0;
      }
      AppMethodBeat.o(152681);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnj
 * JD-Core Version:    0.7.0.1
 */