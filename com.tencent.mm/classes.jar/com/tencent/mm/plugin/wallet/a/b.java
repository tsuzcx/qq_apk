package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class b
  extends com.tencent.mm.bx.a
{
  public m CGH;
  public int CGI;
  public String CGJ;
  public String CGK;
  public String CGL;
  public String CGM;
  public String CGN;
  public String CGO;
  public String CGP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91285);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CGH != null)
      {
        paramVarArgs.lC(1, this.CGH.computeSize());
        this.CGH.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.CGI);
      if (this.CGJ != null) {
        paramVarArgs.d(3, this.CGJ);
      }
      if (this.CGK != null) {
        paramVarArgs.d(4, this.CGK);
      }
      if (this.CGL != null) {
        paramVarArgs.d(5, this.CGL);
      }
      if (this.CGM != null) {
        paramVarArgs.d(6, this.CGM);
      }
      if (this.CGN != null) {
        paramVarArgs.d(7, this.CGN);
      }
      if (this.CGO != null) {
        paramVarArgs.d(8, this.CGO);
      }
      if (this.CGP != null) {
        paramVarArgs.d(9, this.CGP);
      }
      AppMethodBeat.o(91285);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CGH == null) {
        break label782;
      }
    }
    label782:
    for (paramInt = f.a.a.a.lB(1, this.CGH.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.CGI);
      paramInt = i;
      if (this.CGJ != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.CGJ);
      }
      i = paramInt;
      if (this.CGK != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.CGK);
      }
      paramInt = i;
      if (this.CGL != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.CGL);
      }
      i = paramInt;
      if (this.CGM != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.CGM);
      }
      paramInt = i;
      if (this.CGN != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.CGN);
      }
      i = paramInt;
      if (this.CGO != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.CGO);
      }
      paramInt = i;
      if (this.CGP != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.CGP);
      }
      AppMethodBeat.o(91285);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91285);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        b localb = (b)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91285);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new m();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((m)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localb.CGH = ((m)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91285);
          return 0;
        case 2: 
          localb.CGI = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91285);
          return 0;
        case 3: 
          localb.CGJ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91285);
          return 0;
        case 4: 
          localb.CGK = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91285);
          return 0;
        case 5: 
          localb.CGL = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91285);
          return 0;
        case 6: 
          localb.CGM = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91285);
          return 0;
        case 7: 
          localb.CGN = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91285);
          return 0;
        case 8: 
          localb.CGO = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91285);
          return 0;
        }
        localb.CGP = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91285);
        return 0;
      }
      AppMethodBeat.o(91285);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.b
 * JD-Core Version:    0.7.0.1
 */