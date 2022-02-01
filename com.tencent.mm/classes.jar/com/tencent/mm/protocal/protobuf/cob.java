package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cob
  extends com.tencent.mm.bx.a
{
  public String CVv;
  public String CVw;
  public cmf DFJ;
  public int DIV;
  public String DIW;
  public String DIX;
  public String DIY;
  public int DIZ;
  public zh DJc;
  public cmf Dby;
  public int ijM;
  public String ijN;
  public String ijO;
  public String ijP;
  public int ijQ;
  public String ijR;
  public String ijV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6431);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Dby == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(6431);
        throw paramVarArgs;
      }
      if (this.DFJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(6431);
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
      paramVarArgs.aR(3, this.ijM);
      if (this.ijN != null) {
        paramVarArgs.d(4, this.ijN);
      }
      if (this.ijO != null) {
        paramVarArgs.d(5, this.ijO);
      }
      if (this.ijP != null) {
        paramVarArgs.d(6, this.ijP);
      }
      paramVarArgs.aR(7, this.ijQ);
      paramVarArgs.aR(8, this.DIV);
      if (this.DIW != null) {
        paramVarArgs.d(9, this.DIW);
      }
      if (this.DIX != null) {
        paramVarArgs.d(10, this.DIX);
      }
      if (this.ijR != null) {
        paramVarArgs.d(11, this.ijR);
      }
      if (this.DIY != null) {
        paramVarArgs.d(12, this.DIY);
      }
      paramVarArgs.aR(13, this.DIZ);
      if (this.ijV != null) {
        paramVarArgs.d(14, this.ijV);
      }
      if (this.DJc != null)
      {
        paramVarArgs.kX(15, this.DJc.computeSize());
        this.DJc.writeFields(paramVarArgs);
      }
      if (this.CVv != null) {
        paramVarArgs.d(16, this.CVv);
      }
      if (this.CVw != null) {
        paramVarArgs.d(17, this.CVw);
      }
      AppMethodBeat.o(6431);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Dby == null) {
        break label1541;
      }
    }
    label1541:
    for (paramInt = f.a.a.a.kW(1, this.Dby.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DFJ != null) {
        i = paramInt + f.a.a.a.kW(2, this.DFJ.computeSize());
      }
      i += f.a.a.b.b.a.bA(3, this.ijM);
      paramInt = i;
      if (this.ijN != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ijN);
      }
      i = paramInt;
      if (this.ijO != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.ijO);
      }
      paramInt = i;
      if (this.ijP != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.ijP);
      }
      i = paramInt + f.a.a.b.b.a.bA(7, this.ijQ) + f.a.a.b.b.a.bA(8, this.DIV);
      paramInt = i;
      if (this.DIW != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.DIW);
      }
      i = paramInt;
      if (this.DIX != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.DIX);
      }
      paramInt = i;
      if (this.ijR != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.ijR);
      }
      i = paramInt;
      if (this.DIY != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.DIY);
      }
      i += f.a.a.b.b.a.bA(13, this.DIZ);
      paramInt = i;
      if (this.ijV != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.ijV);
      }
      i = paramInt;
      if (this.DJc != null) {
        i = paramInt + f.a.a.a.kW(15, this.DJc.computeSize());
      }
      paramInt = i;
      if (this.CVv != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.CVv);
      }
      i = paramInt;
      if (this.CVw != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.CVw);
      }
      AppMethodBeat.o(6431);
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
          AppMethodBeat.o(6431);
          throw paramVarArgs;
        }
        if (this.DFJ == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(6431);
          throw paramVarArgs;
        }
        AppMethodBeat.o(6431);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cob localcob = (cob)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(6431);
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
            localcob.Dby = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(6431);
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
            localcob.DFJ = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(6431);
          return 0;
        case 3: 
          localcob.ijM = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(6431);
          return 0;
        case 4: 
          localcob.ijN = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(6431);
          return 0;
        case 5: 
          localcob.ijO = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(6431);
          return 0;
        case 6: 
          localcob.ijP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(6431);
          return 0;
        case 7: 
          localcob.ijQ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(6431);
          return 0;
        case 8: 
          localcob.DIV = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(6431);
          return 0;
        case 9: 
          localcob.DIW = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(6431);
          return 0;
        case 10: 
          localcob.DIX = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(6431);
          return 0;
        case 11: 
          localcob.ijR = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(6431);
          return 0;
        case 12: 
          localcob.DIY = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(6431);
          return 0;
        case 13: 
          localcob.DIZ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(6431);
          return 0;
        case 14: 
          localcob.ijV = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(6431);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new zh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((zh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcob.DJc = ((zh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(6431);
          return 0;
        case 16: 
          localcob.CVv = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(6431);
          return 0;
        }
        localcob.CVw = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(6431);
        return 0;
      }
      AppMethodBeat.o(6431);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cob
 * JD-Core Version:    0.7.0.1
 */