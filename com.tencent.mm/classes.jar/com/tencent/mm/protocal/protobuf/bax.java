package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bax
  extends com.tencent.mm.bv.a
{
  public LinkedList<po> wZn;
  public String xpZ;
  public boolean xqa;
  public gz xqb;
  public String xqc;
  public boolean xqd;
  public int xqe;
  public String xqf;
  public int xqg;
  
  public bax()
  {
    AppMethodBeat.i(56849);
    this.wZn = new LinkedList();
    AppMethodBeat.o(56849);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56850);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xpZ != null) {
        paramVarArgs.e(1, this.xpZ);
      }
      paramVarArgs.e(2, 8, this.wZn);
      paramVarArgs.aS(3, this.xqa);
      if (this.xqb != null)
      {
        paramVarArgs.iQ(4, this.xqb.computeSize());
        this.xqb.writeFields(paramVarArgs);
      }
      if (this.xqc != null) {
        paramVarArgs.e(5, this.xqc);
      }
      paramVarArgs.aS(6, this.xqd);
      paramVarArgs.aO(7, this.xqe);
      if (this.xqf != null) {
        paramVarArgs.e(8, this.xqf);
      }
      paramVarArgs.aO(9, this.xqg);
      AppMethodBeat.o(56850);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xpZ == null) {
        break label806;
      }
    }
    label806:
    for (paramInt = e.a.a.b.b.a.f(1, this.xpZ) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.a.c(2, 8, this.wZn) + (e.a.a.b.b.a.eW(3) + 1);
      paramInt = i;
      if (this.xqb != null) {
        paramInt = i + e.a.a.a.iP(4, this.xqb.computeSize());
      }
      i = paramInt;
      if (this.xqc != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.xqc);
      }
      i = i + (e.a.a.b.b.a.eW(6) + 1) + e.a.a.b.b.a.bl(7, this.xqe);
      paramInt = i;
      if (this.xqf != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.xqf);
      }
      i = e.a.a.b.b.a.bl(9, this.xqg);
      AppMethodBeat.o(56850);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wZn.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56850);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bax localbax = (bax)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56850);
          return -1;
        case 1: 
          localbax.xpZ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56850);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new po();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((po)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbax.wZn.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56850);
          return 0;
        case 3: 
          localbax.xqa = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(56850);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gz();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gz)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbax.xqb = ((gz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56850);
          return 0;
        case 5: 
          localbax.xqc = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56850);
          return 0;
        case 6: 
          localbax.xqd = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(56850);
          return 0;
        case 7: 
          localbax.xqe = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56850);
          return 0;
        case 8: 
          localbax.xqf = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56850);
          return 0;
        }
        localbax.xqg = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56850);
        return 0;
      }
      AppMethodBeat.o(56850);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bax
 * JD-Core Version:    0.7.0.1
 */