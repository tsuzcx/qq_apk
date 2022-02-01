package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dbq
  extends cpx
{
  public String DPS;
  public SKBuiltinBuffer_t DVs;
  public int EqS;
  public int ExtFlag;
  public int FKW;
  public int FKX;
  public int FKY;
  public int FjE;
  public int FjF;
  public dkl Fus;
  public String MD5;
  public String hOf;
  public String hkN;
  public int ndI;
  public int vTH;
  public int vTI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125830);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DVs == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buffer");
        AppMethodBeat.o(125830);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.ndI);
      paramVarArgs.aR(3, this.vTI);
      paramVarArgs.aR(17, this.FKW);
      paramVarArgs.aR(4, this.vTH);
      if (this.DVs != null)
      {
        paramVarArgs.ln(5, this.DVs.computeSize());
        this.DVs.writeFields(paramVarArgs);
      }
      if (this.hkN != null) {
        paramVarArgs.d(6, this.hkN);
      }
      paramVarArgs.aR(7, this.FjE);
      paramVarArgs.aR(8, this.FjF);
      if (this.DPS != null) {
        paramVarArgs.d(9, this.DPS);
      }
      paramVarArgs.aR(10, this.FKX);
      paramVarArgs.aR(11, this.EqS);
      if (this.Fus != null)
      {
        paramVarArgs.ln(12, this.Fus.computeSize());
        this.Fus.writeFields(paramVarArgs);
      }
      if (this.hOf != null) {
        paramVarArgs.d(13, this.hOf);
      }
      paramVarArgs.aR(14, this.ExtFlag);
      if (this.MD5 != null) {
        paramVarArgs.d(15, this.MD5);
      }
      paramVarArgs.aR(16, this.FKY);
      AppMethodBeat.o(125830);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1362;
      }
    }
    label1362:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.ndI) + f.a.a.b.b.a.bx(3, this.vTI) + f.a.a.b.b.a.bx(17, this.FKW) + f.a.a.b.b.a.bx(4, this.vTH);
      paramInt = i;
      if (this.DVs != null) {
        paramInt = i + f.a.a.a.lm(5, this.DVs.computeSize());
      }
      i = paramInt;
      if (this.hkN != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.hkN);
      }
      i = i + f.a.a.b.b.a.bx(7, this.FjE) + f.a.a.b.b.a.bx(8, this.FjF);
      paramInt = i;
      if (this.DPS != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.DPS);
      }
      i = paramInt + f.a.a.b.b.a.bx(10, this.FKX) + f.a.a.b.b.a.bx(11, this.EqS);
      paramInt = i;
      if (this.Fus != null) {
        paramInt = i + f.a.a.a.lm(12, this.Fus.computeSize());
      }
      i = paramInt;
      if (this.hOf != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.hOf);
      }
      i += f.a.a.b.b.a.bx(14, this.ExtFlag);
      paramInt = i;
      if (this.MD5 != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.MD5);
      }
      i = f.a.a.b.b.a.bx(16, this.FKY);
      AppMethodBeat.o(125830);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.DVs == null)
        {
          paramVarArgs = new b("Not all required fields were included: Buffer");
          AppMethodBeat.o(125830);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125830);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dbq localdbq = (dbq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125830);
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
            localdbq.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125830);
          return 0;
        case 2: 
          localdbq.ndI = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125830);
          return 0;
        case 3: 
          localdbq.vTI = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125830);
          return 0;
        case 17: 
          localdbq.FKW = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125830);
          return 0;
        case 4: 
          localdbq.vTH = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125830);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdbq.DVs = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125830);
          return 0;
        case 6: 
          localdbq.hkN = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125830);
          return 0;
        case 7: 
          localdbq.FjE = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125830);
          return 0;
        case 8: 
          localdbq.FjF = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125830);
          return 0;
        case 9: 
          localdbq.DPS = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125830);
          return 0;
        case 10: 
          localdbq.FKX = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125830);
          return 0;
        case 11: 
          localdbq.EqS = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125830);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dkl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dkl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdbq.Fus = ((dkl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125830);
          return 0;
        case 13: 
          localdbq.hOf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125830);
          return 0;
        case 14: 
          localdbq.ExtFlag = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125830);
          return 0;
        case 15: 
          localdbq.MD5 = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125830);
          return 0;
        }
        localdbq.FKY = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(125830);
        return 0;
      }
      AppMethodBeat.o(125830);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbq
 * JD-Core Version:    0.7.0.1
 */