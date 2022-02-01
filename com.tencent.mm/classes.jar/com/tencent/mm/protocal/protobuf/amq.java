package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class amq
  extends com.tencent.mm.bw.a
{
  public String LxL;
  public LinkedList<String> LxM;
  public String appId;
  public String dCl;
  public String dRL;
  public anb dXI;
  public String desc;
  public String title;
  public int type;
  
  public amq()
  {
    AppMethodBeat.i(127463);
    this.LxM = new LinkedList();
    AppMethodBeat.o(127463);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127464);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.e(2, this.desc);
      }
      if (this.dRL != null) {
        paramVarArgs.e(3, this.dRL);
      }
      if (this.LxL != null) {
        paramVarArgs.e(4, this.LxL);
      }
      if (this.appId != null) {
        paramVarArgs.e(5, this.appId);
      }
      if (this.dCl != null) {
        paramVarArgs.e(6, this.dCl);
      }
      paramVarArgs.e(7, 1, this.LxM);
      paramVarArgs.aM(8, this.type);
      if (this.dXI != null)
      {
        paramVarArgs.ni(9, this.dXI.computeSize());
        this.dXI.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(127464);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label778;
      }
    }
    label778:
    for (int i = g.a.a.b.b.a.f(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.desc);
      }
      i = paramInt;
      if (this.dRL != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.dRL);
      }
      paramInt = i;
      if (this.LxL != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.LxL);
      }
      i = paramInt;
      if (this.appId != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.appId);
      }
      paramInt = i;
      if (this.dCl != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.dCl);
      }
      i = paramInt + g.a.a.a.c(7, 1, this.LxM) + g.a.a.b.b.a.bu(8, this.type);
      paramInt = i;
      if (this.dXI != null) {
        paramInt = i + g.a.a.a.nh(9, this.dXI.computeSize());
      }
      AppMethodBeat.o(127464);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LxM.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(127464);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        amq localamq = (amq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127464);
          return -1;
        case 1: 
          localamq.title = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(127464);
          return 0;
        case 2: 
          localamq.desc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(127464);
          return 0;
        case 3: 
          localamq.dRL = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(127464);
          return 0;
        case 4: 
          localamq.LxL = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(127464);
          return 0;
        case 5: 
          localamq.appId = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(127464);
          return 0;
        case 6: 
          localamq.dCl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(127464);
          return 0;
        case 7: 
          localamq.LxM.add(((g.a.a.a.a)localObject1).UbS.readString());
          AppMethodBeat.o(127464);
          return 0;
        case 8: 
          localamq.type = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(127464);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new anb();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((anb)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localamq.dXI = ((anb)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(127464);
        return 0;
      }
      AppMethodBeat.o(127464);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amq
 * JD-Core Version:    0.7.0.1
 */