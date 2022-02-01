package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cwi
  extends ckq
{
  public String Emn;
  public long Emo;
  public int EnA;
  public int EnF;
  public long Enz;
  public int Eoe;
  public String Username;
  public int rNz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125835);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Emn != null) {
        paramVarArgs.d(2, this.Emn);
      }
      if (this.Username != null) {
        paramVarArgs.d(3, this.Username);
      }
      paramVarArgs.aG(4, this.Emo);
      paramVarArgs.aR(5, this.rNz);
      paramVarArgs.aG(6, this.Enz);
      paramVarArgs.aR(7, this.EnA);
      paramVarArgs.aR(8, this.Eoe);
      paramVarArgs.aR(9, this.EnF);
      AppMethodBeat.o(125835);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label714;
      }
    }
    label714:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Emn != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Emn);
      }
      i = paramInt;
      if (this.Username != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Username);
      }
      paramInt = f.a.a.b.b.a.q(4, this.Emo);
      int j = f.a.a.b.b.a.bA(5, this.rNz);
      int k = f.a.a.b.b.a.q(6, this.Enz);
      int m = f.a.a.b.b.a.bA(7, this.EnA);
      int n = f.a.a.b.b.a.bA(8, this.Eoe);
      int i1 = f.a.a.b.b.a.bA(9, this.EnF);
      AppMethodBeat.o(125835);
      return i + paramInt + j + k + m + n + i1;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(125835);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cwi localcwi = (cwi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125835);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcwi.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125835);
          return 0;
        case 2: 
          localcwi.Emn = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125835);
          return 0;
        case 3: 
          localcwi.Username = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125835);
          return 0;
        case 4: 
          localcwi.Emo = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(125835);
          return 0;
        case 5: 
          localcwi.rNz = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125835);
          return 0;
        case 6: 
          localcwi.Enz = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(125835);
          return 0;
        case 7: 
          localcwi.EnA = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125835);
          return 0;
        case 8: 
          localcwi.Eoe = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125835);
          return 0;
        }
        localcwi.EnF = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(125835);
        return 0;
      }
      AppMethodBeat.o(125835);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwi
 * JD-Core Version:    0.7.0.1
 */