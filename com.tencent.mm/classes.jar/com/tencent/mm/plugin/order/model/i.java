package com.tencent.mm.plugin.order.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class i
  extends com.tencent.mm.bx.a
{
  public int CreateTime;
  public String uiR;
  public String wDA;
  public int wDB;
  public LinkedList<k> wDC;
  public String wDD;
  public String wDE;
  public double wDF;
  public String wDG;
  public String wDo;
  public double wDp;
  public String wDq;
  public String wDr;
  public int wDs;
  public String wDt;
  public int wDu;
  public int wDv;
  public String wDw;
  public String wDx;
  public String wDy;
  public String wDz;
  
  public i()
  {
    AppMethodBeat.i(91261);
    this.wDC = new LinkedList();
    AppMethodBeat.o(91261);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91262);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.wDo != null) {
        paramVarArgs.d(1, this.wDo);
      }
      paramVarArgs.e(2, this.wDp);
      if (this.wDq != null) {
        paramVarArgs.d(3, this.wDq);
      }
      paramVarArgs.aS(4, this.CreateTime);
      if (this.wDr != null) {
        paramVarArgs.d(5, this.wDr);
      }
      paramVarArgs.aS(6, this.wDs);
      if (this.wDt != null) {
        paramVarArgs.d(7, this.wDt);
      }
      paramVarArgs.aS(8, this.wDu);
      paramVarArgs.aS(9, this.wDv);
      if (this.wDw != null) {
        paramVarArgs.d(10, this.wDw);
      }
      if (this.uiR != null) {
        paramVarArgs.d(11, this.uiR);
      }
      if (this.wDx != null) {
        paramVarArgs.d(12, this.wDx);
      }
      if (this.wDy != null) {
        paramVarArgs.d(13, this.wDy);
      }
      if (this.wDz != null) {
        paramVarArgs.d(14, this.wDz);
      }
      if (this.wDA != null) {
        paramVarArgs.d(15, this.wDA);
      }
      paramVarArgs.aS(16, this.wDB);
      paramVarArgs.e(17, 8, this.wDC);
      if (this.wDD != null) {
        paramVarArgs.d(18, this.wDD);
      }
      if (this.wDE != null) {
        paramVarArgs.d(19, this.wDE);
      }
      paramVarArgs.e(20, this.wDF);
      if (this.wDG != null) {
        paramVarArgs.d(21, this.wDG);
      }
      AppMethodBeat.o(91262);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wDo == null) {
        break label1412;
      }
    }
    label1412:
    for (paramInt = f.a.a.b.b.a.e(1, this.wDo) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.alT(2);
      paramInt = i;
      if (this.wDq != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.wDq);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.CreateTime);
      paramInt = i;
      if (this.wDr != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.wDr);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.wDs);
      paramInt = i;
      if (this.wDt != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.wDt);
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.wDu) + f.a.a.b.b.a.bz(9, this.wDv);
      paramInt = i;
      if (this.wDw != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.wDw);
      }
      i = paramInt;
      if (this.uiR != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.uiR);
      }
      paramInt = i;
      if (this.wDx != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.wDx);
      }
      i = paramInt;
      if (this.wDy != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.wDy);
      }
      paramInt = i;
      if (this.wDz != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.wDz);
      }
      i = paramInt;
      if (this.wDA != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.wDA);
      }
      i = i + f.a.a.b.b.a.bz(16, this.wDB) + f.a.a.a.c(17, 8, this.wDC);
      paramInt = i;
      if (this.wDD != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.wDD);
      }
      i = paramInt;
      if (this.wDE != null) {
        i = paramInt + f.a.a.b.b.a.e(19, this.wDE);
      }
      i += f.a.a.b.b.a.alT(20);
      paramInt = i;
      if (this.wDG != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.wDG);
      }
      AppMethodBeat.o(91262);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wDC.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
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
          locali.wDo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 2: 
          locali.wDp = Double.longBitsToDouble(((f.a.a.a.a)localObject1).NPN.grA());
          AppMethodBeat.o(91262);
          return 0;
        case 3: 
          locali.wDq = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 4: 
          locali.CreateTime = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91262);
          return 0;
        case 5: 
          locali.wDr = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 6: 
          locali.wDs = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91262);
          return 0;
        case 7: 
          locali.wDt = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 8: 
          locali.wDu = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91262);
          return 0;
        case 9: 
          locali.wDv = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91262);
          return 0;
        case 10: 
          locali.wDw = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 11: 
          locali.uiR = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 12: 
          locali.wDx = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 13: 
          locali.wDy = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 14: 
          locali.wDz = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 15: 
          locali.wDA = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 16: 
          locali.wDB = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91262);
          return 0;
        case 17: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new k();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((k)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locali.wDC.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91262);
          return 0;
        case 18: 
          locali.wDD = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 19: 
          locali.wDE = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 20: 
          locali.wDF = Double.longBitsToDouble(((f.a.a.a.a)localObject1).NPN.grA());
          AppMethodBeat.o(91262);
          return 0;
        }
        locali.wDG = ((f.a.a.a.a)localObject1).NPN.readString();
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