package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eej
  extends com.tencent.mm.bx.a
{
  public String FMt;
  public int FMu;
  public int GDa;
  public btn GRt;
  public String Gsr;
  public int HAv;
  public LinkedList<aag> HOp;
  public int HPA;
  public String HPB;
  public String HPC;
  public LinkedList<String> HPD;
  public int HPE;
  public asy HPF;
  public String HbS;
  public String HjQ;
  public int HmO;
  public int Hmr;
  public int Hmv;
  public int Scene;
  public int nEf;
  
  public eej()
  {
    AppMethodBeat.i(117947);
    this.HPA = 2;
    this.HOp = new LinkedList();
    this.HPD = new LinkedList();
    AppMethodBeat.o(117947);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117948);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FMu);
      paramVarArgs.aS(2, this.GDa);
      paramVarArgs.aS(3, this.Hmr);
      if (this.Gsr != null) {
        paramVarArgs.d(4, this.Gsr);
      }
      if (this.GRt != null)
      {
        paramVarArgs.lC(5, this.GRt.computeSize());
        this.GRt.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(6, this.Scene);
      if (this.FMt != null) {
        paramVarArgs.d(7, this.FMt);
      }
      paramVarArgs.aS(8, this.Hmv);
      paramVarArgs.aS(9, this.HPA);
      paramVarArgs.e(10, 8, this.HOp);
      if (this.HPB != null) {
        paramVarArgs.d(11, this.HPB);
      }
      if (this.HbS != null) {
        paramVarArgs.d(12, this.HbS);
      }
      paramVarArgs.aS(13, this.HAv);
      if (this.HPC != null) {
        paramVarArgs.d(14, this.HPC);
      }
      if (this.HjQ != null) {
        paramVarArgs.d(15, this.HjQ);
      }
      paramVarArgs.e(16, 1, this.HPD);
      paramVarArgs.aS(17, this.HmO);
      paramVarArgs.aS(18, this.nEf);
      paramVarArgs.aS(19, this.HPE);
      if (this.HPF != null)
      {
        paramVarArgs.lC(20, this.HPF.computeSize());
        this.HPF.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(117948);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.FMu) + 0 + f.a.a.b.b.a.bz(2, this.GDa) + f.a.a.b.b.a.bz(3, this.Hmr);
      paramInt = i;
      if (this.Gsr != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Gsr);
      }
      i = paramInt;
      if (this.GRt != null) {
        i = paramInt + f.a.a.a.lB(5, this.GRt.computeSize());
      }
      i += f.a.a.b.b.a.bz(6, this.Scene);
      paramInt = i;
      if (this.FMt != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FMt);
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.Hmv) + f.a.a.b.b.a.bz(9, this.HPA) + f.a.a.a.c(10, 8, this.HOp);
      paramInt = i;
      if (this.HPB != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.HPB);
      }
      i = paramInt;
      if (this.HbS != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.HbS);
      }
      i += f.a.a.b.b.a.bz(13, this.HAv);
      paramInt = i;
      if (this.HPC != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.HPC);
      }
      i = paramInt;
      if (this.HjQ != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.HjQ);
      }
      i = i + f.a.a.a.c(16, 1, this.HPD) + f.a.a.b.b.a.bz(17, this.HmO) + f.a.a.b.b.a.bz(18, this.nEf) + f.a.a.b.b.a.bz(19, this.HPE);
      paramInt = i;
      if (this.HPF != null) {
        paramInt = i + f.a.a.a.lB(20, this.HPF.computeSize());
      }
      AppMethodBeat.o(117948);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.HOp.clear();
      this.HPD.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(117948);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      eej localeej = (eej)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117948);
        return -1;
      case 1: 
        localeej.FMu = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(117948);
        return 0;
      case 2: 
        localeej.GDa = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(117948);
        return 0;
      case 3: 
        localeej.Hmr = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(117948);
        return 0;
      case 4: 
        localeej.Gsr = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(117948);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new btn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((btn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localeej.GRt = ((btn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117948);
        return 0;
      case 6: 
        localeej.Scene = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(117948);
        return 0;
      case 7: 
        localeej.FMt = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(117948);
        return 0;
      case 8: 
        localeej.Hmv = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(117948);
        return 0;
      case 9: 
        localeej.HPA = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(117948);
        return 0;
      case 10: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aag();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aag)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localeej.HOp.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117948);
        return 0;
      case 11: 
        localeej.HPB = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(117948);
        return 0;
      case 12: 
        localeej.HbS = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(117948);
        return 0;
      case 13: 
        localeej.HAv = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(117948);
        return 0;
      case 14: 
        localeej.HPC = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(117948);
        return 0;
      case 15: 
        localeej.HjQ = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(117948);
        return 0;
      case 16: 
        localeej.HPD.add(((f.a.a.a.a)localObject1).NPN.readString());
        AppMethodBeat.o(117948);
        return 0;
      case 17: 
        localeej.HmO = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(117948);
        return 0;
      case 18: 
        localeej.nEf = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(117948);
        return 0;
      case 19: 
        localeej.HPE = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(117948);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new asy();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((asy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localeej.HPF = ((asy)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(117948);
      return 0;
    }
    AppMethodBeat.o(117948);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eej
 * JD-Core Version:    0.7.0.1
 */