package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class blx
  extends com.tencent.mm.bw.a
{
  public String DWw;
  public dhb Fbg;
  public LinkedList<dgh> Fbh;
  public dhb Fbi;
  
  public blx()
  {
    AppMethodBeat.i(91526);
    this.Fbh = new LinkedList();
    AppMethodBeat.o(91526);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91527);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Fbg != null)
      {
        paramVarArgs.ln(1, this.Fbg.computeSize());
        this.Fbg.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.Fbh);
      if (this.Fbi != null)
      {
        paramVarArgs.ln(3, this.Fbi.computeSize());
        this.Fbi.writeFields(paramVarArgs);
      }
      if (this.DWw != null) {
        paramVarArgs.d(4, this.DWw);
      }
      AppMethodBeat.o(91527);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Fbg == null) {
        break label666;
      }
    }
    label666:
    for (paramInt = f.a.a.a.lm(1, this.Fbg.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.Fbh);
      paramInt = i;
      if (this.Fbi != null) {
        paramInt = i + f.a.a.a.lm(3, this.Fbi.computeSize());
      }
      i = paramInt;
      if (this.DWw != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.DWw);
      }
      AppMethodBeat.o(91527);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Fbh.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91527);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        blx localblx = (blx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91527);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dhb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dhb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localblx.Fbg = ((dhb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91527);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dgh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dgh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localblx.Fbh.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91527);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dhb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dhb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localblx.Fbi = ((dhb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91527);
          return 0;
        }
        localblx.DWw = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91527);
        return 0;
      }
      AppMethodBeat.o(91527);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.blx
 * JD-Core Version:    0.7.0.1
 */