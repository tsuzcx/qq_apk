package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dyj
  extends com.tencent.mm.bw.a
{
  public String EJp;
  public String EfU;
  public int EfV;
  public int FCc;
  public int FCg;
  public int FCz;
  public int FPQ;
  public int FhS;
  public bpa FhT;
  public String FrO;
  public String FzI;
  public LinkedList<yh> Gdj;
  public int Geu;
  public String Gev;
  public String Gew;
  public LinkedList<String> Gex;
  public int Gey;
  public ape Gez;
  public int Scene;
  public int ndI;
  
  public dyj()
  {
    AppMethodBeat.i(117947);
    this.Geu = 2;
    this.Gdj = new LinkedList();
    this.Gex = new LinkedList();
    AppMethodBeat.o(117947);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117948);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.EfV);
      paramVarArgs.aR(2, this.FhS);
      paramVarArgs.aR(3, this.FCc);
      if (this.EJp != null) {
        paramVarArgs.d(4, this.EJp);
      }
      if (this.FhT != null)
      {
        paramVarArgs.ln(5, this.FhT.computeSize());
        this.FhT.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(6, this.Scene);
      if (this.EfU != null) {
        paramVarArgs.d(7, this.EfU);
      }
      paramVarArgs.aR(8, this.FCg);
      paramVarArgs.aR(9, this.Geu);
      paramVarArgs.e(10, 8, this.Gdj);
      if (this.Gev != null) {
        paramVarArgs.d(11, this.Gev);
      }
      if (this.FrO != null) {
        paramVarArgs.d(12, this.FrO);
      }
      paramVarArgs.aR(13, this.FPQ);
      if (this.Gew != null) {
        paramVarArgs.d(14, this.Gew);
      }
      if (this.FzI != null) {
        paramVarArgs.d(15, this.FzI);
      }
      paramVarArgs.e(16, 1, this.Gex);
      paramVarArgs.aR(17, this.FCz);
      paramVarArgs.aR(18, this.ndI);
      paramVarArgs.aR(19, this.Gey);
      if (this.Gez != null)
      {
        paramVarArgs.ln(20, this.Gez.computeSize());
        this.Gez.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(117948);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.EfV) + 0 + f.a.a.b.b.a.bx(2, this.FhS) + f.a.a.b.b.a.bx(3, this.FCc);
      paramInt = i;
      if (this.EJp != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EJp);
      }
      i = paramInt;
      if (this.FhT != null) {
        i = paramInt + f.a.a.a.lm(5, this.FhT.computeSize());
      }
      i += f.a.a.b.b.a.bx(6, this.Scene);
      paramInt = i;
      if (this.EfU != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.EfU);
      }
      i = paramInt + f.a.a.b.b.a.bx(8, this.FCg) + f.a.a.b.b.a.bx(9, this.Geu) + f.a.a.a.c(10, 8, this.Gdj);
      paramInt = i;
      if (this.Gev != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.Gev);
      }
      i = paramInt;
      if (this.FrO != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.FrO);
      }
      i += f.a.a.b.b.a.bx(13, this.FPQ);
      paramInt = i;
      if (this.Gew != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.Gew);
      }
      i = paramInt;
      if (this.FzI != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.FzI);
      }
      i = i + f.a.a.a.c(16, 1, this.Gex) + f.a.a.b.b.a.bx(17, this.FCz) + f.a.a.b.b.a.bx(18, this.ndI) + f.a.a.b.b.a.bx(19, this.Gey);
      paramInt = i;
      if (this.Gez != null) {
        paramInt = i + f.a.a.a.lm(20, this.Gez.computeSize());
      }
      AppMethodBeat.o(117948);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Gdj.clear();
      this.Gex.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(117948);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dyj localdyj = (dyj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117948);
        return -1;
      case 1: 
        localdyj.EfV = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(117948);
        return 0;
      case 2: 
        localdyj.FhS = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(117948);
        return 0;
      case 3: 
        localdyj.FCc = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(117948);
        return 0;
      case 4: 
        localdyj.EJp = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(117948);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bpa();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bpa)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdyj.FhT = ((bpa)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117948);
        return 0;
      case 6: 
        localdyj.Scene = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(117948);
        return 0;
      case 7: 
        localdyj.EfU = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(117948);
        return 0;
      case 8: 
        localdyj.FCg = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(117948);
        return 0;
      case 9: 
        localdyj.Geu = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(117948);
        return 0;
      case 10: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new yh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((yh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdyj.Gdj.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117948);
        return 0;
      case 11: 
        localdyj.Gev = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(117948);
        return 0;
      case 12: 
        localdyj.FrO = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(117948);
        return 0;
      case 13: 
        localdyj.FPQ = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(117948);
        return 0;
      case 14: 
        localdyj.Gew = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(117948);
        return 0;
      case 15: 
        localdyj.FzI = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(117948);
        return 0;
      case 16: 
        localdyj.Gex.add(((f.a.a.a.a)localObject1).LVo.readString());
        AppMethodBeat.o(117948);
        return 0;
      case 17: 
        localdyj.FCz = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(117948);
        return 0;
      case 18: 
        localdyj.ndI = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(117948);
        return 0;
      case 19: 
        localdyj.Gey = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(117948);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ape();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ape)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localdyj.Gez = ((ape)localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyj
 * JD-Core Version:    0.7.0.1
 */