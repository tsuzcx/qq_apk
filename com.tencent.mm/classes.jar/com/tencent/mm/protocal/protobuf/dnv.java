package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dnv
  extends cpx
{
  public String DPY;
  public String DRb;
  public int Eck;
  public int Eed;
  public int EfV;
  public String EhE;
  public int EvW;
  public int EwP;
  public int FVx;
  public int FVy;
  public int FiL;
  public int hNR;
  public String tlJ;
  public String tlK;
  public SKBuiltinBuffer_t vTK;
  public int vTO;
  public long vTQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(148661);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.vTK == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(148661);
        throw paramVarArgs;
      }
      if (this.tlK != null) {
        paramVarArgs.d(1, this.tlK);
      }
      if (this.tlJ != null) {
        paramVarArgs.d(2, this.tlJ);
      }
      paramVarArgs.aR(3, this.EfV);
      paramVarArgs.aR(4, this.Eck);
      if (this.DRb != null) {
        paramVarArgs.d(5, this.DRb);
      }
      paramVarArgs.aR(6, this.vTO);
      paramVarArgs.aR(7, this.Eed);
      if (this.vTK != null)
      {
        paramVarArgs.ln(8, this.vTK.computeSize());
        this.vTK.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(9, this.hNR);
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(10, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(11, this.EvW);
      if (this.DPY != null) {
        paramVarArgs.d(12, this.DPY);
      }
      paramVarArgs.aR(13, this.FiL);
      paramVarArgs.aR(14, this.FVx);
      paramVarArgs.aR(15, this.FVy);
      paramVarArgs.aO(16, this.vTQ);
      paramVarArgs.aR(17, this.EwP);
      if (this.EhE != null) {
        paramVarArgs.d(19, this.EhE);
      }
      AppMethodBeat.o(148661);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tlK == null) {
        break label1314;
      }
    }
    label1314:
    for (paramInt = f.a.a.b.b.a.e(1, this.tlK) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tlJ != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.tlJ);
      }
      i = i + f.a.a.b.b.a.bx(3, this.EfV) + f.a.a.b.b.a.bx(4, this.Eck);
      paramInt = i;
      if (this.DRb != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.DRb);
      }
      i = paramInt + f.a.a.b.b.a.bx(6, this.vTO) + f.a.a.b.b.a.bx(7, this.Eed);
      paramInt = i;
      if (this.vTK != null) {
        paramInt = i + f.a.a.a.lm(8, this.vTK.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(9, this.hNR);
      paramInt = i;
      if (this.BaseRequest != null) {
        paramInt = i + f.a.a.a.lm(10, this.BaseRequest.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(11, this.EvW);
      paramInt = i;
      if (this.DPY != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.DPY);
      }
      i = paramInt + f.a.a.b.b.a.bx(13, this.FiL) + f.a.a.b.b.a.bx(14, this.FVx) + f.a.a.b.b.a.bx(15, this.FVy) + f.a.a.b.b.a.p(16, this.vTQ) + f.a.a.b.b.a.bx(17, this.EwP);
      paramInt = i;
      if (this.EhE != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.EhE);
      }
      AppMethodBeat.o(148661);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.vTK == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(148661);
          throw paramVarArgs;
        }
        AppMethodBeat.o(148661);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dnv localdnv = (dnv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 18: 
        default: 
          AppMethodBeat.o(148661);
          return -1;
        case 1: 
          localdnv.tlK = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(148661);
          return 0;
        case 2: 
          localdnv.tlJ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(148661);
          return 0;
        case 3: 
          localdnv.EfV = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(148661);
          return 0;
        case 4: 
          localdnv.Eck = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(148661);
          return 0;
        case 5: 
          localdnv.DRb = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(148661);
          return 0;
        case 6: 
          localdnv.vTO = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(148661);
          return 0;
        case 7: 
          localdnv.Eed = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(148661);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdnv.vTK = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148661);
          return 0;
        case 9: 
          localdnv.hNR = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(148661);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdnv.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148661);
          return 0;
        case 11: 
          localdnv.EvW = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(148661);
          return 0;
        case 12: 
          localdnv.DPY = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(148661);
          return 0;
        case 13: 
          localdnv.FiL = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(148661);
          return 0;
        case 14: 
          localdnv.FVx = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(148661);
          return 0;
        case 15: 
          localdnv.FVy = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(148661);
          return 0;
        case 16: 
          localdnv.vTQ = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(148661);
          return 0;
        case 17: 
          localdnv.EwP = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(148661);
          return 0;
        }
        localdnv.EhE = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(148661);
        return 0;
      }
      AppMethodBeat.o(148661);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dnv
 * JD-Core Version:    0.7.0.1
 */