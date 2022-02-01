package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class asz
  extends com.tencent.mm.bx.a
{
  public LinkedList<ata> ZDA;
  public String ZDz;
  public String desc;
  public String title;
  
  public asz()
  {
    AppMethodBeat.i(91463);
    this.ZDA = new LinkedList();
    AppMethodBeat.o(91463);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91464);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.g(1, this.title);
      }
      if (this.ZDz != null) {
        paramVarArgs.g(2, this.ZDz);
      }
      paramVarArgs.e(3, 8, this.ZDA);
      if (this.desc != null) {
        paramVarArgs.g(4, this.desc);
      }
      AppMethodBeat.o(91464);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label452;
      }
    }
    label452:
    for (paramInt = i.a.a.b.b.a.h(1, this.title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ZDz != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.ZDz);
      }
      i += i.a.a.a.c(3, 8, this.ZDA);
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.desc);
      }
      AppMethodBeat.o(91464);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZDA.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91464);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        asz localasz = (asz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91464);
          return -1;
        case 1: 
          localasz.title = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91464);
          return 0;
        case 2: 
          localasz.ZDz = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91464);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            ata localata = new ata();
            if ((localObject != null) && (localObject.length > 0)) {
              localata.parseFrom((byte[])localObject);
            }
            localasz.ZDA.add(localata);
            paramInt += 1;
          }
          AppMethodBeat.o(91464);
          return 0;
        }
        localasz.desc = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91464);
        return 0;
      }
      AppMethodBeat.o(91464);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.asz
 * JD-Core Version:    0.7.0.1
 */