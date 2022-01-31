package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ak
  extends buy
{
  public int cHp;
  public String wlF;
  public String wlG;
  public int wlH;
  public LinkedList<ot> wlK;
  
  public ak()
  {
    AppMethodBeat.i(88995);
    this.wlK = new LinkedList();
    AppMethodBeat.o(88995);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(88996);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.wlK);
      paramVarArgs.aO(3, this.cHp);
      if (this.wlF != null) {
        paramVarArgs.e(4, this.wlF);
      }
      if (this.wlG != null) {
        paramVarArgs.e(5, this.wlG);
      }
      paramVarArgs.aO(6, this.wlH);
      AppMethodBeat.o(88996);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label658;
      }
    }
    label658:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.a.c(2, 8, this.wlK) + e.a.a.b.b.a.bl(3, this.cHp);
      paramInt = i;
      if (this.wlF != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wlF);
      }
      i = paramInt;
      if (this.wlG != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.wlG);
      }
      paramInt = e.a.a.b.b.a.bl(6, this.wlH);
      AppMethodBeat.o(88996);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wlK.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(88996);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        ak localak = (ak)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(88996);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localak.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(88996);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ot();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ot)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localak.wlK.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(88996);
          return 0;
        case 3: 
          localak.cHp = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(88996);
          return 0;
        case 4: 
          localak.wlF = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(88996);
          return 0;
        case 5: 
          localak.wlG = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(88996);
          return 0;
        }
        localak.wlH = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(88996);
        return 0;
      }
      AppMethodBeat.o(88996);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ak
 * JD-Core Version:    0.7.0.1
 */