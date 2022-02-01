package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dcp
  extends com.tencent.mm.bw.a
{
  public String EIF;
  public String EIG;
  public boolean EIH = false;
  public dhz EZc;
  public dhz EZd;
  public String EZe;
  public String EZf;
  public int flags;
  public long timestamp = 0L;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122550);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EZc != null)
      {
        paramVarArgs.ln(1, this.EZc.computeSize());
        this.EZc.writeFields(paramVarArgs);
      }
      if (this.EZd != null)
      {
        paramVarArgs.ln(2, this.EZd.computeSize());
        this.EZd.writeFields(paramVarArgs);
      }
      paramVarArgs.bl(3, this.EIH);
      if (this.EIF != null) {
        paramVarArgs.d(4, this.EIF);
      }
      paramVarArgs.aR(5, this.flags);
      if (this.EIG != null) {
        paramVarArgs.d(6, this.EIG);
      }
      if (this.EZe != null) {
        paramVarArgs.d(7, this.EZe);
      }
      if (this.EZf != null) {
        paramVarArgs.d(8, this.EZf);
      }
      paramVarArgs.aO(9, this.timestamp);
      AppMethodBeat.o(122550);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EZc == null) {
        break label842;
      }
    }
    label842:
    for (paramInt = f.a.a.a.lm(1, this.EZc.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.EZd != null) {
        i = paramInt + f.a.a.a.lm(2, this.EZd.computeSize());
      }
      i += f.a.a.b.b.a.fK(3) + 1;
      paramInt = i;
      if (this.EIF != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EIF);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.flags);
      paramInt = i;
      if (this.EIG != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.EIG);
      }
      i = paramInt;
      if (this.EZe != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.EZe);
      }
      paramInt = i;
      if (this.EZf != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.EZf);
      }
      i = f.a.a.b.b.a.p(9, this.timestamp);
      AppMethodBeat.o(122550);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(122550);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dcp localdcp = (dcp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122550);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dhz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dhz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdcp.EZc = ((dhz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122550);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dhz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dhz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdcp.EZd = ((dhz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122550);
          return 0;
        case 3: 
          localdcp.EIH = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(122550);
          return 0;
        case 4: 
          localdcp.EIF = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(122550);
          return 0;
        case 5: 
          localdcp.flags = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(122550);
          return 0;
        case 6: 
          localdcp.EIG = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(122550);
          return 0;
        case 7: 
          localdcp.EZe = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(122550);
          return 0;
        case 8: 
          localdcp.EZf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(122550);
          return 0;
        }
        localdcp.timestamp = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(122550);
        return 0;
      }
      AppMethodBeat.o(122550);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dcp
 * JD-Core Version:    0.7.0.1
 */