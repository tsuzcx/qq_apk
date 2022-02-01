package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ano
  extends com.tencent.mm.bx.a
{
  public String Zva;
  public gol Zvb;
  public int Zvc;
  public LinkedList<anj> Zvd;
  public int Zve;
  public LinkedList<cjb> Zvf;
  public int Zvg;
  public LinkedList<amp> Zvh;
  public int hjP;
  public int vhJ;
  
  public ano()
  {
    AppMethodBeat.i(260230);
    this.Zvd = new LinkedList();
    this.Zvf = new LinkedList();
    this.Zvh = new LinkedList();
    AppMethodBeat.o(260230);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260236);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.hjP);
      paramVarArgs.bS(2, this.vhJ);
      if (this.Zva != null) {
        paramVarArgs.g(3, this.Zva);
      }
      if (this.Zvb != null)
      {
        paramVarArgs.qD(4, this.Zvb.computeSize());
        this.Zvb.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(5, this.Zvc);
      paramVarArgs.e(6, 8, this.Zvd);
      paramVarArgs.bS(7, this.Zve);
      paramVarArgs.e(8, 8, this.Zvf);
      paramVarArgs.bS(9, this.Zvg);
      paramVarArgs.e(10, 8, this.Zvh);
      AppMethodBeat.o(260236);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.hjP) + 0 + i.a.a.b.b.a.cJ(2, this.vhJ);
      paramInt = i;
      if (this.Zva != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.Zva);
      }
      i = paramInt;
      if (this.Zvb != null) {
        i = paramInt + i.a.a.a.qC(4, this.Zvb.computeSize());
      }
      paramInt = i.a.a.b.b.a.cJ(5, this.Zvc);
      int j = i.a.a.a.c(6, 8, this.Zvd);
      int k = i.a.a.b.b.a.cJ(7, this.Zve);
      int m = i.a.a.a.c(8, 8, this.Zvf);
      int n = i.a.a.b.b.a.cJ(9, this.Zvg);
      int i1 = i.a.a.a.c(10, 8, this.Zvh);
      AppMethodBeat.o(260236);
      return i + paramInt + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Zvd.clear();
      this.Zvf.clear();
      this.Zvh.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(260236);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      ano localano = (ano)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(260236);
        return -1;
      case 1: 
        localano.hjP = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(260236);
        return 0;
      case 2: 
        localano.vhJ = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(260236);
        return 0;
      case 3: 
        localano.Zva = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(260236);
        return 0;
      case 4: 
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
          localano.Zvb = ((gol)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(260236);
        return 0;
      case 5: 
        localano.Zvc = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(260236);
        return 0;
      case 6: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new anj();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((anj)localObject2).parseFrom((byte[])localObject1);
          }
          localano.Zvd.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(260236);
        return 0;
      case 7: 
        localano.Zve = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(260236);
        return 0;
      case 8: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cjb();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cjb)localObject2).parseFrom((byte[])localObject1);
          }
          localano.Zvf.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(260236);
        return 0;
      case 9: 
        localano.Zvg = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(260236);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new amp();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((amp)localObject2).parseFrom((byte[])localObject1);
        }
        localano.Zvh.add(localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(260236);
      return 0;
    }
    AppMethodBeat.o(260236);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ano
 * JD-Core Version:    0.7.0.1
 */