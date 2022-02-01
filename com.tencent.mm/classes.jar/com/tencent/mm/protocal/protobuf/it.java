package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class it
  extends com.tencent.mm.bx.a
{
  public LinkedList<agv> FBK;
  public String FBL;
  public String FBM;
  public String dkR;
  public String uJF;
  public String xSd;
  public int xSe;
  public int xSf;
  public String xSg;
  public String xSh;
  public String xSi;
  public long xSl;
  
  public it()
  {
    AppMethodBeat.i(72420);
    this.FBK = new LinkedList();
    AppMethodBeat.o(72420);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72421);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dkR != null) {
        paramVarArgs.d(1, this.dkR);
      }
      if (this.uJF != null) {
        paramVarArgs.d(2, this.uJF);
      }
      if (this.xSd != null) {
        paramVarArgs.d(3, this.xSd);
      }
      paramVarArgs.aS(4, this.xSe);
      paramVarArgs.aS(5, this.xSf);
      paramVarArgs.e(6, 8, this.FBK);
      if (this.xSg != null) {
        paramVarArgs.d(7, this.xSg);
      }
      if (this.xSh != null) {
        paramVarArgs.d(8, this.xSh);
      }
      if (this.xSi != null) {
        paramVarArgs.d(9, this.xSi);
      }
      if (this.FBL != null) {
        paramVarArgs.d(10, this.FBL);
      }
      if (this.FBM != null) {
        paramVarArgs.d(11, this.FBM);
      }
      paramVarArgs.aY(12, this.xSl);
      AppMethodBeat.o(72421);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dkR == null) {
        break label918;
      }
    }
    label918:
    for (int i = f.a.a.b.b.a.e(1, this.dkR) + 0;; i = 0)
    {
      paramInt = i;
      if (this.uJF != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.uJF);
      }
      i = paramInt;
      if (this.xSd != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.xSd);
      }
      i = i + f.a.a.b.b.a.bz(4, this.xSe) + f.a.a.b.b.a.bz(5, this.xSf) + f.a.a.a.c(6, 8, this.FBK);
      paramInt = i;
      if (this.xSg != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.xSg);
      }
      i = paramInt;
      if (this.xSh != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.xSh);
      }
      paramInt = i;
      if (this.xSi != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.xSi);
      }
      i = paramInt;
      if (this.FBL != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.FBL);
      }
      paramInt = i;
      if (this.FBM != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.FBM);
      }
      i = f.a.a.b.b.a.p(12, this.xSl);
      AppMethodBeat.o(72421);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FBK.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(72421);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        it localit = (it)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72421);
          return -1;
        case 1: 
          localit.dkR = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72421);
          return 0;
        case 2: 
          localit.uJF = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72421);
          return 0;
        case 3: 
          localit.xSd = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72421);
          return 0;
        case 4: 
          localit.xSe = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72421);
          return 0;
        case 5: 
          localit.xSf = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72421);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new agv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((agv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localit.FBK.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72421);
          return 0;
        case 7: 
          localit.xSg = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72421);
          return 0;
        case 8: 
          localit.xSh = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72421);
          return 0;
        case 9: 
          localit.xSi = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72421);
          return 0;
        case 10: 
          localit.FBL = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72421);
          return 0;
        case 11: 
          localit.FBM = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72421);
          return 0;
        }
        localit.xSl = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(72421);
        return 0;
      }
      AppMethodBeat.o(72421);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.it
 * JD-Core Version:    0.7.0.1
 */