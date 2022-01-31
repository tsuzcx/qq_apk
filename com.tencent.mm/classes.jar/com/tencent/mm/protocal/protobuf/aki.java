package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aki
  extends buy
{
  public String kWn;
  public String person_id;
  public int scene;
  public String wKp;
  public bkx xaW;
  public int xbB;
  public String xbC;
  public String xbD;
  public String xby;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(849);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.person_id != null) {
        paramVarArgs.e(2, this.person_id);
      }
      if (this.xby != null) {
        paramVarArgs.e(3, this.xby);
      }
      paramVarArgs.aO(4, this.xbB);
      if (this.xbC != null) {
        paramVarArgs.e(5, this.xbC);
      }
      if (this.xbD != null) {
        paramVarArgs.e(6, this.xbD);
      }
      paramVarArgs.aO(7, this.scene);
      if (this.wKp != null) {
        paramVarArgs.e(8, this.wKp);
      }
      if (this.kWn != null) {
        paramVarArgs.e(9, this.kWn);
      }
      if (this.xaW != null)
      {
        paramVarArgs.iQ(10, this.xaW.computeSize());
        this.xaW.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(849);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label938;
      }
    }
    label938:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.person_id != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.person_id);
      }
      i = paramInt;
      if (this.xby != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.xby);
      }
      i += e.a.a.b.b.a.bl(4, this.xbB);
      paramInt = i;
      if (this.xbC != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.xbC);
      }
      i = paramInt;
      if (this.xbD != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.xbD);
      }
      i += e.a.a.b.b.a.bl(7, this.scene);
      paramInt = i;
      if (this.wKp != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.wKp);
      }
      i = paramInt;
      if (this.kWn != null) {
        i = paramInt + e.a.a.b.b.a.f(9, this.kWn);
      }
      paramInt = i;
      if (this.xaW != null) {
        paramInt = i + e.a.a.a.iP(10, this.xaW.computeSize());
      }
      AppMethodBeat.o(849);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(849);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        aki localaki = (aki)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(849);
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
            localaki.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(849);
          return 0;
        case 2: 
          localaki.person_id = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(849);
          return 0;
        case 3: 
          localaki.xby = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(849);
          return 0;
        case 4: 
          localaki.xbB = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(849);
          return 0;
        case 5: 
          localaki.xbC = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(849);
          return 0;
        case 6: 
          localaki.xbD = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(849);
          return 0;
        case 7: 
          localaki.scene = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(849);
          return 0;
        case 8: 
          localaki.wKp = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(849);
          return 0;
        case 9: 
          localaki.kWn = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(849);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bkx();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bkx)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localaki.xaW = ((bkx)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(849);
        return 0;
      }
      AppMethodBeat.o(849);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aki
 * JD-Core Version:    0.7.0.1
 */