package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bfb
  extends buy
{
  public long cNd;
  public int eel;
  public String poq;
  public String ppo;
  public String wpe;
  public String wpf;
  public int wpg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56860);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.wpg);
      if (this.poq != null) {
        paramVarArgs.e(3, this.poq);
      }
      if (this.ppo != null) {
        paramVarArgs.e(4, this.ppo);
      }
      if (this.wpe != null) {
        paramVarArgs.e(5, this.wpe);
      }
      paramVarArgs.am(6, this.cNd);
      paramVarArgs.aO(7, this.eel);
      if (this.wpf != null) {
        paramVarArgs.e(8, this.wpf);
      }
      AppMethodBeat.o(56860);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label686;
      }
    }
    label686:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.wpg);
      paramInt = i;
      if (this.poq != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.poq);
      }
      i = paramInt;
      if (this.ppo != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.ppo);
      }
      paramInt = i;
      if (this.wpe != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.wpe);
      }
      i = paramInt + e.a.a.b.b.a.p(6, this.cNd) + e.a.a.b.b.a.bl(7, this.eel);
      paramInt = i;
      if (this.wpf != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.wpf);
      }
      AppMethodBeat.o(56860);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56860);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bfb localbfb = (bfb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56860);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((hq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbfb.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56860);
          return 0;
        case 2: 
          localbfb.wpg = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56860);
          return 0;
        case 3: 
          localbfb.poq = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56860);
          return 0;
        case 4: 
          localbfb.ppo = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56860);
          return 0;
        case 5: 
          localbfb.wpe = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56860);
          return 0;
        case 6: 
          localbfb.cNd = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(56860);
          return 0;
        case 7: 
          localbfb.eel = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56860);
          return 0;
        }
        localbfb.wpf = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56860);
        return 0;
      }
      AppMethodBeat.o(56860);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfb
 * JD-Core Version:    0.7.0.1
 */