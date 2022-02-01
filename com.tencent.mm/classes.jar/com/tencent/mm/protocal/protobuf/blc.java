package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class blc
  extends com.tencent.mm.bx.a
{
  public String DJd;
  public SKBuiltinBuffer_t DJe;
  public int DJf;
  public int DJg;
  public String Title;
  public int mBH;
  public int ubA;
  public LinkedList<cmf> ubB;
  public float ubC;
  public String ubD;
  public SKBuiltinBuffer_t ubE;
  public String ubw;
  public float ubx;
  public int uby;
  public LinkedList<Integer> ubz;
  
  public blc()
  {
    AppMethodBeat.i(116338);
    this.ubz = new LinkedList();
    this.ubB = new LinkedList();
    AppMethodBeat.o(116338);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116339);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ubw != null) {
        paramVarArgs.d(1, this.ubw);
      }
      if (this.Title != null) {
        paramVarArgs.d(2, this.Title);
      }
      paramVarArgs.x(3, this.ubx);
      paramVarArgs.aR(4, this.uby);
      paramVarArgs.f(5, 2, this.ubz);
      paramVarArgs.aR(6, this.ubA);
      paramVarArgs.e(7, 8, this.ubB);
      paramVarArgs.x(8, this.ubC);
      if (this.ubD != null) {
        paramVarArgs.d(9, this.ubD);
      }
      paramVarArgs.aR(10, this.mBH);
      if (this.ubE != null)
      {
        paramVarArgs.kX(11, this.ubE.computeSize());
        this.ubE.writeFields(paramVarArgs);
      }
      if (this.DJd != null) {
        paramVarArgs.d(12, this.DJd);
      }
      if (this.DJe != null)
      {
        paramVarArgs.kX(13, this.DJe.computeSize());
        this.DJe.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(14, this.DJf);
      paramVarArgs.aR(15, this.DJg);
      AppMethodBeat.o(116339);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ubw == null) {
        break label1239;
      }
    }
    label1239:
    for (paramInt = f.a.a.b.b.a.e(1, this.ubw) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Title != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Title);
      }
      i = i + (f.a.a.b.b.a.fY(3) + 4) + f.a.a.b.b.a.bA(4, this.uby) + f.a.a.a.d(5, 2, this.ubz) + f.a.a.b.b.a.bA(6, this.ubA) + f.a.a.a.c(7, 8, this.ubB) + (f.a.a.b.b.a.fY(8) + 4);
      paramInt = i;
      if (this.ubD != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.ubD);
      }
      i = paramInt + f.a.a.b.b.a.bA(10, this.mBH);
      paramInt = i;
      if (this.ubE != null) {
        paramInt = i + f.a.a.a.kW(11, this.ubE.computeSize());
      }
      i = paramInt;
      if (this.DJd != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.DJd);
      }
      paramInt = i;
      if (this.DJe != null) {
        paramInt = i + f.a.a.a.kW(13, this.DJe.computeSize());
      }
      i = f.a.a.b.b.a.bA(14, this.DJf);
      int j = f.a.a.b.b.a.bA(15, this.DJg);
      AppMethodBeat.o(116339);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ubz.clear();
        this.ubB.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(116339);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        blc localblc = (blc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(116339);
          return -1;
        case 1: 
          localblc.ubw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(116339);
          return 0;
        case 2: 
          localblc.Title = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(116339);
          return 0;
        case 3: 
          localblc.ubx = Float.intBitsToFloat(((f.a.a.a.a)localObject1).KhF.fHx());
          AppMethodBeat.o(116339);
          return 0;
        case 4: 
          localblc.uby = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(116339);
          return 0;
        case 5: 
          localblc.ubz = new f.a.a.a.a(((f.a.a.a.a)localObject1).KhF.fMu().wA, unknownTagHandler).KhF.fMs();
          AppMethodBeat.o(116339);
          return 0;
        case 6: 
          localblc.ubA = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(116339);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localblc.ubB.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116339);
          return 0;
        case 8: 
          localblc.ubC = Float.intBitsToFloat(((f.a.a.a.a)localObject1).KhF.fHx());
          AppMethodBeat.o(116339);
          return 0;
        case 9: 
          localblc.ubD = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(116339);
          return 0;
        case 10: 
          localblc.mBH = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(116339);
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
            localblc.ubE = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116339);
          return 0;
        case 12: 
          localblc.DJd = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(116339);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localblc.DJe = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116339);
          return 0;
        case 14: 
          localblc.DJf = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(116339);
          return 0;
        }
        localblc.DJg = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(116339);
        return 0;
      }
      AppMethodBeat.o(116339);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.blc
 * JD-Core Version:    0.7.0.1
 */