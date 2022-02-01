package com.tencent.mm.plugin.textstatus.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class w
  extends com.tencent.mm.bw.a
{
  public String GaI;
  public String Gal;
  public String Gam;
  public String Gan;
  public String Gao;
  public String Gap;
  public LinkedList<String> Gbc;
  public b Gbd;
  public LinkedList<r> Gbe;
  public String Gbf;
  
  public w()
  {
    AppMethodBeat.i(222844);
    this.Gbc = new LinkedList();
    this.Gbe = new LinkedList();
    AppMethodBeat.o(222844);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(222845);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.GaI != null) {
        paramVarArgs.e(1, this.GaI);
      }
      if (this.Gao != null) {
        paramVarArgs.e(2, this.Gao);
      }
      if (this.Gap != null) {
        paramVarArgs.e(3, this.Gap);
      }
      if (this.Gal != null) {
        paramVarArgs.e(4, this.Gal);
      }
      if (this.Gam != null) {
        paramVarArgs.e(5, this.Gam);
      }
      if (this.Gan != null) {
        paramVarArgs.e(10, this.Gan);
      }
      paramVarArgs.e(13, 1, this.Gbc);
      if (this.Gbd != null)
      {
        paramVarArgs.ni(14, this.Gbd.computeSize());
        this.Gbd.writeFields(paramVarArgs);
      }
      paramVarArgs.e(15, 8, this.Gbe);
      if (this.Gbf != null) {
        paramVarArgs.e(16, this.Gbf);
      }
      AppMethodBeat.o(222845);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GaI == null) {
        break label962;
      }
    }
    label962:
    for (int i = g.a.a.b.b.a.f(1, this.GaI) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Gao != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Gao);
      }
      i = paramInt;
      if (this.Gap != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Gap);
      }
      paramInt = i;
      if (this.Gal != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Gal);
      }
      i = paramInt;
      if (this.Gam != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.Gam);
      }
      paramInt = i;
      if (this.Gan != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.Gan);
      }
      i = paramInt + g.a.a.a.c(13, 1, this.Gbc);
      paramInt = i;
      if (this.Gbd != null) {
        paramInt = i + g.a.a.a.nh(14, this.Gbd.computeSize());
      }
      i = paramInt + g.a.a.a.c(15, 8, this.Gbe);
      paramInt = i;
      if (this.Gbf != null) {
        paramInt = i + g.a.a.b.b.a.f(16, this.Gbf);
      }
      AppMethodBeat.o(222845);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Gbc.clear();
        this.Gbe.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(222845);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        w localw = (w)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 6: 
        case 7: 
        case 8: 
        case 9: 
        case 11: 
        case 12: 
        default: 
          AppMethodBeat.o(222845);
          return -1;
        case 1: 
          localw.GaI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(222845);
          return 0;
        case 2: 
          localw.Gao = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(222845);
          return 0;
        case 3: 
          localw.Gap = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(222845);
          return 0;
        case 4: 
          localw.Gal = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(222845);
          return 0;
        case 5: 
          localw.Gam = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(222845);
          return 0;
        case 10: 
          localw.Gan = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(222845);
          return 0;
        case 13: 
          localw.Gbc.add(((g.a.a.a.a)localObject1).UbS.readString());
          AppMethodBeat.o(222845);
          return 0;
        case 14: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new b();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((b)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localw.Gbd = ((b)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(222845);
          return 0;
        case 15: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new r();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((r)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localw.Gbe.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(222845);
          return 0;
        }
        localw.Gbf = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(222845);
        return 0;
      }
      AppMethodBeat.o(222845);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.g.w
 * JD-Core Version:    0.7.0.1
 */