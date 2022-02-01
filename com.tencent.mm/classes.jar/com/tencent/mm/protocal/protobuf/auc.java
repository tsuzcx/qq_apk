package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class auc
  extends com.tencent.mm.bx.a
{
  public LinkedList<dbi> Gsg;
  public dbi Gsh;
  public LinkedList<aub> Gsi;
  public boolean Gsj;
  public String Gsk;
  public long Gsl;
  public String dyV;
  public boolean ssW;
  
  public auc()
  {
    AppMethodBeat.i(122501);
    this.Gsg = new LinkedList();
    this.Gsi = new LinkedList();
    this.Gsj = false;
    this.ssW = false;
    AppMethodBeat.o(122501);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122502);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dyV != null) {
        paramVarArgs.d(1, this.dyV);
      }
      paramVarArgs.e(2, 8, this.Gsg);
      if (this.Gsh != null)
      {
        paramVarArgs.lC(3, this.Gsh.computeSize());
        this.Gsh.writeFields(paramVarArgs);
      }
      paramVarArgs.e(4, 8, this.Gsi);
      paramVarArgs.bt(5, this.Gsj);
      paramVarArgs.bt(6, this.ssW);
      if (this.Gsk != null) {
        paramVarArgs.d(7, this.Gsk);
      }
      paramVarArgs.aY(8, this.Gsl);
      AppMethodBeat.o(122502);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dyV == null) {
        break label838;
      }
    }
    label838:
    for (paramInt = f.a.a.b.b.a.e(1, this.dyV) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.Gsg);
      paramInt = i;
      if (this.Gsh != null) {
        paramInt = i + f.a.a.a.lB(3, this.Gsh.computeSize());
      }
      i = paramInt + f.a.a.a.c(4, 8, this.Gsi) + f.a.a.b.b.a.alV(5) + f.a.a.b.b.a.alV(6);
      paramInt = i;
      if (this.Gsk != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Gsk);
      }
      i = f.a.a.b.b.a.p(8, this.Gsl);
      AppMethodBeat.o(122502);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Gsg.clear();
        this.Gsi.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(122502);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        auc localauc = (auc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122502);
          return -1;
        case 1: 
          localauc.dyV = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(122502);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dbi();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dbi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localauc.Gsg.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122502);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dbi();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dbi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localauc.Gsh = ((dbi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122502);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aub();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aub)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localauc.Gsi.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122502);
          return 0;
        case 5: 
          localauc.Gsj = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(122502);
          return 0;
        case 6: 
          localauc.ssW = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(122502);
          return 0;
        case 7: 
          localauc.Gsk = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(122502);
          return 0;
        }
        localauc.Gsl = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(122502);
        return 0;
      }
      AppMethodBeat.o(122502);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.auc
 * JD-Core Version:    0.7.0.1
 */