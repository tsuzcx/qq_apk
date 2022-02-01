package com.tencent.mm.plugin.order.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class i
  extends com.tencent.mm.bw.a
{
  public int CreateTime;
  public String tkL;
  public String vxU;
  public double vxV;
  public String vxW;
  public String vxX;
  public int vxY;
  public String vxZ;
  public int vya;
  public int vyb;
  public String vyc;
  public String vyd;
  public String vye;
  public String vyf;
  public String vyg;
  public int vyh;
  public LinkedList<k> vyi;
  public String vyj;
  public String vyk;
  public double vyl;
  public String vym;
  
  public i()
  {
    AppMethodBeat.i(91261);
    this.vyi = new LinkedList();
    AppMethodBeat.o(91261);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91262);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.vxU != null) {
        paramVarArgs.d(1, this.vxU);
      }
      paramVarArgs.e(2, this.vxV);
      if (this.vxW != null) {
        paramVarArgs.d(3, this.vxW);
      }
      paramVarArgs.aR(4, this.CreateTime);
      if (this.vxX != null) {
        paramVarArgs.d(5, this.vxX);
      }
      paramVarArgs.aR(6, this.vxY);
      if (this.vxZ != null) {
        paramVarArgs.d(7, this.vxZ);
      }
      paramVarArgs.aR(8, this.vya);
      paramVarArgs.aR(9, this.vyb);
      if (this.vyc != null) {
        paramVarArgs.d(10, this.vyc);
      }
      if (this.tkL != null) {
        paramVarArgs.d(11, this.tkL);
      }
      if (this.vyd != null) {
        paramVarArgs.d(12, this.vyd);
      }
      if (this.vye != null) {
        paramVarArgs.d(13, this.vye);
      }
      if (this.vyf != null) {
        paramVarArgs.d(14, this.vyf);
      }
      if (this.vyg != null) {
        paramVarArgs.d(15, this.vyg);
      }
      paramVarArgs.aR(16, this.vyh);
      paramVarArgs.e(17, 8, this.vyi);
      if (this.vyj != null) {
        paramVarArgs.d(18, this.vyj);
      }
      if (this.vyk != null) {
        paramVarArgs.d(19, this.vyk);
      }
      paramVarArgs.e(20, this.vyl);
      if (this.vym != null) {
        paramVarArgs.d(21, this.vym);
      }
      AppMethodBeat.o(91262);
      return 0;
    }
    if (paramInt == 1) {
      if (this.vxU == null) {
        break label1416;
      }
    }
    label1416:
    for (paramInt = f.a.a.b.b.a.e(1, this.vxU) + 0;; paramInt = 0)
    {
      int i = paramInt + (f.a.a.b.b.a.fK(2) + 8);
      paramInt = i;
      if (this.vxW != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.vxW);
      }
      i = paramInt + f.a.a.b.b.a.bx(4, this.CreateTime);
      paramInt = i;
      if (this.vxX != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.vxX);
      }
      i = paramInt + f.a.a.b.b.a.bx(6, this.vxY);
      paramInt = i;
      if (this.vxZ != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.vxZ);
      }
      i = paramInt + f.a.a.b.b.a.bx(8, this.vya) + f.a.a.b.b.a.bx(9, this.vyb);
      paramInt = i;
      if (this.vyc != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.vyc);
      }
      i = paramInt;
      if (this.tkL != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.tkL);
      }
      paramInt = i;
      if (this.vyd != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.vyd);
      }
      i = paramInt;
      if (this.vye != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.vye);
      }
      paramInt = i;
      if (this.vyf != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.vyf);
      }
      i = paramInt;
      if (this.vyg != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.vyg);
      }
      i = i + f.a.a.b.b.a.bx(16, this.vyh) + f.a.a.a.c(17, 8, this.vyi);
      paramInt = i;
      if (this.vyj != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.vyj);
      }
      i = paramInt;
      if (this.vyk != null) {
        i = paramInt + f.a.a.b.b.a.e(19, this.vyk);
      }
      i += f.a.a.b.b.a.fK(20) + 8;
      paramInt = i;
      if (this.vym != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.vym);
      }
      AppMethodBeat.o(91262);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.vyi.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91262);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        i locali = (i)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91262);
          return -1;
        case 1: 
          locali.vxU = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 2: 
          locali.vxV = Double.longBitsToDouble(((f.a.a.a.a)localObject1).LVo.gab());
          AppMethodBeat.o(91262);
          return 0;
        case 3: 
          locali.vxW = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 4: 
          locali.CreateTime = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91262);
          return 0;
        case 5: 
          locali.vxX = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 6: 
          locali.vxY = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91262);
          return 0;
        case 7: 
          locali.vxZ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 8: 
          locali.vya = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91262);
          return 0;
        case 9: 
          locali.vyb = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91262);
          return 0;
        case 10: 
          locali.vyc = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 11: 
          locali.tkL = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 12: 
          locali.vyd = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 13: 
          locali.vye = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 14: 
          locali.vyf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 15: 
          locali.vyg = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 16: 
          locali.vyh = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91262);
          return 0;
        case 17: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new k();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((k)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locali.vyi.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91262);
          return 0;
        case 18: 
          locali.vyj = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 19: 
          locali.vyk = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 20: 
          locali.vyl = Double.longBitsToDouble(((f.a.a.a.a)localObject1).LVo.gab());
          AppMethodBeat.o(91262);
          return 0;
        }
        locali.vym = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91262);
        return 0;
      }
      AppMethodBeat.o(91262);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.i
 * JD-Core Version:    0.7.0.1
 */