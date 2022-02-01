package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class uu
  extends com.tencent.mm.bx.a
{
  public int Zam;
  public int Zan;
  public int Zao;
  public int Zap;
  public LinkedList<etl> Zaq;
  public String Zar;
  public gol Zas;
  public int Zat;
  public int Zau;
  public LinkedList<etl> Zav;
  public LinkedList<uv> Zaw;
  public LinkedList<uv> Zax;
  public int Zay;
  public int Zaz;
  public int yth;
  
  public uu()
  {
    AppMethodBeat.i(133162);
    this.Zaq = new LinkedList();
    this.Zav = new LinkedList();
    this.Zaw = new LinkedList();
    this.Zax = new LinkedList();
    AppMethodBeat.o(133162);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133163);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Zas == null)
      {
        paramVarArgs = new b("Not all required fields were included: AuthKey");
        AppMethodBeat.o(133163);
        throw paramVarArgs;
      }
      paramVarArgs.bS(1, this.Zam);
      paramVarArgs.bS(2, this.yth);
      paramVarArgs.bS(3, this.Zan);
      paramVarArgs.bS(4, this.Zao);
      paramVarArgs.bS(5, this.Zap);
      paramVarArgs.e(6, 8, this.Zaq);
      if (this.Zar != null) {
        paramVarArgs.g(7, this.Zar);
      }
      if (this.Zas != null)
      {
        paramVarArgs.qD(8, this.Zas.computeSize());
        this.Zas.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(9, this.Zat);
      paramVarArgs.bS(10, this.Zau);
      paramVarArgs.e(11, 8, this.Zav);
      paramVarArgs.e(12, 8, this.Zaw);
      paramVarArgs.e(13, 8, this.Zax);
      paramVarArgs.bS(14, this.Zay);
      paramVarArgs.bS(15, this.Zaz);
      AppMethodBeat.o(133163);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.Zam) + 0 + i.a.a.b.b.a.cJ(2, this.yth) + i.a.a.b.b.a.cJ(3, this.Zan) + i.a.a.b.b.a.cJ(4, this.Zao) + i.a.a.b.b.a.cJ(5, this.Zap) + i.a.a.a.c(6, 8, this.Zaq);
      paramInt = i;
      if (this.Zar != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.Zar);
      }
      i = paramInt;
      if (this.Zas != null) {
        i = paramInt + i.a.a.a.qC(8, this.Zas.computeSize());
      }
      paramInt = i.a.a.b.b.a.cJ(9, this.Zat);
      int j = i.a.a.b.b.a.cJ(10, this.Zau);
      int k = i.a.a.a.c(11, 8, this.Zav);
      int m = i.a.a.a.c(12, 8, this.Zaw);
      int n = i.a.a.a.c(13, 8, this.Zax);
      int i1 = i.a.a.b.b.a.cJ(14, this.Zay);
      int i2 = i.a.a.b.b.a.cJ(15, this.Zaz);
      AppMethodBeat.o(133163);
      return i + paramInt + j + k + m + n + i1 + i2;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Zaq.clear();
      this.Zav.clear();
      this.Zaw.clear();
      this.Zax.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      if (this.Zas == null)
      {
        paramVarArgs = new b("Not all required fields were included: AuthKey");
        AppMethodBeat.o(133163);
        throw paramVarArgs;
      }
      AppMethodBeat.o(133163);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      uu localuu = (uu)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(133163);
        return -1;
      case 1: 
        localuu.Zam = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(133163);
        return 0;
      case 2: 
        localuu.yth = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(133163);
        return 0;
      case 3: 
        localuu.Zan = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(133163);
        return 0;
      case 4: 
        localuu.Zao = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(133163);
        return 0;
      case 5: 
        localuu.Zap = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(133163);
        return 0;
      case 6: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new etl();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((etl)localObject2).dh((byte[])localObject1);
          }
          localuu.Zaq.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133163);
        return 0;
      case 7: 
        localuu.Zar = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(133163);
        return 0;
      case 8: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new gol();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((gol)localObject2).dg((byte[])localObject1);
          }
          localuu.Zas = ((gol)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133163);
        return 0;
      case 9: 
        localuu.Zat = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(133163);
        return 0;
      case 10: 
        localuu.Zau = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(133163);
        return 0;
      case 11: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new etl();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((etl)localObject2).dh((byte[])localObject1);
          }
          localuu.Zav.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133163);
        return 0;
      case 12: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new uv();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((uv)localObject2).parseFrom((byte[])localObject1);
          }
          localuu.Zaw.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133163);
        return 0;
      case 13: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new uv();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((uv)localObject2).parseFrom((byte[])localObject1);
          }
          localuu.Zax.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133163);
        return 0;
      case 14: 
        localuu.Zay = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(133163);
        return 0;
      }
      localuu.Zaz = ((i.a.a.a.a)localObject1).ajGk.aar();
      AppMethodBeat.o(133163);
      return 0;
    }
    AppMethodBeat.o(133163);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.uu
 * JD-Core Version:    0.7.0.1
 */