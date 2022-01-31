package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class blp
  extends com.tencent.mm.bv.a
{
  public int CreateTime;
  public String ntp;
  public String ppY;
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
  public LinkedList<ccu> pqm;
  public int xAm;
  
  public blp()
  {
    AppMethodBeat.i(56901);
    this.pqm = new LinkedList();
    AppMethodBeat.o(56901);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56902);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.ppY != null) {
        paramVarArgs.e(1, this.ppY);
      }
      paramVarArgs.aO(2, this.xAm);
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
      AppMethodBeat.o(56902);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ppY == null) {
        break label1186;
      }
    }
    label1186:
    for (paramInt = e.a.a.b.b.a.f(1, this.ppY) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.xAm);
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
      paramInt = e.a.a.b.b.a.bl(16, this.pql);
      int j = e.a.a.a.c(17, 8, this.pqm);
      AppMethodBeat.o(56902);
      return i + paramInt + j;
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
        AppMethodBeat.o(56902);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        blp localblp = (blp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56902);
          return -1;
        case 1: 
          localblp.ppY = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56902);
          return 0;
        case 2: 
          localblp.xAm = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56902);
          return 0;
        case 3: 
          localblp.pqa = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56902);
          return 0;
        case 4: 
          localblp.CreateTime = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56902);
          return 0;
        case 5: 
          localblp.pqb = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56902);
          return 0;
        case 6: 
          localblp.pqc = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56902);
          return 0;
        case 7: 
          localblp.pqd = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56902);
          return 0;
        case 8: 
          localblp.pqe = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56902);
          return 0;
        case 9: 
          localblp.pqf = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56902);
          return 0;
        case 10: 
          localblp.pqg = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56902);
          return 0;
        case 11: 
          localblp.ntp = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56902);
          return 0;
        case 12: 
          localblp.pqh = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56902);
          return 0;
        case 13: 
          localblp.pqi = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56902);
          return 0;
        case 14: 
          localblp.pqj = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56902);
          return 0;
        case 15: 
          localblp.pqk = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56902);
          return 0;
        case 16: 
          localblp.pql = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56902);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ccu();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ccu)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localblp.pqm.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(56902);
        return 0;
      }
      AppMethodBeat.o(56902);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.blp
 * JD-Core Version:    0.7.0.1
 */