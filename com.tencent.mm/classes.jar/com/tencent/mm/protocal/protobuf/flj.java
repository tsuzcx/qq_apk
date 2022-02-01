package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class flj
  extends com.tencent.mm.cd.a
{
  public int CPw;
  public long Sap;
  public int Tkv;
  public cqh TwK;
  public aam TwL;
  public LinkedList<String> UKj;
  public LinkedList<aci> UKk;
  public String sSU;
  public String vhq;
  
  public flj()
  {
    AppMethodBeat.i(117951);
    this.UKj = new LinkedList();
    this.UKk = new LinkedList();
    AppMethodBeat.o(117951);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117952);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.UKj);
      paramVarArgs.aY(2, this.Tkv);
      if (this.vhq != null) {
        paramVarArgs.f(3, this.vhq);
      }
      paramVarArgs.aY(4, this.CPw);
      paramVarArgs.bm(5, this.Sap);
      if (this.sSU != null) {
        paramVarArgs.f(6, this.sSU);
      }
      if (this.TwK != null)
      {
        paramVarArgs.oE(7, this.TwK.computeSize());
        this.TwK.writeFields(paramVarArgs);
      }
      paramVarArgs.e(8, 8, this.UKk);
      if (this.TwL != null)
      {
        paramVarArgs.oE(9, this.TwL.computeSize());
        this.TwL.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(117952);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 1, this.UKj) + 0 + g.a.a.b.b.a.bM(2, this.Tkv);
      paramInt = i;
      if (this.vhq != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.vhq);
      }
      i = paramInt + g.a.a.b.b.a.bM(4, this.CPw) + g.a.a.b.b.a.p(5, this.Sap);
      paramInt = i;
      if (this.sSU != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.sSU);
      }
      i = paramInt;
      if (this.TwK != null) {
        i = paramInt + g.a.a.a.oD(7, this.TwK.computeSize());
      }
      i += g.a.a.a.c(8, 8, this.UKk);
      paramInt = i;
      if (this.TwL != null) {
        paramInt = i + g.a.a.a.oD(9, this.TwL.computeSize());
      }
      AppMethodBeat.o(117952);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.UKj.clear();
      this.UKk.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(117952);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      flj localflj = (flj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117952);
        return -1;
      case 1: 
        localflj.UKj.add(((g.a.a.a.a)localObject1).abFh.readString());
        AppMethodBeat.o(117952);
        return 0;
      case 2: 
        localflj.Tkv = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(117952);
        return 0;
      case 3: 
        localflj.vhq = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(117952);
        return 0;
      case 4: 
        localflj.CPw = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(117952);
        return 0;
      case 5: 
        localflj.Sap = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(117952);
        return 0;
      case 6: 
        localflj.sSU = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(117952);
        return 0;
      case 7: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cqh();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cqh)localObject2).parseFrom((byte[])localObject1);
          }
          localflj.TwK = ((cqh)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(117952);
        return 0;
      case 8: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new aci();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((aci)localObject2).parseFrom((byte[])localObject1);
          }
          localflj.UKk.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(117952);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new aam();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((aam)localObject2).parseFrom((byte[])localObject1);
        }
        localflj.TwL = ((aam)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(117952);
      return 0;
    }
    AppMethodBeat.o(117952);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.flj
 * JD-Core Version:    0.7.0.1
 */