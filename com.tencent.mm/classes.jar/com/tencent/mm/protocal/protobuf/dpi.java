package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dpi
  extends com.tencent.mm.bw.a
{
  public int DSv;
  public String EKy;
  public String ELg;
  public String FDH;
  public String FWC;
  public int FWD;
  public String FWE;
  public String FWF;
  public int FWG;
  public String FWH;
  public int FWI;
  public SKBuiltinBuffer_t FWJ;
  public SKBuiltinBuffer_t FWK;
  public String wTM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152723);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.wTM != null) {
        paramVarArgs.d(1, this.wTM);
      }
      if (this.FWC != null) {
        paramVarArgs.d(2, this.FWC);
      }
      if (this.ELg != null) {
        paramVarArgs.d(3, this.ELg);
      }
      paramVarArgs.aR(4, this.FWD);
      if (this.FDH != null) {
        paramVarArgs.d(5, this.FDH);
      }
      if (this.FWE != null) {
        paramVarArgs.d(6, this.FWE);
      }
      if (this.FWF != null) {
        paramVarArgs.d(7, this.FWF);
      }
      paramVarArgs.aR(8, this.FWG);
      if (this.FWH != null) {
        paramVarArgs.d(9, this.FWH);
      }
      paramVarArgs.aR(10, this.FWI);
      if (this.FWJ != null)
      {
        paramVarArgs.ln(11, this.FWJ.computeSize());
        this.FWJ.writeFields(paramVarArgs);
      }
      if (this.EKy != null) {
        paramVarArgs.d(12, this.EKy);
      }
      paramVarArgs.aR(13, this.DSv);
      if (this.FWK != null)
      {
        paramVarArgs.ln(14, this.FWK.computeSize());
        this.FWK.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(152723);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wTM == null) {
        break label1138;
      }
    }
    label1138:
    for (int i = f.a.a.b.b.a.e(1, this.wTM) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FWC != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FWC);
      }
      i = paramInt;
      if (this.ELg != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ELg);
      }
      i += f.a.a.b.b.a.bx(4, this.FWD);
      paramInt = i;
      if (this.FDH != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FDH);
      }
      i = paramInt;
      if (this.FWE != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.FWE);
      }
      paramInt = i;
      if (this.FWF != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FWF);
      }
      i = paramInt + f.a.a.b.b.a.bx(8, this.FWG);
      paramInt = i;
      if (this.FWH != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.FWH);
      }
      i = paramInt + f.a.a.b.b.a.bx(10, this.FWI);
      paramInt = i;
      if (this.FWJ != null) {
        paramInt = i + f.a.a.a.lm(11, this.FWJ.computeSize());
      }
      i = paramInt;
      if (this.EKy != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.EKy);
      }
      i += f.a.a.b.b.a.bx(13, this.DSv);
      paramInt = i;
      if (this.FWK != null) {
        paramInt = i + f.a.a.a.lm(14, this.FWK.computeSize());
      }
      AppMethodBeat.o(152723);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(152723);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dpi localdpi = (dpi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152723);
          return -1;
        case 1: 
          localdpi.wTM = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152723);
          return 0;
        case 2: 
          localdpi.FWC = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152723);
          return 0;
        case 3: 
          localdpi.ELg = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152723);
          return 0;
        case 4: 
          localdpi.FWD = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152723);
          return 0;
        case 5: 
          localdpi.FDH = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152723);
          return 0;
        case 6: 
          localdpi.FWE = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152723);
          return 0;
        case 7: 
          localdpi.FWF = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152723);
          return 0;
        case 8: 
          localdpi.FWG = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152723);
          return 0;
        case 9: 
          localdpi.FWH = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152723);
          return 0;
        case 10: 
          localdpi.FWI = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152723);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdpi.FWJ = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152723);
          return 0;
        case 12: 
          localdpi.EKy = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152723);
          return 0;
        case 13: 
          localdpi.DSv = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152723);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdpi.FWK = ((SKBuiltinBuffer_t)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpi
 * JD-Core Version:    0.7.0.1
 */