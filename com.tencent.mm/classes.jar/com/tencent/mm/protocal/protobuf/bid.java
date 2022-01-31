package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bid
  extends com.tencent.mm.bv.a
{
  public String app_id;
  public int cpt;
  public int dqC;
  public String gfL;
  public String hKa;
  public String nickname;
  public int type;
  public String wpd;
  public String xxb;
  public String xxc;
  public String xxm;
  public String xxo;
  public String xxp;
  public String xxq;
  public String xxr;
  public bie xxs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80132);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.gfL != null) {
        paramVarArgs.e(1, this.gfL);
      }
      if (this.nickname != null) {
        paramVarArgs.e(2, this.nickname);
      }
      paramVarArgs.aO(3, this.type);
      if (this.hKa != null) {
        paramVarArgs.e(4, this.hKa);
      }
      if (this.xxb != null) {
        paramVarArgs.e(5, this.xxb);
      }
      if (this.xxc != null) {
        paramVarArgs.e(6, this.xxc);
      }
      paramVarArgs.aO(7, this.cpt);
      if (this.xxo != null) {
        paramVarArgs.e(8, this.xxo);
      }
      if (this.xxp != null) {
        paramVarArgs.e(9, this.xxp);
      }
      if (this.xxq != null) {
        paramVarArgs.e(10, this.xxq);
      }
      if (this.xxr != null) {
        paramVarArgs.e(11, this.xxr);
      }
      if (this.xxs != null)
      {
        paramVarArgs.iQ(12, this.xxs.computeSize());
        this.xxs.writeFields(paramVarArgs);
      }
      if (this.wpd != null) {
        paramVarArgs.e(13, this.wpd);
      }
      if (this.app_id != null) {
        paramVarArgs.e(14, this.app_id);
      }
      paramVarArgs.aO(15, this.dqC);
      if (this.xxm != null) {
        paramVarArgs.e(16, this.xxm);
      }
      AppMethodBeat.o(80132);
      return 0;
    }
    if (paramInt == 1) {
      if (this.gfL == null) {
        break label1186;
      }
    }
    label1186:
    for (paramInt = e.a.a.b.b.a.f(1, this.gfL) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nickname != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.nickname);
      }
      i += e.a.a.b.b.a.bl(3, this.type);
      paramInt = i;
      if (this.hKa != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.hKa);
      }
      i = paramInt;
      if (this.xxb != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.xxb);
      }
      paramInt = i;
      if (this.xxc != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.xxc);
      }
      i = paramInt + e.a.a.b.b.a.bl(7, this.cpt);
      paramInt = i;
      if (this.xxo != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.xxo);
      }
      i = paramInt;
      if (this.xxp != null) {
        i = paramInt + e.a.a.b.b.a.f(9, this.xxp);
      }
      paramInt = i;
      if (this.xxq != null) {
        paramInt = i + e.a.a.b.b.a.f(10, this.xxq);
      }
      i = paramInt;
      if (this.xxr != null) {
        i = paramInt + e.a.a.b.b.a.f(11, this.xxr);
      }
      paramInt = i;
      if (this.xxs != null) {
        paramInt = i + e.a.a.a.iP(12, this.xxs.computeSize());
      }
      i = paramInt;
      if (this.wpd != null) {
        i = paramInt + e.a.a.b.b.a.f(13, this.wpd);
      }
      paramInt = i;
      if (this.app_id != null) {
        paramInt = i + e.a.a.b.b.a.f(14, this.app_id);
      }
      i = paramInt + e.a.a.b.b.a.bl(15, this.dqC);
      paramInt = i;
      if (this.xxm != null) {
        paramInt = i + e.a.a.b.b.a.f(16, this.xxm);
      }
      AppMethodBeat.o(80132);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(80132);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bid localbid = (bid)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(80132);
          return -1;
        case 1: 
          localbid.gfL = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80132);
          return 0;
        case 2: 
          localbid.nickname = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80132);
          return 0;
        case 3: 
          localbid.type = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80132);
          return 0;
        case 4: 
          localbid.hKa = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80132);
          return 0;
        case 5: 
          localbid.xxb = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80132);
          return 0;
        case 6: 
          localbid.xxc = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80132);
          return 0;
        case 7: 
          localbid.cpt = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80132);
          return 0;
        case 8: 
          localbid.xxo = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80132);
          return 0;
        case 9: 
          localbid.xxp = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80132);
          return 0;
        case 10: 
          localbid.xxq = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80132);
          return 0;
        case 11: 
          localbid.xxr = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80132);
          return 0;
        case 12: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bie();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((bie)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbid.xxs = ((bie)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80132);
          return 0;
        case 13: 
          localbid.wpd = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80132);
          return 0;
        case 14: 
          localbid.app_id = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80132);
          return 0;
        case 15: 
          localbid.dqC = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80132);
          return 0;
        }
        localbid.xxm = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(80132);
        return 0;
      }
      AppMethodBeat.o(80132);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bid
 * JD-Core Version:    0.7.0.1
 */