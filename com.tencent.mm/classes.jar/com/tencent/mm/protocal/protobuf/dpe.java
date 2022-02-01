package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dpe
  extends cpx
{
  public SKBuiltinBuffer_t FWw;
  public int FWx;
  public int FWy;
  public String FWz;
  public String Fvl;
  public String Fvm;
  public int Fvn;
  public String Fvo;
  public String ProductID;
  public int vyb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91722);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FWw == null)
      {
        paramVarArgs = new b("Not all required fields were included: Receipt");
        AppMethodBeat.o(91722);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FWw != null)
      {
        paramVarArgs.ln(2, this.FWw.computeSize());
        this.FWw.writeFields(paramVarArgs);
      }
      if (this.ProductID != null) {
        paramVarArgs.d(3, this.ProductID);
      }
      paramVarArgs.aR(4, this.FWx);
      paramVarArgs.aR(5, this.vyb);
      if (this.Fvl != null) {
        paramVarArgs.d(6, this.Fvl);
      }
      if (this.Fvm != null) {
        paramVarArgs.d(7, this.Fvm);
      }
      if (this.Fvo != null) {
        paramVarArgs.d(8, this.Fvo);
      }
      paramVarArgs.aR(9, this.FWy);
      if (this.FWz != null) {
        paramVarArgs.d(10, this.FWz);
      }
      paramVarArgs.aR(11, this.Fvn);
      AppMethodBeat.o(91722);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label998;
      }
    }
    label998:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FWw != null) {
        paramInt = i + f.a.a.a.lm(2, this.FWw.computeSize());
      }
      i = paramInt;
      if (this.ProductID != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ProductID);
      }
      i = i + f.a.a.b.b.a.bx(4, this.FWx) + f.a.a.b.b.a.bx(5, this.vyb);
      paramInt = i;
      if (this.Fvl != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Fvl);
      }
      i = paramInt;
      if (this.Fvm != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Fvm);
      }
      paramInt = i;
      if (this.Fvo != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Fvo);
      }
      i = paramInt + f.a.a.b.b.a.bx(9, this.FWy);
      paramInt = i;
      if (this.FWz != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.FWz);
      }
      i = f.a.a.b.b.a.bx(11, this.Fvn);
      AppMethodBeat.o(91722);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.FWw == null)
        {
          paramVarArgs = new b("Not all required fields were included: Receipt");
          AppMethodBeat.o(91722);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91722);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dpe localdpe = (dpe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91722);
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
            localdpe.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91722);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdpe.FWw = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91722);
          return 0;
        case 3: 
          localdpe.ProductID = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91722);
          return 0;
        case 4: 
          localdpe.FWx = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91722);
          return 0;
        case 5: 
          localdpe.vyb = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91722);
          return 0;
        case 6: 
          localdpe.Fvl = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91722);
          return 0;
        case 7: 
          localdpe.Fvm = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91722);
          return 0;
        case 8: 
          localdpe.Fvo = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91722);
          return 0;
        case 9: 
          localdpe.FWy = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91722);
          return 0;
        case 10: 
          localdpe.FWz = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91722);
          return 0;
        }
        localdpe.Fvn = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91722);
        return 0;
      }
      AppMethodBeat.o(91722);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpe
 * JD-Core Version:    0.7.0.1
 */