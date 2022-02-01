package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class biv
  extends com.tencent.mm.cd.a
{
  public int MqM;
  public String RiL;
  public String STc;
  public String STd;
  public int STe;
  public String STf;
  public String STg;
  public avy STh;
  public avs STi;
  public int lZJ;
  public int recommendType;
  public String tBn;
  public bjw xbx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207726);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.tBn != null) {
        paramVarArgs.f(1, this.tBn);
      }
      if (this.STc != null) {
        paramVarArgs.f(2, this.STc);
      }
      if (this.STd != null) {
        paramVarArgs.f(3, this.STd);
      }
      paramVarArgs.aY(4, this.MqM);
      paramVarArgs.aY(5, this.STe);
      if (this.STf != null) {
        paramVarArgs.f(6, this.STf);
      }
      if (this.STg != null) {
        paramVarArgs.f(7, this.STg);
      }
      if (this.RiL != null) {
        paramVarArgs.f(8, this.RiL);
      }
      paramVarArgs.aY(9, this.lZJ);
      if (this.STh != null)
      {
        paramVarArgs.oE(10, this.STh.computeSize());
        this.STh.writeFields(paramVarArgs);
      }
      if (this.xbx != null)
      {
        paramVarArgs.oE(11, this.xbx.computeSize());
        this.xbx.writeFields(paramVarArgs);
      }
      if (this.STi != null)
      {
        paramVarArgs.oE(12, this.STi.computeSize());
        this.STi.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(13, this.recommendType);
      AppMethodBeat.o(207726);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tBn == null) {
        break label1104;
      }
    }
    label1104:
    for (int i = g.a.a.b.b.a.g(1, this.tBn) + 0;; i = 0)
    {
      paramInt = i;
      if (this.STc != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.STc);
      }
      i = paramInt;
      if (this.STd != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.STd);
      }
      i = i + g.a.a.b.b.a.bM(4, this.MqM) + g.a.a.b.b.a.bM(5, this.STe);
      paramInt = i;
      if (this.STf != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.STf);
      }
      i = paramInt;
      if (this.STg != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.STg);
      }
      paramInt = i;
      if (this.RiL != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.RiL);
      }
      i = paramInt + g.a.a.b.b.a.bM(9, this.lZJ);
      paramInt = i;
      if (this.STh != null) {
        paramInt = i + g.a.a.a.oD(10, this.STh.computeSize());
      }
      i = paramInt;
      if (this.xbx != null) {
        i = paramInt + g.a.a.a.oD(11, this.xbx.computeSize());
      }
      paramInt = i;
      if (this.STi != null) {
        paramInt = i + g.a.a.a.oD(12, this.STi.computeSize());
      }
      i = g.a.a.b.b.a.bM(13, this.recommendType);
      AppMethodBeat.o(207726);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(207726);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        biv localbiv = (biv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(207726);
          return -1;
        case 1: 
          localbiv.tBn = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(207726);
          return 0;
        case 2: 
          localbiv.STc = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(207726);
          return 0;
        case 3: 
          localbiv.STd = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(207726);
          return 0;
        case 4: 
          localbiv.MqM = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(207726);
          return 0;
        case 5: 
          localbiv.STe = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(207726);
          return 0;
        case 6: 
          localbiv.STf = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(207726);
          return 0;
        case 7: 
          localbiv.STg = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(207726);
          return 0;
        case 8: 
          localbiv.RiL = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(207726);
          return 0;
        case 9: 
          localbiv.lZJ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(207726);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new avy();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((avy)localObject2).parseFrom((byte[])localObject1);
            }
            localbiv.STh = ((avy)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(207726);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bjw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bjw)localObject2).parseFrom((byte[])localObject1);
            }
            localbiv.xbx = ((bjw)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(207726);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new avs();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((avs)localObject2).parseFrom((byte[])localObject1);
            }
            localbiv.STi = ((avs)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(207726);
          return 0;
        }
        localbiv.recommendType = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(207726);
        return 0;
      }
      AppMethodBeat.o(207726);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.biv
 * JD-Core Version:    0.7.0.1
 */