package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dna
  extends cpx
{
  public int DTc;
  public int DTf;
  public int EfV;
  public String FUF;
  public int FUG;
  public int FUH;
  public int hNR;
  public String ncR;
  public SKBuiltinBuffer_t vTK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(148657);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.vTK == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(148657);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ncR != null) {
        paramVarArgs.d(2, this.ncR);
      }
      if (this.vTK != null)
      {
        paramVarArgs.ln(3, this.vTK.computeSize());
        this.vTK.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(4, this.EfV);
      if (this.FUF != null) {
        paramVarArgs.d(5, this.FUF);
      }
      paramVarArgs.aR(6, this.hNR);
      paramVarArgs.aR(7, this.FUG);
      paramVarArgs.aR(8, this.DTf);
      paramVarArgs.aR(9, this.FUH);
      paramVarArgs.aR(10, this.DTc);
      AppMethodBeat.o(148657);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label914;
      }
    }
    label914:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ncR != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ncR);
      }
      i = paramInt;
      if (this.vTK != null) {
        i = paramInt + f.a.a.a.lm(3, this.vTK.computeSize());
      }
      i += f.a.a.b.b.a.bx(4, this.EfV);
      paramInt = i;
      if (this.FUF != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FUF);
      }
      i = f.a.a.b.b.a.bx(6, this.hNR);
      int j = f.a.a.b.b.a.bx(7, this.FUG);
      int k = f.a.a.b.b.a.bx(8, this.DTf);
      int m = f.a.a.b.b.a.bx(9, this.FUH);
      int n = f.a.a.b.b.a.bx(10, this.DTc);
      AppMethodBeat.o(148657);
      return paramInt + i + j + k + m + n;
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
          AppMethodBeat.o(148657);
          throw paramVarArgs;
        }
        AppMethodBeat.o(148657);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dna localdna = (dna)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(148657);
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
            localdna.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148657);
          return 0;
        case 2: 
          localdna.ncR = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(148657);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdna.vTK = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148657);
          return 0;
        case 4: 
          localdna.EfV = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(148657);
          return 0;
        case 5: 
          localdna.FUF = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(148657);
          return 0;
        case 6: 
          localdna.hNR = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(148657);
          return 0;
        case 7: 
          localdna.FUG = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(148657);
          return 0;
        case 8: 
          localdna.DTf = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(148657);
          return 0;
        case 9: 
          localdna.FUH = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(148657);
          return 0;
        }
        localdna.DTc = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(148657);
        return 0;
      }
      AppMethodBeat.o(148657);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dna
 * JD-Core Version:    0.7.0.1
 */