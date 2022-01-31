package com.tencent.mm.plugin.order.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class i
  extends com.tencent.mm.bv.a
{
  public int CreateTime;
  public String ntp;
  public String ppY;
  public double ppZ;
  public String pqa;
  public String pqb;
  public int pqc;
  public String pqd;
  public int pqe;
  public int pqf;
  public String pqg;
  public String pqh;
  public String pqi;
  public String pqj;
  public String pqk;
  public int pql;
  public LinkedList<k> pqm;
  public String pqn;
  public String pqo;
  public double pqp;
  public String pqq;
  
  public i()
  {
    AppMethodBeat.i(56618);
    this.pqm = new LinkedList();
    AppMethodBeat.o(56618);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56619);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.ppY != null) {
        paramVarArgs.e(1, this.ppY);
      }
      paramVarArgs.f(2, this.ppZ);
      if (this.pqa != null) {
        paramVarArgs.e(3, this.pqa);
      }
      paramVarArgs.aO(4, this.CreateTime);
      if (this.pqb != null) {
        paramVarArgs.e(5, this.pqb);
      }
      paramVarArgs.aO(6, this.pqc);
      if (this.pqd != null) {
        paramVarArgs.e(7, this.pqd);
      }
      paramVarArgs.aO(8, this.pqe);
      paramVarArgs.aO(9, this.pqf);
      if (this.pqg != null) {
        paramVarArgs.e(10, this.pqg);
      }
      if (this.ntp != null) {
        paramVarArgs.e(11, this.ntp);
      }
      if (this.pqh != null) {
        paramVarArgs.e(12, this.pqh);
      }
      if (this.pqi != null) {
        paramVarArgs.e(13, this.pqi);
      }
      if (this.pqj != null) {
        paramVarArgs.e(14, this.pqj);
      }
      if (this.pqk != null) {
        paramVarArgs.e(15, this.pqk);
      }
      paramVarArgs.aO(16, this.pql);
      paramVarArgs.e(17, 8, this.pqm);
      if (this.pqn != null) {
        paramVarArgs.e(18, this.pqn);
      }
      if (this.pqo != null) {
        paramVarArgs.e(19, this.pqo);
      }
      paramVarArgs.f(20, this.pqp);
      if (this.pqq != null) {
        paramVarArgs.e(21, this.pqq);
      }
      AppMethodBeat.o(56619);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ppY == null) {
        break label1416;
      }
    }
    label1416:
    for (paramInt = e.a.a.b.b.a.f(1, this.ppY) + 0;; paramInt = 0)
    {
      int i = paramInt + (e.a.a.b.b.a.eW(2) + 8);
      paramInt = i;
      if (this.pqa != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.pqa);
      }
      i = paramInt + e.a.a.b.b.a.bl(4, this.CreateTime);
      paramInt = i;
      if (this.pqb != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.pqb);
      }
      i = paramInt + e.a.a.b.b.a.bl(6, this.pqc);
      paramInt = i;
      if (this.pqd != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.pqd);
      }
      i = paramInt + e.a.a.b.b.a.bl(8, this.pqe) + e.a.a.b.b.a.bl(9, this.pqf);
      paramInt = i;
      if (this.pqg != null) {
        paramInt = i + e.a.a.b.b.a.f(10, this.pqg);
      }
      i = paramInt;
      if (this.ntp != null) {
        i = paramInt + e.a.a.b.b.a.f(11, this.ntp);
      }
      paramInt = i;
      if (this.pqh != null) {
        paramInt = i + e.a.a.b.b.a.f(12, this.pqh);
      }
      i = paramInt;
      if (this.pqi != null) {
        i = paramInt + e.a.a.b.b.a.f(13, this.pqi);
      }
      paramInt = i;
      if (this.pqj != null) {
        paramInt = i + e.a.a.b.b.a.f(14, this.pqj);
      }
      i = paramInt;
      if (this.pqk != null) {
        i = paramInt + e.a.a.b.b.a.f(15, this.pqk);
      }
      i = i + e.a.a.b.b.a.bl(16, this.pql) + e.a.a.a.c(17, 8, this.pqm);
      paramInt = i;
      if (this.pqn != null) {
        paramInt = i + e.a.a.b.b.a.f(18, this.pqn);
      }
      i = paramInt;
      if (this.pqo != null) {
        i = paramInt + e.a.a.b.b.a.f(19, this.pqo);
      }
      i += e.a.a.b.b.a.eW(20) + 8;
      paramInt = i;
      if (this.pqq != null) {
        paramInt = i + e.a.a.b.b.a.f(21, this.pqq);
      }
      AppMethodBeat.o(56619);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.pqm.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56619);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        i locali = (i)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56619);
          return -1;
        case 1: 
          locali.ppY = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56619);
          return 0;
        case 2: 
          locali.ppZ = Double.longBitsToDouble(((e.a.a.a.a)localObject1).CLY.emy());
          AppMethodBeat.o(56619);
          return 0;
        case 3: 
          locali.pqa = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56619);
          return 0;
        case 4: 
          locali.CreateTime = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56619);
          return 0;
        case 5: 
          locali.pqb = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56619);
          return 0;
        case 6: 
          locali.pqc = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56619);
          return 0;
        case 7: 
          locali.pqd = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56619);
          return 0;
        case 8: 
          locali.pqe = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56619);
          return 0;
        case 9: 
          locali.pqf = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56619);
          return 0;
        case 10: 
          locali.pqg = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56619);
          return 0;
        case 11: 
          locali.ntp = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56619);
          return 0;
        case 12: 
          locali.pqh = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56619);
          return 0;
        case 13: 
          locali.pqi = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56619);
          return 0;
        case 14: 
          locali.pqj = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56619);
          return 0;
        case 15: 
          locali.pqk = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56619);
          return 0;
        case 16: 
          locali.pql = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56619);
          return 0;
        case 17: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new k();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((k)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            locali.pqm.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56619);
          return 0;
        case 18: 
          locali.pqn = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56619);
          return 0;
        case 19: 
          locali.pqo = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56619);
          return 0;
        case 20: 
          locali.pqp = Double.longBitsToDouble(((e.a.a.a.a)localObject1).CLY.emy());
          AppMethodBeat.o(56619);
          return 0;
        }
        locali.pqq = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56619);
        return 0;
      }
      AppMethodBeat.o(56619);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.i
 * JD-Core Version:    0.7.0.1
 */