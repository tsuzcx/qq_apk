package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cnp
  extends buy
{
  public int aXG;
  public int scene;
  public String session_id;
  public String username;
  public int wAx;
  public int xWA;
  public int xWB;
  public int xWC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96304);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.scene);
      paramVarArgs.aO(3, this.xWA);
      paramVarArgs.aO(4, this.wAx);
      paramVarArgs.aO(5, this.xWB);
      paramVarArgs.aO(6, this.xWC);
      if (this.username != null) {
        paramVarArgs.e(7, this.username);
      }
      paramVarArgs.aO(8, this.aXG);
      if (this.session_id != null) {
        paramVarArgs.e(9, this.session_id);
      }
      AppMethodBeat.o(96304);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label694;
      }
    }
    label694:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.scene) + e.a.a.b.b.a.bl(3, this.xWA) + e.a.a.b.b.a.bl(4, this.wAx) + e.a.a.b.b.a.bl(5, this.xWB) + e.a.a.b.b.a.bl(6, this.xWC);
      paramInt = i;
      if (this.username != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.username);
      }
      i = paramInt + e.a.a.b.b.a.bl(8, this.aXG);
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.session_id);
      }
      AppMethodBeat.o(96304);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(96304);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cnp localcnp = (cnp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(96304);
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
            localcnp.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96304);
          return 0;
        case 2: 
          localcnp.scene = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(96304);
          return 0;
        case 3: 
          localcnp.xWA = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(96304);
          return 0;
        case 4: 
          localcnp.wAx = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(96304);
          return 0;
        case 5: 
          localcnp.xWB = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(96304);
          return 0;
        case 6: 
          localcnp.xWC = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(96304);
          return 0;
        case 7: 
          localcnp.username = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(96304);
          return 0;
        case 8: 
          localcnp.aXG = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(96304);
          return 0;
        }
        localcnp.session_id = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(96304);
        return 0;
      }
      AppMethodBeat.o(96304);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnp
 * JD-Core Version:    0.7.0.1
 */