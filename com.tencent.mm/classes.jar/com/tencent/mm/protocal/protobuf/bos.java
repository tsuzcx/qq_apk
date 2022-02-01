package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bos
  extends cpx
{
  public int ETI;
  public boolean EWn;
  public boolean EWo;
  public dzp FdV;
  public ebm FdW;
  public eao FdX;
  public ecj FdY;
  public ebf FdZ;
  public ebn Fea;
  public int Feb;
  public String Fec;
  public String Fed;
  public ebo Fee;
  public String hOf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123624);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.hOf != null) {
        paramVarArgs.d(2, this.hOf);
      }
      if (this.FdV != null)
      {
        paramVarArgs.ln(3, this.FdV.computeSize());
        this.FdV.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(4, this.ETI);
      if (this.FdW != null)
      {
        paramVarArgs.ln(5, this.FdW.computeSize());
        this.FdW.writeFields(paramVarArgs);
      }
      if (this.FdX != null)
      {
        paramVarArgs.ln(6, this.FdX.computeSize());
        this.FdX.writeFields(paramVarArgs);
      }
      if (this.FdY != null)
      {
        paramVarArgs.ln(7, this.FdY.computeSize());
        this.FdY.writeFields(paramVarArgs);
      }
      if (this.FdZ != null)
      {
        paramVarArgs.ln(8, this.FdZ.computeSize());
        this.FdZ.writeFields(paramVarArgs);
      }
      if (this.Fea != null)
      {
        paramVarArgs.ln(9, this.Fea.computeSize());
        this.Fea.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(10, this.Feb);
      if (this.Fec != null) {
        paramVarArgs.d(11, this.Fec);
      }
      if (this.Fed != null) {
        paramVarArgs.d(12, this.Fed);
      }
      paramVarArgs.bl(13, this.EWn);
      paramVarArgs.bl(14, this.EWo);
      if (this.Fee != null)
      {
        paramVarArgs.ln(15, this.Fee.computeSize());
        this.Fee.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(123624);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1758;
      }
    }
    label1758:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hOf != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.hOf);
      }
      i = paramInt;
      if (this.FdV != null) {
        i = paramInt + f.a.a.a.lm(3, this.FdV.computeSize());
      }
      i += f.a.a.b.b.a.bx(4, this.ETI);
      paramInt = i;
      if (this.FdW != null) {
        paramInt = i + f.a.a.a.lm(5, this.FdW.computeSize());
      }
      i = paramInt;
      if (this.FdX != null) {
        i = paramInt + f.a.a.a.lm(6, this.FdX.computeSize());
      }
      paramInt = i;
      if (this.FdY != null) {
        paramInt = i + f.a.a.a.lm(7, this.FdY.computeSize());
      }
      i = paramInt;
      if (this.FdZ != null) {
        i = paramInt + f.a.a.a.lm(8, this.FdZ.computeSize());
      }
      paramInt = i;
      if (this.Fea != null) {
        paramInt = i + f.a.a.a.lm(9, this.Fea.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(10, this.Feb);
      paramInt = i;
      if (this.Fec != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.Fec);
      }
      i = paramInt;
      if (this.Fed != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.Fed);
      }
      i = i + (f.a.a.b.b.a.fK(13) + 1) + (f.a.a.b.b.a.fK(14) + 1);
      paramInt = i;
      if (this.Fee != null) {
        paramInt = i + f.a.a.a.lm(15, this.Fee.computeSize());
      }
      AppMethodBeat.o(123624);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(123624);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bos localbos = (bos)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123624);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbos.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123624);
          return 0;
        case 2: 
          localbos.hOf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123624);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dzp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dzp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbos.FdV = ((dzp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123624);
          return 0;
        case 4: 
          localbos.ETI = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(123624);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ebm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ebm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbos.FdW = ((ebm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123624);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eao();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eao)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbos.FdX = ((eao)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123624);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ecj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ecj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbos.FdY = ((ecj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123624);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ebf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ebf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbos.FdZ = ((ebf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123624);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ebn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ebn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbos.Fea = ((ebn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123624);
          return 0;
        case 10: 
          localbos.Feb = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(123624);
          return 0;
        case 11: 
          localbos.Fec = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123624);
          return 0;
        case 12: 
          localbos.Fed = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123624);
          return 0;
        case 13: 
          localbos.EWn = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(123624);
          return 0;
        case 14: 
          localbos.EWo = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(123624);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ebo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ebo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbos.Fee = ((ebo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(123624);
        return 0;
      }
      AppMethodBeat.o(123624);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bos
 * JD-Core Version:    0.7.0.1
 */