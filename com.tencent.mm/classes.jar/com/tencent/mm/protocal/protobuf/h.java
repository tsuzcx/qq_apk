package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class h
  extends buy
{
  public int scene;
  public String title;
  public String wjX;
  public LinkedList<j> wkb;
  public aw wkc;
  public long wkd;
  public long wkf;
  
  public h()
  {
    AppMethodBeat.i(56675);
    this.wkb = new LinkedList();
    AppMethodBeat.o(56675);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56676);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.title != null) {
        paramVarArgs.e(2, this.title);
      }
      paramVarArgs.am(3, this.wkf);
      paramVarArgs.e(5, 8, this.wkb);
      paramVarArgs.aO(7, this.scene);
      if (this.wjX != null) {
        paramVarArgs.e(8, this.wjX);
      }
      if (this.wkc != null)
      {
        paramVarArgs.iQ(9, this.wkc.computeSize());
        this.wkc.writeFields(paramVarArgs);
      }
      paramVarArgs.am(10, this.wkd);
      AppMethodBeat.o(56676);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label870;
      }
    }
    label870:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.title != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.title);
      }
      i = i + e.a.a.b.b.a.p(3, this.wkf) + e.a.a.a.c(5, 8, this.wkb) + e.a.a.b.b.a.bl(7, this.scene);
      paramInt = i;
      if (this.wjX != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.wjX);
      }
      i = paramInt;
      if (this.wkc != null) {
        i = paramInt + e.a.a.a.iP(9, this.wkc.computeSize());
      }
      paramInt = e.a.a.b.b.a.p(10, this.wkd);
      AppMethodBeat.o(56676);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wkb.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56676);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        h localh = (h)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 4: 
        case 6: 
        default: 
          AppMethodBeat.o(56676);
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
            localh.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56676);
          return 0;
        case 2: 
          localh.title = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56676);
          return 0;
        case 3: 
          localh.wkf = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(56676);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new j();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((j)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localh.wkb.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56676);
          return 0;
        case 7: 
          localh.scene = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56676);
          return 0;
        case 8: 
          localh.wjX = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56676);
          return 0;
        case 9: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aw();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aw)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localh.wkc = ((aw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56676);
          return 0;
        }
        localh.wkd = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(56676);
        return 0;
      }
      AppMethodBeat.o(56676);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.h
 * JD-Core Version:    0.7.0.1
 */