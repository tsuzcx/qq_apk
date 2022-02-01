package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class du
  extends com.tencent.mm.bx.a
{
  public String YFV;
  public String YFW;
  public dxm YFX;
  public String url;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258849);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.url != null) {
        paramVarArgs.g(1, this.url);
      }
      if (this.YFV != null) {
        paramVarArgs.g(2, this.YFV);
      }
      if (this.YFW != null) {
        paramVarArgs.g(3, this.YFW);
      }
      if (this.YFX != null)
      {
        paramVarArgs.qD(4, this.YFX.computeSize());
        this.YFX.writeFields(paramVarArgs);
      }
      if (this.username != null) {
        paramVarArgs.g(100, this.username);
      }
      AppMethodBeat.o(258849);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label544;
      }
    }
    label544:
    for (int i = i.a.a.b.b.a.h(1, this.url) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YFV != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.YFV);
      }
      i = paramInt;
      if (this.YFW != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YFW);
      }
      paramInt = i;
      if (this.YFX != null) {
        paramInt = i + i.a.a.a.qC(4, this.YFX.computeSize());
      }
      i = paramInt;
      if (this.username != null) {
        i = paramInt + i.a.a.b.b.a.h(100, this.username);
      }
      AppMethodBeat.o(258849);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258849);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        du localdu = (du)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258849);
          return -1;
        case 1: 
          localdu.url = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258849);
          return 0;
        case 2: 
          localdu.YFV = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258849);
          return 0;
        case 3: 
          localdu.YFW = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258849);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            dxm localdxm = new dxm();
            if ((localObject != null) && (localObject.length > 0)) {
              localdxm.parseFrom((byte[])localObject);
            }
            localdu.YFX = localdxm;
            paramInt += 1;
          }
          AppMethodBeat.o(258849);
          return 0;
        }
        localdu.username = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(258849);
        return 0;
      }
      AppMethodBeat.o(258849);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.du
 * JD-Core Version:    0.7.0.1
 */