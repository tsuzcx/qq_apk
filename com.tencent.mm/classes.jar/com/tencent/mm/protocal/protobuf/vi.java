package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class vi
  extends com.tencent.mm.bv.a
{
  public String Desc;
  public String Title;
  public String Url;
  public int wNZ;
  public LinkedList<bcs> wOa;
  public int wOb;
  public String wOc;
  public bbs wOd;
  
  public vi()
  {
    AppMethodBeat.i(94516);
    this.wOa = new LinkedList();
    AppMethodBeat.o(94516);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94517);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Desc != null) {
        paramVarArgs.e(1, this.Desc);
      }
      paramVarArgs.aO(2, this.wNZ);
      if (this.Title != null) {
        paramVarArgs.e(3, this.Title);
      }
      if (this.Url != null) {
        paramVarArgs.e(4, this.Url);
      }
      paramVarArgs.e(5, 8, this.wOa);
      paramVarArgs.aO(6, this.wOb);
      if (this.wOc != null) {
        paramVarArgs.e(7, this.wOc);
      }
      if (this.wOd != null)
      {
        paramVarArgs.iQ(8, this.wOd.computeSize());
        this.wOd.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(94517);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Desc == null) {
        break label782;
      }
    }
    label782:
    for (paramInt = e.a.a.b.b.a.f(1, this.Desc) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.wNZ);
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.Title);
      }
      i = paramInt;
      if (this.Url != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.Url);
      }
      i = i + e.a.a.a.c(5, 8, this.wOa) + e.a.a.b.b.a.bl(6, this.wOb);
      paramInt = i;
      if (this.wOc != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.wOc);
      }
      i = paramInt;
      if (this.wOd != null) {
        i = paramInt + e.a.a.a.iP(8, this.wOd.computeSize());
      }
      AppMethodBeat.o(94517);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wOa.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(94517);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        vi localvi = (vi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(94517);
          return -1;
        case 1: 
          localvi.Desc = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94517);
          return 0;
        case 2: 
          localvi.wNZ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94517);
          return 0;
        case 3: 
          localvi.Title = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94517);
          return 0;
        case 4: 
          localvi.Url = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94517);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bcs();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bcs)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localvi.wOa.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94517);
          return 0;
        case 6: 
          localvi.wOb = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94517);
          return 0;
        case 7: 
          localvi.wOc = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94517);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bbs();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bbs)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localvi.wOd = ((bbs)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(94517);
        return 0;
      }
      AppMethodBeat.o(94517);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vi
 * JD-Core Version:    0.7.0.1
 */