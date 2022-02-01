package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class egz
  extends com.tencent.mm.bx.a
{
  public LinkedList<egy> TZE;
  public LinkedList<eww> abmm;
  public String abmn;
  public String abmo;
  
  public egz()
  {
    AppMethodBeat.i(259112);
    this.TZE = new LinkedList();
    this.abmm = new LinkedList();
    AppMethodBeat.o(259112);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259115);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.TZE);
      paramVarArgs.e(2, 8, this.abmm);
      if (this.abmn != null) {
        paramVarArgs.g(3, this.abmn);
      }
      if (this.abmo != null) {
        paramVarArgs.g(4, this.abmo);
      }
      AppMethodBeat.o(259115);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 8, this.TZE) + 0 + i.a.a.a.c(2, 8, this.abmm);
      paramInt = i;
      if (this.abmn != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.abmn);
      }
      i = paramInt;
      if (this.abmo != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.abmo);
      }
      AppMethodBeat.o(259115);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.TZE.clear();
      this.abmm.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259115);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      egz localegz = (egz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(259115);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new egy();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((egy)localObject2).parseFrom((byte[])localObject1);
          }
          localegz.TZE.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(259115);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eww();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eww)localObject2).parseFrom((byte[])localObject1);
          }
          localegz.abmm.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(259115);
        return 0;
      case 3: 
        localegz.abmn = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(259115);
        return 0;
      }
      localegz.abmo = ((i.a.a.a.a)localObject1).ajGk.readString();
      AppMethodBeat.o(259115);
      return 0;
    }
    AppMethodBeat.o(259115);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.egz
 * JD-Core Version:    0.7.0.1
 */