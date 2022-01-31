package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bzd
  extends buy
{
  public String Name;
  public String nqz;
  public String ped;
  public String woO;
  public String xLg;
  public String xLh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(73758);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.nqz != null) {
        paramVarArgs.e(2, this.nqz);
      }
      if (this.xLg != null) {
        paramVarArgs.e(3, this.xLg);
      }
      if (this.ped != null) {
        paramVarArgs.e(5, this.ped);
      }
      if (this.Name != null) {
        paramVarArgs.e(4, this.Name);
      }
      if (this.woO != null) {
        paramVarArgs.e(6, this.woO);
      }
      if (this.xLh != null) {
        paramVarArgs.e(7, this.xLh);
      }
      AppMethodBeat.o(73758);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label674;
      }
    }
    label674:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nqz != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.nqz);
      }
      i = paramInt;
      if (this.xLg != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.xLg);
      }
      paramInt = i;
      if (this.ped != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.ped);
      }
      i = paramInt;
      if (this.Name != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.Name);
      }
      paramInt = i;
      if (this.woO != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.woO);
      }
      i = paramInt;
      if (this.xLh != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.xLh);
      }
      AppMethodBeat.o(73758);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(73758);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bzd localbzd = (bzd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(73758);
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
            localbzd.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(73758);
          return 0;
        case 2: 
          localbzd.nqz = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(73758);
          return 0;
        case 3: 
          localbzd.xLg = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(73758);
          return 0;
        case 5: 
          localbzd.ped = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(73758);
          return 0;
        case 4: 
          localbzd.Name = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(73758);
          return 0;
        case 6: 
          localbzd.woO = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(73758);
          return 0;
        }
        localbzd.xLh = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(73758);
        return 0;
      }
      AppMethodBeat.o(73758);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzd
 * JD-Core Version:    0.7.0.1
 */