package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class zd
  extends com.tencent.mm.bw.a
{
  public SKBuiltinBuffer_t DPX;
  public String Eti;
  public String Etj;
  public int Etk;
  public int Etl;
  public String Etm;
  public int Etn;
  public String Eto;
  public String Etp;
  public int Etq;
  public int Etr;
  public LinkedList<cqy> Ets;
  public String Ett;
  public int Etu;
  public int Etv;
  public int Etw;
  public int Etx;
  public int iJT;
  public String iJY;
  public String ncR;
  public String ndW;
  public String tlX;
  
  public zd()
  {
    AppMethodBeat.i(32174);
    this.Ets = new LinkedList();
    AppMethodBeat.o(32174);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32175);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DPX == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(32175);
        throw paramVarArgs;
      }
      if (this.ncR != null) {
        paramVarArgs.d(1, this.ncR);
      }
      if (this.ndW != null) {
        paramVarArgs.d(2, this.ndW);
      }
      if (this.Eti != null) {
        paramVarArgs.d(3, this.Eti);
      }
      if (this.Etj != null) {
        paramVarArgs.d(4, this.Etj);
      }
      paramVarArgs.aR(5, this.iJT);
      if (this.DPX != null)
      {
        paramVarArgs.ln(6, this.DPX.computeSize());
        this.DPX.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(7, this.Etk);
      paramVarArgs.aR(8, this.Etl);
      if (this.Etm != null) {
        paramVarArgs.d(9, this.Etm);
      }
      paramVarArgs.aR(10, this.Etn);
      if (this.Eto != null) {
        paramVarArgs.d(11, this.Eto);
      }
      if (this.Etp != null) {
        paramVarArgs.d(12, this.Etp);
      }
      paramVarArgs.aR(13, this.Etq);
      paramVarArgs.aR(14, this.Etr);
      paramVarArgs.e(15, 8, this.Ets);
      if (this.Ett != null) {
        paramVarArgs.d(16, this.Ett);
      }
      paramVarArgs.aR(17, this.Etu);
      paramVarArgs.aR(18, this.Etv);
      if (this.tlX != null) {
        paramVarArgs.d(19, this.tlX);
      }
      paramVarArgs.aR(20, this.Etw);
      paramVarArgs.aR(21, this.Etx);
      if (this.iJY != null) {
        paramVarArgs.d(22, this.iJY);
      }
      AppMethodBeat.o(32175);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ncR == null) {
        break label1594;
      }
    }
    label1594:
    for (int i = f.a.a.b.b.a.e(1, this.ncR) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ndW != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ndW);
      }
      i = paramInt;
      if (this.Eti != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Eti);
      }
      paramInt = i;
      if (this.Etj != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Etj);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.iJT);
      paramInt = i;
      if (this.DPX != null) {
        paramInt = i + f.a.a.a.lm(6, this.DPX.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(7, this.Etk) + f.a.a.b.b.a.bx(8, this.Etl);
      paramInt = i;
      if (this.Etm != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Etm);
      }
      i = paramInt + f.a.a.b.b.a.bx(10, this.Etn);
      paramInt = i;
      if (this.Eto != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.Eto);
      }
      i = paramInt;
      if (this.Etp != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.Etp);
      }
      i = i + f.a.a.b.b.a.bx(13, this.Etq) + f.a.a.b.b.a.bx(14, this.Etr) + f.a.a.a.c(15, 8, this.Ets);
      paramInt = i;
      if (this.Ett != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.Ett);
      }
      i = paramInt + f.a.a.b.b.a.bx(17, this.Etu) + f.a.a.b.b.a.bx(18, this.Etv);
      paramInt = i;
      if (this.tlX != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.tlX);
      }
      i = paramInt + f.a.a.b.b.a.bx(20, this.Etw) + f.a.a.b.b.a.bx(21, this.Etx);
      paramInt = i;
      if (this.iJY != null) {
        paramInt = i + f.a.a.b.b.a.e(22, this.iJY);
      }
      AppMethodBeat.o(32175);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Ets.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.DPX == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgBuf");
          AppMethodBeat.o(32175);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32175);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        zd localzd = (zd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32175);
          return -1;
        case 1: 
          localzd.ncR = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32175);
          return 0;
        case 2: 
          localzd.ndW = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32175);
          return 0;
        case 3: 
          localzd.Eti = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32175);
          return 0;
        case 4: 
          localzd.Etj = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32175);
          return 0;
        case 5: 
          localzd.iJT = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32175);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localzd.DPX = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32175);
          return 0;
        case 7: 
          localzd.Etk = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32175);
          return 0;
        case 8: 
          localzd.Etl = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32175);
          return 0;
        case 9: 
          localzd.Etm = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32175);
          return 0;
        case 10: 
          localzd.Etn = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32175);
          return 0;
        case 11: 
          localzd.Eto = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32175);
          return 0;
        case 12: 
          localzd.Etp = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32175);
          return 0;
        case 13: 
          localzd.Etq = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32175);
          return 0;
        case 14: 
          localzd.Etr = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32175);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cqy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cqy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localzd.Ets.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32175);
          return 0;
        case 16: 
          localzd.Ett = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32175);
          return 0;
        case 17: 
          localzd.Etu = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32175);
          return 0;
        case 18: 
          localzd.Etv = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32175);
          return 0;
        case 19: 
          localzd.tlX = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32175);
          return 0;
        case 20: 
          localzd.Etw = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32175);
          return 0;
        case 21: 
          localzd.Etx = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32175);
          return 0;
        }
        localzd.iJY = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(32175);
        return 0;
      }
      AppMethodBeat.o(32175);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zd
 * JD-Core Version:    0.7.0.1
 */