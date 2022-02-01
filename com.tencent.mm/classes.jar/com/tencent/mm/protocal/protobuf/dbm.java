package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dbm
  extends com.tencent.mm.bx.a
{
  public String Gsk;
  public long Gsl;
  public LinkedList<dbi> Hrg;
  public int index;
  public String qXk;
  public boolean ssW;
  public int type;
  
  public dbm()
  {
    AppMethodBeat.i(169384);
    this.Hrg = new LinkedList();
    this.ssW = false;
    this.type = 0;
    this.index = -1;
    AppMethodBeat.o(169384);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169385);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.qXk != null) {
        paramVarArgs.d(1, this.qXk);
      }
      paramVarArgs.aY(2, this.Gsl);
      paramVarArgs.e(3, 8, this.Hrg);
      if (this.Gsk != null) {
        paramVarArgs.d(4, this.Gsk);
      }
      paramVarArgs.bt(5, this.ssW);
      paramVarArgs.aS(6, this.type);
      paramVarArgs.aS(7, this.index);
      AppMethodBeat.o(169385);
      return 0;
    }
    if (paramInt == 1) {
      if (this.qXk == null) {
        break label594;
      }
    }
    label594:
    for (paramInt = f.a.a.b.b.a.e(1, this.qXk) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.Gsl) + f.a.a.a.c(3, 8, this.Hrg);
      paramInt = i;
      if (this.Gsk != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Gsk);
      }
      i = f.a.a.b.b.a.alV(5);
      int j = f.a.a.b.b.a.bz(6, this.type);
      int k = f.a.a.b.b.a.bz(7, this.index);
      AppMethodBeat.o(169385);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Hrg.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(169385);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dbm localdbm = (dbm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169385);
          return -1;
        case 1: 
          localdbm.qXk = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(169385);
          return 0;
        case 2: 
          localdbm.Gsl = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(169385);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dbi();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dbi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdbm.Hrg.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169385);
          return 0;
        case 4: 
          localdbm.Gsk = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(169385);
          return 0;
        case 5: 
          localdbm.ssW = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(169385);
          return 0;
        case 6: 
          localdbm.type = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(169385);
          return 0;
        }
        localdbm.index = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(169385);
        return 0;
      }
      AppMethodBeat.o(169385);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbm
 * JD-Core Version:    0.7.0.1
 */