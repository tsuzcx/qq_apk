package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class aut
  extends com.tencent.mm.bw.a
{
  public long LFA;
  public b LFB;
  public ava LFC;
  public LinkedList<avn> LFD;
  public avn LFE;
  public String LFF;
  public String LFr;
  public avn LFz;
  public long seq;
  public String session_id;
  public int ybm;
  
  public aut()
  {
    AppMethodBeat.i(209485);
    this.LFD = new LinkedList();
    AppMethodBeat.o(209485);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209486);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LFz != null)
      {
        paramVarArgs.ni(1, this.LFz.computeSize());
        this.LFz.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.ybm);
      if (this.LFr != null) {
        paramVarArgs.e(3, this.LFr);
      }
      paramVarArgs.bb(4, this.LFA);
      if (this.LFB != null) {
        paramVarArgs.c(5, this.LFB);
      }
      if (this.LFC != null)
      {
        paramVarArgs.ni(6, this.LFC.computeSize());
        this.LFC.writeFields(paramVarArgs);
      }
      paramVarArgs.e(7, 8, this.LFD);
      if (this.session_id != null) {
        paramVarArgs.e(51, this.session_id);
      }
      paramVarArgs.bb(101, this.seq);
      if (this.LFE != null)
      {
        paramVarArgs.ni(102, this.LFE.computeSize());
        this.LFE.writeFields(paramVarArgs);
      }
      if (this.LFF != null) {
        paramVarArgs.e(103, this.LFF);
      }
      AppMethodBeat.o(209486);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LFz == null) {
        break label1182;
      }
    }
    label1182:
    for (paramInt = g.a.a.a.nh(1, this.LFz.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.ybm);
      paramInt = i;
      if (this.LFr != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.LFr);
      }
      i = paramInt + g.a.a.b.b.a.r(4, this.LFA);
      paramInt = i;
      if (this.LFB != null) {
        paramInt = i + g.a.a.b.b.a.b(5, this.LFB);
      }
      i = paramInt;
      if (this.LFC != null) {
        i = paramInt + g.a.a.a.nh(6, this.LFC.computeSize());
      }
      i += g.a.a.a.c(7, 8, this.LFD);
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + g.a.a.b.b.a.f(51, this.session_id);
      }
      i = paramInt + g.a.a.b.b.a.r(101, this.seq);
      paramInt = i;
      if (this.LFE != null) {
        paramInt = i + g.a.a.a.nh(102, this.LFE.computeSize());
      }
      i = paramInt;
      if (this.LFF != null) {
        i = paramInt + g.a.a.b.b.a.f(103, this.LFF);
      }
      AppMethodBeat.o(209486);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LFD.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209486);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aut localaut = (aut)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209486);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new avn();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((avn)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaut.LFz = ((avn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209486);
          return 0;
        case 2: 
          localaut.ybm = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209486);
          return 0;
        case 3: 
          localaut.LFr = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209486);
          return 0;
        case 4: 
          localaut.LFA = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(209486);
          return 0;
        case 5: 
          localaut.LFB = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(209486);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ava();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ava)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaut.LFC = ((ava)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209486);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new avn();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((avn)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaut.LFD.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209486);
          return 0;
        case 51: 
          localaut.session_id = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209486);
          return 0;
        case 101: 
          localaut.seq = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(209486);
          return 0;
        case 102: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new avn();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((avn)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaut.LFE = ((avn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209486);
          return 0;
        }
        localaut.LFF = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(209486);
        return 0;
      }
      AppMethodBeat.o(209486);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aut
 * JD-Core Version:    0.7.0.1
 */