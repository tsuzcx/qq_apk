package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class coc
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
  public cmf Dby;
  public zi Eij;
  public int ijM;
  public String ijN;
  public String ijO;
  public String ijP;
  public int ijQ;
  public String ijR;
  public String ijV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117918);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Dby == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(117918);
        throw paramVarArgs;
      }
      if (this.DFJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(117918);
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
      if (this.Eij != null)
      {
        paramVarArgs.kX(15, this.Eij.computeSize());
        this.Eij.writeFields(paramVarArgs);
      }
      if (this.CVv != null) {
        paramVarArgs.d(16, this.CVv);
      }
      if (this.CVw != null) {
        paramVarArgs.d(17, this.CVw);
      }
      AppMethodBeat.o(117918);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Dby == null) {
        break label1514;
      }
    }
    label1514:
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
      if (this.Eij != null) {
        i = paramInt + f.a.a.a.kW(15, this.Eij.computeSize());
      }
      paramInt = i;
      if (this.CVv != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.CVv);
      }
      i = paramInt;
      if (this.CVw != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.CVw);
      }
      AppMethodBeat.o(117918);
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
          AppMethodBeat.o(117918);
          throw paramVarArgs;
        }
        if (this.DFJ == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(117918);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117918);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        coc localcoc = (coc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117918);
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
            localcoc.Dby = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117918);
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
            localcoc.DFJ = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117918);
          return 0;
        case 3: 
          localcoc.ijM = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(117918);
          return 0;
        case 4: 
          localcoc.ijN = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(117918);
          return 0;
        case 5: 
          localcoc.ijO = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(117918);
          return 0;
        case 6: 
          localcoc.ijP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(117918);
          return 0;
        case 7: 
          localcoc.ijQ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(117918);
          return 0;
        case 8: 
          localcoc.DIV = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(117918);
          return 0;
        case 9: 
          localcoc.DIW = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(117918);
          return 0;
        case 10: 
          localcoc.DIX = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(117918);
          return 0;
        case 11: 
          localcoc.ijR = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(117918);
          return 0;
        case 12: 
          localcoc.DIY = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(117918);
          return 0;
        case 13: 
          localcoc.DIZ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(117918);
          return 0;
        case 14: 
          localcoc.ijV = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(117918);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new zi();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((zi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcoc.Eij = ((zi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117918);
          return 0;
        case 16: 
          localcoc.CVv = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(117918);
          return 0;
        }
        localcoc.CVw = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(117918);
        return 0;
      }
      AppMethodBeat.o(117918);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.coc
 * JD-Core Version:    0.7.0.1
 */