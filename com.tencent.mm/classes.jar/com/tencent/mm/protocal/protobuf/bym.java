package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bym
  extends cvw
{
  public int FJf;
  public ix FSd;
  public String FSe;
  public int FSf;
  public String FSg;
  public String FSh;
  public SKBuiltinBuffer_t FSi;
  public SKBuiltinBuffer_t FSj;
  public String GNv;
  public String GwD;
  public String Hlk;
  public String Hll;
  public String Hlm;
  public int Hln;
  public String gvo;
  public String gvp;
  public int gvw;
  public String jfY;
  public String nIN;
  public String qkM;
  public String qkN;
  public String uQx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133176);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FSd != null)
      {
        paramVarArgs.lJ(2, this.FSd.computeSize());
        this.FSd.writeFields(paramVarArgs);
      }
      if (this.uQx != null) {
        paramVarArgs.d(3, this.uQx);
      }
      if (this.FSe != null) {
        paramVarArgs.d(4, this.FSe);
      }
      paramVarArgs.aS(5, this.FSf);
      if (this.FSg != null) {
        paramVarArgs.d(6, this.FSg);
      }
      if (this.jfY != null) {
        paramVarArgs.d(7, this.jfY);
      }
      if (this.nIN != null) {
        paramVarArgs.d(8, this.nIN);
      }
      if (this.FSh != null) {
        paramVarArgs.d(9, this.FSh);
      }
      if (this.qkN != null) {
        paramVarArgs.d(10, this.qkN);
      }
      if (this.qkM != null) {
        paramVarArgs.d(11, this.qkM);
      }
      paramVarArgs.aS(13, this.FJf);
      paramVarArgs.aS(14, this.gvw);
      if (this.gvp != null) {
        paramVarArgs.d(15, this.gvp);
      }
      if (this.gvo != null) {
        paramVarArgs.d(16, this.gvo);
      }
      if (this.Hlk != null) {
        paramVarArgs.d(17, this.Hlk);
      }
      if (this.GwD != null) {
        paramVarArgs.d(18, this.GwD);
      }
      if (this.GNv != null) {
        paramVarArgs.d(19, this.GNv);
      }
      if (this.Hll != null) {
        paramVarArgs.d(20, this.Hll);
      }
      if (this.Hlm != null) {
        paramVarArgs.d(21, this.Hlm);
      }
      paramVarArgs.aS(22, this.Hln);
      if (this.FSi != null)
      {
        paramVarArgs.lJ(23, this.FSi.computeSize());
        this.FSi.writeFields(paramVarArgs);
      }
      if (this.FSj != null)
      {
        paramVarArgs.lJ(24, this.FSj.computeSize());
        this.FSj.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133176);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1886;
      }
    }
    label1886:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FSd != null) {
        paramInt = i + f.a.a.a.lI(2, this.FSd.computeSize());
      }
      i = paramInt;
      if (this.uQx != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.uQx);
      }
      paramInt = i;
      if (this.FSe != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FSe);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.FSf);
      paramInt = i;
      if (this.FSg != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FSg);
      }
      i = paramInt;
      if (this.jfY != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.jfY);
      }
      paramInt = i;
      if (this.nIN != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.nIN);
      }
      i = paramInt;
      if (this.FSh != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.FSh);
      }
      paramInt = i;
      if (this.qkN != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.qkN);
      }
      i = paramInt;
      if (this.qkM != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.qkM);
      }
      i = i + f.a.a.b.b.a.bz(13, this.FJf) + f.a.a.b.b.a.bz(14, this.gvw);
      paramInt = i;
      if (this.gvp != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.gvp);
      }
      i = paramInt;
      if (this.gvo != null) {
        i = paramInt + f.a.a.b.b.a.e(16, this.gvo);
      }
      paramInt = i;
      if (this.Hlk != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.Hlk);
      }
      i = paramInt;
      if (this.GwD != null) {
        i = paramInt + f.a.a.b.b.a.e(18, this.GwD);
      }
      paramInt = i;
      if (this.GNv != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.GNv);
      }
      i = paramInt;
      if (this.Hll != null) {
        i = paramInt + f.a.a.b.b.a.e(20, this.Hll);
      }
      paramInt = i;
      if (this.Hlm != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.Hlm);
      }
      i = paramInt + f.a.a.b.b.a.bz(22, this.Hln);
      paramInt = i;
      if (this.FSi != null) {
        paramInt = i + f.a.a.a.lI(23, this.FSi.computeSize());
      }
      i = paramInt;
      if (this.FSj != null) {
        i = paramInt + f.a.a.a.lI(24, this.FSj.computeSize());
      }
      AppMethodBeat.o(133176);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(133176);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bym localbym = (bym)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 12: 
        default: 
          AppMethodBeat.o(133176);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbym.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133176);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ix();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ix)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbym.FSd = ((ix)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133176);
          return 0;
        case 3: 
          localbym.uQx = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 4: 
          localbym.FSe = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 5: 
          localbym.FSf = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(133176);
          return 0;
        case 6: 
          localbym.FSg = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 7: 
          localbym.jfY = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 8: 
          localbym.nIN = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 9: 
          localbym.FSh = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 10: 
          localbym.qkN = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 11: 
          localbym.qkM = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 13: 
          localbym.FJf = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(133176);
          return 0;
        case 14: 
          localbym.gvw = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(133176);
          return 0;
        case 15: 
          localbym.gvp = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 16: 
          localbym.gvo = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 17: 
          localbym.Hlk = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 18: 
          localbym.GwD = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 19: 
          localbym.GNv = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 20: 
          localbym.Hll = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 21: 
          localbym.Hlm = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 22: 
          localbym.Hln = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(133176);
          return 0;
        case 23: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbym.FSi = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133176);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbym.FSj = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133176);
        return 0;
      }
      AppMethodBeat.o(133176);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bym
 * JD-Core Version:    0.7.0.1
 */