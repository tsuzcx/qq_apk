package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class egx
  extends com.tencent.mm.bx.a
{
  public FinderObject EDa;
  public b abml;
  public String id;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259090);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.id != null) {
        paramVarArgs.g(1, this.id);
      }
      paramVarArgs.bS(2, this.type);
      if (this.EDa != null)
      {
        paramVarArgs.qD(3, this.EDa.computeSize());
        this.EDa.writeFields(paramVarArgs);
      }
      if (this.abml != null) {
        paramVarArgs.d(4, this.abml);
      }
      AppMethodBeat.o(259090);
      return 0;
    }
    if (paramInt == 1) {
      if (this.id == null) {
        break label448;
      }
    }
    label448:
    for (paramInt = i.a.a.b.b.a.h(1, this.id) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.type);
      paramInt = i;
      if (this.EDa != null) {
        paramInt = i + i.a.a.a.qC(3, this.EDa.computeSize());
      }
      i = paramInt;
      if (this.abml != null) {
        i = paramInt + i.a.a.b.b.a.c(4, this.abml);
      }
      AppMethodBeat.o(259090);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259090);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        egx localegx = (egx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259090);
          return -1;
        case 1: 
          localegx.id = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259090);
          return 0;
        case 2: 
          localegx.type = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259090);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            FinderObject localFinderObject = new FinderObject();
            if ((localObject != null) && (localObject.length > 0)) {
              localFinderObject.parseFrom((byte[])localObject);
            }
            localegx.EDa = localFinderObject;
            paramInt += 1;
          }
          AppMethodBeat.o(259090);
          return 0;
        }
        localegx.abml = ((i.a.a.a.a)localObject).ajGk.kFX();
        AppMethodBeat.o(259090);
        return 0;
      }
      AppMethodBeat.o(259090);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.egx
 * JD-Core Version:    0.7.0.1
 */