package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class adm
  extends com.tencent.mm.bv.a
{
  public adn field_area_info;
  public int ujI;
  public String wWy;
  public String wWz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(142605);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.ujI);
      if (this.field_area_info != null)
      {
        paramVarArgs.iQ(2, this.field_area_info.computeSize());
        this.field_area_info.writeFields(paramVarArgs);
      }
      if (this.wWy != null) {
        paramVarArgs.e(3, this.wWy);
      }
      if (this.wWz != null) {
        paramVarArgs.e(4, this.wWz);
      }
      AppMethodBeat.o(142605);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.ujI) + 0;
      paramInt = i;
      if (this.field_area_info != null) {
        paramInt = i + e.a.a.a.iP(2, this.field_area_info.computeSize());
      }
      i = paramInt;
      if (this.wWy != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wWy);
      }
      paramInt = i;
      if (this.wWz != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wWz);
      }
      AppMethodBeat.o(142605);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(142605);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      adm localadm = (adm)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(142605);
        return -1;
      case 1: 
        localadm.ujI = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(142605);
        return 0;
      case 2: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new adn();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((adn)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localadm.field_area_info = ((adn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(142605);
        return 0;
      case 3: 
        localadm.wWy = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(142605);
        return 0;
      }
      localadm.wWz = ((e.a.a.a.a)localObject1).CLY.readString();
      AppMethodBeat.o(142605);
      return 0;
    }
    AppMethodBeat.o(142605);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adm
 * JD-Core Version:    0.7.0.1
 */