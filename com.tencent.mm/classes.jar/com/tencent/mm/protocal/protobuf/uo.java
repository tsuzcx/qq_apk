package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class uo
  extends com.tencent.mm.bv.a
{
  public String kWy;
  public String kmn;
  public String kmo;
  public String title;
  public String url;
  public String wFL;
  public String wFM;
  public long wGZ;
  public String wHa;
  public String wHb;
  public atg wML;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89052);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      if (this.kmn != null) {
        paramVarArgs.e(2, this.kmn);
      }
      if (this.kmo != null) {
        paramVarArgs.e(3, this.kmo);
      }
      if (this.url != null) {
        paramVarArgs.e(4, this.url);
      }
      paramVarArgs.am(5, this.wGZ);
      if (this.wHa != null) {
        paramVarArgs.e(6, this.wHa);
      }
      if (this.wHb != null) {
        paramVarArgs.e(7, this.wHb);
      }
      if (this.kWy != null) {
        paramVarArgs.e(8, this.kWy);
      }
      if (this.wML != null)
      {
        paramVarArgs.iQ(9, this.wML.computeSize());
        this.wML.writeFields(paramVarArgs);
      }
      if (this.wFL != null) {
        paramVarArgs.e(10, this.wFL);
      }
      if (this.wFM != null) {
        paramVarArgs.e(11, this.wFM);
      }
      AppMethodBeat.o(89052);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label906;
      }
    }
    label906:
    for (int i = e.a.a.b.b.a.f(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.kmn != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.kmn);
      }
      i = paramInt;
      if (this.kmo != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.kmo);
      }
      paramInt = i;
      if (this.url != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.url);
      }
      i = paramInt + e.a.a.b.b.a.p(5, this.wGZ);
      paramInt = i;
      if (this.wHa != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wHa);
      }
      i = paramInt;
      if (this.wHb != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.wHb);
      }
      paramInt = i;
      if (this.kWy != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.kWy);
      }
      i = paramInt;
      if (this.wML != null) {
        i = paramInt + e.a.a.a.iP(9, this.wML.computeSize());
      }
      paramInt = i;
      if (this.wFL != null) {
        paramInt = i + e.a.a.b.b.a.f(10, this.wFL);
      }
      i = paramInt;
      if (this.wFM != null) {
        i = paramInt + e.a.a.b.b.a.f(11, this.wFM);
      }
      AppMethodBeat.o(89052);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(89052);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        uo localuo = (uo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(89052);
          return -1;
        case 1: 
          localuo.title = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89052);
          return 0;
        case 2: 
          localuo.kmn = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89052);
          return 0;
        case 3: 
          localuo.kmo = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89052);
          return 0;
        case 4: 
          localuo.url = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89052);
          return 0;
        case 5: 
          localuo.wGZ = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(89052);
          return 0;
        case 6: 
          localuo.wHa = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89052);
          return 0;
        case 7: 
          localuo.wHb = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89052);
          return 0;
        case 8: 
          localuo.kWy = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89052);
          return 0;
        case 9: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new atg();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((atg)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localuo.wML = ((atg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89052);
          return 0;
        case 10: 
          localuo.wFL = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89052);
          return 0;
        }
        localuo.wFM = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(89052);
        return 0;
      }
      AppMethodBeat.o(89052);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.uo
 * JD-Core Version:    0.7.0.1
 */