package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class car
  extends cvw
{
  public int FNu;
  public LinkedList<cat> FUY;
  public int Hop;
  public LinkedList<caq> Hoq;
  public int Hor;
  public String Hos;
  public int Scene;
  
  public car()
  {
    AppMethodBeat.i(127498);
    this.Hoq = new LinkedList();
    this.FUY = new LinkedList();
    AppMethodBeat.o(127498);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127499);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.FNu);
      paramVarArgs.aS(3, this.Hop);
      paramVarArgs.e(4, 8, this.Hoq);
      paramVarArgs.aS(5, this.Hor);
      paramVarArgs.e(6, 8, this.FUY);
      if (this.Hos != null) {
        paramVarArgs.d(7, this.Hos);
      }
      paramVarArgs.aS(8, this.Scene);
      AppMethodBeat.o(127499);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label826;
      }
    }
    label826:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.FNu) + f.a.a.b.b.a.bz(3, this.Hop) + f.a.a.a.c(4, 8, this.Hoq) + f.a.a.b.b.a.bz(5, this.Hor) + f.a.a.a.c(6, 8, this.FUY);
      paramInt = i;
      if (this.Hos != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Hos);
      }
      i = f.a.a.b.b.a.bz(8, this.Scene);
      AppMethodBeat.o(127499);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Hoq.clear();
        this.FUY.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(127499);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        car localcar = (car)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127499);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcar.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(127499);
          return 0;
        case 2: 
          localcar.FNu = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(127499);
          return 0;
        case 3: 
          localcar.Hop = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(127499);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new caq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((caq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcar.Hoq.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(127499);
          return 0;
        case 5: 
          localcar.Hor = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(127499);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cat();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cat)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcar.FUY.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(127499);
          return 0;
        case 7: 
          localcar.Hos = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(127499);
          return 0;
        }
        localcar.Scene = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(127499);
        return 0;
      }
      AppMethodBeat.o(127499);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.car
 * JD-Core Version:    0.7.0.1
 */