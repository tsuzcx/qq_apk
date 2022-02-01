package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class chj
  extends com.tencent.mm.bx.a
  implements fcu
{
  public int Idd;
  public int Zla;
  public int Zlb;
  public int Zlc;
  public LinkedList<fjn> Zld;
  public LinkedList<fjn> Zle;
  public LinkedList<fjn> Zlf;
  public int Zlg;
  public int Zlh;
  public int Zli;
  public czq Zlj;
  public int aaqg;
  public int aaqh;
  public int aaqi;
  public LinkedList<fjn> aaqj;
  public LinkedList<fjn> aaqk;
  public LinkedList<fjn> aaql;
  
  public chj()
  {
    AppMethodBeat.i(143974);
    this.Zld = new LinkedList();
    this.Zle = new LinkedList();
    this.Zlf = new LinkedList();
    this.aaqj = new LinkedList();
    this.aaqk = new LinkedList();
    this.aaql = new LinkedList();
    AppMethodBeat.o(143974);
  }
  
  public final int getRet()
  {
    return this.Idd;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143975);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.Idd);
      paramVarArgs.bS(2, this.Zla);
      paramVarArgs.bS(3, this.Zlb);
      paramVarArgs.bS(4, this.Zlc);
      paramVarArgs.e(5, 8, this.Zld);
      paramVarArgs.e(6, 8, this.Zle);
      paramVarArgs.e(7, 8, this.Zlf);
      paramVarArgs.bS(8, this.Zlg);
      paramVarArgs.bS(9, this.Zlh);
      paramVarArgs.bS(10, this.Zli);
      paramVarArgs.bS(11, this.aaqg);
      paramVarArgs.bS(12, this.aaqh);
      paramVarArgs.bS(13, this.aaqi);
      paramVarArgs.e(14, 8, this.aaqj);
      paramVarArgs.e(15, 8, this.aaqk);
      paramVarArgs.e(16, 8, this.aaql);
      if (this.Zlj != null)
      {
        paramVarArgs.qD(17, this.Zlj.computeSize());
        this.Zlj.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(143975);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.Idd) + 0 + i.a.a.b.b.a.cJ(2, this.Zla) + i.a.a.b.b.a.cJ(3, this.Zlb) + i.a.a.b.b.a.cJ(4, this.Zlc) + i.a.a.a.c(5, 8, this.Zld) + i.a.a.a.c(6, 8, this.Zle) + i.a.a.a.c(7, 8, this.Zlf) + i.a.a.b.b.a.cJ(8, this.Zlg) + i.a.a.b.b.a.cJ(9, this.Zlh) + i.a.a.b.b.a.cJ(10, this.Zli) + i.a.a.b.b.a.cJ(11, this.aaqg) + i.a.a.b.b.a.cJ(12, this.aaqh) + i.a.a.b.b.a.cJ(13, this.aaqi) + i.a.a.a.c(14, 8, this.aaqj) + i.a.a.a.c(15, 8, this.aaqk) + i.a.a.a.c(16, 8, this.aaql);
      paramInt = i;
      if (this.Zlj != null) {
        paramInt = i + i.a.a.a.qC(17, this.Zlj.computeSize());
      }
      AppMethodBeat.o(143975);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Zld.clear();
      this.Zle.clear();
      this.Zlf.clear();
      this.aaqj.clear();
      this.aaqk.clear();
      this.aaql.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(143975);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      chj localchj = (chj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143975);
        return -1;
      case 1: 
        localchj.Idd = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(143975);
        return 0;
      case 2: 
        localchj.Zla = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(143975);
        return 0;
      case 3: 
        localchj.Zlb = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(143975);
        return 0;
      case 4: 
        localchj.Zlc = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(143975);
        return 0;
      case 5: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fjn();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fjn)localObject2).parseFrom((byte[])localObject1);
          }
          localchj.Zld.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(143975);
        return 0;
      case 6: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fjn();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fjn)localObject2).parseFrom((byte[])localObject1);
          }
          localchj.Zle.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(143975);
        return 0;
      case 7: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fjn();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fjn)localObject2).parseFrom((byte[])localObject1);
          }
          localchj.Zlf.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(143975);
        return 0;
      case 8: 
        localchj.Zlg = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(143975);
        return 0;
      case 9: 
        localchj.Zlh = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(143975);
        return 0;
      case 10: 
        localchj.Zli = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(143975);
        return 0;
      case 11: 
        localchj.aaqg = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(143975);
        return 0;
      case 12: 
        localchj.aaqh = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(143975);
        return 0;
      case 13: 
        localchj.aaqi = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(143975);
        return 0;
      case 14: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fjn();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fjn)localObject2).parseFrom((byte[])localObject1);
          }
          localchj.aaqj.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(143975);
        return 0;
      case 15: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fjn();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fjn)localObject2).parseFrom((byte[])localObject1);
          }
          localchj.aaqk.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(143975);
        return 0;
      case 16: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fjn();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fjn)localObject2).parseFrom((byte[])localObject1);
          }
          localchj.aaql.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(143975);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new czq();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((czq)localObject2).parseFrom((byte[])localObject1);
        }
        localchj.Zlj = ((czq)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(143975);
      return 0;
    }
    AppMethodBeat.o(143975);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chj
 * JD-Core Version:    0.7.0.1
 */