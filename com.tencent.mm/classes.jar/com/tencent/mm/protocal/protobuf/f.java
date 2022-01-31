package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class f
  extends buy
{
  public int scene;
  public String title;
  public String wjX;
  public int wjZ;
  public long wka;
  public LinkedList<String> wkb;
  public aw wkc;
  public long wkd;
  
  public f()
  {
    AppMethodBeat.i(56672);
    this.wkb = new LinkedList();
    AppMethodBeat.o(56672);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56673);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.wjZ);
      paramVarArgs.am(3, this.wka);
      if (this.title != null) {
        paramVarArgs.e(4, this.title);
      }
      paramVarArgs.e(5, 1, this.wkb);
      paramVarArgs.aO(6, this.scene);
      if (this.wjX != null) {
        paramVarArgs.e(7, this.wjX);
      }
      if (this.wkc != null)
      {
        paramVarArgs.iQ(8, this.wkc.computeSize());
        this.wkc.writeFields(paramVarArgs);
      }
      paramVarArgs.am(9, this.wkd);
      AppMethodBeat.o(56673);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label822;
      }
    }
    label822:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.wjZ) + e.a.a.b.b.a.p(3, this.wka);
      paramInt = i;
      if (this.title != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.title);
      }
      i = paramInt + e.a.a.a.c(5, 1, this.wkb) + e.a.a.b.b.a.bl(6, this.scene);
      paramInt = i;
      if (this.wjX != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.wjX);
      }
      i = paramInt;
      if (this.wkc != null) {
        i = paramInt + e.a.a.a.iP(8, this.wkc.computeSize());
      }
      paramInt = e.a.a.b.b.a.p(9, this.wkd);
      AppMethodBeat.o(56673);
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
        AppMethodBeat.o(56673);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        f localf = (f)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56673);
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
            localf.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56673);
          return 0;
        case 2: 
          localf.wjZ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56673);
          return 0;
        case 3: 
          localf.wka = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(56673);
          return 0;
        case 4: 
          localf.title = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56673);
          return 0;
        case 5: 
          localf.wkb.add(((e.a.a.a.a)localObject1).CLY.readString());
          AppMethodBeat.o(56673);
          return 0;
        case 6: 
          localf.scene = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56673);
          return 0;
        case 7: 
          localf.wjX = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56673);
          return 0;
        case 8: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aw();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aw)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localf.wkc = ((aw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56673);
          return 0;
        }
        localf.wkd = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(56673);
        return 0;
      }
      AppMethodBeat.o(56673);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.f
 * JD-Core Version:    0.7.0.1
 */