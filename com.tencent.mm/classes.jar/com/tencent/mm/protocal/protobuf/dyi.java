package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public class dyi
  extends com.tencent.mm.bw.a
{
  public LinkedList<dyg> Geq;
  public boolean Ger;
  public boolean Ges;
  public boolean Get;
  public String dlk;
  public long iaH;
  public String nHE;
  public String nJQ;
  public String url;
  
  public dyi()
  {
    AppMethodBeat.i(198795);
    this.Geq = new LinkedList();
    AppMethodBeat.o(198795);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(198796);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.url == null)
      {
        paramVarArgs = new b("Not all required fields were included: url");
        AppMethodBeat.o(198796);
        throw paramVarArgs;
      }
      if (this.url != null) {
        paramVarArgs.d(1, this.url);
      }
      paramVarArgs.aO(2, this.iaH);
      paramVarArgs.bl(3, this.Ger);
      paramVarArgs.bl(4, this.Ges);
      if (this.nHE != null) {
        paramVarArgs.d(5, this.nHE);
      }
      if (this.nJQ != null) {
        paramVarArgs.d(6, this.nJQ);
      }
      if (this.dlk != null) {
        paramVarArgs.d(7, this.dlk);
      }
      paramVarArgs.bl(8, this.Get);
      paramVarArgs.e(9, 8, this.Geq);
      AppMethodBeat.o(198796);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label762;
      }
    }
    label762:
    for (paramInt = f.a.a.b.b.a.e(1, this.url) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.iaH) + (f.a.a.b.b.a.fK(3) + 1) + (f.a.a.b.b.a.fK(4) + 1);
      paramInt = i;
      if (this.nHE != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.nHE);
      }
      i = paramInt;
      if (this.nJQ != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.nJQ);
      }
      paramInt = i;
      if (this.dlk != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.dlk);
      }
      i = f.a.a.b.b.a.fK(8);
      int j = f.a.a.a.c(9, 8, this.Geq);
      AppMethodBeat.o(198796);
      return paramInt + (i + 1) + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Geq.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.url == null)
        {
          paramVarArgs = new b("Not all required fields were included: url");
          AppMethodBeat.o(198796);
          throw paramVarArgs;
        }
        AppMethodBeat.o(198796);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dyi localdyi = (dyi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(198796);
          return -1;
        case 1: 
          localdyi.url = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(198796);
          return 0;
        case 2: 
          localdyi.iaH = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(198796);
          return 0;
        case 3: 
          localdyi.Ger = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(198796);
          return 0;
        case 4: 
          localdyi.Ges = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(198796);
          return 0;
        case 5: 
          localdyi.nHE = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(198796);
          return 0;
        case 6: 
          localdyi.nJQ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(198796);
          return 0;
        case 7: 
          localdyi.dlk = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(198796);
          return 0;
        case 8: 
          localdyi.Get = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(198796);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dyg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dyg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdyi.Geq.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(198796);
        return 0;
      }
      AppMethodBeat.o(198796);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyi
 * JD-Core Version:    0.7.0.1
 */