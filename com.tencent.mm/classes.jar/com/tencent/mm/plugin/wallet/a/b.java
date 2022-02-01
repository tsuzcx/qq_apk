package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class b
  extends com.tencent.mm.cd.a
{
  public m OvU;
  public int OvV;
  public String OvW;
  public String OvX;
  public String OvY;
  public String OvZ;
  public String Owa;
  public String Owb;
  public String Owc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91285);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.OvU != null)
      {
        paramVarArgs.oE(1, this.OvU.computeSize());
        this.OvU.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.OvV);
      if (this.OvW != null) {
        paramVarArgs.f(3, this.OvW);
      }
      if (this.OvX != null) {
        paramVarArgs.f(4, this.OvX);
      }
      if (this.OvY != null) {
        paramVarArgs.f(5, this.OvY);
      }
      if (this.OvZ != null) {
        paramVarArgs.f(6, this.OvZ);
      }
      if (this.Owa != null) {
        paramVarArgs.f(7, this.Owa);
      }
      if (this.Owb != null) {
        paramVarArgs.f(8, this.Owb);
      }
      if (this.Owc != null) {
        paramVarArgs.f(9, this.Owc);
      }
      AppMethodBeat.o(91285);
      return 0;
    }
    if (paramInt == 1) {
      if (this.OvU == null) {
        break label760;
      }
    }
    label760:
    for (paramInt = g.a.a.a.oD(1, this.OvU.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.OvV);
      paramInt = i;
      if (this.OvW != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.OvW);
      }
      i = paramInt;
      if (this.OvX != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.OvX);
      }
      paramInt = i;
      if (this.OvY != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.OvY);
      }
      i = paramInt;
      if (this.OvZ != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.OvZ);
      }
      paramInt = i;
      if (this.Owa != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.Owa);
      }
      i = paramInt;
      if (this.Owb != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.Owb);
      }
      paramInt = i;
      if (this.Owc != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.Owc);
      }
      AppMethodBeat.o(91285);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91285);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        b localb = (b)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91285);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            m localm = new m();
            if ((localObject != null) && (localObject.length > 0)) {
              localm.parseFrom((byte[])localObject);
            }
            localb.OvU = localm;
            paramInt += 1;
          }
          AppMethodBeat.o(91285);
          return 0;
        case 2: 
          localb.OvV = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91285);
          return 0;
        case 3: 
          localb.OvW = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91285);
          return 0;
        case 4: 
          localb.OvX = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91285);
          return 0;
        case 5: 
          localb.OvY = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91285);
          return 0;
        case 6: 
          localb.OvZ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91285);
          return 0;
        case 7: 
          localb.Owa = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91285);
          return 0;
        case 8: 
          localb.Owb = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91285);
          return 0;
        }
        localb.Owc = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(91285);
        return 0;
      }
      AppMethodBeat.o(91285);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.b
 * JD-Core Version:    0.7.0.1
 */