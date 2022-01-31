package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bhx
  extends com.tencent.mm.bv.a
{
  public String app_id;
  public String gfM;
  public int oDM;
  public bhz xdA;
  public int xdz;
  public int xwV;
  public bhy xwW;
  public int xwX;
  public int xwY;
  public int xwZ;
  public int xxa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80125);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.gfM != null) {
        paramVarArgs.e(1, this.gfM);
      }
      paramVarArgs.aO(2, this.xwV);
      if (this.xwW != null)
      {
        paramVarArgs.iQ(3, this.xwW.computeSize());
        this.xwW.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(4, this.xdz);
      if (this.xdA != null)
      {
        paramVarArgs.iQ(5, this.xdA.computeSize());
        this.xdA.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(6, this.xwX);
      paramVarArgs.aO(7, this.xwY);
      paramVarArgs.aO(8, this.oDM);
      paramVarArgs.aO(9, this.xwZ);
      if (this.app_id != null) {
        paramVarArgs.e(10, this.app_id);
      }
      paramVarArgs.aO(11, this.xxa);
      AppMethodBeat.o(80125);
      return 0;
    }
    if (paramInt == 1) {
      if (this.gfM == null) {
        break label898;
      }
    }
    label898:
    for (paramInt = e.a.a.b.b.a.f(1, this.gfM) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.xwV);
      paramInt = i;
      if (this.xwW != null) {
        paramInt = i + e.a.a.a.iP(3, this.xwW.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(4, this.xdz);
      paramInt = i;
      if (this.xdA != null) {
        paramInt = i + e.a.a.a.iP(5, this.xdA.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(6, this.xwX) + e.a.a.b.b.a.bl(7, this.xwY) + e.a.a.b.b.a.bl(8, this.oDM) + e.a.a.b.b.a.bl(9, this.xwZ);
      paramInt = i;
      if (this.app_id != null) {
        paramInt = i + e.a.a.b.b.a.f(10, this.app_id);
      }
      i = e.a.a.b.b.a.bl(11, this.xxa);
      AppMethodBeat.o(80125);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(80125);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bhx localbhx = (bhx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(80125);
          return -1;
        case 1: 
          localbhx.gfM = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80125);
          return 0;
        case 2: 
          localbhx.xwV = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80125);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bhy();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bhy)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbhx.xwW = ((bhy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80125);
          return 0;
        case 4: 
          localbhx.xdz = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80125);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bhz();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bhz)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbhx.xdA = ((bhz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80125);
          return 0;
        case 6: 
          localbhx.xwX = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80125);
          return 0;
        case 7: 
          localbhx.xwY = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80125);
          return 0;
        case 8: 
          localbhx.oDM = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80125);
          return 0;
        case 9: 
          localbhx.xwZ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80125);
          return 0;
        case 10: 
          localbhx.app_id = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80125);
          return 0;
        }
        localbhx.xxa = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(80125);
        return 0;
      }
      AppMethodBeat.o(80125);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhx
 * JD-Core Version:    0.7.0.1
 */