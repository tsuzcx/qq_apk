package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class dmn
  extends com.tencent.mm.bx.a
{
  public efk Gee;
  public long HAI;
  public long HAJ;
  public long HAK;
  public long HAL;
  public LinkedList<b> HAM;
  public long begin_time;
  public long duration;
  public String text;
  
  public dmn()
  {
    AppMethodBeat.i(110911);
    this.HAM = new LinkedList();
    AppMethodBeat.o(110911);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110912);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gee != null)
      {
        paramVarArgs.lC(1, this.Gee.computeSize());
        this.Gee.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.begin_time);
      paramVarArgs.aY(3, this.duration);
      if (this.text != null) {
        paramVarArgs.d(4, this.text);
      }
      paramVarArgs.aY(5, this.HAI);
      paramVarArgs.aY(6, this.HAJ);
      paramVarArgs.aY(7, this.HAK);
      paramVarArgs.aY(8, this.HAL);
      paramVarArgs.e(9, 6, this.HAM);
      AppMethodBeat.o(110912);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Gee == null) {
        break label710;
      }
    }
    label710:
    for (paramInt = f.a.a.a.lB(1, this.Gee.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.begin_time) + f.a.a.b.b.a.p(3, this.duration);
      paramInt = i;
      if (this.text != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.text);
      }
      i = f.a.a.b.b.a.p(5, this.HAI);
      int j = f.a.a.b.b.a.p(6, this.HAJ);
      int k = f.a.a.b.b.a.p(7, this.HAK);
      int m = f.a.a.b.b.a.p(8, this.HAL);
      int n = f.a.a.a.c(9, 6, this.HAM);
      AppMethodBeat.o(110912);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HAM.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(110912);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dmn localdmn = (dmn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(110912);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new efk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((efk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdmn.Gee = ((efk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(110912);
          return 0;
        case 2: 
          localdmn.begin_time = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(110912);
          return 0;
        case 3: 
          localdmn.duration = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(110912);
          return 0;
        case 4: 
          localdmn.text = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(110912);
          return 0;
        case 5: 
          localdmn.HAI = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(110912);
          return 0;
        case 6: 
          localdmn.HAJ = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(110912);
          return 0;
        case 7: 
          localdmn.HAK = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(110912);
          return 0;
        case 8: 
          localdmn.HAL = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(110912);
          return 0;
        }
        localdmn.HAM.add(((f.a.a.a.a)localObject1).NPN.gxI());
        AppMethodBeat.o(110912);
        return 0;
      }
      AppMethodBeat.o(110912);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmn
 * JD-Core Version:    0.7.0.1
 */