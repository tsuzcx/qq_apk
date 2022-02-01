package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dep
  extends com.tencent.mm.bw.a
{
  public int CreateTime;
  public cna FOb;
  public ddp FOc;
  public String FOd;
  public int FOe;
  public int FOf;
  public String Id;
  public String ncR;
  public long timeStamp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118475);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Id != null) {
        paramVarArgs.d(1, this.Id);
      }
      if (this.ncR != null) {
        paramVarArgs.d(2, this.ncR);
      }
      paramVarArgs.aR(3, this.CreateTime);
      if (this.FOb != null)
      {
        paramVarArgs.ln(4, this.FOb.computeSize());
        this.FOb.writeFields(paramVarArgs);
      }
      if (this.FOc != null)
      {
        paramVarArgs.ln(5, this.FOc.computeSize());
        this.FOc.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(6, this.timeStamp);
      if (this.FOd != null) {
        paramVarArgs.d(7, this.FOd);
      }
      paramVarArgs.aR(8, this.FOe);
      paramVarArgs.aR(9, this.FOf);
      AppMethodBeat.o(118475);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Id == null) {
        break label830;
      }
    }
    label830:
    for (paramInt = f.a.a.b.b.a.e(1, this.Id) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ncR != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.ncR);
      }
      i += f.a.a.b.b.a.bx(3, this.CreateTime);
      paramInt = i;
      if (this.FOb != null) {
        paramInt = i + f.a.a.a.lm(4, this.FOb.computeSize());
      }
      i = paramInt;
      if (this.FOc != null) {
        i = paramInt + f.a.a.a.lm(5, this.FOc.computeSize());
      }
      i += f.a.a.b.b.a.p(6, this.timeStamp);
      paramInt = i;
      if (this.FOd != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FOd);
      }
      i = f.a.a.b.b.a.bx(8, this.FOe);
      int j = f.a.a.b.b.a.bx(9, this.FOf);
      AppMethodBeat.o(118475);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(118475);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dep localdep = (dep)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118475);
          return -1;
        case 1: 
          localdep.Id = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(118475);
          return 0;
        case 2: 
          localdep.ncR = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(118475);
          return 0;
        case 3: 
          localdep.CreateTime = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(118475);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cna();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cna)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdep.FOb = ((cna)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118475);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ddp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ddp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdep.FOc = ((ddp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118475);
          return 0;
        case 6: 
          localdep.timeStamp = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(118475);
          return 0;
        case 7: 
          localdep.FOd = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(118475);
          return 0;
        case 8: 
          localdep.FOe = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(118475);
          return 0;
        }
        localdep.FOf = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(118475);
        return 0;
      }
      AppMethodBeat.o(118475);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dep
 * JD-Core Version:    0.7.0.1
 */