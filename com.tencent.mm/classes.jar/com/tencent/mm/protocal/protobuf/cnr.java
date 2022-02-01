package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cnr
  extends com.tencent.mm.bx.a
{
  public String FVo;
  public String FVp;
  public dhg GOa;
  public acf GOb;
  public String Guj;
  public int HgO;
  public String HgP;
  public int HgQ;
  public String HgR;
  public int jdc;
  public String jdd;
  public String jde;
  public String jdf;
  public int jdg;
  public String jdh;
  public int jdi;
  public int jdj;
  public String jdk;
  public String jdl;
  public String jdm;
  public String nDo;
  public String nEt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155448);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HgO);
      if (this.nDo != null) {
        paramVarArgs.d(2, this.nDo);
      }
      if (this.nEt != null) {
        paramVarArgs.d(3, this.nEt);
      }
      if (this.HgP != null) {
        paramVarArgs.d(4, this.HgP);
      }
      paramVarArgs.aS(5, this.HgQ);
      if (this.HgR != null) {
        paramVarArgs.d(6, this.HgR);
      }
      paramVarArgs.aS(7, this.jdc);
      if (this.jdd != null) {
        paramVarArgs.d(8, this.jdd);
      }
      if (this.jde != null) {
        paramVarArgs.d(9, this.jde);
      }
      if (this.jdf != null) {
        paramVarArgs.d(10, this.jdf);
      }
      paramVarArgs.aS(11, this.jdg);
      if (this.jdh != null) {
        paramVarArgs.d(12, this.jdh);
      }
      paramVarArgs.aS(13, this.jdi);
      paramVarArgs.aS(14, this.jdj);
      if (this.jdk != null) {
        paramVarArgs.d(15, this.jdk);
      }
      if (this.GOa != null)
      {
        paramVarArgs.lC(16, this.GOa.computeSize());
        this.GOa.writeFields(paramVarArgs);
      }
      if (this.jdl != null) {
        paramVarArgs.d(17, this.jdl);
      }
      if (this.jdm != null) {
        paramVarArgs.d(18, this.jdm);
      }
      if (this.GOb != null)
      {
        paramVarArgs.lC(19, this.GOb.computeSize());
        this.GOb.writeFields(paramVarArgs);
      }
      if (this.FVo != null) {
        paramVarArgs.d(20, this.FVo);
      }
      if (this.FVp != null) {
        paramVarArgs.d(21, this.FVp);
      }
      if (this.Guj != null) {
        paramVarArgs.d(22, this.Guj);
      }
      AppMethodBeat.o(155448);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.HgO) + 0;
      paramInt = i;
      if (this.nDo != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nDo);
      }
      i = paramInt;
      if (this.nEt != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.nEt);
      }
      paramInt = i;
      if (this.HgP != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HgP);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.HgQ);
      paramInt = i;
      if (this.HgR != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.HgR);
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.jdc);
      paramInt = i;
      if (this.jdd != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.jdd);
      }
      i = paramInt;
      if (this.jde != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.jde);
      }
      paramInt = i;
      if (this.jdf != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.jdf);
      }
      i = paramInt + f.a.a.b.b.a.bz(11, this.jdg);
      paramInt = i;
      if (this.jdh != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.jdh);
      }
      i = paramInt + f.a.a.b.b.a.bz(13, this.jdi) + f.a.a.b.b.a.bz(14, this.jdj);
      paramInt = i;
      if (this.jdk != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.jdk);
      }
      i = paramInt;
      if (this.GOa != null) {
        i = paramInt + f.a.a.a.lB(16, this.GOa.computeSize());
      }
      paramInt = i;
      if (this.jdl != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.jdl);
      }
      i = paramInt;
      if (this.jdm != null) {
        i = paramInt + f.a.a.b.b.a.e(18, this.jdm);
      }
      paramInt = i;
      if (this.GOb != null) {
        paramInt = i + f.a.a.a.lB(19, this.GOb.computeSize());
      }
      i = paramInt;
      if (this.FVo != null) {
        i = paramInt + f.a.a.b.b.a.e(20, this.FVo);
      }
      paramInt = i;
      if (this.FVp != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.FVp);
      }
      i = paramInt;
      if (this.Guj != null) {
        i = paramInt + f.a.a.b.b.a.e(22, this.Guj);
      }
      AppMethodBeat.o(155448);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(155448);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cnr localcnr = (cnr)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(155448);
        return -1;
      case 1: 
        localcnr.HgO = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(155448);
        return 0;
      case 2: 
        localcnr.nDo = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 3: 
        localcnr.nEt = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 4: 
        localcnr.HgP = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 5: 
        localcnr.HgQ = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(155448);
        return 0;
      case 6: 
        localcnr.HgR = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 7: 
        localcnr.jdc = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(155448);
        return 0;
      case 8: 
        localcnr.jdd = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 9: 
        localcnr.jde = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 10: 
        localcnr.jdf = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 11: 
        localcnr.jdg = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(155448);
        return 0;
      case 12: 
        localcnr.jdh = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 13: 
        localcnr.jdi = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(155448);
        return 0;
      case 14: 
        localcnr.jdj = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(155448);
        return 0;
      case 15: 
        localcnr.jdk = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 16: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dhg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dhg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcnr.GOa = ((dhg)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(155448);
        return 0;
      case 17: 
        localcnr.jdl = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 18: 
        localcnr.jdm = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 19: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new acf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((acf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcnr.GOb = ((acf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(155448);
        return 0;
      case 20: 
        localcnr.FVo = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 21: 
        localcnr.FVp = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(155448);
        return 0;
      }
      localcnr.Guj = ((f.a.a.a.a)localObject1).NPN.readString();
      AppMethodBeat.o(155448);
      return 0;
    }
    AppMethodBeat.o(155448);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnr
 * JD-Core Version:    0.7.0.1
 */