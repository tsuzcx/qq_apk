package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cz
  extends com.tencent.mm.bv.a
{
  public int cCy;
  public int qiP;
  public String qkn;
  public int scene;
  public String wpp;
  public String wpq;
  public String wpr;
  public adg wps;
  public String wpt;
  public int wpu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56702);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wpp == null)
      {
        paramVarArgs = new b("Not all required fields were included: f2f_id");
        AppMethodBeat.o(56702);
        throw paramVarArgs;
      }
      if (this.wpr == null)
      {
        paramVarArgs = new b("Not all required fields were included: payok_checksign");
        AppMethodBeat.o(56702);
        throw paramVarArgs;
      }
      if (this.wpp != null) {
        paramVarArgs.e(1, this.wpp);
      }
      if (this.wpq != null) {
        paramVarArgs.e(2, this.wpq);
      }
      paramVarArgs.aO(3, this.cCy);
      paramVarArgs.aO(4, this.qiP);
      paramVarArgs.aO(5, this.scene);
      if (this.wpr != null) {
        paramVarArgs.e(6, this.wpr);
      }
      if (this.wps != null)
      {
        paramVarArgs.iQ(7, this.wps.computeSize());
        this.wps.writeFields(paramVarArgs);
      }
      if (this.wpt != null) {
        paramVarArgs.e(8, this.wpt);
      }
      if (this.qkn != null) {
        paramVarArgs.e(9, this.qkn);
      }
      paramVarArgs.aO(10, this.wpu);
      AppMethodBeat.o(56702);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wpp == null) {
        break label890;
      }
    }
    label890:
    for (paramInt = e.a.a.b.b.a.f(1, this.wpp) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wpq != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.wpq);
      }
      i = i + e.a.a.b.b.a.bl(3, this.cCy) + e.a.a.b.b.a.bl(4, this.qiP) + e.a.a.b.b.a.bl(5, this.scene);
      paramInt = i;
      if (this.wpr != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wpr);
      }
      i = paramInt;
      if (this.wps != null) {
        i = paramInt + e.a.a.a.iP(7, this.wps.computeSize());
      }
      paramInt = i;
      if (this.wpt != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.wpt);
      }
      i = paramInt;
      if (this.qkn != null) {
        i = paramInt + e.a.a.b.b.a.f(9, this.qkn);
      }
      paramInt = e.a.a.b.b.a.bl(10, this.wpu);
      AppMethodBeat.o(56702);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wpp == null)
        {
          paramVarArgs = new b("Not all required fields were included: f2f_id");
          AppMethodBeat.o(56702);
          throw paramVarArgs;
        }
        if (this.wpr == null)
        {
          paramVarArgs = new b("Not all required fields were included: payok_checksign");
          AppMethodBeat.o(56702);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56702);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cz localcz = (cz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56702);
          return -1;
        case 1: 
          localcz.wpp = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56702);
          return 0;
        case 2: 
          localcz.wpq = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56702);
          return 0;
        case 3: 
          localcz.cCy = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56702);
          return 0;
        case 4: 
          localcz.qiP = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56702);
          return 0;
        case 5: 
          localcz.scene = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56702);
          return 0;
        case 6: 
          localcz.wpr = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56702);
          return 0;
        case 7: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new adg();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((adg)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcz.wps = ((adg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56702);
          return 0;
        case 8: 
          localcz.wpt = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56702);
          return 0;
        case 9: 
          localcz.qkn = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56702);
          return 0;
        }
        localcz.wpu = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56702);
        return 0;
      }
      AppMethodBeat.o(56702);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cz
 * JD-Core Version:    0.7.0.1
 */