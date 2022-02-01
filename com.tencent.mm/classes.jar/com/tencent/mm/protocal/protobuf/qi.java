package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class qi
  extends cpx
{
  public String DNn;
  public String DNo;
  public String DNp;
  public String DPY;
  public String EhA;
  public int EhB;
  public int EhC;
  public int EhD;
  public String EhE;
  public String Ehp;
  public int Ehq;
  public int Ehr;
  public SKBuiltinBuffer_t Ehs;
  public float Eht;
  public float Ehu;
  public String Ehv;
  public int Ehw;
  public int Ehx;
  public int Ehy;
  public int Ehz;
  public int Scene;
  public String hOf;
  public int sVo;
  public String tlJ;
  public String tlK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152511);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Ehp != null) {
        paramVarArgs.d(1, this.Ehp);
      }
      if (this.tlK != null) {
        paramVarArgs.d(2, this.tlK);
      }
      if (this.tlJ != null) {
        paramVarArgs.d(3, this.tlJ);
      }
      paramVarArgs.aR(4, this.Ehq);
      paramVarArgs.aR(5, this.Ehr);
      if (this.DPY != null) {
        paramVarArgs.d(6, this.DPY);
      }
      if (this.Ehs != null)
      {
        paramVarArgs.ln(7, this.Ehs.computeSize());
        this.Ehs.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(8, this.Scene);
      paramVarArgs.x(9, this.Eht);
      paramVarArgs.x(10, this.Ehu);
      if (this.Ehv != null) {
        paramVarArgs.d(11, this.Ehv);
      }
      paramVarArgs.aR(12, this.Ehw);
      paramVarArgs.aR(13, this.Ehx);
      paramVarArgs.aR(14, this.Ehy);
      paramVarArgs.aR(15, this.Ehz);
      if (this.EhA != null) {
        paramVarArgs.d(16, this.EhA);
      }
      paramVarArgs.aR(17, this.EhB);
      paramVarArgs.aR(18, this.EhC);
      paramVarArgs.aR(19, this.EhD);
      paramVarArgs.aR(20, this.sVo);
      if (this.hOf != null) {
        paramVarArgs.d(21, this.hOf);
      }
      if (this.DNp != null) {
        paramVarArgs.d(22, this.DNp);
      }
      if (this.DNo != null) {
        paramVarArgs.d(23, this.DNo);
      }
      if (this.DNn != null) {
        paramVarArgs.d(24, this.DNn);
      }
      if (this.EhE != null) {
        paramVarArgs.d(25, this.EhE);
      }
      AppMethodBeat.o(152511);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ehp == null) {
        break label1568;
      }
    }
    label1568:
    for (int i = f.a.a.b.b.a.e(1, this.Ehp) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tlK != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.tlK);
      }
      i = paramInt;
      if (this.tlJ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.tlJ);
      }
      i = i + f.a.a.b.b.a.bx(4, this.Ehq) + f.a.a.b.b.a.bx(5, this.Ehr);
      paramInt = i;
      if (this.DPY != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DPY);
      }
      i = paramInt;
      if (this.Ehs != null) {
        i = paramInt + f.a.a.a.lm(7, this.Ehs.computeSize());
      }
      i = i + f.a.a.b.b.a.bx(8, this.Scene) + (f.a.a.b.b.a.fK(9) + 4) + (f.a.a.b.b.a.fK(10) + 4);
      paramInt = i;
      if (this.Ehv != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.Ehv);
      }
      i = paramInt + f.a.a.b.b.a.bx(12, this.Ehw) + f.a.a.b.b.a.bx(13, this.Ehx) + f.a.a.b.b.a.bx(14, this.Ehy) + f.a.a.b.b.a.bx(15, this.Ehz);
      paramInt = i;
      if (this.EhA != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.EhA);
      }
      i = paramInt + f.a.a.b.b.a.bx(17, this.EhB) + f.a.a.b.b.a.bx(18, this.EhC) + f.a.a.b.b.a.bx(19, this.EhD) + f.a.a.b.b.a.bx(20, this.sVo);
      paramInt = i;
      if (this.hOf != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.hOf);
      }
      i = paramInt;
      if (this.DNp != null) {
        i = paramInt + f.a.a.b.b.a.e(22, this.DNp);
      }
      paramInt = i;
      if (this.DNo != null) {
        paramInt = i + f.a.a.b.b.a.e(23, this.DNo);
      }
      i = paramInt;
      if (this.DNn != null) {
        i = paramInt + f.a.a.b.b.a.e(24, this.DNn);
      }
      paramInt = i;
      if (this.EhE != null) {
        paramInt = i + f.a.a.b.b.a.e(25, this.EhE);
      }
      AppMethodBeat.o(152511);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(152511);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        qi localqi = (qi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152511);
          return -1;
        case 1: 
          localqi.Ehp = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152511);
          return 0;
        case 2: 
          localqi.tlK = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152511);
          return 0;
        case 3: 
          localqi.tlJ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152511);
          return 0;
        case 4: 
          localqi.Ehq = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152511);
          return 0;
        case 5: 
          localqi.Ehr = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152511);
          return 0;
        case 6: 
          localqi.DPY = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152511);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localqi.Ehs = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152511);
          return 0;
        case 8: 
          localqi.Scene = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152511);
          return 0;
        case 9: 
          localqi.Eht = Float.intBitsToFloat(((f.a.a.a.a)localObject1).LVo.gaa());
          AppMethodBeat.o(152511);
          return 0;
        case 10: 
          localqi.Ehu = Float.intBitsToFloat(((f.a.a.a.a)localObject1).LVo.gaa());
          AppMethodBeat.o(152511);
          return 0;
        case 11: 
          localqi.Ehv = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152511);
          return 0;
        case 12: 
          localqi.Ehw = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152511);
          return 0;
        case 13: 
          localqi.Ehx = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152511);
          return 0;
        case 14: 
          localqi.Ehy = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152511);
          return 0;
        case 15: 
          localqi.Ehz = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152511);
          return 0;
        case 16: 
          localqi.EhA = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152511);
          return 0;
        case 17: 
          localqi.EhB = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152511);
          return 0;
        case 18: 
          localqi.EhC = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152511);
          return 0;
        case 19: 
          localqi.EhD = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152511);
          return 0;
        case 20: 
          localqi.sVo = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152511);
          return 0;
        case 21: 
          localqi.hOf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152511);
          return 0;
        case 22: 
          localqi.DNp = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152511);
          return 0;
        case 23: 
          localqi.DNo = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152511);
          return 0;
        case 24: 
          localqi.DNn = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152511);
          return 0;
        }
        localqi.EhE = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(152511);
        return 0;
      }
      AppMethodBeat.o(152511);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qi
 * JD-Core Version:    0.7.0.1
 */