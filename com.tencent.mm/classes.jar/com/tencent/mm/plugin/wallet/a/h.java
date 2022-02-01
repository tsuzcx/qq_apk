package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class h
  extends com.tencent.mm.cd.a
{
  public double Owj;
  public double Owk;
  public double Owl;
  public String Owm;
  public LinkedList<t> Own;
  public i Owo;
  public int Owp;
  public String Owq;
  public String Owr;
  public double Ows;
  public double Owt;
  public int Owu;
  public String Owv;
  public String Oww;
  public a Owx;
  public LinkedList<g> Owy;
  public b Owz;
  
  public h()
  {
    AppMethodBeat.i(91292);
    this.Own = new LinkedList();
    this.Owy = new LinkedList();
    AppMethodBeat.o(91292);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91293);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, this.Owj);
      paramVarArgs.e(2, this.Owk);
      paramVarArgs.e(3, this.Owl);
      if (this.Owm != null) {
        paramVarArgs.f(4, this.Owm);
      }
      paramVarArgs.e(5, 8, this.Own);
      if (this.Owo != null)
      {
        paramVarArgs.oE(6, this.Owo.computeSize());
        this.Owo.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(7, this.Owp);
      if (this.Owq != null) {
        paramVarArgs.f(8, this.Owq);
      }
      if (this.Owr != null) {
        paramVarArgs.f(9, this.Owr);
      }
      paramVarArgs.e(10, this.Ows);
      paramVarArgs.e(11, this.Owt);
      paramVarArgs.aY(12, this.Owu);
      if (this.Owv != null) {
        paramVarArgs.f(13, this.Owv);
      }
      if (this.Oww != null) {
        paramVarArgs.f(14, this.Oww);
      }
      if (this.Owx != null)
      {
        paramVarArgs.oE(15, this.Owx.computeSize());
        this.Owx.writeFields(paramVarArgs);
      }
      paramVarArgs.e(16, 8, this.Owy);
      if (this.Owz != null)
      {
        paramVarArgs.oE(17, this.Owz.computeSize());
        this.Owz.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91293);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.gL(1) + 8 + 0 + (g.a.a.b.b.a.gL(2) + 8) + (g.a.a.b.b.a.gL(3) + 8);
      paramInt = i;
      if (this.Owm != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Owm);
      }
      i = paramInt + g.a.a.a.c(5, 8, this.Own);
      paramInt = i;
      if (this.Owo != null) {
        paramInt = i + g.a.a.a.oD(6, this.Owo.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(7, this.Owp);
      paramInt = i;
      if (this.Owq != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.Owq);
      }
      i = paramInt;
      if (this.Owr != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.Owr);
      }
      i = i + (g.a.a.b.b.a.gL(10) + 8) + (g.a.a.b.b.a.gL(11) + 8) + g.a.a.b.b.a.bM(12, this.Owu);
      paramInt = i;
      if (this.Owv != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.Owv);
      }
      i = paramInt;
      if (this.Oww != null) {
        i = paramInt + g.a.a.b.b.a.g(14, this.Oww);
      }
      paramInt = i;
      if (this.Owx != null) {
        paramInt = i + g.a.a.a.oD(15, this.Owx.computeSize());
      }
      i = paramInt + g.a.a.a.c(16, 8, this.Owy);
      paramInt = i;
      if (this.Owz != null) {
        paramInt = i + g.a.a.a.oD(17, this.Owz.computeSize());
      }
      AppMethodBeat.o(91293);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Own.clear();
      this.Owy.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(91293);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      h localh = (h)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91293);
        return -1;
      case 1: 
        localh.Owj = Double.longBitsToDouble(((g.a.a.a.a)localObject1).abFh.AP());
        AppMethodBeat.o(91293);
        return 0;
      case 2: 
        localh.Owk = Double.longBitsToDouble(((g.a.a.a.a)localObject1).abFh.AP());
        AppMethodBeat.o(91293);
        return 0;
      case 3: 
        localh.Owl = Double.longBitsToDouble(((g.a.a.a.a)localObject1).abFh.AP());
        AppMethodBeat.o(91293);
        return 0;
      case 4: 
        localh.Owm = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(91293);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new t();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((t)localObject2).parseFrom((byte[])localObject1);
          }
          localh.Own.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91293);
        return 0;
      case 6: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new i();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((i)localObject2).parseFrom((byte[])localObject1);
          }
          localh.Owo = ((i)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91293);
        return 0;
      case 7: 
        localh.Owp = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(91293);
        return 0;
      case 8: 
        localh.Owq = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(91293);
        return 0;
      case 9: 
        localh.Owr = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(91293);
        return 0;
      case 10: 
        localh.Ows = Double.longBitsToDouble(((g.a.a.a.a)localObject1).abFh.AP());
        AppMethodBeat.o(91293);
        return 0;
      case 11: 
        localh.Owt = Double.longBitsToDouble(((g.a.a.a.a)localObject1).abFh.AP());
        AppMethodBeat.o(91293);
        return 0;
      case 12: 
        localh.Owu = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(91293);
        return 0;
      case 13: 
        localh.Owv = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(91293);
        return 0;
      case 14: 
        localh.Oww = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(91293);
        return 0;
      case 15: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new a();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((a)localObject2).parseFrom((byte[])localObject1);
          }
          localh.Owx = ((a)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91293);
        return 0;
      case 16: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new g();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((g)localObject2).parseFrom((byte[])localObject1);
          }
          localh.Owy.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91293);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new b();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((b)localObject2).parseFrom((byte[])localObject1);
        }
        localh.Owz = ((b)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(91293);
      return 0;
    }
    AppMethodBeat.o(91293);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.h
 * JD-Core Version:    0.7.0.1
 */