package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cnl
  extends com.tencent.mm.bw.a
{
  public String MtR;
  public coc MtS;
  public cnp MtT;
  public coc MtU;
  public String description;
  public LinkedList<cod> media;
  public int mediaType;
  
  public cnl()
  {
    AppMethodBeat.i(209738);
    this.media = new LinkedList();
    AppMethodBeat.o(209738);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209739);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.description != null) {
        paramVarArgs.e(1, this.description);
      }
      paramVarArgs.e(2, 8, this.media);
      paramVarArgs.aM(3, this.mediaType);
      if (this.MtR != null) {
        paramVarArgs.e(4, this.MtR);
      }
      if (this.MtS != null)
      {
        paramVarArgs.ni(5, this.MtS.computeSize());
        this.MtS.writeFields(paramVarArgs);
      }
      if (this.MtT != null)
      {
        paramVarArgs.ni(6, this.MtT.computeSize());
        this.MtT.writeFields(paramVarArgs);
      }
      if (this.MtU != null)
      {
        paramVarArgs.ni(7, this.MtU.computeSize());
        this.MtU.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(209739);
      return 0;
    }
    if (paramInt == 1) {
      if (this.description == null) {
        break label926;
      }
    }
    label926:
    for (paramInt = g.a.a.b.b.a.f(1, this.description) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.media) + g.a.a.b.b.a.bu(3, this.mediaType);
      paramInt = i;
      if (this.MtR != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.MtR);
      }
      i = paramInt;
      if (this.MtS != null) {
        i = paramInt + g.a.a.a.nh(5, this.MtS.computeSize());
      }
      paramInt = i;
      if (this.MtT != null) {
        paramInt = i + g.a.a.a.nh(6, this.MtT.computeSize());
      }
      i = paramInt;
      if (this.MtU != null) {
        i = paramInt + g.a.a.a.nh(7, this.MtU.computeSize());
      }
      AppMethodBeat.o(209739);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.media.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209739);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cnl localcnl = (cnl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209739);
          return -1;
        case 1: 
          localcnl.description = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209739);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cod();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cod)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcnl.media.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209739);
          return 0;
        case 3: 
          localcnl.mediaType = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209739);
          return 0;
        case 4: 
          localcnl.MtR = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209739);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new coc();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((coc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcnl.MtS = ((coc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209739);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cnp();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cnp)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcnl.MtT = ((cnp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209739);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new coc();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((coc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcnl.MtU = ((coc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209739);
        return 0;
      }
      AppMethodBeat.o(209739);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnl
 * JD-Core Version:    0.7.0.1
 */