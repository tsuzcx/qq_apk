package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class btk
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
  public int jdc;
  public String jdd;
  public String jde;
  public String jdf;
  public String jdh;
  public String jdl;
  public String jdm;
  public String nDo;
  public String nEt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89925);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
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
      paramVarArgs.aS(9, this.GNU);
      if (this.GNV != null) {
        paramVarArgs.d(10, this.GNV);
      }
      if (this.GDx != null) {
        paramVarArgs.d(11, this.GDx);
      }
      if (this.jdh != null) {
        paramVarArgs.d(12, this.jdh);
      }
      if (this.GNW != null) {
        paramVarArgs.d(13, this.GNW);
      }
      if (this.GNX != null) {
        paramVarArgs.d(14, this.GNX);
      }
      paramVarArgs.aS(15, this.GNY);
      paramVarArgs.aS(19, this.GNZ);
      if (this.GOa != null)
      {
        paramVarArgs.lC(20, this.GOa.computeSize());
        this.GOa.writeFields(paramVarArgs);
      }
      if (this.jdl != null) {
        paramVarArgs.d(21, this.jdl);
      }
      if (this.FVo != null) {
        paramVarArgs.d(22, this.FVo);
      }
      if (this.FVp != null) {
        paramVarArgs.d(23, this.FVp);
      }
      if (this.jdm != null) {
        paramVarArgs.d(24, this.jdm);
      }
      if (this.GOb != null)
      {
        paramVarArgs.lC(25, this.GOb.computeSize());
        this.GOb.writeFields(paramVarArgs);
      }
      if (this.Guj != null) {
        paramVarArgs.d(26, this.Guj);
      }
      AppMethodBeat.o(89925);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nDo == null) {
        break label1686;
      }
    }
    label1686:
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
      i = paramInt + f.a.a.b.b.a.bz(7, this.jdc) + f.a.a.b.b.a.bz(8, this.Fvl) + f.a.a.b.b.a.bz(9, this.GNU);
      paramInt = i;
      if (this.GNV != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.GNV);
      }
      i = paramInt;
      if (this.GDx != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.GDx);
      }
      paramInt = i;
      if (this.jdh != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.jdh);
      }
      i = paramInt;
      if (this.GNW != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.GNW);
      }
      paramInt = i;
      if (this.GNX != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.GNX);
      }
      i = paramInt + f.a.a.b.b.a.bz(15, this.GNY) + f.a.a.b.b.a.bz(19, this.GNZ);
      paramInt = i;
      if (this.GOa != null) {
        paramInt = i + f.a.a.a.lB(20, this.GOa.computeSize());
      }
      i = paramInt;
      if (this.jdl != null) {
        i = paramInt + f.a.a.b.b.a.e(21, this.jdl);
      }
      paramInt = i;
      if (this.FVo != null) {
        paramInt = i + f.a.a.b.b.a.e(22, this.FVo);
      }
      i = paramInt;
      if (this.FVp != null) {
        i = paramInt + f.a.a.b.b.a.e(23, this.FVp);
      }
      paramInt = i;
      if (this.jdm != null) {
        paramInt = i + f.a.a.b.b.a.e(24, this.jdm);
      }
      i = paramInt;
      if (this.GOb != null) {
        i = paramInt + f.a.a.a.lB(25, this.GOb.computeSize());
      }
      paramInt = i;
      if (this.Guj != null) {
        paramInt = i + f.a.a.b.b.a.e(26, this.Guj);
      }
      AppMethodBeat.o(89925);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(89925);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        btk localbtk = (btk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 16: 
        case 17: 
        case 18: 
        default: 
          AppMethodBeat.o(89925);
          return -1;
        case 1: 
          localbtk.nDo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 2: 
          localbtk.nEt = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 3: 
          localbtk.jdd = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 4: 
          localbtk.jde = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 5: 
          localbtk.jdf = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 6: 
          localbtk.GNT = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 7: 
          localbtk.jdc = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(89925);
          return 0;
        case 8: 
          localbtk.Fvl = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(89925);
          return 0;
        case 9: 
          localbtk.GNU = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(89925);
          return 0;
        case 10: 
          localbtk.GNV = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 11: 
          localbtk.GDx = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 12: 
          localbtk.jdh = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 13: 
          localbtk.GNW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 14: 
          localbtk.GNX = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 15: 
          localbtk.GNY = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(89925);
          return 0;
        case 19: 
          localbtk.GNZ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(89925);
          return 0;
        case 20: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dhg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dhg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbtk.GOa = ((dhg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89925);
          return 0;
        case 21: 
          localbtk.jdl = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 22: 
          localbtk.FVo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 23: 
          localbtk.FVp = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 24: 
          localbtk.jdm = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 25: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new acf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((acf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbtk.GOb = ((acf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89925);
          return 0;
        }
        localbtk.Guj = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(89925);
        return 0;
      }
      AppMethodBeat.o(89925);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.btk
 * JD-Core Version:    0.7.0.1
 */