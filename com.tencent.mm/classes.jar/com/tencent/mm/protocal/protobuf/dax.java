package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dax
  extends com.tencent.mm.bx.a
{
  public LinkedList<daz> aaGs;
  public int rid;
  public String uuid;
  
  public dax()
  {
    AppMethodBeat.i(82427);
    this.aaGs = new LinkedList();
    AppMethodBeat.o(82427);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82428);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.uuid != null) {
        paramVarArgs.g(1, this.uuid);
      }
      paramVarArgs.bS(2, this.rid);
      paramVarArgs.e(3, 8, this.aaGs);
      AppMethodBeat.o(82428);
      return 0;
    }
    if (paramInt == 1) {
      if (this.uuid == null) {
        break label380;
      }
    }
    label380:
    for (paramInt = i.a.a.b.b.a.h(1, this.uuid) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.rid);
      int j = i.a.a.a.c(3, 8, this.aaGs);
      AppMethodBeat.o(82428);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaGs.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(82428);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dax localdax = (dax)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82428);
          return -1;
        case 1: 
          localdax.uuid = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82428);
          return 0;
        case 2: 
          localdax.rid = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(82428);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          daz localdaz = new daz();
          if ((localObject != null) && (localObject.length > 0)) {
            localdaz.parseFrom((byte[])localObject);
          }
          localdax.aaGs.add(localdaz);
          paramInt += 1;
        }
        AppMethodBeat.o(82428);
        return 0;
      }
      AppMethodBeat.o(82428);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dax
 * JD-Core Version:    0.7.0.1
 */