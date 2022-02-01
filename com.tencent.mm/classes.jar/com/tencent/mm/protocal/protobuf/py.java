package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class py
  extends ckq
{
  public String COE;
  public int COF;
  public int COG;
  public SKBuiltinBuffer_t COH;
  public float COI;
  public float COJ;
  public String COK;
  public int COL;
  public int COM;
  public int CON;
  public int COO;
  public String COP;
  public int COQ;
  public int COR;
  public int COS;
  public String COT;
  public String CuS;
  public String CuT;
  public String CuU;
  public String CxC;
  public int Scene;
  public String hnC;
  public int rNz;
  public String sdP;
  public String sdQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152511);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.COE != null) {
        paramVarArgs.d(1, this.COE);
      }
      if (this.sdQ != null) {
        paramVarArgs.d(2, this.sdQ);
      }
      if (this.sdP != null) {
        paramVarArgs.d(3, this.sdP);
      }
      paramVarArgs.aR(4, this.COF);
      paramVarArgs.aR(5, this.COG);
      if (this.CxC != null) {
        paramVarArgs.d(6, this.CxC);
      }
      if (this.COH != null)
      {
        paramVarArgs.kX(7, this.COH.computeSize());
        this.COH.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(8, this.Scene);
      paramVarArgs.x(9, this.COI);
      paramVarArgs.x(10, this.COJ);
      if (this.COK != null) {
        paramVarArgs.d(11, this.COK);
      }
      paramVarArgs.aR(12, this.COL);
      paramVarArgs.aR(13, this.COM);
      paramVarArgs.aR(14, this.CON);
      paramVarArgs.aR(15, this.COO);
      if (this.COP != null) {
        paramVarArgs.d(16, this.COP);
      }
      paramVarArgs.aR(17, this.COQ);
      paramVarArgs.aR(18, this.COR);
      paramVarArgs.aR(19, this.COS);
      paramVarArgs.aR(20, this.rNz);
      if (this.hnC != null) {
        paramVarArgs.d(21, this.hnC);
      }
      if (this.CuU != null) {
        paramVarArgs.d(22, this.CuU);
      }
      if (this.CuT != null) {
        paramVarArgs.d(23, this.CuT);
      }
      if (this.CuS != null) {
        paramVarArgs.d(24, this.CuS);
      }
      if (this.COT != null) {
        paramVarArgs.d(25, this.COT);
      }
      AppMethodBeat.o(152511);
      return 0;
    }
    if (paramInt == 1) {
      if (this.COE == null) {
        break label1568;
      }
    }
    label1568:
    for (int i = f.a.a.b.b.a.e(1, this.COE) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sdQ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.sdQ);
      }
      i = paramInt;
      if (this.sdP != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.sdP);
      }
      i = i + f.a.a.b.b.a.bA(4, this.COF) + f.a.a.b.b.a.bA(5, this.COG);
      paramInt = i;
      if (this.CxC != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CxC);
      }
      i = paramInt;
      if (this.COH != null) {
        i = paramInt + f.a.a.a.kW(7, this.COH.computeSize());
      }
      i = i + f.a.a.b.b.a.bA(8, this.Scene) + (f.a.a.b.b.a.fY(9) + 4) + (f.a.a.b.b.a.fY(10) + 4);
      paramInt = i;
      if (this.COK != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.COK);
      }
      i = paramInt + f.a.a.b.b.a.bA(12, this.COL) + f.a.a.b.b.a.bA(13, this.COM) + f.a.a.b.b.a.bA(14, this.CON) + f.a.a.b.b.a.bA(15, this.COO);
      paramInt = i;
      if (this.COP != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.COP);
      }
      i = paramInt + f.a.a.b.b.a.bA(17, this.COQ) + f.a.a.b.b.a.bA(18, this.COR) + f.a.a.b.b.a.bA(19, this.COS) + f.a.a.b.b.a.bA(20, this.rNz);
      paramInt = i;
      if (this.hnC != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.hnC);
      }
      i = paramInt;
      if (this.CuU != null) {
        i = paramInt + f.a.a.b.b.a.e(22, this.CuU);
      }
      paramInt = i;
      if (this.CuT != null) {
        paramInt = i + f.a.a.b.b.a.e(23, this.CuT);
      }
      i = paramInt;
      if (this.CuS != null) {
        i = paramInt + f.a.a.b.b.a.e(24, this.CuS);
      }
      paramInt = i;
      if (this.COT != null) {
        paramInt = i + f.a.a.b.b.a.e(25, this.COT);
      }
      AppMethodBeat.o(152511);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(152511);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        py localpy = (py)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152511);
          return -1;
        case 1: 
          localpy.COE = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152511);
          return 0;
        case 2: 
          localpy.sdQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152511);
          return 0;
        case 3: 
          localpy.sdP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152511);
          return 0;
        case 4: 
          localpy.COF = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152511);
          return 0;
        case 5: 
          localpy.COG = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152511);
          return 0;
        case 6: 
          localpy.CxC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152511);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localpy.COH = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152511);
          return 0;
        case 8: 
          localpy.Scene = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152511);
          return 0;
        case 9: 
          localpy.COI = Float.intBitsToFloat(((f.a.a.a.a)localObject1).KhF.fHx());
          AppMethodBeat.o(152511);
          return 0;
        case 10: 
          localpy.COJ = Float.intBitsToFloat(((f.a.a.a.a)localObject1).KhF.fHx());
          AppMethodBeat.o(152511);
          return 0;
        case 11: 
          localpy.COK = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152511);
          return 0;
        case 12: 
          localpy.COL = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152511);
          return 0;
        case 13: 
          localpy.COM = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152511);
          return 0;
        case 14: 
          localpy.CON = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152511);
          return 0;
        case 15: 
          localpy.COO = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152511);
          return 0;
        case 16: 
          localpy.COP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152511);
          return 0;
        case 17: 
          localpy.COQ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152511);
          return 0;
        case 18: 
          localpy.COR = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152511);
          return 0;
        case 19: 
          localpy.COS = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152511);
          return 0;
        case 20: 
          localpy.rNz = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152511);
          return 0;
        case 21: 
          localpy.hnC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152511);
          return 0;
        case 22: 
          localpy.CuU = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152511);
          return 0;
        case 23: 
          localpy.CuT = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152511);
          return 0;
        case 24: 
          localpy.CuS = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152511);
          return 0;
        }
        localpy.COT = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(152511);
        return 0;
      }
      AppMethodBeat.o(152511);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.py
 * JD-Core Version:    0.7.0.1
 */