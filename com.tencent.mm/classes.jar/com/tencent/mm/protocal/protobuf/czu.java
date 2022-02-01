package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class czu
  extends com.tencent.mm.bw.a
{
  public int CreateTime;
  public cob DQr;
  public String Exe;
  public String FIW;
  public String FIX;
  public int FIY;
  public int FIZ;
  public long FJa;
  public long FJb;
  public SKBuiltinBuffer_t FJc;
  public int FJd;
  public LinkedList<dag> FJe;
  public int FJf;
  public String Fwn;
  public int IsNotRichText;
  public String hkR;
  public int ndI;
  public int sVo;
  
  public czu()
  {
    AppMethodBeat.i(125770);
    this.FJe = new LinkedList();
    AppMethodBeat.o(125770);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125771);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Fwn != null) {
        paramVarArgs.d(1, this.Fwn);
      }
      if (this.Exe != null) {
        paramVarArgs.d(2, this.Exe);
      }
      if (this.FIW != null) {
        paramVarArgs.d(3, this.FIW);
      }
      if (this.FIX != null) {
        paramVarArgs.d(4, this.FIX);
      }
      paramVarArgs.aR(5, this.ndI);
      paramVarArgs.aR(6, this.sVo);
      paramVarArgs.aR(7, this.CreateTime);
      if (this.hkR != null) {
        paramVarArgs.d(8, this.hkR);
      }
      paramVarArgs.aR(9, this.FIY);
      paramVarArgs.aR(10, this.FIZ);
      paramVarArgs.aR(11, this.IsNotRichText);
      paramVarArgs.aO(12, this.FJa);
      paramVarArgs.aO(13, this.FJb);
      if (this.FJc != null)
      {
        paramVarArgs.ln(14, this.FJc.computeSize());
        this.FJc.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(15, this.FJd);
      if (this.DQr != null)
      {
        paramVarArgs.ln(16, this.DQr.computeSize());
        this.DQr.writeFields(paramVarArgs);
      }
      paramVarArgs.e(17, 8, this.FJe);
      paramVarArgs.aR(18, this.FJf);
      AppMethodBeat.o(125771);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Fwn == null) {
        break label1362;
      }
    }
    label1362:
    for (int i = f.a.a.b.b.a.e(1, this.Fwn) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Exe != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Exe);
      }
      i = paramInt;
      if (this.FIW != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FIW);
      }
      paramInt = i;
      if (this.FIX != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FIX);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.ndI) + f.a.a.b.b.a.bx(6, this.sVo) + f.a.a.b.b.a.bx(7, this.CreateTime);
      paramInt = i;
      if (this.hkR != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.hkR);
      }
      i = paramInt + f.a.a.b.b.a.bx(9, this.FIY) + f.a.a.b.b.a.bx(10, this.FIZ) + f.a.a.b.b.a.bx(11, this.IsNotRichText) + f.a.a.b.b.a.p(12, this.FJa) + f.a.a.b.b.a.p(13, this.FJb);
      paramInt = i;
      if (this.FJc != null) {
        paramInt = i + f.a.a.a.lm(14, this.FJc.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(15, this.FJd);
      paramInt = i;
      if (this.DQr != null) {
        paramInt = i + f.a.a.a.lm(16, this.DQr.computeSize());
      }
      i = f.a.a.a.c(17, 8, this.FJe);
      int j = f.a.a.b.b.a.bx(18, this.FJf);
      AppMethodBeat.o(125771);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FJe.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(125771);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        czu localczu = (czu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125771);
          return -1;
        case 1: 
          localczu.Fwn = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125771);
          return 0;
        case 2: 
          localczu.Exe = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125771);
          return 0;
        case 3: 
          localczu.FIW = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125771);
          return 0;
        case 4: 
          localczu.FIX = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125771);
          return 0;
        case 5: 
          localczu.ndI = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125771);
          return 0;
        case 6: 
          localczu.sVo = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125771);
          return 0;
        case 7: 
          localczu.CreateTime = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125771);
          return 0;
        case 8: 
          localczu.hkR = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125771);
          return 0;
        case 9: 
          localczu.FIY = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125771);
          return 0;
        case 10: 
          localczu.FIZ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125771);
          return 0;
        case 11: 
          localczu.IsNotRichText = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125771);
          return 0;
        case 12: 
          localczu.FJa = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(125771);
          return 0;
        case 13: 
          localczu.FJb = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(125771);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localczu.FJc = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125771);
          return 0;
        case 15: 
          localczu.FJd = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125771);
          return 0;
        case 16: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cob();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cob)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localczu.DQr = ((cob)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125771);
          return 0;
        case 17: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dag();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dag)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localczu.FJe.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125771);
          return 0;
        }
        localczu.FJf = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(125771);
        return 0;
      }
      AppMethodBeat.o(125771);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czu
 * JD-Core Version:    0.7.0.1
 */