package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class te
  extends dop
{
  public String KEq;
  public String KEr;
  public String KEs;
  public String KHq;
  public int LbA;
  public SKBuiltinBuffer_t LbB;
  public float LbC;
  public float LbD;
  public String LbE;
  public int LbF;
  public int LbG;
  public int LbH;
  public int LbI;
  public String LbJ;
  public int LbK;
  public int LbL;
  public int LbM;
  public String LbN;
  public String Lby;
  public int Lbz;
  public int Scene;
  public String jfi;
  public String xNG;
  public String xNH;
  public int xub;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152511);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Lby != null) {
        paramVarArgs.e(1, this.Lby);
      }
      if (this.xNH != null) {
        paramVarArgs.e(2, this.xNH);
      }
      if (this.xNG != null) {
        paramVarArgs.e(3, this.xNG);
      }
      paramVarArgs.aM(4, this.Lbz);
      paramVarArgs.aM(5, this.LbA);
      if (this.KHq != null) {
        paramVarArgs.e(6, this.KHq);
      }
      if (this.LbB != null)
      {
        paramVarArgs.ni(7, this.LbB.computeSize());
        this.LbB.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(8, this.Scene);
      paramVarArgs.E(9, this.LbC);
      paramVarArgs.E(10, this.LbD);
      if (this.LbE != null) {
        paramVarArgs.e(11, this.LbE);
      }
      paramVarArgs.aM(12, this.LbF);
      paramVarArgs.aM(13, this.LbG);
      paramVarArgs.aM(14, this.LbH);
      paramVarArgs.aM(15, this.LbI);
      if (this.LbJ != null) {
        paramVarArgs.e(16, this.LbJ);
      }
      paramVarArgs.aM(17, this.LbK);
      paramVarArgs.aM(18, this.LbL);
      paramVarArgs.aM(19, this.LbM);
      paramVarArgs.aM(20, this.xub);
      if (this.jfi != null) {
        paramVarArgs.e(21, this.jfi);
      }
      if (this.KEs != null) {
        paramVarArgs.e(22, this.KEs);
      }
      if (this.KEr != null) {
        paramVarArgs.e(23, this.KEr);
      }
      if (this.KEq != null) {
        paramVarArgs.e(24, this.KEq);
      }
      if (this.LbN != null) {
        paramVarArgs.e(25, this.LbN);
      }
      AppMethodBeat.o(152511);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Lby == null) {
        break label1568;
      }
    }
    label1568:
    for (int i = g.a.a.b.b.a.f(1, this.Lby) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xNH != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.xNH);
      }
      i = paramInt;
      if (this.xNG != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.xNG);
      }
      i = i + g.a.a.b.b.a.bu(4, this.Lbz) + g.a.a.b.b.a.bu(5, this.LbA);
      paramInt = i;
      if (this.KHq != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.KHq);
      }
      i = paramInt;
      if (this.LbB != null) {
        i = paramInt + g.a.a.a.nh(7, this.LbB.computeSize());
      }
      i = i + g.a.a.b.b.a.bu(8, this.Scene) + (g.a.a.b.b.a.fS(9) + 4) + (g.a.a.b.b.a.fS(10) + 4);
      paramInt = i;
      if (this.LbE != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.LbE);
      }
      i = paramInt + g.a.a.b.b.a.bu(12, this.LbF) + g.a.a.b.b.a.bu(13, this.LbG) + g.a.a.b.b.a.bu(14, this.LbH) + g.a.a.b.b.a.bu(15, this.LbI);
      paramInt = i;
      if (this.LbJ != null) {
        paramInt = i + g.a.a.b.b.a.f(16, this.LbJ);
      }
      i = paramInt + g.a.a.b.b.a.bu(17, this.LbK) + g.a.a.b.b.a.bu(18, this.LbL) + g.a.a.b.b.a.bu(19, this.LbM) + g.a.a.b.b.a.bu(20, this.xub);
      paramInt = i;
      if (this.jfi != null) {
        paramInt = i + g.a.a.b.b.a.f(21, this.jfi);
      }
      i = paramInt;
      if (this.KEs != null) {
        i = paramInt + g.a.a.b.b.a.f(22, this.KEs);
      }
      paramInt = i;
      if (this.KEr != null) {
        paramInt = i + g.a.a.b.b.a.f(23, this.KEr);
      }
      i = paramInt;
      if (this.KEq != null) {
        i = paramInt + g.a.a.b.b.a.f(24, this.KEq);
      }
      paramInt = i;
      if (this.LbN != null) {
        paramInt = i + g.a.a.b.b.a.f(25, this.LbN);
      }
      AppMethodBeat.o(152511);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(152511);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        te localte = (te)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152511);
          return -1;
        case 1: 
          localte.Lby = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152511);
          return 0;
        case 2: 
          localte.xNH = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152511);
          return 0;
        case 3: 
          localte.xNG = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152511);
          return 0;
        case 4: 
          localte.Lbz = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152511);
          return 0;
        case 5: 
          localte.LbA = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152511);
          return 0;
        case 6: 
          localte.KHq = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152511);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localte.LbB = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152511);
          return 0;
        case 8: 
          localte.Scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152511);
          return 0;
        case 9: 
          localte.LbC = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
          AppMethodBeat.o(152511);
          return 0;
        case 10: 
          localte.LbD = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
          AppMethodBeat.o(152511);
          return 0;
        case 11: 
          localte.LbE = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152511);
          return 0;
        case 12: 
          localte.LbF = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152511);
          return 0;
        case 13: 
          localte.LbG = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152511);
          return 0;
        case 14: 
          localte.LbH = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152511);
          return 0;
        case 15: 
          localte.LbI = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152511);
          return 0;
        case 16: 
          localte.LbJ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152511);
          return 0;
        case 17: 
          localte.LbK = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152511);
          return 0;
        case 18: 
          localte.LbL = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152511);
          return 0;
        case 19: 
          localte.LbM = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152511);
          return 0;
        case 20: 
          localte.xub = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152511);
          return 0;
        case 21: 
          localte.jfi = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152511);
          return 0;
        case 22: 
          localte.KEs = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152511);
          return 0;
        case 23: 
          localte.KEr = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152511);
          return 0;
        case 24: 
          localte.KEq = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152511);
          return 0;
        }
        localte.LbN = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(152511);
        return 0;
      }
      AppMethodBeat.o(152511);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.te
 * JD-Core Version:    0.7.0.1
 */