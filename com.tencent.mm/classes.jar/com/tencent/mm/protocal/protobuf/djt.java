package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class djt
  extends com.tencent.mm.bx.a
{
  public int CzZ;
  public String Dpx;
  public String Dqd;
  public String EgI;
  public String EzA;
  public String EzB;
  public int EzC;
  public String EzD;
  public int EzE;
  public SKBuiltinBuffer_t EzF;
  public SKBuiltinBuffer_t EzG;
  public String Ezy;
  public int Ezz;
  public String vJI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152723);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.vJI != null) {
        paramVarArgs.d(1, this.vJI);
      }
      if (this.Ezy != null) {
        paramVarArgs.d(2, this.Ezy);
      }
      if (this.Dqd != null) {
        paramVarArgs.d(3, this.Dqd);
      }
      paramVarArgs.aR(4, this.Ezz);
      if (this.EgI != null) {
        paramVarArgs.d(5, this.EgI);
      }
      if (this.EzA != null) {
        paramVarArgs.d(6, this.EzA);
      }
      if (this.EzB != null) {
        paramVarArgs.d(7, this.EzB);
      }
      paramVarArgs.aR(8, this.EzC);
      if (this.EzD != null) {
        paramVarArgs.d(9, this.EzD);
      }
      paramVarArgs.aR(10, this.EzE);
      if (this.EzF != null)
      {
        paramVarArgs.kX(11, this.EzF.computeSize());
        this.EzF.writeFields(paramVarArgs);
      }
      if (this.Dpx != null) {
        paramVarArgs.d(12, this.Dpx);
      }
      paramVarArgs.aR(13, this.CzZ);
      if (this.EzG != null)
      {
        paramVarArgs.kX(14, this.EzG.computeSize());
        this.EzG.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(152723);
      return 0;
    }
    if (paramInt == 1) {
      if (this.vJI == null) {
        break label1138;
      }
    }
    label1138:
    for (int i = f.a.a.b.b.a.e(1, this.vJI) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Ezy != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Ezy);
      }
      i = paramInt;
      if (this.Dqd != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Dqd);
      }
      i += f.a.a.b.b.a.bA(4, this.Ezz);
      paramInt = i;
      if (this.EgI != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.EgI);
      }
      i = paramInt;
      if (this.EzA != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.EzA);
      }
      paramInt = i;
      if (this.EzB != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.EzB);
      }
      i = paramInt + f.a.a.b.b.a.bA(8, this.EzC);
      paramInt = i;
      if (this.EzD != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.EzD);
      }
      i = paramInt + f.a.a.b.b.a.bA(10, this.EzE);
      paramInt = i;
      if (this.EzF != null) {
        paramInt = i + f.a.a.a.kW(11, this.EzF.computeSize());
      }
      i = paramInt;
      if (this.Dpx != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.Dpx);
      }
      i += f.a.a.b.b.a.bA(13, this.CzZ);
      paramInt = i;
      if (this.EzG != null) {
        paramInt = i + f.a.a.a.kW(14, this.EzG.computeSize());
      }
      AppMethodBeat.o(152723);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(152723);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        djt localdjt = (djt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152723);
          return -1;
        case 1: 
          localdjt.vJI = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152723);
          return 0;
        case 2: 
          localdjt.Ezy = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152723);
          return 0;
        case 3: 
          localdjt.Dqd = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152723);
          return 0;
        case 4: 
          localdjt.Ezz = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152723);
          return 0;
        case 5: 
          localdjt.EgI = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152723);
          return 0;
        case 6: 
          localdjt.EzA = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152723);
          return 0;
        case 7: 
          localdjt.EzB = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152723);
          return 0;
        case 8: 
          localdjt.EzC = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152723);
          return 0;
        case 9: 
          localdjt.EzD = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152723);
          return 0;
        case 10: 
          localdjt.EzE = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152723);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdjt.EzF = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152723);
          return 0;
        case 12: 
          localdjt.Dpx = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152723);
          return 0;
        case 13: 
          localdjt.CzZ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152723);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdjt.EzG = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152723);
        return 0;
      }
      AppMethodBeat.o(152723);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djt
 * JD-Core Version:    0.7.0.1
 */