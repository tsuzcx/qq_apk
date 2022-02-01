package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class akc
  extends com.tencent.mm.bx.a
{
  public int Zrj;
  public LinkedList<aek> Zrk;
  public String title;
  public String wsz;
  
  public akc()
  {
    AppMethodBeat.i(113996);
    this.Zrk = new LinkedList();
    AppMethodBeat.o(113996);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113997);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.g(1, this.title);
      }
      if (this.wsz != null) {
        paramVarArgs.g(2, this.wsz);
      }
      paramVarArgs.bS(3, this.Zrj);
      paramVarArgs.e(4, 8, this.Zrk);
      AppMethodBeat.o(113997);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label440;
      }
    }
    label440:
    for (paramInt = i.a.a.b.b.a.h(1, this.title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wsz != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.wsz);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.Zrj);
      int j = i.a.a.a.c(4, 8, this.Zrk);
      AppMethodBeat.o(113997);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Zrk.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(113997);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        akc localakc = (akc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113997);
          return -1;
        case 1: 
          localakc.title = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(113997);
          return 0;
        case 2: 
          localakc.wsz = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(113997);
          return 0;
        case 3: 
          localakc.Zrj = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(113997);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          aek localaek = new aek();
          if ((localObject != null) && (localObject.length > 0)) {
            localaek.parseFrom((byte[])localObject);
          }
          localakc.Zrk.add(localaek);
          paramInt += 1;
        }
        AppMethodBeat.o(113997);
        return 0;
      }
      AppMethodBeat.o(113997);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akc
 * JD-Core Version:    0.7.0.1
 */