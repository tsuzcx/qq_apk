package com.tencent.mm.plugin.wallet.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class b
  extends com.tencent.mm.bx.a
{
  public k Vlf;
  public int Vlg;
  public String Vlh;
  public String Vli;
  public String Vlj;
  public String Vlk;
  public String Vll;
  public String Vlm;
  public String Vln;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91285);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Vlf != null)
      {
        paramVarArgs.qD(1, this.Vlf.computeSize());
        this.Vlf.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.Vlg);
      if (this.Vlh != null) {
        paramVarArgs.g(3, this.Vlh);
      }
      if (this.Vli != null) {
        paramVarArgs.g(4, this.Vli);
      }
      if (this.Vlj != null) {
        paramVarArgs.g(5, this.Vlj);
      }
      if (this.Vlk != null) {
        paramVarArgs.g(6, this.Vlk);
      }
      if (this.Vll != null) {
        paramVarArgs.g(7, this.Vll);
      }
      if (this.Vlm != null) {
        paramVarArgs.g(8, this.Vlm);
      }
      if (this.Vln != null) {
        paramVarArgs.g(9, this.Vln);
      }
      AppMethodBeat.o(91285);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Vlf == null) {
        break label756;
      }
    }
    label756:
    for (paramInt = i.a.a.a.qC(1, this.Vlf.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.Vlg);
      paramInt = i;
      if (this.Vlh != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.Vlh);
      }
      i = paramInt;
      if (this.Vli != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.Vli);
      }
      paramInt = i;
      if (this.Vlj != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.Vlj);
      }
      i = paramInt;
      if (this.Vlk != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.Vlk);
      }
      paramInt = i;
      if (this.Vll != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.Vll);
      }
      i = paramInt;
      if (this.Vlm != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.Vlm);
      }
      paramInt = i;
      if (this.Vln != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.Vln);
      }
      AppMethodBeat.o(91285);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91285);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        b localb = (b)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91285);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            k localk = new k();
            if ((localObject != null) && (localObject.length > 0)) {
              localk.parseFrom((byte[])localObject);
            }
            localb.Vlf = localk;
            paramInt += 1;
          }
          AppMethodBeat.o(91285);
          return 0;
        case 2: 
          localb.Vlg = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91285);
          return 0;
        case 3: 
          localb.Vlh = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91285);
          return 0;
        case 4: 
          localb.Vli = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91285);
          return 0;
        case 5: 
          localb.Vlj = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91285);
          return 0;
        case 6: 
          localb.Vlk = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91285);
          return 0;
        case 7: 
          localb.Vll = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91285);
          return 0;
        case 8: 
          localb.Vlm = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91285);
          return 0;
        }
        localb.Vln = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91285);
        return 0;
      }
      AppMethodBeat.o(91285);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.model.b
 * JD-Core Version:    0.7.0.1
 */