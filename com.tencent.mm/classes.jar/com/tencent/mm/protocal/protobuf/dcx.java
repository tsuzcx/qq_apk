package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dcx
  extends com.tencent.mm.bx.a
{
  public String FVo;
  public String FVp;
  public int Fvl;
  public String GDx;
  public String GNT;
  public int GNU;
  public String GNV;
  public String GNW;
  public String GNX;
  public int GNY;
  public int GNZ;
  public dhg GOa;
  public acf GOb;
  public String Guj;
  public int HrE;
  public SKBuiltinBuffer_t HrF;
  public int HrG;
  public int jdc;
  public String jdd;
  public String jde;
  public String jdf;
  public String jdl;
  public String jdm;
  public String nDo;
  public String nEt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32440);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HrF == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuffer");
        AppMethodBeat.o(32440);
        throw paramVarArgs;
      }
      if (this.nDo != null) {
        paramVarArgs.d(1, this.nDo);
      }
      if (this.nEt != null) {
        paramVarArgs.d(2, this.nEt);
      }
      if (this.jdd != null) {
        paramVarArgs.d(3, this.jdd);
      }
      if (this.jde != null) {
        paramVarArgs.d(4, this.jde);
      }
      if (this.jdf != null) {
        paramVarArgs.d(5, this.jdf);
      }
      if (this.GNT != null) {
        paramVarArgs.d(6, this.GNT);
      }
      paramVarArgs.aS(7, this.jdc);
      paramVarArgs.aS(8, this.Fvl);
      paramVarArgs.aS(9, this.HrE);
      if (this.HrF != null)
      {
        paramVarArgs.lC(10, this.HrF.computeSize());
        this.HrF.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(11, this.HrG);
      if (this.GNW != null) {
        paramVarArgs.d(12, this.GNW);
      }
      if (this.GNX != null) {
        paramVarArgs.d(13, this.GNX);
      }
      paramVarArgs.aS(14, this.GNY);
      paramVarArgs.aS(15, this.GNU);
      if (this.GNV != null) {
        paramVarArgs.d(16, this.GNV);
      }
      if (this.GDx != null) {
        paramVarArgs.d(17, this.GDx);
      }
      paramVarArgs.aS(21, this.GNZ);
      if (this.GOa != null)
      {
        paramVarArgs.lC(22, this.GOa.computeSize());
        this.GOa.writeFields(paramVarArgs);
      }
      if (this.jdl != null) {
        paramVarArgs.d(23, this.jdl);
      }
      if (this.FVo != null) {
        paramVarArgs.d(24, this.FVo);
      }
      if (this.FVp != null) {
        paramVarArgs.d(25, this.FVp);
      }
      if (this.jdm != null) {
        paramVarArgs.d(26, this.jdm);
      }
      if (this.GOb != null)
      {
        paramVarArgs.lC(27, this.GOb.computeSize());
        this.GOb.writeFields(paramVarArgs);
      }
      if (this.Guj != null) {
        paramVarArgs.d(28, this.Guj);
      }
      AppMethodBeat.o(32440);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nDo == null) {
        break label1953;
      }
    }
    label1953:
    for (int i = f.a.a.b.b.a.e(1, this.nDo) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nEt != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nEt);
      }
      i = paramInt;
      if (this.jdd != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.jdd);
      }
      paramInt = i;
      if (this.jde != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.jde);
      }
      i = paramInt;
      if (this.jdf != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.jdf);
      }
      paramInt = i;
      if (this.GNT != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GNT);
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.jdc) + f.a.a.b.b.a.bz(8, this.Fvl) + f.a.a.b.b.a.bz(9, this.HrE);
      paramInt = i;
      if (this.HrF != null) {
        paramInt = i + f.a.a.a.lB(10, this.HrF.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(11, this.HrG);
      paramInt = i;
      if (this.GNW != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.GNW);
      }
      i = paramInt;
      if (this.GNX != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.GNX);
      }
      i = i + f.a.a.b.b.a.bz(14, this.GNY) + f.a.a.b.b.a.bz(15, this.GNU);
      paramInt = i;
      if (this.GNV != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.GNV);
      }
      i = paramInt;
      if (this.GDx != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.GDx);
      }
      i += f.a.a.b.b.a.bz(21, this.GNZ);
      paramInt = i;
      if (this.GOa != null) {
        paramInt = i + f.a.a.a.lB(22, this.GOa.computeSize());
      }
      i = paramInt;
      if (this.jdl != null) {
        i = paramInt + f.a.a.b.b.a.e(23, this.jdl);
      }
      paramInt = i;
      if (this.FVo != null) {
        paramInt = i + f.a.a.b.b.a.e(24, this.FVo);
      }
      i = paramInt;
      if (this.FVp != null) {
        i = paramInt + f.a.a.b.b.a.e(25, this.FVp);
      }
      paramInt = i;
      if (this.jdm != null) {
        paramInt = i + f.a.a.b.b.a.e(26, this.jdm);
      }
      i = paramInt;
      if (this.GOb != null) {
        i = paramInt + f.a.a.a.lB(27, this.GOb.computeSize());
      }
      paramInt = i;
      if (this.Guj != null) {
        paramInt = i + f.a.a.b.b.a.e(28, this.Guj);
      }
      AppMethodBeat.o(32440);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.HrF == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgBuffer");
          AppMethodBeat.o(32440);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32440);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dcx localdcx = (dcx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 18: 
        case 19: 
        case 20: 
        default: 
          AppMethodBeat.o(32440);
          return -1;
        case 1: 
          localdcx.nDo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 2: 
          localdcx.nEt = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 3: 
          localdcx.jdd = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 4: 
          localdcx.jde = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 5: 
          localdcx.jdf = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 6: 
          localdcx.GNT = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 7: 
          localdcx.jdc = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32440);
          return 0;
        case 8: 
          localdcx.Fvl = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32440);
          return 0;
        case 9: 
          localdcx.HrE = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32440);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdcx.HrF = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32440);
          return 0;
        case 11: 
          localdcx.HrG = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32440);
          return 0;
        case 12: 
          localdcx.GNW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 13: 
          localdcx.GNX = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 14: 
          localdcx.GNY = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32440);
          return 0;
        case 15: 
          localdcx.GNU = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32440);
          return 0;
        case 16: 
          localdcx.GNV = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 17: 
          localdcx.GDx = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 21: 
          localdcx.GNZ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32440);
          return 0;
        case 22: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dhg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dhg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdcx.GOa = ((dhg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32440);
          return 0;
        case 23: 
          localdcx.jdl = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 24: 
          localdcx.FVo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 25: 
          localdcx.FVp = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 26: 
          localdcx.jdm = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 27: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new acf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((acf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdcx.GOb = ((acf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32440);
          return 0;
        }
        localdcx.Guj = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(32440);
        return 0;
      }
      AppMethodBeat.o(32440);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dcx
 * JD-Core Version:    0.7.0.1
 */